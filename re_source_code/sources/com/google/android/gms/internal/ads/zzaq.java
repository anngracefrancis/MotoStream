package com.google.android.gms.internal.ads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaq {
    public static zzc a(zzp zzpVar) {
        boolean z;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = zzpVar.f16553c;
        String str = map.get("Date");
        long jC = str != null ? c(str) : 0L;
        String str2 = map.get("Cache-Control");
        int i2 = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            int i3 = 0;
            j2 = 0;
            j3 = 0;
            while (i2 < strArrSplit.length) {
                String strTrim = strArrSplit[i2].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j3 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    i3 = 1;
                }
                i2++;
            }
            i2 = i3;
            z = true;
        } else {
            z = false;
            j2 = 0;
            j3 = 0;
        }
        String str3 = map.get("Expires");
        long jC2 = str3 != null ? c(str3) : 0L;
        String str4 = map.get("Last-Modified");
        long jC3 = str4 != null ? c(str4) : 0L;
        String str5 = map.get("ETag");
        if (z) {
            j5 = jCurrentTimeMillis + (j2 * 1000);
            if (i2 != 0) {
                j6 = j5;
            } else {
                Long.signum(j3);
                j6 = (j3 * 1000) + j5;
            }
            j4 = j6;
        } else {
            j4 = 0;
            if (jC <= 0 || jC2 < jC) {
                j5 = 0;
            } else {
                j5 = jCurrentTimeMillis + (jC2 - jC);
                j4 = j5;
            }
        }
        zzc zzcVar = new zzc();
        zzcVar.a = zzpVar.f16552b;
        zzcVar.f14946b = str5;
        zzcVar.f14950f = j5;
        zzcVar.f14949e = j4;
        zzcVar.f14947c = jC;
        zzcVar.f14948d = jC3;
        zzcVar.f14951g = map;
        zzcVar.f14952h = zzpVar.f16554d;
        return zzcVar;
    }

    static String b(long j2) {
        return d().format(new Date(j2));
    }

    private static long c(String str) {
        try {
            return d().parse(str).getTime();
        } catch (ParseException e2) {
            zzag.e(e2, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    private static SimpleDateFormat d() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
