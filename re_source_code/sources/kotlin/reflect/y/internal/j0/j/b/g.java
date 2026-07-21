package kotlin.reflect.y.internal.j0.j.b;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.e.z.a;
import kotlin.reflect.y.internal.j0.e.z.c;

/* JADX INFO: compiled from: ClassData.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    private final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.e.c f24490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f24491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final z0 f24492d;

    public g(c cVar, kotlin.reflect.y.internal.j0.e.c cVar2, a aVar, z0 z0Var) {
        m.f(cVar, "nameResolver");
        m.f(cVar2, "classProto");
        m.f(aVar, "metadataVersion");
        m.f(z0Var, "sourceElement");
        this.a = cVar;
        this.f24490b = cVar2;
        this.f24491c = aVar;
        this.f24492d = z0Var;
    }

    public final c a() {
        return this.a;
    }

    public final kotlin.reflect.y.internal.j0.e.c b() {
        return this.f24490b;
    }

    public final a c() {
        return this.f24491c;
    }

    public final z0 d() {
        return this.f24492d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return m.a(this.a, gVar.a) && m.a(this.f24490b, gVar.f24490b) && m.a(this.f24491c, gVar.f24491c) && m.a(this.f24492d, gVar.f24492d);
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.f24490b.hashCode()) * 31) + this.f24491c.hashCode()) * 31) + this.f24492d.hashCode();
    }

    public String toString() {
        return "ClassData(nameResolver=" + this.a + ", classProto=" + this.f24490b + ", metadataVersion=" + this.f24491c + ", sourceElement=" + this.f24492d + ')';
    }
}
