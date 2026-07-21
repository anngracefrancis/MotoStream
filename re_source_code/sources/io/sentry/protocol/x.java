package io.sentry.protocol;

import io.sentry.a1;
import io.sentry.b5;
import io.sentry.c4;
import io.sentry.e5;
import io.sentry.f5;
import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.q5;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: SentryTransaction.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class x extends c4 implements r2 {
    private y A;
    private Map<String, Object> B;
    private String u;
    private Double v;
    private Double w;
    private final List<t> x;
    private final String y;
    private final Map<String, h> z;

    /* JADX INFO: compiled from: SentryTransaction.java */
    public static final class a implements l2<x> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public x a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            x xVar = new x(HttpUrl.FRAGMENT_ENCODE_SET, Double.valueOf(0.0d), null, new ArrayList(), new HashMap(), new y(z.CUSTOM.apiName()));
            c4.a aVar = new c4.a();
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "start_timestamp":
                        try {
                            Double dT0 = n2Var.t0();
                            if (dT0 != null) {
                                xVar.v = dT0;
                            }
                            break;
                        } catch (NumberFormatException unused) {
                            Date dateQ0 = n2Var.q0(w1Var);
                            if (dateQ0 != null) {
                                xVar.v = Double.valueOf(a1.b(dateQ0));
                            }
                            break;
                        }
                        break;
                    case "measurements":
                        Map mapJ0 = n2Var.J0(w1Var, new h.a());
                        if (mapJ0 != null) {
                            xVar.z.putAll(mapJ0);
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "type":
                        n2Var.J();
                        break;
                    case "timestamp":
                        try {
                            Double dT1 = n2Var.t0();
                            if (dT1 != null) {
                                xVar.w = dT1;
                            }
                            break;
                        } catch (NumberFormatException unused2) {
                            Date dateQ1 = n2Var.q0(w1Var);
                            if (dateQ1 != null) {
                                xVar.w = Double.valueOf(a1.b(dateQ1));
                            }
                            break;
                        }
                        break;
                    case "spans":
                        List listF0 = n2Var.F0(w1Var, new t.a());
                        if (listF0 != null) {
                            xVar.x.addAll(listF0);
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "transaction_info":
                        xVar.A = new y.a().a(n2Var, w1Var);
                        break;
                    case "transaction":
                        xVar.u = n2Var.N0();
                        break;
                    default:
                        if (aVar.a(xVar, strB, n2Var, w1Var)) {
                            break;
                        } else {
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap();
                            }
                            n2Var.R0(w1Var, concurrentHashMap, strB);
                            break;
                        }
                        break;
                }
            }
            xVar.r0(concurrentHashMap);
            n2Var.j();
            return xVar;
        }
    }

    public x(b5 b5Var) {
        super(b5Var.k());
        this.x = new ArrayList();
        this.y = "transaction";
        this.z = new HashMap();
        io.sentry.util.q.c(b5Var, "sentryTracer is required");
        this.v = Double.valueOf(a1.l(b5Var.q().x()));
        this.w = Double.valueOf(a1.l(b5Var.q().v(b5Var.n())));
        this.u = b5Var.getName();
        for (e5 e5Var : b5Var.x()) {
            if (Boolean.TRUE.equals(e5Var.B())) {
                this.x.add(new t(e5Var));
            }
        }
        c cVarC = C();
        cVarC.putAll(b5Var.y());
        f5 f5VarM = b5Var.m();
        cVarC.n(new f5(f5VarM.k(), f5VarM.h(), f5VarM.d(), f5VarM.b(), f5VarM.a(), f5VarM.g(), f5VarM.i(), f5VarM.c()));
        for (Map.Entry<String, String> entry : f5VarM.j().entrySet()) {
            c0(entry.getKey(), entry.getValue());
        }
        Map<String, Object> mapZ = b5Var.z();
        if (mapZ != null) {
            for (Map.Entry<String, Object> entry2 : mapZ.entrySet()) {
                V(entry2.getKey(), entry2.getValue());
            }
        }
        this.A = new y(b5Var.p().apiName());
    }

    private BigDecimal l0(Double d2) {
        return BigDecimal.valueOf(d2.doubleValue()).setScale(6, RoundingMode.DOWN);
    }

    public Map<String, h> m0() {
        return this.z;
    }

    public q5 n0() {
        f5 f5VarE = C().e();
        if (f5VarE == null) {
            return null;
        }
        return f5VarE.g();
    }

    public List<t> o0() {
        return this.x;
    }

    public boolean p0() {
        return this.w != null;
    }

    public boolean q0() {
        q5 q5VarN0 = n0();
        if (q5VarN0 == null) {
            return false;
        }
        return q5VarN0.c().booleanValue();
    }

    public void r0(Map<String, Object> map) {
        this.B = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.u != null) {
            h3Var.k("transaction").b(this.u);
        }
        h3Var.k("start_timestamp").g(w1Var, l0(this.v));
        if (this.w != null) {
            h3Var.k("timestamp").g(w1Var, l0(this.w));
        }
        if (!this.x.isEmpty()) {
            h3Var.k("spans").g(w1Var, this.x);
        }
        h3Var.k("type").b("transaction");
        if (!this.z.isEmpty()) {
            h3Var.k("measurements").g(w1Var, this.z);
        }
        h3Var.k("transaction_info").g(w1Var, this.A);
        new c4.b().a(this, h3Var, w1Var);
        Map<String, Object> map = this.B;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.B.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    @ApiStatus.Internal
    public x(String str, Double d2, Double d3, List<t> list, Map<String, h> map, y yVar) {
        ArrayList arrayList = new ArrayList();
        this.x = arrayList;
        this.y = "transaction";
        HashMap map2 = new HashMap();
        this.z = map2;
        this.u = str;
        this.v = d2;
        this.w = d3;
        arrayList.addAll(list);
        map2.putAll(map);
        this.A = yVar;
    }
}
