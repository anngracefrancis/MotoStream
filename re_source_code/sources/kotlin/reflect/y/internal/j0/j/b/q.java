package kotlin.reflect.y.internal.j0.j.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.e.l;
import kotlin.reflect.y.internal.j0.e.m;
import kotlin.reflect.y.internal.j0.e.o;
import kotlin.reflect.y.internal.j0.e.p;
import kotlin.reflect.y.internal.j0.e.z.d;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.j.b.g0.f;
import kotlin.reflect.y.internal.j0.j.b.g0.i;
import kotlin.reflect.y.internal.j0.k.n;

/* JADX INFO: compiled from: DeserializedPackageFragmentImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q extends p {
    private final kotlin.reflect.y.internal.j0.e.z.a m;
    private final f n;
    private final d o;
    private final y p;
    private m q;
    private h r;

    /* JADX INFO: compiled from: DeserializedPackageFragmentImpl.kt */
    static final class a extends Lambda implements Function1<kotlin.reflect.y.internal.j0.f.b, z0> {
        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final z0 invoke(kotlin.reflect.y.internal.j0.f.b bVar) {
            kotlin.jvm.internal.m.f(bVar, "it");
            f fVar = q.this.n;
            if (fVar != null) {
                return fVar;
            }
            z0 z0Var = z0.a;
            kotlin.jvm.internal.m.e(z0Var, "NO_SOURCE");
            return z0Var;
        }
    }

    /* JADX INFO: compiled from: DeserializedPackageFragmentImpl.kt */
    static final class b extends Lambda implements Function0<Collection<? extends kotlin.reflect.y.internal.j0.f.f>> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Collection<kotlin.reflect.y.internal.j0.f.f> invoke() {
            Collection<kotlin.reflect.y.internal.j0.f.b> collectionB = q.this.A0().b();
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionB) {
                kotlin.reflect.y.internal.j0.f.b bVar = (kotlin.reflect.y.internal.j0.f.b) obj;
                if ((bVar.l() || i.a.a().contains(bVar)) ? false : true) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(v.u(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((kotlin.reflect.y.internal.j0.f.b) it.next()).j());
            }
            return arrayList2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(c cVar, n nVar, g0 g0Var, m mVar, kotlin.reflect.y.internal.j0.e.z.a aVar, f fVar) {
        super(cVar, nVar, g0Var);
        kotlin.jvm.internal.m.f(cVar, "fqName");
        kotlin.jvm.internal.m.f(nVar, "storageManager");
        kotlin.jvm.internal.m.f(g0Var, "module");
        kotlin.jvm.internal.m.f(mVar, "proto");
        kotlin.jvm.internal.m.f(aVar, "metadataVersion");
        this.m = aVar;
        this.n = fVar;
        p pVarO = mVar.O();
        kotlin.jvm.internal.m.e(pVarO, "proto.strings");
        o oVarN = mVar.N();
        kotlin.jvm.internal.m.e(oVarN, "proto.qualifiedNames");
        d dVar = new d(pVarO, oVarN);
        this.o = dVar;
        this.p = new y(mVar, dVar, aVar, new a());
        this.q = mVar;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.p
    public void M0(k kVar) {
        kotlin.jvm.internal.m.f(kVar, "components");
        m mVar = this.q;
        if (mVar == null) {
            throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
        }
        this.q = null;
        l lVarM = mVar.M();
        kotlin.jvm.internal.m.e(lVarM, "proto.`package`");
        this.r = new i(this, lVarM, this.o, this.m, this.n, kVar, "scope of " + this, new b());
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.p
    /* JADX INFO: renamed from: O0, reason: merged with bridge method [inline-methods] */
    public y A0() {
        return this.p;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.k0
    public h q() {
        h hVar = this.r;
        if (hVar != null) {
            return hVar;
        }
        kotlin.jvm.internal.m.w("_memberScope");
        return null;
    }
}
