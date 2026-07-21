package c.g.b.k;

import c.g.b.k.m.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: ConstraintAnchor.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f3055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f3056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f3057f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    c.g.b.i f3060i;
    private HashSet<d> a = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3058g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f3059h = -1;

    /* JADX INFO: compiled from: ConstraintAnchor.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: compiled from: ConstraintAnchor.java */
    public enum b {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public d(e eVar, b bVar) {
        this.f3055d = eVar;
        this.f3056e = bVar;
    }

    public boolean a(d dVar, int i2, int i3, boolean z) {
        if (dVar == null) {
            p();
            return true;
        }
        if (!z && !o(dVar)) {
            return false;
        }
        this.f3057f = dVar;
        if (dVar.a == null) {
            dVar.a = new HashSet<>();
        }
        HashSet<d> hashSet = this.f3057f.a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        if (i2 > 0) {
            this.f3058g = i2;
        } else {
            this.f3058g = 0;
        }
        this.f3059h = i3;
        return true;
    }

    public void b(int i2, ArrayList<o> arrayList, o oVar) {
        HashSet<d> hashSet = this.a;
        if (hashSet != null) {
            Iterator<d> it = hashSet.iterator();
            while (it.hasNext()) {
                c.g.b.k.m.i.a(it.next().f3055d, i2, arrayList, oVar);
            }
        }
    }

    public HashSet<d> c() {
        return this.a;
    }

    public int d() {
        if (this.f3054c) {
            return this.f3053b;
        }
        return 0;
    }

    public int e() {
        d dVar;
        if (this.f3055d.Q() == 8) {
            return 0;
        }
        return (this.f3059h <= -1 || (dVar = this.f3057f) == null || dVar.f3055d.Q() != 8) ? this.f3058g : this.f3059h;
    }

    public final d f() {
        switch (a.a[this.f3056e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f3055d.K;
            case 3:
                return this.f3055d.I;
            case 4:
                return this.f3055d.L;
            case 5:
                return this.f3055d.J;
            default:
                throw new AssertionError(this.f3056e.name());
        }
    }

    public e g() {
        return this.f3055d;
    }

    public c.g.b.i h() {
        return this.f3060i;
    }

    public d i() {
        return this.f3057f;
    }

    public b j() {
        return this.f3056e;
    }

    public boolean k() {
        HashSet<d> hashSet = this.a;
        if (hashSet == null) {
            return false;
        }
        Iterator<d> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().f().n()) {
                return true;
            }
        }
        return false;
    }

    public boolean l() {
        HashSet<d> hashSet = this.a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean m() {
        return this.f3054c;
    }

    public boolean n() {
        return this.f3057f != null;
    }

    public boolean o(d dVar) {
        if (dVar == null) {
            return false;
        }
        b bVarJ = dVar.j();
        b bVar = this.f3056e;
        if (bVarJ == bVar) {
            return bVar != b.BASELINE || (dVar.g().U() && g().U());
        }
        switch (a.a[bVar.ordinal()]) {
            case 1:
                return (bVarJ == b.BASELINE || bVarJ == b.CENTER_X || bVarJ == b.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z = bVarJ == b.LEFT || bVarJ == b.RIGHT;
                if (dVar.g() instanceof g) {
                    return z || bVarJ == b.CENTER_X;
                }
                return z;
            case 4:
            case 5:
                boolean z2 = bVarJ == b.TOP || bVarJ == b.BOTTOM;
                if (dVar.g() instanceof g) {
                    return z2 || bVarJ == b.CENTER_Y;
                }
                return z2;
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f3056e.name());
        }
    }

    public void p() {
        HashSet<d> hashSet;
        d dVar = this.f3057f;
        if (dVar != null && (hashSet = dVar.a) != null) {
            hashSet.remove(this);
            if (this.f3057f.a.size() == 0) {
                this.f3057f.a = null;
            }
        }
        this.a = null;
        this.f3057f = null;
        this.f3058g = 0;
        this.f3059h = -1;
        this.f3054c = false;
        this.f3053b = 0;
    }

    public void q() {
        this.f3054c = false;
        this.f3053b = 0;
    }

    public void r(c.g.b.c cVar) {
        c.g.b.i iVar = this.f3060i;
        if (iVar == null) {
            this.f3060i = new c.g.b.i(c.g.b.i.a.UNRESTRICTED, null);
        } else {
            iVar.d();
        }
    }

    public void s(int i2) {
        this.f3053b = i2;
        this.f3054c = true;
    }

    public String toString() {
        return this.f3055d.r() + ":" + this.f3056e.toString();
    }
}
