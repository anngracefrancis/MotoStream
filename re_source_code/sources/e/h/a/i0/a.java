package e.h.a.i0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.liulishuo.filedownloader.message.MessageSnapshot;

/* JADX INFO: compiled from: IFileDownloadIPCCallback.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: e.h.a.i0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IFileDownloadIPCCallback.java */
    public static abstract class AbstractBinderC0278a extends Binder implements a {

        /* JADX INFO: renamed from: e.h.a.i0.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IFileDownloadIPCCallback.java */
        private static class C0279a implements a {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private IBinder f21346f;

            C0279a(IBinder iBinder) {
                this.f21346f = iBinder;
            }

            @Override // e.h.a.i0.a
            public void D4(MessageSnapshot messageSnapshot) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
                    if (messageSnapshot != null) {
                        parcelObtain.writeInt(1);
                        messageSnapshot.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f21346f.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21346f;
            }
        }

        public AbstractBinderC0278a() {
            attachInterface(this, "com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
        }

        public static a H(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0279a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
                D4(parcel.readInt() != 0 ? MessageSnapshot.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel2.writeString("com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
            return true;
        }
    }

    void D4(MessageSnapshot messageSnapshot) throws RemoteException;
}
