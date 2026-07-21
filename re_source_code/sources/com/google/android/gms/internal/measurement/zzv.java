package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class zzv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzv> CREATOR = new zzy();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f17565f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f17566g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f17567h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f17568i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f17569j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f17570k;

    @SafeParcelable.Field
    public final Bundle l;

    @SafeParcelable.Constructor
    public zzv(@SafeParcelable.Param(id = 1) long j2, @SafeParcelable.Param(id = 2) long j3, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) String str2, @SafeParcelable.Param(id = 6) String str3, @SafeParcelable.Param(id = 7) Bundle bundle) {
        this.f17565f = j2;
        this.f17566g = j3;
        this.f17567h = z;
        this.f17568i = str;
        this.f17569j = str2;
        this.f17570k = str3;
        this.l = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.p(parcel, 1, this.f17565f);
        SafeParcelWriter.p(parcel, 2, this.f17566g);
        SafeParcelWriter.c(parcel, 3, this.f17567h);
        SafeParcelWriter.u(parcel, 4, this.f17568i, false);
        SafeParcelWriter.u(parcel, 5, this.f17569j, false);
        SafeParcelWriter.u(parcel, 6, this.f17570k, false);
        SafeParcelWriter.e(parcel, 7, this.l, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
