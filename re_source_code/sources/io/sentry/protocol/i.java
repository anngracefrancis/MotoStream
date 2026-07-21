package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Mechanism.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient Thread f22601f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f22602g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f22603h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f22604i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Boolean f22605j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Map<String, Object> f22606k;
    private Map<String, Object> l;
    private Boolean m;
    private Map<String, Object> n;

    /* JADX INFO: compiled from: Mechanism.java */
    public static final class a implements l2<i> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public i a(n2 n2Var, w1 w1Var) throws Exception {
            i iVar = new i();
            n2Var.b();
            HashMap map = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "description":
                        iVar.f22603h = n2Var.N0();
                        break;
                    case "data":
                        iVar.l = io.sentry.util.i.b((Map) n2Var.K0());
                        break;
                    case "meta":
                        iVar.f22606k = io.sentry.util.i.b((Map) n2Var.K0());
                        break;
                    case "type":
                        iVar.f22602g = n2Var.N0();
                        break;
                    case "handled":
                        iVar.f22605j = n2Var.p0();
                        break;
                    case "synthetic":
                        iVar.m = n2Var.p0();
                        break;
                    case "help_link":
                        iVar.f22604i = n2Var.N0();
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
            iVar.k(map);
            return iVar;
        }
    }

    public i() {
        this(null);
    }

    public Boolean h() {
        return this.f22605j;
    }

    public void i(Boolean bool) {
        this.f22605j = bool;
    }

    public void j(String str) {
        this.f22602g = str;
    }

    public void k(Map<String, Object> map) {
        this.n = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22602g != null) {
            h3Var.k("type").b(this.f22602g);
        }
        if (this.f22603h != null) {
            h3Var.k("description").b(this.f22603h);
        }
        if (this.f22604i != null) {
            h3Var.k("help_link").b(this.f22604i);
        }
        if (this.f22605j != null) {
            h3Var.k("handled").h(this.f22605j);
        }
        if (this.f22606k != null) {
            h3Var.k("meta").g(w1Var, this.f22606k);
        }
        if (this.l != null) {
            h3Var.k("data").g(w1Var, this.l);
        }
        if (this.m != null) {
            h3Var.k("synthetic").h(this.m);
        }
        Map<String, Object> map = this.n;
        if (map != null) {
            for (String str : map.keySet()) {
                h3Var.k(str).g(w1Var, this.n.get(str));
            }
        }
        h3Var.d();
    }

    public i(Thread thread) {
        this.f22601f = thread;
    }
}
