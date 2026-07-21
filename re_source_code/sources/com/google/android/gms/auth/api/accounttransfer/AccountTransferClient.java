package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;

/* JADX INFO: loaded from: classes2.dex */
public class AccountTransferClient extends GoogleApi<zzn> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Api.ClientKey<com.google.android.gms.internal.auth.zzu> f11420j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Api.AbstractClientBuilder<com.google.android.gms.internal.auth.zzu, zzn> f11421k;
    private static final Api<zzn> l;

    static {
        Api.ClientKey<com.google.android.gms.internal.auth.zzu> clientKey = new Api.ClientKey<>();
        f11420j = clientKey;
        b bVar = new b();
        f11421k = bVar;
        l = new Api<>("AccountTransfer.ACCOUNT_TRANSFER_API", bVar, clientKey);
    }
}
