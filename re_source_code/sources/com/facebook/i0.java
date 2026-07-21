package com.facebook;

import android.content.Intent;
import com.facebook.internal.p0;

/* JADX INFO: compiled from: ProfileManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class i0 {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile i0 f9715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c.q.a.a f9716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h0 f9717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Profile f9718e;

    /* JADX INFO: compiled from: ProfileManager.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final synchronized i0 a() {
            i0 i0Var;
            if (i0.f9715b == null) {
                a0 a0Var = a0.a;
                c.q.a.a aVarB = c.q.a.a.b(a0.c());
                kotlin.jvm.internal.m.e(aVarB, "getInstance(applicationContext)");
                i0.f9715b = new i0(aVarB, new h0());
            }
            i0Var = i0.f9715b;
            if (i0Var == null) {
                kotlin.jvm.internal.m.w("instance");
                throw null;
            }
            return i0Var;
        }
    }

    public i0(c.q.a.a aVar, h0 h0Var) {
        kotlin.jvm.internal.m.f(aVar, "localBroadcastManager");
        kotlin.jvm.internal.m.f(h0Var, "profileCache");
        this.f9716c = aVar;
        this.f9717d = h0Var;
    }

    private final void e(Profile profile, Profile profile2) {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", profile);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", profile2);
        this.f9716c.d(intent);
    }

    private final void g(Profile profile, boolean z) {
        Profile profile2 = this.f9718e;
        this.f9718e = profile;
        if (z) {
            if (profile != null) {
                this.f9717d.c(profile);
            } else {
                this.f9717d.a();
            }
        }
        p0 p0Var = p0.a;
        if (p0.c(profile2, profile)) {
            return;
        }
        e(profile2, profile);
    }

    public final Profile c() {
        return this.f9718e;
    }

    public final boolean d() {
        Profile profileB = this.f9717d.b();
        if (profileB == null) {
            return false;
        }
        g(profileB, false);
        return true;
    }

    public final void f(Profile profile) {
        g(profile, true);
    }
}
