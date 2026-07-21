package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.util.PlatformVersion;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzuq {
    private final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private m40 f16819b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f16820c = false;

    public final Activity a() {
        synchronized (this.a) {
            if (!PlatformVersion.a()) {
                return null;
            }
            m40 m40Var = this.f16819b;
            if (m40Var == null) {
                return null;
            }
            return m40Var.a();
        }
    }

    public final Context b() {
        synchronized (this.a) {
            if (!PlatformVersion.a()) {
                return null;
            }
            m40 m40Var = this.f16819b;
            if (m40Var == null) {
                return null;
            }
            return m40Var.b();
        }
    }

    public final void c(Context context) {
        synchronized (this.a) {
            if (!this.f16820c) {
                if (!PlatformVersion.a()) {
                    return;
                }
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                if (application == null) {
                    zzbad.i("Can not cast Context to Application");
                    return;
                }
                if (this.f16819b == null) {
                    this.f16819b = new m40();
                }
                this.f16819b.e(application, context);
                this.f16820c = true;
            }
        }
    }

    public final void d(zzut zzutVar) {
        synchronized (this.a) {
            if (PlatformVersion.a()) {
                if (this.f16819b == null) {
                    this.f16819b = new m40();
                }
                this.f16819b.f(zzutVar);
            }
        }
    }
}
