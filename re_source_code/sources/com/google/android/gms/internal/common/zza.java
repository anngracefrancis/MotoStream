package com.google.android.gms.internal.common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zza implements IInterface {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final IBinder f17071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f17072g;

    protected zza(IBinder iBinder, String str) {
        this.f17071f = iBinder;
        this.f17072g = str;
    }

    protected final Parcel H(int i2, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f17071f.transact(i2, parcel, parcelObtain, 0);
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

    protected final void P(int i2, Parcel parcel) throws RemoteException {
        try {
            this.f17071f.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f17071f;
    }

    protected final Parcel k0() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f17072g);
        return parcelObtain;
    }
}
