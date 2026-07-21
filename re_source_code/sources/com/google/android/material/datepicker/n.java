package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: compiled from: TimeSource.java */
/* JADX INFO: loaded from: classes2.dex */
class n {
    private static final n a = new n(null, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Long f18622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TimeZone f18623c;

    private n(Long l, TimeZone timeZone) {
        this.f18622b = l;
        this.f18623c = timeZone;
    }

    static n c() {
        return a;
    }

    Calendar a() {
        return b(this.f18623c);
    }

    Calendar b(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l = this.f18622b;
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
        }
        return calendar;
    }
}
