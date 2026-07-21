package kotlin.reflect.y.internal;

import cm.aptoide.pt.database.room.RoomInstalled;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.y.internal.calls.AnnotationConstructorCaller;
import kotlin.reflect.y.internal.calls.Caller;
import kotlin.reflect.y.internal.calls.CallerImpl;
import kotlin.reflect.y.internal.calls.f;
import kotlin.reflect.y.internal.calls.h;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.f0.y.e.j, reason: from Kotlin metadata */
/* JADX INFO: compiled from: KFunctionImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u00020\u0005B)\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB5\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0012J.\u00102\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u000304032\n\u00105\u001a\u0006\u0012\u0002\b\u0003042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00106\u001a\u00020)H\u0002J\u0010\u00107\u001a\u0002082\u0006\u00105\u001a\u000209H\u0002J\u0010\u0010:\u001a\u0002082\u0006\u00105\u001a\u000209H\u0002J\u0010\u0010;\u001a\u0002082\u0006\u00105\u001a\u000209H\u0002J\u0013\u0010<\u001a\u00020)2\b\u0010=\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010>\u001a\u00020\u0014H\u0016J\b\u0010?\u001a\u00020\tH\u0016R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R!\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b\"\u0010\u001cR\u001b\u0010\r\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010*R\u0014\u0010+\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010*R\u0014\u0010,\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010*R\u0014\u0010.\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010*R\u0014\u0010/\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010*R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", HttpUrl.FRAGMENT_ENCODE_SET, RoomInstalled.SIGNATURE, "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "arity", HttpUrl.FRAGMENT_ENCODE_SET, "getArity", "()I", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "isBound", HttpUrl.FRAGMENT_ENCODE_SET, "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "getName", "()Ljava/lang/String;", "createConstructorCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "member", "isDefault", "createInstanceMethodCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Ljava/lang/reflect/Method;", "createJvmStaticInObjectCaller", "createStaticMethodCaller", "equals", "other", "hashCode", "toString", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KFunctionImpl extends KCallableImpl<Object> implements FunctionBase<Object>, KFunction<Object>, FunctionWithAllInvokes {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f23146j = {g0.h(new y(g0.b(KFunctionImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), g0.h(new y(g0.b(KFunctionImpl.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), g0.h(new y(g0.b(KFunctionImpl.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final KDeclarationContainerImpl f23147k;
    private final String l;
    private final Object m;
    private final a0.a n;
    private final a0.b o;
    private final a0.b p;

    /* JADX INFO: renamed from: kotlin.f0.y.e.j$a */
    /* JADX INFO: compiled from: KFunctionImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class a extends Lambda implements Function0<Caller<? extends Member>> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Caller<Member> invoke() {
            Object objB;
            Caller callerM;
            JvmFunctionSignature jvmFunctionSignatureG = RuntimeTypeMapper.a.g(KFunctionImpl.this.F());
            if (jvmFunctionSignatureG instanceof JvmFunctionSignature.d) {
                if (KFunctionImpl.this.D()) {
                    Class<?> clsA = KFunctionImpl.this.getL().a();
                    List<KParameter> parameters = KFunctionImpl.this.getParameters();
                    ArrayList arrayList = new ArrayList(v.u(parameters, 10));
                    Iterator<T> it = parameters.iterator();
                    while (it.hasNext()) {
                        String name = ((KParameter) it.next()).getName();
                        m.c(name);
                        arrayList.add(name);
                    }
                    return new AnnotationConstructorCaller(clsA, arrayList, AnnotationConstructorCaller.a.POSITIONAL_CALL, AnnotationConstructorCaller.b.KOTLIN, null, 16, null);
                }
                objB = KFunctionImpl.this.getL().u(((JvmFunctionSignature.d) jvmFunctionSignatureG).b());
            } else if (jvmFunctionSignatureG instanceof JvmFunctionSignature.e) {
                JvmFunctionSignature.e eVar = (JvmFunctionSignature.e) jvmFunctionSignatureG;
                objB = KFunctionImpl.this.getL().y(eVar.c(), eVar.b());
            } else if (jvmFunctionSignatureG instanceof JvmFunctionSignature.c) {
                objB = ((JvmFunctionSignature.c) jvmFunctionSignatureG).getA();
            } else {
                if (!(jvmFunctionSignatureG instanceof JvmFunctionSignature.b)) {
                    if (!(jvmFunctionSignatureG instanceof JvmFunctionSignature.a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    List<Method> listB = ((JvmFunctionSignature.a) jvmFunctionSignatureG).b();
                    Class<?> clsA2 = KFunctionImpl.this.getL().a();
                    ArrayList arrayList2 = new ArrayList(v.u(listB, 10));
                    Iterator<T> it2 = listB.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(((Method) it2.next()).getName());
                    }
                    return new AnnotationConstructorCaller(clsA2, arrayList2, AnnotationConstructorCaller.a.POSITIONAL_CALL, AnnotationConstructorCaller.b.JAVA, listB);
                }
                objB = ((JvmFunctionSignature.b) jvmFunctionSignatureG).b();
            }
            if (objB instanceof Constructor) {
                KFunctionImpl kFunctionImpl = KFunctionImpl.this;
                callerM = kFunctionImpl.K((Constructor) objB, kFunctionImpl.F(), false);
            } else {
                if (!(objB instanceof Method)) {
                    throw new KotlinReflectionInternalError("Could not compute caller for function: " + KFunctionImpl.this.F() + " (member = " + objB + ')');
                }
                Method method = (Method) objB;
                if (Modifier.isStatic(method.getModifiers())) {
                    callerM = KFunctionImpl.this.F().getAnnotations().l(g0.j()) != null ? KFunctionImpl.this.M(method) : KFunctionImpl.this.N(method);
                } else {
                    callerM = KFunctionImpl.this.L(method);
                }
            }
            return h.c(callerM, KFunctionImpl.this.F(), false, 2, null);
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.j$b */
    /* JADX INFO: compiled from: KFunctionImpl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class b extends Lambda implements Function0<Caller<? extends Member>> {
        b() {
            super(0);
        }

        /* JADX WARN: Code duplicated, block: B:35:0x012a  */
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Caller<Member> invoke() {
            GenericDeclaration genericDeclarationV;
            Caller callerN;
            JvmFunctionSignature jvmFunctionSignatureG = RuntimeTypeMapper.a.g(KFunctionImpl.this.F());
            if (jvmFunctionSignatureG instanceof JvmFunctionSignature.e) {
                KDeclarationContainerImpl f23147k = KFunctionImpl.this.getL();
                JvmFunctionSignature.e eVar = (JvmFunctionSignature.e) jvmFunctionSignatureG;
                String strC = eVar.c();
                String strB = eVar.b();
                Member member = KFunctionImpl.this.z().getMember();
                m.c(member);
                genericDeclarationV = f23147k.w(strC, strB, !Modifier.isStatic(member.getModifiers()));
            } else if (jvmFunctionSignatureG instanceof JvmFunctionSignature.d) {
                if (KFunctionImpl.this.D()) {
                    Class<?> clsA = KFunctionImpl.this.getL().a();
                    List<KParameter> parameters = KFunctionImpl.this.getParameters();
                    ArrayList arrayList = new ArrayList(v.u(parameters, 10));
                    Iterator<T> it = parameters.iterator();
                    while (it.hasNext()) {
                        String name = ((KParameter) it.next()).getName();
                        m.c(name);
                        arrayList.add(name);
                    }
                    return new AnnotationConstructorCaller(clsA, arrayList, AnnotationConstructorCaller.a.CALL_BY_NAME, AnnotationConstructorCaller.b.KOTLIN, null, 16, null);
                }
                genericDeclarationV = KFunctionImpl.this.getL().v(((JvmFunctionSignature.d) jvmFunctionSignatureG).b());
            } else {
                if (jvmFunctionSignatureG instanceof JvmFunctionSignature.a) {
                    List<Method> listB = ((JvmFunctionSignature.a) jvmFunctionSignatureG).b();
                    Class<?> clsA2 = KFunctionImpl.this.getL().a();
                    ArrayList arrayList2 = new ArrayList(v.u(listB, 10));
                    Iterator<T> it2 = listB.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(((Method) it2.next()).getName());
                    }
                    return new AnnotationConstructorCaller(clsA2, arrayList2, AnnotationConstructorCaller.a.CALL_BY_NAME, AnnotationConstructorCaller.b.JAVA, listB);
                }
                genericDeclarationV = null;
            }
            if (genericDeclarationV instanceof Constructor) {
                KFunctionImpl kFunctionImpl = KFunctionImpl.this;
                callerN = kFunctionImpl.K((Constructor) genericDeclarationV, kFunctionImpl.F(), true);
            } else if (!(genericDeclarationV instanceof Method)) {
                callerN = null;
            } else if (KFunctionImpl.this.F().getAnnotations().l(g0.j()) != null) {
                kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = KFunctionImpl.this.F().b();
                m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                if (((e) mVarB).A()) {
                    callerN = KFunctionImpl.this.N((Method) genericDeclarationV);
                } else {
                    callerN = KFunctionImpl.this.M((Method) genericDeclarationV);
                }
            } else {
                callerN = KFunctionImpl.this.N((Method) genericDeclarationV);
            }
            if (callerN != null) {
                return h.b(callerN, KFunctionImpl.this.F(), true);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.j$c */
    /* JADX INFO: compiled from: KFunctionImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class c extends Lambda implements Function0<kotlin.p002reflect.jvm.internal.impl.descriptors.y> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f23151g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(0);
            this.f23151g = str;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.p002reflect.jvm.internal.impl.descriptors.y invoke() {
            return KFunctionImpl.this.getL().x(this.f23151g, KFunctionImpl.this.l);
        }
    }

    /* synthetic */ KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, kotlin.p002reflect.jvm.internal.impl.descriptors.y yVar, Object obj, int i2, g gVar) {
        this(kDeclarationContainerImpl, str, str2, yVar, (i2 & 16) != 0 ? kotlin.jvm.internal.c.NO_RECEIVER : obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CallerImpl<Constructor<?>> K(Constructor<?> constructor, kotlin.p002reflect.jvm.internal.impl.descriptors.y yVar, boolean z) {
        if (z || !kotlin.reflect.y.internal.j0.i.u.b.f(yVar)) {
            return E() ? new CallerImpl.c(constructor, O()) : new CallerImpl.e(constructor);
        }
        return E() ? new CallerImpl.a(constructor, O()) : new CallerImpl.b(constructor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CallerImpl.h L(Method method) {
        return E() ? new CallerImpl.h.a(method, O()) : new CallerImpl.h.d(method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CallerImpl.h M(Method method) {
        return E() ? new CallerImpl.h.b(method) : new CallerImpl.h.e(method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CallerImpl.h N(Method method) {
        return E() ? new CallerImpl.h.c(method, O()) : new CallerImpl.h.f(method);
    }

    private final Object O() {
        return h.a(this.m, F());
    }

    @Override // kotlin.reflect.y.internal.KCallableImpl
    /* JADX INFO: renamed from: A, reason: from getter */
    public KDeclarationContainerImpl getL() {
        return this.f23147k;
    }

    @Override // kotlin.reflect.y.internal.KCallableImpl
    public Caller<?> B() {
        return (Caller) this.p.c(this, f23146j[2]);
    }

    @Override // kotlin.reflect.y.internal.KCallableImpl
    public boolean E() {
        return !m.a(this.m, kotlin.jvm.internal.c.NO_RECEIVER);
    }

    @Override // kotlin.reflect.y.internal.KCallableImpl
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public kotlin.p002reflect.jvm.internal.impl.descriptors.y F() {
        T tC = this.n.c(this, f23146j[0]);
        m.e(tC, "<get-descriptor>(...)");
        return (kotlin.p002reflect.jvm.internal.impl.descriptors.y) tC;
    }

    @Override // kotlin.jvm.functions.Function3
    public Object d(Object obj, Object obj2, Object obj3) {
        return FunctionWithAllInvokes.a.d(this, obj, obj2, obj3);
    }

    public boolean equals(Object other) {
        KFunctionImpl kFunctionImplC = g0.c(other);
        return kFunctionImplC != null && m.a(getL(), kFunctionImplC.getL()) && m.a(getM(), kFunctionImplC.getM()) && m.a(this.l, kFunctionImplC.l) && m.a(this.m, kFunctionImplC.m);
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return f.a(z());
    }

    @Override // kotlin.reflect.KCallable
    /* JADX INFO: renamed from: getName */
    public String getM() {
        String strK = F().getName().k();
        m.e(strK, "descriptor.name.asString()");
        return strK;
    }

    public int hashCode() {
        return (((getL().hashCode() * 31) + getM().hashCode()) * 31) + this.l.hashCode();
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return FunctionWithAllInvokes.a.a(this);
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return F().isSuspend();
    }

    public String toString() {
        return ReflectionObjectRenderer.a.d(F());
    }

    @Override // kotlin.reflect.y.internal.KCallableImpl
    public Caller<?> z() {
        T tC = this.o.c(this, f23146j[1]);
        m.e(tC, "<get-caller>(...)");
        return (Caller) tC;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return FunctionWithAllInvokes.a.b(this, obj);
    }

    private KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, kotlin.p002reflect.jvm.internal.impl.descriptors.y yVar, Object obj) {
        this.f23147k = kDeclarationContainerImpl;
        this.l = str2;
        this.m = obj;
        this.n = a0.c(yVar, new c(str));
        this.o = a0.b(new a());
        this.p = a0.b(new b());
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(Object obj, Object obj2) {
        return FunctionWithAllInvokes.a.c(this, obj, obj2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        this(kDeclarationContainerImpl, str, str2, null, obj);
        m.f(kDeclarationContainerImpl, "container");
        m.f(str, "name");
        m.f(str2, RoomInstalled.SIGNATURE);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, kotlin.p002reflect.jvm.internal.impl.descriptors.y yVar) {
        m.f(kDeclarationContainerImpl, "container");
        m.f(yVar, "descriptor");
        String strK = yVar.getName().k();
        m.e(strK, "descriptor.name.asString()");
        this(kDeclarationContainerImpl, strK, RuntimeTypeMapper.a.g(yVar).getF23032b(), yVar, null, 16, null);
    }
}
