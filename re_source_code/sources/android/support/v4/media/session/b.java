package android.support.v4.media.session;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IMediaSession.java */
/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {

    /* JADX INFO: compiled from: IMediaSession.java */
    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: android.support.v4.media.session.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IMediaSession.java */
        private static class C0003a implements b {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private IBinder f54f;

            C0003a(IBinder iBinder) {
                this.f54f = iBinder;
            }

            @Override // android.support.v4.media.session.b
            public void Z0(android.support.v4.media.session.a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f54f.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f54f;
            }
        }

        public static b H(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C0003a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }
    }

    void Z0(android.support.v4.media.session.a aVar) throws RemoteException;
}
