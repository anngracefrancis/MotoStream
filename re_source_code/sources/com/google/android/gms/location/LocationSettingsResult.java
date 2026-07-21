package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class LocationSettingsResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new zzah();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final Status f17654f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final LocationSettingsStates f17655g;

    @SafeParcelable.Constructor
    public LocationSettingsResult(@SafeParcelable.Param(id = 1) Status status, @SafeParcelable.Param(id = 2) LocationSettingsStates locationSettingsStates) {
        this.f17654f = status;
        this.f17655g = locationSettingsStates;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f17654f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, getStatus(), i2, false);
        SafeParcelWriter.s(parcel, 2, y(), i2, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final LocationSettingsStates y() {
        return this.f17655g;
    }
}
