package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbid {
    private static final Pattern a = Pattern.compile("^\\uFEFF?\\s*(\\s*<!--([^-]|(?!-->))*-->)*\\s*<!DOCTYPE(\\s)+html(|(\\s)+[^>]*)>", 2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f14468b = Pattern.compile("^\\uFEFF?\\s*(\\s*<!--([^-]|(?!-->))*-->)*?\\s*<!DOCTYPE[^>]*>", 2);

    public static String a() {
        String str = (String) zzyt.e().c(zzacu.c0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", str);
            jSONObject.put("sdk", "Google Mobile Ads");
            jSONObject.put("sdkVersion", "12.4.51-000");
            return "<script>Object.defineProperty(window,'MRAID_ENV',{get:function(){return " + jSONObject.toString() + "}});</script>";
        } catch (JSONException e2) {
            zzbad.d("Unable to build MRAID_ENV", e2);
            return null;
        }
    }

    public static String b(String str, String... strArr) {
        if (strArr.length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        Matcher matcher = a.matcher(str);
        int i2 = 0;
        if (matcher.find()) {
            int iEnd = matcher.end();
            sb.append(str.substring(0, iEnd));
            int length = strArr.length;
            while (i2 < length) {
                String str2 = strArr[i2];
                if (str2 != null) {
                    sb.append(str2);
                }
                i2++;
            }
            sb.append(str.substring(iEnd));
        } else {
            if (!f14468b.matcher(str).find()) {
                int length2 = strArr.length;
                while (i2 < length2) {
                    String str3 = strArr[i2];
                    if (str3 != null) {
                        sb.append(str3);
                    }
                    i2++;
                }
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
