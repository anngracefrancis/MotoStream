package io.sentry.protocol;

import cm.aptoide.pt.DeepLinkIntentReceiver;
import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.t4;
import io.sentry.w1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SentryThread.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Long f22670f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Integer f22671g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f22672h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f22673i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Boolean f22674j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Boolean f22675k;
    private Boolean l;
    private Boolean m;
    private v n;
    private Map<String, t4> o;
    private Map<String, Object> p;

    /* JADX INFO: compiled from: SentryThread.java */
    public static final class a implements l2<w> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public w a(n2 n2Var, w1 w1Var) throws Exception {
            w wVar = new w();
            n2Var.b();
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "daemon":
                        wVar.l = n2Var.p0();
                        break;
                    case "priority":
                        wVar.f22671g = n2Var.E0();
                        break;
                    case "held_locks":
                        Map mapJ0 = n2Var.J0(w1Var, new t4.a());
                        if (mapJ0 == null) {
                            break;
                        } else {
                            wVar.o = new HashMap(mapJ0);
                            break;
                        }
                        break;
                    case "id":
                        wVar.f22670f = n2Var.G0();
                        break;
                    case "main":
                        wVar.m = n2Var.p0();
                        break;
                    case "name":
                        wVar.f22672h = n2Var.N0();
                        break;
                    case "state":
                        wVar.f22673i = n2Var.N0();
                        break;
                    case "crashed":
                        wVar.f22674j = n2Var.p0();
                        break;
                    case "current":
                        wVar.f22675k = n2Var.p0();
                        break;
                    case "stacktrace":
                        wVar.n = (v) n2Var.M0(w1Var, new v.a());
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, strB);
                        break;
                }
            }
            wVar.A(concurrentHashMap);
            n2Var.j();
            return wVar;
        }
    }

    public void A(Map<String, Object> map) {
        this.p = map;
    }

    public Map<String, t4> k() {
        return this.o;
    }

    public Long l() {
        return this.f22670f;
    }

    public String m() {
        return this.f22672h;
    }

    public v n() {
        return this.n;
    }

    public Boolean o() {
        return this.f22675k;
    }

    public Boolean p() {
        return this.m;
    }

    public void q(Boolean bool) {
        this.f22674j = bool;
    }

    public void r(Boolean bool) {
        this.f22675k = bool;
    }

    public void s(Boolean bool) {
        this.l = bool;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22670f != null) {
            h3Var.k(DeepLinkIntentReceiver.DeepLinksKeys.ID).e(this.f22670f);
        }
        if (this.f22671g != null) {
            h3Var.k("priority").e(this.f22671g);
        }
        if (this.f22672h != null) {
            h3Var.k("name").b(this.f22672h);
        }
        if (this.f22673i != null) {
            h3Var.k("state").b(this.f22673i);
        }
        if (this.f22674j != null) {
            h3Var.k("crashed").h(this.f22674j);
        }
        if (this.f22675k != null) {
            h3Var.k("current").h(this.f22675k);
        }
        if (this.l != null) {
            h3Var.k("daemon").h(this.l);
        }
        if (this.m != null) {
            h3Var.k("main").h(this.m);
        }
        if (this.n != null) {
            h3Var.k("stacktrace").g(w1Var, this.n);
        }
        if (this.o != null) {
            h3Var.k("held_locks").g(w1Var, this.o);
        }
        Map<String, Object> map = this.p;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.p.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    public void t(Map<String, t4> map) {
        this.o = map;
    }

    public void u(Long l) {
        this.f22670f = l;
    }

    public void v(Boolean bool) {
        this.m = bool;
    }

    public void w(String str) {
        this.f22672h = str;
    }

    public void x(Integer num) {
        this.f22671g = num;
    }

    public void y(v vVar) {
        this.n = vVar;
    }

    public void z(String str) {
        this.f22673i = str;
    }
}
