package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
public final class zzari extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzari> CREATOR = new zzarj();

    @SafeParcelable.Field
    private final boolean A;

    @SafeParcelable.Field
    private final boolean B;

    @SafeParcelable.Field
    private zzaru C;

    @SafeParcelable.Field
    private String D;

    @SafeParcelable.Field
    private final String E;

    @SafeParcelable.Field
    private final boolean F;

    @SafeParcelable.Field
    private final boolean G;

    @SafeParcelable.Field
    private final zzato H;

    @SafeParcelable.Field
    private final List<String> I;

    @SafeParcelable.Field
    private final List<String> J;

    @SafeParcelable.Field
    private final boolean K;

    @SafeParcelable.Field
    private final zzark L;

    @SafeParcelable.Field
    private final boolean M;

    @SafeParcelable.Field
    private String N;

    @SafeParcelable.Field
    private final List<String> O;

    @SafeParcelable.Field
    private final boolean P;

    @SafeParcelable.Field
    private final String Q;

    @SafeParcelable.Field
    private final zzauy R;

    @SafeParcelable.Field
    private final String S;

    @SafeParcelable.Field
    private final boolean T;

    @SafeParcelable.Field
    private final boolean U;

    @SafeParcelable.Field
    private Bundle V;

    @SafeParcelable.Field
    private final boolean W;

    @SafeParcelable.Field
    private final int X;

    @SafeParcelable.Field
    private final boolean Y;

    @SafeParcelable.Field
    private final List<String> Z;

    @SafeParcelable.Field
    private final boolean a0;

    @SafeParcelable.Field
    private final String b0;

    @SafeParcelable.Field
    private String c0;

    @SafeParcelable.Field
    private boolean d0;

    @SafeParcelable.Field
    private boolean e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f14093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f14094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private String f14095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final List<String> f14096i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f14097j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private final List<String> f14098k;

    @SafeParcelable.Field
    private final long l;

    @SafeParcelable.Field
    private final boolean m;

    @SafeParcelable.Field
    private final long n;

    @SafeParcelable.Field
    private final List<String> o;

    @SafeParcelable.Field
    private final long p;

    @SafeParcelable.Field
    private final int q;

    @SafeParcelable.Field
    private final String r;

    @SafeParcelable.Field
    private final long s;

    @SafeParcelable.Field
    private final String t;

    @SafeParcelable.Field
    private final boolean u;

    @SafeParcelable.Field
    private final String v;

    @SafeParcelable.Field
    private final String w;

    @SafeParcelable.Field
    private final boolean x;

    @SafeParcelable.Field
    private final boolean y;

    @SafeParcelable.Field
    private final boolean z;

    @SafeParcelable.Constructor
    zzari(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) List<String> list, @SafeParcelable.Param(id = 5) int i3, @SafeParcelable.Param(id = 6) List<String> list2, @SafeParcelable.Param(id = 7) long j2, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) long j3, @SafeParcelable.Param(id = 10) List<String> list3, @SafeParcelable.Param(id = 11) long j4, @SafeParcelable.Param(id = 12) int i4, @SafeParcelable.Param(id = 13) String str3, @SafeParcelable.Param(id = 14) long j5, @SafeParcelable.Param(id = 15) String str4, @SafeParcelable.Param(id = 18) boolean z2, @SafeParcelable.Param(id = 19) String str5, @SafeParcelable.Param(id = 21) String str6, @SafeParcelable.Param(id = 22) boolean z3, @SafeParcelable.Param(id = 23) boolean z4, @SafeParcelable.Param(id = 24) boolean z5, @SafeParcelable.Param(id = 25) boolean z6, @SafeParcelable.Param(id = 26) boolean z7, @SafeParcelable.Param(id = 28) zzaru zzaruVar, @SafeParcelable.Param(id = 29) String str7, @SafeParcelable.Param(id = 30) String str8, @SafeParcelable.Param(id = 31) boolean z8, @SafeParcelable.Param(id = 32) boolean z9, @SafeParcelable.Param(id = 33) zzato zzatoVar, @SafeParcelable.Param(id = 34) List<String> list4, @SafeParcelable.Param(id = 35) List<String> list5, @SafeParcelable.Param(id = 36) boolean z10, @SafeParcelable.Param(id = 37) zzark zzarkVar, @SafeParcelable.Param(id = 38) boolean z11, @SafeParcelable.Param(id = 39) String str9, @SafeParcelable.Param(id = 40) List<String> list6, @SafeParcelable.Param(id = 42) boolean z12, @SafeParcelable.Param(id = 43) String str10, @SafeParcelable.Param(id = 44) zzauy zzauyVar, @SafeParcelable.Param(id = 45) String str11, @SafeParcelable.Param(id = 46) boolean z13, @SafeParcelable.Param(id = 47) boolean z14, @SafeParcelable.Param(id = 48) Bundle bundle, @SafeParcelable.Param(id = 49) boolean z15, @SafeParcelable.Param(id = 50) int i5, @SafeParcelable.Param(id = 51) boolean z16, @SafeParcelable.Param(id = 52) List<String> list7, @SafeParcelable.Param(id = 53) boolean z17, @SafeParcelable.Param(id = 54) String str12, @SafeParcelable.Param(id = 55) String str13, @SafeParcelable.Param(id = 56) boolean z18, @SafeParcelable.Param(id = 57) boolean z19) {
        zzarz zzarzVar;
        this.f14093f = i2;
        this.f14094g = str;
        this.f14095h = str2;
        this.f14096i = list != null ? Collections.unmodifiableList(list) : null;
        this.f14097j = i3;
        this.f14098k = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.l = j2;
        this.m = z;
        this.n = j3;
        this.o = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.p = j4;
        this.q = i4;
        this.r = str3;
        this.s = j5;
        this.t = str4;
        this.u = z2;
        this.v = str5;
        this.w = str6;
        this.x = z3;
        this.y = z4;
        this.z = z5;
        this.A = z6;
        this.T = z13;
        this.B = z7;
        this.C = zzaruVar;
        this.D = str7;
        this.E = str8;
        if (this.f14095h == null && zzaruVar != null && (zzarzVar = (zzarz) zzaruVar.y(zzarz.CREATOR)) != null && !TextUtils.isEmpty(zzarzVar.f14110f)) {
            this.f14095h = zzarzVar.f14110f;
        }
        this.F = z8;
        this.G = z9;
        this.H = zzatoVar;
        this.I = list4;
        this.J = list5;
        this.K = z10;
        this.L = zzarkVar;
        this.M = z11;
        this.N = str9;
        this.O = list6;
        this.P = z12;
        this.Q = str10;
        this.R = zzauyVar;
        this.S = str11;
        this.U = z14;
        this.V = bundle;
        this.W = z15;
        this.X = i5;
        this.Y = z16;
        this.Z = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.a0 = z17;
        this.b0 = str12;
        this.c0 = str13;
        this.d0 = z18;
        this.e0 = z19;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f14093f);
        SafeParcelWriter.u(parcel, 2, this.f14094g, false);
        SafeParcelWriter.u(parcel, 3, this.f14095h, false);
        SafeParcelWriter.w(parcel, 4, this.f14096i, false);
        SafeParcelWriter.l(parcel, 5, this.f14097j);
        SafeParcelWriter.w(parcel, 6, this.f14098k, false);
        SafeParcelWriter.p(parcel, 7, this.l);
        SafeParcelWriter.c(parcel, 8, this.m);
        SafeParcelWriter.p(parcel, 9, this.n);
        SafeParcelWriter.w(parcel, 10, this.o, false);
        SafeParcelWriter.p(parcel, 11, this.p);
        SafeParcelWriter.l(parcel, 12, this.q);
        SafeParcelWriter.u(parcel, 13, this.r, false);
        SafeParcelWriter.p(parcel, 14, this.s);
        SafeParcelWriter.u(parcel, 15, this.t, false);
        SafeParcelWriter.c(parcel, 18, this.u);
        SafeParcelWriter.u(parcel, 19, this.v, false);
        SafeParcelWriter.u(parcel, 21, this.w, false);
        SafeParcelWriter.c(parcel, 22, this.x);
        SafeParcelWriter.c(parcel, 23, this.y);
        SafeParcelWriter.c(parcel, 24, this.z);
        SafeParcelWriter.c(parcel, 25, this.A);
        SafeParcelWriter.c(parcel, 26, this.B);
        SafeParcelWriter.s(parcel, 28, this.C, i2, false);
        SafeParcelWriter.u(parcel, 29, this.D, false);
        SafeParcelWriter.u(parcel, 30, this.E, false);
        SafeParcelWriter.c(parcel, 31, this.F);
        SafeParcelWriter.c(parcel, 32, this.G);
        SafeParcelWriter.s(parcel, 33, this.H, i2, false);
        SafeParcelWriter.w(parcel, 34, this.I, false);
        SafeParcelWriter.w(parcel, 35, this.J, false);
        SafeParcelWriter.c(parcel, 36, this.K);
        SafeParcelWriter.s(parcel, 37, this.L, i2, false);
        SafeParcelWriter.c(parcel, 38, this.M);
        SafeParcelWriter.u(parcel, 39, this.N, false);
        SafeParcelWriter.w(parcel, 40, this.O, false);
        SafeParcelWriter.c(parcel, 42, this.P);
        SafeParcelWriter.u(parcel, 43, this.Q, false);
        SafeParcelWriter.s(parcel, 44, this.R, i2, false);
        SafeParcelWriter.u(parcel, 45, this.S, false);
        SafeParcelWriter.c(parcel, 46, this.T);
        SafeParcelWriter.c(parcel, 47, this.U);
        SafeParcelWriter.e(parcel, 48, this.V, false);
        SafeParcelWriter.c(parcel, 49, this.W);
        SafeParcelWriter.l(parcel, 50, this.X);
        SafeParcelWriter.c(parcel, 51, this.Y);
        SafeParcelWriter.w(parcel, 52, this.Z, false);
        SafeParcelWriter.c(parcel, 53, this.a0);
        SafeParcelWriter.u(parcel, 54, this.b0, false);
        SafeParcelWriter.u(parcel, 55, this.c0, false);
        SafeParcelWriter.c(parcel, 56, this.d0);
        SafeParcelWriter.c(parcel, 57, this.e0);
        SafeParcelWriter.b(parcel, iA);
    }
}
