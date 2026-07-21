package kotlin.reflect.y.internal.j0.l;

import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.y.internal.j0.l.t1.g;

/* JADX INFO: compiled from: StarProjectionImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s0 extends h1 {
    private final e1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f24784b;

    /* JADX INFO: compiled from: StarProjectionImpl.kt */
    static final class a extends Lambda implements Function0<e0> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke() {
            return t0.b(s0.this.a);
        }
    }

    public s0(e1 e1Var) {
        m.f(e1Var, "typeParameter");
        this.a = e1Var;
        this.f24784b = i.a(LazyThreadSafetyMode.PUBLICATION, new a());
    }

    private final e0 e() {
        return (e0) this.f24784b.getValue();
    }

    @Override // kotlin.reflect.y.internal.j0.l.g1
    public r1 a() {
        return r1.OUT_VARIANCE;
    }

    @Override // kotlin.reflect.y.internal.j0.l.g1
    public g1 b(g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.y.internal.j0.l.g1
    public boolean c() {
        return true;
    }

    @Override // kotlin.reflect.y.internal.j0.l.g1
    public e0 getType() {
        return e();
    }
}
