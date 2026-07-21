package kotlin.reflect.y.internal.j0.f;

/* JADX INFO: compiled from: Name.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements Comparable<f> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f24213f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f24214g;

    private f(String str, boolean z) {
        if (str == null) {
            g(0);
        }
        this.f24213f = str;
        this.f24214g = z;
    }

    public static boolean A(String str) {
        if (str == null) {
            g(6);
        }
        if (str.isEmpty() || str.startsWith("<")) {
            return false;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '.' || cCharAt == '/' || cCharAt == '\\') {
                return false;
            }
        }
        return true;
    }

    public static f D(String str) {
        if (str == null) {
            g(7);
        }
        if (str.startsWith("<")) {
            return new f(str, true);
        }
        throw new IllegalArgumentException("special name must start with '<': " + str);
    }

    private static /* synthetic */ void g(int i2) {
        String str = (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) ? 2 : 3];
        if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = "name";
        }
        if (i2 == 1) {
            objArr[1] = "asString";
        } else if (i2 == 2) {
            objArr[1] = "getIdentifier";
        } else if (i2 == 3 || i2 == 4) {
            objArr[1] = "asStringStripSpecialMarkers";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        }
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 5:
                objArr[2] = "identifier";
                break;
            case 6:
                objArr[2] = "isValidIdentifier";
                break;
            case 7:
                objArr[2] = "special";
                break;
            case 8:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static f v(String str) {
        if (str == null) {
            g(8);
        }
        return str.startsWith("<") ? D(str) : x(str);
    }

    public static f x(String str) {
        if (str == null) {
            g(5);
        }
        return new f(str, false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f24214g == fVar.f24214g && this.f24213f.equals(fVar.f24213f);
    }

    public int hashCode() {
        return (this.f24213f.hashCode() * 31) + (this.f24214g ? 1 : 0);
    }

    public String k() {
        String str = this.f24213f;
        if (str == null) {
            g(1);
        }
        return str;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        return this.f24213f.compareTo(fVar.f24213f);
    }

    public String toString() {
        return this.f24213f;
    }

    public String u() {
        if (this.f24214g) {
            throw new IllegalStateException("not identifier: " + this);
        }
        String strK = k();
        if (strK == null) {
            g(2);
        }
        return strK;
    }

    public boolean y() {
        return this.f24214g;
    }
}
