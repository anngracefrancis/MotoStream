package com.airbnb.lottie.s.j;

import android.graphics.PointF;

/* JADX INFO: compiled from: RectangleShape.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements b {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.m<PointF, PointF> f8769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.f f8770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.b f8771d;

    public j(String str, com.airbnb.lottie.s.i.m<PointF, PointF> mVar, com.airbnb.lottie.s.i.f fVar, com.airbnb.lottie.s.i.b bVar) {
        this.a = str;
        this.f8769b = mVar;
        this.f8770c = fVar;
        this.f8771d = bVar;
    }

    @Override // com.airbnb.lottie.s.j.b
    public com.airbnb.lottie.q.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar) {
        return new com.airbnb.lottie.q.a.n(fVar, aVar, this);
    }

    public com.airbnb.lottie.s.i.b b() {
        return this.f8771d;
    }

    public String c() {
        return this.a;
    }

    public com.airbnb.lottie.s.i.m<PointF, PointF> d() {
        return this.f8769b;
    }

    public com.airbnb.lottie.s.i.f e() {
        return this.f8770c;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f8769b + ", size=" + this.f8770c + '}';
    }
}
