package com.facebook.internal;

import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;

/* JADX INFO: compiled from: InstallReferrerUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g0 {
    public static final g0 a = new g0();

    /* JADX INFO: compiled from: InstallReferrerUtil.kt */
    public interface a {
        void a(String str);
    }

    /* JADX INFO: compiled from: InstallReferrerUtil.kt */
    public static final class b implements InstallReferrerStateListener {
        final /* synthetic */ InstallReferrerClient a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f9775b;

        b(InstallReferrerClient installReferrerClient, a aVar) {
            this.a = installReferrerClient;
            this.f9775b = aVar;
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public void a(int i2) {
            if (i2 == 0) {
                try {
                    ReferrerDetails referrerDetailsB = this.a.b();
                    kotlin.jvm.internal.m.e(referrerDetailsB, "{\n                      referrerClient.installReferrer\n                    }");
                    String strA = referrerDetailsB.a();
                    if (strA != null && (kotlin.text.v.J(strA, "fb", false, 2, null) || kotlin.text.v.J(strA, "facebook", false, 2, null))) {
                        this.f9775b.a(strA);
                    }
                    g0.a.e();
                } catch (RemoteException | Exception unused) {
                    return;
                }
            } else if (i2 == 2) {
                g0.a.e();
            }
            this.a.a();
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public void b() {
        }
    }

    private g0() {
    }

    private final boolean b() {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        return com.facebook.a0.c().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("is_referrer_updated", false);
    }

    private final void c(a aVar) {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        InstallReferrerClient installReferrerClientA = InstallReferrerClient.c(com.facebook.a0.c()).a();
        try {
            installReferrerClientA.d(new b(installReferrerClientA, aVar));
        } catch (Exception unused) {
        }
    }

    public static final void d(a aVar) {
        kotlin.jvm.internal.m.f(aVar, "callback");
        g0 g0Var = a;
        if (g0Var.b()) {
            return;
        }
        g0Var.c(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        com.facebook.a0.c().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putBoolean("is_referrer_updated", true).apply();
    }
}
