package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* JADX INFO: loaded from: classes2.dex */
public final class zzv extends com.google.android.gms.internal.p000authapi.zzc implements zzu {
    zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzu
    public final void B3(zzs zzsVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel parcelH = H();
        com.google.android.gms.internal.p000authapi.zze.b(parcelH, zzsVar);
        com.google.android.gms.internal.p000authapi.zze.c(parcelH, googleSignInOptions);
        P(103, parcelH);
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzu
    public final void i3(zzs zzsVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel parcelH = H();
        com.google.android.gms.internal.p000authapi.zze.b(parcelH, zzsVar);
        com.google.android.gms.internal.p000authapi.zze.c(parcelH, googleSignInOptions);
        P(102, parcelH);
    }
}
