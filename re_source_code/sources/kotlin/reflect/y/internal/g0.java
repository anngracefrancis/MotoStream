package kotlin.reflect.y.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.q0;
import kotlin.collections.z;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a.k;
import kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a.l;
import kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.p;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.p002reflect.jvm.internal.impl.protobuf.o;
import kotlin.reflect.KCallable;
import kotlin.reflect.KType;
import kotlin.reflect.KVisibility;
import kotlin.reflect.y.internal.j0.b.i;
import kotlin.reflect.y.internal.j0.d.b.q;
import kotlin.reflect.y.internal.j0.e.n;
import kotlin.reflect.y.internal.j0.e.s;
import kotlin.reflect.y.internal.j0.e.z.h;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.d;
import kotlin.reflect.y.internal.j0.i.f;
import kotlin.reflect.y.internal.j0.i.r.j;
import kotlin.reflect.y.internal.j0.j.b.w;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.text.u;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: util.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001al\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0013*\u00020\u0014\"\b\b\u0001\u0010\u0012*\u00020\u00062\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0017\u001a\u0002H\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u001d\u0010\u001e\u001a\u0019\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00120\u001f¢\u0006\u0002\b!H\u0000¢\u0006\u0002\u0010\"\u001a.\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00162\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*H\u0002\u001a(\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00162\u0006\u0010$\u001a\u00020%2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010)\u001a\u00020*H\u0002\u001a%\u0010-\u001a\u0002H.\"\u0004\b\u0000\u0010.2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H.00H\u0080\bø\u0001\u0000¢\u0006\u0002\u00101\u001a\u0016\u00102\u001a\u0004\u0018\u00010\u000e*\u0002032\u0006\u0010$\u001a\u00020%H\u0002\u001a\u0014\u00104\u001a\b\u0012\u0002\b\u0003\u0018\u000105*\u0004\u0018\u00010\u000eH\u0000\u001a\u0010\u00106\u001a\u0004\u0018\u000107*\u0004\u0018\u00010\u000eH\u0000\u001a\u0014\u00108\u001a\b\u0012\u0002\b\u0003\u0018\u000109*\u0004\u0018\u00010\u000eH\u0000\u001a\u0012\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;*\u00020=H\u0000\u001a\u0014\u0010>\u001a\u0006\u0012\u0002\b\u00030\u0016*\u0006\u0012\u0002\b\u00030\u0016H\u0000\u001a\u000e\u0010?\u001a\u0004\u0018\u00010<*\u00020@H\u0002\u001a\u0012\u0010A\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0016*\u00020BH\u0000\u001a\u000e\u0010C\u001a\u0004\u0018\u00010D*\u00020EH\u0000\u001a\u001a\u0010F\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030G2\u0006\u0010$\u001a\u00020%H\u0002\u001a\u0018\u0010H\u001a\b\u0012\u0004\u0012\u00020<0;*\b\u0012\u0004\u0012\u00020<0;H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0018\u0010\t\u001a\u00020\n*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006I"}, d2 = {"JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "instanceReceiverParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "isInlineClassType", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KType;)Z", "defaultPrimitiveValue", HttpUrl.FRAGMENT_ENCODE_SET, "type", "Ljava/lang/reflect/Type;", "deserializeToDescriptor", "D", "M", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "moduleAnchor", "Ljava/lang/Class;", "proto", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "metadataVersion", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "createDescriptor", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "loadClass", "classLoader", "Ljava/lang/ClassLoader;", "packageName", HttpUrl.FRAGMENT_ENCODE_SET, "className", "arrayDimensions", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "reflectionCall", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "arrayToRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ArrayValue;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "computeAnnotations", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "createArrayType", "toAnnotationInstance", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toJavaClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibility;", "toRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", "unwrapRepeatableAnnotations", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class g0 {
    private static final c a = new c("kotlin.jvm.JvmStatic");

    /* JADX INFO: compiled from: util.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.values().length];
            iArr[i.BOOLEAN.ordinal()] = 1;
            iArr[i.CHAR.ordinal()] = 2;
            iArr[i.BYTE.ordinal()] = 3;
            iArr[i.SHORT.ordinal()] = 4;
            iArr[i.INT.ordinal()] = 5;
            iArr[i.FLOAT.ordinal()] = 6;
            iArr[i.LONG.ordinal()] = 7;
            iArr[i.DOUBLE.ordinal()] = 8;
            a = iArr;
        }
    }

    /* JADX WARN: Incorrect type for immutable var: ssa=boolean[], code=short[], for r7v12, types: [boolean[]] */
    /* JADX WARN: Incorrect type for immutable var: ssa=byte[], code=short[], for r7v14, types: [byte[]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.lang.Class[]] */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r7v16, types: [int[]] */
    /* JADX WARN: Type inference failed for: r7v17, types: [float[]] */
    /* JADX WARN: Type inference failed for: r7v18, types: [long[]] */
    /* JADX WARN: Type inference failed for: r7v20, types: [double[]] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.lang.Object a(kotlin.reflect.y.internal.j0.i.r.b r6, java.lang.ClassLoader r7) {
        /*
            Method dump skipped, instruction units count: 606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.y.internal.g0.a(kotlin.f0.y.e.j0.i.r.b, java.lang.ClassLoader):java.lang.Object");
    }

    public static final KCallableImpl<?> b(Object obj) {
        KCallableImpl<?> kCallableImpl = obj instanceof KCallableImpl ? (KCallableImpl) obj : null;
        if (kCallableImpl != null) {
            return kCallableImpl;
        }
        KFunctionImpl kFunctionImplC = c(obj);
        return kFunctionImplC != null ? kFunctionImplC : d(obj);
    }

    public static final KFunctionImpl c(Object obj) {
        KFunctionImpl kFunctionImpl = obj instanceof KFunctionImpl ? (KFunctionImpl) obj : null;
        if (kFunctionImpl != null) {
            return kFunctionImpl;
        }
        kotlin.jvm.internal.i iVar = obj instanceof kotlin.jvm.internal.i ? (kotlin.jvm.internal.i) obj : null;
        KCallable kCallableCompute = iVar != null ? iVar.compute() : null;
        if (kCallableCompute instanceof KFunctionImpl) {
            return (KFunctionImpl) kCallableCompute;
        }
        return null;
    }

    public static final KPropertyImpl<?> d(Object obj) {
        KPropertyImpl<?> kPropertyImpl = obj instanceof KPropertyImpl ? (KPropertyImpl) obj : null;
        if (kPropertyImpl != null) {
            return kPropertyImpl;
        }
        b0 b0Var = obj instanceof b0 ? (b0) obj : null;
        KCallable kCallableCompute = b0Var != null ? b0Var.compute() : null;
        if (kCallableCompute instanceof KPropertyImpl) {
            return (KPropertyImpl) kCallableCompute;
        }
        return null;
    }

    public static final List<Annotation> e(kotlin.p002reflect.jvm.internal.impl.descriptors.n1.a aVar) {
        m.f(aVar, "<this>");
        g annotations = aVar.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c cVar : annotations) {
            z0 z0VarT = cVar.t();
            Annotation annotationO = null;
            if (z0VarT instanceof b) {
                annotationO = ((b) z0VarT).d();
            } else if (z0VarT instanceof l.a) {
                p pVarB = ((l.a) z0VarT).b();
                e eVar = pVarB instanceof e ? (e) pVarB : null;
                if (eVar != null) {
                    annotationO = eVar.R();
                }
            } else {
                annotationO = o(cVar);
            }
            if (annotationO != null) {
                arrayList.add(annotationO);
            }
        }
        return s(arrayList);
    }

    public static final Class<?> f(Class<?> cls) {
        m.f(cls, "<this>");
        return Array.newInstance(cls, 0).getClass();
    }

    public static final Object g(Type type) {
        m.f(type, "type");
        if (!(type instanceof Class) || !((Class) type).isPrimitive()) {
            return null;
        }
        if (m.a(type, Boolean.TYPE)) {
            return Boolean.FALSE;
        }
        if (m.a(type, Character.TYPE)) {
            return (char) 0;
        }
        if (m.a(type, Byte.TYPE)) {
            return (byte) 0;
        }
        if (m.a(type, Short.TYPE)) {
            return (short) 0;
        }
        if (m.a(type, Integer.TYPE)) {
            return 0;
        }
        if (m.a(type, Float.TYPE)) {
            return Float.valueOf(0.0f);
        }
        if (m.a(type, Long.TYPE)) {
            return 0L;
        }
        if (m.a(type, Double.TYPE)) {
            return Double.valueOf(0.0d);
        }
        if (m.a(type, Void.TYPE)) {
            throw new IllegalStateException("Parameter with void type is illegal");
        }
        throw new UnsupportedOperationException("Unknown primitive: " + type);
    }

    public static final <M extends o, D extends kotlin.p002reflect.jvm.internal.impl.descriptors.a> D h(Class<?> cls, M m, kotlin.reflect.y.internal.j0.e.z.c cVar, kotlin.reflect.y.internal.j0.e.z.g gVar, kotlin.reflect.y.internal.j0.e.z.a aVar, Function2<? super w, ? super M, ? extends D> function2) {
        List<s> listN0;
        m.f(cls, "moduleAnchor");
        m.f(m, "proto");
        m.f(cVar, "nameResolver");
        m.f(gVar, "typeTable");
        m.f(aVar, "metadataVersion");
        m.f(function2, "createDescriptor");
        k kVarA = z.a(cls);
        if (m instanceof kotlin.reflect.y.internal.j0.e.i) {
            listN0 = ((kotlin.reflect.y.internal.j0.e.i) m).m0();
        } else {
            if (!(m instanceof n)) {
                throw new IllegalStateException(("Unsupported message: " + m).toString());
            }
            listN0 = ((n) m).n0();
        }
        List<s> list = listN0;
        kotlin.reflect.y.internal.j0.j.b.k kVarA2 = kVarA.a();
        kotlin.p002reflect.jvm.internal.impl.descriptors.g0 g0VarB = kVarA.b();
        h hVarB = h.a.b();
        m.e(list, "typeParameters");
        return function2.invoke(new w(new kotlin.reflect.y.internal.j0.j.b.m(kVarA2, cVar, g0VarB, gVar, hVarB, aVar, null, null, list)), m);
    }

    public static final w0 i(kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar) {
        m.f(aVar, "<this>");
        if (aVar.f0() == null) {
            return null;
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = aVar.b();
        m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return ((kotlin.p002reflect.jvm.internal.impl.descriptors.e) mVarB).K0();
    }

    public static final c j() {
        return a;
    }

    public static final boolean k(KType kType) {
        e0 e0VarF;
        m.f(kType, "<this>");
        KTypeImpl kTypeImpl = kType instanceof KTypeImpl ? (KTypeImpl) kType : null;
        return (kTypeImpl == null || (e0VarF = kTypeImpl.getF25005g()) == null || !f.c(e0VarF)) ? false : true;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static final Class<?> l(ClassLoader classLoader, String str, String str2, int i2) {
        if (m.a(str, "kotlin")) {
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (str2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        String str3 = str + '.' + u.z(str2, '.', '$', false, 4, null);
        if (i2 > 0) {
            str3 = u.w("[", i2) + 'L' + str3 + ';';
        }
        return kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a.e.a(classLoader, str3);
    }

    private static final Class<?> m(ClassLoader classLoader, kotlin.reflect.y.internal.j0.f.b bVar, int i2) {
        kotlin.reflect.y.internal.j0.b.q.c cVar = kotlin.reflect.y.internal.j0.b.q.c.a;
        d dVarJ = bVar.b().j();
        m.e(dVarJ, "kotlinClassId.asSingleFqName().toUnsafe()");
        kotlin.reflect.y.internal.j0.f.b bVarN = cVar.n(dVarJ);
        if (bVarN != null) {
            bVar = bVarN;
        }
        String strB = bVar.h().b();
        m.e(strB, "javaClassId.packageFqName.asString()");
        String strB2 = bVar.i().b();
        m.e(strB2, "javaClassId.relativeClassName.asString()");
        return l(classLoader, strB, strB2, i2);
    }

    static /* synthetic */ Class n(ClassLoader classLoader, kotlin.reflect.y.internal.j0.f.b bVar, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return m(classLoader, bVar, i2);
    }

    private static final Annotation o(kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c cVar) {
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVarE = kotlin.reflect.y.internal.j0.i.t.a.e(cVar);
        Class<?> clsP = eVarE != null ? p(eVarE) : null;
        if (!(clsP instanceof Class)) {
            clsP = null;
        }
        if (clsP == null) {
            return null;
        }
        Set<Map.Entry<kotlin.reflect.y.internal.j0.f.f, kotlin.reflect.y.internal.j0.i.r.g<?>>> setEntrySet = cVar.a().entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            kotlin.reflect.y.internal.j0.f.f fVar = (kotlin.reflect.y.internal.j0.f.f) entry.getKey();
            kotlin.reflect.y.internal.j0.i.r.g gVar = (kotlin.reflect.y.internal.j0.i.r.g) entry.getValue();
            ClassLoader classLoader = clsP.getClassLoader();
            m.e(classLoader, "annotationClass.classLoader");
            Object objR = r(gVar, classLoader);
            Pair pairA = objR != null ? kotlin.s.a(fVar.k(), objR) : null;
            if (pairA != null) {
                arrayList.add(pairA);
            }
        }
        return (Annotation) kotlin.reflect.y.internal.calls.b.g(clsP, q0.q(arrayList), null, 4, null);
    }

    public static final Class<?> p(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
        m.f(eVar, "<this>");
        z0 z0VarT = eVar.t();
        m.e(z0VarT, "source");
        if (z0VarT instanceof kotlin.reflect.y.internal.j0.d.b.s) {
            q qVarD = ((kotlin.reflect.y.internal.j0.d.b.s) z0VarT).d();
            m.d(qVarD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
            return ((kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a.f) qVarD).d();
        }
        if (z0VarT instanceof l.a) {
            p pVarB = ((l.a) z0VarT).b();
            m.d(pVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            return ((kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.l) pVarB).w();
        }
        kotlin.reflect.y.internal.j0.f.b bVarG = kotlin.reflect.y.internal.j0.i.t.a.g(eVar);
        if (bVarG == null) {
            return null;
        }
        return m(kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.d.e(eVar.getClass()), bVarG, 0);
    }

    public static final KVisibility q(kotlin.p002reflect.jvm.internal.impl.descriptors.u uVar) {
        m.f(uVar, "<this>");
        if (m.a(uVar, t.f25368e)) {
            return KVisibility.PUBLIC;
        }
        if (m.a(uVar, t.f25366c)) {
            return KVisibility.PROTECTED;
        }
        if (m.a(uVar, t.f25367d)) {
            return KVisibility.INTERNAL;
        }
        if (m.a(uVar, t.a) ? true : m.a(uVar, t.f25365b)) {
            return KVisibility.PRIVATE;
        }
        return null;
    }

    private static final Object r(kotlin.reflect.y.internal.j0.i.r.g<?> gVar, ClassLoader classLoader) {
        if (gVar instanceof kotlin.reflect.y.internal.j0.i.r.a) {
            return o(((kotlin.reflect.y.internal.j0.i.r.a) gVar).b());
        }
        if (gVar instanceof kotlin.reflect.y.internal.j0.i.r.b) {
            return a((kotlin.reflect.y.internal.j0.i.r.b) gVar, classLoader);
        }
        if (gVar instanceof j) {
            Pair<? extends kotlin.reflect.y.internal.j0.f.b, ? extends kotlin.reflect.y.internal.j0.f.f> pairB = ((j) gVar).b();
            kotlin.reflect.y.internal.j0.f.b bVarA = pairB.a();
            kotlin.reflect.y.internal.j0.f.f fVarB = pairB.b();
            Class clsN = n(classLoader, bVarA, 0, 4, null);
            if (clsN != null) {
                return f0.a(clsN, fVarB.k());
            }
            return null;
        }
        if (!(gVar instanceof kotlin.reflect.y.internal.j0.i.r.q)) {
            if (gVar instanceof kotlin.reflect.y.internal.j0.i.r.k ? true : gVar instanceof kotlin.reflect.y.internal.j0.i.r.s) {
                return null;
            }
            return gVar.b();
        }
        kotlin.f0.y.e.j0.i.r.q.b bVarB = ((kotlin.reflect.y.internal.j0.i.r.q) gVar).b();
        if (bVarB instanceof kotlin.f0.y.e.j0.i.r.q.b.C0379b) {
            kotlin.f0.y.e.j0.i.r.q.b.C0379b c0379b = (kotlin.f0.y.e.j0.i.r.q.b.C0379b) bVarB;
            return m(classLoader, c0379b.b(), c0379b.a());
        }
        if (!(bVarB instanceof kotlin.f0.y.e.j0.i.r.q.b.a)) {
            throw new NoWhenBranchMatchedException();
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarC = ((kotlin.f0.y.e.j0.i.r.q.b.a) bVarB).a().O0().w();
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar = hVarC instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e ? (kotlin.p002reflect.jvm.internal.impl.descriptors.e) hVarC : null;
        if (eVar != null) {
            return p(eVar);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final List<Annotation> s(List<? extends Annotation> list) throws IllegalAccessException, InvocationTargetException {
        boolean z;
        List listE;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (m.a(kotlin.jvm.a.b(kotlin.jvm.a.a((Annotation) it.next())).getSimpleName(), "Container")) {
                    z = true;
                    break;
                }
            }
        } else {
            z = false;
            break;
        }
        if (!z) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Annotation annotation : list) {
            Class clsB = kotlin.jvm.a.b(kotlin.jvm.a.a(annotation));
            if (!m.a(clsB.getSimpleName(), "Container") || clsB.getAnnotation(i0.class) == null) {
                listE = kotlin.collections.t.e(annotation);
            } else {
                Object objInvoke = clsB.getDeclaredMethod("value", new Class[0]).invoke(annotation, new Object[0]);
                m.d(objInvoke, "null cannot be cast to non-null type kotlin.Array<out kotlin.Annotation>");
                listE = kotlin.collections.m.c((Annotation[]) objInvoke);
            }
            z.z(arrayList, listE);
        }
        return arrayList;
    }
}
