package com.facebook;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AccessTokenCache.kt */
/* JADX INFO: loaded from: classes.dex */
public final class u {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f10569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f10570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f0 f10571d;

    /* JADX INFO: compiled from: AccessTokenCache.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: AccessTokenCache.kt */
    public static final class b {
        public final f0 a() {
            a0 a0Var = a0.a;
            return new f0(a0.c(), null, 2, null);
        }
    }

    public u(SharedPreferences sharedPreferences, b bVar) {
        kotlin.jvm.internal.m.f(sharedPreferences, "sharedPreferences");
        kotlin.jvm.internal.m.f(bVar, "tokenCachingStrategyFactory");
        this.f10569b = sharedPreferences;
        this.f10570c = bVar;
    }

    private final AccessToken b() {
        String string = this.f10569b.getString("com.facebook.AccessTokenManager.CachedAccessToken", null);
        if (string == null) {
            return null;
        }
        try {
            return AccessToken.f9559f.b(new JSONObject(string));
        } catch (JSONException unused) {
            return null;
        }
    }

    private final AccessToken c() {
        Bundle bundleC = d().c();
        if (bundleC == null || !f0.a.g(bundleC)) {
            return null;
        }
        return AccessToken.f9559f.c(bundleC);
    }

    private final f0 d() {
        if (this.f10571d == null) {
            synchronized (this) {
                if (this.f10571d == null) {
                    this.f10571d = this.f10570c.a();
                }
                kotlin.u uVar = kotlin.u.a;
            }
        }
        f0 f0Var = this.f10571d;
        if (f0Var != null) {
            return f0Var;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final boolean e() {
        return this.f10569b.contains("com.facebook.AccessTokenManager.CachedAccessToken");
    }

    private final boolean h() {
        a0 a0Var = a0.a;
        return a0.x();
    }

    public final void a() {
        this.f10569b.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
        if (h()) {
            d().a();
        }
    }

    public final AccessToken f() {
        if (e()) {
            return b();
        }
        if (!h()) {
            return null;
        }
        AccessToken accessTokenC = c();
        if (accessTokenC == null) {
            return accessTokenC;
        }
        g(accessTokenC);
        d().a();
        return accessTokenC;
    }

    public final void g(AccessToken accessToken) {
        kotlin.jvm.internal.m.f(accessToken, "accessToken");
        try {
            this.f10569b.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", accessToken.o().toString()).apply();
        } catch (JSONException unused) {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public u() {
        a0 a0Var = a0.a;
        SharedPreferences sharedPreferences = a0.c().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);
        kotlin.jvm.internal.m.e(sharedPreferences, "FacebookSdk.getApplicationContext()\n              .getSharedPreferences(\n                  AccessTokenManager.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)");
        this(sharedPreferences, new b());
    }
}
