package kotlin.reflect.y.internal.j0.d.a.o0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.IndexedValue;
import kotlin.collections.n;
import kotlin.collections.p0;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.l;
import kotlin.reflect.y.internal.j0.d.b.x;
import kotlin.reflect.y.internal.j0.i.u.e;
import kotlin.s;
import kotlin.u;

/* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
final class m {
    private final Map<String, k> a = new LinkedHashMap();

    /* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
    public final class a {
        private final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ m f23670b;

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.d.a.o0.m$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
        public final class C0339a {
            private final String a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final List<Pair<String, q>> f23671b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private Pair<String, q> f23672c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f23673d;

            public C0339a(a aVar, String str) {
                kotlin.jvm.internal.m.f(str, "functionName");
                this.f23673d = aVar;
                this.a = str;
                this.f23671b = new ArrayList();
                this.f23672c = s.a("V", null);
            }

            public final Pair<String, k> a() {
                x xVar = x.a;
                String strB = this.f23673d.b();
                String str = this.a;
                List<Pair<String, q>> list = this.f23671b;
                ArrayList arrayList = new ArrayList(v.u(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Pair) it.next()).c());
                }
                String strK = xVar.k(strB, xVar.j(str, arrayList, this.f23672c.c()));
                q qVarD = this.f23672c.d();
                List<Pair<String, q>> list2 = this.f23671b;
                ArrayList arrayList2 = new ArrayList(v.u(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((q) ((Pair) it2.next()).d());
                }
                return s.a(strK, new k(qVarD, arrayList2));
            }

            public final void b(String str, e... eVarArr) {
                q qVar;
                kotlin.jvm.internal.m.f(str, "type");
                kotlin.jvm.internal.m.f(eVarArr, "qualifiers");
                List<Pair<String, q>> list = this.f23671b;
                if (eVarArr.length == 0) {
                    qVar = null;
                } else {
                    Iterable<IndexedValue> iterableM0 = n.m0(eVarArr);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(l.b(p0.e(v.u(iterableM0, 10)), 16));
                    for (IndexedValue indexedValue : iterableM0) {
                        linkedHashMap.put(Integer.valueOf(indexedValue.c()), (e) indexedValue.d());
                    }
                    qVar = new q(linkedHashMap);
                }
                list.add(s.a(str, qVar));
            }

            public final void c(String str, e... eVarArr) {
                kotlin.jvm.internal.m.f(str, "type");
                kotlin.jvm.internal.m.f(eVarArr, "qualifiers");
                Iterable<IndexedValue> iterableM0 = n.m0(eVarArr);
                LinkedHashMap linkedHashMap = new LinkedHashMap(l.b(p0.e(v.u(iterableM0, 10)), 16));
                for (IndexedValue indexedValue : iterableM0) {
                    linkedHashMap.put(Integer.valueOf(indexedValue.c()), (e) indexedValue.d());
                }
                this.f23672c = s.a(str, new q(linkedHashMap));
            }

            public final void d(e eVar) {
                kotlin.jvm.internal.m.f(eVar, "type");
                String strU = eVar.u();
                kotlin.jvm.internal.m.e(strU, "type.desc");
                this.f23672c = s.a(strU, null);
            }
        }

        public a(m mVar, String str) {
            kotlin.jvm.internal.m.f(str, "className");
            this.f23670b = mVar;
            this.a = str;
        }

        public final void a(String str, Function1<? super C0339a, u> function1) {
            kotlin.jvm.internal.m.f(str, "name");
            kotlin.jvm.internal.m.f(function1, "block");
            Map map = this.f23670b.a;
            C0339a c0339a = new C0339a(this, str);
            function1.invoke(c0339a);
            Pair<String, k> pairA = c0339a.a();
            map.put(pairA.c(), pairA.d());
        }

        public final String b() {
            return this.a;
        }
    }

    public final Map<String, k> b() {
        return this.a;
    }
}
