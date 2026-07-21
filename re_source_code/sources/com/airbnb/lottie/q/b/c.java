package com.airbnb.lottie.q.b;

import java.util.List;

/* JADX INFO: compiled from: FloatKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends f<Float> {
    public c(List<com.airbnb.lottie.w.a<Float>> list) {
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
    public Float i(com.airbnb.lottie.w.a<Float> aVar, float f2) {
        Float f3;
        if (aVar.f8862b == null || aVar.f8863c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.airbnb.lottie.w.c<A> cVar = this.f8653e;
        return (cVar == 0 || (f3 = (Float) cVar.b(aVar.f8865e, aVar.f8866f.floatValue(), aVar.f8862b, aVar.f8863c, f2, e(), f())) == null) ? Float.valueOf(com.airbnb.lottie.v.e.j(aVar.f8862b.floatValue(), aVar.f8863c.floatValue(), f2)) : f3;
    }
}
