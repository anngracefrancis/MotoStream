package com.bumptech.glide.load.engine;

import com.bumptech.glide.Registry;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DecodeHelper.java */
/* JADX INFO: loaded from: classes.dex */
final class g<Transcode> {
    private final List<com.bumptech.glide.load.n.n.a<?>> a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.bumptech.glide.load.f> f9103b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.e f9104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f9105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f9106e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9107f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Class<?> f9108g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private h.e f9109h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.load.i f9110i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<Class<?>, com.bumptech.glide.load.l<?>> f9111j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Class<Transcode> f9112k;
    private boolean l;
    private boolean m;
    private com.bumptech.glide.load.f n;
    private com.bumptech.glide.g o;
    private j p;
    private boolean q;
    private boolean r;

    g() {
    }

    void a() {
        this.f9104c = null;
        this.f9105d = null;
        this.n = null;
        this.f9108g = null;
        this.f9112k = null;
        this.f9110i = null;
        this.o = null;
        this.f9111j = null;
        this.p = null;
        this.a.clear();
        this.l = false;
        this.f9103b.clear();
        this.m = false;
    }

    com.bumptech.glide.load.engine.z.b b() {
        return this.f9104c.b();
    }

    List<com.bumptech.glide.load.f> c() {
        if (!this.m) {
            this.m = true;
            this.f9103b.clear();
            List<com.bumptech.glide.load.n.n.a<?>> listG = g();
            int size = listG.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.bumptech.glide.load.n.n.a<?> aVar = listG.get(i2);
                if (!this.f9103b.contains(aVar.a)) {
                    this.f9103b.add(aVar.a);
                }
                for (int i3 = 0; i3 < aVar.f9325b.size(); i3++) {
                    if (!this.f9103b.contains(aVar.f9325b.get(i3))) {
                        this.f9103b.add(aVar.f9325b.get(i3));
                    }
                }
            }
        }
        return this.f9103b;
    }

    com.bumptech.glide.load.engine.a0.a d() {
        return this.f9109h.a();
    }

    j e() {
        return this.p;
    }

    int f() {
        return this.f9107f;
    }

    List<com.bumptech.glide.load.n.n.a<?>> g() {
        if (!this.l) {
            this.l = true;
            this.a.clear();
            List listI = this.f9104c.h().i(this.f9105d);
            int size = listI.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.bumptech.glide.load.n.n.a<?> aVarB = ((com.bumptech.glide.load.n.n) listI.get(i2)).b(this.f9105d, this.f9106e, this.f9107f, this.f9110i);
                if (aVarB != null) {
                    this.a.add(aVarB);
                }
            }
        }
        return this.a;
    }

    <Data> s<Data, ?, Transcode> h(Class<Data> cls) {
        return this.f9104c.h().h(cls, this.f9108g, this.f9112k);
    }

    Class<?> i() {
        return this.f9105d.getClass();
    }

    List<com.bumptech.glide.load.n.n<File, ?>> j(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f9104c.h().i(file);
    }

    com.bumptech.glide.load.i k() {
        return this.f9110i;
    }

    com.bumptech.glide.g l() {
        return this.o;
    }

    List<Class<?>> m() {
        return this.f9104c.h().j(this.f9105d.getClass(), this.f9108g, this.f9112k);
    }

    <Z> com.bumptech.glide.load.k<Z> n(u<Z> uVar) {
        return this.f9104c.h().k(uVar);
    }

    com.bumptech.glide.load.f o() {
        return this.n;
    }

    <X> com.bumptech.glide.load.d<X> p(X x) throws Registry.NoSourceEncoderAvailableException {
        return this.f9104c.h().m(x);
    }

    Class<?> q() {
        return this.f9112k;
    }

    <Z> com.bumptech.glide.load.l<Z> r(Class<Z> cls) {
        com.bumptech.glide.load.l<Z> lVar = (com.bumptech.glide.load.l) this.f9111j.get(cls);
        if (lVar == null) {
            for (Map.Entry<Class<?>, com.bumptech.glide.load.l<?>> entry : this.f9111j.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    lVar = (com.bumptech.glide.load.l) entry.getValue();
                    break;
                }
            }
        }
        if (lVar != null) {
            return lVar;
        }
        if (!this.f9111j.isEmpty() || !this.q) {
            return com.bumptech.glide.load.o.b.a();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    int s() {
        return this.f9106e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean t(Class<?> cls) {
        return h(cls) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    <R> void u(com.bumptech.glide.e eVar, Object obj, com.bumptech.glide.load.f fVar, int i2, int i3, j jVar, Class<?> cls, Class<R> cls2, com.bumptech.glide.g gVar, com.bumptech.glide.load.i iVar, Map<Class<?>, com.bumptech.glide.load.l<?>> map, boolean z, boolean z2, h.e eVar2) {
        this.f9104c = eVar;
        this.f9105d = obj;
        this.n = fVar;
        this.f9106e = i2;
        this.f9107f = i3;
        this.p = jVar;
        this.f9108g = cls;
        this.f9109h = eVar2;
        this.f9112k = cls2;
        this.o = gVar;
        this.f9110i = iVar;
        this.f9111j = map;
        this.q = z;
        this.r = z2;
    }

    boolean v(u<?> uVar) {
        return this.f9104c.h().n(uVar);
    }

    boolean w() {
        return this.r;
    }

    boolean x(com.bumptech.glide.load.f fVar) {
        List<com.bumptech.glide.load.n.n.a<?>> listG = g();
        int size = listG.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (listG.get(i2).a.equals(fVar)) {
                return true;
            }
        }
        return false;
    }
}
