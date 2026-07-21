package kotlin.reflect.y.internal.calls;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.j;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.f0.y.e.i0.i, reason: from Kotlin metadata */
/* JADX INFO: compiled from: InternalUnderlyingValOfInlineClass.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002\u0016\u0017B\u001d\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J%\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0004¢\u0006\u0002\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0002\u0018\u0019¨\u0006\u001a"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Method;", "unboxMethod", "parameterTypes", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Method;Ljava/util/List;)V", "member", "getMember", "()Ljava/lang/reflect/Method;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "callMethod", HttpUrl.FRAGMENT_ENCODE_SET, "instance", "args", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "Bound", "Unbound", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Bound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class InternalUnderlyingValOfInlineClass implements Caller<Method> {
    private final Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Type> f23143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Type f23144c;

    /* JADX INFO: renamed from: kotlin.f0.y.e.i0.i$a */
    /* JADX INFO: compiled from: InternalUnderlyingValOfInlineClass.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Bound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "unboxMethod", "Ljava/lang/reflect/Method;", "boundReceiver", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends InternalUnderlyingValOfInlineClass implements BoundCaller {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Object f23145d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Method method, Object obj) {
            super(method, u.j(), null);
            m.f(method, "unboxMethod");
            this.f23145d = obj;
        }

        @Override // kotlin.reflect.y.internal.calls.Caller
        public Object call(Object[] args) {
            m.f(args, "args");
            c(args);
            return b(this.f23145d, args);
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.i0.i$b */
    /* JADX INFO: compiled from: InternalUnderlyingValOfInlineClass.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "unboxMethod", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", HttpUrl.FRAGMENT_ENCODE_SET, "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends InternalUnderlyingValOfInlineClass {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Method method) {
            super(method, t.e(method.getDeclaringClass()), null);
            m.f(method, "unboxMethod");
        }

        @Override // kotlin.reflect.y.internal.calls.Caller
        public Object call(Object[] args) {
            Object[] objArrI;
            m.f(args, "args");
            c(args);
            Object obj = args[0];
            CallerImpl.d dVar = CallerImpl.a;
            if (args.length <= 1) {
                objArrI = new Object[0];
            } else {
                objArrI = j.i(args, 1, args.length);
                m.d(objArrI, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.jvm.internal.calls.CallerImpl.Companion.dropFirst>");
            }
            return b(obj, objArrI);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private InternalUnderlyingValOfInlineClass(Method method, List<? extends Type> list) {
        this.a = method;
        this.f23143b = list;
        Class<?> returnType = method.getReturnType();
        m.e(returnType, "unboxMethod.returnType");
        this.f23144c = returnType;
    }

    public /* synthetic */ InternalUnderlyingValOfInlineClass(Method method, List list, g gVar) {
        this(method, list);
    }

    @Override // kotlin.reflect.y.internal.calls.Caller
    public final List<Type> a() {
        return this.f23143b;
    }

    protected final Object b(Object obj, Object[] objArr) {
        m.f(objArr, "args");
        return this.a.invoke(obj, Arrays.copyOf(objArr, objArr.length));
    }

    public void c(Object[] objArr) {
        Caller.a.a(this, objArr);
    }

    @Override // kotlin.reflect.y.internal.calls.Caller
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final Method getMember() {
        return null;
    }

    @Override // kotlin.reflect.y.internal.calls.Caller
    /* JADX INFO: renamed from: getReturnType, reason: from getter */
    public final Type getF23144c() {
        return this.f23144c;
    }
}
