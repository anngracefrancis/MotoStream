package kotlin.reflect.y.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeParameterReference;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import kotlin.reflect.y.internal.j0.d.b.k;
import kotlin.reflect.y.internal.j0.d.b.q;
import kotlin.reflect.y.internal.j0.j.b.g0.f;
import kotlin.reflect.y.internal.j0.j.b.g0.g;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.u;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.f0.y.e.w, reason: from Kotlin metadata */
/* JADX INFO: compiled from: KTypeParameterImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\u0010\u0010\"\u001a\u0006\u0012\u0002\b\u00030#*\u00020$H\u0002J\u0010\u0010%\u001a\u0006\u0012\u0002\b\u00030&*\u00020'H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "container", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "isReified", HttpUrl.FRAGMENT_ENCODE_SET, "()Z", "name", HttpUrl.FRAGMENT_ENCODE_SET, "getName", "()Ljava/lang/String;", "upperBounds", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "upperBounds$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "getContainerClass", "Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedMemberDescriptor;", "toKClassImpl", "Lkotlin/reflect/jvm/internal/KClassImpl;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KTypeParameterImpl implements KTypeParameter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f25016f = {g0.h(new y(g0.b(KTypeParameterImpl.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e1 f25017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a0.a f25018h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final KTypeParameterOwnerImpl f25019i;

    /* JADX INFO: renamed from: kotlin.f0.y.e.w$a */
    /* JADX INFO: compiled from: KTypeParameterImpl.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[r1.values().length];
            iArr[r1.INVARIANT.ordinal()] = 1;
            iArr[r1.IN_VARIANCE.ordinal()] = 2;
            iArr[r1.OUT_VARIANCE.ordinal()] = 3;
            a = iArr;
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.w$b */
    /* JADX INFO: compiled from: KTypeParameterImpl.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class b extends Lambda implements Function0<List<? extends KTypeImpl>> {
        b() {
            super(0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function0
        public final List<? extends KTypeImpl> invoke() {
            List<e0> upperBounds = KTypeParameterImpl.this.getF25017g().getUpperBounds();
            m.e(upperBounds, "descriptor.upperBounds");
            ArrayList arrayList = new ArrayList(v.u(upperBounds, 10));
            Iterator<T> it = upperBounds.iterator();
            while (it.hasNext()) {
                arrayList.add(new KTypeImpl((e0) it.next(), null, 2, 0 == true ? 1 : 0));
            }
            return arrayList;
        }
    }

    public KTypeParameterImpl(KTypeParameterOwnerImpl kTypeParameterOwnerImpl, e1 e1Var) {
        KClassImpl<?> kClassImplC;
        Object objL;
        m.f(e1Var, "descriptor");
        this.f25017g = e1Var;
        this.f25018h = a0.d(new b());
        if (kTypeParameterOwnerImpl == null) {
            kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = getF25017g().b();
            m.e(mVarB, "descriptor.containingDeclaration");
            if (mVarB instanceof e) {
                objL = c((e) mVarB);
            } else {
                if (!(mVarB instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.b)) {
                    throw new KotlinReflectionInternalError("Unknown type parameter container: " + mVarB);
                }
                kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB2 = ((kotlin.p002reflect.jvm.internal.impl.descriptors.b) mVarB).b();
                m.e(mVarB2, "declaration.containingDeclaration");
                if (mVarB2 instanceof e) {
                    kClassImplC = c((e) mVarB2);
                } else {
                    g gVar = mVarB instanceof g ? (g) mVarB : null;
                    if (gVar == null) {
                        throw new KotlinReflectionInternalError("Non-class callable descriptor must be deserialized: " + mVarB);
                    }
                    KClass kClassE = kotlin.jvm.a.e(a(gVar));
                    m.d(kClassE, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                    kClassImplC = (KClassImpl) kClassE;
                }
                objL = mVarB.L(new CreateKCallableVisitor(kClassImplC), u.a);
            }
            m.e(objL, "when (val declaration = … $declaration\")\n        }");
            kTypeParameterOwnerImpl = (KTypeParameterOwnerImpl) objL;
        }
        this.f25019i = kTypeParameterOwnerImpl;
    }

    private final Class<?> a(g gVar) {
        Class<?> clsD;
        f fVarC0 = gVar.c0();
        if (!(fVarC0 instanceof k)) {
            fVarC0 = null;
        }
        k kVar = (k) fVarC0;
        q qVarG = kVar != null ? kVar.g() : null;
        kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a.f fVar = (kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a.f) (qVarG instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a.f ? qVarG : null);
        if (fVar != null && (clsD = fVar.d()) != null) {
            return clsD;
        }
        throw new KotlinReflectionInternalError("Container of deserialized member is not resolved: " + gVar);
    }

    private final KClassImpl<?> c(e eVar) {
        Class<?> clsP = g0.p(eVar);
        KClassImpl<?> kClassImpl = (KClassImpl) (clsP != null ? kotlin.jvm.a.e(clsP) : null);
        if (kClassImpl != null) {
            return kClassImpl;
        }
        throw new KotlinReflectionInternalError("Type parameter container is not resolved: " + eVar.b());
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public e1 getF25017g() {
        return this.f25017g;
    }

    public boolean equals(Object other) {
        if (other instanceof KTypeParameterImpl) {
            KTypeParameterImpl kTypeParameterImpl = (KTypeParameterImpl) other;
            if (m.a(this.f25019i, kTypeParameterImpl.f25019i) && m.a(getName(), kTypeParameterImpl.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KTypeParameter
    public String getName() {
        String strK = getF25017g().getName().k();
        m.e(strK, "descriptor.name.asString()");
        return strK;
    }

    @Override // kotlin.reflect.KTypeParameter
    public List<KType> getUpperBounds() {
        T tC = this.f25018h.c(this, f25016f[0]);
        m.e(tC, "<get-upperBounds>(...)");
        return (List) tC;
    }

    public int hashCode() {
        return (this.f25019i.hashCode() * 31) + getName().hashCode();
    }

    @Override // kotlin.reflect.KTypeParameter
    public KVariance n() {
        int i2 = a.a[getF25017g().n().ordinal()];
        if (i2 == 1) {
            return KVariance.INVARIANT;
        }
        if (i2 == 2) {
            return KVariance.IN;
        }
        if (i2 == 3) {
            return KVariance.OUT;
        }
        throw new NoWhenBranchMatchedException();
    }

    public String toString() {
        return TypeParameterReference.f22947f.a(this);
    }
}
