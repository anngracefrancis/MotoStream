package com.google.android.gms.auth.api.signin.internal;

import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
public final class zzf implements GoogleSignInApi {
    private static GoogleSignInOptions e(GoogleApiClient googleApiClient) {
        return ((zzg) googleApiClient.m(Auth.f11400b)).j();
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public final Intent a(GoogleApiClient googleApiClient) {
        return zzh.b(googleApiClient.n(), e(googleApiClient));
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public final GoogleSignInResult b(Intent intent) {
        return zzh.a(intent);
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public final PendingResult<Status> c(GoogleApiClient googleApiClient) {
        return zzh.e(googleApiClient, googleApiClient.n(), false);
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public final PendingResult<Status> d(GoogleApiClient googleApiClient) {
        return zzh.c(googleApiClient, googleApiClient.n(), false);
    }
}
