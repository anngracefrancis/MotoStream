package kotlin.reflect.y.internal.j0.j.b;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.p0;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.ranges.l;
import kotlin.reflect.y.internal.j0.e.m;
import kotlin.reflect.y.internal.j0.e.z.a;
import kotlin.reflect.y.internal.j0.e.z.c;
import kotlin.reflect.y.internal.j0.f.b;

/* JADX INFO: compiled from: ProtoBasedClassDataFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y implements h {
    private final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f24635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1<b, z0> f24636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<b, kotlin.reflect.y.internal.j0.e.c> f24637d;

    /* JADX WARN: Multi-variable type inference failed */
    public y(m mVar, c cVar, a aVar, Function1<? super b, ? extends z0> function1) {
        kotlin.jvm.internal.m.f(mVar, "proto");
        kotlin.jvm.internal.m.f(cVar, "nameResolver");
        kotlin.jvm.internal.m.f(aVar, "metadataVersion");
        kotlin.jvm.internal.m.f(function1, "classSource");
        this.a = cVar;
        this.f24635b = aVar;
        this.f24636c = function1;
        List<kotlin.reflect.y.internal.j0.e.c> listJ = mVar.J();
        kotlin.jvm.internal.m.e(listJ, "proto.class_List");
        LinkedHashMap linkedHashMap = new LinkedHashMap(l.b(p0.e(v.u(listJ, 10)), 16));
        for (Object obj : listJ) {
            linkedHashMap.put(x.a(this.a, ((kotlin.reflect.y.internal.j0.e.c) obj).F0()), obj);
        }
        this.f24637d = linkedHashMap;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.h
    public g a(b bVar) {
        kotlin.jvm.internal.m.f(bVar, "classId");
        kotlin.reflect.y.internal.j0.e.c cVar = this.f24637d.get(bVar);
        if (cVar == null) {
            return null;
        }
        return new g(this.a, cVar, this.f24635b, this.f24636c.invoke(bVar));
    }

    public final Collection<b> b() {
        return this.f24637d.keySet();
    }
}
