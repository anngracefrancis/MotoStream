package kotlin.reflect.y.internal.j0.i.v;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.m0;

/* JADX INFO: compiled from: SamConversionResolverImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements a {
    private final Iterable<Object> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.b<e, m0> f24396b;

    public b(n nVar, Iterable<? extends Object> iterable) {
        m.f(nVar, "storageManager");
        m.f(iterable, "samWithReceiverResolvers");
        this.a = iterable;
        this.f24396b = nVar.a();
    }
}
