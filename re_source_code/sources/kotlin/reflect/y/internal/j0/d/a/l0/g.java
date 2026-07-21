package kotlin.reflect.y.internal.j0.d.a.l0;

import kotlin.Lazy;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.y.internal.j0.d.a.l0.m.c;
import kotlin.reflect.y.internal.j0.d.a.x;
import kotlin.reflect.y.internal.j0.k.n;

/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    private final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f23467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy<x> f23468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f23469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c f23470e;

    public g(b bVar, k kVar, Lazy<x> lazy) {
        m.f(bVar, "components");
        m.f(kVar, "typeParameterResolver");
        m.f(lazy, "delegateForDefaultTypeQualifiers");
        this.a = bVar;
        this.f23467b = kVar;
        this.f23468c = lazy;
        this.f23469d = lazy;
        this.f23470e = new c(this, kVar);
    }

    public final b a() {
        return this.a;
    }

    public final x b() {
        return (x) this.f23469d.getValue();
    }

    public final Lazy<x> c() {
        return this.f23468c;
    }

    public final g0 d() {
        return this.a.m();
    }

    public final n e() {
        return this.a.u();
    }

    public final k f() {
        return this.f23467b;
    }

    public final c g() {
        return this.f23470e;
    }
}
