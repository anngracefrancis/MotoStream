package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
public final class zzarg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzarg> CREATOR = new zzarh();

    @SafeParcelable.Field
    private final String A;

    @SafeParcelable.Field
    private final List<String> B;

    @SafeParcelable.Field
    private final String C;

    @SafeParcelable.Field
    private final zzady D;

    @SafeParcelable.Field
    private final List<String> E;

    @SafeParcelable.Field
    private final long F;

    @SafeParcelable.Field
    private final String G;

    @SafeParcelable.Field
    private final float H;

    @SafeParcelable.Field
    private final int I;

    @SafeParcelable.Field
    private final int J;

    @SafeParcelable.Field
    private final boolean K;

    @SafeParcelable.Field
    private final boolean L;

    @SafeParcelable.Field
    private final String M;

    @SafeParcelable.Field
    private final boolean N;

    @SafeParcelable.Field
    private final String O;

    @SafeParcelable.Field
    private final boolean P;

    @SafeParcelable.Field
    private final int Q;

    @SafeParcelable.Field
    private final Bundle R;

    @SafeParcelable.Field
    private final String S;

    @SafeParcelable.Field
    private final zzaax T;

    @SafeParcelable.Field
    private final boolean U;

    @SafeParcelable.Field
    private final Bundle V;

    @SafeParcelable.Field
    private final String W;

    @SafeParcelable.Field
    private final String X;

    @SafeParcelable.Field
    private final String Y;

    @SafeParcelable.Field
    private final boolean Z;

    @SafeParcelable.Field
    private final List<Integer> a0;

    @SafeParcelable.Field
    private final String b0;

    @SafeParcelable.Field
    private final List<String> c0;

    @SafeParcelable.Field
    private final int d0;

    @SafeParcelable.Field
    private final boolean e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f14087f;

    @SafeParcelable.Field
    private final boolean f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final Bundle f14088g;

    @SafeParcelable.Field
    private final boolean g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final zzxz f14089h;

    @SafeParcelable.Field
    private final ArrayList<String> h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final zzyd f14090i;

    @SafeParcelable.Field
    private final String i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f14091j;

    @SafeParcelable.Field
    private final zzaiy j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private final ApplicationInfo f14092k;

    @SafeParcelable.Field
    private final String k0;

    @SafeParcelable.Field
    private final PackageInfo l;

    @SafeParcelable.Field
    private final Bundle l0;

    @SafeParcelable.Field
    private final String m;

    @SafeParcelable.Field
    private final String n;

    @SafeParcelable.Field
    private final String o;

    @SafeParcelable.Field
    private final zzbai p;

    @SafeParcelable.Field
    private final Bundle q;

    @SafeParcelable.Field
    private final int r;

    @SafeParcelable.Field
    private final List<String> s;

    @SafeParcelable.Field
    private final Bundle t;

    @SafeParcelable.Field
    private final boolean u;

    @SafeParcelable.Field
    private final int v;

    @SafeParcelable.Field
    private final int w;

    @SafeParcelable.Field
    private final float x;

    @SafeParcelable.Field
    private final String y;

    @SafeParcelable.Field
    private final long z;

    @SafeParcelable.Constructor
    zzarg(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) Bundle bundle, @SafeParcelable.Param(id = 3) zzxz zzxzVar, @SafeParcelable.Param(id = 4) zzyd zzydVar, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) ApplicationInfo applicationInfo, @SafeParcelable.Param(id = 7) PackageInfo packageInfo, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) String str3, @SafeParcelable.Param(id = 10) String str4, @SafeParcelable.Param(id = 11) zzbai zzbaiVar, @SafeParcelable.Param(id = 12) Bundle bundle2, @SafeParcelable.Param(id = 13) int i3, @SafeParcelable.Param(id = 14) List<String> list, @SafeParcelable.Param(id = 15) Bundle bundle3, @SafeParcelable.Param(id = 16) boolean z, @SafeParcelable.Param(id = 18) int i4, @SafeParcelable.Param(id = 19) int i5, @SafeParcelable.Param(id = 20) float f2, @SafeParcelable.Param(id = 21) String str5, @SafeParcelable.Param(id = 25) long j2, @SafeParcelable.Param(id = 26) String str6, @SafeParcelable.Param(id = 27) List<String> list2, @SafeParcelable.Param(id = 28) String str7, @SafeParcelable.Param(id = 29) zzady zzadyVar, @SafeParcelable.Param(id = 30) List<String> list3, @SafeParcelable.Param(id = 31) long j3, @SafeParcelable.Param(id = 33) String str8, @SafeParcelable.Param(id = 34) float f3, @SafeParcelable.Param(id = 40) boolean z2, @SafeParcelable.Param(id = 35) int i6, @SafeParcelable.Param(id = 36) int i7, @SafeParcelable.Param(id = 37) boolean z3, @SafeParcelable.Param(id = 38) boolean z4, @SafeParcelable.Param(id = 39) String str9, @SafeParcelable.Param(id = 41) String str10, @SafeParcelable.Param(id = 42) boolean z5, @SafeParcelable.Param(id = 43) int i8, @SafeParcelable.Param(id = 44) Bundle bundle4, @SafeParcelable.Param(id = 45) String str11, @SafeParcelable.Param(id = 46) zzaax zzaaxVar, @SafeParcelable.Param(id = 47) boolean z6, @SafeParcelable.Param(id = 48) Bundle bundle5, @SafeParcelable.Param(id = 49) String str12, @SafeParcelable.Param(id = 50) String str13, @SafeParcelable.Param(id = 51) String str14, @SafeParcelable.Param(id = 52) boolean z7, @SafeParcelable.Param(id = 53) List<Integer> list4, @SafeParcelable.Param(id = 54) String str15, @SafeParcelable.Param(id = 55) List<String> list5, @SafeParcelable.Param(id = 56) int i9, @SafeParcelable.Param(id = 57) boolean z8, @SafeParcelable.Param(id = 58) boolean z9, @SafeParcelable.Param(id = 59) boolean z10, @SafeParcelable.Param(id = 60) ArrayList<String> arrayList, @SafeParcelable.Param(id = 61) String str16, @SafeParcelable.Param(id = 63) zzaiy zzaiyVar, @SafeParcelable.Param(id = 64) String str17, @SafeParcelable.Param(id = 65) Bundle bundle6) {
        this.f14087f = i2;
        this.f14088g = bundle;
        this.f14089h = zzxzVar;
        this.f14090i = zzydVar;
        this.f14091j = str;
        this.f14092k = applicationInfo;
        this.l = packageInfo;
        this.m = str2;
        this.n = str3;
        this.o = str4;
        this.p = zzbaiVar;
        this.q = bundle2;
        this.r = i3;
        this.s = list;
        this.E = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.t = bundle3;
        this.u = z;
        this.v = i4;
        this.w = i5;
        this.x = f2;
        this.y = str5;
        this.z = j2;
        this.A = str6;
        this.B = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.C = str7;
        this.D = zzadyVar;
        this.F = j3;
        this.G = str8;
        this.H = f3;
        this.N = z2;
        this.I = i6;
        this.J = i7;
        this.K = z3;
        this.L = z4;
        this.M = str9;
        this.O = str10;
        this.P = z5;
        this.Q = i8;
        this.R = bundle4;
        this.S = str11;
        this.T = zzaaxVar;
        this.U = z6;
        this.V = bundle5;
        this.W = str12;
        this.X = str13;
        this.Y = str14;
        this.Z = z7;
        this.a0 = list4;
        this.b0 = str15;
        this.c0 = list5;
        this.d0 = i9;
        this.e0 = z8;
        this.f0 = z9;
        this.g0 = z10;
        this.h0 = arrayList;
        this.i0 = str16;
        this.j0 = zzaiyVar;
        this.k0 = str17;
        this.l0 = bundle6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f14087f);
        SafeParcelWriter.e(parcel, 2, this.f14088g, false);
        SafeParcelWriter.s(parcel, 3, this.f14089h, i2, false);
        SafeParcelWriter.s(parcel, 4, this.f14090i, i2, false);
        SafeParcelWriter.u(parcel, 5, this.f14091j, false);
        SafeParcelWriter.s(parcel, 6, this.f14092k, i2, false);
        SafeParcelWriter.s(parcel, 7, this.l, i2, false);
        SafeParcelWriter.u(parcel, 8, this.m, false);
        SafeParcelWriter.u(parcel, 9, this.n, false);
        SafeParcelWriter.u(parcel, 10, this.o, false);
        SafeParcelWriter.s(parcel, 11, this.p, i2, false);
        SafeParcelWriter.e(parcel, 12, this.q, false);
        SafeParcelWriter.l(parcel, 13, this.r);
        SafeParcelWriter.w(parcel, 14, this.s, false);
        SafeParcelWriter.e(parcel, 15, this.t, false);
        SafeParcelWriter.c(parcel, 16, this.u);
        SafeParcelWriter.l(parcel, 18, this.v);
        SafeParcelWriter.l(parcel, 19, this.w);
        SafeParcelWriter.i(parcel, 20, this.x);
        SafeParcelWriter.u(parcel, 21, this.y, false);
        SafeParcelWriter.p(parcel, 25, this.z);
        SafeParcelWriter.u(parcel, 26, this.A, false);
        SafeParcelWriter.w(parcel, 27, this.B, false);
        SafeParcelWriter.u(parcel, 28, this.C, false);
        SafeParcelWriter.s(parcel, 29, this.D, i2, false);
        SafeParcelWriter.w(parcel, 30, this.E, false);
        SafeParcelWriter.p(parcel, 31, this.F);
        SafeParcelWriter.u(parcel, 33, this.G, false);
        SafeParcelWriter.i(parcel, 34, this.H);
        SafeParcelWriter.l(parcel, 35, this.I);
        SafeParcelWriter.l(parcel, 36, this.J);
        SafeParcelWriter.c(parcel, 37, this.K);
        SafeParcelWriter.c(parcel, 38, this.L);
        SafeParcelWriter.u(parcel, 39, this.M, false);
        SafeParcelWriter.c(parcel, 40, this.N);
        SafeParcelWriter.u(parcel, 41, this.O, false);
        SafeParcelWriter.c(parcel, 42, this.P);
        SafeParcelWriter.l(parcel, 43, this.Q);
        SafeParcelWriter.e(parcel, 44, this.R, false);
        SafeParcelWriter.u(parcel, 45, this.S, false);
        SafeParcelWriter.s(parcel, 46, this.T, i2, false);
        SafeParcelWriter.c(parcel, 47, this.U);
        SafeParcelWriter.e(parcel, 48, this.V, false);
        SafeParcelWriter.u(parcel, 49, this.W, false);
        SafeParcelWriter.u(parcel, 50, this.X, false);
        SafeParcelWriter.u(parcel, 51, this.Y, false);
        SafeParcelWriter.c(parcel, 52, this.Z);
        SafeParcelWriter.n(parcel, 53, this.a0, false);
        SafeParcelWriter.u(parcel, 54, this.b0, false);
        SafeParcelWriter.w(parcel, 55, this.c0, false);
        SafeParcelWriter.l(parcel, 56, this.d0);
        SafeParcelWriter.c(parcel, 57, this.e0);
        SafeParcelWriter.c(parcel, 58, this.f0);
        SafeParcelWriter.c(parcel, 59, this.g0);
        SafeParcelWriter.w(parcel, 60, this.h0, false);
        SafeParcelWriter.u(parcel, 61, this.i0, false);
        SafeParcelWriter.s(parcel, 63, this.j0, i2, false);
        SafeParcelWriter.u(parcel, 64, this.k0, false);
        SafeParcelWriter.e(parcel, 65, this.l0, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
