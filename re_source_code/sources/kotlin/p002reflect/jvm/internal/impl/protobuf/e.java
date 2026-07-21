package kotlin.p002reflect.jvm.internal.impl.protobuf;

import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: CodedInputStream.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f25406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f25407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f25408d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f25409e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final InputStream f25410f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f25411g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f25412h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f25413i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f25414j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f25415k;
    private int l;
    private int m;
    private a n;

    /* JADX INFO: compiled from: CodedInputStream.java */
    private interface a {
        void a();
    }

    private e(InputStream inputStream) {
        this.f25412h = false;
        this.f25414j = Integer.MAX_VALUE;
        this.l = 64;
        this.m = 67108864;
        this.n = null;
        this.a = new byte[RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT];
        this.f25407c = 0;
        this.f25409e = 0;
        this.f25413i = 0;
        this.f25410f = inputStream;
        this.f25406b = false;
    }

    public static int B(int i2, InputStream inputStream) throws IOException {
        if ((i2 & 128) == 0) {
            return i2;
        }
        int i3 = i2 & 127;
        int i4 = 7;
        while (i4 < 32) {
            int i5 = inputStream.read();
            if (i5 == -1) {
                throw InvalidProtocolBufferException.k();
            }
            i3 |= (i5 & 127) << i4;
            if ((i5 & 128) == 0) {
                return i3;
            }
            i4 += 7;
        }
        while (i4 < 64) {
            int i6 = inputStream.read();
            if (i6 == -1) {
                throw InvalidProtocolBufferException.k();
            }
            if ((i6 & 128) == 0) {
                return i3;
            }
            i4 += 7;
        }
        throw InvalidProtocolBufferException.f();
    }

    private void N() {
        int i2 = this.f25407c + this.f25408d;
        this.f25407c = i2;
        int i3 = this.f25413i + i2;
        int i4 = this.f25414j;
        if (i3 <= i4) {
            this.f25408d = 0;
            return;
        }
        int i5 = i3 - i4;
        this.f25408d = i5;
        this.f25407c = i2 - i5;
    }

    private void O(int i2) throws IOException {
        if (!T(i2)) {
            throw InvalidProtocolBufferException.k();
        }
    }

    private void S(int i2) throws IOException {
        if (i2 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        int i3 = this.f25413i;
        int i4 = this.f25409e;
        int i5 = i3 + i4 + i2;
        int i6 = this.f25414j;
        if (i5 > i6) {
            R((i6 - i3) - i4);
            throw InvalidProtocolBufferException.k();
        }
        int i7 = this.f25407c;
        int i8 = i7 - i4;
        this.f25409e = i7;
        O(1);
        while (true) {
            int i9 = i2 - i8;
            int i10 = this.f25407c;
            if (i9 <= i10) {
                this.f25409e = i9;
                return;
            } else {
                i8 += i10;
                this.f25409e = i10;
                O(1);
            }
        }
    }

    private boolean T(int i2) throws IOException {
        int i3 = this.f25409e;
        if (i3 + i2 <= this.f25407c) {
            StringBuilder sb = new StringBuilder(77);
            sb.append("refillBuffer() called when ");
            sb.append(i2);
            sb.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb.toString());
        }
        if (this.f25413i + i3 + i2 > this.f25414j) {
            return false;
        }
        a aVar = this.n;
        if (aVar != null) {
            aVar.a();
        }
        if (this.f25410f != null) {
            int i4 = this.f25409e;
            if (i4 > 0) {
                int i5 = this.f25407c;
                if (i5 > i4) {
                    byte[] bArr = this.a;
                    System.arraycopy(bArr, i4, bArr, 0, i5 - i4);
                }
                this.f25413i += i4;
                this.f25407c -= i4;
                this.f25409e = 0;
            }
            InputStream inputStream = this.f25410f;
            byte[] bArr2 = this.a;
            int i6 = this.f25407c;
            int i7 = inputStream.read(bArr2, i6, bArr2.length - i6);
            if (i7 == 0 || i7 < -1 || i7 > this.a.length) {
                StringBuilder sb2 = new StringBuilder(102);
                sb2.append("InputStream#read(byte[]) returned invalid result: ");
                sb2.append(i7);
                sb2.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb2.toString());
            }
            if (i7 > 0) {
                this.f25407c += i7;
                if ((this.f25413i + i2) - this.m > 0) {
                    throw InvalidProtocolBufferException.j();
                }
                N();
                if (this.f25407c >= i2) {
                    return true;
                }
                return T(i2);
            }
        }
        return false;
    }

    public static int b(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public static long c(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    private void d(int i2) throws IOException {
        if (this.f25407c - this.f25409e < i2) {
            O(i2);
        }
    }

    public static e g(InputStream inputStream) {
        return new e(inputStream);
    }

    static e h(n nVar) {
        e eVar = new e(nVar);
        try {
            eVar.j(nVar.size());
            return eVar;
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    private byte[] x(int i2) throws IOException {
        if (i2 <= 0) {
            if (i2 == 0) {
                return i.a;
            }
            throw InvalidProtocolBufferException.g();
        }
        int i3 = this.f25413i;
        int i4 = this.f25409e;
        int i5 = i3 + i4 + i2;
        int i6 = this.f25414j;
        if (i5 > i6) {
            R((i6 - i3) - i4);
            throw InvalidProtocolBufferException.k();
        }
        if (i2 < 4096) {
            byte[] bArr = new byte[i2];
            int i7 = this.f25407c - i4;
            System.arraycopy(this.a, i4, bArr, 0, i7);
            this.f25409e = this.f25407c;
            int i8 = i2 - i7;
            d(i8);
            System.arraycopy(this.a, 0, bArr, i7, i8);
            this.f25409e = i8;
            return bArr;
        }
        int i9 = this.f25407c;
        this.f25413i = i3 + i9;
        this.f25409e = 0;
        this.f25407c = 0;
        int length = i9 - i4;
        int i10 = i2 - length;
        ArrayList<byte[]> arrayList = new ArrayList();
        while (i10 > 0) {
            int iMin = Math.min(i10, RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT);
            byte[] bArr2 = new byte[iMin];
            int i11 = 0;
            while (i11 < iMin) {
                InputStream inputStream = this.f25410f;
                int i12 = inputStream == null ? -1 : inputStream.read(bArr2, i11, iMin - i11);
                if (i12 == -1) {
                    throw InvalidProtocolBufferException.k();
                }
                this.f25413i += i12;
                i11 += i12;
            }
            i10 -= iMin;
            arrayList.add(bArr2);
        }
        byte[] bArr3 = new byte[i2];
        System.arraycopy(this.a, i4, bArr3, 0, length);
        for (byte[] bArr4 : arrayList) {
            System.arraycopy(bArr4, 0, bArr3, length, bArr4.length);
            length += bArr4.length;
        }
        return bArr3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0079, code lost:
    
        if (r2[r3] < 0) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int A() throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r9.f25409e
            int r1 = r9.f25407c
            if (r1 != r0) goto L8
            goto L7b
        L8:
            byte[] r2 = r9.a
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L13
            r9.f25409e = r3
            return r0
        L13:
            int r1 = r1 - r3
            r4 = 9
            if (r1 >= r4) goto L19
            goto L7b
        L19:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            long r3 = (long) r0
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L2c
            r5 = -128(0xffffffffffffff80, double:NaN)
        L29:
            long r3 = r3 ^ r5
            int r0 = (int) r3
            goto L81
        L2c:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            long r7 = (long) r0
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 < 0) goto L3e
            r0 = 16256(0x3f80, double:8.0315E-320)
            long r0 = r0 ^ r7
            int r0 = (int) r0
        L3c:
            r1 = r3
            goto L81
        L3e:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            long r3 = (long) r0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L4e
            r5 = -2080896(0xffffffffffe03f80, double:NaN)
            goto L29
        L4e:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            long r4 = (long) r0
            r6 = 266354560(0xfe03f80, double:1.315966377E-315)
            long r4 = r4 ^ r6
            int r0 = (int) r4
            if (r1 >= 0) goto L3c
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L81
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L3c
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L81
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L3c
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 >= 0) goto L81
        L7b:
            long r0 = r9.D()
            int r1 = (int) r0
            return r1
        L81:
            r9.f25409e = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.p002reflect.jvm.internal.impl.protobuf.e.A():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
    
        if (r2[r0] < 0) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long C() throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r9.f25409e
            int r1 = r9.f25407c
            if (r1 != r0) goto L8
            goto Lb6
        L8:
            byte[] r2 = r9.a
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L14
            r9.f25409e = r3
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
            long r3 = (long) r0
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L2e
            r5 = -128(0xffffffffffffff80, double:NaN)
        L2b:
            long r3 = r3 ^ r5
            goto Lbb
        L2e:
            int r0 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            long r7 = (long) r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L40
            r1 = 16256(0x3f80, double:8.0315E-320)
        L3c:
            long r3 = r3 ^ r1
        L3d:
            r1 = r0
            goto Lbb
        L40:
            int r1 = r0 + 1
            r0 = r2[r0]
            int r0 = r0 << 21
            long r7 = (long) r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L50
            r5 = -2080896(0xffffffffffe03f80, double:NaN)
            goto L2b
        L50:
            int r0 = r1 + 1
            r1 = r2[r1]
            long r7 = (long) r1
            r1 = 28
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L61
            r1 = 266354560(0xfe03f80, double:1.315966377E-315)
            goto L3c
        L61:
            int r1 = r0 + 1
            r0 = r2[r0]
            long r7 = (long) r0
            r0 = 35
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L74
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
            goto L2b
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
            goto L3c
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
            goto L2b
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
            if (r1 >= 0) goto L3d
            int r1 = r0 + 1
            r0 = r2[r0]
            long r7 = (long) r0
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto Lbb
        Lb6:
            long r0 = r9.D()
            return r0
        Lbb:
            r9.f25409e = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.p002reflect.jvm.internal.impl.protobuf.e.C():long");
    }

    long D() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte bW = w();
            j2 |= ((long) (bW & 127)) << i2;
            if ((bW & 128) == 0) {
                return j2;
            }
        }
        throw InvalidProtocolBufferException.f();
    }

    public int E() throws IOException {
        return y();
    }

    public long F() throws IOException {
        return z();
    }

    public int G() throws IOException {
        return b(A());
    }

    public long H() throws IOException {
        return c(C());
    }

    public String I() throws IOException {
        int iA = A();
        if (iA > this.f25407c - this.f25409e || iA <= 0) {
            return iA == 0 ? HttpUrl.FRAGMENT_ENCODE_SET : new String(x(iA), "UTF-8");
        }
        String str = new String(this.a, this.f25409e, iA, "UTF-8");
        this.f25409e += iA;
        return str;
    }

    public String J() throws IOException {
        byte[] bArrX;
        int iA = A();
        int i2 = this.f25409e;
        if (iA <= this.f25407c - i2 && iA > 0) {
            bArrX = this.a;
            this.f25409e = i2 + iA;
        } else {
            if (iA == 0) {
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
            bArrX = x(iA);
            i2 = 0;
        }
        if (v.f(bArrX, i2, i2 + iA)) {
            return new String(bArrX, i2, iA, "UTF-8");
        }
        throw InvalidProtocolBufferException.d();
    }

    public int K() throws IOException {
        if (f()) {
            this.f25411g = 0;
            return 0;
        }
        int iA = A();
        this.f25411g = iA;
        if (w.a(iA) != 0) {
            return this.f25411g;
        }
        throw InvalidProtocolBufferException.c();
    }

    public int L() throws IOException {
        return A();
    }

    public long M() throws IOException {
        return C();
    }

    public boolean P(int i2, CodedOutputStream codedOutputStream) throws IOException {
        int iB = w.b(i2);
        if (iB == 0) {
            long jT = t();
            codedOutputStream.o0(i2);
            codedOutputStream.z0(jT);
            return true;
        }
        if (iB == 1) {
            long jZ = z();
            codedOutputStream.o0(i2);
            codedOutputStream.V(jZ);
            return true;
        }
        if (iB == 2) {
            d dVarL = l();
            codedOutputStream.o0(i2);
            codedOutputStream.P(dVarL);
            return true;
        }
        if (iB == 3) {
            codedOutputStream.o0(i2);
            Q(codedOutputStream);
            int iC = w.c(w.a(i2), 4);
            a(iC);
            codedOutputStream.o0(iC);
            return true;
        }
        if (iB == 4) {
            return false;
        }
        if (iB != 5) {
            throw InvalidProtocolBufferException.e();
        }
        int iY = y();
        codedOutputStream.o0(i2);
        codedOutputStream.U(iY);
        return true;
    }

    public void Q(CodedOutputStream codedOutputStream) throws IOException {
        int iK;
        do {
            iK = K();
            if (iK == 0) {
                return;
            }
        } while (P(iK, codedOutputStream));
    }

    public void R(int i2) throws IOException {
        int i3 = this.f25407c;
        int i4 = this.f25409e;
        if (i2 > i3 - i4 || i2 < 0) {
            S(i2);
        } else {
            this.f25409e = i4 + i2;
        }
    }

    public void a(int i2) throws InvalidProtocolBufferException {
        if (this.f25411g != i2) {
            throw InvalidProtocolBufferException.b();
        }
    }

    public int e() {
        int i2 = this.f25414j;
        if (i2 == Integer.MAX_VALUE) {
            return -1;
        }
        return i2 - (this.f25413i + this.f25409e);
    }

    public boolean f() throws IOException {
        return this.f25409e == this.f25407c && !T(1);
    }

    public void i(int i2) {
        this.f25414j = i2;
        N();
    }

    public int j(int i2) throws InvalidProtocolBufferException {
        if (i2 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        int i3 = i2 + this.f25413i + this.f25409e;
        int i4 = this.f25414j;
        if (i3 > i4) {
            throw InvalidProtocolBufferException.k();
        }
        this.f25414j = i3;
        N();
        return i4;
    }

    public boolean k() throws IOException {
        return C() != 0;
    }

    public d l() throws IOException {
        int iA = A();
        int i2 = this.f25407c;
        int i3 = this.f25409e;
        if (iA > i2 - i3 || iA <= 0) {
            return iA == 0 ? d.f25399f : new n(x(iA));
        }
        d cVar = (this.f25406b && this.f25412h) ? new c(this.a, this.f25409e, iA) : d.i(this.a, i3, iA);
        this.f25409e += iA;
        return cVar;
    }

    public double m() throws IOException {
        return Double.longBitsToDouble(z());
    }

    public int n() throws IOException {
        return A();
    }

    public int o() throws IOException {
        return y();
    }

    public long p() throws IOException {
        return z();
    }

    public float q() throws IOException {
        return Float.intBitsToFloat(y());
    }

    public void r(int i2, o.a aVar, f fVar) throws IOException {
        int i3 = this.f25415k;
        if (i3 >= this.l) {
            throw InvalidProtocolBufferException.h();
        }
        this.f25415k = i3 + 1;
        aVar.i(this, fVar);
        a(w.c(i2, 4));
        this.f25415k--;
    }

    public int s() throws IOException {
        return A();
    }

    public long t() throws IOException {
        return C();
    }

    public <T extends o> T u(q<T> qVar, f fVar) throws IOException {
        int iA = A();
        if (this.f25415k >= this.l) {
            throw InvalidProtocolBufferException.h();
        }
        int iJ = j(iA);
        this.f25415k++;
        T tB = qVar.b(this, fVar);
        a(0);
        this.f25415k--;
        i(iJ);
        return tB;
    }

    public void v(o.a aVar, f fVar) throws IOException {
        int iA = A();
        if (this.f25415k >= this.l) {
            throw InvalidProtocolBufferException.h();
        }
        int iJ = j(iA);
        this.f25415k++;
        aVar.i(this, fVar);
        a(0);
        this.f25415k--;
        i(iJ);
    }

    public byte w() throws IOException {
        if (this.f25409e == this.f25407c) {
            O(1);
        }
        byte[] bArr = this.a;
        int i2 = this.f25409e;
        this.f25409e = i2 + 1;
        return bArr[i2];
    }

    public int y() throws IOException {
        int i2 = this.f25409e;
        if (this.f25407c - i2 < 4) {
            O(4);
            i2 = this.f25409e;
        }
        byte[] bArr = this.a;
        this.f25409e = i2 + 4;
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public long z() throws IOException {
        int i2 = this.f25409e;
        if (this.f25407c - i2 < 8) {
            O(8);
            i2 = this.f25409e;
        }
        byte[] bArr = this.a;
        this.f25409e = i2 + 8;
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    private e(n nVar) {
        this.f25412h = false;
        this.f25414j = Integer.MAX_VALUE;
        this.l = 64;
        this.m = 67108864;
        this.n = null;
        this.a = nVar.f25448g;
        int iM = nVar.M();
        this.f25409e = iM;
        this.f25407c = iM + nVar.size();
        this.f25413i = -this.f25409e;
        this.f25410f = null;
        this.f25406b = true;
    }
}
