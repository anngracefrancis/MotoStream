package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IMultiInstanceInvalidationService.java */
/* JADX INFO: loaded from: classes.dex */
public interface e extends IInterface {

    /* JADX INFO: compiled from: IMultiInstanceInvalidationService.java */
    public static abstract class a extends Binder implements e {

        /* JADX INFO: renamed from: androidx.room.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IMultiInstanceInvalidationService.java */
        private static class C0044a implements e {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private IBinder f2128f;

            C0044a(IBinder iBinder) {
                this.f2128f = iBinder;
            }

            @Override // androidx.room.e
            public void S6(d dVar, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    parcelObtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    this.f2128f.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2128f;
            }

            @Override // androidx.room.e
            public int k2(d dVar, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    parcelObtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.f2128f.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.room.e
            public void z6(int i2, String[] strArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStringArray(strArr);
                    this.f2128f.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
        }

        public static e H(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof e)) ? new C0044a(iBinder) : (e) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                int iK2 = k2(d.a.H(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(iK2);
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                S6(d.a.H(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i2 == 3) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                z6(parcel.readInt(), parcel.createStringArray());
                return true;
            }
            if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
            return true;
        }
    }

    void S6(d dVar, int i2) throws RemoteException;

    int k2(d dVar, String str) throws RemoteException;

    void z6(int i2, String[] strArr) throws RemoteException;
}
