package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
public final class zzaio extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaio> CREATOR = new zzaip();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f13915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f13916g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f13917h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f13918i;

    @SafeParcelable.Constructor
    public zzaio(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) String str2) {
        this.f13915f = str;
        this.f13916g = z;
        this.f13917h = i2;
        this.f13918i = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f13915f, false);
        SafeParcelWriter.c(parcel, 2, this.f13916g);
        SafeParcelWriter.l(parcel, 3, this.f13917h);
        SafeParcelWriter.u(parcel, 4, this.f13918i, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
