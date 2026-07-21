package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
final class wy implements zzge {
    private final Handler a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final yy f13528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CopyOnWriteArraySet<zzgh> f13529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean[] f13530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f13531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13532f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f13533g;

    @SuppressLint({"HandlerLeak"})
    public wy(int i2, int i3, int i4) {
        Log.i("ExoPlayerImpl", "Init 1.3.1");
        int i5 = 0;
        this.f13531e = false;
        this.f13532f = 1;
        this.f13529c = new CopyOnWriteArraySet<>();
        this.f13530d = new boolean[2];
        while (true) {
            boolean[] zArr = this.f13530d;
            if (i5 >= zArr.length) {
                xy xyVar = new xy(this);
                this.a = xyVar;
                this.f13528b = new yy(xyVar, this.f13531e, this.f13530d, 2500, 5000);
                return;
            }
            zArr[i5] = true;
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final int F() {
        return this.f13532f;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void a(boolean z) {
        if (this.f13531e != z) {
            this.f13531e = z;
            this.f13533g++;
            this.f13528b.n(z);
            Iterator<zzgh> it = this.f13529c.iterator();
            while (it.hasNext()) {
                it.next().a(z, this.f13532f);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void b(long j2) {
        this.f13528b.d(j2);
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void c() {
        this.f13528b.c();
        this.a.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final long d() {
        return this.f13528b.a();
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final long e() {
        return this.f13528b.o();
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final boolean f() {
        return this.f13531e;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final long g() {
        return this.f13528b.b();
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void h(zzgf zzgfVar, int i2, Object obj) {
        this.f13528b.k(zzgfVar, 1, obj);
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void i(zzgh zzghVar) {
        this.f13529c.add(zzghVar);
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void j(zzgf zzgfVar, int i2, Object obj) {
        this.f13528b.h(zzgfVar, 1, obj);
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void k(zzhp... zzhpVarArr) {
        this.f13528b.i(zzhpVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void l(int i2, boolean z) {
        boolean[] zArr = this.f13530d;
        if (zArr[0] != z) {
            zArr[0] = z;
            this.f13528b.m(0, z);
        }
    }

    final void m(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            this.f13532f = message.arg1;
            Iterator<zzgh> it = this.f13529c.iterator();
            while (it.hasNext()) {
                it.next().a(this.f13531e, this.f13532f);
            }
            return;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                return;
            }
            zzgd zzgdVar = (zzgd) message.obj;
            Iterator<zzgh> it2 = this.f13529c.iterator();
            while (it2.hasNext()) {
                it2.next().b(zzgdVar);
            }
            return;
        }
        int i3 = this.f13533g - 1;
        this.f13533g = i3;
        if (i3 == 0) {
            Iterator<zzgh> it3 = this.f13529c.iterator();
            while (it3.hasNext()) {
                it3.next().c();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void stop() {
        this.f13528b.f();
    }
}
