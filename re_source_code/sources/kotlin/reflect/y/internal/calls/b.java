package kotlin.reflect.y.internal.calls;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.c0;
import kotlin.collections.j;
import kotlin.collections.n;
import kotlin.collections.v;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.reflect.KClass;
import kotlin.reflect.y.internal.KotlinReflectionInternalError;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001aI\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000¢\u0006\u0002\u0010\u000b\u001a$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002\u001a\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u00022\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¨\u0006\u0014²\u0006\u0014\u0010\u0015\u001a\u00020\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0002X\u008a\u0084\u0002²\u0006\u0014\u0010\u0016\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0002X\u008a\u0084\u0002"}, d2 = {"createAnnotationInstance", "T", HttpUrl.FRAGMENT_ENCODE_SET, "annotationClass", "Ljava/lang/Class;", "values", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "methods", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "throwIllegalArgumentType", HttpUrl.FRAGMENT_ENCODE_SET, "index", HttpUrl.FRAGMENT_ENCODE_SET, "name", "expectedJvmType", "transformKotlinToJvm", "expectedType", "kotlin-reflection", "hashCode", "toString"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "T", HttpUrl.FRAGMENT_ENCODE_SET, "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class a extends Lambda implements Function0<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f23119f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Map<String, ? extends Object> map) {
            super(0);
            this.f23119f = map;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            int iHashCode;
            Iterator<T> it = this.f23119f.entrySet().iterator();
            int iHashCode2 = 0;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof boolean[]) {
                    iHashCode = Arrays.hashCode((boolean[]) value);
                } else if (value instanceof char[]) {
                    iHashCode = Arrays.hashCode((char[]) value);
                } else if (value instanceof byte[]) {
                    iHashCode = Arrays.hashCode((byte[]) value);
                } else if (value instanceof short[]) {
                    iHashCode = Arrays.hashCode((short[]) value);
                } else if (value instanceof int[]) {
                    iHashCode = Arrays.hashCode((int[]) value);
                } else if (value instanceof float[]) {
                    iHashCode = Arrays.hashCode((float[]) value);
                } else if (value instanceof long[]) {
                    iHashCode = Arrays.hashCode((long[]) value);
                } else if (value instanceof double[]) {
                    iHashCode = Arrays.hashCode((double[]) value);
                } else {
                    iHashCode = value instanceof Object[] ? Arrays.hashCode((Object[]) value) : value.hashCode();
                }
                iHashCode2 += iHashCode ^ (str.hashCode() * 127);
            }
            return Integer.valueOf(iHashCode2);
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.i0.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u00012\u000e\u0010\u0004\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00060\u00062,\u0010\u0007\u001a(\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\b0\bH\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin.jvm.PlatformType", "T", "<anonymous parameter 0>", "method", "Ljava/lang/reflect/Method;", "args", HttpUrl.FRAGMENT_ENCODE_SET, "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class C0318b implements InvocationHandler {
        final /* synthetic */ Class<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f23120b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Lazy<String> f23121c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Lazy<Integer> f23122d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ List<Method> f23123e;

        C0318b(Class<T> cls, Map<String, ? extends Object> map, Lazy<String> lazy, Lazy<Integer> lazy2, List<Method> list) {
            this.a = cls;
            this.f23120b = map;
            this.f23121c = lazy;
            this.f23122d = lazy2;
            this.f23123e = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            if (name != null) {
                int iHashCode = name.hashCode();
                if (iHashCode != -1776922004) {
                    if (iHashCode != 147696667) {
                        if (iHashCode == 1444986633 && name.equals("annotationType")) {
                            return this.a;
                        }
                    } else if (name.equals("hashCode")) {
                        return Integer.valueOf(b.i(this.f23122d));
                    }
                } else if (name.equals("toString")) {
                    return b.j(this.f23121c);
                }
            }
            if (m.a(name, "equals")) {
                if (objArr != null && objArr.length == 1) {
                    Class<T> cls = this.a;
                    List<Method> list = this.f23123e;
                    Map<String, Object> map = this.f23120b;
                    m.e(objArr, "args");
                    return Boolean.valueOf(b.h(cls, list, map, j.N(objArr)));
                }
            }
            if (this.f23120b.containsKey(name)) {
                return this.f23120b.get(name);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Method is not supported: ");
            sb.append(method);
            sb.append(" (args: ");
            if (objArr == null) {
                objArr = new Object[0];
            }
            sb.append(n.Z(objArr));
            sb.append(')');
            throw new KotlinReflectionInternalError(sb.toString());
        }
    }

    /* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "T", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class c extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Class<T> f23124f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f23125g;

        /* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "T", HttpUrl.FRAGMENT_ENCODE_SET, "entry", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class a extends Lambda implements Function1<Map.Entry<? extends String, ? extends Object>, CharSequence> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final a f23126f = new a();

            a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CharSequence invoke(Map.Entry<String, ? extends Object> entry) {
                String string;
                m.f(entry, "entry");
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof boolean[]) {
                    string = Arrays.toString((boolean[]) value);
                    m.e(string, "toString(this)");
                } else if (value instanceof char[]) {
                    string = Arrays.toString((char[]) value);
                    m.e(string, "toString(this)");
                } else if (value instanceof byte[]) {
                    string = Arrays.toString((byte[]) value);
                    m.e(string, "toString(this)");
                } else if (value instanceof short[]) {
                    string = Arrays.toString((short[]) value);
                    m.e(string, "toString(this)");
                } else if (value instanceof int[]) {
                    string = Arrays.toString((int[]) value);
                    m.e(string, "toString(this)");
                } else if (value instanceof float[]) {
                    string = Arrays.toString((float[]) value);
                    m.e(string, "toString(this)");
                } else if (value instanceof long[]) {
                    string = Arrays.toString((long[]) value);
                    m.e(string, "toString(this)");
                } else if (value instanceof double[]) {
                    string = Arrays.toString((double[]) value);
                    m.e(string, "toString(this)");
                } else if (value instanceof Object[]) {
                    string = Arrays.toString((Object[]) value);
                    m.e(string, "toString(this)");
                } else {
                    string = value.toString();
                }
                return key + '=' + string;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Class<T> cls, Map<String, ? extends Object> map) {
            super(0);
            this.f23124f = cls;
            this.f23125g = map;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Class<T> cls = this.f23124f;
            Map<String, Object> map = this.f23125g;
            StringBuilder sb = new StringBuilder();
            sb.append('@');
            sb.append(cls.getCanonicalName());
            c0.c0(map.entrySet(), sb, ", ", "(", ")", 0, null, a.f23126f, 48, null);
            String string = sb.toString();
            m.e(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
    }

    public static final <T> T f(Class<T> cls, Map<String, ? extends Object> map, List<Method> list) {
        m.f(cls, "annotationClass");
        m.f(map, "values");
        m.f(list, "methods");
        Lazy lazyB = i.b(new a(map));
        T t = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new C0318b(cls, map, i.b(new c(cls, map)), lazyB, list));
        m.d(t, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance");
        return t;
    }

    public static /* synthetic */ Object g(Class cls, Map map, List list, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            Set setKeySet = map.keySet();
            ArrayList arrayList = new ArrayList(v.u(setKeySet, 10));
            Iterator it = setKeySet.iterator();
            while (it.hasNext()) {
                arrayList.add(cls.getDeclaredMethod((String) it.next(), new Class[0]));
            }
            list = arrayList;
        }
        return f(cls, map, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> boolean h(Class<T> cls, List<Method> list, Map<String, ? extends Object> map, Object obj) throws IllegalAccessException, InvocationTargetException {
        boolean zA;
        boolean z;
        KClass kClassA;
        Class clsB = null;
        Annotation annotation = obj instanceof Annotation ? (Annotation) obj : null;
        if (annotation != null && (kClassA = kotlin.jvm.a.a(annotation)) != null) {
            clsB = kotlin.jvm.a.b(kClassA);
        }
        if (m.a(clsB, cls)) {
            if ((list instanceof Collection) && list.isEmpty()) {
                z = true;
            } else {
                for (Method method : list) {
                    Object obj2 = map.get(method.getName());
                    Object objInvoke = method.invoke(obj, new Object[0]);
                    if (obj2 instanceof boolean[]) {
                        m.d(objInvoke, "null cannot be cast to non-null type kotlin.BooleanArray");
                        zA = Arrays.equals((boolean[]) obj2, (boolean[]) objInvoke);
                    } else if (obj2 instanceof char[]) {
                        m.d(objInvoke, "null cannot be cast to non-null type kotlin.CharArray");
                        zA = Arrays.equals((char[]) obj2, (char[]) objInvoke);
                    } else if (obj2 instanceof byte[]) {
                        m.d(objInvoke, "null cannot be cast to non-null type kotlin.ByteArray");
                        zA = Arrays.equals((byte[]) obj2, (byte[]) objInvoke);
                    } else if (obj2 instanceof short[]) {
                        m.d(objInvoke, "null cannot be cast to non-null type kotlin.ShortArray");
                        zA = Arrays.equals((short[]) obj2, (short[]) objInvoke);
                    } else if (obj2 instanceof int[]) {
                        m.d(objInvoke, "null cannot be cast to non-null type kotlin.IntArray");
                        zA = Arrays.equals((int[]) obj2, (int[]) objInvoke);
                    } else if (obj2 instanceof float[]) {
                        m.d(objInvoke, "null cannot be cast to non-null type kotlin.FloatArray");
                        zA = Arrays.equals((float[]) obj2, (float[]) objInvoke);
                    } else if (obj2 instanceof long[]) {
                        m.d(objInvoke, "null cannot be cast to non-null type kotlin.LongArray");
                        zA = Arrays.equals((long[]) obj2, (long[]) objInvoke);
                    } else if (obj2 instanceof double[]) {
                        m.d(objInvoke, "null cannot be cast to non-null type kotlin.DoubleArray");
                        zA = Arrays.equals((double[]) obj2, (double[]) objInvoke);
                    } else if (obj2 instanceof Object[]) {
                        m.d(objInvoke, "null cannot be cast to non-null type kotlin.Array<*>");
                        zA = Arrays.equals((Object[]) obj2, (Object[]) objInvoke);
                    } else {
                        zA = m.a(obj2, objInvoke);
                    }
                    if (!zA) {
                        z = false;
                    }
                }
                z = true;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int i(Lazy<Integer> lazy) {
        return lazy.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String j(Lazy<String> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void k(int i2, String str, Class<?> cls) {
        KClass kClassB;
        String strP;
        if (m.a(cls, Class.class)) {
            kClassB = g0.b(KClass.class);
        } else {
            kClassB = (cls.isArray() && m.a(cls.getComponentType(), Class.class)) ? g0.b(KClass[].class) : kotlin.jvm.a.e(cls);
        }
        if (m.a(kClassB.p(), g0.b(Object[].class).p())) {
            StringBuilder sb = new StringBuilder();
            sb.append(kClassB.p());
            sb.append('<');
            Class<?> componentType = kotlin.jvm.a.b(kClassB).getComponentType();
            m.e(componentType, "kotlinClass.java.componentType");
            sb.append(kotlin.jvm.a.e(componentType).p());
            sb.append('>');
            strP = sb.toString();
        } else {
            strP = kClassB.p();
        }
        throw new IllegalArgumentException("Argument #" + i2 + ' ' + str + " is not of the required type " + strP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object l(Object obj, Class<?> cls) {
        if (obj instanceof Class) {
            return null;
        }
        if (obj instanceof KClass) {
            obj = kotlin.jvm.a.b((KClass) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Class[]) {
                return null;
            }
            if (objArr instanceof KClass[]) {
                m.d(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                KClass[] kClassArr = (KClass[]) obj;
                ArrayList arrayList = new ArrayList(kClassArr.length);
                for (KClass kClass : kClassArr) {
                    arrayList.add(kotlin.jvm.a.b(kClass));
                }
                obj = arrayList.toArray(new Class[0]);
                m.d(obj, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            } else {
                obj = objArr;
            }
        }
        if (cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }
}
