package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdmr implements Serializable, Iterable<Byte> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zzdmr f15982f = new mu(zzdod.f16033c);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final iu f15983g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Comparator<zzdmr> f15984h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f15985i = 0;

    static {
        du duVar = null;
        f15983g = zt.a() ? new nu(duVar) : new gu(duVar);
        f15984h = new eu();
    }

    zzdmr() {
    }

    public static zzdmr A(byte[] bArr, int i2, int i3) {
        y(i2, i2 + i3, bArr.length);
        return new mu(f15983g.a(bArr, i2, i3));
    }

    public static zzdmr D(byte[] bArr) {
        return A(bArr, 0, bArr.length);
    }

    static zzdmr i(byte[] bArr) {
        return new mu(bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int s(byte b2) {
        return b2 & 255;
    }

    static ju x(int i2) {
        return new ju(i2, null);
    }

    static int y(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i2);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i3 < i2) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(i3);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("End index: ");
        sb3.append(i3);
        sb3.append(" >= ");
        sb3.append(i4);
        throw new IndexOutOfBoundsException(sb3.toString());
    }

    public static zzdmr z(String str) {
        return new mu(str.getBytes(zzdod.a));
    }

    public abstract zzdmr C(int i2, int i3);

    public final byte[] c() {
        int size = size();
        if (size == 0) {
            return zzdod.f16033c;
        }
        byte[] bArr = new byte[size];
        h(bArr, 0, 0, size);
        return bArr;
    }

    public abstract boolean equals(Object obj);

    protected abstract String f(Charset charset);

    abstract void g(zzdmq zzdmqVar) throws IOException;

    protected abstract void h(byte[] bArr, int i2, int i3, int i4);

    public final int hashCode() {
        int iU = this.f15985i;
        if (iU == 0) {
            int size = size();
            iU = u(size, 0, size);
            if (iU == 0) {
                iU = 1;
            }
            this.f15985i = iU;
        }
        return iU;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new du(this);
    }

    public final String n() {
        return size() == 0 ? HttpUrl.FRAGMENT_ENCODE_SET : f(zzdod.a);
    }

    public abstract boolean o();

    public abstract zzdnd q();

    protected final int r() {
        return this.f15985i;
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    protected abstract int u(int i2, int i3, int i4);

    public abstract byte v(int i2);

    abstract byte w(int i2);
}
