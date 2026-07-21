package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import cm.aptoide.pt.root.execution.Command;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcau {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzcan f14991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdh f14992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbai f14993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.google.android.gms.ads.internal.zza f14994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzwj f14995f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Executor f14996g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzady f14997h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzcbi f14998i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ScheduledExecutorService f14999j;

    public zzcau(Context context, zzcan zzcanVar, zzdh zzdhVar, zzbai zzbaiVar, com.google.android.gms.ads.internal.zza zzaVar, zzwj zzwjVar, Executor executor, zzcxv zzcxvVar, zzcbi zzcbiVar, ScheduledExecutorService scheduledExecutorService) {
        this.a = context;
        this.f14991b = zzcanVar;
        this.f14992c = zzdhVar;
        this.f14993d = zzbaiVar;
        this.f14994e = zzaVar;
        this.f14995f = zzwjVar;
        this.f14996g = executor;
        this.f14997h = zzcxvVar.f15755i;
        this.f14998i = zzcbiVar;
        this.f14999j = scheduledExecutorService;
    }

    private static <T> zzbbh<T> b(zzbbh<T> zzbbhVar, T t) {
        final Object obj = null;
        return zzbar.e(zzbbhVar, Exception.class, new zzbal(obj) { // from class: com.google.android.gms.internal.ads.rg
            private final Object a;

            {
                this.a = obj;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj2) {
                Object obj3 = this.a;
                zzawz.l("Error during loading assets.", (Exception) obj2);
                return zzbar.o(obj3);
            }
        }, zzbbm.f14331b);
    }

    private final zzbbh<List<zzadw>> c(JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzbar.o(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i2 = 0; i2 < length; i2++) {
            arrayList.add(d(jSONArray.optJSONObject(i2), z));
        }
        return zzbar.d(zzbar.m(arrayList), ng.a, this.f14996g);
    }

    private final zzbbh<zzadw> d(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzbar.o(null);
        }
        final String strOptString = jSONObject.optString("url");
        if (TextUtils.isEmpty(strOptString)) {
            return zzbar.o(null);
        }
        final double dOptDouble = jSONObject.optDouble("scale", 1.0d);
        boolean zOptBoolean = jSONObject.optBoolean("is_transparent", true);
        final int iOptInt = jSONObject.optInt("width", -1);
        final int iOptInt2 = jSONObject.optInt("height", -1);
        if (z) {
            return zzbar.o(new zzadw(null, Uri.parse(strOptString), dOptDouble, iOptInt, iOptInt2));
        }
        return e(jSONObject.optBoolean("require"), zzbar.d(this.f14991b.d(strOptString, dOptDouble, zOptBoolean), new zzbam(strOptString, dOptDouble, iOptInt, iOptInt2) { // from class: com.google.android.gms.internal.ads.og
            private final String a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final double f13100b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final int f13101c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final int f13102d;

            {
                this.a = strOptString;
                this.f13100b = dOptDouble;
                this.f13101c = iOptInt;
                this.f13102d = iOptInt2;
            }

            @Override // com.google.android.gms.internal.ads.zzbam
            public final Object a(Object obj) {
                String str = this.a;
                return new zzadw(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(str), this.f13100b, this.f13101c, this.f13102d);
            }
        }, this.f14996g), null);
    }

    private static <T> zzbbh<T> e(boolean z, final zzbbh<T> zzbbhVar, T t) {
        return z ? zzbar.c(zzbbhVar, new zzbal(zzbbhVar) { // from class: com.google.android.gms.internal.ads.tg
            private final zzbbh a;

            {
                this.a = zzbbhVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return obj != null ? this.a : zzbar.l(new zzcmw("Retrieve required value in native ad response failed.", 0));
            }
        }, zzbbm.f14331b) : b(zzbbhVar, null);
    }

    private static Integer j(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static List<zzabj> k(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("mute");
        if (jSONObjectOptJSONObject == null) {
            return Collections.emptyList();
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("reasons");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
            zzabj zzabjVarM = m(jSONArrayOptJSONArray.optJSONObject(i2));
            if (zzabjVarM != null) {
                arrayList.add(zzabjVarM);
            }
        }
        return arrayList;
    }

    public static zzabj l(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("mute");
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return m(jSONObjectOptJSONObject);
    }

    private static zzabj m(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("reason");
        String strOptString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
            return null;
        }
        return new zzabj(strOptString, strOptString2);
    }

    final /* synthetic */ zzadt a(JSONObject jSONObject, List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String strOptString = jSONObject.optString(Command.CommandHandler.TEXT);
        Integer numJ = j(jSONObject, "bg_color");
        Integer numJ2 = j(jSONObject, "text_color");
        int iOptInt = jSONObject.optInt("text_size", -1);
        boolean zOptBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int iOptInt2 = jSONObject.optInt("animation_ms", 1000);
        return new zzadt(strOptString, list, numJ, numJ2, iOptInt > 0 ? Integer.valueOf(iOptInt) : null, jSONObject.optInt("presentation_ms", 4000) + iOptInt2, this.f14997h.f13849j, zOptBoolean);
    }

    final /* synthetic */ zzbbh f(String str, Object obj) throws Exception {
        zzk.zzlh();
        zzbgz zzbgzVarB = zzbhf.b(this.a, zzbin.b(), "native-omid", false, false, this.f14992c, this.f14993d, null, null, this.f14994e, this.f14995f);
        final zzbbq zzbbqVarE = zzbbq.e(zzbgzVarB);
        zzbgzVarB.p().i(new zzbij(zzbbqVarE) { // from class: com.google.android.gms.internal.ads.ug
            private final zzbbq a;

            {
                this.a = zzbbqVarE;
            }

            @Override // com.google.android.gms.internal.ads.zzbij
            public final void zzae(boolean z) {
                this.a.f();
            }
        });
        zzbgzVarB.loadData(str, "text/html", "UTF-8");
        return zzbbqVarE;
    }

    public final zzbbh<zzadw> g(JSONObject jSONObject, String str) {
        return d(jSONObject.optJSONObject(str), this.f14997h.f13846g);
    }

    public final zzbbh<List<zzadw>> h(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        zzady zzadyVar = this.f14997h;
        return c(jSONArrayOptJSONArray, zzadyVar.f13846g, zzadyVar.f13848i);
    }

    public final zzbbh<zzadt> i(JSONObject jSONObject, String str) {
        final JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            return zzbar.o(null);
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("images");
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("image");
        if (jSONArrayOptJSONArray == null && jSONObjectOptJSONObject2 != null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONArrayOptJSONArray.put(jSONObjectOptJSONObject2);
        }
        return e(jSONObjectOptJSONObject.optBoolean("require"), zzbar.d(c(jSONArrayOptJSONArray, false, true), new zzbam(this, jSONObjectOptJSONObject) { // from class: com.google.android.gms.internal.ads.pg
            private final zzcau a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final JSONObject f13163b;

            {
                this.a = this;
                this.f13163b = jSONObjectOptJSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzbam
            public final Object a(Object obj) {
                return this.a.a(this.f13163b, (List) obj);
            }
        }, this.f14996g), null);
    }

    public final zzbbh<zzbgz> n(JSONObject jSONObject) {
        JSONObject jSONObjectE = zzazc.e(jSONObject, "html_containers", "instream");
        if (jSONObjectE != null) {
            return e(jSONObjectE.optBoolean("require"), this.f14998i.g(jSONObjectE.optString("base_url"), jSONObjectE.optString("html")), null);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("video");
        if (jSONObjectOptJSONObject == null) {
            return zzbar.o(null);
        }
        if (!TextUtils.isEmpty(jSONObjectOptJSONObject.optString("vast_xml"))) {
            return b(zzbar.b(this.f14998i.f(jSONObjectOptJSONObject), ((Integer) zzyt.e().c(zzacu.L2)).intValue(), TimeUnit.SECONDS, this.f14999j), null);
        }
        zzbad.i("Required field 'vast_xml' is missing");
        return zzbar.o(null);
    }
}
