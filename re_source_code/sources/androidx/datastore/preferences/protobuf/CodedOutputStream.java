package androidx.datastore.preferences.protobuf;

import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class CodedOutputStream extends g {
    private static final Logger a = Logger.getLogger(CodedOutputStream.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f1240b = p1.C();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    l f1241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1242d;

    public static class OutOfSpaceException extends IOException {
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        OutOfSpaceException(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    private static abstract class b extends CodedOutputStream {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final byte[] f1243e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f1244f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f1245g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f1246h;

        b(int i2) {
            super();
            if (i2 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i2, 20)];
            this.f1243e = bArr;
            this.f1244f = bArr.length;
        }

        final void b1(byte b2) {
            byte[] bArr = this.f1243e;
            int i2 = this.f1245g;
            this.f1245g = i2 + 1;
            bArr[i2] = b2;
            this.f1246h++;
        }

        final void c1(int i2) {
            byte[] bArr = this.f1243e;
            int i3 = this.f1245g;
            int i4 = i3 + 1;
            this.f1245g = i4;
            bArr[i3] = (byte) (i2 & 255);
            int i5 = i4 + 1;
            this.f1245g = i5;
            bArr[i4] = (byte) ((i2 >> 8) & 255);
            int i6 = i5 + 1;
            this.f1245g = i6;
            bArr[i5] = (byte) ((i2 >> 16) & 255);
            this.f1245g = i6 + 1;
            bArr[i6] = (byte) ((i2 >> 24) & 255);
            this.f1246h += 4;
        }

        final void d1(long j2) {
            byte[] bArr = this.f1243e;
            int i2 = this.f1245g;
            int i3 = i2 + 1;
            this.f1245g = i3;
            bArr[i2] = (byte) (j2 & 255);
            int i4 = i3 + 1;
            this.f1245g = i4;
            bArr[i3] = (byte) ((j2 >> 8) & 255);
            int i5 = i4 + 1;
            this.f1245g = i5;
            bArr[i4] = (byte) ((j2 >> 16) & 255);
            int i6 = i5 + 1;
            this.f1245g = i6;
            bArr[i5] = (byte) (255 & (j2 >> 24));
            int i7 = i6 + 1;
            this.f1245g = i7;
            bArr[i6] = (byte) (((int) (j2 >> 32)) & 255);
            int i8 = i7 + 1;
            this.f1245g = i8;
            bArr[i7] = (byte) (((int) (j2 >> 40)) & 255);
            int i9 = i8 + 1;
            this.f1245g = i9;
            bArr[i8] = (byte) (((int) (j2 >> 48)) & 255);
            this.f1245g = i9 + 1;
            bArr[i9] = (byte) (((int) (j2 >> 56)) & 255);
            this.f1246h += 8;
        }

        final void e1(int i2) {
            if (i2 >= 0) {
                g1(i2);
            } else {
                h1(i2);
            }
        }

        final void f1(int i2, int i3) {
            g1(r1.c(i2, i3));
        }

        final void g1(int i2) {
            if (!CodedOutputStream.f1240b) {
                while ((i2 & (-128)) != 0) {
                    byte[] bArr = this.f1243e;
                    int i3 = this.f1245g;
                    this.f1245g = i3 + 1;
                    bArr[i3] = (byte) ((i2 & 127) | 128);
                    this.f1246h++;
                    i2 >>>= 7;
                }
                byte[] bArr2 = this.f1243e;
                int i4 = this.f1245g;
                this.f1245g = i4 + 1;
                bArr2[i4] = (byte) i2;
                this.f1246h++;
                return;
            }
            long j2 = this.f1245g;
            while ((i2 & (-128)) != 0) {
                byte[] bArr3 = this.f1243e;
                int i5 = this.f1245g;
                this.f1245g = i5 + 1;
                p1.H(bArr3, i5, (byte) ((i2 & 127) | 128));
                i2 >>>= 7;
            }
            byte[] bArr4 = this.f1243e;
            int i6 = this.f1245g;
            this.f1245g = i6 + 1;
            p1.H(bArr4, i6, (byte) i2);
            this.f1246h += (int) (((long) this.f1245g) - j2);
        }

        final void h1(long j2) {
            if (!CodedOutputStream.f1240b) {
                while ((j2 & (-128)) != 0) {
                    byte[] bArr = this.f1243e;
                    int i2 = this.f1245g;
                    this.f1245g = i2 + 1;
                    bArr[i2] = (byte) ((((int) j2) & 127) | 128);
                    this.f1246h++;
                    j2 >>>= 7;
                }
                byte[] bArr2 = this.f1243e;
                int i3 = this.f1245g;
                this.f1245g = i3 + 1;
                bArr2[i3] = (byte) j2;
                this.f1246h++;
                return;
            }
            long j3 = this.f1245g;
            while ((j2 & (-128)) != 0) {
                byte[] bArr3 = this.f1243e;
                int i4 = this.f1245g;
                this.f1245g = i4 + 1;
                p1.H(bArr3, i4, (byte) ((((int) j2) & 127) | 128));
                j2 >>>= 7;
            }
            byte[] bArr4 = this.f1243e;
            int i5 = this.f1245g;
            this.f1245g = i5 + 1;
            p1.H(bArr4, i5, (byte) j2);
            this.f1246h += (int) (((long) this.f1245g) - j3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final int i0() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    private static class c extends CodedOutputStream {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final byte[] f1247e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f1248f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f1249g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f1250h;

        c(byte[] bArr, int i2, int i3) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i4 = i2 + i3;
            if ((i2 | i3 | (bArr.length - i4)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
            }
            this.f1247e = bArr;
            this.f1248f = i2;
            this.f1250h = i2;
            this.f1249g = i4;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void E0(int i2, int i3) throws IOException {
            W0(i2, 0);
            F0(i3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void F0(int i2) throws IOException {
            if (i2 >= 0) {
                Y0(i2);
            } else {
                a1(i2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        final void I0(int i2, q0 q0Var, f1 f1Var) throws IOException {
            W0(i2, 2);
            Y0(((androidx.datastore.preferences.protobuf.a) q0Var).k(f1Var));
            f1Var.h(q0Var, this.f1241c);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void J0(q0 q0Var) throws IOException {
            Y0(q0Var.e());
            q0Var.i(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void K0(int i2, q0 q0Var) throws IOException {
            W0(1, 3);
            X0(2, i2);
            c1(3, q0Var);
            W0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void L0(int i2, h hVar) throws IOException {
            W0(1, 3);
            X0(2, i2);
            o0(3, hVar);
            W0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void U0(int i2, String str) throws IOException {
            W0(i2, 2);
            V0(str);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void V0(String str) throws IOException {
            int i2 = this.f1250h;
            try {
                int iX = CodedOutputStream.X(str.length() * 3);
                int iX2 = CodedOutputStream.X(str.length());
                if (iX2 == iX) {
                    int i3 = i2 + iX2;
                    this.f1250h = i3;
                    int iF = q1.f(str, this.f1247e, i3, i0());
                    this.f1250h = i2;
                    Y0((iF - i2) - iX2);
                    this.f1250h = iF;
                } else {
                    Y0(q1.g(str));
                    this.f1250h = q1.f(str, this.f1247e, this.f1250h, i0());
                }
            } catch (q1.d e2) {
                this.f1250h = i2;
                d0(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void W0(int i2, int i3) throws IOException {
            Y0(r1.c(i2, i3));
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void X0(int i2, int i3) throws IOException {
            W0(i2, 0);
            Y0(i3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void Y0(int i2) throws IOException {
            if (!CodedOutputStream.f1240b || androidx.datastore.preferences.protobuf.d.c() || i0() < 5) {
                while ((i2 & (-128)) != 0) {
                    try {
                        byte[] bArr = this.f1247e;
                        int i3 = this.f1250h;
                        this.f1250h = i3 + 1;
                        bArr[i3] = (byte) ((i2 & 127) | 128);
                        i2 >>>= 7;
                    } catch (IndexOutOfBoundsException e2) {
                        throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1250h), Integer.valueOf(this.f1249g), 1), e2);
                    }
                }
                byte[] bArr2 = this.f1247e;
                int i4 = this.f1250h;
                this.f1250h = i4 + 1;
                bArr2[i4] = (byte) i2;
                return;
            }
            if ((i2 & (-128)) == 0) {
                byte[] bArr3 = this.f1247e;
                int i5 = this.f1250h;
                this.f1250h = i5 + 1;
                p1.H(bArr3, i5, (byte) i2);
                return;
            }
            byte[] bArr4 = this.f1247e;
            int i6 = this.f1250h;
            this.f1250h = i6 + 1;
            p1.H(bArr4, i6, (byte) (i2 | 128));
            int i7 = i2 >>> 7;
            if ((i7 & (-128)) == 0) {
                byte[] bArr5 = this.f1247e;
                int i8 = this.f1250h;
                this.f1250h = i8 + 1;
                p1.H(bArr5, i8, (byte) i7);
                return;
            }
            byte[] bArr6 = this.f1247e;
            int i9 = this.f1250h;
            this.f1250h = i9 + 1;
            p1.H(bArr6, i9, (byte) (i7 | 128));
            int i10 = i7 >>> 7;
            if ((i10 & (-128)) == 0) {
                byte[] bArr7 = this.f1247e;
                int i11 = this.f1250h;
                this.f1250h = i11 + 1;
                p1.H(bArr7, i11, (byte) i10);
                return;
            }
            byte[] bArr8 = this.f1247e;
            int i12 = this.f1250h;
            this.f1250h = i12 + 1;
            p1.H(bArr8, i12, (byte) (i10 | 128));
            int i13 = i10 >>> 7;
            if ((i13 & (-128)) == 0) {
                byte[] bArr9 = this.f1247e;
                int i14 = this.f1250h;
                this.f1250h = i14 + 1;
                p1.H(bArr9, i14, (byte) i13);
                return;
            }
            byte[] bArr10 = this.f1247e;
            int i15 = this.f1250h;
            this.f1250h = i15 + 1;
            p1.H(bArr10, i15, (byte) (i13 | 128));
            byte[] bArr11 = this.f1247e;
            int i16 = this.f1250h;
            this.f1250h = i16 + 1;
            p1.H(bArr11, i16, (byte) (i13 >>> 7));
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void Z0(int i2, long j2) throws IOException {
            W0(i2, 0);
            a1(j2);
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public final void a(byte[] bArr, int i2, int i3) throws IOException {
            b1(bArr, i2, i3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void a1(long j2) throws IOException {
            if (CodedOutputStream.f1240b && i0() >= 10) {
                while ((j2 & (-128)) != 0) {
                    byte[] bArr = this.f1247e;
                    int i2 = this.f1250h;
                    this.f1250h = i2 + 1;
                    p1.H(bArr, i2, (byte) ((((int) j2) & 127) | 128));
                    j2 >>>= 7;
                }
                byte[] bArr2 = this.f1247e;
                int i3 = this.f1250h;
                this.f1250h = i3 + 1;
                p1.H(bArr2, i3, (byte) j2);
                return;
            }
            while ((j2 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f1247e;
                    int i4 = this.f1250h;
                    this.f1250h = i4 + 1;
                    bArr3[i4] = (byte) ((((int) j2) & 127) | 128);
                    j2 >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1250h), Integer.valueOf(this.f1249g), 1), e2);
                }
            }
            byte[] bArr4 = this.f1247e;
            int i5 = this.f1250h;
            this.f1250h = i5 + 1;
            bArr4[i5] = (byte) j2;
        }

        public final void b1(byte[] bArr, int i2, int i3) throws IOException {
            try {
                System.arraycopy(bArr, i2, this.f1247e, this.f1250h, i3);
                this.f1250h += i3;
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1250h), Integer.valueOf(this.f1249g), Integer.valueOf(i3)), e2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void c0() {
        }

        public final void c1(int i2, q0 q0Var) throws IOException {
            W0(i2, 2);
            J0(q0Var);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final int i0() {
            return this.f1249g - this.f1250h;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void j0(byte b2) throws IOException {
            try {
                byte[] bArr = this.f1247e;
                int i2 = this.f1250h;
                this.f1250h = i2 + 1;
                bArr[i2] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1250h), Integer.valueOf(this.f1249g), 1), e2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void k0(int i2, boolean z) throws IOException {
            W0(i2, 0);
            j0(z ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void n0(byte[] bArr, int i2, int i3) throws IOException {
            Y0(i3);
            b1(bArr, i2, i3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void o0(int i2, h hVar) throws IOException {
            W0(i2, 2);
            p0(hVar);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void p0(h hVar) throws IOException {
            Y0(hVar.size());
            hVar.L(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void u0(int i2, int i3) throws IOException {
            W0(i2, 5);
            v0(i3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void v0(int i2) throws IOException {
            try {
                byte[] bArr = this.f1247e;
                int i3 = this.f1250h;
                int i4 = i3 + 1;
                this.f1250h = i4;
                bArr[i3] = (byte) (i2 & 255);
                int i5 = i4 + 1;
                this.f1250h = i5;
                bArr[i4] = (byte) ((i2 >> 8) & 255);
                int i6 = i5 + 1;
                this.f1250h = i6;
                bArr[i5] = (byte) ((i2 >> 16) & 255);
                this.f1250h = i6 + 1;
                bArr[i6] = (byte) ((i2 >> 24) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1250h), Integer.valueOf(this.f1249g), 1), e2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void w0(int i2, long j2) throws IOException {
            W0(i2, 1);
            x0(j2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void x0(long j2) throws IOException {
            try {
                byte[] bArr = this.f1247e;
                int i2 = this.f1250h;
                int i3 = i2 + 1;
                this.f1250h = i3;
                bArr[i2] = (byte) (((int) j2) & 255);
                int i4 = i3 + 1;
                this.f1250h = i4;
                bArr[i3] = (byte) (((int) (j2 >> 8)) & 255);
                int i5 = i4 + 1;
                this.f1250h = i5;
                bArr[i4] = (byte) (((int) (j2 >> 16)) & 255);
                int i6 = i5 + 1;
                this.f1250h = i6;
                bArr[i5] = (byte) (((int) (j2 >> 24)) & 255);
                int i7 = i6 + 1;
                this.f1250h = i7;
                bArr[i6] = (byte) (((int) (j2 >> 32)) & 255);
                int i8 = i7 + 1;
                this.f1250h = i8;
                bArr[i7] = (byte) (((int) (j2 >> 40)) & 255);
                int i9 = i8 + 1;
                this.f1250h = i9;
                bArr[i8] = (byte) (((int) (j2 >> 48)) & 255);
                this.f1250h = i9 + 1;
                bArr[i9] = (byte) (((int) (j2 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1250h), Integer.valueOf(this.f1249g), 1), e2);
            }
        }
    }

    private static final class d extends b {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final OutputStream f1251i;

        d(OutputStream outputStream, int i2) {
            super(i2);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.f1251i = outputStream;
        }

        private void i1() throws IOException {
            this.f1251i.write(this.f1243e, 0, this.f1245g);
            this.f1245g = 0;
        }

        private void j1(int i2) throws IOException {
            if (this.f1244f - this.f1245g < i2) {
                i1();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void E0(int i2, int i3) throws IOException {
            j1(20);
            f1(i2, 0);
            e1(i3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void F0(int i2) throws IOException {
            if (i2 >= 0) {
                Y0(i2);
            } else {
                a1(i2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        void I0(int i2, q0 q0Var, f1 f1Var) throws IOException {
            W0(i2, 2);
            m1(q0Var, f1Var);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void J0(q0 q0Var) throws IOException {
            Y0(q0Var.e());
            q0Var.i(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void K0(int i2, q0 q0Var) throws IOException {
            W0(1, 3);
            X0(2, i2);
            l1(3, q0Var);
            W0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void L0(int i2, h hVar) throws IOException {
            W0(1, 3);
            X0(2, i2);
            o0(3, hVar);
            W0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void U0(int i2, String str) throws IOException {
            W0(i2, 2);
            V0(str);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void V0(String str) throws IOException {
            int iG;
            try {
                int length = str.length() * 3;
                int iX = CodedOutputStream.X(length);
                int i2 = iX + length;
                int i3 = this.f1244f;
                if (i2 > i3) {
                    byte[] bArr = new byte[length];
                    int iF = q1.f(str, bArr, 0, length);
                    Y0(iF);
                    a(bArr, 0, iF);
                    return;
                }
                if (i2 > i3 - this.f1245g) {
                    i1();
                }
                int iX2 = CodedOutputStream.X(str.length());
                int i4 = this.f1245g;
                try {
                    if (iX2 == iX) {
                        int i5 = i4 + iX2;
                        this.f1245g = i5;
                        int iF2 = q1.f(str, this.f1243e, i5, this.f1244f - i5);
                        this.f1245g = i4;
                        iG = (iF2 - i4) - iX2;
                        g1(iG);
                        this.f1245g = iF2;
                    } else {
                        iG = q1.g(str);
                        g1(iG);
                        this.f1245g = q1.f(str, this.f1243e, this.f1245g, iG);
                    }
                    this.f1246h += iG;
                } catch (q1.d e2) {
                    this.f1246h -= this.f1245g - i4;
                    this.f1245g = i4;
                    throw e2;
                } catch (ArrayIndexOutOfBoundsException e3) {
                    throw new OutOfSpaceException(e3);
                }
            } catch (q1.d e4) {
                d0(str, e4);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void W0(int i2, int i3) throws IOException {
            Y0(r1.c(i2, i3));
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void X0(int i2, int i3) throws IOException {
            j1(20);
            f1(i2, 0);
            g1(i3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void Y0(int i2) throws IOException {
            j1(5);
            g1(i2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void Z0(int i2, long j2) throws IOException {
            j1(20);
            f1(i2, 0);
            h1(j2);
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public void a(byte[] bArr, int i2, int i3) throws IOException {
            k1(bArr, i2, i3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void a1(long j2) throws IOException {
            j1(10);
            h1(j2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void c0() throws IOException {
            if (this.f1245g > 0) {
                i1();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void j0(byte b2) throws IOException {
            if (this.f1245g == this.f1244f) {
                i1();
            }
            b1(b2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void k0(int i2, boolean z) throws IOException {
            j1(11);
            f1(i2, 0);
            b1(z ? (byte) 1 : (byte) 0);
        }

        public void k1(byte[] bArr, int i2, int i3) throws IOException {
            int i4 = this.f1244f;
            int i5 = this.f1245g;
            if (i4 - i5 >= i3) {
                System.arraycopy(bArr, i2, this.f1243e, i5, i3);
                this.f1245g += i3;
                this.f1246h += i3;
                return;
            }
            int i6 = i4 - i5;
            System.arraycopy(bArr, i2, this.f1243e, i5, i6);
            int i7 = i2 + i6;
            int i8 = i3 - i6;
            this.f1245g = this.f1244f;
            this.f1246h += i6;
            i1();
            if (i8 <= this.f1244f) {
                System.arraycopy(bArr, i7, this.f1243e, 0, i8);
                this.f1245g = i8;
            } else {
                this.f1251i.write(bArr, i7, i8);
            }
            this.f1246h += i8;
        }

        public void l1(int i2, q0 q0Var) throws IOException {
            W0(i2, 2);
            J0(q0Var);
        }

        void m1(q0 q0Var, f1 f1Var) throws IOException {
            Y0(((androidx.datastore.preferences.protobuf.a) q0Var).k(f1Var));
            f1Var.h(q0Var, this.f1241c);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void n0(byte[] bArr, int i2, int i3) throws IOException {
            Y0(i3);
            k1(bArr, i2, i3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void o0(int i2, h hVar) throws IOException {
            W0(i2, 2);
            p0(hVar);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void p0(h hVar) throws IOException {
            Y0(hVar.size());
            hVar.L(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void u0(int i2, int i3) throws IOException {
            j1(14);
            f1(i2, 5);
            c1(i3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void v0(int i2) throws IOException {
            j1(4);
            c1(i2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void w0(int i2, long j2) throws IOException {
            j1(18);
            f1(i2, 1);
            d1(j2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void x0(long j2) throws IOException {
            j1(8);
            d1(j2);
        }
    }

    public static int A(int i2, d0 d0Var) {
        return V(i2) + B(d0Var);
    }

    public static int B(d0 d0Var) {
        return C(d0Var.b());
    }

    static int C(int i2) {
        return X(i2) + i2;
    }

    public static int D(int i2, q0 q0Var) {
        return (V(1) * 2) + W(2, i2) + E(3, q0Var);
    }

    public static int E(int i2, q0 q0Var) {
        return V(i2) + G(q0Var);
    }

    static int F(int i2, q0 q0Var, f1 f1Var) {
        return V(i2) + H(q0Var, f1Var);
    }

    public static int G(q0 q0Var) {
        return C(q0Var.e());
    }

    static int H(q0 q0Var, f1 f1Var) {
        return C(((androidx.datastore.preferences.protobuf.a) q0Var).k(f1Var));
    }

    static int I(int i2) {
        return i2 > 4096 ? RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT : i2;
    }

    public static int J(int i2, h hVar) {
        return (V(1) * 2) + W(2, i2) + g(3, hVar);
    }

    @Deprecated
    public static int K(int i2) {
        return X(i2);
    }

    public static int L(int i2, int i3) {
        return V(i2) + M(i3);
    }

    public static int M(int i2) {
        return 4;
    }

    public static int N(int i2, long j2) {
        return V(i2) + O(j2);
    }

    public static int O(long j2) {
        return 8;
    }

    public static int P(int i2, int i3) {
        return V(i2) + Q(i3);
    }

    public static int Q(int i2) {
        return X(a0(i2));
    }

    public static int R(int i2, long j2) {
        return V(i2) + S(j2);
    }

    public static int S(long j2) {
        return Z(b0(j2));
    }

    public static int T(int i2, String str) {
        return V(i2) + U(str);
    }

    public static int U(String str) {
        int length;
        try {
            length = q1.g(str);
        } catch (q1.d unused) {
            length = str.getBytes(a0.a).length;
        }
        return C(length);
    }

    public static int V(int i2) {
        return X(r1.c(i2, 0));
    }

    public static int W(int i2, int i3) {
        return V(i2) + X(i3);
    }

    public static int X(int i2) {
        if ((i2 & (-128)) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int Y(int i2, long j2) {
        return V(i2) + Z(j2);
    }

    public static int Z(long j2) {
        int i2;
        if (((-128) & j2) == 0) {
            return 1;
        }
        if (j2 < 0) {
            return 10;
        }
        if (((-34359738368L) & j2) != 0) {
            i2 = 6;
            j2 >>>= 28;
        } else {
            i2 = 2;
        }
        if (((-2097152) & j2) != 0) {
            i2 += 2;
            j2 >>>= 14;
        }
        return (j2 & (-16384)) != 0 ? i2 + 1 : i2;
    }

    public static int a0(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    public static long b0(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    public static int d(int i2, boolean z) {
        return V(i2) + e(z);
    }

    public static int e(boolean z) {
        return 1;
    }

    public static int f(byte[] bArr) {
        return C(bArr.length);
    }

    public static CodedOutputStream f0(OutputStream outputStream, int i2) {
        return new d(outputStream, i2);
    }

    public static int g(int i2, h hVar) {
        return V(i2) + h(hVar);
    }

    public static CodedOutputStream g0(byte[] bArr) {
        return h0(bArr, 0, bArr.length);
    }

    public static int h(h hVar) {
        return C(hVar.size());
    }

    public static CodedOutputStream h0(byte[] bArr, int i2, int i3) {
        return new c(bArr, i2, i3);
    }

    public static int i(int i2, double d2) {
        return V(i2) + j(d2);
    }

    public static int j(double d2) {
        return 8;
    }

    public static int k(int i2, int i3) {
        return V(i2) + l(i3);
    }

    public static int l(int i2) {
        return w(i2);
    }

    public static int m(int i2, int i3) {
        return V(i2) + n(i3);
    }

    public static int n(int i2) {
        return 4;
    }

    public static int o(int i2, long j2) {
        return V(i2) + p(j2);
    }

    public static int p(long j2) {
        return 8;
    }

    public static int q(int i2, float f2) {
        return V(i2) + r(f2);
    }

    public static int r(float f2) {
        return 4;
    }

    @Deprecated
    static int s(int i2, q0 q0Var, f1 f1Var) {
        return (V(i2) * 2) + u(q0Var, f1Var);
    }

    @Deprecated
    public static int t(q0 q0Var) {
        return q0Var.e();
    }

    @Deprecated
    static int u(q0 q0Var, f1 f1Var) {
        return ((androidx.datastore.preferences.protobuf.a) q0Var).k(f1Var);
    }

    public static int v(int i2, int i3) {
        return V(i2) + w(i3);
    }

    public static int w(int i2) {
        if (i2 >= 0) {
            return X(i2);
        }
        return 10;
    }

    public static int x(int i2, long j2) {
        return V(i2) + y(j2);
    }

    public static int y(long j2) {
        return Z(j2);
    }

    public static int z(int i2, d0 d0Var) {
        return (V(1) * 2) + W(2, i2) + A(3, d0Var);
    }

    @Deprecated
    public final void A0(int i2, q0 q0Var) throws IOException {
        W0(i2, 3);
        C0(q0Var);
        W0(i2, 4);
    }

    @Deprecated
    final void B0(int i2, q0 q0Var, f1 f1Var) throws IOException {
        W0(i2, 3);
        D0(q0Var, f1Var);
        W0(i2, 4);
    }

    @Deprecated
    public final void C0(q0 q0Var) throws IOException {
        q0Var.i(this);
    }

    @Deprecated
    final void D0(q0 q0Var, f1 f1Var) throws IOException {
        f1Var.h(q0Var, this.f1241c);
    }

    public abstract void E0(int i2, int i3) throws IOException;

    public abstract void F0(int i2) throws IOException;

    public final void G0(int i2, long j2) throws IOException {
        Z0(i2, j2);
    }

    public final void H0(long j2) throws IOException {
        a1(j2);
    }

    abstract void I0(int i2, q0 q0Var, f1 f1Var) throws IOException;

    public abstract void J0(q0 q0Var) throws IOException;

    public abstract void K0(int i2, q0 q0Var) throws IOException;

    public abstract void L0(int i2, h hVar) throws IOException;

    public final void M0(int i2, int i3) throws IOException {
        u0(i2, i3);
    }

    public final void N0(int i2) throws IOException {
        v0(i2);
    }

    public final void O0(int i2, long j2) throws IOException {
        w0(i2, j2);
    }

    public final void P0(long j2) throws IOException {
        x0(j2);
    }

    public final void Q0(int i2, int i3) throws IOException {
        X0(i2, a0(i3));
    }

    public final void R0(int i2) throws IOException {
        Y0(a0(i2));
    }

    public final void S0(int i2, long j2) throws IOException {
        Z0(i2, b0(j2));
    }

    public final void T0(long j2) throws IOException {
        a1(b0(j2));
    }

    public abstract void U0(int i2, String str) throws IOException;

    public abstract void V0(String str) throws IOException;

    public abstract void W0(int i2, int i3) throws IOException;

    public abstract void X0(int i2, int i3) throws IOException;

    public abstract void Y0(int i2) throws IOException;

    public abstract void Z0(int i2, long j2) throws IOException;

    public abstract void a1(long j2) throws IOException;

    public final void c() {
        if (i0() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void c0() throws IOException;

    final void d0(String str, q1.d dVar) throws IOException {
        a.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) dVar);
        byte[] bytes = str.getBytes(a0.a);
        try {
            Y0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (OutOfSpaceException e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new OutOfSpaceException(e3);
        }
    }

    boolean e0() {
        return this.f1242d;
    }

    public abstract int i0();

    public abstract void j0(byte b2) throws IOException;

    public abstract void k0(int i2, boolean z) throws IOException;

    public final void l0(boolean z) throws IOException {
        j0(z ? (byte) 1 : (byte) 0);
    }

    public final void m0(byte[] bArr) throws IOException {
        n0(bArr, 0, bArr.length);
    }

    abstract void n0(byte[] bArr, int i2, int i3) throws IOException;

    public abstract void o0(int i2, h hVar) throws IOException;

    public abstract void p0(h hVar) throws IOException;

    public final void q0(int i2, double d2) throws IOException {
        w0(i2, Double.doubleToRawLongBits(d2));
    }

    public final void r0(double d2) throws IOException {
        x0(Double.doubleToRawLongBits(d2));
    }

    public final void s0(int i2, int i3) throws IOException {
        E0(i2, i3);
    }

    public final void t0(int i2) throws IOException {
        F0(i2);
    }

    public abstract void u0(int i2, int i3) throws IOException;

    public abstract void v0(int i2) throws IOException;

    public abstract void w0(int i2, long j2) throws IOException;

    public abstract void x0(long j2) throws IOException;

    public final void y0(int i2, float f2) throws IOException {
        u0(i2, Float.floatToRawIntBits(f2));
    }

    public final void z0(float f2) throws IOException {
        v0(Float.floatToRawIntBits(f2));
    }

    private CodedOutputStream() {
    }
}
