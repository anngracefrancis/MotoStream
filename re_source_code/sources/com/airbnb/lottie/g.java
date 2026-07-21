package com.airbnb.lottie;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: LottieImageAsset.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f8528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f8529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f8530e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Bitmap f8531f;

    public g(int i2, int i3, String str, String str2, String str3) {
        this.a = i2;
        this.f8527b = i3;
        this.f8528c = str;
        this.f8529d = str2;
        this.f8530e = str3;
    }

    public Bitmap a() {
        return this.f8531f;
    }

    public String b() {
        return this.f8529d;
    }

    public String c() {
        return this.f8528c;
    }

    public void d(Bitmap bitmap) {
        this.f8531f = bitmap;
    }
}
