package com.airbnb.lottie.s.j;

import android.graphics.PointF;

/* JADX INFO: compiled from: CircleShape.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.m<PointF, PointF> f8719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.f f8720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f8721d;

    public a(String str, com.airbnb.lottie.s.i.m<PointF, PointF> mVar, com.airbnb.lottie.s.i.f fVar, boolean z) {
        this.a = str;
        this.f8719b = mVar;
        this.f8720c = fVar;
        this.f8721d = z;
    }

    @Override // com.airbnb.lottie.s.j.b
    public com.airbnb.lottie.q.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar) {
        return new com.airbnb.lottie.q.a.e(fVar, aVar, this);
    }

    public String b() {
        return this.a;
    }

    public com.airbnb.lottie.s.i.m<PointF, PointF> c() {
        return this.f8719b;
    }

    public com.airbnb.lottie.s.i.f d() {
        return this.f8720c;
    }

    public boolean e() {
        return this.f8721d;
    }
}
