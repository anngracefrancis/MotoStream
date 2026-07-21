package h.a.z.a;

import io.reactivex.exceptions.CompositeException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: ListCompositeDisposable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements h.a.x.c, b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    List<h.a.x.c> f21450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile boolean f21451g;

    @Override // h.a.z.a.b
    public boolean a(h.a.x.c cVar) {
        if (!c(cVar)) {
            return false;
        }
        cVar.k();
        return true;
    }

    @Override // h.a.z.a.b
    public boolean b(h.a.x.c cVar) {
        h.a.z.b.b.c(cVar, "d is null");
        if (!this.f21451g) {
            synchronized (this) {
                if (!this.f21451g) {
                    List linkedList = this.f21450f;
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                        this.f21450f = linkedList;
                    }
                    linkedList.add(cVar);
                    return true;
                }
            }
        }
        cVar.k();
        return false;
    }

    @Override // h.a.z.a.b
    public boolean c(h.a.x.c cVar) {
        h.a.z.b.b.c(cVar, "Disposable item is null");
        if (this.f21451g) {
            return false;
        }
        synchronized (this) {
            if (this.f21451g) {
                return false;
            }
            List<h.a.x.c> list = this.f21450f;
            if (list != null && list.remove(cVar)) {
                return true;
            }
            return false;
        }
    }

    void d(List<h.a.x.c> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = null;
        Iterator<h.a.x.c> it = list.iterator();
        while (it.hasNext()) {
            try {
                it.next().k();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.a(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() != 1) {
                throw new CompositeException(arrayList);
            }
            throw h.a.z.j.c.c((Throwable) arrayList.get(0));
        }
    }

    @Override // h.a.x.c
    public void k() {
        if (this.f21451g) {
            return;
        }
        synchronized (this) {
            if (this.f21451g) {
                return;
            }
            this.f21451g = true;
            List<h.a.x.c> list = this.f21450f;
            this.f21450f = null;
            d(list);
        }
    }

    @Override // h.a.x.c
    public boolean q() {
        return this.f21451g;
    }
}
