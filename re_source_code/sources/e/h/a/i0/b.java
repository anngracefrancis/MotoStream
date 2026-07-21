package e.h.a.i0;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.liulishuo.filedownloader.model.FileDownloadHeader;

/* JADX INFO: compiled from: IFileDownloadIPCService.java */
/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {

    /* JADX INFO: compiled from: IFileDownloadIPCService.java */
    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: e.h.a.i0.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IFileDownloadIPCService.java */
        private static class C0280a implements b {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private IBinder f21347f;

            C0280a(IBinder iBinder) {
                this.f21347f = iBinder;
            }

            @Override // e.h.a.i0.b
            public byte Q(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeInt(i2);
                    this.f21347f.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readByte();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // e.h.a.i0.b
            public void S(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    int i5 = 1;
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (fileDownloadHeader != null) {
                        parcelObtain.writeInt(1);
                        fileDownloadHeader.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!z3) {
                        i5 = 0;
                    }
                    parcelObtain.writeInt(i5);
                    this.f21347f.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // e.h.a.i0.b
            public void V4(e.h.a.i0.a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f21347f.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // e.h.a.i0.b
            public void Y6() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    this.f21347f.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // e.h.a.i0.b
            public boolean a0(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeInt(i2);
                    this.f21347f.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21347f;
            }

            @Override // e.h.a.i0.b
            public boolean o0(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeInt(i2);
                    this.f21347f.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // e.h.a.i0.b
            public void t0(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.f21347f.transact(13, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // e.h.a.i0.b
            public void v1(e.h.a.i0.a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f21347f.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.liulishuo.filedownloader.i.IFileDownloadIPCService");
        }

        public static b E0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C0280a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    v1(e.h.a.i0.a.AbstractBinderC0278a.H(parcel.readStrongBinder()));
                    return true;
                case 2:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    V4(e.h.a.i0.a.AbstractBinderC0278a.H(parcel.readStrongBinder()));
                    return true;
                case 3:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    boolean zI2 = I2(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zI2 ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    S(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0 ? FileDownloadHeader.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    boolean zA0 = a0(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zA0 ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    Y6();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    boolean zZ2 = Z2(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zZ2 ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    long jU5 = u5(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(jU5);
                    return true;
                case 9:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    long jP4 = p4(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(jP4);
                    return true;
                case 10:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    byte bQ = Q(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeByte(bQ);
                    return true;
                case 11:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    boolean zZ4 = Z4();
                    parcel2.writeNoException();
                    parcel2.writeInt(zZ4 ? 1 : 0);
                    return true;
                case 12:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    E6(parcel.readInt(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 13:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    t0(parcel.readInt() != 0);
                    return true;
                case 14:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    boolean zO0 = o0(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zO0 ? 1 : 0);
                    return true;
                case 15:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    l2();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }
    }

    void E6(int i2, Notification notification) throws RemoteException;

    boolean I2(String str, String str2) throws RemoteException;

    byte Q(int i2) throws RemoteException;

    void S(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3) throws RemoteException;

    void V4(e.h.a.i0.a aVar) throws RemoteException;

    void Y6() throws RemoteException;

    boolean Z2(int i2) throws RemoteException;

    boolean Z4() throws RemoteException;

    boolean a0(int i2) throws RemoteException;

    void l2() throws RemoteException;

    boolean o0(int i2) throws RemoteException;

    long p4(int i2) throws RemoteException;

    void t0(boolean z) throws RemoteException;

    long u5(int i2) throws RemoteException;

    void v1(e.h.a.i0.a aVar) throws RemoteException;
}
