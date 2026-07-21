package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
public final class zzady extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzady> CREATOR = new zzadz();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f13845f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f13846g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f13847h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f13848i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f13849j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    public final zzacd f13850k;

    @SafeParcelable.Field
    public final boolean l;

    @SafeParcelable.Field
    public final int m;

    public zzady(NativeAdOptions nativeAdOptions) {
        this(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzacd(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zzkr(), 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f13845f);
        SafeParcelWriter.c(parcel, 2, this.f13846g);
        SafeParcelWriter.l(parcel, 3, this.f13847h);
        SafeParcelWriter.c(parcel, 4, this.f13848i);
        SafeParcelWriter.l(parcel, 5, this.f13849j);
        SafeParcelWriter.s(parcel, 6, this.f13850k, i2, false);
        SafeParcelWriter.c(parcel, 7, this.l);
        SafeParcelWriter.l(parcel, 8, this.m);
        SafeParcelWriter.b(parcel, iA);
    }

    @SafeParcelable.Constructor
    public zzady(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) boolean z2, @SafeParcelable.Param(id = 5) int i4, @SafeParcelable.Param(id = 6) zzacd zzacdVar, @SafeParcelable.Param(id = 7) boolean z3, @SafeParcelable.Param(id = 8) int i5) {
        this.f13845f = i2;
        this.f13846g = z;
        this.f13847h = i3;
        this.f13848i = z2;
        this.f13849j = i4;
        this.f13850k = zzacdVar;
        this.l = z3;
        this.m = i5;
    }
}
