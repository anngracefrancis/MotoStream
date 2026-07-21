package io.sentry.protocol;

import cm.aptoide.pt.DeepLinkIntentReceiver;
import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: Device.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements r2 {
    private Integer A;
    private Float B;
    private Integer C;
    private Date D;
    private TimeZone E;
    private String F;

    @Deprecated
    private String G;
    private String H;
    private String I;
    private Float J;
    private Integer K;
    private Double L;
    private String M;
    private Map<String, Object> N;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f22582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f22583g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f22584h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f22585i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f22586j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f22587k;
    private String[] l;
    private Float m;
    private Boolean n;
    private Boolean o;
    private b p;
    private Boolean q;
    private Long r;
    private Long s;
    private Long t;
    private Boolean u;
    private Long v;
    private Long w;
    private Long x;
    private Long y;
    private Integer z;

    /* JADX INFO: compiled from: Device.java */
    public static final class a implements l2<e> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public e a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            e eVar = new e();
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "timezone":
                        eVar.E = n2Var.Q0(w1Var);
                        break;
                    case "boot_time":
                        if (n2Var.N() != io.sentry.vendor.gson.stream.b.STRING) {
                            break;
                        } else {
                            eVar.D = n2Var.q0(w1Var);
                            break;
                        }
                        break;
                    case "simulator":
                        eVar.q = n2Var.p0();
                        break;
                    case "manufacturer":
                        eVar.f22583g = n2Var.N0();
                        break;
                    case "language":
                        eVar.G = n2Var.N0();
                        break;
                    case "processor_count":
                        eVar.K = n2Var.E0();
                        break;
                    case "orientation":
                        eVar.p = (b) n2Var.M0(w1Var, new b.a());
                        break;
                    case "battery_temperature":
                        eVar.J = n2Var.y0();
                        break;
                    case "family":
                        eVar.f22585i = n2Var.N0();
                        break;
                    case "locale":
                        eVar.H = n2Var.N0();
                        break;
                    case "online":
                        eVar.o = n2Var.p0();
                        break;
                    case "battery_level":
                        eVar.m = n2Var.y0();
                        break;
                    case "model_id":
                        eVar.f22587k = n2Var.N0();
                        break;
                    case "screen_density":
                        eVar.B = n2Var.y0();
                        break;
                    case "screen_dpi":
                        eVar.C = n2Var.E0();
                        break;
                    case "free_memory":
                        eVar.s = n2Var.G0();
                        break;
                    case "id":
                        eVar.F = n2Var.N0();
                        break;
                    case "name":
                        eVar.f22582f = n2Var.N0();
                        break;
                    case "low_memory":
                        eVar.u = n2Var.p0();
                        break;
                    case "archs":
                        List list = (List) n2Var.K0();
                        if (list == null) {
                            break;
                        } else {
                            String[] strArr = new String[list.size()];
                            list.toArray(strArr);
                            eVar.l = strArr;
                            break;
                        }
                        break;
                    case "brand":
                        eVar.f22584h = n2Var.N0();
                        break;
                    case "model":
                        eVar.f22586j = n2Var.N0();
                        break;
                    case "cpu_description":
                        eVar.M = n2Var.N0();
                        break;
                    case "processor_frequency":
                        eVar.L = n2Var.t0();
                        break;
                    case "connection_type":
                        eVar.I = n2Var.N0();
                        break;
                    case "screen_width_pixels":
                        eVar.z = n2Var.E0();
                        break;
                    case "external_storage_size":
                        eVar.x = n2Var.G0();
                        break;
                    case "storage_size":
                        eVar.v = n2Var.G0();
                        break;
                    case "usable_memory":
                        eVar.t = n2Var.G0();
                        break;
                    case "memory_size":
                        eVar.r = n2Var.G0();
                        break;
                    case "charging":
                        eVar.n = n2Var.p0();
                        break;
                    case "external_free_storage":
                        eVar.y = n2Var.G0();
                        break;
                    case "free_storage":
                        eVar.w = n2Var.G0();
                        break;
                    case "screen_height_pixels":
                        eVar.A = n2Var.E0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, strB);
                        break;
                }
            }
            eVar.s0(concurrentHashMap);
            n2Var.j();
            return eVar;
        }
    }

    /* JADX INFO: compiled from: Device.java */
    public enum b implements r2 {
        PORTRAIT,
        LANDSCAPE;

        /* JADX INFO: compiled from: Device.java */
        public static final class a implements l2<b> {
            @Override // io.sentry.l2
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public b a(n2 n2Var, w1 w1Var) throws Exception {
                return b.valueOf(n2Var.J().toUpperCase(Locale.ROOT));
            }
        }

        @Override // io.sentry.r2
        public void serialize(h3 h3Var, w1 w1Var) throws IOException {
            h3Var.b(toString().toLowerCase(Locale.ROOT));
        }
    }

    public e() {
    }

    public String I() {
        return this.I;
    }

    public String J() {
        return this.F;
    }

    public String K() {
        return this.G;
    }

    public String L() {
        return this.H;
    }

    public void M(String[] strArr) {
        this.l = strArr;
    }

    public void N(Float f2) {
        this.m = f2;
    }

    public void O(Float f2) {
        this.J = f2;
    }

    public void P(Date date) {
        this.D = date;
    }

    public void Q(String str) {
        this.f22584h = str;
    }

    public void R(Boolean bool) {
        this.n = bool;
    }

    public void S(String str) {
        this.I = str;
    }

    public void T(Long l) {
        this.y = l;
    }

    public void U(Long l) {
        this.x = l;
    }

    public void V(String str) {
        this.f22585i = str;
    }

    public void W(Long l) {
        this.s = l;
    }

    public void X(Long l) {
        this.w = l;
    }

    public void Y(String str) {
        this.F = str;
    }

    public void Z(String str) {
        this.G = str;
    }

    public void a0(String str) {
        this.H = str;
    }

    public void b0(Boolean bool) {
        this.u = bool;
    }

    public void c0(String str) {
        this.f22583g = str;
    }

    public void d0(Long l) {
        this.r = l;
    }

    public void e0(String str) {
        this.f22586j = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return io.sentry.util.q.a(this.f22582f, eVar.f22582f) && io.sentry.util.q.a(this.f22583g, eVar.f22583g) && io.sentry.util.q.a(this.f22584h, eVar.f22584h) && io.sentry.util.q.a(this.f22585i, eVar.f22585i) && io.sentry.util.q.a(this.f22586j, eVar.f22586j) && io.sentry.util.q.a(this.f22587k, eVar.f22587k) && Arrays.equals(this.l, eVar.l) && io.sentry.util.q.a(this.m, eVar.m) && io.sentry.util.q.a(this.n, eVar.n) && io.sentry.util.q.a(this.o, eVar.o) && this.p == eVar.p && io.sentry.util.q.a(this.q, eVar.q) && io.sentry.util.q.a(this.r, eVar.r) && io.sentry.util.q.a(this.s, eVar.s) && io.sentry.util.q.a(this.t, eVar.t) && io.sentry.util.q.a(this.u, eVar.u) && io.sentry.util.q.a(this.v, eVar.v) && io.sentry.util.q.a(this.w, eVar.w) && io.sentry.util.q.a(this.x, eVar.x) && io.sentry.util.q.a(this.y, eVar.y) && io.sentry.util.q.a(this.z, eVar.z) && io.sentry.util.q.a(this.A, eVar.A) && io.sentry.util.q.a(this.B, eVar.B) && io.sentry.util.q.a(this.C, eVar.C) && io.sentry.util.q.a(this.D, eVar.D) && io.sentry.util.q.a(this.F, eVar.F) && io.sentry.util.q.a(this.G, eVar.G) && io.sentry.util.q.a(this.H, eVar.H) && io.sentry.util.q.a(this.I, eVar.I) && io.sentry.util.q.a(this.J, eVar.J) && io.sentry.util.q.a(this.K, eVar.K) && io.sentry.util.q.a(this.L, eVar.L) && io.sentry.util.q.a(this.M, eVar.M);
    }

    public void f0(String str) {
        this.f22587k = str;
    }

    public void g0(String str) {
        this.f22582f = str;
    }

    public void h0(Boolean bool) {
        this.o = bool;
    }

    public int hashCode() {
        return (io.sentry.util.q.b(this.f22582f, this.f22583g, this.f22584h, this.f22585i, this.f22586j, this.f22587k, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E, this.F, this.G, this.H, this.I, this.J, this.K, this.L, this.M) * 31) + Arrays.hashCode(this.l);
    }

    public void i0(b bVar) {
        this.p = bVar;
    }

    public void j0(Integer num) {
        this.K = num;
    }

    public void k0(Double d2) {
        this.L = d2;
    }

    public void l0(Float f2) {
        this.B = f2;
    }

    public void m0(Integer num) {
        this.C = num;
    }

    public void n0(Integer num) {
        this.A = num;
    }

    public void o0(Integer num) {
        this.z = num;
    }

    public void p0(Boolean bool) {
        this.q = bool;
    }

    public void q0(Long l) {
        this.v = l;
    }

    public void r0(TimeZone timeZone) {
        this.E = timeZone;
    }

    public void s0(Map<String, Object> map) {
        this.N = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22582f != null) {
            h3Var.k("name").b(this.f22582f);
        }
        if (this.f22583g != null) {
            h3Var.k("manufacturer").b(this.f22583g);
        }
        if (this.f22584h != null) {
            h3Var.k("brand").b(this.f22584h);
        }
        if (this.f22585i != null) {
            h3Var.k("family").b(this.f22585i);
        }
        if (this.f22586j != null) {
            h3Var.k("model").b(this.f22586j);
        }
        if (this.f22587k != null) {
            h3Var.k("model_id").b(this.f22587k);
        }
        if (this.l != null) {
            h3Var.k("archs").g(w1Var, this.l);
        }
        if (this.m != null) {
            h3Var.k("battery_level").e(this.m);
        }
        if (this.n != null) {
            h3Var.k("charging").h(this.n);
        }
        if (this.o != null) {
            h3Var.k("online").h(this.o);
        }
        if (this.p != null) {
            h3Var.k("orientation").g(w1Var, this.p);
        }
        if (this.q != null) {
            h3Var.k("simulator").h(this.q);
        }
        if (this.r != null) {
            h3Var.k("memory_size").e(this.r);
        }
        if (this.s != null) {
            h3Var.k("free_memory").e(this.s);
        }
        if (this.t != null) {
            h3Var.k("usable_memory").e(this.t);
        }
        if (this.u != null) {
            h3Var.k("low_memory").h(this.u);
        }
        if (this.v != null) {
            h3Var.k("storage_size").e(this.v);
        }
        if (this.w != null) {
            h3Var.k("free_storage").e(this.w);
        }
        if (this.x != null) {
            h3Var.k("external_storage_size").e(this.x);
        }
        if (this.y != null) {
            h3Var.k("external_free_storage").e(this.y);
        }
        if (this.z != null) {
            h3Var.k("screen_width_pixels").e(this.z);
        }
        if (this.A != null) {
            h3Var.k("screen_height_pixels").e(this.A);
        }
        if (this.B != null) {
            h3Var.k("screen_density").e(this.B);
        }
        if (this.C != null) {
            h3Var.k("screen_dpi").e(this.C);
        }
        if (this.D != null) {
            h3Var.k("boot_time").g(w1Var, this.D);
        }
        if (this.E != null) {
            h3Var.k("timezone").g(w1Var, this.E);
        }
        if (this.F != null) {
            h3Var.k(DeepLinkIntentReceiver.DeepLinksKeys.ID).b(this.F);
        }
        if (this.G != null) {
            h3Var.k("language").b(this.G);
        }
        if (this.I != null) {
            h3Var.k("connection_type").b(this.I);
        }
        if (this.J != null) {
            h3Var.k("battery_temperature").e(this.J);
        }
        if (this.H != null) {
            h3Var.k("locale").b(this.H);
        }
        if (this.K != null) {
            h3Var.k("processor_count").e(this.K);
        }
        if (this.L != null) {
            h3Var.k("processor_frequency").e(this.L);
        }
        if (this.M != null) {
            h3Var.k("cpu_description").b(this.M);
        }
        Map<String, Object> map = this.N;
        if (map != null) {
            for (String str : map.keySet()) {
                h3Var.k(str).g(w1Var, this.N.get(str));
            }
        }
        h3Var.d();
    }

    e(e eVar) {
        this.f22582f = eVar.f22582f;
        this.f22583g = eVar.f22583g;
        this.f22584h = eVar.f22584h;
        this.f22585i = eVar.f22585i;
        this.f22586j = eVar.f22586j;
        this.f22587k = eVar.f22587k;
        this.n = eVar.n;
        this.o = eVar.o;
        this.p = eVar.p;
        this.q = eVar.q;
        this.r = eVar.r;
        this.s = eVar.s;
        this.t = eVar.t;
        this.u = eVar.u;
        this.v = eVar.v;
        this.w = eVar.w;
        this.x = eVar.x;
        this.y = eVar.y;
        this.z = eVar.z;
        this.A = eVar.A;
        this.B = eVar.B;
        this.C = eVar.C;
        this.D = eVar.D;
        this.F = eVar.F;
        this.G = eVar.G;
        this.I = eVar.I;
        this.J = eVar.J;
        this.m = eVar.m;
        String[] strArr = eVar.l;
        this.l = strArr != null ? (String[]) strArr.clone() : null;
        this.H = eVar.H;
        TimeZone timeZone = eVar.E;
        this.E = timeZone != null ? (TimeZone) timeZone.clone() : null;
        this.K = eVar.K;
        this.L = eVar.L;
        this.M = eVar.M;
        this.N = io.sentry.util.i.b(eVar.N);
    }
}
