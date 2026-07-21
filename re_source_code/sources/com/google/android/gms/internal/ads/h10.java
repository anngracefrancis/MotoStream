package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
final class h10 implements zzlx {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12675b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12676c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12677d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ByteBuffer f12678e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ByteBuffer f12679f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f12680g;

    public h10() {
        ByteBuffer byteBuffer = zzlx.a;
        this.f12678e = byteBuffer;
        this.f12679f = byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final boolean C() {
        return this.f12680g && this.f12679f == zzlx.a;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void a() {
        flush();
        this.f12678e = zzlx.a;
        this.f12675b = -1;
        this.f12676c = -1;
        this.f12677d = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final boolean b() {
        int i2 = this.f12677d;
        return (i2 == 0 || i2 == 2) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void c() {
        this.f12680g = true;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final ByteBuffer d() {
        ByteBuffer byteBuffer = this.f12679f;
        this.f12679f = zzlx.a;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final int e() {
        return this.f12676c;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final int f() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void flush() {
        this.f12679f = zzlx.a;
        this.f12680g = false;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final boolean g(int i2, int i3, int i4) throws zzly {
        if (i4 != 3 && i4 != 2 && i4 != Integer.MIN_VALUE && i4 != 1073741824) {
            throw new zzly(i2, i3, i4);
        }
        if (this.f12675b == i2 && this.f12676c == i3 && this.f12677d == i4) {
            return false;
        }
        this.f12675b = i2;
        this.f12676c = i3;
        this.f12677d = i4;
        if (i4 != 2) {
            return true;
        }
        this.f12678e = zzlx.a;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002b  */
    /* JADX WARN: Code duplicated, block: B:14:0x003a  */
    /* JADX WARN: Code duplicated, block: B:17:0x0043 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0045 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x0047 A[ADDED_TO_REGION, LOOP:0: B:19:0x0047->B:20:0x0049, LOOP_START, PHI: r0
      0x0047: PHI (r0v6 int) = (r0v0 int), (r0v7 int) binds: [B:18:0x0045, B:20:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:20:0x0049 A[LOOP:0: B:19:0x0047->B:20:0x0049, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:21:0x0062  */
    /* JADX WARN: Code duplicated, block: B:23:0x0068 A[ADDED_TO_REGION, LOOP:1: B:23:0x0068->B:24:0x006a, LOOP_START, PHI: r0
      0x0068: PHI (r0v4 int) = (r0v0 int), (r0v5 int) binds: [B:17:0x0043, B:24:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:24:0x006a A[LOOP:1: B:23:0x0068->B:24:0x006a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:25:0x0081 A[ADDED_TO_REGION, LOOP:2: B:25:0x0081->B:26:0x0083, LOOP_START, PHI: r0
      0x0081: PHI (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:16:0x0041, B:26:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x0083 A[LOOP:2: B:25:0x0081->B:26:0x0083, LOOP_END] */
    @Override // com.google.android.gms.internal.ads.zzlx
    public final void h(ByteBuffer byteBuffer) {
        int i2;
        int i3;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i4 = iLimit - iPosition;
        int i5 = this.f12677d;
        if (i5 != Integer.MIN_VALUE) {
            if (i5 != 3) {
                if (i5 != 1073741824) {
                    throw new IllegalStateException();
                }
                i2 = i4 / 2;
            }
            if (this.f12678e.capacity() < i2) {
                this.f12678e = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
            } else {
                this.f12678e.clear();
            }
            i3 = this.f12677d;
            if (i3 != Integer.MIN_VALUE) {
                while (iPosition < iLimit) {
                    this.f12678e.put(byteBuffer.get(iPosition + 1));
                    this.f12678e.put(byteBuffer.get(iPosition + 2));
                    iPosition += 3;
                }
            } else if (i3 != 3) {
                while (iPosition < iLimit) {
                    this.f12678e.put((byte) 0);
                    this.f12678e.put((byte) ((byteBuffer.get(iPosition) & 255) - 128));
                    iPosition++;
                }
            } else {
                if (i3 == 1073741824) {
                    throw new IllegalStateException();
                }
                while (iPosition < iLimit) {
                    this.f12678e.put(byteBuffer.get(iPosition + 2));
                    this.f12678e.put(byteBuffer.get(iPosition + 3));
                    iPosition += 4;
                }
            }
            byteBuffer.position(byteBuffer.limit());
            this.f12678e.flip();
            this.f12679f = this.f12678e;
        }
        i4 /= 3;
        i2 = i4 << 1;
        if (this.f12678e.capacity() < i2) {
            this.f12678e = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        } else {
            this.f12678e.clear();
        }
        i3 = this.f12677d;
        if (i3 != Integer.MIN_VALUE) {
            while (iPosition < iLimit) {
                this.f12678e.put(byteBuffer.get(iPosition + 1));
                this.f12678e.put(byteBuffer.get(iPosition + 2));
                iPosition += 3;
            }
        } else if (i3 != 3) {
            while (iPosition < iLimit) {
                this.f12678e.put((byte) 0);
                this.f12678e.put((byte) ((byteBuffer.get(iPosition) & 255) - 128));
                iPosition++;
            }
        } else {
            if (i3 == 1073741824) {
                throw new IllegalStateException();
            }
            while (iPosition < iLimit) {
                this.f12678e.put(byteBuffer.get(iPosition + 2));
                this.f12678e.put(byteBuffer.get(iPosition + 3));
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        this.f12678e.flip();
        this.f12679f = this.f12678e;
    }
}
