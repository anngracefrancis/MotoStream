package kotlin.reflect.y.internal.j0.f;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.collections.n;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FqNameUnsafe.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static final f a = f.D("<root>");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f24207b = Pattern.compile("\\.");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Function1<String, f> f24208c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f24209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private transient c f24210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient d f24211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient f f24212g;

    /* JADX INFO: compiled from: FqNameUnsafe.java */
    static class a implements Function1<String, f> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f invoke(String str) {
            return f.v(str);
        }
    }

    d(String str, c cVar) {
        if (str == null) {
            a(0);
        }
        if (cVar == null) {
            a(1);
        }
        this.f24209d = str;
        this.f24210e = cVar;
    }

    private static /* synthetic */ void a(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 15:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                i3 = 2;
                break;
            case 9:
            case 15:
            case 16:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        if (i2 != 1) {
            switch (i2) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 17:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                    break;
                case 9:
                    objArr[0] = "name";
                    break;
                case 15:
                    objArr[0] = "segment";
                    break;
                case 16:
                    objArr[0] = "shortName";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
        } else {
            objArr[0] = "safe";
        }
        switch (i2) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
            case 6:
                objArr[1] = "toSafe";
                break;
            case 7:
            case 8:
                objArr[1] = "parent";
                break;
            case 9:
            case 15:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                break;
            case 10:
            case 11:
                objArr[1] = "shortName";
                break;
            case 12:
            case 13:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 14:
                objArr[1] = "pathSegments";
                break;
            case 17:
                objArr[1] = "toString";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                break;
            case 9:
                objArr[2] = "child";
                break;
            case 15:
                objArr[2] = "startsWith";
                break;
            case 16:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                throw new IllegalStateException(str2);
            case 9:
            case 15:
            case 16:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    private void d() {
        int iLastIndexOf = this.f24209d.lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            this.f24212g = f.v(this.f24209d.substring(iLastIndexOf + 1));
            this.f24211f = new d(this.f24209d.substring(0, iLastIndexOf));
        } else {
            this.f24212g = f.v(this.f24209d);
            this.f24211f = c.a.j();
        }
    }

    public static d m(f fVar) {
        if (fVar == null) {
            a(16);
        }
        return new d(fVar.k(), c.a.j(), fVar);
    }

    public String b() {
        String str = this.f24209d;
        if (str == null) {
            a(4);
        }
        return str;
    }

    public d c(f fVar) {
        String strK;
        if (fVar == null) {
            a(9);
        }
        if (e()) {
            strK = fVar.k();
        } else {
            strK = this.f24209d + "." + fVar.k();
        }
        return new d(strK, this, fVar);
    }

    public boolean e() {
        return this.f24209d.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && this.f24209d.equals(((d) obj).f24209d);
    }

    public boolean f() {
        return this.f24210e != null || b().indexOf(60) < 0;
    }

    public d g() {
        d dVar = this.f24211f;
        if (dVar != null) {
            if (dVar == null) {
                a(7);
            }
            return dVar;
        }
        if (e()) {
            throw new IllegalStateException("root");
        }
        d();
        d dVar2 = this.f24211f;
        if (dVar2 == null) {
            a(8);
        }
        return dVar2;
    }

    public List<f> h() {
        List<f> listEmptyList = e() ? Collections.emptyList() : n.L(f24207b.split(this.f24209d), f24208c);
        if (listEmptyList == null) {
            a(14);
        }
        return listEmptyList;
    }

    public int hashCode() {
        return this.f24209d.hashCode();
    }

    public f i() {
        f fVar = this.f24212g;
        if (fVar != null) {
            if (fVar == null) {
                a(10);
            }
            return fVar;
        }
        if (e()) {
            throw new IllegalStateException("root");
        }
        d();
        f fVar2 = this.f24212g;
        if (fVar2 == null) {
            a(11);
        }
        return fVar2;
    }

    public f j() {
        if (e()) {
            f fVar = a;
            if (fVar == null) {
                a(12);
            }
            return fVar;
        }
        f fVarI = i();
        if (fVarI == null) {
            a(13);
        }
        return fVarI;
    }

    public boolean k(f fVar) {
        if (fVar == null) {
            a(15);
        }
        if (e()) {
            return false;
        }
        int iIndexOf = this.f24209d.indexOf(46);
        String str = this.f24209d;
        String strK = fVar.k();
        if (iIndexOf == -1) {
            iIndexOf = this.f24209d.length();
        }
        return str.regionMatches(0, strK, 0, iIndexOf);
    }

    public c l() {
        c cVar = this.f24210e;
        if (cVar != null) {
            if (cVar == null) {
                a(5);
            }
            return cVar;
        }
        c cVar2 = new c(this);
        this.f24210e = cVar2;
        if (cVar2 == null) {
            a(6);
        }
        return cVar2;
    }

    public String toString() {
        String strK = e() ? a.k() : this.f24209d;
        if (strK == null) {
            a(17);
        }
        return strK;
    }

    public d(String str) {
        if (str == null) {
            a(2);
        }
        this.f24209d = str;
    }

    private d(String str, d dVar, f fVar) {
        if (str == null) {
            a(3);
        }
        this.f24209d = str;
        this.f24211f = dVar;
        this.f24212g = fVar;
    }
}
