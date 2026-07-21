package com.flurry.sdk;

/* JADX INFO: loaded from: classes2.dex */
public final class d3 implements f3 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f10700k = 0;

    @Override // com.flurry.sdk.f3
    public final void a() {
        this.f10700k = 0;
    }

    @Override // com.flurry.sdk.f3
    public final f3.a b(u6 u6Var) {
        if (u6Var.a().equals(s6.FLUSH_FRAME)) {
            return new f3.a(f3.b.DO_NOT_DROP, new c4(new d4(this.f10700k)));
        }
        if (!u6Var.a().equals(s6.ANALYTICS_ERROR)) {
            return f3.a;
        }
        if (p7.UNCAUGHT_EXCEPTION_ID.f11009i.equals(((t3) u6Var.f()).f11061c)) {
            return f3.a;
        }
        int i2 = this.f10700k;
        this.f10700k = i2 + 1;
        return i2 >= 50 ? f3.f10748h : f3.a;
    }
}
