package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class LocationSettingsStates extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new zzai();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f17656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f17657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f17658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f17659i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f17660j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f17661k;

    @SafeParcelable.Constructor
    public LocationSettingsStates(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) boolean z2, @SafeParcelable.Param(id = 3) boolean z3, @SafeParcelable.Param(id = 4) boolean z4, @SafeParcelable.Param(id = 5) boolean z5, @SafeParcelable.Param(id = 6) boolean z6) {
        this.f17656f = z;
        this.f17657g = z2;
        this.f17658h = z3;
        this.f17659i = z4;
        this.f17660j = z5;
        this.f17661k = z6;
    }

    public final boolean W() {
        return this.f17659i;
    }

    public final boolean Y() {
        return this.f17656f;
    }

    public final boolean e0() {
        return this.f17660j;
    }

    public final boolean i0() {
        return this.f17657g;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.c(parcel, 1, Y());
        SafeParcelWriter.c(parcel, 2, i0());
        SafeParcelWriter.c(parcel, 3, z());
        SafeParcelWriter.c(parcel, 4, W());
        SafeParcelWriter.c(parcel, 5, e0());
        SafeParcelWriter.c(parcel, 6, y());
        SafeParcelWriter.b(parcel, iA);
    }

    public final boolean y() {
        return this.f17661k;
    }

    public final boolean z() {
        return this.f17658h;
    }
}
