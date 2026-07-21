package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.q4;
import io.sentry.r2;
import io.sentry.s4;
import io.sentry.w1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: SdkVersion.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f22634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f22635g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Set<r> f22636h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Set<String> f22637i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<String, Object> f22638j;

    /* JADX INFO: compiled from: SdkVersion.java */
    public static final class a implements l2<o> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public o a(n2 n2Var, w1 w1Var) throws Exception {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            n2Var.b();
            String strJ = null;
            String strJ2 = null;
            HashMap map = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "name":
                        strJ = n2Var.J();
                        break;
                    case "version":
                        strJ2 = n2Var.J();
                        break;
                    case "packages":
                        List listF0 = n2Var.F0(w1Var, new r.a());
                        if (listF0 == null) {
                            break;
                        } else {
                            arrayList.addAll(listF0);
                            break;
                        }
                        break;
                    case "integrations":
                        List list = (List) n2Var.K0();
                        if (list == null) {
                            break;
                        } else {
                            arrayList2.addAll(list);
                            break;
                        }
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
            if (strJ == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"name\"");
                w1Var.b(s4.ERROR, "Missing required field \"name\"", illegalStateException);
                throw illegalStateException;
            }
            if (strJ2 == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"version\"");
                w1Var.b(s4.ERROR, "Missing required field \"version\"", illegalStateException2);
                throw illegalStateException2;
            }
            o oVar = new o(strJ, strJ2);
            oVar.f22636h = new CopyOnWriteArraySet(arrayList);
            oVar.f22637i = new CopyOnWriteArraySet(arrayList2);
            oVar.i(map);
            return oVar;
        }
    }

    public o(String str, String str2) {
        this.f22634f = (String) io.sentry.util.q.c(str, "name is required.");
        this.f22635g = (String) io.sentry.util.q.c(str2, "version is required.");
    }

    public static o k(o oVar, String str, String str2) {
        io.sentry.util.q.c(str, "name is required.");
        io.sentry.util.q.c(str2, "version is required.");
        if (oVar == null) {
            return new o(str, str2);
        }
        oVar.h(str);
        oVar.j(str2);
        return oVar;
    }

    public void c(String str, String str2) {
        q4.c().b(str, str2);
    }

    public Set<String> d() {
        Set<String> set = this.f22637i;
        return set != null ? set : q4.c().d();
    }

    public String e() {
        return this.f22634f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        return this.f22634f.equals(oVar.f22634f) && this.f22635g.equals(oVar.f22635g);
    }

    public Set<r> f() {
        Set<r> set = this.f22636h;
        return set != null ? set : q4.c().e();
    }

    public String g() {
        return this.f22635g;
    }

    public void h(String str) {
        this.f22634f = (String) io.sentry.util.q.c(str, "name is required.");
    }

    public int hashCode() {
        return io.sentry.util.q.b(this.f22634f, this.f22635g);
    }

    public void i(Map<String, Object> map) {
        this.f22638j = map;
    }

    public void j(String str) {
        this.f22635g = (String) io.sentry.util.q.c(str, "version is required.");
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        h3Var.k("name").b(this.f22634f);
        h3Var.k("version").b(this.f22635g);
        Set<r> setF = f();
        Set<String> setD = d();
        if (!setF.isEmpty()) {
            h3Var.k("packages").g(w1Var, setF);
        }
        if (!setD.isEmpty()) {
            h3Var.k("integrations").g(w1Var, setD);
        }
        Map<String, Object> map = this.f22638j;
        if (map != null) {
            for (String str : map.keySet()) {
                h3Var.k(str).g(w1Var, this.f22638j.get(str));
            }
        }
        h3Var.d();
    }
}
