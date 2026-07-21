package io.sentry;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: DateUtils.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class a1 {
    public static long a(Date date) {
        return h(date.getTime());
    }

    public static double b(Date date) {
        return i(date.getTime());
    }

    public static Date c() {
        return Calendar.getInstance(io.sentry.vendor.gson.internal.bind.util.a.a).getTime();
    }

    public static Date d(long j2) {
        Calendar calendar = Calendar.getInstance(io.sentry.vendor.gson.internal.bind.util.a.a);
        calendar.setTimeInMillis(j2);
        return calendar.getTime();
    }

    public static Date e(String str) throws IllegalArgumentException {
        try {
            return io.sentry.vendor.gson.internal.bind.util.a.f(str, new ParsePosition(0));
        } catch (ParseException unused) {
            throw new IllegalArgumentException("timestamp is not ISO format " + str);
        }
    }

    public static Date f(String str) throws IllegalArgumentException {
        try {
            return d(new BigDecimal(str).setScale(3, RoundingMode.DOWN).movePointRight(3).longValue());
        } catch (NumberFormatException unused) {
            throw new IllegalArgumentException("timestamp is not millis format " + str);
        }
    }

    public static String g(Date date) {
        return io.sentry.vendor.gson.internal.bind.util.a.b(date, true);
    }

    public static long h(long j2) {
        return j2 * 1000000;
    }

    public static double i(double d2) {
        return d2 / 1000.0d;
    }

    public static Date j(long j2) {
        return d(Double.valueOf(k(Double.valueOf(j2).doubleValue())).longValue());
    }

    public static double k(double d2) {
        return d2 / 1000000.0d;
    }

    public static double l(long j2) {
        return Double.valueOf(j2).doubleValue() / 1.0E9d;
    }

    public static long m(long j2) {
        return j2 * 1000000000;
    }

    public static Date n(f4 f4Var) {
        if (f4Var == null) {
            return null;
        }
        return o(f4Var);
    }

    public static Date o(f4 f4Var) {
        return j(f4Var.x());
    }
}
