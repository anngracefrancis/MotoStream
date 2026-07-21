package kotlin.reflect.y.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.c0;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.l;
import kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a.f;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.y.internal.j0.e.n;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.j.b.w;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.m0;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.f0.y.e.h, reason: from Kotlin metadata */
/* JADX INFO: compiled from: KClassImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u00052\u00020\u0006:\u0001eB\u0013\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0013\u0010T\u001a\u00020&2\b\u0010U\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0016\u0010V\u001a\b\u0012\u0004\u0012\u00020W0\u00142\u0006\u0010X\u001a\u00020YH\u0016J\u0012\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u00020]H\u0016J\u0016\u0010^\u001a\b\u0012\u0004\u0012\u00020[0\u00142\u0006\u0010X\u001a\u00020YH\u0016J\b\u0010_\u001a\u00020]H\u0016J\u0012\u0010`\u001a\u00020&2\b\u0010a\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010b\u001a\u00020cH\u0002J\b\u0010d\u001a\u00020AH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017R3\u0010\u001b\u001a$\u0012 \u0012\u001e \u001e*\u000e\u0018\u00010\u001dR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001dR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010'R\u0014\u0010(\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010'R\u0014\u0010+\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010'R\u0014\u0010,\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010'R\u0014\u0010-\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010'R\u0014\u0010.\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010'R\u001a\u0010/\u001a\u00020&8VX\u0096\u0004¢\u0006\f\u0012\u0004\b0\u00101\u001a\u0004\b/\u0010'R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u0002058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u001e\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003090\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u0017R\u001e\u0010;\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0017R\u0016\u0010=\u001a\u0004\u0018\u00018\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0016\u0010@\u001a\u0004\u0018\u00010A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\"\u0010D\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00040\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u000eR\u0016\u0010F\u001a\u0004\u0018\u00010A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010CR\u0014\u0010H\u001a\u0002058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u00107R\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u000eR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010\u000eR\u0016\u0010P\u001a\u0004\u0018\u00010Q8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u0010S¨\u0006f"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "constructorDescriptors", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "isAbstract", HttpUrl.FRAGMENT_ENCODE_SET, "()Z", "isCompanion", "isData", "isFinal", "isFun", "isInner", "isOpen", "isSealed", "isValue", "isValue$annotations", "()V", "getJClass", "()Ljava/lang/Class;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", HttpUrl.FRAGMENT_ENCODE_SET, "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses", "simpleName", "getSimpleName", "staticScope", "getStaticScope$kotlin_reflection", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", HttpUrl.FRAGMENT_ENCODE_SET, "getProperties", "hashCode", "isInstance", "value", "reportUnresolvedClass", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "Data", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KClassImpl<T> extends KDeclarationContainerImpl implements KClass<T>, KTypeParameterOwnerImpl {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Class<T> f23055i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final a0.b<KClassImpl<T>.a> f23056j;

    /* JADX INFO: renamed from: kotlin.f0.y.e.h$a */
    /* JADX INFO: compiled from: KClassImpl.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010N\u001a\u00020<2\n\u0010O\u001a\u0006\u0012\u0002\b\u00030PH\u0002R%\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR%\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR%\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015R-\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00058FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\n\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\bR%\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001e\u0010\bR%\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b!\u0010\bR%\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b$\u0010\bR\u001b\u0010&\u001a\u00020'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b(\u0010)R%\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b,\u0010\bR%\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\n\u001a\u0004\b/\u0010\bR%\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\n\u001a\u0004\b3\u0010\bR#\u00105\u001a\u0004\u0018\u00018\u00008FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b9\u0010:\u0012\u0004\b6\u0010\u001a\u001a\u0004\b7\u00108R\u001d\u0010;\u001a\u0004\u0018\u00010<8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\n\u001a\u0004\b=\u0010>R)\u0010@\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u0000020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\n\u001a\u0004\bA\u0010\u0015R\u001d\u0010C\u001a\u0004\u0018\u00010<8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\n\u001a\u0004\bD\u0010>R!\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\n\u001a\u0004\bH\u0010\u0015R!\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\n\u001a\u0004\bL\u0010\u0015¨\u0006Q"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "allMembers", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getAllMembers", "()Ljava/util/Collection;", "allMembers$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "annotations", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors$annotations", "()V", "getConstructors", "constructors$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "declaredNonStaticMembers", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "getObjectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "qualifiedName", HttpUrl.FRAGMENT_ENCODE_SET, "getQualifiedName", "()Ljava/lang/String;", "qualifiedName$delegate", "sealedSubclasses", "getSealedSubclasses", "sealedSubclasses$delegate", "simpleName", "getSimpleName", "simpleName$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class a extends KDeclarationContainerImpl.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final /* synthetic */ KProperty<Object>[] f23057d = {g0.h(new y(g0.b(a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), g0.h(new y(g0.b(a.class), "annotations", "getAnnotations()Ljava/util/List;")), g0.h(new y(g0.b(a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), g0.h(new y(g0.b(a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), g0.h(new y(g0.b(a.class), "constructors", "getConstructors()Ljava/util/Collection;")), g0.h(new y(g0.b(a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), g0.h(new y(g0.b(a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), g0.h(new y(g0.b(a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), g0.h(new y(g0.b(a.class), "supertypes", "getSupertypes()Ljava/util/List;")), g0.h(new y(g0.b(a.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), g0.h(new y(g0.b(a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), g0.h(new y(g0.b(a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), g0.h(new y(g0.b(a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), g0.h(new y(g0.b(a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), g0.h(new y(g0.b(a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), g0.h(new y(g0.b(a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), g0.h(new y(g0.b(a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), g0.h(new y(g0.b(a.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final a0.a f23058e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final a0.a f23059f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final a0.a f23060g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final a0.a f23061h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final a0.a f23062i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final a0.a f23063j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final a0.b f23064k;
        private final a0.a l;
        private final a0.a m;
        private final a0.a n;
        private final a0.a o;
        private final a0.a p;
        private final a0.a q;
        private final a0.a r;
        private final a0.a s;
        private final a0.a t;
        private final a0.a u;
        private final a0.a v;

        /* JADX INFO: renamed from: kotlin.f0.y.e.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: KClassImpl.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class C0316a extends Lambda implements Function0<List<? extends KCallableImpl<?>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ KClassImpl<T>.a f23065f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0316a(KClassImpl<T>.a aVar) {
                super(0);
                this.f23065f = aVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KCallableImpl<?>> invoke() {
                return c0.o0(this.f23065f.g(), this.f23065f.h());
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.h$a$b */
        /* JADX INFO: compiled from: KClassImpl.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class b extends Lambda implements Function0<List<? extends KCallableImpl<?>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ KClassImpl<T>.a f23066f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(KClassImpl<T>.a aVar) {
                super(0);
                this.f23066f = aVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KCallableImpl<?>> invoke() {
                return c0.o0(this.f23066f.k(), this.f23066f.n());
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.h$a$c */
        /* JADX INFO: compiled from: KClassImpl.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class c extends Lambda implements Function0<List<? extends KCallableImpl<?>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ KClassImpl<T>.a f23067f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(KClassImpl<T>.a aVar) {
                super(0);
                this.f23067f = aVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KCallableImpl<?>> invoke() {
                return c0.o0(this.f23067f.l(), this.f23067f.o());
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.h$a$d */
        /* JADX INFO: compiled from: KClassImpl.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "kotlin.jvm.PlatformType", "T", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class d extends Lambda implements Function0<List<? extends Annotation>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ KClassImpl<T>.a f23068f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(KClassImpl<T>.a aVar) {
                super(0);
                this.f23068f = aVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Annotation> invoke() {
                return g0.e(this.f23068f.m());
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.h$a$e */
        /* JADX INFO: compiled from: KClassImpl.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002 \u0004*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/KFunction;", "T", "kotlin.jvm.PlatformType", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class e extends Lambda implements Function0<List<? extends KFunction<? extends T>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ KClassImpl<T> f23069f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(KClassImpl<T> kClassImpl) {
                super(0);
                this.f23069f = kClassImpl;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<KFunction<T>> invoke() {
                Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.l> collectionA = this.f23069f.A();
                KClassImpl<T> kClassImpl = this.f23069f;
                ArrayList arrayList = new ArrayList(v.u(collectionA, 10));
                Iterator<T> it = collectionA.iterator();
                while (it.hasNext()) {
                    arrayList.add(new KFunctionImpl(kClassImpl, (kotlin.p002reflect.jvm.internal.impl.descriptors.l) it.next()));
                }
                return arrayList;
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.h$a$f */
        /* JADX INFO: compiled from: KClassImpl.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class f extends Lambda implements Function0<List<? extends KCallableImpl<?>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ KClassImpl<T>.a f23070f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            f(KClassImpl<T>.a aVar) {
                super(0);
                this.f23070f = aVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KCallableImpl<?>> invoke() {
                return c0.o0(this.f23070f.k(), this.f23070f.l());
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.h$a$g */
        /* JADX INFO: compiled from: KClassImpl.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class g extends Lambda implements Function0<Collection<? extends KCallableImpl<?>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ KClassImpl<T> f23071f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            g(KClassImpl<T> kClassImpl) {
                super(0);
                this.f23071f = kClassImpl;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Collection<KCallableImpl<?>> invoke() {
                KClassImpl<T> kClassImpl = this.f23071f;
                return kClassImpl.D(kClassImpl.S(), KDeclarationContainerImpl.c.DECLARED);
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.h$a$h */
        /* JADX INFO: compiled from: KClassImpl.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class h extends Lambda implements Function0<Collection<? extends KCallableImpl<?>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ KClassImpl<T> f23072f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            h(KClassImpl<T> kClassImpl) {
                super(0);
                this.f23072f = kClassImpl;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Collection<KCallableImpl<?>> invoke() {
                KClassImpl<T> kClassImpl = this.f23072f;
                return kClassImpl.D(kClassImpl.T(), KDeclarationContainerImpl.c.DECLARED);
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.h$a$i */
        /* JADX INFO: compiled from: KClassImpl.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "kotlin.jvm.PlatformType", "T", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class i extends Lambda implements Function0<kotlin.p002reflect.jvm.internal.impl.descriptors.e> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ KClassImpl<T> f23073f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            i(KClassImpl<T> kClassImpl) {
                super(0);
                this.f23073f = kClassImpl;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final kotlin.p002reflect.jvm.internal.impl.descriptors.e invoke() throws InvocationTargetException {
                kotlin.reflect.y.internal.j0.f.b bVarO = this.f23073f.O();
                kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a.k kVarA = this.f23073f.Q().invoke().a();
                kotlin.p002reflect.jvm.internal.impl.descriptors.e eVarB = bVarO.k() ? kVarA.a().b(bVarO) : x.a(kVarA.b(), bVarO);
                if (eVarB != null) {
                    return eVarB;
                }
                this.f23073f.U();
                throw null;
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.h$a$j */
        /* JADX INFO: compiled from: KClassImpl.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class j extends Lambda implements Function0<Collection<? extends KCallableImpl<?>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ KClassImpl<T> f23074f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            j(KClassImpl<T> kClassImpl) {
                super(0);
                this.f23074f = kClassImpl;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Collection<KCallableImpl<?>> invoke() {
                KClassImpl<T> kClassImpl = this.f23074f;
                return kClassImpl.D(kClassImpl.S(), KDeclarationContainerImpl.c.INHERITED);
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.h$a$k */
        /* JADX INFO: compiled from: KClassImpl.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class k extends Lambda implements Function0<Collection<? extends KCallableImpl<?>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ KClassImpl<T> f23075f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            k(KClassImpl<T> kClassImpl) {
                super(0);
                this.f23075f = kClassImpl;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Collection<KCallableImpl<?>> invoke() {
                KClassImpl<T> kClassImpl = this.f23075f;
                return kClassImpl.D(kClassImpl.T(), KDeclarationContainerImpl.c.INHERITED);
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.h$a$l */
        /* JADX INFO: compiled from: KClassImpl.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a6\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u0002 \u0004*\u001a\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/KClassImpl;", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin.jvm.PlatformType", "T", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class l extends Lambda implements Function0<List<? extends KClassImpl<? extends Object>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ KClassImpl<T>.a f23076f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            l(KClassImpl<T>.a aVar) {
                super(0);
                this.f23076f = aVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KClassImpl<? extends Object>> invoke() {
                kotlin.reflect.y.internal.j0.i.w.h hVarY0 = this.f23076f.m().y0();
                kotlin.jvm.internal.m.e(hVarY0, "descriptor.unsubstitutedInnerClassesScope");
                Collection collectionA = kotlin.f0.y.e.j0.i.w.k.a.a(hVarY0, null, null, 3, null);
                ArrayList<kotlin.p002reflect.jvm.internal.impl.descriptors.m> arrayList = new ArrayList();
                for (T t : collectionA) {
                    if (!kotlin.reflect.y.internal.j0.i.d.B((kotlin.p002reflect.jvm.internal.impl.descriptors.m) t)) {
                        arrayList.add(t);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar : arrayList) {
                    kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar = mVar instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e ? (kotlin.p002reflect.jvm.internal.impl.descriptors.e) mVar : null;
                    Class<?> clsP = eVar != null ? g0.p(eVar) : null;
                    KClassImpl kClassImpl = clsP != null ? new KClassImpl(clsP) : null;
                    if (kClassImpl != null) {
                        arrayList2.add(kClassImpl);
                    }
                }
                return arrayList2;
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.h$a$m */
        /* JADX INFO: compiled from: KClassImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", HttpUrl.FRAGMENT_ENCODE_SET, "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class m extends Lambda implements Function0<T> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ KClassImpl<T>.a f23077f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ KClassImpl<T> f23078g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            m(KClassImpl<T>.a aVar, KClassImpl<T> kClassImpl) {
                super(0);
                this.f23077f = aVar;
                this.f23078g = kClassImpl;
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                kotlin.p002reflect.jvm.internal.impl.descriptors.e eVarM = this.f23077f.m();
                if (eVarM.i() != kotlin.p002reflect.jvm.internal.impl.descriptors.f.OBJECT) {
                    return null;
                }
                T t = (T) ((!eVarM.A() || kotlin.reflect.y.internal.j0.b.d.a(kotlin.reflect.y.internal.j0.b.c.a, eVarM)) ? this.f23078g.a().getDeclaredField("INSTANCE") : this.f23078g.a().getEnclosingClass().getDeclaredField(eVarM.getName().k())).get(null);
                kotlin.jvm.internal.m.d(t, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.KClassImpl");
                return t;
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.h$a$n */
        /* JADX INFO: compiled from: KClassImpl.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "T", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class n extends Lambda implements Function0<String> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ KClassImpl<T> f23079f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            n(KClassImpl<T> kClassImpl) {
                super(0);
                this.f23079f = kClassImpl;
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                if (this.f23079f.a().isAnonymousClass()) {
                    return null;
                }
                kotlin.reflect.y.internal.j0.f.b bVarO = this.f23079f.O();
                if (bVarO.k()) {
                    return null;
                }
                return bVarO.b().b();
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.h$a$o */
        /* JADX INFO: compiled from: KClassImpl.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00030\u0002 \u0004*\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "kotlin.jvm.PlatformType", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class o extends Lambda implements Function0<List<? extends KClassImpl<? extends T>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ KClassImpl<T>.a f23080f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            o(KClassImpl<T>.a aVar) {
                super(0);
                this.f23080f = aVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<KClassImpl<? extends T>> invoke() {
                Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.e> collectionJ = this.f23080f.m().J();
                kotlin.jvm.internal.m.e(collectionJ, "descriptor.sealedSubclasses");
                ArrayList arrayList = new ArrayList();
                for (kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar : collectionJ) {
                    kotlin.jvm.internal.m.d(eVar, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    Class<?> clsP = g0.p(eVar);
                    KClassImpl kClassImpl = clsP != null ? new KClassImpl(clsP) : null;
                    if (kClassImpl != null) {
                        arrayList.add(kClassImpl);
                    }
                }
                return arrayList;
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.h$a$p */
        /* JADX INFO: compiled from: KClassImpl.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "T", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class p extends Lambda implements Function0<String> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ KClassImpl<T> f23081f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ KClassImpl<T>.a f23082g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            p(KClassImpl<T> kClassImpl, KClassImpl<T>.a aVar) {
                super(0);
                this.f23081f = kClassImpl;
                this.f23082g = aVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                if (this.f23081f.a().isAnonymousClass()) {
                    return null;
                }
                kotlin.reflect.y.internal.j0.f.b bVarO = this.f23081f.O();
                if (bVarO.k()) {
                    return this.f23082g.f(this.f23081f.a());
                }
                String strK = bVarO.j().k();
                kotlin.jvm.internal.m.e(strK, "classId.shortClassName.asString()");
                return strK;
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.h$a$q */
        /* JADX INFO: compiled from: KClassImpl.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "T", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class q extends Lambda implements Function0<List<? extends KTypeImpl>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ KClassImpl<T>.a f23083f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ KClassImpl<T> f23084g;

            /* JADX INFO: renamed from: kotlin.f0.y.e.h$a$q$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: KClassImpl.kt */
            @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Type;", "T", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
            static final class C0317a extends Lambda implements Function0<Type> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ e0 f23085f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ KClassImpl<T>.a f23086g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                final /* synthetic */ KClassImpl<T> f23087h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0317a(e0 e0Var, KClassImpl<T>.a aVar, KClassImpl<T> kClassImpl) {
                    super(0);
                    this.f23085f = e0Var;
                    this.f23086g = aVar;
                    this.f23087h = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Type invoke() {
                    kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarW = this.f23085f.O0().w();
                    if (!(hVarW instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e)) {
                        throw new KotlinReflectionInternalError("Supertype not a class: " + hVarW);
                    }
                    Class<?> clsP = g0.p((kotlin.p002reflect.jvm.internal.impl.descriptors.e) hVarW);
                    if (clsP == null) {
                        throw new KotlinReflectionInternalError("Unsupported superclass of " + this.f23086g + ": " + hVarW);
                    }
                    if (kotlin.jvm.internal.m.a(this.f23087h.a().getSuperclass(), clsP)) {
                        Type genericSuperclass = this.f23087h.a().getGenericSuperclass();
                        kotlin.jvm.internal.m.e(genericSuperclass, "{\n                      …ass\n                    }");
                        return genericSuperclass;
                    }
                    Class<?>[] interfaces = this.f23087h.a().getInterfaces();
                    kotlin.jvm.internal.m.e(interfaces, "jClass.interfaces");
                    int iE = kotlin.collections.n.E(interfaces, clsP);
                    if (iE >= 0) {
                        Type type = this.f23087h.a().getGenericInterfaces()[iE];
                        kotlin.jvm.internal.m.e(type, "{\n                      …ex]\n                    }");
                        return type;
                    }
                    throw new KotlinReflectionInternalError("No superclass of " + this.f23086g + " in Java reflection for " + hVarW);
                }
            }

            /* JADX INFO: renamed from: kotlin.f0.y.e.h$a$q$b */
            /* JADX INFO: compiled from: KClassImpl.kt */
            @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Type;", "T", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
            static final class b extends Lambda implements Function0<Type> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                public static final b f23088f = new b();

                b() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Type invoke() {
                    return Object.class;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            q(KClassImpl<T>.a aVar, KClassImpl<T> kClassImpl) {
                super(0);
                this.f23083f = aVar;
                this.f23084g = kClassImpl;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KTypeImpl> invoke() {
                kotlin.p002reflect.jvm.internal.impl.descriptors.f fVarI;
                Collection<e0> collectionA = this.f23083f.m().h().a();
                kotlin.jvm.internal.m.e(collectionA, "descriptor.typeConstructor.supertypes");
                ArrayList arrayList = new ArrayList(collectionA.size());
                KClassImpl<T>.a aVar = this.f23083f;
                KClassImpl<T> kClassImpl = this.f23084g;
                for (e0 e0Var : collectionA) {
                    kotlin.jvm.internal.m.e(e0Var, "kotlinType");
                    arrayList.add(new KTypeImpl(e0Var, new C0317a(e0Var, aVar, kClassImpl)));
                }
                if (!kotlin.reflect.y.internal.j0.b.h.t0(this.f23083f.m())) {
                    boolean z = false;
                    if (arrayList.isEmpty()) {
                        z = true;
                        break;
                    }
                    Iterator<T> it = arrayList.iterator();
                    do {
                        if (!it.hasNext()) {
                            z = true;
                            break;
                        }
                        fVarI = kotlin.reflect.y.internal.j0.i.d.e(((KTypeImpl) it.next()).getF25005g()).i();
                        kotlin.jvm.internal.m.e(fVarI, "getClassDescriptorForType(it.type).kind");
                    } while (fVarI == kotlin.p002reflect.jvm.internal.impl.descriptors.f.INTERFACE || fVarI == kotlin.p002reflect.jvm.internal.impl.descriptors.f.ANNOTATION_CLASS);
                    if (z) {
                        m0 m0VarI = kotlin.reflect.y.internal.j0.i.t.a.f(this.f23083f.m()).i();
                        kotlin.jvm.internal.m.e(m0VarI, "descriptor.builtIns.anyType");
                        arrayList.add(new KTypeImpl(m0VarI, b.f23088f));
                    }
                }
                return kotlin.p002reflect.jvm.internal.impl.utils.a.c(arrayList);
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.h$a$r */
        /* JADX INFO: compiled from: KClassImpl.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "kotlin.jvm.PlatformType", "T", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class r extends Lambda implements Function0<List<? extends KTypeParameterImpl>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ KClassImpl<T>.a f23089f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ KClassImpl<T> f23090g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            r(KClassImpl<T>.a aVar, KClassImpl<T> kClassImpl) {
                super(0);
                this.f23089f = aVar;
                this.f23090g = kClassImpl;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KTypeParameterImpl> invoke() {
                List<e1> listW = this.f23089f.m().w();
                kotlin.jvm.internal.m.e(listW, "descriptor.declaredTypeParameters");
                KClassImpl<T> kClassImpl = this.f23090g;
                ArrayList arrayList = new ArrayList(v.u(listW, 10));
                for (e1 e1Var : listW) {
                    kotlin.jvm.internal.m.e(e1Var, "descriptor");
                    arrayList.add(new KTypeParameterImpl(kClassImpl, e1Var));
                }
                return arrayList;
            }
        }

        public a() {
            super();
            this.f23058e = a0.d(new i(KClassImpl.this));
            this.f23059f = a0.d(new d(this));
            this.f23060g = a0.d(new p(KClassImpl.this, this));
            this.f23061h = a0.d(new n(KClassImpl.this));
            this.f23062i = a0.d(new e(KClassImpl.this));
            this.f23063j = a0.d(new l(this));
            this.f23064k = a0.b(new m(this, KClassImpl.this));
            this.l = a0.d(new r(this, KClassImpl.this));
            this.m = a0.d(new q(this, KClassImpl.this));
            this.n = a0.d(new o(this));
            this.o = a0.d(new g(KClassImpl.this));
            this.p = a0.d(new h(KClassImpl.this));
            this.q = a0.d(new j(KClassImpl.this));
            this.r = a0.d(new k(KClassImpl.this));
            this.s = a0.d(new b(this));
            this.t = a0.d(new c(this));
            this.u = a0.d(new f(this));
            this.v = a0.d(new C0316a(this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String f(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                kotlin.jvm.internal.m.e(simpleName, "name");
                return kotlin.text.v.G0(simpleName, enclosingMethod.getName() + '$', null, 2, null);
            }
            Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
            if (enclosingConstructor == null) {
                kotlin.jvm.internal.m.e(simpleName, "name");
                return kotlin.text.v.F0(simpleName, '$', null, 2, null);
            }
            kotlin.jvm.internal.m.e(simpleName, "name");
            return kotlin.text.v.G0(simpleName, enclosingConstructor.getName() + '$', null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> l() {
            T tC = this.p.c(this, f23057d[11]);
            kotlin.jvm.internal.m.e(tC, "<get-declaredStaticMembers>(...)");
            return (Collection) tC;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> n() {
            T tC = this.q.c(this, f23057d[12]);
            kotlin.jvm.internal.m.e(tC, "<get-inheritedNonStaticMembers>(...)");
            return (Collection) tC;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> o() {
            T tC = this.r.c(this, f23057d[13]);
            kotlin.jvm.internal.m.e(tC, "<get-inheritedStaticMembers>(...)");
            return (Collection) tC;
        }

        public final Collection<KCallableImpl<?>> g() {
            T tC = this.s.c(this, f23057d[14]);
            kotlin.jvm.internal.m.e(tC, "<get-allNonStaticMembers>(...)");
            return (Collection) tC;
        }

        public final Collection<KCallableImpl<?>> h() {
            T tC = this.t.c(this, f23057d[15]);
            kotlin.jvm.internal.m.e(tC, "<get-allStaticMembers>(...)");
            return (Collection) tC;
        }

        public final List<Annotation> i() {
            T tC = this.f23059f.c(this, f23057d[1]);
            kotlin.jvm.internal.m.e(tC, "<get-annotations>(...)");
            return (List) tC;
        }

        public final Collection<KFunction<T>> j() {
            T tC = this.f23062i.c(this, f23057d[4]);
            kotlin.jvm.internal.m.e(tC, "<get-constructors>(...)");
            return (Collection) tC;
        }

        public final Collection<KCallableImpl<?>> k() {
            T tC = this.o.c(this, f23057d[10]);
            kotlin.jvm.internal.m.e(tC, "<get-declaredNonStaticMembers>(...)");
            return (Collection) tC;
        }

        public final kotlin.p002reflect.jvm.internal.impl.descriptors.e m() {
            T tC = this.f23058e.c(this, f23057d[0]);
            kotlin.jvm.internal.m.e(tC, "<get-descriptor>(...)");
            return (kotlin.p002reflect.jvm.internal.impl.descriptors.e) tC;
        }

        public final T p() {
            return this.f23064k.c(this, f23057d[6]);
        }

        public final String q() {
            return (String) this.f23061h.c(this, f23057d[3]);
        }

        public final String r() {
            return (String) this.f23060g.c(this, f23057d[2]);
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.h$b */
    /* JADX INFO: compiled from: KClassImpl.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[kotlin.reflect.y.internal.j0.d.b.c0.a.EnumC0345a.values().length];
            iArr[kotlin.reflect.y.internal.j0.d.b.c0.a.EnumC0345a.FILE_FACADE.ordinal()] = 1;
            iArr[kotlin.reflect.y.internal.j0.d.b.c0.a.EnumC0345a.MULTIFILE_CLASS.ordinal()] = 2;
            iArr[kotlin.reflect.y.internal.j0.d.b.c0.a.EnumC0345a.MULTIFILE_CLASS_PART.ordinal()] = 3;
            iArr[kotlin.reflect.y.internal.j0.d.b.c0.a.EnumC0345a.SYNTHETIC_CLASS.ordinal()] = 4;
            iArr[kotlin.reflect.y.internal.j0.d.b.c0.a.EnumC0345a.UNKNOWN.ordinal()] = 5;
            iArr[kotlin.reflect.y.internal.j0.d.b.c0.a.EnumC0345a.CLASS.ordinal()] = 6;
            a = iArr;
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.h$c */
    /* JADX INFO: compiled from: KClassImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u001e \u0004*\u000e\u0018\u00010\u0001R\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001R\b\u0012\u0004\u0012\u0002H\u00030\u0002\"\b\b\u0000\u0010\u0003*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "kotlin.jvm.PlatformType", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class c extends Lambda implements Function0<KClassImpl<T>.a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ KClassImpl<T> f23091f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(KClassImpl<T> kClassImpl) {
            super(0);
            this.f23091f = kClassImpl;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final KClassImpl<T>.a invoke() {
            return this.f23091f.new a();
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.h$d */
    /* JADX INFO: compiled from: KClassImpl.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* synthetic */ class d extends i implements Function2<w, n, t0> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final d f23092h = new d();

        d() {
            super(2);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* JADX INFO: renamed from: getName */
        public final String getM() {
            return "loadProperty";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(w.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public final t0 invoke(w wVar, n nVar) {
            m.f(wVar, "p0");
            m.f(nVar, "p1");
            return wVar.l(nVar);
        }
    }

    public KClassImpl(Class<T> cls) {
        m.f(cls, "jClass");
        this.f23055i = cls;
        a0.b<KClassImpl<T>.a> bVarB = a0.b(new c(this));
        m.e(bVarB, "lazy { Data() }");
        this.f23056j = bVarB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.y.internal.j0.f.b O() {
        return RuntimeTypeMapper.a.c(a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Void U() throws InvocationTargetException {
        kotlin.reflect.y.internal.j0.d.b.c0.a aVarA;
        f fVarA = f.a.a(a());
        kotlin.reflect.y.internal.j0.d.b.c0.a.EnumC0345a enumC0345aC = (fVarA == null || (aVarA = fVarA.a()) == null) ? null : aVarA.c();
        switch (enumC0345aC == null ? -1 : b.a[enumC0345aC.ordinal()]) {
            case -1:
            case 6:
                throw new KotlinReflectionInternalError("Unresolved class: " + a());
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
            case 2:
            case 3:
                throw new UnsupportedOperationException("Packages and file facades are not yet supported in Kotlin reflection. Meanwhile please use Java reflection to inspect this class: " + a());
            case 4:
                throw new UnsupportedOperationException("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection library has no idea what declarations it has. Please use Java reflection to inspect this class: " + a());
            case 5:
                throw new KotlinReflectionInternalError("Unknown class: " + a() + " (kind = " + enumC0345aC + ')');
        }
    }

    @Override // kotlin.reflect.y.internal.KDeclarationContainerImpl
    public Collection<l> A() {
        e eVarR = R();
        if (eVarR.i() == kotlin.p002reflect.jvm.internal.impl.descriptors.f.INTERFACE || eVarR.i() == kotlin.p002reflect.jvm.internal.impl.descriptors.f.OBJECT) {
            return u.j();
        }
        Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.d> collectionK = eVarR.k();
        m.e(collectionK, "descriptor.constructors");
        return collectionK;
    }

    @Override // kotlin.reflect.y.internal.KDeclarationContainerImpl
    public Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.y> B(kotlin.reflect.y.internal.j0.f.f fVar) {
        m.f(fVar, "name");
        h hVarS = S();
        kotlin.reflect.y.internal.j0.c.b.d dVar = kotlin.reflect.y.internal.j0.c.b.d.FROM_REFLECTION;
        return c0.o0(hVarS.a(fVar, dVar), T().a(fVar, dVar));
    }

    @Override // kotlin.reflect.y.internal.KDeclarationContainerImpl
    public t0 C(int i2) {
        Class<?> declaringClass;
        if (m.a(a().getSimpleName(), "DefaultImpls") && (declaringClass = a().getDeclaringClass()) != null && declaringClass.isInterface()) {
            KClass kClassE = kotlin.jvm.a.e(declaringClass);
            m.d(kClassE, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            return ((KClassImpl) kClassE).C(i2);
        }
        e eVarR = R();
        kotlin.reflect.y.internal.j0.j.b.g0.d dVar = eVarR instanceof kotlin.reflect.y.internal.j0.j.b.g0.d ? (kotlin.reflect.y.internal.j0.j.b.g0.d) eVarR : null;
        if (dVar == null) {
            return null;
        }
        kotlin.reflect.y.internal.j0.e.c cVarC1 = dVar.c1();
        kotlin.reflect.jvm.internal.impl.protobuf.h.f<kotlin.reflect.y.internal.j0.e.c, List<n>> fVar = kotlin.reflect.y.internal.j0.e.a0.a.f23829j;
        m.e(fVar, "classLocalVariable");
        n nVar = (n) kotlin.reflect.y.internal.j0.e.z.e.b(cVarC1, fVar, i2);
        if (nVar != null) {
            return (t0) g0.h(a(), nVar, dVar.b1().g(), dVar.b1().j(), dVar.e1(), d.f23092h);
        }
        return null;
    }

    @Override // kotlin.reflect.y.internal.KDeclarationContainerImpl
    public Collection<t0> F(kotlin.reflect.y.internal.j0.f.f fVar) {
        m.f(fVar, "name");
        h hVarS = S();
        kotlin.reflect.y.internal.j0.c.b.d dVar = kotlin.reflect.y.internal.j0.c.b.d.FROM_REFLECTION;
        return c0.o0(hVarS.c(fVar, dVar), T().c(fVar, dVar));
    }

    public Collection<KFunction<T>> P() {
        return this.f23056j.invoke().j();
    }

    public final a0.b<KClassImpl<T>.a> Q() {
        return this.f23056j;
    }

    public e R() {
        return this.f23056j.invoke().m();
    }

    public final h S() {
        return R().s().q();
    }

    public final h T() {
        h hVarS = R().S();
        m.e(hVarS, "descriptor.staticScope");
        return hVarS;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<T> a() {
        return this.f23055i;
    }

    public boolean equals(Object other) {
        return (other instanceof KClassImpl) && m.a(kotlin.jvm.a.c(this), kotlin.jvm.a.c((KClass) other));
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return this.f23056j.invoke().i();
    }

    public int hashCode() {
        return kotlin.jvm.a.c(this).hashCode();
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        return R().j() == d0.ABSTRACT;
    }

    @Override // kotlin.reflect.KClass
    public boolean l() {
        return R().l();
    }

    @Override // kotlin.reflect.KClass
    public boolean m() {
        return R().m();
    }

    @Override // kotlin.reflect.KClass
    public boolean o() {
        return R().j() == d0.SEALED;
    }

    @Override // kotlin.reflect.KClass
    public String p() {
        return this.f23056j.invoke().q();
    }

    @Override // kotlin.reflect.KClass
    public String q() {
        return this.f23056j.invoke().r();
    }

    @Override // kotlin.reflect.KClass
    public T r() {
        return this.f23056j.invoke().p();
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("class ");
        kotlin.reflect.y.internal.j0.f.b bVarO = O();
        kotlin.reflect.y.internal.j0.f.c cVarH = bVarO.h();
        m.e(cVarH, "classId.packageFqName");
        if (cVarH.d()) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        } else {
            str = cVarH.b() + '.';
        }
        String strB = bVarO.i().b();
        m.e(strB, "classId.relativeClassName.asString()");
        sb.append(str + kotlin.text.u.z(strB, '.', '$', false, 4, null));
        return sb.toString();
    }
}
