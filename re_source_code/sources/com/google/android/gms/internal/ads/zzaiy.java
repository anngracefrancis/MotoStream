package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
public final class zzaiy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaiy> CREATOR = new zzaiz();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f13921f;

    @SafeParcelable.Constructor
    public zzaiy(@SafeParcelable.Param(id = 1) int i2) {
        this.f13921f = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f13921f);
        SafeParcelWriter.b(parcel, iA);
    }
}
