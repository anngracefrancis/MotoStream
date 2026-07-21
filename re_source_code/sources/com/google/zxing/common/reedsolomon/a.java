package com.google.zxing.common.reedsolomon;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: GenericGF.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final a a = new a(4201, RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f20309b = new a(1033, 1024, 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f20310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f20311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f20312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f20313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f20314g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f20315h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int[] f20316i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int[] f20317j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final b f20318k;
    private final b l;
    private final int m;
    private final int n;
    private final int o;

    static {
        a aVar = new a(67, 64, 1);
        f20310c = aVar;
        f20311d = new a(19, 16, 1);
        f20312e = new a(285, 256, 0);
        a aVar2 = new a(301, 256, 1);
        f20313f = aVar2;
        f20314g = aVar2;
        f20315h = aVar;
    }

    public a(int i2, int i3, int i4) {
        this.n = i2;
        this.m = i3;
        this.o = i4;
        this.f20316i = new int[i3];
        this.f20317j = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.f20316i[i6] = i5;
            i5 <<= 1;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.f20317j[this.f20316i[i7]] = i7;
        }
        this.f20318k = new b(this, new int[]{0});
        this.l = new b(this, new int[]{1});
    }

    static int a(int i2, int i3) {
        return i2 ^ i3;
    }

    b b(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f20318k;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new b(this, iArr);
    }

    int c(int i2) {
        return this.f20316i[i2];
    }

    public int d() {
        return this.o;
    }

    b e() {
        return this.f20318k;
    }

    int f(int i2) {
        if (i2 != 0) {
            return this.f20316i[(this.m - this.f20317j[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    int g(int i2) {
        if (i2 != 0) {
            return this.f20317j[i2];
        }
        throw new IllegalArgumentException();
    }

    int h(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.f20316i;
        int[] iArr2 = this.f20317j;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.m - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.n) + ',' + this.m + ')';
    }
}
