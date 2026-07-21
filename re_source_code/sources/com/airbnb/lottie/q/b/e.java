package com.airbnb.lottie.q.b;

import java.util.List;

/* JADX INFO: compiled from: IntegerKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends f<Integer> {
    public e(List<com.airbnb.lottie.w.a<Integer>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
    public Integer i(com.airbnb.lottie.w.a<Integer> aVar, float f2) {
        Integer num;
        if (aVar.f8862b == null || aVar.f8863c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.airbnb.lottie.w.c<A> cVar = this.f8653e;
        return (cVar == 0 || (num = (Integer) cVar.b(aVar.f8865e, aVar.f8866f.floatValue(), aVar.f8862b, aVar.f8863c, f2, e(), f())) == null) ? Integer.valueOf(com.airbnb.lottie.v.e.k(aVar.f8862b.intValue(), aVar.f8863c.intValue(), f2)) : num;
    }
}
