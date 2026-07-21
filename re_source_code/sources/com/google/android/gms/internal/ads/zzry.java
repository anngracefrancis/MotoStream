package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class zzry {
    public final Uri a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f16684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f16685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f16686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f16687e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f16688f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f16689g;

    public zzry(Uri uri) {
        this(uri, 0);
    }

    public final boolean a(int i2) {
        return (this.f16689g & 1) == 1;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.a);
        String string = Arrays.toString(this.f16684b);
        long j2 = this.f16685c;
        long j3 = this.f16686d;
        long j4 = this.f16687e;
        String str = this.f16688f;
        int i2 = this.f16689g;
        StringBuilder sb = new StringBuilder(strValueOf.length() + 93 + String.valueOf(string).length() + String.valueOf(str).length());
        sb.append("DataSpec[");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(string);
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

    private zzry(Uri uri, int i2) {
        this(uri, 0L, -1L, null, 0);
    }

    public zzry(Uri uri, long j2, long j3, String str) {
        this(uri, j2, j2, j3, str, 0);
    }

    private zzry(Uri uri, long j2, long j3, String str, int i2) {
        this(uri, 0L, 0L, -1L, null, 0);
    }

    private zzry(Uri uri, long j2, long j3, long j4, String str, int i2) {
        this(uri, null, j2, j3, j4, str, i2);
    }

    public zzry(Uri uri, byte[] bArr, long j2, long j3, long j4, String str, int i2) {
        boolean z = true;
        zzsk.a(j2 >= 0);
        zzsk.a(j3 >= 0);
        if (j4 <= 0 && j4 != -1) {
            z = false;
        }
        zzsk.a(z);
        this.a = uri;
        this.f16684b = bArr;
        this.f16685c = j2;
        this.f16686d = j3;
        this.f16687e = j4;
        this.f16688f = str;
        this.f16689g = i2;
    }
}
