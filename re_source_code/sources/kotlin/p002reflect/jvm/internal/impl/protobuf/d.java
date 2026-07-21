package kotlin.p002reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: ByteString.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d implements Iterable<Byte> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f25399f = new n(new byte[0]);

    /* JADX INFO: compiled from: ByteString.java */
    public interface a extends Iterator<Byte> {
        byte f();
    }

    d() {
    }

    private static d c(Iterator<d> it, int i2) {
        if (i2 == 1) {
            return it.next();
        }
        int i3 = i2 >>> 1;
        return c(it, i3).f(c(it, i2 - i3));
    }

    public static d g(Iterable<d> iterable) {
        Collection arrayList;
        if (iterable instanceof Collection) {
            arrayList = (Collection) iterable;
        } else {
            arrayList = new ArrayList();
            Iterator<d> it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return arrayList.isEmpty() ? f25399f : c(arrayList.iterator(), arrayList.size());
    }

    public static d h(byte[] bArr) {
        return i(bArr, 0, bArr.length);
    }

    public static d i(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return new n(bArr2);
    }

    public static d n(String str) {
        try {
            return new n(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 not supported?", e2);
        }
    }

    public static b w() {
        return new b(128);
    }

    public byte[] A() {
        int size = size();
        if (size == 0) {
            return i.a;
        }
        byte[] bArr = new byte[size];
        q(bArr, 0, 0, size);
        return bArr;
    }

    public abstract String C(String str) throws UnsupportedEncodingException;

    public String D() {
        try {
            return C("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 not supported?", e2);
        }
    }

    void E(OutputStream outputStream, int i2, int i3) throws IOException {
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Source offset < 0: ");
            sb.append(i2);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i3 < 0) {
            StringBuilder sb2 = new StringBuilder(23);
            sb2.append("Length < 0: ");
            sb2.append(i3);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        int i4 = i2 + i3;
        if (i4 <= size()) {
            if (i3 > 0) {
                F(outputStream, i2, i3);
            }
        } else {
            StringBuilder sb3 = new StringBuilder(39);
            sb3.append("Source end offset exceeded: ");
            sb3.append(i4);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    abstract void F(OutputStream outputStream, int i2, int i3) throws IOException;

    public d f(d dVar) {
        int size = size();
        int size2 = dVar.size();
        if (((long) size) + ((long) size2) < 2147483647L) {
            return s.O(this, dVar);
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("ByteString would be too long: ");
        sb.append(size);
        sb.append("+");
        sb.append(size2);
        throw new IllegalArgumentException(sb.toString());
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void o(byte[] bArr, int i2, int i3, int i4) {
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Source offset < 0: ");
            sb.append(i2);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i3 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Target offset < 0: ");
            sb2.append(i3);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        if (i4 < 0) {
            StringBuilder sb3 = new StringBuilder(23);
            sb3.append("Length < 0: ");
            sb3.append(i4);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        int i5 = i2 + i4;
        if (i5 > size()) {
            StringBuilder sb4 = new StringBuilder(34);
            sb4.append("Source end offset < 0: ");
            sb4.append(i5);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
        int i6 = i3 + i4;
        if (i6 <= bArr.length) {
            if (i4 > 0) {
                q(bArr, i2, i3, i4);
            }
        } else {
            StringBuilder sb5 = new StringBuilder(34);
            sb5.append("Target end offset < 0: ");
            sb5.append(i6);
            throw new IndexOutOfBoundsException(sb5.toString());
        }
    }

    protected abstract void q(byte[] bArr, int i2, int i3, int i4);

    protected abstract int r();

    protected abstract boolean s();

    public abstract int size();

    public abstract boolean t();

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: u */
    public abstract a iterator();

    public abstract e v();

    protected abstract int x(int i2, int i3, int i4);

    protected abstract int y(int i2, int i3, int i4);

    protected abstract int z();

    /* JADX INFO: compiled from: ByteString.java */
    public static final class b extends OutputStream {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final byte[] f25400f = new byte[0];

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f25401g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final ArrayList<d> f25402h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f25403i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private byte[] f25404j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f25405k;

        b(int i2) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Buffer size < 0");
            }
            this.f25401g = i2;
            this.f25402h = new ArrayList<>();
            this.f25404j = new byte[i2];
        }

        private byte[] a(byte[] bArr, int i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i2));
            return bArr2;
        }

        private void b(int i2) {
            this.f25402h.add(new n(this.f25404j));
            int length = this.f25403i + this.f25404j.length;
            this.f25403i = length;
            this.f25404j = new byte[Math.max(this.f25401g, Math.max(i2, length >>> 1))];
            this.f25405k = 0;
        }

        private void c() {
            int i2 = this.f25405k;
            byte[] bArr = this.f25404j;
            if (i2 >= bArr.length) {
                this.f25402h.add(new n(this.f25404j));
                this.f25404j = f25400f;
            } else if (i2 > 0) {
                this.f25402h.add(new n(a(bArr, i2)));
            }
            this.f25403i += this.f25405k;
            this.f25405k = 0;
        }

        public synchronized int d() {
            return this.f25403i + this.f25405k;
        }

        public synchronized d e() {
            c();
            return d.g(this.f25402h);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(d()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i2) {
            if (this.f25405k == this.f25404j.length) {
                b(1);
            }
            byte[] bArr = this.f25404j;
            int i3 = this.f25405k;
            this.f25405k = i3 + 1;
            bArr[i3] = (byte) i2;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i2, int i3) {
            byte[] bArr2 = this.f25404j;
            int length = bArr2.length;
            int i4 = this.f25405k;
            if (i3 <= length - i4) {
                System.arraycopy(bArr, i2, bArr2, i4, i3);
                this.f25405k += i3;
            } else {
                int length2 = bArr2.length - i4;
                System.arraycopy(bArr, i2, bArr2, i4, length2);
                int i5 = i3 - length2;
                b(i5);
                System.arraycopy(bArr, i2 + length2, this.f25404j, 0, i5);
                this.f25405k = i5;
            }
        }
    }
}
