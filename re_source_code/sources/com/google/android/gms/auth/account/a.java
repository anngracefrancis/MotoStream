package com.google.android.gms.auth.account;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.auth.zzr;

/* JADX INFO: loaded from: classes2.dex */
final class a extends Api.AbstractClientBuilder<zzr, Api.ApiOptions.NoOptions> {
    a() {
    }

    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* synthetic */ Api.Client c(Context context, Looper looper, ClientSettings clientSettings, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzr(context, looper, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }
}
