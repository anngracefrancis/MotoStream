package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class ju {
    private final zzdni a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f12840b;

    private ju(int i2) {
        byte[] bArr = new byte[i2];
        this.f12840b = bArr;
        this.a = zzdni.n(bArr);
    }

    public final zzdmr a() {
        this.a.v();
        return new mu(this.f12840b);
    }

    public final zzdni b() {
        return this.a;
    }

    /* synthetic */ ju(int i2, du duVar) {
        this(i2);
    }
}
