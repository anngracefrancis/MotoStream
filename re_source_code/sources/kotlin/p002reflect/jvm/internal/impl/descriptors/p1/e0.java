package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.p002reflect.jvm.internal.impl.descriptors.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.o;
import kotlin.p002reflect.jvm.internal.impl.descriptors.s0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u;
import kotlin.p002reflect.jvm.internal.impl.descriptors.v0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.f.h;
import kotlin.reflect.y.internal.j0.i.t.a;
import kotlin.reflect.y.internal.j0.l.m0;

/* JADX INFO: compiled from: PropertySetterDescriptorImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class e0 extends b0 implements v0 {
    private i1 r;
    private final v0 s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public e0(t0 t0Var, g gVar, d0 d0Var, u uVar, boolean z, boolean z2, boolean z3, b.a aVar, v0 v0Var, z0 z0Var) {
        v0 v0Var2;
        e0 e0Var;
        super(d0Var, uVar, t0Var, gVar, f.D("<set-" + t0Var.getName() + ">"), z, z2, z3, aVar, z0Var);
        if (t0Var == null) {
            v(0);
        }
        if (gVar == null) {
            v(1);
        }
        if (d0Var == null) {
            v(2);
        }
        if (uVar == null) {
            v(3);
        }
        if (aVar == null) {
            v(4);
        }
        if (z0Var == null) {
            v(5);
        }
        if (v0Var != null) {
            e0Var = this;
            v0Var2 = v0Var;
        } else {
            v0Var2 = this;
            e0Var = v0Var2;
        }
        e0Var.s = v0Var2;
    }

    public static l0 Q0(v0 v0Var, kotlin.reflect.y.internal.j0.l.e0 e0Var, g gVar) {
        if (v0Var == null) {
            v(7);
        }
        if (e0Var == null) {
            v(8);
        }
        if (gVar == null) {
            v(9);
        }
        return new l0(v0Var, null, 0, gVar, h.n, e0Var, false, false, false, null, z0.a);
    }

    private static /* synthetic */ void v(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 9:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "visibility";
                break;
            case 4:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD;
                break;
            case 7:
                objArr[0] = "setterDescriptor";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        switch (i2) {
            case 10:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 11:
                objArr[1] = "getValueParameters";
                break;
            case 12:
                objArr[1] = "getReturnType";
                break;
            case 13:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
        }
        switch (i2) {
            case 6:
                objArr[2] = "initialize";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSetterParameter";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(o<R, D> oVar, D d2) {
        return oVar.i(this, d2);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.b0, kotlin.p002reflect.jvm.internal.impl.descriptors.p1.k, kotlin.p002reflect.jvm.internal.impl.descriptors.p1.j, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    /* JADX INFO: renamed from: R0, reason: merged with bridge method [inline-methods] */
    public v0 a() {
        v0 v0Var = this.s;
        if (v0Var == null) {
            v(13);
        }
        return v0Var;
    }

    public void S0(i1 i1Var) {
        if (i1Var == null) {
            v(6);
        }
        this.r = i1Var;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.y, kotlin.p002reflect.jvm.internal.impl.descriptors.b, kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public Collection<? extends v0> e() {
        Collection<s0> collectionM0 = super.M0(false);
        if (collectionM0 == null) {
            v(10);
        }
        return collectionM0;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public List<i1> f() {
        i1 i1Var = this.r;
        if (i1Var == null) {
            throw new IllegalStateException();
        }
        List<i1> listSingletonList = Collections.singletonList(i1Var);
        if (listSingletonList == null) {
            v(11);
        }
        return listSingletonList;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public kotlin.reflect.y.internal.j0.l.e0 getReturnType() {
        m0 m0VarZ = a.f(this).Z();
        if (m0VarZ == null) {
            v(12);
        }
        return m0VarZ;
    }
}
