package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: TransactionInfo.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class y implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f22676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, Object> f22677g;

    /* JADX INFO: compiled from: TransactionInfo.java */
    public static final class a implements l2<y> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public y a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            String strN0 = null;
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                if (strB.equals("source")) {
                    strN0 = n2Var.N0();
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    n2Var.R0(w1Var, concurrentHashMap, strB);
                }
            }
            y yVar = new y(strN0);
            yVar.a(concurrentHashMap);
            n2Var.j();
            return yVar;
        }
    }

    public y(String str) {
        this.f22676f = str;
    }

    public void a(Map<String, Object> map) {
        this.f22677g = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22676f != null) {
            h3Var.k("source").g(w1Var, this.f22676f);
        }
        Map<String, Object> map = this.f22677g;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f22677g.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }
}
