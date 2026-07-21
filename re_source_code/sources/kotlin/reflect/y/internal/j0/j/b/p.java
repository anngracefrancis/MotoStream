package kotlin.reflect.y.internal.j0.j.b;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.z;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.k.n;

/* JADX INFO: compiled from: DeserializedPackageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p extends z {
    private final n l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(c cVar, n nVar, g0 g0Var) {
        super(g0Var, cVar);
        m.f(cVar, "fqName");
        m.f(nVar, "storageManager");
        m.f(g0Var, "module");
        this.l = nVar;
    }

    public abstract h A0();

    public boolean L0(f fVar) {
        m.f(fVar, "name");
        h hVarQ = q();
        return (hVarQ instanceof kotlin.reflect.y.internal.j0.j.b.g0.h) && ((kotlin.reflect.y.internal.j0.j.b.g0.h) hVarQ).q().contains(fVar);
    }

    public abstract void M0(k kVar);
}
