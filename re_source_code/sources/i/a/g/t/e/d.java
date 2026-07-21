package i.a.g.t.e;

import i.a.g.f;
import i.a.g.h;
import i.a.g.l;
import i.a.g.q;
import i.a.g.s.g;
import java.io.IOException;
import java.util.Iterator;
import java.util.Timer;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Prober.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static k.b.b f21913k = k.b.c.i(d.class.getName());

    public d(l lVar) {
        super(lVar, c.n());
        g gVar = g.f21884f;
        t(gVar);
        i(gVar);
    }

    @Override // java.util.TimerTask
    public boolean cancel() {
        s();
        return super.cancel();
    }

    @Override // i.a.g.t.a
    public String f() {
        StringBuilder sb = new StringBuilder();
        sb.append("Prober(");
        sb.append(e() != null ? e().p0() : HttpUrl.FRAGMENT_ENCODE_SET);
        sb.append(")");
        return sb.toString();
    }

    @Override // i.a.g.t.e.c
    protected void h() {
        t(q().g());
        if (q().A()) {
            return;
        }
        cancel();
        e().l();
    }

    @Override // i.a.g.t.e.c
    protected f j(f fVar) throws IOException {
        fVar.A(i.a.g.g.C(e().n0().q(), i.a.g.s.e.TYPE_ANY, i.a.g.s.d.CLASS_IN, false));
        Iterator<h> it = e().n0().a(i.a.g.s.d.CLASS_ANY, false, o()).iterator();
        while (it.hasNext()) {
            fVar = c(fVar, it.next());
        }
        return fVar;
    }

    @Override // i.a.g.t.e.c
    protected f k(q qVar, f fVar) throws IOException {
        String strO = qVar.o();
        i.a.g.s.e eVar = i.a.g.s.e.TYPE_ANY;
        i.a.g.s.d dVar = i.a.g.s.d.CLASS_IN;
        return c(d(fVar, i.a.g.g.C(strO, eVar, dVar, false)), new h.f(qVar.o(), dVar, false, o(), qVar.m(), qVar.t(), qVar.l(), e().n0().q()));
    }

    @Override // i.a.g.t.e.c
    protected boolean l() {
        return (e().X0() || e().V0()) ? false : true;
    }

    @Override // i.a.g.t.e.c
    protected f m() {
        return new f(0);
    }

    @Override // i.a.g.t.e.c
    public String p() {
        return "probing";
    }

    @Override // i.a.g.t.e.c
    protected void r(Throwable th) {
        e().h1();
    }

    @Override // i.a.g.t.a
    public String toString() {
        return super.toString() + " state: " + q();
    }

    public void u(Timer timer) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - e().m0() < 5000) {
            e().z1(e().F0() + 1);
        } else {
            e().z1(1);
        }
        e().y1(jCurrentTimeMillis);
        if (e().R0() && e().F0() < 10) {
            timer.schedule(this, l.q0().nextInt(251), 250L);
        } else {
            if (e().X0() || e().V0()) {
                return;
            }
            timer.schedule(this, 1000L, 1000L);
        }
    }
}
