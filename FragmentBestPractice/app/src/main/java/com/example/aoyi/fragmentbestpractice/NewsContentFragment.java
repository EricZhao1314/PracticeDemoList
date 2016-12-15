package com.example.aoyi.fragmentbestpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by aoyi on 2016/12/12.
 */

public class NewsContentFragment extends Fragment {
    @Nullable
    private View view;
    private TextView newsTitleText;
    private TextView newsContentText;
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.news_content_frag,container,false);
        return view;
    }
    //创建更新新闻标题与内容的方法
    public void refresh(String newsTitle , String newsContent){
        View visibilityLayout =view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        newsTitleText= (TextView) view.findViewById(R.id.news_title);
        newsContentText= (TextView) view.findViewById(R.id.news_content);
        newsTitleText.setText(newsTitle);
        newsContentText.setText(newsContent);


    }
}
