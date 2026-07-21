package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class zzv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzv> CREATOR = new zzy();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public String f18240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public String f18241g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    public zzkj f18242h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    public long f18243i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    public boolean f18244j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    public String f18245k;

    @SafeParcelable.Field
    public zzan l;

    @SafeParcelable.Field
    public long m;

    @SafeParcelable.Field
    public zzan n;

    @SafeParcelable.Field
    public long o;

    @SafeParcelable.Field
    public zzan p;

    zzv(zzv zzvVar) {
        Preconditions.k(zzvVar);
        this.f18240f = zzvVar.f18240f;
        this.f18241g = zzvVar.f18241g;
        this.f18242h = zzvVar.f18242h;
        this.f18243i = zzvVar.f18243i;
        this.f18244j = zzvVar.f18244j;
        this.f18245k = zzvVar.f18245k;
        this.l = zzvVar.l;
        this.m = zzvVar.m;
        this.n = zzvVar.n;
        this.o = zzvVar.o;
        this.p = zzvVar.p;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, this.f18240f, false);
        SafeParcelWriter.u(parcel, 3, this.f18241g, false);
        SafeParcelWriter.s(parcel, 4, this.f18242h, i2, false);
        SafeParcelWriter.p(parcel, 5, this.f18243i);
        SafeParcelWriter.c(parcel, 6, this.f18244j);
        SafeParcelWriter.u(parcel, 7, this.f18245k, false);
        SafeParcelWriter.s(parcel, 8, this.l, i2, false);
        SafeParcelWriter.p(parcel, 9, this.m);
        SafeParcelWriter.s(parcel, 10, this.n, i2, false);
        SafeParcelWriter.p(parcel, 11, this.o);
        SafeParcelWriter.s(parcel, 12, this.p, i2, false);
        SafeParcelWriter.b(parcel, iA);
    }

    @SafeParcelable.Constructor
    zzv(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) zzkj zzkjVar, @SafeParcelable.Param(id = 5) long j2, @SafeParcelable.Param(id = 6) boolean z, @SafeParcelable.Param(id = 7) String str3, @SafeParcelable.Param(id = 8) zzan zzanVar, @SafeParcelable.Param(id = 9) long j3, @SafeParcelable.Param(id = 10) zzan zzanVar2, @SafeParcelable.Param(id = 11) long j4, @SafeParcelable.Param(id = 12) zzan zzanVar3) {
        this.f18240f = str;
        this.f18241g = str2;
        this.f18242h = zzkjVar;
        this.f18243i = j2;
        this.f18244j = z;
        this.f18245k = str3;
        this.l = zzanVar;
        this.m = j3;
        this.n = zzanVar2;
        this.o = j4;
        this.p = zzanVar3;
    }
}
