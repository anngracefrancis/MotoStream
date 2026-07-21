package com.airbnb.lottie.q.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: PathKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends f<PointF> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final PointF f8659g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f8660h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private h f8661i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private PathMeasure f8662j;

    public i(List<? extends com.airbnb.lottie.w.a<PointF>> list) {
        super(list);
        this.f8659g = new PointF();
        this.f8660h = new float[2];
    }

    /* JADX WARN: Multi-variable type inference failed */
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
        h hVar = (h) aVar;
        Path pathE = hVar.e();
        if (pathE == null) {
            return aVar.f8862b;
        }
        com.airbnb.lottie.w.c<A> cVar = this.f8653e;
        if (cVar != 0 && (pointF = (PointF) cVar.b(hVar.f8865e, hVar.f8866f.floatValue(), hVar.f8862b, hVar.f8863c, e(), f2, f())) != null) {
            return pointF;
        }
        if (this.f8661i != hVar) {
            this.f8662j = new PathMeasure(pathE, false);
            this.f8661i = hVar;
        }
        PathMeasure pathMeasure = this.f8662j;
        pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.f8660h, null);
        PointF pointF2 = this.f8659g;
        float[] fArr = this.f8660h;
        pointF2.set(fArr[0], fArr[1]);
        return this.f8659g;
    }
}
