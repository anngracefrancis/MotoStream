package com.bumptech.glide.load.engine;

import android.util.Log;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SourceGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class y implements f, com.bumptech.glide.load.m.d.a<Object>, f.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final g<?> f9214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final f.a f9215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f9216h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private c f9217i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Object f9218j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile com.bumptech.glide.load.n.n.a<?> f9219k;
    private d l;

    y(g<?> gVar, f.a aVar) {
        this.f9214f = gVar;
        this.f9215g = aVar;
    }

    private void b(Object obj) {
        long jB = com.bumptech.glide.r.f.b();
        try {
            com.bumptech.glide.load.d<X> dVarP = this.f9214f.p(obj);
            e eVar = new e(dVarP, obj, this.f9214f.k());
            this.l = new d(this.f9219k.a, this.f9214f.o());
            this.f9214f.d().a(this.l, eVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.l + ", data: " + obj + ", encoder: " + dVarP + ", duration: " + com.bumptech.glide.r.f.a(jB));
            }
            this.f9219k.f9326c.b();
            this.f9217i = new c(Collections.singletonList(this.f9219k.a), this.f9214f, this);
        } catch (Throwable th) {
            this.f9219k.f9326c.b();
            throw th;
        }
    }

    private boolean d() {
        return this.f9216h < this.f9214f.g().size();
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean a() {
        Object obj = this.f9218j;
        if (obj != null) {
            this.f9218j = null;
            b(obj);
        }
        c cVar = this.f9217i;
        if (cVar != null && cVar.a()) {
            return true;
        }
        this.f9217i = null;
        this.f9219k = null;
        boolean z = false;
        while (!z && d()) {
            List<com.bumptech.glide.load.n.n.a<?>> listG = this.f9214f.g();
            int i2 = this.f9216h;
            this.f9216h = i2 + 1;
            this.f9219k = listG.get(i2);
            if (this.f9219k != null && (this.f9214f.e().c(this.f9219k.f9326c.d()) || this.f9214f.t(this.f9219k.f9326c.a()))) {
                this.f9219k.f9326c.e(this.f9214f.l(), this);
                z = true;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.load.m.d.a
    public void c(Exception exc) {
        this.f9215g.g(this.l, exc, this.f9219k.f9326c, this.f9219k.f9326c.d());
    }

    @Override // com.bumptech.glide.load.engine.f
    public void cancel() {
        com.bumptech.glide.load.n.n.a<?> aVar = this.f9219k;
        if (aVar != null) {
            aVar.f9326c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.m.d.a
    public void f(Object obj) {
        j jVarE = this.f9214f.e();
        if (obj == null || !jVarE.c(this.f9219k.f9326c.d())) {
            this.f9215g.q(this.f9219k.a, obj, this.f9219k.f9326c, this.f9219k.f9326c.d(), this.l);
        } else {
            this.f9218j = obj;
            this.f9215g.k();
        }
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void g(com.bumptech.glide.load.f fVar, Exception exc, com.bumptech.glide.load.m.d<?> dVar, com.bumptech.glide.load.a aVar) {
        this.f9215g.g(fVar, exc, dVar, this.f9219k.f9326c.d());
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void k() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void q(com.bumptech.glide.load.f fVar, Object obj, com.bumptech.glide.load.m.d<?> dVar, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.f fVar2) {
        this.f9215g.q(fVar, obj, dVar, this.f9219k.f9326c.d(), fVar);
    }
}
