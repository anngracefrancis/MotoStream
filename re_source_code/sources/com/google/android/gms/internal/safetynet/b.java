package com.google.android.gms.internal.safetynet;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes2.dex */
final class b extends zzk.a {
    b(zzk zzkVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void s(Api.AnyClient anyClient) throws RemoteException {
        ((zzi) ((zzx) anyClient).getService()).M1(this.s);
    }
}
