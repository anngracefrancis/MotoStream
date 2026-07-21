package kotlin.reflect.y.internal.j0.l;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.t1.g;

/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h0 extends s1 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final n f24744g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Function0<e0> f24745h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final i<e0> f24746i;

    /* JADX INFO: compiled from: SpecialTypes.kt */
    static final class a extends Lambda implements Function0<e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f24747f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ h0 f24748g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(g gVar, h0 h0Var) {
            super(0);
            this.f24747f = gVar;
            this.f24748g = h0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke() {
            return this.f24747f.a((kotlin.reflect.y.internal.j0.l.w1.i) this.f24748g.f24745h.invoke());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h0(n nVar, Function0<? extends e0> function0) {
        m.f(nVar, "storageManager");
        m.f(function0, "computation");
        this.f24744g = nVar;
        this.f24745h = function0;
        this.f24746i = nVar.d(function0);
    }

    @Override // kotlin.reflect.y.internal.j0.l.s1
    protected e0 S0() {
        return this.f24746i.invoke();
    }

    @Override // kotlin.reflect.y.internal.j0.l.s1
    public boolean T0() {
        return this.f24746i.a();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    /* JADX INFO: renamed from: V0, reason: merged with bridge method [inline-methods] */
    public h0 Y0(g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        return new h0(this.f24744g, new a(gVar, this));
    }
}
