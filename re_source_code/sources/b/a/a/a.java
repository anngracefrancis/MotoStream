package b.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IPackageInstallObserver.java */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: b.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IPackageInstallObserver.java */
    public static abstract class AbstractBinderC0057a extends Binder implements a {
        public AbstractBinderC0057a() {
            throw new RuntimeException("Stub!");
        }

        public static a asInterface(IBinder iBinder) {
            throw new RuntimeException("Stub!");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            throw new RuntimeException("Stub!");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            throw new RuntimeException("Stub!");
        }

        public abstract void packageInstalled(String str, int i2) throws RemoteException;
    }
}
