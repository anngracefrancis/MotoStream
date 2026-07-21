package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.k0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.o;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.c;

/* JADX INFO: compiled from: PackageFragmentDescriptorImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class z extends k implements k0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final c f25306j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f25307k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(g0 g0Var, c cVar) {
        super(g0Var, g.f25179c.b(), cVar.h(), z0.a);
        m.f(g0Var, "module");
        m.f(cVar, "fqName");
        this.f25306j = cVar;
        this.f25307k = "package " + cVar + " of " + g0Var;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(o<R, D> oVar, D d2) {
        m.f(oVar, "visitor");
        return oVar.f(this, d2);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.k0
    public final c d() {
        return this.f25306j;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.k, kotlin.p002reflect.jvm.internal.impl.descriptors.p
    public z0 t() {
        z0 z0Var = z0.a;
        m.e(z0Var, "NO_SOURCE");
        return z0Var;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.j
    public String toString() {
        return this.f25307k;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.k, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public g0 b() {
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = super.b();
        m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
        return (g0) mVarB;
    }
}
