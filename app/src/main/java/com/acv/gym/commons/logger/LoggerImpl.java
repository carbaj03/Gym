package com.acv.gym.commons.logger;


import com.acv.gym.BuildConfig;
import com.acv.gym.domain.commons.logger.Logger;

import timber.log.Timber;

public class LoggerImpl implements Logger {

    public static void initialize(){
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }
    }

    @Override
    public void tag(String tag) {
        Timber.tag(tag);
    }

    @Override
    public void d(String message, Object... objects) {
        Timber.d(message, objects);
    }

    @Override
    public void d(Throwable t) {
        Timber.d(t);
    }

    @Override
    public void d(Throwable t, String message, Object... objects) {
        Timber.d(t, message, objects);
    }

    @Override
    public void i(String message, Object... objects) {
        Timber.i(message, objects);
    }

    @Override
    public void i(Throwable t) {
        Timber.i(t);
    }

    @Override
    public void i(Throwable t, String message, Object... objects) {
        Timber.i(t, message, objects);
    }

    @Override
    public void e(String message, Object... objects) {
        Timber.e(message, objects);
    }

    @Override
    public void e(Throwable t) {
        Timber.e(t);
    }

    @Override
    public void e(Throwable t, String message, Object... objects) {
        Timber.e(t, message, objects);
    }
}
