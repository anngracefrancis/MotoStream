package kotlin.reflect.y.internal.j0.d.b;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.j.b.g;

/* JADX INFO: compiled from: JavaClassDataFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements kotlin.reflect.y.internal.j0.j.b.h {
    private final o a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f23794b;

    public h(o oVar, g gVar) {
        m.f(oVar, "kotlinClassFinder");
        m.f(gVar, "deserializedDescriptorResolver");
        this.a = oVar;
        this.f23794b = gVar;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.h
    public g a(b bVar) {
        m.f(bVar, "classId");
        q qVarB = p.b(this.a, bVar);
        if (qVarB == null) {
            return null;
        }
        m.a(qVarB.e(), bVar);
        return this.f23794b.i(qVarB);
    }
}
