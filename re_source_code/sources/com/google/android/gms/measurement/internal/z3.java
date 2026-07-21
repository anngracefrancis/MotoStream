package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class z3 {
    private long A;
    private long B;
    private long C;
    private String D;
    private boolean E;
    private long F;
    private long G;
    private final zzfx a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f18036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f18037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f18038e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f18039f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f18040g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f18041h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f18042i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f18043j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f18044k;
    private String l;
    private long m;
    private long n;
    private boolean o;
    private long p;
    private boolean q;
    private boolean r;
    private String s;
    private Boolean t;
    private long u;
    private List<String> v;
    private String w;
    private long x;
    private long y;
    private long z;

    z3(zzfx zzfxVar, String str) {
        Preconditions.k(zzfxVar);
        Preconditions.g(str);
        this.a = zzfxVar;
        this.f18035b = str;
        zzfxVar.g().d();
    }

    public final String A() {
        this.a.g().d();
        return this.f18037d;
    }

    public final void B(long j2) {
        this.a.g().d();
        this.E |= this.n != j2;
        this.n = j2;
    }

    public final void C(String str) {
        this.a.g().d();
        this.E |= !zzkk.t0(this.f18038e, str);
        this.f18038e = str;
    }

    public final String D() {
        this.a.g().d();
        return this.s;
    }

    public final void E(long j2) {
        this.a.g().d();
        this.E |= this.u != j2;
        this.u = j2;
    }

    public final void F(String str) {
        this.a.g().d();
        this.E |= !zzkk.t0(this.f18039f, str);
        this.f18039f = str;
    }

    public final String G() {
        this.a.g().d();
        return this.w;
    }

    public final void H(long j2) {
        Preconditions.a(j2 >= 0);
        this.a.g().d();
        this.E = (this.f18040g != j2) | this.E;
        this.f18040g = j2;
    }

    public final void I(String str) {
        this.a.g().d();
        this.E |= !zzkk.t0(this.f18043j, str);
        this.f18043j = str;
    }

    public final String J() {
        this.a.g().d();
        return this.f18038e;
    }

    public final void K(long j2) {
        this.a.g().d();
        this.E |= this.F != j2;
        this.F = j2;
    }

    public final void L(String str) {
        this.a.g().d();
        this.E |= !zzkk.t0(this.l, str);
        this.l = str;
    }

    public final String M() {
        this.a.g().d();
        return this.f18039f;
    }

    public final void N(long j2) {
        this.a.g().d();
        this.E |= this.G != j2;
        this.G = j2;
    }

    public final void O(String str) {
        this.a.g().d();
        this.E |= !zzkk.t0(this.D, str);
        this.D = str;
    }

    public final long P() {
        this.a.g().d();
        return this.f18041h;
    }

    public final void Q(long j2) {
        this.a.g().d();
        this.E |= this.x != j2;
        this.x = j2;
    }

    public final long R() {
        this.a.g().d();
        return this.f18042i;
    }

    public final void S(long j2) {
        this.a.g().d();
        this.E |= this.y != j2;
        this.y = j2;
    }

    public final String T() {
        this.a.g().d();
        return this.f18043j;
    }

    public final void U(long j2) {
        this.a.g().d();
        this.E |= this.z != j2;
        this.z = j2;
    }

    public final long V() {
        this.a.g().d();
        return this.f18044k;
    }

    public final void W(long j2) {
        this.a.g().d();
        this.E |= this.A != j2;
        this.A = j2;
    }

    public final String X() {
        this.a.g().d();
        return this.l;
    }

    public final void Y(long j2) {
        this.a.g().d();
        this.E |= this.C != j2;
        this.C = j2;
    }

    public final long Z() {
        this.a.g().d();
        return this.m;
    }

    public final void a(long j2) {
        this.a.g().d();
        this.E |= this.f18041h != j2;
        this.f18041h = j2;
    }

    public final void a0(long j2) {
        this.a.g().d();
        this.E |= this.B != j2;
        this.B = j2;
    }

    public final void b(Boolean bool) {
        this.a.g().d();
        this.E |= !zzkk.X(this.t, bool);
        this.t = bool;
    }

    public final long b0() {
        this.a.g().d();
        return this.n;
    }

    public final void c(String str) {
        this.a.g().d();
        this.E |= !zzkk.t0(this.f18036c, str);
        this.f18036c = str;
    }

    public final void c0(long j2) {
        this.a.g().d();
        this.E |= this.p != j2;
        this.p = j2;
    }

    public final void d(List<String> list) {
        this.a.g().d();
        if (zzkk.f0(this.v, list)) {
            return;
        }
        this.E = true;
        this.v = list != null ? new ArrayList(list) : null;
    }

    public final long d0() {
        this.a.g().d();
        return this.u;
    }

    public final void e(boolean z) {
        this.a.g().d();
        this.E |= this.o != z;
        this.o = z;
    }

    public final boolean e0() {
        this.a.g().d();
        return this.o;
    }

    public final boolean f() {
        this.a.g().d();
        return this.E;
    }

    public final long f0() {
        this.a.g().d();
        return this.f18040g;
    }

    public final long g() {
        this.a.g().d();
        return this.C;
    }

    public final long g0() {
        this.a.g().d();
        return this.F;
    }

    public final long h() {
        this.a.g().d();
        return this.B;
    }

    public final long h0() {
        this.a.g().d();
        return this.G;
    }

    public final String i() {
        this.a.g().d();
        return this.D;
    }

    public final void i0() {
        this.a.g().d();
        long j2 = this.f18040g + 1;
        if (j2 > 2147483647L) {
            this.a.h().K().b("Bundle index overflow. appId", zzet.x(this.f18035b));
            j2 = 0;
        }
        this.E = true;
        this.f18040g = j2;
    }

    public final String j() {
        this.a.g().d();
        String str = this.D;
        O(null);
        return str;
    }

    public final long j0() {
        this.a.g().d();
        return this.x;
    }

    public final long k() {
        this.a.g().d();
        return this.p;
    }

    public final long k0() {
        this.a.g().d();
        return this.y;
    }

    public final boolean l() {
        this.a.g().d();
        return this.q;
    }

    public final long l0() {
        this.a.g().d();
        return this.z;
    }

    public final boolean m() {
        this.a.g().d();
        return this.r;
    }

    public final long m0() {
        this.a.g().d();
        return this.A;
    }

    public final Boolean n() {
        this.a.g().d();
        return this.t;
    }

    public final List<String> o() {
        this.a.g().d();
        return this.v;
    }

    public final void p() {
        this.a.g().d();
        this.E = false;
    }

    public final void q(long j2) {
        this.a.g().d();
        this.E |= this.f18042i != j2;
        this.f18042i = j2;
    }

    public final void r(String str) {
        this.a.g().d();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.E |= !zzkk.t0(this.f18037d, str);
        this.f18037d = str;
    }

    public final void s(boolean z) {
        this.a.g().d();
        this.E |= this.q != z;
        this.q = z;
    }

    public final String t() {
        this.a.g().d();
        return this.f18035b;
    }

    public final void u(long j2) {
        this.a.g().d();
        this.E |= this.f18044k != j2;
        this.f18044k = j2;
    }

    public final void v(String str) {
        this.a.g().d();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.E |= !zzkk.t0(this.s, str);
        this.s = str;
    }

    public final void w(boolean z) {
        this.a.g().d();
        this.E |= this.r != z;
        this.r = z;
    }

    public final String x() {
        this.a.g().d();
        return this.f18036c;
    }

    public final void y(long j2) {
        this.a.g().d();
        this.E |= this.m != j2;
        this.m = j2;
    }

    public final void z(String str) {
        this.a.g().d();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.E |= !zzkk.t0(this.w, str);
        this.w = str;
    }
}
