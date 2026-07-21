package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
public final class zzaum extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaum> CREATOR = new zzaun();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f14162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f14163g;

    public zzaum(ServerSideVerificationOptions serverSideVerificationOptions) {
        this(serverSideVerificationOptions.getUserId(), serverSideVerificationOptions.getCustomData());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f14162f, false);
        SafeParcelWriter.u(parcel, 2, this.f14163g, false);
        SafeParcelWriter.b(parcel, iA);
    }

    @SafeParcelable.Constructor
    public zzaum(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2) {
        this.f14162f = str;
        this.f14163g = str2;
    }
}
