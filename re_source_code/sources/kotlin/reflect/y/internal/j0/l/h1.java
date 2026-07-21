package kotlin.reflect.y.internal.j0.l;

/* JADX INFO: compiled from: TypeProjectionBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h1 implements g1 {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g1)) {
            return false;
        }
        g1 g1Var = (g1) obj;
        return c() == g1Var.c() && a() == g1Var.a() && getType().equals(g1Var.getType());
    }

    public int hashCode() {
        int iHashCode = a().hashCode();
        if (n1.v(getType())) {
            return (iHashCode * 31) + 19;
        }
        return (iHashCode * 31) + (c() ? 17 : getType().hashCode());
    }

    public String toString() {
        if (c()) {
            return "*";
        }
        if (a() == r1.INVARIANT) {
            return getType().toString();
        }
        return a() + " " + getType();
    }
}
