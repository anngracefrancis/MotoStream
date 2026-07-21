package com.facebook.o0.o0;

import android.content.Context;

/* JADX INFO: compiled from: InAppPurchaseAutoLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static final g a = new g();

    private g() {
    }

    private final void c() {
        j jVar = j.a;
        h.b bVar = h.a;
        j.e(bVar.d(), bVar.e());
        bVar.d().clear();
    }

    public static final void d(Context context) {
        h.b bVar;
        h hVarC;
        kotlin.jvm.internal.m.f(context, "context");
        m mVar = m.a;
        if (m.a("com.android.billingclient.api.Purchase") == null || (hVarC = (bVar = h.a).c(context)) == null || !bVar.f().get()) {
            return;
        }
        j jVar = j.a;
        if (j.d()) {
            hVarC.p("inapp", new Runnable() { // from class: com.facebook.o0.o0.c
                @Override // java.lang.Runnable
                public final void run() {
                    g.e();
                }
            });
        } else {
            hVarC.o("inapp", new Runnable() { // from class: com.facebook.o0.o0.d
                @Override // java.lang.Runnable
                public final void run() {
                    g.f();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e() {
        a.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        a.c();
    }
}
