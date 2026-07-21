package com.google.zxing.h.b;

/* JADX INFO: compiled from: C40Encoder.java */
/* JADX INFO: loaded from: classes2.dex */
class c implements g {
    c() {
    }

    private int b(h hVar, StringBuilder sb, StringBuilder sb2, int i2) {
        int length = sb.length();
        sb.delete(length - i2, length);
        hVar.f20358f--;
        int iC = c(hVar.c(), sb2);
        hVar.k();
        return iC;
    }

    private static String d(CharSequence charSequence, int i2) {
        int iCharAt = (charSequence.charAt(i2) * 1600) + (charSequence.charAt(i2 + 1) * '(') + charSequence.charAt(i2 + 2) + 1;
        return new String(new char[]{(char) (iCharAt / 256), (char) (iCharAt % 256)});
    }

    static void g(h hVar, StringBuilder sb) {
        hVar.s(d(sb, 0));
        sb.delete(0, 3);
    }

    @Override // com.google.zxing.h.b.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (hVar.i()) {
            char c2 = hVar.c();
            hVar.f20358f++;
            int iC = c(c2, sb);
            int iA = hVar.a() + ((sb.length() / 3) << 1);
            hVar.q(iA);
            int iA2 = hVar.g().a() - iA;
            if (!hVar.i()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (iA2 < 2 || iA2 > 2)) {
                    iC = b(hVar, sb, sb2, iC);
                }
                while (sb.length() % 3 == 1 && ((iC <= 3 && iA2 != 1) || iC > 3)) {
                    iC = b(hVar, sb, sb2, iC);
                }
                break;
            }
            if (sb.length() % 3 == 0 && j.n(hVar.d(), hVar.f20358f, e()) != e()) {
                hVar.o(0);
                break;
            }
        }
        f(hVar, sb);
    }

    int c(char c2, StringBuilder sb) {
        if (c2 == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
            return 1;
        }
        if (c2 >= 'A' && c2 <= 'Z') {
            sb.append((char) ((c2 - 'A') + 14));
            return 1;
        }
        if (c2 < ' ') {
            sb.append((char) 0);
            sb.append(c2);
            return 2;
        }
        if (c2 >= '!' && c2 <= '/') {
            sb.append((char) 1);
            sb.append((char) (c2 - '!'));
            return 2;
        }
        if (c2 >= ':' && c2 <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c2 - ':') + 15));
            return 2;
        }
        if (c2 >= '[' && c2 <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c2 - '[') + 22));
            return 2;
        }
        if (c2 < '`' || c2 > 127) {
            sb.append("\u0001\u001e");
            return c((char) (c2 - 128), sb) + 2;
        }
        sb.append((char) 2);
        sb.append((char) (c2 - '`'));
        return 2;
    }

    public int e() {
        return 1;
    }

    void f(h hVar, StringBuilder sb) {
        int length = (sb.length() / 3) << 1;
        int length2 = sb.length() % 3;
        int iA = hVar.a() + length;
        hVar.q(iA);
        int iA2 = hVar.g().a() - iA;
        if (length2 == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                g(hVar, sb);
            }
            if (hVar.i()) {
                hVar.r((char) 254);
            }
        } else if (iA2 == 1 && length2 == 1) {
            while (sb.length() >= 3) {
                g(hVar, sb);
            }
            if (hVar.i()) {
                hVar.r((char) 254);
            }
            hVar.f20358f--;
        } else {
            if (length2 != 0) {
                throw new IllegalStateException("Unexpected case. Please report!");
            }
            while (sb.length() >= 3) {
                g(hVar, sb);
            }
            if (iA2 > 0 || hVar.i()) {
                hVar.r((char) 254);
            }
        }
        hVar.o(0);
    }
}
