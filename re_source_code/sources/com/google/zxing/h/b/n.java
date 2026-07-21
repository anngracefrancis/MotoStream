package com.google.zxing.h.b;

/* JADX INFO: compiled from: X12Encoder.java */
/* JADX INFO: loaded from: classes2.dex */
final class n extends c {
    n() {
    }

    @Override // com.google.zxing.h.b.c, com.google.zxing.h.b.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (hVar.i()) {
            char c2 = hVar.c();
            hVar.f20358f++;
            c(c2, sb);
            if (sb.length() % 3 == 0) {
                c.g(hVar, sb);
                if (j.n(hVar.d(), hVar.f20358f, e()) != e()) {
                    hVar.o(0);
                    break;
                }
            }
        }
        f(hVar, sb);
    }

    @Override // com.google.zxing.h.b.c
    int c(char c2, StringBuilder sb) {
        if (c2 == '\r') {
            sb.append((char) 0);
        } else if (c2 == ' ') {
            sb.append((char) 3);
        } else if (c2 == '*') {
            sb.append((char) 1);
        } else if (c2 == '>') {
            sb.append((char) 2);
        } else if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
        } else if (c2 < 'A' || c2 > 'Z') {
            j.e(c2);
        } else {
            sb.append((char) ((c2 - 'A') + 14));
        }
        return 1;
    }

    @Override // com.google.zxing.h.b.c
    public int e() {
        return 3;
    }

    @Override // com.google.zxing.h.b.c
    void f(h hVar, StringBuilder sb) {
        hVar.p();
        int iA = hVar.g().a() - hVar.a();
        hVar.f20358f -= sb.length();
        if (hVar.f() > 1 || iA > 1 || hVar.f() != iA) {
            hVar.r((char) 254);
        }
        if (hVar.e() < 0) {
            hVar.o(0);
        }
    }
}
