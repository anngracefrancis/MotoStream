package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

/* JADX INFO: loaded from: classes2.dex */
public final class Common {

    @KeepForSdk
    public static final Api.ClientKey<zai> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zai, Api.ApiOptions.NoOptions> f12048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @KeepForSdk
    public static final Api<Api.ApiOptions.NoOptions> f12049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zac f12050d;

    static {
        Api.ClientKey<zai> clientKey = new Api.ClientKey<>();
        a = clientKey;
        a aVar = new a();
        f12048b = aVar;
        f12049c = new Api<>("Common.API", aVar, clientKey);
        f12050d = new zad();
    }
}
