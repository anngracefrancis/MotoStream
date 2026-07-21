package com.flurry.sdk;

/* JADX INFO: loaded from: classes2.dex */
public final class e7 {
    private static e7 a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q f10725d = new q();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s f10726e = new s();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j0 f10727f = new j0();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f10728g = new c();
    public o n = new o(this.f10725d);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h7 f10731j = new h7(this.f10725d);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h f10729h = new h(this.f10731j);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u f10723b = new u(this.f10731j);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f10730i = new d(this.n, this.f10731j);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public y f10732k = new y(this.f10731j);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w f10724c = new w(this.f10731j);
    public d0 l = new d0(this.f10731j);
    public l7 m = new l7();
    public i0 o = new i0(this.l, this.n);
    public a0 p = new a0();
    public k7 q = new k7();

    private e7() {
        this.f10723b.u();
        this.f10725d.u();
        this.f10726e.u();
        this.f10727f.u();
        this.f10728g.u();
        this.n.u();
        this.f10731j.u();
        this.f10729h.u();
        this.f10730i.u();
        this.f10732k.u();
        this.f10724c.u();
        this.l.u();
        this.m.u();
        this.o.u();
        this.p.u();
        this.q.u();
    }

    public static synchronized e7 a() {
        if (a == null) {
            a = new e7();
        }
        return a;
    }
}
