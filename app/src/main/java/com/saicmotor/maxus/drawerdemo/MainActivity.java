package com.saicmotor.maxus.drawerdemo;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> mPlanetTitles = new ArrayList<String>();
    private DrawerLayout mDrawerLayout;
    private LinearLayout left;
    private ListView mDrawerList;
    private ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initView() {
        mDrawerList =findViewById(R.id.left_drawer);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        left= findViewById(R.id.left);
        icon = findViewById(R.id.icon);
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            mPlanetTitles.add("left---Line" + i);
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.activity_list_item, android.R.id.text1, mPlanetTitles);
        mDrawerList.setAdapter(adapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mDrawerLayout.closeDrawers();
            }
        });

        mDrawerLayout.setScrimColor(Color.TRANSPARENT);

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(left);
            }
        });

        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                int top = (new Double(200 / 1.5)).intValue();
                Float left = 1100 - 840 * slideOffset;
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(320, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(left.intValue(), top, 0, 0);
                icon.setLayoutParams(lp);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }
}
