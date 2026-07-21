package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class j implements IGmsServiceBroker {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final IBinder f12034f;

    j(IBinder iBinder) {
        this.f12034f = iBinder;
    }

    @Override // com.google.android.gms.common.internal.IGmsServiceBroker
    public final void U1(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(iGmsCallbacks != null ? iGmsCallbacks.asBinder() : null);
            if (getServiceRequest != null) {
                parcelObtain.writeInt(1);
                zzm.a(getServiceRequest, parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.f12034f.transact(46, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f12034f;
    }
}
