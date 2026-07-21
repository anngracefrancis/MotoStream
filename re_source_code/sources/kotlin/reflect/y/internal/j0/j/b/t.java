package kotlin.reflect.y.internal.j0.j.b;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.b;

/* JADX INFO: compiled from: IncompatibleVersionErrorData.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t<T> {
    private final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f24604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f24605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f24606d;

    public t(T t, T t2, String str, b bVar) {
        m.f(str, "filePath");
        m.f(bVar, "classId");
        this.a = t;
        this.f24604b = t2;
        this.f24605c = str;
        this.f24606d = bVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return m.a(this.a, tVar.a) && m.a(this.f24604b, tVar.f24604b) && m.a(this.f24605c, tVar.f24605c) && m.a(this.f24606d, tVar.f24606d);
    }

    public int hashCode() {
        T t = this.a;
        int iHashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.f24604b;
        return ((((iHashCode + (t2 != null ? t2.hashCode() : 0)) * 31) + this.f24605c.hashCode()) * 31) + this.f24606d.hashCode();
    }

    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.a + ", expectedVersion=" + this.f24604b + ", filePath=" + this.f24605c + ", classId=" + this.f24606d + ')';
    }
}
