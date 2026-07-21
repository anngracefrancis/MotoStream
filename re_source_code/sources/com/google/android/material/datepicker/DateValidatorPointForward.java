package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f18552f;

    static class a implements Parcelable.Creator<DateValidatorPointForward> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DateValidatorPointForward createFromParcel(Parcel parcel) {
            return new DateValidatorPointForward(parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DateValidatorPointForward[] newArray(int i2) {
            return new DateValidatorPointForward[i2];
        }
    }

    /* synthetic */ DateValidatorPointForward(long j2, a aVar) {
        this(j2);
    }

    public static DateValidatorPointForward a(long j2) {
        return new DateValidatorPointForward(j2);
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean F0(long j2) {
        return j2 >= this.f18552f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointForward) && this.f18552f == ((DateValidatorPointForward) obj).f18552f;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f18552f)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f18552f);
    }

    private DateValidatorPointForward(long j2) {
        this.f18552f = j2;
    }
}
