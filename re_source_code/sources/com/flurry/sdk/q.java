package com.flurry.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends d7<p> implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static String p;
    public int q;
    private final Set<String> r;

    public q() {
        super("ApplicationLifecycleProvider");
        this.q = 0;
        Application application = (Application) b0.a();
        if (application != null) {
            this.q = application.getResources().getConfiguration().orientation;
            application.registerActivityLifecycleCallbacks(this);
            application.registerComponentCallbacks(this);
        } else {
            d1.c(6, "ApplicationLifecycleProvider", "Context is null when initializing.");
        }
        this.r = new HashSet();
    }

    private void x(int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("trim_memory_level", i2);
        t(new p(p.a.TRIM_MEMORY, bundle));
    }

    private void y(Activity activity, p.a aVar) {
        Bundle extras;
        Bundle bundle = new Bundle();
        bundle.putString("activity_name", activity.getLocalClassName());
        if (p.a.CREATED.equals(aVar)) {
            try {
                Intent intent = activity.getIntent();
                if (intent != null && (extras = intent.getExtras()) != null) {
                    bundle.putBundle("launch_options", extras);
                }
            } catch (Throwable unused) {
                d1.c(6, "ApplicationLifecycleProvider", "Error to get Launch Options from the Intent.");
            }
        }
        t(new p(aVar, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        y(activity, p.a.CREATED);
        synchronized (this) {
            if (p == null) {
                p = activity.getClass().getName();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        y(activity, p.a.DESTROYED);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        y(activity, p.a.PAUSED);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        y(activity, p.a.RESUMED);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        y(activity, p.a.SAVE_STATE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        this.r.add(activity.toString());
        y(activity, p.a.STARTED);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        this.r.remove(activity.toString());
        y(activity, p.a.STOPPED);
        if (this.r.isEmpty()) {
            y(activity, p.a.APP_BACKGROUND);
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        int i2 = configuration.orientation;
        if (this.q != i2) {
            this.q = i2;
            Bundle bundle = new Bundle();
            bundle.putInt("orientation_name", this.q);
            t(new p(p.a.APP_ORIENTATION_CHANGE, bundle));
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        x(80);
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
        x(i2);
    }
}
