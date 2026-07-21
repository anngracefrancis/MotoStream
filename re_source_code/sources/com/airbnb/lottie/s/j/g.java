package com.airbnb.lottie.s.j;

/* JADX INFO: compiled from: Mask.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.h f8744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.d f8745c;

    /* JADX INFO: compiled from: Mask.java */
    public enum a {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public g(a aVar, com.airbnb.lottie.s.i.h hVar, com.airbnb.lottie.s.i.d dVar) {
        this.a = aVar;
        this.f8744b = hVar;
        this.f8745c = dVar;
    }

    public a a() {
        return this.a;
    }

    public com.airbnb.lottie.s.i.h b() {
        return this.f8744b;
    }

    public com.airbnb.lottie.s.i.d c() {
        return this.f8745c;
    }
}
