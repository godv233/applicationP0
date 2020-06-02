package com.example.applicationp0;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.applicationp0.bilibili.HomeFragment;
import com.example.applicationp0.bilibili.IndexFragment;
import com.example.applicationp0.bilibili.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * 相同的部分在于
 * 都是使用BottomNavigationView+fragment的切换来实现的
 *
 * 两种导航栏实现的逻辑在于
 * 对于在avtivity中使用fragment的官方实现方式来说：
 * 相当于我们把其中点击跳转fragment的逻辑放在了navController。简化了开发
 *
 * 对于在activity中使用FrameLayout的手动实现方式来说，
 * 相当于我们手动的实现了其中点击跳转的逻辑。将其中的fragment来替换FrameLayout
 * 需要我们手动初始化fragment并且设置事件的监听（navView.setOnNavigationItemSelectedListener）。
 *
 */
public class MainActivity extends AppCompatActivity {
    private HomeFragment homeFragment;
    private IndexFragment indexFragment;
    private SearchFragment searchFragment;
    private BottomNavigationView navView;
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navView = findViewById(R.id.nav_view);
//        //实例化naV_controller
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navView.getMenu()).build();
//        //声明appBar
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);
        initView();
        initListener();
        //默认选择首页
        switchFragment(indexFragment);
    }
    //设置事件监听
    private void initListener() {
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_index:
                        switchFragment(indexFragment);
                        break;
                    case R.id.navigation_home:
                        switchFragment(homeFragment);
                        break;
                    case R.id.navigation_search:
                        switchFragment(searchFragment);
                        break;
                }
                return true;
            }
        });
    }

    private void switchFragment(Fragment targetFragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_page_container, targetFragment);
        transaction.commit();
    }

    //初始化视图
    private void initView() {
        //初始化fragment
        homeFragment=new HomeFragment();
        indexFragment=new IndexFragment();
        searchFragment=new SearchFragment();
    }
}
