package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public class zzfm implements IInterface {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final IBinder f16226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f16227g;

    protected zzfm(IBinder iBinder, String str) {
        this.f16226f = iBinder;
        this.f16227g = str;
    }

    protected final void E0(int i2, Parcel parcel) throws RemoteException {
        try {
            this.f16226f.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    protected final Parcel H() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f16227g);
        return parcelObtain;
    }

    protected final Parcel P(int i2, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f16226f.transact(i2, parcel, parcelObtain, 0);
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
        return this.f16226f;
    }

    protected final void k0(int i2, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f16226f.transact(i2, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
