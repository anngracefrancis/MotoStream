package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: Geo.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f22588f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f22589g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f22590h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<String, Object> f22591i;

    /* JADX INFO: compiled from: Geo.java */
    public static final class a implements l2<f> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            f fVar = new f();
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "region":
                        fVar.f22590h = n2Var.N0();
                        break;
                    case "city":
                        fVar.f22588f = n2Var.N0();
                        break;
                    case "country_code":
                        fVar.f22589g = n2Var.N0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, strB);
                        break;
                }
            }
            fVar.d(concurrentHashMap);
            n2Var.j();
            return fVar;
        }
    }

    public void d(Map<String, Object> map) {
        this.f22591i = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22588f != null) {
            h3Var.k("city").b(this.f22588f);
        }
        if (this.f22589g != null) {
            h3Var.k("country_code").b(this.f22589g);
        }
        if (this.f22590h != null) {
            h3Var.k("region").b(this.f22590h);
        }
        Map<String, Object> map = this.f22591i;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f22591i.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }
}
