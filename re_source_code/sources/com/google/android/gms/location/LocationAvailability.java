package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new zzaa();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    @Deprecated
    private int f17629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    @Deprecated
    private int f17630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private long f17631h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private int f17632i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private zzaj[] f17633j;

    @SafeParcelable.Constructor
    LocationAvailability(@SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 1) int i3, @SafeParcelable.Param(id = 2) int i4, @SafeParcelable.Param(id = 3) long j2, @SafeParcelable.Param(id = 5) zzaj[] zzajVarArr) {
        this.f17632i = i2;
        this.f17629f = i3;
        this.f17630g = i4;
        this.f17631h = j2;
        this.f17633j = zzajVarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && LocationAvailability.class == obj.getClass()) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.f17629f == locationAvailability.f17629f && this.f17630g == locationAvailability.f17630g && this.f17631h == locationAvailability.f17631h && this.f17632i == locationAvailability.f17632i && Arrays.equals(this.f17633j, locationAvailability.f17633j)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.b(Integer.valueOf(this.f17632i), Integer.valueOf(this.f17629f), Integer.valueOf(this.f17630g), Long.valueOf(this.f17631h), this.f17633j);
    }

    public final String toString() {
        boolean zY = y();
        StringBuilder sb = new StringBuilder(48);
        sb.append("LocationAvailability[isLocationAvailable: ");
        sb.append(zY);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f17629f);
        SafeParcelWriter.l(parcel, 2, this.f17630g);
        SafeParcelWriter.p(parcel, 3, this.f17631h);
        SafeParcelWriter.l(parcel, 4, this.f17632i);
        SafeParcelWriter.x(parcel, 5, this.f17633j, i2, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final boolean y() {
        return this.f17632i < 1000;
    }
}
