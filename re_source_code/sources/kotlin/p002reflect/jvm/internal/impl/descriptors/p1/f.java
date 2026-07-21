package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.p002reflect.jvm.internal.impl.descriptors.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.l;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.o;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.h;
import kotlin.reflect.y.internal.j0.l.l1;

/* JADX INFO: compiled from: ClassConstructorDescriptorImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends p implements d {
    protected final boolean J;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected f(e eVar, l lVar, g gVar, boolean z, b.a aVar, z0 z0Var) {
        super(eVar, lVar, gVar, h.f24223i, aVar, z0Var);
        if (eVar == null) {
            v(0);
        }
        if (gVar == null) {
            v(1);
        }
        if (aVar == null) {
            v(2);
        }
        if (z0Var == null) {
            v(3);
        }
        this.J = z;
    }

    private List<w0> l1() {
        e eVarB = b();
        if (eVarB.F0().isEmpty()) {
            List<w0> listEmptyList = Collections.emptyList();
            if (listEmptyList == null) {
                v(16);
            }
            return listEmptyList;
        }
        List<w0> listF0 = eVarB.F0();
        if (listF0 == null) {
            v(15);
        }
        return listF0;
    }

    public static f o1(e eVar, g gVar, boolean z, z0 z0Var) {
        if (eVar == null) {
            v(4);
        }
        if (gVar == null) {
            v(5);
        }
        if (z0Var == null) {
            v(6);
        }
        return new f(eVar, null, gVar, z, b.a.DECLARATION, z0Var);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001a  */
    /* JADX WARN: Code duplicated, block: B:7:0x000e  */
    private static /* synthetic */ void v(int i2) {
        String str;
        int i3;
        if (i2 != 21 && i2 != 27) {
            switch (i2) {
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i2 != 21 && i2 != 27) {
            switch (i2) {
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    i3 = 2;
                    break;
                default:
                    i3 = 3;
                    break;
            }
        } else {
            i3 = 2;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 5:
            case 8:
            case 25:
                objArr[0] = "annotations";
                break;
            case 2:
            case 24:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 9:
            case 26:
                objArr[0] = "source";
                break;
            case 4:
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 13:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 11:
            case 14:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "typeParameterDescriptors";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 27:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
                break;
            case 20:
                objArr[0] = "originalSubstitutor";
                break;
            case 22:
                objArr[0] = "overriddenDescriptors";
                break;
            case 23:
                objArr[0] = "newOwner";
                break;
        }
        if (i2 == 21) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i2 != 27) {
            switch (i2) {
                case 15:
                case 16:
                    objArr[1] = "calculateContextReceiverParameters";
                    break;
                case 17:
                    objArr[1] = "getContainingDeclaration";
                    break;
                case 18:
                    objArr[1] = "getConstructedClass";
                    break;
                case 19:
                    objArr[1] = "getOriginal";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
                    break;
            }
        } else {
            objArr[1] = "copy";
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "create";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSynthesized";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                objArr[2] = "initialize";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 27:
                break;
            case 20:
                objArr[2] = "substitute";
                break;
            case 22:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 23:
            case 24:
            case 25:
            case 26:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 21 && i2 != 27) {
            switch (i2) {
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.l
    public boolean B() {
        return this.J;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.l
    public e C() {
        e eVarB = b();
        if (eVarB == null) {
            v(18);
        }
        return eVarB;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(o<R, D> oVar, D d2) {
        return oVar.h(this, d2);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p, kotlin.p002reflect.jvm.internal.impl.descriptors.y, kotlin.p002reflect.jvm.internal.impl.descriptors.b, kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public Collection<? extends y> e() {
        Set setEmptySet = Collections.emptySet();
        if (setEmptySet == null) {
            v(21);
        }
        return setEmptySet;
    }

    public w0 m1() {
        e eVarB = b();
        if (!eVarB.m()) {
            return null;
        }
        m mVarB = eVarB.b();
        if (mVarB instanceof e) {
            return ((e) mVarB).K0();
        }
        return null;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p, kotlin.p002reflect.jvm.internal.impl.descriptors.b
    /* JADX INFO: renamed from: n1, reason: merged with bridge method [inline-methods] */
    public d k0(m mVar, d0 d0Var, u uVar, b.a aVar, boolean z) {
        d dVar = (d) super.k0(mVar, d0Var, uVar, aVar, z);
        if (dVar == null) {
            v(27);
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p
    /* JADX INFO: renamed from: p1, reason: merged with bridge method [inline-methods] */
    public f M0(m mVar, y yVar, b.a aVar, kotlin.reflect.y.internal.j0.f.f fVar, g gVar, z0 z0Var) {
        if (mVar == null) {
            v(23);
        }
        if (aVar == null) {
            v(24);
        }
        if (gVar == null) {
            v(25);
        }
        if (z0Var == null) {
            v(26);
        }
        b.a aVar2 = b.a.DECLARATION;
        if (aVar == aVar2 || aVar == b.a.SYNTHESIZED) {
            return new f((e) mVar, this, gVar, this.J, aVar2, z0Var);
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + mVar + "\nkind: " + aVar);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.k, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    /* JADX INFO: renamed from: q1, reason: merged with bridge method [inline-methods] */
    public e b() {
        e eVar = (e) super.b();
        if (eVar == null) {
            v(17);
        }
        return eVar;
    }

    public f r1(List<i1> list, u uVar) {
        if (list == null) {
            v(13);
        }
        if (uVar == null) {
            v(14);
        }
        s1(list, uVar, b().w());
        return this;
    }

    public f s1(List<i1> list, u uVar, List<e1> list2) {
        if (list == null) {
            v(10);
        }
        if (uVar == null) {
            v(11);
        }
        if (list2 == null) {
            v(12);
        }
        super.S0(null, m1(), l1(), list2, list, null, d0.FINAL, uVar);
        return this;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p, kotlin.p002reflect.jvm.internal.impl.descriptors.b
    public void x0(Collection<? extends b> collection) {
        if (collection == null) {
            v(22);
        }
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p, kotlin.p002reflect.jvm.internal.impl.descriptors.y, kotlin.p002reflect.jvm.internal.impl.descriptors.b1
    public d c(l1 l1Var) {
        if (l1Var == null) {
            v(20);
        }
        return (d) super.c(l1Var);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p, kotlin.p002reflect.jvm.internal.impl.descriptors.p1.k, kotlin.p002reflect.jvm.internal.impl.descriptors.p1.j, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public d a() {
        d dVar = (d) super.a();
        if (dVar == null) {
            v(19);
        }
        return dVar;
    }
}
