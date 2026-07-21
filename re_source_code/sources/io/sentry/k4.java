package io.sentry;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: SentryEnvelopeItemHeader.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class k4 implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f22464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f22465g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final r4 f22466h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f22467i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Callable<Integer> f22468j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f22469k;
    private Map<String, Object> l;

    /* JADX INFO: compiled from: SentryEnvelopeItemHeader.java */
    public static final class a implements l2<k4> {
        private Exception c(String str, w1 w1Var) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            w1Var.b(s4.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public k4 a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            HashMap map = null;
            r4 r4Var = null;
            String strN0 = null;
            String strN1 = null;
            String strN2 = null;
            int iZ = 0;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "length":
                        iZ = n2Var.z();
                        break;
                    case "filename":
                        strN1 = n2Var.N0();
                        break;
                    case "attachment_type":
                        strN2 = n2Var.N0();
                        break;
                    case "type":
                        r4Var = (r4) n2Var.M0(w1Var, new r4.a());
                        break;
                    case "content_type":
                        strN0 = n2Var.N0();
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        n2Var.R0(w1Var, map, strB);
                        break;
                }
            }
            if (r4Var == null) {
                throw c("type", w1Var);
            }
            k4 k4Var = new k4(r4Var, iZ, strN0, strN1, strN2);
            k4Var.c(map);
            n2Var.j();
            return k4Var;
        }
    }

    @ApiStatus.Internal
    public k4(r4 r4Var, int i2, String str, String str2, String str3) {
        this.f22466h = (r4) io.sentry.util.q.c(r4Var, "type is required");
        this.f22464f = str;
        this.f22467i = i2;
        this.f22465g = str2;
        this.f22468j = null;
        this.f22469k = str3;
    }

    public int a() {
        Callable<Integer> callable = this.f22468j;
        if (callable == null) {
            return this.f22467i;
        }
        try {
            return callable.call().intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public r4 b() {
        return this.f22466h;
    }

    public void c(Map<String, Object> map) {
        this.l = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22464f != null) {
            h3Var.k("content_type").b(this.f22464f);
        }
        if (this.f22465g != null) {
            h3Var.k("filename").b(this.f22465g);
        }
        h3Var.k("type").g(w1Var, this.f22466h);
        if (this.f22469k != null) {
            h3Var.k("attachment_type").b(this.f22469k);
        }
        h3Var.k("length").a(a());
        Map<String, Object> map = this.l;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.l.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    k4(r4 r4Var, Callable<Integer> callable, String str, String str2, String str3) {
        this.f22466h = (r4) io.sentry.util.q.c(r4Var, "type is required");
        this.f22464f = str;
        this.f22467i = -1;
        this.f22465g = str2;
        this.f22468j = callable;
        this.f22469k = str3;
    }

    k4(r4 r4Var, Callable<Integer> callable, String str, String str2) {
        this(r4Var, callable, str, str2, (String) null);
    }
}
