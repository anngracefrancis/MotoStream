package kotlin.reflect.y.internal;

import cm.aptoide.pt.database.room.RoomInstalled;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.c0;
import kotlin.collections.n;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.f0.y.e.d, reason: from Kotlin metadata */
/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u0082\u0001\u0005\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "asString", HttpUrl.FRAGMENT_ENCODE_SET, "FakeJavaAnnotationConstructor", "JavaConstructor", "JavaMethod", "KotlinConstructor", "KotlinFunction", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class JvmFunctionSignature {

    /* JADX INFO: renamed from: kotlin.f0.y.e.d$a */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "methods", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "getMethods", "()Ljava/util/List;", "asString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends JvmFunctionSignature {
        private final Class<?> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<Method> f23028b;

        /* JADX INFO: renamed from: kotlin.f0.y.e.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "it", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class C0314a extends Lambda implements Function1<Method, CharSequence> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final C0314a f23029f = new C0314a();

            C0314a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CharSequence invoke(Method method) {
                Class<?> returnType = method.getReturnType();
                m.e(returnType, "it.returnType");
                return kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.d.b(returnType);
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.d$a$b */
        /* JADX INFO: compiled from: Comparisons.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class b<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return kotlin.comparisons.b.a(((Method) t).getName(), ((Method) t2).getName());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class<?> cls) {
            super(null);
            m.f(cls, "jClass");
            this.a = cls;
            Method[] declaredMethods = cls.getDeclaredMethods();
            m.e(declaredMethods, "jClass.declaredMethods");
            this.f23028b = n.Q(declaredMethods, new b());
        }

        @Override // kotlin.reflect.y.internal.JvmFunctionSignature
        /* JADX INFO: renamed from: a */
        public String getF23032b() {
            return c0.e0(this.f23028b, HttpUrl.FRAGMENT_ENCODE_SET, "<init>(", ")V", 0, null, C0314a.f23029f, 24, null);
        }

        public final List<Method> b() {
            return this.f23028b;
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.d$b */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "constructor", "Ljava/lang/reflect/Constructor;", "(Ljava/lang/reflect/Constructor;)V", "getConstructor", "()Ljava/lang/reflect/Constructor;", "asString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends JvmFunctionSignature {
        private final Constructor<?> a;

        /* JADX INFO: renamed from: kotlin.f0.y.e.d$b$a */
        /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "it", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class a extends Lambda implements Function1<Class<?>, CharSequence> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final a f23030f = new a();

            a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CharSequence invoke(Class<?> cls) {
                m.e(cls, "it");
                return kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.d.b(cls);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Constructor<?> constructor) {
            super(null);
            m.f(constructor, "constructor");
            this.a = constructor;
        }

        @Override // kotlin.reflect.y.internal.JvmFunctionSignature
        /* JADX INFO: renamed from: a */
        public String getF23032b() {
            Class<?>[] parameterTypes = this.a.getParameterTypes();
            m.e(parameterTypes, "constructor.parameterTypes");
            return n.I(parameterTypes, HttpUrl.FRAGMENT_ENCODE_SET, "<init>(", ")V", 0, null, a.f23030f, 24, null);
        }

        public final Constructor<?> b() {
            return this.a;
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.d$c */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "getMethod", "()Ljava/lang/reflect/Method;", "asString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends JvmFunctionSignature {
        private final Method a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Method method) {
            super(null);
            m.f(method, "method");
            this.a = method;
        }

        @Override // kotlin.reflect.y.internal.JvmFunctionSignature
        /* JADX INFO: renamed from: a */
        public String getF23032b() {
            return e0.b(this.a);
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final Method getA() {
            return this.a;
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.d$d */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", RoomInstalled.SIGNATURE, "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "_signature", HttpUrl.FRAGMENT_ENCODE_SET, "constructorDesc", "getConstructorDesc", "()Ljava/lang/String;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "asString", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d extends JvmFunctionSignature {
        private final kotlin.f0.y.e.j0.e.a0.b.d.b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f23031b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(kotlin.f0.y.e.j0.e.a0.b.d.b bVar) {
            super(null);
            m.f(bVar, RoomInstalled.SIGNATURE);
            this.a = bVar;
            this.f23031b = bVar.a();
        }

        @Override // kotlin.reflect.y.internal.JvmFunctionSignature
        /* JADX INFO: renamed from: a, reason: from getter */
        public String getF23032b() {
            return this.f23031b;
        }

        public final String b() {
            return this.a.b();
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.d$e */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", RoomInstalled.SIGNATURE, "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "_signature", HttpUrl.FRAGMENT_ENCODE_SET, "methodDesc", "getMethodDesc", "()Ljava/lang/String;", "methodName", "getMethodName", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "asString", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e extends JvmFunctionSignature {
        private final kotlin.f0.y.e.j0.e.a0.b.d.b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f23032b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(kotlin.f0.y.e.j0.e.a0.b.d.b bVar) {
            super(null);
            m.f(bVar, RoomInstalled.SIGNATURE);
            this.a = bVar;
            this.f23032b = bVar.a();
        }

        @Override // kotlin.reflect.y.internal.JvmFunctionSignature
        /* JADX INFO: renamed from: a, reason: from getter */
        public String getF23032b() {
            return this.f23032b;
        }

        public final String b() {
            return this.a.b();
        }

        public final String c() {
            return this.a.c();
        }
    }

    private JvmFunctionSignature() {
    }

    public /* synthetic */ JvmFunctionSignature(g gVar) {
        this();
    }

    /* JADX INFO: renamed from: a */
    public abstract String getF23032b();
}
