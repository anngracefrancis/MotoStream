package io.sentry.profilemeasurements;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.util.q;
import io.sentry.w1;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: ProfileMeasurementValue.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class b implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, Object> f22551f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f22552g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private double f22553h;

    /* JADX INFO: compiled from: ProfileMeasurementValue.java */
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
                if (strB.equals("elapsed_since_start_ns")) {
                    String strN0 = n2Var.N0();
                    if (strN0 != null) {
                        bVar.f22552g = strN0;
                    }
                } else if (strB.equals("value")) {
                    Double dT0 = n2Var.t0();
                    if (dT0 != null) {
                        bVar.f22553h = dT0.doubleValue();
                    }
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
        this(0L, 0);
    }

    public void c(Map<String, Object> map) {
        this.f22551f = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return q.a(this.f22551f, bVar.f22551f) && this.f22552g.equals(bVar.f22552g) && this.f22553h == bVar.f22553h;
    }

    public int hashCode() {
        return q.b(this.f22551f, this.f22552g, Double.valueOf(this.f22553h));
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        h3Var.k("value").g(w1Var, Double.valueOf(this.f22553h));
        h3Var.k("elapsed_since_start_ns").g(w1Var, this.f22552g);
        Map<String, Object> map = this.f22551f;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f22551f.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    public b(Long l, Number number) {
        this.f22552g = l.toString();
        this.f22553h = number.doubleValue();
    }
}
