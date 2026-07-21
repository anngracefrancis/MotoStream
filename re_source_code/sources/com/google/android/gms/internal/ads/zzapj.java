package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
public final class zzapj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzapj> CREATOR = new zzapk();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f14031f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f14032g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f14033h;

    @SafeParcelable.Constructor
    zzapj(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) int i4) {
        this.f14031f = i2;
        this.f14032g = i3;
        this.f14033h = i4;
    }

    public static zzapj y(VersionInfo versionInfo) {
        return new zzapj(versionInfo.getMajorVersion(), versionInfo.getMinorVersion(), versionInfo.getMicroVersion());
    }

    public final String toString() {
        int i2 = this.f14031f;
        int i3 = this.f14032g;
        int i4 = this.f14033h;
        StringBuilder sb = new StringBuilder(35);
        sb.append(i2);
        sb.append(".");
        sb.append(i3);
        sb.append(".");
        sb.append(i4);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f14031f);
        SafeParcelWriter.l(parcel, 2, this.f14032g);
        SafeParcelWriter.l(parcel, 3, this.f14033h);
        SafeParcelWriter.b(parcel, iA);
    }
}
