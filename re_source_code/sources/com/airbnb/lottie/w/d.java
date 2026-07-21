package com.airbnb.lottie.w;

/* JADX INFO: compiled from: ScaleXY.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private final float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f8879b;

    public d(float f2, float f3) {
        this.a = f2;
        this.f8879b = f3;
    }

    public float a() {
        return this.a;
    }

    public float b() {
        return this.f8879b;
    }

    public String toString() {
        return a() + "x" + b();
    }

    public d() {
        this(1.0f, 1.0f);
    }
}
