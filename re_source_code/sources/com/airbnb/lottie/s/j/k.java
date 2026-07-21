package com.airbnb.lottie.s.j;

/* JADX INFO: compiled from: Repeater.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements b {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.b f8772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.b f8773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.l f8774d;

    public k(String str, com.airbnb.lottie.s.i.b bVar, com.airbnb.lottie.s.i.b bVar2, com.airbnb.lottie.s.i.l lVar) {
        this.a = str;
        this.f8772b = bVar;
        this.f8773c = bVar2;
        this.f8774d = lVar;
    }

    @Override // com.airbnb.lottie.s.j.b
    public com.airbnb.lottie.q.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar) {
        return new com.airbnb.lottie.q.a.o(fVar, aVar, this);
    }

    public com.airbnb.lottie.s.i.b b() {
        return this.f8772b;
    }

    public String c() {
        return this.a;
    }

    public com.airbnb.lottie.s.i.b d() {
        return this.f8773c;
    }

    public com.airbnb.lottie.s.i.l e() {
        return this.f8774d;
    }
}
