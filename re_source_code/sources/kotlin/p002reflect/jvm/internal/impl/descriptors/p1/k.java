package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: DeclarationDescriptorNonRootImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class k extends j implements n {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final m f25247h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final z0 f25248i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected k(m mVar, g gVar, f fVar, z0 z0Var) {
        super(gVar, fVar);
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
        this.f25247h = mVar;
        this.f25248i = z0Var;
    }

    private static /* synthetic */ void v(int i2) {
        String str = (i2 == 4 || i2 == 5 || i2 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 4 || i2 == 5 || i2 == 6) ? 2 : 3];
        switch (i2) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i2 == 4) {
            objArr[1] = "getOriginal";
        } else if (i2 == 5) {
            objArr[1] = "getContainingDeclaration";
        } else if (i2 != 6) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i2 != 4 && i2 != 5 && i2 != 6) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i2 != 4 && i2 != 5 && i2 != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.j, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public p a() {
        p pVar = (p) super.a();
        if (pVar == null) {
            v(4);
        }
        return pVar;
    }

    public m b() {
        m mVar = this.f25247h;
        if (mVar == null) {
            v(5);
        }
        return mVar;
    }

    public z0 t() {
        z0 z0Var = this.f25248i;
        if (z0Var == null) {
            v(6);
        }
        return z0Var;
    }
}
