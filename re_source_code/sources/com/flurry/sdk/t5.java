package com.flurry.sdk;

/* JADX INFO: loaded from: classes2.dex */
public final class t5 extends r6 {
    private t5(t6 t6Var) {
        super(t6Var);
    }

    public static t5 h() {
        long jF = p2.f("frame.counter", 0L) + 1;
        p2.c("frame.counter", jF);
        return new t5(new u5(jF));
    }

    @Override // com.flurry.sdk.u6
    public final s6 a() {
        return s6.FRAME_COUNTER;
    }
}
