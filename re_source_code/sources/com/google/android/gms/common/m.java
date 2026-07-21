package com.google.android.gms.common;

import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
class m {
    private static final m a = new m(true, 3, 1, null, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f12088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String f12089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Throwable f12090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f12091e;

    private m(boolean z, int i2, int i3, String str, Throwable th) {
        this.f12088b = z;
        this.f12091e = i2;
        this.f12089c = str;
        this.f12090d = th;
    }

    @Deprecated
    static m b() {
        return a;
    }

    static m c(String str) {
        return new m(false, 1, 5, str, null);
    }

    static m d(String str, Throwable th) {
        return new m(false, 1, 5, str, th);
    }

    static m f(int i2) {
        return new m(true, i2, 1, null, null);
    }

    static m g(int i2, int i3, String str, Throwable th) {
        return new m(false, i2, i3, str, th);
    }

    String a() {
        return this.f12089c;
    }

    final void e() {
        if (this.f12088b || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.f12090d != null) {
            Log.d("GoogleCertificatesRslt", a(), this.f12090d);
        } else {
            Log.d("GoogleCertificatesRslt", a());
        }
    }
}
