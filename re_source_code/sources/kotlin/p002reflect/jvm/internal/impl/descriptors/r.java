package kotlin.p002reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: DescriptorVisibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class r extends u {
    private final m1 a;

    public r(m1 m1Var) {
        m.f(m1Var, "delegate");
        this.a = m1Var;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.u
    public m1 b() {
        return this.a;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.u
    public String c() {
        return b().b();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.u
    public u f() {
        u uVarJ = t.j(b().d());
        m.e(uVarJ, "toDescriptorVisibility(delegate.normalize())");
        return uVarJ;
    }
}
