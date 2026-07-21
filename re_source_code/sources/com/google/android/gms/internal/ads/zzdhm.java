package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public enum zzdhm implements zzdoe {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);

    private static final zzdof<zzdhm> l = new zzdof<zzdhm>() { // from class: com.google.android.gms.internal.ads.it
    };
    private final int n;

    zzdhm(int i2) {
        this.n = i2;
    }

    public static zzdhm g(int i2) {
        if (i2 == 0) {
            return UNKNOWN_PREFIX;
        }
        if (i2 == 1) {
            return TINK;
        }
        if (i2 == 2) {
            return LEGACY;
        }
        if (i2 == 3) {
            return RAW;
        }
        if (i2 != 4) {
            return null;
        }
        return CRUNCHY;
    }

    @Override // com.google.android.gms.internal.ads.zzdoe
    public final int i() {
        if (this != UNRECOGNIZED) {
            return this.n;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
