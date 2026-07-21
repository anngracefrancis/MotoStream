package com.google.android.gms.auth.api;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzak;
import com.google.android.gms.internal.auth.zzar;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public final class AuthProxy {
    private static final Api.ClientKey<zzak> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zzak, AuthProxyOptions> f11412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @KeepForSdk
    public static final Api<AuthProxyOptions> f11413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @KeepForSdk
    public static final ProxyApi f11414d;

    static {
        Api.ClientKey<zzak> clientKey = new Api.ClientKey<>();
        a = clientKey;
        a aVar = new a();
        f11412b = aVar;
        f11413c = new Api<>("Auth.PROXY_API", aVar, clientKey);
        f11414d = new zzar();
    }
}
