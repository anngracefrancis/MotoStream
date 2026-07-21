package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzf;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.p000authapi.zzi;
import com.google.android.gms.internal.p000authapi.zzr;

/* JADX INFO: loaded from: classes2.dex */
public final class Auth {
    public static final Api.ClientKey<zzr> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Api.ClientKey<zzg> f11400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zzr, AuthCredentialsOptions> f11401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zzg, GoogleSignInOptions> f11402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @KeepForSdk
    @Deprecated
    public static final Api<AuthProxyOptions> f11403e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Api<AuthCredentialsOptions> f11404f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Api<GoogleSignInOptions> f11405g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @KeepForSdk
    @Deprecated
    public static final ProxyApi f11406h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final CredentialsApi f11407i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final GoogleSignInApi f11408j;

    @Deprecated
    public static class AuthCredentialsOptions implements Api.ApiOptions.Optional {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final AuthCredentialsOptions f11409f = new Builder().a();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f11410g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f11411h;

        @Deprecated
        public static class Builder {
            protected Boolean a = Boolean.FALSE;

            public AuthCredentialsOptions a() {
                return new AuthCredentialsOptions(this);
            }
        }

        public AuthCredentialsOptions(Builder builder) {
            this.f11411h = builder.a.booleanValue();
        }

        public final Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", null);
            bundle.putBoolean("force_save_dialog", this.f11411h);
            return bundle;
        }
    }

    static {
        Api.ClientKey<zzr> clientKey = new Api.ClientKey<>();
        a = clientKey;
        Api.ClientKey<zzg> clientKey2 = new Api.ClientKey<>();
        f11400b = clientKey2;
        b bVar = new b();
        f11401c = bVar;
        c cVar = new c();
        f11402d = cVar;
        f11403e = AuthProxy.f11413c;
        f11404f = new Api<>("Auth.CREDENTIALS_API", bVar, clientKey);
        f11405g = new Api<>("Auth.GOOGLE_SIGN_IN_API", cVar, clientKey2);
        f11406h = AuthProxy.f11414d;
        f11407i = new zzi();
        f11408j = new zzf();
    }

    private Auth() {
    }
}
