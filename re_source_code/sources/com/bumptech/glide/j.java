package com.bumptech.glide;

import com.bumptech.glide.j;

/* JADX INFO: compiled from: TransitionOptions.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class j<CHILD extends j<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.bumptech.glide.p.m.e<? super TranscodeType> f8959f = com.bumptech.glide.p.m.c.c();

    private CHILD e() {
        return this;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    final com.bumptech.glide.p.m.e<? super TranscodeType> d() {
        return this.f8959f;
    }

    public final CHILD f(com.bumptech.glide.p.m.e<? super TranscodeType> eVar) {
        this.f8959f = (com.bumptech.glide.p.m.e) com.bumptech.glide.r.j.d(eVar);
        return (CHILD) e();
    }
}
