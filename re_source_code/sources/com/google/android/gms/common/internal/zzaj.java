package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
@Deprecated
public final class zzaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaj> CREATOR = new zzak();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    final int f12055f;

    @SafeParcelable.Constructor
    zzaj(@SafeParcelable.Param(id = 1) int i2) {
        this.f12055f = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f12055f);
        SafeParcelWriter.b(parcel, iA);
    }
}
