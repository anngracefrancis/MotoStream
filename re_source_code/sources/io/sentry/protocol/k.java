package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: OperatingSystem.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f22611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f22612g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f22613h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f22614i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f22615j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Boolean f22616k;
    private Map<String, Object> l;

    /* JADX INFO: compiled from: OperatingSystem.java */
    public static final class a implements l2<k> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public k a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            k kVar = new k();
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "rooted":
                        kVar.f22616k = n2Var.p0();
                        break;
                    case "raw_description":
                        kVar.f22613h = n2Var.N0();
                        break;
                    case "name":
                        kVar.f22611f = n2Var.N0();
                        break;
                    case "build":
                        kVar.f22614i = n2Var.N0();
                        break;
                    case "version":
                        kVar.f22612g = n2Var.N0();
                        break;
                    case "kernel_version":
                        kVar.f22615j = n2Var.N0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, strB);
                        break;
                }
            }
            kVar.l(concurrentHashMap);
            n2Var.j();
            return kVar;
        }
    }

    public k() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return io.sentry.util.q.a(this.f22611f, kVar.f22611f) && io.sentry.util.q.a(this.f22612g, kVar.f22612g) && io.sentry.util.q.a(this.f22613h, kVar.f22613h) && io.sentry.util.q.a(this.f22614i, kVar.f22614i) && io.sentry.util.q.a(this.f22615j, kVar.f22615j) && io.sentry.util.q.a(this.f22616k, kVar.f22616k);
    }

    public String g() {
        return this.f22611f;
    }

    public void h(String str) {
        this.f22614i = str;
    }

    public int hashCode() {
        return io.sentry.util.q.b(this.f22611f, this.f22612g, this.f22613h, this.f22614i, this.f22615j, this.f22616k);
    }

    public void i(String str) {
        this.f22615j = str;
    }

    public void j(String str) {
        this.f22611f = str;
    }

    public void k(Boolean bool) {
        this.f22616k = bool;
    }

    public void l(Map<String, Object> map) {
        this.l = map;
    }

    public void m(String str) {
        this.f22612g = str;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22611f != null) {
            h3Var.k("name").b(this.f22611f);
        }
        if (this.f22612g != null) {
            h3Var.k("version").b(this.f22612g);
        }
        if (this.f22613h != null) {
            h3Var.k("raw_description").b(this.f22613h);
        }
        if (this.f22614i != null) {
            h3Var.k("build").b(this.f22614i);
        }
        if (this.f22615j != null) {
            h3Var.k("kernel_version").b(this.f22615j);
        }
        if (this.f22616k != null) {
            h3Var.k("rooted").h(this.f22616k);
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

    k(k kVar) {
        this.f22611f = kVar.f22611f;
        this.f22612g = kVar.f22612g;
        this.f22613h = kVar.f22613h;
        this.f22614i = kVar.f22614i;
        this.f22615j = kVar.f22615j;
        this.f22616k = kVar.f22616k;
        this.l = io.sentry.util.i.b(kVar.l);
    }
}
