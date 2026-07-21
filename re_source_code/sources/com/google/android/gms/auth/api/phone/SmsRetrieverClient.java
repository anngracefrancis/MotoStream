package com.google.android.gms.auth.api.phone;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.internal.p001authapiphone.zzi;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SmsRetrieverClient extends GoogleApi<Api.ApiOptions.NoOptions> implements SmsRetrieverApi {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Api.ClientKey<zzi> f11481j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zzi, Api.ApiOptions.NoOptions> f11482k;
    private static final Api<Api.ApiOptions.NoOptions> l;

    static {
        Api.ClientKey<zzi> clientKey = new Api.ClientKey<>();
        f11481j = clientKey;
        a aVar = new a();
        f11482k = aVar;
        l = new Api<>("SmsRetriever.API", aVar, clientKey);
    }
}
