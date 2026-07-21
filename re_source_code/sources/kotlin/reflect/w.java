package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.s;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.KTypeBase;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlin.sequences.Sequence;
import kotlin.sequences.i;
import kotlin.sequences.l;
import kotlin.sequences.n;
import kotlin.text.u;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\"\u0010\n\u001a\u00020\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0003\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0016\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0003\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00078BX\u0083\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\b\u001a\u0004\b\u0005\u0010\t¨\u0006\u0015"}, d2 = {"javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "Lkotlin/reflect/KTypeProjection;", "(Lkotlin/reflect/KTypeProjection;)V", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "createPossiblyInnerType", "jClass", "Ljava/lang/Class;", "arguments", HttpUrl.FRAGMENT_ENCODE_SET, "typeToString", HttpUrl.FRAGMENT_ENCODE_SET, "type", "computeJavaType", "forceWrapper", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class w {

    /* JADX INFO: compiled from: TypesJVM.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[KVariance.values().length];
            iArr[KVariance.IN.ordinal()] = 1;
            iArr[KVariance.INVARIANT.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            a = iArr;
        }
    }

    /* JADX INFO: compiled from: TypesJVM.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* synthetic */ class b extends j implements Function1<Class<?>, Class<?>> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f23013h = new b();

        b() {
            super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public final Class<?> invoke(Class<?> cls) {
            m.f(cls, "p0");
            return cls.getComponentType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type c(KType kType, boolean z) {
        KClassifier kClassifierC = kType.c();
        if (kClassifierC instanceof KTypeParameter) {
            return new TypeVariableImpl((KTypeParameter) kClassifierC);
        }
        if (!(kClassifierC instanceof KClass)) {
            throw new UnsupportedOperationException("Unsupported type classifier: " + kType);
        }
        KClass kClass = (KClass) kClassifierC;
        Class clsC = z ? kotlin.jvm.a.c(kClass) : kotlin.jvm.a.b(kClass);
        List<KTypeProjection> listB = kType.b();
        if (listB.isEmpty()) {
            return clsC;
        }
        if (!clsC.isArray()) {
            return e(clsC, listB);
        }
        if (clsC.getComponentType().isPrimitive()) {
            return clsC;
        }
        KTypeProjection kTypeProjection = (KTypeProjection) s.u0(listB);
        if (kTypeProjection == null) {
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
        }
        KVariance f22997c = kTypeProjection.getF22997c();
        KType f22998d = kTypeProjection.getF22998d();
        int i2 = f22997c == null ? -1 : a.a[f22997c.ordinal()];
        if (i2 == -1 || i2 == 1) {
            return clsC;
        }
        if (i2 != 2 && i2 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        m.c(f22998d);
        Type typeD = d(f22998d, false, 1, null);
        return typeD instanceof Class ? clsC : new GenericArrayTypeImpl(typeD);
    }

    static /* synthetic */ Type d(KType kType, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return c(kType, z);
    }

    private static final Type e(Class<?> cls, List<KTypeProjection> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ArrayList arrayList = new ArrayList(v.u(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(g((KTypeProjection) it.next()));
            }
            return new ParameterizedTypeImpl(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            ArrayList arrayList2 = new ArrayList(v.u(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(g((KTypeProjection) it2.next()));
            }
            return new ParameterizedTypeImpl(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        Type typeE = e(declaringClass, list.subList(length, list.size()));
        List<KTypeProjection> listSubList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(v.u(listSubList, 10));
        Iterator<T> it3 = listSubList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(g((KTypeProjection) it3.next()));
        }
        return new ParameterizedTypeImpl(cls, typeE, arrayList3);
    }

    public static final Type f(KType kType) {
        Type typeJ;
        m.f(kType, "<this>");
        return (!(kType instanceof KTypeBase) || (typeJ = ((KTypeBase) kType).j()) == null) ? d(kType, false, 1, null) : typeJ;
    }

    private static final Type g(KTypeProjection kTypeProjection) {
        KVariance kVarianceD = kTypeProjection.d();
        if (kVarianceD == null) {
            return WildcardTypeImpl.f23014f.a();
        }
        KType kTypeC = kTypeProjection.c();
        m.c(kTypeC);
        int i2 = a.a[kVarianceD.ordinal()];
        if (i2 == 1) {
            return new WildcardTypeImpl(null, c(kTypeC, true));
        }
        if (i2 == 2) {
            return c(kTypeC, true);
        }
        if (i2 == 3) {
            return new WildcardTypeImpl(c(kTypeC, true), null);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String h(Type type) {
        String name;
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (cls.isArray()) {
            Sequence sequenceF = l.f(type, b.f23013h);
            name = ((Class) i.t(sequenceF)).getName() + u.w(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, n.j(sequenceF));
        } else {
            name = cls.getName();
        }
        m.e(name, "{\n        if (type.isArr…   } else type.name\n    }");
        return name;
    }
}
