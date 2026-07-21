package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
final class d extends zzc {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ c f11539f;

    d(c cVar) {
        this.f11539f = cVar;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzc, com.google.android.gms.auth.api.signin.internal.zzs
    public final void Q1(Status status) throws RemoteException {
        this.f11539f.k(status);
    }
}
