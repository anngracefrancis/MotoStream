package kotlin.reflect.y.internal.j0.m;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface f {

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class a {
        public static String a(f fVar, y yVar) {
            m.f(yVar, "functionDescriptor");
            if (fVar.b(yVar)) {
                return null;
            }
            return fVar.getDescription();
        }
    }

    String a(y yVar);

    boolean b(y yVar);

    String getDescription();
}
