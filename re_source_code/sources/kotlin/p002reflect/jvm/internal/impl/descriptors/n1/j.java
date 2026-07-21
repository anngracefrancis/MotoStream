package kotlin.p002reflect.jvm.internal.impl.descriptors.n1;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.r.g;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.m0;

/* JADX INFO: compiled from: BuiltInAnnotationDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements c {
    private final h a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f25182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<f, g<?>> f25183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f25184d;

    /* JADX INFO: compiled from: BuiltInAnnotationDescriptor.kt */
    static final class a extends Lambda implements Function0<m0> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final m0 invoke() {
            return j.this.a.o(j.this.d()).s();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(h hVar, c cVar, Map<f, ? extends g<?>> map) {
        m.f(hVar, "builtIns");
        m.f(cVar, "fqName");
        m.f(map, "allValueArguments");
        this.a = hVar;
        this.f25182b = cVar;
        this.f25183c = map;
        this.f25184d = i.a(LazyThreadSafetyMode.PUBLICATION, new a());
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c
    public Map<f, g<?>> a() {
        return this.f25183c;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c
    public c d() {
        return this.f25182b;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c
    public e0 getType() {
        Object value = this.f25184d.getValue();
        m.e(value, "<get-type>(...)");
        return (e0) value;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c
    public z0 t() {
        z0 z0Var = z0.a;
        m.e(z0Var, "NO_SOURCE");
        return z0Var;
    }
}
