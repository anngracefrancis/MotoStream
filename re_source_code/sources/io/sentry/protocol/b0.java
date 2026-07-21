package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ViewHierarchy.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b0 implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f22569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<c0> f22570g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<String, Object> f22571h;

    /* JADX INFO: compiled from: ViewHierarchy.java */
    public static final class a implements l2<b0> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b0 a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            String strN0 = null;
            List listF0 = null;
            HashMap map = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                if (strB.equals("rendering_system")) {
                    strN0 = n2Var.N0();
                } else if (strB.equals("windows")) {
                    listF0 = n2Var.F0(w1Var, new c0.a());
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    n2Var.R0(w1Var, map, strB);
                }
            }
            n2Var.j();
            b0 b0Var = new b0(strN0, listF0);
            b0Var.a(map);
            return b0Var;
        }
    }

    public b0(String str, List<c0> list) {
        this.f22569f = str;
        this.f22570g = list;
    }

    public void a(Map<String, Object> map) {
        this.f22571h = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22569f != null) {
            h3Var.k("rendering_system").b(this.f22569f);
        }
        if (this.f22570g != null) {
            h3Var.k("windows").g(w1Var, this.f22570g);
        }
        Map<String, Object> map = this.f22571h;
        if (map != null) {
            for (String str : map.keySet()) {
                h3Var.k(str).g(w1Var, this.f22571h.get(str));
            }
        }
        h3Var.d();
    }
}
