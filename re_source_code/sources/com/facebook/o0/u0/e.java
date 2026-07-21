package com.facebook.o0.u0;

import android.util.Patterns;
import cm.aptoide.pt.root.execution.Command;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.collections.q0;
import kotlin.jvm.internal.m;
import kotlin.s;
import kotlin.text.Charsets;
import kotlin.text.v;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: FeatureExtractor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final e a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, String> f10515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Map<String, String> f10516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Map<String, String> f10517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static JSONObject f10518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f10519f;

    private e() {
    }

    public static final float[] a(JSONObject jSONObject, String str) {
        m.f(jSONObject, "viewHierarchy");
        m.f(str, "appName");
        if (!f10519f) {
            return null;
        }
        float[] fArr = new float[30];
        for (int i2 = 0; i2 < 30; i2++) {
            fArr[i2] = 0.0f;
        }
        try {
            String lowerCase = str.toLowerCase();
            m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
            JSONObject jSONObject2 = new JSONObject(jSONObject.optJSONObject("view").toString());
            String strOptString = jSONObject.optString("screenname");
            JSONArray jSONArray = new JSONArray();
            e eVar = a;
            eVar.j(jSONObject2, jSONArray);
            eVar.m(fArr, eVar.i(jSONObject2));
            JSONObject jSONObjectB = eVar.b(jSONObject2);
            if (jSONObjectB == null) {
                return null;
            }
            m.e(strOptString, "screenName");
            String string = jSONObject2.toString();
            m.e(string, "viewTree.toString()");
            eVar.m(fArr, eVar.h(jSONObjectB, jSONArray, strOptString, string, lowerCase));
        } catch (JSONException unused) {
        }
        return fArr;
    }

    private final JSONObject b(JSONObject jSONObject) {
        try {
            if (jSONObject.optBoolean("is_interacted")) {
                return jSONObject;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childviews");
            if (jSONArrayOptJSONArray == null) {
                return null;
            }
            int i2 = 0;
            int length = jSONArrayOptJSONArray.length();
            if (length > 0) {
                while (true) {
                    int i3 = i2 + 1;
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                    m.e(jSONObject2, "children.getJSONObject(i)");
                    JSONObject jSONObjectB = b(jSONObject2);
                    if (jSONObjectB != null) {
                        return jSONObjectB;
                    }
                    if (i3 < length) {
                        i2 = i3;
                    }
                }
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    public static final String c(String str, String str2, String str3) {
        m.f(str, "buttonText");
        m.f(str2, "activityName");
        m.f(str3, "appName");
        String str4 = str3 + " | " + str2 + ", " + str;
        if (str4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str4.toLowerCase();
        m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    public static final void d(File file) {
        try {
            f10518e = new JSONObject();
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            f10518e = new JSONObject(new String(bArr, Charsets.f25054b));
            f10515b = q0.l(s.a("ENGLISH", "1"), s.a("GERMAN", "2"), s.a("SPANISH", "3"), s.a("JAPANESE", "4"));
            f10516c = q0.l(s.a("VIEW_CONTENT", "0"), s.a("SEARCH", "1"), s.a("ADD_TO_CART", "2"), s.a("ADD_TO_WISHLIST", "3"), s.a("INITIATE_CHECKOUT", "4"), s.a("ADD_PAYMENT_INFO", "5"), s.a("PURCHASE", "6"), s.a("LEAD", "7"), s.a("COMPLETE_REGISTRATION", "8"));
            f10517d = q0.l(s.a("BUTTON_TEXT", "1"), s.a("PAGE_TITLE", "2"), s.a("RESOLVED_DOCUMENT_LINK", "3"), s.a("BUTTON_ID", "4"));
            f10519f = true;
        } catch (Exception unused) {
        }
    }

    private final boolean e(JSONObject jSONObject) {
        return ((jSONObject.optInt("classtypebitmask") & 1) << 5) > 0;
    }

    public static final boolean f() {
        return f10519f;
    }

    private final boolean g(String[] strArr, String[] strArr2) {
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str = strArr[i2];
            i2++;
            int length2 = strArr2.length;
            int i3 = 0;
            while (i3 < length2) {
                String str2 = strArr2[i3];
                i3++;
                if (v.J(str2, str, false, 2, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final float[] h(JSONObject jSONObject, JSONArray jSONArray, String str, String str2, String str3) {
        float[] fArr = new float[30];
        int i2 = 0;
        while (true) {
            if (i2 >= 30) {
                break;
            }
            fArr[i2] = 0.0f;
            i2++;
        }
        int length = jSONArray.length();
        fArr[3] = length > 1 ? length - 1.0f : 0.0f;
        try {
            int length2 = jSONArray.length();
            if (length2 > 0) {
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 1;
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    m.e(jSONObject2, "siblings.getJSONObject(i)");
                    if (e(jSONObject2)) {
                        fArr[9] = fArr[9] + 1.0f;
                    }
                    if (i4 >= length2) {
                        break;
                    }
                    i3 = i4;
                }
            }
        } catch (JSONException unused) {
        }
        fArr[13] = -1.0f;
        fArr[14] = -1.0f;
        String str4 = str + '|' + str3;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        n(jSONObject, sb2, sb);
        String string = sb.toString();
        m.e(string, "hintSB.toString()");
        String string2 = sb2.toString();
        m.e(string2, "textSB.toString()");
        fArr[15] = l("ENGLISH", "COMPLETE_REGISTRATION", "BUTTON_TEXT", string2) ? 1.0f : 0.0f;
        fArr[16] = l("ENGLISH", "COMPLETE_REGISTRATION", "PAGE_TITLE", str4) ? 1.0f : 0.0f;
        fArr[17] = l("ENGLISH", "COMPLETE_REGISTRATION", "BUTTON_ID", string) ? 1.0f : 0.0f;
        fArr[18] = v.J(str2, "password", false, 2, null) ? 1.0f : 0.0f;
        fArr[19] = k("(?i)(confirm.*password)|(password.*(confirmation|confirm)|confirmation)", str2) ? 1.0f : 0.0f;
        fArr[20] = k("(?i)(sign in)|login|signIn", str2) ? 1.0f : 0.0f;
        fArr[21] = k("(?i)(sign.*(up|now)|registration|register|(create|apply).*(profile|account)|open.*account|account.*(open|creation|application)|enroll|join.*now)", str2) ? 1.0f : 0.0f;
        fArr[22] = l("ENGLISH", "PURCHASE", "BUTTON_TEXT", string2) ? 1.0f : 0.0f;
        fArr[24] = l("ENGLISH", "PURCHASE", "PAGE_TITLE", str4) ? 1.0f : 0.0f;
        fArr[25] = k("(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart", string2) ? 1.0f : 0.0f;
        fArr[27] = k("(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart|shop|buy", str4) ? 1.0f : 0.0f;
        fArr[28] = l("ENGLISH", "LEAD", "BUTTON_TEXT", string2) ? 1.0f : 0.0f;
        fArr[29] = l("ENGLISH", "LEAD", "PAGE_TITLE", str4) ? 1.0f : 0.0f;
        return fArr;
    }

    private final float[] i(JSONObject jSONObject) {
        float[] fArr = new float[30];
        int i2 = 0;
        for (int i3 = 0; i3 < 30; i3++) {
            fArr[i3] = 0.0f;
        }
        String strOptString = jSONObject.optString(Command.CommandHandler.TEXT);
        m.e(strOptString, "node.optString(TEXT_KEY)");
        String lowerCase = strOptString.toLowerCase();
        m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
        String strOptString2 = jSONObject.optString("hint");
        m.e(strOptString2, "node.optString(HINT_KEY)");
        String lowerCase2 = strOptString2.toLowerCase();
        m.e(lowerCase2, "(this as java.lang.String).toLowerCase()");
        String strOptString3 = jSONObject.optString("classname");
        m.e(strOptString3, "node.optString(CLASS_NAME_KEY)");
        String lowerCase3 = strOptString3.toLowerCase();
        m.e(lowerCase3, "(this as java.lang.String).toLowerCase()");
        int iOptInt = jSONObject.optInt("inputtype", -1);
        String[] strArr = {lowerCase, lowerCase2};
        if (g(new String[]{"$", "amount", "price", "total"}, strArr)) {
            fArr[0] = fArr[0] + 1.0f;
        }
        if (g(new String[]{"password", "pwd"}, strArr)) {
            fArr[1] = fArr[1] + 1.0f;
        }
        if (g(new String[]{"tel", "phone"}, strArr)) {
            fArr[2] = fArr[2] + 1.0f;
        }
        if (g(new String[]{"search"}, strArr)) {
            fArr[4] = fArr[4] + 1.0f;
        }
        if (iOptInt >= 0) {
            fArr[5] = fArr[5] + 1.0f;
        }
        if (iOptInt == 3 || iOptInt == 2) {
            fArr[6] = fArr[6] + 1.0f;
        }
        if (iOptInt == 32 || Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
            fArr[7] = fArr[7] + 1.0f;
        }
        if (v.J(lowerCase3, "checkbox", false, 2, null)) {
            fArr[8] = fArr[8] + 1.0f;
        }
        if (g(new String[]{"complete", "confirm", "done", "submit"}, new String[]{lowerCase})) {
            fArr[10] = fArr[10] + 1.0f;
        }
        if (v.J(lowerCase3, "radio", false, 2, null) && v.J(lowerCase3, "button", false, 2, null)) {
            fArr[12] = fArr[12] + 1.0f;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childviews");
            int length = jSONArrayOptJSONArray.length();
            if (length > 0) {
                while (true) {
                    int i4 = i2 + 1;
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                    m.e(jSONObject2, "childViews.getJSONObject(i)");
                    m(fArr, i(jSONObject2));
                    if (i4 >= length) {
                        break;
                    }
                    i2 = i4;
                }
            }
        } catch (JSONException unused) {
        }
        return fArr;
    }

    private final boolean j(JSONObject jSONObject, JSONArray jSONArray) {
        boolean z;
        boolean z2;
        try {
            if (jSONObject.optBoolean("is_interacted")) {
                return true;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childviews");
            int length = jSONArrayOptJSONArray.length();
            if (length <= 0) {
                z = false;
                z2 = false;
                break;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (jSONArrayOptJSONArray.getJSONObject(i2).optBoolean("is_interacted")) {
                    z = true;
                    z2 = true;
                    break;
                }
                if (i3 >= length) {
                    z = false;
                    z2 = false;
                    break;
                }
                i2 = i3;
            }
            JSONArray jSONArray2 = new JSONArray();
            if (z) {
                int length2 = jSONArrayOptJSONArray.length();
                if (length2 > 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        jSONArray.put(jSONArrayOptJSONArray.getJSONObject(i4));
                        if (i5 >= length2) {
                            break;
                        }
                        i4 = i5;
                    }
                }
            } else {
                int length3 = jSONArrayOptJSONArray.length();
                if (length3 > 0) {
                    int i6 = 0;
                    while (true) {
                        int i7 = i6 + 1;
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i6);
                        m.e(jSONObject2, "child");
                        if (j(jSONObject2, jSONArray)) {
                            jSONArray2.put(jSONObject2);
                            z2 = true;
                        }
                        if (i7 >= length3) {
                            break;
                        }
                        i6 = i7;
                    }
                }
                jSONObject.put("childviews", jSONArray2);
            }
            return z2;
        } catch (JSONException unused) {
            return false;
        }
    }

    private final boolean k(String str, String str2) {
        return Pattern.compile(str).matcher(str2).find();
    }

    private final boolean l(String str, String str2, String str3, String str4) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        JSONObject jSONObjectOptJSONObject4;
        JSONObject jSONObject = f10518e;
        String strOptString = null;
        if (jSONObject == null) {
            m.w("rules");
            throw null;
        }
        JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("rulesForLanguage");
        if (jSONObjectOptJSONObject5 == null) {
            jSONObjectOptJSONObject = null;
        } else {
            Map<String, String> map = f10515b;
            if (map == null) {
                m.w("languageInfo");
                throw null;
            }
            jSONObjectOptJSONObject = jSONObjectOptJSONObject5.optJSONObject(map.get(str));
        }
        if (jSONObjectOptJSONObject == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rulesForEvent")) == null) {
            jSONObjectOptJSONObject3 = null;
        } else {
            Map<String, String> map2 = f10516c;
            if (map2 == null) {
                m.w("eventInfo");
                throw null;
            }
            jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(map2.get(str2));
        }
        if (jSONObjectOptJSONObject3 != null && (jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("positiveRules")) != null) {
            Map<String, String> map3 = f10517d;
            if (map3 == null) {
                m.w("textTypeInfo");
                throw null;
            }
            strOptString = jSONObjectOptJSONObject4.optString(map3.get(str3));
        }
        if (strOptString == null) {
            return false;
        }
        return k(strOptString, str4);
    }

    private final void m(float[] fArr, float[] fArr2) {
        int length = fArr.length - 1;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            fArr[i2] = fArr[i2] + fArr2[i2];
            if (i3 > length) {
                return;
            } else {
                i2 = i3;
            }
        }
    }

    private final void n(JSONObject jSONObject, StringBuilder sb, StringBuilder sb2) {
        int length;
        String strOptString = jSONObject.optString(Command.CommandHandler.TEXT, HttpUrl.FRAGMENT_ENCODE_SET);
        m.e(strOptString, "view.optString(TEXT_KEY, \"\")");
        String lowerCase = strOptString.toLowerCase();
        m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
        String strOptString2 = jSONObject.optString("hint", HttpUrl.FRAGMENT_ENCODE_SET);
        m.e(strOptString2, "view.optString(HINT_KEY, \"\")");
        String lowerCase2 = strOptString2.toLowerCase();
        m.e(lowerCase2, "(this as java.lang.String).toLowerCase()");
        int i2 = 0;
        if (lowerCase.length() > 0) {
            sb.append(lowerCase);
            sb.append(" ");
        }
        if (lowerCase2.length() > 0) {
            sb2.append(lowerCase2);
            sb2.append(" ");
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childviews");
        if (jSONArrayOptJSONArray == null || (length = jSONArrayOptJSONArray.length()) <= 0) {
            return;
        }
        while (true) {
            int i3 = i2 + 1;
            try {
                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                m.e(jSONObject2, "currentChildView");
                n(jSONObject2, sb, sb2);
            } catch (JSONException unused) {
            }
            if (i3 >= length) {
                return;
            } else {
                i2 = i3;
            }
        }
    }
}
