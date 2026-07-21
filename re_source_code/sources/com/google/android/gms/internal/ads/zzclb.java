package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzclb extends zzatl implements zzbsm {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzatk f15358f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzbsn f15359g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzbvo f15360h;

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void F1(IObjectWrapper iObjectWrapper, int i2) throws RemoteException {
        zzatk zzatkVar = this.f15358f;
        if (zzatkVar != null) {
            zzatkVar.F1(iObjectWrapper, i2);
        }
        zzbvo zzbvoVar = this.f15360h;
        if (zzbvoVar != null) {
            zzbvoVar.a(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void G6(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzatk zzatkVar = this.f15358f;
        if (zzatkVar != null) {
            zzatkVar.G6(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void Y3(IObjectWrapper iObjectWrapper, zzato zzatoVar) throws RemoteException {
        zzatk zzatkVar = this.f15358f;
        if (zzatkVar != null) {
            zzatkVar.Y3(iObjectWrapper, zzatoVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void Y5(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzatk zzatkVar = this.f15358f;
        if (zzatkVar != null) {
            zzatkVar.Y5(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void a2(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzatk zzatkVar = this.f15358f;
        if (zzatkVar != null) {
            zzatkVar.a2(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void b5(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzatk zzatkVar = this.f15358f;
        if (zzatkVar != null) {
            zzatkVar.b5(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void c3(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzatk zzatkVar = this.f15358f;
        if (zzatkVar != null) {
            zzatkVar.c3(iObjectWrapper);
        }
        zzbvo zzbvoVar = this.f15360h;
        if (zzbvoVar != null) {
            zzbvoVar.onInitializationSucceeded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void e4(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzatk zzatkVar = this.f15358f;
        if (zzatkVar != null) {
            zzatkVar.e4(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void f1(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzatk zzatkVar = this.f15358f;
        if (zzatkVar != null) {
            zzatkVar.f1(iObjectWrapper);
        }
    }

    public final synchronized void i7(zzatk zzatkVar) {
        this.f15358f = zzatkVar;
    }

    public final synchronized void j7(zzbvo zzbvoVar) {
        this.f15360h = zzbvoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsm
    public final synchronized void n6(zzbsn zzbsnVar) {
        this.f15359g = zzbsnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void q2(IObjectWrapper iObjectWrapper, int i2) throws RemoteException {
        zzatk zzatkVar = this.f15358f;
        if (zzatkVar != null) {
            zzatkVar.q2(iObjectWrapper, i2);
        }
        zzbsn zzbsnVar = this.f15359g;
        if (zzbsnVar != null) {
            zzbsnVar.onAdFailedToLoad(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void w3(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzatk zzatkVar = this.f15358f;
        if (zzatkVar != null) {
            zzatkVar.w3(iObjectWrapper);
        }
        zzbsn zzbsnVar = this.f15359g;
        if (zzbsnVar != null) {
            zzbsnVar.onAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final synchronized void zzb(Bundle bundle) throws RemoteException {
        zzatk zzatkVar = this.f15358f;
        if (zzatkVar != null) {
            zzatkVar.zzb(bundle);
        }
    }
}
