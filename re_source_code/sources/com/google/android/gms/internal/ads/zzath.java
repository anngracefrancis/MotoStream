package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class zzath extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzath> CREATOR = new zzati();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public final zzxz f14150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f14151g;

    @SafeParcelable.Constructor
    public zzath(@SafeParcelable.Param(id = 2) zzxz zzxzVar, @SafeParcelable.Param(id = 3) String str) {
        this.f14150f = zzxzVar;
        this.f14151g = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 2, this.f14150f, i2, false);
        SafeParcelWriter.u(parcel, 3, this.f14151g, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
