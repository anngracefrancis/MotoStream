package kotlin.reflect.y.internal.j0.i.w.o;

import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: TransientReceiver.java */
/* JADX INFO: loaded from: classes3.dex */
public class i extends a {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(e0 e0Var) {
        this(e0Var, null);
        if (e0Var == null) {
            b(0);
        }
    }

    private static /* synthetic */ void b(int i2) {
        Object[] objArr = new Object[3];
        if (i2 != 2) {
            objArr[0] = "type";
        } else {
            objArr[0] = "newType";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (i2 != 2) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "replaceType";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public String toString() {
        return "{Transient} : " + getType();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private i(e0 e0Var, f fVar) {
        super(e0Var, fVar);
        if (e0Var == null) {
            b(1);
        }
    }
}
