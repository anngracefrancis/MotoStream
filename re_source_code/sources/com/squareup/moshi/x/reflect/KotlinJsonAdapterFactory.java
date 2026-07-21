package com.squareup.moshi.x.reflect;

import com.squareup.moshi.e;
import com.squareup.moshi.f;
import com.squareup.moshi.i;
import com.squareup.moshi.r;
import com.squareup.moshi.u;
import com.squareup.moshi.v;
import com.squareup.moshi.w.c;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.c0;
import kotlin.collections.p0;
import kotlin.collections.z;
import kotlin.jvm.a;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.squareup.moshi.x.a.b, reason: from Kotlin metadata */
/* JADX INFO: compiled from: KotlinJsonAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapterFactory;", "Lcom/squareup/moshi/JsonAdapter$Factory;", "()V", "create", "Lcom/squareup/moshi/JsonAdapter;", "type", "Ljava/lang/reflect/Type;", "annotations", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "moshi", "Lcom/squareup/moshi/Moshi;", "reflect"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KotlinJsonAdapterFactory implements f.e {
    /* JADX WARN: Code duplicated, block: B:117:0x01dd  */
    @Override // com.squareup.moshi.f.e
    public f<?> a(Type type, Set<? extends Annotation> set, r rVar) {
        Object next;
        String m;
        Type typeF;
        Object next2;
        m.f(type, "type");
        m.f(set, "annotations");
        m.f(rVar, "moshi");
        boolean z = true;
        if (!set.isEmpty()) {
            return null;
        }
        Class<?> clsA = v.a(type);
        if (clsA.isInterface() || clsA.isEnum() || !clsA.isAnnotationPresent(c.a) || c.i(clsA)) {
            return null;
        }
        try {
            f<?> fVarD = c.d(rVar, type, clsA);
            if (fVarD != null) {
                return fVarD;
            }
        } catch (RuntimeException e2) {
            if (!(e2.getCause() instanceof ClassNotFoundException)) {
                throw e2;
            }
        }
        if (!(!clsA.isLocalClass())) {
            throw new IllegalArgumentException(("Cannot serialize local class or object expression " + clsA.getName()).toString());
        }
        KClass kClassE = a.e(clsA);
        if (!(!kClassE.isAbstract())) {
            throw new IllegalArgumentException(("Cannot serialize abstract class " + clsA.getName()).toString());
        }
        if (!(!kClassE.m())) {
            throw new IllegalArgumentException(("Cannot serialize inner class " + clsA.getName()).toString());
        }
        if (!(kClassE.r() == null)) {
            throw new IllegalArgumentException(("Cannot serialize object declaration " + clsA.getName()).toString());
        }
        if (!(!kClassE.o())) {
            throw new IllegalArgumentException(("Cannot reflectively serialize sealed class " + clsA.getName() + ". Please register an adapter.").toString());
        }
        KFunction kFunctionB = kotlin.p002reflect.full.a.b(kClassE);
        if (kFunctionB == null) {
            return null;
        }
        List<KParameter> parameters = kFunctionB.getParameters();
        LinkedHashMap linkedHashMap = new LinkedHashMap(l.b(p0.e(kotlin.collections.v.u(parameters, 10)), 16));
        for (Object obj : parameters) {
            linkedHashMap.put(((KParameter) obj).getName(), obj);
        }
        kotlin.reflect.y.a.a(kFunctionB, true);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (KProperty1 kProperty1 : kotlin.p002reflect.full.a.a(kClassE)) {
            KParameter kParameter = (KParameter) linkedHashMap.get(kProperty1.getM());
            kotlin.reflect.y.a.a(kProperty1, z);
            Iterator<T> it = kProperty1.getAnnotations().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((Annotation) next) instanceof e));
            e eVar = (e) next;
            List listG0 = c0.G0(kProperty1.getAnnotations());
            if (kParameter != null) {
                z.z(listG0, kParameter.getAnnotations());
                if (eVar == null) {
                    Iterator<T> it2 = kParameter.getAnnotations().iterator();
                    do {
                        if (!it2.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it2.next();
                    } while (!(((Annotation) next2) instanceof e));
                    eVar = (e) next2;
                }
            }
            Field fieldB = kotlin.reflect.y.c.b(kProperty1);
            if (Modifier.isTransient(fieldB != null ? fieldB.getModifiers() : 0)) {
                if (!(kParameter == null || kParameter.k())) {
                    throw new IllegalArgumentException(("No default value for transient constructor " + kParameter).toString());
                }
            } else if (eVar != null && eVar.ignore() == z) {
                if (!(kParameter == null || kParameter.k())) {
                    throw new IllegalArgumentException(("No default value for ignored constructor " + kParameter).toString());
                }
            } else {
                if (!(kParameter == null || m.a(kParameter.getType(), kProperty1.getReturnType()))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('\'');
                    sb.append(kProperty1.getM());
                    sb.append("' has a constructor parameter of type ");
                    m.c(kParameter);
                    sb.append(kParameter.getType());
                    sb.append(" but a property of type ");
                    sb.append(kProperty1.getReturnType());
                    sb.append('.');
                    throw new IllegalArgumentException(sb.toString().toString());
                }
                if ((kProperty1 instanceof KMutableProperty1) || kParameter != null) {
                    if (eVar == null || (m = eVar.name()) == null) {
                        m = kProperty1.getM();
                    } else {
                        if (m.a(m, "\u0000")) {
                            m = null;
                        }
                        if (m == null) {
                            m = kProperty1.getM();
                        }
                    }
                    String str = m;
                    KClassifier kClassifierC = kProperty1.getReturnType().c();
                    if (kClassifierC instanceof KClass) {
                        KClass kClass = (KClass) kClassifierC;
                        if (kClass.l()) {
                            typeF = a.b(kClass);
                            if (!kProperty1.getReturnType().b().isEmpty()) {
                                List<KTypeProjection> listB = kProperty1.getReturnType().b();
                                ArrayList arrayList = new ArrayList();
                                Iterator<T> it3 = listB.iterator();
                                while (it3.hasNext()) {
                                    KType kTypeC = ((KTypeProjection) it3.next()).c();
                                    Type typeF2 = kTypeC != null ? kotlin.reflect.y.c.f(kTypeC) : null;
                                    if (typeF2 != null) {
                                        arrayList.add(typeF2);
                                    }
                                }
                                Object[] array = arrayList.toArray(new Type[0]);
                                m.d(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                Type[] typeArr = (Type[]) array;
                                typeF = u.j(typeF, (Type[]) Arrays.copyOf(typeArr, typeArr.length));
                            }
                        } else {
                            typeF = kotlin.reflect.y.c.f(kProperty1.getReturnType());
                        }
                    } else {
                        if (!(kClassifierC instanceof KTypeParameter)) {
                            throw new IllegalStateException("Not possible!".toString());
                        }
                        typeF = kotlin.reflect.y.c.f(kProperty1.getReturnType());
                    }
                    Type typeP = c.p(type, clsA, typeF);
                    Object[] array2 = listG0.toArray(new Annotation[0]);
                    m.d(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    f fVarF = rVar.f(typeP, c.k((Annotation[]) array2), kProperty1.getM());
                    String m2 = kProperty1.getM();
                    m.e(fVarF, "adapter");
                    m.d(kProperty1, "null cannot be cast to non-null type kotlin.reflect.KProperty1<kotlin.Any, kotlin.Any?>");
                    linkedHashMap2.put(m2, new KotlinJsonAdapter.Binding(str, fVarF, kProperty1, kParameter, kParameter != null ? kParameter.getF24980h() : -1));
                    z = true;
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (KParameter kParameter2 : kFunctionB.getParameters()) {
            KotlinJsonAdapter.Binding binding = (KotlinJsonAdapter.Binding) l0.c(linkedHashMap2).remove(kParameter2.getName());
            if (!(binding != null || kParameter2.k())) {
                throw new IllegalArgumentException(("No property for required constructor " + kParameter2).toString());
            }
            arrayList2.add(binding);
        }
        int size = arrayList2.size();
        Iterator it4 = linkedHashMap2.entrySet().iterator();
        while (true) {
            int i2 = size;
            if (!it4.hasNext()) {
                break;
            }
            size = i2 + 1;
            arrayList2.add(KotlinJsonAdapter.Binding.b((KotlinJsonAdapter.Binding) ((Map.Entry) it4.next()).getValue(), null, null, null, null, i2, 15, null));
        }
        List listR = c0.R(arrayList2);
        ArrayList arrayList3 = new ArrayList(kotlin.collections.v.u(listR, 10));
        Iterator it5 = listR.iterator();
        while (it5.hasNext()) {
            arrayList3.add(((KotlinJsonAdapter.Binding) it5.next()).getJsonName());
        }
        Object[] array3 = arrayList3.toArray(new String[0]);
        m.d(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array3;
        i.a aVarA = i.a.a((String[]) Arrays.copyOf(strArr, strArr.length));
        m.e(aVarA, "options");
        return new KotlinJsonAdapter(kFunctionB, arrayList2, listR, aVarA).nullSafe();
    }
}
