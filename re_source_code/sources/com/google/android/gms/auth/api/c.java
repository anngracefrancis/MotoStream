package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class c extends Api.AbstractClientBuilder<zzg, GoogleSignInOptions> {
    c() {
    }

    @Override // com.google.android.gms.common.api.Api.BaseClientBuilder
    public final /* synthetic */ List a(Object obj) {
        GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
        return googleSignInOptions == null ? Collections.emptyList() : googleSignInOptions.z();
    }

    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* synthetic */ Api.Client c(Context context, Looper looper, ClientSettings clientSettings, GoogleSignInOptions googleSignInOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzg(context, looper, clientSettings, googleSignInOptions, connectionCallbacks, onConnectionFailedListener);
    }
}
