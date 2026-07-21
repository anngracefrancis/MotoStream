package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzayi {
    private final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14274b = HttpUrl.FRAGMENT_ENCODE_SET;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14275c = HttpUrl.FRAGMENT_ENCODE_SET;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14276d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    private String f14277e = HttpUrl.FRAGMENT_ENCODE_SET;

    @VisibleForTesting
    private final void b(Context context, String str, boolean z, boolean z2) {
        if (context instanceof Activity) {
            zzaxi.a.post(new s5(this, context, str, z, z2));
        } else {
            zzbad.h("Can not create dialog without Activity Context");
        }
    }

    private final String d(Context context) {
        String str;
        synchronized (this.a) {
            if (TextUtils.isEmpty(this.f14274b)) {
                zzk.zzlg();
                String strH0 = zzaxi.h0(context, "debug_signals_id.txt");
                this.f14274b = strH0;
                if (TextUtils.isEmpty(strH0)) {
                    zzk.zzlg();
                    this.f14274b = zzaxi.j0();
                    zzk.zzlg();
                    zzaxi.K(context, "debug_signals_id.txt", this.f14274b);
                }
            }
            str = this.f14274b;
        }
        return str;
    }

    private final void e(Context context, String str, String str2, String str3) {
        Uri.Builder builderBuildUpon = f(context, (String) zzyt.e().c(zzacu.L3), str3, str).buildUpon();
        builderBuildUpon.appendQueryParameter("debugData", str2);
        zzk.zzlg();
        zzaxi.J(context, str, builderBuildUpon.build().toString());
    }

    private final Uri f(Context context, String str, String str2, String str3) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        builderBuildUpon.appendQueryParameter("linkedDeviceId", d(context));
        builderBuildUpon.appendQueryParameter("adSlotPath", str2);
        builderBuildUpon.appendQueryParameter("afmaVersion", str3);
        return builderBuildUpon.build();
    }

    @VisibleForTesting
    private final boolean h(Context context, String str, String str2) {
        String strJ = j(context, f(context, (String) zzyt.e().c(zzacu.J3), str, str2).toString(), str2);
        if (TextUtils.isEmpty(strJ)) {
            zzbad.e("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strJ.trim());
            String strOptString = jSONObject.optString("gct");
            this.f14277e = jSONObject.optString("status");
            synchronized (this.a) {
                this.f14275c = strOptString;
            }
            return true;
        } catch (JSONException e2) {
            zzbad.d("Fail to get in app preview response json.", e2);
            return false;
        }
    }

    @VisibleForTesting
    private final boolean i(Context context, String str, String str2) {
        String strJ = j(context, f(context, (String) zzyt.e().c(zzacu.K3), str, str2).toString(), str2);
        if (TextUtils.isEmpty(strJ)) {
            zzbad.e("Not linked for debug signals.");
            return false;
        }
        try {
            boolean zEquals = "1".equals(new JSONObject(strJ.trim()).optString("debug_mode"));
            synchronized (this.a) {
                this.f14276d = zEquals;
            }
            return zEquals;
        } catch (JSONException e2) {
            zzbad.d("Fail to get debug mode response json.", e2);
            return false;
        }
    }

    @VisibleForTesting
    private static String j(Context context, String str, String str2) {
        HashMap map = new HashMap();
        map.put("User-Agent", zzk.zzlg().g0(context, str2));
        zzbbh<String> zzbbhVarC = new zzayu(context).c(str, map);
        try {
            return zzbbhVarC.get(((Integer) zzyt.e().c(zzacu.M3)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            String strValueOf = String.valueOf(str);
            zzbad.c(strValueOf.length() != 0 ? "Interrupted while retriving a response from: ".concat(strValueOf) : new String("Interrupted while retriving a response from: "), e2);
            zzbbhVarC.cancel(true);
            return null;
        } catch (TimeoutException e3) {
            String strValueOf2 = String.valueOf(str);
            zzbad.c(strValueOf2.length() != 0 ? "Timeout while retriving a response from: ".concat(strValueOf2) : new String("Timeout while retriving a response from: "), e3);
            zzbbhVarC.cancel(true);
            return null;
        } catch (Exception e4) {
            String strValueOf3 = String.valueOf(str);
            zzbad.c(strValueOf3.length() != 0 ? "Error retriving a response from: ".concat(strValueOf3) : new String("Error retriving a response from: "), e4);
            return null;
        }
    }

    private final void k(Context context, String str, String str2) {
        zzk.zzlg();
        zzaxi.j(context, f(context, (String) zzyt.e().c(zzacu.I3), str, str2));
    }

    public final void a(Context context, String str, String str2, String str3) {
        boolean zM = m();
        if (!i(context, str, str2)) {
            k(context, str, str2);
            return;
        }
        if (!zM && !TextUtils.isEmpty(str3)) {
            e(context, str2, str3, str);
        }
        zzbad.e("Device is linked for debug signals.");
        b(context, "The device is successfully linked for troubleshooting.", false, true);
    }

    public final boolean c(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !zzk.zzlq().m()) {
            return false;
        }
        zzbad.e("Sending troubleshooting signals to the server.");
        e(context, str, str2, str3);
        return true;
    }

    public final void g(Context context, String str, String str2) {
        if (!h(context, str, str2)) {
            b(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
            return;
        }
        if ("2".equals(this.f14277e)) {
            zzbad.e("Creative is not pushed for this device.");
            b(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(this.f14277e)) {
            zzbad.e("The app is not linked for creative preview.");
            k(context, str, str2);
        } else if ("0".equals(this.f14277e)) {
            zzbad.e("Device is linked for in app preview.");
            b(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final String l() {
        String str;
        synchronized (this.a) {
            str = this.f14275c;
        }
        return str;
    }

    public final boolean m() {
        boolean z;
        synchronized (this.a) {
            z = this.f14276d;
        }
        return z;
    }
}
