package com.bumptech.glide.p.m;

/* JADX INFO: compiled from: NoTransition.java */
/* JADX INFO: loaded from: classes.dex */
public class c<R> implements d<R> {
    static final c<?> a = new c<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e<?> f9536b = new a();

    /* JADX INFO: compiled from: NoTransition.java */
    public static class a<R> implements e<R> {
        @Override // com.bumptech.glide.p.m.e
        public d<R> a(com.bumptech.glide.load.a aVar, boolean z) {
            return c.a;
        }
    }

    public static <R> d<R> b() {
        return a;
    }

    public static <R> e<R> c() {
        return (e<R>) f9536b;
    }

    @Override // com.bumptech.glide.p.m.d
    public boolean a(Object obj, d.a aVar) {
        return false;
    }
}
