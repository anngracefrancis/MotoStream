package com.airbnb.lottie.w;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: Keyframe.java */
/* JADX INFO: loaded from: classes.dex */
public class a<T> {
    private final com.airbnb.lottie.d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f8862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f8863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Interpolator f8864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f8865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Float f8866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f8867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f8868h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PointF f8869i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PointF f8870j;

    public a(com.airbnb.lottie.d dVar, T t, T t2, Interpolator interpolator, float f2, Float f3) {
        this.f8867g = Float.MIN_VALUE;
        this.f8868h = Float.MIN_VALUE;
        this.f8869i = null;
        this.f8870j = null;
        this.a = dVar;
        this.f8862b = t;
        this.f8863c = t2;
        this.f8864d = interpolator;
        this.f8865e = f2;
        this.f8866f = f3;
    }

    public boolean a(float f2) {
        return f2 >= c() && f2 < b();
    }

    public float b() {
        if (this.a == null) {
            return 1.0f;
        }
        if (this.f8868h == Float.MIN_VALUE) {
            if (this.f8866f == null) {
                this.f8868h = 1.0f;
            } else {
                this.f8868h = c() + ((this.f8866f.floatValue() - this.f8865e) / this.a.e());
            }
        }
        return this.f8868h;
    }

    public float c() {
        com.airbnb.lottie.d dVar = this.a;
        if (dVar == null) {
            return 0.0f;
        }
        if (this.f8867g == Float.MIN_VALUE) {
            this.f8867g = (this.f8865e - dVar.m()) / this.a.e();
        }
        return this.f8867g;
    }

    public boolean d() {
        return this.f8864d == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f8862b + ", endValue=" + this.f8863c + ", startFrame=" + this.f8865e + ", endFrame=" + this.f8866f + ", interpolator=" + this.f8864d + '}';
    }

    public a(T t) {
        this.f8867g = Float.MIN_VALUE;
        this.f8868h = Float.MIN_VALUE;
        this.f8869i = null;
        this.f8870j = null;
        this.a = null;
        this.f8862b = t;
        this.f8863c = t;
        this.f8864d = null;
        this.f8865e = Float.MIN_VALUE;
        this.f8866f = Float.valueOf(Float.MAX_VALUE);
    }
}
