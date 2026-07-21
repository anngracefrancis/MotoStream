package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public enum zzbz implements zzdoe {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_FAILURE(2),
    ENUM_UNKNOWN(1000);


    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final zzdof<zzbz> f14890j = new zzdof<zzbz>() { // from class: com.google.android.gms.internal.ads.jg
    };
    private final int l;

    zzbz(int i2) {
        this.l = i2;
    }

    public static zzdog g() {
        return sg.a;
    }

    public static zzbz k(int i2) {
        if (i2 == 0) {
            return ENUM_FALSE;
        }
        if (i2 == 1) {
            return ENUM_TRUE;
        }
        if (i2 == 2) {
            return ENUM_FAILURE;
        }
        if (i2 != 1000) {
            return null;
        }
        return ENUM_UNKNOWN;
    }

    @Override // com.google.android.gms.internal.ads.zzdoe
    public final int i() {
        return this.l;
    }
}
