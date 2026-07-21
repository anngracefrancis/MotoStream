package com.airbnb.lottie.s.j;

import android.graphics.Path;

/* JADX INFO: compiled from: ShapeFill.java */
/* JADX INFO: loaded from: classes.dex */
public class m implements b {
    private final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path.FillType f8777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f8778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.a f8779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.d f8780e;

    public m(String str, boolean z, Path.FillType fillType, com.airbnb.lottie.s.i.a aVar, com.airbnb.lottie.s.i.d dVar) {
        this.f8778c = str;
        this.a = z;
        this.f8777b = fillType;
        this.f8779d = aVar;
        this.f8780e = dVar;
    }

    @Override // com.airbnb.lottie.s.j.b
    public com.airbnb.lottie.q.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar) {
        return new com.airbnb.lottie.q.a.f(fVar, aVar, this);
    }

    public com.airbnb.lottie.s.i.a b() {
        return this.f8779d;
    }

    public Path.FillType c() {
        return this.f8777b;
    }

    public String d() {
        return this.f8778c;
    }

    public com.airbnb.lottie.s.i.d e() {
        return this.f8780e;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.a + '}';
    }
}
