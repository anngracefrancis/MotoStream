package io.sentry.clientreport;

import io.sentry.a1;
import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.s4;
import io.sentry.w1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: ClientReport.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class b implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Date f22356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<f> f22357g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<String, Object> f22358h;

    /* JADX INFO: compiled from: ClientReport.java */
    public static final class a implements l2<b> {
        private Exception c(String str, w1 w1Var) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            w1Var.b(s4.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(n2 n2Var, w1 w1Var) throws Exception {
            ArrayList arrayList = new ArrayList();
            n2Var.b();
            Date dateQ0 = null;
            HashMap map = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                if (strB.equals("discarded_events")) {
                    arrayList.addAll(n2Var.F0(w1Var, new f.a()));
                } else if (strB.equals("timestamp")) {
                    dateQ0 = n2Var.q0(w1Var);
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    n2Var.R0(w1Var, map, strB);
                }
            }
            n2Var.j();
            if (dateQ0 == null) {
                throw c("timestamp", w1Var);
            }
            if (arrayList.isEmpty()) {
                throw c("discarded_events", w1Var);
            }
            b bVar = new b(dateQ0, arrayList);
            bVar.b(map);
            return bVar;
        }
    }

    public b(Date date, List<f> list) {
        this.f22356f = date;
        this.f22357g = list;
    }

    public List<f> a() {
        return this.f22357g;
    }

    public void b(Map<String, Object> map) {
        this.f22358h = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        h3Var.k("timestamp").b(a1.g(this.f22356f));
        h3Var.k("discarded_events").g(w1Var, this.f22357g);
        Map<String, Object> map = this.f22358h;
        if (map != null) {
            for (String str : map.keySet()) {
                h3Var.k(str).g(w1Var, this.f22358h.get(str));
            }
        }
        h3Var.d();
    }
}
