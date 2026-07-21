package io.sentry;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: ProfilingTraceData.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class m3 implements r2 {
    private String A;
    private String B;
    private String C;
    private String D;
    private final Map<String, io.sentry.profilemeasurements.a> E;
    private String F;
    private Map<String, Object> G;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final File f22494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Callable<List<Integer>> f22495g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f22496h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f22497i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f22498j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f22499k;
    private String l;
    private String m;
    private String n;
    private boolean o;
    private String p;
    private List<Integer> q;
    private String r;
    private String s;
    private String t;
    private List<n3> u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    /* JADX INFO: compiled from: ProfilingTraceData.java */
    public static final class b implements l2<m3> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public m3 a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            ConcurrentHashMap concurrentHashMap = null;
            m3 m3Var = new m3();
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "device_manufacturer":
                        String strN0 = n2Var.N0();
                        if (strN0 == null) {
                            break;
                        } else {
                            m3Var.f22498j = strN0;
                            break;
                        }
                        break;
                    case "android_api_level":
                        Integer numE0 = n2Var.E0();
                        if (numE0 == null) {
                            break;
                        } else {
                            m3Var.f22496h = numE0.intValue();
                            break;
                        }
                        break;
                    case "build_id":
                        String strN1 = n2Var.N0();
                        if (strN1 == null) {
                            break;
                        } else {
                            m3Var.t = strN1;
                            break;
                        }
                        break;
                    case "device_locale":
                        String strN2 = n2Var.N0();
                        if (strN2 == null) {
                            break;
                        } else {
                            m3Var.f22497i = strN2;
                            break;
                        }
                        break;
                    case "profile_id":
                        String strN3 = n2Var.N0();
                        if (strN3 == null) {
                            break;
                        } else {
                            m3Var.B = strN3;
                            break;
                        }
                        break;
                    case "device_os_build_number":
                        String strN4 = n2Var.N0();
                        if (strN4 == null) {
                            break;
                        } else {
                            m3Var.l = strN4;
                            break;
                        }
                        break;
                    case "device_model":
                        String strN5 = n2Var.N0();
                        if (strN5 == null) {
                            break;
                        } else {
                            m3Var.f22499k = strN5;
                            break;
                        }
                        break;
                    case "device_is_emulator":
                        Boolean boolP0 = n2Var.p0();
                        if (boolP0 == null) {
                            break;
                        } else {
                            m3Var.o = boolP0.booleanValue();
                            break;
                        }
                        break;
                    case "duration_ns":
                        String strN6 = n2Var.N0();
                        if (strN6 == null) {
                            break;
                        } else {
                            m3Var.w = strN6;
                            break;
                        }
                        break;
                    case "measurements":
                        Map mapJ0 = n2Var.J0(w1Var, new io.sentry.profilemeasurements.a.C0307a());
                        if (mapJ0 == null) {
                            break;
                        } else {
                            m3Var.E.putAll(mapJ0);
                            break;
                        }
                        break;
                    case "device_physical_memory_bytes":
                        String strN7 = n2Var.N0();
                        if (strN7 == null) {
                            break;
                        } else {
                            m3Var.r = strN7;
                            break;
                        }
                        break;
                    case "device_cpu_frequencies":
                        List list = (List) n2Var.K0();
                        if (list == null) {
                            break;
                        } else {
                            m3Var.q = list;
                            break;
                        }
                        break;
                    case "version_code":
                        String strN8 = n2Var.N0();
                        if (strN8 == null) {
                            break;
                        } else {
                            m3Var.x = strN8;
                            break;
                        }
                        break;
                    case "version_name":
                        String strN9 = n2Var.N0();
                        if (strN9 == null) {
                            break;
                        } else {
                            m3Var.y = strN9;
                            break;
                        }
                        break;
                    case "environment":
                        String strN10 = n2Var.N0();
                        if (strN10 == null) {
                            break;
                        } else {
                            m3Var.C = strN10;
                            break;
                        }
                        break;
                    case "transaction_name":
                        String strN11 = n2Var.N0();
                        if (strN11 == null) {
                            break;
                        } else {
                            m3Var.v = strN11;
                            break;
                        }
                        break;
                    case "device_os_name":
                        String strN12 = n2Var.N0();
                        if (strN12 == null) {
                            break;
                        } else {
                            m3Var.m = strN12;
                            break;
                        }
                        break;
                    case "architecture":
                        String strN13 = n2Var.N0();
                        if (strN13 == null) {
                            break;
                        } else {
                            m3Var.p = strN13;
                            break;
                        }
                        break;
                    case "transaction_id":
                        String strN14 = n2Var.N0();
                        if (strN14 == null) {
                            break;
                        } else {
                            m3Var.z = strN14;
                            break;
                        }
                        break;
                    case "device_os_version":
                        String strN15 = n2Var.N0();
                        if (strN15 == null) {
                            break;
                        } else {
                            m3Var.n = strN15;
                            break;
                        }
                        break;
                    case "truncation_reason":
                        String strN16 = n2Var.N0();
                        if (strN16 == null) {
                            break;
                        } else {
                            m3Var.D = strN16;
                            break;
                        }
                        break;
                    case "trace_id":
                        String strN17 = n2Var.N0();
                        if (strN17 == null) {
                            break;
                        } else {
                            m3Var.A = strN17;
                            break;
                        }
                        break;
                    case "platform":
                        String strN18 = n2Var.N0();
                        if (strN18 == null) {
                            break;
                        } else {
                            m3Var.s = strN18;
                            break;
                        }
                        break;
                    case "sampled_profile":
                        String strN19 = n2Var.N0();
                        if (strN19 == null) {
                            break;
                        } else {
                            m3Var.F = strN19;
                            break;
                        }
                        break;
                    case "transactions":
                        List listF0 = n2Var.F0(w1Var, new n3.a());
                        if (listF0 == null) {
                            break;
                        } else {
                            m3Var.u.addAll(listF0);
                            break;
                        }
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, strB);
                        break;
                }
            }
            m3Var.F(concurrentHashMap);
            n2Var.j();
            return m3Var;
        }
    }

    private boolean B() {
        return this.D.equals("normal") || this.D.equals("timeout") || this.D.equals("backgrounded");
    }

    static /* synthetic */ List C() throws Exception {
        return new ArrayList();
    }

    public File A() {
        return this.f22494f;
    }

    public void D() {
        try {
            this.q = this.f22495g.call();
        } catch (Throwable unused) {
        }
    }

    public void E(String str) {
        this.F = str;
    }

    public void F(Map<String, Object> map) {
        this.G = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        h3Var.k("android_api_level").g(w1Var, Integer.valueOf(this.f22496h));
        h3Var.k("device_locale").g(w1Var, this.f22497i);
        h3Var.k("device_manufacturer").b(this.f22498j);
        h3Var.k("device_model").b(this.f22499k);
        h3Var.k("device_os_build_number").b(this.l);
        h3Var.k("device_os_name").b(this.m);
        h3Var.k("device_os_version").b(this.n);
        h3Var.k("device_is_emulator").c(this.o);
        h3Var.k("architecture").g(w1Var, this.p);
        h3Var.k("device_cpu_frequencies").g(w1Var, this.q);
        h3Var.k("device_physical_memory_bytes").b(this.r);
        h3Var.k("platform").b(this.s);
        h3Var.k("build_id").b(this.t);
        h3Var.k("transaction_name").b(this.v);
        h3Var.k("duration_ns").b(this.w);
        h3Var.k("version_name").b(this.y);
        h3Var.k("version_code").b(this.x);
        if (!this.u.isEmpty()) {
            h3Var.k("transactions").g(w1Var, this.u);
        }
        h3Var.k("transaction_id").b(this.z);
        h3Var.k("trace_id").b(this.A);
        h3Var.k("profile_id").b(this.B);
        h3Var.k("environment").b(this.C);
        h3Var.k("truncation_reason").b(this.D);
        if (this.F != null) {
            h3Var.k("sampled_profile").b(this.F);
        }
        h3Var.k("measurements").g(w1Var, this.E);
        Map<String, Object> map = this.G;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.G.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    public String z() {
        return this.B;
    }

    private m3() {
        this(new File("dummy"), d3.r());
    }

    public m3(File file, e2 e2Var) {
        this(file, new ArrayList(), e2Var, "0", 0, HttpUrl.FRAGMENT_ENCODE_SET, new Callable() { // from class: io.sentry.r
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return m3.C();
            }
        }, null, null, null, null, null, null, null, null, "normal", new HashMap());
    }

    public m3(File file, List<n3> list, e2 e2Var, String str, int i2, String str2, Callable<List<Integer>> callable, String str3, String str4, String str5, Boolean bool, String str6, String str7, String str8, String str9, String str10, Map<String, io.sentry.profilemeasurements.a> map) {
        this.q = new ArrayList();
        this.F = null;
        this.f22494f = file;
        this.p = str2;
        this.f22495g = callable;
        this.f22496h = i2;
        this.f22497i = Locale.getDefault().toString();
        String str11 = HttpUrl.FRAGMENT_ENCODE_SET;
        this.f22498j = str3 != null ? str3 : HttpUrl.FRAGMENT_ENCODE_SET;
        this.f22499k = str4 != null ? str4 : HttpUrl.FRAGMENT_ENCODE_SET;
        this.n = str5 != null ? str5 : HttpUrl.FRAGMENT_ENCODE_SET;
        this.o = bool != null ? bool.booleanValue() : false;
        this.r = str6 != null ? str6 : "0";
        this.l = HttpUrl.FRAGMENT_ENCODE_SET;
        this.m = "android";
        this.s = "android";
        this.t = str7 != null ? str7 : HttpUrl.FRAGMENT_ENCODE_SET;
        this.u = list;
        this.v = e2Var.getName();
        this.w = str;
        this.x = HttpUrl.FRAGMENT_ENCODE_SET;
        this.y = str8 != null ? str8 : str11;
        this.z = e2Var.k().toString();
        this.A = e2Var.m().k().toString();
        this.B = UUID.randomUUID().toString();
        this.C = str9 != null ? str9 : "production";
        this.D = str10;
        if (!B()) {
            this.D = "normal";
        }
        this.E = map;
    }
}
