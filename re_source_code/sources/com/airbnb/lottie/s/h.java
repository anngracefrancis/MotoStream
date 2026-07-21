package com.airbnb.lottie.s;

/* JADX INFO: compiled from: MutablePair.java */
/* JADX INFO: loaded from: classes.dex */
public class h<T> {
    T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    T f8708b;

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void b(T t, T t2) {
        this.a = t;
        this.f8708b = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c.i.j.e)) {
            return false;
        }
        c.i.j.e eVar = (c.i.j.e) obj;
        return a(eVar.a, this.a) && a(eVar.f3281b, this.f8708b);
    }

    public int hashCode() {
        T t = this.a;
        int iHashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f8708b;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.a) + " " + String.valueOf(this.f8708b) + "}";
    }
}
