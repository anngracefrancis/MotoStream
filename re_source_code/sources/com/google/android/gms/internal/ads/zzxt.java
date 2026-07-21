package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
public final class zzxt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxt> CREATOR = new zzxu();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f16964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f16965g;

    @SafeParcelable.Constructor
    public zzxt(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2) {
        this.f16964f = str;
        this.f16965g = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f16964f, false);
        SafeParcelWriter.u(parcel, 2, this.f16965g, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
