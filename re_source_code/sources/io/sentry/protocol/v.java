package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SentryStackTrace.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<u> f22666f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, String> f22667g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Boolean f22668h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<String, Object> f22669i;

    /* JADX INFO: compiled from: SentryStackTrace.java */
    public static final class a implements l2<v> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public v a(n2 n2Var, w1 w1Var) throws Exception {
            v vVar = new v();
            n2Var.b();
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "frames":
                        vVar.f22666f = n2Var.F0(w1Var, new u.a());
                        break;
                    case "registers":
                        vVar.f22667g = io.sentry.util.i.b((Map) n2Var.K0());
                        break;
                    case "snapshot":
                        vVar.f22668h = n2Var.p0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, strB);
                        break;
                }
            }
            vVar.f(concurrentHashMap);
            n2Var.j();
            return vVar;
        }
    }

    public v() {
    }

    public List<u> d() {
        return this.f22666f;
    }

    public void e(Boolean bool) {
        this.f22668h = bool;
    }

    public void f(Map<String, Object> map) {
        this.f22669i = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22666f != null) {
            h3Var.k("frames").g(w1Var, this.f22666f);
        }
        if (this.f22667g != null) {
            h3Var.k("registers").g(w1Var, this.f22667g);
        }
        if (this.f22668h != null) {
            h3Var.k("snapshot").h(this.f22668h);
        }
        Map<String, Object> map = this.f22669i;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f22669i.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    public v(List<u> list) {
        this.f22666f = list;
    }
}
