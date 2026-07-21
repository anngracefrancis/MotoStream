package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzanj extends zzaas {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f13993f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile zzaau f13994g;

    @Override // com.google.android.gms.internal.ads.zzaar
    public final int F() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean G1() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final float Q6() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void R1(zzaau zzaauVar) throws RemoteException {
        synchronized (this.f13993f) {
            this.f13994g = zzaauVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final float S5() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final float T() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final zzaau a5() throws RemoteException {
        zzaau zzaauVar;
        synchronized (this.f13993f) {
            zzaauVar = this.f13994g;
        }
        return zzaauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean d1() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void k5() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean l5() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void o2(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void pause() throws RemoteException {
        throw new RemoteException();
    }
}
