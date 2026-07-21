package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public class zza implements IInterface {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final IBinder f17015f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f17016g;

    protected zza(IBinder iBinder, String str) {
        this.f17015f = iBinder;
        this.f17016g = str;
    }

    protected final Parcel H() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f17016g);
        return parcelObtain;
    }

    protected final Parcel P(int i2, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f17015f.transact(i2, parcel, parcelObtain, 0);
                parcelObtain.readException();
                parcel.recycle();
                return parcelObtain;
            } catch (RuntimeException e2) {
                parcelObtain.recycle();
                throw e2;
            }
        } catch (Throwable th) {
            parcel.recycle();
            throw th;
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f17015f;
    }
}
