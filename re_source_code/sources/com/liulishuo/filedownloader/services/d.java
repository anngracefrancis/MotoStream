package com.liulishuo.filedownloader.services;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: FDServiceSeparateHandler.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends e.h.a.i0.b.a implements com.liulishuo.filedownloader.message.b.InterfaceC0246b, j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RemoteCallbackList<e.h.a.i0.a> f20519f = new RemoteCallbackList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final g f20520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final WeakReference<FileDownloadService> f20521h;

    d(WeakReference<FileDownloadService> weakReference, g gVar) {
        this.f20521h = weakReference;
        this.f20520g = gVar;
        com.liulishuo.filedownloader.message.b.a().c(this);
    }

    private synchronized int E3(MessageSnapshot messageSnapshot) {
        int iBeginBroadcast;
        RemoteCallbackList<e.h.a.i0.a> remoteCallbackList;
        iBeginBroadcast = this.f20519f.beginBroadcast();
        for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
            try {
                try {
                    ((e.h.a.i0.a) this.f20519f.getBroadcastItem(i2)).D4(messageSnapshot);
                } catch (Throwable th) {
                    this.f20519f.finishBroadcast();
                    throw th;
                }
            } catch (RemoteException e2) {
                e.h.a.k0.d.c(this, e2, "callback error", new Object[0]);
                remoteCallbackList = this.f20519f;
                remoteCallbackList.finishBroadcast();
                return iBeginBroadcast;
            }
        }
        remoteCallbackList = this.f20519f;
        remoteCallbackList.finishBroadcast();
        return iBeginBroadcast;
    }

    @Override // e.h.a.i0.b
    public void E6(int i2, Notification notification) throws RemoteException {
        WeakReference<FileDownloadService> weakReference = this.f20521h;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f20521h.get().startForeground(i2, notification);
    }

    @Override // com.liulishuo.filedownloader.message.b.InterfaceC0246b
    public void H(MessageSnapshot messageSnapshot) {
        E3(messageSnapshot);
    }

    @Override // e.h.a.i0.b
    public boolean I2(String str, String str2) throws RemoteException {
        return this.f20520g.i(str, str2);
    }

    @Override // com.liulishuo.filedownloader.services.j
    public IBinder P(Intent intent) {
        return this;
    }

    @Override // e.h.a.i0.b
    public byte Q(int i2) throws RemoteException {
        return this.f20520g.f(i2);
    }

    @Override // e.h.a.i0.b
    public void S(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3) throws RemoteException {
        this.f20520g.n(str, str2, z, i2, i3, i4, z2, fileDownloadHeader, z3);
    }

    @Override // e.h.a.i0.b
    public void V4(e.h.a.i0.a aVar) throws RemoteException {
        this.f20519f.unregister(aVar);
    }

    @Override // e.h.a.i0.b
    public void Y6() throws RemoteException {
        this.f20520g.l();
    }

    @Override // e.h.a.i0.b
    public boolean Z2(int i2) throws RemoteException {
        return this.f20520g.m(i2);
    }

    @Override // e.h.a.i0.b
    public boolean Z4() throws RemoteException {
        return this.f20520g.j();
    }

    @Override // e.h.a.i0.b
    public boolean a0(int i2) throws RemoteException {
        return this.f20520g.k(i2);
    }

    @Override // com.liulishuo.filedownloader.services.j
    public void k0(Intent intent, int i2, int i3) {
    }

    @Override // e.h.a.i0.b
    public void l2() throws RemoteException {
        this.f20520g.c();
    }

    @Override // e.h.a.i0.b
    public boolean o0(int i2) throws RemoteException {
        return this.f20520g.d(i2);
    }

    @Override // e.h.a.i0.b
    public long p4(int i2) throws RemoteException {
        return this.f20520g.g(i2);
    }

    @Override // e.h.a.i0.b
    public void t0(boolean z) throws RemoteException {
        WeakReference<FileDownloadService> weakReference = this.f20521h;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f20521h.get().stopForeground(z);
    }

    @Override // e.h.a.i0.b
    public long u5(int i2) throws RemoteException {
        return this.f20520g.e(i2);
    }

    @Override // e.h.a.i0.b
    public void v1(e.h.a.i0.a aVar) throws RemoteException {
        this.f20519f.register(aVar);
    }
}
