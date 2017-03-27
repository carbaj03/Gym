package com.acv.gym.commons.logger;

import android.util.Log;

import timber.log.Timber;

public class CrashReportingTree extends Timber.Tree {
    @Override
    protected void log(int priority, String tag, String message, Throwable t) {

        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return;
        }

        CrashNotification.log(priority, tag, message);

        if (t != null) {
            if (priority == Log.ERROR) {
                CrashNotification.logError(t);
            } else if (priority == Log.WARN) {
                CrashNotification.logWarning(t);
            }
        }
    }
}