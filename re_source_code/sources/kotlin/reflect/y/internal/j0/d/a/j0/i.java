package kotlin.reflect.y.internal.j0.d.a.j0;

import java.util.Map;
import kotlin.collections.p0;
import kotlin.collections.q0;
import kotlin.collections.t;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.y;
import kotlin.reflect.KProperty;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.d.a.n0.b;
import kotlin.reflect.y.internal.j0.d.a.n0.e;
import kotlin.reflect.y.internal.j0.d.a.n0.m;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.r.g;
import kotlin.s;

/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f23426g = {g0.h(new y(g0.b(i.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.i f23427h;

    /* JADX INFO: compiled from: JavaAnnotationMapper.kt */
    static final class a extends Lambda implements Function0<Map<f, ? extends g<? extends Object>>> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Map<f, g<Object>> invoke() {
            g<?> gVarC;
            b bVarB = i.this.b();
            if (bVarB instanceof e) {
                gVarC = d.a.c(((e) i.this.b()).e());
            } else {
                gVarC = bVarB instanceof m ? d.a.c(t.e(i.this.b())) : null;
            }
            Map<f, g<Object>> mapF = gVarC != null ? p0.f(s.a(c.a.d(), gVarC)) : null;
            return mapF == null ? q0.i() : mapF;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(kotlin.reflect.y.internal.j0.d.a.n0.a aVar, kotlin.reflect.y.internal.j0.d.a.l0.g gVar) {
        super(gVar, aVar, k.a.H);
        kotlin.jvm.internal.m.f(aVar, "annotation");
        kotlin.jvm.internal.m.f(gVar, "c");
        this.f23427h = gVar.e().d(new a());
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.j0.b, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c
    public Map<f, g<Object>> a() {
        return (Map) kotlin.reflect.y.internal.j0.k.m.a(this.f23427h, this, f23426g[0]);
    }
}
