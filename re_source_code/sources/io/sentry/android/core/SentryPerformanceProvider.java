package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import io.sentry.f4;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class SentryPerformanceProvider extends x0 implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static f4 f22069g = h0.a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static long f22070h = SystemClock.uptimeMillis();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f22071i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f22072j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Application f22073k;

    public SentryPerformanceProvider() {
        q0.e().i(f22070h, f22069g);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        if (SentryPerformanceProvider.class.getName().equals(providerInfo.authority)) {
            throw new IllegalStateException("An applicationId is required to fulfill the manifest placeholder.");
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.f22071i) {
            return;
        }
        q0.e().j(bundle == null);
        this.f22071i = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (!this.f22072j) {
            this.f22072j = true;
            q0.e().g();
        }
        Application application = this.f22073k;
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        if (!(context instanceof Application)) {
            return true;
        }
        Application application = (Application) context;
        this.f22073k = application;
        application.registerActivityLifecycleCallbacks(this);
        return true;
    }
}
