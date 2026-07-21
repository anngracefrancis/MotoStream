package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CopyableThrowable;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ExceptionsConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a2\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u0007\"\b\b\u0000\u0010\b*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0002\u001a*\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00072\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0002\u001a1\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u00072\u0014\b\u0004\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0082\b\u001a!\u0010\u0010\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00062\u0006\u0010\u0011\u001a\u0002H\bH\u0000¢\u0006\u0002\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0003H\u0082\u0010\u001a\u0018\u0010\u0015\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000*(\b\u0002\u0010\u0017\"\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¨\u0006\u0018"}, d2 = {"ctorCache", "Lkotlinx/coroutines/internal/CtorCache;", "throwableFields", HttpUrl.FRAGMENT_ENCODE_SET, "createConstructor", "Lkotlin/Function1;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/internal/Ctor;", "E", "clz", "Ljava/lang/Class;", "createSafeConstructor", "constructor", "Ljava/lang/reflect/Constructor;", "safeCtor", "block", "tryCopyException", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class j {
    private static final int a = f(Throwable.class, -1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CtorCache f25806b;

    /* JADX INFO: compiled from: Comparisons.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return kotlin.comparisons.b.a(Integer.valueOf(((Constructor) t2).getParameterTypes().length), Integer.valueOf(((Constructor) t).getParameterTypes().length));
        }
    }

    /* JADX INFO: compiled from: ExceptionsConstructor.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "E", HttpUrl.FRAGMENT_ENCODE_SET, "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends Lambda implements Function1 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f25807f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Throwable th) {
            return null;
        }
    }

    /* JADX INFO: compiled from: ExceptionsConstructor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstructorKt$safeCtor$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class c extends Lambda implements Function1<Throwable, Throwable> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Constructor f25808f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Constructor constructor) {
            super(1);
            this.f25808f = constructor;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Throwable invoke(Throwable th) {
            Object objA;
            try {
                Result.a aVar = Result.f25108f;
                Object objNewInstance = this.f25808f.newInstance(th.getMessage(), th);
                if (objNewInstance == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
                objA = Result.a((Throwable) objNewInstance);
                if (Result.c(objA)) {
                    objA = null;
                }
                return (Throwable) objA;
            } catch (Throwable th2) {
                Result.a aVar2 = Result.f25108f;
                objA = Result.a(kotlin.o.a(th2));
            }
        }
    }

    /* JADX INFO: compiled from: ExceptionsConstructor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstructorKt$safeCtor$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class d extends Lambda implements Function1<Throwable, Throwable> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Constructor f25809f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Constructor constructor) {
            super(1);
            this.f25809f = constructor;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Throwable invoke(Throwable th) {
            Object objA;
            try {
                Result.a aVar = Result.f25108f;
                Object objNewInstance = this.f25809f.newInstance(th);
                if (objNewInstance == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
                objA = Result.a((Throwable) objNewInstance);
                if (Result.c(objA)) {
                    objA = null;
                }
                return (Throwable) objA;
            } catch (Throwable th2) {
                Result.a aVar2 = Result.f25108f;
                objA = Result.a(kotlin.o.a(th2));
            }
        }
    }

    /* JADX INFO: compiled from: ExceptionsConstructor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstructorKt$safeCtor$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class e extends Lambda implements Function1<Throwable, Throwable> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Constructor f25810f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Constructor constructor) {
            super(1);
            this.f25810f = constructor;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Throwable invoke(Throwable th) {
            Object objA;
            try {
                Result.a aVar = Result.f25108f;
                Object objNewInstance = this.f25810f.newInstance(th.getMessage());
                if (objNewInstance == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
                Throwable th2 = (Throwable) objNewInstance;
                th2.initCause(th);
                objA = Result.a(th2);
                if (Result.c(objA)) {
                    objA = null;
                }
                return (Throwable) objA;
            } catch (Throwable th3) {
                Result.a aVar2 = Result.f25108f;
                objA = Result.a(kotlin.o.a(th3));
            }
        }
    }

    /* JADX INFO: compiled from: ExceptionsConstructor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstructorKt$safeCtor$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class f extends Lambda implements Function1<Throwable, Throwable> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Constructor f25811f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Constructor constructor) {
            super(1);
            this.f25811f = constructor;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Throwable invoke(Throwable th) {
            Object objA;
            try {
                Result.a aVar = Result.f25108f;
                Object objNewInstance = this.f25811f.newInstance(new Object[0]);
                if (objNewInstance == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
                Throwable th2 = (Throwable) objNewInstance;
                th2.initCause(th);
                objA = Result.a(th2);
                if (Result.c(objA)) {
                    objA = null;
                }
                return (Throwable) objA;
            } catch (Throwable th3) {
                Result.a aVar2 = Result.f25108f;
                objA = Result.a(kotlin.o.a(th3));
            }
        }
    }

    static {
        CtorCache ctorCache;
        try {
            ctorCache = l.a() ? WeakMapCtorCache.a : ClassValueCtorCache.a;
        } catch (Throwable unused) {
            ctorCache = WeakMapCtorCache.a;
        }
        f25806b = ctorCache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E extends Throwable> Function1<Throwable, Throwable> b(Class<E> cls) {
        b bVar = b.f25807f;
        if (a != f(cls, 0)) {
            return bVar;
        }
        Iterator it = kotlin.collections.n.Q(cls.getConstructors(), new a()).iterator();
        while (it.hasNext()) {
            Function1<Throwable, Throwable> function1C = c((Constructor) it.next());
            if (function1C != null) {
                return function1C;
            }
        }
        return bVar;
    }

    private static final Function1<Throwable, Throwable> c(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return new f(constructor);
        }
        if (length != 1) {
            if (length == 2 && kotlin.jvm.internal.m.a(parameterTypes[0], String.class) && kotlin.jvm.internal.m.a(parameterTypes[1], Throwable.class)) {
                return new c(constructor);
            }
            return null;
        }
        Class<?> cls = parameterTypes[0];
        if (kotlin.jvm.internal.m.a(cls, Throwable.class)) {
            return new d(constructor);
        }
        if (kotlin.jvm.internal.m.a(cls, String.class)) {
            return new e(constructor);
        }
        return null;
    }

    private static final int d(Class<?> cls, int i2) {
        do {
            int i3 = 0;
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    i3++;
                }
            }
            i2 += i3;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i2;
    }

    static /* synthetic */ int e(Class cls, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return d(cls, i2);
    }

    private static final int f(Class<?> cls, int i2) {
        Object objA;
        kotlin.jvm.a.e(cls);
        try {
            Result.a aVar = Result.f25108f;
            objA = Result.a(Integer.valueOf(e(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f25108f;
            objA = Result.a(kotlin.o.a(th));
        }
        Integer numValueOf = Integer.valueOf(i2);
        if (Result.c(objA)) {
            objA = numValueOf;
        }
        return ((Number) objA).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E extends Throwable> E g(E e2) {
        Object objA;
        if (!(e2 instanceof CopyableThrowable)) {
            return (E) f25806b.a(e2.getClass()).invoke(e2);
        }
        try {
            Result.a aVar = Result.f25108f;
            objA = Result.a(((CopyableThrowable) e2).a());
        } catch (Throwable th) {
            Result.a aVar2 = Result.f25108f;
            objA = Result.a(kotlin.o.a(th));
        }
        if (Result.c(objA)) {
            objA = null;
        }
        return (E) objA;
    }
}
