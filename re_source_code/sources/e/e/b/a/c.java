package e.e.b.a;

import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: Event.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class c<T> {
    public static <T> c<T> d(T t) {
        return new a(null, t, d.DEFAULT);
    }

    public static <T> c<T> e(T t) {
        return new a(null, t, d.VERY_LOW);
    }

    public static <T> c<T> f(T t) {
        return new a(null, t, d.HIGHEST);
    }

    public abstract Integer a();

    public abstract T b();

    public abstract d c();
}
