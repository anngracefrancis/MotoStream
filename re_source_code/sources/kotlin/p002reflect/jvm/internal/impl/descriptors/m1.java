package kotlin.p002reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: Visibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class m1 {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f25164b;

    protected m1(String str, boolean z) {
        m.f(str, "name");
        this.a = str;
        this.f25164b = z;
    }

    public Integer a(m1 m1Var) {
        m.f(m1Var, "visibility");
        return l1.a.a(this, m1Var);
    }

    public String b() {
        return this.a;
    }

    public final boolean c() {
        return this.f25164b;
    }

    public m1 d() {
        return this;
    }

    public final String toString() {
        return b();
    }
}
