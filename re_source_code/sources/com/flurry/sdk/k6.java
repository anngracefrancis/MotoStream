package com.flurry.sdk;

/* JADX INFO: loaded from: classes2.dex */
public final class k6 extends r6 {
    private k6(t6 t6Var) {
        super(t6Var);
    }

    public static k6 h(long j2, long j3, long j4, int i2) {
        return new k6(new l6(j2, j3, j4, i2));
    }

    @Override // com.flurry.sdk.u6
    public final s6 a() {
        return s6.SESSION_ID;
    }
}
