package kotlin.reflect.y.internal.j0.l;

import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.l.t1.n;
import kotlin.reflect.y.internal.j0.l.u1.k;

/* JADX INFO: compiled from: StubTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends m0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f24700g = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final n f24701h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f24702i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final h f24703j;

    /* JADX INFO: compiled from: StubTypes.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public e(n nVar, boolean z) {
        m.f(nVar, "originalTypeVariable");
        this.f24701h = nVar;
        this.f24702i = z;
        this.f24703j = k.b(kotlin.reflect.y.internal.j0.l.u1.g.STUB_TYPE_SCOPE, nVar.toString());
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public List<g1> M0() {
        return u.j();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public a1 N0() {
        return a1.f24676g.h();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public boolean P0() {
        return this.f24702i;
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* JADX INFO: renamed from: V0 */
    public m0 S0(boolean z) {
        return z == P0() ? this : Y0(z);
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* JADX INFO: renamed from: W0 */
    public m0 U0(a1 a1Var) {
        m.f(a1Var, "newAttributes");
        return this;
    }

    public final n X0() {
        return this.f24701h;
    }

    public abstract e Y0(boolean z);

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* JADX INFO: renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public e Y0(kotlin.reflect.y.internal.j0.l.t1.g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public h q() {
        return this.f24703j;
    }
}
