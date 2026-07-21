package kotlin.reflect.y.internal.j0.b.q;

import java.util.Collection;
import kotlin.collections.u;
import kotlin.collections.v0;
import kotlin.collections.w0;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.i.t.a;

/* JADX INFO: compiled from: JavaToKotlinClassMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final d a = new d();

    private d() {
    }

    public static /* synthetic */ e f(d dVar, c cVar, h hVar, Integer num, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = null;
        }
        return dVar.e(cVar, hVar, num);
    }

    public final e a(e eVar) {
        m.f(eVar, "mutable");
        c cVarO = c.a.o(kotlin.reflect.y.internal.j0.i.d.m(eVar));
        if (cVarO != null) {
            e eVarO = a.f(eVar).o(cVarO);
            m.e(eVarO, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
            return eVarO;
        }
        throw new IllegalArgumentException("Given class " + eVar + " is not a mutable collection");
    }

    public final e b(e eVar) {
        m.f(eVar, "readOnly");
        c cVarP = c.a.p(kotlin.reflect.y.internal.j0.i.d.m(eVar));
        if (cVarP != null) {
            e eVarO = a.f(eVar).o(cVarP);
            m.e(eVarO, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
            return eVarO;
        }
        throw new IllegalArgumentException("Given class " + eVar + " is not a read-only collection");
    }

    public final boolean c(e eVar) {
        m.f(eVar, "mutable");
        return c.a.k(kotlin.reflect.y.internal.j0.i.d.m(eVar));
    }

    public final boolean d(e eVar) {
        m.f(eVar, "readOnly");
        return c.a.l(kotlin.reflect.y.internal.j0.i.d.m(eVar));
    }

    public final e e(c cVar, h hVar, Integer num) {
        m.f(cVar, "fqName");
        m.f(hVar, "builtIns");
        b bVarM = (num == null || !m.a(cVar, c.a.h())) ? c.a.m(cVar) : k.a(num.intValue());
        if (bVarM != null) {
            return hVar.o(bVarM.b());
        }
        return null;
    }

    public final Collection<e> g(c cVar, h hVar) {
        m.f(cVar, "fqName");
        m.f(hVar, "builtIns");
        e eVarF = f(this, cVar, hVar, null, 4, null);
        if (eVarF == null) {
            return w0.d();
        }
        c cVarP = c.a.p(a.i(eVarF));
        if (cVarP == null) {
            return v0.c(eVarF);
        }
        e eVarO = hVar.o(cVarP);
        m.e(eVarO, "builtIns.getBuiltInClass…otlinMutableAnalogFqName)");
        return u.m(eVarF, eVarO);
    }
}
