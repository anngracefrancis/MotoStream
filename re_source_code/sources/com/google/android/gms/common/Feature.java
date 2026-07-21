package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
@SafeParcelable.Class
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new zzc();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f11626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    @Deprecated
    private final int f11627g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final long f11628h;

    @SafeParcelable.Constructor
    public Feature(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) long j2) {
        this.f11626f = str;
        this.f11627g = i2;
        this.f11628h = j2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((y() != null && y().equals(feature.y())) || (y() == null && feature.y() == null)) && z() == feature.z()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.b(y(), Long.valueOf(z()));
    }

    public final String toString() {
        Objects.ToStringHelper toStringHelperC = Objects.c(this);
        toStringHelperC.a("name", y());
        toStringHelperC.a("version", Long.valueOf(z()));
        return toStringHelperC.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, y(), false);
        SafeParcelWriter.l(parcel, 2, this.f11627g);
        SafeParcelWriter.p(parcel, 3, z());
        SafeParcelWriter.b(parcel, iA);
    }

    @KeepForSdk
    public String y() {
        return this.f11626f;
    }

    @KeepForSdk
    public long z() {
        long j2 = this.f11628h;
        return j2 == -1 ? this.f11627g : j2;
    }
}
