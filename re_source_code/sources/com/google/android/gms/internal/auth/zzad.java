package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class zzad extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzad> CREATOR = new zzae();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f17030f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f17031g;

    @SafeParcelable.Constructor
    zzad(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str) {
        this.f17031g = (String) Preconditions.k(str);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f17030f);
        SafeParcelWriter.u(parcel, 2, this.f17031g, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
