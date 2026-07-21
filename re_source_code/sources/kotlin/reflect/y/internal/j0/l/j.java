package kotlin.reflect.y.internal.j0.l;

import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.i;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: AnnotationsTypeAttribute.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends y0<j> {
    private final g a;

    public j(g gVar) {
        m.f(gVar, "annotations");
        this.a = gVar;
    }

    @Override // kotlin.reflect.y.internal.j0.l.y0
    public KClass<? extends j> b() {
        return g0.b(j.class);
    }

    @Override // kotlin.reflect.y.internal.j0.l.y0
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public j a(j jVar) {
        return jVar == null ? this : new j(i.a(this.a, jVar.a));
    }

    public final g e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return m.a(((j) obj).a, this.a);
        }
        return false;
    }

    @Override // kotlin.reflect.y.internal.j0.l.y0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public j c(j jVar) {
        if (m.a(jVar, this)) {
            return this;
        }
        return null;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
