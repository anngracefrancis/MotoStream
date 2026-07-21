package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public enum zzdgu implements zzdoe {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final zzdof<zzdgu> f15914k = new zzdof<zzdgu>() { // from class: com.google.android.gms.internal.ads.zs
    };
    private final int m;

    zzdgu(int i2) {
        this.m = i2;
    }

    public static zzdgu g(int i2) {
        if (i2 == 0) {
            return UNKNOWN_STATUS;
        }
        if (i2 == 1) {
            return ENABLED;
        }
        if (i2 == 2) {
            return DISABLED;
        }
        if (i2 != 3) {
            return null;
        }
        return DESTROYED;
    }

    @Override // com.google.android.gms.internal.ads.zzdoe
    public final int i() {
        if (this != UNRECOGNIZED) {
            return this.m;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
