package com.example.applicationp0.bilibili;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.applicationp0.R;

/**
 * @Author godv
 * Date on 2020/6/2  18:09
 */
public class HomePageFragment extends Fragment {
    private String text;
    public HomePageFragment(String s) {
        text=s;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_page_content, container, false);
        TextView textView = view.findViewById(R.id.content_text);
        textView.setText(text);
        return view;

    }
}
