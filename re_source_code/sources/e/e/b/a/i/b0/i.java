package e.e.b.a.i.b0;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.t;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.y;
import e.e.b.a.i.b0.j.j0;
import javax.inject.Provider;

/* JADX INFO: compiled from: SchedulingModule_WorkSchedulerFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements e.e.b.a.i.x.a.b<y> {
    private final Provider<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider<j0> f20759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider<t> f20760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Provider<e.e.b.a.i.c0.a> f20761d;

    public i(Provider<Context> provider, Provider<j0> provider2, Provider<t> provider3, Provider<e.e.b.a.i.c0.a> provider4) {
        this.a = provider;
        this.f20759b = provider2;
        this.f20760c = provider3;
        this.f20761d = provider4;
    }

    public static i a(Provider<Context> provider, Provider<j0> provider2, Provider<t> provider3, Provider<e.e.b.a.i.c0.a> provider4) {
        return new i(provider, provider2, provider3, provider4);
    }

    public static y c(Context context, j0 j0Var, t tVar, e.e.b.a.i.c0.a aVar) {
        return (y) e.e.b.a.i.x.a.d.c(h.a(context, j0Var, tVar, aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public y get() {
        return c(this.a.get(), this.f20759b.get(), this.f20760c.get(), this.f20761d.get());
    }
}
