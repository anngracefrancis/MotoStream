package kotlin.reflect.y.internal.j0.i.w.o;

import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: AbstractReceiverValue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements f {
    protected final e0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f24438b;

    public a(e0 e0Var, f fVar) {
        if (e0Var == null) {
            b(0);
        }
        this.a = e0Var;
        this.f24438b = fVar == null ? this : fVar;
    }

    private static /* synthetic */ void b(int i2) {
        String str = (i2 == 1 || i2 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 1 || i2 == 2) ? 2 : 3];
        if (i2 == 1 || i2 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[0] = "receiverType";
        }
        if (i2 == 1) {
            objArr[1] = "getType";
        } else if (i2 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i2 != 1 && i2 != 2) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.o.f
    public e0 getType() {
        e0 e0Var = this.a;
        if (e0Var == null) {
            b(1);
        }
        return e0Var;
    }
}
