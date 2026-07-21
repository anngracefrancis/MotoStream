package kotlin.reflect.y.internal.j0.m;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public final g a(y yVar) {
        m.f(yVar, "functionDescriptor");
        for (h hVar : b()) {
            if (hVar.b(yVar)) {
                return hVar.a(yVar);
            }
        }
        return g.a.f24894b;
    }

    public abstract List<h> b();
}
