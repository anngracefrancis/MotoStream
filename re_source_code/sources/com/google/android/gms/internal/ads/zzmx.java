package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class zzmx implements zzlx {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private i10 f16473d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ByteBuffer f16476g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ShortBuffer f16477h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ByteBuffer f16478i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f16479j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f16480k;
    private boolean l;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f16474e = 1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f16475f = 1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16471b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16472c = -1;

    public zzmx() {
        ByteBuffer byteBuffer = zzlx.a;
        this.f16476g = byteBuffer;
        this.f16477h = byteBuffer.asShortBuffer();
        this.f16478i = byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final boolean C() {
        if (!this.l) {
            return false;
        }
        i10 i10Var = this.f16473d;
        return i10Var == null || i10Var.l() == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void a() {
        this.f16473d = null;
        ByteBuffer byteBuffer = zzlx.a;
        this.f16476g = byteBuffer;
        this.f16477h = byteBuffer.asShortBuffer();
        this.f16478i = byteBuffer;
        this.f16471b = -1;
        this.f16472c = -1;
        this.f16479j = 0L;
        this.f16480k = 0L;
        this.l = false;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final boolean b() {
        return Math.abs(this.f16474e - 1.0f) >= 0.01f || Math.abs(this.f16475f - 1.0f) >= 0.01f;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void c() {
        this.f16473d.k();
        this.l = true;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final ByteBuffer d() {
        ByteBuffer byteBuffer = this.f16478i;
        this.f16478i = zzlx.a;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final int e() {
        return this.f16471b;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final int f() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void flush() {
        i10 i10Var = new i10(this.f16472c, this.f16471b);
        this.f16473d = i10Var;
        i10Var.a(this.f16474e);
        this.f16473d.c(this.f16475f);
        this.f16478i = zzlx.a;
        this.f16479j = 0L;
        this.f16480k = 0L;
        this.l = false;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final boolean g(int i2, int i3, int i4) throws zzly {
        if (i4 != 2) {
            throw new zzly(i2, i3, i4);
        }
        if (this.f16472c == i2 && this.f16471b == i3) {
            return false;
        }
        this.f16472c = i2;
        this.f16471b = i3;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void h(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.f16479j += (long) iRemaining;
            this.f16473d.e(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
        int iL = (this.f16473d.l() * this.f16471b) << 1;
        if (iL > 0) {
            if (this.f16476g.capacity() < iL) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iL).order(ByteOrder.nativeOrder());
                this.f16476g = byteBufferOrder;
                this.f16477h = byteBufferOrder.asShortBuffer();
            } else {
                this.f16476g.clear();
                this.f16477h.clear();
            }
            this.f16473d.i(this.f16477h);
            this.f16480k += (long) iL;
            this.f16476g.limit(iL);
            this.f16478i = this.f16476g;
        }
    }

    public final float i(float f2) {
        float fA = zzsy.a(f2, 0.1f, 8.0f);
        this.f16474e = fA;
        return fA;
    }

    public final float j(float f2) {
        this.f16475f = zzsy.a(f2, 0.1f, 8.0f);
        return f2;
    }

    public final long k() {
        return this.f16479j;
    }

    public final long l() {
        return this.f16480k;
    }
}
