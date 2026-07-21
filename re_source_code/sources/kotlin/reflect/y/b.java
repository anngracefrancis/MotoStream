package kotlin.reflect.y;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.s;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.f;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.y.internal.KTypeImpl;
import kotlin.reflect.y.internal.KotlinReflectionInternalError;

/* JADX INFO: compiled from: KTypesJvm.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001c\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\"\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\b¨\u0006\t"}, d2 = {"jvmErasure", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClassifier;", "getJvmErasure", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "getJvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class b {
    public static final KClass<?> a(KClassifier kClassifier) {
        Object obj;
        KClass<?> kClassB;
        m.f(kClassifier, "<this>");
        if (kClassifier instanceof KClass) {
            return (KClass) kClassifier;
        }
        if (!(kClassifier instanceof KTypeParameter)) {
            throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + kClassifier);
        }
        List<KType> upperBounds = ((KTypeParameter) kClassifier).getUpperBounds();
        Iterator<T> it = upperBounds.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            KType kType = (KType) next;
            m.d(kType, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
            h hVarW = ((KTypeImpl) kType).getF25005g().O0().w();
            e eVar = hVarW instanceof e ? (e) hVarW : null;
            if ((eVar == null || eVar.i() == f.INTERFACE || eVar.i() == f.ANNOTATION_CLASS) ? false : true) {
                obj = next;
                break;
            }
        }
        KType kType2 = (KType) obj;
        if (kType2 == null) {
            kType2 = (KType) s.W(upperBounds);
        }
        return (kType2 == null || (kClassB = b(kType2)) == null) ? g0.b(Object.class) : kClassB;
    }

    public static final KClass<?> b(KType kType) {
        KClass<?> kClassA;
        m.f(kType, "<this>");
        KClassifier kClassifierC = kType.c();
        if (kClassifierC != null && (kClassA = a(kClassifierC)) != null) {
            return kClassA;
        }
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + kType);
    }
}
