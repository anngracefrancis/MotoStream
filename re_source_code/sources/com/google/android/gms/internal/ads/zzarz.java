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
public final class zzarz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzarz> CREATOR = new zzasa();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    String f14110f;

    @SafeParcelable.Constructor
    public zzarz(@SafeParcelable.Param(id = 2) String str) {
        this.f14110f = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, this.f14110f, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
