package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzacw {
    public static boolean a(String str) {
        return b((String) zzyt.e().c(zzacu.k4), str);
    }

    private static boolean b(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                return Pattern.matches(str, str2);
            } catch (RuntimeException e2) {
                zzk.zzlk().e(e2, "NonagonUtil.isPatternMatched");
            }
        }
        return false;
    }
}
