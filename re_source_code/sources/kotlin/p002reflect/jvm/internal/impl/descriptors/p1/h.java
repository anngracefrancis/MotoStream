package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.f;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.l;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.t1.g;

/* JADX INFO: compiled from: ClassDescriptorImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends g {
    private final d0 n;
    private final f o;
    private final e1 p;
    private kotlin.reflect.y.internal.j0.i.w.h q;
    private Set<d> r;
    private d s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(m mVar, kotlin.reflect.y.internal.j0.f.f fVar, d0 d0Var, f fVar2, Collection<e0> collection, z0 z0Var, boolean z, n nVar) {
        super(nVar, mVar, fVar, z0Var, z);
        if (mVar == null) {
            K(0);
        }
        if (fVar == null) {
            K(1);
        }
        if (d0Var == null) {
            K(2);
        }
        if (fVar2 == null) {
            K(3);
        }
        if (collection == null) {
            K(4);
        }
        if (z0Var == null) {
            K(5);
        }
        if (nVar == null) {
            K(6);
        }
        this.n = d0Var;
        this.o = fVar2;
        this.p = new l(this, Collections.emptyList(), collection, nVar);
    }

    private static /* synthetic */ void K(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                i3 = 2;
                break;
            case 12:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "supertypes";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 8:
                objArr[0] = "constructors";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 12:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 9:
                objArr[1] = "getAnnotations";
                break;
            case 10:
                objArr[1] = "getTypeConstructor";
                break;
            case 11:
                objArr[1] = "getConstructors";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 14:
                objArr[1] = "getStaticScope";
                break;
            case 15:
                objArr[1] = "getKind";
                break;
            case 16:
                objArr[1] = "getModality";
                break;
            case 17:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i2) {
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                break;
            case 12:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public boolean A() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public boolean D() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public boolean E0() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.t
    public kotlin.reflect.y.internal.j0.i.w.h H(g gVar) {
        if (gVar == null) {
            K(12);
        }
        kotlin.reflect.y.internal.j0.i.w.h hVar = this.q;
        if (hVar == null) {
            K(13);
        }
        return hVar;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public Collection<e> J() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            K(19);
        }
        return listEmptyList;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public boolean J0() {
        return false;
    }

    public final void L0(kotlin.reflect.y.internal.j0.i.w.h hVar, Set<d> set, d dVar) {
        if (hVar == null) {
            K(7);
        }
        if (set == null) {
            K(8);
        }
        this.q = hVar;
        this.r = set;
        this.s = dVar;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public boolean M() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public d R() {
        return this.s;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.y.internal.j0.i.w.h S() {
        kotlin.f0.y.e.j0.i.w.h.b bVar = kotlin.f0.y.e.j0.i.w.h.b.f24422b;
        if (bVar == null) {
            K(14);
        }
        return bVar;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public e U() {
        return null;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.a
    public kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g getAnnotations() {
        kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVarB = kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b();
        if (gVarB == null) {
            K(9);
        }
        return gVarB;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e, kotlin.p002reflect.jvm.internal.impl.descriptors.q, kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public u getVisibility() {
        u uVar = t.f25368e;
        if (uVar == null) {
            K(17);
        }
        return uVar;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.h
    public e1 h() {
        e1 e1Var = this.p;
        if (e1Var == null) {
            K(10);
        }
        return e1Var;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public f i() {
        f fVar = this.o;
        if (fVar == null) {
            K(15);
        }
        return fVar;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e, kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public d0 j() {
        d0 d0Var = this.n;
        if (d0Var == null) {
            K(16);
        }
        return d0Var;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public Collection<d> k() {
        Set<d> set = this.r;
        if (set == null) {
            K(11);
        }
        return set;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public boolean l() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.i
    public boolean m() {
        return false;
    }

    public String toString() {
        return "class " + getName();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e, kotlin.p002reflect.jvm.internal.impl.descriptors.i
    public List<kotlin.p002reflect.jvm.internal.impl.descriptors.e1> w() {
        List<kotlin.p002reflect.jvm.internal.impl.descriptors.e1> listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            K(18);
        }
        return listEmptyList;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public g1<m0> z0() {
        return null;
    }
}
