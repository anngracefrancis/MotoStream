package kotlin.reflect.y.internal.j0.l;

import cm.aptoide.pt.database.room.RoomNotification;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;

/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public class q extends j1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j1 f24776c;

    public q(j1 j1Var) {
        m.f(j1Var, "substitution");
        this.f24776c = j1Var;
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    public boolean a() {
        return this.f24776c.a();
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    public g d(g gVar) {
        m.f(gVar, "annotations");
        return this.f24776c.d(gVar);
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    public g1 e(e0 e0Var) {
        m.f(e0Var, RoomNotification.KEY);
        return this.f24776c.e(e0Var);
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    public boolean f() {
        return this.f24776c.f();
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    public e0 g(e0 e0Var, r1 r1Var) {
        m.f(e0Var, "topLevelType");
        m.f(r1Var, "position");
        return this.f24776c.g(e0Var, r1Var);
    }
}
