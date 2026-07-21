package com.facebook.o0;

/* JADX INFO: compiled from: AppEventsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {
    public static final c0 a = new c0();

    /* JADX INFO: compiled from: AppEventsManager.kt */
    public static final class a implements com.facebook.internal.d0.b {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(boolean z) {
            if (z) {
                com.facebook.o0.k0.c cVar = com.facebook.o0.k0.c.a;
                com.facebook.o0.k0.c.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(boolean z) {
            if (z) {
                com.facebook.o0.t0.a aVar = com.facebook.o0.t0.a.a;
                com.facebook.o0.t0.a.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(boolean z) {
            if (z) {
                com.facebook.o0.r0.h hVar = com.facebook.o0.r0.h.a;
                com.facebook.o0.r0.h.c();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(boolean z) {
            if (z) {
                com.facebook.o0.n0.a aVar = com.facebook.o0.n0.a.a;
                com.facebook.o0.n0.a.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(boolean z) {
            if (z) {
                com.facebook.o0.o0.k kVar = com.facebook.o0.o0.k.a;
                com.facebook.o0.o0.k.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(boolean z) {
            if (z) {
                com.facebook.o0.p0.c cVar = com.facebook.o0.p0.c.a;
                com.facebook.o0.p0.c.b();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(boolean z) {
            if (z) {
                com.facebook.o0.p0.b bVar = com.facebook.o0.p0.b.a;
                com.facebook.o0.p0.b.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(boolean z) {
            if (z) {
                com.facebook.o0.l0.f fVar = com.facebook.o0.l0.f.a;
                com.facebook.o0.l0.f.a();
            }
        }

        @Override // com.facebook.internal.d0.b
        public void a(com.facebook.internal.c0 c0Var) {
            com.facebook.internal.a0 a0Var = com.facebook.internal.a0.a;
            com.facebook.internal.a0.a(com.facebook.internal.a0.b.AAM, new com.facebook.internal.a0.a() { // from class: com.facebook.o0.n
                @Override // com.facebook.internal.a0.a
                public final void a(boolean z) {
                    c0.a.j(z);
                }
            });
            com.facebook.internal.a0.a(com.facebook.internal.a0.b.RestrictiveDataFiltering, new com.facebook.internal.a0.a() { // from class: com.facebook.o0.r
                @Override // com.facebook.internal.a0.a
                public final void a(boolean z) {
                    c0.a.k(z);
                }
            });
            com.facebook.internal.a0.a(com.facebook.internal.a0.b.PrivacyProtection, new com.facebook.internal.a0.a() { // from class: com.facebook.o0.k
                @Override // com.facebook.internal.a0.a
                public final void a(boolean z) {
                    c0.a.l(z);
                }
            });
            com.facebook.internal.a0.a(com.facebook.internal.a0.b.EventDeactivation, new com.facebook.internal.a0.a() { // from class: com.facebook.o0.p
                @Override // com.facebook.internal.a0.a
                public final void a(boolean z) {
                    c0.a.m(z);
                }
            });
            com.facebook.internal.a0.a(com.facebook.internal.a0.b.IapLogging, new com.facebook.internal.a0.a() { // from class: com.facebook.o0.o
                @Override // com.facebook.internal.a0.a
                public final void a(boolean z) {
                    c0.a.n(z);
                }
            });
            com.facebook.internal.a0.a(com.facebook.internal.a0.b.ProtectedMode, new com.facebook.internal.a0.a() { // from class: com.facebook.o0.l
                @Override // com.facebook.internal.a0.a
                public final void a(boolean z) {
                    c0.a.o(z);
                }
            });
            com.facebook.internal.a0.a(com.facebook.internal.a0.b.MACARuleMatching, new com.facebook.internal.a0.a() { // from class: com.facebook.o0.m
                @Override // com.facebook.internal.a0.a
                public final void a(boolean z) {
                    c0.a.p(z);
                }
            });
            com.facebook.internal.a0.a(com.facebook.internal.a0.b.CloudBridge, new com.facebook.internal.a0.a() { // from class: com.facebook.o0.q
                @Override // com.facebook.internal.a0.a
                public final void a(boolean z) {
                    c0.a.q(z);
                }
            });
        }

        @Override // com.facebook.internal.d0.b
        public void onError() {
        }
    }

    private c0() {
    }

    public static final void a() {
        com.facebook.internal.d0 d0Var = com.facebook.internal.d0.a;
        com.facebook.internal.d0.a(new a());
    }
}
