package com.flurry.sdk;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class o2 {
    public static boolean a(String str) {
        Context contextA = b0.a();
        if (contextA != null) {
            return contextA.checkCallingOrSelfPermission(str) == 0;
        }
        d1.c(6, "PermissionUtil", "Context is null when checking permission.");
        return false;
    }
}
