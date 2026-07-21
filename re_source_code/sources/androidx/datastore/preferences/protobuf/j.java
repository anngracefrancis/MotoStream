package androidx.datastore.preferences.protobuf;

import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: CodedInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    k f1336d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1337e;

    /* JADX INFO: compiled from: CodedInputStream.java */
    private static final class b extends j {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final byte[] f1338f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f1339g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f1340h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f1341i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f1342j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f1343k;
        private int l;
        private boolean m;
        private int n;

        private void M() {
            int i2 = this.f1340h + this.f1341i;
            this.f1340h = i2;
            int i3 = i2 - this.f1343k;
            int i4 = this.n;
            if (i3 <= i4) {
                this.f1341i = 0;
                return;
            }
            int i5 = i3 - i4;
            this.f1341i = i5;
            this.f1340h = i2 - i5;
        }

        private void P() throws IOException {
            if (this.f1340h - this.f1342j >= 10) {
                Q();
            } else {
                R();
            }
        }

        private void Q() throws IOException {
            for (int i2 = 0; i2 < 10; i2++) {
                byte[] bArr = this.f1338f;
                int i3 = this.f1342j;
                this.f1342j = i3 + 1;
                if (bArr[i3] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        private void R() throws IOException {
            for (int i2 = 0; i2 < 10; i2++) {
                if (F() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public String A() throws IOException {
            int iJ = J();
            if (iJ > 0) {
                int i2 = this.f1340h;
                int i3 = this.f1342j;
                if (iJ <= i2 - i3) {
                    String strE = q1.e(this.f1338f, i3, iJ);
                    this.f1342j += iJ;
                    return strE;
                }
            }
            if (iJ == 0) {
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
            if (iJ <= 0) {
                throw InvalidProtocolBufferException.f();
            }
            throw InvalidProtocolBufferException.k();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int B() throws IOException {
            if (e()) {
                this.l = 0;
                return 0;
            }
            int iJ = J();
            this.l = iJ;
            if (r1.a(iJ) != 0) {
                return this.l;
            }
            throw InvalidProtocolBufferException.b();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int C() throws IOException {
            return J();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public long D() throws IOException {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public boolean E(int i2) throws IOException {
            int iB = r1.b(i2);
            if (iB == 0) {
                P();
                return true;
            }
            if (iB == 1) {
                O(8);
                return true;
            }
            if (iB == 2) {
                O(J());
                return true;
            }
            if (iB == 3) {
                N();
                a(r1.c(r1.a(i2), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.d();
            }
            O(4);
            return true;
        }

        public byte F() throws IOException {
            int i2 = this.f1342j;
            if (i2 == this.f1340h) {
                throw InvalidProtocolBufferException.k();
            }
            byte[] bArr = this.f1338f;
            this.f1342j = i2 + 1;
            return bArr[i2];
        }

        public byte[] G(int i2) throws IOException {
            if (i2 > 0) {
                int i3 = this.f1340h;
                int i4 = this.f1342j;
                if (i2 <= i3 - i4) {
                    int i5 = i2 + i4;
                    this.f1342j = i5;
                    return Arrays.copyOfRange(this.f1338f, i4, i5);
                }
            }
            if (i2 > 0) {
                throw InvalidProtocolBufferException.k();
            }
            if (i2 == 0) {
                return a0.f1255c;
            }
            throw InvalidProtocolBufferException.f();
        }

        public int H() throws IOException {
            int i2 = this.f1342j;
            if (this.f1340h - i2 < 4) {
                throw InvalidProtocolBufferException.k();
            }
            byte[] bArr = this.f1338f;
            this.f1342j = i2 + 4;
            return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }

        public long I() throws IOException {
            int i2 = this.f1342j;
            if (this.f1340h - i2 < 8) {
                throw InvalidProtocolBufferException.k();
            }
            byte[] bArr = this.f1338f;
            this.f1342j = i2 + 8;
            return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
        
            if (r2[r3] < 0) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int J() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.f1342j
                int r1 = r5.f1340h
                if (r1 != r0) goto L7
                goto L6a
            L7:
                byte[] r2 = r5.f1338f
                int r3 = r0 + 1
                r0 = r2[r0]
                if (r0 < 0) goto L12
                r5.f1342j = r3
                return r0
            L12:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L18
                goto L6a
            L18:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L24
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L70
            L24:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L31
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L2f:
                r1 = r3
                goto L70
            L31:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L3f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L70
            L3f:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L70
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L70
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r2 = r2[r3]
                if (r2 >= 0) goto L70
            L6a:
                long r0 = r5.L()
                int r1 = (int) r0
                return r1
            L70:
                r5.f1342j = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.j.b.J():int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:40:0x00b4, code lost:
        
            if (r2[r0] < 0) goto L41;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long K() throws java.io.IOException {
            /*
                r11 = this;
                int r0 = r11.f1342j
                int r1 = r11.f1340h
                if (r1 != r0) goto L8
                goto Lb6
            L8:
                byte[] r2 = r11.f1338f
                int r3 = r0 + 1
                r0 = r2[r0]
                if (r0 < 0) goto L14
                r11.f1342j = r3
                long r0 = (long) r0
                return r0
            L14:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L1b
                goto Lb6
            L1b:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L29
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            L26:
                long r2 = (long) r0
                goto Lbd
            L29:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L3a
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
                long r0 = (long) r0
                r9 = r0
                r1 = r3
                r2 = r9
                goto Lbd
            L3a:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L48
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L26
            L48:
                long r3 = (long) r0
                int r0 = r1 + 1
                r1 = r2[r1]
                long r5 = (long) r1
                r1 = 28
                long r5 = r5 << r1
                long r3 = r3 ^ r5
                r5 = 0
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L5f
                r1 = 266354560(0xfe03f80, double:1.315966377E-315)
            L5b:
                long r1 = r1 ^ r3
                r2 = r1
                r1 = r0
                goto Lbd
            L5f:
                int r1 = r0 + 1
                r0 = r2[r0]
                long r7 = (long) r0
                r0 = 35
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L74
                r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
            L71:
                long r3 = r3 ^ r5
            L72:
                r2 = r3
                goto Lbd
            L74:
                int r0 = r1 + 1
                r1 = r2[r1]
                long r7 = (long) r1
                r1 = 42
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L87
                r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
                goto L5b
            L87:
                int r1 = r0 + 1
                r0 = r2[r0]
                long r7 = (long) r0
                r0 = 49
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L9a
                r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
                goto L71
            L9a:
                int r0 = r1 + 1
                r1 = r2[r1]
                long r7 = (long) r1
                r1 = 56
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 >= 0) goto Lbb
                int r1 = r0 + 1
                r0 = r2[r0]
                long r7 = (long) r0
                int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r0 >= 0) goto L72
            Lb6:
                long r0 = r11.L()
                return r0
            Lbb:
                r1 = r0
                goto L72
            Lbd:
                r11.f1342j = r1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.j.b.K():long");
        }

        long L() throws IOException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte bF = F();
                j2 |= ((long) (bF & 127)) << i2;
                if ((bF & 128) == 0) {
                    return j2;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        public void N() throws IOException {
            int iB;
            do {
                iB = B();
                if (iB == 0) {
                    return;
                }
            } while (E(iB));
        }

        public void O(int i2) throws IOException {
            if (i2 >= 0) {
                int i3 = this.f1340h;
                int i4 = this.f1342j;
                if (i2 <= i3 - i4) {
                    this.f1342j = i4 + i2;
                    return;
                }
            }
            if (i2 >= 0) {
                throw InvalidProtocolBufferException.k();
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public void a(int i2) throws InvalidProtocolBufferException {
            if (this.l != i2) {
                throw InvalidProtocolBufferException.a();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int d() {
            return this.f1342j - this.f1343k;
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public boolean e() throws IOException {
            return this.f1342j == this.f1340h;
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public void k(int i2) {
            this.n = i2;
            M();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int l(int i2) throws InvalidProtocolBufferException {
            if (i2 < 0) {
                throw InvalidProtocolBufferException.f();
            }
            int iD = i2 + d();
            int i3 = this.n;
            if (iD > i3) {
                throw InvalidProtocolBufferException.k();
            }
            this.n = iD;
            M();
            return i3;
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public boolean m() throws IOException {
            return K() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public h n() throws IOException {
            int iJ = J();
            if (iJ > 0) {
                int i2 = this.f1340h;
                int i3 = this.f1342j;
                if (iJ <= i2 - i3) {
                    h hVarG = (this.f1339g && this.m) ? h.G(this.f1338f, i3, iJ) : h.n(this.f1338f, i3, iJ);
                    this.f1342j += iJ;
                    return hVarG;
                }
            }
            return iJ == 0 ? h.f1298f : h.F(G(iJ));
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public double o() throws IOException {
            return Double.longBitsToDouble(I());
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int p() throws IOException {
            return J();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int q() throws IOException {
            return H();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public long r() throws IOException {
            return I();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public float s() throws IOException {
            return Float.intBitsToFloat(H());
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int t() throws IOException {
            return J();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public long u() throws IOException {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int v() throws IOException {
            return H();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public long w() throws IOException {
            return I();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int x() throws IOException {
            return j.b(J());
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public long y() throws IOException {
            return j.c(K());
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public String z() throws IOException {
            int iJ = J();
            if (iJ > 0 && iJ <= this.f1340h - this.f1342j) {
                String str = new String(this.f1338f, this.f1342j, iJ, a0.a);
                this.f1342j += iJ;
                return str;
            }
            if (iJ == 0) {
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
            if (iJ < 0) {
                throw InvalidProtocolBufferException.f();
            }
            throw InvalidProtocolBufferException.k();
        }

        private b(byte[] bArr, int i2, int i3, boolean z) {
            super();
            this.n = Integer.MAX_VALUE;
            this.f1338f = bArr;
            this.f1340h = i3 + i2;
            this.f1342j = i2;
            this.f1343k = i2;
            this.f1339g = z;
        }
    }

    /* JADX INFO: compiled from: CodedInputStream.java */
    private static final class c extends j {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final InputStream f1344f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final byte[] f1345g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f1346h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f1347i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f1348j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f1349k;
        private int l;
        private int m;
        private a n;

        /* JADX INFO: compiled from: CodedInputStream.java */
        private interface a {
            void a();
        }

        private h F(int i2) throws IOException {
            byte[] bArrI = I(i2);
            if (bArrI != null) {
                return h.i(bArrI);
            }
            int i3 = this.f1348j;
            int i4 = this.f1346h;
            int length = i4 - i3;
            this.l += i4;
            this.f1348j = 0;
            this.f1346h = 0;
            List<byte[]> listJ = J(i2 - length);
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f1345g, i3, bArr, 0, length);
            for (byte[] bArr2 : listJ) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return h.F(bArr);
        }

        private byte[] H(int i2, boolean z) throws IOException {
            byte[] bArrI = I(i2);
            if (bArrI != null) {
                return z ? (byte[]) bArrI.clone() : bArrI;
            }
            int i3 = this.f1348j;
            int i4 = this.f1346h;
            int length = i4 - i3;
            this.l += i4;
            this.f1348j = 0;
            this.f1346h = 0;
            List<byte[]> listJ = J(i2 - length);
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f1345g, i3, bArr, 0, length);
            for (byte[] bArr2 : listJ) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        private byte[] I(int i2) throws IOException {
            if (i2 == 0) {
                return a0.f1255c;
            }
            if (i2 < 0) {
                throw InvalidProtocolBufferException.f();
            }
            int i3 = this.l;
            int i4 = this.f1348j;
            int i5 = i3 + i4 + i2;
            if (i5 - this.f1335c > 0) {
                throw InvalidProtocolBufferException.j();
            }
            int i6 = this.m;
            if (i5 > i6) {
                S((i6 - i3) - i4);
                throw InvalidProtocolBufferException.k();
            }
            int i7 = this.f1346h - i4;
            int i8 = i2 - i7;
            if (i8 >= 4096 && i8 > this.f1344f.available()) {
                return null;
            }
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f1345g, this.f1348j, bArr, 0, i7);
            this.l += this.f1346h;
            this.f1348j = 0;
            this.f1346h = 0;
            while (i7 < i2) {
                int i9 = this.f1344f.read(bArr, i7, i2 - i7);
                if (i9 == -1) {
                    throw InvalidProtocolBufferException.k();
                }
                this.l += i9;
                i7 += i9;
            }
            return bArr;
        }

        private List<byte[]> J(int i2) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i2 > 0) {
                int iMin = Math.min(i2, RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT);
                byte[] bArr = new byte[iMin];
                int i3 = 0;
                while (i3 < iMin) {
                    int i4 = this.f1344f.read(bArr, i3, iMin - i3);
                    if (i4 == -1) {
                        throw InvalidProtocolBufferException.k();
                    }
                    this.l += i4;
                    i3 += i4;
                }
                i2 -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void P() {
            int i2 = this.f1346h + this.f1347i;
            this.f1346h = i2;
            int i3 = this.l + i2;
            int i4 = this.m;
            if (i3 <= i4) {
                this.f1347i = 0;
                return;
            }
            int i5 = i3 - i4;
            this.f1347i = i5;
            this.f1346h = i2 - i5;
        }

        private void Q(int i2) throws IOException {
            if (X(i2)) {
                return;
            }
            if (i2 <= (this.f1335c - this.l) - this.f1348j) {
                throw InvalidProtocolBufferException.k();
            }
            throw InvalidProtocolBufferException.j();
        }

        private void T(int i2) throws IOException {
            if (i2 < 0) {
                throw InvalidProtocolBufferException.f();
            }
            int i3 = this.l;
            int i4 = this.f1348j;
            int i5 = i3 + i4 + i2;
            int i6 = this.m;
            if (i5 > i6) {
                S((i6 - i3) - i4);
                throw InvalidProtocolBufferException.k();
            }
            int i7 = 0;
            if (this.n == null) {
                this.l = i3 + i4;
                int i8 = this.f1346h - i4;
                this.f1346h = 0;
                this.f1348j = 0;
                i7 = i8;
                while (i7 < i2) {
                    try {
                        long j2 = i2 - i7;
                        long jSkip = this.f1344f.skip(j2);
                        if (jSkip < 0 || jSkip > j2) {
                            throw new IllegalStateException(this.f1344f.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                        }
                        if (jSkip == 0) {
                            break;
                        } else {
                            i7 += (int) jSkip;
                        }
                    } finally {
                        this.l += i7;
                        P();
                    }
                }
            }
            if (i7 >= i2) {
                return;
            }
            int i9 = this.f1346h;
            int i10 = i9 - this.f1348j;
            this.f1348j = i9;
            Q(1);
            while (true) {
                int i11 = i2 - i10;
                int i12 = this.f1346h;
                if (i11 <= i12) {
                    this.f1348j = i11;
                    return;
                } else {
                    i10 += i12;
                    this.f1348j = i12;
                    Q(1);
                }
            }
        }

        private void U() throws IOException {
            if (this.f1346h - this.f1348j >= 10) {
                V();
            } else {
                W();
            }
        }

        private void V() throws IOException {
            for (int i2 = 0; i2 < 10; i2++) {
                byte[] bArr = this.f1345g;
                int i3 = this.f1348j;
                this.f1348j = i3 + 1;
                if (bArr[i3] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        private void W() throws IOException {
            for (int i2 = 0; i2 < 10; i2++) {
                if (G() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        private boolean X(int i2) throws IOException {
            int i3 = this.f1348j;
            if (i3 + i2 <= this.f1346h) {
                throw new IllegalStateException("refillBuffer() called when " + i2 + " bytes were already available in buffer");
            }
            int i4 = this.f1335c;
            int i5 = this.l;
            if (i2 > (i4 - i5) - i3 || i5 + i3 + i2 > this.m) {
                return false;
            }
            a aVar = this.n;
            if (aVar != null) {
                aVar.a();
            }
            int i6 = this.f1348j;
            if (i6 > 0) {
                int i7 = this.f1346h;
                if (i7 > i6) {
                    byte[] bArr = this.f1345g;
                    System.arraycopy(bArr, i6, bArr, 0, i7 - i6);
                }
                this.l += i6;
                this.f1346h -= i6;
                this.f1348j = 0;
            }
            InputStream inputStream = this.f1344f;
            byte[] bArr2 = this.f1345g;
            int i8 = this.f1346h;
            int i9 = inputStream.read(bArr2, i8, Math.min(bArr2.length - i8, (this.f1335c - this.l) - i8));
            if (i9 == 0 || i9 < -1 || i9 > this.f1345g.length) {
                throw new IllegalStateException(this.f1344f.getClass() + "#read(byte[]) returned invalid result: " + i9 + "\nThe InputStream implementation is buggy.");
            }
            if (i9 <= 0) {
                return false;
            }
            this.f1346h += i9;
            P();
            if (this.f1346h >= i2) {
                return true;
            }
            return X(i2);
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public String A() throws IOException {
            byte[] bArrH;
            int iM = M();
            int i2 = this.f1348j;
            int i3 = this.f1346h;
            if (iM <= i3 - i2 && iM > 0) {
                bArrH = this.f1345g;
                this.f1348j = i2 + iM;
            } else {
                if (iM == 0) {
                    return HttpUrl.FRAGMENT_ENCODE_SET;
                }
                if (iM <= i3) {
                    Q(iM);
                    bArrH = this.f1345g;
                    this.f1348j = iM + 0;
                } else {
                    bArrH = H(iM, false);
                }
                i2 = 0;
            }
            return q1.e(bArrH, i2, iM);
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int B() throws IOException {
            if (e()) {
                this.f1349k = 0;
                return 0;
            }
            int iM = M();
            this.f1349k = iM;
            if (r1.a(iM) != 0) {
                return this.f1349k;
            }
            throw InvalidProtocolBufferException.b();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int C() throws IOException {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public long D() throws IOException {
            return N();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public boolean E(int i2) throws IOException {
            int iB = r1.b(i2);
            if (iB == 0) {
                U();
                return true;
            }
            if (iB == 1) {
                S(8);
                return true;
            }
            if (iB == 2) {
                S(M());
                return true;
            }
            if (iB == 3) {
                R();
                a(r1.c(r1.a(i2), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.d();
            }
            S(4);
            return true;
        }

        public byte G() throws IOException {
            if (this.f1348j == this.f1346h) {
                Q(1);
            }
            byte[] bArr = this.f1345g;
            int i2 = this.f1348j;
            this.f1348j = i2 + 1;
            return bArr[i2];
        }

        public int K() throws IOException {
            int i2 = this.f1348j;
            if (this.f1346h - i2 < 4) {
                Q(4);
                i2 = this.f1348j;
            }
            byte[] bArr = this.f1345g;
            this.f1348j = i2 + 4;
            return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }

        public long L() throws IOException {
            int i2 = this.f1348j;
            if (this.f1346h - i2 < 8) {
                Q(8);
                i2 = this.f1348j;
            }
            byte[] bArr = this.f1345g;
            this.f1348j = i2 + 8;
            return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
        
            if (r2[r3] < 0) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int M() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.f1348j
                int r1 = r5.f1346h
                if (r1 != r0) goto L7
                goto L6a
            L7:
                byte[] r2 = r5.f1345g
                int r3 = r0 + 1
                r0 = r2[r0]
                if (r0 < 0) goto L12
                r5.f1348j = r3
                return r0
            L12:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L18
                goto L6a
            L18:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L24
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L70
            L24:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L31
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L2f:
                r1 = r3
                goto L70
            L31:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L3f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L70
            L3f:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L70
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L70
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r2 = r2[r3]
                if (r2 >= 0) goto L70
            L6a:
                long r0 = r5.O()
                int r1 = (int) r0
                return r1
            L70:
                r5.f1348j = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.j.c.M():int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:40:0x00b4, code lost:
        
            if (r2[r0] < 0) goto L41;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long N() throws java.io.IOException {
            /*
                r11 = this;
                int r0 = r11.f1348j
                int r1 = r11.f1346h
                if (r1 != r0) goto L8
                goto Lb6
            L8:
                byte[] r2 = r11.f1345g
                int r3 = r0 + 1
                r0 = r2[r0]
                if (r0 < 0) goto L14
                r11.f1348j = r3
                long r0 = (long) r0
                return r0
            L14:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L1b
                goto Lb6
            L1b:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L29
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            L26:
                long r2 = (long) r0
                goto Lbd
            L29:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L3a
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
                long r0 = (long) r0
                r9 = r0
                r1 = r3
                r2 = r9
                goto Lbd
            L3a:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L48
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L26
            L48:
                long r3 = (long) r0
                int r0 = r1 + 1
                r1 = r2[r1]
                long r5 = (long) r1
                r1 = 28
                long r5 = r5 << r1
                long r3 = r3 ^ r5
                r5 = 0
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L5f
                r1 = 266354560(0xfe03f80, double:1.315966377E-315)
            L5b:
                long r1 = r1 ^ r3
                r2 = r1
                r1 = r0
                goto Lbd
            L5f:
                int r1 = r0 + 1
                r0 = r2[r0]
                long r7 = (long) r0
                r0 = 35
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L74
                r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
            L71:
                long r3 = r3 ^ r5
            L72:
                r2 = r3
                goto Lbd
            L74:
                int r0 = r1 + 1
                r1 = r2[r1]
                long r7 = (long) r1
                r1 = 42
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L87
                r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
                goto L5b
            L87:
                int r1 = r0 + 1
                r0 = r2[r0]
                long r7 = (long) r0
                r0 = 49
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L9a
                r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
                goto L71
            L9a:
                int r0 = r1 + 1
                r1 = r2[r1]
                long r7 = (long) r1
                r1 = 56
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 >= 0) goto Lbb
                int r1 = r0 + 1
                r0 = r2[r0]
                long r7 = (long) r0
                int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r0 >= 0) goto L72
            Lb6:
                long r0 = r11.O()
                return r0
            Lbb:
                r1 = r0
                goto L72
            Lbd:
                r11.f1348j = r1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.j.c.N():long");
        }

        long O() throws IOException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte bG = G();
                j2 |= ((long) (bG & 127)) << i2;
                if ((bG & 128) == 0) {
                    return j2;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        public void R() throws IOException {
            int iB;
            do {
                iB = B();
                if (iB == 0) {
                    return;
                }
            } while (E(iB));
        }

        public void S(int i2) throws IOException {
            int i3 = this.f1346h;
            int i4 = this.f1348j;
            if (i2 > i3 - i4 || i2 < 0) {
                T(i2);
            } else {
                this.f1348j = i4 + i2;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public void a(int i2) throws InvalidProtocolBufferException {
            if (this.f1349k != i2) {
                throw InvalidProtocolBufferException.a();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int d() {
            return this.l + this.f1348j;
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public boolean e() throws IOException {
            return this.f1348j == this.f1346h && !X(1);
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public void k(int i2) {
            this.m = i2;
            P();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int l(int i2) throws InvalidProtocolBufferException {
            if (i2 < 0) {
                throw InvalidProtocolBufferException.f();
            }
            int i3 = i2 + this.l + this.f1348j;
            int i4 = this.m;
            if (i3 > i4) {
                throw InvalidProtocolBufferException.k();
            }
            this.m = i3;
            P();
            return i4;
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public boolean m() throws IOException {
            return N() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public h n() throws IOException {
            int iM = M();
            int i2 = this.f1346h;
            int i3 = this.f1348j;
            if (iM > i2 - i3 || iM <= 0) {
                return iM == 0 ? h.f1298f : F(iM);
            }
            h hVarN = h.n(this.f1345g, i3, iM);
            this.f1348j += iM;
            return hVarN;
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public double o() throws IOException {
            return Double.longBitsToDouble(L());
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int p() throws IOException {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int q() throws IOException {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public long r() throws IOException {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public float s() throws IOException {
            return Float.intBitsToFloat(K());
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int t() throws IOException {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public long u() throws IOException {
            return N();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int v() throws IOException {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public long w() throws IOException {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public int x() throws IOException {
            return j.b(M());
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public long y() throws IOException {
            return j.c(N());
        }

        @Override // androidx.datastore.preferences.protobuf.j
        public String z() throws IOException {
            int iM = M();
            if (iM > 0 && iM <= this.f1346h - this.f1348j) {
                String str = new String(this.f1345g, this.f1348j, iM, a0.a);
                this.f1348j += iM;
                return str;
            }
            if (iM == 0) {
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
            if (iM > this.f1346h) {
                return new String(H(iM, false), a0.a);
            }
            Q(iM);
            String str2 = new String(this.f1345g, this.f1348j, iM, a0.a);
            this.f1348j += iM;
            return str2;
        }

        private c(InputStream inputStream, int i2) {
            super();
            this.m = Integer.MAX_VALUE;
            this.n = null;
            a0.b(inputStream, "input");
            this.f1344f = inputStream;
            this.f1345g = new byte[i2];
            this.f1346h = 0;
            this.f1348j = 0;
            this.l = 0;
        }
    }

    public static int b(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public static long c(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    public static j f(InputStream inputStream) {
        return g(inputStream, RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT);
    }

    public static j g(InputStream inputStream, int i2) {
        if (i2 > 0) {
            return inputStream == null ? h(a0.f1255c) : new c(inputStream, i2);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static j h(byte[] bArr) {
        return i(bArr, 0, bArr.length);
    }

    public static j i(byte[] bArr, int i2, int i3) {
        return j(bArr, i2, i3, false);
    }

    static j j(byte[] bArr, int i2, int i3, boolean z) {
        b bVar = new b(bArr, i2, i3, z);
        try {
            bVar.l(i3);
            return bVar;
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public abstract String A() throws IOException;

    public abstract int B() throws IOException;

    public abstract int C() throws IOException;

    public abstract long D() throws IOException;

    public abstract boolean E(int i2) throws IOException;

    public abstract void a(int i2) throws InvalidProtocolBufferException;

    public abstract int d();

    public abstract boolean e() throws IOException;

    public abstract void k(int i2);

    public abstract int l(int i2) throws InvalidProtocolBufferException;

    public abstract boolean m() throws IOException;

    public abstract h n() throws IOException;

    public abstract double o() throws IOException;

    public abstract int p() throws IOException;

    public abstract int q() throws IOException;

    public abstract long r() throws IOException;

    public abstract float s() throws IOException;

    public abstract int t() throws IOException;

    public abstract long u() throws IOException;

    public abstract int v() throws IOException;

    public abstract long w() throws IOException;

    public abstract int x() throws IOException;

    public abstract long y() throws IOException;

    public abstract String z() throws IOException;

    private j() {
        this.f1334b = 100;
        this.f1335c = Integer.MAX_VALUE;
        this.f1337e = false;
    }
}
