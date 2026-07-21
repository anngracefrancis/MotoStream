package kotlin.reflect.y.internal.calls;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.j;
import kotlin.collections.n;
import kotlin.jvm.internal.j0;
import kotlin.jvm.internal.m;
import kotlin.u;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.f0.y.e.i0.e, reason: from Kotlin metadata */
/* JADX INFO: compiled from: CallerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u001e*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\b\u001b\u001c\u001d\u001e\u001f !\"B3\b\u0004\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0004R\u0017\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0082\u0001\u0007#$%&'()¨\u0006*"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "member", "returnType", "Ljava/lang/reflect/Type;", "instanceClass", "Ljava/lang/Class;", "valueParameterTypes", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/reflect/Member;Ljava/lang/reflect/Type;Ljava/lang/Class;[Ljava/lang/reflect/Type;)V", "getInstanceClass", "()Ljava/lang/Class;", "getMember", "()Ljava/lang/reflect/Member;", "Ljava/lang/reflect/Member;", "parameterTypes", HttpUrl.FRAGMENT_ENCODE_SET, "getParameterTypes", "()Ljava/util/List;", "getReturnType", "()Ljava/lang/reflect/Type;", "checkObjectInstance", HttpUrl.FRAGMENT_ENCODE_SET, "obj", HttpUrl.FRAGMENT_ENCODE_SET, "AccessorForHiddenBoundConstructor", "AccessorForHiddenConstructor", "BoundConstructor", "Companion", "Constructor", "FieldGetter", "FieldSetter", "Method", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenBoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$BoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Constructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class CallerImpl<M extends Member> implements Caller<M> {
    public static final d a = new d(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final M f23127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Type f23128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Class<?> f23129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<Type> f23130e;

    /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$a */
    /* JADX INFO: compiled from: CallerImpl.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00012\u00020\u0003B\u001b\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenBoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "constructor", "boundReceiver", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "call", "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends CallerImpl<Constructor<?>> implements BoundCaller {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Object f23131f;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(Constructor<?> constructor, Object obj) {
            Object objI;
            m.f(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            m.e(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            m.e(genericParameterTypes, "constructor.genericParameterTypes");
            if (genericParameterTypes.length <= 2) {
                objI = new Type[0];
            } else {
                objI = j.i(genericParameterTypes, 1, genericParameterTypes.length - 1);
                m.d(objI, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.jvm.internal.calls.CallerImpl.Companion.dropFirstAndLast>");
            }
            super(constructor, declaringClass, null, (Type[]) objI, null);
            this.f23131f = obj;
        }

        @Override // kotlin.reflect.y.internal.calls.Caller
        public Object call(Object[] args) {
            m.f(args, "args");
            b(args);
            Constructor<?> member = getMember();
            j0 j0Var = new j0(3);
            j0Var.a(this.f23131f);
            j0Var.b(args);
            j0Var.a(null);
            return member.newInstance(j0Var.d(new Object[j0Var.c()]));
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$b */
    /* JADX INFO: compiled from: CallerImpl.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "(Ljava/lang/reflect/Constructor;)V", "call", HttpUrl.FRAGMENT_ENCODE_SET, "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends CallerImpl<Constructor<?>> {
        /* JADX WARN: Illegal instructions before constructor call */
        public b(Constructor<?> constructor) {
            Object objI;
            m.f(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            m.e(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            m.e(genericParameterTypes, "constructor.genericParameterTypes");
            if (genericParameterTypes.length <= 1) {
                objI = new Type[0];
            } else {
                objI = j.i(genericParameterTypes, 0, genericParameterTypes.length - 1);
                m.d(objI, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.jvm.internal.calls.CallerImpl.Companion.dropLast>");
            }
            super(constructor, declaringClass, null, (Type[]) objI, null);
        }

        @Override // kotlin.reflect.y.internal.calls.Caller
        public Object call(Object[] args) {
            m.f(args, "args");
            b(args);
            Constructor<?> member = getMember();
            j0 j0Var = new j0(2);
            j0Var.b(args);
            j0Var.a(null);
            return member.newInstance(j0Var.d(new Object[j0Var.c()]));
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$c */
    /* JADX INFO: compiled from: CallerImpl.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002B\u001b\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$BoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "boundReceiver", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "call", "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends CallerImpl<Constructor<?>> implements BoundCaller {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Object f23132f;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(Constructor<?> constructor, Object obj) {
            m.f(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            m.e(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            m.e(genericParameterTypes, "constructor.genericParameterTypes");
            super(constructor, declaringClass, null, genericParameterTypes, null);
            this.f23132f = obj;
        }

        @Override // kotlin.reflect.y.internal.calls.Caller
        public Object call(Object[] args) {
            m.f(args, "args");
            b(args);
            Constructor<?> member = getMember();
            j0 j0Var = new j0(2);
            j0Var.a(this.f23132f);
            j0Var.b(args);
            return member.newInstance(j0Var.d(new Object[j0Var.c()]));
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$d */
    /* JADX INFO: compiled from: CallerImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0001\u0010\u0005\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u0004H\u0086\b¢\u0006\u0002\u0010\u0006J(\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0001\u0010\u0005\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u0004H\u0086\b¢\u0006\u0002\u0010\u0006J(\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0001\u0010\u0005\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u0004H\u0086\b¢\u0006\u0002\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "dropFirst", HttpUrl.FRAGMENT_ENCODE_SET, "T", "([Ljava/lang/Object;)[Ljava/lang/Object;", "dropFirstAndLast", "dropLast", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$e */
    /* JADX INFO: compiled from: CallerImpl.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Constructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "(Ljava/lang/reflect/Constructor;)V", "call", HttpUrl.FRAGMENT_ENCODE_SET, "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e extends CallerImpl<Constructor<?>> {
        /* JADX WARN: Illegal instructions before constructor call */
        public e(Constructor<?> constructor) {
            m.f(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            m.e(declaringClass, "constructor.declaringClass");
            Class<?> declaringClass2 = constructor.getDeclaringClass();
            Class<?> declaringClass3 = declaringClass2.getDeclaringClass();
            Class<?> cls = (declaringClass3 == null || Modifier.isStatic(declaringClass2.getModifiers())) ? null : declaringClass3;
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            m.e(genericParameterTypes, "constructor.genericParameterTypes");
            super(constructor, declaringClass, cls, genericParameterTypes, null);
        }

        @Override // kotlin.reflect.y.internal.calls.Caller
        public Object call(Object[] args) {
            m.f(args, "args");
            b(args);
            return getMember().newInstance(Arrays.copyOf(args, args.length));
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$f */
    /* JADX INFO: compiled from: CallerImpl.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\f\r\u000e\u000f\u0010B\u0017\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000b\u0082\u0001\u0005\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "requiresInstance", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/reflect/Field;Z)V", "call", HttpUrl.FRAGMENT_ENCODE_SET, "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "BoundInstance", "BoundJvmStaticInObject", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Static;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class f extends CallerImpl<Field> {

        /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$f$a */
        /* JADX INFO: compiled from: CallerImpl.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "boundReceiver", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/reflect/Field;Ljava/lang/Object;)V", "call", "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends f implements BoundCaller {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final Object f23133f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Field field, Object obj) {
                super(field, false, null);
                m.f(field, "field");
                this.f23133f = obj;
            }

            @Override // kotlin.reflect.y.internal.calls.CallerImpl.f, kotlin.reflect.y.internal.calls.Caller
            public Object call(Object[] args) {
                m.f(args, "args");
                b(args);
                return getMember().get(this.f23133f);
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$f$b */
        /* JADX INFO: compiled from: CallerImpl.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class b extends f implements BoundCaller {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Field field) {
                super(field, false, null);
                m.f(field, "field");
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$f$c */
        /* JADX INFO: compiled from: CallerImpl.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class c extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Field field) {
                super(field, true, null);
                m.f(field, "field");
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$f$d */
        /* JADX INFO: compiled from: CallerImpl.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "checkArguments", HttpUrl.FRAGMENT_ENCODE_SET, "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class d extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Field field) {
                super(field, true, null);
                m.f(field, "field");
            }

            @Override // kotlin.reflect.y.internal.calls.CallerImpl
            public void b(Object[] objArr) {
                m.f(objArr, "args");
                super.b(objArr);
                c(j.x(objArr));
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$f$e */
        /* JADX INFO: compiled from: CallerImpl.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class e extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(Field field) {
                super(field, false, null);
                m.f(field, "field");
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private f(Field field, boolean z) {
            Type genericType = field.getGenericType();
            m.e(genericType, "field.genericType");
            super(field, genericType, z ? field.getDeclaringClass() : null, new Type[0], null);
        }

        public /* synthetic */ f(Field field, boolean z, kotlin.jvm.internal.g gVar) {
            this(field, z);
        }

        @Override // kotlin.reflect.y.internal.calls.Caller
        public Object call(Object[] args) {
            m.f(args, "args");
            b(args);
            return getMember().get(d() != null ? j.w(args) : null);
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$g */
    /* JADX INFO: compiled from: CallerImpl.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\u0010\u0011\u0012\u0013\u0014B\u001f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u000e2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0005\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "notNull", HttpUrl.FRAGMENT_ENCODE_SET, "requiresInstance", "(Ljava/lang/reflect/Field;ZZ)V", "call", HttpUrl.FRAGMENT_ENCODE_SET, "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "checkArguments", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)V", "BoundInstance", "BoundJvmStaticInObject", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Static;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class g extends CallerImpl<Field> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f23134f;

        /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$g$a */
        /* JADX INFO: compiled from: CallerImpl.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\b2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0016¢\u0006\u0002\u0010\rR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", HttpUrl.FRAGMENT_ENCODE_SET, "boundReceiver", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/reflect/Field;ZLjava/lang/Object;)V", "call", "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends g implements BoundCaller {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final Object f23135g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Field field, boolean z, Object obj) {
                super(field, z, false, null);
                m.f(field, "field");
                this.f23135g = obj;
            }

            @Override // kotlin.reflect.y.internal.calls.CallerImpl.g, kotlin.reflect.y.internal.calls.Caller
            public Object call(Object[] args) throws IllegalAccessException {
                m.f(args, "args");
                b(args);
                getMember().set(this.f23135g, j.w(args));
                return u.a;
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$g$b */
        /* JADX INFO: compiled from: CallerImpl.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/reflect/Field;Z)V", "call", HttpUrl.FRAGMENT_ENCODE_SET, "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class b extends g implements BoundCaller {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Field field, boolean z) {
                super(field, z, false, null);
                m.f(field, "field");
            }

            @Override // kotlin.reflect.y.internal.calls.CallerImpl.g, kotlin.reflect.y.internal.calls.Caller
            public Object call(Object[] args) throws IllegalAccessException {
                m.f(args, "args");
                b(args);
                getMember().set(null, j.J(args));
                return u.a;
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$g$c */
        /* JADX INFO: compiled from: CallerImpl.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class c extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Field field, boolean z) {
                super(field, z, true, null);
                m.f(field, "field");
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$g$d */
        /* JADX INFO: compiled from: CallerImpl.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/reflect/Field;Z)V", "checkArguments", HttpUrl.FRAGMENT_ENCODE_SET, "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class d extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Field field, boolean z) {
                super(field, z, true, null);
                m.f(field, "field");
            }

            @Override // kotlin.reflect.y.internal.calls.CallerImpl.g, kotlin.reflect.y.internal.calls.CallerImpl
            public void b(Object[] objArr) {
                m.f(objArr, "args");
                super.b(objArr);
                c(j.x(objArr));
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$g$e */
        /* JADX INFO: compiled from: CallerImpl.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class e extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(Field field, boolean z) {
                super(field, z, false, null);
                m.f(field, "field");
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private g(Field field, boolean z, boolean z2) {
            Class cls = Void.TYPE;
            m.e(cls, "TYPE");
            Class<?> declaringClass = z2 ? field.getDeclaringClass() : null;
            Type genericType = field.getGenericType();
            m.e(genericType, "field.genericType");
            super(field, cls, declaringClass, new Type[]{genericType}, null);
            this.f23134f = z;
        }

        public /* synthetic */ g(Field field, boolean z, boolean z2, kotlin.jvm.internal.g gVar) {
            this(field, z, z2);
        }

        @Override // kotlin.reflect.y.internal.calls.CallerImpl
        public void b(Object[] objArr) {
            m.f(objArr, "args");
            super.b(objArr);
            if (this.f23134f && j.J(objArr) == null) {
                throw new IllegalArgumentException("null is not allowed as a value for this property.");
            }
        }

        @Override // kotlin.reflect.y.internal.calls.Caller
        public Object call(Object[] args) throws IllegalAccessException {
            m.f(args, "args");
            b(args);
            getMember().set(d() != null ? j.w(args) : null, j.J(args));
            return u.a;
        }
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0027  */
    private CallerImpl(M m, Type type, Class<?> cls, Type[] typeArr) {
        List<Type> listZ;
        this.f23127b = m;
        this.f23128c = type;
        this.f23129d = cls;
        if (cls != null) {
            j0 j0Var = new j0(2);
            j0Var.a(cls);
            j0Var.b(typeArr);
            listZ = kotlin.collections.u.m(j0Var.d(new Type[j0Var.c()]));
            listZ = listZ == null ? n.Z(typeArr) : listZ;
        }
        this.f23130e = listZ;
    }

    public /* synthetic */ CallerImpl(Member member, Type type, Class cls, Type[] typeArr, kotlin.jvm.internal.g gVar) {
        this(member, type, cls, typeArr);
    }

    @Override // kotlin.reflect.y.internal.calls.Caller
    public List<Type> a() {
        return this.f23130e;
    }

    public void b(Object[] objArr) {
        Caller.a.a(this, objArr);
    }

    protected final void c(Object obj) {
        if (obj == null || !this.f23127b.getDeclaringClass().isInstance(obj)) {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    public final Class<?> d() {
        return this.f23129d;
    }

    @Override // kotlin.reflect.y.internal.calls.Caller
    public final M getMember() {
        return this.f23127b;
    }

    @Override // kotlin.reflect.y.internal.calls.Caller
    /* JADX INFO: renamed from: getReturnType, reason: from getter */
    public final Type getF23128c() {
        return this.f23128c;
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$h */
    /* JADX INFO: compiled from: CallerImpl.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006\u0010\u0011\u0012\u0013\u0014\u0015B)\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ%\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0004¢\u0006\u0002\u0010\u000fR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0006\u0016\u0017\u0018\u0019\u001a\u001b¨\u0006\u001c"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Method;", "method", "requiresInstance", HttpUrl.FRAGMENT_ENCODE_SET, "parameterTypes", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Method;Z[Ljava/lang/reflect/Type;)V", "isVoidMethod", "callMethod", HttpUrl.FRAGMENT_ENCODE_SET, "instance", "args", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "BoundInstance", "BoundJvmStaticInObject", "BoundStatic", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStatic;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Static;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class h extends CallerImpl<Method> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f23136f;

        /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$h$a */
        /* JADX INFO: compiled from: CallerImpl.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends h implements BoundCaller {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final Object f23137g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Method method, Object obj) {
                super(method, false, null, 4, null);
                m.f(method, "method");
                this.f23137g = obj;
            }

            @Override // kotlin.reflect.y.internal.calls.Caller
            public Object call(Object[] args) {
                m.f(args, "args");
                b(args);
                return e(this.f23137g, args);
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$h$b */
        /* JADX INFO: compiled from: CallerImpl.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", HttpUrl.FRAGMENT_ENCODE_SET, "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class b extends h implements BoundCaller {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Method method) {
                super(method, false, null, 4, null);
                m.f(method, "method");
            }

            @Override // kotlin.reflect.y.internal.calls.Caller
            public Object call(Object[] args) {
                m.f(args, "args");
                b(args);
                return e(null, args);
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$h$c */
        /* JADX INFO: compiled from: CallerImpl.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStatic;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class c extends h implements BoundCaller {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final Object f23138g;

            /* JADX WARN: Illegal instructions before constructor call */
            public c(Method method, Object obj) {
                Object objI;
                m.f(method, "method");
                Type[] genericParameterTypes = method.getGenericParameterTypes();
                m.e(genericParameterTypes, "method.genericParameterTypes");
                boolean z = false;
                if (genericParameterTypes.length <= 1) {
                    objI = new Type[0];
                } else {
                    objI = j.i(genericParameterTypes, 1, genericParameterTypes.length);
                    m.d(objI, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.jvm.internal.calls.CallerImpl.Companion.dropFirst>");
                }
                super(method, z, (Type[]) objI, null);
                this.f23138g = obj;
            }

            @Override // kotlin.reflect.y.internal.calls.Caller
            public Object call(Object[] args) {
                m.f(args, "args");
                b(args);
                j0 j0Var = new j0(2);
                j0Var.a(this.f23138g);
                j0Var.b(args);
                return e(null, j0Var.d(new Object[j0Var.c()]));
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$h$d */
        /* JADX INFO: compiled from: CallerImpl.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", HttpUrl.FRAGMENT_ENCODE_SET, "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class d extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Method method) {
                super(method, false, null, 6, null);
                m.f(method, "method");
            }

            @Override // kotlin.reflect.y.internal.calls.Caller
            public Object call(Object[] args) {
                Object[] objArrI;
                m.f(args, "args");
                b(args);
                Object obj = args[0];
                if (args.length <= 1) {
                    objArrI = new Object[0];
                } else {
                    objArrI = j.i(args, 1, args.length);
                    m.d(objArrI, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.jvm.internal.calls.CallerImpl.Companion.dropFirst>");
                }
                return e(obj, objArrI);
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$h$e */
        /* JADX INFO: compiled from: CallerImpl.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", HttpUrl.FRAGMENT_ENCODE_SET, "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class e extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(Method method) {
                super(method, true, null, 4, null);
                m.f(method, "method");
            }

            @Override // kotlin.reflect.y.internal.calls.Caller
            public Object call(Object[] args) {
                Object[] objArrI;
                m.f(args, "args");
                b(args);
                c(j.x(args));
                if (args.length <= 1) {
                    objArrI = new Object[0];
                } else {
                    objArrI = j.i(args, 1, args.length);
                    m.d(objArrI, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.jvm.internal.calls.CallerImpl.Companion.dropFirst>");
                }
                return e(null, objArrI);
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.i0.e$h$f */
        /* JADX INFO: compiled from: CallerImpl.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", HttpUrl.FRAGMENT_ENCODE_SET, "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class f extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(Method method) {
                super(method, false, null, 6, null);
                m.f(method, "method");
            }

            @Override // kotlin.reflect.y.internal.calls.Caller
            public Object call(Object[] args) {
                m.f(args, "args");
                b(args);
                return e(null, args);
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ h(Method method, boolean z, Type[] typeArr, int i2, kotlin.jvm.internal.g gVar) {
            z = (i2 & 2) != 0 ? !Modifier.isStatic(method.getModifiers()) : z;
            if ((i2 & 4) != 0) {
                typeArr = method.getGenericParameterTypes();
                m.e(typeArr, "method.genericParameterTypes");
            }
            this(method, z, typeArr, null);
        }

        public /* synthetic */ h(Method method, boolean z, Type[] typeArr, kotlin.jvm.internal.g gVar) {
            this(method, z, typeArr);
        }

        protected final Object e(Object obj, Object[] objArr) {
            m.f(objArr, "args");
            return this.f23136f ? u.a : getMember().invoke(obj, Arrays.copyOf(objArr, objArr.length));
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private h(Method method, boolean z, Type[] typeArr) {
            Type genericReturnType = method.getGenericReturnType();
            m.e(genericReturnType, "method.genericReturnType");
            super(method, genericReturnType, z ? method.getDeclaringClass() : null, typeArr, null);
            this.f23136f = m.a(getF23128c(), Void.TYPE);
        }
    }
}
