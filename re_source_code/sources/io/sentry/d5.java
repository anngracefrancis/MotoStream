package io.sentry;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: Session.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d5 implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Date f22375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Date f22376g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicInteger f22377h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f22378i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final UUID f22379j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Boolean f22380k;
    private b l;
    private Long m;
    private Double n;
    private final String o;
    private String p;
    private final String q;
    private final String r;
    private String s;
    private final Object t;
    private Map<String, Object> u;

    /* JADX INFO: compiled from: Session.java */
    public static final class a implements l2<d5> {
        private Exception c(String str, w1 w1Var) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            w1Var.b(s4.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:62:0x00fc  */
        /* JADX WARN: Code duplicated, block: B:7:0x0049  */
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public d5 a(n2 n2Var, w1 w1Var) throws Exception {
            String strN0;
            n2Var.b();
            Integer numE0 = null;
            b bVarValueOf = null;
            Date dateQ0 = null;
            Date dateQ1 = null;
            ConcurrentHashMap concurrentHashMap = null;
            String strN1 = null;
            UUID uuidFromString = null;
            Boolean boolP0 = null;
            Long lG0 = null;
            Double dT0 = null;
            String strN2 = null;
            String strN3 = null;
            String str = null;
            String strN4 = null;
            String strN5 = null;
            while (true) {
                String strN6 = str;
                String str2 = strN3;
                String str3 = strN2;
                Double d2 = dT0;
                if (n2Var.N() != io.sentry.vendor.gson.stream.b.NAME) {
                    Long l = lG0;
                    if (bVarValueOf == null) {
                        throw c("status", w1Var);
                    }
                    if (dateQ0 == null) {
                        throw c("started", w1Var);
                    }
                    if (numE0 == null) {
                        throw c("errors", w1Var);
                    }
                    if (strN4 == null) {
                        throw c("release", w1Var);
                    }
                    d5 d5Var = new d5(bVarValueOf, dateQ0, dateQ1, numE0.intValue(), strN1, uuidFromString, boolP0, l, d2, str3, str2, strN6, strN4, strN5);
                    d5Var.o(concurrentHashMap);
                    n2Var.j();
                    return d5Var;
                }
                String strB = n2Var.B();
                strB.hashCode();
                Long l2 = lG0;
                switch (strB) {
                    case "duration":
                        dT0 = n2Var.t0();
                        str = strN6;
                        strN3 = str2;
                        strN2 = str3;
                        lG0 = l2;
                        break;
                    case "started":
                        dateQ0 = n2Var.q0(w1Var);
                        str = strN6;
                        strN3 = str2;
                        strN2 = str3;
                        dT0 = d2;
                        lG0 = l2;
                        break;
                    case "errors":
                        numE0 = n2Var.E0();
                        str = strN6;
                        strN3 = str2;
                        strN2 = str3;
                        dT0 = d2;
                        lG0 = l2;
                        break;
                    case "status":
                        String strB2 = io.sentry.util.u.b(n2Var.N0());
                        if (strB2 != null) {
                            bVarValueOf = b.valueOf(strB2);
                        }
                        str = strN6;
                        strN3 = str2;
                        strN2 = str3;
                        dT0 = d2;
                        lG0 = l2;
                        break;
                    case "did":
                        strN1 = n2Var.N0();
                        str = strN6;
                        strN3 = str2;
                        strN2 = str3;
                        dT0 = d2;
                        lG0 = l2;
                        break;
                    case "seq":
                        lG0 = n2Var.G0();
                        str = strN6;
                        strN3 = str2;
                        strN2 = str3;
                        dT0 = d2;
                        break;
                    case "sid":
                        try {
                            strN0 = n2Var.N0();
                            try {
                                uuidFromString = UUID.fromString(strN0);
                            } catch (IllegalArgumentException unused) {
                                w1Var.c(s4.ERROR, "%s sid is not valid.", strN0);
                            }
                            break;
                        } catch (IllegalArgumentException unused2) {
                            strN0 = null;
                        }
                        str = strN6;
                        strN3 = str2;
                        strN2 = str3;
                        dT0 = d2;
                        lG0 = l2;
                        break;
                    case "init":
                        boolP0 = n2Var.p0();
                        str = strN6;
                        strN3 = str2;
                        strN2 = str3;
                        dT0 = d2;
                        lG0 = l2;
                        break;
                    case "timestamp":
                        dateQ1 = n2Var.q0(w1Var);
                        str = strN6;
                        strN3 = str2;
                        strN2 = str3;
                        dT0 = d2;
                        lG0 = l2;
                        break;
                    case "attrs":
                        n2Var.b();
                        strN3 = str2;
                        strN2 = str3;
                        while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                            String strB3 = n2Var.B();
                            strB3.hashCode();
                            switch (strB3) {
                                case "environment":
                                    strN6 = n2Var.N0();
                                    break;
                                case "release":
                                    strN4 = n2Var.N0();
                                    break;
                                case "ip_address":
                                    strN2 = n2Var.N0();
                                    break;
                                case "user_agent":
                                    strN3 = n2Var.N0();
                                    break;
                                default:
                                    n2Var.i0();
                                    break;
                            }
                        }
                        n2Var.j();
                        str = strN6;
                        dT0 = d2;
                        lG0 = l2;
                        break;
                    case "abnormal_mechanism":
                        strN5 = n2Var.N0();
                        str = strN6;
                        strN3 = str2;
                        strN2 = str3;
                        dT0 = d2;
                        lG0 = l2;
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, strB);
                        str = strN6;
                        strN3 = str2;
                        strN2 = str3;
                        dT0 = d2;
                        lG0 = l2;
                        break;
                }
            }
        }
    }

    /* JADX INFO: compiled from: Session.java */
    public enum b {
        Ok,
        Exited,
        Crashed,
        Abnormal
    }

    public d5(b bVar, Date date, Date date2, int i2, String str, UUID uuid, Boolean bool, Long l, Double d2, String str2, String str3, String str4, String str5, String str6) {
        this.t = new Object();
        this.l = bVar;
        this.f22375f = date;
        this.f22376g = date2;
        this.f22377h = new AtomicInteger(i2);
        this.f22378i = str;
        this.f22379j = uuid;
        this.f22380k = bool;
        this.m = l;
        this.n = d2;
        this.o = str2;
        this.p = str3;
        this.q = str4;
        this.r = str5;
        this.s = str6;
    }

    private double a(Date date) {
        double dAbs = Math.abs(date.getTime() - this.f22375f.getTime());
        Double.isNaN(dAbs);
        return dAbs / 1000.0d;
    }

    private long i(Date date) {
        long time = date.getTime();
        return time < 0 ? Math.abs(time) : time;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public d5 clone() {
        return new d5(this.l, this.f22375f, this.f22376g, this.f22377h.get(), this.f22378i, this.f22379j, this.f22380k, this.m, this.n, this.o, this.p, this.q, this.r, this.s);
    }

    public void c() {
        d(a1.c());
    }

    public void d(Date date) {
        synchronized (this.t) {
            this.f22380k = null;
            if (this.l == b.Ok) {
                this.l = b.Exited;
            }
            if (date != null) {
                this.f22376g = date;
            } else {
                this.f22376g = a1.c();
            }
            Date date2 = this.f22376g;
            if (date2 != null) {
                this.n = Double.valueOf(a(date2));
                this.m = Long.valueOf(i(this.f22376g));
            }
        }
    }

    public int e() {
        return this.f22377h.get();
    }

    public String f() {
        return this.s;
    }

    public Boolean g() {
        return this.f22380k;
    }

    public String h() {
        return this.r;
    }

    public UUID j() {
        return this.f22379j;
    }

    public Date k() {
        Date date = this.f22375f;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public b l() {
        return this.l;
    }

    public boolean m() {
        return this.l != b.Ok;
    }

    @ApiStatus.Internal
    public void n() {
        this.f22380k = Boolean.TRUE;
    }

    public void o(Map<String, Object> map) {
        this.u = map;
    }

    public boolean p(b bVar, String str, boolean z) {
        return q(bVar, str, z, null);
    }

    public boolean q(b bVar, String str, boolean z, String str2) {
        boolean z2;
        synchronized (this.t) {
            boolean z3 = false;
            z2 = true;
            if (bVar != null) {
                try {
                    this.l = bVar;
                    z3 = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (str != null) {
                this.p = str;
                z3 = true;
            }
            if (z) {
                this.f22377h.addAndGet(1);
                z3 = true;
            }
            if (str2 != null) {
                this.s = str2;
            } else {
                z2 = z3;
            }
            if (z2) {
                this.f22380k = null;
                Date dateC = a1.c();
                this.f22376g = dateC;
                if (dateC != null) {
                    this.m = Long.valueOf(i(dateC));
                }
            }
        }
        return z2;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22379j != null) {
            h3Var.k("sid").b(this.f22379j.toString());
        }
        if (this.f22378i != null) {
            h3Var.k("did").b(this.f22378i);
        }
        if (this.f22380k != null) {
            h3Var.k("init").h(this.f22380k);
        }
        h3Var.k("started").g(w1Var, this.f22375f);
        h3Var.k("status").g(w1Var, this.l.name().toLowerCase(Locale.ROOT));
        if (this.m != null) {
            h3Var.k("seq").e(this.m);
        }
        h3Var.k("errors").a(this.f22377h.intValue());
        if (this.n != null) {
            h3Var.k("duration").e(this.n);
        }
        if (this.f22376g != null) {
            h3Var.k("timestamp").g(w1Var, this.f22376g);
        }
        if (this.s != null) {
            h3Var.k("abnormal_mechanism").g(w1Var, this.s);
        }
        h3Var.k("attrs");
        h3Var.f();
        h3Var.k("release").g(w1Var, this.r);
        if (this.q != null) {
            h3Var.k("environment").g(w1Var, this.q);
        }
        if (this.o != null) {
            h3Var.k("ip_address").g(w1Var, this.o);
        }
        if (this.p != null) {
            h3Var.k("user_agent").g(w1Var, this.p);
        }
        h3Var.d();
        Map<String, Object> map = this.u;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.u.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    public d5(String str, io.sentry.protocol.a0 a0Var, String str2, String str3) {
        this(b.Ok, a1.c(), a1.c(), 0, str, UUID.randomUUID(), Boolean.TRUE, null, null, a0Var != null ? a0Var.l() : null, null, str2, str3, null);
    }
}
