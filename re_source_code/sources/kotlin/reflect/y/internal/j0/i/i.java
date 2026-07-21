package kotlin.reflect.y.internal.j0.i;

import java.util.Collection;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.b;

/* JADX INFO: compiled from: OverridingStrategy.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i {
    public abstract void a(b bVar);

    public abstract void b(b bVar, b bVar2);

    public abstract void c(b bVar, b bVar2);

    public void d(b bVar, Collection<? extends b> collection) {
        m.f(bVar, "member");
        m.f(collection, "overridden");
        bVar.x0(collection);
    }
}
