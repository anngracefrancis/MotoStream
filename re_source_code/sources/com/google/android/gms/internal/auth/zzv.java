package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class zzv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzv> CREATOR = new zzw();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f17047f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f17048g;

    @SafeParcelable.Constructor
    zzv(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str) {
        this.f17048g = (String) Preconditions.k(str);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f17047f);
        SafeParcelWriter.u(parcel, 2, this.f17048g, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
