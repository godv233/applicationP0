package com.example.applicationp0.bilibili;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author godv
 * Date on 2020/6/2  17:16
 */
public class HomePagerAdapter extends FragmentPagerAdapter {
    private List<String> data = new ArrayList<>();

    public HomePagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new HomePageFragment(data.get(position));
    }

    @Override
    public int getCount() {
        return data.size();
    }

    /**
     * 设置数据
     *
     * @param data
     */
    public void setData(List<String> categories) {
        this.data.clear();
        data.addAll(categories);
        notifyDataSetChanged();
    }
}
