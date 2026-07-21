package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class n3 implements e3 {
    private final zzgo a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f17227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f17228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f17229d;

    n3(zzgo zzgoVar, String str, Object[] objArr) {
        this.a = zzgoVar;
        this.f17227b = str;
        this.f17228c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f17229d = cCharAt;
            return;
        }
        int i2 = cCharAt & 8191;
        int i3 = 13;
        int i4 = 1;
        while (true) {
            int i5 = i4 + 1;
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 < 55296) {
                this.f17229d = i2 | (cCharAt2 << i3);
                return;
            } else {
                i2 |= (cCharAt2 & 8191) << i3;
                i3 += 13;
                i4 = i5;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.e3
    public final int a() {
        return (this.f17229d & 1) == 1 ? zzfd.zze.f17404i : zzfd.zze.f17405j;
    }

    @Override // com.google.android.gms.internal.measurement.e3
    public final boolean b() {
        return (this.f17229d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.measurement.e3
    public final zzgo c() {
        return this.a;
    }

    final String d() {
        return this.f17227b;
    }

    final Object[] e() {
        return this.f17228c;
    }
}
