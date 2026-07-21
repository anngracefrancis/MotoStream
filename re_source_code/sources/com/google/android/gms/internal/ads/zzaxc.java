package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzaxc implements zzaxb {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f14242b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzbbh<?> f14244d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SharedPreferences f14246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SharedPreferences.Editor f14247g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f14250j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f14251k;
    private final Object a = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Runnable> f14243c = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzuu f14245e = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f14248h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f14249i = true;
    private boolean l = false;
    private String m = HttpUrl.FRAGMENT_ENCODE_SET;
    private long n = 0;
    private long o = 0;
    private long p = 0;
    private int q = -1;
    private int r = 0;
    private Set<String> s = Collections.emptySet();
    private JSONObject t = new JSONObject();
    private boolean u = true;
    private boolean v = true;
    private String w = null;

    private final void C(Bundle bundle) {
        zzaxg.a.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.c5

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzaxc f12398f;

            {
                this.f12398f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12398f.o();
            }
        });
    }

    private final void E() {
        zzbbh<?> zzbbhVar = this.f14244d;
        if (zzbbhVar == null || zzbbhVar.isDone()) {
            return;
        }
        try {
            this.f14244d.get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            zzbad.d("Interrupted while waiting for preferences loaded.", e2);
        } catch (CancellationException e3) {
            e = e3;
            zzbad.c("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (ExecutionException e4) {
            e = e4;
            zzbad.c("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (TimeoutException e5) {
            e = e5;
            zzbad.c("Fail to initialize AdSharedPreferenceManager.", e);
        }
    }

    private final Bundle F() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("listener_registration_bundle", true);
        synchronized (this.a) {
            bundle.putBoolean("use_https", this.f14249i);
            bundle.putBoolean("content_url_opted_out", this.u);
            bundle.putBoolean("content_vertical_opted_out", this.v);
            bundle.putBoolean("auto_collect_location", this.l);
            bundle.putInt("version_code", this.r);
            bundle.putStringArray("never_pool_slots", (String[]) this.s.toArray(new String[0]));
            bundle.putString("app_settings_json", this.m);
            bundle.putLong("app_settings_last_update_ms", this.n);
            bundle.putLong("app_last_background_time_ms", this.o);
            bundle.putInt("request_in_session_count", this.q);
            bundle.putLong("first_ad_req_time_ms", this.p);
            bundle.putString("native_advanced_settings", this.t.toString());
            bundle.putString("display_cutout", this.w);
            String str = this.f14250j;
            if (str != null) {
                bundle.putString("content_url_hashes", str);
            }
            String str2 = this.f14251k;
            if (str2 != null) {
                bundle.putString("content_vertical_hashes", str2);
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final String A() {
        String str;
        E();
        synchronized (this.a) {
            str = this.f14251k;
        }
        return str;
    }

    public final void B(final Context context, String str, boolean z) {
        final String strConcat;
        if (str == null) {
            strConcat = "admob";
        } else {
            strConcat = str.length() != 0 ? "admob__".concat(str) : new String("admob__");
        }
        this.f14244d = zzaxg.b(new Runnable(this, context, strConcat) { // from class: com.google.android.gms.internal.ads.b5

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzaxc f12313f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final Context f12314g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final String f12315h;

            {
                this.f12313f = this;
                this.f12314g = context;
                this.f12315h = strConcat;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12313f.D(this.f12314g, this.f12315h);
            }
        });
        this.f14242b = z;
    }

    final /* synthetic */ void D(Context context, String str) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        synchronized (this.a) {
            this.f14246f = sharedPreferences;
            this.f14247g = editorEdit;
            if (PlatformVersion.i() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                z = true;
            }
            this.f14248h = z;
            this.f14249i = this.f14246f.getBoolean("use_https", this.f14249i);
            this.u = this.f14246f.getBoolean("content_url_opted_out", this.u);
            this.f14250j = this.f14246f.getString("content_url_hashes", this.f14250j);
            this.l = this.f14246f.getBoolean("auto_collect_location", this.l);
            this.v = this.f14246f.getBoolean("content_vertical_opted_out", this.v);
            this.f14251k = this.f14246f.getString("content_vertical_hashes", this.f14251k);
            this.r = this.f14246f.getInt("version_code", this.r);
            this.m = this.f14246f.getString("app_settings_json", this.m);
            this.n = this.f14246f.getLong("app_settings_last_update_ms", this.n);
            this.o = this.f14246f.getLong("app_last_background_time_ms", this.o);
            this.q = this.f14246f.getInt("request_in_session_count", this.q);
            this.p = this.f14246f.getLong("first_ad_req_time_ms", this.p);
            this.s = this.f14246f.getStringSet("never_pool_slots", this.s);
            this.w = this.f14246f.getString("display_cutout", this.w);
            try {
                this.t = new JSONObject(this.f14246f.getString("native_advanced_settings", "{}"));
            } catch (JSONException e2) {
                zzbad.d("Could not convert native advanced settings to json object", e2);
            }
            C(F());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final JSONObject a() {
        JSONObject jSONObject;
        E();
        synchronized (this.a) {
            jSONObject = this.t;
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final boolean b() {
        boolean z;
        E();
        synchronized (this.a) {
            z = this.v;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void c(String str) {
        E();
        synchronized (this.a) {
            long jA = zzk.zzln().a();
            this.n = jA;
            if (str != null && !str.equals(this.m)) {
                this.m = str;
                SharedPreferences.Editor editor = this.f14247g;
                if (editor != null) {
                    editor.putString("app_settings_json", str);
                    this.f14247g.putLong("app_settings_last_update_ms", jA);
                    this.f14247g.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putString("app_settings_json", str);
                bundle.putLong("app_settings_last_update_ms", jA);
                C(bundle);
                Iterator<Runnable> it = this.f14243c.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final long d() {
        long j2;
        E();
        synchronized (this.a) {
            j2 = this.p;
        }
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void e(int i2) {
        E();
        synchronized (this.a) {
            if (this.r == i2) {
                return;
            }
            this.r = i2;
            SharedPreferences.Editor editor = this.f14247g;
            if (editor != null) {
                editor.putInt("version_code", i2);
                this.f14247g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("version_code", i2);
            C(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void f(String str) {
        E();
        synchronized (this.a) {
            if (TextUtils.equals(this.w, str)) {
                return;
            }
            this.w = str;
            SharedPreferences.Editor editor = this.f14247g;
            if (editor != null) {
                editor.putString("display_cutout", str);
                this.f14247g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("display_cutout", str);
            C(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final String g() {
        String str;
        E();
        synchronized (this.a) {
            str = this.f14250j;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void h(long j2) {
        E();
        synchronized (this.a) {
            if (this.o == j2) {
                return;
            }
            this.o = j2;
            SharedPreferences.Editor editor = this.f14247g;
            if (editor != null) {
                editor.putLong("app_last_background_time_ms", j2);
                this.f14247g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putLong("app_last_background_time_ms", j2);
            C(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final int i() {
        int i2;
        E();
        synchronized (this.a) {
            i2 = this.q;
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void j(boolean z) {
        E();
        synchronized (this.a) {
            if (this.v == z) {
                return;
            }
            this.v = z;
            SharedPreferences.Editor editor = this.f14247g;
            if (editor != null) {
                editor.putBoolean("content_vertical_opted_out", z);
                this.f14247g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("content_url_opted_out", this.u);
            bundle.putBoolean("content_vertical_opted_out", this.v);
            C(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final boolean k() {
        boolean z;
        E();
        synchronized (this.a) {
            z = this.u;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void l(String str) {
        E();
        synchronized (this.a) {
            if (str != null) {
                if (!str.equals(this.f14250j)) {
                    this.f14250j = str;
                    SharedPreferences.Editor editor = this.f14247g;
                    if (editor != null) {
                        editor.putString("content_url_hashes", str);
                        this.f14247g.apply();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("content_url_hashes", str);
                    C(bundle);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final long m() {
        long j2;
        E();
        synchronized (this.a) {
            j2 = this.o;
        }
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void n(boolean z) {
        E();
        synchronized (this.a) {
            if (this.l == z) {
                return;
            }
            this.l = z;
            SharedPreferences.Editor editor = this.f14247g;
            if (editor != null) {
                editor.putBoolean("auto_collect_location", z);
                this.f14247g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("auto_collect_location", z);
            C(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final zzuu o() {
        if (!this.f14242b || !PlatformVersion.a()) {
            return null;
        }
        if (k() && b()) {
            return null;
        }
        if (!((Boolean) zzyt.e().c(zzacu.h0)).booleanValue()) {
            return null;
        }
        synchronized (this.a) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.f14245e == null) {
                this.f14245e = new zzuu();
            }
            this.f14245e.e();
            zzbad.h("start fetching content...");
            return this.f14245e;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void p(String str) {
        E();
        synchronized (this.a) {
            if (str != null) {
                if (!str.equals(this.f14251k)) {
                    this.f14251k = str;
                    SharedPreferences.Editor editor = this.f14247g;
                    if (editor != null) {
                        editor.putString("content_vertical_hashes", str);
                        this.f14247g.apply();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("content_vertical_hashes", str);
                    C(bundle);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final zzawl q() {
        zzawl zzawlVar;
        E();
        synchronized (this.a) {
            zzawlVar = new zzawl(this.m, this.n);
        }
        return zzawlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void r(boolean z) {
        E();
        synchronized (this.a) {
            if (this.u == z) {
                return;
            }
            this.u = z;
            SharedPreferences.Editor editor = this.f14247g;
            if (editor != null) {
                editor.putBoolean("content_url_opted_out", z);
                this.f14247g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("content_url_opted_out", this.u);
            bundle.putBoolean("content_vertical_opted_out", this.v);
            C(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final int s() {
        int i2;
        E();
        synchronized (this.a) {
            i2 = this.r;
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final String t() {
        String str;
        E();
        synchronized (this.a) {
            str = this.w;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void u(Runnable runnable) {
        this.f14243c.add(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void v(int i2) {
        E();
        synchronized (this.a) {
            if (this.q == i2) {
                return;
            }
            this.q = i2;
            SharedPreferences.Editor editor = this.f14247g;
            if (editor != null) {
                editor.putInt("request_in_session_count", i2);
                this.f14247g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("request_in_session_count", i2);
            C(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final boolean w() {
        boolean z;
        E();
        synchronized (this.a) {
            z = this.l;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void x(long j2) {
        E();
        synchronized (this.a) {
            if (this.p == j2) {
                return;
            }
            this.p = j2;
            SharedPreferences.Editor editor = this.f14247g;
            if (editor != null) {
                editor.putLong("first_ad_req_time_ms", j2);
                this.f14247g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putLong("first_ad_req_time_ms", j2);
            C(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void y() {
        E();
        synchronized (this.a) {
            this.t = new JSONObject();
            SharedPreferences.Editor editor = this.f14247g;
            if (editor != null) {
                editor.remove("native_advanced_settings");
                this.f14247g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", "{}");
            C(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxb
    public final void z(String str, String str2, boolean z) {
        E();
        synchronized (this.a) {
            JSONArray jSONArrayOptJSONArray = this.t.optJSONArray(str);
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
            }
            int length = jSONArrayOptJSONArray.length();
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject == null) {
                    return;
                }
                if (str2.equals(jSONObjectOptJSONObject.optString("template_id"))) {
                    if (!z || !jSONObjectOptJSONObject.optBoolean("uses_media_view", false)) {
                        length = i2;
                        break;
                    }
                    return;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", zzk.zzln().a());
                jSONArrayOptJSONArray.put(length, jSONObject);
                this.t.put(str, jSONArrayOptJSONArray);
            } catch (JSONException e2) {
                zzbad.d("Could not update native advanced settings", e2);
            }
            SharedPreferences.Editor editor = this.f14247g;
            if (editor != null) {
                editor.putString("native_advanced_settings", this.t.toString());
                this.f14247g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", this.t.toString());
            C(bundle);
        }
    }
}
