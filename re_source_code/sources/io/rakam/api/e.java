package io.rakam.api;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Diagnostics.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static final h a = h.d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static e f21935b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile String f21937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile OkHttpClient f21938e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile String f21939f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    k f21942i = new k("diagnosticThread");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    volatile boolean f21936c = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f21940g = 50;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    String f21941h = "https://diagnostics.rakam.io/event/batch";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    List<String> f21943j = new ArrayList(this.f21940g);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Map<String, JSONObject> f21944k = new HashMap(this.f21940g);

    /* JADX INFO: compiled from: Diagnostics.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f21945f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Throwable f21946g;

        a(String str, Throwable th) {
            this.f21945f = str;
            this.f21946g = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = e.this.f21944k.get(this.f21945f);
            try {
                if (jSONObject != null) {
                    jSONObject.put("count", jSONObject.optInt("count", 0) + 1);
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("error", g.i0(this.f21945f));
                jSONObject2.put("timestamp", System.currentTimeMillis());
                jSONObject2.put("device_id", e.this.f21939f);
                jSONObject2.put("count", 1);
                Throwable th = this.f21946g;
                if (th != null) {
                    String stackTraceString = Log.getStackTraceString(th);
                    if (!j.d(stackTraceString)) {
                        jSONObject2.put("stack_trace", g.i0(stackTraceString));
                    }
                }
                if (e.this.f21943j.size() >= e.this.f21940g) {
                    for (int i2 = 0; i2 < 5; i2++) {
                        e.this.f21944k.remove(e.this.f21943j.remove(0));
                    }
                }
                e.this.f21944k.put(this.f21945f, jSONObject2);
                e.this.f21943j.add(this.f21945f);
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX INFO: compiled from: Diagnostics.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f21943j.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList(e.this.f21943j.size());
            Iterator<String> it = e.this.f21943j.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add(new JSONObject().put("properties", e.this.f21944k.get(it.next())).put("collection", "android_sdk_error"));
                } catch (JSONException e2) {
                    e.a.b("RakamDiagnostics", "Unable to serialize events: " + e2.getMessage());
                }
            }
            if (new JSONArray((Collection) arrayList).length() > 0) {
                e.this.h(new JSONArray((Collection) arrayList));
            }
        }
    }

    private e() {
        this.f21942i.start();
    }

    static synchronized e e() {
        if (f21935b == null) {
            f21935b = new e();
        }
        return f21935b;
    }

    e c(OkHttpClient okHttpClient, String str, String str2) {
        this.f21936c = true;
        this.f21937d = str;
        this.f21938e = okHttpClient;
        this.f21939f = str2;
        return this;
    }

    e d() {
        if (this.f21936c && !j.d(this.f21937d) && this.f21938e != null && !j.d(this.f21939f)) {
            i(new b());
        }
        return this;
    }

    e f(String str) {
        return g(str, null);
    }

    e g(String str, Throwable th) {
        if (this.f21936c && !j.d(str) && !j.d(this.f21939f)) {
            i(new a(str, th));
        }
        return this;
    }

    protected void h(JSONArray jSONArray) {
        try {
            try {
                if (this.f21938e.newCall(new Request.Builder().url(this.f21941h).post(RequestBody.create(g.a, new JSONObject().put("api", new JSONObject().put("api_key", this.f21937d).put("library", new JSONObject().put("name", "rakam-android").put("version", "2.7.14")).put("upload_time", System.currentTimeMillis())).put("events", jSONArray).toString())).build()).execute().body().string().equals("1")) {
                    this.f21944k.clear();
                    this.f21943j.clear();
                }
            } catch (IOException | AssertionError | Exception unused) {
            }
        } catch (JSONException e2) {
            a.b("RakamDiagnostics", String.format("Failed to convert revenue object to JSON: %s", e2.toString()));
        }
    }

    protected void i(Runnable runnable) {
        Thread threadCurrentThread = Thread.currentThread();
        k kVar = this.f21942i;
        if (threadCurrentThread != kVar) {
            kVar.a(runnable);
        } else {
            runnable.run();
        }
    }
}
