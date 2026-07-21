package com.google.zxing.h.b;

import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: EncoderContext.java */
/* JADX INFO: loaded from: classes2.dex */
final class h {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private l f20354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.google.zxing.b f20355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.google.zxing.b f20356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final StringBuilder f20357e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f20358f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f20359g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private k f20360h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f20361i;

    h(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i2 = 0; i2 < length; i2++) {
            char c2 = (char) (bytes[i2] & 255);
            if (c2 == '?' && str.charAt(i2) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c2);
        }
        this.a = sb.toString();
        this.f20354b = l.FORCE_NONE;
        this.f20357e = new StringBuilder(str.length());
        this.f20359g = -1;
    }

    private int h() {
        return this.a.length() - this.f20361i;
    }

    public int a() {
        return this.f20357e.length();
    }

    public StringBuilder b() {
        return this.f20357e;
    }

    public char c() {
        return this.a.charAt(this.f20358f);
    }

    public String d() {
        return this.a;
    }

    public int e() {
        return this.f20359g;
    }

    public int f() {
        return h() - this.f20358f;
    }

    public k g() {
        return this.f20360h;
    }

    public boolean i() {
        return this.f20358f < h();
    }

    public void j() {
        this.f20359g = -1;
    }

    public void k() {
        this.f20360h = null;
    }

    public void l(com.google.zxing.b bVar, com.google.zxing.b bVar2) {
        this.f20355c = bVar;
        this.f20356d = bVar2;
    }

    public void m(int i2) {
        this.f20361i = i2;
    }

    public void n(l lVar) {
        this.f20354b = lVar;
    }

    public void o(int i2) {
        this.f20359g = i2;
    }

    public void p() {
        q(a());
    }

    public void q(int i2) {
        k kVar = this.f20360h;
        if (kVar == null || i2 > kVar.a()) {
            this.f20360h = k.l(i2, this.f20354b, this.f20355c, this.f20356d, true);
        }
    }

    public void r(char c2) {
        this.f20357e.append(c2);
    }

    public void s(String str) {
        this.f20357e.append(str);
    }
}
