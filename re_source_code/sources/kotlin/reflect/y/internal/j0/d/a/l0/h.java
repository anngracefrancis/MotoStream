package kotlin.reflect.y.internal.j0.d.a.l0;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.y.internal.j0.d.a.n0.y;
import kotlin.reflect.y.internal.j0.d.a.n0.z;

/* JADX INFO: compiled from: resolvers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements k {
    private final g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m f23471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f23472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<y, Integer> f23473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.h<y, kotlin.reflect.y.internal.j0.d.a.l0.l.m> f23474e;

    /* JADX INFO: compiled from: resolvers.kt */
    static final class a extends Lambda implements Function1<y, kotlin.reflect.y.internal.j0.d.a.l0.l.m> {
        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.y.internal.j0.d.a.l0.l.m invoke(y yVar) {
            kotlin.jvm.internal.m.f(yVar, "typeParameter");
            Integer num = (Integer) h.this.f23473d.get(yVar);
            if (num == null) {
                return null;
            }
            h hVar = h.this;
            return new kotlin.reflect.y.internal.j0.d.a.l0.l.m(kotlin.reflect.y.internal.j0.d.a.l0.a.h(kotlin.reflect.y.internal.j0.d.a.l0.a.b(hVar.a, hVar), hVar.f23471b.getAnnotations()), yVar, hVar.f23472c + num.intValue(), hVar.f23471b);
        }
    }

    public h(g gVar, m mVar, z zVar, int i2) {
        kotlin.jvm.internal.m.f(gVar, "c");
        kotlin.jvm.internal.m.f(mVar, "containingDeclaration");
        kotlin.jvm.internal.m.f(zVar, "typeParameterOwner");
        this.a = gVar;
        this.f23471b = mVar;
        this.f23472c = i2;
        this.f23473d = kotlin.p002reflect.jvm.internal.impl.utils.a.d(zVar.getTypeParameters());
        this.f23474e = gVar.e().i(new a());
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.k
    public e1 a(y yVar) {
        kotlin.jvm.internal.m.f(yVar, "javaTypeParameter");
        kotlin.reflect.y.internal.j0.d.a.l0.l.m mVarInvoke = this.f23474e.invoke(yVar);
        return mVarInvoke != null ? mVarInvoke : this.a.f().a(yVar);
    }
}
