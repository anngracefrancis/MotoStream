package io.sentry.cache;

import io.sentry.l2;
import io.sentry.s4;
import io.sentry.x1;
import io.sentry.x4;
import java.util.Map;

/* JADX INFO: compiled from: PersistingOptionsObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s implements x1 {
    private final x4 a;

    public s(x4 x4Var) {
        this.a = x4Var;
    }

    private void g(String str) {
        p.a(this.a, ".options-cache", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            this.a.getLogger().b(s4.ERROR, "Serialization task failed", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(String str) {
        if (str == null) {
            g("dist.json");
        } else {
            y(str, "dist.json");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(String str) {
        if (str == null) {
            g("environment.json");
        } else {
            y(str, "environment.json");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(String str) {
        if (str == null) {
            g("proguard-uuid.json");
        } else {
            y(str, "proguard-uuid.json");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(String str) {
        if (str == null) {
            g("release.json");
        } else {
            y(str, "release.json");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(io.sentry.protocol.o oVar) {
        if (oVar == null) {
            g("sdk-version.json");
        } else {
            y(oVar, "sdk-version.json");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(Map map) {
        y(map, "tags.json");
    }

    public static <T> T v(x4 x4Var, String str, Class<T> cls) {
        return (T) w(x4Var, str, cls, null);
    }

    public static <T, R> T w(x4 x4Var, String str, Class<T> cls, l2<R> l2Var) {
        return (T) p.c(x4Var, ".options-cache", str, cls, l2Var);
    }

    private void x(final Runnable runnable) {
        try {
            this.a.getExecutorService().submit(new Runnable() { // from class: io.sentry.cache.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22326f.i(runnable);
                }
            });
        } catch (Throwable th) {
            this.a.getLogger().b(s4.ERROR, "Serialization task could not be scheduled", th);
        }
    }

    private <T> void y(T t, String str) {
        p.d(this.a, t, ".options-cache", str);
    }

    @Override // io.sentry.x1
    public void a(final Map<String, String> map) {
        x(new Runnable() { // from class: io.sentry.cache.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f22330f.u(map);
            }
        });
    }

    @Override // io.sentry.x1
    public void b(final io.sentry.protocol.o oVar) {
        x(new Runnable() { // from class: io.sentry.cache.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f22328f.s(oVar);
            }
        });
    }

    @Override // io.sentry.x1
    public void c(final String str) {
        x(new Runnable() { // from class: io.sentry.cache.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f22332f.k(str);
            }
        });
    }

    @Override // io.sentry.x1
    public void d(final String str) {
        x(new Runnable() { // from class: io.sentry.cache.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f22336f.m(str);
            }
        });
    }

    @Override // io.sentry.x1
    public void e(final String str) {
        x(new Runnable() { // from class: io.sentry.cache.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f22334f.o(str);
            }
        });
    }

    @Override // io.sentry.x1
    public void f(final String str) {
        x(new Runnable() { // from class: io.sentry.cache.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f22338f.q(str);
            }
        });
    }
}
