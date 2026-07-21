package com.facebook.o0.p0;

import android.os.Build;
import android.os.Bundle;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import com.facebook.a0;
import com.facebook.internal.c0;
import com.facebook.internal.d0;
import com.facebook.internal.p0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.m;
import kotlin.text.Regex;
import kotlin.text.u;
import kotlin.text.v;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MACARuleMatchingManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f10390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static JSONArray f10391c;
    public static final b a = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String[] f10392d = {"event", "_locale", "_appVersion", "_deviceOS", "_platform", "_deviceModel", "_nativeAppID", "_nativeAppShortVersion", "_timezone", "_carrier", "_deviceOSTypeName", "_deviceOSVersion", "_remainingDiskGB"};

    private b() {
    }

    public static final void a() {
        a.g();
        if (f10391c != null) {
            f10390b = true;
        }
    }

    public static final void b(Bundle bundle, String str) {
        String language;
        String country;
        m.f(bundle, "params");
        m.f(str, "event");
        bundle.putString("event", str);
        StringBuilder sb = new StringBuilder();
        p0 p0Var = p0.a;
        Locale localeG = p0Var.G();
        String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        if (localeG == null || (language = localeG.getLanguage()) == null) {
            language = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(language);
        sb.append('_');
        Locale localeG2 = p0Var.G();
        if (localeG2 == null || (country = localeG2.getCountry()) == null) {
            country = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(country);
        bundle.putString("_locale", sb.toString());
        String strN = p0Var.N();
        if (strN == null) {
            strN = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        bundle.putString("_appVersion", strN);
        bundle.putString("_deviceOS", "ANDROID");
        bundle.putString("_platform", "mobile");
        String str3 = Build.MODEL;
        if (str3 == null) {
            str3 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        bundle.putString("_deviceModel", str3);
        a0 a0Var = a0.a;
        bundle.putString("_nativeAppID", a0.d());
        String strN2 = p0Var.N();
        if (strN2 != null) {
            str2 = strN2;
        }
        bundle.putString("_nativeAppShortVersion", str2);
        bundle.putString("_timezone", p0Var.B());
        bundle.putString("_carrier", p0Var.w());
        bundle.putString("_deviceOSTypeName", "ANDROID");
        bundle.putString("_deviceOSVersion", Build.VERSION.RELEASE);
        bundle.putLong("_remainingDiskGB", p0Var.u());
    }

    public static final String c(JSONObject jSONObject) {
        m.f(jSONObject, "logic");
        Iterator<String> itKeys = jSONObject.keys();
        if (itKeys.hasNext()) {
            return itKeys.next();
        }
        return null;
    }

    public static final String d(Bundle bundle) {
        String strOptString;
        JSONArray jSONArray = f10391c;
        if (jSONArray == null) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        Integer numValueOf = jSONArray == null ? null : Integer.valueOf(jSONArray.length());
        if (numValueOf != null && numValueOf.intValue() == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        JSONArray jSONArray2 = f10391c;
        if (jSONArray2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int length = jSONArray2.length();
        if (length > 0) {
            while (true) {
                int i3 = i2 + 1;
                String strOptString2 = jSONArray2.optString(i2);
                if (strOptString2 != null) {
                    JSONObject jSONObject = new JSONObject(strOptString2);
                    long jOptLong = jSONObject.optLong(DeepLinkIntentReceiver.DeepLinksKeys.ID);
                    if (jOptLong != 0 && (strOptString = jSONObject.optString("rule")) != null && f(strOptString, bundle)) {
                        arrayList.add(Long.valueOf(jOptLong));
                    }
                }
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        String string = new JSONArray((Collection) arrayList).toString();
        m.e(string, "JSONArray(res).toString()");
        return string;
    }

    public static final ArrayList<String> e(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        int i2 = 0;
        int length = jSONArray.length();
        if (length > 0) {
            while (true) {
                int i3 = i2 + 1;
                arrayList.add(jSONArray.get(i2).toString());
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        return arrayList;
    }

    public static final boolean f(String str, Bundle bundle) throws JSONException {
        JSONObject jSONObject;
        String strC;
        int length;
        if (str == null || bundle == null || (strC = c((jSONObject = new JSONObject(str)))) == null) {
            return false;
        }
        Object obj = jSONObject.get(strC);
        int iHashCode = strC.hashCode();
        if (iHashCode != 3555) {
            if (iHashCode != 96727) {
                if (iHashCode == 109267 && strC.equals("not")) {
                    return !f(obj.toString(), bundle);
                }
            } else if (strC.equals("and")) {
                JSONArray jSONArray = (JSONArray) obj;
                if (jSONArray == null) {
                    return false;
                }
                int length2 = jSONArray.length();
                if (length2 > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2 + 1;
                        if (!f(jSONArray.get(i2).toString(), bundle)) {
                            return false;
                        }
                        if (i3 >= length2) {
                            break;
                        }
                        i2 = i3;
                    }
                }
                return true;
            }
        } else if (strC.equals("or")) {
            JSONArray jSONArray2 = (JSONArray) obj;
            if (jSONArray2 != null && (length = jSONArray2.length()) > 0) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    if (f(jSONArray2.get(i4).toString(), bundle)) {
                        return true;
                    }
                    if (i5 < length) {
                        i4 = i5;
                    }
                }
            }
            return false;
        }
        JSONObject jSONObject2 = (JSONObject) obj;
        if (jSONObject2 == null) {
            return false;
        }
        return j(strC, jSONObject2, bundle);
    }

    private final void g() {
        d0 d0Var = d0.a;
        a0 a0Var = a0.a;
        c0 c0VarO = d0.o(a0.d(), false);
        if (c0VarO == null) {
            return;
        }
        f10391c = c0VarO.f();
    }

    public static final void h(Bundle bundle, String str) {
        m.f(str, "event");
        if (!f10390b || bundle == null) {
            return;
        }
        try {
            b(bundle, str);
            bundle.putString("_audiencePropertyIds", d(bundle));
            bundle.putString("cs_maca", "1");
            i(bundle);
        } catch (Exception unused) {
        }
    }

    public static final void i(Bundle bundle) {
        m.f(bundle, "params");
        String[] strArr = f10392d;
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str = strArr[i2];
            i2++;
            bundle.remove(str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:139:0x023a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:144:0x0249 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:145:0x024a  */
    /* JADX WARN: Code duplicated, block: B:148:0x0251  */
    /* JADX WARN: Code duplicated, block: B:151:0x025b  */
    /* JADX WARN: Code duplicated, block: B:153:0x0263  */
    /* JADX WARN: Code duplicated, block: B:155:0x0272  */
    /* JADX WARN: Code duplicated, block: B:173:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:175:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:177:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:217:0x036a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:218:0x036b  */
    /* JADX WARN: Code duplicated, block: B:223:0x037f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:224:0x0380  */
    /* JADX WARN: Code duplicated, block: B:241:0x0288 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:242:0x0282 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:243:0x03be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:244:? A[LOOP:0: B:149:0x0255->B:244:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:245:0x02d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:246:0x023a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:248:0x02d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:249:? A[LOOP:1: B:171:0x02a7->B:249:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:253:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:254:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:255:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:256:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:258:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final boolean j(String str, JSONObject jSONObject, Bundle bundle) {
        Object obj;
        Locale locale;
        String lowerCase;
        String string;
        String lowerCase2;
        Locale locale2;
        String lowerCase3;
        String string2;
        String lowerCase4;
        m.f(str, "variable");
        m.f(jSONObject, "values");
        String strC = c(jSONObject);
        if (strC == null) {
            return false;
        }
        String string3 = jSONObject.get(strC).toString();
        ArrayList<String> arrayListE = e(jSONObject.optJSONArray(strC));
        if (m.a(strC, "exists")) {
            return m.a(bundle != null ? Boolean.valueOf(bundle.containsKey(str)) : null, Boolean.valueOf(Boolean.parseBoolean(string3)));
        }
        if (bundle == null) {
            obj = null;
        } else {
            String lowerCase5 = str.toLowerCase(Locale.ROOT);
            m.e(lowerCase5, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
            obj = bundle.get(lowerCase5);
        }
        if (obj == null) {
            obj = bundle == null ? null : bundle.get(str);
            if (obj == null) {
                return false;
            }
        }
        switch (strC.hashCode()) {
            case -1729128927:
                if (!strC.equals("i_not_contains")) {
                    return false;
                }
                String string4 = obj.toString();
                if (string4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                Locale locale3 = Locale.ROOT;
                String lowerCase6 = string4.toLowerCase(locale3);
                m.e(lowerCase6, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                if (string3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase7 = string3.toLowerCase(locale3);
                m.e(lowerCase7, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                if (v.J(lowerCase6, lowerCase7, false, 2, null)) {
                    return false;
                }
                return true;
            case -1179774633:
                if (!strC.equals("is_any")) {
                    return false;
                }
                if (arrayListE == null) {
                    return false;
                }
                return arrayListE.contains(obj.toString());
            case -1039699439:
                if (!strC.equals("not_in")) {
                    return false;
                }
                if (arrayListE == null) {
                    return false;
                }
                return arrayListE.contains(obj.toString());
            case -969266188:
                if (strC.equals("starts_with")) {
                    return u.E(obj.toString(), string3, false, 2, null);
                }
                return false;
            case -966353971:
                if (strC.equals("regex_match")) {
                    return new Regex(string3).b(obj.toString());
                }
                return false;
            case -665609109:
                if (!strC.equals("is_not_any")) {
                    return false;
                }
                if (arrayListE == null) {
                    return false;
                }
                return arrayListE.contains(obj.toString());
            case -567445985:
                if (strC.equals("contains")) {
                    return v.J(obj.toString(), string3, false, 2, null);
                }
                return false;
            case -327990090:
                if (!strC.equals("i_str_neq")) {
                    return false;
                }
                String string5 = obj.toString();
                if (string5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                Locale locale4 = Locale.ROOT;
                String lowerCase8 = string5.toLowerCase(locale4);
                m.e(lowerCase8, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                if (string3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase9 = string3.toLowerCase(locale4);
                m.e(lowerCase9, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                if (m.a(lowerCase8, lowerCase9)) {
                    return false;
                }
                return true;
            case -159812115:
                if (!strC.equals("i_is_any")) {
                    return false;
                }
                if (arrayListE != null || arrayListE.isEmpty()) {
                    return false;
                }
                for (String str2 : arrayListE) {
                    if (str2 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    locale = Locale.ROOT;
                    lowerCase = str2.toLowerCase(locale);
                    m.e(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    string = obj.toString();
                    if (string != null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    lowerCase2 = string.toLowerCase(locale);
                    m.e(lowerCase2, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    if (m.a(lowerCase, lowerCase2)) {
                        return true;
                    }
                }
                return false;
            case -92753547:
                if (!strC.equals("i_str_not_in")) {
                    return false;
                }
                if (arrayListE == null) {
                    return false;
                }
                if (!arrayListE.isEmpty()) {
                    for (String str3 : arrayListE) {
                        if (str3 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        locale2 = Locale.ROOT;
                        lowerCase3 = str3.toLowerCase(locale2);
                        m.e(lowerCase3, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                        string2 = obj.toString();
                        if (string2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        lowerCase4 = string2.toLowerCase(locale2);
                        m.e(lowerCase4, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                        if (!(!m.a(lowerCase3, lowerCase4))) {
                            return false;
                        }
                    }
                }
                return true;
            case 60:
                if (!strC.equals("<")) {
                    return false;
                }
                if (Double.parseDouble(obj.toString()) < Double.parseDouble(string3)) {
                    return true;
                }
                return false;
            case 61:
                if (!strC.equals("=")) {
                    return false;
                }
                return m.a(obj.toString(), string3);
            case 62:
                if (!strC.equals(">")) {
                    return false;
                }
                if (Double.parseDouble(obj.toString()) > Double.parseDouble(string3)) {
                    return true;
                }
                return false;
            case 1084:
                if (!strC.equals("!=")) {
                    return false;
                }
                if (m.a(obj.toString(), string3)) {
                    return false;
                }
                return true;
            case 1921:
                if (!strC.equals("<=")) {
                    return false;
                }
                if (Double.parseDouble(obj.toString()) <= Double.parseDouble(string3)) {
                    return true;
                }
                return false;
            case 1952:
                if (!strC.equals("==")) {
                    return false;
                }
                return m.a(obj.toString(), string3);
            case 1983:
                if (!strC.equals(">=")) {
                    return false;
                }
                if (Double.parseDouble(obj.toString()) >= Double.parseDouble(string3)) {
                    return true;
                }
                return false;
            case 3244:
                if (!strC.equals("eq")) {
                    return false;
                }
                return m.a(obj.toString(), string3);
            case 3294:
                if (!strC.equals("ge")) {
                    return false;
                }
                if (Double.parseDouble(obj.toString()) >= Double.parseDouble(string3)) {
                    return true;
                }
                return false;
            case 3309:
                if (!strC.equals("gt")) {
                    return false;
                }
                if (Double.parseDouble(obj.toString()) > Double.parseDouble(string3)) {
                    return true;
                }
                return false;
            case 3365:
                if (!strC.equals("in")) {
                    return false;
                }
                if (arrayListE == null) {
                    return false;
                }
                return arrayListE.contains(obj.toString());
            case 3449:
                if (!strC.equals("le")) {
                    return false;
                }
                if (Double.parseDouble(obj.toString()) <= Double.parseDouble(string3)) {
                    return true;
                }
                return false;
            case 3464:
                if (!strC.equals("lt")) {
                    return false;
                }
                if (Double.parseDouble(obj.toString()) < Double.parseDouble(string3)) {
                    return true;
                }
                return false;
            case 3511:
                if (!strC.equals("ne")) {
                    return false;
                }
                if (m.a(obj.toString(), string3)) {
                    return true;
                }
                return false;
            case 102680:
                if (!strC.equals("gte")) {
                    return false;
                }
                if (Double.parseDouble(obj.toString()) >= Double.parseDouble(string3)) {
                    return true;
                }
                return false;
            case 107485:
                if (!strC.equals("lte")) {
                    return false;
                }
                if (Double.parseDouble(obj.toString()) <= Double.parseDouble(string3)) {
                    return true;
                }
                return false;
            case 108954:
                if (!strC.equals("neq")) {
                    return false;
                }
                if (m.a(obj.toString(), string3)) {
                    return true;
                }
                return false;
            case 127966736:
                if (!strC.equals("i_str_eq")) {
                    return false;
                }
                String string6 = obj.toString();
                if (string6 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                Locale locale5 = Locale.ROOT;
                String lowerCase10 = string6.toLowerCase(locale5);
                m.e(lowerCase10, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                if (string3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase11 = string3.toLowerCase(locale5);
                m.e(lowerCase11, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                return m.a(lowerCase10, lowerCase11);
            case 127966857:
                if (!strC.equals("i_str_in")) {
                    return false;
                }
                if (arrayListE != null) {
                    return false;
                }
                while (r8.hasNext()) {
                    if (str2 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    locale = Locale.ROOT;
                    lowerCase = str2.toLowerCase(locale);
                    m.e(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    string = obj.toString();
                    if (string != null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    lowerCase2 = string.toLowerCase(locale);
                    m.e(lowerCase2, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    if (m.a(lowerCase, lowerCase2)) {
                        return true;
                    }
                }
                return false;
            case 363990325:
                if (!strC.equals("i_contains")) {
                    return false;
                }
                String string7 = obj.toString();
                if (string7 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                Locale locale6 = Locale.ROOT;
                String lowerCase12 = string7.toLowerCase(locale6);
                m.e(lowerCase12, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                if (string3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase13 = string3.toLowerCase(locale6);
                m.e(lowerCase13, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                return v.J(lowerCase12, lowerCase13, false, 2, null);
            case 1091487233:
                if (!strC.equals("i_is_not_any")) {
                    return false;
                }
                if (arrayListE == null) {
                    return false;
                }
                if (!arrayListE.isEmpty()) {
                    while (r8.hasNext()) {
                        if (str3 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        locale2 = Locale.ROOT;
                        lowerCase3 = str3.toLowerCase(locale2);
                        m.e(lowerCase3, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                        string2 = obj.toString();
                        if (string2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        lowerCase4 = string2.toLowerCase(locale2);
                        m.e(lowerCase4, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                        if (!(!m.a(lowerCase3, lowerCase4))) {
                            return false;
                        }
                    }
                }
                return true;
            case 1918401035:
                if (strC.equals("not_contains") && !v.J(obj.toString(), string3, false, 2, null)) {
                    return true;
                }
                return false;
            case 1961112862:
                if (!strC.equals("i_starts_with")) {
                    return false;
                }
                String string8 = obj.toString();
                if (string8 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                Locale locale7 = Locale.ROOT;
                String lowerCase14 = string8.toLowerCase(locale7);
                m.e(lowerCase14, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                if (string3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase15 = string3.toLowerCase(locale7);
                m.e(lowerCase15, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                return u.E(lowerCase14, lowerCase15, false, 2, null);
            default:
                return false;
        }
    }
}
