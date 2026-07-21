package com.airbnb.lottie.s;

/* JADX INFO: compiled from: LottieCompositionCache.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private static final g a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c.e.e<String, com.airbnb.lottie.d> f8707b = new c.e.e<>(10485760);

    g() {
    }

    public static g b() {
        return a;
    }

    public com.airbnb.lottie.d a(String str) {
        if (str == null) {
            return null;
        }
        return this.f8707b.c(str);
    }

    public void c(String str, com.airbnb.lottie.d dVar) {
        if (str == null) {
            return;
        }
        this.f8707b.d(str, dVar);
    }
}
