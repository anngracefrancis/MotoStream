package kotlin.reflect.y.internal.j0.j.b.g0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.c0;
import kotlin.collections.t;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.p002reflect.jvm.internal.impl.descriptors.c1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.e.q;
import kotlin.reflect.y.internal.j0.e.s;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.j.b.a0;
import kotlin.reflect.y.internal.j0.j.b.d0;
import kotlin.reflect.y.internal.j0.j.b.x;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: DeserializedTypeParameterDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends b {
    private final kotlin.reflect.y.internal.j0.j.b.m p;
    private final s q;
    private final kotlin.reflect.y.internal.j0.j.b.g0.a r;

    /* JADX INFO: compiled from: DeserializedTypeParameterDescriptor.kt */
    static final class a extends Lambda implements Function0<List<? extends c>> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends c> invoke() {
            return c0.E0(m.this.p.c().d().a(m.this.P0(), m.this.p.g()));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public m(kotlin.reflect.y.internal.j0.j.b.m mVar, s sVar, int i2) {
        kotlin.jvm.internal.m.f(mVar, "c");
        kotlin.jvm.internal.m.f(sVar, "proto");
        n nVarH = mVar.h();
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarE = mVar.e();
        g gVarB = g.f25179c.b();
        f fVarB = x.b(mVar.g(), sVar.N());
        a0 a0Var = a0.a;
        s.c cVarT = sVar.T();
        kotlin.jvm.internal.m.e(cVarT, "proto.variance");
        super(nVarH, mVarE, gVarB, fVarB, a0Var.d(cVarT), sVar.O(), i2, z0.a, c1.a.a);
        this.p = mVar;
        this.q = sVar;
        this.r = new kotlin.reflect.y.internal.j0.j.b.g0.a(mVar.h(), new a());
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.e
    protected List<e0> M0() {
        List<q> listP = kotlin.reflect.y.internal.j0.e.z.f.p(this.q, this.p.j());
        if (listP.isEmpty()) {
            return t.e(kotlin.reflect.y.internal.j0.i.t.a.f(this).y());
        }
        d0 d0VarI = this.p.i();
        ArrayList arrayList = new ArrayList(v.u(listP, 10));
        Iterator<T> it = listP.iterator();
        while (it.hasNext()) {
            arrayList.add(d0VarI.q((q) it.next()));
        }
        return arrayList;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.b, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.a
    /* JADX INFO: renamed from: O0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.y.internal.j0.j.b.g0.a getAnnotations() {
        return this.r;
    }

    public final s P0() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.e
    /* JADX INFO: renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public Void L0(e0 e0Var) {
        kotlin.jvm.internal.m.f(e0Var, "type");
        throw new IllegalStateException("There should be no cycles for deserialized type parameters, but found for: " + this);
    }
}
