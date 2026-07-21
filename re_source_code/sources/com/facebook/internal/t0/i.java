package com.facebook.internal.t0;

import android.os.Build;
import com.facebook.internal.p0;
import java.io.File;
import java.util.Arrays;
import kotlin.jvm.internal.m;
import kotlin.text.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: InstrumentData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public static final b a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f9868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONArray f9869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f9870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f9871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f9872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Long f9873h;

    /* JADX INFO: compiled from: InstrumentData.kt */
    public static final class a {
        public static final a a = new a();

        private a() {
        }

        public static final i a(String str, String str2) {
            return new i(str, str2, (kotlin.jvm.internal.g) null);
        }

        public static final i b(Throwable th, c cVar) {
            m.f(cVar, "t");
            return new i(th, cVar, (kotlin.jvm.internal.g) null);
        }

        public static final i c(JSONArray jSONArray) {
            m.f(jSONArray, "features");
            return new i(jSONArray, (kotlin.jvm.internal.g) null);
        }

        public static final i d(File file) {
            m.f(file, "file");
            return new i(file, (kotlin.jvm.internal.g) null);
        }
    }

    /* JADX INFO: compiled from: InstrumentData.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final c b(String str) {
            if (u.E(str, "crash_log_", false, 2, null)) {
                return c.CrashReport;
            }
            if (u.E(str, "shield_log_", false, 2, null)) {
                return c.CrashShield;
            }
            if (u.E(str, "thread_check_log_", false, 2, null)) {
                return c.ThreadCheck;
            }
            if (u.E(str, "analysis_log_", false, 2, null)) {
                return c.Analysis;
            }
            return u.E(str, "anr_log_", false, 2, null) ? c.AnrReport : c.Unknown;
        }
    }

    /* JADX INFO: compiled from: InstrumentData.kt */
    public enum c {
        Unknown,
        Analysis,
        AnrReport,
        CrashReport,
        CrashShield,
        ThreadCheck;

        /* JADX INFO: compiled from: InstrumentData.kt */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[c.valuesCustom().length];
                iArr[c.Analysis.ordinal()] = 1;
                iArr[c.AnrReport.ordinal()] = 2;
                iArr[c.CrashReport.ordinal()] = 3;
                iArr[c.CrashShield.ordinal()] = 4;
                iArr[c.ThreadCheck.ordinal()] = 5;
                a = iArr;
            }
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static c[] valuesCustom() {
            c[] cVarArrValuesCustom = values();
            return (c[]) Arrays.copyOf(cVarArrValuesCustom, cVarArrValuesCustom.length);
        }

        public final String k() {
            int i2 = a.a[ordinal()];
            if (i2 == 1) {
                return "analysis_log_";
            }
            if (i2 == 2) {
                return "anr_log_";
            }
            if (i2 == 3) {
                return "crash_log_";
            }
            if (i2 != 4) {
                return i2 != 5 ? "Unknown" : "thread_check_log_";
            }
            return "shield_log_";
        }

        @Override // java.lang.Enum
        public String toString() {
            int i2 = a.a[ordinal()];
            if (i2 == 1) {
                return "Analysis";
            }
            if (i2 == 2) {
                return "AnrReport";
            }
            if (i2 == 3) {
                return "CrashReport";
            }
            if (i2 != 4) {
                return i2 != 5 ? "Unknown" : "ThreadCheck";
            }
            return "CrashShield";
        }
    }

    /* JADX INFO: compiled from: InstrumentData.kt */
    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.valuesCustom().length];
            iArr[c.Analysis.ordinal()] = 1;
            iArr[c.AnrReport.ordinal()] = 2;
            iArr[c.CrashReport.ordinal()] = 3;
            iArr[c.CrashShield.ordinal()] = 4;
            iArr[c.ThreadCheck.ordinal()] = 5;
            a = iArr;
        }
    }

    public /* synthetic */ i(File file, kotlin.jvm.internal.g gVar) {
        this(file);
    }

    public /* synthetic */ i(String str, String str2, kotlin.jvm.internal.g gVar) {
        this(str, str2);
    }

    public /* synthetic */ i(Throwable th, c cVar, kotlin.jvm.internal.g gVar) {
        this(th, cVar);
    }

    private i(JSONArray jSONArray) {
        this.f9868c = c.Analysis;
        this.f9873h = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        this.f9869d = jSONArray;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("analysis_log_");
        stringBuffer.append(String.valueOf(this.f9873h));
        stringBuffer.append(".json");
        String string = stringBuffer.toString();
        m.e(string, "StringBuffer()\n            .append(InstrumentUtility.ANALYSIS_REPORT_PREFIX)\n            .append(timestamp.toString())\n            .append(\".json\")\n            .toString()");
        this.f9867b = string;
    }

    public /* synthetic */ i(JSONArray jSONArray, kotlin.jvm.internal.g gVar) {
        this(jSONArray);
    }

    private final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = this.f9869d;
            if (jSONArray != null) {
                jSONObject.put("feature_names", jSONArray);
            }
            Long l = this.f9873h;
            if (l != null) {
                jSONObject.put("timestamp", l);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private final JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_model", Build.MODEL);
            String str = this.f9870e;
            if (str != null) {
                jSONObject.put("app_version", str);
            }
            Long l = this.f9873h;
            if (l != null) {
                jSONObject.put("timestamp", l);
            }
            String str2 = this.f9871f;
            if (str2 != null) {
                jSONObject.put("reason", str2);
            }
            String str3 = this.f9872g;
            if (str3 != null) {
                jSONObject.put("callstack", str3);
            }
            c cVar = this.f9868c;
            if (cVar != null) {
                jSONObject.put("type", cVar);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private final JSONObject e() {
        c cVar = this.f9868c;
        int i2 = cVar == null ? -1 : d.a[cVar.ordinal()];
        if (i2 == 1) {
            return c();
        }
        if (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
            return d();
        }
        return null;
    }

    public final void a() {
        k kVar = k.a;
        k.a(this.f9867b);
    }

    public final int b(i iVar) {
        m.f(iVar, "data");
        Long l = this.f9873h;
        if (l == null) {
            return -1;
        }
        long jLongValue = l.longValue();
        Long l2 = iVar.f9873h;
        if (l2 == null) {
            return 1;
        }
        return m.i(l2.longValue(), jLongValue);
    }

    public final boolean f() {
        c cVar = this.f9868c;
        int i2 = cVar == null ? -1 : d.a[cVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if ((i2 != 3 && i2 != 4 && i2 != 5) || this.f9872g == null || this.f9873h == null) {
                    return false;
                }
            } else if (this.f9872g == null || this.f9871f == null || this.f9873h == null) {
                return false;
            }
        } else if (this.f9869d == null || this.f9873h == null) {
            return false;
        }
        return true;
    }

    public final void g() {
        if (f()) {
            k kVar = k.a;
            k.t(this.f9867b, toString());
        }
    }

    public String toString() {
        JSONObject jSONObjectE = e();
        if (jSONObjectE == null) {
            String string = new JSONObject().toString();
            m.e(string, "JSONObject().toString()");
            return string;
        }
        String string2 = jSONObjectE.toString();
        m.e(string2, "params.toString()");
        return string2;
    }

    private i(Throwable th, c cVar) {
        this.f9868c = cVar;
        p0 p0Var = p0.a;
        this.f9870e = p0.t();
        k kVar = k.a;
        this.f9871f = k.b(th);
        this.f9872g = k.e(th);
        this.f9873h = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cVar.k());
        stringBuffer.append(String.valueOf(this.f9873h));
        stringBuffer.append(".json");
        String string = stringBuffer.toString();
        m.e(string, "StringBuffer().append(t.logPrefix).append(timestamp.toString()).append(\".json\").toString()");
        this.f9867b = string;
    }

    private i(String str, String str2) {
        this.f9868c = c.AnrReport;
        p0 p0Var = p0.a;
        this.f9870e = p0.t();
        this.f9871f = str;
        this.f9872g = str2;
        this.f9873h = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("anr_log_");
        stringBuffer.append(String.valueOf(this.f9873h));
        stringBuffer.append(".json");
        String string = stringBuffer.toString();
        m.e(string, "StringBuffer()\n            .append(InstrumentUtility.ANR_REPORT_PREFIX)\n            .append(timestamp.toString())\n            .append(\".json\")\n            .toString()");
        this.f9867b = string;
    }

    private i(File file) {
        String name = file.getName();
        m.e(name, "file.name");
        this.f9867b = name;
        this.f9868c = a.b(name);
        k kVar = k.a;
        JSONObject jSONObjectR = k.r(this.f9867b, true);
        if (jSONObjectR != null) {
            this.f9873h = Long.valueOf(jSONObjectR.optLong("timestamp", 0L));
            this.f9870e = jSONObjectR.optString("app_version", null);
            this.f9871f = jSONObjectR.optString("reason", null);
            this.f9872g = jSONObjectR.optString("callstack", null);
            this.f9869d = jSONObjectR.optJSONArray("feature_names");
        }
    }
}
