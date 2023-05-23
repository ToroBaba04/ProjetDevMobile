package com.example.testbd.modele;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.example.testbd.R;

public class Layouts {
    public Layouts() {}
    public CardView getCardView(@Nullable Context context){
        CardView card = new CardView(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) (160*2.6));
        params.setMargins((int)(22*2.6),(int)(5*2.6),(int)(22*2.6),(int)(5*2.6));
        card.setLayoutParams(params);
        card.setBackgroundColor(Color.WHITE);
        card.setBackgroundResource(R.drawable.backlayout);
        card.setCardElevation((int)(9*2.6));
        //card.setUseCompatPadding(true);
        return card;
    }
    public TextView getTextView1(@Nullable Context context){
        TextView text1 = new TextView(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        text1.setTextColor(Color.BLACK);
        text1.setBackgroundColor(Color.WHITE);
        text1.setTextSize(24);
        params.setMargins((int)(20*2.6),(int)(20*2.6), 0, 0);
        text1.setLayoutParams(params);
        text1.setTypeface(null, Typeface.BOLD);
        return text1;
    }
    public TextView getTextView2(@Nullable Context context){
        TextView text2 = new TextView(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        text2.setTextColor(Color.BLACK);
        text2.setTextSize(16);
        text2.setBackgroundColor(Color.WHITE);
        params.setMargins(0,(int)(50*2.6), 0, 0);
        text2.setLayoutParams(params);
        text2.setPadding((int)(20*2.6),(int)(20*2.6),(int)(20*2.6),(int)(20*2.6));
        return text2;
    }
}
