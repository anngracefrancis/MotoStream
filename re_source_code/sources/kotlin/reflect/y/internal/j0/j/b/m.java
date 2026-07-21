package kotlin.reflect.y.internal.j0.j.b;

import java.util.List;
import kotlin.reflect.y.internal.j0.e.s;
import kotlin.reflect.y.internal.j0.e.z.a;
import kotlin.reflect.y.internal.j0.e.z.c;
import kotlin.reflect.y.internal.j0.e.z.g;
import kotlin.reflect.y.internal.j0.e.z.h;
import kotlin.reflect.y.internal.j0.e.z.i;
import kotlin.reflect.y.internal.j0.j.b.g0.f;
import kotlin.reflect.y.internal.j0.k.n;

/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {
    private final k a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f24592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.p002reflect.jvm.internal.impl.descriptors.m f24593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g f24594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final h f24595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a f24596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final f f24597g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final d0 f24598h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final w f24599i;

    public m(k kVar, c cVar, kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar, g gVar, h hVar, a aVar, f fVar, d0 d0Var, List<s> list) {
        String strC;
        kotlin.jvm.internal.m.f(kVar, "components");
        kotlin.jvm.internal.m.f(cVar, "nameResolver");
        kotlin.jvm.internal.m.f(mVar, "containingDeclaration");
        kotlin.jvm.internal.m.f(gVar, "typeTable");
        kotlin.jvm.internal.m.f(hVar, "versionRequirementTable");
        kotlin.jvm.internal.m.f(aVar, "metadataVersion");
        kotlin.jvm.internal.m.f(list, "typeParameters");
        this.a = kVar;
        this.f24592b = cVar;
        this.f24593c = mVar;
        this.f24594d = gVar;
        this.f24595e = hVar;
        this.f24596f = aVar;
        this.f24597g = fVar;
        this.f24598h = new d0(this, d0Var, list, "Deserializer for \"" + mVar.getName() + '\"', (fVar == null || (strC = fVar.c()) == null) ? "[container not found]" : strC);
        this.f24599i = new w(this);
    }

    public static /* synthetic */ m b(m mVar, kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar2, List list, c cVar, g gVar, h hVar, a aVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            cVar = mVar.f24592b;
        }
        c cVar2 = cVar;
        if ((i2 & 8) != 0) {
            gVar = mVar.f24594d;
        }
        g gVar2 = gVar;
        if ((i2 & 16) != 0) {
            hVar = mVar.f24595e;
        }
        h hVar2 = hVar;
        if ((i2 & 32) != 0) {
            aVar = mVar.f24596f;
        }
        return mVar.a(mVar2, list, cVar2, gVar2, hVar2, aVar);
    }

    public final m a(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar, List<s> list, c cVar, g gVar, h hVar, a aVar) {
        kotlin.jvm.internal.m.f(mVar, "descriptor");
        kotlin.jvm.internal.m.f(list, "typeParameterProtos");
        kotlin.jvm.internal.m.f(cVar, "nameResolver");
        kotlin.jvm.internal.m.f(gVar, "typeTable");
        h hVar2 = hVar;
        kotlin.jvm.internal.m.f(hVar2, "versionRequirementTable");
        kotlin.jvm.internal.m.f(aVar, "metadataVersion");
        k kVar = this.a;
        if (!i.b(aVar)) {
            hVar2 = this.f24595e;
        }
        return new m(kVar, cVar, mVar, gVar, hVar2, aVar, this.f24597g, this.f24598h, list);
    }

    public final k c() {
        return this.a;
    }

    public final f d() {
        return this.f24597g;
    }

    public final kotlin.p002reflect.jvm.internal.impl.descriptors.m e() {
        return this.f24593c;
    }

    public final w f() {
        return this.f24599i;
    }

    public final c g() {
        return this.f24592b;
    }

    public final n h() {
        return this.a.u();
    }

    public final d0 i() {
        return this.f24598h;
    }

    public final g j() {
        return this.f24594d;
    }

    public final h k() {
        return this.f24595e;
    }
}
