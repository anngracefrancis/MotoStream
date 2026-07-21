package com.flurry.sdk;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class c2 {
    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        long j2 = 0;
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 < 0) {
                return j2;
            }
            outputStream.write(bArr, 0, i2);
            j2 += (long) i2;
        }
    }

    public static String b(String str) {
        if (str == null) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return str.length() <= 255 ? str : str.substring(0, 255);
    }

    public static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        for (byte b2 : bArr) {
            sb.append(cArr[(byte) ((b2 & 240) >> 4)]);
            sb.append(cArr[(byte) (b2 & 15)]);
        }
        return sb.toString();
    }

    public static void d() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("Must be called from a background thread!");
        }
    }

    public static void e(int i2, String str, String str2, boolean z) {
        if (i2 < 100) {
            return;
        }
        String strY = e7.a().l.y();
        long jF = p2.f("last_streaming_session_id", Long.MIN_VALUE);
        HashMap map = new HashMap();
        map.put("fl.response.code", String.valueOf(i2));
        map.put("fl.message", k(str));
        map.put("fl.current.session", Boolean.toString(z));
        map.put("fl.current.session.id", strY);
        if (i2 != 200) {
            g0.a();
            g0.d("Flurry.SDKReport.ServerRequest", map);
        }
        map.put("fl.report.identifier", str2);
        if (jF != Long.MIN_VALUE) {
            map.put("fl.last.session.id", String.valueOf(jF));
        }
        g0.a();
        g0.f("Flurry.SDKReport.ServerRequest", map);
    }

    public static void f(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean g(int i2) {
        return Build.VERSION.SDK_INT >= i2;
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 2);
        } catch (UnsupportedEncodingException e2) {
            d1.c(5, "GeneralUtil", "Unsupported UTF-8: " + e2.getMessage());
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    public static byte[] i(String str) {
        byte[] bArr = new byte[str.length() / 2];
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2 += 2) {
            StringBuilder sb = new StringBuilder(2);
            sb.append(charArray[i2]);
            sb.append(charArray[i2 + 1]);
            bArr[i2 / 2] = (byte) Integer.parseInt(sb.toString(), 16);
        }
        return bArr;
    }

    public static long j(String str) {
        if (str == null) {
            return 0L;
        }
        long jCharAt = 1125899906842597L;
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            jCharAt = (jCharAt * 31) + ((long) str.charAt(i2));
        }
        return jCharAt;
    }

    private static String k(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("status code")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.split("<!--|-->")) {
            if (!str2.contains("timestamp")) {
                String strTrim = str2.trim();
                if (strTrim.length() > 0) {
                    sb.append("<");
                    sb.append(strTrim);
                    sb.append(">");
                }
            }
        }
        return sb.toString();
    }
}
