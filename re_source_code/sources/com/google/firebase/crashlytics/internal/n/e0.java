package com.google.firebase.crashlytics.internal.n;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.j;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: DataCollectionArbiter.java */
/* JADX INFO: loaded from: classes2.dex */
public class e0 {
    private final SharedPreferences a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f19022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f19023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    TaskCompletionSource<Void> f19024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f19025e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f19026f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Boolean f19027g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TaskCompletionSource<Void> f19028h;

    public e0(j jVar) {
        Object obj = new Object();
        this.f19023c = obj;
        this.f19024d = new TaskCompletionSource<>();
        this.f19025e = false;
        this.f19026f = false;
        this.f19028h = new TaskCompletionSource<>();
        Context contextI = jVar.i();
        this.f19022b = jVar;
        this.a = t.q(contextI);
        Boolean boolB = b();
        this.f19027g = boolB == null ? a(contextI) : boolB;
        synchronized (obj) {
            if (d()) {
                this.f19024d.e(null);
                this.f19025e = true;
            }
        }
    }

    private Boolean a(Context context) {
        Boolean boolG = g(context);
        if (boolG == null) {
            this.f19026f = false;
            return null;
        }
        this.f19026f = true;
        return Boolean.valueOf(Boolean.TRUE.equals(boolG));
    }

    private Boolean b() {
        if (!this.a.contains("firebase_crashlytics_collection_enabled")) {
            return null;
        }
        this.f19026f = false;
        return Boolean.valueOf(this.a.getBoolean("firebase_crashlytics_collection_enabled", true));
    }

    private boolean e() {
        try {
            return this.f19022b.r();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    private void f(boolean z) {
        String str;
        String str2 = z ? "ENABLED" : "DISABLED";
        if (this.f19027g == null) {
            str = "global Firebase setting";
        } else {
            str = this.f19026f ? "firebase_crashlytics_collection_enabled manifest flag" : "API";
        }
        h.f().b(String.format("Crashlytics automatic data collection %s by %s.", str2, str));
    }

    private static Boolean g(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_crashlytics_collection_enabled")) {
                return null;
            }
            return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
        } catch (PackageManager.NameNotFoundException e2) {
            h.f().e("Could not read data collection permission from manifest", e2);
            return null;
        }
    }

    public void c(boolean z) {
        if (!z) {
            throw new IllegalStateException("An invalid data collection token was used.");
        }
        this.f19028h.e(null);
    }

    public synchronized boolean d() {
        boolean zBooleanValue;
        Boolean bool = this.f19027g;
        zBooleanValue = bool != null ? bool.booleanValue() : e();
        f(zBooleanValue);
        return zBooleanValue;
    }

    public Task<Void> h() {
        Task<Void> taskA;
        synchronized (this.f19023c) {
            taskA = this.f19024d.a();
        }
        return taskA;
    }

    public Task<Void> i(Executor executor) {
        return q0.j(executor, this.f19028h.a(), h());
    }
}
