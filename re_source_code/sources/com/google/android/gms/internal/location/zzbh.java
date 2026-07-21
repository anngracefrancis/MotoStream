package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class zzbh extends AbstractSafeParcelable implements Geofence {
    public static final Parcelable.Creator<zzbh> CREATOR = new zzbi();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f17105f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final long f17106g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final short f17107h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final double f17108i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private final double f17109j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private final float f17110k;

    @SafeParcelable.Field
    private final int l;

    @SafeParcelable.Field
    private final int m;

    @SafeParcelable.Field
    private final int n;

    @SafeParcelable.Constructor
    public zzbh(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 7) int i2, @SafeParcelable.Param(id = 3) short s, @SafeParcelable.Param(id = 4) double d2, @SafeParcelable.Param(id = 5) double d3, @SafeParcelable.Param(id = 6) float f2, @SafeParcelable.Param(id = 2) long j2, @SafeParcelable.Param(id = 8) int i3, @SafeParcelable.Param(id = 9) int i4) {
        if (str == null || str.length() > 100) {
            String strValueOf = String.valueOf(str);
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "requestId is null or too long: ".concat(strValueOf) : new String("requestId is null or too long: "));
        }
        if (f2 <= 0.0f) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("invalid radius: ");
            sb.append(f2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (d2 > 90.0d || d2 < -90.0d) {
            StringBuilder sb2 = new StringBuilder(42);
            sb2.append("invalid latitude: ");
            sb2.append(d2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (d3 > 180.0d || d3 < -180.0d) {
            StringBuilder sb3 = new StringBuilder(43);
            sb3.append("invalid longitude: ");
            sb3.append(d3);
            throw new IllegalArgumentException(sb3.toString());
        }
        int i5 = i2 & 7;
        if (i5 == 0) {
            StringBuilder sb4 = new StringBuilder(46);
            sb4.append("No supported transition specified: ");
            sb4.append(i2);
            throw new IllegalArgumentException(sb4.toString());
        }
        this.f17107h = s;
        this.f17105f = str;
        this.f17108i = d2;
        this.f17109j = d3;
        this.f17110k = f2;
        this.f17106g = j2;
        this.l = i5;
        this.m = i3;
        this.n = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzbh)) {
            return false;
        }
        zzbh zzbhVar = (zzbh) obj;
        return this.f17110k == zzbhVar.f17110k && this.f17108i == zzbhVar.f17108i && this.f17109j == zzbhVar.f17109j && this.f17107h == zzbhVar.f17107h;
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f17108i);
        int i2 = ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31;
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f17109j);
        return (((((((i2 * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.f17110k)) * 31) + this.f17107h) * 31) + this.l;
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[9];
        objArr[0] = this.f17107h != 1 ? null : "CIRCLE";
        objArr[1] = this.f17105f.replaceAll("\\p{C}", "?");
        objArr[2] = Integer.valueOf(this.l);
        objArr[3] = Double.valueOf(this.f17108i);
        objArr[4] = Double.valueOf(this.f17109j);
        objArr[5] = Float.valueOf(this.f17110k);
        objArr[6] = Integer.valueOf(this.m / 1000);
        objArr[7] = Integer.valueOf(this.n);
        objArr[8] = Long.valueOf(this.f17106g);
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", objArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, y(), false);
        SafeParcelWriter.p(parcel, 2, this.f17106g);
        SafeParcelWriter.t(parcel, 3, this.f17107h);
        SafeParcelWriter.g(parcel, 4, this.f17108i);
        SafeParcelWriter.g(parcel, 5, this.f17109j);
        SafeParcelWriter.i(parcel, 6, this.f17110k);
        SafeParcelWriter.l(parcel, 7, this.l);
        SafeParcelWriter.l(parcel, 8, this.m);
        SafeParcelWriter.l(parcel, 9, this.n);
        SafeParcelWriter.b(parcel, iA);
    }

    public final String y() {
        return this.f17105f;
    }
}
