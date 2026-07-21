package com.facebook.internal;

import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: compiled from: InstagramCustomTab.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f0 extends u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f9773c = new a(null);

    /* JADX INFO: compiled from: InstagramCustomTab.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final Uri a(String str, Bundle bundle) {
            kotlin.jvm.internal.m.f(str, "action");
            if (kotlin.jvm.internal.m.a(str, "oauth")) {
                p0 p0Var = p0.a;
                n0 n0Var = n0.a;
                return p0.e(n0.k(), "oauth/authorize", bundle);
            }
            p0 p0Var2 = p0.a;
            n0 n0Var2 = n0.a;
            String strK = n0.k();
            StringBuilder sb = new StringBuilder();
            com.facebook.a0 a0Var = com.facebook.a0.a;
            sb.append(com.facebook.a0.n());
            sb.append("/dialog/");
            sb.append(str);
            return p0.e(strK, sb.toString(), bundle);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(String str, Bundle bundle) {
        super(str, bundle);
        kotlin.jvm.internal.m.f(str, "action");
        b(f9773c.a(str, bundle == null ? new Bundle() : bundle));
    }
}
