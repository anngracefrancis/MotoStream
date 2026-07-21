package kotlin.reflect.y.internal.j0.i.w.o;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: ContextReceiver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends a implements f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f24440c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, e0 e0Var, f fVar) {
        super(e0Var, fVar);
        m.f(aVar, "declarationDescriptor");
        m.f(e0Var, "receiverType");
        this.f24440c = aVar;
    }

    public a c() {
        return this.f24440c;
    }

    public String toString() {
        return "Cxt { " + c() + " }";
    }
}
