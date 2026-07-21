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
public final class zzaax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaax> CREATOR = new zzaay();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f13731f;

    @SafeParcelable.Constructor
    public zzaax(@SafeParcelable.Param(id = 2) int i2) {
        this.f13731f = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 2, this.f13731f);
        SafeParcelWriter.b(parcel, iA);
    }
}
