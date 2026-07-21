package com.facebook;

import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ProfileCache.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h0 {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f9713b;

    /* JADX INFO: compiled from: ProfileCache.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public h0() {
        a0 a0Var = a0.a;
        SharedPreferences sharedPreferences = a0.c().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);
        kotlin.jvm.internal.m.e(sharedPreferences, "FacebookSdk.getApplicationContext()\n            .getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)");
        this.f9713b = sharedPreferences;
    }

    public final void a() {
        this.f9713b.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
    }

    public final Profile b() {
        String string = this.f9713b.getString("com.facebook.ProfileManager.CachedProfile", null);
        if (string != null) {
            try {
                return new Profile(new JSONObject(string));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public final void c(Profile profile) {
        kotlin.jvm.internal.m.f(profile, "profile");
        JSONObject jSONObjectB = profile.b();
        if (jSONObjectB != null) {
            this.f9713b.edit().putString("com.facebook.ProfileManager.CachedProfile", jSONObjectB.toString()).apply();
        }
    }
}
