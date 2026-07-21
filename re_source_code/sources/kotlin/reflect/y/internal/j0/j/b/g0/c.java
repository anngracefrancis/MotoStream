package kotlin.reflect.y.internal.j0.j.b.g0;

import kotlin.p002reflect.jvm.internal.impl.descriptors.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.l;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.f;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.e.d;
import kotlin.reflect.y.internal.j0.e.z.g;
import kotlin.reflect.y.internal.j0.e.z.h;

/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends f implements b {
    private final d K;
    private final kotlin.reflect.y.internal.j0.e.z.c L;
    private final g M;
    private final h N;
    private final f O;

    public /* synthetic */ c(e eVar, l lVar, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar, boolean z, b.a aVar, d dVar, kotlin.reflect.y.internal.j0.e.z.c cVar, g gVar2, h hVar, f fVar, z0 z0Var, int i2, kotlin.jvm.internal.g gVar3) {
        this(eVar, lVar, gVar, z, aVar, dVar, cVar, gVar2, hVar, fVar, (i2 & 1024) != 0 ? null : z0Var);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p, kotlin.p002reflect.jvm.internal.impl.descriptors.y
    public boolean P() {
        return false;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.g0.g
    public g T() {
        return this.M;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.g0.g
    public kotlin.reflect.y.internal.j0.e.z.c Z() {
        return this.L;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.g0.g
    public f c0() {
        return this.O;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p, kotlin.p002reflect.jvm.internal.impl.descriptors.y
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p, kotlin.p002reflect.jvm.internal.impl.descriptors.y
    public boolean isSuspend() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.f
    /* JADX INFO: renamed from: t1, reason: merged with bridge method [inline-methods] */
    public c M0(m mVar, y yVar, b.a aVar, kotlin.reflect.y.internal.j0.f.f fVar, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar, z0 z0Var) {
        kotlin.jvm.internal.m.f(mVar, "newOwner");
        kotlin.jvm.internal.m.f(aVar, "kind");
        kotlin.jvm.internal.m.f(gVar, "annotations");
        kotlin.jvm.internal.m.f(z0Var, "source");
        c cVar = new c((e) mVar, (l) yVar, gVar, this.J, aVar, E(), Z(), T(), v1(), c0(), z0Var);
        cVar.Z0(R0());
        return cVar;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.g0.g
    /* JADX INFO: renamed from: u1, reason: merged with bridge method [inline-methods] */
    public d E() {
        return this.K;
    }

    public h v1() {
        return this.N;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p, kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public boolean z() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar, l lVar, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar, boolean z, b.a aVar, d dVar, kotlin.reflect.y.internal.j0.e.z.c cVar, g gVar2, h hVar, f fVar, z0 z0Var) {
        super(eVar, lVar, gVar, z, aVar, z0Var == null ? z0.a : z0Var);
        kotlin.jvm.internal.m.f(eVar, "containingDeclaration");
        kotlin.jvm.internal.m.f(gVar, "annotations");
        kotlin.jvm.internal.m.f(aVar, "kind");
        kotlin.jvm.internal.m.f(dVar, "proto");
        kotlin.jvm.internal.m.f(cVar, "nameResolver");
        kotlin.jvm.internal.m.f(gVar2, "typeTable");
        kotlin.jvm.internal.m.f(hVar, "versionRequirementTable");
        this.K = dVar;
        this.L = cVar;
        this.M = gVar2;
        this.N = hVar;
        this.O = fVar;
    }
}
