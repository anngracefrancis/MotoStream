package io.sentry;

import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.timeline.view.follow.TimeLineFollowFragment;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: TraceContext.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Experimental
public final class o5 implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final io.sentry.protocol.q f22528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f22529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f22530h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f22531i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f22532j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f22533k;
    private final String l;
    private final String m;
    private final String n;
    private Map<String, Object> o;

    /* JADX INFO: compiled from: TraceContext.java */
    public static final class b implements l2<o5> {
        private Exception c(String str, w1 w1Var) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            w1Var.b(s4.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        /* JADX WARN: Code duplicated, block: B:71:0x0112 A[PHI: r4
          0x0112: PHI (r4v2 java.lang.String) = (r4v1 java.lang.String), (r4v4 java.lang.String) binds: [B:66:0x0101, B:69:0x0109] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public o5 a(n2 n2Var, w1 w1Var) throws Exception {
            String str;
            String strB;
            n2Var.b();
            c cVar = null;
            String strA = null;
            io.sentry.protocol.q qVarA = null;
            String strN0 = null;
            String strJ = null;
            String strN1 = null;
            String strN2 = null;
            String strN3 = null;
            String strN4 = null;
            String strN5 = null;
            ConcurrentHashMap concurrentHashMap = null;
            while (true) {
                String str2 = strN5;
                if (n2Var.N() != io.sentry.vendor.gson.stream.b.NAME) {
                    if (qVarA == null) {
                        throw c("trace_id", w1Var);
                    }
                    if (strJ == null) {
                        throw c("public_key", w1Var);
                    }
                    if (cVar == null) {
                        str = strA;
                        strB = strN0;
                    } else {
                        if (strA == null) {
                            strA = cVar.a();
                        }
                        if (strN0 == null) {
                            strB = cVar.b();
                            str = strA;
                        } else {
                            str = strA;
                            strB = strN0;
                        }
                    }
                    o5 o5Var = new o5(qVarA, strJ, strN1, strN2, str, strB, strN3, strN4, str2);
                    o5Var.b(concurrentHashMap);
                    n2Var.j();
                    return o5Var;
                }
                String strB2 = n2Var.B();
                strB2.hashCode();
                switch (strB2) {
                    case "user_segment":
                        strN0 = n2Var.N0();
                        break;
                    case "user_id":
                        strA = n2Var.N0();
                        break;
                    case "environment":
                        strN2 = n2Var.N0();
                        break;
                    case "user":
                        cVar = (c) n2Var.M0(w1Var, new c.a());
                        break;
                    case "sample_rate":
                        strN4 = n2Var.N0();
                        break;
                    case "release":
                        strN1 = n2Var.N0();
                        break;
                    case "trace_id":
                        qVarA = new io.sentry.protocol.q.a().a(n2Var, w1Var);
                        break;
                    case "sampled":
                        strN5 = n2Var.N0();
                        continue;
                        break;
                    case "public_key":
                        strJ = n2Var.J();
                        break;
                    case "transaction":
                        strN3 = n2Var.N0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, strB2);
                        break;
                }
                strN5 = str2;
            }
        }
    }

    /* JADX INFO: compiled from: TraceContext.java */
    @Deprecated
    private static final class c {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f22534b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Map<String, Object> f22535c;

        /* JADX INFO: compiled from: TraceContext.java */
        public static final class a implements l2<c> {
            @Override // io.sentry.l2
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public c a(n2 n2Var, w1 w1Var) throws Exception {
                n2Var.b();
                String strN0 = null;
                String strN1 = null;
                ConcurrentHashMap concurrentHashMap = null;
                while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                    String strB = n2Var.B();
                    strB.hashCode();
                    if (strB.equals(DeepLinkIntentReceiver.DeepLinksKeys.ID)) {
                        strN0 = n2Var.N0();
                    } else if (strB.equals("segment")) {
                        strN1 = n2Var.N0();
                    } else {
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, strB);
                    }
                }
                c cVar = new c(strN0, strN1);
                cVar.c(concurrentHashMap);
                n2Var.j();
                return cVar;
            }
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.f22534b;
        }

        public void c(Map<String, Object> map) {
            this.f22535c = map;
        }

        private c(String str, String str2) {
            this.a = str;
            this.f22534b = str2;
        }
    }

    o5(io.sentry.protocol.q qVar, String str) {
        this(qVar, str, null, null, null, null, null, null, null);
    }

    public String a() {
        return this.m;
    }

    public void b(Map<String, Object> map) {
        this.o = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        h3Var.k("trace_id").g(w1Var, this.f22528f);
        h3Var.k("public_key").b(this.f22529g);
        if (this.f22530h != null) {
            h3Var.k("release").b(this.f22530h);
        }
        if (this.f22531i != null) {
            h3Var.k("environment").b(this.f22531i);
        }
        if (this.f22532j != null) {
            h3Var.k(TimeLineFollowFragment.BundleKeys.USER_ID).b(this.f22532j);
        }
        if (this.f22533k != null) {
            h3Var.k("user_segment").b(this.f22533k);
        }
        if (this.l != null) {
            h3Var.k("transaction").b(this.l);
        }
        if (this.m != null) {
            h3Var.k("sample_rate").b(this.m);
        }
        if (this.n != null) {
            h3Var.k("sampled").b(this.n);
        }
        Map<String, Object> map = this.o;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.o.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    o5(io.sentry.protocol.q qVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.f22528f = qVar;
        this.f22529g = str;
        this.f22530h = str2;
        this.f22531i = str3;
        this.f22532j = str4;
        this.f22533k = str5;
        this.l = str6;
        this.m = str7;
        this.n = str8;
    }
}
