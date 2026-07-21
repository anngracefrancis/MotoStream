package h.a.x;

import io.reactivex.exceptions.CompositeException;
import java.util.ArrayList;

/* JADX INFO: compiled from: CompositeDisposable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements c, h.a.z.a.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    h.a.z.j.e<c> f21443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile boolean f21444g;

    @Override // h.a.z.a.b
    public boolean a(c cVar) {
        if (!c(cVar)) {
            return false;
        }
        cVar.k();
        return true;
    }

    @Override // h.a.z.a.b
    public boolean b(c cVar) {
        h.a.z.b.b.c(cVar, "disposable is null");
        if (!this.f21444g) {
            synchronized (this) {
                if (!this.f21444g) {
                    h.a.z.j.e<c> eVar = this.f21443f;
                    if (eVar == null) {
                        eVar = new h.a.z.j.e<>();
                        this.f21443f = eVar;
                    }
                    eVar.a(cVar);
                    return true;
                }
            }
        }
        cVar.k();
        return false;
    }

    @Override // h.a.z.a.b
    public boolean c(c cVar) {
        h.a.z.b.b.c(cVar, "disposables is null");
        if (this.f21444g) {
            return false;
        }
        synchronized (this) {
            if (this.f21444g) {
                return false;
            }
            h.a.z.j.e<c> eVar = this.f21443f;
            if (eVar != null && eVar.e(cVar)) {
                return true;
            }
            return false;
        }
    }

    void d(h.a.z.j.e<c> eVar) {
        if (eVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : eVar.b()) {
            if (obj instanceof c) {
                try {
                    ((c) obj).k();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.a(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
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
        if (this.f21444g) {
            return;
        }
        synchronized (this) {
            if (this.f21444g) {
                return;
            }
            this.f21444g = true;
            h.a.z.j.e<c> eVar = this.f21443f;
            this.f21443f = null;
            d(eVar);
        }
    }

    @Override // h.a.x.c
    public boolean q() {
        return this.f21444g;
    }
}
