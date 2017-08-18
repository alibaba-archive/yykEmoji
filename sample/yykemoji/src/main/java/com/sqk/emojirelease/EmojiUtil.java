package com.sqk.emojirelease;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmojiUtil {
    private static ArrayList<Emoji> emojiList;

    public static ArrayList<Emoji> getEmojiList(Context context) {
        if (emojiList == null) {
            synchronized (EmojiUtil.class) {
                if (emojiList == null) {
                    emojiList = generateEmojis(context);
                }
            }
        }
        return emojiList;
    }

    private static ArrayList<Emoji> generateEmojis(Context context) {
        ArrayList<Emoji> list = new ArrayList<>();
        for (int i = 0; i < EmojiResArray.length; i++) {
            Emoji emoji = new Emoji();
            emoji.setImageUri(EmojiResArray[i]);
            emoji.setContent(context.getString(EmojiContentResArray[i]));
            list.add(emoji);
        }
        return list;
    }


    public static final int[] EmojiResArray = {
        R.drawable.d_erha,
        R.drawable.d_tanshou,
        R.drawable.d_aini,
        R.drawable.d_aoteman,
        R.drawable.d_baibai,
        R.drawable.d_beishang,
        R.drawable.d_bishi,
        R.drawable.d_bizui,
        R.drawable.d_chanzui,
        R.drawable.d_chijing,
        R.drawable.d_dahaqi,
        R.drawable.d_dalian,
        R.drawable.d_ding,
        R.drawable.d_doge,
        R.drawable.d_feizao,
        R.drawable.d_ganmao,
        R.drawable.d_guzhang,
        R.drawable.d_haha,
        R.drawable.d_haixiu,
        R.drawable.d_han,
        R.drawable.d_hehe,
        R.drawable.d_heixian,
        R.drawable.d_heng,
        R.drawable.d_huaxin,
        R.drawable.d_jiyan,
        R.drawable.d_keai,
        R.drawable.d_kelian,
        R.drawable.d_ku,
        R.drawable.d_kun,
        R.drawable.d_landelini,
        R.drawable.d_lei,
        R.drawable.d_miao,
        R.drawable.d_nanhaier,
        R.drawable.d_nu,
        R.drawable.d_numa,
        R.drawable.d_nvhaier,
        R.drawable.d_qian,
        R.drawable.d_qinqin,
        R.drawable.d_shayan,
        R.drawable.d_shengbing,
        R.drawable.d_shenshou,
        R.drawable.d_shiwang,
        R.drawable.d_shuai,
        R.drawable.d_shuijiao,
        R.drawable.d_sikao,
        R.drawable.d_taikaixin,
        R.drawable.d_touxiao,
        R.drawable.d_tu,
        R.drawable.d_tuzi,
        R.drawable.d_wabishi,
        R.drawable.d_weiqu,
        R.drawable.d_xiaoku,
        R.drawable.d_xiongmao,
        R.drawable.d_xixi,
        R.drawable.d_xu,
        R.drawable.d_yinxian,
        R.drawable.d_yiwen,
        R.drawable.d_youhengheng,
        R.drawable.d_yun,
        R.drawable.d_zhuakuang,
        R.drawable.d_zhutou,
        R.drawable.d_zuiyou,
        R.drawable.d_zuohengheng,
        R.drawable.f_geili,
        R.drawable.f_hufen,
        R.drawable.f_jiong,
        R.drawable.f_meng,
        R.drawable.f_shenma,
        R.drawable.f_v5,
        R.drawable.f_xi,
        R.drawable.f_zhi,
        R.drawable.h_buyao,
        R.drawable.h_good,
        R.drawable.h_haha,
        R.drawable.h_lai,
        R.drawable.h_ok,
        R.drawable.h_quantou,
        R.drawable.h_ruo,
        R.drawable.h_woshou,
        R.drawable.h_ye,
        R.drawable.h_zan,
        R.drawable.h_zuoyi,
        R.drawable.l_shangxin,
        R.drawable.l_xin,
        R.drawable.o_dangao,
        R.drawable.o_feiji,
        R.drawable.o_ganbei,
        R.drawable.o_huatong,
        R.drawable.o_lazhu,
        R.drawable.o_liwu,
        R.drawable.o_lvsidai,
        R.drawable.o_weibo,
        R.drawable.o_weiguan,
        R.drawable.o_yinyue,
        R.drawable.o_zhaoxiangji,
        R.drawable.o_zhong,
        R.drawable.w_fuyun,
        R.drawable.w_shachenbao,
        R.drawable.w_taiyang,
        R.drawable.w_weifeng,
        R.drawable.w_xianhua,
        R.drawable.w_xiayu,
        R.drawable.w_yueliang,
    };

    public static final int[] EmojiContentResArray = {
        R.string.emoji_erha,
        R.string.emoji_tanshou,
        R.string.emoji_aini,
        R.string.emoji_aoteman,
        R.string.emoji_baibai,
        R.string.emoji_beishang,
        R.string.emoji_bishi,
        R.string.emoji_bizui,
        R.string.emoji_chanzui,
        R.string.emoji_chijing,
        R.string.emoji_haqian,
        R.string.emoji_dalian,
        R.string.emoji_ding,
        R.string.emoji_doge,
        R.string.emoji_feizao,
        R.string.emoji_ganmao,
        R.string.emoji_guzhang,
        R.string.emoji_haha_zh,
        R.string.emoji_haixiu,
        R.string.emoji_han,
        R.string.emoji_weixiao,
        R.string.emoji_heixian,
        R.string.emoji_heng,
        R.string.emoji_se,
        R.string.emoji_jiyan,
        R.string.emoji_keai,
        R.string.emoji_kelian,
        R.string.emoji_ku,
        R.string.emoji_kun,
        R.string.emoji_baiyan,
        R.string.emoji_lei,
        R.string.emoji_miaomiao,
        R.string.emoji_boy,
        R.string.emoji_nu,
        R.string.emoji_numa,
        R.string.emoji_girl,
        R.string.emoji_qian,
        R.string.emoji_qinqin,
        R.string.emoji_shayan,
        R.string.emoji_sick,
        R.string.emoji_caonima,
        R.string.emoji_shiwang,
        R.string.emoji_shuai,
        R.string.emoji_shui,
        R.string.emoji_sikao,
        R.string.emoji_taikaixin,
        R.string.emoji_touxiao,
        R.string.emoji_tu,
        R.string.emoji_tuzi,
        R.string.emoji_wabi,
        R.string.emoji_weiqu,
        R.string.emoji_xiaocry,
        R.string.emoji_xiongmao,
        R.string.emoji_xixi,
        R.string.emoji_xu,
        R.string.emoji_yinxian,
        R.string.emoji_yiwen,
        R.string.emoji_youhengheng,
        R.string.emoji_yun,
        R.string.emoji_zhuakuang,
        R.string.emoji_zhutou,
        R.string.emoji_zuiyou,
        R.string.emoji_zuohengheng,
        R.string.emoji_geili,
        R.string.emoji_hufen,
        R.string.emoji_jiong,
        R.string.emoji_meng,
        R.string.emoji_shenma,
        R.string.emoji_weiwu,
        R.string.emoji_xi,
        R.string.emoji_zhi,
        R.string.emoji_no,
        R.string.emoji_good,
        R.string.emoji_haha,
        R.string.emoji_lai,
        R.string.emoji_ok,
        R.string.emoji_quantou,
        R.string.emoji_ruo,
        R.string.emoji_woshou,
        R.string.emoji_ye,
        R.string.emoji_zan,
        R.string.emoji_zuoyi,
        R.string.emoji_shangxin,
        R.string.emoji_xin,
        R.string.emoji_dangao,
        R.string.emoji_feiji,
        R.string.emoji_ganbei,
        R.string.emoji_huatong,
        R.string.emoji_lazhu,
        R.string.emoji_liwu,
        R.string.emoji_lvsidai,
        R.string.emoji_weibo,
        R.string.emoji_weiguan,
        R.string.emoji_yinyue,
        R.string.emoji_zhaoxiangji,
        R.string.emoji_zhong,
        R.string.emoji_fuyun,
        R.string.emoji_shachenbao,
        R.string.emoji_taiyang,
        R.string.emoji_weifeng,
        R.string.emoji_xianhua,
        R.string.emoji_xiayu,
        R.string.emoji_yueliang,
    };

    public static int calculateInSampleSize(BitmapFactory.Options options,
                                            int reqWidth, int reqHeight) {
        // 源图片的高度和宽度
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            // 计算出实际宽高和目标宽高的比率
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            // 选择宽和高中最小的比率作为inSampleSize的值，这样可以保证最终图片的宽和高
            // 一定都会大于等于目标的宽和高。
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {
        // 第一次解析将inJustDecodeBounds设置为true，来获取图片大小
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        // 调用上面定义的方法计算inSampleSize值
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        // 使用获取到的inSampleSize值再次解析图片
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }


    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static void handlerEmojiText(TextView comment, String content, Context context) throws IOException {
        comment.setText(handlerTextToEmojiSpannable(content, context));
    }

    public static SpannableStringBuilder handlerTextToEmojiSpannable(String content, Context context) throws IOException {
        return handlerTextToEmojiSpannable(content, context, dip2px(context, 18), dip2px(context, 18));
    }

    public static SpannableStringBuilder handlerTextToEmojiSpannable(String content, Context context, int width, int height) throws IOException {
        if (content == null) {
            throw new IOException("content should not be null");
        }
        if (emojiList == null) {
            emojiList = getEmojiList(context);
        }
        SpannableStringBuilder sb = new SpannableStringBuilder(content);
        String regex = "\\[(\\S+?)\\]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        while (m.find()) {
            String tempText = m.group();
            for (int i = 0; i < EmojiContentList.EmojiTextArray.length; i++) {
                if (tempText.equals(EmojiContentList.EmojiTextArray[i][0]) || tempText.equals(EmojiContentList.EmojiTextArray[i][1])) {
                    Emoji emoji = emojiList.get(i);
                    //转换为Span并设置Span的大小
                    sb.setSpan(new ImageSpan(context, decodeSampledBitmapFromResource(context.getResources(), emoji.getImageUri(), width, height)),
                        m.start(), m.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    break;
                }
            }
        }
        return sb;
    }
}
