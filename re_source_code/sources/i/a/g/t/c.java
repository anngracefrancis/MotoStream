package i.a.g.t;

import i.a.g.f;
import i.a.g.g;
import i.a.g.h;
import i.a.g.l;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Responder.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static k.b.b f21898g = k.b.c.i(c.class.getName());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final i.a.g.c f21899h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final InetAddress f21900i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f21901j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f21902k;

    public c(l lVar, i.a.g.c cVar, InetAddress inetAddress, int i2) {
        super(lVar);
        this.f21899h = cVar;
        this.f21900i = inetAddress;
        this.f21901j = i2;
        this.f21902k = i2 != i.a.g.s.a.a;
    }

    @Override // i.a.g.t.a
    public String f() {
        StringBuilder sb = new StringBuilder();
        sb.append("Responder(");
        sb.append(e() != null ? e().p0() : HttpUrl.FRAGMENT_ENCODE_SET);
        sb.append(")");
        return sb.toString();
    }

    public void g(Timer timer) {
        boolean zB = true;
        for (g gVar : this.f21899h.l()) {
            if (f21898g.d()) {
                f21898g.i(f() + "start() question=" + gVar);
            }
            zB = gVar.B(e());
            if (!zB) {
                break;
            }
        }
        int iNextInt = (!zB || this.f21899h.r()) ? (l.q0().nextInt(96) + 20) - this.f21899h.A() : 0;
        int i2 = iNextInt >= 0 ? iNextInt : 0;
        if (f21898g.d()) {
            f21898g.i(f() + "start() Responder chosen delay=" + i2);
        }
        if (e().X0() || e().V0()) {
            return;
        }
        timer.schedule(this, i2);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        e().v1(this.f21899h);
        HashSet<g> hashSet = new HashSet();
        Set<h> hashSet2 = new HashSet<>();
        if (e().R0()) {
            try {
                for (g gVar : this.f21899h.l()) {
                    if (f21898g.b()) {
                        f21898g.c(f() + "run() JmDNS responding to: " + gVar);
                    }
                    if (this.f21902k) {
                        hashSet.add(gVar);
                    }
                    gVar.y(e(), hashSet2);
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (h hVar : this.f21899h.c()) {
                    if (hVar.J(jCurrentTimeMillis)) {
                        hashSet2.remove(hVar);
                        if (f21898g.b()) {
                            f21898g.c(f() + "JmDNS Responder Known Answer Removed");
                        }
                    }
                }
                if (hashSet2.isEmpty()) {
                    return;
                }
                if (f21898g.b()) {
                    f21898g.c(f() + "run() JmDNS responding");
                }
                f fVar = new f(33792, !this.f21902k, this.f21899h.B());
                if (this.f21902k) {
                    fVar.F(new InetSocketAddress(this.f21900i, this.f21901j));
                }
                fVar.w(this.f21899h.f());
                for (g gVar2 : hashSet) {
                    if (gVar2 != null) {
                        fVar = d(fVar, gVar2);
                    }
                }
                for (h hVar2 : hashSet2) {
                    if (hVar2 != null) {
                        fVar = a(fVar, this.f21899h, hVar2);
                    }
                }
                if (fVar.n()) {
                    return;
                }
                e().x1(fVar);
            } catch (Throwable th) {
                f21898g.f(f() + "run() exception ", th);
                e().close();
            }
        }
    }

    @Override // i.a.g.t.a
    public String toString() {
        return super.toString() + " incomming: " + this.f21899h;
    }
}
