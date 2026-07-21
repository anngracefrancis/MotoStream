package kotlin.p002reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.l.g1;

/* JADX INFO: compiled from: typeParameterUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class r0 {
    private final i a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<g1> f25311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r0 f25312c;

    /* JADX WARN: Multi-variable type inference failed */
    public r0(i iVar, List<? extends g1> list, r0 r0Var) {
        m.f(iVar, "classifierDescriptor");
        m.f(list, "arguments");
        this.a = iVar;
        this.f25311b = list;
        this.f25312c = r0Var;
    }

    public final List<g1> a() {
        return this.f25311b;
    }

    public final i b() {
        return this.a;
    }

    public final r0 c() {
        return this.f25312c;
    }
}
