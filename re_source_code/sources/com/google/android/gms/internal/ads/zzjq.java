package com.google.android.gms.internal.ads;

import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public final class zzjq {
    public final Uri a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f16358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f16359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f16360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f16361e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f16362f;

    public zzjq(Uri uri) {
        this(uri, 0);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.a);
        long j2 = this.f16358b;
        long j3 = this.f16359c;
        long j4 = this.f16360d;
        String str = this.f16361e;
        int i2 = this.f16362f;
        StringBuilder sb = new StringBuilder(strValueOf.length() + 91 + String.valueOf(str).length());
        sb.append("DataSpec[");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(j3);
        sb.append(", ");
        sb.append(j4);
        sb.append(", ");
        sb.append(str);
        sb.append(", ");
        sb.append(i2);
        sb.append("]");
        return sb.toString();
    }

    private zzjq(Uri uri, int i2) {
        this(uri, 0L, -1L, null, 0);
    }

    public zzjq(Uri uri, long j2, long j3, String str) {
        this(uri, j2, j2, j3, null, 0);
    }

    private zzjq(Uri uri, long j2, long j3, String str, int i2) {
        this(uri, 0L, 0L, -1L, null, 0);
    }

    public zzjq(Uri uri, long j2, long j3, long j4, String str, int i2) {
        boolean z = true;
        zzkh.a(j2 >= 0);
        zzkh.a(j3 >= 0);
        if (j4 <= 0 && j4 != -1) {
            z = false;
        }
        zzkh.a(z);
        this.a = uri;
        this.f16358b = j2;
        this.f16359c = j3;
        this.f16360d = j4;
        this.f16361e = str;
        this.f16362f = i2;
    }
}
