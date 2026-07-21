package io.sentry.cache;

import io.sentry.f5;
import io.sentry.l2;
import io.sentry.s4;
import io.sentry.v0;
import io.sentry.x4;
import io.sentry.y1;
import io.sentry.z1;
import java.util.Collection;

/* JADX INFO: compiled from: PersistingScopeObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t implements z1 {
    private final x4 a;

    public t(x4 x4Var) {
        this.a = x4Var;
    }

    private void e(String str) {
        p.a(this.a, ".scope-cache", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            this.a.getLogger().b(s4.ERROR, "Serialization task failed", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(Collection collection) {
        t(collection, "breadcrumbs.json");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(io.sentry.protocol.c cVar) {
        t(cVar, "contexts.json");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(f5 f5Var) {
        if (f5Var == null) {
            e("trace.json");
        } else {
            t(f5Var, "trace.json");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(String str) {
        if (str == null) {
            e("transaction.json");
        } else {
            t(str, "transaction.json");
        }
    }

    public static <T> T q(x4 x4Var, String str, Class<T> cls) {
        return (T) r(x4Var, str, cls, null);
    }

    public static <T, R> T r(x4 x4Var, String str, Class<T> cls, l2<R> l2Var) {
        return (T) p.c(x4Var, ".scope-cache", str, cls, l2Var);
    }

    private void s(final Runnable runnable) {
        try {
            this.a.getExecutorService().submit(new Runnable() { // from class: io.sentry.cache.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22342f.g(runnable);
                }
            });
        } catch (Throwable th) {
            this.a.getLogger().b(s4.ERROR, "Serialization task could not be scheduled", th);
        }
    }

    private <T> void t(T t, String str) {
        p.d(this.a, t, ".scope-cache", str);
    }

    @Override // io.sentry.z1
    public void a(final Collection<v0> collection) {
        s(new Runnable() { // from class: io.sentry.cache.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f22344f.j(collection);
            }
        });
    }

    @Override // io.sentry.z1
    public void b(final io.sentry.protocol.c cVar) {
        s(new Runnable() { // from class: io.sentry.cache.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f22348f.l(cVar);
            }
        });
    }

    @Override // io.sentry.z1
    public void c(final f5 f5Var) {
        s(new Runnable() { // from class: io.sentry.cache.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f22346f.n(f5Var);
            }
        });
    }

    @Override // io.sentry.z1
    public void d(final String str) {
        s(new Runnable() { // from class: io.sentry.cache.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f22340f.p(str);
            }
        });
    }

    @Override // io.sentry.z1
    public /* synthetic */ void i(v0 v0Var) {
        y1.a(this, v0Var);
    }
}
