package com.flurry.sdk;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 {
    private static l0 a;

    private l0() {
    }

    public static synchronized l0 a() {
        if (a == null) {
            a = new l0();
        }
        return a;
    }
}
