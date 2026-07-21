package com.bumptech.glide.load.engine;

import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: ResourceCacheGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class v implements f, com.bumptech.glide.load.m.d.a<Object> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final f.a f9198f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final g<?> f9199g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f9200h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f9201i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.bumptech.glide.load.f f9202j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<com.bumptech.glide.load.n.n<File, ?>> f9203k;
    private int l;
    private volatile com.bumptech.glide.load.n.n.a<?> m;
    private File n;
    private w o;

    v(g<?> gVar, f.a aVar) {
        this.f9199g = gVar;
        this.f9198f = aVar;
    }

    private boolean b() {
        return this.l < this.f9203k.size();
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean a() {
        List<com.bumptech.glide.load.f> listC = this.f9199g.c();
        boolean z = false;
        if (listC.isEmpty()) {
            return false;
        }
        List<Class<?>> listM = this.f9199g.m();
        if (listM.isEmpty()) {
            if (File.class.equals(this.f9199g.q())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f9199g.i() + " to " + this.f9199g.q());
        }
        while (true) {
            if (this.f9203k != null && b()) {
                this.m = null;
                while (!z && b()) {
                    List<com.bumptech.glide.load.n.n<File, ?>> list = this.f9203k;
                    int i2 = this.l;
                    this.l = i2 + 1;
                    this.m = list.get(i2).b(this.n, this.f9199g.s(), this.f9199g.f(), this.f9199g.k());
                    if (this.m != null && this.f9199g.t(this.m.f9326c.a())) {
                        this.m.f9326c.e(this.f9199g.l(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i3 = this.f9201i + 1;
            this.f9201i = i3;
            if (i3 >= listM.size()) {
                int i4 = this.f9200h + 1;
                this.f9200h = i4;
                if (i4 >= listC.size()) {
                    return false;
                }
                this.f9201i = 0;
            }
            com.bumptech.glide.load.f fVar = listC.get(this.f9200h);
            Class<?> cls = listM.get(this.f9201i);
            this.o = new w(this.f9199g.b(), fVar, this.f9199g.o(), this.f9199g.s(), this.f9199g.f(), this.f9199g.r(cls), cls, this.f9199g.k());
            File fileB = this.f9199g.d().b(this.o);
            this.n = fileB;
            if (fileB != null) {
                this.f9202j = fVar;
                this.f9203k = this.f9199g.j(fileB);
                this.l = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.m.d.a
    public void c(Exception exc) {
        this.f9198f.g(this.o, exc, this.m.f9326c, com.bumptech.glide.load.a.RESOURCE_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.f
    public void cancel() {
        com.bumptech.glide.load.n.n.a<?> aVar = this.m;
        if (aVar != null) {
            aVar.f9326c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.m.d.a
    public void f(Object obj) {
        this.f9198f.q(this.f9202j, obj, this.m.f9326c, com.bumptech.glide.load.a.RESOURCE_DISK_CACHE, this.o);
    }
}
