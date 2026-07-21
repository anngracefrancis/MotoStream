package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class zzro {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzrm[] f16674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16675c;

    public zzro(zzrm... zzrmVarArr) {
        this.f16674b = zzrmVarArr;
        this.a = zzrmVarArr.length;
    }

    public final zzrm a(int i2) {
        return this.f16674b[i2];
    }

    public final zzrm[] b() {
        return (zzrm[]) this.f16674b.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzro.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f16674b, ((zzro) obj).f16674b);
    }

    public final int hashCode() {
        if (this.f16675c == 0) {
            this.f16675c = Arrays.hashCode(this.f16674b) + 527;
        }
        return this.f16675c;
    }
}
