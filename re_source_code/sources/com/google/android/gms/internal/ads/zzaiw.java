package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
public final class zzaiw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaiw> CREATOR = new zzaix();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f13919f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public final Bundle f13920g;

    @SafeParcelable.Constructor
    public zzaiw(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) Bundle bundle) {
        this.f13919f = str;
        this.f13920g = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f13919f, false);
        SafeParcelWriter.e(parcel, 2, this.f13920g, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
