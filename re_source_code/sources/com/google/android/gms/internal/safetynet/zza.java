package com.google.android.gms.internal.safetynet;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public class zza implements IInterface {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final IBinder f17588f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f17589g;

    protected zza(IBinder iBinder, String str) {
        this.f17588f = iBinder;
        this.f17589g = str;
    }

    protected final Parcel H() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f17589g);
        return parcelObtain;
    }

    protected final void P(int i2, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f17588f.transact(i2, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f17588f;
    }
}
