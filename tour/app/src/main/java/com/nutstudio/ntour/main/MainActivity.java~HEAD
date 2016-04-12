package com.nutstudio.ntour.main;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;

import com.nutstudio.ntour.R;
import com.nutstudio.ntour.addScenery.AddSceneryActivity;
import com.nutstudio.ntour.search.SearchActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.main_tab_layout)
    TabLayout mainTabLayout;
    @Bind(R.id.main_pager)
    ViewPager mainPager;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.root)
    LinearLayout root;
    private ViewPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initSystemUi();

    }

    private List<String> getNavList1Data() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("这是第" + i + "个");
        }
        return list;
    }

    private void initSystemUi() {

        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddSceneryActivity.class));
                Animator re= ViewAnimationUtils.createCircularReveal(root,1080,1920,56,root.getHeight());
                re.setDuration(3000);
                re.start();
                /*ObjectAnimator revealAnimator = ObjectAnimator.ofFloat( //缩放X 轴的
                        root, "scaleX", 0, 200);
                ObjectAnimator revealAnimator1 = ObjectAnimator.ofFloat(//缩放Y 轴的
                        root, "scaleY", 0, 200);
                AnimatorSet set = new AnimatorSet();
                set.setDuration(3000);//设置播放时间
                set.setInterpolator(new LinearInterpolator());//设置播放模式，这里是平常模式
                set.playTogether(revealAnimator, revealAnimator1);//设置一起播放
                set.start();
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });
        mainTabLayout.addTab(mainTabLayout.newTab().setText("发现"));
        mainTabLayout.addTab(mainTabLayout.newTab().setText("我的"));
        mainTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mainPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        LayoutInflater inflater = LayoutInflater.from(this);
        List<View> content = new ArrayList<View>();

        View view1 = inflater.inflate(R.layout.pager_item1, null);
        View view2 = inflater.inflate(R.layout.pager_item2, null);
        content.add(view1);
        content.add(view2);
        mPagerAdapter = new ViewPagerAdapter(content);
        mPagerAdapter.notifyDataSetChanged();
        mainPager.setAdapter(mPagerAdapter);
        TabLayout.TabLayoutOnPageChangeListener listener =
                new TabLayout.TabLayoutOnPageChangeListener(mainTabLayout);
        mainPager.addOnPageChangeListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            startActivity(new Intent(MainActivity.this, SearchActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
