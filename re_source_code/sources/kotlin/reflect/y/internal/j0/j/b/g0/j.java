package kotlin.reflect.y.internal.j0.j.b.g0;

import kotlin.p002reflect.jvm.internal.impl.descriptors.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.c0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.e.n;
import kotlin.reflect.y.internal.j0.e.z.c;
import kotlin.reflect.y.internal.j0.e.z.g;
import kotlin.reflect.y.internal.j0.e.z.h;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends c0 implements b {
    private final n H;
    private final c I;
    private final g J;
    private final h K;
    private final f L;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(m mVar, t0 t0Var, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar, d0 d0Var, u uVar, boolean z, f fVar, b.a aVar, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, n nVar, c cVar, g gVar2, h hVar, f fVar2) {
        super(mVar, t0Var, gVar, d0Var, uVar, z, fVar, aVar, z0.a, z2, z3, z6, false, z4, z5);
        kotlin.jvm.internal.m.f(mVar, "containingDeclaration");
        kotlin.jvm.internal.m.f(gVar, "annotations");
        kotlin.jvm.internal.m.f(d0Var, "modality");
        kotlin.jvm.internal.m.f(uVar, "visibility");
        kotlin.jvm.internal.m.f(fVar, "name");
        kotlin.jvm.internal.m.f(aVar, "kind");
        kotlin.jvm.internal.m.f(nVar, "proto");
        kotlin.jvm.internal.m.f(cVar, "nameResolver");
        kotlin.jvm.internal.m.f(gVar2, "typeTable");
        kotlin.jvm.internal.m.f(hVar, "versionRequirementTable");
        this.H = nVar;
        this.I = cVar;
        this.J = gVar2;
        this.K = hVar;
        this.L = fVar2;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.c0
    protected c0 Q0(m mVar, d0 d0Var, u uVar, t0 t0Var, b.a aVar, f fVar, z0 z0Var) {
        kotlin.jvm.internal.m.f(mVar, "newOwner");
        kotlin.jvm.internal.m.f(d0Var, "newModality");
        kotlin.jvm.internal.m.f(uVar, "newVisibility");
        kotlin.jvm.internal.m.f(aVar, "kind");
        kotlin.jvm.internal.m.f(fVar, "newName");
        kotlin.jvm.internal.m.f(z0Var, "source");
        return new j(mVar, t0Var, getAnnotations(), d0Var, uVar, j0(), fVar, aVar, s0(), isConst(), z(), O(), M(), E(), Z(), T(), h1(), c0());
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.g0.g
    public g T() {
        return this.J;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.g0.g
    public c Z() {
        return this.I;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.g0.g
    public f c0() {
        return this.L;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.g0.g
    /* JADX INFO: renamed from: g1, reason: merged with bridge method [inline-methods] */
    public n E() {
        return this.H;
    }

    public h h1() {
        return this.K;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.c0, kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public boolean z() {
        Boolean boolD = kotlin.reflect.y.internal.j0.e.z.b.D.d(E().b0());
        kotlin.jvm.internal.m.e(boolD, "IS_EXTERNAL_PROPERTY.get(proto.flags)");
        return boolD.booleanValue();
    }
}
