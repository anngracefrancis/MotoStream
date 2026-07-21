package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
public final class zzarx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzarx> CREATOR = new zzary();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public final Bundle f14104f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public final zzbai f14105g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    public final ApplicationInfo f14106h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f14107i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    public final List<String> f14108j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    public final PackageInfo f14109k;

    @SafeParcelable.Field
    public final String l;

    @SafeParcelable.Field
    public final boolean m;

    @SafeParcelable.Field
    public final String n;

    @SafeParcelable.Constructor
    public zzarx(@SafeParcelable.Param(id = 1) Bundle bundle, @SafeParcelable.Param(id = 2) zzbai zzbaiVar, @SafeParcelable.Param(id = 3) ApplicationInfo applicationInfo, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) List<String> list, @SafeParcelable.Param(id = 6) PackageInfo packageInfo, @SafeParcelable.Param(id = 7) String str2, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) String str3) {
        this.f14104f = bundle;
        this.f14105g = zzbaiVar;
        this.f14107i = str;
        this.f14106h = applicationInfo;
        this.f14108j = list;
        this.f14109k = packageInfo;
        this.l = str2;
        this.m = z;
        this.n = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.e(parcel, 1, this.f14104f, false);
        SafeParcelWriter.s(parcel, 2, this.f14105g, i2, false);
        SafeParcelWriter.s(parcel, 3, this.f14106h, i2, false);
        SafeParcelWriter.u(parcel, 4, this.f14107i, false);
        SafeParcelWriter.w(parcel, 5, this.f14108j, false);
        SafeParcelWriter.s(parcel, 6, this.f14109k, i2, false);
        SafeParcelWriter.u(parcel, 7, this.l, false);
        SafeParcelWriter.c(parcel, 8, this.m);
        SafeParcelWriter.u(parcel, 9, this.n, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
