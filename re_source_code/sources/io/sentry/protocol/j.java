package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: Message.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f22607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f22608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<String> f22609h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<String, Object> f22610i;

    /* JADX INFO: compiled from: Message.java */
    public static final class a implements l2<j> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public j a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            j jVar = new j();
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "params":
                        List list = (List) n2Var.K0();
                        if (list == null) {
                            break;
                        } else {
                            jVar.f22609h = list;
                            break;
                        }
                        break;
                    case "message":
                        jVar.f22608g = n2Var.N0();
                        break;
                    case "formatted":
                        jVar.f22607f = n2Var.N0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, strB);
                        break;
                }
            }
            jVar.f(concurrentHashMap);
            n2Var.j();
            return jVar;
        }
    }

    public void d(String str) {
        this.f22607f = str;
    }

    public void e(String str) {
        this.f22608g = str;
    }

    public void f(Map<String, Object> map) {
        this.f22610i = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22607f != null) {
            h3Var.k("formatted").b(this.f22607f);
        }
        if (this.f22608g != null) {
            h3Var.k("message").b(this.f22608g);
        }
        List<String> list = this.f22609h;
        if (list != null && !list.isEmpty()) {
            h3Var.k("params").g(w1Var, this.f22609h);
        }
        Map<String, Object> map = this.f22610i;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f22610i.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }
}
