package com.google.android.gms.internal.ads;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@TargetApi(11)
public final class zzbgr extends WebChromeClient {
    private final zzbgz a;

    public zzbgr(zzbgz zzbgzVar) {
        this.a = zzbgzVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Context a(WebView webView) {
        if (!(webView instanceof zzbgz)) {
            return webView.getContext();
        }
        zzbgz zzbgzVar = (zzbgz) webView;
        Activity activityA = zzbgzVar.a();
        return activityA != null ? activityA : zzbgzVar.getContext();
    }

    private final boolean b(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        com.google.android.gms.ads.internal.zzb zzbVarO;
        try {
            zzbgz zzbgzVar = this.a;
            if (zzbgzVar != null && zzbgzVar.p() != null && this.a.p().o() != null && (zzbVarO = this.a.p().o()) != null && !zzbVarO.zzkx()) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(str3).length());
                sb.append("window.");
                sb.append(str);
                sb.append("('");
                sb.append(str3);
                sb.append("')");
                zzbVarO.zzbk(sb.toString());
                return false;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(str2);
            if (z) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                TextView textView = new TextView(context);
                textView.setText(str3);
                EditText editText = new EditText(context);
                editText.setText(str4);
                linearLayout.addView(textView);
                linearLayout.addView(editText);
                builder.setView(linearLayout).setPositiveButton(R.string.ok, new ra(jsPromptResult, editText)).setNegativeButton(R.string.cancel, new qa(jsPromptResult)).setOnCancelListener(new pa(jsPromptResult)).create().show();
            } else {
                builder.setMessage(str3).setPositiveButton(R.string.ok, new oa(jsResult)).setNegativeButton(R.string.cancel, new na(jsResult)).setOnCancelListener(new ma(jsResult)).create().show();
            }
            return true;
        } catch (WindowManager.BadTokenException e2) {
            zzbad.d("Fail to display Dialog.", e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzbgz)) {
            zzbad.i("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzd zzdVarK0 = ((zzbgz) webView).k0();
        if (zzdVarK0 == null) {
            zzbad.i("Tried to close an AdWebView not associated with an overlay.");
        } else {
            zzdVarK0.close();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String strMessage = consoleMessage.message();
        String strSourceId = consoleMessage.sourceId();
        int iLineNumber = consoleMessage.lineNumber();
        StringBuilder sb = new StringBuilder(String.valueOf(strMessage).length() + 19 + String.valueOf(strSourceId).length());
        sb.append("JS: ");
        sb.append(strMessage);
        sb.append(" (");
        sb.append(strSourceId);
        sb.append(":");
        sb.append(iLineNumber);
        sb.append(")");
        String string = sb.toString();
        if (string.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        int i2 = sa.a[consoleMessage.messageLevel().ordinal()];
        if (i2 == 1) {
            zzbad.g(string);
        } else if (i2 == 2) {
            zzbad.i(string);
        } else if (i2 == 3 || i2 == 4 || i2 != 5) {
            zzbad.h(string);
        } else {
            zzbad.e(string);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        if (this.a.z() != null) {
            webView2.setWebViewClient(this.a.z());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onExceededDatabaseQuota(String str, String str2, long j2, long j3, long j4, WebStorage.QuotaUpdater quotaUpdater) {
        long j5 = 5242880 - j4;
        if (j5 <= 0) {
            quotaUpdater.updateQuota(j2);
            return;
        }
        if (j2 != 0) {
            if (j3 == 0) {
                j2 = Math.min(j2 + Math.min(131072L, j5), 1048576L);
            } else if (j3 <= Math.min(1048576 - j2, j5)) {
                j2 += j3;
            }
            j3 = j2;
        } else if (j3 > j5 || j3 > 1048576) {
            j3 = 0;
        }
        quotaUpdater.updateQuota(j3);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0028  */
    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        boolean z;
        if (callback != null) {
            zzk.zzlg();
            if (zzaxi.f0(this.a.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                z = true;
            } else {
                zzk.zzlg();
                if (zzaxi.f0(this.a.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z = true;
                } else {
                    z = false;
                }
            }
            callback.invoke(str, z, true);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        com.google.android.gms.ads.internal.overlay.zzd zzdVarK0 = this.a.k0();
        if (zzdVarK0 == null) {
            zzbad.i("Could not get ad overlay when hiding custom view.");
        } else {
            zzdVarK0.zzte();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return b(a(webView), "alert", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return b(a(webView), "onBeforeUnload", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return b(a(webView), "confirm", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return b(a(webView), "prompt", str, str2, str3, null, jsPromptResult, true);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(21)
    public final void onPermissionRequest(PermissionRequest permissionRequest) {
        if (PlatformVersion.h()) {
            if (!((Boolean) zzyt.e().c(zzacu.S0)).booleanValue()) {
                zzbgz zzbgzVar = this.a;
                if (zzbgzVar == null || zzbgzVar.p() == null || this.a.p().n() == null) {
                    super.onPermissionRequest(permissionRequest);
                    return;
                }
                String[] strArrD = this.a.p().n().d(permissionRequest.getResources());
                if (strArrD.length > 0) {
                    permissionRequest.grant(strArrD);
                    return;
                } else {
                    permissionRequest.deny();
                    return;
                }
            }
        }
        super.onPermissionRequest(permissionRequest);
    }

    public final void onReachedMaxAppCacheSize(long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        long j4 = j2 + 131072;
        if (5242880 - j3 < j4) {
            quotaUpdater.updateQuota(0L);
        } else {
            quotaUpdater.updateQuota(j4);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public final void onShowCustomView(View view, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
        com.google.android.gms.ads.internal.overlay.zzd zzdVarK0 = this.a.k0();
        if (zzdVarK0 == null) {
            zzbad.i("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
        } else {
            zzdVarK0.zza(view, customViewCallback);
            zzdVarK0.setRequestedOrientation(i2);
        }
    }
}
