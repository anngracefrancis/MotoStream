package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcr {
    final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Uri f17352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String f17353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f17354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f17355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f17356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f17357g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f17358h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final zzcv<Context, Boolean> f17359i;

    public zzcr(Uri uri) {
        this(null, uri, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, false, false, false, false, null);
    }

    public final zzcl<Double> a(String str, double d2) {
        return zzcl.i(this, str, -3.0d);
    }

    public final zzcl<Long> b(String str, long j2) {
        return zzcl.j(this, str, j2);
    }

    public final zzcl<String> c(String str, String str2) {
        return zzcl.k(this, str, str2);
    }

    public final zzcl<Boolean> d(String str, boolean z) {
        return zzcl.l(this, str, z);
    }

    private zzcr(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, zzcv<Context, Boolean> zzcvVar) {
        this.a = null;
        this.f17352b = uri;
        this.f17353c = str2;
        this.f17354d = str3;
        this.f17355e = false;
        this.f17356f = false;
        this.f17357g = false;
        this.f17358h = false;
        this.f17359i = null;
    }
}
