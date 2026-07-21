package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zza> CREATOR = new zzb();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f18263f;

    @SafeParcelable.Constructor
    public zza(@SafeParcelable.Param(id = 2) String str) {
        this.f18263f = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, this.f18263f, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
