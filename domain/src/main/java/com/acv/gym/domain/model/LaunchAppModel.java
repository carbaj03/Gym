package com.acv.gym.domain.model;


public class LaunchAppModel {

    public final boolean isFirstTime;

    public LaunchAppModel(boolean isFirstTime) {
        this.isFirstTime = isFirstTime;
    }

    public boolean isFirstTime() {
        return isFirstTime;
    }
}
