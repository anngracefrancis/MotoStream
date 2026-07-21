package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
public final class zzawc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzawc> CREATOR = new zzawd();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f14197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f14198g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    public final zzyd f14199h;

    @SafeParcelable.Constructor
    public zzawc(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) zzyd zzydVar) {
        this.f14197f = str;
        this.f14198g = str2;
        this.f14199h = zzydVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f14197f, false);
        SafeParcelWriter.u(parcel, 2, this.f14198g, false);
        SafeParcelWriter.s(parcel, 3, this.f14199h, i2, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
