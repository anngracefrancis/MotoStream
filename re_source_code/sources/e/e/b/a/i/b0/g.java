package e.e.b.a.i.b0;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.t;
import javax.inject.Provider;

/* JADX INFO: compiled from: SchedulingConfigModule_ConfigFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements e.e.b.a.i.x.a.b<t> {
    private final Provider<e.e.b.a.i.c0.a> a;

    public g(Provider<e.e.b.a.i.c0.a> provider) {
        this.a = provider;
    }

    public static t a(e.e.b.a.i.c0.a aVar) {
        return (t) e.e.b.a.i.x.a.d.c(f.a(aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static g b(Provider<e.e.b.a.i.c0.a> provider) {
        return new g(provider);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public t get() {
        return a(this.a.get());
    }
}
