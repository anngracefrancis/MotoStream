package com.airbnb.lottie.q.b;

import java.util.List;

/* JADX INFO: compiled from: ScaleKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends f<com.airbnb.lottie.w.d> {
    public k(List<com.airbnb.lottie.w.a<com.airbnb.lottie.w.d>> list) {
        super(list);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.airbnb.lottie.q.b.a
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.w.d i(com.airbnb.lottie.w.a<com.airbnb.lottie.w.d> aVar, float f2) {
        com.airbnb.lottie.w.d dVar;
        com.airbnb.lottie.w.d dVar2;
        com.airbnb.lottie.w.d dVar3 = aVar.f8862b;
        if (dVar3 == null || (dVar = aVar.f8863c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.airbnb.lottie.w.d dVar4 = dVar3;
        com.airbnb.lottie.w.d dVar5 = dVar;
        com.airbnb.lottie.w.c<A> cVar = this.f8653e;
        return (cVar == 0 || (dVar2 = (com.airbnb.lottie.w.d) cVar.b(aVar.f8865e, aVar.f8866f.floatValue(), dVar4, dVar5, f2, e(), f())) == null) ? new com.airbnb.lottie.w.d(com.airbnb.lottie.v.e.j(dVar4.a(), dVar5.a(), f2), com.airbnb.lottie.v.e.j(dVar4.b(), dVar5.b(), f2)) : dVar2;
    }
}
