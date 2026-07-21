package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.measurement.internal.zzgw;
import com.google.android.gms.measurement.internal.zzgy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static final Set<String> a = new HashSet(Arrays.asList("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f18860b = Arrays.asList("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd", "app_open");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<String> f18861c = Arrays.asList("auto", "app", "am");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<String> f18862d = Arrays.asList("_r", "_dbg");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final List<String> f18863e = Arrays.asList((String[]) ArrayUtils.a(zzgy.a, zzgy.f18168b));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final List<String> f18864f = Arrays.asList("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");

    public static boolean a(String str) {
        return !f18861c.contains(str);
    }

    public static boolean b(String str, Bundle bundle) {
        if (f18860b.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        Iterator<String> it = f18862d.iterator();
        while (it.hasNext()) {
            if (bundle.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals("fcm") || str.equals("frc");
        }
        if ("_ln".equals(str2)) {
            return str.equals("fcm") || str.equals("fiam");
        }
        if (f18863e.contains(str2)) {
            return false;
        }
        Iterator<String> it = f18864f.iterator();
        while (it.hasNext()) {
            if (str2.matches(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(String str, String str2, Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!a(str) || bundle == null) {
            return false;
        }
        Iterator<String> it = f18862d.iterator();
        while (it.hasNext()) {
            if (bundle.containsKey(it.next())) {
                return false;
            }
        }
        str.hashCode();
        switch (str) {
            case "fcm":
                bundle.putString("_cis", "fcm_integration");
                return true;
            case "fdl":
                bundle.putString("_cis", "fdl_integration");
                return true;
            case "fiam":
                bundle.putString("_cis", "fiam_integration");
                return true;
            default:
                return false;
        }
    }

    public static boolean e(String str) {
        return !a.contains(str);
    }

    public static String f(String str) {
        String strA = zzgw.a(str);
        return strA != null ? strA : str;
    }
}
