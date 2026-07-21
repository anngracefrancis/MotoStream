package kotlin.reflect.y.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.y.internal.calls.Caller;
import kotlin.reflect.y.internal.calls.CallerImpl;
import kotlin.reflect.y.internal.calls.InternalUnderlyingValOfInlineClass;
import kotlin.reflect.y.internal.calls.ThrowingCaller;
import kotlin.reflect.y.internal.calls.h;
import kotlin.reflect.y.internal.j0.e.a0.a;
import kotlin.reflect.y.internal.j0.e.a0.b.i;
import kotlin.reflect.y.internal.j0.i.d;
import kotlin.reflect.y.internal.j0.i.f;
import kotlin.reflect.y.internal.j0.j.b.g0.j;
import kotlin.reflect.y.internal.j0.l.n1;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: KPropertyImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\b*\u00020\nH\u0002\"\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000b"}, d2 = {"boundReceiver", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "getBoundReceiver", "(Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;)Ljava/lang/Object;", "computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/calls/Caller;", "isGetter", HttpUrl.FRAGMENT_ENCODE_SET, "isJvmFieldPropertyInCompanionObject", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class u {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x0048  */
    public static final Caller<?> b(KPropertyImpl.a<?, ?> aVar, boolean z) {
        JvmFunctionSignature.e eVarC;
        Method methodC;
        Caller aVar2;
        a.c cVarC;
        Caller cVar;
        Method methodF;
        if (KDeclarationContainerImpl.f23095f.a().b(aVar.n().getN())) {
            return ThrowingCaller.a;
        }
        JvmPropertySignature jvmPropertySignatureF = RuntimeTypeMapper.a.f(aVar.n().F());
        if (jvmPropertySignatureF instanceof JvmPropertySignature.c) {
            JvmPropertySignature.c cVar2 = (JvmPropertySignature.c) jvmPropertySignatureF;
            a.d dVarF = cVar2.getF23036c();
            if (z) {
                if (dVarF.G()) {
                    cVarC = dVarF.B();
                } else {
                    cVarC = null;
                }
            } else if (dVarF.H()) {
                cVarC = dVarF.C();
            } else {
                cVarC = null;
            }
            Method methodY = cVarC != null ? aVar.n().getF23147k().y(cVar2.getF23037d().getString(cVarC.x()), cVar2.getF23037d().getString(cVarC.w())) : null;
            if (methodY != null) {
                if (!Modifier.isStatic(methodY.getModifiers())) {
                    cVar = aVar.E() ? new CallerImpl.h.a(methodY, f(aVar)) : new CallerImpl.h.d(methodY);
                } else if (d(aVar)) {
                    cVar = aVar.E() ? new CallerImpl.h.b(methodY) : new CallerImpl.h.e(methodY);
                } else {
                    cVar = aVar.E() ? new CallerImpl.h.c(methodY, f(aVar)) : new CallerImpl.h.f(methodY);
                }
                aVar2 = cVar;
            } else if (f.d(aVar.n().F()) && m.a(aVar.n().F().getVisibility(), t.f25367d)) {
                Class<?> clsH = h.h(aVar.n().F().b());
                if (clsH == null || (methodF = h.f(clsH, aVar.n().F())) == null) {
                    throw new KotlinReflectionInternalError("Underlying property of inline class " + aVar.n() + " should have a field");
                }
                aVar2 = aVar.E() ? new InternalUnderlyingValOfInlineClass.a(methodF, f(aVar)) : new InternalUnderlyingValOfInlineClass.b(methodF);
            } else {
                Field fieldK = aVar.n().K();
                if (fieldK == null) {
                    throw new KotlinReflectionInternalError("No accessors or field is found for property " + aVar.n());
                }
                aVar2 = c(aVar, z, fieldK);
            }
        } else if (jvmPropertySignatureF instanceof JvmPropertySignature.a) {
            aVar2 = c(aVar, z, ((JvmPropertySignature.a) jvmPropertySignatureF).getA());
        } else {
            if (!(jvmPropertySignatureF instanceof JvmPropertySignature.b)) {
                if (!(jvmPropertySignatureF instanceof JvmPropertySignature.d)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (z) {
                    eVarC = ((JvmPropertySignature.d) jvmPropertySignatureF).getA();
                } else {
                    eVarC = ((JvmPropertySignature.d) jvmPropertySignatureF).getF23040b();
                    if (eVarC == null) {
                        throw new KotlinReflectionInternalError("No setter found for property " + aVar.n());
                    }
                }
                Method methodY2 = aVar.n().getF23147k().y(eVarC.c(), eVarC.b());
                if (methodY2 != null) {
                    Modifier.isStatic(methodY2.getModifiers());
                    return aVar.E() ? new CallerImpl.h.a(methodY2, f(aVar)) : new CallerImpl.h.d(methodY2);
                }
                throw new KotlinReflectionInternalError("No accessor found for property " + aVar.n());
            }
            if (z) {
                methodC = ((JvmPropertySignature.b) jvmPropertySignatureF).getA();
            } else {
                JvmPropertySignature.b bVar = (JvmPropertySignature.b) jvmPropertySignatureF;
                methodC = bVar.getF23034b();
                if (methodC == null) {
                    throw new KotlinReflectionInternalError("No source found for setter of Java method property: " + bVar.getA());
                }
            }
            aVar2 = aVar.E() ? new CallerImpl.h.a(methodC, f(aVar)) : new CallerImpl.h.d(methodC);
        }
        return h.c(aVar2, aVar.F(), false, 2, null);
    }

    private static final CallerImpl<Field> c(KPropertyImpl.a<?, ?> aVar, boolean z, Field field) {
        CallerImpl<Field> aVar2;
        if (g(aVar.n().F()) || !Modifier.isStatic(field.getModifiers())) {
            if (!z) {
                aVar2 = aVar.E() ? new CallerImpl.g.a(field, e(aVar), f(aVar)) : new CallerImpl.g.c(field, e(aVar));
            } else {
                if (!aVar.E()) {
                    return new CallerImpl.f.c(field);
                }
                aVar2 = new CallerImpl.f.a(field, f(aVar));
            }
        } else if (d(aVar)) {
            if (z) {
                return aVar.E() ? new CallerImpl.f.b(field) : new CallerImpl.f.d(field);
            }
            aVar2 = aVar.E() ? new CallerImpl.g.b(field, e(aVar)) : new CallerImpl.g.d(field, e(aVar));
        } else {
            if (z) {
                return new CallerImpl.f.e(field);
            }
            aVar2 = new CallerImpl.g.e(field, e(aVar));
        }
        return aVar2;
    }

    private static final boolean d(KPropertyImpl.a<?, ?> aVar) {
        return aVar.n().F().getAnnotations().R0(g0.j());
    }

    private static final boolean e(KPropertyImpl.a<?, ?> aVar) {
        return !n1.l(aVar.n().F().getType());
    }

    public static final Object f(KPropertyImpl.a<?, ?> aVar) {
        m.f(aVar, "<this>");
        return aVar.n().G();
    }

    private static final boolean g(t0 t0Var) {
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = t0Var.b();
        m.e(mVarB, "containingDeclaration");
        if (!d.x(mVarB)) {
            return false;
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB2 = mVarB.b();
        return !(d.C(mVarB2) || d.t(mVarB2)) || ((t0Var instanceof j) && i.f(((j) t0Var).E()));
    }
}
