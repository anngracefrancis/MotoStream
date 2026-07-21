package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SdkInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f22629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Integer f22630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Integer f22631h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Integer f22632i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<String, Object> f22633j;

    /* JADX INFO: compiled from: SdkInfo.java */
    public static final class a implements l2<n> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public n a(n2 n2Var, w1 w1Var) throws Exception {
            n nVar = new n();
            n2Var.b();
            HashMap map = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "sdk_name":
                        nVar.f22629f = n2Var.N0();
                        break;
                    case "version_patchlevel":
                        nVar.f22632i = n2Var.E0();
                        break;
                    case "version_major":
                        nVar.f22630g = n2Var.E0();
                        break;
                    case "version_minor":
                        nVar.f22631h = n2Var.E0();
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
            nVar.e(map);
            return nVar;
        }
    }

    public void e(Map<String, Object> map) {
        this.f22633j = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22629f != null) {
            h3Var.k("sdk_name").b(this.f22629f);
        }
        if (this.f22630g != null) {
            h3Var.k("version_major").e(this.f22630g);
        }
        if (this.f22631h != null) {
            h3Var.k("version_minor").e(this.f22631h);
        }
        if (this.f22632i != null) {
            h3Var.k("version_patchlevel").e(this.f22632i);
        }
        Map<String, Object> map = this.f22633j;
        if (map != null) {
            for (String str : map.keySet()) {
                h3Var.k(str).g(w1Var, this.f22633j.get(str));
            }
        }
        h3Var.d();
    }
}
