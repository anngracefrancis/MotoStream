package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class e10 implements zzlx {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f12495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f12496e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int[] f12497f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ByteBuffer f12498g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ByteBuffer f12499h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f12500i;

    public e10() {
        ByteBuffer byteBuffer = zzlx.a;
        this.f12498g = byteBuffer;
        this.f12499h = byteBuffer;
        this.f12493b = -1;
        this.f12494c = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final boolean C() {
        return this.f12500i && this.f12499h == zzlx.a;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void a() {
        flush();
        this.f12498g = zzlx.a;
        this.f12493b = -1;
        this.f12494c = -1;
        this.f12497f = null;
        this.f12496e = false;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final boolean b() {
        return this.f12496e;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void c() {
        this.f12500i = true;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final ByteBuffer d() {
        ByteBuffer byteBuffer = this.f12499h;
        this.f12499h = zzlx.a;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final int e() {
        int[] iArr = this.f12497f;
        return iArr == null ? this.f12493b : iArr.length;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final int f() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void flush() {
        this.f12499h = zzlx.a;
        this.f12500i = false;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final boolean g(int i2, int i3, int i4) throws zzly {
        boolean z = !Arrays.equals(this.f12495d, this.f12497f);
        int[] iArr = this.f12495d;
        this.f12497f = iArr;
        if (iArr == null) {
            this.f12496e = false;
            return z;
        }
        if (i4 != 2) {
            throw new zzly(i2, i3, i4);
        }
        if (!z && this.f12494c == i2 && this.f12493b == i3) {
            return false;
        }
        this.f12494c = i2;
        this.f12493b = i3;
        this.f12496e = i3 != iArr.length;
        int i5 = 0;
        while (true) {
            int[] iArr2 = this.f12497f;
            if (i5 >= iArr2.length) {
                return true;
            }
            int i6 = iArr2[i5];
            if (i6 >= i3) {
                throw new zzly(i2, i3, i4);
            }
            this.f12496e = (i6 != i5) | this.f12496e;
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void h(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int length = (((iLimit - iPosition) / (this.f12493b * 2)) * this.f12497f.length) << 1;
        if (this.f12498g.capacity() < length) {
            this.f12498g = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.f12498g.clear();
        }
        while (iPosition < iLimit) {
            for (int i2 : this.f12497f) {
                this.f12498g.putShort(byteBuffer.getShort((i2 * 2) + iPosition));
            }
            iPosition += this.f12493b << 1;
        }
        byteBuffer.position(iLimit);
        this.f12498g.flip();
        this.f12499h = this.f12498g;
    }

    public final void i(int[] iArr) {
        this.f12495d = iArr;
    }
}
