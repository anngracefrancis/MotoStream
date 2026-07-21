package kotlin.reflect.y.internal.j0.d.a.l0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.t;
import kotlin.collections.v;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.d.a.j0.k;
import kotlin.reflect.y.internal.j0.d.a.l0.d;
import kotlin.reflect.y.internal.j0.d.a.l0.g;
import kotlin.reflect.y.internal.j0.d.a.n0.j;
import kotlin.reflect.y.internal.j0.d.a.n0.y;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.r1;

/* JADX INFO: compiled from: LazyJavaTypeParameterDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m extends b {
    private final g p;
    private final y q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(g gVar, y yVar, int i2, kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
        super(gVar.e(), mVar, new d(gVar, yVar, false, 4, null), yVar.getName(), r1.INVARIANT, false, i2, z0.a, gVar.a().v());
        kotlin.jvm.internal.m.f(gVar, "c");
        kotlin.jvm.internal.m.f(yVar, "javaTypeParameter");
        kotlin.jvm.internal.m.f(mVar, "containingDeclaration");
        this.p = gVar;
        this.q = yVar;
    }

    private final List<e0> N0() {
        Collection<j> upperBounds = this.q.getUpperBounds();
        if (upperBounds.isEmpty()) {
            m0 m0VarI = this.p.d().o().i();
            kotlin.jvm.internal.m.e(m0VarI, "c.module.builtIns.anyType");
            m0 m0VarI2 = this.p.d().o().I();
            kotlin.jvm.internal.m.e(m0VarI2, "c.module.builtIns.nullableAnyType");
            return t.e(f0.d(m0VarI, m0VarI2));
        }
        ArrayList arrayList = new ArrayList(v.u(upperBounds, 10));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(this.p.g().o((j) it.next(), kotlin.reflect.y.internal.j0.d.a.l0.m.d.d(k.COMMON, false, this, 1, null)));
        }
        return arrayList;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.e
    protected List<e0> A0(List<? extends e0> list) {
        kotlin.jvm.internal.m.f(list, "bounds");
        return this.p.a().r().i(this, list, this.p);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.e
    protected void L0(e0 e0Var) {
        kotlin.jvm.internal.m.f(e0Var, "type");
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.e
    protected List<e0> M0() {
        return N0();
    }
}
