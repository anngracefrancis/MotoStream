package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class zzrb {
    public static final zzrb a = new zzrb(new zzra[0]);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzra[] f16642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16643d;

    public zzrb(zzra... zzraVarArr) {
        this.f16642c = zzraVarArr;
        this.f16641b = zzraVarArr.length;
    }

    public final int a(zzra zzraVar) {
        for (int i2 = 0; i2 < this.f16641b; i2++) {
            if (this.f16642c[i2] == zzraVar) {
                return i2;
            }
        }
        return -1;
    }

    public final zzra b(int i2) {
        return this.f16642c[i2];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzrb.class == obj.getClass()) {
            zzrb zzrbVar = (zzrb) obj;
            if (this.f16641b == zzrbVar.f16641b && Arrays.equals(this.f16642c, zzrbVar.f16642c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f16643d == 0) {
            this.f16643d = Arrays.hashCode(this.f16642c);
        }
        return this.f16643d;
    }
}
