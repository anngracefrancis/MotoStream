package com.airbnb.lottie.s.j;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: ShapeGroup.java */
/* JADX INFO: loaded from: classes.dex */
public class n implements b {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<b> f8781b;

    public n(String str, List<b> list) {
        this.a = str;
        this.f8781b = list;
    }

    @Override // com.airbnb.lottie.s.j.b
    public com.airbnb.lottie.q.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar) {
        return new com.airbnb.lottie.q.a.c(fVar, aVar, this);
    }

    public List<b> b() {
        return this.f8781b;
    }

    public String c() {
        return this.a;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.a + "' Shapes: " + Arrays.toString(this.f8781b.toArray()) + '}';
    }
}
