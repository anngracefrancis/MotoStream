package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdh {
    private static final String[] a = {"/aclk", "/pcs/click", "/dbm/clk"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15915b = "googleads.g.doubleclick.net";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15916c = "/pagead/ads";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f15917d = "ad.doubleclick.net";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String[] f15918e = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzdc f15919f;

    public zzdh(zzdc zzdcVar) {
        this.f15919f = zzdcVar;
    }

    private final Uri b(Uri uri, Context context, String str, boolean z, View view, Activity activity) throws zzdi {
        try {
            boolean zD = d(uri);
            if (zD) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzdi("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzdi("Query parameter already exists: ms");
            }
            String strZza = z ? this.f15919f.zza(context, str, view, activity) : this.f15919f.zza(context);
            if (!zD) {
                String string = uri.toString();
                int iIndexOf = string.indexOf("&adurl");
                if (iIndexOf == -1) {
                    iIndexOf = string.indexOf("?adurl");
                }
                if (iIndexOf == -1) {
                    return uri.buildUpon().appendQueryParameter("ms", strZza).build();
                }
                int i2 = iIndexOf + 1;
                return Uri.parse(string.substring(0, i2) + "ms=" + strZza + "&" + string.substring(i2));
            }
            String string2 = uri.toString();
            int iIndexOf2 = string2.indexOf(";adurl");
            if (iIndexOf2 != -1) {
                int i3 = iIndexOf2 + 1;
                return Uri.parse(string2.substring(0, i3) + "dc_ms=" + strZza + ";" + string2.substring(i3));
            }
            String encodedPath = uri.getEncodedPath();
            int iIndexOf3 = string2.indexOf(encodedPath);
            return Uri.parse(string2.substring(0, encodedPath.length() + iIndexOf3) + ";dc_ms=" + strZza + ";" + string2.substring(iIndexOf3 + encodedPath.length()));
        } catch (UnsupportedOperationException unused) {
            throw new zzdi("Provided Uri is not in a valid state");
        }
    }

    private final boolean d(Uri uri) {
        uri.getClass();
        try {
            return uri.getHost().equals(this.f15917d);
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public final Uri a(Uri uri, Context context, View view, Activity activity) throws zzdi {
        try {
            return b(uri, context, uri.getQueryParameter("ai"), true, view, activity);
        } catch (UnsupportedOperationException unused) {
            throw new zzdi("Provided Uri is not in a valid state");
        }
    }

    public final void c(MotionEvent motionEvent) {
        this.f15919f.zza(motionEvent);
    }

    public final boolean e(Uri uri) {
        uri.getClass();
        try {
            String host = uri.getHost();
            for (String str : this.f15918e) {
                if (host.endsWith(str)) {
                    return true;
                }
            }
        } catch (NullPointerException unused) {
        }
        return false;
    }

    public final zzdc f() {
        return this.f15919f;
    }

    public final boolean g(Uri uri) {
        if (e(uri)) {
            for (String str : a) {
                if (uri.getPath().endsWith(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
