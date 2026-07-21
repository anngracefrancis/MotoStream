package i.a.g.t;

import i.a.g.l;
import java.util.Timer;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: RecordReaper.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static k.b.b f21897g = k.b.c.i(b.class.getName());

    public b(l lVar) {
        super(lVar);
    }

    @Override // i.a.g.t.a
    public String f() {
        StringBuilder sb = new StringBuilder();
        sb.append("RecordReaper(");
        sb.append(e() != null ? e().p0() : HttpUrl.FRAGMENT_ENCODE_SET);
        sb.append(")");
        return sb.toString();
    }

    public void g(Timer timer) {
        if (e().X0() || e().V0()) {
            return;
        }
        timer.schedule(this, 10000L, 10000L);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (e().X0() || e().V0()) {
            return;
        }
        if (f21897g.d()) {
            f21897g.i(f() + ".run() JmDNS reaping cache");
        }
        e().Q();
    }
}
