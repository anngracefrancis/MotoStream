package io.sentry.profilemeasurements;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.util.q;
import io.sentry.w1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: ProfileMeasurement.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class a implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, Object> f22548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f22549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Collection<b> f22550h;

    /* JADX INFO: renamed from: io.sentry.profilemeasurements.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ProfileMeasurement.java */
    public static final class C0307a implements l2<a> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            a aVar = new a();
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                if (strB.equals("values")) {
                    List listF0 = n2Var.F0(w1Var, new b.a());
                    if (listF0 != null) {
                        aVar.f22550h = listF0;
                    }
                } else if (strB.equals("unit")) {
                    String strN0 = n2Var.N0();
                    if (strN0 != null) {
                        aVar.f22549g = strN0;
                    }
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    n2Var.R0(w1Var, concurrentHashMap, strB);
                }
            }
            aVar.c(concurrentHashMap);
            n2Var.j();
            return aVar;
        }
    }

    public a() {
        this("unknown", new ArrayList());
    }

    public void c(Map<String, Object> map) {
        this.f22548f = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return q.a(this.f22548f, aVar.f22548f) && this.f22549g.equals(aVar.f22549g) && new ArrayList(this.f22550h).equals(new ArrayList(aVar.f22550h));
    }

    public int hashCode() {
        return q.b(this.f22548f, this.f22549g, this.f22550h);
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        h3Var.k("unit").g(w1Var, this.f22549g);
        h3Var.k("values").g(w1Var, this.f22550h);
        Map<String, Object> map = this.f22548f;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f22548f.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    public a(String str, Collection<b> collection) {
        this.f22549g = str;
        this.f22550h = collection;
    }
}
