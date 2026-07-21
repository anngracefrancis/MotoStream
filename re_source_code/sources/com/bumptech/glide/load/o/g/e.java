package com.bumptech.glide.load.o.g;

import com.bumptech.glide.load.engine.q;

/* JADX INFO: compiled from: GifDrawableResource.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends com.bumptech.glide.load.o.e.b<c> implements q {
    public e(c cVar) {
        super(cVar);
    }

    @Override // com.bumptech.glide.load.o.e.b, com.bumptech.glide.load.engine.q
    public void a() {
        ((c) this.f9410f).e().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.u
    public void c() {
        ((c) this.f9410f).stop();
        ((c) this.f9410f).k();
    }

    @Override // com.bumptech.glide.load.engine.u
    public int d() {
        return ((c) this.f9410f).i();
    }

    @Override // com.bumptech.glide.load.engine.u
    public Class<c> e() {
        return c.class;
    }
}
