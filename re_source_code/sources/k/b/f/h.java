package k.b.f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: SubstituteLoggerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class h implements k.b.a {
    boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Map<String, g> f22921b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final LinkedBlockingQueue<k.b.e.d> f22922c = new LinkedBlockingQueue<>();

    @Override // k.b.a
    public synchronized k.b.b a(String str) {
        g gVar;
        gVar = this.f22921b.get(str);
        if (gVar == null) {
            gVar = new g(str, this.f22922c, this.a);
            this.f22921b.put(str, gVar);
        }
        return gVar;
    }

    public void b() {
        this.f22921b.clear();
        this.f22922c.clear();
    }

    public LinkedBlockingQueue<k.b.e.d> c() {
        return this.f22922c;
    }

    public List<g> d() {
        return new ArrayList(this.f22921b.values());
    }

    public void e() {
        this.a = true;
    }
}
