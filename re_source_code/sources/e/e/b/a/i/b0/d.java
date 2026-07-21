package e.e.b.a.i.b0;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.y;
import e.e.b.a.i.b0.j.j0;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* JADX INFO: compiled from: DefaultScheduler_Factory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements e.e.b.a.i.x.a.b<c> {
    private final Provider<Executor> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.backends.e> f20755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider<y> f20756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Provider<j0> f20757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.synchronization.a> f20758e;

    public d(Provider<Executor> provider, Provider<com.google.android.datatransport.runtime.backends.e> provider2, Provider<y> provider3, Provider<j0> provider4, Provider<com.google.android.datatransport.runtime.synchronization.a> provider5) {
        this.a = provider;
        this.f20755b = provider2;
        this.f20756c = provider3;
        this.f20757d = provider4;
        this.f20758e = provider5;
    }

    public static d a(Provider<Executor> provider, Provider<com.google.android.datatransport.runtime.backends.e> provider2, Provider<y> provider3, Provider<j0> provider4, Provider<com.google.android.datatransport.runtime.synchronization.a> provider5) {
        return new d(provider, provider2, provider3, provider4, provider5);
    }

    public static c c(Executor executor, com.google.android.datatransport.runtime.backends.e eVar, y yVar, j0 j0Var, com.google.android.datatransport.runtime.synchronization.a aVar) {
        return new c(executor, eVar, yVar, j0Var, aVar);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c get() {
        return c(this.a.get(), this.f20755b.get(), this.f20756c.get(), this.f20757d.get(), this.f20758e.get());
    }
}
