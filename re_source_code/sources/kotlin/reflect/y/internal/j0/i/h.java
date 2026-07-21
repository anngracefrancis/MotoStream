package kotlin.reflect.y.internal.j0.i;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.b;

/* JADX INFO: compiled from: OverridingStrategy.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h extends i {
    @Override // kotlin.reflect.y.internal.j0.i.i
    public void b(b bVar, b bVar2) {
        m.f(bVar, "first");
        m.f(bVar2, "second");
        e(bVar, bVar2);
    }

    @Override // kotlin.reflect.y.internal.j0.i.i
    public void c(b bVar, b bVar2) {
        m.f(bVar, "fromSuper");
        m.f(bVar2, "fromCurrent");
        e(bVar, bVar2);
    }

    protected abstract void e(b bVar, b bVar2);
}
