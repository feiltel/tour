package com.nutstudio.ntour.search;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import com.nutstudio.ntour.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fei on 2016/4/12.
 */
public class SearchActivity extends AppCompatActivity {
    @Bind(R.id.search_view)
    SearchView searchView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_search);
        ButterKnife.bind(this);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchView.setSubmitButtonEnabled(true);
        initSystemUi();
    }

    private void initSystemUi() {
        setSupportActionBar(toolbar);
    }
}
