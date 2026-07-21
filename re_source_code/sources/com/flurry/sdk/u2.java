package com.flurry.sdk;

/* JADX INFO: loaded from: classes2.dex */
final class u2 extends c3 implements x2 {

    final class a extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ u6 f11074h;

        a(u6 u6Var) {
            this.f11074h = u6Var;
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            u2.this.w(this.f11074h);
        }
    }

    u2(x2 x2Var) {
        super("BufferModule", x2Var);
    }

    @Override // com.flurry.sdk.c3
    protected final void b(u6 u6Var) {
        m(new a(u6Var));
    }
}
