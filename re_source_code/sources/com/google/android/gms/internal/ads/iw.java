package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class iw implements xv {
    private final zzdpk a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f12783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f12784d;

    iw(zzdpk zzdpkVar, String str, Object[] objArr) {
        this.a = zzdpkVar;
        this.f12782b = str;
        this.f12783c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f12784d = cCharAt;
            return;
        }
        int i2 = cCharAt & 8191;
        int i3 = 13;
        int i4 = 1;
        while (true) {
            int i5 = i4 + 1;
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 < 55296) {
                this.f12784d = i2 | (cCharAt2 << i3);
                return;
            } else {
                i2 |= (cCharAt2 & 8191) << i3;
                i3 += 13;
                i4 = i5;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.xv
    public final boolean a() {
        return (this.f12784d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.ads.xv
    public final zzdpk b() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.ads.xv
    public final int c() {
        return (this.f12784d & 1) == 1 ? zzdob.zze.f16029i : zzdob.zze.f16030j;
    }

    final String d() {
        return this.f12782b;
    }

    final Object[] e() {
        return this.f12783c;
    }
}
