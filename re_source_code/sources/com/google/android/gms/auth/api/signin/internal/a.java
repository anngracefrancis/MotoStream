package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
final class a extends e<Status> {
    a(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    protected final /* synthetic */ Result h(Status status) {
        return status;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void s(Api.AnyClient anyClient) throws RemoteException {
        zzg zzgVar = (zzg) anyClient;
        ((zzu) zzgVar.getService()).i3(new b(this), zzgVar.j());
    }
}
