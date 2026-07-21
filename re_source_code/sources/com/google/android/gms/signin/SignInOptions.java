package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;

/* JADX INFO: loaded from: classes2.dex */
public final class SignInOptions implements Api.ApiOptions.Optional {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final SignInOptions f18274f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f18275g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f18276h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f18277i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f18278j = false;
    private final boolean l = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f18279k = null;
    private final Long m = null;
    private final Long n = null;

    public static final class zaa {
    }

    static {
        new zaa();
        f18274f = new SignInOptions(false, false, null, false, null, false, null, null);
    }

    private SignInOptions(boolean z, boolean z2, String str, boolean z3, String str2, boolean z4, Long l, Long l2) {
    }

    public final Long a() {
        return this.m;
    }

    public final String b() {
        return this.f18279k;
    }

    public final Long c() {
        return this.n;
    }

    public final String d() {
        return this.f18277i;
    }

    public final boolean e() {
        return this.f18278j;
    }

    public final boolean f() {
        return this.f18276h;
    }

    public final boolean g() {
        return this.f18275g;
    }

    public final boolean h() {
        return this.l;
    }
}
