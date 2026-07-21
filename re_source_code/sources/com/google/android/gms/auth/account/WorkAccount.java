package com.google.android.gms.auth.account;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzh;
import com.google.android.gms.internal.auth.zzr;

/* JADX INFO: loaded from: classes2.dex */
public class WorkAccount {
    private static final Api.ClientKey<zzr> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zzr, Api.ApiOptions.NoOptions> f11397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Api<Api.ApiOptions.NoOptions> f11398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final WorkAccountApi f11399d;

    static {
        Api.ClientKey<zzr> clientKey = new Api.ClientKey<>();
        a = clientKey;
        a aVar = new a();
        f11397b = aVar;
        f11398c = new Api<>("WorkAccount.API", aVar, clientKey);
        f11399d = new zzh();
    }

    private WorkAccount() {
    }
}
