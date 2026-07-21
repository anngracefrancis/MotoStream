package com.google.zxing.f.b;

/* JADX INFO: compiled from: Token.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class g {
    static final g a = new e(null, 0, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f20338b;

    g(g gVar) {
        this.f20338b = gVar;
    }

    final g a(int i2, int i3) {
        return new e(this, i2, i3);
    }

    final g b(int i2, int i3) {
        return new b(this, i2, i3);
    }

    abstract void c(com.google.zxing.g.a aVar, byte[] bArr);

    final g d() {
        return this.f20338b;
    }
}
