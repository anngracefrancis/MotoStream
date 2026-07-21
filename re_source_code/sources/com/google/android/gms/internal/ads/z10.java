package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class z10 extends y10 {
    public final long Q0;
    public final List<a20> R0;
    public final List<z10> S0;

    public z10(int i2, long j2) {
        super(i2);
        this.Q0 = j2;
        this.R0 = new ArrayList();
        this.S0 = new ArrayList();
    }

    public final a20 d(int i2) {
        int size = this.R0.size();
        for (int i3 = 0; i3 < size; i3++) {
            a20 a20Var = this.R0.get(i3);
            if (a20Var.P0 == i2) {
                return a20Var;
            }
        }
        return null;
    }

    public final z10 e(int i2) {
        int size = this.S0.size();
        for (int i3 = 0; i3 < size; i3++) {
            z10 z10Var = this.S0.get(i3);
            if (z10Var.P0 == i2) {
                return z10Var;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.y10
    public final String toString() {
        String strC = y10.c(this.P0);
        String string = Arrays.toString(this.R0.toArray());
        String string2 = Arrays.toString(this.S0.toArray());
        StringBuilder sb = new StringBuilder(String.valueOf(strC).length() + 22 + String.valueOf(string).length() + String.valueOf(string2).length());
        sb.append(strC);
        sb.append(" leaves: ");
        sb.append(string);
        sb.append(" containers: ");
        sb.append(string2);
        return sb.toString();
    }
}
