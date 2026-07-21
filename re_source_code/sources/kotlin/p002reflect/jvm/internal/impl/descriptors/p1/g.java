package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.k.n;

/* JADX INFO: compiled from: ClassDescriptorBase.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final m f25240k;
    private final z0 l;
    private final boolean m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected g(n nVar, m mVar, f fVar, z0 z0Var, boolean z) {
        super(nVar, fVar);
        if (nVar == null) {
            K(0);
        }
        if (mVar == null) {
            K(1);
        }
        if (fVar == null) {
            K(2);
        }
        if (z0Var == null) {
            K(3);
        }
        this.f25240k = mVar;
        this.l = z0Var;
        this.m = z;
    }

    private static /* synthetic */ void K(int i2) {
        String str = (i2 == 4 || i2 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 4 || i2 == 5) ? 2 : 3];
        if (i2 == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i2 == 2) {
            objArr[0] = "name";
        } else if (i2 == 3) {
            objArr[0] = "source";
        } else if (i2 == 4 || i2 == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[0] = "storageManager";
        }
        if (i2 == 4) {
            objArr[1] = "getContainingDeclaration";
        } else if (i2 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[1] = "getSource";
        }
        if (i2 != 4 && i2 != 5) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i2 != 4 && i2 != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e, kotlin.p002reflect.jvm.internal.impl.descriptors.n, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public m b() {
        m mVar = this.f25240k;
        if (mVar == null) {
            K(4);
        }
        return mVar;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p
    public z0 t() {
        z0 z0Var = this.l;
        if (z0Var == null) {
            K(5);
        }
        return z0Var;
    }

    public boolean z() {
        return this.m;
    }
}
