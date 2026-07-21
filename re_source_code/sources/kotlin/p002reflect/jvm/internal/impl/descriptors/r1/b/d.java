package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.collections.n;
import kotlin.collections.q0;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.reflect.KClass;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.s;
import kotlin.sequences.Sequence;
import kotlin.sequences.l;

/* JADX INFO: compiled from: reflectClassUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private static final List<KClass<? extends Object>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Class<? extends Object>, Class<? extends Object>> f25337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<Class<? extends Object>, Class<? extends Object>> f25338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<Class<? extends Function<?>>, Integer> f25339d;

    /* JADX INFO: compiled from: reflectClassUtil.kt */
    static final class a extends Lambda implements Function1<ParameterizedType, ParameterizedType> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f25340f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ParameterizedType invoke(ParameterizedType parameterizedType) {
            m.f(parameterizedType, "it");
            Type ownerType = parameterizedType.getOwnerType();
            if (ownerType instanceof ParameterizedType) {
                return (ParameterizedType) ownerType;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: reflectClassUtil.kt */
    static final class b extends Lambda implements Function1<ParameterizedType, Sequence<? extends Type>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f25341f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Sequence<Type> invoke(ParameterizedType parameterizedType) {
            m.f(parameterizedType, "it");
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            m.e(actualTypeArguments, "it.actualTypeArguments");
            return n.r(actualTypeArguments);
        }
    }

    static {
        int i2 = 0;
        List<KClass<? extends Object>> listM = u.m(g0.b(Boolean.TYPE), g0.b(Byte.TYPE), g0.b(Character.TYPE), g0.b(Double.TYPE), g0.b(Float.TYPE), g0.b(Integer.TYPE), g0.b(Long.TYPE), g0.b(Short.TYPE));
        a = listM;
        ArrayList arrayList = new ArrayList(v.u(listM, 10));
        Iterator<T> it = listM.iterator();
        while (it.hasNext()) {
            KClass kClass = (KClass) it.next();
            arrayList.add(s.a(kotlin.jvm.a.c(kClass), kotlin.jvm.a.d(kClass)));
        }
        f25337b = q0.q(arrayList);
        List<KClass<? extends Object>> list = a;
        ArrayList arrayList2 = new ArrayList(v.u(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            KClass kClass2 = (KClass) it2.next();
            arrayList2.add(s.a(kotlin.jvm.a.d(kClass2), kotlin.jvm.a.c(kClass2)));
        }
        f25338c = q0.q(arrayList2);
        List listM2 = u.m(Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class);
        ArrayList arrayList3 = new ArrayList(v.u(listM2, 10));
        for (Object obj : listM2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                u.t();
            }
            arrayList3.add(s.a((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        f25339d = q0.q(arrayList3);
    }

    public static final kotlin.reflect.y.internal.j0.f.b a(Class<?> cls) {
        kotlin.reflect.y.internal.j0.f.b bVarM;
        kotlin.reflect.y.internal.j0.f.b bVarA;
        m.f(cls, "<this>");
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException("Can't compute ClassId for primitive type: " + cls);
        }
        if (cls.isArray()) {
            throw new IllegalArgumentException("Can't compute ClassId for array type: " + cls);
        }
        if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
            String simpleName = cls.getSimpleName();
            m.e(simpleName, "simpleName");
            if (!(simpleName.length() == 0)) {
                Class<?> declaringClass = cls.getDeclaringClass();
                if (declaringClass == null || (bVarA = a(declaringClass)) == null || (bVarM = bVarA.d(f.x(cls.getSimpleName()))) == null) {
                    bVarM = kotlin.reflect.y.internal.j0.f.b.m(new c(cls.getName()));
                }
                m.e(bVarM, "declaringClass?.classId?…Id.topLevel(FqName(name))");
                return bVarM;
            }
        }
        c cVar = new c(cls.getName());
        return new kotlin.reflect.y.internal.j0.f.b(cVar.e(), c.k(cVar.g()), true);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final String b(Class<?> cls) {
        m.f(cls, "<this>");
        if (!cls.isPrimitive()) {
            if (cls.isArray()) {
                String name = cls.getName();
                m.e(name, "name");
                return kotlin.text.u.z(name, '.', '/', false, 4, null);
            }
            StringBuilder sb = new StringBuilder();
            sb.append('L');
            String name2 = cls.getName();
            m.e(name2, "name");
            sb.append(kotlin.text.u.z(name2, '.', '/', false, 4, null));
            sb.append(';');
            return sb.toString();
        }
        String name3 = cls.getName();
        switch (name3.hashCode()) {
            case -1325958191:
                if (name3.equals("double")) {
                    return "D";
                }
                break;
            case 104431:
                if (name3.equals("int")) {
                    return "I";
                }
                break;
            case 3039496:
                if (name3.equals("byte")) {
                    return "B";
                }
                break;
            case 3052374:
                if (name3.equals("char")) {
                    return "C";
                }
                break;
            case 3327612:
                if (name3.equals("long")) {
                    return "J";
                }
                break;
            case 3625364:
                if (name3.equals("void")) {
                    return "V";
                }
                break;
            case 64711720:
                if (name3.equals("boolean")) {
                    return "Z";
                }
                break;
            case 97526364:
                if (name3.equals("float")) {
                    return "F";
                }
                break;
            case 109413500:
                if (name3.equals("short")) {
                    return "S";
                }
                break;
        }
        throw new IllegalArgumentException("Unsupported primitive type: " + cls);
    }

    public static final List<Type> c(Type type) {
        m.f(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            return u.j();
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() != null) {
            return kotlin.sequences.n.A(kotlin.sequences.n.p(l.f(type, a.f25340f), b.f25341f));
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        m.e(actualTypeArguments, "actualTypeArguments");
        return n.Z(actualTypeArguments);
    }

    public static final Class<?> d(Class<?> cls) {
        m.f(cls, "<this>");
        return f25337b.get(cls);
    }

    public static final ClassLoader e(Class<?> cls) {
        m.f(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        m.e(systemClassLoader, "getSystemClassLoader()");
        return systemClassLoader;
    }

    public static final Class<?> f(Class<?> cls) {
        m.f(cls, "<this>");
        return f25338c.get(cls);
    }

    public static final boolean g(Class<?> cls) {
        m.f(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }
}
