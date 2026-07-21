package kotlin.reflect.y.internal.j0.l;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.y.internal.j0.i.t.a;
import kotlin.reflect.y.internal.j0.k.n;

/* JADX INFO: compiled from: AbstractClassTypeConstructor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends g implements e1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(n nVar) {
        super(nVar);
        if (nVar == null) {
            v(0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x002f  */
    private static /* synthetic */ void v(int i2) {
        String str = (i2 == 1 || i2 == 3 || i2 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 1 || i2 == 3 || i2 == 4) ? 2 : 3];
        if (i2 == 1) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        } else if (i2 == 2) {
            objArr[0] = "classifier";
        } else if (i2 == 3 || i2 == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        } else {
            objArr[0] = "storageManager";
        }
        if (i2 == 1) {
            objArr[1] = "getBuiltIns";
        } else if (i2 == 3 || i2 == 4) {
            objArr[1] = "getAdditionalNeighboursInSupertypeGraph";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        }
        if (i2 != 1) {
            if (i2 == 2) {
                objArr[2] = "isSameClassifier";
            } else if (i2 != 3 && i2 != 4) {
                objArr[2] = "<init>";
            }
        }
        String str2 = String.format(str, objArr);
        if (i2 != 1 && i2 != 3 && i2 != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // kotlin.reflect.y.internal.j0.l.m
    protected boolean i(h hVar) {
        if (hVar == null) {
            v(2);
        }
        return (hVar instanceof e) && g(w(), hVar);
    }

    @Override // kotlin.reflect.y.internal.j0.l.g
    protected e0 m() {
        if (kotlin.reflect.y.internal.j0.b.h.t0(w())) {
            return null;
        }
        return o().i();
    }

    @Override // kotlin.reflect.y.internal.j0.l.g
    protected Collection<e0> n(boolean z) {
        m mVarB = w().b();
        if (!(mVarB instanceof e)) {
            List listEmptyList = Collections.emptyList();
            if (listEmptyList == null) {
                v(3);
            }
            return listEmptyList;
        }
        kotlin.p002reflect.jvm.internal.impl.utils.e eVar = new kotlin.p002reflect.jvm.internal.impl.utils.e();
        e eVar2 = (e) mVarB;
        eVar.add(eVar2.s());
        e eVarU = eVar2.U();
        if (z && eVarU != null) {
            eVar.add(eVarU.s());
        }
        return eVar;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public kotlin.reflect.y.internal.j0.b.h o() {
        kotlin.reflect.y.internal.j0.b.h hVarF = a.f(w());
        if (hVarF == null) {
            v(1);
        }
        return hVarF;
    }

    public abstract e w();
}
