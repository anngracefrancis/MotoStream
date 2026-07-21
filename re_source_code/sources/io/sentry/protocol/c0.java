package io.sentry.protocol;

import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ViewHierarchyNode.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c0 implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f22573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f22574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f22575h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f22576i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Double f22577j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Double f22578k;
    private Double l;
    private Double m;
    private String n;
    private Double o;
    private List<c0> p;
    private Map<String, Object> q;

    /* JADX INFO: compiled from: ViewHierarchyNode.java */
    public static final class a implements l2<c0> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public c0 a(n2 n2Var, w1 w1Var) throws Exception {
            c0 c0Var = new c0();
            n2Var.b();
            HashMap map = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "rendering_system":
                        c0Var.f22573f = n2Var.N0();
                        break;
                    case "identifier":
                        c0Var.f22575h = n2Var.N0();
                        break;
                    case "height":
                        c0Var.f22578k = n2Var.t0();
                        break;
                    case "x":
                        c0Var.l = n2Var.t0();
                        break;
                    case "y":
                        c0Var.m = n2Var.t0();
                        break;
                    case "tag":
                        c0Var.f22576i = n2Var.N0();
                        break;
                    case "type":
                        c0Var.f22574g = n2Var.N0();
                        break;
                    case "alpha":
                        c0Var.o = n2Var.t0();
                        break;
                    case "width":
                        c0Var.f22577j = n2Var.t0();
                        break;
                    case "children":
                        c0Var.p = n2Var.F0(w1Var, this);
                        break;
                    case "visibility":
                        c0Var.n = n2Var.N0();
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
            c0Var.q(map);
            return c0Var;
        }
    }

    public void l(Double d2) {
        this.o = d2;
    }

    public void m(List<c0> list) {
        this.p = list;
    }

    public void n(Double d2) {
        this.f22578k = d2;
    }

    public void o(String str) {
        this.f22575h = str;
    }

    public void p(String str) {
        this.f22574g = str;
    }

    public void q(Map<String, Object> map) {
        this.q = map;
    }

    public void r(String str) {
        this.n = str;
    }

    public void s(Double d2) {
        this.f22577j = d2;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22573f != null) {
            h3Var.k("rendering_system").b(this.f22573f);
        }
        if (this.f22574g != null) {
            h3Var.k("type").b(this.f22574g);
        }
        if (this.f22575h != null) {
            h3Var.k("identifier").b(this.f22575h);
        }
        if (this.f22576i != null) {
            h3Var.k(StoreTabGridRecyclerFragment.BundleCons.TAG).b(this.f22576i);
        }
        if (this.f22577j != null) {
            h3Var.k("width").e(this.f22577j);
        }
        if (this.f22578k != null) {
            h3Var.k("height").e(this.f22578k);
        }
        if (this.l != null) {
            h3Var.k("x").e(this.l);
        }
        if (this.m != null) {
            h3Var.k("y").e(this.m);
        }
        if (this.n != null) {
            h3Var.k("visibility").b(this.n);
        }
        if (this.o != null) {
            h3Var.k("alpha").e(this.o);
        }
        List<c0> list = this.p;
        if (list != null && !list.isEmpty()) {
            h3Var.k("children").g(w1Var, this.p);
        }
        Map<String, Object> map = this.q;
        if (map != null) {
            for (String str : map.keySet()) {
                h3Var.k(str).g(w1Var, this.q.get(str));
            }
        }
        h3Var.d();
    }

    public void t(Double d2) {
        this.l = d2;
    }

    public void u(Double d2) {
        this.m = d2;
    }
}
