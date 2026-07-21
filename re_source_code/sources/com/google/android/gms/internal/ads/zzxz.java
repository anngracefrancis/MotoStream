package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
public final class zzxz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxz> CREATOR = new zzyb();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f16968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    @Deprecated
    public final long f16969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    public final Bundle f16970h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    @Deprecated
    public final int f16971i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    public final List<String> f16972j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f16973k;

    @SafeParcelable.Field
    public final int l;

    @SafeParcelable.Field
    public final boolean m;

    @SafeParcelable.Field
    public final String n;

    @SafeParcelable.Field
    public final zzaca o;

    @SafeParcelable.Field
    public final Location p;

    @SafeParcelable.Field
    public final String q;

    @SafeParcelable.Field
    public final Bundle r;

    @SafeParcelable.Field
    public final Bundle s;

    @SafeParcelable.Field
    public final List<String> t;

    @SafeParcelable.Field
    public final String u;

    @SafeParcelable.Field
    public final String v;

    @SafeParcelable.Field
    @Deprecated
    public final boolean w;

    @SafeParcelable.Field
    public final zzxt x;

    @SafeParcelable.Field
    public final int y;

    @SafeParcelable.Field
    public final String z;

    @SafeParcelable.Constructor
    public zzxz(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) long j2, @SafeParcelable.Param(id = 3) Bundle bundle, @SafeParcelable.Param(id = 4) int i3, @SafeParcelable.Param(id = 5) List<String> list, @SafeParcelable.Param(id = 6) boolean z, @SafeParcelable.Param(id = 7) int i4, @SafeParcelable.Param(id = 8) boolean z2, @SafeParcelable.Param(id = 9) String str, @SafeParcelable.Param(id = 10) zzaca zzacaVar, @SafeParcelable.Param(id = 11) Location location, @SafeParcelable.Param(id = 12) String str2, @SafeParcelable.Param(id = 13) Bundle bundle2, @SafeParcelable.Param(id = 14) Bundle bundle3, @SafeParcelable.Param(id = 15) List<String> list2, @SafeParcelable.Param(id = 16) String str3, @SafeParcelable.Param(id = 17) String str4, @SafeParcelable.Param(id = 18) boolean z3, @SafeParcelable.Param(id = 19) zzxt zzxtVar, @SafeParcelable.Param(id = 20) int i5, @SafeParcelable.Param(id = 21) String str5) {
        this.f16968f = i2;
        this.f16969g = j2;
        this.f16970h = bundle == null ? new Bundle() : bundle;
        this.f16971i = i3;
        this.f16972j = list;
        this.f16973k = z;
        this.l = i4;
        this.m = z2;
        this.n = str;
        this.o = zzacaVar;
        this.p = location;
        this.q = str2;
        this.r = bundle2 == null ? new Bundle() : bundle2;
        this.s = bundle3;
        this.t = list2;
        this.u = str3;
        this.v = str4;
        this.w = z3;
        this.x = zzxtVar;
        this.y = i5;
        this.z = str5;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzxz)) {
            return false;
        }
        zzxz zzxzVar = (zzxz) obj;
        return this.f16968f == zzxzVar.f16968f && this.f16969g == zzxzVar.f16969g && Objects.a(this.f16970h, zzxzVar.f16970h) && this.f16971i == zzxzVar.f16971i && Objects.a(this.f16972j, zzxzVar.f16972j) && this.f16973k == zzxzVar.f16973k && this.l == zzxzVar.l && this.m == zzxzVar.m && Objects.a(this.n, zzxzVar.n) && Objects.a(this.o, zzxzVar.o) && Objects.a(this.p, zzxzVar.p) && Objects.a(this.q, zzxzVar.q) && Objects.a(this.r, zzxzVar.r) && Objects.a(this.s, zzxzVar.s) && Objects.a(this.t, zzxzVar.t) && Objects.a(this.u, zzxzVar.u) && Objects.a(this.v, zzxzVar.v) && this.w == zzxzVar.w && this.y == zzxzVar.y && Objects.a(this.z, zzxzVar.z);
    }

    public final int hashCode() {
        return Objects.b(Integer.valueOf(this.f16968f), Long.valueOf(this.f16969g), this.f16970h, Integer.valueOf(this.f16971i), this.f16972j, Boolean.valueOf(this.f16973k), Integer.valueOf(this.l), Boolean.valueOf(this.m), this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, Boolean.valueOf(this.w), Integer.valueOf(this.y), this.z);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f16968f);
        SafeParcelWriter.p(parcel, 2, this.f16969g);
        SafeParcelWriter.e(parcel, 3, this.f16970h, false);
        SafeParcelWriter.l(parcel, 4, this.f16971i);
        SafeParcelWriter.w(parcel, 5, this.f16972j, false);
        SafeParcelWriter.c(parcel, 6, this.f16973k);
        SafeParcelWriter.l(parcel, 7, this.l);
        SafeParcelWriter.c(parcel, 8, this.m);
        SafeParcelWriter.u(parcel, 9, this.n, false);
        SafeParcelWriter.s(parcel, 10, this.o, i2, false);
        SafeParcelWriter.s(parcel, 11, this.p, i2, false);
        SafeParcelWriter.u(parcel, 12, this.q, false);
        SafeParcelWriter.e(parcel, 13, this.r, false);
        SafeParcelWriter.e(parcel, 14, this.s, false);
        SafeParcelWriter.w(parcel, 15, this.t, false);
        SafeParcelWriter.u(parcel, 16, this.u, false);
        SafeParcelWriter.u(parcel, 17, this.v, false);
        SafeParcelWriter.c(parcel, 18, this.w);
        SafeParcelWriter.s(parcel, 19, this.x, i2, false);
        SafeParcelWriter.l(parcel, 20, this.y);
        SafeParcelWriter.u(parcel, 21, this.z, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
