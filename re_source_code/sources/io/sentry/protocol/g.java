package io.sentry.protocol;

import cm.aptoide.pt.DeepLinkIntentReceiver;
import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: Gpu.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f22592f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Integer f22593g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f22594h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f22595i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Integer f22596j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f22597k;
    private Boolean l;
    private String m;
    private String n;
    private Map<String, Object> o;

    /* JADX INFO: compiled from: Gpu.java */
    public static final class a implements l2<g> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public g a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            g gVar = new g();
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "npot_support":
                        gVar.n = n2Var.N0();
                        break;
                    case "vendor_id":
                        gVar.f22594h = n2Var.N0();
                        break;
                    case "multi_threaded_rendering":
                        gVar.l = n2Var.p0();
                        break;
                    case "id":
                        gVar.f22593g = n2Var.E0();
                        break;
                    case "name":
                        gVar.f22592f = n2Var.N0();
                        break;
                    case "vendor_name":
                        gVar.f22595i = n2Var.N0();
                        break;
                    case "version":
                        gVar.m = n2Var.N0();
                        break;
                    case "api_type":
                        gVar.f22597k = n2Var.N0();
                        break;
                    case "memory_size":
                        gVar.f22596j = n2Var.E0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, strB);
                        break;
                }
            }
            gVar.j(concurrentHashMap);
            n2Var.j();
            return gVar;
        }
    }

    public g() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return io.sentry.util.q.a(this.f22592f, gVar.f22592f) && io.sentry.util.q.a(this.f22593g, gVar.f22593g) && io.sentry.util.q.a(this.f22594h, gVar.f22594h) && io.sentry.util.q.a(this.f22595i, gVar.f22595i) && io.sentry.util.q.a(this.f22596j, gVar.f22596j) && io.sentry.util.q.a(this.f22597k, gVar.f22597k) && io.sentry.util.q.a(this.l, gVar.l) && io.sentry.util.q.a(this.m, gVar.m) && io.sentry.util.q.a(this.n, gVar.n);
    }

    public int hashCode() {
        return io.sentry.util.q.b(this.f22592f, this.f22593g, this.f22594h, this.f22595i, this.f22596j, this.f22597k, this.l, this.m, this.n);
    }

    public void j(Map<String, Object> map) {
        this.o = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22592f != null) {
            h3Var.k("name").b(this.f22592f);
        }
        if (this.f22593g != null) {
            h3Var.k(DeepLinkIntentReceiver.DeepLinksKeys.ID).e(this.f22593g);
        }
        if (this.f22594h != null) {
            h3Var.k("vendor_id").b(this.f22594h);
        }
        if (this.f22595i != null) {
            h3Var.k("vendor_name").b(this.f22595i);
        }
        if (this.f22596j != null) {
            h3Var.k("memory_size").e(this.f22596j);
        }
        if (this.f22597k != null) {
            h3Var.k("api_type").b(this.f22597k);
        }
        if (this.l != null) {
            h3Var.k("multi_threaded_rendering").h(this.l);
        }
        if (this.m != null) {
            h3Var.k("version").b(this.m);
        }
        if (this.n != null) {
            h3Var.k("npot_support").b(this.n);
        }
        Map<String, Object> map = this.o;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.o.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    g(g gVar) {
        this.f22592f = gVar.f22592f;
        this.f22593g = gVar.f22593g;
        this.f22594h = gVar.f22594h;
        this.f22595i = gVar.f22595i;
        this.f22596j = gVar.f22596j;
        this.f22597k = gVar.f22597k;
        this.l = gVar.l;
        this.m = gVar.m;
        this.n = gVar.n;
        this.o = io.sentry.util.i.b(gVar.o);
    }
}
