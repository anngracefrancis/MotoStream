package e.e.b.b.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IGetInstallReferrerService.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: e.e.b.b.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IGetInstallReferrerService.java */
    public static abstract class AbstractBinderC0258a extends Binder implements a {

        /* JADX INFO: renamed from: e.e.b.b.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IGetInstallReferrerService.java */
        private static class C0259a implements a {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private IBinder f20884f;

            C0259a(IBinder iBinder) {
                this.f20884f = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f20884f;
            }

            @Override // e.e.b.b.a.a
            public Bundle e3(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f20884f.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
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
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0259a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }

    Bundle e3(Bundle bundle) throws RemoteException;
}
