package com.nutstudio.ntour.content;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nutstudio.ntour.R;
import com.nutstudio.ntour.page.page2.CollectionRecyclerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ContentFragment extends Fragment {

    private ArrayList<Map<String, Object>> dataSet = new ArrayList<Map<String, Object>>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    private ArrayList<Map<String, Object>> getData() {
        for (int i = 0; i < 100; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("item_img", "https://www.baidu.com/img/bd_logo1.png");
            map.put("item_text", "picture" + i);
            dataSet.add(map);
        }
        return dataSet;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
