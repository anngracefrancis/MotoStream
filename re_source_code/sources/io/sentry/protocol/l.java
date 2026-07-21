package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: Request.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f22617f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f22618g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f22619h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Object f22620i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f22621j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Map<String, String> f22622k;
    private Map<String, String> l;
    private Long m;
    private Map<String, String> n;
    private String o;
    private String p;
    private Map<String, Object> q;

    /* JADX INFO: compiled from: Request.java */
    public static final class a implements l2<l> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public l a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            l lVar = new l();
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "fragment":
                        lVar.o = n2Var.N0();
                        break;
                    case "method":
                        lVar.f22618g = n2Var.N0();
                        break;
                    case "env":
                        Map map = (Map) n2Var.K0();
                        if (map == null) {
                            break;
                        } else {
                            lVar.l = io.sentry.util.i.b(map);
                            break;
                        }
                        break;
                    case "url":
                        lVar.f22617f = n2Var.N0();
                        break;
                    case "data":
                        lVar.f22620i = n2Var.K0();
                        break;
                    case "other":
                        Map map2 = (Map) n2Var.K0();
                        if (map2 == null) {
                            break;
                        } else {
                            lVar.n = io.sentry.util.i.b(map2);
                            break;
                        }
                        break;
                    case "headers":
                        Map map3 = (Map) n2Var.K0();
                        if (map3 == null) {
                            break;
                        } else {
                            lVar.f22622k = io.sentry.util.i.b(map3);
                            break;
                        }
                        break;
                    case "cookies":
                        lVar.f22621j = n2Var.N0();
                        break;
                    case "body_size":
                        lVar.m = n2Var.G0();
                        break;
                    case "query_string":
                        lVar.f22619h = n2Var.N0();
                        break;
                    case "api_target":
                        lVar.p = n2Var.N0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, strB);
                        break;
                }
            }
            lVar.m(concurrentHashMap);
            n2Var.j();
            return lVar;
        }
    }

    public l() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return io.sentry.util.q.a(this.f22617f, lVar.f22617f) && io.sentry.util.q.a(this.f22618g, lVar.f22618g) && io.sentry.util.q.a(this.f22619h, lVar.f22619h) && io.sentry.util.q.a(this.f22621j, lVar.f22621j) && io.sentry.util.q.a(this.f22622k, lVar.f22622k) && io.sentry.util.q.a(this.l, lVar.l) && io.sentry.util.q.a(this.m, lVar.m) && io.sentry.util.q.a(this.o, lVar.o) && io.sentry.util.q.a(this.p, lVar.p);
    }

    public int hashCode() {
        return io.sentry.util.q.b(this.f22617f, this.f22618g, this.f22619h, this.f22621j, this.f22622k, this.l, this.m, this.o, this.p);
    }

    public Map<String, String> l() {
        return this.f22622k;
    }

    public void m(Map<String, Object> map) {
        this.q = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22617f != null) {
            h3Var.k("url").b(this.f22617f);
        }
        if (this.f22618g != null) {
            h3Var.k("method").b(this.f22618g);
        }
        if (this.f22619h != null) {
            h3Var.k("query_string").b(this.f22619h);
        }
        if (this.f22620i != null) {
            h3Var.k("data").g(w1Var, this.f22620i);
        }
        if (this.f22621j != null) {
            h3Var.k("cookies").b(this.f22621j);
        }
        if (this.f22622k != null) {
            h3Var.k("headers").g(w1Var, this.f22622k);
        }
        if (this.l != null) {
            h3Var.k("env").g(w1Var, this.l);
        }
        if (this.n != null) {
            h3Var.k("other").g(w1Var, this.n);
        }
        if (this.o != null) {
            h3Var.k("fragment").g(w1Var, this.o);
        }
        if (this.m != null) {
            h3Var.k("body_size").g(w1Var, this.m);
        }
        if (this.p != null) {
            h3Var.k("api_target").g(w1Var, this.p);
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

    public l(l lVar) {
        this.f22617f = lVar.f22617f;
        this.f22621j = lVar.f22621j;
        this.f22618g = lVar.f22618g;
        this.f22619h = lVar.f22619h;
        this.f22622k = io.sentry.util.i.b(lVar.f22622k);
        this.l = io.sentry.util.i.b(lVar.l);
        this.n = io.sentry.util.i.b(lVar.n);
        this.q = io.sentry.util.i.b(lVar.q);
        this.f22620i = lVar.f22620i;
        this.o = lVar.o;
        this.m = lVar.m;
        this.p = lVar.p;
    }
}
