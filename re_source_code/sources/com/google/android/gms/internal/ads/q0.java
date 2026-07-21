package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
final class q0 extends zzaif {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbbr f13199f;

    q0(p0 p0Var, zzbbr zzbbrVar) {
        this.f13199f = zzbbrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaie
    public final void O1(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        this.f13199f.a(parcelFileDescriptor);
    }
}
