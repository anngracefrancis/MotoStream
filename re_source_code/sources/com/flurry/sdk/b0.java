package com.flurry.sdk;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 {
    private static Context a;

    public static Context a() {
        return a;
    }

    public static void b(Context context) {
        a = context.getApplicationContext();
    }
}
