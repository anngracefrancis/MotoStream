package io.sentry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: Scope.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s3 {
    private s4 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e2 f22698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f22699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private io.sentry.protocol.a0 f22700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f22701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private io.sentry.protocol.l f22702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<String> f22703g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Queue<v0> f22704h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<String, String> f22705i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<String, Object> f22706j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<k1> f22707k;
    private final x4 l;
    private volatile d5 m;
    private final Object n;
    private final Object o;
    private final Object p;
    private io.sentry.protocol.c q;
    private List<s0> r;
    private o3 s;

    /* JADX INFO: compiled from: Scope.java */
    @ApiStatus.Internal
    public interface a {
        void a(o3 o3Var);
    }

    /* JADX INFO: compiled from: Scope.java */
    interface b {
        void a(d5 d5Var);
    }

    /* JADX INFO: compiled from: Scope.java */
    @ApiStatus.Internal
    public interface c {
        void a(e2 e2Var);
    }

    /* JADX INFO: compiled from: Scope.java */
    static final class d {
        private final d5 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d5 f22708b;

        public d(d5 d5Var, d5 d5Var2) {
            this.f22708b = d5Var;
            this.a = d5Var2;
        }

        public d5 a() {
            return this.f22708b;
        }

        public d5 b() {
            return this.a;
        }
    }

    public s3(x4 x4Var) {
        this.f22703g = new ArrayList();
        this.f22705i = new ConcurrentHashMap();
        this.f22706j = new ConcurrentHashMap();
        this.f22707k = new CopyOnWriteArrayList();
        this.n = new Object();
        this.o = new Object();
        this.p = new Object();
        this.q = new io.sentry.protocol.c();
        this.r = new CopyOnWriteArrayList();
        x4 x4Var2 = (x4) io.sentry.util.q.c(x4Var, "SentryOptions is required.");
        this.l = x4Var2;
        this.f22704h = f(x4Var2.getMaxBreadcrumbs());
        this.s = new o3();
    }

    private Queue<v0> f(int i2) {
        return m5.g(new w0(i2));
    }

    private v0 h(x4.a aVar, v0 v0Var, n1 n1Var) {
        try {
            return aVar.a(v0Var, n1Var);
        } catch (Throwable th) {
            this.l.getLogger().b(s4.ERROR, "The BeforeBreadcrumbCallback callback threw an exception. Exception details will be added to the breadcrumb.", th);
            if (th.getMessage() == null) {
                return v0Var;
            }
            v0Var.m("sentry:message", th.getMessage());
            return v0Var;
        }
    }

    d A() {
        d dVar;
        synchronized (this.n) {
            if (this.m != null) {
                this.m.c();
            }
            d5 d5Var = this.m;
            dVar = null;
            if (this.l.getRelease() != null) {
                this.m = new d5(this.l.getDistinctId(), this.f22700d, this.l.getEnvironment(), this.l.getRelease());
                dVar = new d(this.m.clone(), d5Var != null ? d5Var.clone() : null);
            } else {
                this.l.getLogger().c(s4.WARNING, "Release is not set on SentryOptions. Session could not be started", new Object[0]);
            }
        }
        return dVar;
    }

    @ApiStatus.Internal
    public o3 B(a aVar) {
        o3 o3Var;
        synchronized (this.p) {
            aVar.a(this.s);
            o3Var = new o3(this.s);
        }
        return o3Var;
    }

    d5 C(b bVar) {
        d5 d5VarClone;
        synchronized (this.n) {
            bVar.a(this.m);
            d5VarClone = this.m != null ? this.m.clone() : null;
        }
        return d5VarClone;
    }

    @ApiStatus.Internal
    public void D(c cVar) {
        synchronized (this.o) {
            cVar.a(this.f22698b);
        }
    }

    public void a(v0 v0Var, n1 n1Var) {
        if (v0Var == null) {
            return;
        }
        if (n1Var == null) {
            n1Var = new n1();
        }
        x4.a beforeBreadcrumb = this.l.getBeforeBreadcrumb();
        if (beforeBreadcrumb != null) {
            v0Var = h(beforeBreadcrumb, v0Var, n1Var);
        }
        if (v0Var == null) {
            this.l.getLogger().c(s4.INFO, "Breadcrumb was dropped by beforeBreadcrumb", new Object[0]);
            return;
        }
        this.f22704h.add(v0Var);
        for (z1 z1Var : this.l.getScopeObservers()) {
            z1Var.i(v0Var);
            z1Var.a(this.f22704h);
        }
    }

    public void b() {
        this.a = null;
        this.f22700d = null;
        this.f22702f = null;
        this.f22701e = null;
        this.f22703g.clear();
        d();
        this.f22705i.clear();
        this.f22706j.clear();
        this.f22707k.clear();
        e();
        c();
    }

    public void c() {
        this.r.clear();
    }

    public void d() {
        this.f22704h.clear();
        Iterator<z1> it = this.l.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().a(this.f22704h);
        }
    }

    public void e() {
        synchronized (this.o) {
            this.f22698b = null;
        }
        this.f22699c = null;
        for (z1 z1Var : this.l.getScopeObservers()) {
            z1Var.d(null);
            z1Var.c(null);
        }
    }

    d5 g() {
        d5 d5Var;
        synchronized (this.n) {
            d5Var = null;
            if (this.m != null) {
                this.m.c();
                d5 d5VarClone = this.m.clone();
                this.m = null;
                d5Var = d5VarClone;
            }
        }
        return d5Var;
    }

    List<s0> i() {
        return new CopyOnWriteArrayList(this.r);
    }

    @ApiStatus.Internal
    public Queue<v0> j() {
        return this.f22704h;
    }

    public io.sentry.protocol.c k() {
        return this.q;
    }

    List<k1> l() {
        return this.f22707k;
    }

    @ApiStatus.Internal
    public Map<String, Object> m() {
        return this.f22706j;
    }

    @ApiStatus.Internal
    public List<String> n() {
        return this.f22703g;
    }

    public s4 o() {
        return this.a;
    }

    @ApiStatus.Internal
    public o3 p() {
        return this.s;
    }

    public io.sentry.protocol.l q() {
        return this.f22702f;
    }

    @ApiStatus.Internal
    public d5 r() {
        return this.m;
    }

    public d2 s() {
        e5 e5VarI;
        e2 e2Var = this.f22698b;
        return (e2Var == null || (e5VarI = e2Var.i()) == null) ? e2Var : e5VarI;
    }

    @ApiStatus.Internal
    public Map<String, String> t() {
        return io.sentry.util.i.b(this.f22705i);
    }

    public e2 u() {
        return this.f22698b;
    }

    public String v() {
        e2 e2Var = this.f22698b;
        return e2Var != null ? e2Var.getName() : this.f22699c;
    }

    public io.sentry.protocol.a0 w() {
        return this.f22700d;
    }

    @ApiStatus.Internal
    public void x(o3 o3Var) {
        this.s = o3Var;
    }

    @ApiStatus.Internal
    public void y(String str) {
        this.f22701e = str;
        io.sentry.protocol.c cVarK = k();
        io.sentry.protocol.a aVarA = cVarK.a();
        if (aVarA == null) {
            aVarA = new io.sentry.protocol.a();
            cVarK.f(aVarA);
        }
        if (str == null) {
            aVarA.s(null);
        } else {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(str);
            aVarA.s(arrayList);
        }
        Iterator<z1> it = this.l.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().b(cVarK);
        }
    }

    public void z(e2 e2Var) {
        synchronized (this.o) {
            this.f22698b = e2Var;
            for (z1 z1Var : this.l.getScopeObservers()) {
                if (e2Var != null) {
                    z1Var.d(e2Var.getName());
                    z1Var.c(e2Var.m());
                } else {
                    z1Var.d(null);
                    z1Var.c(null);
                }
            }
        }
    }

    @ApiStatus.Internal
    public s3(s3 s3Var) {
        this.f22703g = new ArrayList();
        this.f22705i = new ConcurrentHashMap();
        this.f22706j = new ConcurrentHashMap();
        this.f22707k = new CopyOnWriteArrayList();
        this.n = new Object();
        this.o = new Object();
        this.p = new Object();
        this.q = new io.sentry.protocol.c();
        this.r = new CopyOnWriteArrayList();
        this.f22698b = s3Var.f22698b;
        this.f22699c = s3Var.f22699c;
        this.m = s3Var.m;
        this.l = s3Var.l;
        this.a = s3Var.a;
        io.sentry.protocol.a0 a0Var = s3Var.f22700d;
        this.f22700d = a0Var != null ? new io.sentry.protocol.a0(a0Var) : null;
        this.f22701e = s3Var.f22701e;
        io.sentry.protocol.l lVar = s3Var.f22702f;
        this.f22702f = lVar != null ? new io.sentry.protocol.l(lVar) : null;
        this.f22703g = new ArrayList(s3Var.f22703g);
        this.f22707k = new CopyOnWriteArrayList(s3Var.f22707k);
        v0[] v0VarArr = (v0[]) s3Var.f22704h.toArray(new v0[0]);
        Queue<v0> queueF = f(s3Var.l.getMaxBreadcrumbs());
        for (v0 v0Var : v0VarArr) {
            queueF.add(new v0(v0Var));
        }
        this.f22704h = queueF;
        Map<String, String> map = s3Var.f22705i;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                concurrentHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        this.f22705i = concurrentHashMap;
        Map<String, Object> map2 = s3Var.f22706j;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        for (Map.Entry<String, Object> entry2 : map2.entrySet()) {
            if (entry2 != null) {
                concurrentHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        this.f22706j = concurrentHashMap2;
        this.q = new io.sentry.protocol.c(s3Var.q);
        this.r = new CopyOnWriteArrayList(s3Var.r);
        this.s = new o3(s3Var.s);
    }
}
