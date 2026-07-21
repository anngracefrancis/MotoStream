package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new zzo();

    @SafeParcelable.Field
    public final String A;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f18234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f18235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f18236h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f18237i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f18238j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f18239k;

    @SafeParcelable.Field
    public final String l;

    @SafeParcelable.Field
    public final boolean m;

    @SafeParcelable.Field
    public final boolean n;

    @SafeParcelable.Field
    public final long o;

    @SafeParcelable.Field
    public final String p;

    @SafeParcelable.Field
    public final long q;

    @SafeParcelable.Field
    public final long r;

    @SafeParcelable.Field
    public final int s;

    @SafeParcelable.Field
    public final boolean t;

    @SafeParcelable.Field
    public final boolean u;

    @SafeParcelable.Field
    public final boolean v;

    @SafeParcelable.Field
    public final String w;

    @SafeParcelable.Field
    public final Boolean x;

    @SafeParcelable.Field
    public final long y;

    @SafeParcelable.Field
    public final List<String> z;

    zzm(String str, String str2, String str3, long j2, String str4, long j3, long j4, String str5, boolean z, boolean z2, String str6, long j5, long j6, int i2, boolean z3, boolean z4, boolean z5, String str7, Boolean bool, long j7, List<String> list, String str8) {
        Preconditions.g(str);
        this.f18234f = str;
        this.f18235g = TextUtils.isEmpty(str2) ? null : str2;
        this.f18236h = str3;
        this.o = j2;
        this.f18237i = str4;
        this.f18238j = j3;
        this.f18239k = j4;
        this.l = str5;
        this.m = z;
        this.n = z2;
        this.p = str6;
        this.q = j5;
        this.r = j6;
        this.s = i2;
        this.t = z3;
        this.u = z4;
        this.v = z5;
        this.w = str7;
        this.x = bool;
        this.y = j7;
        this.z = list;
        this.A = str8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, this.f18234f, false);
        SafeParcelWriter.u(parcel, 3, this.f18235g, false);
        SafeParcelWriter.u(parcel, 4, this.f18236h, false);
        SafeParcelWriter.u(parcel, 5, this.f18237i, false);
        SafeParcelWriter.p(parcel, 6, this.f18238j);
        SafeParcelWriter.p(parcel, 7, this.f18239k);
        SafeParcelWriter.u(parcel, 8, this.l, false);
        SafeParcelWriter.c(parcel, 9, this.m);
        SafeParcelWriter.c(parcel, 10, this.n);
        SafeParcelWriter.p(parcel, 11, this.o);
        SafeParcelWriter.u(parcel, 12, this.p, false);
        SafeParcelWriter.p(parcel, 13, this.q);
        SafeParcelWriter.p(parcel, 14, this.r);
        SafeParcelWriter.l(parcel, 15, this.s);
        SafeParcelWriter.c(parcel, 16, this.t);
        SafeParcelWriter.c(parcel, 17, this.u);
        SafeParcelWriter.c(parcel, 18, this.v);
        SafeParcelWriter.u(parcel, 19, this.w, false);
        SafeParcelWriter.d(parcel, 21, this.x, false);
        SafeParcelWriter.p(parcel, 22, this.y);
        SafeParcelWriter.w(parcel, 23, this.z, false);
        SafeParcelWriter.u(parcel, 24, this.A, false);
        SafeParcelWriter.b(parcel, iA);
    }

    @SafeParcelable.Constructor
    zzm(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) long j2, @SafeParcelable.Param(id = 7) long j3, @SafeParcelable.Param(id = 8) String str5, @SafeParcelable.Param(id = 9) boolean z, @SafeParcelable.Param(id = 10) boolean z2, @SafeParcelable.Param(id = 11) long j4, @SafeParcelable.Param(id = 12) String str6, @SafeParcelable.Param(id = 13) long j5, @SafeParcelable.Param(id = 14) long j6, @SafeParcelable.Param(id = 15) int i2, @SafeParcelable.Param(id = 16) boolean z3, @SafeParcelable.Param(id = 17) boolean z4, @SafeParcelable.Param(id = 18) boolean z5, @SafeParcelable.Param(id = 19) String str7, @SafeParcelable.Param(id = 21) Boolean bool, @SafeParcelable.Param(id = 22) long j7, @SafeParcelable.Param(id = 23) List<String> list, @SafeParcelable.Param(id = 24) String str8) {
        this.f18234f = str;
        this.f18235g = str2;
        this.f18236h = str3;
        this.o = j4;
        this.f18237i = str4;
        this.f18238j = j2;
        this.f18239k = j3;
        this.l = str5;
        this.m = z;
        this.n = z2;
        this.p = str6;
        this.q = j5;
        this.r = j6;
        this.s = i2;
        this.t = z3;
        this.u = z4;
        this.v = z5;
        this.w = str7;
        this.x = bool;
        this.y = j7;
        this.z = list;
        this.A = str8;
    }
}
