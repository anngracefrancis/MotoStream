package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class w implements v {
    private final List<x> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<x> f25297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<x> f25298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set<x> f25299d;

    public w(List<x> list, Set<x> set, List<x> list2, Set<x> set2) {
        m.f(list, "allDependencies");
        m.f(set, "modulesWhoseInternalsAreVisible");
        m.f(list2, "directExpectedByDependencies");
        m.f(set2, "allExpectedByDependencies");
        this.a = list;
        this.f25297b = set;
        this.f25298c = list2;
        this.f25299d = set2;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.v
    public List<x> a() {
        return this.a;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.v
    public Set<x> b() {
        return this.f25297b;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.v
    public List<x> c() {
        return this.f25298c;
    }
}
