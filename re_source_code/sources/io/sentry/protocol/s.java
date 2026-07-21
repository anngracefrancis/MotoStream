package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SentryRuntime.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f22650f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f22651g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f22652h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<String, Object> f22653i;

    /* JADX INFO: compiled from: SentryRuntime.java */
    public static final class a implements l2<s> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public s a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            s sVar = new s();
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "raw_description":
                        sVar.f22652h = n2Var.N0();
                        break;
                    case "name":
                        sVar.f22650f = n2Var.N0();
                        break;
                    case "version":
                        sVar.f22651g = n2Var.N0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, strB);
                        break;
                }
            }
            sVar.g(concurrentHashMap);
            n2Var.j();
            return sVar;
        }
    }

    public s() {
    }

    public String d() {
        return this.f22650f;
    }

    public String e() {
        return this.f22651g;
    }

    public void f(String str) {
        this.f22650f = str;
    }

    public void g(Map<String, Object> map) {
        this.f22653i = map;
    }

    public void h(String str) {
        this.f22651g = str;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22650f != null) {
            h3Var.k("name").b(this.f22650f);
        }
        if (this.f22651g != null) {
            h3Var.k("version").b(this.f22651g);
        }
        if (this.f22652h != null) {
            h3Var.k("raw_description").b(this.f22652h);
        }
        Map<String, Object> map = this.f22653i;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f22653i.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    s(s sVar) {
        this.f22650f = sVar.f22650f;
        this.f22651g = sVar.f22651g;
        this.f22652h = sVar.f22652h;
        this.f22653i = io.sentry.util.i.b(sVar.f22653i);
    }
}
