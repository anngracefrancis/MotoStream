package kotlin.reflect.y.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.j;
import kotlin.collections.s;
import kotlin.collections.v;
import kotlin.collections.y;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.full.IllegalCallableAccessException;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.q0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w0;
import kotlin.p003y.Continuation;
import kotlin.reflect.KCallable;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.y.internal.calls.Caller;
import kotlin.reflect.y.internal.j0.l.e0;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.f0.y.e.f, reason: from Kotlin metadata */
/* JADX INFO: compiled from: KCallableImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J%\u00106\u001a\u00028\u00002\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0016¢\u0006\u0002\u0010:J#\u0010;\u001a\u00028\u00002\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u0001090<H\u0002¢\u0006\u0002\u0010=J#\u0010>\u001a\u00028\u00002\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u0001090<H\u0016¢\u0006\u0002\u0010=J3\u0010?\u001a\u00028\u00002\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u0001090<2\f\u0010@\u001a\b\u0012\u0002\b\u0003\u0018\u00010AH\u0000¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020,H\u0002J\n\u0010F\u001a\u0004\u0018\u00010GH\u0002R(\u0010\u0005\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\b \t*\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f \t*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u000e0\u000e0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010 \t*\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017R\u0012\u0010\u001e\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010$R\u0014\u0010%\u001a\u00020#8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b%\u0010$R\u0012\u0010&\u001a\u00020#X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010$R\u0014\u0010'\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010$R\u0014\u0010(\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010$R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0013R\u0014\u0010+\u001a\u00020,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u0013R\u0016\u00102\u001a\u0004\u0018\u0001038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u0006H"}, d2 = {"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "()V", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "kotlin.jvm.PlatformType", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "annotations", "getAnnotations", "()Ljava/util/List;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "isAbstract", HttpUrl.FRAGMENT_ENCODE_SET, "()Z", "isAnnotationConstructor", "isBound", "isFinal", "isOpen", "parameters", "getParameters", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "callAnnotationConstructor", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "callDefaultMethod", "continuationArgument", "Lkotlin/coroutines/Continuation;", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultEmptyArray", "type", "extractContinuationArgument", "Ljava/lang/reflect/Type;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KCallableImpl<R> implements KCallable<R>, KTypeParameterOwnerImpl {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a0.a<List<Annotation>> f23042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a0.a<ArrayList<KParameter>> f23043g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a0.a<KTypeImpl> f23044h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final a0.a<List<KTypeParameterImpl>> f23045i;

    /* JADX INFO: renamed from: kotlin.f0.y.e.f$a */
    /* JADX INFO: compiled from: KCallableImpl.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0004 \u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "kotlin.jvm.PlatformType", "R", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class a extends Lambda implements Function0<List<? extends Annotation>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ KCallableImpl<R> f23046f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(KCallableImpl<? extends R> kCallableImpl) {
            super(0);
            this.f23046f = kCallableImpl;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends Annotation> invoke() {
            return g0.e(this.f23046f.F());
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.f$b */
    /* JADX INFO: compiled from: KCallableImpl.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0004 \u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "kotlin.jvm.PlatformType", "R", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class b extends Lambda implements Function0<ArrayList<KParameter>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ KCallableImpl<R> f23047f;

        /* JADX INFO: renamed from: kotlin.f0.y.e.f$b$a */
        /* JADX INFO: compiled from: KCallableImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "R", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class a extends Lambda implements Function0<q0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ w0 f23048f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(w0 w0Var) {
                super(0);
                this.f23048f = w0Var;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final q0 invoke() {
                return this.f23048f;
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.f$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: KCallableImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "R", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class C0315b extends Lambda implements Function0<q0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ w0 f23049f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0315b(w0 w0Var) {
                super(0);
                this.f23049f = w0Var;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final q0 invoke() {
                return this.f23049f;
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.f$b$c */
        /* JADX INFO: compiled from: KCallableImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "R", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class c extends Lambda implements Function0<q0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ kotlin.p002reflect.jvm.internal.impl.descriptors.b f23050f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ int f23051g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar, int i2) {
                super(0);
                this.f23050f = bVar;
                this.f23051g = i2;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final q0 invoke() {
                i1 i1Var = this.f23050f.f().get(this.f23051g);
                m.e(i1Var, "descriptor.valueParameters[i]");
                return i1Var;
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.f$b$d */
        /* JADX INFO: compiled from: Comparisons.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class d<T> implements Comparator {
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return kotlin.comparisons.b.a(((KParameter) t).getName(), ((KParameter) t2).getName());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(KCallableImpl<? extends R> kCallableImpl) {
            super(0);
            this.f23047f = kCallableImpl;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ArrayList<KParameter> invoke() {
            int i2;
            kotlin.p002reflect.jvm.internal.impl.descriptors.b bVarC = this.f23047f.F();
            ArrayList<KParameter> arrayList = new ArrayList<>();
            int i3 = 0;
            if (this.f23047f.E()) {
                i2 = 0;
            } else {
                w0 w0VarI = g0.i(bVarC);
                if (w0VarI != null) {
                    arrayList.add(new KParameterImpl(this.f23047f, 0, KParameter.a.INSTANCE, new a(w0VarI)));
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                w0 w0VarM0 = bVarC.m0();
                if (w0VarM0 != null) {
                    arrayList.add(new KParameterImpl(this.f23047f, i2, KParameter.a.EXTENSION_RECEIVER, new C0315b(w0VarM0)));
                    i2++;
                }
            }
            int size = bVarC.f().size();
            while (i3 < size) {
                arrayList.add(new KParameterImpl(this.f23047f, i2, KParameter.a.VALUE, new c(bVarC, i3)));
                i3++;
                i2++;
            }
            if (this.f23047f.D() && (bVarC instanceof kotlin.reflect.y.internal.j0.d.a.k0.a) && arrayList.size() > 1) {
                y.y(arrayList, new d());
            }
            arrayList.trimToSize();
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.f$c */
    /* JADX INFO: compiled from: KCallableImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "R", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class c extends Lambda implements Function0<KTypeImpl> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ KCallableImpl<R> f23052f;

        /* JADX INFO: renamed from: kotlin.f0.y.e.f$c$a */
        /* JADX INFO: compiled from: KCallableImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Type;", "R", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class a extends Lambda implements Function0<Type> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ KCallableImpl<R> f23053f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(KCallableImpl<? extends R> kCallableImpl) {
                super(0);
                this.f23053f = kCallableImpl;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Type invoke() {
                Type typeY = this.f23053f.y();
                return typeY == null ? this.f23053f.z().getF23144c() : typeY;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(KCallableImpl<? extends R> kCallableImpl) {
            super(0);
            this.f23052f = kCallableImpl;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final KTypeImpl invoke() {
            e0 returnType = this.f23052f.F().getReturnType();
            m.c(returnType);
            return new KTypeImpl(returnType, new a(this.f23052f));
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.f$d */
    /* JADX INFO: compiled from: KCallableImpl.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0004 \u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "kotlin.jvm.PlatformType", "R", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class d extends Lambda implements Function0<List<? extends KTypeParameterImpl>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ KCallableImpl<R> f23054f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(KCallableImpl<? extends R> kCallableImpl) {
            super(0);
            this.f23054f = kCallableImpl;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends KTypeParameterImpl> invoke() {
            List<e1> typeParameters = this.f23054f.F().getTypeParameters();
            m.e(typeParameters, "descriptor.typeParameters");
            KCallableImpl<R> kCallableImpl = this.f23054f;
            ArrayList arrayList = new ArrayList(v.u(typeParameters, 10));
            for (e1 e1Var : typeParameters) {
                m.e(e1Var, "descriptor");
                arrayList.add(new KTypeParameterImpl(kCallableImpl, e1Var));
            }
            return arrayList;
        }
    }

    public KCallableImpl() {
        a0.a<List<Annotation>> aVarD = a0.d(new a(this));
        m.e(aVarD, "lazySoft { descriptor.computeAnnotations() }");
        this.f23042f = aVarD;
        a0.a<ArrayList<KParameter>> aVarD2 = a0.d(new b(this));
        m.e(aVarD2, "lazySoft {\n        val d…ze()\n        result\n    }");
        this.f23043g = aVarD2;
        a0.a<KTypeImpl> aVarD3 = a0.d(new c(this));
        m.e(aVarD3, "lazySoft {\n        KType…eturnType\n        }\n    }");
        this.f23044h = aVarD3;
        a0.a<List<KTypeParameterImpl>> aVarD4 = a0.d(new d(this));
        m.e(aVarD4, "lazySoft {\n        descr…this, descriptor) }\n    }");
        this.f23045i = aVarD4;
    }

    private final R v(Map<KParameter, ? extends Object> map) throws IllegalCallableAccessException {
        Object objX;
        List<KParameter> parameters = getParameters();
        ArrayList arrayList = new ArrayList(v.u(parameters, 10));
        for (KParameter kParameter : parameters) {
            if (map.containsKey(kParameter)) {
                objX = map.get(kParameter);
                if (objX == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + kParameter + ')');
                }
            } else if (kParameter.k()) {
                objX = null;
            } else {
                if (!kParameter.h()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + kParameter);
                }
                objX = x(kParameter.getType());
            }
            arrayList.add(objX);
        }
        Caller<?> callerB = B();
        if (callerB == null) {
            throw new KotlinReflectionInternalError("This callable does not support a default call: " + F());
        }
        try {
            Object[] array = arrayList.toArray(new Object[0]);
            m.d(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return (R) callerB.call(array);
        } catch (IllegalAccessException e2) {
            throw new IllegalCallableAccessException(e2);
        }
    }

    private final Object x(KType kType) {
        Class clsB = kotlin.jvm.a.b(kotlin.reflect.y.b.b(kType));
        if (clsB.isArray()) {
            Object objNewInstance = Array.newInstance(clsB.getComponentType(), 0);
            m.e(objNewInstance, "type.jvmErasure.java.run…\"\n            )\n        }");
            return objNewInstance;
        }
        throw new KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + clsB.getSimpleName() + ", because it is not an array type");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Type y() {
        Type[] lowerBounds;
        kotlin.p002reflect.jvm.internal.impl.descriptors.b bVarC = F();
        kotlin.p002reflect.jvm.internal.impl.descriptors.y yVar = bVarC instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.y ? (kotlin.p002reflect.jvm.internal.impl.descriptors.y) bVarC : null;
        if (!(yVar != null && yVar.isSuspend())) {
            return null;
        }
        Object objI0 = s.i0(z().a());
        ParameterizedType parameterizedType = objI0 instanceof ParameterizedType ? (ParameterizedType) objI0 : null;
        if (!m.a(parameterizedType != null ? parameterizedType.getRawType() : null, Continuation.class)) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        m.e(actualTypeArguments, "continuationType.actualTypeArguments");
        Object objN = j.N(actualTypeArguments);
        WildcardType wildcardType = objN instanceof WildcardType ? (WildcardType) objN : null;
        if (wildcardType == null || (lowerBounds = wildcardType.getLowerBounds()) == null) {
            return null;
        }
        return (Type) j.w(lowerBounds);
    }

    /* JADX INFO: renamed from: A */
    public abstract KDeclarationContainerImpl getF23147k();

    public abstract Caller<?> B();

    /* JADX INFO: renamed from: C */
    public abstract kotlin.p002reflect.jvm.internal.impl.descriptors.b F();

    protected final boolean D() {
        return m.a(getM(), "<init>") && getF23147k().a().isAnnotation();
    }

    public abstract boolean E();

    @Override // kotlin.reflect.KCallable
    public R call(Object... args) throws IllegalCallableAccessException {
        m.f(args, "args");
        try {
            return (R) z().call(args);
        } catch (IllegalAccessException e2) {
            throw new IllegalCallableAccessException(e2);
        }
    }

    @Override // kotlin.reflect.KCallable
    public R callBy(Map<KParameter, ? extends Object> args) {
        m.f(args, "args");
        return D() ? v(args) : w(args, null);
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        List<Annotation> listInvoke = this.f23042f.invoke();
        m.e(listInvoke, "_annotations()");
        return listInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public List<KParameter> getParameters() {
        ArrayList<KParameter> arrayListInvoke = this.f23043g.invoke();
        m.e(arrayListInvoke, "_parameters()");
        return arrayListInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        KTypeImpl kTypeImplInvoke = this.f23044h.invoke();
        m.e(kTypeImplInvoke, "_returnType()");
        return kTypeImplInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public List<KTypeParameter> getTypeParameters() {
        List<KTypeParameterImpl> listInvoke = this.f23045i.invoke();
        m.e(listInvoke, "_typeParameters()");
        return listInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public KVisibility getVisibility() {
        u visibility = F().getVisibility();
        m.e(visibility, "descriptor.visibility");
        return g0.q(visibility);
    }

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        return F().j() == d0.ABSTRACT;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        return F().j() == d0.FINAL;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        return F().j() == d0.OPEN;
    }

    public final R w(Map<KParameter, ? extends Object> map, Continuation<?> continuation) throws IllegalCallableAccessException {
        m.f(map, "args");
        List<KParameter> parameters = getParameters();
        ArrayList arrayList = new ArrayList(parameters.size());
        ArrayList arrayList2 = new ArrayList(1);
        Iterator<KParameter> it = parameters.iterator();
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                if (continuation != null) {
                    arrayList.add(continuation);
                }
                if (!z) {
                    Object[] array = arrayList.toArray(new Object[0]);
                    m.d(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    return call(Arrays.copyOf(array, array.length));
                }
                arrayList2.add(Integer.valueOf(i3));
                Caller<?> callerB = B();
                if (callerB == null) {
                    throw new KotlinReflectionInternalError("This callable does not support a default call: " + F());
                }
                arrayList.addAll(arrayList2);
                arrayList.add(null);
                try {
                    Object[] array2 = arrayList.toArray(new Object[0]);
                    m.d(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    return (R) callerB.call(array2);
                } catch (IllegalAccessException e2) {
                    throw new IllegalCallableAccessException(e2);
                }
            }
            KParameter next = it.next();
            if (i2 != 0 && i2 % 32 == 0) {
                arrayList2.add(Integer.valueOf(i3));
                i3 = 0;
            }
            if (map.containsKey(next)) {
                arrayList.add(map.get(next));
            } else if (next.k()) {
                arrayList.add(g0.k(next.getType()) ? null : g0.g(kotlin.reflect.y.c.f(next.getType())));
                i3 = (1 << (i2 % 32)) | i3;
                z = true;
            } else {
                if (!next.h()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + next);
                }
                arrayList.add(x(next.getType()));
            }
            if (next.getF24981i() == KParameter.a.VALUE) {
                i2++;
            }
        }
    }

    public abstract Caller<?> z();
}
