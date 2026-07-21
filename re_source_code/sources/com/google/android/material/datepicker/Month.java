package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes2.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Calendar f18555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f18556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int f18557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final int f18558i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final int f18559j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final int f18560k;
    final long l;

    static class a implements Parcelable.Creator<Month> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Month createFromParcel(Parcel parcel) {
            return Month.k(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Month[] newArray(int i2) {
            return new Month[i2];
        }
    }

    private Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarD = o.d(calendar);
        this.f18555f = calendarD;
        this.f18557h = calendarD.get(2);
        this.f18558i = calendarD.get(1);
        this.f18559j = calendarD.getMaximum(7);
        this.f18560k = calendarD.getActualMaximum(5);
        this.f18556g = o.o().format(calendarD.getTime());
        this.l = calendarD.getTimeInMillis();
    }

    static Month k(int i2, int i3) {
        Calendar calendarL = o.l();
        calendarL.set(1, i2);
        calendarL.set(2, i3);
        return new Month(calendarL);
    }

    static Month q(long j2) {
        Calendar calendarL = o.l();
        calendarL.setTimeInMillis(j2);
        return new Month(calendarL);
    }

    static Month u() {
        return new Month(o.j());
    }

    long E() {
        return this.f18555f.getTimeInMillis();
    }

    Month F(int i2) {
        Calendar calendarD = o.d(this.f18555f);
        calendarD.add(2, i2);
        return new Month(calendarD);
    }

    int G(Month month) {
        if (this.f18555f instanceof GregorianCalendar) {
            return ((month.f18558i - this.f18558i) * 12) + (month.f18557h - this.f18557h);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.f18557h == month.f18557h && this.f18558i == month.f18558i;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public int compareTo(Month month) {
        return this.f18555f.compareTo(month.f18555f);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f18557h), Integer.valueOf(this.f18558i)});
    }

    int v() {
        int firstDayOfWeek = this.f18555f.get(7) - this.f18555f.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f18559j : firstDayOfWeek;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f18558i);
        parcel.writeInt(this.f18557h);
    }

    long x(int i2) {
        Calendar calendarD = o.d(this.f18555f);
        calendarD.set(5, i2);
        return calendarD.getTimeInMillis();
    }

    String y() {
        return this.f18556g;
    }
}
