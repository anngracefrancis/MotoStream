package kotlin.reflect.y;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.y.internal.EmptyContainerForLocal;
import kotlin.reflect.y.internal.KFunctionImpl;
import kotlin.reflect.y.internal.j0.e.a0.b.e;
import kotlin.reflect.y.internal.j0.e.a0.b.f;
import kotlin.reflect.y.internal.j0.e.t;
import kotlin.reflect.y.internal.j0.e.z.g;
import kotlin.reflect.y.internal.j0.j.b.w;

/* JADX INFO: compiled from: reflectLambda.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"reflect", "Lkotlin/reflect/KFunction;", "R", "Lkotlin/Function;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class d {

    /* JADX INFO: compiled from: reflectLambda.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* synthetic */ class a extends i implements Function2<w, kotlin.reflect.y.internal.j0.e.i, y0> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f23018h = new a();

        a() {
            super(2);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* JADX INFO: renamed from: getName */
        public final String getM() {
            return "loadFunction";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(w.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;";
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public final y0 invoke(w wVar, kotlin.reflect.y.internal.j0.e.i iVar) {
            m.f(wVar, "p0");
            m.f(iVar, "p1");
            return wVar.j(iVar);
        }
    }

    public static final <R> KFunction<R> a(Function<? extends R> function) {
        m.f(function, "<this>");
        Metadata metadata = (Metadata) function.getClass().getAnnotation(Metadata.class);
        if (metadata == null) {
            return null;
        }
        String[] strArrD1 = metadata.d1();
        if (strArrD1.length == 0) {
            strArrD1 = null;
        }
        if (strArrD1 == null) {
            return null;
        }
        Pair<f, kotlin.reflect.y.internal.j0.e.i> pairJ = kotlin.reflect.y.internal.j0.e.a0.b.i.j(strArrD1, metadata.d2());
        f fVarA = pairJ.a();
        kotlin.reflect.y.internal.j0.e.i iVarB = pairJ.b();
        e eVar = new e(metadata.mv(), (metadata.xi() & 8) != 0);
        Class<?> cls = function.getClass();
        t tVarN0 = iVarB.n0();
        m.e(tVarN0, "proto.typeTable");
        return new KFunctionImpl(EmptyContainerForLocal.f23024i, (y0) kotlin.reflect.y.internal.g0.h(cls, iVarB, fVarA, new g(tVarN0), eVar, a.f23018h));
    }
}
