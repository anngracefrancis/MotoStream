package kotlin.p002reflect.jvm.internal.impl.descriptors.q1;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.l1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m1;

/* JADX INFO: compiled from: JavaVisibilities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends m1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f25309c = new b();

    private b() {
        super("protected_and_package", true);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m1
    public Integer a(m1 m1Var) {
        m.f(m1Var, "visibility");
        if (m.a(this, m1Var)) {
            return 0;
        }
        if (m1Var == l1.b.f25154c) {
            return null;
        }
        return Integer.valueOf(l1.a.b(m1Var) ? 1 : -1);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m1
    public String b() {
        return "protected/*protected and package*/";
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m1
    public m1 d() {
        return l1.g.f25159c;
    }
}
