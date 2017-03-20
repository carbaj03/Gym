package com.acv.gym.di;

import android.support.test.InstrumentationRegistry;

import com.acv.gym.GymApplication;
import com.acv.gym.di.component.AppComponent;
import com.acv.gym.di.module.AppModule;

import it.cosenonjaviste.daggermock.DaggerMockRule;


public class EspressoDaggerMockRule extends DaggerMockRule<AppComponent> {

    public EspressoDaggerMockRule() {
        super(AppComponent.class, new AppModule(getApp()));

        set(new ComponentSetter<AppComponent>() {
            @Override public void setComponent(AppComponent component) {
                GymApplication.appComponent = component;
            }
        });
    }

    private static GymApplication getApp() {
        return (GymApplication) InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext();
    }
}
