package kotlin.reflect.y.internal.calls;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.l;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.ranges.IntRange;
import kotlin.reflect.y.internal.KotlinReflectionInternalError;
import kotlin.reflect.y.internal.g0;
import kotlin.reflect.y.internal.j0.i.f;
import kotlin.reflect.y.internal.j0.l.e0;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.f0.y.e.i0.g, reason: from Kotlin metadata */
/* JADX INFO: compiled from: InlineClassAwareCaller.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001cB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "caller", "isDefault", HttpUrl.FRAGMENT_ENCODE_SET, "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", HttpUrl.FRAGMENT_ENCODE_SET, "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InlineClassAwareCaller<M extends Member> implements Caller<M> {
    private final Caller<M> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f23139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f23140c;

    /* JADX INFO: renamed from: kotlin.f0.y.e.i0.g$a */
    /* JADX INFO: compiled from: InlineClassAwareCaller.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003H\u0086\u0002J\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0086\u0002¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0086\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", HttpUrl.FRAGMENT_ENCODE_SET, "argumentRange", "Lkotlin/ranges/IntRange;", "unbox", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/lang/reflect/Method;", "box", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getBox", "()Ljava/lang/reflect/Method;", "getUnbox", "()[Ljava/lang/reflect/Method;", "[Ljava/lang/reflect/Method;", "component1", "component2", "component3", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class a {
        private final IntRange a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method[] f23141b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Method f23142c;

        public a(IntRange intRange, Method[] methodArr, Method method) {
            m.f(intRange, "argumentRange");
            m.f(methodArr, "unbox");
            this.a = intRange;
            this.f23141b = methodArr;
            this.f23142c = method;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final IntRange getA() {
            return this.a;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final Method[] getF23141b() {
            return this.f23141b;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final Method getF23142c() {
            return this.f23142c;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0067  */
    /* JADX WARN: Multi-variable type inference failed */
    public InlineClassAwareCaller(b bVar, Caller<? extends M> caller, boolean z) {
        a aVar;
        Class<?> clsI;
        m.f(bVar, "descriptor");
        m.f(caller, "caller");
        this.a = caller;
        this.f23139b = z;
        e0 returnType = bVar.getReturnType();
        m.c(returnType);
        Class<?> clsI2 = h.i(returnType);
        Method methodD = clsI2 != null ? h.d(clsI2, bVar) : null;
        if (f.a(bVar)) {
            aVar = new a(IntRange.f22979j.a(), new Method[0], methodD);
        } else {
            int i2 = -1;
            if (!(caller instanceof CallerImpl.h.c)) {
                if (bVar instanceof l) {
                    if (!(caller instanceof BoundCaller)) {
                        i2 = 0;
                    }
                } else if (bVar.f0() == null || (caller instanceof BoundCaller)) {
                    i2 = 0;
                } else {
                    kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = bVar.b();
                    m.e(mVarB, "descriptor.containingDeclaration");
                    if (f.b(mVarB)) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                }
            }
            int i3 = (z ? 2 : 0) + (((bVar instanceof y) && ((y) bVar).isSuspend()) ? 1 : 0);
            ArrayList arrayList = new ArrayList();
            w0 w0VarM0 = bVar.m0();
            e0 type = w0VarM0 != null ? w0VarM0.getType() : null;
            if (type != null) {
                arrayList.add(type);
            } else if (bVar instanceof l) {
                e eVarC = ((l) bVar).C();
                m.e(eVarC, "descriptor.constructedClass");
                if (eVarC.m()) {
                    kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB2 = eVarC.b();
                    m.d(mVarB2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    arrayList.add(((e) mVarB2).s());
                }
            } else {
                kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB3 = bVar.b();
                m.e(mVarB3, "descriptor.containingDeclaration");
                if ((mVarB3 instanceof e) && f.b(mVarB3)) {
                    arrayList.add(((e) mVarB3).s());
                }
            }
            List<i1> listF = bVar.f();
            m.e(listF, "descriptor.valueParameters");
            Iterator<T> it = listF.iterator();
            while (it.hasNext()) {
                arrayList.add(((i1) it.next()).getType());
            }
            int size = arrayList.size() + i2 + i3;
            if (f.a(this) != size) {
                throw new KotlinReflectionInternalError("Inconsistent number of parameters in the descriptor and Java reflection object: " + f.a(this) + " != " + size + "\nCalling: " + bVar + "\nParameter types: " + a() + ")\nDefault: " + this.f23139b);
            }
            IntRange intRangeK = kotlin.ranges.l.k(Math.max(i2, 0), arrayList.size() + i2);
            Method[] methodArr = new Method[size];
            int i4 = 0;
            while (i4 < size) {
                methodArr[i4] = (!(i4 <= intRangeK.getF22973h() && intRangeK.getF22972g() <= i4) || (clsI = h.i((e0) arrayList.get(i4 - i2))) == null) ? null : h.f(clsI, bVar);
                i4++;
            }
            aVar = new a(intRangeK, methodArr, methodD);
        }
        this.f23140c = aVar;
    }

    @Override // kotlin.reflect.y.internal.calls.Caller
    public List<Type> a() {
        return this.a.a();
    }

    @Override // kotlin.reflect.y.internal.calls.Caller
    public Object call(Object[] args) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke;
        m.f(args, "args");
        a aVar = this.f23140c;
        IntRange a2 = aVar.getA();
        Method[] f23141b = aVar.getF23141b();
        Method f23142c = aVar.getF23142c();
        Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
        m.e(objArrCopyOf, "copyOf(this, size)");
        m.d(objArrCopyOf, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        int f22972g = a2.getF22972g();
        int f22973h = a2.getF22973h();
        if (f22972g <= f22973h) {
            while (true) {
                Method method = f23141b[f22972g];
                Object objG = args[f22972g];
                if (method != null) {
                    if (objG != null) {
                        objG = method.invoke(objG, new Object[0]);
                    } else {
                        Class<?> returnType = method.getReturnType();
                        m.e(returnType, "method.returnType");
                        objG = g0.g(returnType);
                    }
                }
                objArrCopyOf[f22972g] = objG;
                if (f22972g == f22973h) {
                    break;
                }
                f22972g++;
            }
        }
        Object objCall = this.a.call(objArrCopyOf);
        return (f23142c == null || (objInvoke = f23142c.invoke(null, objCall)) == null) ? objCall : objInvoke;
    }

    @Override // kotlin.reflect.y.internal.calls.Caller
    public M getMember() {
        return (M) this.a.getMember();
    }

    @Override // kotlin.reflect.y.internal.calls.Caller
    /* JADX INFO: renamed from: getReturnType */
    public Type getF23144c() {
        return this.a.getF23144c();
    }
}
