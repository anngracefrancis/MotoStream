package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public enum zzdgf implements zzdoe {
    UNKNOWN_CURVE(0),
    NIST_P256(2),
    NIST_P384(3),
    NIST_P521(4),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final zzdof<zzdgf> f15896k = new zzdof<zzdgf>() { // from class: com.google.android.gms.internal.ads.rs
    };
    private final int m;

    zzdgf(int i2) {
        this.m = i2;
    }

    public static zzdgf g(int i2) {
        if (i2 == 0) {
            return UNKNOWN_CURVE;
        }
        if (i2 == 2) {
            return NIST_P256;
        }
        if (i2 == 3) {
            return NIST_P384;
        }
        if (i2 != 4) {
            return null;
        }
        return NIST_P521;
    }

    @Override // com.google.android.gms.internal.ads.zzdoe
    public final int i() {
        if (this != UNRECOGNIZED) {
            return this.m;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
