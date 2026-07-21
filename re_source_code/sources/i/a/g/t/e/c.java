package i.a.g.t.e;

import i.a.g.f;
import i.a.g.i;
import i.a.g.l;
import i.a.g.q;
import i.a.g.s.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DNSStateTask.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends i.a.g.t.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static k.b.b f21909g = k.b.c.i(c.class.getName());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f21910h = 3600;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f21911i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private g f21912j;

    public c(l lVar, int i2) {
        super(lVar);
        this.f21912j = null;
        this.f21911i = i2;
    }

    public static int n() {
        return f21910h;
    }

    protected void g(List<i> list) {
        if (list != null) {
            for (i iVar : list) {
                synchronized (iVar) {
                    iVar.d(this);
                }
            }
        }
    }

    protected abstract void h();

    protected void i(g gVar) {
        synchronized (e()) {
            e().K(this, gVar);
        }
        Iterator<i.a.d> it = e().y0().values().iterator();
        while (it.hasNext()) {
            ((q) it.next()).E(this, gVar);
        }
    }

    protected abstract f j(f fVar) throws IOException;

    protected abstract f k(q qVar, f fVar) throws IOException;

    protected abstract boolean l();

    protected abstract f m();

    public int o() {
        return this.f21911i;
    }

    public abstract String p();

    protected g q() {
        return this.f21912j;
    }

    protected abstract void r(Throwable th);

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        f fVarM = m();
        try {
            if (!l()) {
                cancel();
                return;
            }
            List<i> arrayList = new ArrayList<>();
            synchronized (e()) {
                if (e().T0(this, q())) {
                    f21909g.c(f() + ".run() JmDNS " + p() + " " + e().p0());
                    arrayList.add(e());
                    fVarM = j(fVarM);
                }
            }
            Iterator<i.a.d> it = e().y0().values().iterator();
            while (it.hasNext()) {
                q qVar = (q) it.next();
                synchronized (qVar) {
                    if (qVar.S(this, q())) {
                        f21909g.c(f() + ".run() JmDNS " + p() + " " + qVar.o());
                        arrayList.add(qVar);
                        fVarM = k(qVar, fVarM);
                    }
                }
            }
            if (fVarM.n()) {
                g(arrayList);
                cancel();
                return;
            }
            f21909g.c(f() + ".run() JmDNS " + p() + " #" + q());
            e().x1(fVarM);
            g(arrayList);
            h();
        } catch (Throwable th) {
            f21909g.f(f() + ".run() exception ", th);
            r(th);
        }
    }

    protected void s() {
        synchronized (e()) {
            e().q1(this);
        }
        Iterator<i.a.d> it = e().y0().values().iterator();
        while (it.hasNext()) {
            ((q) it.next()).Z(this);
        }
    }

    protected void t(g gVar) {
        this.f21912j = gVar;
    }
}
