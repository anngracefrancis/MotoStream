package kotlin.p002reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.i.w.o.f;

/* JADX INFO: compiled from: DescriptorVisibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class u {
    protected u() {
    }

    public final Integer a(u uVar) {
        m.f(uVar, "visibility");
        return b().a(uVar.b());
    }

    public abstract m1 b();

    public abstract String c();

    public final boolean d() {
        return b().c();
    }

    public abstract boolean e(f fVar, q qVar, m mVar, boolean z);

    public abstract u f();

    public final String toString() {
        return b().toString();
    }
}
