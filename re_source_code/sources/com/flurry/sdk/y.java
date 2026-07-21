package com.flurry.sdk;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends d7<x> {
    public String p;
    public boolean q;
    private h7 r;
    protected f7<i7> s;

    final class a implements f7<i7> {
        a() {
        }

        @Override // com.flurry.sdk.f7
        public final /* synthetic */ void a(i7 i7Var) {
            y yVar = y.this;
            yVar.t(new x(yVar.p, y.this.q));
        }
    }

    final class b extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ f7 f11145h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ x f11146i;

        b(f7 f7Var, x xVar) {
            this.f11145h = f7Var;
            this.f11146i = xVar;
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            this.f11145h.a(this.f11146i);
        }
    }

    public y(h7 h7Var) {
        super("NotificationProvider");
        this.q = false;
        a aVar = new a();
        this.s = aVar;
        this.r = h7Var;
        h7Var.v(aVar);
    }

    @Override // com.flurry.sdk.d7
    public final void v(f7<x> f7Var) {
        super.v(f7Var);
        m(new b(f7Var, new x(this.p, this.q)));
    }
}
