package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzvi {
    final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f16846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f16847c;

    zzvi(long j2, String str, int i2) {
        this.a = j2;
        this.f16846b = str;
        this.f16847c = i2;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzvi)) {
            zzvi zzviVar = (zzvi) obj;
            if (zzviVar.a == this.a && zzviVar.f16847c == this.f16847c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.a;
    }
}
