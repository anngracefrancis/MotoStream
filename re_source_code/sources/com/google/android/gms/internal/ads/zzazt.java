package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.dataprovider.BuildConfig;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzazt {
    public static final Handler a = new zzdbh(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14314b = AdView.class.getName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f14315c = InterstitialAd.class.getName();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f14316d = PublisherAdView.class.getName();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f14317e = PublisherInterstitialAd.class.getName();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f14318f = SearchAdView.class.getName();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f14319g = AdLoader.class.getName();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f14320h = -1.0f;

    public static int a(Context context, int i2) {
        return b(context.getResources().getDisplayMetrics(), i2);
    }

    public static int b(DisplayMetrics displayMetrics, int i2) {
        return (int) TypedValue.applyDimension(1, i2, displayMetrics);
    }

    @VisibleForTesting
    public static String c(StackTraceElement[] stackTraceElementArr, String str) {
        String className;
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= stackTraceElementArr.length) {
                className = null;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i2];
            String className2 = stackTraceElement.getClassName();
            if ("loadAd".equalsIgnoreCase(stackTraceElement.getMethodName()) && (f14314b.equalsIgnoreCase(className2) || f14315c.equalsIgnoreCase(className2) || f14316d.equalsIgnoreCase(className2) || f14317e.equalsIgnoreCase(className2) || f14318f.equalsIgnoreCase(className2) || f14319g.equalsIgnoreCase(className2))) {
                className = stackTraceElementArr[i3].getClassName();
                break;
            }
            i2 = i3;
        }
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            StringBuilder sb = new StringBuilder();
            int i4 = 2;
            if (stringTokenizer.hasMoreElements()) {
                sb.append(stringTokenizer.nextToken());
                while (true) {
                    int i5 = i4 - 1;
                    if (i4 <= 0 || !stringTokenizer.hasMoreElements()) {
                        break;
                    }
                    sb.append(".");
                    sb.append(stringTokenizer.nextToken());
                    i4 = i5;
                }
                str = sb.toString();
            }
            if (className != null && !className.contains(str)) {
                return className;
            }
        }
        return null;
    }

    public static void e(Context context, String str, String str2, Bundle bundle, boolean z, zzazw zzazwVar) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        bundle.putString("os", Build.VERSION.RELEASE);
        bundle.putString("api", String.valueOf(Build.VERSION.SDK_INT));
        bundle.putString("appid", applicationContext.getPackageName());
        if (str == null) {
            int iB = GoogleApiAvailabilityLight.h().b(context);
            StringBuilder sb = new StringBuilder(23);
            sb.append(iB);
            sb.append(".15000000");
            str = sb.toString();
        }
        bundle.putString("js", str);
        Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme(BuildConfig.APTOIDE_WEB_SERVICES_SCHEME).path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter(DeepLinkIntentReceiver.DeepLinksKeys.ID, str2);
        for (String str3 : bundle.keySet()) {
            builderAppendQueryParameter.appendQueryParameter(str3, bundle.getString(str3));
        }
        zzazwVar.a(builderAppendQueryParameter.toString());
    }

    private final void g(ViewGroup viewGroup, zzyd zzydVar, String str, int i2, int i3) {
        if (viewGroup.getChildCount() != 0) {
            return;
        }
        Context context = viewGroup.getContext();
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setText(str);
        textView.setTextColor(i2);
        textView.setBackgroundColor(i3);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(i2);
        int iA = a(context, 3);
        frameLayout.addView(textView, new FrameLayout.LayoutParams(zzydVar.f16992k - iA, zzydVar.f16989h - iA, 17));
        viewGroup.addView(frameLayout, zzydVar.f16992k, zzydVar.f16989h);
    }

    public static void i(boolean z, HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setReadTimeout(60000);
        if (str != null) {
            httpURLConnection.setRequestProperty("User-Agent", str);
        }
        httpURLConnection.setUseCaches(false);
    }

    public static int k(DisplayMetrics displayMetrics, int i2) {
        return Math.round(i2 / displayMetrics.density);
    }

    public static String l(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String string = contentResolver == null ? null : Settings.Secure.getString(contentResolver, "android_id");
        if (string == null || v()) {
            string = "emulator";
        }
        return t(string);
    }

    public static String m(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            return null;
        }
        return Settings.Secure.getString(contentResolver, "android_id");
    }

    public static boolean n(Context context) {
        int iJ = GoogleApiAvailabilityLight.h().j(context, 12451000);
        return iJ == 0 || iJ == 2;
    }

    public static boolean o(Context context) {
        if (context.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return ((int) (((float) displayMetrics.heightPixels) / displayMetrics.density)) < 600;
    }

    @TargetApi(17)
    public static boolean p(Context context) {
        int iIntValue;
        int iIntValue2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (PlatformVersion.d()) {
            defaultDisplay.getRealMetrics(displayMetrics);
            iIntValue = displayMetrics.heightPixels;
            iIntValue2 = displayMetrics.widthPixels;
        } else {
            try {
                iIntValue = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                iIntValue2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception unused) {
            }
        }
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.heightPixels == iIntValue && displayMetrics.widthPixels == iIntValue2;
    }

    public static int q(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static Throwable r(Throwable th) {
        if (((Boolean) zzyt.e().c(zzacu.n)).booleanValue()) {
            return th;
        }
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.push(th);
            th = th.getCause();
        }
        Throwable th2 = null;
        while (!linkedList.isEmpty()) {
            Throwable th3 = (Throwable) linkedList.pop();
            StackTraceElement[] stackTrace = th3.getStackTrace();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new StackTraceElement(th3.getClass().getName(), "<filtered>", "<filtered>", 1));
            boolean z = false;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (u(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    z = true;
                } else {
                    String className = stackTraceElement.getClassName();
                    if (!TextUtils.isEmpty(className) && (className.startsWith("android.") || className.startsWith("java."))) {
                        arrayList.add(stackTraceElement);
                    } else {
                        arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                    }
                }
            }
            if (z) {
                th2 = th2 == null ? new Throwable(th3.getMessage()) : new Throwable(th3.getMessage(), th2);
                th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            }
        }
        return th2;
    }

    public static boolean s(Context context, int i2) {
        return GoogleApiAvailabilityLight.h().j(context, i2) == 0;
    }

    public static String t(String str) {
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return String.format(Locale.US, "%032X", new BigInteger(1, messageDigest.digest()));
            } catch (ArithmeticException unused) {
                return null;
            } catch (NoSuchAlgorithmException unused2) {
            }
        }
        return null;
    }

    @VisibleForTesting
    public static boolean u(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith((String) zzyt.e().c(zzacu.o))) {
            return true;
        }
        try {
            return Class.forName(str).isAnnotationPresent(zzard.class);
        } catch (Exception e2) {
            zzbad.b(str.length() != 0 ? "Fail to check class type for class ".concat(str) : new String("Fail to check class type for class "), e2);
            return false;
        }
    }

    public static boolean v() {
        return Build.DEVICE.startsWith("generic");
    }

    public static boolean w() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static String x() {
        UUID uuidRandomUUID = UUID.randomUUID();
        byte[] byteArray = BigInteger.valueOf(uuidRandomUUID.getLeastSignificantBits()).toByteArray();
        byte[] byteArray2 = BigInteger.valueOf(uuidRandomUUID.getMostSignificantBits()).toByteArray();
        String string = new BigInteger(1, byteArray).toString();
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(byteArray);
                messageDigest.update(byteArray2);
                byte[] bArr = new byte[8];
                System.arraycopy(messageDigest.digest(), 0, bArr, 0, 8);
                string = new BigInteger(1, bArr).toString();
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return string;
    }

    public final void d(Context context, String str, String str2, Bundle bundle, boolean z) {
        e(context, str, str2, bundle, true, new f6(this));
    }

    public final void f(ViewGroup viewGroup, zzyd zzydVar, String str) {
        g(viewGroup, zzydVar, str, -16777216, -1);
    }

    public final void h(ViewGroup viewGroup, zzyd zzydVar, String str, String str2) {
        zzbad.i(str2);
        g(viewGroup, zzydVar, str, -65536, -16777216);
    }

    public final int j(Context context, int i2) {
        if (this.f14320h < 0.0f) {
            synchronized (this) {
                if (this.f14320h < 0.0f) {
                    Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    defaultDisplay.getMetrics(displayMetrics);
                    this.f14320h = displayMetrics.density;
                }
            }
        }
        return Math.round(i2 / this.f14320h);
    }
}
