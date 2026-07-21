package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
final class n00 implements zzkv {
    private final zzlo[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzrp f13001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzro f13002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f13003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final p00 f13004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CopyOnWriteArraySet<zzkw> f13005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzlu f13006g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzlt f13007h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f13008i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f13009j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f13010k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private zzlr p;
    private Object q;
    private zzrb r;
    private zzro s;
    private zzln t;
    private zzle u;
    private int v;
    private int w;
    private long x;

    @SuppressLint({"HandlerLeak"})
    public n00(zzlo[] zzloVarArr, zzrp zzrpVar, zzll zzllVar) {
        String str = zzsy.f16743e;
        StringBuilder sb = new StringBuilder("Init ExoPlayerLib/2.4.2 [".length() + 1 + String.valueOf(str).length());
        sb.append("Init ExoPlayerLib/2.4.2 [");
        sb.append(str);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        zzsk.e(zzloVarArr.length > 0);
        this.a = (zzlo[]) zzsk.d(zzloVarArr);
        this.f13001b = (zzrp) zzsk.d(zzrpVar);
        this.f13009j = false;
        this.f13010k = 0;
        this.l = 1;
        this.f13005f = new CopyOnWriteArraySet<>();
        zzro zzroVar = new zzro(new zzrm[zzloVarArr.length]);
        this.f13002c = zzroVar;
        this.p = zzlr.a;
        this.f13006g = new zzlu();
        this.f13007h = new zzlt();
        this.r = zzrb.a;
        this.s = zzroVar;
        this.t = zzln.a;
        o00 o00Var = new o00(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.f13003d = o00Var;
        zzle zzleVar = new zzle(0, 0L);
        this.u = zzleVar;
        this.f13004e = new p00(zzloVarArr, zzrpVar, zzllVar, this.f13009j, 0, o00Var, zzleVar, this);
    }

    private final int o() {
        if (this.p.a() || this.m > 0) {
            return this.v;
        }
        this.p.c(this.u.a, this.f13007h, false);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final int F() {
        return this.l;
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final void a(boolean z) {
        if (this.f13009j != z) {
            this.f13009j = z;
            this.f13004e.y(z);
            Iterator<zzkw> it = this.f13005f.iterator();
            while (it.hasNext()) {
                it.next().a(z, this.l);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final void b(long j2) {
        int iO = o();
        if (iO < 0 || (!this.p.a() && iO >= this.p.g())) {
            throw new zzlk(this.p, iO, j2);
        }
        this.m++;
        this.v = iO;
        if (this.p.a()) {
            this.w = 0;
        } else {
            this.p.d(iO, this.f13006g, false);
            if (j2 != -9223372036854775807L) {
                zzkt.b(j2);
            }
            this.p.c(0, this.f13007h, false);
            this.w = 0;
        }
        if (j2 == -9223372036854775807L) {
            this.x = 0L;
            this.f13004e.m(this.p, iO, -9223372036854775807L);
            return;
        }
        this.x = j2;
        this.f13004e.m(this.p, iO, zzkt.b(j2));
        Iterator<zzkw> it = this.f13005f.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final void c() {
        this.f13004e.b();
        this.f13003d.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final long d() {
        if (this.p.a() || this.m > 0) {
            return this.x;
        }
        this.p.c(this.u.a, this.f13007h, false);
        return this.f13007h.b() + zzkt.a(this.u.f16418d);
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final long e() {
        if (this.p.a() || this.m > 0) {
            return this.x;
        }
        this.p.c(this.u.a, this.f13007h, false);
        return this.f13007h.b() + zzkt.a(this.u.f16417c);
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final boolean f() {
        return this.f13009j;
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final long g() {
        if (this.p.a()) {
            return -9223372036854775807L;
        }
        return zzkt.a(this.p.d(o(), this.f13006g, false).f16447i);
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final int h() {
        return this.a.length;
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final void i(zzky... zzkyVarArr) {
        this.f13004e.p(zzkyVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final void j(zzql zzqlVar) {
        if (!this.p.a() || this.q != null) {
            this.p = zzlr.a;
            this.q = null;
            Iterator<zzkw> it = this.f13005f.iterator();
            while (it.hasNext()) {
                it.next().i(this.p, this.q);
            }
        }
        if (this.f13008i) {
            this.f13008i = false;
            this.r = zzrb.a;
            this.s = this.f13002c;
            this.f13001b.d(null);
            Iterator<zzkw> it2 = this.f13005f.iterator();
            while (it2.hasNext()) {
                it2.next().e(this.r, this.s);
            }
        }
        this.n++;
        this.f13004e.n(zzqlVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final void k(zzky... zzkyVarArr) {
        this.f13004e.w(zzkyVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final void l(zzkw zzkwVar) {
        this.f13005f.remove(zzkwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final void m(zzkw zzkwVar) {
        this.f13005f.add(zzkwVar);
    }

    final void n(Message message) {
        switch (message.what) {
            case 0:
                this.n--;
                return;
            case 1:
                this.l = message.arg1;
                Iterator<zzkw> it = this.f13005f.iterator();
                while (it.hasNext()) {
                    it.next().a(this.f13009j, this.l);
                }
                return;
            case 2:
                this.o = message.arg1 != 0;
                Iterator<zzkw> it2 = this.f13005f.iterator();
                while (it2.hasNext()) {
                    it2.next().k(this.o);
                }
                return;
            case 3:
                if (this.n == 0) {
                    zzrr zzrrVar = (zzrr) message.obj;
                    this.f13008i = true;
                    this.r = zzrrVar.a;
                    this.s = zzrrVar.f16676b;
                    this.f13001b.d(zzrrVar.f16677c);
                    Iterator<zzkw> it3 = this.f13005f.iterator();
                    while (it3.hasNext()) {
                        it3.next().e(this.r, this.s);
                    }
                    return;
                }
                return;
            case 4:
                int i2 = this.m - 1;
                this.m = i2;
                if (i2 == 0) {
                    this.u = (zzle) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<zzkw> it4 = this.f13005f.iterator();
                        while (it4.hasNext()) {
                            it4.next().c();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.m == 0) {
                    this.u = (zzle) message.obj;
                    Iterator<zzkw> it5 = this.f13005f.iterator();
                    while (it5.hasNext()) {
                        it5.next().c();
                    }
                    return;
                }
                return;
            case 6:
                zzlg zzlgVar = (zzlg) message.obj;
                this.m -= zzlgVar.f16421d;
                if (this.n == 0) {
                    this.p = zzlgVar.a;
                    this.q = zzlgVar.f16419b;
                    this.u = zzlgVar.f16420c;
                    Iterator<zzkw> it6 = this.f13005f.iterator();
                    while (it6.hasNext()) {
                        it6.next().i(this.p, this.q);
                    }
                    return;
                }
                return;
            case 7:
                zzln zzlnVar = (zzln) message.obj;
                if (this.t.equals(zzlnVar)) {
                    return;
                }
                this.t = zzlnVar;
                Iterator<zzkw> it7 = this.f13005f.iterator();
                while (it7.hasNext()) {
                    it7.next().h(zzlnVar);
                }
                return;
            case 8:
                zzku zzkuVar = (zzku) message.obj;
                Iterator<zzkw> it8 = this.f13005f.iterator();
                while (it8.hasNext()) {
                    it8.next().l(zzkuVar);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final void stop() {
        this.f13004e.f();
    }
}
