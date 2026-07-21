package com.flurry.sdk;

/* JADX INFO: loaded from: classes2.dex */
public final class r5 extends r6 {
    private r5(t6 t6Var) {
        super(t6Var);
    }

    public static r5 h(int i2, String str) {
        return new r5(new s5(i2, str));
    }

    @Override // com.flurry.sdk.u6
    public final s6 a() {
        return s6.FLUSH_FRAME;
    }
}
