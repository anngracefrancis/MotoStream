package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.y.internal.j0.j.b.r;

/* JADX INFO: compiled from: RuntimeErrorReporter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f25319b = new j();

    private j() {
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.r
    public void a(b bVar) {
        m.f(bVar, "descriptor");
        throw new IllegalStateException("Cannot infer visibility for " + bVar);
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.r
    public void b(e eVar, List<String> list) {
        m.f(eVar, "descriptor");
        m.f(list, "unresolvedSuperClasses");
        throw new IllegalStateException("Incomplete hierarchy for class " + eVar.getName() + ", unresolved classes " + list);
    }
}
