package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.ads.internal.zzk;
import java.lang.ref.WeakReference;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzasq extends ContextWrapper {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference<Activity> f14147b;

    private zzasq(Context context) {
        super(context);
        this.f14147b = new WeakReference<>(null);
    }

    private final synchronized Intent b(Intent intent) {
        if (this.a != null && intent.getComponent() != null && intent.getComponent().getPackageName().equals(this.a.getPackageName())) {
            Intent intent2 = (Intent) intent.clone();
            intent2.setClassName(super.getPackageName(), intent.getComponent().getClassName());
            return intent2;
        }
        return intent;
    }

    private final synchronized void c(Intent intent) {
        Activity activity = this.f14147b.get();
        if (activity == null) {
            intent.addFlags(268435456);
            super.startActivity(intent);
            return;
        }
        try {
            Intent intent2 = (Intent) intent.clone();
            intent2.setFlags(intent.getFlags() & (-268435457));
            activity.startActivity(intent2);
        } catch (Throwable th) {
            zzk.zzlk().e(th, HttpUrl.FRAGMENT_ENCODE_SET);
            intent.addFlags(268435456);
            super.startActivity(intent);
        }
    }

    private static Context d(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public static zzasq e(Context context) {
        return new zzasq(d(context));
    }

    public static Context f(Context context) {
        return context instanceof zzasq ? ((zzasq) context).getBaseContext() : d(context);
    }

    public final synchronized void a(String str) throws PackageManager.NameNotFoundException {
        this.a = super.createPackageContext(str, 0);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return this;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized ApplicationInfo getApplicationInfo() {
        Context context = this.a;
        if (context != null) {
            return context.getApplicationInfo();
        }
        return super.getApplicationInfo();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized String getPackageName() {
        Context context = this.a;
        if (context != null) {
            return context.getPackageName();
        }
        return super.getPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized String getPackageResourcePath() {
        Context context = this.a;
        if (context != null) {
            return context.getPackageResourcePath();
        }
        return super.getPackageResourcePath();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized void startActivity(Intent intent) {
        c(b(intent));
    }
}
