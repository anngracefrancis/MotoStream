package io.sentry;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: SpanContext.java */
/* JADX INFO: loaded from: classes2.dex */
public class f5 implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final io.sentry.protocol.q f22410f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final h5 f22411g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final h5 f22412h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private transient q5 f22413i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected String f22414j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected String f22415k;
    protected j5 l;
    protected Map<String, String> m;
    protected String n;
    private Map<String, Object> o;

    /* JADX INFO: compiled from: SpanContext.java */
    public static final class a implements l2<f5> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f5 a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            String strJ = null;
            io.sentry.protocol.q qVarA = null;
            h5 h5VarB = null;
            h5 h5Var = null;
            ConcurrentHashMap concurrentHashMap = null;
            String strJ2 = null;
            j5 j5Var = null;
            String strJ3 = null;
            Map<String, String> mapB = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "span_id":
                        h5VarB = new h5.a().a(n2Var, w1Var);
                        break;
                    case "parent_span_id":
                        h5Var = (h5) n2Var.M0(w1Var, new h5.a());
                        break;
                    case "description":
                        strJ2 = n2Var.J();
                        break;
                    case "origin":
                        strJ3 = n2Var.J();
                        break;
                    case "status":
                        j5Var = (j5) n2Var.M0(w1Var, new j5.a());
                        break;
                    case "op":
                        strJ = n2Var.J();
                        break;
                    case "tags":
                        mapB = io.sentry.util.i.b((Map) n2Var.K0());
                        break;
                    case "trace_id":
                        qVarA = new io.sentry.protocol.q.a().a(n2Var, w1Var);
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, strB);
                        break;
                }
            }
            if (qVarA == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"trace_id\"");
                w1Var.b(s4.ERROR, "Missing required field \"trace_id\"", illegalStateException);
                throw illegalStateException;
            }
            if (h5VarB == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"span_id\"");
                w1Var.b(s4.ERROR, "Missing required field \"span_id\"", illegalStateException2);
                throw illegalStateException2;
            }
            f5 f5Var = new f5(qVarA, h5VarB, strJ == null ? HttpUrl.FRAGMENT_ENCODE_SET : strJ, h5Var, null);
            f5Var.l(strJ2);
            f5Var.o(j5Var);
            f5Var.m(strJ3);
            if (mapB != null) {
                f5Var.m = mapB;
            }
            f5Var.p(concurrentHashMap);
            n2Var.j();
            return f5Var;
        }
    }

    public f5(String str) {
        this(new io.sentry.protocol.q(), new h5(), str, null, null);
    }

    public String a() {
        return this.f22415k;
    }

    public String b() {
        return this.f22414j;
    }

    public String c() {
        return this.n;
    }

    public h5 d() {
        return this.f22412h;
    }

    public Boolean e() {
        q5 q5Var = this.f22413i;
        if (q5Var == null) {
            return null;
        }
        return q5Var.a();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f5)) {
            return false;
        }
        f5 f5Var = (f5) obj;
        return this.f22410f.equals(f5Var.f22410f) && this.f22411g.equals(f5Var.f22411g) && io.sentry.util.q.a(this.f22412h, f5Var.f22412h) && this.f22414j.equals(f5Var.f22414j) && io.sentry.util.q.a(this.f22415k, f5Var.f22415k) && this.l == f5Var.l;
    }

    public Boolean f() {
        q5 q5Var = this.f22413i;
        if (q5Var == null) {
            return null;
        }
        return q5Var.c();
    }

    public q5 g() {
        return this.f22413i;
    }

    public h5 h() {
        return this.f22411g;
    }

    public int hashCode() {
        return io.sentry.util.q.b(this.f22410f, this.f22411g, this.f22412h, this.f22414j, this.f22415k, this.l);
    }

    public j5 i() {
        return this.l;
    }

    public Map<String, String> j() {
        return this.m;
    }

    public io.sentry.protocol.q k() {
        return this.f22410f;
    }

    public void l(String str) {
        this.f22415k = str;
    }

    public void m(String str) {
        this.n = str;
    }

    @ApiStatus.Internal
    public void n(q5 q5Var) {
        this.f22413i = q5Var;
    }

    public void o(j5 j5Var) {
        this.l = j5Var;
    }

    public void p(Map<String, Object> map) {
        this.o = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        h3Var.k("trace_id");
        this.f22410f.serialize(h3Var, w1Var);
        h3Var.k("span_id");
        this.f22411g.serialize(h3Var, w1Var);
        if (this.f22412h != null) {
            h3Var.k("parent_span_id");
            this.f22412h.serialize(h3Var, w1Var);
        }
        h3Var.k("op").b(this.f22414j);
        if (this.f22415k != null) {
            h3Var.k("description").b(this.f22415k);
        }
        if (this.l != null) {
            h3Var.k("status").g(w1Var, this.l);
        }
        if (this.n != null) {
            h3Var.k("origin").g(w1Var, this.n);
        }
        if (!this.m.isEmpty()) {
            h3Var.k("tags").g(w1Var, this.m);
        }
        Map<String, Object> map = this.o;
        if (map != null) {
            for (String str : map.keySet()) {
                h3Var.k(str).g(w1Var, this.o.get(str));
            }
        }
        h3Var.d();
    }

    public f5(io.sentry.protocol.q qVar, h5 h5Var, String str, h5 h5Var2, q5 q5Var) {
        this(qVar, h5Var, h5Var2, str, null, q5Var, null, "manual");
    }

    @ApiStatus.Internal
    public f5(io.sentry.protocol.q qVar, h5 h5Var, h5 h5Var2, String str, String str2, q5 q5Var, j5 j5Var, String str3) {
        this.m = new ConcurrentHashMap();
        this.n = "manual";
        this.f22410f = (io.sentry.protocol.q) io.sentry.util.q.c(qVar, "traceId is required");
        this.f22411g = (h5) io.sentry.util.q.c(h5Var, "spanId is required");
        this.f22414j = (String) io.sentry.util.q.c(str, "operation is required");
        this.f22412h = h5Var2;
        this.f22413i = q5Var;
        this.f22415k = str2;
        this.l = j5Var;
        this.n = str3;
    }

    public f5(f5 f5Var) {
        this.m = new ConcurrentHashMap();
        this.n = "manual";
        this.f22410f = f5Var.f22410f;
        this.f22411g = f5Var.f22411g;
        this.f22412h = f5Var.f22412h;
        this.f22413i = f5Var.f22413i;
        this.f22414j = f5Var.f22414j;
        this.f22415k = f5Var.f22415k;
        this.l = f5Var.l;
        Map<String, String> mapB = io.sentry.util.i.b(f5Var.m);
        if (mapB != null) {
            this.m = mapB;
        }
    }
}
