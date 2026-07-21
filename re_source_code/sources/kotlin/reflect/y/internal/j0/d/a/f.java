package kotlin.reflect.y.internal.j0.d.a;

import kotlin.collections.c0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.y.internal.j0.d.b.v;

/* JADX INFO: compiled from: specialBuiltinMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends h0 {
    public static final f n = new f();

    /* JADX INFO: compiled from: specialBuiltinMembers.kt */
    static final class a extends Lambda implements Function1<kotlin.p002reflect.jvm.internal.impl.descriptors.b, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f23363f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
            m.f(bVar, "it");
            return Boolean.valueOf(f.n.j(bVar));
        }
    }

    /* JADX INFO: compiled from: specialBuiltinMembers.kt */
    static final class b extends Lambda implements Function1<kotlin.p002reflect.jvm.internal.impl.descriptors.b, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f23364f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
            m.f(bVar, "it");
            return Boolean.valueOf((bVar instanceof y) && f.n.j(bVar));
        }
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
        return c0.K(h0.a.e(), v.d(bVar));
    }

    public static final y k(y yVar) {
        m.f(yVar, "functionDescriptor");
        f fVar = n;
        kotlin.reflect.y.internal.j0.f.f name = yVar.getName();
        m.e(name, "functionDescriptor.name");
        if (fVar.l(name)) {
            return (y) kotlin.reflect.y.internal.j0.i.t.a.c(yVar, false, a.f23363f, 1, null);
        }
        return null;
    }

    public static final h0.b m(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
        kotlin.p002reflect.jvm.internal.impl.descriptors.b bVarC;
        String strD;
        m.f(bVar, "<this>");
        h0.a aVar = h0.a;
        if (!aVar.d().contains(bVar.getName()) || (bVarC = kotlin.reflect.y.internal.j0.i.t.a.c(bVar, false, b.f23364f, 1, null)) == null || (strD = v.d(bVarC)) == null) {
            return null;
        }
        return aVar.l(strD);
    }

    public final boolean l(kotlin.reflect.y.internal.j0.f.f fVar) {
        m.f(fVar, "<this>");
        return h0.a.d().contains(fVar);
    }
}
