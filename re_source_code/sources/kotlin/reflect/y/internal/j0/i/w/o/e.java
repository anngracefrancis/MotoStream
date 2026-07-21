package kotlin.reflect.y.internal.j0.i.w.o;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.l.m0;

/* JADX INFO: compiled from: ImplicitClassReceiver.kt */
/* JADX INFO: loaded from: classes3.dex */
public class e implements f, h {
    private final kotlin.p002reflect.jvm.internal.impl.descriptors.e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f24442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.p002reflect.jvm.internal.impl.descriptors.e f24443c;

    public e(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar, e eVar2) {
        m.f(eVar, "classDescriptor");
        this.a = eVar;
        this.f24442b = eVar2 == null ? this : eVar2;
        this.f24443c = eVar;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.o.f
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public m0 getType() {
        m0 m0VarS = this.a.s();
        m.e(m0VarS, "classDescriptor.defaultType");
        return m0VarS;
    }

    public boolean equals(Object obj) {
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar = this.a;
        e eVar2 = obj instanceof e ? (e) obj : null;
        return m.a(eVar, eVar2 != null ? eVar2.a : null);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.o.h
    public final kotlin.p002reflect.jvm.internal.impl.descriptors.e r() {
        return this.a;
    }

    public String toString() {
        return "Class{" + getType() + '}';
    }
}
