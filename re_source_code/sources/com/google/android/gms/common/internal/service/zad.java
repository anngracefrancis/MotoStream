package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
public final class zad implements zac {
    @Override // com.google.android.gms.common.internal.service.zac
    public final PendingResult<Status> a(GoogleApiClient googleApiClient) {
        return googleApiClient.k(new b(this, googleApiClient));
    }
}
