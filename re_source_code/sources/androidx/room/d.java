package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IMultiInstanceInvalidationCallback.java */
/* JADX INFO: loaded from: classes.dex */
public interface d extends IInterface {

    /* JADX INFO: compiled from: IMultiInstanceInvalidationCallback.java */
    public static abstract class a extends Binder implements d {

        /* JADX INFO: renamed from: androidx.room.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IMultiInstanceInvalidationCallback.java */
        private static class C0043a implements d {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private IBinder f2127f;

            C0043a(IBinder iBinder) {
                this.f2127f = iBinder;
            }

            @Override // androidx.room.d
            public void L1(String[] strArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
                    parcelObtain.writeStringArray(strArr);
                    this.f2127f.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2127f;
            }
        }

        public a() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationCallback");
        }

        public static d H(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof d)) ? new C0043a(iBinder) : (d) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationCallback");
                L1(parcel.createStringArray());
                return true;
            }
            if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel2.writeString("androidx.room.IMultiInstanceInvalidationCallback");
            return true;
        }
    }

    void L1(String[] strArr) throws RemoteException;
}
