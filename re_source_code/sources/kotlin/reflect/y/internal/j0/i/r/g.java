package kotlin.reflect.y.internal.j0.i.r;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g<T> {
    private final T a;

    public g(T t) {
        this.a = t;
    }

    public abstract e0 a(g0 g0Var);

    public T b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            T tB = b();
            g gVar = obj instanceof g ? (g) obj : null;
            if (!m.a(tB, gVar != null ? gVar.b() : null)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        T tB = b();
        if (tB != null) {
            return tB.hashCode();
        }
        return 0;
    }

    public String toString() {
        return String.valueOf(b());
    }
}
