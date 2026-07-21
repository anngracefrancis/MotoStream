package kotlin.reflect.y.internal.j0.l;

import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.y.internal.j0.i.d;
import kotlin.reflect.y.internal.j0.l.u1.k;

/* JADX INFO: compiled from: ClassifierBasedTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m implements e1 {
    private int a;

    private final boolean h(h hVar) {
        return (k.m(hVar) || d.E(hVar)) ? false : true;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    /* JADX INFO: renamed from: c */
    public abstract h w();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e1) || obj.hashCode() != hashCode()) {
            return false;
        }
        e1 e1Var = (e1) obj;
        if (e1Var.getParameters().size() != getParameters().size()) {
            return false;
        }
        h hVarW = w();
        h hVarW2 = e1Var.w();
        if (hVarW2 != null && h(hVarW) && h(hVarW2)) {
            return i(hVarW2);
        }
        return false;
    }

    protected final boolean g(h hVar, h hVar2) {
        kotlin.jvm.internal.m.f(hVar, "first");
        kotlin.jvm.internal.m.f(hVar2, "second");
        if (!kotlin.jvm.internal.m.a(hVar.getName(), hVar2.getName())) {
            return false;
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = hVar.b();
        for (kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB2 = hVar2.b(); mVarB != null && mVarB2 != null; mVarB2 = mVarB2.b()) {
            if (mVarB instanceof g0) {
                return mVarB2 instanceof g0;
            }
            if (mVarB2 instanceof g0) {
                return false;
            }
            if (mVarB instanceof k0) {
                return (mVarB2 instanceof k0) && kotlin.jvm.internal.m.a(((k0) mVarB).d(), ((k0) mVarB2).d());
            }
            if ((mVarB2 instanceof k0) || !kotlin.jvm.internal.m.a(mVarB.getName(), mVarB2.getName())) {
                return false;
            }
            mVarB = mVarB.b();
        }
        return true;
    }

    public int hashCode() {
        int i2 = this.a;
        if (i2 != 0) {
            return i2;
        }
        h hVarW = w();
        int iHashCode = h(hVarW) ? d.m(hVarW).hashCode() : System.identityHashCode(this);
        this.a = iHashCode;
        return iHashCode;
    }

    protected abstract boolean i(h hVar);
}
