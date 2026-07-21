package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
final class w2 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ e.e.a.a f13489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzanu f13490g;

    w2(zzanu zzanuVar, e.e.a.a aVar) {
        this.f13490g = zzanuVar;
        this.f13489f = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f13490g.a.onAdFailedToLoad(zzaog.a(this.f13489f));
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }
}
