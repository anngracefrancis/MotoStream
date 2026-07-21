package com.facebook.q0.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IReceiverService.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.facebook.q0.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IReceiverService.java */
    public static abstract class AbstractBinderC0154a extends Binder implements a {

        /* JADX INFO: renamed from: com.facebook.q0.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IReceiverService.java */
        private static class C0155a implements a {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static a f10561f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private IBinder f10562g;

            C0155a(IBinder iBinder) {
                this.f10562g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10562g;
            }

            @Override // com.facebook.q0.a.a
            public int u1(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.facebook.ppml.receiver.IReceiverService");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f10562g.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0154a.P() != null) {
                        return AbstractBinderC0154a.P().u1(bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static a H(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.facebook.ppml.receiver.IReceiverService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0155a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a P() {
            return C0155a.f10561f;
        }
    }

    int u1(Bundle bundle) throws RemoteException;
}
