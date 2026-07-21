package com.bumptech.glide.l;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: StandardGifDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements a {
    private static final String a = "e";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f9011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f9012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a.InterfaceC0122a f9013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ByteBuffer f9014e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f9015f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private short[] f9016g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte[] f9017h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private byte[] f9018i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private byte[] f9019j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int[] f9020k;
    private int l;
    private c m;
    private Bitmap n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private int s;
    private Boolean t;
    private Bitmap.Config u;

    public e(a.InterfaceC0122a interfaceC0122a, c cVar, ByteBuffer byteBuffer, int i2) {
        this(interfaceC0122a);
        r(cVar, byteBuffer, i2);
    }

    private int j(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.q + i2; i10++) {
            byte[] bArr = this.f9019j;
            if (i10 >= bArr.length || i10 >= i3) {
                break;
            }
            int i11 = this.f9011b[bArr[i10] & 255];
            if (i11 != 0) {
                i5 += (i11 >> 24) & 255;
                i6 += (i11 >> 16) & 255;
                i7 += (i11 >> 8) & 255;
                i8 += i11 & 255;
                i9++;
            }
        }
        int i12 = i2 + i4;
        for (int i13 = i12; i13 < this.q + i12; i13++) {
            byte[] bArr2 = this.f9019j;
            if (i13 >= bArr2.length || i13 >= i3) {
                break;
            }
            int i14 = this.f9011b[bArr2[i13] & 255];
            if (i14 != 0) {
                i5 += (i14 >> 24) & 255;
                i6 += (i14 >> 16) & 255;
                i7 += (i14 >> 8) & 255;
                i8 += i14 & 255;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }

    private void k(b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr = this.f9020k;
        int i7 = bVar.f8990d;
        int i8 = this.q;
        int i9 = i7 / i8;
        int i10 = bVar.f8988b / i8;
        int i11 = bVar.f8989c / i8;
        int i12 = bVar.a / i8;
        boolean z = this.l == 0;
        int i13 = this.s;
        int i14 = this.r;
        byte[] bArr = this.f9019j;
        int[] iArr2 = this.f9011b;
        Boolean bool = this.t;
        int i15 = 8;
        int i16 = 0;
        int i17 = 0;
        int i18 = 1;
        while (i16 < i9) {
            Boolean bool2 = bool;
            if (bVar.f8991e) {
                if (i17 >= i9) {
                    i2 = i9;
                    int i19 = i18 + 1;
                    if (i19 == 2) {
                        i18 = i19;
                        i17 = 4;
                    } else if (i19 == 3) {
                        i18 = i19;
                        i17 = 2;
                        i15 = 4;
                    } else if (i19 != 4) {
                        i18 = i19;
                    } else {
                        i18 = i19;
                        i17 = 1;
                        i15 = 2;
                    }
                } else {
                    i2 = i9;
                }
                i3 = i17 + i15;
            } else {
                i2 = i9;
                i3 = i17;
                i17 = i16;
            }
            int i20 = i17 + i10;
            boolean z2 = i8 == 1;
            if (i20 < i14) {
                int i21 = i20 * i13;
                int i22 = i21 + i12;
                int i23 = i22 + i11;
                int i24 = i21 + i13;
                if (i24 < i23) {
                    i23 = i24;
                }
                i4 = i3;
                int i25 = i16 * i8 * bVar.f8989c;
                if (z2) {
                    int i26 = i22;
                    while (i26 < i23) {
                        int i27 = i10;
                        int i28 = iArr2[bArr[i25] & 255];
                        if (i28 != 0) {
                            iArr[i26] = i28;
                        } else if (z && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i25 += i8;
                        i26++;
                        i10 = i27;
                    }
                } else {
                    i6 = i10;
                    int i29 = ((i23 - i22) * i8) + i25;
                    int i30 = i22;
                    while (true) {
                        i5 = i11;
                        if (i30 < i23) {
                            int iJ = j(i25, i29, bVar.f8989c);
                            if (iJ != 0) {
                                iArr[i30] = iJ;
                            } else if (z && bool2 == null) {
                                bool2 = Boolean.TRUE;
                            }
                            i25 += i8;
                            i30++;
                            i11 = i5;
                        }
                    }
                }
                bool = bool2;
                i16++;
                i10 = i6;
                i11 = i5;
                i9 = i2;
                i17 = i4;
            } else {
                i4 = i3;
            }
            i6 = i10;
            i5 = i11;
            bool = bool2;
            i16++;
            i10 = i6;
            i11 = i5;
            i9 = i2;
            i17 = i4;
        }
        Boolean bool3 = bool;
        if (this.t == null) {
            this.t = Boolean.valueOf(bool3 == null ? false : bool3.booleanValue());
        }
    }

    private void l(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.f9020k;
        int i2 = bVar2.f8990d;
        int i3 = bVar2.f8988b;
        int i4 = bVar2.f8989c;
        int i5 = bVar2.a;
        boolean z = this.l == 0;
        int i6 = this.s;
        byte[] bArr = this.f9019j;
        int[] iArr2 = this.f9011b;
        int i7 = 0;
        byte b2 = -1;
        while (i7 < i2) {
            int i8 = (i7 + i3) * i6;
            int i9 = i8 + i5;
            int i10 = i9 + i4;
            int i11 = i8 + i6;
            if (i11 < i10) {
                i10 = i11;
            }
            int i12 = bVar2.f8989c * i7;
            int i13 = i9;
            while (i13 < i10) {
                byte b3 = bArr[i12];
                int i14 = i2;
                int i15 = b3 & 255;
                if (i15 != b2) {
                    int i16 = iArr2[i15];
                    if (i16 != 0) {
                        iArr[i13] = i16;
                    } else {
                        b2 = b3;
                    }
                }
                i12++;
                i13++;
                i2 = i14;
            }
            i7++;
            bVar2 = bVar;
        }
        this.t = Boolean.valueOf(this.t == null && z && b2 != -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15, types: [short] */
    /* JADX WARN: Type inference failed for: r7v17 */
    private void m(b bVar) {
        int i2;
        int i3;
        short s;
        this = this;
        if (bVar != null) {
            this.f9014e.position(bVar.f8996j);
        }
        if (bVar == null) {
            c cVar = this.m;
            i2 = cVar.f9002f;
            i3 = cVar.f9003g;
        } else {
            i2 = bVar.f8989c;
            i3 = bVar.f8990d;
        }
        int i4 = i2 * i3;
        byte[] bArr = this.f9019j;
        if (bArr == null || bArr.length < i4) {
            this.f9019j = this.f9013d.e(i4);
        }
        byte[] bArr2 = this.f9019j;
        if (this.f9016g == null) {
            this.f9016g = new short[RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT];
        }
        short[] sArr = this.f9016g;
        if (this.f9017h == null) {
            this.f9017h = new byte[RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT];
        }
        byte[] bArr3 = this.f9017h;
        if (this.f9018i == null) {
            this.f9018i = new byte[4097];
        }
        byte[] bArr4 = this.f9018i;
        int iQ = q();
        int i5 = 1 << iQ;
        int i6 = i5 + 1;
        int i7 = i5 + 2;
        int i8 = iQ + 1;
        int i9 = (1 << i8) - 1;
        int i10 = 0;
        for (int i11 = 0; i11 < i5; i11++) {
            sArr[i11] = 0;
            bArr3[i11] = (byte) i11;
        }
        byte[] bArr5 = this.f9015f;
        int i12 = i8;
        int i13 = i7;
        int i14 = i9;
        int iP = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = -1;
        int i20 = 0;
        int i21 = 0;
        while (i10 < i4) {
            if (iP == 0) {
                iP = p();
                if (iP <= 0) {
                    this.p = 3;
                    break;
                }
                i15 = 0;
            }
            i17 += (bArr5[i15] & 255) << i16;
            i15++;
            iP--;
            int i22 = i16 + 8;
            i13 = i13;
            i12 = i12;
            i19 = i19;
            i8 = i8;
            i20 = i20;
            while (true) {
                if (i22 < i12) {
                    i16 = i22;
                    break;
                }
                int i23 = i7;
                int i24 = i17 & i14;
                i17 >>= i12;
                i22 -= i12;
                if (i24 == i5) {
                    i14 = i9;
                    i12 = i8;
                    i13 = i23;
                    i7 = i13;
                    i19 = -1;
                } else {
                    if (i24 == i6) {
                        i16 = i22;
                        i7 = i23;
                        break;
                    }
                    if (i19 == -1) {
                        bArr2[i18] = bArr3[i24];
                        i18++;
                        i10++;
                        i19 = i24;
                        i20 = i19;
                        i7 = i23;
                        i22 = i22;
                    } else {
                        if (i24 >= i13) {
                            bArr4[i21] = (byte) i20;
                            i21++;
                            s = i19;
                        } else {
                            s = i24;
                        }
                        while (s >= i5) {
                            bArr4[i21] = bArr3[s];
                            i21++;
                            s = sArr[s];
                        }
                        i20 = bArr3[s] & 255;
                        byte b2 = (byte) i20;
                        bArr2[i18] = b2;
                        while (true) {
                            i18++;
                            i10++;
                            if (i21 <= 0) {
                                break;
                            }
                            i21--;
                            bArr2[i18] = bArr4[i21];
                        }
                        byte[] bArr6 = bArr4;
                        if (i13 < 4096) {
                            sArr[i13] = (short) i19;
                            bArr3[i13] = b2;
                            i13++;
                            if ((i13 & i14) == 0 && i13 < 4096) {
                                i12++;
                                i14 += i13;
                            }
                        }
                        i19 = i24;
                        i7 = i23;
                        i22 = i22;
                        bArr4 = bArr6;
                    }
                }
            }
        }
        Arrays.fill(bArr2, i18, i4, (byte) 0);
    }

    private Bitmap o() {
        Boolean bool = this.t;
        Bitmap bitmapA = this.f9013d.a(this.s, this.r, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.u);
        bitmapA.setHasAlpha(true);
        return bitmapA;
    }

    private int p() {
        int iQ = q();
        if (iQ <= 0) {
            return iQ;
        }
        ByteBuffer byteBuffer = this.f9014e;
        byteBuffer.get(this.f9015f, 0, Math.min(iQ, byteBuffer.remaining()));
        return iQ;
    }

    private int q() {
        return this.f9014e.get() & 255;
    }

    private Bitmap s(b bVar, b bVar2) {
        int i2;
        int i3;
        Bitmap bitmap;
        int[] iArr = this.f9020k;
        int i4 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.n;
            if (bitmap2 != null) {
                this.f9013d.c(bitmap2);
            }
            this.n = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.f8993g == 3 && this.n == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i3 = bVar2.f8993g) > 0) {
            if (i3 == 2) {
                if (!bVar.f8992f) {
                    c cVar = this.m;
                    int i5 = cVar.l;
                    if (bVar.f8997k == null || cVar.f9006j != bVar.f8994h) {
                        i4 = i5;
                    }
                } else if (this.l == 0) {
                    this.t = Boolean.TRUE;
                }
                int i6 = bVar2.f8990d;
                int i7 = this.q;
                int i8 = i6 / i7;
                int i9 = bVar2.f8988b / i7;
                int i10 = bVar2.f8989c / i7;
                int i11 = bVar2.a / i7;
                int i12 = this.s;
                int i13 = (i9 * i12) + i11;
                int i14 = (i8 * i12) + i13;
                while (i13 < i14) {
                    int i15 = i13 + i10;
                    for (int i16 = i13; i16 < i15; i16++) {
                        iArr[i16] = i4;
                    }
                    i13 += this.s;
                }
            } else if (i3 == 3 && (bitmap = this.n) != null) {
                int i17 = this.s;
                bitmap.getPixels(iArr, 0, i17, 0, 0, i17, this.r);
            }
        }
        m(bVar);
        if (bVar.f8991e || this.q != 1) {
            k(bVar);
        } else {
            l(bVar);
        }
        if (this.o && ((i2 = bVar.f8993g) == 0 || i2 == 1)) {
            if (this.n == null) {
                this.n = o();
            }
            Bitmap bitmap3 = this.n;
            int i18 = this.s;
            bitmap3.setPixels(iArr, 0, i18, 0, 0, i18, this.r);
        }
        Bitmap bitmapO = o();
        int i19 = this.s;
        bitmapO.setPixels(iArr, 0, i19, 0, 0, i19, this.r);
        return bitmapO;
    }

    @Override // com.bumptech.glide.l.a
    public synchronized Bitmap a() {
        if (this.m.f8999c <= 0 || this.l < 0) {
            String str = a;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to decode frame, frameCount=" + this.m.f8999c + ", framePointer=" + this.l);
            }
            this.p = 1;
        }
        int i2 = this.p;
        if (i2 != 1 && i2 != 2) {
            this.p = 0;
            if (this.f9015f == null) {
                this.f9015f = this.f9013d.e(255);
            }
            b bVar = this.m.f9001e.get(this.l);
            int i3 = this.l - 1;
            b bVar2 = i3 >= 0 ? this.m.f9001e.get(i3) : null;
            int[] iArr = bVar.f8997k;
            if (iArr == null) {
                iArr = this.m.a;
            }
            this.f9011b = iArr;
            if (iArr != null) {
                if (bVar.f8992f) {
                    System.arraycopy(iArr, 0, this.f9012c, 0, iArr.length);
                    int[] iArr2 = this.f9012c;
                    this.f9011b = iArr2;
                    iArr2[bVar.f8994h] = 0;
                }
                return s(bVar, bVar2);
            }
            String str2 = a;
            if (Log.isLoggable(str2, 3)) {
                Log.d(str2, "No valid color table found for frame #" + this.l);
            }
            this.p = 1;
            return null;
        }
        String str3 = a;
        if (Log.isLoggable(str3, 3)) {
            Log.d(str3, "Unable to decode frame, status=" + this.p);
        }
        return null;
    }

    @Override // com.bumptech.glide.l.a
    public ByteBuffer b() {
        return this.f9014e;
    }

    @Override // com.bumptech.glide.l.a
    public void c() {
        this.l = (this.l + 1) % this.m.f8999c;
    }

    @Override // com.bumptech.glide.l.a
    public void clear() {
        this.m = null;
        byte[] bArr = this.f9019j;
        if (bArr != null) {
            this.f9013d.d(bArr);
        }
        int[] iArr = this.f9020k;
        if (iArr != null) {
            this.f9013d.f(iArr);
        }
        Bitmap bitmap = this.n;
        if (bitmap != null) {
            this.f9013d.c(bitmap);
        }
        this.n = null;
        this.f9014e = null;
        this.t = null;
        byte[] bArr2 = this.f9015f;
        if (bArr2 != null) {
            this.f9013d.d(bArr2);
        }
    }

    @Override // com.bumptech.glide.l.a
    public int d() {
        return this.m.f8999c;
    }

    @Override // com.bumptech.glide.l.a
    public int e() {
        int i2;
        if (this.m.f8999c <= 0 || (i2 = this.l) < 0) {
            return 0;
        }
        return n(i2);
    }

    @Override // com.bumptech.glide.l.a
    public void f(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.u = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    @Override // com.bumptech.glide.l.a
    public void g() {
        this.l = -1;
    }

    @Override // com.bumptech.glide.l.a
    public int h() {
        return this.l;
    }

    @Override // com.bumptech.glide.l.a
    public int i() {
        return this.f9014e.limit() + this.f9019j.length + (this.f9020k.length * 4);
    }

    public int n(int i2) {
        if (i2 >= 0) {
            c cVar = this.m;
            if (i2 < cVar.f8999c) {
                return cVar.f9001e.get(i2).f8995i;
            }
        }
        return -1;
    }

    public synchronized void r(c cVar, ByteBuffer byteBuffer, int i2) {
        try {
            if (i2 <= 0) {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
            }
            int iHighestOneBit = Integer.highestOneBit(i2);
            this.p = 0;
            this.m = cVar;
            this.l = -1;
            ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f9014e = byteBufferAsReadOnlyBuffer;
            byteBufferAsReadOnlyBuffer.position(0);
            this.f9014e.order(ByteOrder.LITTLE_ENDIAN);
            this.o = false;
            Iterator<b> it = cVar.f9001e.iterator();
            while (it.hasNext()) {
                if (it.next().f8993g == 3) {
                    this.o = true;
                    break;
                }
            }
            this.q = iHighestOneBit;
            int i3 = cVar.f9002f;
            this.s = i3 / iHighestOneBit;
            int i4 = cVar.f9003g;
            this.r = i4 / iHighestOneBit;
            this.f9019j = this.f9013d.e(i3 * i4);
            this.f9020k = this.f9013d.b(this.s * this.r);
        } catch (Throwable th) {
            throw th;
        }
    }

    public e(a.InterfaceC0122a interfaceC0122a) {
        this.f9012c = new int[256];
        this.u = Bitmap.Config.ARGB_8888;
        this.f9013d = interfaceC0122a;
        this.m = new c();
    }
}
