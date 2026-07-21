package kotlin.reflect.y.internal.j0.i.u;

import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.c;

/* JADX INFO: compiled from: JvmClassName.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f24388b;

    private d(String str) {
        if (str == null) {
            a(5);
        }
        this.a = str;
    }

    private static /* synthetic */ void a(int i2) {
        String str = (i2 == 3 || i2 == 6 || i2 == 7 || i2 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 3 || i2 == 6 || i2 == 7 || i2 == 8) ? 2 : 3];
        switch (i2) {
            case 1:
                objArr[0] = "classId";
                break;
            case 2:
            case 4:
                objArr[0] = "fqName";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
                break;
            case 5:
            default:
                objArr[0] = "internalName";
                break;
        }
        if (i2 == 3) {
            objArr[1] = "byFqNameWithoutInnerClasses";
        } else if (i2 == 6) {
            objArr[1] = "getFqNameForClassNameWithoutDollars";
        } else if (i2 == 7) {
            objArr[1] = "getPackageFqName";
        } else if (i2 != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
        } else {
            objArr[1] = "getInternalName";
        }
        switch (i2) {
            case 1:
                objArr[2] = "byClassId";
                break;
            case 2:
            case 4:
                objArr[2] = "byFqNameWithoutInnerClasses";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                break;
            case 5:
                objArr[2] = "<init>";
                break;
            default:
                objArr[2] = "byInternalName";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 3 && i2 != 6 && i2 != 7 && i2 != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static d b(b bVar) {
        if (bVar == null) {
            a(1);
        }
        c cVarH = bVar.h();
        String strReplace = bVar.i().b().replace('.', '$');
        if (cVarH.d()) {
            return new d(strReplace);
        }
        return new d(cVarH.b().replace('.', '/') + "/" + strReplace);
    }

    public static d c(c cVar) {
        if (cVar == null) {
            a(2);
        }
        d dVar = new d(cVar.b().replace('.', '/'));
        dVar.f24388b = cVar;
        return dVar;
    }

    public static d d(String str) {
        if (str == null) {
            a(0);
        }
        return new d(str);
    }

    public c e() {
        return new c(this.a.replace('/', '.'));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((d) obj).a);
    }

    public String f() {
        String str = this.a;
        if (str == null) {
            a(8);
        }
        return str;
    }

    public c g() {
        int iLastIndexOf = this.a.lastIndexOf("/");
        if (iLastIndexOf != -1) {
            return new c(this.a.substring(0, iLastIndexOf).replace('/', '.'));
        }
        c cVar = c.a;
        if (cVar == null) {
            a(7);
        }
        return cVar;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a;
    }
}
