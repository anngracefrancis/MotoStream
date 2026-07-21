package kotlin.reflect.y.internal.j0.i.q.a;

import java.util.Collection;
import java.util.List;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.l.t1.g;
import kotlin.reflect.y.internal.j0.l.t1.j;

/* JADX INFO: compiled from: CapturedTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements b {
    private final g1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f24355b;

    public c(g1 g1Var) {
        m.f(g1Var, "projection");
        this.a = g1Var;
        f().a();
        r1 r1Var = r1.INVARIANT;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public Collection<e0> a() {
        e0 type = f().a() == r1.OUT_VARIANCE ? f().getType() : o().I();
        m.e(type, "if (projection.projectio… builtIns.nullableAnyType");
        return t.e(type);
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    /* JADX INFO: renamed from: c */
    public /* bridge */ /* synthetic */ h w() {
        return (h) g();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public boolean e() {
        return false;
    }

    @Override // kotlin.reflect.y.internal.j0.i.q.a.b
    public g1 f() {
        return this.a;
    }

    public Void g() {
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public List<e1> getParameters() {
        return u.j();
    }

    public final j h() {
        return this.f24355b;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public c b(g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        g1 g1VarB = f().b(gVar);
        m.e(g1VarB, "projection.refine(kotlinTypeRefiner)");
        return new c(g1VarB);
    }

    public final void j(j jVar) {
        this.f24355b = jVar;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public kotlin.reflect.y.internal.j0.b.h o() {
        kotlin.reflect.y.internal.j0.b.h hVarO = f().getType().O0().o();
        m.e(hVarO, "projection.type.constructor.builtIns");
        return hVarO;
    }

    public String toString() {
        return "CapturedTypeConstructor(" + f() + ')';
    }
}
