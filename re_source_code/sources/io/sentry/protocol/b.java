package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: Browser.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f22566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f22567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<String, Object> f22568h;

    /* JADX INFO: compiled from: Browser.java */
    public static final class a implements l2<b> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            b bVar = new b();
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                if (strB.equals("name")) {
                    bVar.f22566f = n2Var.N0();
                } else if (strB.equals("version")) {
                    bVar.f22567g = n2Var.N0();
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    n2Var.R0(w1Var, concurrentHashMap, strB);
                }
            }
            bVar.c(concurrentHashMap);
            n2Var.j();
            return bVar;
        }
    }

    public b() {
    }

    public void c(Map<String, Object> map) {
        this.f22568h = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return io.sentry.util.q.a(this.f22566f, bVar.f22566f) && io.sentry.util.q.a(this.f22567g, bVar.f22567g);
    }

    public int hashCode() {
        return io.sentry.util.q.b(this.f22566f, this.f22567g);
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22566f != null) {
            h3Var.k("name").b(this.f22566f);
        }
        if (this.f22567g != null) {
            h3Var.k("version").b(this.f22567g);
        }
        Map<String, Object> map = this.f22568h;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f22568h.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    b(b bVar) {
        this.f22566f = bVar.f22566f;
        this.f22567g = bVar.f22567g;
        this.f22568h = io.sentry.util.i.b(bVar.f22568h);
    }
}
