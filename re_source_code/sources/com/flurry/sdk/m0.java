package com.flurry.sdk;

/* JADX INFO: loaded from: classes2.dex */
public final class m0 {
    private static m0 a;

    private m0() {
    }

    public static synchronized m0 a() {
        if (a == null) {
            a = new m0();
        }
        return a;
    }
}
