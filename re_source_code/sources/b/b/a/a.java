package b.b.a;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: ICustomTabsCallback.java */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: b.b.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ICustomTabsCallback.java */
    public static abstract class AbstractBinderC0058a extends Binder implements a {
        public AbstractBinderC0058a() {
            attachInterface(this, "android.support.customtabs.ICustomTabsCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 2) {
                parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                r5(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i2 == 3) {
                parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                N4(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i2 == 4) {
                parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                B6(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i2 == 5) {
                parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                q6(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i2 != 6) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("android.support.customtabs.ICustomTabsCallback");
                return true;
            }
            parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
            J6(parcel.readInt(), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void B6(Bundle bundle) throws RemoteException;

    void J6(int i2, Uri uri, boolean z, Bundle bundle) throws RemoteException;

    void N4(String str, Bundle bundle) throws RemoteException;

    void q6(String str, Bundle bundle) throws RemoteException;

    void r5(int i2, Bundle bundle) throws RemoteException;
}
