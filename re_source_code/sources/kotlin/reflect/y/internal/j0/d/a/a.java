package kotlin.reflect.y.internal.j0.d.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.collections.n;
import kotlin.collections.s;
import kotlin.collections.x0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.d.a.o0.f;
import kotlin.reflect.y.internal.j0.d.a.o0.i;
import kotlin.reflect.y.internal.j0.f.c;

/* JADX INFO: compiled from: AbstractAnnotationTypeQualifierResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a<TAnnotation> {
    private static final C0326a a = new C0326a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    private static final Map<String, kotlin.reflect.y.internal.j0.d.a.b> f23320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final w f23321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<Object, TAnnotation> f23322d;

    /* JADX INFO: renamed from: kotlin.f0.y.e.j0.d.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractAnnotationTypeQualifierResolver.kt */
    private static final class C0326a {
        private C0326a() {
        }

        public /* synthetic */ C0326a(g gVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: AbstractAnnotationTypeQualifierResolver.kt */
    static final class b extends Lambda implements Function1<TAnnotation, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f23323f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(TAnnotation tannotation) {
            m.f(tannotation, "$this$extractNullability");
            return Boolean.FALSE;
        }
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (kotlin.reflect.y.internal.j0.d.a.b bVar : kotlin.reflect.y.internal.j0.d.a.b.values()) {
            String strK = bVar.k();
            if (linkedHashMap.get(strK) == null) {
                linkedHashMap.put(strK, bVar);
            }
        }
        f23320b = linkedHashMap;
    }

    public a(w wVar) {
        m.f(wVar, "javaTypeEnhancementState");
        this.f23321c = wVar;
        this.f23322d = new ConcurrentHashMap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Set<kotlin.reflect.y.internal.j0.d.a.b> a(Set<? extends kotlin.reflect.y.internal.j0.d.a.b> set) {
        return set.contains(kotlin.reflect.y.internal.j0.d.a.b.TYPE_USE) ? x0.l(x0.k(n.l0(kotlin.reflect.y.internal.j0.d.a.b.values()), kotlin.reflect.y.internal.j0.d.a.b.TYPE_PARAMETER_BOUNDS), set) : set;
    }

    private final q d(TAnnotation tannotation) {
        i iVarG;
        q qVarR = r(tannotation);
        if (qVarR != null) {
            return qVarR;
        }
        Pair<TAnnotation, Set<kotlin.reflect.y.internal.j0.d.a.b>> pairT = t(tannotation);
        if (pairT == null) {
            return null;
        }
        TAnnotation tannotationA = pairT.a();
        Set<kotlin.reflect.y.internal.j0.d.a.b> setB = pairT.b();
        f0 f0VarQ = q(tannotation);
        if (f0VarQ == null) {
            f0VarQ = p(tannotationA);
        }
        if (f0VarQ.q() || (iVarG = g(tannotationA, b.f23323f)) == null) {
            return null;
        }
        return new q(i.b(iVarG, null, f0VarQ.u(), 1, null), setB, false, 4, null);
    }

    private final i g(TAnnotation tannotation, Function1<? super TAnnotation, Boolean> function1) {
        i iVarN;
        i iVarN2 = n(tannotation, function1.invoke(tannotation).booleanValue());
        if (iVarN2 != null) {
            return iVarN2;
        }
        TAnnotation tannotationS = s(tannotation);
        if (tannotationS == null) {
            return null;
        }
        f0 f0VarP = p(tannotation);
        if (f0VarP.q() || (iVarN = n(tannotationS, function1.invoke(tannotationS).booleanValue())) == null) {
            return null;
        }
        return i.b(iVarN, null, f0VarP.u(), 1, null);
    }

    private final TAnnotation h(TAnnotation tannotation, c cVar) {
        for (TAnnotation tannotation2 : k(tannotation)) {
            if (m.a(i(tannotation2), cVar)) {
                return tannotation2;
            }
        }
        return null;
    }

    private final boolean l(TAnnotation tannotation, c cVar) {
        Iterable<TAnnotation> iterableK = k(tannotation);
        if ((iterableK instanceof Collection) && ((Collection) iterableK).isEmpty()) {
            return false;
        }
        Iterator<TAnnotation> it = iterableK.iterator();
        while (it.hasNext()) {
            if (m.a(i(it.next()), cVar)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0078, code lost:
    
        if (r6.equals("ALWAYS") != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008d, code lost:
    
        if (r6.equals("NEVER") == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0096, code lost:
    
        if (r6.equals("MAYBE") == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0099, code lost:
    
        r6 = kotlin.reflect.y.internal.j0.d.a.o0.h.NULLABLE;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlin.reflect.y.internal.j0.d.a.o0.i n(TAnnotation r6, boolean r7) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.y.internal.j0.d.a.a.n(java.lang.Object, boolean):kotlin.f0.y.e.j0.d.a.o0.i");
    }

    private final f0 o(TAnnotation tannotation) {
        c cVarI = i(tannotation);
        return (cVarI == null || !c.c().containsKey(cVarI)) ? p(tannotation) : this.f23321c.c().invoke(cVarI);
    }

    private final f0 p(TAnnotation tannotation) {
        f0 f0VarQ = q(tannotation);
        return f0VarQ != null ? f0VarQ : this.f23321c.d().a();
    }

    private final f0 q(TAnnotation tannotation) {
        Iterable<String> iterableB;
        String str;
        f0 f0Var = this.f23321c.d().c().get(i(tannotation));
        if (f0Var != null) {
            return f0Var;
        }
        TAnnotation tannotationH = h(tannotation, c.d());
        if (tannotationH == null || (iterableB = b(tannotationH, false)) == null || (str = (String) s.V(iterableB)) == null) {
            return null;
        }
        f0 f0VarB = this.f23321c.d().b();
        if (f0VarB != null) {
            return f0VarB;
        }
        int iHashCode = str.hashCode();
        if (iHashCode == -2137067054) {
            if (str.equals("IGNORE")) {
                return f0.IGNORE;
            }
            return null;
        }
        if (iHashCode == -1838656823) {
            if (str.equals("STRICT")) {
                return f0.STRICT;
            }
            return null;
        }
        if (iHashCode == 2656902 && str.equals("WARN")) {
            return f0.WARN;
        }
        return null;
    }

    private final q r(TAnnotation tannotation) {
        q qVar;
        if (this.f23321c.b() || (qVar = c.a().get(i(tannotation))) == null) {
            return null;
        }
        f0 f0VarO = o(tannotation);
        if (!(f0VarO != f0.IGNORE)) {
            f0VarO = null;
        }
        if (f0VarO == null) {
            return null;
        }
        return q.b(qVar, i.b(qVar.d(), null, f0VarO.u(), 1, null), null, false, 6, null);
    }

    private final Pair<TAnnotation, Set<kotlin.reflect.y.internal.j0.d.a.b>> t(TAnnotation tannotation) {
        TAnnotation tannotationH;
        TAnnotation next;
        if (this.f23321c.d().d() || (tannotationH = h(tannotation, c.e())) == null) {
            return null;
        }
        Iterator<TAnnotation> it = k(tannotation).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(s(next) != null));
        if (next == null) {
            return null;
        }
        Iterable<String> iterableB = b(tannotationH, true);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<String> it2 = iterableB.iterator();
        while (it2.hasNext()) {
            kotlin.reflect.y.internal.j0.d.a.b bVar = f23320b.get(it2.next());
            if (bVar != null) {
                linkedHashSet.add(bVar);
            }
        }
        return new Pair<>(next, a(linkedHashSet));
    }

    protected abstract Iterable<String> b(TAnnotation tannotation, boolean z);

    public final x c(x xVar, Iterable<? extends TAnnotation> iterable) {
        EnumMap<kotlin.reflect.y.internal.j0.d.a.b, q> enumMapB;
        m.f(iterable, "annotations");
        if (this.f23321c.b()) {
            return xVar;
        }
        ArrayList<q> arrayList = new ArrayList();
        Iterator<? extends TAnnotation> it = iterable.iterator();
        while (it.hasNext()) {
            q qVarD = d(it.next());
            if (qVarD != null) {
                arrayList.add(qVarD);
            }
        }
        if (arrayList.isEmpty()) {
            return xVar;
        }
        EnumMap enumMap = (xVar == null || (enumMapB = xVar.b()) == null) ? new EnumMap(kotlin.reflect.y.internal.j0.d.a.b.class) : new EnumMap((EnumMap) enumMapB);
        boolean z = false;
        for (q qVar : arrayList) {
            Iterator<kotlin.reflect.y.internal.j0.d.a.b> it2 = qVar.e().iterator();
            while (it2.hasNext()) {
                enumMap.put(it2.next(), qVar);
                z = true;
            }
        }
        return !z ? xVar : new x(enumMap);
    }

    public final f e(Iterable<? extends TAnnotation> iterable) {
        f fVar;
        m.f(iterable, "annotations");
        Iterator<? extends TAnnotation> it = iterable.iterator();
        f fVar2 = null;
        while (it.hasNext()) {
            c cVarI = i(it.next());
            if (b0.m().contains(cVarI)) {
                fVar = f.READ_ONLY;
            } else if (b0.j().contains(cVarI)) {
                fVar = f.MUTABLE;
            } else {
                continue;
            }
            if (fVar2 != null && fVar2 != fVar) {
                return null;
            }
            fVar2 = fVar;
        }
        return fVar2;
    }

    public final i f(Iterable<? extends TAnnotation> iterable, Function1<? super TAnnotation, Boolean> function1) {
        m.f(iterable, "annotations");
        m.f(function1, "forceWarning");
        Iterator<? extends TAnnotation> it = iterable.iterator();
        i iVar = null;
        while (it.hasNext()) {
            i iVarG = g(it.next(), function1);
            if (iVar != null) {
                if (iVarG != null && !m.a(iVarG, iVar) && (!iVarG.d() || iVar.d())) {
                    if (iVarG.d() || !iVar.d()) {
                        return null;
                    }
                }
            }
            iVar = iVarG;
        }
        return iVar;
    }

    protected abstract c i(TAnnotation tannotation);

    protected abstract Object j(TAnnotation tannotation);

    protected abstract Iterable<TAnnotation> k(TAnnotation tannotation);

    public final boolean m(TAnnotation tannotation) {
        m.f(tannotation, "annotation");
        TAnnotation tannotationH = h(tannotation, k.a.H);
        if (tannotationH == null) {
            return false;
        }
        Iterable<String> iterableB = b(tannotationH, false);
        if ((iterableB instanceof Collection) && ((Collection) iterableB).isEmpty()) {
            return false;
        }
        Iterator<String> it = iterableB.iterator();
        while (it.hasNext()) {
            if (m.a(it.next(), kotlin.p002reflect.jvm.internal.impl.descriptors.n1.n.H.name())) {
                return true;
            }
        }
        return false;
    }

    public final TAnnotation s(TAnnotation tannotation) {
        TAnnotation tannotationS;
        m.f(tannotation, "annotation");
        if (this.f23321c.d().d()) {
            return null;
        }
        if (c0.K(c.b(), i(tannotation)) || l(tannotation, c.f())) {
            return tannotation;
        }
        if (!l(tannotation, c.g())) {
            return null;
        }
        ConcurrentHashMap<Object, TAnnotation> concurrentHashMap = this.f23322d;
        Object objJ = j(tannotation);
        TAnnotation tannotation2 = concurrentHashMap.get(objJ);
        if (tannotation2 != null) {
            return tannotation2;
        }
        Iterator<TAnnotation> it = k(tannotation).iterator();
        do {
            if (!it.hasNext()) {
                tannotationS = null;
                break;
            }
            tannotationS = s(it.next());
        } while (tannotationS == null);
        if (tannotationS == null) {
            return null;
        }
        TAnnotation tannotationPutIfAbsent = concurrentHashMap.putIfAbsent(objJ, tannotationS);
        return tannotationPutIfAbsent == null ? tannotationS : tannotationPutIfAbsent;
    }
}
