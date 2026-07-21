package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.database.room.RoomNotification;
import cm.aptoide.pt.dataprovider.BuildConfig;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: compiled from: Utility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class p0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f9817b;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Locale f9825j;
    public static final p0 a = new p0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f9818c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f9819d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f9820e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f9821f = HttpUrl.FRAGMENT_ENCODE_SET;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f9822g = HttpUrl.FRAGMENT_ENCODE_SET;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f9823h = "NoCarrier";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f9824i = HttpUrl.FRAGMENT_ENCODE_SET;

    /* JADX INFO: compiled from: Utility.kt */
    public interface a {
        void a(JSONObject jSONObject);

        void b(FacebookException facebookException);
    }

    private p0() {
    }

    public static final JSONObject A() {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        String string = com.facebook.a0.c().getSharedPreferences("com.facebook.sdk.DataProcessingOptions", 0).getString("data_processing_options", null);
        if (string != null) {
            try {
                return new JSONObject(string);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private final void A0() {
        try {
            if (p()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                f9819d = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            }
            f9819d = j(f9819d);
        } catch (Exception unused) {
        }
    }

    public static final void B0(Runnable runnable) {
        try {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            com.facebook.a0.k().execute(runnable);
        } catch (Exception unused) {
        }
    }

    public static final String C(String str) {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        String strL = com.facebook.a0.l();
        if (str == null) {
            return strL;
        }
        if (kotlin.jvm.internal.m.a(str, "gaming")) {
            return kotlin.text.u.A(strL, "facebook.com", "fb.gg", false, 4, null);
        }
        return kotlin.jvm.internal.m.a(str, "instagram") ? kotlin.text.u.A(strL, "facebook.com", "instagram.com", false, 4, null) : strL;
    }

    public static final void C0(JSONObject jSONObject, q qVar, String str, boolean z, Context context) throws JSONException {
        kotlin.jvm.internal.m.f(jSONObject, "params");
        kotlin.jvm.internal.m.f(context, "context");
        a0 a0Var = a0.a;
        a0.b bVar = a0.b.ServiceUpdateCompliance;
        if (!a0.g(bVar)) {
            jSONObject.put("anon_id", str);
        }
        jSONObject.put("application_tracking_enabled", !z);
        com.facebook.a0 a0Var2 = com.facebook.a0.a;
        jSONObject.put("advertiser_id_collection_enabled", com.facebook.a0.b());
        if (qVar != null) {
            if (a0.g(bVar)) {
                a.a(jSONObject, qVar, str, context);
            }
            if (qVar.j() != null) {
                if (a0.g(bVar)) {
                    a.b(jSONObject, qVar, context);
                } else {
                    jSONObject.put("attribution", qVar.j());
                }
            }
            if (qVar.h() != null) {
                jSONObject.put("advertiser_id", qVar.h());
                jSONObject.put("advertiser_tracking_enabled", !qVar.k());
            }
            if (!qVar.k()) {
                com.facebook.o0.j0 j0Var = com.facebook.o0.j0.a;
                String strA = com.facebook.o0.j0.a();
                if (!(strA.length() == 0)) {
                    jSONObject.put("ud", strA);
                }
            }
            if (qVar.i() != null) {
                jSONObject.put("installer_package", qVar.i());
            }
        }
    }

    private final GraphRequest D(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", K(z()));
        bundle.putString("access_token", str);
        GraphRequest graphRequestY = GraphRequest.a.y(null, null);
        graphRequestY.H(bundle);
        graphRequestY.G(com.facebook.e0.GET);
        return graphRequestY;
    }

    public static final void D0(JSONObject jSONObject, Context context) throws JSONException {
        Locale locale;
        String language;
        int i2;
        String country;
        kotlin.jvm.internal.m.f(jSONObject, "params");
        kotlin.jvm.internal.m.f(context, "appContext");
        JSONArray jSONArray = new JSONArray();
        p0 p0Var = a;
        jSONArray.put("a2");
        p0Var.y0(context);
        String packageName = context.getPackageName();
        int i3 = 0;
        int i4 = -1;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            if (packageInfo == null) {
                return;
            }
            i4 = packageInfo.versionCode;
            f9824i = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        jSONArray.put(packageName);
        jSONArray.put(i4);
        jSONArray.put(f9824i);
        jSONArray.put(Build.VERSION.RELEASE);
        jSONArray.put(Build.MODEL);
        try {
            locale = context.getResources().getConfiguration().locale;
        } catch (Exception unused2) {
            locale = Locale.getDefault();
        }
        f9825j = locale;
        StringBuilder sb = new StringBuilder();
        Locale locale2 = f9825j;
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        if (locale2 == null || (language = locale2.getLanguage()) == null) {
            language = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(language);
        sb.append('_');
        Locale locale3 = f9825j;
        if (locale3 != null && (country = locale3.getCountry()) != null) {
            str = country;
        }
        sb.append(str);
        jSONArray.put(sb.toString());
        jSONArray.put(f9821f);
        jSONArray.put(f9823h);
        double d2 = 0.0d;
        try {
            Display defaultDisplay = null;
            if (Build.VERSION.SDK_INT >= 17) {
                Object systemService = context.getSystemService("display");
                DisplayManager displayManager = systemService instanceof DisplayManager ? (DisplayManager) systemService : null;
                if (displayManager != null) {
                    defaultDisplay = displayManager.getDisplay(0);
                }
            } else {
                Object systemService2 = context.getSystemService("window");
                WindowManager windowManager = systemService2 instanceof WindowManager ? (WindowManager) systemService2 : null;
                if (windowManager != null) {
                    defaultDisplay = windowManager.getDefaultDisplay();
                }
            }
            if (defaultDisplay != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                int i5 = displayMetrics.widthPixels;
                try {
                    int i6 = displayMetrics.heightPixels;
                    try {
                        d2 = displayMetrics.density;
                    } catch (Exception unused3) {
                    }
                    i2 = i6;
                    i3 = i5;
                } catch (Exception unused4) {
                    i3 = i5;
                    i2 = 0;
                }
            } else {
                i2 = 0;
            }
        } catch (Exception unused5) {
        }
        jSONArray.put(i3);
        jSONArray.put(i2);
        jSONArray.put(new DecimalFormat("#.##").format(d2));
        jSONArray.put(a.v0());
        jSONArray.put(f9819d);
        jSONArray.put(f9820e);
        jSONArray.put(f9822g);
        jSONObject.put("extinfo", jSONArray.toString());
    }

    public static final void E(final String str, final a aVar) {
        kotlin.jvm.internal.m.f(str, "accessToken");
        kotlin.jvm.internal.m.f(aVar, "callback");
        m0 m0Var = m0.a;
        JSONObject jSONObjectA = m0.a(str);
        if (jSONObjectA != null) {
            aVar.a(jSONObjectA);
            return;
        }
        GraphRequest.b bVar = new GraphRequest.b() { // from class: com.facebook.internal.k
            @Override // com.facebook.GraphRequest.b
            public final void b(com.facebook.d0 d0Var) {
                p0.F(aVar, str, d0Var);
            }
        };
        GraphRequest graphRequestD = a.D(str);
        graphRequestD.D(bVar);
        graphRequestD.k();
    }

    public static final String E0(byte[] bArr) {
        kotlin.jvm.internal.m.f(bArr, "bytes");
        return a.Q("SHA-1", bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(a aVar, String str, com.facebook.d0 d0Var) {
        kotlin.jvm.internal.m.f(aVar, "$callback");
        kotlin.jvm.internal.m.f(str, "$accessToken");
        kotlin.jvm.internal.m.f(d0Var, "response");
        if (d0Var.b() != null) {
            aVar.b(d0Var.b().e());
            return;
        }
        m0 m0Var = m0.a;
        JSONObject jSONObjectD = d0Var.d();
        if (jSONObjectD == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        m0.b(str, jSONObjectD);
        aVar.a(d0Var.d());
    }

    public static final String F0(String str) {
        if (str == null) {
            return null;
        }
        return a.P("SHA-256", str);
    }

    public static final void G0(Parcel parcel, Map<String, String> map) {
        kotlin.jvm.internal.m.f(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            parcel.writeString(key);
            parcel.writeString(value);
        }
    }

    public static final String H(Context context) {
        q0 q0Var = q0.a;
        q0.j(context, "context");
        com.facebook.a0 a0Var = com.facebook.a0.a;
        return com.facebook.a0.d();
    }

    public static final void H0(Parcel parcel, Map<String, String> map) {
        kotlin.jvm.internal.m.f(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            parcel.writeString(key);
            parcel.writeString(value);
        }
    }

    public static final Method I(Class<?> cls, String str, Class<?>... clsArr) {
        kotlin.jvm.internal.m.f(cls, "clazz");
        kotlin.jvm.internal.m.f(str, "methodName");
        kotlin.jvm.internal.m.f(clsArr, "parameterTypes");
        try {
            return cls.getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static final Method J(String str, String str2, Class<?>... clsArr) {
        kotlin.jvm.internal.m.f(str, "className");
        kotlin.jvm.internal.m.f(str2, "methodName");
        kotlin.jvm.internal.m.f(clsArr, "parameterTypes");
        try {
            Class<?> cls = Class.forName(str);
            kotlin.jvm.internal.m.e(cls, "clazz");
            return I(cls, str2, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private final String K(String str) {
        return kotlin.jvm.internal.m.a(str, "instagram") ? "id,name,profile_picture" : "id,name,first_name,middle_name,last_name";
    }

    public static final Locale L() {
        try {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            return com.facebook.a0.c().getResources().getConfiguration().locale;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Object M(JSONObject jSONObject, String str, String str2) throws JSONException {
        kotlin.jvm.internal.m.f(jSONObject, "jsonObject");
        Object objOpt = jSONObject.opt(str);
        if (objOpt != null && (objOpt instanceof String)) {
            objOpt = new JSONTokener((String) objOpt).nextValue();
        }
        if (objOpt == null || (objOpt instanceof JSONObject) || (objOpt instanceof JSONArray)) {
            return objOpt;
        }
        if (str2 == null) {
            throw new FacebookException("Got an unexpected non-JSON object.");
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.putOpt(str2, objOpt);
        return jSONObject2;
    }

    private final String O(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] bArrDigest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        kotlin.jvm.internal.m.e(bArrDigest, "digest");
        int length = bArrDigest.length;
        int i2 = 0;
        while (i2 < length) {
            byte b2 = bArrDigest[i2];
            i2++;
            sb.append(Integer.toHexString((b2 >> 4) & 15));
            sb.append(Integer.toHexString((b2 >> 0) & 15));
        }
        String string = sb.toString();
        kotlin.jvm.internal.m.e(string, "builder.toString()");
        return string;
    }

    private final String P(String str, String str2) {
        Charset charset = Charsets.f25054b;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str2.getBytes(charset);
        kotlin.jvm.internal.m.e(bytes, "(this as java.lang.String).getBytes(charset)");
        return Q(str, bytes);
    }

    private final String Q(String str, byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            kotlin.jvm.internal.m.e(messageDigest, "hash");
            return O(messageDigest, bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static final Object R(Object obj, Method method, Object... objArr) {
        kotlin.jvm.internal.m.f(method, "method");
        kotlin.jvm.internal.m.f(objArr, "args");
        try {
            return method.invoke(obj, Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static final boolean S() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            com.facebook.a0 a0Var = com.facebook.a0.a;
            String str = String.format("fb%s://applinks", Arrays.copyOf(new Object[]{com.facebook.a0.d()}, 1));
            kotlin.jvm.internal.m.e(str, "java.lang.String.format(format, *args)");
            intent.setData(Uri.parse(str));
            Context contextC = com.facebook.a0.c();
            PackageManager packageManager = contextC.getPackageManager();
            String packageName = contextC.getPackageName();
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            kotlin.jvm.internal.m.e(listQueryIntentActivities, "packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)");
            Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
            while (it.hasNext()) {
                if (kotlin.jvm.internal.m.a(packageName, it.next().activityInfo.packageName)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static final boolean T(Context context) {
        AutofillManager autofillManager;
        kotlin.jvm.internal.m.f(context, "context");
        return Build.VERSION.SDK_INT >= 26 && (autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class)) != null && autofillManager.isAutofillSupported() && autofillManager.isEnabled();
    }

    public static final boolean U(Context context) {
        kotlin.jvm.internal.m.f(context, "context");
        if (Build.VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        String str = Build.DEVICE;
        if (str != null) {
            kotlin.jvm.internal.m.e(str, "DEVICE");
            if (new Regex(".+_cheets|cheets_.+").b(str)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean V(Uri uri) {
        return uri != null && kotlin.text.u.q("content", uri.getScheme(), true);
    }

    public static final boolean W(AccessToken accessToken) {
        return accessToken != null && kotlin.jvm.internal.m.a(accessToken, AccessToken.f9559f.e());
    }

    public static final boolean X() {
        JSONObject jSONObjectA = A();
        if (jSONObjectA == null) {
            return false;
        }
        try {
            JSONArray jSONArray = jSONObjectA.getJSONArray("data_processing_options");
            int length = jSONArray.length();
            if (length > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    String string = jSONArray.getString(i2);
                    kotlin.jvm.internal.m.e(string, "options.getString(i)");
                    String lowerCase = string.toLowerCase();
                    kotlin.jvm.internal.m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
                    if (kotlin.jvm.internal.m.a(lowerCase, "ldu")) {
                        return true;
                    }
                    if (i3 < length) {
                        i2 = i3;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static final boolean Y(Uri uri) {
        return uri != null && kotlin.text.u.q("file", uri.getScheme(), true);
    }

    private final boolean Z(Context context) {
        Method methodJ = J("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
        if (methodJ == null) {
            return false;
        }
        Object objR = R(null, methodJ, context);
        return (objR instanceof Integer) && kotlin.jvm.internal.m.a(objR, 0);
    }

    private final void a(JSONObject jSONObject, q qVar, String str, Context context) throws JSONException {
        if (Build.VERSION.SDK_INT < 31 || !Z(context)) {
            jSONObject.put("anon_id", str);
        } else {
            if (qVar.k()) {
                return;
            }
            jSONObject.put("anon_id", str);
        }
    }

    public static final boolean a0(String str) {
        if (str != null) {
            if (!(str.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    private final void b(JSONObject jSONObject, q qVar, Context context) throws JSONException {
        if (Build.VERSION.SDK_INT < 31 || !Z(context)) {
            jSONObject.put("attribution", qVar.j());
        } else {
            if (qVar.k()) {
                return;
            }
            jSONObject.put("attribution", qVar.j());
        }
    }

    public static final boolean b0(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static final <T> boolean c(T t, T t2) {
        if (t == null) {
            return t2 == null;
        }
        return kotlin.jvm.internal.m.a(t, t2);
    }

    public static final boolean c0(Uri uri) {
        return uri != null && (kotlin.text.u.q("http", uri.getScheme(), true) || kotlin.text.u.q(BuildConfig.APTOIDE_WEB_SERVICES_SCHEME, uri.getScheme(), true) || kotlin.text.u.q("fbstaging", uri.getScheme(), true));
    }

    public static final JSONObject d(String str) {
        kotlin.jvm.internal.m.f(str, "accessToken");
        m0 m0Var = m0.a;
        JSONObject jSONObjectA = m0.a(str);
        if (jSONObjectA != null) {
            return jSONObjectA;
        }
        com.facebook.d0 d0VarJ = a.D(str).j();
        if (d0VarJ.b() != null) {
            return null;
        }
        return d0VarJ.d();
    }

    public static final Set<String> d0(JSONArray jSONArray) throws JSONException {
        kotlin.jvm.internal.m.f(jSONArray, "jsonArray");
        HashSet hashSet = new HashSet();
        int length = jSONArray.length();
        if (length > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                String string = jSONArray.getString(i2);
                kotlin.jvm.internal.m.e(string, "jsonArray.getString(i)");
                hashSet.add(string);
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        return hashSet;
    }

    public static final Uri e(String str, String str2, Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(BuildConfig.APTOIDE_WEB_SERVICES_SCHEME);
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str3, (String) obj);
                }
            }
        }
        Uri uriBuild = builder.build();
        kotlin.jvm.internal.m.e(uriBuild, "builder.build()");
        return uriBuild;
    }

    public static final List<String> e0(JSONArray jSONArray) throws JSONException {
        kotlin.jvm.internal.m.f(jSONArray, "jsonArray");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        if (length > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                arrayList.add(jSONArray.getString(i2));
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        return arrayList;
    }

    private final void f(Context context, String str) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager cookieManager = CookieManager.getInstance();
        String cookie = cookieManager.getCookie(str);
        if (cookie == null) {
            return;
        }
        Object[] array = kotlin.text.v.v0(cookie, new String[]{";"}, false, 0, 6, null).toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String[] strArr = (String[]) array;
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str2 = strArr[i2];
            i2++;
            Object[] array2 = kotlin.text.v.v0(str2, new String[]{"="}, false, 0, 6, null).toArray(new String[0]);
            if (array2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr2 = (String[]) array2;
            if (strArr2.length > 0) {
                String str3 = strArr2[0];
                int length2 = str3.length() - 1;
                int i3 = 0;
                boolean z = false;
                while (i3 <= length2) {
                    boolean z2 = kotlin.jvm.internal.m.h(str3.charAt(!z ? i3 : length2), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        } else {
                            length2--;
                        }
                    } else if (z2) {
                        i3++;
                    } else {
                        z = true;
                    }
                }
                cookieManager.setCookie(str, kotlin.jvm.internal.m.n(str3.subSequence(i3, length2 + 1).toString(), "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;"));
            }
        }
        cookieManager.removeExpiredCookie();
    }

    public static final Map<String, String> f0(String str) {
        kotlin.jvm.internal.m.f(str, "str");
        if (str.length() == 0) {
            return new HashMap();
        }
        try {
            HashMap map = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                kotlin.jvm.internal.m.e(next, RoomNotification.KEY);
                String string = jSONObject.getString(next);
                kotlin.jvm.internal.m.e(string, "jsonObject.getString(key)");
                map.put(next, string);
            }
            return map;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    public static final void g(Context context) {
        kotlin.jvm.internal.m.f(context, "context");
        try {
            p0 p0Var = a;
            p0Var.f(context, "facebook.com");
            p0Var.f(context, ".facebook.com");
            p0Var.f(context, "https://facebook.com");
            p0Var.f(context, "https://.facebook.com");
        } catch (Exception unused) {
        }
    }

    public static final void h(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static final String i(String str, String str2) {
        return a0(str) ? str2 : str;
    }

    public static final void i0(String str, Exception exc) {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        if (!com.facebook.a0.u() || str == null || exc == null) {
            return;
        }
        Log.d(str, exc.getClass().getSimpleName() + ": " + ((Object) exc.getMessage()));
    }

    private final long j(double d2) {
        return Math.round(d2 / 1.073741824E9d);
    }

    public static final void j0(String str, String str2) {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        if (!com.facebook.a0.u() || str == null || str2 == null) {
            return;
        }
        Log.d(str, str2);
    }

    public static final List<String> k(JSONArray jSONArray) {
        kotlin.jvm.internal.m.f(jSONArray, "jsonArray");
        try {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            int length = jSONArray.length();
            if (length <= 0) {
                return arrayList;
            }
            while (true) {
                int i3 = i2 + 1;
                String string = jSONArray.getString(i2);
                kotlin.jvm.internal.m.e(string, "jsonArray.getString(i)");
                arrayList.add(string);
                if (i3 >= length) {
                    return arrayList;
                }
                i2 = i3;
            }
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    public static final void k0(String str, String str2, Throwable th) {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        if (!com.facebook.a0.u() || a0(str)) {
            return;
        }
        Log.d(str, str2, th);
    }

    public static final Map<String, Object> l(JSONObject jSONObject) {
        kotlin.jvm.internal.m.f(jSONObject, "jsonObject");
        HashMap map = new HashMap();
        JSONArray jSONArrayNames = jSONObject.names();
        if (jSONArrayNames == null) {
            return map;
        }
        int i2 = 0;
        int length = jSONArrayNames.length();
        if (length > 0) {
            while (true) {
                int i3 = i2 + 1;
                try {
                    String string = jSONArrayNames.getString(i2);
                    kotlin.jvm.internal.m.e(string, "keys.getString(i)");
                    Object objL = jSONObject.get(string);
                    if (objL instanceof JSONObject) {
                        objL = l((JSONObject) objL);
                    }
                    kotlin.jvm.internal.m.e(objL, "value");
                    map.put(string, objL);
                } catch (JSONException unused) {
                }
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        return map;
    }

    public static final String l0(Map<String, String> map) {
        kotlin.jvm.internal.m.f(map, "map");
        boolean zIsEmpty = map.isEmpty();
        String string = HttpUrl.FRAGMENT_ENCODE_SET;
        if (!zIsEmpty) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                string = jSONObject.toString();
            } catch (JSONException unused) {
            }
            kotlin.jvm.internal.m.e(string, "{\n      try {\n        val jsonObject = JSONObject()\n        for ((key, value) in map) {\n          jsonObject.put(key, value)\n        }\n        jsonObject.toString()\n      } catch (_e: JSONException) {\n        \"\"\n      }\n    }");
        }
        return string;
    }

    public static final Map<String, String> m(JSONObject jSONObject) {
        kotlin.jvm.internal.m.f(jSONObject, "jsonObject");
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = jSONObject.optString(next);
            if (strOptString != null) {
                kotlin.jvm.internal.m.e(next, RoomNotification.KEY);
                map.put(next, strOptString);
            }
        }
        return map;
    }

    public static final String m0(String str) {
        kotlin.jvm.internal.m.f(str, RoomNotification.KEY);
        return a.P("MD5", str);
    }

    public static final int n(InputStream inputStream, OutputStream outputStream) throws Throwable {
        kotlin.jvm.internal.m.f(outputStream, "outputStream");
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            try {
                byte[] bArr = new byte[8192];
                int i2 = 0;
                while (true) {
                    int i3 = bufferedInputStream2.read(bArr);
                    if (i3 == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, i3);
                    i2 += i3;
                }
                bufferedInputStream2.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                return i2;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static final boolean n0(Context context) {
        kotlin.jvm.internal.m.f(context, "context");
        return T(context);
    }

    public static final void o(URLConnection uRLConnection) {
        if (uRLConnection == null || !(uRLConnection instanceof HttpURLConnection)) {
            return;
        }
        ((HttpURLConnection) uRLConnection).disconnect();
    }

    public static final Bundle o0(String str) {
        Bundle bundle = new Bundle();
        if (!a0(str)) {
            if (str == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            Object[] array = kotlin.text.v.v0(str, new String[]{"&"}, false, 0, 6, null).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            int length = strArr.length;
            int i2 = 0;
            while (i2 < length) {
                String str2 = strArr[i2];
                i2++;
                Object[] array2 = kotlin.text.v.v0(str2, new String[]{"="}, false, 0, 6, null).toArray(new String[0]);
                if (array2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                String[] strArr2 = (String[]) array2;
                try {
                    if (strArr2.length == 2) {
                        bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), URLDecoder.decode(strArr2[1], "UTF-8"));
                    } else if (strArr2.length == 1) {
                        bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), HttpUrl.FRAGMENT_ENCODE_SET);
                    }
                } catch (UnsupportedEncodingException e2) {
                    i0("FacebookSDK", e2);
                }
            }
        }
        return bundle;
    }

    private final boolean p() {
        return kotlin.jvm.internal.m.a("mounted", Environment.getExternalStorageState());
    }

    public static final boolean p0(Bundle bundle, String str, Object obj) {
        kotlin.jvm.internal.m.f(bundle, "bundle");
        if (obj == null) {
            bundle.remove(str);
            return true;
        }
        if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return true;
        }
        if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
            return true;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Number) obj).doubleValue());
            return true;
        }
        if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
            return true;
        }
        if (obj instanceof Integer) {
            bundle.putInt(str, ((Number) obj).intValue());
            return true;
        }
        if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
            return true;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Number) obj).longValue());
            return true;
        }
        if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
            return true;
        }
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return true;
        }
        if (obj instanceof JSONArray) {
            bundle.putString(str, ((JSONArray) obj).toString());
            return true;
        }
        if (!(obj instanceof JSONObject)) {
            return false;
        }
        bundle.putString(str, ((JSONObject) obj).toString());
        return true;
    }

    public static final String q(int i2) {
        String string = new BigInteger(i2 * 5, new Random()).toString(32);
        kotlin.jvm.internal.m.e(string, "BigInteger(length * 5, r).toString(32)");
        return string;
    }

    public static final void q0(Bundle bundle, String str, String str2) {
        kotlin.jvm.internal.m.f(bundle, "b");
        if (a0(str2)) {
            return;
        }
        bundle.putString(str, str2);
    }

    public static final String r(Context context) {
        if (context == null) {
            return "null";
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        String simpleName = context.getClass().getSimpleName();
        kotlin.jvm.internal.m.e(simpleName, "{\n      context.javaClass.simpleName\n    }");
        return simpleName;
    }

    public static final Map<String, String> r0(Parcel parcel) {
        kotlin.jvm.internal.m.f(parcel, "parcel");
        int i2 = parcel.readInt();
        if (i2 < 0) {
            return null;
        }
        HashMap map = new HashMap();
        int i3 = 0;
        if (i2 > 0) {
            do {
                i3++;
                String string = parcel.readString();
                String string2 = parcel.readString();
                if (string != null && string2 != null) {
                    map.put(string, string2);
                }
            } while (i3 < i2);
        }
        return map;
    }

    public static final String s(Context context) {
        String string;
        kotlin.jvm.internal.m.f(context, "context");
        try {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            String strE = com.facebook.a0.e();
            if (strE != null) {
                return strE;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i2 = applicationInfo.labelRes;
            if (i2 == 0) {
                string = applicationInfo.nonLocalizedLabel.toString();
            } else {
                string = context.getString(i2);
                kotlin.jvm.internal.m.e(string, "context.getString(stringId)");
            }
            return string;
        } catch (Exception unused) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    public static final String s0(InputStream inputStream) throws Throwable {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        InputStreamReader inputStreamReader;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
                try {
                    StringBuilder sb = new StringBuilder();
                    char[] cArr = new char[RecyclerView.l.FLAG_MOVED];
                    while (true) {
                        int i2 = inputStreamReader.read(cArr);
                        if (i2 == -1) {
                            String string = sb.toString();
                            kotlin.jvm.internal.m.e(string, "{\n      bufferedInputStream = BufferedInputStream(inputStream)\n      reader = InputStreamReader(bufferedInputStream)\n      val stringBuilder = StringBuilder()\n      val bufferSize = 1024 * 2\n      val buffer = CharArray(bufferSize)\n      var n = 0\n      while (reader.read(buffer).also { n = it } != -1) {\n        stringBuilder.append(buffer, 0, n)\n      }\n      stringBuilder.toString()\n    }");
                            h(bufferedInputStream);
                            h(inputStreamReader);
                            return string;
                        }
                        sb.append(cArr, 0, i2);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    h(bufferedInputStream);
                    h(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
            }
        } catch (Throwable th4) {
            bufferedInputStream = null;
            th = th4;
            inputStreamReader = null;
        }
    }

    public static final String t() {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        Context contextC = com.facebook.a0.c();
        if (contextC == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = contextC.getPackageManager().getPackageInfo(contextC.getPackageName(), 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static final Map<String, String> t0(Parcel parcel) {
        kotlin.jvm.internal.m.f(parcel, "parcel");
        int i2 = parcel.readInt();
        if (i2 < 0) {
            return null;
        }
        HashMap map = new HashMap();
        int i3 = 0;
        if (i2 > 0) {
            do {
                i3++;
                map.put(parcel.readString(), parcel.readString());
            } while (i3 < i2);
        }
        return map;
    }

    private final void u0() {
        try {
            if (p()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                f9820e = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            }
            f9820e = j(f9820e);
        } catch (Exception unused) {
        }
    }

    public static final Date v(Bundle bundle, String str, Date date) {
        long jLongValue;
        kotlin.jvm.internal.m.f(date, "dateBase");
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(str);
        if (!(obj instanceof Long)) {
            if (obj instanceof String) {
                try {
                    jLongValue = Long.parseLong((String) obj);
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        jLongValue = ((Number) obj).longValue();
        return jLongValue == 0 ? new Date(Long.MAX_VALUE) : new Date(date.getTime() + (jLongValue * 1000));
    }

    private final int v0() {
        int i2 = f9817b;
        if (i2 > 0) {
            return i2;
        }
        try {
            File[] fileArrListFiles = new File("/sys/devices/system/cpu/").listFiles(new FilenameFilter() { // from class: com.facebook.internal.l
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str) {
                    return p0.w0(file, str);
                }
            });
            if (fileArrListFiles != null) {
                f9817b = fileArrListFiles.length;
            }
        } catch (Exception unused) {
        }
        if (f9817b <= 0) {
            f9817b = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return f9817b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w0(File file, String str) {
        return Pattern.matches("cpu[0-9]+", str);
    }

    public static final long x(Uri uri) {
        kotlin.jvm.internal.m.f(uri, "contentUri");
        Cursor cursorQuery = null;
        try {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            cursorQuery = com.facebook.a0.c().getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery == null) {
                return 0L;
            }
            int columnIndex = cursorQuery.getColumnIndex("_size");
            cursorQuery.moveToFirst();
            long j2 = cursorQuery.getLong(columnIndex);
            cursorQuery.close();
            return j2;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    private final void x0(Context context) {
        if (kotlin.jvm.internal.m.a(f9823h, "NoCarrier")) {
            try {
                Object systemService = context.getSystemService("phone");
                if (systemService == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
                }
                String networkOperatorName = ((TelephonyManager) systemService).getNetworkOperatorName();
                kotlin.jvm.internal.m.e(networkOperatorName, "telephonyManager.networkOperatorName");
                f9823h = networkOperatorName;
            } catch (Exception unused) {
            }
        }
    }

    public static final Locale y() {
        Locale localeL = L();
        if (localeL != null) {
            return localeL;
        }
        Locale locale = Locale.getDefault();
        kotlin.jvm.internal.m.e(locale, "getDefault()");
        return locale;
    }

    private final void y0(Context context) {
        if (f9818c == -1 || System.currentTimeMillis() - f9818c >= cm.aptoide.pt.BuildConfig.ANALYTICS_SESSION_INTERVAL_IN_MILLIS) {
            f9818c = System.currentTimeMillis();
            z0();
            x0(context);
            A0();
            u0();
        }
    }

    private final String z() {
        AccessToken accessTokenE = AccessToken.f9559f.e();
        return (accessTokenE == null || accessTokenE.h() == null) ? "facebook" : accessTokenE.h();
    }

    private final void z0() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            String displayName = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            kotlin.jvm.internal.m.e(displayName, "tz.getDisplayName(tz.inDaylightTime(Date()), TimeZone.SHORT)");
            f9821f = displayName;
            String id = timeZone.getID();
            kotlin.jvm.internal.m.e(id, "tz.id");
            f9822g = id;
        } catch (AssertionError | Exception unused) {
        }
    }

    public final String B() {
        return f9822g;
    }

    public final Locale G() {
        return f9825j;
    }

    public final String N() {
        return f9824i;
    }

    public final long u() {
        return f9820e;
    }

    public final String w() {
        return f9823h;
    }
}
