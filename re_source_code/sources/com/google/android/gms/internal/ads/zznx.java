package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class zznx {
    public final int a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f16527b;

    public zznx(int i2, byte[] bArr) {
        this.f16527b = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zznx.class == obj.getClass()) {
            zznx zznxVar = (zznx) obj;
            if (this.a == zznxVar.a && Arrays.equals(this.f16527b, zznxVar.f16527b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.a * 31) + Arrays.hashCode(this.f16527b);
    }
}
