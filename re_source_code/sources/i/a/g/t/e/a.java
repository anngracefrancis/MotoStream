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

/* JADX INFO: compiled from: Announcer.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static k.b.b f21907k = k.b.c.i(a.class.getName());

    public a(l lVar) {
        super(lVar, c.n());
        g gVar = g.f21887i;
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
        sb.append("Announcer(");
        sb.append(e() != null ? e().p0() : HttpUrl.FRAGMENT_ENCODE_SET);
        sb.append(")");
        return sb.toString();
    }

    @Override // i.a.g.t.e.c
    protected void h() {
        t(q().g());
        if (q().q()) {
            return;
        }
        cancel();
        e().x();
    }

    @Override // i.a.g.t.e.c
    protected f j(f fVar) throws IOException {
        Iterator<h> it = e().n0().a(i.a.g.s.d.CLASS_ANY, true, o()).iterator();
        while (it.hasNext()) {
            fVar = a(fVar, null, it.next());
        }
        return fVar;
    }

    @Override // i.a.g.t.e.c
    protected f k(q qVar, f fVar) throws IOException {
        Iterator<h> it = qVar.D(i.a.g.s.d.CLASS_ANY, true, o(), e().n0()).iterator();
        while (it.hasNext()) {
            fVar = a(fVar, null, it.next());
        }
        return fVar;
    }

    @Override // i.a.g.t.e.c
    protected boolean l() {
        return (e().X0() || e().V0()) ? false : true;
    }

    @Override // i.a.g.t.e.c
    protected f m() {
        return new f(33792);
    }

    @Override // i.a.g.t.e.c
    public String p() {
        return "announcing";
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
        if (e().X0() || e().V0()) {
            return;
        }
        timer.schedule(this, 1000L, 1000L);
    }
}
