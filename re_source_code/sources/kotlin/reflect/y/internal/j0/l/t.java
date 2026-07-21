package kotlin.reflect.y.internal.j0.l;

import java.util.HashMap;
import java.util.List;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.k0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.l.x1.a;

/* JADX INFO: compiled from: DescriptorSubstitutor.java */
/* JADX INFO: loaded from: classes3.dex */
public class t {
    private static /* synthetic */ void a(int i2) {
        String str = i2 != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 4 ? 3 : 2];
        switch (i2) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i2 != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i2 != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String str2 = String.format(str, objArr);
        if (i2 == 4) {
            throw new IllegalStateException(str2);
        }
    }

    public static l1 b(List<e1> list, j1 j1Var, m mVar, List<e1> list2) {
        if (list == null) {
            a(0);
        }
        if (j1Var == null) {
            a(1);
        }
        if (mVar == null) {
            a(2);
        }
        if (list2 == null) {
            a(3);
        }
        l1 l1VarC = c(list, j1Var, mVar, list2, null);
        if (l1VarC != null) {
            return l1VarC;
        }
        throw new AssertionError("Substitution failed");
    }

    public static l1 c(List<e1> list, j1 j1Var, m mVar, List<e1> list2, boolean[] zArr) {
        if (list == null) {
            a(5);
        }
        if (j1Var == null) {
            a(6);
        }
        if (mVar == null) {
            a(7);
        }
        if (list2 == null) {
            a(8);
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        int i2 = 0;
        for (e1 e1Var : list) {
            k0 k0VarR0 = k0.R0(mVar, e1Var.getAnnotations(), e1Var.F(), e1Var.n(), e1Var.getName(), i2, z0.a, e1Var.h0());
            map.put(e1Var.h(), new i1(k0VarR0.s()));
            map2.put(e1Var, k0VarR0);
            list2.add(k0VarR0);
            i2++;
        }
        f1 f1VarJ = f1.j(map);
        l1 l1VarH = l1.h(j1Var, f1VarJ);
        l1 l1VarH2 = l1.h(j1Var.h(), f1VarJ);
        for (e1 e1Var2 : list) {
            k0 k0Var = (k0) map2.get(e1Var2);
            for (e0 e0Var : e1Var2.getUpperBounds()) {
                h hVarW = e0Var.O0().w();
                e0 e0VarP = (((hVarW instanceof e1) && a.j((e1) hVarW)) ? l1VarH : l1VarH2).p(e0Var, r1.OUT_VARIANCE);
                if (e0VarP == null) {
                    return null;
                }
                if (e0VarP != e0Var && zArr != null) {
                    zArr[0] = true;
                }
                k0Var.N0(e0VarP);
            }
            k0Var.W0();
        }
        return l1VarH;
    }
}
