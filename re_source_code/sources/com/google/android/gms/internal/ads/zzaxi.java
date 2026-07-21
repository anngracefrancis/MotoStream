package com.google.android.gms.internal.ads;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzaxi {
    public static final Handler a = new zzaxa(Looper.getMainLooper());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14259f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicReference<Pattern> f14255b = new AtomicReference<>(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicReference<Pattern> f14256c = new AtomicReference<>(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14257d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f14258e = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f14260g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f14261h = false;

    public static boolean A(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return true;
                    }
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    return !(powerManager == null ? false : powerManager.isScreenOn());
                }
            }
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    public static int B(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return 0;
        }
        return applicationInfo.targetSdkVersion;
    }

    private static KeyguardManager C(Context context) {
        Object systemService = context.getSystemService("keyguard");
        if (systemService == null || !(systemService instanceof KeyguardManager)) {
            return null;
        }
        return (KeyguardManager) systemService;
    }

    @TargetApi(16)
    public static boolean D(Context context) {
        KeyguardManager keyguardManagerC;
        return context != null && PlatformVersion.c() && (keyguardManagerC = C(context)) != null && keyguardManagerC.isKeyguardLocked();
    }

    public static boolean E(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi2");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        } catch (Throwable th) {
            zzbad.c("Error loading class.", th);
            zzk.zzlk().e(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    public static String F(Context context) {
        return !((Boolean) zzyt.e().c(zzacu.T4)).booleanValue() ? HttpUrl.FRAGMENT_ENCODE_SET : context.getSharedPreferences("mobileads_consent", 0).getString("consent_string", HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public static Bundle G(Context context) {
        if (!((Boolean) zzyt.e().c(zzacu.U4)).booleanValue()) {
            return null;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Bundle bundle = new Bundle();
        if (defaultSharedPreferences.contains("IABConsent_CMPPresent")) {
            bundle.putBoolean("IABConsent_CMPPresent", defaultSharedPreferences.getBoolean("IABConsent_CMPPresent", false));
        }
        String[] strArr = {"IABConsent_SubjectToGDPR", "IABConsent_ConsentString", "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents"};
        for (int i2 = 0; i2 < 4; i2++) {
            String str = strArr[i2];
            if (defaultSharedPreferences.contains(str)) {
                bundle.putString(str, defaultSharedPreferences.getString(str, null));
            }
        }
        return bundle;
    }

    public static boolean H(Context context) {
        Window window;
        if ((context instanceof Activity) && (window = ((Activity) context).getWindow()) != null && window.getDecorView() != null) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            window.getDecorView().getGlobalVisibleRect(rect, null);
            window.getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (rect.bottom != 0 && rect2.bottom != 0 && rect.top == rect2.top) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(18)
    public static void I(Context context, Intent intent) {
        if (intent != null && PlatformVersion.e()) {
            Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
            extras.putBinder("android.support.customtabs.extra.SESSION", null);
            extras.putString("com.android.browser.application_id", context.getPackageName());
            intent.putExtras(extras);
        }
    }

    public static void J(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            new zzazi(context, str, (String) obj).zzvi();
        }
    }

    public static void K(Context context, String str, String str2) {
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(str, 0);
            fileOutputStreamOpenFileOutput.write(str2.getBytes("UTF-8"));
            fileOutputStreamOpenFileOutput.close();
        } catch (Exception e2) {
            zzbad.c("Error writing to file in internal storage.", e2);
        }
    }

    public static WebResourceResponse L(Context context, String str, String str2) {
        try {
            HashMap map = new HashMap();
            map.put("User-Agent", zzk.zzlg().g0(context, str));
            map.put("Cache-Control", "max-stale=3600");
            String str3 = new zzayu(context).c(str2, map).get(60L, TimeUnit.SECONDS);
            if (str3 != null) {
                return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
            }
            return null;
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e2) {
            zzbad.d("Could not fetch MRAID JS.", e2);
            return null;
        }
    }

    public static WebResourceResponse M(HttpURLConnection httpURLConnection) throws IOException {
        zzk.zzlg();
        String contentType = httpURLConnection.getContentType();
        boolean zIsEmpty = TextUtils.isEmpty(contentType);
        String strTrim = HttpUrl.FRAGMENT_ENCODE_SET;
        String strTrim2 = zIsEmpty ? HttpUrl.FRAGMENT_ENCODE_SET : contentType.split(";")[0].trim();
        zzk.zzlg();
        String contentType2 = httpURLConnection.getContentType();
        if (!TextUtils.isEmpty(contentType2)) {
            String[] strArrSplit = contentType2.split(";");
            if (strArrSplit.length != 1) {
                for (int i2 = 1; i2 < strArrSplit.length; i2++) {
                    if (strArrSplit[i2].trim().startsWith("charset")) {
                        String[] strArrSplit2 = strArrSplit[i2].trim().split("=");
                        if (strArrSplit2.length > 1) {
                            strTrim = strArrSplit2[1].trim();
                            break;
                        }
                    }
                }
            }
        }
        String str = strTrim;
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        HashMap map = new HashMap(headerFields.size());
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null && entry.getValue().size() > 0) {
                map.put(entry.getKey(), entry.getValue().get(0));
            }
        }
        return zzk.zzli().f(strTrim2, str, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), map, httpURLConnection.getInputStream());
    }

    public static void O(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            zzaxg.b(runnable);
        }
    }

    public static int[] P(Activity activity) {
        View viewFindViewById;
        Window window = activity.getWindow();
        return (window == null || (viewFindViewById = window.findViewById(R.id.content)) == null) ? l0() : new int[]{viewFindViewById.getWidth(), viewFindViewById.getHeight()};
    }

    public static int Q(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            String strValueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
            sb.append("Could not parse value:");
            sb.append(strValueOf);
            zzbad.i(sb.toString());
            return 0;
        }
    }

    public static boolean R(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public static boolean V(String str) {
        if (!zzazx.a()) {
            return false;
        }
        if (!((Boolean) zzyt.e().c(zzacu.V3)).booleanValue()) {
            return false;
        }
        String str2 = (String) zzyt.e().c(zzacu.X3);
        if (!str2.isEmpty()) {
            for (String str3 : str2.split(";")) {
                if (str3.equals(str)) {
                    return false;
                }
            }
        }
        String str4 = (String) zzyt.e().c(zzacu.W3);
        if (str4.isEmpty()) {
            return true;
        }
        for (String str5 : str4.split(";")) {
            if (str5.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static Map<String, String> X(Uri uri) {
        if (!((Boolean) zzyt.e().c(zzacu.c5)).booleanValue()) {
            if (uri == null) {
                return null;
            }
            HashMap map = new HashMap();
            zzk.zzli();
            for (String str : uri.getQueryParameterNames()) {
                map.put(str, uri.getQueryParameter(str));
            }
            return map;
        }
        if (uri == null) {
            return null;
        }
        HashMap map2 = new HashMap(20);
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return map2;
        }
        int length = encodedQuery.length();
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(length);
        StringBuilder sb3 = sb;
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = encodedQuery.charAt(i2);
            if (cCharAt == '%') {
                byte[] bArr = new byte[(length - i2) / 3];
                int i3 = 0;
                while (i2 < length - 2 && cCharAt == '%') {
                    try {
                        bArr[i3] = (byte) ((a(encodedQuery.charAt(i2 + 1)) << 4) + a(encodedQuery.charAt(i2 + 2)));
                        i3++;
                    } catch (IllegalArgumentException unused) {
                    }
                    i2 += 3;
                    if (i2 < length) {
                        cCharAt = encodedQuery.charAt(i2);
                    }
                }
                try {
                    sb3.append(new String(bArr, 0, i3, "UTF-8"));
                } catch (UnsupportedEncodingException unused2) {
                }
                if (cCharAt != '%') {
                }
            } else if (cCharAt == '&') {
                if (sb.length() > 0 && sb3 != sb) {
                    map2.put(sb.toString(), sb2.toString());
                    sb.setLength(0);
                    sb2.setLength(0);
                }
                sb3 = sb;
            } else if (cCharAt == '+') {
                sb3.append(' ');
            } else if (cCharAt == '=' && sb3 != sb2) {
                sb3 = sb2;
            } else {
                sb3.append(cCharAt);
            }
            i2++;
        }
        if (sb.length() > 0 && sb3 != sb) {
            map2.put(sb.toString(), sb2.toString());
        }
        return map2;
    }

    public static Bitmap Z(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return bitmapCreateBitmap;
    }

    private static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'A';
        if (c2 < 'A' || c2 > 'F') {
            c3 = 'a';
            if (c2 < 'a' || c2 > 'f') {
                throw new IllegalArgumentException("Invalid Hex.");
            }
        }
        return (c2 - c3) + 10;
    }

    public static Bitmap a0(View view) {
        if (view == null) {
            return null;
        }
        Bitmap bitmapC0 = c0(view);
        return bitmapC0 == null ? b0(view) : bitmapC0;
    }

    public static DisplayMetrics b(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    private static Bitmap b0(View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width != 0 && height != 0) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                view.layout(0, 0, width, height);
                view.draw(canvas);
                return bitmapCreateBitmap;
            }
            zzbad.i("Width or height of view is zero");
            return null;
        } catch (RuntimeException e2) {
            zzbad.c("Fail to capture the webview", e2);
            return null;
        }
    }

    public static PopupWindow c(View view, int i2, int i3, boolean z) {
        return new PopupWindow(view, i2, i3, false);
    }

    private static Bitmap c0(View view) {
        Bitmap bitmapCreateBitmap = null;
        try {
            boolean zIsDrawingCacheEnabled = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view.getDrawingCache();
            bitmapCreateBitmap = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
            view.setDrawingCacheEnabled(zIsDrawingCacheEnabled);
        } catch (RuntimeException e2) {
            zzbad.c("Fail to capture the web view", e2);
        }
        return bitmapCreateBitmap;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0012  */
    public static boolean d0(View view) {
        Activity activity;
        View rootView = view.getRootView();
        if (rootView != null) {
            Context context = rootView.getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
        } else {
            activity = null;
        }
        if (activity == null) {
            return false;
        }
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        return (attributes == null || (attributes.flags & 524288) == 0) ? false : true;
    }

    public static int e0(View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof AdapterView)) {
            parent = parent.getParent();
        }
        if (parent == null) {
            return -1;
        }
        return ((AdapterView) parent).getPositionForView(view);
    }

    public static String f(InputStreamReader inputStreamReader) throws IOException {
        StringBuilder sb = new StringBuilder(8192);
        char[] cArr = new char[RecyclerView.l.FLAG_MOVED];
        while (true) {
            int i2 = inputStreamReader.read(cArr);
            if (i2 == -1) {
                return sb.toString();
            }
            sb.append(cArr, 0, i2);
        }
    }

    public static boolean f0(Context context, String str) {
        Context contextF = zzasq.f(context);
        return Wrappers.a(contextF).b(str, contextF.getPackageName()) == 0;
    }

    private final JSONArray g(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            o(jSONArray, it.next());
        }
        return jSONArray;
    }

    public static String h0(Context context, String str) {
        try {
            return new String(IOUtils.d(context.openFileInput(str), true), "UTF-8");
        } catch (IOException unused) {
            zzbad.e("Error reading from internal storage.");
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    public static void i(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable unused) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    private static String i0() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Mozilla/5.0 (Linux; U; Android");
        String str = Build.VERSION.RELEASE;
        if (str != null) {
            sb.append(" ");
            sb.append(str);
        }
        sb.append("; ");
        sb.append(Locale.getDefault());
        String str2 = Build.DEVICE;
        if (str2 != null) {
            sb.append("; ");
            sb.append(str2);
            String str3 = Build.DISPLAY;
            if (str3 != null) {
                sb.append(" Build/");
                sb.append(str3);
            }
        }
        sb.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return sb.toString();
    }

    @TargetApi(18)
    public static void j(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            I(context, intent);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String string = uri.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 26);
            sb.append("Opening ");
            sb.append(string);
            sb.append(" in a new browser.");
            zzbad.e(sb.toString());
        } catch (ActivityNotFoundException e2) {
            zzbad.c("No browser is found.", e2);
        }
    }

    public static String j0() {
        return UUID.randomUUID().toString();
    }

    public static String k0() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + str2.length());
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        return sb.toString();
    }

    private static int[] l0() {
        return new int[]{0, 0};
    }

    public static String m0() {
        Resources resourcesB = zzk.zzlk().b();
        return resourcesB != null ? resourcesB.getString(com.google.android.gms.ads.impl.R.string.s7) : "Test Ad";
    }

    public static void n(Context context, Throwable th) {
        if (context == null) {
            return;
        }
        boolean zBooleanValue = false;
        try {
            zBooleanValue = ((Boolean) zzyt.e().c(zzacu.m)).booleanValue();
        } catch (IllegalStateException unused) {
        }
        if (zBooleanValue) {
            CrashUtils.a(context, th);
        }
    }

    private final void o(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(N((Bundle) obj));
            return;
        }
        if (obj instanceof Map) {
            jSONArray.put(Y((Map) obj));
            return;
        }
        if (obj instanceof Collection) {
            jSONArray.put(g((Collection) obj));
            return;
        }
        if (!(obj instanceof Object[])) {
            jSONArray.put(obj);
            return;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (Object obj2 : (Object[]) obj) {
            o(jSONArray2, obj2);
        }
        jSONArray.put(jSONArray2);
    }

    private final void p(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, N((Bundle) obj));
            return;
        }
        if (obj instanceof Map) {
            jSONObject.put(str, Y((Map) obj));
            return;
        }
        if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, g((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, g(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    private static boolean t(String str, AtomicReference<Pattern> atomicReference, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Pattern patternCompile = atomicReference.get();
            if (patternCompile == null || !str2.equals(patternCompile.pattern())) {
                patternCompile = Pattern.compile(str2);
                atomicReference.set(patternCompile);
            }
            return patternCompile.matcher(str).matches();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    @VisibleForTesting
    protected static String w(Context context) {
        try {
            return new WebView(context).getSettings().getUserAgentString();
        } catch (Throwable unused) {
            return i0();
        }
    }

    public static AlertDialog.Builder x(Context context) {
        return new AlertDialog.Builder(context);
    }

    public static zzacf y(Context context) {
        return new zzacf(context);
    }

    public static String z(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        ComponentName componentName;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && !runningTasks.isEmpty() && (runningTaskInfo = runningTasks.get(0)) != null && (componentName = runningTaskInfo.topActivity) != null) {
                return componentName.getClassName();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final JSONObject N(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            p(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public final int[] S(Activity activity) {
        int[] iArrP = P(activity);
        return new int[]{zzyt.a().j(activity, iArrP[0]), zzyt.a().j(activity, iArrP[1])};
    }

    public final boolean T(String str) {
        return t(str, this.f14255b, (String) zzyt.e().c(zzacu.A0));
    }

    public final boolean U(String str) {
        return t(str, this.f14256c, (String) zzyt.e().c(zzacu.B0));
    }

    public final int[] W(Activity activity) {
        View viewFindViewById;
        Window window = activity.getWindow();
        int[] iArrL0 = (window == null || (viewFindViewById = window.findViewById(R.id.content)) == null) ? l0() : new int[]{viewFindViewById.getTop(), viewFindViewById.getBottom()};
        return new int[]{zzyt.a().j(activity, iArrL0[0]), zzyt.a().j(activity, iArrL0[1])};
    }

    public final JSONObject Y(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                p(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e2) {
            String strValueOf = String.valueOf(e2.getMessage());
            throw new JSONException(strValueOf.length() != 0 ? "Could not convert map to JSON: ".concat(strValueOf) : new String("Could not convert map to JSON: "));
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x009a A[Catch: Exception -> 0x00a9, all -> 0x00c3, TRY_LEAVE, TryCatch #3 {Exception -> 0x00a9, blocks: (B:29:0x0090, B:31:0x009a), top: B:49:0x0090, outer: #1 }] */
    public final String g0(Context context, String str) {
        synchronized (this.f14258e) {
            String str2 = this.f14259f;
            if (str2 != null) {
                return str2;
            }
            if (str == null) {
                return i0();
            }
            try {
                this.f14259f = zzk.zzli().a(context);
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(this.f14259f)) {
                String strValueOf = String.valueOf(this.f14259f);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 10 + str.length());
                sb.append(strValueOf);
                sb.append(" (Mobile; ");
                sb.append(str);
                this.f14259f = sb.toString();
                if (Wrappers.a(context).f()) {
                    this.f14259f = String.valueOf(this.f14259f).concat(";aia");
                }
                String strConcat = String.valueOf(this.f14259f).concat(")");
                this.f14259f = strConcat;
                return strConcat;
            }
            zzyt.a();
            if (zzazt.w()) {
                this.f14259f = w(context);
            } else {
                this.f14259f = null;
                a.post(new f5(this, context));
                while (this.f14259f == null) {
                    try {
                        this.f14258e.wait();
                    } catch (InterruptedException unused2) {
                        String strI0 = i0();
                        this.f14259f = strI0;
                        String strValueOf2 = String.valueOf(strI0);
                        zzbad.i(strValueOf2.length() != 0 ? "Interrupted, use default user agent: ".concat(strValueOf2) : new String("Interrupted, use default user agent: "));
                    }
                }
            }
            String strValueOf3 = String.valueOf(this.f14259f);
            StringBuilder sb2 = new StringBuilder(strValueOf3.length() + 10 + str.length());
            sb2.append(strValueOf3);
            sb2.append(" (Mobile; ");
            sb2.append(str);
            this.f14259f = sb2.toString();
            try {
                if (Wrappers.a(context).f()) {
                    this.f14259f = String.valueOf(this.f14259f).concat(";aia");
                }
            } catch (Exception e2) {
                zzk.zzlk().e(e2, "AdUtil.getUserAgent");
            }
            String strConcat2 = String.valueOf(this.f14259f).concat(")");
            this.f14259f = strConcat2;
            return strConcat2;
            throw th;
        }
    }

    public final JSONObject h(Bundle bundle, JSONObject jSONObject) {
        if (bundle != null) {
            try {
                return N(bundle);
            } catch (JSONException e2) {
                zzbad.c("Error converting Bundle to JSON", e2);
            }
        }
        return null;
    }

    public final void k(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(g0(context, str));
    }

    public final void l(Context context, String str, String str2, Bundle bundle, boolean z) {
        zzk.zzlg();
        bundle.putString("device", k0());
        bundle.putString("eids", TextUtils.join(",", zzacu.c()));
        zzyt.a();
        zzazt.e(context, str, str2, bundle, true, new g5(this, context, str));
    }

    public final void m(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", g0(context, str));
        httpURLConnection.setUseCaches(false);
    }

    public final boolean q(View view, Context context) {
        Context applicationContext = context.getApplicationContext();
        return r(view, applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null, C(context));
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001d  */
    public final boolean r(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z;
        if (zzk.zzlg().f14257d) {
            z = true;
        } else {
            if (!(keyguardManager == null ? false : keyguardManager.inKeyguardRestrictedInputMode()) || d0(view)) {
                z = true;
            } else {
                z = false;
            }
        }
        if (view.getVisibility() == 0 && view.isShown()) {
            if ((powerManager == null || powerManager.isScreenOn()) && z) {
                if (!((Boolean) zzyt.e().c(zzacu.O1)).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean u(Context context) {
        if (this.f14260g) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new i5(this, null), intentFilter);
        this.f14260g = true;
        return true;
    }

    public final boolean v(Context context) {
        if (this.f14261h) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        context.getApplicationContext().registerReceiver(new h5(this, null), intentFilter);
        this.f14261h = true;
        return true;
    }
}
