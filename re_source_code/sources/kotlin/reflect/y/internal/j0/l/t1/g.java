package kotlin.reflect.y.internal.j0.l.t1;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.i;

/* JADX INFO: compiled from: KotlinTypeRefiner.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g extends i {

    /* JADX INFO: compiled from: KotlinTypeRefiner.kt */
    public static final class a extends g {
        public static final a a = new a();

        private a() {
        }

        @Override // kotlin.reflect.y.internal.j0.l.t1.g
        public e b(b bVar) {
            m.f(bVar, "classId");
            return null;
        }

        @Override // kotlin.reflect.y.internal.j0.l.t1.g
        public <S extends h> S c(e eVar, Function0<? extends S> function0) {
            m.f(eVar, "classDescriptor");
            m.f(function0, "compute");
            return function0.invoke();
        }

        @Override // kotlin.reflect.y.internal.j0.l.t1.g
        public boolean d(g0 g0Var) {
            m.f(g0Var, "moduleDescriptor");
            return false;
        }

        @Override // kotlin.reflect.y.internal.j0.l.t1.g
        public boolean e(e1 e1Var) {
            m.f(e1Var, "typeConstructor");
            return false;
        }

        @Override // kotlin.reflect.y.internal.j0.l.t1.g
        public Collection<e0> g(e eVar) {
            m.f(eVar, "classDescriptor");
            Collection<e0> collectionA = eVar.h().a();
            m.e(collectionA, "classDescriptor.typeConstructor.supertypes");
            return collectionA;
        }

        @Override // kotlin.reflect.y.internal.j0.l.i
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public e0 a(kotlin.reflect.y.internal.j0.l.w1.i iVar) {
            m.f(iVar, "type");
            return (e0) iVar;
        }

        @Override // kotlin.reflect.y.internal.j0.l.t1.g
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public e f(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
            m.f(mVar, "descriptor");
            return null;
        }
    }

    public abstract e b(b bVar);

    public abstract <S extends h> S c(e eVar, Function0<? extends S> function0);

    public abstract boolean d(g0 g0Var);

    public abstract boolean e(e1 e1Var);

    public abstract kotlin.p002reflect.jvm.internal.impl.descriptors.h f(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar);

    public abstract Collection<e0> g(e eVar);

    /* JADX INFO: renamed from: h */
    public abstract e0 a(kotlin.reflect.y.internal.j0.l.w1.i iVar);
}
