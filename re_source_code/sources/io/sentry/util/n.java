package io.sentry.util;

import io.sentry.c2;
import io.sentry.r2;
import io.sentry.s4;
import io.sentry.w1;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicIntegerArray;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: JsonSerializationUtils.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class n {
    private static final Charset a = Charset.forName("UTF-8");

    public static List<Object> a(AtomicIntegerArray atomicIntegerArray) {
        int length = atomicIntegerArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            arrayList.add(Integer.valueOf(atomicIntegerArray.get(i2)));
        }
        return arrayList;
    }

    public static byte[] b(c2 c2Var, w1 w1Var, r2 r2Var) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, a));
                try {
                    c2Var.a(r2Var, bufferedWriter);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    bufferedWriter.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (Throwable th) {
                    try {
                        bufferedWriter.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable unused2) {
                }
                throw th2;
            }
        } catch (Throwable th3) {
            w1Var.b(s4.ERROR, "Could not serialize serializable", th3);
            return null;
        }
    }

    public static Map<String, Object> c(Calendar calendar) {
        HashMap map = new HashMap();
        map.put("year", Integer.valueOf(calendar.get(1)));
        map.put("month", Integer.valueOf(calendar.get(2)));
        map.put("dayOfMonth", Integer.valueOf(calendar.get(5)));
        map.put("hourOfDay", Integer.valueOf(calendar.get(11)));
        map.put("minute", Integer.valueOf(calendar.get(12)));
        map.put("second", Integer.valueOf(calendar.get(13)));
        return map;
    }
}
