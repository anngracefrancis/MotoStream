package com.facebook.internal.t0;

import com.facebook.a0;

/* JADX INFO: compiled from: InstrumentManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {
    public static final j a = new j();

    private j() {
    }

    public static final void d() {
        a0 a0Var = a0.a;
        if (a0.g()) {
            com.facebook.internal.a0 a0Var2 = com.facebook.internal.a0.a;
            com.facebook.internal.a0.a(com.facebook.internal.a0.b.CrashReport, new com.facebook.internal.a0.a() { // from class: com.facebook.internal.t0.b
                @Override // com.facebook.internal.a0.a
                public final void a(boolean z) {
                    j.e(z);
                }
            });
            com.facebook.internal.a0.a(com.facebook.internal.a0.b.ErrorReport, new com.facebook.internal.a0.a() { // from class: com.facebook.internal.t0.d
                @Override // com.facebook.internal.a0.a
                public final void a(boolean z) {
                    j.f(z);
                }
            });
            com.facebook.internal.a0.a(com.facebook.internal.a0.b.AnrReport, new com.facebook.internal.a0.a() { // from class: com.facebook.internal.t0.c
                @Override // com.facebook.internal.a0.a
                public final void a(boolean z) {
                    j.g(z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(boolean z) {
        if (z) {
            com.facebook.internal.t0.m.c.f9888f.a();
            com.facebook.internal.a0 a0Var = com.facebook.internal.a0.a;
            if (com.facebook.internal.a0.g(com.facebook.internal.a0.b.CrashShield)) {
                h hVar = h.a;
                h.a();
                com.facebook.internal.t0.n.a aVar = com.facebook.internal.t0.n.a.a;
                com.facebook.internal.t0.n.a.a();
            }
            if (com.facebook.internal.a0.g(com.facebook.internal.a0.b.ThreadCheck)) {
                com.facebook.internal.t0.p.a aVar2 = com.facebook.internal.t0.p.a.a;
                com.facebook.internal.t0.p.a.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(boolean z) {
        if (z) {
            com.facebook.internal.t0.o.e eVar = com.facebook.internal.t0.o.e.a;
            com.facebook.internal.t0.o.e.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(boolean z) {
        if (z) {
            com.facebook.internal.t0.l.e eVar = com.facebook.internal.t0.l.e.a;
            com.facebook.internal.t0.l.e.a();
        }
    }
}
