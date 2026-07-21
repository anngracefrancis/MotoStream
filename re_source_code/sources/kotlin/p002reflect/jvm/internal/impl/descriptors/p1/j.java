package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.h.c;

/* JADX INFO: compiled from: DeclarationDescriptorImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class j extends b implements m {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final f f25244g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(g gVar, f fVar) {
        super(gVar);
        if (gVar == null) {
            v(0);
        }
        if (fVar == null) {
            v(1);
        }
        this.f25244g = fVar;
    }

    public static String H(m mVar) {
        if (mVar == null) {
            v(4);
        }
        try {
            String str = c.f24255j.q(mVar) + "[" + mVar.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(mVar)) + "]";
            if (str == null) {
                v(5);
            }
            return str;
        } catch (Throwable unused) {
            String str2 = mVar.getClass().getSimpleName() + " " + mVar.getName();
            if (str2 == null) {
                v(6);
            }
            return str2;
        }
    }

    private static /* synthetic */ void v(int i2) {
        String str = (i2 == 2 || i2 == 3 || i2 == 5 || i2 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 2 || i2 == 3 || i2 == 5 || i2 == 6) ? 2 : 3];
        switch (i2) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
                break;
            case 4:
                objArr[0] = "descriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        if (i2 == 2) {
            objArr[1] = "getName";
        } else if (i2 == 3) {
            objArr[1] = "getOriginal";
        } else if (i2 == 5 || i2 == 6) {
            objArr[1] = "toString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        }
        if (i2 != 2 && i2 != 3) {
            if (i2 == 4) {
                objArr[2] = "toString";
            } else if (i2 != 5 && i2 != 6) {
                objArr[2] = "<init>";
            }
        }
        String str2 = String.format(str, objArr);
        if (i2 != 2 && i2 != 3 && i2 != 5 && i2 != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public m a() {
        return this;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.i0
    public f getName() {
        f fVar = this.f25244g;
        if (fVar == null) {
            v(2);
        }
        return fVar;
    }

    public String toString() {
        return H(this);
    }
}
