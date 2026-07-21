package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.p002reflect.jvm.internal.impl.descriptors.a;
import kotlin.p002reflect.jvm.internal.impl.descriptors.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.s0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.l1;

/* JADX INFO: compiled from: PropertyAccessorDescriptorImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b0 extends k implements s0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f25212j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f25213k;
    private final d0 l;
    private final t0 m;
    private final boolean n;
    private final b.a o;
    private u p;
    private y q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(d0 d0Var, u uVar, t0 t0Var, g gVar, f fVar, boolean z, boolean z2, boolean z3, b.a aVar, z0 z0Var) {
        super(t0Var.b(), gVar, fVar, z0Var);
        if (d0Var == null) {
            v(0);
        }
        if (uVar == null) {
            v(1);
        }
        if (t0Var == null) {
            v(2);
        }
        if (gVar == null) {
            v(3);
        }
        if (fVar == null) {
            v(4);
        }
        if (z0Var == null) {
            v(5);
        }
        this.q = null;
        this.l = d0Var;
        this.p = uVar;
        this.m = t0Var;
        this.f25212j = z;
        this.f25213k = z2;
        this.n = z3;
        this.o = aVar;
    }

    private static /* synthetic */ void v(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 7:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                i3 = 2;
                break;
            case 7:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "visibility";
                break;
            case 2:
                objArr[0] = "correspondingProperty";
                break;
            case 3:
                objArr[0] = "annotations";
                break;
            case 4:
                objArr[0] = "name";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 7:
                objArr[0] = "substitutor";
                break;
            case 15:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "modality";
                break;
        }
        switch (i2) {
            case 6:
                objArr[1] = "getKind";
                break;
            case 7:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getModality";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getCorrespondingVariable";
                break;
            case 12:
                objArr[1] = "getCorrespondingProperty";
                break;
            case 13:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 14:
                objArr[1] = "getOverriddenDescriptors";
                break;
        }
        switch (i2) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                break;
            case 7:
                objArr[2] = "substitute";
                break;
            case 15:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                throw new IllegalStateException(str2);
            case 7:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.b
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public s0 k0(m mVar, d0 d0Var, u uVar, b.a aVar, boolean z) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.s0
    public t0 B0() {
        t0 t0Var = this.m;
        if (t0Var == null) {
            v(12);
        }
        return t0Var;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.y
    public boolean C0() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public boolean E0() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public boolean G() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.y
    public boolean H0() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.k, kotlin.p002reflect.jvm.internal.impl.descriptors.p1.j, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public abstract s0 a();

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public boolean M() {
        return false;
    }

    protected Collection<s0> M0(boolean z) {
        ArrayList arrayList = new ArrayList(0);
        for (t0 t0Var : B0().e()) {
            m getter = z ? t0Var.getGetter() : t0Var.getSetter();
            if (getter != null) {
                arrayList.add(getter);
            }
        }
        return arrayList;
    }

    public void N0(boolean z) {
        this.f25212j = z;
    }

    public void O0(y yVar) {
        this.q = yVar;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.y
    public boolean P() {
        return false;
    }

    public void P0(u uVar) {
        this.p = uVar;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.y
    public boolean Q() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.s0
    public boolean V() {
        return this.f25212j;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.y
    public y d0() {
        return this.q;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public w0 f0() {
        return B0().f0();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public List<e1> getTypeParameters() {
        List<e1> listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            v(8);
        }
        return listEmptyList;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.q, kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public u getVisibility() {
        u uVar = this.p;
        if (uVar == null) {
            v(10);
        }
        return uVar;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.b
    public b.a i() {
        b.a aVar = this.o;
        if (aVar == null) {
            v(6);
        }
        return aVar;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public <V> V i0(a.InterfaceC0406a<V> interfaceC0406a) {
        return null;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.y
    public boolean isInline() {
        return this.n;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.y
    public boolean isSuspend() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public d0 j() {
        d0 d0Var = this.l;
        if (d0Var == null) {
            v(9);
        }
        return d0Var;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public w0 m0() {
        return B0().m0();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public List<w0> r0() {
        List<w0> listR0 = B0().r0();
        if (listR0 == null) {
            v(13);
        }
        return listR0;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.y
    public boolean w0() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.b
    public void x0(Collection<? extends b> collection) {
        if (collection == null) {
            v(15);
        }
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public boolean z() {
        return this.f25213k;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.b1
    public y c(l1 l1Var) {
        if (l1Var == null) {
            v(7);
        }
        throw new UnsupportedOperationException();
    }
}
