package com.facebook.o0.o0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.facebook.internal.a0;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.text.v;

/* JADX INFO: compiled from: InAppPurchaseManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k {
    public static final k a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f10379b = new AtomicBoolean(false);

    private k() {
    }

    public static final void a() {
        f10379b.set(true);
        b();
    }

    public static final void b() {
        if (f10379b.get()) {
            if (a.c()) {
                a0 a0Var = a0.a;
                if (a0.g(a0.b.IapLoggingLib2)) {
                    g gVar = g.a;
                    com.facebook.a0 a0Var2 = com.facebook.a0.a;
                    g.d(com.facebook.a0.c());
                    return;
                }
            }
            f fVar = f.a;
            f.g();
        }
    }

    private final boolean c() {
        try {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            Context contextC = com.facebook.a0.c();
            ApplicationInfo applicationInfo = contextC.getPackageManager().getApplicationInfo(contextC.getPackageName(), 128);
            kotlin.jvm.internal.m.e(applicationInfo, "context.packageManager.getApplicationInfo(\n              context.packageName, PackageManager.GET_META_DATA)");
            String string = applicationInfo.metaData.getString("com.google.android.play.billingclient.version");
            return string != null && Integer.parseInt((String) v.v0(string, new String[]{"."}, false, 3, 2, null).get(0)) >= 2;
        } catch (Exception unused) {
            return false;
        }
    }
}
