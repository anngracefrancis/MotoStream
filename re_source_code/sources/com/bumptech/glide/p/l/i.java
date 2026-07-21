package com.bumptech.glide.p.l;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: Target.java */
/* JADX INFO: loaded from: classes.dex */
public interface i<R> extends com.bumptech.glide.m.i {
    com.bumptech.glide.p.d getRequest();

    void getSize(h hVar);

    void onLoadCleared(Drawable drawable);

    void onLoadFailed(Drawable drawable);

    void onLoadStarted(Drawable drawable);

    void onResourceReady(R r, com.bumptech.glide.p.m.d<? super R> dVar);

    void removeCallback(h hVar);

    void setRequest(com.bumptech.glide.p.d dVar);
}
