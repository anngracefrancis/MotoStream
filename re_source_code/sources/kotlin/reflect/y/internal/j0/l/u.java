package kotlin.reflect.y.internal.j0.l;

import cm.aptoide.pt.database.room.RoomNotification;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: DisjointKeysUnionTypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends j1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f24815c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final j1 f24816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final j1 f24817e;

    /* JADX INFO: compiled from: DisjointKeysUnionTypeSubstitution.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final j1 a(j1 j1Var, j1 j1Var2) {
            m.f(j1Var, "first");
            m.f(j1Var2, "second");
            if (j1Var.f()) {
                return j1Var2;
            }
            return j1Var2.f() ? j1Var : new u(j1Var, j1Var2, null);
        }
    }

    private u(j1 j1Var, j1 j1Var2) {
        this.f24816d = j1Var;
        this.f24817e = j1Var2;
    }

    public /* synthetic */ u(j1 j1Var, j1 j1Var2, g gVar) {
        this(j1Var, j1Var2);
    }

    public static final j1 i(j1 j1Var, j1 j1Var2) {
        return f24815c.a(j1Var, j1Var2);
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    public boolean a() {
        return this.f24816d.a() || this.f24817e.a();
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    public boolean b() {
        return this.f24816d.b() || this.f24817e.b();
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    public kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g d(kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar) {
        m.f(gVar, "annotations");
        return this.f24817e.d(this.f24816d.d(gVar));
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    public g1 e(e0 e0Var) {
        m.f(e0Var, RoomNotification.KEY);
        g1 g1VarE = this.f24816d.e(e0Var);
        return g1VarE == null ? this.f24817e.e(e0Var) : g1VarE;
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    public boolean f() {
        return false;
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    public e0 g(e0 e0Var, r1 r1Var) {
        m.f(e0Var, "topLevelType");
        m.f(r1Var, "position");
        return this.f24817e.g(this.f24816d.g(e0Var, r1Var), r1Var);
    }
}
