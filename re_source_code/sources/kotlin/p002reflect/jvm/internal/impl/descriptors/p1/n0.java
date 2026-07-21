package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import kotlin.jvm.functions.Function0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.r.g;
import kotlin.reflect.y.internal.j0.k.j;
import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: VariableDescriptorWithInitializerImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class n0 extends m0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f25263k;
    protected j<g<?>> l;
    protected Function0<j<g<?>>> m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(m mVar, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar, f fVar, e0 e0Var, boolean z, z0 z0Var) {
        super(mVar, gVar, fVar, e0Var, z0Var);
        if (mVar == null) {
            v(0);
        }
        if (gVar == null) {
            v(1);
        }
        if (fVar == null) {
            v(2);
        }
        if (z0Var == null) {
            v(3);
        }
        this.f25263k = z;
    }

    private static /* synthetic */ void v(int i2) {
        Object[] objArr = new Object[3];
        if (i2 == 1) {
            objArr[0] = "annotations";
        } else if (i2 == 2) {
            objArr[0] = "name";
        } else if (i2 == 3) {
            objArr[0] = "source";
        } else if (i2 == 4 || i2 == 5) {
            objArr[0] = "compileTimeInitializerFactory";
        } else {
            objArr[0] = "containingDeclaration";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (i2 == 4) {
            objArr[2] = "setCompileTimeInitializerFactory";
        } else if (i2 != 5) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "setCompileTimeInitializer";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public void L0(j<g<?>> jVar, Function0<j<g<?>>> function0) {
        if (function0 == null) {
            v(5);
        }
        this.m = function0;
        if (jVar == null) {
            jVar = function0.invoke();
        }
        this.l = jVar;
    }

    public void M0(Function0<j<g<?>>> function0) {
        if (function0 == null) {
            v(4);
        }
        L0(null, function0);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.j1
    public g<?> X() {
        j<g<?>> jVar = this.l;
        if (jVar != null) {
            return jVar.invoke();
        }
        return null;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.j1
    public boolean j0() {
        return this.f25263k;
    }
}
