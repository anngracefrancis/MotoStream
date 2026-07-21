package com.flurry.sdk;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class r2 {
    public static boolean a(Object... objArr) {
        for (int i2 = 0; i2 < 2; i2++) {
            if (objArr[i2] == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(String... strArr) {
        for (int i2 = 0; i2 < 4; i2++) {
            if (TextUtils.isEmpty(strArr[i2])) {
                return false;
            }
        }
        return true;
    }
}
