package e.h.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: LostServiceConnectedHandler.java */
/* JADX INFO: loaded from: classes2.dex */
public class z extends e implements v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<a.b> f21387b = new ArrayList<>();

    @Override // e.h.a.v
    public boolean a(a.b bVar) {
        return !this.f21387b.isEmpty() && this.f21387b.contains(bVar);
    }

    @Override // e.h.a.v
    public boolean b(a.b bVar) {
        if (!q.e().i()) {
            synchronized (this.f21387b) {
                if (!q.e().i()) {
                    if (e.h.a.k0.d.a) {
                        e.h.a.k0.d.a(this, "Waiting for connecting with the downloader service... %d", Integer.valueOf(bVar.v().getId()));
                    }
                    m.b().u0(e.h.a.k0.c.a());
                    if (!this.f21387b.contains(bVar)) {
                        bVar.b();
                        this.f21387b.add(bVar);
                    }
                    return true;
                }
            }
        }
        c(bVar);
        return false;
    }

    @Override // e.h.a.v
    public void c(a.b bVar) {
        if (this.f21387b.isEmpty()) {
            return;
        }
        synchronized (this.f21387b) {
            this.f21387b.remove(bVar);
        }
    }

    @Override // e.h.a.e
    public void e() {
        w wVarG = q.e().g();
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "The downloader service is connected.", new Object[0]);
        }
        synchronized (this.f21387b) {
            List<a.b> list = (List) this.f21387b.clone();
            this.f21387b.clear();
            ArrayList arrayList = new ArrayList(wVarG.a());
            for (a.b bVar : list) {
                int iX = bVar.x();
                if (wVarG.f(iX)) {
                    bVar.v().m().a();
                    if (!arrayList.contains(Integer.valueOf(iX))) {
                        arrayList.add(Integer.valueOf(iX));
                    }
                } else {
                    bVar.w();
                }
            }
            wVarG.d(arrayList);
        }
    }

    @Override // e.h.a.e
    public void f() {
        if (g() != e.h.a.h0.b.a.lost) {
            if (h.i().m() > 0) {
                e.h.a.k0.d.i(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(h.i().m()));
                return;
            }
            return;
        }
        w wVarG = q.e().g();
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(h.i().m()));
        }
        if (h.i().m() > 0) {
            synchronized (this.f21387b) {
                h.i().f(this.f21387b);
                Iterator<a.b> it = this.f21387b.iterator();
                while (it.hasNext()) {
                    it.next().b();
                }
                wVarG.b();
            }
            try {
                q.e().b();
            } catch (IllegalStateException unused) {
                e.h.a.k0.d.i(this, "restart service failed, you may need to restart downloading manually when the app comes back to foreground", new Object[0]);
            }
        }
    }
}
