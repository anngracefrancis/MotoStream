package io.sentry.protocol;

import io.sentry.a1;
import io.sentry.e5;
import io.sentry.h3;
import io.sentry.h5;
import io.sentry.j5;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.s4;
import io.sentry.w1;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: SentrySpan.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class t implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Double f22654f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Double f22655g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final q f22656h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final h5 f22657i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final h5 f22658j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f22659k;
    private final String l;
    private final j5 m;
    private final String n;
    private final Map<String, String> o;
    private final Map<String, Object> p;
    private Map<String, Object> q;

    /* JADX INFO: compiled from: SentrySpan.java */
    public static final class a implements l2<t> {
        private Exception c(String str, w1 w1Var) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            w1Var.b(s4.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public t a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            Map map = null;
            Double dValueOf = null;
            Double dValueOf2 = null;
            q qVarA = null;
            h5 h5VarA = null;
            h5 h5Var = null;
            String strN0 = null;
            String strN1 = null;
            j5 j5Var = null;
            String strN2 = null;
            ConcurrentHashMap concurrentHashMap = null;
            Map map2 = null;
            while (true) {
                Map map3 = map2;
                String str = strN2;
                j5 j5Var2 = j5Var;
                String str2 = strN1;
                if (n2Var.N() != io.sentry.vendor.gson.stream.b.NAME) {
                    if (dValueOf == null) {
                        throw c("start_timestamp", w1Var);
                    }
                    if (qVarA == null) {
                        throw c("trace_id", w1Var);
                    }
                    if (h5VarA == null) {
                        throw c("span_id", w1Var);
                    }
                    if (strN0 == null) {
                        throw c("op", w1Var);
                    }
                    t tVar = new t(dValueOf, dValueOf2, qVarA, h5VarA, h5Var, strN0, str2, j5Var2, str, map == null ? new HashMap() : map, map3);
                    tVar.c(concurrentHashMap);
                    n2Var.j();
                    return tVar;
                }
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "span_id":
                        h5VarA = new h5.a().a(n2Var, w1Var);
                        map2 = map3;
                        strN2 = str;
                        j5Var = j5Var2;
                        strN1 = str2;
                        break;
                    case "parent_span_id":
                        h5Var = (h5) n2Var.M0(w1Var, new h5.a());
                        map2 = map3;
                        strN2 = str;
                        j5Var = j5Var2;
                        strN1 = str2;
                        break;
                    case "description":
                        strN1 = n2Var.N0();
                        map2 = map3;
                        strN2 = str;
                        j5Var = j5Var2;
                        break;
                    case "start_timestamp":
                        try {
                            dValueOf = n2Var.t0();
                            break;
                        } catch (NumberFormatException unused) {
                            Date dateQ0 = n2Var.q0(w1Var);
                            dValueOf = dateQ0 != null ? Double.valueOf(a1.b(dateQ0)) : null;
                        }
                        map2 = map3;
                        strN2 = str;
                        j5Var = j5Var2;
                        strN1 = str2;
                        break;
                    case "origin":
                        strN2 = n2Var.N0();
                        map2 = map3;
                        j5Var = j5Var2;
                        strN1 = str2;
                        break;
                    case "status":
                        j5Var = (j5) n2Var.M0(w1Var, new j5.a());
                        map2 = map3;
                        strN2 = str;
                        strN1 = str2;
                        break;
                    case "op":
                        strN0 = n2Var.N0();
                        map2 = map3;
                        strN2 = str;
                        j5Var = j5Var2;
                        strN1 = str2;
                        break;
                    case "data":
                        map2 = (Map) n2Var.K0();
                        strN2 = str;
                        j5Var = j5Var2;
                        strN1 = str2;
                        break;
                    case "tags":
                        map = (Map) n2Var.K0();
                        map2 = map3;
                        strN2 = str;
                        j5Var = j5Var2;
                        strN1 = str2;
                        break;
                    case "timestamp":
                        try {
                            dValueOf2 = n2Var.t0();
                            break;
                        } catch (NumberFormatException unused2) {
                            Date dateQ1 = n2Var.q0(w1Var);
                            dValueOf2 = dateQ1 != null ? Double.valueOf(a1.b(dateQ1)) : null;
                        }
                        map2 = map3;
                        strN2 = str;
                        j5Var = j5Var2;
                        strN1 = str2;
                        break;
                    case "trace_id":
                        qVarA = new q.a().a(n2Var, w1Var);
                        map2 = map3;
                        strN2 = str;
                        j5Var = j5Var2;
                        strN1 = str2;
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, strB);
                        map2 = map3;
                        strN2 = str;
                        j5Var = j5Var2;
                        strN1 = str2;
                        break;
                }
            }
        }
    }

    public t(e5 e5Var) {
        this(e5Var, e5Var.r());
    }

    private BigDecimal a(Double d2) {
        return BigDecimal.valueOf(d2.doubleValue()).setScale(6, RoundingMode.DOWN);
    }

    public String b() {
        return this.f22659k;
    }

    public void c(Map<String, Object> map) {
        this.q = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        h3Var.k("start_timestamp").g(w1Var, a(this.f22654f));
        if (this.f22655g != null) {
            h3Var.k("timestamp").g(w1Var, a(this.f22655g));
        }
        h3Var.k("trace_id").g(w1Var, this.f22656h);
        h3Var.k("span_id").g(w1Var, this.f22657i);
        if (this.f22658j != null) {
            h3Var.k("parent_span_id").g(w1Var, this.f22658j);
        }
        h3Var.k("op").b(this.f22659k);
        if (this.l != null) {
            h3Var.k("description").b(this.l);
        }
        if (this.m != null) {
            h3Var.k("status").g(w1Var, this.m);
        }
        if (this.n != null) {
            h3Var.k("origin").g(w1Var, this.n);
        }
        if (!this.o.isEmpty()) {
            h3Var.k("tags").g(w1Var, this.o);
        }
        if (this.p != null) {
            h3Var.k("data").g(w1Var, this.p);
        }
        Map<String, Object> map = this.q;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.q.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    @ApiStatus.Internal
    public t(e5 e5Var, Map<String, Object> map) {
        io.sentry.util.q.c(e5Var, "span is required");
        this.l = e5Var.getDescription();
        this.f22659k = e5Var.t();
        this.f22657i = e5Var.x();
        this.f22658j = e5Var.v();
        this.f22656h = e5Var.z();
        this.m = e5Var.getStatus();
        this.n = e5Var.m().c();
        Map<String, String> mapB = io.sentry.util.i.b(e5Var.y());
        this.o = mapB == null ? new ConcurrentHashMap<>() : mapB;
        this.f22655g = Double.valueOf(a1.l(e5Var.q().v(e5Var.n())));
        this.f22654f = Double.valueOf(a1.l(e5Var.q().x()));
        this.p = map;
    }

    @ApiStatus.Internal
    public t(Double d2, Double d3, q qVar, h5 h5Var, h5 h5Var2, String str, String str2, j5 j5Var, String str3, Map<String, String> map, Map<String, Object> map2) {
        this.f22654f = d2;
        this.f22655g = d3;
        this.f22656h = qVar;
        this.f22657i = h5Var;
        this.f22658j = h5Var2;
        this.f22659k = str;
        this.l = str2;
        this.m = j5Var;
        this.o = map;
        this.p = map2;
        this.n = str3;
    }
}
