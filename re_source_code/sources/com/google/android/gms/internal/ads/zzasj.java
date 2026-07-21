package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzasj extends zzasl {
    private final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f14141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SharedPreferences f14142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzalj<JSONObject, JSONObject> f14143d;

    public zzasj(Context context, zzalj<JSONObject, JSONObject> zzaljVar) {
        this.f14141b = context.getApplicationContext();
        this.f14143d = zzaljVar;
    }

    public static JSONObject c(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzbai.y().f14326f);
            jSONObject.put("mf", zzyt.e().c(zzacu.E2));
            jSONObject.put("cl", "248613007");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", 11140);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.c(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", 12451009);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzasl
    public final zzbbh<Void> a() {
        synchronized (this.a) {
            if (this.f14142c == null) {
                this.f14142c = this.f14141b.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (zzk.zzln().a() - this.f14142c.getLong("js_last_update", 0L) < ((Long) zzyt.e().c(zzacu.D2)).longValue()) {
            return zzbar.o(null);
        }
        return zzbar.d(this.f14143d.a(c(this.f14141b)), new zzbam(this) { // from class: com.google.android.gms.internal.ads.u3
            private final zzasj a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbam
            public final Object a(Object obj) {
                return this.a.b((JSONObject) obj);
            }
        }, zzbbm.f14331b);
    }

    final /* synthetic */ Void b(JSONObject jSONObject) {
        zzacu.b(this.f14141b, 1, jSONObject);
        this.f14142c.edit().putLong("js_last_update", zzk.zzln().a()).apply();
        return null;
    }
}
