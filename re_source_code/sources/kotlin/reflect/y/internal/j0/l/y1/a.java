package kotlin.reflect.y.internal.j0.l.y1;

import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: CapturedTypeApproximation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a<T> {
    private final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f24880b;

    public a(T t, T t2) {
        this.a = t;
        this.f24880b = t2;
    }

    public final T a() {
        return this.a;
    }

    public final T b() {
        return this.f24880b;
    }

    public final T c() {
        return this.a;
    }

    public final T d() {
        return this.f24880b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return m.a(this.a, aVar.a) && m.a(this.f24880b, aVar.f24880b);
    }

    public int hashCode() {
        T t = this.a;
        int iHashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.f24880b;
        return iHashCode + (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "ApproximationBounds(lower=" + this.a + ", upper=" + this.f24880b + ')';
    }
}
