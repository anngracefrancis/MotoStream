package com.bumptech.glide.load.engine.a0;

import android.annotation.SuppressLint;
import com.bumptech.glide.load.engine.u;

/* JADX INFO: compiled from: LruResourceCache.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends com.bumptech.glide.r.g<com.bumptech.glide.load.f, u<?>> implements h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private h.a f9064e;

    public g(long j2) {
        super(j2);
    }

    @Override // com.bumptech.glide.load.engine.a0.h
    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        if (i2 >= 40) {
            b();
        } else if (i2 >= 20 || i2 == 15) {
            m(h() / 2);
        }
    }

    @Override // com.bumptech.glide.load.engine.a0.h
    public /* bridge */ /* synthetic */ u c(com.bumptech.glide.load.f fVar, u uVar) {
        return (u) super.k(fVar, uVar);
    }

    @Override // com.bumptech.glide.load.engine.a0.h
    public /* bridge */ /* synthetic */ u d(com.bumptech.glide.load.f fVar) {
        return (u) super.l(fVar);
    }

    @Override // com.bumptech.glide.load.engine.a0.h
    public void e(h.a aVar) {
        this.f9064e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.r.g
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int i(u<?> uVar) {
        return uVar == null ? super.i(null) : uVar.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.r.g
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(com.bumptech.glide.load.f fVar, u<?> uVar) {
        h.a aVar = this.f9064e;
        if (aVar == null || uVar == null) {
            return;
        }
        aVar.a(uVar);
    }
}
