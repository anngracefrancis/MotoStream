package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzh implements zzac {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f16266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f16267d;

    public zzh() {
        this(2500, 1, 1.0f);
    }

    @Override // com.google.android.gms.internal.ads.zzac
    public final void a(zzaf zzafVar) throws zzaf {
        int i2 = this.f16265b + 1;
        this.f16265b = i2;
        int i3 = this.a;
        this.a = i3 + ((int) (i3 * this.f16267d));
        if (!(i2 <= this.f16266c)) {
            throw zzafVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzac
    public final int b() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzac
    public final int c() {
        return this.f16265b;
    }

    private zzh(int i2, int i3, float f2) {
        this.a = 2500;
        this.f16266c = 1;
        this.f16267d = 1.0f;
    }
}
