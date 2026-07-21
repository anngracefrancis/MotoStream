package kotlin.reflect.y.internal.j0.l.u1;

import java.util.Arrays;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.m0;

/* JADX INFO: compiled from: ErrorType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends m0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e1 f24840g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.i.w.h f24841h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final j f24842i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List<g1> f24843j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f24844k;
    private final String[] l;
    private final String m;

    public /* synthetic */ h(e1 e1Var, kotlin.reflect.y.internal.j0.i.w.h hVar, j jVar, List list, boolean z, String[] strArr, int i2, g gVar) {
        this(e1Var, hVar, jVar, (i2 & 8) != 0 ? u.j() : list, (i2 & 16) != 0 ? false : z, strArr);
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public List<g1> M0() {
        return this.f24843j;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public a1 N0() {
        return a1.f24676g.h();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public e1 O0() {
        return this.f24840g;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public boolean P0() {
        return this.f24844k;
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* JADX INFO: renamed from: V0 */
    public m0 S0(boolean z) {
        e1 e1VarO0 = O0();
        kotlin.reflect.y.internal.j0.i.w.h hVarQ = q();
        j jVar = this.f24842i;
        List<g1> listM0 = M0();
        String[] strArr = this.l;
        return new h(e1VarO0, hVarQ, jVar, listM0, z, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* JADX INFO: renamed from: W0 */
    public m0 U0(a1 a1Var) {
        m.f(a1Var, "newAttributes");
        return this;
    }

    public final String X0() {
        return this.m;
    }

    public final j Y0() {
        return this.f24842i;
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* JADX INFO: renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public h Y0(kotlin.reflect.y.internal.j0.l.t1.g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public kotlin.reflect.y.internal.j0.i.w.h q() {
        return this.f24841h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(e1 e1Var, kotlin.reflect.y.internal.j0.i.w.h hVar, j jVar, List<? extends g1> list, boolean z, String... strArr) {
        m.f(e1Var, "constructor");
        m.f(hVar, "memberScope");
        m.f(jVar, "kind");
        m.f(list, "arguments");
        m.f(strArr, "formatParams");
        this.f24840g = e1Var;
        this.f24841h = hVar;
        this.f24842i = jVar;
        this.f24843j = list;
        this.f24844k = z;
        this.l = strArr;
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String strK = jVar.k();
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length);
        String str = String.format(strK, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        m.e(str, "format(format, *args)");
        this.m = str;
    }
}
