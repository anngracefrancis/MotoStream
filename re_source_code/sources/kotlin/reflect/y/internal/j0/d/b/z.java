package kotlin.reflect.y.internal.j0.d.b;

import java.util.Collection;
import kotlin.collections.c0;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: methodSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class z implements y<l> {
    public static final z a = new z();

    private z() {
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.y
    public String b(e eVar) {
        return y.a.a(this, eVar);
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.y
    public e0 c(Collection<? extends e0> collection) {
        m.f(collection, "types");
        throw new AssertionError("There should be no intersection type in existing descriptors, but found: " + c0.e0(collection, null, null, null, 0, null, null, 63, null));
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.y
    public String d(e eVar) {
        m.f(eVar, "classDescriptor");
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.y
    public e0 e(e0 e0Var) {
        return y.a.b(this, e0Var);
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.y
    public void f(e0 e0Var, e eVar) {
        m.f(e0Var, "kotlinType");
        m.f(eVar, "descriptor");
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.y
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public l a(e eVar) {
        m.f(eVar, "classDescriptor");
        return null;
    }
}
