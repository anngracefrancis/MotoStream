package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class h0 {
    private final Bundle a;

    public h0(Bundle bundle) {
        if (bundle == null) {
            throw new NullPointerException("data");
        }
        this.a = new Bundle(bundle);
    }

    private static int d(String str) {
        int color = Color.parseColor(str);
        if (color != -16777216) {
            return color;
        }
        throw new IllegalArgumentException("Transparent color is invalid");
    }

    private static boolean s(String str) {
        return str.startsWith("google.c.a.") || str.equals("from");
    }

    public static boolean t(Bundle bundle) {
        return "1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString(v("gcm.n.e")));
    }

    private static boolean u(String str) {
        return str.startsWith("google.c.") || str.startsWith("gcm.n.") || str.startsWith("gcm.notification.");
    }

    private static String v(String str) {
        return !str.startsWith("gcm.n.") ? str : str.replace("gcm.n.", "gcm.notification.");
    }

    private String w(String str) {
        if (!this.a.containsKey(str) && str.startsWith("gcm.n.")) {
            String strV = v(str);
            if (this.a.containsKey(strV)) {
                return strV;
            }
        }
        return str;
    }

    private static String z(String str) {
        return str.startsWith("gcm.n.") ? str.substring(6) : str;
    }

    public boolean a(String str) {
        String strP = p(str);
        return "1".equals(strP) || Boolean.parseBoolean(strP);
    }

    public Integer b(String str) {
        String strP = p(str);
        if (TextUtils.isEmpty(strP)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(strP));
        } catch (NumberFormatException unused) {
            String strZ = z(str);
            StringBuilder sb = new StringBuilder(String.valueOf(strZ).length() + 38 + String.valueOf(strP).length());
            sb.append("Couldn't parse value of ");
            sb.append(strZ);
            sb.append("(");
            sb.append(strP);
            sb.append(") into an int");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    public JSONArray c(String str) {
        String strP = p(str);
        if (TextUtils.isEmpty(strP)) {
            return null;
        }
        try {
            return new JSONArray(strP);
        } catch (JSONException unused) {
            String strZ = z(str);
            StringBuilder sb = new StringBuilder(String.valueOf(strZ).length() + 50 + String.valueOf(strP).length());
            sb.append("Malformed JSON for key ");
            sb.append(strZ);
            sb.append(": ");
            sb.append(strP);
            sb.append(", falling back to default");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    int[] e() {
        JSONArray jSONArrayC = c("gcm.n.light_settings");
        if (jSONArrayC == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (jSONArrayC.length() != 3) {
                throw new JSONException("lightSettings don't have all three fields");
            }
            iArr[0] = d(jSONArrayC.optString(0));
            iArr[1] = jSONArrayC.optInt(1);
            iArr[2] = jSONArrayC.optInt(2);
            return iArr;
        } catch (IllegalArgumentException e2) {
            String strValueOf = String.valueOf(jSONArrayC);
            String message = e2.getMessage();
            StringBuilder sb = new StringBuilder(strValueOf.length() + 60 + String.valueOf(message).length());
            sb.append("LightSettings is invalid: ");
            sb.append(strValueOf);
            sb.append(". ");
            sb.append(message);
            sb.append(". Skipping setting LightSettings");
            Log.w("NotificationParams", sb.toString());
            return null;
        } catch (JSONException unused) {
            String strValueOf2 = String.valueOf(jSONArrayC);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 58);
            sb2.append("LightSettings is invalid: ");
            sb2.append(strValueOf2);
            sb2.append(". Skipping setting LightSettings");
            Log.w("NotificationParams", sb2.toString());
            return null;
        }
    }

    public Uri f() {
        String strP = p("gcm.n.link_android");
        if (TextUtils.isEmpty(strP)) {
            strP = p("gcm.n.link");
        }
        if (TextUtils.isEmpty(strP)) {
            return null;
        }
        return Uri.parse(strP);
    }

    public Object[] g(String str) {
        JSONArray jSONArrayC = c(String.valueOf(str).concat("_loc_args"));
        if (jSONArrayC == null) {
            return null;
        }
        int length = jSONArrayC.length();
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = jSONArrayC.optString(i2);
        }
        return strArr;
    }

    public String h(String str) {
        return p(String.valueOf(str).concat("_loc_key"));
    }

    public String i(Resources resources, String str, String str2) {
        String strH = h(str2);
        if (TextUtils.isEmpty(strH)) {
            return null;
        }
        int identifier = resources.getIdentifier(strH, "string", str);
        if (identifier == 0) {
            String strZ = z(String.valueOf(str2).concat("_loc_key"));
            StringBuilder sb = new StringBuilder(String.valueOf(strZ).length() + 49 + String.valueOf(str2).length());
            sb.append(strZ);
            sb.append(" resource not found: ");
            sb.append(str2);
            sb.append(" Default value will be used.");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
        Object[] objArrG = g(str2);
        if (objArrG == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, objArrG);
        } catch (MissingFormatArgumentException e2) {
            String strZ2 = z(str2);
            String string = Arrays.toString(objArrG);
            StringBuilder sb2 = new StringBuilder(String.valueOf(strZ2).length() + 58 + String.valueOf(string).length());
            sb2.append("Missing format argument for ");
            sb2.append(strZ2);
            sb2.append(": ");
            sb2.append(string);
            sb2.append(" Default value will be used.");
            Log.w("NotificationParams", sb2.toString(), e2);
            return null;
        }
    }

    public Long j(String str) {
        String strP = p(str);
        if (TextUtils.isEmpty(strP)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(strP));
        } catch (NumberFormatException unused) {
            String strZ = z(str);
            StringBuilder sb = new StringBuilder(String.valueOf(strZ).length() + 38 + String.valueOf(strP).length());
            sb.append("Couldn't parse value of ");
            sb.append(strZ);
            sb.append("(");
            sb.append(strP);
            sb.append(") into a long");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    public String k() {
        return p("gcm.n.android_channel_id");
    }

    Integer l() {
        Integer numB = b("gcm.n.notification_count");
        if (numB == null) {
            return null;
        }
        if (numB.intValue() >= 0) {
            return numB;
        }
        String strValueOf = String.valueOf(numB);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 67);
        sb.append("notificationCount is invalid: ");
        sb.append(strValueOf);
        sb.append(". Skipping setting notificationCount.");
        Log.w("FirebaseMessaging", sb.toString());
        return null;
    }

    Integer m() {
        Integer numB = b("gcm.n.notification_priority");
        if (numB == null) {
            return null;
        }
        if (numB.intValue() >= -2 && numB.intValue() <= 2) {
            return numB;
        }
        String strValueOf = String.valueOf(numB);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 72);
        sb.append("notificationPriority is invalid ");
        sb.append(strValueOf);
        sb.append(". Skipping setting notificationPriority.");
        Log.w("FirebaseMessaging", sb.toString());
        return null;
    }

    public String n(Resources resources, String str, String str2) {
        String strP = p(str2);
        return !TextUtils.isEmpty(strP) ? strP : i(resources, str, str2);
    }

    public String o() {
        String strP = p("gcm.n.sound2");
        return TextUtils.isEmpty(strP) ? p("gcm.n.sound") : strP;
    }

    public String p(String str) {
        return this.a.getString(w(str));
    }

    public long[] q() {
        JSONArray jSONArrayC = c("gcm.n.vibrate_timings");
        if (jSONArrayC == null) {
            return null;
        }
        try {
            if (jSONArrayC.length() <= 1) {
                throw new JSONException("vibrateTimings have invalid length");
            }
            int length = jSONArrayC.length();
            long[] jArr = new long[length];
            for (int i2 = 0; i2 < length; i2++) {
                jArr[i2] = jSONArrayC.optLong(i2);
            }
            return jArr;
        } catch (NumberFormatException | JSONException unused) {
            String strValueOf = String.valueOf(jSONArrayC);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 74);
            sb.append("User defined vibrateTimings is invalid: ");
            sb.append(strValueOf);
            sb.append(". Skipping setting vibrateTimings.");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    Integer r() {
        Integer numB = b("gcm.n.visibility");
        if (numB == null) {
            return null;
        }
        if (numB.intValue() >= -1 && numB.intValue() <= 1) {
            return numB;
        }
        String strValueOf = String.valueOf(numB);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 53);
        sb.append("visibility is invalid: ");
        sb.append(strValueOf);
        sb.append(". Skipping setting visibility.");
        Log.w("NotificationParams", sb.toString());
        return null;
    }

    public Bundle x() {
        Bundle bundle = new Bundle(this.a);
        for (String str : this.a.keySet()) {
            if (!s(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    public Bundle y() {
        Bundle bundle = new Bundle(this.a);
        for (String str : this.a.keySet()) {
            if (u(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }
}
