package kotlin.reflect.y.internal.j0.l;

import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
final class o0 extends s {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a1 f24770h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(m0 m0Var, a1 a1Var) {
        super(m0Var);
        m.f(m0Var, "delegate");
        m.f(a1Var, "attributes");
        this.f24770h = a1Var;
    }

    @Override // kotlin.reflect.y.internal.j0.l.r, kotlin.reflect.y.internal.j0.l.e0
    public a1 N0() {
        return this.f24770h;
    }

    @Override // kotlin.reflect.y.internal.j0.l.r
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public o0 Z0(m0 m0Var) {
        m.f(m0Var, "delegate");
        return new o0(m0Var, N0());
    }
}
