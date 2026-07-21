package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.s4;
import io.sentry.w1;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: MeasurementValue.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class h implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Number f22598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f22599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<String, Object> f22600h;

    /* JADX INFO: compiled from: MeasurementValue.java */
    public static final class a implements l2<h> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public h a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            Number number = null;
            String strN0 = null;
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                if (strB.equals("unit")) {
                    strN0 = n2Var.N0();
                } else if (strB.equals("value")) {
                    number = (Number) n2Var.K0();
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    n2Var.R0(w1Var, concurrentHashMap, strB);
                }
            }
            n2Var.j();
            if (number != null) {
                h hVar = new h(number, strN0);
                hVar.a(concurrentHashMap);
                return hVar;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"value\"");
            w1Var.b(s4.ERROR, "Missing required field \"value\"", illegalStateException);
            throw illegalStateException;
        }
    }

    public h(Number number, String str) {
        this.f22598f = number;
        this.f22599g = str;
    }

    public void a(Map<String, Object> map) {
        this.f22600h = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        h3Var.k("value").e(this.f22598f);
        if (this.f22599g != null) {
            h3Var.k("unit").b(this.f22599g);
        }
        Map<String, Object> map = this.f22600h;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f22600h.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }
}
