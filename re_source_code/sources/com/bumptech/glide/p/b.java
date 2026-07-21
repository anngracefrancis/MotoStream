package com.bumptech.glide.p;

/* JADX INFO: compiled from: ErrorRequestCoordinator.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements e, d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e f9490f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d f9491g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d f9492h;

    public b(e eVar) {
        this.f9490f = eVar;
    }

    private boolean n(d dVar) {
        return dVar.equals(this.f9491g) || (this.f9491g.h() && dVar.equals(this.f9492h));
    }

    private boolean o() {
        e eVar = this.f9490f;
        return eVar == null || eVar.m(this);
    }

    private boolean p() {
        e eVar = this.f9490f;
        return eVar == null || eVar.g(this);
    }

    private boolean q() {
        e eVar = this.f9490f;
        return eVar == null || eVar.j(this);
    }

    private boolean r() {
        e eVar = this.f9490f;
        return eVar != null && eVar.b();
    }

    @Override // com.bumptech.glide.p.e
    public void a(d dVar) {
        if (!dVar.equals(this.f9492h)) {
            if (this.f9492h.isRunning()) {
                return;
            }
            this.f9492h.d();
        } else {
            e eVar = this.f9490f;
            if (eVar != null) {
                eVar.a(this);
            }
        }
    }

    @Override // com.bumptech.glide.p.e
    public boolean b() {
        return r() || f();
    }

    @Override // com.bumptech.glide.p.d
    public void c() {
        this.f9491g.c();
        this.f9492h.c();
    }

    @Override // com.bumptech.glide.p.d
    public void clear() {
        this.f9491g.clear();
        if (this.f9492h.isRunning()) {
            this.f9492h.clear();
        }
    }

    @Override // com.bumptech.glide.p.d
    public void d() {
        if (this.f9491g.isRunning()) {
            return;
        }
        this.f9491g.d();
    }

    @Override // com.bumptech.glide.p.d
    public boolean e(d dVar) {
        if (!(dVar instanceof b)) {
            return false;
        }
        b bVar = (b) dVar;
        return this.f9491g.e(bVar.f9491g) && this.f9492h.e(bVar.f9492h);
    }

    @Override // com.bumptech.glide.p.d
    public boolean f() {
        return (this.f9491g.h() ? this.f9492h : this.f9491g).f();
    }

    @Override // com.bumptech.glide.p.e
    public boolean g(d dVar) {
        return p() && n(dVar);
    }

    @Override // com.bumptech.glide.p.d
    public boolean h() {
        return this.f9491g.h() && this.f9492h.h();
    }

    @Override // com.bumptech.glide.p.d
    public boolean i() {
        return (this.f9491g.h() ? this.f9492h : this.f9491g).i();
    }

    @Override // com.bumptech.glide.p.d
    public boolean isRunning() {
        return (this.f9491g.h() ? this.f9492h : this.f9491g).isRunning();
    }

    @Override // com.bumptech.glide.p.e
    public boolean j(d dVar) {
        return q() && n(dVar);
    }

    @Override // com.bumptech.glide.p.e
    public void k(d dVar) {
        e eVar = this.f9490f;
        if (eVar != null) {
            eVar.k(this);
        }
    }

    @Override // com.bumptech.glide.p.d
    public boolean l() {
        return (this.f9491g.h() ? this.f9492h : this.f9491g).l();
    }

    @Override // com.bumptech.glide.p.e
    public boolean m(d dVar) {
        return o() && n(dVar);
    }

    public void s(d dVar, d dVar2) {
        this.f9491g = dVar;
        this.f9492h = dVar2;
    }
}
