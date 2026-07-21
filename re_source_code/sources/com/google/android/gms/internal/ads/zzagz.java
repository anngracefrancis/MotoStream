package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzagz {
    public static final zzaho<zzbgz> a = z.a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zzaho<zzbgz> f13888b = a0.a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzaho<zzbgz> f13889c = b0.a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zzaho<zzbgz> f13890d = new e0();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final zzaho<zzbgz> f13891e = new f0();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zzaho<zzbgz> f13892f = c0.a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final zzaho<Object> f13893g = new g0();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final zzaho<zzbgz> f13894h = new h0();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final zzaho<zzbgz> f13895i = d0.a;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final zzaho<zzbgz> f13896j = new i0();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final zzaho<zzbgz> f13897k = new j0();
    public static final zzaho<zzbdf> l = new zzbfo();
    public static final zzaho<zzbdf> m = new zzbfp();
    public static final zzaho<zzbgz> n = new zzagy();
    public static final zzahu o = new zzahu();
    public static final zzaho<zzbgz> p = new k0();
    public static final zzaho<zzbgz> q = new l0();
    public static final zzaho<zzbgz> r = new m0();

    static final /* synthetic */ void a(zzaji zzajiVar, Map map) throws zzdi {
        String str = (String) map.get("u");
        if (str == null) {
            zzbad.i("URL missing from click GMSG.");
            return;
        }
        Uri uriA = Uri.parse(str);
        try {
            zzdh zzdhVarD = ((zzbif) zzajiVar).d();
            if (zzdhVarD != null && zzdhVarD.e(uriA)) {
                uriA = zzdhVarD.a(uriA, ((zzbhx) zzajiVar).getContext(), ((zzbih) zzajiVar).getView(), ((zzbhx) zzajiVar).a());
            }
        } catch (zzdi unused) {
            zzbad.i(str.length() != 0 ? "Unable to append parameter to URL: ".concat(str) : new String("Unable to append parameter to URL: "));
        }
        zzbhx zzbhxVar = (zzbhx) zzajiVar;
        new zzazi(zzbhxVar.getContext(), ((zzbig) zzajiVar).b().f14326f, zzavx.b(uriA, zzbhxVar.getContext())).zzvi();
    }

    static final /* synthetic */ void b(zzbhx zzbhxVar, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzbad.i("URL missing from httpTrack GMSG.");
        } else {
            new zzazi(zzbhxVar.getContext(), ((zzbig) zzbhxVar).b().f14326f, str).zzvi();
        }
    }

    static final /* synthetic */ void c(zzbif zzbifVar, Map map) {
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int i2 = Integer.parseInt(str);
            int i3 = Integer.parseInt(str2);
            int i4 = Integer.parseInt(str3);
            zzdh zzdhVarD = zzbifVar.d();
            if (zzdhVarD != null) {
                zzdhVarD.f().zza(i2, i3, i4);
            }
        } catch (NumberFormatException unused) {
            zzbad.i("Could not parse touch parameters from gmsg.");
        }
    }

    static final /* synthetic */ void d(zzbhx zzbhxVar, Map map) {
        PackageManager packageManager = zzbhxVar.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        String strOptString = jSONObject2.optString(DeepLinkIntentReceiver.DeepLinksKeys.ID);
                        String strOptString2 = jSONObject2.optString("u");
                        String strOptString3 = jSONObject2.optString("i");
                        String strOptString4 = jSONObject2.optString("m");
                        String strOptString5 = jSONObject2.optString("p");
                        String strOptString6 = jSONObject2.optString("c");
                        jSONObject2.optString("f");
                        jSONObject2.optString("e");
                        String strOptString7 = jSONObject2.optString("intent_url");
                        Intent uri = null;
                        if (!TextUtils.isEmpty(strOptString7)) {
                            try {
                                uri = Intent.parseUri(strOptString7, 0);
                            } catch (URISyntaxException e2) {
                                String strValueOf = String.valueOf(strOptString7);
                                zzbad.c(strValueOf.length() != 0 ? "Error parsing the url: ".concat(strValueOf) : new String("Error parsing the url: "), e2);
                            }
                        }
                        if (uri == null) {
                            uri = new Intent();
                            if (!TextUtils.isEmpty(strOptString2)) {
                                uri.setData(Uri.parse(strOptString2));
                            }
                            if (!TextUtils.isEmpty(strOptString3)) {
                                uri.setAction(strOptString3);
                            }
                            if (!TextUtils.isEmpty(strOptString4)) {
                                uri.setType(strOptString4);
                            }
                            if (!TextUtils.isEmpty(strOptString5)) {
                                uri.setPackage(strOptString5);
                            }
                            if (!TextUtils.isEmpty(strOptString6)) {
                                String[] strArrSplit = strOptString6.split("/", 2);
                                if (strArrSplit.length == 2) {
                                    uri.setComponent(new ComponentName(strArrSplit[0], strArrSplit[1]));
                                }
                            }
                        }
                        try {
                            jSONObject.put(strOptString, packageManager.resolveActivity(uri, 65536) != null);
                        } catch (JSONException e3) {
                            zzbad.c("Error constructing openable urls response.", e3);
                        }
                    } catch (JSONException e4) {
                        zzbad.c("Error parsing the intent data.", e4);
                    }
                }
                ((zzaji) zzbhxVar).j("openableIntents", jSONObject);
            } catch (JSONException unused) {
                ((zzaji) zzbhxVar).j("openableIntents", new JSONObject());
            }
        } catch (JSONException unused2) {
            ((zzaji) zzbhxVar).j("openableIntents", new JSONObject());
        }
    }

    static final /* synthetic */ void e(zzbhx zzbhxVar, Map map) {
        String str = (String) map.get("urls");
        if (TextUtils.isEmpty(str)) {
            zzbad.i("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] strArrSplit = str.split(",");
        HashMap map2 = new HashMap();
        PackageManager packageManager = zzbhxVar.getContext().getPackageManager();
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.split(";", 2);
            boolean z = true;
            if (packageManager.resolveActivity(new Intent(strArrSplit2.length > 1 ? strArrSplit2[1].trim() : "android.intent.action.VIEW", Uri.parse(strArrSplit2[0].trim())), 65536) == null) {
                z = false;
            }
            map2.put(str2, Boolean.valueOf(z));
        }
        ((zzaji) zzbhxVar).y("openableURLs", map2);
    }
}
