package com.airbnb.lottie.s.j;

import android.graphics.PointF;

/* JADX INFO: compiled from: PolystarShape.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements b {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f8757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.b f8758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.m<PointF, PointF> f8759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.b f8760e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.b f8761f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.b f8762g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.b f8763h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.b f8764i;

    /* JADX INFO: compiled from: PolystarShape.java */
    public enum a {
        Star(1),
        Polygon(2);


        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f8768i;

        a(int i2) {
            this.f8768i = i2;
        }

        public static a g(int i2) {
            for (a aVar : values()) {
                if (aVar.f8768i == i2) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public i(String str, a aVar, com.airbnb.lottie.s.i.b bVar, com.airbnb.lottie.s.i.m<PointF, PointF> mVar, com.airbnb.lottie.s.i.b bVar2, com.airbnb.lottie.s.i.b bVar3, com.airbnb.lottie.s.i.b bVar4, com.airbnb.lottie.s.i.b bVar5, com.airbnb.lottie.s.i.b bVar6) {
        this.a = str;
        this.f8757b = aVar;
        this.f8758c = bVar;
        this.f8759d = mVar;
        this.f8760e = bVar2;
        this.f8761f = bVar3;
        this.f8762g = bVar4;
        this.f8763h = bVar5;
        this.f8764i = bVar6;
    }

    @Override // com.airbnb.lottie.s.j.b
    public com.airbnb.lottie.q.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar) {
        return new com.airbnb.lottie.q.a.m(fVar, aVar, this);
    }

    public com.airbnb.lottie.s.i.b b() {
        return this.f8761f;
    }

    public com.airbnb.lottie.s.i.b c() {
        return this.f8763h;
    }

    public String d() {
        return this.a;
    }

    public com.airbnb.lottie.s.i.b e() {
        return this.f8762g;
    }

    public com.airbnb.lottie.s.i.b f() {
        return this.f8764i;
    }

    public com.airbnb.lottie.s.i.b g() {
        return this.f8758c;
    }

    public com.airbnb.lottie.s.i.m<PointF, PointF> h() {
        return this.f8759d;
    }

    public com.airbnb.lottie.s.i.b i() {
        return this.f8760e;
    }

    public a j() {
        return this.f8757b;
    }
}
