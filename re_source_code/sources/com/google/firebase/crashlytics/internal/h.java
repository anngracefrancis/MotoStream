package com.google.firebase.crashlytics.internal;

import android.util.Log;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {
    static final h a = new h("FirebaseCrashlytics");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f19003c = 4;

    public h(String str) {
        this.f19002b = str;
    }

    private boolean a(int i2) {
        return this.f19003c <= i2 || Log.isLoggable(this.f19002b, i2);
    }

    public static h f() {
        return a;
    }

    public void b(String str) {
        c(str, null);
    }

    public void c(String str, Throwable th) {
        if (a(3)) {
            Log.d(this.f19002b, str, th);
        }
    }

    public void d(String str) {
        e(str, null);
    }

    public void e(String str, Throwable th) {
        if (a(6)) {
            Log.e(this.f19002b, str, th);
        }
    }

    public void g(String str) {
        h(str, null);
    }

    public void h(String str, Throwable th) {
        if (a(4)) {
            Log.i(this.f19002b, str, th);
        }
    }

    public void i(String str) {
        j(str, null);
    }

    public void j(String str, Throwable th) {
        if (a(2)) {
            Log.v(this.f19002b, str, th);
        }
    }

    public void k(String str) {
        l(str, null);
    }

    public void l(String str, Throwable th) {
        if (a(5)) {
            Log.w(this.f19002b, str, th);
        }
    }
}
