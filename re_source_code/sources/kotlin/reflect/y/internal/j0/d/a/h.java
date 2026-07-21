package kotlin.reflect.y.internal.j0.d.a;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.d;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: BuiltinSpecialProperties.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h {
    /* JADX INFO: Access modifiers changed from: private */
    public static final c c(c cVar, String str) {
        c cVarC = cVar.c(f.x(str));
        m.e(cVarC, "child(Name.identifier(name))");
        return cVarC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c d(d dVar, String str) {
        c cVarL = dVar.c(f.x(str)).l();
        m.e(cVarL, "child(Name.identifier(name)).toSafe()");
        return cVarL;
    }
}
