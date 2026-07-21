package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class zzday extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzday> CREATOR = new zzdaz();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f15849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final byte[] f15850g;

    @SafeParcelable.Constructor
    zzday(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) byte[] bArr) {
        this.f15849f = i2;
        this.f15850g = bArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f15849f);
        SafeParcelWriter.f(parcel, 2, this.f15850g, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public zzday(byte[] bArr) {
        this(1, bArr);
    }
}
