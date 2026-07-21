package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzavx {
    @VisibleForTesting
    private static Uri a(String str, String str2, String str3) {
        int iIndexOf = str.indexOf("&adurl");
        if (iIndexOf == -1) {
            iIndexOf = str.indexOf("?adurl");
        }
        if (iIndexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        int i2 = iIndexOf + 1;
        return Uri.parse(str.substring(0, i2) + str2 + "=" + str3 + "&" + str.substring(i2));
    }

    public static String b(Uri uri, Context context) {
        if (!zzk.zzme().D(context)) {
            return uri.toString();
        }
        String strN = zzk.zzme().n(context);
        if (strN == null) {
            return uri.toString();
        }
        if (((Boolean) zzyt.e().c(zzacu.C0)).booleanValue()) {
            String str = (String) zzyt.e().c(zzacu.D0);
            String string = uri.toString();
            if (string.contains(str)) {
                zzk.zzme().u(context, strN);
                return string.replace(str, strN);
            }
        } else if (TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            uri = a(uri.toString(), "fbs_aeid", strN);
            zzk.zzme().u(context, strN);
        }
        return uri.toString();
    }

    public static String c(String str, Context context, boolean z) {
        String strN;
        if ((((Boolean) zzyt.e().c(zzacu.K0)).booleanValue() && !z) || !zzk.zzme().D(context) || TextUtils.isEmpty(str) || (strN = zzk.zzme().n(context)) == null) {
            return str;
        }
        if (!((Boolean) zzyt.e().c(zzacu.C0)).booleanValue()) {
            if (str.contains("fbs_aeid")) {
                return str;
            }
            if (zzk.zzlg().T(str)) {
                zzk.zzme().u(context, strN);
                return a(str, "fbs_aeid", strN).toString();
            }
            if (!zzk.zzlg().U(str)) {
                return str;
            }
            zzk.zzme().v(context, strN);
            return a(str, "fbs_aeid", strN).toString();
        }
        CharSequence charSequence = (String) zzyt.e().c(zzacu.D0);
        if (!str.contains(charSequence)) {
            return str;
        }
        if (zzk.zzlg().T(str)) {
            zzk.zzme().u(context, strN);
            return str.replace(charSequence, strN);
        }
        if (!zzk.zzlg().U(str)) {
            return str;
        }
        zzk.zzme().v(context, strN);
        return str.replace(charSequence, strN);
    }
}
