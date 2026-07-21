package kotlin.p002reflect.jvm.internal.impl.descriptors.n1;

import kotlin.collections.q0;
import kotlin.collections.u;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.i.r.b;
import kotlin.reflect.y.internal.j0.i.r.j;
import kotlin.reflect.y.internal.j0.i.r.v;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.s;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: annotationUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    private static final kotlin.reflect.y.internal.j0.f.f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.reflect.y.internal.j0.f.f f25174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kotlin.reflect.y.internal.j0.f.f f25175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final kotlin.reflect.y.internal.j0.f.f f25176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final kotlin.reflect.y.internal.j0.f.f f25177e;

    /* JADX INFO: compiled from: annotationUtil.kt */
    static final class a extends Lambda implements Function1<g0, e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f25178f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(h hVar) {
            super(1);
            this.f25178f = hVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke(g0 g0Var) {
            m.f(g0Var, "module");
            m0 m0VarL = g0Var.o().l(r1.INVARIANT, this.f25178f.W());
            m.e(m0VarL, "module.builtIns.getArray…ce.INVARIANT, stringType)");
            return m0VarL;
        }
    }

    static {
        kotlin.reflect.y.internal.j0.f.f fVarX = kotlin.reflect.y.internal.j0.f.f.x("message");
        m.e(fVarX, "identifier(\"message\")");
        a = fVarX;
        kotlin.reflect.y.internal.j0.f.f fVarX2 = kotlin.reflect.y.internal.j0.f.f.x("replaceWith");
        m.e(fVarX2, "identifier(\"replaceWith\")");
        f25174b = fVarX2;
        kotlin.reflect.y.internal.j0.f.f fVarX3 = kotlin.reflect.y.internal.j0.f.f.x("level");
        m.e(fVarX3, "identifier(\"level\")");
        f25175c = fVarX3;
        kotlin.reflect.y.internal.j0.f.f fVarX4 = kotlin.reflect.y.internal.j0.f.f.x("expression");
        m.e(fVarX4, "identifier(\"expression\")");
        f25176d = fVarX4;
        kotlin.reflect.y.internal.j0.f.f fVarX5 = kotlin.reflect.y.internal.j0.f.f.x("imports");
        m.e(fVarX5, "identifier(\"imports\")");
        f25177e = fVarX5;
    }

    public static final c a(h hVar, String str, String str2, String str3) {
        m.f(hVar, "<this>");
        m.f(str, "message");
        m.f(str2, "replaceWith");
        m.f(str3, "level");
        j jVar = new j(hVar, k.a.B, q0.l(s.a(f25176d, new v(str2)), s.a(f25177e, new b(u.j(), new a(hVar)))));
        c cVar = k.a.y;
        kotlin.reflect.y.internal.j0.f.f fVar = f25175c;
        kotlin.reflect.y.internal.j0.f.b bVarM = kotlin.reflect.y.internal.j0.f.b.m(k.a.A);
        m.e(bVarM, "topLevel(StandardNames.FqNames.deprecationLevel)");
        kotlin.reflect.y.internal.j0.f.f fVarX = kotlin.reflect.y.internal.j0.f.f.x(str3);
        m.e(fVarX, "identifier(level)");
        return new j(hVar, cVar, q0.l(s.a(a, new v(str)), s.a(f25174b, new kotlin.reflect.y.internal.j0.i.r.a(jVar)), s.a(fVar, new j(bVarM, fVarX))));
    }

    public static /* synthetic */ c b(h hVar, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if ((i2 & 4) != 0) {
            str3 = "WARNING";
        }
        return a(hVar, str, str2, str3);
    }
}
