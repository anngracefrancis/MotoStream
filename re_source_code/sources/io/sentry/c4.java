package io.sentry;

import io.sentry.exception.ExceptionMechanismException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: SentryBaseEvent.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c4 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private io.sentry.protocol.q f22319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final io.sentry.protocol.c f22320g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private io.sentry.protocol.o f22321h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private io.sentry.protocol.l f22322i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<String, String> f22323j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f22324k;
    private String l;
    private String m;
    private io.sentry.protocol.a0 n;
    protected transient Throwable o;
    private String p;
    private String q;
    private List<v0> r;
    private io.sentry.protocol.d s;
    private Map<String, Object> t;

    /* JADX INFO: compiled from: SentryBaseEvent.java */
    public static final class a {
        public boolean a(c4 c4Var, String str, n2 n2Var, w1 w1Var) throws Exception {
            str.hashCode();
            switch (str) {
                case "debug_meta":
                    c4Var.s = (io.sentry.protocol.d) n2Var.M0(w1Var, new io.sentry.protocol.d.a());
                    return true;
                case "server_name":
                    c4Var.p = n2Var.N0();
                    return true;
                case "contexts":
                    c4Var.f22320g.putAll(new io.sentry.protocol.c.a().a(n2Var, w1Var));
                    return true;
                case "environment":
                    c4Var.l = n2Var.N0();
                    return true;
                case "breadcrumbs":
                    c4Var.r = n2Var.F0(w1Var, new v0.a());
                    return true;
                case "sdk":
                    c4Var.f22321h = (io.sentry.protocol.o) n2Var.M0(w1Var, new io.sentry.protocol.o.a());
                    return true;
                case "dist":
                    c4Var.q = n2Var.N0();
                    return true;
                case "tags":
                    c4Var.f22323j = io.sentry.util.i.b((Map) n2Var.K0());
                    return true;
                case "user":
                    c4Var.n = (io.sentry.protocol.a0) n2Var.M0(w1Var, new io.sentry.protocol.a0.a());
                    return true;
                case "extra":
                    c4Var.t = io.sentry.util.i.b((Map) n2Var.K0());
                    return true;
                case "event_id":
                    c4Var.f22319f = (io.sentry.protocol.q) n2Var.M0(w1Var, new io.sentry.protocol.q.a());
                    return true;
                case "release":
                    c4Var.f22324k = n2Var.N0();
                    return true;
                case "request":
                    c4Var.f22322i = (io.sentry.protocol.l) n2Var.M0(w1Var, new io.sentry.protocol.l.a());
                    return true;
                case "platform":
                    c4Var.m = n2Var.N0();
                    return true;
                default:
                    return false;
            }
        }
    }

    /* JADX INFO: compiled from: SentryBaseEvent.java */
    public static final class b {
        public void a(c4 c4Var, h3 h3Var, w1 w1Var) throws IOException {
            if (c4Var.f22319f != null) {
                h3Var.k("event_id").g(w1Var, c4Var.f22319f);
            }
            h3Var.k("contexts").g(w1Var, c4Var.f22320g);
            if (c4Var.f22321h != null) {
                h3Var.k("sdk").g(w1Var, c4Var.f22321h);
            }
            if (c4Var.f22322i != null) {
                h3Var.k("request").g(w1Var, c4Var.f22322i);
            }
            if (c4Var.f22323j != null && !c4Var.f22323j.isEmpty()) {
                h3Var.k("tags").g(w1Var, c4Var.f22323j);
            }
            if (c4Var.f22324k != null) {
                h3Var.k("release").b(c4Var.f22324k);
            }
            if (c4Var.l != null) {
                h3Var.k("environment").b(c4Var.l);
            }
            if (c4Var.m != null) {
                h3Var.k("platform").b(c4Var.m);
            }
            if (c4Var.n != null) {
                h3Var.k("user").g(w1Var, c4Var.n);
            }
            if (c4Var.p != null) {
                h3Var.k("server_name").b(c4Var.p);
            }
            if (c4Var.q != null) {
                h3Var.k("dist").b(c4Var.q);
            }
            if (c4Var.r != null && !c4Var.r.isEmpty()) {
                h3Var.k("breadcrumbs").g(w1Var, c4Var.r);
            }
            if (c4Var.s != null) {
                h3Var.k("debug_meta").g(w1Var, c4Var.s);
            }
            if (c4Var.t == null || c4Var.t.isEmpty()) {
                return;
            }
            h3Var.k("extra").g(w1Var, c4Var.t);
        }
    }

    protected c4(io.sentry.protocol.q qVar) {
        this.f22320g = new io.sentry.protocol.c();
        this.f22319f = qVar;
    }

    public List<v0> B() {
        return this.r;
    }

    public io.sentry.protocol.c C() {
        return this.f22320g;
    }

    public io.sentry.protocol.d D() {
        return this.s;
    }

    public String E() {
        return this.q;
    }

    public String F() {
        return this.l;
    }

    public io.sentry.protocol.q G() {
        return this.f22319f;
    }

    public Map<String, Object> H() {
        return this.t;
    }

    public String I() {
        return this.m;
    }

    public String J() {
        return this.f22324k;
    }

    public io.sentry.protocol.l K() {
        return this.f22322i;
    }

    public io.sentry.protocol.o L() {
        return this.f22321h;
    }

    public String M() {
        return this.p;
    }

    @ApiStatus.Internal
    public Map<String, String> N() {
        return this.f22323j;
    }

    public Throwable O() {
        Throwable th = this.o;
        return th instanceof ExceptionMechanismException ? ((ExceptionMechanismException) th).c() : th;
    }

    @ApiStatus.Internal
    public Throwable P() {
        return this.o;
    }

    public io.sentry.protocol.a0 Q() {
        return this.n;
    }

    public void R(List<v0> list) {
        this.r = io.sentry.util.i.a(list);
    }

    public void S(io.sentry.protocol.d dVar) {
        this.s = dVar;
    }

    public void T(String str) {
        this.q = str;
    }

    public void U(String str) {
        this.l = str;
    }

    public void V(String str, Object obj) {
        if (this.t == null) {
            this.t = new HashMap();
        }
        this.t.put(str, obj);
    }

    public void W(Map<String, Object> map) {
        this.t = io.sentry.util.i.c(map);
    }

    public void X(String str) {
        this.m = str;
    }

    public void Y(String str) {
        this.f22324k = str;
    }

    public void Z(io.sentry.protocol.l lVar) {
        this.f22322i = lVar;
    }

    public void a0(io.sentry.protocol.o oVar) {
        this.f22321h = oVar;
    }

    public void b0(String str) {
        this.p = str;
    }

    public void c0(String str, String str2) {
        if (this.f22323j == null) {
            this.f22323j = new HashMap();
        }
        this.f22323j.put(str, str2);
    }

    public void d0(Map<String, String> map) {
        this.f22323j = io.sentry.util.i.c(map);
    }

    public void e0(io.sentry.protocol.a0 a0Var) {
        this.n = a0Var;
    }

    protected c4() {
        this(new io.sentry.protocol.q());
    }
}
