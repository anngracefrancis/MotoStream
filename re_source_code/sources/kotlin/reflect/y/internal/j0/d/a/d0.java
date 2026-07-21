package kotlin.reflect.y.internal.j0.d.a;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.e;
import kotlin.reflect.y.internal.j0.k.f;
import kotlin.reflect.y.internal.j0.k.h;

/* JADX INFO: compiled from: JavaNullabilityAnnotationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d0<T> implements c0<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<c, T> f23358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f23359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h<c, T> f23360d;

    /* JADX INFO: compiled from: JavaNullabilityAnnotationSettings.kt */
    static final class a extends Lambda implements Function1<c, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d0<T> f23361f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(d0<T> d0Var) {
            super(1);
            this.f23361f = d0Var;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final T invoke(c cVar) {
            m.e(cVar, "it");
            return (T) e.a(cVar, this.f23361f.b());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d0(Map<c, ? extends T> map) {
        m.f(map, "states");
        this.f23358b = map;
        f fVar = new f("Java nullability annotation states");
        this.f23359c = fVar;
        h<c, T> hVarI = fVar.i(new a(this));
        m.e(hVarI, "storageManager.createMem…cificFqname(states)\n    }");
        this.f23360d = hVarI;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.c0
    public T a(c cVar) {
        m.f(cVar, "fqName");
        return this.f23360d.invoke(cVar);
    }

    public final Map<c, T> b() {
        return this.f23358b;
    }
}
