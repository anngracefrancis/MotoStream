package kotlin.p002reflect.jvm.internal.impl.descriptors.q1;

import cm.aptoide.pt.downloadmanager.Constants;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.l1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m1;

/* JADX INFO: compiled from: JavaVisibilities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends m1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f25308c = new a();

    private a() {
        super(Constants.PACKAGE, false);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m1
    public Integer a(m1 m1Var) {
        m.f(m1Var, "visibility");
        if (this == m1Var) {
            return 0;
        }
        return l1.a.b(m1Var) ? 1 : -1;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m1
    public String b() {
        return "public/*package*/";
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m1
    public m1 d() {
        return l1.g.f25159c;
    }
}
