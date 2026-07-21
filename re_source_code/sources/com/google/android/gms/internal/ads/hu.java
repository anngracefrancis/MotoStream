package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class hu extends mu {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f12723k;
    private final int l;

    hu(byte[] bArr, int i2, int i3) {
        super(bArr);
        zzdmr.y(i2, i2 + i3, bArr.length);
        this.f12723k = i2;
        this.l = i3;
    }

    @Override // com.google.android.gms.internal.ads.mu
    protected final int F() {
        return this.f12723k;
    }

    @Override // com.google.android.gms.internal.ads.mu, com.google.android.gms.internal.ads.zzdmr
    protected final void h(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.f12995j, F(), bArr, 0, i4);
    }

    @Override // com.google.android.gms.internal.ads.mu, com.google.android.gms.internal.ads.zzdmr
    public final int size() {
        return this.l;
    }

    @Override // com.google.android.gms.internal.ads.mu, com.google.android.gms.internal.ads.zzdmr
    public final byte v(int i2) {
        int size = size();
        if (((size - (i2 + 1)) | i2) >= 0) {
            return this.f12995j[this.f12723k + i2];
        }
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i2);
        sb2.append(", ");
        sb2.append(size);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.ads.mu, com.google.android.gms.internal.ads.zzdmr
    final byte w(int i2) {
        return this.f12995j[this.f12723k + i2];
    }
}
