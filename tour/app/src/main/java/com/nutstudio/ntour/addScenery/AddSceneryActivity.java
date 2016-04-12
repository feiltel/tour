package com.nutstudio.ntour.addScenery;

import android.animation.Animator;
import android.os.Bundle;
import android.view.ViewAnimationUtils;
import android.widget.LinearLayout;

import com.nutstudio.ntour.R;
import com.nutstudio.ntour.custom.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fei on 2016/4/12.
 */
public class AddSceneryActivity extends BaseActivity {


    @Bind(R.id.root)
    LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_scenery);
        ButterKnife.bind(this);
        /*Animator re = ViewAnimationUtils.createCircularReveal(root, 1080, 1920, 56, root.getHeight());
        re.setDuration(3000);
        re.start();*/
    }
}
