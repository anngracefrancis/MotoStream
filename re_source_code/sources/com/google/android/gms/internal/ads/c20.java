package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class c20 {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f12378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f12379e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzst f12380f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzst f12381g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f12382h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f12383i;

    public c20(zzst zzstVar, zzst zzstVar2, boolean z) {
        this.f12381g = zzstVar;
        this.f12380f = zzstVar2;
        this.f12379e = z;
        zzstVar2.k(12);
        this.a = zzstVar2.s();
        zzstVar.k(12);
        this.f12383i = zzstVar.s();
        zzsk.f(zzstVar.d() == 1, "first_chunk must be 1");
        this.f12376b = -1;
    }

    public final boolean a() {
        int i2 = this.f12376b + 1;
        this.f12376b = i2;
        if (i2 == this.a) {
            return false;
        }
        this.f12378d = this.f12379e ? this.f12380f.t() : this.f12380f.q();
        if (this.f12376b == this.f12382h) {
            this.f12377c = this.f12381g.s();
            this.f12381g.l(4);
            int i3 = this.f12383i - 1;
            this.f12383i = i3;
            this.f12382h = i3 > 0 ? this.f12381g.s() - 1 : -1;
        }
        return true;
    }
}
