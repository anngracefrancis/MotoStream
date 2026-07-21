package com.google.zxing.k.c;

/* JADX INFO: compiled from: QRCode.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    private com.google.zxing.k.b.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.google.zxing.k.b.a f20448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.google.zxing.k.b.c f20449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f20450d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f20451e;

    public static boolean b(int i2) {
        return i2 >= 0 && i2 < 8;
    }

    public b a() {
        return this.f20451e;
    }

    public void c(com.google.zxing.k.b.a aVar) {
        this.f20448b = aVar;
    }

    public void d(int i2) {
        this.f20450d = i2;
    }

    public void e(b bVar) {
        this.f20451e = bVar;
    }

    public void f(com.google.zxing.k.b.b bVar) {
        this.a = bVar;
    }

    public void g(com.google.zxing.k.b.c cVar) {
        this.f20449c = cVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.a);
        sb.append("\n ecLevel: ");
        sb.append(this.f20448b);
        sb.append("\n version: ");
        sb.append(this.f20449c);
        sb.append("\n maskPattern: ");
        sb.append(this.f20450d);
        if (this.f20451e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f20451e);
        }
        sb.append(">>\n");
        return sb.toString();
    }
}
