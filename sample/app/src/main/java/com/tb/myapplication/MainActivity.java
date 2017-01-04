package com.tb.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.sqk.emojirelease.Emoji;
import com.sqk.emojirelease.EmojiUtil;
import com.sqk.emojirelease.FaceFragment;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements FaceFragment.OnEmojiClickListener, View.OnClickListener {
    TextView textView;
    EditText editText;

    FaceFragment faceFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
        editText = (EditText) findViewById(R.id.edit_text);
        findViewById(R.id.open).setOnClickListener(this);
        findViewById(R.id.close).setOnClickListener(this);
        faceFragment = FaceFragment.Instance();
        faceFragment.setAttachListener(new FaceFragment.OnAttachListener() {
            @Override
            public void onOpen() {
                Toast.makeText(MainActivity.this,"attach",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClose() {
                Toast.makeText(MainActivity.this,"detach",Toast.LENGTH_SHORT).show();
            }
        });
        getSupportFragmentManager().beginTransaction().add(R.id.Container, faceFragment).commit();
    }


    @Override
    public void onEmojiDelete() {
        String text = editText.getText().toString();
        if (text.isEmpty()) {
            return;
        }
        if ("]".equals(text.substring(text.length() - 1, text.length()))) {
            int index = text.lastIndexOf("[");
            if (index == -1) {
                int action = KeyEvent.ACTION_DOWN;
                int code = KeyEvent.KEYCODE_DEL;
                KeyEvent event = new KeyEvent(action, code);
                editText.onKeyDown(KeyEvent.KEYCODE_DEL, event);
                displayTextView();
                return;
            }
            editText.getText().delete(index, text.length());
            displayTextView();
            return;
        }
        int action = KeyEvent.ACTION_DOWN;
        int code = KeyEvent.KEYCODE_DEL;
        KeyEvent event = new KeyEvent(action, code);
        editText.onKeyDown(KeyEvent.KEYCODE_DEL, event);
        displayTextView();
    }

    private void displayTextView() {
        try {
            EmojiUtil.handlerEmojiText(textView, editText.getText().toString(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onEmojiClick(Emoji emoji) {
        if (emoji != null) {
            int index = editText.getSelectionStart();
            Editable editable = editText.getEditableText();
            if (index < 0) {
                editable.append(emoji.getContent());
            } else {
                editable.insert(index, emoji.getContent());
            }
        }
        displayTextView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.open:
                getSupportFragmentManager().beginTransaction().attach(faceFragment).commit();
                break;
            case R.id.close:
                getSupportFragmentManager().beginTransaction().detach(faceFragment).commit();
                break;
            default:
                break;
        }
    }
}
