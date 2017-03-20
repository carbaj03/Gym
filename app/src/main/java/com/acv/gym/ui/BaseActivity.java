package com.acv.gym.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import com.acv.gym.ui.navigation.Navigator;

import javax.inject.Inject;


public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    protected Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent();
        setupLayout();
    }

    protected abstract void setupActivityComponent();

    protected void setupLayout() {
        setContentView(getActivityLayout());
    }

    protected abstract
    @LayoutRes
    int getActivityLayout();

}
