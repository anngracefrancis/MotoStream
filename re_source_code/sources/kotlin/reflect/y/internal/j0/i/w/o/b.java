package kotlin.reflect.y.internal.j0.i.w.o;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: ContextClassReceiver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends a implements f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f24439c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(e eVar, e0 e0Var, f fVar) {
        super(e0Var, fVar);
        m.f(eVar, "classDescriptor");
        m.f(e0Var, "receiverType");
        this.f24439c = eVar;
    }

    public String toString() {
        return getType() + ": Ctx { " + this.f24439c + " }";
    }
}
