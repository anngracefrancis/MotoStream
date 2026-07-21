package i.a.g;

import java.net.InetAddress;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: DNSTaskStarter.java */
/* JADX INFO: loaded from: classes2.dex */
public interface j {

    /* JADX INFO: compiled from: DNSTaskStarter.java */
    public static final class b {
        private static volatile b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final AtomicReference<a> f21794b = new AtomicReference<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ConcurrentMap<l, j> f21795c = new ConcurrentHashMap(20);

        /* JADX INFO: compiled from: DNSTaskStarter.java */
        public interface a {
            j a(l lVar);
        }

        private b() {
        }

        public static b b() {
            if (a == null) {
                synchronized (b.class) {
                    if (a == null) {
                        a = new b();
                    }
                }
            }
            return a;
        }

        protected static j d(l lVar) {
            a aVar = f21794b.get();
            j jVarA = aVar != null ? aVar.a(lVar) : null;
            return jVarA != null ? jVarA : new a(lVar);
        }

        public void a(l lVar) {
            this.f21795c.remove(lVar);
        }

        public j c(l lVar) {
            j jVar = this.f21795c.get(lVar);
            if (jVar != null) {
                return jVar;
            }
            this.f21795c.putIfAbsent(lVar, d(lVar));
            return this.f21795c.get(lVar);
        }
    }

    void a();

    void b();

    void c(String str);

    void e();

    void f();

    void j();

    void k();

    void l();

    void m(c cVar, InetAddress inetAddress, int i2);

    void p();

    void x();

    void y(q qVar);

    /* JADX INFO: compiled from: DNSTaskStarter.java */
    public static final class a implements j {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final l f21791f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Timer f21792g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Timer f21793h;

        public a(l lVar) {
            this.f21791f = lVar;
            this.f21792g = new C0305a("JmDNS(" + lVar.p0() + ").Timer", true);
            this.f21793h = new C0305a("JmDNS(" + lVar.p0() + ").State.Timer", true);
        }

        @Override // i.a.g.j
        public void a() {
            this.f21792g.purge();
        }

        @Override // i.a.g.j
        public void b() {
            this.f21793h.cancel();
        }

        @Override // i.a.g.j
        public void c(String str) {
            new i.a.g.t.d.c(this.f21791f, str).j(this.f21792g);
        }

        @Override // i.a.g.j
        public void e() {
            this.f21792g.cancel();
        }

        @Override // i.a.g.j
        public void f() {
            new i.a.g.t.e.b(this.f21791f).u(this.f21793h);
        }

        @Override // i.a.g.j
        public void j() {
            new i.a.g.t.b(this.f21791f).g(this.f21792g);
        }

        @Override // i.a.g.j
        public void k() {
            new i.a.g.t.e.d(this.f21791f).u(this.f21793h);
        }

        @Override // i.a.g.j
        public void l() {
            new i.a.g.t.e.a(this.f21791f).u(this.f21793h);
        }

        @Override // i.a.g.j
        public void m(c cVar, InetAddress inetAddress, int i2) {
            new i.a.g.t.c(this.f21791f, cVar, inetAddress, i2).g(this.f21792g);
        }

        @Override // i.a.g.j
        public void p() {
            this.f21793h.purge();
        }

        @Override // i.a.g.j
        public void x() {
            new i.a.g.t.e.e(this.f21791f).u(this.f21793h);
        }

        @Override // i.a.g.j
        public void y(q qVar) {
            new i.a.g.t.d.b(this.f21791f, qVar).j(this.f21792g);
        }

        /* JADX INFO: renamed from: i.a.g.j$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DNSTaskStarter.java */
        public static class C0305a extends Timer {
            private volatile boolean a;

            public C0305a(String str, boolean z) {
                super(str, z);
                this.a = false;
            }

            @Override // java.util.Timer
            public synchronized void cancel() {
                if (this.a) {
                    return;
                }
                this.a = true;
                super.cancel();
            }

            @Override // java.util.Timer
            public synchronized void schedule(TimerTask timerTask, long j2) {
                if (this.a) {
                    return;
                }
                super.schedule(timerTask, j2);
            }

            @Override // java.util.Timer
            public synchronized void scheduleAtFixedRate(TimerTask timerTask, long j2, long j3) {
                if (this.a) {
                    return;
                }
                super.scheduleAtFixedRate(timerTask, j2, j3);
            }

            @Override // java.util.Timer
            public synchronized void schedule(TimerTask timerTask, Date date) {
                if (this.a) {
                    return;
                }
                super.schedule(timerTask, date);
            }

            @Override // java.util.Timer
            public synchronized void scheduleAtFixedRate(TimerTask timerTask, Date date, long j2) {
                if (this.a) {
                    return;
                }
                super.scheduleAtFixedRate(timerTask, date, j2);
            }

            @Override // java.util.Timer
            public synchronized void schedule(TimerTask timerTask, long j2, long j3) {
                if (this.a) {
                    return;
                }
                super.schedule(timerTask, j2, j3);
            }

            @Override // java.util.Timer
            public synchronized void schedule(TimerTask timerTask, Date date, long j2) {
                if (this.a) {
                    return;
                }
                super.schedule(timerTask, date, j2);
            }
        }
    }
}
