package io.sentry;

import cm.aptoide.pt.DeepLinkIntentReceiver;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: ProfilingTransactionData.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class n3 implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f22506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f22507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f22508h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Long f22509i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Long f22510j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Long f22511k;
    private Long l;
    private Map<String, Object> m;

    /* JADX INFO: compiled from: ProfilingTransactionData.java */
    public static final class a implements l2<n3> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public n3 a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            n3 n3Var = new n3();
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "relative_start_ns":
                        Long lG0 = n2Var.G0();
                        if (lG0 == null) {
                            break;
                        } else {
                            n3Var.f22509i = lG0;
                            break;
                        }
                        break;
                    case "relative_end_ns":
                        Long lG1 = n2Var.G0();
                        if (lG1 == null) {
                            break;
                        } else {
                            n3Var.f22510j = lG1;
                            break;
                        }
                        break;
                    case "id":
                        String strN0 = n2Var.N0();
                        if (strN0 == null) {
                            break;
                        } else {
                            n3Var.f22506f = strN0;
                            break;
                        }
                        break;
                    case "name":
                        String strN1 = n2Var.N0();
                        if (strN1 == null) {
                            break;
                        } else {
                            n3Var.f22508h = strN1;
                            break;
                        }
                        break;
                    case "trace_id":
                        String strN2 = n2Var.N0();
                        if (strN2 == null) {
                            break;
                        } else {
                            n3Var.f22507g = strN2;
                            break;
                        }
                        break;
                    case "relative_cpu_end_ms":
                        Long lG2 = n2Var.G0();
                        if (lG2 == null) {
                            break;
                        } else {
                            n3Var.l = lG2;
                            break;
                        }
                        break;
                    case "relative_cpu_start_ms":
                        Long lG3 = n2Var.G0();
                        if (lG3 == null) {
                            break;
                        } else {
                            n3Var.f22511k = lG3;
                            break;
                        }
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, strB);
                        break;
                }
            }
            n3Var.j(concurrentHashMap);
            n2Var.j();
            return n3Var;
        }
    }

    public n3() {
        this(d3.r(), 0L, 0L);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n3.class != obj.getClass()) {
            return false;
        }
        n3 n3Var = (n3) obj;
        return this.f22506f.equals(n3Var.f22506f) && this.f22507g.equals(n3Var.f22507g) && this.f22508h.equals(n3Var.f22508h) && this.f22509i.equals(n3Var.f22509i) && this.f22511k.equals(n3Var.f22511k) && io.sentry.util.q.a(this.l, n3Var.l) && io.sentry.util.q.a(this.f22510j, n3Var.f22510j) && io.sentry.util.q.a(this.m, n3Var.m);
    }

    public String h() {
        return this.f22506f;
    }

    public int hashCode() {
        return io.sentry.util.q.b(this.f22506f, this.f22507g, this.f22508h, this.f22509i, this.f22510j, this.f22511k, this.l, this.m);
    }

    public void i(Long l, Long l2, Long l3, Long l4) {
        if (this.f22510j == null) {
            this.f22510j = Long.valueOf(l.longValue() - l2.longValue());
            this.f22509i = Long.valueOf(this.f22509i.longValue() - l2.longValue());
            this.l = Long.valueOf(l3.longValue() - l4.longValue());
            this.f22511k = Long.valueOf(this.f22511k.longValue() - l4.longValue());
        }
    }

    public void j(Map<String, Object> map) {
        this.m = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        h3Var.k(DeepLinkIntentReceiver.DeepLinksKeys.ID).g(w1Var, this.f22506f);
        h3Var.k("trace_id").g(w1Var, this.f22507g);
        h3Var.k("name").g(w1Var, this.f22508h);
        h3Var.k("relative_start_ns").g(w1Var, this.f22509i);
        h3Var.k("relative_end_ns").g(w1Var, this.f22510j);
        h3Var.k("relative_cpu_start_ms").g(w1Var, this.f22511k);
        h3Var.k("relative_cpu_end_ms").g(w1Var, this.l);
        Map<String, Object> map = this.m;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.m.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    public n3(e2 e2Var, Long l, Long l2) {
        this.f22506f = e2Var.k().toString();
        this.f22507g = e2Var.m().k().toString();
        this.f22508h = e2Var.getName();
        this.f22509i = l;
        this.f22511k = l2;
    }
}
