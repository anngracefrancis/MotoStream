package com.google.android.gms.internal.location;

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
public final class zzad extends AbstractSafeParcelable implements Result {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final Status f17085g;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final zzad f17084f = new zzad(Status.f11688g);
    public static final Parcelable.Creator<zzad> CREATOR = new zzae();

    @SafeParcelable.Constructor
    public zzad(@SafeParcelable.Param(id = 1) Status status) {
        this.f17085g = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f17085g;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, getStatus(), i2, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
