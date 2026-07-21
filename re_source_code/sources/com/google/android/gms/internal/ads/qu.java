package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class qu implements kw {
    private final zzdnd a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13241d = 0;

    private qu(zzdnd zzdndVar) {
        zzdnd zzdndVar2 = (zzdnd) zzdod.d(zzdndVar, "input");
        this.a = zzdndVar2;
        zzdndVar2.f15988d = this;
    }

    public static qu c(zzdnd zzdndVar) {
        qu quVar = zzdndVar.f15988d;
        return quVar != null ? quVar : new qu(zzdndVar);
    }

    private final void d(List<String> list, boolean z) throws IOException {
        int iD;
        int iD2;
        if ((this.f13239b & 7) != 2) {
            throw zzdok.f();
        }
        if (!(list instanceof zzdot) || z) {
            do {
                list.add(z ? M() : a());
                if (this.a.t()) {
                    return;
                } else {
                    iD = this.a.d();
                }
            } while (iD == this.f13239b);
            this.f13241d = iD;
            return;
        }
        zzdot zzdotVar = (zzdot) list;
        do {
            zzdotVar.q0(T());
            if (this.a.t()) {
                return;
            } else {
                iD2 = this.a.d();
            }
        } while (iD2 == this.f13239b);
        this.f13241d = iD2;
    }

    private final <T> T e(lw<T> lwVar, zzdno zzdnoVar) throws IOException {
        int iM = this.a.m();
        zzdnd zzdndVar = this.a;
        if (zzdndVar.a >= zzdndVar.f15986b) {
            throw new zzdok("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iZ = zzdndVar.z(iM);
        T tC = lwVar.c();
        this.a.a++;
        lwVar.h(tC, this, zzdnoVar);
        lwVar.f(tC);
        this.a.x(0);
        zzdnd zzdndVar2 = this.a;
        zzdndVar2.a--;
        zzdndVar2.A(iZ);
        return tC;
    }

    private final <T> T f(lw<T> lwVar, zzdno zzdnoVar) throws IOException {
        int i2 = this.f13240c;
        this.f13240c = ((this.f13239b >>> 3) << 3) | 4;
        try {
            T tC = lwVar.c();
            lwVar.h(tC, this, zzdnoVar);
            lwVar.f(tC);
            if (this.f13239b != this.f13240c) {
                throw zzdok.g();
            }
            this.f13240c = i2;
            return tC;
        } catch (Throwable th) {
            this.f13240c = i2;
            throw th;
        }
    }

    private final void g(int i2) throws IOException {
        if ((this.f13239b & 7) != i2) {
            throw zzdok.f();
        }
    }

    private static void h(int i2) throws IOException {
        if ((i2 & 7) != 0) {
            throw zzdok.g();
        }
    }

    private static void j(int i2) throws IOException {
        if ((i2 & 3) != 0) {
            throw zzdok.g();
        }
    }

    private final void k(int i2) throws IOException {
        if (this.a.u() != i2) {
            throw zzdok.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void B(List<Long> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof ov)) {
            int i2 = this.f13239b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.a.h()));
                    if (this.a.t()) {
                        return;
                    } else {
                        iD = this.a.d();
                    }
                } while (iD == this.f13239b);
                this.f13241d = iD;
                return;
            }
            if (i2 != 2) {
                throw zzdok.f();
            }
            int iM = this.a.m();
            h(iM);
            int iU = this.a.u() + iM;
            do {
                list.add(Long.valueOf(this.a.h()));
            } while (this.a.u() < iU);
            return;
        }
        ov ovVar = (ov) list;
        int i3 = this.f13239b & 7;
        if (i3 == 1) {
            do {
                ovVar.i(this.a.h());
                if (this.a.t()) {
                    return;
                } else {
                    iD2 = this.a.d();
                }
            } while (iD2 == this.f13239b);
            this.f13241d = iD2;
            return;
        }
        if (i3 != 2) {
            throw zzdok.f();
        }
        int iM2 = this.a.m();
        h(iM2);
        int iU2 = this.a.u() + iM2;
        do {
            ovVar.i(this.a.h());
        } while (this.a.u() < iU2);
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void C(List<Integer> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof gv)) {
            int i2 = this.f13239b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.a.g()));
                    if (this.a.t()) {
                        return;
                    } else {
                        iD = this.a.d();
                    }
                } while (iD == this.f13239b);
                this.f13241d = iD;
                return;
            }
            if (i2 != 2) {
                throw zzdok.f();
            }
            int iU = this.a.u() + this.a.m();
            do {
                list.add(Integer.valueOf(this.a.g()));
            } while (this.a.u() < iU);
            k(iU);
            return;
        }
        gv gvVar = (gv) list;
        int i3 = this.f13239b & 7;
        if (i3 == 0) {
            do {
                gvVar.Z0(this.a.g());
                if (this.a.t()) {
                    return;
                } else {
                    iD2 = this.a.d();
                }
            } while (iD2 == this.f13239b);
            this.f13241d = iD2;
            return;
        }
        if (i3 != 2) {
            throw zzdok.f();
        }
        int iU2 = this.a.u() + this.a.m();
        do {
            gvVar.Z0(this.a.g());
        } while (this.a.u() < iU2);
        k(iU2);
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final int D() throws IOException {
        g(0);
        return this.a.q();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final long E() throws IOException {
        g(0);
        return this.a.e();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final <K, V> void F(Map<K, V> map, tv<K, V> tvVar, zzdno zzdnoVar) throws IOException {
        g(2);
        this.a.z(this.a.m());
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final boolean G() throws IOException {
        g(0);
        return this.a.j();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void H(List<Long> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof ov)) {
            int i2 = this.f13239b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.a.r()));
                    if (this.a.t()) {
                        return;
                    } else {
                        iD = this.a.d();
                    }
                } while (iD == this.f13239b);
                this.f13241d = iD;
                return;
            }
            if (i2 != 2) {
                throw zzdok.f();
            }
            int iU = this.a.u() + this.a.m();
            do {
                list.add(Long.valueOf(this.a.r()));
            } while (this.a.u() < iU);
            k(iU);
            return;
        }
        ov ovVar = (ov) list;
        int i3 = this.f13239b & 7;
        if (i3 == 0) {
            do {
                ovVar.i(this.a.r());
                if (this.a.t()) {
                    return;
                } else {
                    iD2 = this.a.d();
                }
            } while (iD2 == this.f13239b);
            this.f13241d = iD2;
            return;
        }
        if (i3 != 2) {
            throw zzdok.f();
        }
        int iU2 = this.a.u() + this.a.m();
        do {
            ovVar.i(this.a.r());
        } while (this.a.u() < iU2);
        k(iU2);
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void I(List<Integer> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof gv)) {
            int i2 = this.f13239b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.a.q()));
                    if (this.a.t()) {
                        return;
                    } else {
                        iD = this.a.d();
                    }
                } while (iD == this.f13239b);
                this.f13241d = iD;
                return;
            }
            if (i2 != 2) {
                throw zzdok.f();
            }
            int iU = this.a.u() + this.a.m();
            do {
                list.add(Integer.valueOf(this.a.q()));
            } while (this.a.u() < iU);
            k(iU);
            return;
        }
        gv gvVar = (gv) list;
        int i3 = this.f13239b & 7;
        if (i3 == 0) {
            do {
                gvVar.Z0(this.a.q());
                if (this.a.t()) {
                    return;
                } else {
                    iD2 = this.a.d();
                }
            } while (iD2 == this.f13239b);
            this.f13241d = iD2;
            return;
        }
        if (i3 != 2) {
            throw zzdok.f();
        }
        int iU2 = this.a.u() + this.a.m();
        do {
            gvVar.Z0(this.a.q());
        } while (this.a.u() < iU2);
        k(iU2);
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final long J() throws IOException {
        g(0);
        return this.a.r();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final long K() throws IOException {
        g(0);
        return this.a.f();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final long L() throws IOException {
        g(1);
        return this.a.h();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final String M() throws IOException {
        g(2);
        return this.a.k();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final int N() throws IOException {
        int i2 = this.f13241d;
        if (i2 != 0) {
            this.f13239b = i2;
            this.f13241d = 0;
        } else {
            this.f13239b = this.a.d();
        }
        int i3 = this.f13239b;
        if (i3 == 0 || i3 == this.f13240c) {
            return Integer.MAX_VALUE;
        }
        return i3 >>> 3;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void O(List<zzdmr> list) throws IOException {
        int iD;
        if ((this.f13239b & 7) != 2) {
            throw zzdok.f();
        }
        do {
            list.add(T());
            if (this.a.t()) {
                return;
            } else {
                iD = this.a.d();
            }
        } while (iD == this.f13239b);
        this.f13241d = iD;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final int P() throws IOException {
        g(0);
        return this.a.g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.kw
    public final <T> void Q(List<T> list, lw<T> lwVar, zzdno zzdnoVar) throws IOException {
        int iD;
        int i2 = this.f13239b;
        if ((i2 & 7) != 3) {
            throw zzdok.f();
        }
        do {
            list.add(f(lwVar, zzdnoVar));
            if (this.a.t() || this.f13241d != 0) {
                return;
            } else {
                iD = this.a.d();
            }
        } while (iD == i2);
        this.f13241d = iD;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final int R() throws IOException {
        g(5);
        return this.a.i();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final boolean S() throws IOException {
        int i2;
        if (this.a.t() || (i2 = this.f13239b) == this.f13240c) {
            return false;
        }
        return this.a.y(i2);
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final zzdmr T() throws IOException {
        g(2);
        return this.a.l();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final <T> T U(lw<T> lwVar, zzdno zzdnoVar) throws IOException {
        g(2);
        return (T) e(lwVar, zzdnoVar);
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final int V() throws IOException {
        g(0);
        return this.a.m();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void W(List<Integer> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof gv)) {
            int i2 = this.f13239b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.a.n()));
                    if (this.a.t()) {
                        return;
                    } else {
                        iD = this.a.d();
                    }
                } while (iD == this.f13239b);
                this.f13241d = iD;
                return;
            }
            if (i2 != 2) {
                throw zzdok.f();
            }
            int iU = this.a.u() + this.a.m();
            do {
                list.add(Integer.valueOf(this.a.n()));
            } while (this.a.u() < iU);
            k(iU);
            return;
        }
        gv gvVar = (gv) list;
        int i3 = this.f13239b & 7;
        if (i3 == 0) {
            do {
                gvVar.Z0(this.a.n());
                if (this.a.t()) {
                    return;
                } else {
                    iD2 = this.a.d();
                }
            } while (iD2 == this.f13239b);
            this.f13241d = iD2;
            return;
        }
        if (i3 != 2) {
            throw zzdok.f();
        }
        int iU2 = this.a.u() + this.a.m();
        do {
            gvVar.Z0(this.a.n());
        } while (this.a.u() < iU2);
        k(iU2);
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final int X() throws IOException {
        g(0);
        return this.a.n();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void Y(List<Integer> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof gv)) {
            int i2 = this.f13239b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.a.m()));
                    if (this.a.t()) {
                        return;
                    } else {
                        iD = this.a.d();
                    }
                } while (iD == this.f13239b);
                this.f13241d = iD;
                return;
            }
            if (i2 != 2) {
                throw zzdok.f();
            }
            int iU = this.a.u() + this.a.m();
            do {
                list.add(Integer.valueOf(this.a.m()));
            } while (this.a.u() < iU);
            k(iU);
            return;
        }
        gv gvVar = (gv) list;
        int i3 = this.f13239b & 7;
        if (i3 == 0) {
            do {
                gvVar.Z0(this.a.m());
                if (this.a.t()) {
                    return;
                } else {
                    iD2 = this.a.d();
                }
            } while (iD2 == this.f13239b);
            this.f13241d = iD2;
            return;
        }
        if (i3 != 2) {
            throw zzdok.f();
        }
        int iU2 = this.a.u() + this.a.m();
        do {
            gvVar.Z0(this.a.m());
        } while (this.a.u() < iU2);
        k(iU2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.kw
    public final <T> void Z(List<T> list, lw<T> lwVar, zzdno zzdnoVar) throws IOException {
        int iD;
        int i2 = this.f13239b;
        if ((i2 & 7) != 2) {
            throw zzdok.f();
        }
        do {
            list.add(e(lwVar, zzdnoVar));
            if (this.a.t() || this.f13241d != 0) {
                return;
            } else {
                iD = this.a.d();
            }
        } while (iD == i2);
        this.f13241d = iD;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final String a() throws IOException {
        g(2);
        return this.a.c();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void a0(List<Long> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof ov)) {
            int i2 = this.f13239b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.a.p()));
                    if (this.a.t()) {
                        return;
                    } else {
                        iD = this.a.d();
                    }
                } while (iD == this.f13239b);
                this.f13241d = iD;
                return;
            }
            if (i2 != 2) {
                throw zzdok.f();
            }
            int iM = this.a.m();
            h(iM);
            int iU = this.a.u() + iM;
            do {
                list.add(Long.valueOf(this.a.p()));
            } while (this.a.u() < iU);
            return;
        }
        ov ovVar = (ov) list;
        int i3 = this.f13239b & 7;
        if (i3 == 1) {
            do {
                ovVar.i(this.a.p());
                if (this.a.t()) {
                    return;
                } else {
                    iD2 = this.a.d();
                }
            } while (iD2 == this.f13239b);
            this.f13241d = iD2;
            return;
        }
        if (i3 != 2) {
            throw zzdok.f();
        }
        int iM2 = this.a.m();
        h(iM2);
        int iU2 = this.a.u() + iM2;
        do {
            ovVar.i(this.a.p());
        } while (this.a.u() < iU2);
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void b(List<String> list) throws IOException {
        d(list, false);
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final int b0() throws IOException {
        g(5);
        return this.a.o();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final <T> T c0(lw<T> lwVar, zzdno zzdnoVar) throws IOException {
        g(3);
        return (T) f(lwVar, zzdnoVar);
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void d0(List<Integer> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof gv)) {
            int i2 = this.f13239b & 7;
            if (i2 == 2) {
                int iM = this.a.m();
                j(iM);
                int iU = this.a.u() + iM;
                do {
                    list.add(Integer.valueOf(this.a.o()));
                } while (this.a.u() < iU);
                return;
            }
            if (i2 != 5) {
                throw zzdok.f();
            }
            do {
                list.add(Integer.valueOf(this.a.o()));
                if (this.a.t()) {
                    return;
                } else {
                    iD = this.a.d();
                }
            } while (iD == this.f13239b);
            this.f13241d = iD;
            return;
        }
        gv gvVar = (gv) list;
        int i3 = this.f13239b & 7;
        if (i3 == 2) {
            int iM2 = this.a.m();
            j(iM2);
            int iU2 = this.a.u() + iM2;
            do {
                gvVar.Z0(this.a.o());
            } while (this.a.u() < iU2);
            return;
        }
        if (i3 != 5) {
            throw zzdok.f();
        }
        do {
            gvVar.Z0(this.a.o());
            if (this.a.t()) {
                return;
            } else {
                iD2 = this.a.d();
            }
        } while (iD2 == this.f13239b);
        this.f13241d = iD2;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final long e0() throws IOException {
        g(1);
        return this.a.p();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final int getTag() {
        return this.f13239b;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void i(List<Boolean> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof cu)) {
            int i2 = this.f13239b & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.a.j()));
                    if (this.a.t()) {
                        return;
                    } else {
                        iD = this.a.d();
                    }
                } while (iD == this.f13239b);
                this.f13241d = iD;
                return;
            }
            if (i2 != 2) {
                throw zzdok.f();
            }
            int iU = this.a.u() + this.a.m();
            do {
                list.add(Boolean.valueOf(this.a.j()));
            } while (this.a.u() < iU);
            k(iU);
            return;
        }
        cu cuVar = (cu) list;
        int i3 = this.f13239b & 7;
        if (i3 == 0) {
            do {
                cuVar.f(this.a.j());
                if (this.a.t()) {
                    return;
                } else {
                    iD2 = this.a.d();
                }
            } while (iD2 == this.f13239b);
            this.f13241d = iD2;
            return;
        }
        if (i3 != 2) {
            throw zzdok.f();
        }
        int iU2 = this.a.u() + this.a.m();
        do {
            cuVar.f(this.a.j());
        } while (this.a.u() < iU2);
        k(iU2);
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void n(List<Integer> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof gv)) {
            int i2 = this.f13239b & 7;
            if (i2 == 2) {
                int iM = this.a.m();
                j(iM);
                int iU = this.a.u() + iM;
                do {
                    list.add(Integer.valueOf(this.a.i()));
                } while (this.a.u() < iU);
                return;
            }
            if (i2 != 5) {
                throw zzdok.f();
            }
            do {
                list.add(Integer.valueOf(this.a.i()));
                if (this.a.t()) {
                    return;
                } else {
                    iD = this.a.d();
                }
            } while (iD == this.f13239b);
            this.f13241d = iD;
            return;
        }
        gv gvVar = (gv) list;
        int i3 = this.f13239b & 7;
        if (i3 == 2) {
            int iM2 = this.a.m();
            j(iM2);
            int iU2 = this.a.u() + iM2;
            do {
                gvVar.Z0(this.a.i());
            } while (this.a.u() < iU2);
            return;
        }
        if (i3 != 5) {
            throw zzdok.f();
        }
        do {
            gvVar.Z0(this.a.i());
            if (this.a.t()) {
                return;
            } else {
                iD2 = this.a.d();
            }
        } while (iD2 == this.f13239b);
        this.f13241d = iD2;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void o(List<Float> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof cv)) {
            int i2 = this.f13239b & 7;
            if (i2 == 2) {
                int iM = this.a.m();
                j(iM);
                int iU = this.a.u() + iM;
                do {
                    list.add(Float.valueOf(this.a.b()));
                } while (this.a.u() < iU);
                return;
            }
            if (i2 != 5) {
                throw zzdok.f();
            }
            do {
                list.add(Float.valueOf(this.a.b()));
                if (this.a.t()) {
                    return;
                } else {
                    iD = this.a.d();
                }
            } while (iD == this.f13239b);
            this.f13241d = iD;
            return;
        }
        cv cvVar = (cv) list;
        int i3 = this.f13239b & 7;
        if (i3 == 2) {
            int iM2 = this.a.m();
            j(iM2);
            int iU2 = this.a.u() + iM2;
            do {
                cvVar.i(this.a.b());
            } while (this.a.u() < iU2);
            return;
        }
        if (i3 != 5) {
            throw zzdok.f();
        }
        do {
            cvVar.i(this.a.b());
            if (this.a.t()) {
                return;
            } else {
                iD2 = this.a.d();
            }
        } while (iD2 == this.f13239b);
        this.f13241d = iD2;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void r(List<Double> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof tu)) {
            int i2 = this.f13239b & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.a.a()));
                    if (this.a.t()) {
                        return;
                    } else {
                        iD = this.a.d();
                    }
                } while (iD == this.f13239b);
                this.f13241d = iD;
                return;
            }
            if (i2 != 2) {
                throw zzdok.f();
            }
            int iM = this.a.m();
            h(iM);
            int iU = this.a.u() + iM;
            do {
                list.add(Double.valueOf(this.a.a()));
            } while (this.a.u() < iU);
            return;
        }
        tu tuVar = (tu) list;
        int i3 = this.f13239b & 7;
        if (i3 == 1) {
            do {
                tuVar.f(this.a.a());
                if (this.a.t()) {
                    return;
                } else {
                    iD2 = this.a.d();
                }
            } while (iD2 == this.f13239b);
            this.f13241d = iD2;
            return;
        }
        if (i3 != 2) {
            throw zzdok.f();
        }
        int iM2 = this.a.m();
        h(iM2);
        int iU2 = this.a.u() + iM2;
        do {
            tuVar.f(this.a.a());
        } while (this.a.u() < iU2);
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final double readDouble() throws IOException {
        g(1);
        return this.a.a();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final float readFloat() throws IOException {
        g(5);
        return this.a.b();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void t(List<String> list) throws IOException {
        d(list, true);
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void u(List<Long> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof ov)) {
            int i2 = this.f13239b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.a.f()));
                    if (this.a.t()) {
                        return;
                    } else {
                        iD = this.a.d();
                    }
                } while (iD == this.f13239b);
                this.f13241d = iD;
                return;
            }
            if (i2 != 2) {
                throw zzdok.f();
            }
            int iU = this.a.u() + this.a.m();
            do {
                list.add(Long.valueOf(this.a.f()));
            } while (this.a.u() < iU);
            k(iU);
            return;
        }
        ov ovVar = (ov) list;
        int i3 = this.f13239b & 7;
        if (i3 == 0) {
            do {
                ovVar.i(this.a.f());
                if (this.a.t()) {
                    return;
                } else {
                    iD2 = this.a.d();
                }
            } while (iD2 == this.f13239b);
            this.f13241d = iD2;
            return;
        }
        if (i3 != 2) {
            throw zzdok.f();
        }
        int iU2 = this.a.u() + this.a.m();
        do {
            ovVar.i(this.a.f());
        } while (this.a.u() < iU2);
        k(iU2);
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void z(List<Long> list) throws IOException {
        int iD;
        int iD2;
        if (!(list instanceof ov)) {
            int i2 = this.f13239b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.a.e()));
                    if (this.a.t()) {
                        return;
                    } else {
                        iD = this.a.d();
                    }
                } while (iD == this.f13239b);
                this.f13241d = iD;
                return;
            }
            if (i2 != 2) {
                throw zzdok.f();
            }
            int iU = this.a.u() + this.a.m();
            do {
                list.add(Long.valueOf(this.a.e()));
            } while (this.a.u() < iU);
            k(iU);
            return;
        }
        ov ovVar = (ov) list;
        int i3 = this.f13239b & 7;
        if (i3 == 0) {
            do {
                ovVar.i(this.a.e());
                if (this.a.t()) {
                    return;
                } else {
                    iD2 = this.a.d();
                }
            } while (iD2 == this.f13239b);
            this.f13241d = iD2;
            return;
        }
        if (i3 != 2) {
            throw zzdok.f();
        }
        int iU2 = this.a.u() + this.a.m();
        do {
            ovVar.i(this.a.e());
        } while (this.a.u() < iU2);
        k(iU2);
    }
}
