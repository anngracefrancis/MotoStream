package kotlin.reflect.y.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ReflectProperties.java */
/* JADX INFO: loaded from: classes2.dex */
public class a0 {

    /* JADX INFO: compiled from: ReflectProperties.java */
    public static class a<T> extends c<T> implements Function0<T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Function0<T> f23019g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private volatile SoftReference<Object> f23020h;

        public a(T t, Function0<T> function0) {
            if (function0 == null) {
                g(0);
            }
            this.f23020h = null;
            this.f23019g = function0;
            if (t != null) {
                this.f23020h = new SoftReference<>(b(t));
            }
        }

        private static /* synthetic */ void g(int i2) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
        }

        @Override // kotlin.f0.y.e.a0.c, kotlin.jvm.functions.Function0
        public T invoke() {
            Object obj;
            SoftReference<Object> softReference = this.f23020h;
            if (softReference != null && (obj = softReference.get()) != null) {
                return e(obj);
            }
            T tInvoke = this.f23019g.invoke();
            this.f23020h = new SoftReference<>(b(tInvoke));
            return tInvoke;
        }
    }

    /* JADX INFO: compiled from: ReflectProperties.java */
    public static class b<T> extends c<T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Function0<T> f23021g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private volatile Object f23022h;

        public b(Function0<T> function0) {
            if (function0 == null) {
                g(0);
            }
            this.f23022h = null;
            this.f23021g = function0;
        }

        private static /* synthetic */ void g(int i2) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"));
        }

        @Override // kotlin.f0.y.e.a0.c, kotlin.jvm.functions.Function0
        public T invoke() {
            Object obj = this.f23022h;
            if (obj != null) {
                return e(obj);
            }
            T tInvoke = this.f23021g.invoke();
            this.f23022h = b(tInvoke);
            return tInvoke;
        }
    }

    /* JADX INFO: compiled from: ReflectProperties.java */
    public static abstract class c<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Object f23023f = new a();

        /* JADX INFO: compiled from: ReflectProperties.java */
        static class a {
            a() {
            }
        }

        protected Object b(T t) {
            return t == null ? f23023f : t;
        }

        public final T c(Object obj, Object obj2) {
            return invoke();
        }

        /* JADX WARN: Multi-variable type inference failed */
        protected T e(Object obj) {
            if (obj == f23023f) {
                return null;
            }
            return obj;
        }

        public abstract T invoke();
    }

    private static /* synthetic */ void a(int i2) {
        Object[] objArr = new Object[3];
        objArr[0] = "initializer";
        objArr[1] = "kotlin/reflect/jvm/internal/ReflectProperties";
        if (i2 == 1 || i2 == 2) {
            objArr[2] = "lazySoft";
        } else {
            objArr[2] = "lazy";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static <T> b<T> b(Function0<T> function0) {
        if (function0 == null) {
            a(0);
        }
        return new b<>(function0);
    }

    public static <T> a<T> c(T t, Function0<T> function0) {
        if (function0 == null) {
            a(1);
        }
        return new a<>(t, function0);
    }

    public static <T> a<T> d(Function0<T> function0) {
        if (function0 == null) {
            a(2);
        }
        return c(null, function0);
    }
}
