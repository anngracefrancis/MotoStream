package com.facebook.internal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.reviews.RateAndReviewsFragment;
import com.facebook.AccessToken;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: WebDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public class r0 extends Dialog {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f9841f = new b(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f9842g = com.facebook.common.e.a;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile int f9843h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static d f9844i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f9845j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f9846k;
    private e l;
    private WebView m;
    private ProgressDialog n;
    private ImageView o;
    private FrameLayout p;
    private f q;
    private boolean r;
    private boolean s;
    private boolean t;
    private WindowManager.LayoutParams u;

    /* JADX INFO: compiled from: WebDialog.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final int a() {
            q0 q0Var = q0.a;
            q0.l();
            return r0.f9843h;
        }

        protected final void b(Context context) {
            if (context == null) {
                return;
            }
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if ((applicationInfo == null ? null : applicationInfo.metaData) != null && r0.f9843h == 0) {
                    e(applicationInfo.metaData.getInt("com.facebook.sdk.WebDialogTheme"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }

        public final r0 c(Context context, String str, Bundle bundle, int i2, e eVar) {
            kotlin.jvm.internal.m.f(context, "context");
            r0.p(context);
            return new r0(context, str, bundle, i2, com.facebook.login.z.FACEBOOK, eVar, null);
        }

        public final r0 d(Context context, String str, Bundle bundle, int i2, com.facebook.login.z zVar, e eVar) {
            kotlin.jvm.internal.m.f(context, "context");
            kotlin.jvm.internal.m.f(zVar, "targetApp");
            r0.p(context);
            return new r0(context, str, bundle, i2, zVar, eVar, null);
        }

        public final void e(int i2) {
            if (i2 == 0) {
                i2 = r0.f9842g;
            }
            r0.f9843h = i2;
        }
    }

    /* JADX INFO: compiled from: WebDialog.kt */
    private final class c extends WebViewClient {
        final /* synthetic */ r0 a;

        public c(r0 r0Var) {
            kotlin.jvm.internal.m.f(r0Var, "this$0");
            this.a = r0Var;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            ProgressDialog progressDialog;
            kotlin.jvm.internal.m.f(webView, "view");
            kotlin.jvm.internal.m.f(str, "url");
            super.onPageFinished(webView, str);
            if (!this.a.s && (progressDialog = this.a.n) != null) {
                progressDialog.dismiss();
            }
            FrameLayout frameLayout = this.a.p;
            if (frameLayout != null) {
                frameLayout.setBackgroundColor(0);
            }
            WebView webViewO = this.a.o();
            if (webViewO != null) {
                webViewO.setVisibility(0);
            }
            ImageView imageView = this.a.o;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            this.a.t = true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            ProgressDialog progressDialog;
            kotlin.jvm.internal.m.f(webView, "view");
            kotlin.jvm.internal.m.f(str, "url");
            p0 p0Var = p0.a;
            p0.j0("FacebookSDK.WebDialog", kotlin.jvm.internal.m.n("Webview loading URL: ", str));
            super.onPageStarted(webView, str, bitmap);
            if (this.a.s || (progressDialog = this.a.n) == null) {
                return;
            }
            progressDialog.show();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            kotlin.jvm.internal.m.f(webView, "view");
            kotlin.jvm.internal.m.f(str, "description");
            kotlin.jvm.internal.m.f(str2, "failingUrl");
            super.onReceivedError(webView, i2, str, str2);
            this.a.y(new FacebookDialogException(str, i2, str2));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            kotlin.jvm.internal.m.f(webView, "view");
            kotlin.jvm.internal.m.f(sslErrorHandler, "handler");
            kotlin.jvm.internal.m.f(sslError, "error");
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            sslErrorHandler.cancel();
            this.a.y(new FacebookDialogException(null, -11, null));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            int i2;
            kotlin.jvm.internal.m.f(webView, "view");
            kotlin.jvm.internal.m.f(str, "url");
            p0 p0Var = p0.a;
            p0.j0("FacebookSDK.WebDialog", kotlin.jvm.internal.m.n("Redirect URL: ", str));
            Uri uri = Uri.parse(str);
            boolean z = uri.getPath() != null && Pattern.matches("^/(v\\d+\\.\\d+/)??dialog/.*", uri.getPath());
            if (!kotlin.text.u.E(str, this.a.f9846k, false, 2, null)) {
                if (kotlin.text.u.E(str, "fbconnect://cancel", false, 2, null)) {
                    this.a.cancel();
                    return true;
                }
                if (z || kotlin.text.v.J(str, "touch", false, 2, null)) {
                    return false;
                }
                try {
                    this.a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                } catch (ActivityNotFoundException unused) {
                    return false;
                }
            }
            Bundle bundleW = this.a.w(str);
            String string = bundleW.getString("error");
            if (string == null) {
                string = bundleW.getString("error_type");
            }
            String string2 = bundleW.getString("error_msg");
            if (string2 == null) {
                string2 = bundleW.getString("error_message");
            }
            if (string2 == null) {
                string2 = bundleW.getString("error_description");
            }
            String string3 = bundleW.getString("error_code");
            if (string3 == null || p0.a0(string3)) {
                i2 = -1;
            } else {
                try {
                    i2 = Integer.parseInt(string3);
                } catch (NumberFormatException unused2) {
                    i2 = -1;
                }
            }
            p0 p0Var2 = p0.a;
            if (p0.a0(string) && p0.a0(string2) && i2 == -1) {
                this.a.z(bundleW);
            } else if ((string == null || !(kotlin.jvm.internal.m.a(string, "access_denied") || kotlin.jvm.internal.m.a(string, "OAuthAccessDeniedException"))) && i2 != 4201) {
                this.a.y(new FacebookServiceException(new FacebookRequestError(i2, string, string2), string2));
            } else {
                this.a.cancel();
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: WebDialog.kt */
    public interface d {
        void a(WebView webView);
    }

    /* JADX INFO: compiled from: WebDialog.kt */
    public interface e {
        void a(Bundle bundle, FacebookException facebookException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: WebDialog.kt */
    final class f extends AsyncTask<Void, Void, String[]> {
        private final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Bundle f9853b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Exception[] f9854c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ r0 f9855d;

        public f(r0 r0Var, String str, Bundle bundle) {
            kotlin.jvm.internal.m.f(r0Var, "this$0");
            kotlin.jvm.internal.m.f(str, "action");
            kotlin.jvm.internal.m.f(bundle, "parameters");
            this.f9855d = r0Var;
            this.a = str;
            this.f9853b = bundle;
            this.f9854c = new Exception[0];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(String[] strArr, int i2, f fVar, CountDownLatch countDownLatch, com.facebook.d0 d0Var) {
            kotlin.jvm.internal.m.f(strArr, "$results");
            kotlin.jvm.internal.m.f(fVar, "this$0");
            kotlin.jvm.internal.m.f(countDownLatch, "$latch");
            kotlin.jvm.internal.m.f(d0Var, "response");
            try {
                FacebookRequestError facebookRequestErrorB = d0Var.b();
                String str = "Error staging photo.";
                if (facebookRequestErrorB != null) {
                    String strC = facebookRequestErrorB.c();
                    if (strC != null) {
                        str = strC;
                    }
                    throw new FacebookGraphResponseException(d0Var, str);
                }
                JSONObject jSONObjectC = d0Var.c();
                if (jSONObjectC == null) {
                    throw new FacebookException("Error staging photo.");
                }
                String strOptString = jSONObjectC.optString(DeepLinkIntentReceiver.DeepLinksKeys.URI);
                if (strOptString == null) {
                    throw new FacebookException("Error staging photo.");
                }
                strArr[i2] = strOptString;
                countDownLatch.countDown();
            } catch (Exception e2) {
                fVar.f9854c[i2] = e2;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String[] doInBackground(Void... voidArr) {
            kotlin.jvm.internal.m.f(voidArr, "p0");
            String[] stringArray = this.f9853b.getStringArray("media");
            if (stringArray == null) {
                return null;
            }
            final String[] strArr = new String[stringArray.length];
            this.f9854c = new Exception[stringArray.length];
            final CountDownLatch countDownLatch = new CountDownLatch(stringArray.length);
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            AccessToken accessTokenE = AccessToken.f9559f.e();
            final int i2 = 0;
            try {
                int length = stringArray.length - 1;
                if (length >= 0) {
                    while (true) {
                        int i3 = i2 + 1;
                        if (isCancelled()) {
                            Iterator it = concurrentLinkedQueue.iterator();
                            while (it.hasNext()) {
                                ((com.facebook.b0) it.next()).cancel(true);
                            }
                            return null;
                        }
                        Uri uri = Uri.parse(stringArray[i2]);
                        p0 p0Var = p0.a;
                        if (p0.c0(uri)) {
                            strArr[i2] = uri.toString();
                            countDownLatch.countDown();
                        } else {
                            GraphRequest.b bVar = new GraphRequest.b() { // from class: com.facebook.internal.o
                                @Override // com.facebook.GraphRequest.b
                                public final void b(com.facebook.d0 d0Var) {
                                    r0.f.b(strArr, i2, this, countDownLatch, d0Var);
                                }
                            };
                            com.facebook.r0.a.a aVar = com.facebook.r0.a.a.a;
                            kotlin.jvm.internal.m.e(uri, DeepLinkIntentReceiver.DeepLinksKeys.URI);
                            concurrentLinkedQueue.add(com.facebook.r0.a.a.a(accessTokenE, uri, bVar).k());
                        }
                        if (i3 > length) {
                            break;
                        }
                        i2 = i3;
                    }
                }
                countDownLatch.await();
                return strArr;
            } catch (Exception unused) {
                Iterator it2 = concurrentLinkedQueue.iterator();
                while (it2.hasNext()) {
                    ((com.facebook.b0) it2.next()).cancel(true);
                }
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String[] strArr) {
            ProgressDialog progressDialog = this.f9855d.n;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            Exception[] excArr = this.f9854c;
            int i2 = 0;
            int length = excArr.length;
            while (i2 < length) {
                Exception exc = excArr[i2];
                i2++;
                if (exc != null) {
                    this.f9855d.y(exc);
                    return;
                }
            }
            if (strArr == null) {
                this.f9855d.y(new FacebookException("Failed to stage photos for web dialog"));
                return;
            }
            List listC = kotlin.collections.m.c(strArr);
            if (listC.contains(null)) {
                this.f9855d.y(new FacebookException("Failed to stage photos for web dialog"));
                return;
            }
            p0 p0Var = p0.a;
            p0.p0(this.f9853b, "media", new JSONArray((Collection) listC));
            n0 n0Var = n0.a;
            String strB = n0.b();
            StringBuilder sb = new StringBuilder();
            com.facebook.a0 a0Var = com.facebook.a0.a;
            sb.append(com.facebook.a0.n());
            sb.append("/dialog/");
            sb.append(this.a);
            Uri uriE = p0.e(strB, sb.toString(), this.f9853b);
            this.f9855d.f9845j = uriE.toString();
            ImageView imageView = this.f9855d.o;
            if (imageView == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            this.f9855d.C((imageView.getDrawable().getIntrinsicWidth() / 2) + 1);
        }
    }

    /* JADX INFO: compiled from: WebDialog.kt */
    public /* synthetic */ class g {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.facebook.login.z.valuesCustom().length];
            iArr[com.facebook.login.z.INSTAGRAM.ordinal()] = 1;
            a = iArr;
        }
    }

    /* JADX INFO: compiled from: WebDialog.kt */
    public static final class h extends WebView {
        h(Context context) {
            super(context);
        }

        @Override // android.webkit.WebView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            try {
                super.onWindowFocusChanged(z);
            } catch (NullPointerException unused) {
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    protected r0(Context context, String str) {
        this(context, str, f9841f.a());
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(str, "url");
    }

    public /* synthetic */ r0(Context context, String str, Bundle bundle, int i2, com.facebook.login.z zVar, e eVar, kotlin.jvm.internal.g gVar) {
        this(context, str, bundle, i2, zVar, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetJavaScriptEnabled"})
    public final void C(int i2) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.m = new h(getContext());
        d dVar = f9844i;
        if (dVar != null) {
            dVar.a(o());
        }
        WebView webView = this.m;
        if (webView != null) {
            webView.setVerticalScrollBarEnabled(false);
        }
        WebView webView2 = this.m;
        if (webView2 != null) {
            webView2.setHorizontalScrollBarEnabled(false);
        }
        WebView webView3 = this.m;
        if (webView3 != null) {
            webView3.setWebViewClient(new c(this));
        }
        WebView webView4 = this.m;
        WebSettings settings = webView4 == null ? null : webView4.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
        }
        WebView webView5 = this.m;
        if (webView5 != null) {
            String str = this.f9845j;
            if (str == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            webView5.loadUrl(str);
        }
        WebView webView6 = this.m;
        if (webView6 != null) {
            webView6.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        WebView webView7 = this.m;
        if (webView7 != null) {
            webView7.setVisibility(4);
        }
        WebView webView8 = this.m;
        WebSettings settings2 = webView8 == null ? null : webView8.getSettings();
        if (settings2 != null) {
            settings2.setSavePassword(false);
        }
        WebView webView9 = this.m;
        WebSettings settings3 = webView9 != null ? webView9.getSettings() : null;
        if (settings3 != null) {
            settings3.setSaveFormData(false);
        }
        WebView webView10 = this.m;
        if (webView10 != null) {
            webView10.setFocusable(true);
        }
        WebView webView11 = this.m;
        if (webView11 != null) {
            webView11.setFocusableInTouchMode(true);
        }
        WebView webView12 = this.m;
        if (webView12 != null) {
            webView12.setOnTouchListener(new View.OnTouchListener() { // from class: com.facebook.internal.p
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return r0.D(view, motionEvent);
                }
            });
        }
        linearLayout.setPadding(i2, i2, i2, i2);
        linearLayout.addView(this.m);
        linearLayout.setBackgroundColor(-872415232);
        FrameLayout frameLayout = this.p;
        if (frameLayout == null) {
            return;
        }
        frameLayout.addView(linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D(View view, MotionEvent motionEvent) {
        if (view.hasFocus()) {
            return false;
        }
        view.requestFocus();
        return false;
    }

    private final void l() {
        ImageView imageView = new ImageView(getContext());
        this.o = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.internal.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r0.m(this.f9803f, view);
                }
            });
        }
        Drawable drawable = getContext().getResources().getDrawable(com.facebook.common.a.a);
        ImageView imageView2 = this.o;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
        ImageView imageView3 = this.o;
        if (imageView3 == null) {
            return;
        }
        imageView3.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(r0 r0Var, View view) {
        kotlin.jvm.internal.m.f(r0Var, "this$0");
        r0Var.cancel();
    }

    private final int n(int i2, float f2, int i3, int i4) {
        int i5 = (int) (i2 / f2);
        double d2 = 0.5d;
        if (i5 <= i3) {
            d2 = 1.0d;
        } else if (i5 < i4) {
            double d3 = i4 - i5;
            double d4 = i4 - i3;
            Double.isNaN(d3);
            Double.isNaN(d4);
            d2 = 0.5d + ((d3 / d4) * 0.5d);
        }
        double d5 = i2;
        Double.isNaN(d5);
        return (int) (d5 * d2);
    }

    protected static final void p(Context context) {
        f9841f.b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(r0 r0Var, DialogInterface dialogInterface) {
        kotlin.jvm.internal.m.f(r0Var, "this$0");
        r0Var.cancel();
    }

    protected final void A(String str) {
        kotlin.jvm.internal.m.f(str, "expectedRedirectUrl");
        this.f9846k = str;
    }

    public final void B(e eVar) {
        this.l = eVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        if (this.l == null || this.r) {
            return;
        }
        y(new FacebookOperationCanceledException());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        ProgressDialog progressDialog;
        WebView webView = this.m;
        if (webView != null) {
            webView.stopLoading();
        }
        if (!this.s && (progressDialog = this.n) != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        super.dismiss();
    }

    protected final WebView o() {
        return this.m;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        WindowManager.LayoutParams layoutParams;
        WindowManager.LayoutParams attributes;
        this.s = false;
        p0 p0Var = p0.a;
        Context context = getContext();
        kotlin.jvm.internal.m.e(context, "context");
        if (p0.n0(context) && (layoutParams = this.u) != null) {
            if ((layoutParams == null ? null : layoutParams.token) == null) {
                if (layoutParams != null) {
                    Activity ownerActivity = getOwnerActivity();
                    Window window = ownerActivity == null ? null : ownerActivity.getWindow();
                    layoutParams.token = (window == null || (attributes = window.getAttributes()) == null) ? null : attributes.token;
                }
                WindowManager.LayoutParams layoutParams2 = this.u;
                p0.j0("FacebookSDK.WebDialog", kotlin.jvm.internal.m.n("Set token on onAttachedToWindow(): ", layoutParams2 != null ? layoutParams2.token : null));
            }
        }
        super.onAttachedToWindow();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        this.n = progressDialog;
        if (progressDialog != null) {
            progressDialog.requestWindowFeature(1);
        }
        ProgressDialog progressDialog2 = this.n;
        if (progressDialog2 != null) {
            progressDialog2.setMessage(getContext().getString(com.facebook.common.d.f9683d));
        }
        ProgressDialog progressDialog3 = this.n;
        if (progressDialog3 != null) {
            progressDialog3.setCanceledOnTouchOutside(false);
        }
        ProgressDialog progressDialog4 = this.n;
        if (progressDialog4 != null) {
            progressDialog4.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.facebook.internal.n
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    r0.v(this.f9805f, dialogInterface);
                }
            });
        }
        requestWindowFeature(1);
        this.p = new FrameLayout(getContext());
        x();
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(16);
        }
        l();
        if (this.f9845j != null) {
            ImageView imageView = this.o;
            if (imageView == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            C((imageView.getDrawable().getIntrinsicWidth() / 2) + 1);
        }
        FrameLayout frameLayout = this.p;
        if (frameLayout != null) {
            frameLayout.addView(this.o, new ViewGroup.LayoutParams(-2, -2));
        }
        FrameLayout frameLayout2 = this.p;
        if (frameLayout2 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        setContentView(frameLayout2);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.s = true;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        kotlin.jvm.internal.m.f(keyEvent, "event");
        if (i2 == 4) {
            WebView webView = this.m;
            if (webView != null) {
                if (kotlin.jvm.internal.m.a(webView == null ? null : Boolean.valueOf(webView.canGoBack()), Boolean.TRUE)) {
                    WebView webView2 = this.m;
                    if (webView2 == null) {
                        return true;
                    }
                    webView2.goBack();
                    return true;
                }
            }
            cancel();
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        f fVar = this.q;
        if (fVar != null) {
            if ((fVar == null ? null : fVar.getStatus()) == AsyncTask.Status.PENDING) {
                f fVar2 = this.q;
                if (fVar2 != null) {
                    fVar2.execute(new Void[0]);
                }
                ProgressDialog progressDialog = this.n;
                if (progressDialog == null) {
                    return;
                }
                progressDialog.show();
                return;
            }
        }
        x();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        f fVar = this.q;
        if (fVar != null) {
            fVar.cancel(true);
            ProgressDialog progressDialog = this.n;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
        super.onStop();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        kotlin.jvm.internal.m.f(layoutParams, "params");
        if (layoutParams.token == null) {
            this.u = layoutParams;
        }
        super.onWindowAttributesChanged(layoutParams);
    }

    protected final boolean q() {
        return this.r;
    }

    protected final boolean r() {
        return this.t;
    }

    public Bundle w(String str) {
        Uri uri = Uri.parse(str);
        p0 p0Var = p0.a;
        Bundle bundleO0 = p0.o0(uri.getQuery());
        bundleO0.putAll(p0.o0(uri.getFragment()));
        return bundleO0;
    }

    public final void x() {
        Object systemService = getContext().getSystemService("window");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        int i4 = i2 < i3 ? i2 : i3;
        if (i2 < i3) {
            i2 = i3;
        }
        int iMin = Math.min(n(i4, displayMetrics.density, 480, 800), displayMetrics.widthPixels);
        int iMin2 = Math.min(n(i2, displayMetrics.density, 800, 1280), displayMetrics.heightPixels);
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(iMin, iMin2);
    }

    protected final void y(Throwable th) {
        if (this.l == null || this.r) {
            return;
        }
        this.r = true;
        FacebookException facebookException = th instanceof FacebookException ? (FacebookException) th : new FacebookException(th);
        e eVar = this.l;
        if (eVar != null) {
            eVar.a(null, facebookException);
        }
        dismiss();
    }

    protected final void z(Bundle bundle) {
        e eVar = this.l;
        if (eVar == null || this.r) {
            return;
        }
        this.r = true;
        if (eVar != null) {
            eVar.a(bundle, null);
        }
        dismiss();
    }

    private r0(Context context, String str, int i2) {
        super(context, i2 == 0 ? f9841f.a() : i2);
        this.f9846k = "fbconnect://success";
        this.f9845j = str;
    }

    private r0(Context context, String str, Bundle bundle, int i2, com.facebook.login.z zVar, e eVar) {
        Uri uriE;
        super(context, i2 == 0 ? f9841f.a() : i2);
        this.f9846k = "fbconnect://success";
        bundle = bundle == null ? new Bundle() : bundle;
        p0 p0Var = p0.a;
        String str2 = p0.U(context) ? "fbconnect://chrome_os_success" : "fbconnect://success";
        this.f9846k = str2;
        bundle.putString("redirect_uri", str2);
        bundle.putString("display", "touch");
        com.facebook.a0 a0Var = com.facebook.a0.a;
        bundle.putString("client_id", com.facebook.a0.d());
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String str3 = String.format(Locale.ROOT, "android-%s", Arrays.copyOf(new Object[]{com.facebook.a0.s()}, 1));
        kotlin.jvm.internal.m.e(str3, "java.lang.String.format(locale, format, *args)");
        bundle.putString("sdk", str3);
        this.l = eVar;
        if (kotlin.jvm.internal.m.a(str, "share") && bundle.containsKey("media")) {
            this.q = new f(this, str, bundle);
            return;
        }
        if (g.a[zVar.ordinal()] == 1) {
            n0 n0Var = n0.a;
            uriE = p0.e(n0.k(), "oauth/authorize", bundle);
        } else {
            n0 n0Var2 = n0.a;
            uriE = p0.e(n0.b(), com.facebook.a0.n() + "/dialog/" + ((Object) str), bundle);
        }
        this.f9845j = uriE.toString();
    }

    /* JADX INFO: compiled from: WebDialog.kt */
    public static class a {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f9847b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f9848c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f9849d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private e f9850e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Bundle f9851f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private AccessToken f9852g;

        public a(Context context, String str, Bundle bundle) {
            kotlin.jvm.internal.m.f(context, "context");
            kotlin.jvm.internal.m.f(str, "action");
            AccessToken.c cVar = AccessToken.f9559f;
            this.f9852g = cVar.e();
            if (!cVar.g()) {
                p0 p0Var = p0.a;
                String strH = p0.H(context);
                if (strH == null) {
                    throw new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
                }
                this.f9847b = strH;
            }
            b(context, str, bundle);
        }

        private final void b(Context context, String str, Bundle bundle) {
            this.a = context;
            this.f9848c = str;
            if (bundle != null) {
                this.f9851f = bundle;
            } else {
                this.f9851f = new Bundle();
            }
        }

        public r0 a() {
            AccessToken accessToken = this.f9852g;
            if (accessToken != null) {
                Bundle bundle = this.f9851f;
                if (bundle != null) {
                    bundle.putString(RateAndReviewsFragment.BundleCons.APP_ID, accessToken == null ? null : accessToken.c());
                }
                Bundle bundle2 = this.f9851f;
                if (bundle2 != null) {
                    AccessToken accessToken2 = this.f9852g;
                    bundle2.putString("access_token", accessToken2 != null ? accessToken2.l() : null);
                }
            } else {
                Bundle bundle3 = this.f9851f;
                if (bundle3 != null) {
                    bundle3.putString(RateAndReviewsFragment.BundleCons.APP_ID, this.f9847b);
                }
            }
            b bVar = r0.f9841f;
            Context context = this.a;
            if (context != null) {
                return bVar.c(context, this.f9848c, this.f9851f, this.f9849d, this.f9850e);
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        public final String c() {
            return this.f9847b;
        }

        public final Context d() {
            return this.a;
        }

        public final e e() {
            return this.f9850e;
        }

        public final Bundle f() {
            return this.f9851f;
        }

        public final int g() {
            return this.f9849d;
        }

        public final a h(e eVar) {
            this.f9850e = eVar;
            return this;
        }

        public a(Context context, String str, String str2, Bundle bundle) {
            kotlin.jvm.internal.m.f(context, "context");
            kotlin.jvm.internal.m.f(str2, "action");
            if (str == null) {
                p0 p0Var = p0.a;
                str = p0.H(context);
            }
            q0 q0Var = q0.a;
            this.f9847b = q0.k(str, "applicationId");
            b(context, str2, bundle);
        }
    }
}
