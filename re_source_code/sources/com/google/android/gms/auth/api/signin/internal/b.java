package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
final class b extends zzc {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ a f11538f;

    b(a aVar) {
        this.f11538f = aVar;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzc, com.google.android.gms.auth.api.signin.internal.zzs
    public final void g1(Status status) throws RemoteException {
        this.f11538f.k(status);
    }
}
