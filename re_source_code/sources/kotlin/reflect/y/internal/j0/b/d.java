package kotlin.reflect.y.internal.j0.b;

import java.util.Set;
import kotlin.collections.c0;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.i.t.a;

/* JADX INFO: compiled from: CompanionObjectMappingUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final boolean a(c cVar, e eVar) {
        m.f(cVar, "<this>");
        m.f(eVar, "classDescriptor");
        if (kotlin.reflect.y.internal.j0.i.d.x(eVar)) {
            Set<b> setB = cVar.b();
            b bVarG = a.g(eVar);
            if (c0.K(setB, bVarG != null ? bVarG.g() : null)) {
                return true;
            }
        }
        return false;
    }
}
