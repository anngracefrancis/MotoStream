package rx;

/* JADX INFO: compiled from: Notification.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d<T> {
    private static final d<Void> a = new d<>(a.OnCompleted, null, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f26083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Throwable f26084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final T f26085d;

    /* JADX INFO: compiled from: Notification.java */
    public enum a {
        OnNext,
        OnError,
        OnCompleted
    }

    private d(a aVar, T t, Throwable th) {
        this.f26085d = t;
        this.f26084c = th;
        this.f26083b = aVar;
    }

    public static <T> d<T> a() {
        return (d<T>) a;
    }

    public static <T> d<T> b(Throwable th) {
        return new d<>(a.OnError, null, th);
    }

    public static <T> d<T> c(T t) {
        return new d<>(a.OnNext, t, null);
    }

    public a d() {
        return this.f26083b;
    }

    public Throwable e() {
        return this.f26084c;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != d.class) {
            return false;
        }
        d dVar = (d) obj;
        if (dVar.d() != d()) {
            return false;
        }
        T t = this.f26085d;
        T t2 = dVar.f26085d;
        if (t != t2 && (t == null || !t.equals(t2))) {
            return false;
        }
        Throwable th = this.f26084c;
        Throwable th2 = dVar.f26084c;
        return th == th2 || (th != null && th.equals(th2));
    }

    public T f() {
        return this.f26085d;
    }

    public boolean g() {
        return j() && this.f26084c != null;
    }

    public boolean h() {
        return k() && this.f26085d != null;
    }

    public int hashCode() {
        int iHashCode = d().hashCode();
        if (h()) {
            iHashCode = (iHashCode * 31) + f().hashCode();
        }
        return g() ? (iHashCode * 31) + e().hashCode() : iHashCode;
    }

    public boolean i() {
        return d() == a.OnCompleted;
    }

    public boolean j() {
        return d() == a.OnError;
    }

    public boolean k() {
        return d() == a.OnNext;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append('[');
        sb.append(super.toString());
        sb.append(' ');
        sb.append(d());
        if (h()) {
            sb.append(' ');
            sb.append(f());
        }
        if (g()) {
            sb.append(' ');
            sb.append(e().getMessage());
        }
        sb.append(']');
        return sb.toString();
    }
}
