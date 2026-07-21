package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SentryException.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f22639f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f22640g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f22641h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Long f22642i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private v f22643j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private i f22644k;
    private Map<String, Object> l;

    /* JADX INFO: compiled from: SentryException.java */
    public static final class a implements l2<p> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public p a(n2 n2Var, w1 w1Var) throws Exception {
            p pVar = new p();
            n2Var.b();
            HashMap map = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "thread_id":
                        pVar.f22642i = n2Var.G0();
                        break;
                    case "module":
                        pVar.f22641h = n2Var.N0();
                        break;
                    case "type":
                        pVar.f22639f = n2Var.N0();
                        break;
                    case "value":
                        pVar.f22640g = n2Var.N0();
                        break;
                    case "mechanism":
                        pVar.f22644k = (i) n2Var.M0(w1Var, new i.a());
                        break;
                    case "stacktrace":
                        pVar.f22643j = (v) n2Var.M0(w1Var, new v.a());
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
            pVar.o(map);
            return pVar;
        }
    }

    public i g() {
        return this.f22644k;
    }

    public Long h() {
        return this.f22642i;
    }

    public String i() {
        return this.f22639f;
    }

    public void j(i iVar) {
        this.f22644k = iVar;
    }

    public void k(String str) {
        this.f22641h = str;
    }

    public void l(v vVar) {
        this.f22643j = vVar;
    }

    public void m(Long l) {
        this.f22642i = l;
    }

    public void n(String str) {
        this.f22639f = str;
    }

    public void o(Map<String, Object> map) {
        this.l = map;
    }

    public void p(String str) {
        this.f22640g = str;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22639f != null) {
            h3Var.k("type").b(this.f22639f);
        }
        if (this.f22640g != null) {
            h3Var.k("value").b(this.f22640g);
        }
        if (this.f22641h != null) {
            h3Var.k("module").b(this.f22641h);
        }
        if (this.f22642i != null) {
            h3Var.k("thread_id").e(this.f22642i);
        }
        if (this.f22643j != null) {
            h3Var.k("stacktrace").g(w1Var, this.f22643j);
        }
        if (this.f22644k != null) {
            h3Var.k("mechanism").g(w1Var, this.f22644k);
        }
        Map<String, Object> map = this.l;
        if (map != null) {
            for (String str : map.keySet()) {
                h3Var.k(str).g(w1Var, this.l.get(str));
            }
        }
        h3Var.d();
    }
}
