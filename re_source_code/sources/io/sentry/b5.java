package io.sentry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: SentryTracer.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class b5 implements e2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e5 f22296b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final v1 f22298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f22299e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile TimerTask f22301g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile Timer f22302h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final u0 f22305k;
    private io.sentry.protocol.z l;
    private final Map<String, io.sentry.protocol.h> m;
    private final h2 n;
    private final u5 p;
    private final t5 q;
    private final io.sentry.protocol.q a = new io.sentry.protocol.q();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<e5> f22297c = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f22300f = b.a;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f22303i = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AtomicBoolean f22304j = new AtomicBoolean(false);
    private final io.sentry.protocol.c o = new io.sentry.protocol.c();

    /* JADX INFO: compiled from: SentryTracer.java */
    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            b5.this.w();
        }
    }

    /* JADX INFO: compiled from: SentryTracer.java */
    private static final class b {
        static final b a = d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f22307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final j5 f22308c;

        private b(boolean z, j5 j5Var) {
            this.f22307b = z;
            this.f22308c = j5Var;
        }

        static b c(j5 j5Var) {
            return new b(true, j5Var);
        }

        private static b d() {
            return new b(false, null);
        }
    }

    b5(r5 r5Var, v1 v1Var, t5 t5Var, u5 u5Var) {
        this.f22302h = null;
        io.sentry.util.q.c(r5Var, "context is required");
        io.sentry.util.q.c(v1Var, "hub is required");
        this.m = new ConcurrentHashMap();
        this.f22296b = new e5(r5Var, this, v1Var, t5Var.g(), t5Var);
        this.f22299e = r5Var.t();
        this.n = r5Var.s();
        this.f22298d = v1Var;
        this.p = u5Var;
        this.l = r5Var.v();
        this.q = t5Var;
        if (r5Var.r() != null) {
            this.f22305k = r5Var.r();
        } else {
            this.f22305k = new u0(v1Var.q().getLogger());
        }
        if (u5Var != null && Boolean.TRUE.equals(E())) {
            u5Var.b(this);
        }
        if (t5Var.f() != null) {
            this.f22302h = new Timer(true);
            l();
        }
    }

    private boolean D() {
        ArrayList arrayList = new ArrayList(this.f22297c);
        if (arrayList.isEmpty()) {
            return true;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((e5) it.next()).b()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H(e5 e5Var) {
        b bVar = this.f22300f;
        if (this.q.f() == null) {
            if (bVar.f22307b) {
                d(bVar.f22308c);
            }
        } else if (!this.q.j() || D()) {
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J(s3 s3Var, e2 e2Var) {
        if (e2Var == this) {
            s3Var.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L(final s3 s3Var) {
        s3Var.D(new s3.c() { // from class: io.sentry.p0
            @Override // io.sentry.s3.c
            public final void a(e2 e2Var) {
                this.a.J(s3Var, e2Var);
            }
        });
    }

    private void P() {
        synchronized (this) {
            if (this.f22305k.q()) {
                final AtomicReference atomicReference = new AtomicReference();
                this.f22298d.o(new t3() { // from class: io.sentry.n0
                    @Override // io.sentry.t3
                    public final void a(s3 s3Var) {
                        atomicReference.set(s3Var.w());
                    }
                });
                this.f22305k.E(this, (io.sentry.protocol.a0) atomicReference.get(), this.f22298d.q(), B());
                this.f22305k.a();
            }
        }
    }

    private void s() {
        synchronized (this.f22303i) {
            if (this.f22301g != null) {
                this.f22301g.cancel();
                this.f22304j.set(false);
                this.f22301g = null;
            }
        }
    }

    private d2 t(h5 h5Var, String str, String str2, f4 f4Var, h2 h2Var, i5 i5Var) {
        if (this.f22296b.b()) {
            return c3.r();
        }
        if (!this.n.equals(h2Var)) {
            return c3.r();
        }
        io.sentry.util.q.c(h5Var, "parentSpanId is required");
        io.sentry.util.q.c(str, "operation is required");
        s();
        e5 e5Var = new e5(this.f22296b.z(), h5Var, this, str, this.f22298d, f4Var, i5Var, new g5() { // from class: io.sentry.o0
            @Override // io.sentry.g5
            public final void a(e5 e5Var2) {
                this.a.H(e5Var2);
            }
        });
        e5Var.j(str2);
        e5Var.C("thread.id", String.valueOf(Thread.currentThread().getId()));
        e5Var.C("thread.name", this.f22298d.q().getMainThreadChecker().d() ? "main" : Thread.currentThread().getName());
        this.f22297c.add(e5Var);
        return e5Var;
    }

    private d2 u(String str, String str2, f4 f4Var, h2 h2Var, i5 i5Var) {
        if (this.f22296b.b()) {
            return c3.r();
        }
        if (!this.n.equals(h2Var)) {
            return c3.r();
        }
        if (this.f22297c.size() < this.f22298d.q().getMaxSpans()) {
            return this.f22296b.E(str, str2, f4Var, h2Var, i5Var);
        }
        this.f22298d.q().getLogger().c(s4.WARNING, "Span operation: %s, description: %s dropped due to limit reached. Returning NoOpSpan.", str, str2);
        return c3.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        j5 status = getStatus();
        if (status == null) {
            status = j5.OK;
        }
        d(status);
        this.f22304j.set(false);
    }

    e5 A() {
        return this.f22296b;
    }

    public q5 B() {
        return this.f22296b.w();
    }

    public List<e5> C() {
        return this.f22297c;
    }

    public Boolean E() {
        return this.f22296b.A();
    }

    public Boolean F() {
        return this.f22296b.B();
    }

    d2 N(h5 h5Var, String str, String str2, f4 f4Var, h2 h2Var, i5 i5Var) {
        return t(h5Var, str, str2, f4Var, h2Var, i5Var);
    }

    public d2 O(String str, String str2, f4 f4Var, h2 h2Var, i5 i5Var) {
        return u(str, str2, f4Var, h2Var, i5Var);
    }

    @Override // io.sentry.d2
    public o5 a() {
        if (!this.f22298d.q().isTraceSampling()) {
            return null;
        }
        P();
        return this.f22305k.F();
    }

    @Override // io.sentry.d2
    public boolean b() {
        return this.f22296b.b();
    }

    @Override // io.sentry.d2
    public boolean c(f4 f4Var) {
        return this.f22296b.c(f4Var);
    }

    @Override // io.sentry.d2
    public void d(j5 j5Var) {
        o(j5Var, null);
    }

    @Override // io.sentry.e2
    public void e(j5 j5Var, boolean z) {
        if (b()) {
            return;
        }
        f4 f4VarA = this.f22298d.q().getDateProvider().a();
        List<e5> list = this.f22297c;
        ListIterator<e5> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            e5 e5VarPrevious = listIterator.previous();
            e5VarPrevious.D(null);
            e5VarPrevious.o(j5Var, f4VarA);
        }
        v(j5Var, f4VarA, z);
    }

    @Override // io.sentry.d2
    public d2 f(String str, String str2, f4 f4Var, h2 h2Var) {
        return O(str, str2, f4Var, h2Var, new i5());
    }

    @Override // io.sentry.d2
    public void g() {
        d(getStatus());
    }

    @Override // io.sentry.d2
    public String getDescription() {
        return this.f22296b.getDescription();
    }

    @Override // io.sentry.e2
    public String getName() {
        return this.f22299e;
    }

    @Override // io.sentry.d2
    public j5 getStatus() {
        return this.f22296b.getStatus();
    }

    @Override // io.sentry.d2
    public void h(String str, Number number, v2 v2Var) {
        if (this.f22296b.b()) {
            return;
        }
        this.m.put(str, new io.sentry.protocol.h(number, v2Var.apiName()));
    }

    @Override // io.sentry.e2
    public e5 i() {
        ArrayList arrayList = new ArrayList(this.f22297c);
        if (arrayList.isEmpty()) {
            return null;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (!((e5) arrayList.get(size)).b()) {
                return (e5) arrayList.get(size);
            }
        }
        return null;
    }

    @Override // io.sentry.d2
    public void j(String str) {
        if (this.f22296b.b()) {
            return;
        }
        this.f22296b.j(str);
    }

    @Override // io.sentry.e2
    public io.sentry.protocol.q k() {
        return this.a;
    }

    @Override // io.sentry.e2
    public void l() {
        synchronized (this.f22303i) {
            s();
            if (this.f22302h != null) {
                this.f22304j.set(true);
                this.f22301g = new a();
                try {
                    this.f22302h.schedule(this.f22301g, this.q.f().longValue());
                } catch (Throwable th) {
                    this.f22298d.q().getLogger().b(s4.WARNING, "Failed to schedule finish timer", th);
                    w();
                }
            }
        }
    }

    @Override // io.sentry.d2
    public f5 m() {
        return this.f22296b.m();
    }

    @Override // io.sentry.d2
    public f4 n() {
        return this.f22296b.n();
    }

    @Override // io.sentry.d2
    @ApiStatus.Internal
    public void o(j5 j5Var, f4 f4Var) {
        v(j5Var, f4Var, true);
    }

    @Override // io.sentry.e2
    public io.sentry.protocol.z p() {
        return this.l;
    }

    @Override // io.sentry.d2
    public f4 q() {
        return this.f22296b.q();
    }

    public void v(j5 j5Var, f4 f4Var, boolean z) {
        f4 f4VarN = this.f22296b.n();
        if (f4Var == null) {
            f4Var = f4VarN;
        }
        if (f4Var == null) {
            f4Var = this.f22298d.q().getDateProvider().a();
        }
        for (e5 e5Var : this.f22297c) {
            if (e5Var.u().a()) {
                e5Var.o(j5Var != null ? j5Var : m().l, f4Var);
            }
        }
        this.f22300f = b.c(j5Var);
        if (this.f22296b.b()) {
            return;
        }
        if (!this.q.j() || D()) {
            u5 u5Var = this.p;
            List<k3> listA = u5Var != null ? u5Var.e(this) : null;
            Boolean bool = Boolean.TRUE;
            m3 m3VarA = (bool.equals(F()) && bool.equals(E())) ? this.f22298d.q().getTransactionProfiler().a(this, listA) : null;
            if (listA != null) {
                listA.clear();
            }
            for (e5 e5Var2 : this.f22297c) {
                if (!e5Var2.b()) {
                    e5Var2.D(null);
                    e5Var2.o(j5.DEADLINE_EXCEEDED, f4Var);
                }
            }
            this.f22296b.o(this.f22300f.f22308c, f4Var);
            this.f22298d.o(new t3() { // from class: io.sentry.m0
                @Override // io.sentry.t3
                public final void a(s3 s3Var) {
                    this.a.L(s3Var);
                }
            });
            io.sentry.protocol.x xVar = new io.sentry.protocol.x(this);
            s5 s5VarH = this.q.h();
            if (s5VarH != null) {
                s5VarH.a(this);
            }
            if (this.f22302h != null) {
                synchronized (this.f22303i) {
                    if (this.f22302h != null) {
                        this.f22302h.cancel();
                        this.f22302h = null;
                    }
                }
            }
            if (z && this.f22297c.isEmpty() && this.q.f() != null) {
                this.f22298d.q().getLogger().c(s4.DEBUG, "Dropping idle transaction %s because it has no child spans", this.f22299e);
            } else {
                xVar.m0().putAll(this.m);
                this.f22298d.r(xVar, a(), null, m3VarA);
            }
        }
    }

    public List<e5> x() {
        return this.f22297c;
    }

    @ApiStatus.Internal
    public io.sentry.protocol.c y() {
        return this.o;
    }

    public Map<String, Object> z() {
        return this.f22296b.r();
    }
}
