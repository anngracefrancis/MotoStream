package kotlin.reflect.y.internal.j0.d.a.l0;

import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.y.internal.j0.d.a.n0.z;
import kotlin.reflect.y.internal.j0.d.a.x;

/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: kotlin.f0.y.e.j0.d.a.l0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: context.kt */
    static final class C0330a extends Lambda implements Function0<x> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f23444f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ g f23445g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0330a(g gVar, g gVar2) {
            super(0);
            this.f23444f = gVar;
            this.f23445g = gVar2;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final x invoke() {
            return a.g(this.f23444f, this.f23445g.getAnnotations());
        }
    }

    /* JADX INFO: compiled from: context.kt */
    static final class b extends Lambda implements Function0<x> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f23446f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g f23447g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(g gVar, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar2) {
            super(0);
            this.f23446f = gVar;
            this.f23447g = gVar2;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final x invoke() {
            return a.g(this.f23446f, this.f23447g);
        }
    }

    private static final g a(g gVar, m mVar, z zVar, int i2, Lazy<x> lazy) {
        return new g(gVar.a(), zVar != null ? new h(gVar, mVar, zVar, i2) : gVar.f(), lazy);
    }

    public static final g b(g gVar, k kVar) {
        kotlin.jvm.internal.m.f(gVar, "<this>");
        kotlin.jvm.internal.m.f(kVar, "typeParameterResolver");
        return new g(gVar.a(), kVar, gVar.c());
    }

    public static final g c(g gVar, g gVar2, z zVar, int i2) {
        kotlin.jvm.internal.m.f(gVar, "<this>");
        kotlin.jvm.internal.m.f(gVar2, "containingDeclaration");
        return a(gVar, gVar2, zVar, i2, i.a(LazyThreadSafetyMode.NONE, new C0330a(gVar, gVar2)));
    }

    public static /* synthetic */ g d(g gVar, g gVar2, z zVar, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            zVar = null;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return c(gVar, gVar2, zVar, i2);
    }

    public static final g e(g gVar, m mVar, z zVar, int i2) {
        kotlin.jvm.internal.m.f(gVar, "<this>");
        kotlin.jvm.internal.m.f(mVar, "containingDeclaration");
        kotlin.jvm.internal.m.f(zVar, "typeParameterOwner");
        return a(gVar, mVar, zVar, i2, gVar.c());
    }

    public static /* synthetic */ g f(g gVar, m mVar, z zVar, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return e(gVar, mVar, zVar, i2);
    }

    public static final x g(g gVar, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar2) {
        kotlin.jvm.internal.m.f(gVar, "<this>");
        kotlin.jvm.internal.m.f(gVar2, "additionalAnnotations");
        return gVar.a().a().c(gVar.b(), gVar2);
    }

    public static final g h(g gVar, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar2) {
        kotlin.jvm.internal.m.f(gVar, "<this>");
        kotlin.jvm.internal.m.f(gVar2, "additionalAnnotations");
        return gVar2.isEmpty() ? gVar : new g(gVar.a(), gVar.f(), i.a(LazyThreadSafetyMode.NONE, new b(gVar, gVar2)));
    }

    public static final g i(g gVar, kotlin.reflect.y.internal.j0.d.a.l0.b bVar) {
        kotlin.jvm.internal.m.f(gVar, "<this>");
        kotlin.jvm.internal.m.f(bVar, "components");
        return new g(bVar, gVar.f(), gVar.c());
    }
}
