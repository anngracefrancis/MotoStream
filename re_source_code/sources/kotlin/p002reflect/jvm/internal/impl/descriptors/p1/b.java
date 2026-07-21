package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import kotlin.p002reflect.jvm.internal.impl.descriptors.c1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.r1;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AbstractLazyTypeParameterDescriptor.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends e {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(n nVar, m mVar, g gVar, f fVar, r1 r1Var, boolean z, int i2, z0 z0Var, c1 c1Var) {
        super(nVar, mVar, gVar, fVar, r1Var, z, i2, z0Var, c1Var);
        if (nVar == null) {
            v(0);
        }
        if (mVar == null) {
            v(1);
        }
        if (gVar == null) {
            v(2);
        }
        if (fVar == null) {
            v(3);
        }
        if (r1Var == null) {
            v(4);
        }
        if (z0Var == null) {
            v(5);
        }
        if (c1Var == null) {
            v(6);
        }
    }

    private static /* synthetic */ void v(int i2) {
        Object[] objArr = new Object[3];
        switch (i2) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        objArr[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.j
    public String toString() {
        Object[] objArr = new Object[3];
        boolean zF = F();
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        objArr[0] = zF ? "reified " : HttpUrl.FRAGMENT_ENCODE_SET;
        if (n() != r1.INVARIANT) {
            str = n() + " ";
        }
        objArr[1] = str;
        objArr[2] = getName();
        return String.format("%s%s%s", objArr);
    }
}
