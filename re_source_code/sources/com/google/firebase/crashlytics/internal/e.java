package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.p.f0;
import com.google.firebase.crashlytics.internal.p.g0;
import com.google.firebase.s.b;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: CrashlyticsNativeComponentDeferredProxy.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements d {
    private static final i a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.firebase.s.a<d> f18997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicReference<d> f18998c = new AtomicReference<>(null);

    /* JADX INFO: compiled from: CrashlyticsNativeComponentDeferredProxy.java */
    private static final class b implements i {
        private b() {
        }

        @Override // com.google.firebase.crashlytics.internal.i
        public File a() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.i
        public File b() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.i
        public File c() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.i
        public f0.a d() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.i
        public File e() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.i
        public File f() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.i
        public File g() {
            return null;
        }
    }

    public e(com.google.firebase.s.a<d> aVar) {
        this.f18997b = aVar;
        aVar.a(new com.google.firebase.s.a.InterfaceC0234a() { // from class: com.google.firebase.crashlytics.h.a
            @Override // com.google.firebase.s.a.InterfaceC0234a
            public final void a(b bVar) {
                this.a.f(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(com.google.firebase.s.b bVar) {
        h.f().b("Crashlytics native component now available.");
        this.f18998c.set((d) bVar.get());
    }

    @Override // com.google.firebase.crashlytics.internal.d
    public i a(String str) {
        d dVar = this.f18998c.get();
        return dVar == null ? a : dVar.a(str);
    }

    @Override // com.google.firebase.crashlytics.internal.d
    public boolean b() {
        d dVar = this.f18998c.get();
        return dVar != null && dVar.b();
    }

    @Override // com.google.firebase.crashlytics.internal.d
    public void c(final String str, final String str2, final long j2, final g0 g0Var) {
        h.f().i("Deferring native open session: " + str);
        this.f18997b.a(new com.google.firebase.s.a.InterfaceC0234a() { // from class: com.google.firebase.crashlytics.h.b
            @Override // com.google.firebase.s.a.InterfaceC0234a
            public final void a(com.google.firebase.s.b bVar) {
                ((d) bVar.get()).c(str, str2, j2, g0Var);
            }
        });
    }

    @Override // com.google.firebase.crashlytics.internal.d
    public boolean d(String str) {
        d dVar = this.f18998c.get();
        return dVar != null && dVar.d(str);
    }
}
