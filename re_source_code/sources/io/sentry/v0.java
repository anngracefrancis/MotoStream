package io.sentry;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: Breadcrumb.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v0 implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Date f22766f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f22767g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f22768h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<String, Object> f22769i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f22770j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private s4 f22771k;
    private Map<String, Object> l;

    /* JADX INFO: compiled from: Breadcrumb.java */
    public static final class a implements l2<v0> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public v0 a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            Date dateC = a1.c();
            Map concurrentHashMap = new ConcurrentHashMap();
            String strN0 = null;
            String strN1 = null;
            String strN2 = null;
            s4 s4VarA = null;
            ConcurrentHashMap concurrentHashMap2 = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "data":
                        Map mapB = io.sentry.util.i.b((Map) n2Var.K0());
                        if (mapB == null) {
                            break;
                        } else {
                            concurrentHashMap = mapB;
                            break;
                        }
                        break;
                    case "type":
                        strN1 = n2Var.N0();
                        break;
                    case "category":
                        strN2 = n2Var.N0();
                        break;
                    case "timestamp":
                        Date dateQ0 = n2Var.q0(w1Var);
                        if (dateQ0 == null) {
                            break;
                        } else {
                            dateC = dateQ0;
                            break;
                        }
                        break;
                    case "level":
                        try {
                            s4VarA = new s4.a().a(n2Var, w1Var);
                            break;
                        } catch (Exception e2) {
                            w1Var.a(s4.ERROR, e2, "Error when deserializing SentryLevel", new Object[0]);
                            break;
                        }
                        break;
                    case "message":
                        strN0 = n2Var.N0();
                        break;
                    default:
                        if (concurrentHashMap2 == null) {
                            concurrentHashMap2 = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap2, strB);
                        break;
                }
            }
            v0 v0Var = new v0(dateC);
            v0Var.f22767g = strN0;
            v0Var.f22768h = strN1;
            v0Var.f22769i = concurrentHashMap;
            v0Var.f22770j = strN2;
            v0Var.f22771k = s4VarA;
            v0Var.q(concurrentHashMap2);
            n2Var.j();
            return v0Var;
        }
    }

    public v0(Date date) {
        this.f22769i = new ConcurrentHashMap();
        this.f22766f = date;
    }

    public static v0 r(String str, String str2, String str3, String str4, Map<String, Object> map) {
        v0 v0Var = new v0();
        v0Var.p("user");
        v0Var.l("ui." + str);
        if (str2 != null) {
            v0Var.m("view.id", str2);
        }
        if (str3 != null) {
            v0Var.m("view.class", str3);
        }
        if (str4 != null) {
            v0Var.m("view.tag", str4);
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            v0Var.g().put(entry.getKey(), entry.getValue());
        }
        v0Var.n(s4.INFO);
        return v0Var;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v0.class != obj.getClass()) {
            return false;
        }
        v0 v0Var = (v0) obj;
        return this.f22766f.getTime() == v0Var.f22766f.getTime() && io.sentry.util.q.a(this.f22767g, v0Var.f22767g) && io.sentry.util.q.a(this.f22768h, v0Var.f22768h) && io.sentry.util.q.a(this.f22770j, v0Var.f22770j) && this.f22771k == v0Var.f22771k;
    }

    public String f() {
        return this.f22770j;
    }

    @ApiStatus.Internal
    public Map<String, Object> g() {
        return this.f22769i;
    }

    public s4 h() {
        return this.f22771k;
    }

    public int hashCode() {
        return io.sentry.util.q.b(this.f22766f, this.f22767g, this.f22768h, this.f22770j, this.f22771k);
    }

    public String i() {
        return this.f22767g;
    }

    public Date j() {
        return (Date) this.f22766f.clone();
    }

    public String k() {
        return this.f22768h;
    }

    public void l(String str) {
        this.f22770j = str;
    }

    public void m(String str, Object obj) {
        this.f22769i.put(str, obj);
    }

    public void n(s4 s4Var) {
        this.f22771k = s4Var;
    }

    public void o(String str) {
        this.f22767g = str;
    }

    public void p(String str) {
        this.f22768h = str;
    }

    public void q(Map<String, Object> map) {
        this.l = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        h3Var.k("timestamp").g(w1Var, this.f22766f);
        if (this.f22767g != null) {
            h3Var.k("message").b(this.f22767g);
        }
        if (this.f22768h != null) {
            h3Var.k("type").b(this.f22768h);
        }
        h3Var.k("data").g(w1Var, this.f22769i);
        if (this.f22770j != null) {
            h3Var.k("category").b(this.f22770j);
        }
        if (this.f22771k != null) {
            h3Var.k("level").g(w1Var, this.f22771k);
        }
        Map<String, Object> map = this.l;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.l.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    v0(v0 v0Var) {
        this.f22769i = new ConcurrentHashMap();
        this.f22766f = v0Var.f22766f;
        this.f22767g = v0Var.f22767g;
        this.f22768h = v0Var.f22768h;
        this.f22770j = v0Var.f22770j;
        Map<String, Object> mapB = io.sentry.util.i.b(v0Var.f22769i);
        if (mapB != null) {
            this.f22769i = mapB;
        }
        this.l = io.sentry.util.i.b(v0Var.l);
        this.f22771k = v0Var.f22771k;
    }

    public v0() {
        this(a1.c());
    }
}
