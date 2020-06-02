package com.example.applicationp0.bilibili;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.applicationp0.R;


import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    //上导航栏
    //中间页面内容
    public ViewPager homePager;
    private HomePagerAdapter mHomePagerAdapter;
    List<Fragment> fragments = new ArrayList<>();
    List<String> titles = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //加载fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        return rootView;
    }

}
