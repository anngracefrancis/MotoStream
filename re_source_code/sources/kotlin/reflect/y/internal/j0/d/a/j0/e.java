package kotlin.reflect.y.internal.j0.d.a.j0;

import java.util.Map;
import kotlin.collections.p0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.reflect.KProperty;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.d.a.l0.g;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.r.v;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.s;

/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f23420g = {g0.h(new y(g0.b(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final i f23421h;

    /* JADX INFO: compiled from: JavaAnnotationMapper.kt */
    static final class a extends Lambda implements Function0<Map<f, ? extends v>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f23422f = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Map<f, v> invoke() {
            return p0.f(s.a(c.a.b(), new v("Deprecated in Java")));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(kotlin.reflect.y.internal.j0.d.a.n0.a aVar, g gVar) {
        super(gVar, aVar, k.a.y);
        m.f(gVar, "c");
        this.f23421h = gVar.e().d(a.f23422f);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.j0.b, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c
    public Map<f, kotlin.reflect.y.internal.j0.i.r.g<?>> a() {
        return (Map) kotlin.reflect.y.internal.j0.k.m.a(this.f23421h, this, f23420g[0]);
    }
}
