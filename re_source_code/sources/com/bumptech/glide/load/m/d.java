package com.bumptech.glide.load.m;

/* JADX INFO: compiled from: DataFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public interface d<T> {

    /* JADX INFO: compiled from: DataFetcher.java */
    public interface a<T> {
        void c(Exception exc);

        void f(T t);
    }

    Class<T> a();

    void b();

    void cancel();

    com.bumptech.glide.load.a d();

    void e(com.bumptech.glide.g gVar, a<? super T> aVar);
}
