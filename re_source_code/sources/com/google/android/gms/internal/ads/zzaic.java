package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
public final class zzaic extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaic> CREATOR = new zzaid();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f13908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f13909g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f13910h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    public final byte[] f13911i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    public final String[] f13912j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    public final String[] f13913k;

    @SafeParcelable.Field
    public final boolean l;

    @SafeParcelable.Field
    public final long m;

    @SafeParcelable.Constructor
    zzaic(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) String[] strArr, @SafeParcelable.Param(id = 6) String[] strArr2, @SafeParcelable.Param(id = 7) boolean z2, @SafeParcelable.Param(id = 8) long j2) {
        this.f13908f = z;
        this.f13909g = str;
        this.f13910h = i2;
        this.f13911i = bArr;
        this.f13912j = strArr;
        this.f13913k = strArr2;
        this.l = z2;
        this.m = j2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.c(parcel, 1, this.f13908f);
        SafeParcelWriter.u(parcel, 2, this.f13909g, false);
        SafeParcelWriter.l(parcel, 3, this.f13910h);
        SafeParcelWriter.f(parcel, 4, this.f13911i, false);
        SafeParcelWriter.v(parcel, 5, this.f13912j, false);
        SafeParcelWriter.v(parcel, 6, this.f13913k, false);
        SafeParcelWriter.c(parcel, 7, this.l);
        SafeParcelWriter.p(parcel, 8, this.m);
        SafeParcelWriter.b(parcel, iA);
    }
}
