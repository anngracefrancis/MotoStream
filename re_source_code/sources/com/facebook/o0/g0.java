package com.facebook.o0;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: InternalAppEventsLogger.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g0 {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b0 f10126b;

    /* JADX INFO: compiled from: InternalAppEventsLogger.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final g0 a(String str, String str2, AccessToken accessToken) {
            kotlin.jvm.internal.m.f(str, "activityName");
            return new g0(str, str2, accessToken);
        }

        public final Executor b() {
            return b0.a.f();
        }

        public final a0.b c() {
            return b0.a.h();
        }

        public final String d() {
            return b0.a.j();
        }

        public final void e(Map<String, String> map) {
            kotlin.jvm.internal.m.f(map, "ud");
            j0 j0Var = j0.a;
            j0.g(map);
        }
    }

    public g0(b0 b0Var) {
        kotlin.jvm.internal.m.f(b0Var, "loggerImpl");
        this.f10126b = b0Var;
    }

    public final void a() {
        this.f10126b.j();
    }

    public final void b(Bundle bundle) {
        kotlin.jvm.internal.m.f(bundle, "parameters");
        if (!((bundle.getInt("previous") & 2) != 0)) {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            if (!com.facebook.a0.g()) {
                return;
            }
        }
        this.f10126b.p("fb_sdk_settings_changed", null, bundle);
    }

    public final void c(String str, double d2, Bundle bundle) {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        if (com.facebook.a0.g()) {
            this.f10126b.l(str, d2, bundle);
        }
    }

    public final void d(String str, Bundle bundle) {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        if (com.facebook.a0.g()) {
            this.f10126b.m(str, bundle);
        }
    }

    public final void e(String str, String str2) {
        this.f10126b.o(str, str2);
    }

    public final void f(String str) {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        if (com.facebook.a0.g()) {
            this.f10126b.p(str, null, null);
        }
    }

    public final void g(String str, Bundle bundle) {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        if (com.facebook.a0.g()) {
            this.f10126b.p(str, null, bundle);
        }
    }

    public final void h(String str, Double d2, Bundle bundle) {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        if (com.facebook.a0.g()) {
            this.f10126b.p(str, d2, bundle);
        }
    }

    public final void i(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        if (com.facebook.a0.g()) {
            this.f10126b.q(str, bigDecimal, currency, bundle);
        }
    }

    public final void j(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        if (com.facebook.a0.g()) {
            this.f10126b.s(bigDecimal, currency, bundle);
        }
    }

    public g0(Context context) {
        this(new b0(context, (String) null, (AccessToken) null));
    }

    public g0(Context context, String str) {
        this(new b0(context, str, (AccessToken) null));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g0(String str, String str2, AccessToken accessToken) {
        this(new b0(str, str2, accessToken));
        kotlin.jvm.internal.m.f(str, "activityName");
    }
}
