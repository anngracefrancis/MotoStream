package b.b.a;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: compiled from: ICustomTabsService.java */
/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {

    /* JADX INFO: compiled from: ICustomTabsService.java */
    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: b.b.a.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ICustomTabsService.java */
        private static class C0059a implements b {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private IBinder f2684f;

            C0059a(IBinder iBinder) {
                this.f2684f = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2684f;
            }

            @Override // b.b.a.b
            public boolean p3(long j2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcelObtain.writeLong(j2);
                    this.f2684f.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // b.b.a.b
            public boolean q1(b.b.a.a aVar, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeTypedList(list);
                    this.f2684f.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // b.b.a.b
            public boolean x4(b.b.a.a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f2684f.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static b H(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("android.support.customtabs.ICustomTabsService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C0059a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }
    }

    boolean p3(long j2) throws RemoteException;

    boolean q1(b.b.a.a aVar, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException;

    boolean x4(b.b.a.a aVar) throws RemoteException;
}
