package com.google.zxing.f.b;

/* JADX INFO: compiled from: BinaryShiftToken.java */
/* JADX INFO: loaded from: classes2.dex */
final class b extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final short f20325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final short f20326d;

    b(g gVar, int i2, int i3) {
        super(gVar);
        this.f20325c = (short) i2;
        this.f20326d = (short) i3;
    }

    @Override // com.google.zxing.f.b.g
    public void c(com.google.zxing.g.a aVar, byte[] bArr) {
        int i2 = 0;
        while (true) {
            short s = this.f20326d;
            if (i2 >= s) {
                return;
            }
            if (i2 == 0 || (i2 == 31 && s <= 62)) {
                aVar.e(31, 5);
                short s2 = this.f20326d;
                if (s2 > 62) {
                    aVar.e(s2 - 31, 16);
                } else if (i2 == 0) {
                    aVar.e(Math.min((int) s2, 31), 5);
                } else {
                    aVar.e(s2 - 31, 5);
                }
            }
            aVar.e(bArr[this.f20325c + i2], 8);
            i2++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append((int) this.f20325c);
        sb.append("::");
        sb.append((this.f20325c + this.f20326d) - 1);
        sb.append('>');
        return sb.toString();
    }
}
