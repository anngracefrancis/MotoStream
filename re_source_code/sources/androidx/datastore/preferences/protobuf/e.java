package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: BinaryReader.java */
/* JADX INFO: loaded from: classes.dex */
abstract class e implements e1 {

    /* JADX INFO: compiled from: BinaryReader.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[r1.b.values().length];
            a = iArr;
            try {
                iArr[r1.b.m.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[r1.b.q.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[r1.b.f1397f.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[r1.b.s.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[r1.b.l.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[r1.b.f1402k.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[r1.b.f1398g.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[r1.b.f1401j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[r1.b.f1399h.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[r1.b.p.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[r1.b.t.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[r1.b.u.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[r1.b.v.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[r1.b.w.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[r1.b.n.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[r1.b.r.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[r1.b.f1400i.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* JADX INFO: compiled from: BinaryReader.java */
    private static final class b extends e {
        private final boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f1284b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1285c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f1286d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1287e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f1288f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f1289g;

        public b(ByteBuffer byteBuffer, boolean z) {
            super(null);
            this.a = z;
            this.f1284b = byteBuffer.array();
            int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            this.f1285c = iArrayOffset;
            this.f1286d = iArrayOffset;
            this.f1287e = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        private boolean Q() {
            return this.f1285c == this.f1287e;
        }

        private byte R() throws IOException {
            int i2 = this.f1285c;
            if (i2 == this.f1287e) {
                throw InvalidProtocolBufferException.k();
            }
            byte[] bArr = this.f1284b;
            this.f1285c = i2 + 1;
            return bArr[i2];
        }

        private Object S(r1.b bVar, Class<?> cls, p pVar) throws IOException {
            switch (a.a[bVar.ordinal()]) {
                case 1:
                    return Boolean.valueOf(l());
                case 2:
                    return C();
                case 3:
                    return Double.valueOf(readDouble());
                case 4:
                    return Integer.valueOf(v());
                case 5:
                    return Integer.valueOf(k());
                case 6:
                    return Long.valueOf(f());
                case 7:
                    return Float.valueOf(readFloat());
                case 8:
                    return Integer.valueOf(E());
                case 9:
                    return Long.valueOf(L());
                case 10:
                    return g(cls, pVar);
                case 11:
                    return Integer.valueOf(H());
                case 12:
                    return Long.valueOf(m());
                case 13:
                    return Integer.valueOf(x());
                case 14:
                    return Long.valueOf(y());
                case 15:
                    return M();
                case 16:
                    return Integer.valueOf(p());
                case 17:
                    return Long.valueOf(e());
                default:
                    throw new RuntimeException("unsupported field type.");
            }
        }

        private <T> T T(f1<T> f1Var, p pVar) throws IOException {
            int i2 = this.f1289g;
            this.f1289g = r1.c(r1.a(this.f1288f), 4);
            try {
                T tC = f1Var.c();
                f1Var.e(tC, this, pVar);
                f1Var.f(tC);
                if (this.f1288f != this.f1289g) {
                    throw InvalidProtocolBufferException.g();
                }
                this.f1289g = i2;
                return tC;
            } catch (Throwable th) {
                this.f1289g = i2;
                throw th;
            }
        }

        private int U() throws IOException {
            e0(4);
            return V();
        }

        private int V() {
            int i2 = this.f1285c;
            byte[] bArr = this.f1284b;
            this.f1285c = i2 + 4;
            return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }

        private long W() throws IOException {
            e0(8);
            return X();
        }

        private long X() {
            int i2 = this.f1285c;
            byte[] bArr = this.f1284b;
            this.f1285c = i2 + 8;
            return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
        }

        private <T> T Y(f1<T> f1Var, p pVar) throws IOException {
            int iB0 = b0();
            e0(iB0);
            int i2 = this.f1287e;
            int i3 = this.f1285c + iB0;
            this.f1287e = i3;
            try {
                T tC = f1Var.c();
                f1Var.e(tC, this, pVar);
                f1Var.f(tC);
                if (this.f1285c != i3) {
                    throw InvalidProtocolBufferException.g();
                }
                this.f1287e = i2;
                return tC;
            } catch (Throwable th) {
                this.f1287e = i2;
                throw th;
            }
        }

        private int b0() throws IOException {
            int i2;
            int i3 = this.f1285c;
            int i4 = this.f1287e;
            if (i4 == i3) {
                throw InvalidProtocolBufferException.k();
            }
            byte[] bArr = this.f1284b;
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            if (b2 >= 0) {
                this.f1285c = i5;
                return b2;
            }
            if (i4 - i5 < 9) {
                return (int) d0();
            }
            int i6 = i5 + 1;
            int i7 = b2 ^ (bArr[i5] << 7);
            if (i7 < 0) {
                i2 = i7 ^ (-128);
            } else {
                int i8 = i6 + 1;
                int i9 = i7 ^ (bArr[i6] << 14);
                if (i9 >= 0) {
                    i2 = i9 ^ 16256;
                } else {
                    i6 = i8 + 1;
                    int i10 = i9 ^ (bArr[i8] << 21);
                    if (i10 < 0) {
                        i2 = i10 ^ (-2080896);
                    } else {
                        i8 = i6 + 1;
                        byte b3 = bArr[i6];
                        i2 = (i10 ^ (b3 << 28)) ^ 266354560;
                        if (b3 < 0) {
                            i6 = i8 + 1;
                            if (bArr[i8] < 0) {
                                i8 = i6 + 1;
                                if (bArr[i6] < 0) {
                                    i6 = i8 + 1;
                                    if (bArr[i8] < 0) {
                                        i8 = i6 + 1;
                                        if (bArr[i6] < 0) {
                                            i6 = i8 + 1;
                                            if (bArr[i8] < 0) {
                                                throw InvalidProtocolBufferException.e();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                i6 = i8;
            }
            this.f1285c = i6;
            return i2;
        }

        private long d0() throws IOException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte bR = R();
                j2 |= ((long) (bR & 127)) << i2;
                if ((bR & 128) == 0) {
                    return j2;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        private void e0(int i2) throws IOException {
            if (i2 < 0 || i2 > this.f1287e - this.f1285c) {
                throw InvalidProtocolBufferException.k();
            }
        }

        private void f0(int i2) throws IOException {
            if (this.f1285c != i2) {
                throw InvalidProtocolBufferException.k();
            }
        }

        private void g0(int i2) throws IOException {
            if (r1.b(this.f1288f) != i2) {
                throw InvalidProtocolBufferException.d();
            }
        }

        private void h0(int i2) throws IOException {
            e0(i2);
            this.f1285c += i2;
        }

        private void i0() throws IOException {
            int i2 = this.f1289g;
            this.f1289g = r1.c(r1.a(this.f1288f), 4);
            while (A() != Integer.MAX_VALUE && G()) {
            }
            if (this.f1288f != this.f1289g) {
                throw InvalidProtocolBufferException.g();
            }
            this.f1289g = i2;
        }

        private void j0() throws IOException {
            int i2 = this.f1287e;
            int i3 = this.f1285c;
            if (i2 - i3 >= 10) {
                byte[] bArr = this.f1284b;
                int i4 = 0;
                while (i4 < 10) {
                    int i5 = i3 + 1;
                    if (bArr[i3] >= 0) {
                        this.f1285c = i5;
                        return;
                    } else {
                        i4++;
                        i3 = i5;
                    }
                }
            }
            k0();
        }

        private void k0() throws IOException {
            for (int i2 = 0; i2 < 10; i2++) {
                if (R() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        private void l0(int i2) throws IOException {
            e0(i2);
            if ((i2 & 3) != 0) {
                throw InvalidProtocolBufferException.g();
            }
        }

        private void m0(int i2) throws IOException {
            e0(i2);
            if ((i2 & 7) != 0) {
                throw InvalidProtocolBufferException.g();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public int A() throws IOException {
            if (Q()) {
                return Integer.MAX_VALUE;
            }
            int iB0 = b0();
            this.f1288f = iB0;
            if (iB0 == this.f1289g) {
                return Integer.MAX_VALUE;
            }
            return r1.a(iB0);
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public void B(List<String> list) throws IOException {
            a0(list, true);
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public h C() throws IOException {
            g0(2);
            int iB0 = b0();
            if (iB0 == 0) {
                return h.f1298f;
            }
            e0(iB0);
            h hVarG = this.a ? h.G(this.f1284b, this.f1285c, iB0) : h.n(this.f1284b, this.f1285c, iB0);
            this.f1285c += iB0;
            return hVarG;
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public void D(List<Float> list) throws IOException {
            int i2;
            int i3;
            if (!(list instanceof w)) {
                int iB = r1.b(this.f1288f);
                if (iB == 2) {
                    int iB0 = b0();
                    l0(iB0);
                    int i4 = this.f1285c + iB0;
                    while (this.f1285c < i4) {
                        list.add(Float.valueOf(Float.intBitsToFloat(V())));
                    }
                    return;
                }
                if (iB != 5) {
                    throw InvalidProtocolBufferException.d();
                }
                do {
                    list.add(Float.valueOf(readFloat()));
                    if (Q()) {
                        return;
                    } else {
                        i2 = this.f1285c;
                    }
                } while (b0() == this.f1288f);
                this.f1285c = i2;
                return;
            }
            w wVar = (w) list;
            int iB2 = r1.b(this.f1288f);
            if (iB2 == 2) {
                int iB1 = b0();
                l0(iB1);
                int i5 = this.f1285c + iB1;
                while (this.f1285c < i5) {
                    wVar.h(Float.intBitsToFloat(V()));
                }
                return;
            }
            if (iB2 != 5) {
                throw InvalidProtocolBufferException.d();
            }
            do {
                wVar.h(readFloat());
                if (Q()) {
                    return;
                } else {
                    i3 = this.f1285c;
                }
            } while (b0() == this.f1288f);
            this.f1285c = i3;
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public int E() throws IOException {
            g0(0);
            return b0();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.e1
        public <T> void F(List<T> list, f1<T> f1Var, p pVar) throws IOException {
            int i2;
            if (r1.b(this.f1288f) != 3) {
                throw InvalidProtocolBufferException.d();
            }
            int i3 = this.f1288f;
            do {
                list.add(T(f1Var, pVar));
                if (Q()) {
                    return;
                } else {
                    i2 = this.f1285c;
                }
            } while (b0() == i3);
            this.f1285c = i2;
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public boolean G() throws IOException {
            int i2;
            if (Q() || (i2 = this.f1288f) == this.f1289g) {
                return false;
            }
            int iB = r1.b(i2);
            if (iB == 0) {
                j0();
                return true;
            }
            if (iB == 1) {
                h0(8);
                return true;
            }
            if (iB == 2) {
                h0(b0());
                return true;
            }
            if (iB == 3) {
                i0();
                return true;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.d();
            }
            h0(4);
            return true;
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public int H() throws IOException {
            g0(5);
            return U();
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public void I(List<h> list) throws IOException {
            int i2;
            if (r1.b(this.f1288f) != 2) {
                throw InvalidProtocolBufferException.d();
            }
            do {
                list.add(C());
                if (Q()) {
                    return;
                } else {
                    i2 = this.f1285c;
                }
            } while (b0() == this.f1288f);
            this.f1285c = i2;
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public void J(List<Double> list) throws IOException {
            int i2;
            int i3;
            if (!(list instanceof m)) {
                int iB = r1.b(this.f1288f);
                if (iB == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (Q()) {
                            return;
                        } else {
                            i2 = this.f1285c;
                        }
                    } while (b0() == this.f1288f);
                    this.f1285c = i2;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.d();
                }
                int iB0 = b0();
                m0(iB0);
                int i4 = this.f1285c + iB0;
                while (this.f1285c < i4) {
                    list.add(Double.valueOf(Double.longBitsToDouble(X())));
                }
                return;
            }
            m mVar = (m) list;
            int iB2 = r1.b(this.f1288f);
            if (iB2 == 1) {
                do {
                    mVar.h(readDouble());
                    if (Q()) {
                        return;
                    } else {
                        i3 = this.f1285c;
                    }
                } while (b0() == this.f1288f);
                this.f1285c = i3;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iB1 = b0();
            m0(iB1);
            int i5 = this.f1285c + iB1;
            while (this.f1285c < i5) {
                mVar.h(Double.longBitsToDouble(X()));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.e1
        public <T> void K(List<T> list, f1<T> f1Var, p pVar) throws IOException {
            int i2;
            if (r1.b(this.f1288f) != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int i3 = this.f1288f;
            do {
                list.add(Y(f1Var, pVar));
                if (Q()) {
                    return;
                } else {
                    i2 = this.f1285c;
                }
            } while (b0() == i3);
            this.f1285c = i2;
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public long L() throws IOException {
            g0(0);
            return c0();
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public String M() throws IOException {
            return Z(true);
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public void N(List<Long> list) throws IOException {
            int i2;
            int i3;
            if (!(list instanceof h0)) {
                int iB = r1.b(this.f1288f);
                if (iB == 1) {
                    do {
                        list.add(Long.valueOf(f()));
                        if (Q()) {
                            return;
                        } else {
                            i2 = this.f1285c;
                        }
                    } while (b0() == this.f1288f);
                    this.f1285c = i2;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.d();
                }
                int iB0 = b0();
                m0(iB0);
                int i4 = this.f1285c + iB0;
                while (this.f1285c < i4) {
                    list.add(Long.valueOf(X()));
                }
                return;
            }
            h0 h0Var = (h0) list;
            int iB2 = r1.b(this.f1288f);
            if (iB2 == 1) {
                do {
                    h0Var.i(f());
                    if (Q()) {
                        return;
                    } else {
                        i3 = this.f1285c;
                    }
                } while (b0() == this.f1288f);
                this.f1285c = i3;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iB1 = b0();
            m0(iB1);
            int i5 = this.f1285c + iB1;
            while (this.f1285c < i5) {
                h0Var.i(X());
            }
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public <T> T O(f1<T> f1Var, p pVar) throws IOException {
            g0(3);
            return (T) T(f1Var, pVar);
        }

        public String Z(boolean z) throws IOException {
            g0(2);
            int iB0 = b0();
            if (iB0 == 0) {
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
            e0(iB0);
            if (z) {
                byte[] bArr = this.f1284b;
                int i2 = this.f1285c;
                if (!q1.n(bArr, i2, i2 + iB0)) {
                    throw InvalidProtocolBufferException.c();
                }
            }
            String str = new String(this.f1284b, this.f1285c, iB0, a0.a);
            this.f1285c += iB0;
            return str;
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public String a() throws IOException {
            return Z(false);
        }

        public void a0(List<String> list, boolean z) throws IOException {
            int i2;
            int i3;
            if (r1.b(this.f1288f) != 2) {
                throw InvalidProtocolBufferException.d();
            }
            if (!(list instanceof f0) || z) {
                do {
                    list.add(Z(z));
                    if (Q()) {
                        return;
                    } else {
                        i2 = this.f1285c;
                    }
                } while (b0() == this.f1288f);
                this.f1285c = i2;
                return;
            }
            f0 f0Var = (f0) list;
            do {
                f0Var.a0(C());
                if (Q()) {
                    return;
                } else {
                    i3 = this.f1285c;
                }
            } while (b0() == this.f1288f);
            this.f1285c = i3;
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public void b(List<String> list) throws IOException {
            a0(list, false);
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public <T> T c(f1<T> f1Var, p pVar) throws IOException {
            g0(2);
            return (T) Y(f1Var, pVar);
        }

        public long c0() throws IOException {
            long j2;
            long j3;
            long j4;
            long j5;
            int i2;
            int i3 = this.f1285c;
            int i4 = this.f1287e;
            if (i4 == i3) {
                throw InvalidProtocolBufferException.k();
            }
            byte[] bArr = this.f1284b;
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            if (b2 >= 0) {
                this.f1285c = i5;
                return b2;
            }
            if (i4 - i5 < 9) {
                return d0();
            }
            int i6 = i5 + 1;
            int i7 = b2 ^ (bArr[i5] << 7);
            if (i7 >= 0) {
                int i8 = i6 + 1;
                int i9 = i7 ^ (bArr[i6] << 14);
                if (i9 >= 0) {
                    i6 = i8;
                    j5 = i9 ^ 16256;
                } else {
                    i6 = i8 + 1;
                    int i10 = i9 ^ (bArr[i8] << 21);
                    if (i10 < 0) {
                        i2 = i10 ^ (-2080896);
                    } else {
                        long j6 = i10;
                        int i11 = i6 + 1;
                        long j7 = j6 ^ (((long) bArr[i6]) << 28);
                        if (j7 >= 0) {
                            j4 = 266354560;
                        } else {
                            i6 = i11 + 1;
                            long j8 = j7 ^ (((long) bArr[i11]) << 35);
                            if (j8 < 0) {
                                j3 = -34093383808L;
                            } else {
                                i11 = i6 + 1;
                                j7 = j8 ^ (((long) bArr[i6]) << 42);
                                if (j7 >= 0) {
                                    j4 = 4363953127296L;
                                } else {
                                    i6 = i11 + 1;
                                    j8 = j7 ^ (((long) bArr[i11]) << 49);
                                    if (j8 < 0) {
                                        j3 = -558586000294016L;
                                    } else {
                                        int i12 = i6 + 1;
                                        j2 = (j8 ^ (((long) bArr[i6]) << 56)) ^ 71499008037633920L;
                                        if (j2 < 0) {
                                            i6 = i12 + 1;
                                            if (bArr[i12] < 0) {
                                                throw InvalidProtocolBufferException.e();
                                            }
                                        } else {
                                            i6 = i12;
                                        }
                                    }
                                    j5 = j2;
                                }
                            }
                            j2 = j8 ^ j3;
                            j5 = j2;
                        }
                        j5 = j4 ^ j7;
                        i6 = i11;
                    }
                }
                this.f1285c = i6;
                return j5;
            }
            i2 = i7 ^ (-128);
            j5 = i2;
            this.f1285c = i6;
            return j5;
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public void d(List<Integer> list) throws IOException {
            int i2;
            int i3;
            if (!(list instanceof z)) {
                int iB = r1.b(this.f1288f);
                if (iB != 0) {
                    if (iB != 2) {
                        throw InvalidProtocolBufferException.d();
                    }
                    int iB0 = this.f1285c + b0();
                    while (this.f1285c < iB0) {
                        list.add(Integer.valueOf(j.b(b0())));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(x()));
                    if (Q()) {
                        return;
                    } else {
                        i2 = this.f1285c;
                    }
                } while (b0() == this.f1288f);
                this.f1285c = i2;
                return;
            }
            z zVar = (z) list;
            int iB2 = r1.b(this.f1288f);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw InvalidProtocolBufferException.d();
                }
                int iB1 = this.f1285c + b0();
                while (this.f1285c < iB1) {
                    zVar.h(j.b(b0()));
                }
                return;
            }
            do {
                zVar.h(x());
                if (Q()) {
                    return;
                } else {
                    i3 = this.f1285c;
                }
            } while (b0() == this.f1288f);
            this.f1285c = i3;
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public long e() throws IOException {
            g0(0);
            return c0();
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public long f() throws IOException {
            g0(1);
            return W();
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public <T> T g(Class<T> cls, p pVar) throws IOException {
            g0(2);
            return (T) Y(b1.a().d(cls), pVar);
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public int getTag() {
            return this.f1288f;
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public void h(List<Integer> list) throws IOException {
            int i2;
            int i3;
            if (!(list instanceof z)) {
                int iB = r1.b(this.f1288f);
                if (iB == 2) {
                    int iB0 = b0();
                    l0(iB0);
                    int i4 = this.f1285c + iB0;
                    while (this.f1285c < i4) {
                        list.add(Integer.valueOf(V()));
                    }
                    return;
                }
                if (iB != 5) {
                    throw InvalidProtocolBufferException.d();
                }
                do {
                    list.add(Integer.valueOf(H()));
                    if (Q()) {
                        return;
                    } else {
                        i2 = this.f1285c;
                    }
                } while (b0() == this.f1288f);
                this.f1285c = i2;
                return;
            }
            z zVar = (z) list;
            int iB2 = r1.b(this.f1288f);
            if (iB2 == 2) {
                int iB1 = b0();
                l0(iB1);
                int i5 = this.f1285c + iB1;
                while (this.f1285c < i5) {
                    zVar.h(V());
                }
                return;
            }
            if (iB2 != 5) {
                throw InvalidProtocolBufferException.d();
            }
            do {
                zVar.h(H());
                if (Q()) {
                    return;
                } else {
                    i3 = this.f1285c;
                }
            } while (b0() == this.f1288f);
            this.f1285c = i3;
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public void i(List<Long> list) throws IOException {
            int i2;
            int i3;
            if (!(list instanceof h0)) {
                int iB = r1.b(this.f1288f);
                if (iB != 0) {
                    if (iB != 2) {
                        throw InvalidProtocolBufferException.d();
                    }
                    int iB0 = this.f1285c + b0();
                    while (this.f1285c < iB0) {
                        list.add(Long.valueOf(j.c(c0())));
                    }
                    return;
                }
                do {
                    list.add(Long.valueOf(y()));
                    if (Q()) {
                        return;
                    } else {
                        i2 = this.f1285c;
                    }
                } while (b0() == this.f1288f);
                this.f1285c = i2;
                return;
            }
            h0 h0Var = (h0) list;
            int iB2 = r1.b(this.f1288f);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw InvalidProtocolBufferException.d();
                }
                int iB1 = this.f1285c + b0();
                while (this.f1285c < iB1) {
                    h0Var.i(j.c(c0()));
                }
                return;
            }
            do {
                h0Var.i(y());
                if (Q()) {
                    return;
                } else {
                    i3 = this.f1285c;
                }
            } while (b0() == this.f1288f);
            this.f1285c = i3;
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public void j(List<Integer> list) throws IOException {
            int i2;
            int i3;
            if (!(list instanceof z)) {
                int iB = r1.b(this.f1288f);
                if (iB != 0) {
                    if (iB != 2) {
                        throw InvalidProtocolBufferException.d();
                    }
                    int iB0 = this.f1285c + b0();
                    while (this.f1285c < iB0) {
                        list.add(Integer.valueOf(b0()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(p()));
                    if (Q()) {
                        return;
                    } else {
                        i2 = this.f1285c;
                    }
                } while (b0() == this.f1288f);
                this.f1285c = i2;
                return;
            }
            z zVar = (z) list;
            int iB2 = r1.b(this.f1288f);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw InvalidProtocolBufferException.d();
                }
                int iB1 = this.f1285c + b0();
                while (this.f1285c < iB1) {
                    zVar.h(b0());
                }
                return;
            }
            do {
                zVar.h(p());
                if (Q()) {
                    return;
                } else {
                    i3 = this.f1285c;
                }
            } while (b0() == this.f1288f);
            this.f1285c = i3;
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public int k() throws IOException {
            g0(5);
            return U();
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public boolean l() throws IOException {
            g0(0);
            return b0() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public long m() throws IOException {
            g0(1);
            return W();
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public void n(List<Long> list) throws IOException {
            int i2;
            int i3;
            if (!(list instanceof h0)) {
                int iB = r1.b(this.f1288f);
                if (iB == 0) {
                    do {
                        list.add(Long.valueOf(e()));
                        if (Q()) {
                            return;
                        } else {
                            i2 = this.f1285c;
                        }
                    } while (b0() == this.f1288f);
                    this.f1285c = i2;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.d();
                }
                int iB0 = this.f1285c + b0();
                while (this.f1285c < iB0) {
                    list.add(Long.valueOf(c0()));
                }
                f0(iB0);
                return;
            }
            h0 h0Var = (h0) list;
            int iB2 = r1.b(this.f1288f);
            if (iB2 == 0) {
                do {
                    h0Var.i(e());
                    if (Q()) {
                        return;
                    } else {
                        i3 = this.f1285c;
                    }
                } while (b0() == this.f1288f);
                this.f1285c = i3;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iB1 = this.f1285c + b0();
            while (this.f1285c < iB1) {
                h0Var.i(c0());
            }
            f0(iB1);
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public <T> T o(Class<T> cls, p pVar) throws IOException {
            g0(3);
            return (T) T(b1.a().d(cls), pVar);
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public int p() throws IOException {
            g0(0);
            return b0();
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public void q(List<Long> list) throws IOException {
            int i2;
            int i3;
            if (!(list instanceof h0)) {
                int iB = r1.b(this.f1288f);
                if (iB == 0) {
                    do {
                        list.add(Long.valueOf(L()));
                        if (Q()) {
                            return;
                        } else {
                            i2 = this.f1285c;
                        }
                    } while (b0() == this.f1288f);
                    this.f1285c = i2;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.d();
                }
                int iB0 = this.f1285c + b0();
                while (this.f1285c < iB0) {
                    list.add(Long.valueOf(c0()));
                }
                f0(iB0);
                return;
            }
            h0 h0Var = (h0) list;
            int iB2 = r1.b(this.f1288f);
            if (iB2 == 0) {
                do {
                    h0Var.i(L());
                    if (Q()) {
                        return;
                    } else {
                        i3 = this.f1285c;
                    }
                } while (b0() == this.f1288f);
                this.f1285c = i3;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iB1 = this.f1285c + b0();
            while (this.f1285c < iB1) {
                h0Var.i(c0());
            }
            f0(iB1);
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public void r(List<Long> list) throws IOException {
            int i2;
            int i3;
            if (!(list instanceof h0)) {
                int iB = r1.b(this.f1288f);
                if (iB == 1) {
                    do {
                        list.add(Long.valueOf(m()));
                        if (Q()) {
                            return;
                        } else {
                            i2 = this.f1285c;
                        }
                    } while (b0() == this.f1288f);
                    this.f1285c = i2;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.d();
                }
                int iB0 = b0();
                m0(iB0);
                int i4 = this.f1285c + iB0;
                while (this.f1285c < i4) {
                    list.add(Long.valueOf(X()));
                }
                return;
            }
            h0 h0Var = (h0) list;
            int iB2 = r1.b(this.f1288f);
            if (iB2 == 1) {
                do {
                    h0Var.i(m());
                    if (Q()) {
                        return;
                    } else {
                        i3 = this.f1285c;
                    }
                } while (b0() == this.f1288f);
                this.f1285c = i3;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iB1 = b0();
            m0(iB1);
            int i5 = this.f1285c + iB1;
            while (this.f1285c < i5) {
                h0Var.i(X());
            }
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public double readDouble() throws IOException {
            g0(1);
            return Double.longBitsToDouble(W());
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public float readFloat() throws IOException {
            g0(5);
            return Float.intBitsToFloat(U());
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public void s(List<Integer> list) throws IOException {
            int i2;
            int i3;
            if (!(list instanceof z)) {
                int iB = r1.b(this.f1288f);
                if (iB == 0) {
                    do {
                        list.add(Integer.valueOf(E()));
                        if (Q()) {
                            return;
                        } else {
                            i2 = this.f1285c;
                        }
                    } while (b0() == this.f1288f);
                    this.f1285c = i2;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.d();
                }
                int iB0 = this.f1285c + b0();
                while (this.f1285c < iB0) {
                    list.add(Integer.valueOf(b0()));
                }
                f0(iB0);
                return;
            }
            z zVar = (z) list;
            int iB2 = r1.b(this.f1288f);
            if (iB2 == 0) {
                do {
                    zVar.h(E());
                    if (Q()) {
                        return;
                    } else {
                        i3 = this.f1285c;
                    }
                } while (b0() == this.f1288f);
                this.f1285c = i3;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iB1 = this.f1285c + b0();
            while (this.f1285c < iB1) {
                zVar.h(b0());
            }
            f0(iB1);
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public void t(List<Integer> list) throws IOException {
            int i2;
            int i3;
            if (!(list instanceof z)) {
                int iB = r1.b(this.f1288f);
                if (iB != 0) {
                    if (iB != 2) {
                        throw InvalidProtocolBufferException.d();
                    }
                    int iB0 = this.f1285c + b0();
                    while (this.f1285c < iB0) {
                        list.add(Integer.valueOf(b0()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(v()));
                    if (Q()) {
                        return;
                    } else {
                        i2 = this.f1285c;
                    }
                } while (b0() == this.f1288f);
                this.f1285c = i2;
                return;
            }
            z zVar = (z) list;
            int iB2 = r1.b(this.f1288f);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw InvalidProtocolBufferException.d();
                }
                int iB1 = this.f1285c + b0();
                while (this.f1285c < iB1) {
                    zVar.h(b0());
                }
                return;
            }
            do {
                zVar.h(v());
                if (Q()) {
                    return;
                } else {
                    i3 = this.f1285c;
                }
            } while (b0() == this.f1288f);
            this.f1285c = i3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.e1
        public <K, V> void u(Map<K, V> map, j0.a<K, V> aVar, p pVar) throws IOException {
            g0(2);
            int iB0 = b0();
            e0(iB0);
            int i2 = this.f1287e;
            this.f1287e = this.f1285c + iB0;
            try {
                Object objS = aVar.f1352b;
                Object objS2 = aVar.f1354d;
                while (true) {
                    int iA = A();
                    if (iA == Integer.MAX_VALUE) {
                        map.put(objS, objS2);
                        this.f1287e = i2;
                        return;
                    } else if (iA == 1) {
                        objS = S(aVar.a, null, null);
                    } else if (iA != 2) {
                        try {
                            if (!G()) {
                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                            }
                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                            if (!G()) {
                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                            }
                        }
                    } else {
                        objS2 = S(aVar.f1353c, aVar.f1354d.getClass(), pVar);
                    }
                }
            } catch (Throwable th) {
                this.f1287e = i2;
                throw th;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public int v() throws IOException {
            g0(0);
            return b0();
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public void w(List<Integer> list) throws IOException {
            int i2;
            int i3;
            if (!(list instanceof z)) {
                int iB = r1.b(this.f1288f);
                if (iB == 2) {
                    int iB0 = b0();
                    l0(iB0);
                    int i4 = this.f1285c + iB0;
                    while (this.f1285c < i4) {
                        list.add(Integer.valueOf(V()));
                    }
                    return;
                }
                if (iB != 5) {
                    throw InvalidProtocolBufferException.d();
                }
                do {
                    list.add(Integer.valueOf(k()));
                    if (Q()) {
                        return;
                    } else {
                        i2 = this.f1285c;
                    }
                } while (b0() == this.f1288f);
                this.f1285c = i2;
                return;
            }
            z zVar = (z) list;
            int iB2 = r1.b(this.f1288f);
            if (iB2 == 2) {
                int iB1 = b0();
                l0(iB1);
                int i5 = this.f1285c + iB1;
                while (this.f1285c < i5) {
                    zVar.h(V());
                }
                return;
            }
            if (iB2 != 5) {
                throw InvalidProtocolBufferException.d();
            }
            do {
                zVar.h(k());
                if (Q()) {
                    return;
                } else {
                    i3 = this.f1285c;
                }
            } while (b0() == this.f1288f);
            this.f1285c = i3;
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public int x() throws IOException {
            g0(0);
            return j.b(b0());
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public long y() throws IOException {
            g0(0);
            return j.c(c0());
        }

        @Override // androidx.datastore.preferences.protobuf.e1
        public void z(List<Boolean> list) throws IOException {
            int i2;
            int i3;
            if (!(list instanceof f)) {
                int iB = r1.b(this.f1288f);
                if (iB != 0) {
                    if (iB != 2) {
                        throw InvalidProtocolBufferException.d();
                    }
                    int iB0 = this.f1285c + b0();
                    while (this.f1285c < iB0) {
                        list.add(Boolean.valueOf(b0() != 0));
                    }
                    f0(iB0);
                    return;
                }
                do {
                    list.add(Boolean.valueOf(l()));
                    if (Q()) {
                        return;
                    } else {
                        i2 = this.f1285c;
                    }
                } while (b0() == this.f1288f);
                this.f1285c = i2;
                return;
            }
            f fVar = (f) list;
            int iB2 = r1.b(this.f1288f);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw InvalidProtocolBufferException.d();
                }
                int iB1 = this.f1285c + b0();
                while (this.f1285c < iB1) {
                    fVar.i(b0() != 0);
                }
                f0(iB1);
                return;
            }
            do {
                fVar.i(l());
                if (Q()) {
                    return;
                } else {
                    i3 = this.f1285c;
                }
            } while (b0() == this.f1288f);
            this.f1285c = i3;
        }
    }

    /* synthetic */ e(a aVar) {
        this();
    }

    public static e P(ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer, z);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    private e() {
    }
}
