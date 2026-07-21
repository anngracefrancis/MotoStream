package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zza implements IInterface {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final IBinder f17305f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f17306g;

    protected zza(IBinder iBinder, String str) {
        this.f17305f = iBinder;
        this.f17306g = str;
    }

    protected final Parcel H() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f17306g);
        return parcelObtain;
    }

    protected final Parcel P(int i2, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f17305f.transact(i2, parcel, parcelObtain, 0);
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
        return this.f17305f;
    }

    protected final void k0(int i2, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f17305f.transact(i2, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
