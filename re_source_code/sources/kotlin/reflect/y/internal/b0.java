package kotlin.reflect.y.internal;

import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.h0;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.v;
import kotlin.jvm.internal.x;
import kotlin.jvm.internal.z;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.y.d;

/* JADX INFO: compiled from: ReflectionFactoryImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class b0 extends h0 {
    private static KDeclarationContainerImpl k(c cVar) {
        KDeclarationContainer owner = cVar.getOwner();
        return owner instanceof KDeclarationContainerImpl ? (KDeclarationContainerImpl) owner : EmptyContainerForLocal.f23024i;
    }

    @Override // kotlin.jvm.internal.h0
    public KFunction a(i iVar) {
        return new KFunctionImpl(k(iVar), iVar.getM(), iVar.getSignature(), iVar.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.h0
    public KClass b(Class cls) {
        return g.a(cls);
    }

    @Override // kotlin.jvm.internal.h0
    public KDeclarationContainer c(Class cls, String str) {
        return new KPackageImpl(cls, str);
    }

    @Override // kotlin.jvm.internal.h0
    public KMutableProperty0 d(p pVar) {
        return new KMutableProperty0Impl(k(pVar), pVar.getM(), pVar.getSignature(), pVar.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.h0
    public KMutableProperty1 e(r rVar) {
        return new KMutableProperty1Impl(k(rVar), rVar.getM(), rVar.getSignature(), rVar.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.h0
    public KProperty0 f(v vVar) {
        return new KProperty0Impl(k(vVar), vVar.getM(), vVar.getSignature(), vVar.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.h0
    public KProperty1 g(x xVar) {
        return new KProperty1Impl(k(xVar), xVar.getM(), xVar.getSignature(), xVar.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.h0
    public KProperty2 h(z zVar) {
        return new KProperty2Impl(k(zVar), zVar.getM(), zVar.getSignature());
    }

    @Override // kotlin.jvm.internal.h0
    public String i(FunctionBase functionBase) {
        KFunctionImpl kFunctionImplC;
        KFunction kFunctionA = d.a(functionBase);
        return (kFunctionA == null || (kFunctionImplC = g0.c(kFunctionA)) == null) ? super.i(functionBase) : ReflectionObjectRenderer.a.e(kFunctionImplC.F());
    }

    @Override // kotlin.jvm.internal.h0
    public String j(Lambda lambda) {
        return i(lambda);
    }
}
