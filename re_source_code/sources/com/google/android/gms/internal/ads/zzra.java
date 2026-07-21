package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class zzra {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzlh[] f16639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16640c;

    public zzra(zzlh... zzlhVarArr) {
        zzsk.e(zzlhVarArr.length > 0);
        this.f16639b = zzlhVarArr;
        this.a = zzlhVarArr.length;
    }

    public final zzlh a(int i2) {
        return this.f16639b[i2];
    }

    public final int b(zzlh zzlhVar) {
        int i2 = 0;
        while (true) {
            zzlh[] zzlhVarArr = this.f16639b;
            if (i2 >= zzlhVarArr.length) {
                return -1;
            }
            if (zzlhVar == zzlhVarArr[i2]) {
                return i2;
            }
            i2++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzra.class == obj.getClass()) {
            zzra zzraVar = (zzra) obj;
            if (this.a == zzraVar.a && Arrays.equals(this.f16639b, zzraVar.f16639b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f16640c == 0) {
            this.f16640c = Arrays.hashCode(this.f16639b) + 527;
        }
        return this.f16640c;
    }
}
