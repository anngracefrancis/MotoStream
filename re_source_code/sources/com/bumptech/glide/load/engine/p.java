package com.bumptech.glide.load.engine;

/* JADX INFO: compiled from: EngineResource.java */
/* JADX INFO: loaded from: classes.dex */
class p<Z> implements u<Z> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f9183f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f9184g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final u<Z> f9185h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f9186i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.bumptech.glide.load.f f9187j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f9188k;
    private boolean l;

    /* JADX INFO: compiled from: EngineResource.java */
    interface a {
        void d(com.bumptech.glide.load.f fVar, p<?> pVar);
    }

    p(u<Z> uVar, boolean z, boolean z2) {
        this.f9185h = (u) com.bumptech.glide.r.j.d(uVar);
        this.f9183f = z;
        this.f9184g = z2;
    }

    synchronized void a() {
        if (this.l) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f9188k++;
    }

    u<Z> b() {
        return this.f9185h;
    }

    @Override // com.bumptech.glide.load.engine.u
    public synchronized void c() {
        if (this.f9188k > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.l) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.l = true;
        if (this.f9184g) {
            this.f9185h.c();
        }
    }

    @Override // com.bumptech.glide.load.engine.u
    public int d() {
        return this.f9185h.d();
    }

    @Override // com.bumptech.glide.load.engine.u
    public Class<Z> e() {
        return this.f9185h.e();
    }

    boolean f() {
        return this.f9183f;
    }

    void g() {
        synchronized (this.f9186i) {
            synchronized (this) {
                int i2 = this.f9188k;
                if (i2 <= 0) {
                    throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
                }
                int i3 = i2 - 1;
                this.f9188k = i3;
                if (i3 == 0) {
                    this.f9186i.d(this.f9187j, this);
                }
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.u
    public Z get() {
        return this.f9185h.get();
    }

    synchronized void h(com.bumptech.glide.load.f fVar, a aVar) {
        this.f9187j = fVar;
        this.f9186i = aVar;
    }

    public synchronized String toString() {
        return "EngineResource{isCacheable=" + this.f9183f + ", listener=" + this.f9186i + ", key=" + this.f9187j + ", acquired=" + this.f9188k + ", isRecycled=" + this.l + ", resource=" + this.f9185h + '}';
    }
}
