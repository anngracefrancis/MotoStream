package kotlin.reflect.y.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.j1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.l;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.y.internal.KotlinReflectionInternalError;
import kotlin.reflect.y.internal.g0;
import kotlin.reflect.y.internal.j0.i.f;
import kotlin.reflect.y.internal.j0.i.t.a;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.n1;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: InlineClassAwareCaller.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a6\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\n\b\u0000\u0010\n*\u0004\u0018\u00010\u000b*\b\u0012\u0004\u0012\u0002H\n0\t2\u0006\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\u0018\u0010\u0011\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\f\u0010\u0012\u001a\u00020\r*\u00020\u0002H\u0002\u001a\u0014\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u0004\u0018\u00010\u0014H\u0000\u001a\u0012\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u00020\u0001H\u0000\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0015"}, d2 = {"expectedReceiverType", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getExpectedReceiverType", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;)Lorg/jetbrains/kotlin/types/KotlinType;", "coerceToExpectedReceiverType", HttpUrl.FRAGMENT_ENCODE_SET, "descriptor", "createInlineClassAwareCallerIfNeeded", "Lkotlin/reflect/jvm/internal/calls/Caller;", "M", "Ljava/lang/reflect/Member;", "isDefault", HttpUrl.FRAGMENT_ENCODE_SET, "getBoxMethod", "Ljava/lang/reflect/Method;", "Ljava/lang/Class;", "getUnboxMethod", "hasInlineClassReceiver", "toInlineClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class h {
    public static final Object a(Object obj, b bVar) {
        e0 e0VarE;
        Class<?> clsI;
        Method methodF;
        m.f(bVar, "descriptor");
        return (((bVar instanceof t0) && f.d((j1) bVar)) || (e0VarE = e(bVar)) == null || (clsI = i(e0VarE)) == null || (methodF = f(clsI, bVar)) == null) ? obj : methodF.invoke(obj, new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends Member> Caller<M> b(Caller<? extends M> caller, b bVar, boolean z) {
        boolean z2;
        m.f(caller, "<this>");
        m.f(bVar, "descriptor");
        boolean z3 = true;
        if (!f.a(bVar)) {
            List<i1> listF = bVar.f();
            m.e(listF, "descriptor.valueParameters");
            if (!(listF instanceof Collection) || !listF.isEmpty()) {
                Iterator<T> it = listF.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    e0 type = ((i1) it.next()).getType();
                    m.e(type, "it.type");
                    if (f.c(type)) {
                        z2 = true;
                        break;
                    }
                }
            } else {
                z2 = false;
                break;
            }
            if (!z2) {
                e0 returnType = bVar.getReturnType();
                if (!(returnType != null && f.c(returnType)) && ((caller instanceof BoundCaller) || !g(bVar))) {
                    z3 = false;
                }
            }
        }
        return z3 ? new InlineClassAwareCaller(bVar, caller, z) : caller;
    }

    public static /* synthetic */ Caller c(Caller caller, b bVar, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return b(caller, bVar, z);
    }

    public static final Method d(Class<?> cls, b bVar) {
        m.f(cls, "<this>");
        m.f(bVar, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", f(cls, bVar).getReturnType());
            m.e(declaredMethod, "{\n        getDeclaredMet…riptor).returnType)\n    }");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No box method found in inline class: " + cls + " (calling " + bVar + ')');
        }
    }

    private static final e0 e(b bVar) {
        w0 w0VarM0 = bVar.m0();
        w0 w0VarF0 = bVar.f0();
        if (w0VarM0 != null) {
            return w0VarM0.getType();
        }
        if (w0VarF0 == null) {
            return null;
        }
        if (bVar instanceof l) {
            return w0VarF0.getType();
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = bVar.b();
        e eVar = mVarB instanceof e ? (e) mVarB : null;
        if (eVar != null) {
            return eVar.s();
        }
        return null;
    }

    public static final Method f(Class<?> cls, b bVar) {
        m.f(cls, "<this>");
        m.f(bVar, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", new Class[0]);
            m.e(declaredMethod, "{\n        getDeclaredMet…LINE_CLASS_MEMBERS)\n    }");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No unbox method found in inline class: " + cls + " (calling " + bVar + ')');
        }
    }

    private static final boolean g(b bVar) {
        e0 e0VarE = e(bVar);
        return e0VarE != null && f.c(e0VarE);
    }

    public static final Class<?> h(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
        if (!(mVar instanceof e) || !f.b(mVar)) {
            return null;
        }
        e eVar = (e) mVar;
        Class<?> clsP = g0.p(eVar);
        if (clsP != null) {
            return clsP;
        }
        throw new KotlinReflectionInternalError("Class object for the class " + eVar.getName() + " cannot be found (classId=" + a.g((kotlin.p002reflect.jvm.internal.impl.descriptors.h) mVar) + ')');
    }

    public static final Class<?> i(e0 e0Var) {
        m.f(e0Var, "<this>");
        Class<?> clsH = h(e0Var.O0().w());
        if (clsH == null) {
            return null;
        }
        if (!n1.l(e0Var)) {
            return clsH;
        }
        e0 e0VarE = f.e(e0Var);
        if (e0VarE == null || n1.l(e0VarE) || kotlin.reflect.y.internal.j0.b.h.r0(e0VarE)) {
            return null;
        }
        return clsH;
    }
}
