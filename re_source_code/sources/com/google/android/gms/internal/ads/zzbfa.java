package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbfa implements zzkw, zzqi, zzsj<zzrv>, zztn {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    private static int f14420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @VisibleForTesting
    private static int f14421g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Context f14422h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzbez f14423i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzlo f14424j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzlo f14425k;
    private final zzrj l;
    private final zzbde m;
    private zzkv n;
    private ByteBuffer o;
    private boolean p;
    private zzbfi q;
    private int r;
    private Set<WeakReference<m9>> s = new HashSet();

    public zzbfa(Context context, zzbde zzbdeVar) {
        this.f14422h = context;
        this.m = zzbdeVar;
        zzbez zzbezVar = new zzbez();
        this.f14423i = zzbezVar;
        zzpg zzpgVar = zzpg.a;
        zzth zzthVar = new zzth(context, zzpgVar, 0L, zzaxi.a, this, -1);
        this.f14424j = zzthVar;
        zzms zzmsVar = new zzms(zzpgVar);
        this.f14425k = zzmsVar;
        zzrg zzrgVar = new zzrg();
        this.l = zzrgVar;
        if (zzawz.n()) {
            String strValueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 28);
            sb.append("ExoPlayerAdapter initialize ");
            sb.append(strValueOf);
            zzawz.m(sb.toString());
        }
        f14420f++;
        zzkv zzkvVarA = zzkz.a(new zzlo[]{zzmsVar, zzthVar}, zzrgVar, zzbezVar);
        this.n = zzkvVarA;
        zzkvVarA.m(this);
    }

    public static int G() {
        return f14420f;
    }

    public static int H() {
        return f14421g;
    }

    @VisibleForTesting
    private final zzql u(Uri uri, final String str) {
        final zzrw zzrwVar;
        if (!this.p || this.o.limit() <= 0) {
            zzrwVar = this.m.f14371i > 0 ? new zzrw(this, str) { // from class: com.google.android.gms.internal.ads.p9
                private final zzbfa a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final String f13158b;

                {
                    this.a = this;
                    this.f13158b = str;
                }

                @Override // com.google.android.gms.internal.ads.zzrw
                public final zzrv a() {
                    return this.a.E(this.f13158b);
                }
            } : new zzrw(this, str) { // from class: com.google.android.gms.internal.ads.q9
                private final zzbfa a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final String f13227b;

                {
                    this.a = this;
                    this.f13227b = str;
                }

                @Override // com.google.android.gms.internal.ads.zzrw
                public final zzrv a() {
                    return this.a.D(this.f13227b);
                }
            };
            if (this.m.f14372j) {
                zzrwVar = new zzrw(this, zzrwVar) { // from class: com.google.android.gms.internal.ads.r9
                    private final zzbfa a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    private final zzrw f13266b;

                    {
                        this.a = this;
                        this.f13266b = zzrwVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzrw
                    public final zzrv a() {
                        return this.a.v(this.f13266b);
                    }
                };
            }
            if (this.o.limit() > 0) {
                final byte[] bArr = new byte[this.o.limit()];
                this.o.get(bArr);
                zzrwVar = new zzrw(zzrwVar, bArr) { // from class: com.google.android.gms.internal.ads.s9
                    private final zzrw a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    private final byte[] f13322b;

                    {
                        this.a = zzrwVar;
                        this.f13322b = bArr;
                    }

                    @Override // com.google.android.gms.internal.ads.zzrw
                    public final zzrv a() {
                        zzrw zzrwVar2 = this.a;
                        byte[] bArr2 = this.f13322b;
                        return new v9(new zzru(bArr2), bArr2.length, zzrwVar2.a());
                    }
                };
            }
        } else {
            final byte[] bArr2 = new byte[this.o.limit()];
            this.o.get(bArr2);
            zzrwVar = new zzrw(bArr2) { // from class: com.google.android.gms.internal.ads.o9
                private final byte[] a;

                {
                    this.a = bArr2;
                }

                @Override // com.google.android.gms.internal.ads.zzrw
                public final zzrv a() {
                    return new zzru(this.a);
                }
            };
        }
        return new zzqh(uri, zzrwVar, t9.a, -1, zzaxi.a, this, null, this.m.f14369g);
    }

    final void A(boolean z) {
        for (int i2 = 0; i2 < this.n.h(); i2++) {
            this.l.f(i2, !z);
        }
    }

    final void B(float f2, boolean z) {
        zzky zzkyVar = new zzky(this.f14425k, 2, Float.valueOf(f2));
        if (z) {
            this.n.k(zzkyVar);
        } else {
            this.n.i(zzkyVar);
        }
    }

    public final void C(int i2) {
        Iterator<WeakReference<m9>> it = this.s.iterator();
        while (it.hasNext()) {
            m9 m9Var = it.next().get();
            if (m9Var != null) {
                m9Var.b(i2);
            }
        }
    }

    final /* synthetic */ zzrv D(String str) {
        zzbde zzbdeVar = this.m;
        return new zzsa(str, null, zzbdeVar.f14372j ? null : this, zzbdeVar.f14366d, zzbdeVar.f14368f, true, null);
    }

    final /* synthetic */ zzrv E(String str) {
        zzbde zzbdeVar = this.m;
        m9 m9Var = new m9(str, zzbdeVar.f14372j ? null : this, zzbdeVar.f14366d, zzbdeVar.f14368f, zzbdeVar.f14371i);
        this.s.add(new WeakReference<>(m9Var));
        return m9Var;
    }

    final /* synthetic */ void F(boolean z, long j2) {
        zzbfi zzbfiVar = this.q;
        if (zzbfiVar != null) {
            zzbfiVar.a(z, j2);
        }
    }

    public final zzkv I() {
        return this.n;
    }

    public final zzbez J() {
        return this.f14423i;
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    public final void a(boolean z, int i2) {
        zzbfi zzbfiVar = this.q;
        if (zzbfiVar != null) {
            zzbfiVar.e(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztn
    public final void b(int i2, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    public final void c() {
    }

    @Override // com.google.android.gms.internal.ads.zzsj
    public final /* bridge */ /* synthetic */ void d(zzrv zzrvVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    public final void e(zzrb zzrbVar, zzro zzroVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzqi
    public final void f(IOException iOException) {
        zzbfi zzbfiVar = this.q;
        if (zzbfiVar != null) {
            zzbfiVar.f("onLoadError", iOException);
        }
    }

    public final void finalize() throws Throwable {
        f14420f--;
        if (zzawz.n()) {
            String strValueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 26);
            sb.append("ExoPlayerAdapter finalize ");
            sb.append(strValueOf);
            zzawz.m(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zztn
    public final void g(String str, long j2, long j3) {
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    public final void h(zzln zzlnVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    public final void i(zzlr zzlrVar, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zztn
    public final void j(Surface surface) {
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    public final void k(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    public final void l(zzku zzkuVar) {
        zzbfi zzbfiVar = this.q;
        if (zzbfiVar != null) {
            zzbfiVar.f("onPlayerError", zzkuVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztn
    public final void m(int i2, int i3, int i4, float f2) {
        zzbfi zzbfiVar = this.q;
        if (zzbfiVar != null) {
            zzbfiVar.g(i2, i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsj
    public final /* synthetic */ void n(zzrv zzrvVar, zzry zzryVar) {
        this.r = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzsj
    public final /* synthetic */ void o(zzrv zzrvVar, int i2) {
        this.r += i2;
    }

    @Override // com.google.android.gms.internal.ads.zztn
    public final void p(zznc zzncVar) {
    }

    @Override // com.google.android.gms.internal.ads.zztn
    public final void q(zzlh zzlhVar) {
    }

    @Override // com.google.android.gms.internal.ads.zztn
    public final void r(zznc zzncVar) {
    }

    public final long s() {
        return this.r;
    }

    public final void t() {
        zzkv zzkvVar = this.n;
        if (zzkvVar != null) {
            zzkvVar.l(this);
            this.n.c();
            this.n = null;
            f14421g--;
        }
    }

    final /* synthetic */ zzrv v(zzrw zzrwVar) {
        return new zzbex(this.f14422h, zzrwVar.a(), this, new zzbey(this) { // from class: com.google.android.gms.internal.ads.u9
            private final zzbfa a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbey
            public final void a(boolean z, long j2) {
                this.a.F(z, j2);
            }
        });
    }

    final void w(Surface surface, boolean z) {
        zzky zzkyVar = new zzky(this.f14424j, 1, surface);
        if (z) {
            this.n.k(zzkyVar);
        } else {
            this.n.i(zzkyVar);
        }
    }

    public final void x(zzbfi zzbfiVar) {
        this.q = zzbfiVar;
    }

    public final void y(Uri[] uriArr, String str) {
        z(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void z(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzql zzqoVar;
        this.o = byteBuffer;
        this.p = z;
        if (uriArr.length == 1) {
            zzqoVar = u(uriArr[0], str);
        } else {
            zzql[] zzqlVarArr = new zzql[uriArr.length];
            for (int i2 = 0; i2 < uriArr.length; i2++) {
                zzqlVarArr[i2] = u(uriArr[i2], str);
            }
            zzqoVar = new zzqo(zzqlVarArr);
        }
        this.n.j(zzqoVar);
        f14421g++;
    }
}
