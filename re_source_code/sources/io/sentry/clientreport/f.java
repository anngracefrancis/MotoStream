package io.sentry.clientreport;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.s4;
import io.sentry.w1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: DiscardedEvent.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class f implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f22361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f22362g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Long f22363h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<String, Object> f22364i;

    /* JADX INFO: compiled from: DiscardedEvent.java */
    public static final class a implements l2<f> {
        private Exception c(String str, w1 w1Var) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            w1Var.b(s4.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            String strN0 = null;
            String strN1 = null;
            Long lG0 = null;
            HashMap map = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "quantity":
                        lG0 = n2Var.G0();
                        break;
                    case "reason":
                        strN0 = n2Var.N0();
                        break;
                    case "category":
                        strN1 = n2Var.N0();
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        n2Var.R0(w1Var, map, strB);
                        break;
                }
            }
            n2Var.j();
            if (strN0 == null) {
                throw c("reason", w1Var);
            }
            if (strN1 == null) {
                throw c("category", w1Var);
            }
            if (lG0 == null) {
                throw c("quantity", w1Var);
            }
            f fVar = new f(strN0, strN1, lG0);
            fVar.d(map);
            return fVar;
        }
    }

    public f(String str, String str2, Long l) {
        this.f22361f = str;
        this.f22362g = str2;
        this.f22363h = l;
    }

    public String a() {
        return this.f22362g;
    }

    public Long b() {
        return this.f22363h;
    }

    public String c() {
        return this.f22361f;
    }

    public void d(Map<String, Object> map) {
        this.f22364i = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        h3Var.k("reason").b(this.f22361f);
        h3Var.k("category").b(this.f22362g);
        h3Var.k("quantity").e(this.f22363h);
        Map<String, Object> map = this.f22364i;
        if (map != null) {
            for (String str : map.keySet()) {
                h3Var.k(str).g(w1Var, this.f22364i.get(str));
            }
        }
        h3Var.d();
    }

    public String toString() {
        return "DiscardedEvent{reason='" + this.f22361f + "', category='" + this.f22362g + "', quantity=" + this.f22363h + '}';
    }
}
