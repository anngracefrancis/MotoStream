package kotlin.reflect.y.internal.j0.d.a.o0;

import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.a;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.d.a.b;
import kotlin.reflect.y.internal.j0.d.a.d;
import kotlin.reflect.y.internal.j0.d.a.l0.g;
import kotlin.reflect.y.internal.j0.d.a.l0.l.e;
import kotlin.reflect.y.internal.j0.d.a.x;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.reflect.y.internal.j0.l.p1;
import kotlin.reflect.y.internal.j0.l.t1.q;
import kotlin.reflect.y.internal.j0.l.w1.i;
import kotlin.reflect.y.internal.j0.l.w1.o;
import kotlin.reflect.y.internal.j0.l.w1.r;

/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
final class n extends a<c> {
    private final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f23674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f23675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f23676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f23677e;

    public /* synthetic */ n(a aVar, boolean z, g gVar, b bVar, boolean z2, int i2, kotlin.jvm.internal.g gVar2) {
        this(aVar, z, gVar, bVar, (i2 & 16) != 0 ? false : z2);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o0.a
    public boolean A(i iVar) {
        m.f(iVar, "<this>");
        return ((e0) iVar).R0() instanceof g;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o0.a
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public d h() {
        return this.f23675c.a().a();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o0.a
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public e0 p(i iVar) {
        m.f(iVar, "<this>");
        return p1.a((e0) iVar);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o0.a
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public boolean r(c cVar) {
        m.f(cVar, "<this>");
        return ((cVar instanceof kotlin.reflect.y.internal.j0.d.a.k0.g) && ((kotlin.reflect.y.internal.j0.d.a.k0.g) cVar).g()) || ((cVar instanceof e) && !o() && (((e) cVar).k() || l() == b.TYPE_PARAMETER_BOUNDS));
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o0.a
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public r v() {
        return q.a;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o0.a
    public Iterable<c> i(i iVar) {
        m.f(iVar, "<this>");
        return ((e0) iVar).getAnnotations();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o0.a
    public Iterable<c> k() {
        kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g annotations;
        a aVar = this.a;
        return (aVar == null || (annotations = aVar.getAnnotations()) == null) ? u.j() : annotations;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o0.a
    public b l() {
        return this.f23676d;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o0.a
    public x m() {
        return this.f23675c.b();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o0.a
    public boolean n() {
        a aVar = this.a;
        return (aVar instanceof i1) && ((i1) aVar).l0() != null;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o0.a
    public boolean o() {
        return this.f23675c.a().q().c();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o0.a
    public kotlin.reflect.y.internal.j0.f.d s(i iVar) {
        m.f(iVar, "<this>");
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVarF = n1.f((e0) iVar);
        if (eVarF != null) {
            return kotlin.reflect.y.internal.j0.i.d.m(eVarF);
        }
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o0.a
    public boolean u() {
        return this.f23677e;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o0.a
    public boolean w(i iVar) {
        m.f(iVar, "<this>");
        return h.e0((e0) iVar);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o0.a
    public boolean x() {
        return this.f23674b;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o0.a
    public boolean y(i iVar, i iVar2) {
        m.f(iVar, "<this>");
        m.f(iVar2, "other");
        return this.f23675c.a().k().b((e0) iVar, (e0) iVar2);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o0.a
    public boolean z(o oVar) {
        m.f(oVar, "<this>");
        return oVar instanceof kotlin.reflect.y.internal.j0.d.a.l0.l.m;
    }

    public n(a aVar, boolean z, g gVar, b bVar, boolean z2) {
        m.f(gVar, "containerContext");
        m.f(bVar, "containerApplicabilityType");
        this.a = aVar;
        this.f23674b = z;
        this.f23675c = gVar;
        this.f23676d = bVar;
        this.f23677e = z2;
    }
}
