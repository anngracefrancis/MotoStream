package com.airbnb.lottie.q.b;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: PointKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends f<PointF> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final PointF f8663g;

    public j(List<com.airbnb.lottie.w.a<PointF>> list) {
        super(list);
        this.f8663g = new PointF();
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
    public PointF i(com.airbnb.lottie.w.a<PointF> aVar, float f2) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = aVar.f8862b;
        if (pointF3 == null || (pointF = aVar.f8863c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF4 = pointF3;
        PointF pointF5 = pointF;
        com.airbnb.lottie.w.c<A> cVar = this.f8653e;
        if (cVar != 0 && (pointF2 = (PointF) cVar.b(aVar.f8865e, aVar.f8866f.floatValue(), pointF4, pointF5, f2, e(), f())) != null) {
            return pointF2;
        }
        PointF pointF6 = this.f8663g;
        float f3 = pointF4.x;
        float f4 = f3 + ((pointF5.x - f3) * f2);
        float f5 = pointF4.y;
        pointF6.set(f4, f5 + (f2 * (pointF5.y - f5)));
        return this.f8663g;
    }
}
