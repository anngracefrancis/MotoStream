package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class d5 extends r6 {
    private d5(t6 t6Var) {
        super(t6Var);
    }

    public static void h() {
        String strB = n0.a().b();
        String str = n0.a().f10926b;
        if (TextUtils.isEmpty(str)) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        Context contextA = b0.a();
        int i2 = 0;
        try {
            i2 = contextA.getPackageManager().getPackageInfo(contextA.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        m2.a().b(new d5(new e5(strB, str, String.valueOf(i2), a2.a(b0.a()))));
    }

    @Override // com.flurry.sdk.u6
    public final s6 a() {
        return s6.APP_INFO;
    }
}
