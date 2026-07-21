package e.h.a;

import android.os.IBinder;
import android.os.RemoteException;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.services.FileDownloadService;

/* JADX INFO: compiled from: FileDownloadServiceUIGuard.java */
/* JADX INFO: loaded from: classes2.dex */
class o extends com.liulishuo.filedownloader.services.a<a, e.h.a.i0.b> {

    /* JADX INFO: compiled from: FileDownloadServiceUIGuard.java */
    protected static class a extends e.h.a.i0.a.AbstractBinderC0278a {
        protected a() {
        }

        @Override // e.h.a.i0.a
        public void D4(MessageSnapshot messageSnapshot) throws RemoteException {
            com.liulishuo.filedownloader.message.b.a().b(messageSnapshot);
        }
    }

    o() {
        super(FileDownloadService.SeparateProcessService.class);
    }

    @Override // e.h.a.u
    public byte Q(int i2) {
        if (!isConnected()) {
            return e.h.a.k0.a.b(i2);
        }
        try {
            return d().Q(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return (byte) 0;
        }
    }

    @Override // e.h.a.u
    public boolean S(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3) {
        if (!isConnected()) {
            return e.h.a.k0.a.e(str, str2, z);
        }
        try {
            d().S(str, str2, z, i2, i3, i4, z2, fileDownloadHeader, z3);
            return true;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // e.h.a.u
    public boolean a0(int i2) {
        if (!isConnected()) {
            return e.h.a.k0.a.d(i2);
        }
        try {
            return d().a0(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.liulishuo.filedownloader.services.a
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public e.h.a.i0.b a(IBinder iBinder) {
        return e.h.a.i0.b.a.E0(iBinder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.liulishuo.filedownloader.services.a
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public a c() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.liulishuo.filedownloader.services.a
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public void e(e.h.a.i0.b bVar, a aVar) throws RemoteException {
        bVar.v1(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.liulishuo.filedownloader.services.a
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void g(e.h.a.i0.b bVar, a aVar) throws RemoteException {
        bVar.V4(aVar);
    }

    @Override // e.h.a.u
    public boolean o0(int i2) {
        if (!isConnected()) {
            return e.h.a.k0.a.a(i2);
        }
        try {
            return d().o0(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // e.h.a.u
    public void t0(boolean z) {
        if (!isConnected()) {
            e.h.a.k0.a.f(z);
            return;
        }
        try {
            try {
                d().t0(z);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        } finally {
            this.f20510i = false;
        }
    }
}
