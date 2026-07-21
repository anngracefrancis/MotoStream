package e.e.b.a.i;

import javax.inject.Provider;

/* JADX INFO: compiled from: TransportRuntime_Factory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w implements e.e.b.a.i.x.a.b<u> {
    private final Provider<e.e.b.a.i.c0.a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider<e.e.b.a.i.c0.a> f20851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider<e.e.b.a.i.b0.e> f20852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.u> f20853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.w> f20854e;

    public w(Provider<e.e.b.a.i.c0.a> provider, Provider<e.e.b.a.i.c0.a> provider2, Provider<e.e.b.a.i.b0.e> provider3, Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.u> provider4, Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.w> provider5) {
        this.a = provider;
        this.f20851b = provider2;
        this.f20852c = provider3;
        this.f20853d = provider4;
        this.f20854e = provider5;
    }

    public static w a(Provider<e.e.b.a.i.c0.a> provider, Provider<e.e.b.a.i.c0.a> provider2, Provider<e.e.b.a.i.b0.e> provider3, Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.u> provider4, Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.w> provider5) {
        return new w(provider, provider2, provider3, provider4, provider5);
    }

    public static u c(e.e.b.a.i.c0.a aVar, e.e.b.a.i.c0.a aVar2, e.e.b.a.i.b0.e eVar, com.google.android.datatransport.runtime.scheduling.jobscheduling.u uVar, com.google.android.datatransport.runtime.scheduling.jobscheduling.w wVar) {
        return new u(aVar, aVar2, eVar, uVar, wVar);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public u get() {
        return c(this.a.get(), this.f20851b.get(), this.f20852c.get(), this.f20853d.get(), this.f20854e.get());
    }
}
