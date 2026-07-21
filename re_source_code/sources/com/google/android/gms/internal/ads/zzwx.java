package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public enum zzwx implements zzdoe {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_UNKNOWN(1000);


    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final zzdof<zzwx> f16917i = new zzdof<zzwx>() { // from class: com.google.android.gms.internal.ads.m50
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f16919k;

    zzwx(int i2) {
        this.f16919k = i2;
    }

    public static zzdog g() {
        return n50.a;
    }

    public static zzwx k(int i2) {
        if (i2 == 0) {
            return ENUM_FALSE;
        }
        if (i2 == 1) {
            return ENUM_TRUE;
        }
        if (i2 != 1000) {
            return null;
        }
        return ENUM_UNKNOWN;
    }

    @Override // com.google.android.gms.internal.ads.zzdoe
    public final int i() {
        return this.f16919k;
    }
}
