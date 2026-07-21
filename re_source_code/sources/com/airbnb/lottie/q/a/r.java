package com.airbnb.lottie.q.a;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: TrimPathContent.java */
/* JADX INFO: loaded from: classes.dex */
public class r implements b, com.airbnb.lottie.q.b.a.InterfaceC0118a {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.airbnb.lottie.q.b.a.InterfaceC0118a> f8645b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.s.j.q.a f8646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, Float> f8647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, Float> f8648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, Float> f8649f;

    public r(com.airbnb.lottie.s.k.a aVar, com.airbnb.lottie.s.j.q qVar) {
        this.a = qVar.c();
        this.f8646c = qVar.f();
        com.airbnb.lottie.q.b.a<Float, Float> aVarA = qVar.e().a();
        this.f8647d = aVarA;
        com.airbnb.lottie.q.b.a<Float, Float> aVarA2 = qVar.b().a();
        this.f8648e = aVarA2;
        com.airbnb.lottie.q.b.a<Float, Float> aVarA3 = qVar.d().a();
        this.f8649f = aVarA3;
        aVar.i(aVarA);
        aVar.i(aVarA2);
        aVar.i(aVarA3);
        aVarA.a(this);
        aVarA2.a(this);
        aVarA3.a(this);
    }

    @Override // com.airbnb.lottie.q.b.a.InterfaceC0118a
    public void a() {
        for (int i2 = 0; i2 < this.f8645b.size(); i2++) {
            this.f8645b.get(i2).a();
        }
    }

    @Override // com.airbnb.lottie.q.a.b
    public void b(List<b> list, List<b> list2) {
    }

    void c(com.airbnb.lottie.q.b.a.InterfaceC0118a interfaceC0118a) {
        this.f8645b.add(interfaceC0118a);
    }

    public com.airbnb.lottie.q.b.a<?, Float> e() {
        return this.f8648e;
    }

    public com.airbnb.lottie.q.b.a<?, Float> h() {
        return this.f8649f;
    }

    public com.airbnb.lottie.q.b.a<?, Float> i() {
        return this.f8647d;
    }

    com.airbnb.lottie.s.j.q.a j() {
        return this.f8646c;
    }
}
