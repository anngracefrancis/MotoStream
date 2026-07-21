package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: INotificationSideChannel.java */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: android.support.v4.app.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: INotificationSideChannel.java */
    public static abstract class AbstractBinderC0000a extends Binder implements a {

        /* JADX INFO: renamed from: android.support.v4.app.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: INotificationSideChannel.java */
        private static class C0001a implements a {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static a f0f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private IBinder f1g;

            C0001a(IBinder iBinder) {
                this.f1g = iBinder;
            }

            @Override // android.support.v4.app.a
            public void F6(String str, int i2, String str2, Notification notification) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str2);
                    if (notification != null) {
                        parcelObtain.writeInt(1);
                        notification.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f1g.transact(1, parcelObtain, null, 1) || AbstractBinderC0000a.P() == null) {
                        return;
                    }
                    AbstractBinderC0000a.P().F6(str, i2, str2, notification);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1g;
            }
        }

        public static a H(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0001a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a P() {
            return C0001a.f0f;
        }
    }

    void F6(String str, int i2, String str2, Notification notification) throws RemoteException;
}
