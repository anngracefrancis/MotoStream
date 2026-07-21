package kotlin.reflect.y.internal.j0.d.a.o0;

import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {
    private final q a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<q> f23664b;

    /* JADX WARN: Multi-variable type inference failed */
    public k() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public k(q qVar, List<q> list) {
        m.f(list, "parametersInfo");
        this.a = qVar;
        this.f23664b = list;
    }

    public final List<q> a() {
        return this.f23664b;
    }

    public final q b() {
        return this.a;
    }

    public /* synthetic */ k(q qVar, List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : qVar, (i2 & 2) != 0 ? u.j() : list);
    }
}
