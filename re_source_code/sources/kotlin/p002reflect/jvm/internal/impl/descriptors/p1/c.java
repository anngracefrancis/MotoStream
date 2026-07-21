package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.p002reflect.jvm.internal.impl.descriptors.a;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.o;
import kotlin.p002reflect.jvm.internal.impl.descriptors.q0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.h;
import kotlin.reflect.y.internal.j0.i.w.o.i;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.l1;
import kotlin.reflect.y.internal.j0.l.r1;

/* JADX INFO: compiled from: AbstractReceiverParameterDescriptor.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends j implements w0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(g gVar) {
        super(gVar, h.f24222h);
        if (gVar == null) {
            v(0);
        }
    }

    private static /* synthetic */ void v(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "substitutor";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        switch (i2) {
            case 2:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 3:
                objArr[1] = "getTypeParameters";
                break;
            case 4:
                objArr[1] = "getType";
                break;
            case 5:
                objArr[1] = "getValueParameters";
                break;
            case 6:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 7:
                objArr[1] = "getVisibility";
                break;
            case 8:
                objArr[1] = "getOriginal";
                break;
            case 9:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
        }
        switch (i2) {
            case 1:
                objArr[2] = "substitute";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public boolean G() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.j, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public q0 a() {
        return this;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(o<R, D> oVar, D d2) {
        return oVar.l(this, d2);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public Collection<? extends a> e() {
        Set setEmptySet = Collections.emptySet();
        if (setEmptySet == null) {
            v(6);
        }
        return setEmptySet;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public List<i1> f() {
        List<i1> listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            v(5);
        }
        return listEmptyList;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public w0 f0() {
        return null;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public e0 getReturnType() {
        return getType();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.h1
    public e0 getType() {
        e0 type = getValue().getType();
        if (type == null) {
            v(4);
        }
        return type;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public List<e1> getTypeParameters() {
        List<e1> listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            v(3);
        }
        return listEmptyList;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.q, kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public u getVisibility() {
        u uVar = t.f25369f;
        if (uVar == null) {
            v(7);
        }
        return uVar;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public w0 m0() {
        return null;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p
    public z0 t() {
        z0 z0Var = z0.a;
        if (z0Var == null) {
            v(9);
        }
        return z0Var;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.b1
    public w0 c(l1 l1Var) {
        if (l1Var == null) {
            v(1);
        }
        if (l1Var.k()) {
            return this;
        }
        e0 e0VarP = b() instanceof e ? l1Var.p(getType(), r1.OUT_VARIANCE) : l1Var.p(getType(), r1.INVARIANT);
        if (e0VarP == null) {
            return null;
        }
        return e0VarP == getType() ? this : new f0(b(), new i(e0VarP), getAnnotations());
    }
}
