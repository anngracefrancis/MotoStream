package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class zzajr {
    public static void a(zzajq zzajqVar, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("(");
        sb.append(str2);
        sb.append(");");
        zzajqVar.k(sb.toString());
    }

    public static void b(zzajq zzajqVar, String str, Map map) {
        try {
            zzajqVar.j(str, zzk.zzlg().Y(map));
        } catch (JSONException unused) {
            zzbad.i("Could not convert parameters to JSON.");
        }
    }

    public static void c(zzajq zzajqVar, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zzajqVar.X(str, jSONObject.toString());
    }

    public static void d(zzajq zzajqVar, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(string);
        sb.append(");");
        String strValueOf = String.valueOf(sb.toString());
        zzbad.e(strValueOf.length() != 0 ? "Dispatching AFMA event: ".concat(strValueOf) : new String("Dispatching AFMA event: "));
        zzajqVar.k(sb.toString());
    }
}
