package rx.n.a;

import java.io.Serializable;

/* JADX INFO: compiled from: NotificationLite.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    private static final Object a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f26243b = new b();

    /* JADX INFO: compiled from: NotificationLite.java */
    static class a implements Serializable {
        a() {
        }

        public String toString() {
            return "Notification=>Completed";
        }
    }

    /* JADX INFO: compiled from: NotificationLite.java */
    static class b implements Serializable {
        b() {
        }

        public String toString() {
            return "Notification=>NULL";
        }
    }

    /* JADX INFO: compiled from: NotificationLite.java */
    static final class c implements Serializable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Throwable f26244f;

        public c(Throwable th) {
            this.f26244f = th;
        }

        public String toString() {
            return "Notification=>Error:" + this.f26244f;
        }
    }

    public static <T> boolean a(rx.f<? super T> fVar, Object obj) {
        if (obj == a) {
            fVar.onCompleted();
            return true;
        }
        if (obj == f26243b) {
            fVar.onNext(null);
            return false;
        }
        if (obj == null) {
            throw new IllegalArgumentException("The lite notification can not be null");
        }
        if (obj.getClass() == c.class) {
            fVar.onError(((c) obj).f26244f);
            return true;
        }
        fVar.onNext(obj);
        return false;
    }

    public static Object b() {
        return a;
    }

    public static Object c(Throwable th) {
        return new c(th);
    }

    public static Throwable d(Object obj) {
        return ((c) obj).f26244f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T e(Object obj) {
        if (obj == f26243b) {
            return null;
        }
        return obj;
    }

    public static boolean f(Object obj) {
        return obj == a;
    }

    public static <T> Object g(T t) {
        return t == null ? f26243b : t;
    }
}
