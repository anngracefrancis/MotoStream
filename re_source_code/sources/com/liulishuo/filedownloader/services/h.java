package com.liulishuo.filedownloader.services;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: FileDownloadThreadPool.java */
/* JADX INFO: loaded from: classes2.dex */
class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ThreadPoolExecutor f20525b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f20527d;
    private SparseArray<e.h.a.g0.d> a = new SparseArray<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f20526c = "Network";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f20528e = 0;

    h(int i2) {
        this.f20525b = e.h.a.k0.b.a(i2, "Network");
        this.f20527d = i2;
    }

    private synchronized void d() {
        SparseArray<e.h.a.g0.d> sparseArray = new SparseArray<>();
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iKeyAt = this.a.keyAt(i2);
            e.h.a.g0.d dVar = this.a.get(iKeyAt);
            if (dVar != null && dVar.p()) {
                sparseArray.put(iKeyAt, dVar);
            }
        }
        this.a = sparseArray;
    }

    public void a(int i2) {
        d();
        synchronized (this) {
            e.h.a.g0.d dVar = this.a.get(i2);
            if (dVar != null) {
                dVar.r();
                boolean zRemove = this.f20525b.remove(dVar);
                if (e.h.a.k0.d.a) {
                    e.h.a.k0.d.a(this, "successful cancel %d %B", Integer.valueOf(i2), Boolean.valueOf(zRemove));
                }
            }
            this.a.remove(i2);
        }
    }

    public synchronized int b() {
        d();
        return this.a.size();
    }

    public void c(e.h.a.g0.d dVar) {
        dVar.s();
        synchronized (this) {
            this.a.put(dVar.k(), dVar);
        }
        this.f20525b.execute(dVar);
        int i2 = this.f20528e;
        if (i2 < 600) {
            this.f20528e = i2 + 1;
        } else {
            d();
            this.f20528e = 0;
        }
    }

    public synchronized int e(String str, int i2) {
        if (str == null) {
            return 0;
        }
        int size = this.a.size();
        for (int i3 = 0; i3 < size; i3++) {
            e.h.a.g0.d dVarValueAt = this.a.valueAt(i3);
            if (dVarValueAt != null && dVarValueAt.p() && dVarValueAt.k() != i2 && str.equals(dVarValueAt.l())) {
                return dVarValueAt.k();
            }
        }
        return 0;
    }

    public synchronized List<Integer> f() {
        ArrayList arrayList;
        d();
        arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            SparseArray<e.h.a.g0.d> sparseArray = this.a;
            arrayList.add(Integer.valueOf(sparseArray.get(sparseArray.keyAt(i2)).k()));
        }
        return arrayList;
    }

    public synchronized boolean g(int i2) {
        e.h.a.g0.d dVar;
        dVar = this.a.get(i2);
        return dVar != null && dVar.p();
    }

    public synchronized boolean h(int i2) {
        if (b() > 0) {
            e.h.a.k0.d.i(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int iB = e.h.a.k0.e.b(i2);
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.f20527d), Integer.valueOf(iB));
        }
        List<Runnable> listShutdownNow = this.f20525b.shutdownNow();
        this.f20525b = e.h.a.k0.b.a(iB, "Network");
        if (listShutdownNow.size() > 0) {
            e.h.a.k0.d.i(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(listShutdownNow.size()));
        }
        this.f20527d = iB;
        return true;
    }
}
