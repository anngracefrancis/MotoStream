package com.facebook.internal.t0.o;

import com.facebook.internal.t0.k;
import java.io.File;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ErrorReportData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Long f9897d;

    /* JADX INFO: compiled from: ErrorReportData.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public d(String str) {
        this.f9897d = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        this.f9896c = str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("error_log_");
        Long l = this.f9897d;
        if (l == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        stringBuffer.append(l.longValue());
        stringBuffer.append(".json");
        String string = stringBuffer.toString();
        m.e(string, "StringBuffer()\n            .append(InstrumentUtility.ERROR_REPORT_PREFIX)\n            .append(timestamp as Long)\n            .append(\".json\")\n            .toString()");
        this.f9895b = string;
    }

    public final void a() {
        k kVar = k.a;
        k.a(this.f9895b);
    }

    public final int b(d dVar) {
        m.f(dVar, "data");
        Long l = this.f9897d;
        if (l == null) {
            return -1;
        }
        long jLongValue = l.longValue();
        Long l2 = dVar.f9897d;
        if (l2 == null) {
            return 1;
        }
        return m.i(l2.longValue(), jLongValue);
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            Long l = this.f9897d;
            if (l != null) {
                jSONObject.put("timestamp", l);
            }
            jSONObject.put("error_message", this.f9896c);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean d() {
        return (this.f9896c == null || this.f9897d == null) ? false : true;
    }

    public final void e() {
        if (d()) {
            k kVar = k.a;
            k.t(this.f9895b, toString());
        }
    }

    public String toString() {
        JSONObject jSONObjectC = c();
        if (jSONObjectC == null) {
            return super.toString();
        }
        String string = jSONObjectC.toString();
        m.e(string, "params.toString()");
        return string;
    }

    public d(File file) {
        m.f(file, "file");
        String name = file.getName();
        m.e(name, "file.name");
        this.f9895b = name;
        k kVar = k.a;
        JSONObject jSONObjectR = k.r(name, true);
        if (jSONObjectR != null) {
            this.f9897d = Long.valueOf(jSONObjectR.optLong("timestamp", 0L));
            this.f9896c = jSONObjectR.optString("error_message", null);
        }
    }
}
