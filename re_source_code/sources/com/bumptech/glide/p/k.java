package com.bumptech.glide.p;

/* JADX INFO: compiled from: ThumbnailRequestCoordinator.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements e, d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e f9511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d f9512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d f9513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f9514i;

    k() {
        this(null);
    }

    private boolean n() {
        e eVar = this.f9511f;
        return eVar == null || eVar.m(this);
    }

    private boolean o() {
        e eVar = this.f9511f;
        return eVar == null || eVar.g(this);
    }

    private boolean p() {
        e eVar = this.f9511f;
        return eVar == null || eVar.j(this);
    }

    private boolean q() {
        e eVar = this.f9511f;
        return eVar != null && eVar.b();
    }

    @Override // com.bumptech.glide.p.e
    public void a(d dVar) {
        e eVar;
        if (dVar.equals(this.f9512g) && (eVar = this.f9511f) != null) {
            eVar.a(this);
        }
    }

    @Override // com.bumptech.glide.p.e
    public boolean b() {
        return q() || f();
    }

    @Override // com.bumptech.glide.p.d
    public void c() {
        this.f9512g.c();
        this.f9513h.c();
    }

    @Override // com.bumptech.glide.p.d
    public void clear() {
        this.f9514i = false;
        this.f9513h.clear();
        this.f9512g.clear();
    }

    @Override // com.bumptech.glide.p.d
    public void d() {
        this.f9514i = true;
        if (!this.f9512g.l() && !this.f9513h.isRunning()) {
            this.f9513h.d();
        }
        if (!this.f9514i || this.f9512g.isRunning()) {
            return;
        }
        this.f9512g.d();
    }

    @Override // com.bumptech.glide.p.d
    public boolean e(d dVar) {
        if (!(dVar instanceof k)) {
            return false;
        }
        k kVar = (k) dVar;
        d dVar2 = this.f9512g;
        if (dVar2 == null) {
            if (kVar.f9512g != null) {
                return false;
            }
        } else if (!dVar2.e(kVar.f9512g)) {
            return false;
        }
        d dVar3 = this.f9513h;
        d dVar4 = kVar.f9513h;
        if (dVar3 == null) {
            if (dVar4 != null) {
                return false;
            }
        } else if (!dVar3.e(dVar4)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.p.d
    public boolean f() {
        return this.f9512g.f() || this.f9513h.f();
    }

    @Override // com.bumptech.glide.p.e
    public boolean g(d dVar) {
        return o() && dVar.equals(this.f9512g) && !b();
    }

    @Override // com.bumptech.glide.p.d
    public boolean h() {
        return this.f9512g.h();
    }

    @Override // com.bumptech.glide.p.d
    public boolean i() {
        return this.f9512g.i();
    }

    @Override // com.bumptech.glide.p.d
    public boolean isRunning() {
        return this.f9512g.isRunning();
    }

    @Override // com.bumptech.glide.p.e
    public boolean j(d dVar) {
        return p() && (dVar.equals(this.f9512g) || !this.f9512g.f());
    }

    @Override // com.bumptech.glide.p.e
    public void k(d dVar) {
        if (dVar.equals(this.f9513h)) {
            return;
        }
        e eVar = this.f9511f;
        if (eVar != null) {
            eVar.k(this);
        }
        if (this.f9513h.l()) {
            return;
        }
        this.f9513h.clear();
    }

    @Override // com.bumptech.glide.p.d
    public boolean l() {
        return this.f9512g.l() || this.f9513h.l();
    }

    @Override // com.bumptech.glide.p.e
    public boolean m(d dVar) {
        return n() && dVar.equals(this.f9512g);
    }

    public void r(d dVar, d dVar2) {
        this.f9512g = dVar;
        this.f9513h = dVar2;
    }

    public k(e eVar) {
        this.f9511f = eVar;
    }
}
