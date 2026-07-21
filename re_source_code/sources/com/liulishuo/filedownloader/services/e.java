package com.liulishuo.filedownloader.services;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import e.h.a.m;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: FDServiceSharedHandler.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends e.h.a.i0.b.a implements j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final g f20522f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final WeakReference<FileDownloadService> f20523g;

    /* JADX INFO: compiled from: FDServiceSharedHandler.java */
    public interface a {
        void a(e eVar);
    }

    e(WeakReference<FileDownloadService> weakReference, g gVar) {
        this.f20523g = weakReference;
        this.f20522f = gVar;
    }

    @Override // e.h.a.i0.b
    public void E6(int i2, Notification notification) {
        WeakReference<FileDownloadService> weakReference = this.f20523g;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f20523g.get().startForeground(i2, notification);
    }

    @Override // e.h.a.i0.b
    public boolean I2(String str, String str2) {
        return this.f20522f.i(str, str2);
    }

    @Override // com.liulishuo.filedownloader.services.j
    public IBinder P(Intent intent) {
        return null;
    }

    @Override // e.h.a.i0.b
    public byte Q(int i2) {
        return this.f20522f.f(i2);
    }

    @Override // e.h.a.i0.b
    public void S(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3) {
        this.f20522f.n(str, str2, z, i2, i3, i4, z2, fileDownloadHeader, z3);
    }

    @Override // e.h.a.i0.b
    public void V4(e.h.a.i0.a aVar) {
    }

    @Override // e.h.a.i0.b
    public void Y6() {
        this.f20522f.l();
    }

    @Override // e.h.a.i0.b
    public boolean Z2(int i2) {
        return this.f20522f.m(i2);
    }

    @Override // e.h.a.i0.b
    public boolean Z4() {
        return this.f20522f.j();
    }

    @Override // e.h.a.i0.b
    public boolean a0(int i2) {
        return this.f20522f.k(i2);
    }

    @Override // com.liulishuo.filedownloader.services.j
    public void k0(Intent intent, int i2, int i3) {
        m.a().a(this);
    }

    @Override // e.h.a.i0.b
    public void l2() {
        this.f20522f.c();
    }

    @Override // e.h.a.i0.b
    public boolean o0(int i2) {
        return this.f20522f.d(i2);
    }

    @Override // e.h.a.i0.b
    public long p4(int i2) {
        return this.f20522f.g(i2);
    }

    @Override // e.h.a.i0.b
    public void t0(boolean z) {
        WeakReference<FileDownloadService> weakReference = this.f20523g;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f20523g.get().stopForeground(z);
    }

    @Override // e.h.a.i0.b
    public long u5(int i2) {
        return this.f20522f.e(i2);
    }

    @Override // e.h.a.i0.b
    public void v1(e.h.a.i0.a aVar) {
    }
}
