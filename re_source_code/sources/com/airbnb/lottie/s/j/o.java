package com.airbnb.lottie.s.j;

/* JADX INFO: compiled from: ShapePath.java */
/* JADX INFO: loaded from: classes.dex */
public class o implements b {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.h f8783c;

    public o(String str, int i2, com.airbnb.lottie.s.i.h hVar) {
        this.a = str;
        this.f8782b = i2;
        this.f8783c = hVar;
    }

    @Override // com.airbnb.lottie.s.j.b
    public com.airbnb.lottie.q.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar) {
        return new com.airbnb.lottie.q.a.p(fVar, aVar, this);
    }

    public String b() {
        return this.a;
    }

    public com.airbnb.lottie.s.i.h c() {
        return this.f8783c;
    }

    public String toString() {
        return "ShapePath{name=" + this.a + ", index=" + this.f8782b + '}';
    }
}
