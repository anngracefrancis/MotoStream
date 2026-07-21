package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.c0;
import kotlin.collections.t;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.b.g;
import kotlin.reflect.y.internal.j0.d.b.p;
import kotlin.reflect.y.internal.j0.d.b.q;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.i.u.d;
import kotlin.reflect.y.internal.j0.i.w.h;

/* JADX INFO: compiled from: PackagePartScopeCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private final g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f25313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<b, h> f25314c;

    public a(g gVar, g gVar2) {
        m.f(gVar, "resolver");
        m.f(gVar2, "kotlinClassFinder");
        this.a = gVar;
        this.f25313b = gVar2;
        this.f25314c = new ConcurrentHashMap<>();
    }

    public final h a(f fVar) {
        Collection collectionE;
        m.f(fVar, "fileClass");
        ConcurrentHashMap<b, h> concurrentHashMap = this.f25314c;
        b bVarE = fVar.e();
        h hVar = concurrentHashMap.get(bVarE);
        if (hVar == null) {
            c cVarH = fVar.e().h();
            m.e(cVarH, "fileClass.classId.packageFqName");
            if (fVar.a().c() == kotlin.reflect.y.internal.j0.d.b.c0.a.EnumC0345a.MULTIFILE_CLASS) {
                List<String> listF = fVar.a().f();
                collectionE = new ArrayList();
                Iterator<T> it = listF.iterator();
                while (it.hasNext()) {
                    b bVarM = b.m(d.d((String) it.next()).e());
                    m.e(bVarM, "topLevel(JvmClassName.by…velClassMaybeWithDollars)");
                    q qVarB = p.b(this.f25313b, bVarM);
                    if (qVarB != null) {
                        collectionE.add(qVarB);
                    }
                }
            } else {
                collectionE = t.e(fVar);
            }
            kotlin.p002reflect.jvm.internal.impl.descriptors.p1.m mVar = new kotlin.p002reflect.jvm.internal.impl.descriptors.p1.m(this.a.d().p(), cVarH);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = collectionE.iterator();
            while (it2.hasNext()) {
                h hVarB = this.a.b(mVar, (q) it2.next());
                if (hVarB != null) {
                    arrayList.add(hVarB);
                }
            }
            List listE0 = c0.E0(arrayList);
            h hVarA = kotlin.reflect.y.internal.j0.i.w.b.f24397b.a("package " + cVarH + " (" + fVar + ')', listE0);
            h hVarPutIfAbsent = concurrentHashMap.putIfAbsent(bVarE, hVarA);
            hVar = hVarPutIfAbsent == null ? hVarA : hVarPutIfAbsent;
        }
        m.e(hVar, "cache.getOrPut(fileClass…ileClass)\", scopes)\n    }");
        return hVar;
    }
}
