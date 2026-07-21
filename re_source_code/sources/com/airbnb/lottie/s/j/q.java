package com.airbnb.lottie.s.j;

import com.airbnb.lottie.q.a.r;

/* JADX INFO: compiled from: ShapeTrimPath.java */
/* JADX INFO: loaded from: classes.dex */
public class q implements b {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f8801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.b f8802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.b f8803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.b f8804e;

    /* JADX INFO: compiled from: ShapeTrimPath.java */
    public enum a {
        Simultaneously,
        Individually;

        public static a g(int i2) {
            if (i2 == 1) {
                return Simultaneously;
            }
            if (i2 == 2) {
                return Individually;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i2);
        }
    }

    public q(String str, a aVar, com.airbnb.lottie.s.i.b bVar, com.airbnb.lottie.s.i.b bVar2, com.airbnb.lottie.s.i.b bVar3) {
        this.a = str;
        this.f8801b = aVar;
        this.f8802c = bVar;
        this.f8803d = bVar2;
        this.f8804e = bVar3;
    }

    @Override // com.airbnb.lottie.s.j.b
    public com.airbnb.lottie.q.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar) {
        return new r(aVar, this);
    }

    public com.airbnb.lottie.s.i.b b() {
        return this.f8803d;
    }

    public String c() {
        return this.a;
    }

    public com.airbnb.lottie.s.i.b d() {
        return this.f8804e;
    }

    public com.airbnb.lottie.s.i.b e() {
        return this.f8802c;
    }

    public a f() {
        return this.f8801b;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f8802c + ", end: " + this.f8803d + ", offset: " + this.f8804e + "}";
    }
}
