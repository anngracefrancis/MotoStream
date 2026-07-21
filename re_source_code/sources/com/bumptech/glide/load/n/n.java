package com.bumptech.glide.load.n;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: ModelLoader.java */
/* JADX INFO: loaded from: classes.dex */
public interface n<Model, Data> {

    /* JADX INFO: compiled from: ModelLoader.java */
    public static class a<Data> {
        public final com.bumptech.glide.load.f a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<com.bumptech.glide.load.f> f9325b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bumptech.glide.load.m.d<Data> f9326c;

        public a(com.bumptech.glide.load.f fVar, com.bumptech.glide.load.m.d<Data> dVar) {
            this(fVar, Collections.emptyList(), dVar);
        }

        public a(com.bumptech.glide.load.f fVar, List<com.bumptech.glide.load.f> list, com.bumptech.glide.load.m.d<Data> dVar) {
            this.a = (com.bumptech.glide.load.f) com.bumptech.glide.r.j.d(fVar);
            this.f9325b = (List) com.bumptech.glide.r.j.d(list);
            this.f9326c = (com.bumptech.glide.load.m.d) com.bumptech.glide.r.j.d(dVar);
        }
    }

    boolean a(Model model);

    a<Data> b(Model model, int i2, int i3, com.bumptech.glide.load.i iVar);
}
