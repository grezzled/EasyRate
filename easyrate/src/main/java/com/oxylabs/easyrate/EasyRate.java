package com.oxylabs.easyrate;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;


/**
 * Created by Soufiane on 03,September,2019
 * https://www.isoufiane.com
 */
public class EasyRate {

    private String title;
    private Context context;
    private Dialog d;
    private ImageView imgRev1, imgRev2, imgRev3, imgRev4, imgRev5, avatarImg, closeBtn;
    private TextView avatarTxt, avatarMsg;
    private Button ctaBtn;
    private SharedPreferences.Editor editor;

    private int DAYS_UNTIL_PROMPT = 3;//Default number of days
    private int LAUNCHES_UNTIL_PROMPT = 3;//Default number of launches

    public static EasyRate init(Context context) {
        EasyRate easyRate = new EasyRate();
        easyRate.context = context;
        return easyRate;
    }

    // TODO Customize things

    public void show() {
        d = new Dialog(context);
        // Inflate layout and add it to dialog
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater == null)
            return;
        View view = inflater.inflate(R.layout.view_easy_rate, null);

        bindViews(view);
        initViews();

        d.setContentView(view);

        // Copy Default params then change width & height
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = d.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            lp.copyFrom(window.getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            window.setAttributes(lp);
        }

        d.show();
    }


    private void bindViews(View view) {
        imgRev1 = view.findViewById(R.id.rev1_img);
        imgRev2 = view.findViewById(R.id.rev2_img);
        imgRev3 = view.findViewById(R.id.rev3_img);
        imgRev4 = view.findViewById(R.id.rev4_img);
        imgRev5 = view.findViewById(R.id.rev5_img);
        avatarImg = view.findViewById(R.id.avatar_img);
        avatarTxt = view.findViewById(R.id.avatar_txt);
        avatarMsg = view.findViewById(R.id.avatar_msg);
        ctaBtn = view.findViewById(R.id.cta_btn);
        closeBtn = view.findViewById(R.id.close_btn);
    }

    private void initViews() {
        setFilter(imgRev1, imgRev2, imgRev3, imgRev4, imgRev5);

        imgRev1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeFilter(imgRev1);
                initIcons(context);
                setFilter(imgRev2, imgRev3, imgRev4, imgRev5);
                avatarImg.setImageDrawable(context.getResources().getDrawable(R.drawable.avatar_man_1));
                avatarImg.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.avatar_man_1, null));
                avatarTxt.setText(context.getResources().getString(R.string.dev));
                avatarMsg.setText(context.getResources().getString(R.string.review_1));
                ctaBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                ctaBtn.setText(context.getResources().getText(R.string.write_feedback));
                ctaBtn.setEnabled(true);
                ctaBtn.setBackground(context.getResources().getDrawable(R.drawable.round_corners_fill));
            }
        });

        imgRev2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeFilter(imgRev1, imgRev2);
                initIcons(context);
                setSameImg(context.getResources().getDrawable(R.drawable.emoji_angry), imgRev1, imgRev2);
                setFilter(imgRev3, imgRev4, imgRev5);
                avatarImg.setImageDrawable(context.getResources().getDrawable(R.drawable.avatar_girl_1));
                avatarTxt.setText(context.getResources().getString(R.string.ui));
                avatarMsg.setText(context.getResources().getString(R.string.review_2));
                ctaBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    }
                });
                ctaBtn.setText(context.getResources().getText(R.string.write_feedback));
                ctaBtn.setEnabled(true);
                ctaBtn.setBackground(context.getResources().getDrawable(R.drawable.round_corners_fill));
            }
        });

        imgRev3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeFilter(imgRev1, imgRev2, imgRev3);
                initIcons(context);
                setSameImg(context.getResources().getDrawable(R.drawable.emoji_thinking), imgRev1, imgRev2, imgRev3);
                setFilter(imgRev4, imgRev5);
                avatarImg.setImageDrawable(context.getResources().getDrawable(R.drawable.avatar_boy));
                avatarTxt.setText(context.getResources().getString(R.string.qa));
                avatarMsg.setText(context.getResources().getString(R.string.review_3));
                ctaBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    }
                });
                ctaBtn.setText(context.getResources().getText(R.string.write_feedback));
                ctaBtn.setEnabled(true);
                ctaBtn.setBackground(context.getResources().getDrawable(R.drawable.round_corners_fill));
            }
        });

        imgRev4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeFilter(imgRev1, imgRev2, imgRev3, imgRev4);
                initIcons(context);
                setSameImg(context.getResources().getDrawable(R.drawable.emoji_happy), imgRev1, imgRev2, imgRev3, imgRev4);
                setFilter(imgRev5);
                avatarImg.setImageDrawable(context.getResources().getDrawable(R.drawable.avatar_man));
                avatarTxt.setText(context.getResources().getString(R.string.op));
                avatarMsg.setText(context.getResources().getString(R.string.review_4));
                ctaBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + context.getPackageName())));
                        if (editor != null) {
                            editor.putBoolean("dontshowagain", true);
                            editor.commit();
                        }
                        closeBtn.performClick();

                    }
                });
                ctaBtn.setText(context.getResources().getText(R.string.rate));
                ctaBtn.setEnabled(true);
                ctaBtn.setBackground(context.getResources().getDrawable(R.drawable.round_corners_fill));
            }
        });

        imgRev5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeFilter(imgRev1, imgRev2, imgRev3, imgRev4, imgRev5);
                initIcons(context);
                setSameImg(context.getResources().getDrawable(R.drawable.emoji_in_love), imgRev1, imgRev2, imgRev3, imgRev4, imgRev5);
                avatarImg.setImageDrawable(context.getResources().getDrawable(R.drawable.avatar_girl));
                avatarTxt.setText(context.getResources().getString(R.string.pm));
                avatarMsg.setText(context.getResources().getString(R.string.review_5));
                ctaBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + context.getPackageName())));
                        if (editor != null) {
                            editor.putBoolean("dontshowagain", true);
                            editor.commit();
                        }
                        closeBtn.performClick();
                    }
                });
                ctaBtn.setText(context.getResources().getText(R.string.rate));
                ctaBtn.setEnabled(true);
                ctaBtn.setBackground(context.getResources().getDrawable(R.drawable.round_corners_fill));
            }
        });

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetDelay();
                d.dismiss();
            }
        });
    }

    private void setFilter(ImageView... imageViews) {
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        for (ImageView imgv : imageViews) {
            imgv.setColorFilter(filter);
        }
    }

    private void setSameImg(Drawable image, ImageView... imageViews) {
        for (ImageView imgV : imageViews) {
            imgV.setImageDrawable(image);
        }
    }

    private void removeFilter(ImageView... imageViews) {
        for (ImageView imgV : imageViews) {
            imgV.setColorFilter(null);
        }
    }

    private void initIcons(Context context) {
        imgRev1.setImageDrawable(context.getResources().getDrawable(R.drawable.emoji_crying));
        imgRev2.setImageDrawable(context.getResources().getDrawable(R.drawable.emoji_angry));
        imgRev3.setImageDrawable(context.getResources().getDrawable(R.drawable.emoji_thinking));
        imgRev4.setImageDrawable(context.getResources().getDrawable(R.drawable.emoji_happy));
        imgRev5.setImageDrawable(context.getResources().getDrawable(R.drawable.emoji_in_love));
    }


    public void build() {
        // Should Show Dialog
        SharedPreferences prefs = context.getSharedPreferences("apprater", 0);
        if (prefs.getBoolean("dontshowagain", false)) {
            return;
        }

        editor = prefs.edit();

        // Increment launch counter
        long launch_count = prefs.getLong("launch_count", 0) + 1;
        editor.putLong("launch_count", launch_count);

        // Get date of first launch
        Long date_firstLaunch = prefs.getLong("date_firstlaunch", 0);
        if (date_firstLaunch == 0) {
            date_firstLaunch = System.currentTimeMillis();
            editor.putLong("date_firstlaunch", date_firstLaunch);
        }

        // Wait at least n days before opening
        if (launch_count >= LAUNCHES_UNTIL_PROMPT) {
            if (System.currentTimeMillis() >= date_firstLaunch +
                    (DAYS_UNTIL_PROMPT * 24 * 60 * 60 * 1000)) {
                show();
            }
        }
        editor.apply();
    }

    public EasyRate setDaysDelay(int numberOfDays) {
        DAYS_UNTIL_PROMPT = numberOfDays;
        return this;
    }

    public EasyRate setLaunchesDelay(int numberOfLaunches) {
        LAUNCHES_UNTIL_PROMPT = numberOfLaunches;
        return this;
    }

    public void resetDelay() {
        SharedPreferences prefs = context.getSharedPreferences("apprater", 0);
        editor = prefs.edit();
        editor.putLong("date_firstlaunch", 0);
        editor.putLong("launch_count", 0);
        editor.apply();
    }

    public void dontShowAgain(Boolean showAgain) {
        SharedPreferences prefs = context.getSharedPreferences("apprater", 0);
        editor = prefs.edit();
        editor.putBoolean("dontshowagain", showAgain);
        editor.apply();
    }

    public void setOnActionClickListener() {

    }


}
