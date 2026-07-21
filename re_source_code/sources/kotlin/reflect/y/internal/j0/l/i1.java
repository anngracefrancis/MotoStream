package kotlin.reflect.y.internal.j0.l;

import kotlin.reflect.y.internal.j0.l.t1.g;

/* JADX INFO: compiled from: TypeProjectionImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class i1 extends h1 {
    private final r1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e0 f24749b;

    public i1(r1 r1Var, e0 e0Var) {
        if (r1Var == null) {
            d(0);
        }
        if (e0Var == null) {
            d(1);
        }
        this.a = r1Var;
        this.f24749b = e0Var;
    }

    private static /* synthetic */ void d(int i2) {
        String str = (i2 == 4 || i2 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 4 || i2 == 5) ? 2 : 3];
        switch (i2) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "type";
                break;
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
                break;
            case 6:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "projection";
                break;
        }
        if (i2 == 4) {
            objArr[1] = "getProjectionKind";
        } else if (i2 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (i2 == 3) {
            objArr[2] = "replaceType";
        } else if (i2 != 4 && i2 != 5) {
            if (i2 != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "refine";
            }
        }
        String str2 = String.format(str, objArr);
        if (i2 != 4 && i2 != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // kotlin.reflect.y.internal.j0.l.g1
    public r1 a() {
        r1 r1Var = this.a;
        if (r1Var == null) {
            d(4);
        }
        return r1Var;
    }

    @Override // kotlin.reflect.y.internal.j0.l.g1
    public g1 b(g gVar) {
        if (gVar == null) {
            d(6);
        }
        return new i1(this.a, gVar.a(this.f24749b));
    }

    @Override // kotlin.reflect.y.internal.j0.l.g1
    public boolean c() {
        return false;
    }

    @Override // kotlin.reflect.y.internal.j0.l.g1
    public e0 getType() {
        e0 e0Var = this.f24749b;
        if (e0Var == null) {
            d(5);
        }
        return e0Var;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i1(e0 e0Var) {
        this(r1.INVARIANT, e0Var);
        if (e0Var == null) {
            d(2);
        }
    }
}
