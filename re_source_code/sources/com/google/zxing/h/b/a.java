package com.google.zxing.h.b;

/* JADX INFO: compiled from: ASCIIEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
final class a implements g {
    a() {
    }

    private static char b(char c2, char c3) {
        if (j.f(c2) && j.f(c3)) {
            return (char) (((c2 - '0') * 10) + (c3 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c2 + c3);
    }

    @Override // com.google.zxing.h.b.g
    public void a(h hVar) {
        if (j.a(hVar.d(), hVar.f20358f) >= 2) {
            hVar.r(b(hVar.d().charAt(hVar.f20358f), hVar.d().charAt(hVar.f20358f + 1)));
            hVar.f20358f += 2;
            return;
        }
        char c2 = hVar.c();
        int iN = j.n(hVar.d(), hVar.f20358f, c());
        if (iN == c()) {
            if (!j.g(c2)) {
                hVar.r((char) (c2 + 1));
                hVar.f20358f++;
                return;
            } else {
                hVar.r((char) 235);
                hVar.r((char) ((c2 - 128) + 1));
                hVar.f20358f++;
                return;
            }
        }
        if (iN == 1) {
            hVar.r((char) 230);
            hVar.o(1);
            return;
        }
        if (iN == 2) {
            hVar.r((char) 239);
            hVar.o(2);
            return;
        }
        if (iN == 3) {
            hVar.r((char) 238);
            hVar.o(3);
        } else if (iN == 4) {
            hVar.r((char) 240);
            hVar.o(4);
        } else {
            if (iN != 5) {
                throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(iN)));
            }
            hVar.r((char) 231);
            hVar.o(5);
        }
    }

    public int c() {
        return 0;
    }
}
