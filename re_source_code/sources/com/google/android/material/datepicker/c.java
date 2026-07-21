package com.google.android.material.datepicker;

import android.os.Build;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: DateStrings.java */
/* JADX INFO: loaded from: classes2.dex */
class c {
    static String a(long j2) {
        return b(j2, Locale.getDefault());
    }

    static String b(long j2, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? o.b(locale).format(new Date(j2)) : o.f(locale).format(new Date(j2));
    }

    static String c(long j2) {
        return d(j2, Locale.getDefault());
    }

    static String d(long j2, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? o.n(locale).format(new Date(j2)) : o.f(locale).format(new Date(j2));
    }
}
