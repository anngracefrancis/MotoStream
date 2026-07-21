package kotlin.reflect.y.internal.j0.i.w.o;

import kotlin.p002reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: ExtensionReceiver.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends a implements f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f24441c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(a aVar, e0 e0Var, f fVar) {
        super(e0Var, fVar);
        if (aVar == null) {
            b(0);
        }
        if (e0Var == null) {
            b(1);
        }
        this.f24441c = aVar;
    }

    private static /* synthetic */ void b(int i2) {
        String str = i2 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 2 ? 3 : 2];
        if (i2 == 1) {
            objArr[0] = "receiverType";
        } else if (i2 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else if (i2 != 3) {
            objArr[0] = "callableDescriptor";
        } else {
            objArr[0] = "newType";
        }
        if (i2 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else {
            objArr[1] = "getDeclarationDescriptor";
        }
        if (i2 != 2) {
            if (i2 != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "replaceType";
            }
        }
        String str2 = String.format(str, objArr);
        if (i2 == 2) {
            throw new IllegalStateException(str2);
        }
    }

    public String toString() {
        return getType() + ": Ext {" + this.f24441c + "}";
    }
}
