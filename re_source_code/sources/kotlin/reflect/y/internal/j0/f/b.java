package kotlin.reflect.y.internal.j0.f;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ClassId.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f24203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f24204c;

    public b(c cVar, c cVar2, boolean z) {
        if (cVar == null) {
            a(1);
        }
        if (cVar2 == null) {
            a(2);
        }
        this.a = cVar;
        this.f24203b = cVar2;
        this.f24204c = z;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0023  */
    /* JADX WARN: Code duplicated, block: B:9:0x0013  */
    private static /* synthetic */ void a(int i2) {
        String str;
        int i3;
        if (i2 != 5 && i2 != 6 && i2 != 7 && i2 != 9) {
            switch (i2) {
                case 13:
                case 14:
                case 15:
                case 16:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i2 != 5 && i2 != 6 && i2 != 7 && i2 != 9) {
            switch (i2) {
                case 13:
                case 14:
                case 15:
                case 16:
                    i3 = 2;
                    break;
                default:
                    i3 = 3;
                    break;
            }
        } else {
            i3 = 2;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 3:
                objArr[0] = "packageFqName";
                break;
            case 2:
                objArr[0] = "relativeClassName";
                break;
            case 4:
                objArr[0] = "topLevelName";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 10:
                objArr[0] = "segment";
                break;
            case 11:
            case 12:
                objArr[0] = "string";
                break;
            default:
                objArr[0] = "topLevelFqName";
                break;
        }
        if (i2 == 5) {
            objArr[1] = "getPackageFqName";
        } else if (i2 == 6) {
            objArr[1] = "getRelativeClassName";
        } else if (i2 == 7) {
            objArr[1] = "getShortClassName";
        } else if (i2 != 9) {
            switch (i2) {
                case 13:
                case 14:
                    objArr[1] = "asString";
                    break;
                case 15:
                case 16:
                    objArr[1] = "asFqNameString";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                    break;
            }
        } else {
            objArr[1] = "asSingleFqName";
        }
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
                objArr[2] = "<init>";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
                break;
            case 8:
                objArr[2] = "createNestedClassId";
                break;
            case 10:
                objArr[2] = "startsWith";
                break;
            case 11:
            case 12:
                objArr[2] = "fromString";
                break;
            default:
                objArr[2] = "topLevel";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 5 && i2 != 6 && i2 != 7 && i2 != 9) {
            switch (i2) {
                case 13:
                case 14:
                case 15:
                case 16:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    public static b e(String str) {
        if (str == null) {
            a(11);
        }
        return f(str, false);
    }

    public static b f(String str, boolean z) {
        String str2;
        if (str == null) {
            a(12);
        }
        int iLastIndexOf = str.lastIndexOf("/");
        if (iLastIndexOf == -1) {
            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        } else {
            String strReplace = str.substring(0, iLastIndexOf).replace('/', '.');
            str = str.substring(iLastIndexOf + 1);
            str2 = strReplace;
        }
        return new b(new c(str2), new c(str), z);
    }

    public static b m(c cVar) {
        if (cVar == null) {
            a(0);
        }
        return new b(cVar.e(), cVar.g());
    }

    public c b() {
        if (this.a.d()) {
            c cVar = this.f24203b;
            if (cVar == null) {
                a(9);
            }
            return cVar;
        }
        return new c(this.a.b() + "." + this.f24203b.b());
    }

    public String c() {
        if (this.a.d()) {
            String strB = this.f24203b.b();
            if (strB == null) {
                a(13);
            }
            return strB;
        }
        String str = this.a.b().replace('.', '/') + "/" + this.f24203b.b();
        if (str == null) {
            a(14);
        }
        return str;
    }

    public b d(f fVar) {
        if (fVar == null) {
            a(8);
        }
        return new b(h(), this.f24203b.c(fVar), this.f24204c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.a.equals(bVar.a) && this.f24203b.equals(bVar.f24203b) && this.f24204c == bVar.f24204c;
    }

    public b g() {
        c cVarE = this.f24203b.e();
        if (cVarE.d()) {
            return null;
        }
        return new b(h(), cVarE, this.f24204c);
    }

    public c h() {
        c cVar = this.a;
        if (cVar == null) {
            a(5);
        }
        return cVar;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.f24203b.hashCode()) * 31) + Boolean.valueOf(this.f24204c).hashCode();
    }

    public c i() {
        c cVar = this.f24203b;
        if (cVar == null) {
            a(6);
        }
        return cVar;
    }

    public f j() {
        f fVarG = this.f24203b.g();
        if (fVarG == null) {
            a(7);
        }
        return fVarG;
    }

    public boolean k() {
        return this.f24204c;
    }

    public boolean l() {
        return !this.f24203b.e().d();
    }

    public String toString() {
        if (!this.a.d()) {
            return c();
        }
        return "/" + c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(c cVar, f fVar) {
        this(cVar, c.k(fVar), false);
        if (cVar == null) {
            a(3);
        }
        if (fVar == null) {
            a(4);
        }
    }
}
