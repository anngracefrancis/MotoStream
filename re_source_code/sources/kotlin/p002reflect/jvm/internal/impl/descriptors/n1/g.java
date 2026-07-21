package kotlin.p002reflect.jvm.internal.impl.descriptors.n1;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.y.internal.j0.f.c;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface g extends Iterable<c>, KMappedMarker {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f25179c = a.a;

    /* JADX INFO: compiled from: Annotations.kt */
    public static final class a {
        static final /* synthetic */ a a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final g f25180b = new C0407a();

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.descriptors.n1.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Annotations.kt */
        public static final class C0407a implements g {
            C0407a() {
            }

            @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g
            public boolean R0(c cVar) {
                return b.b(this, cVar);
            }

            public Void c(c cVar) {
                m.f(cVar, "fqName");
                return null;
            }

            @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g
            public boolean isEmpty() {
                return true;
            }

            @Override // java.lang.Iterable
            public Iterator<c> iterator() {
                return u.j().iterator();
            }

            @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g
            public /* bridge */ /* synthetic */ c l(c cVar) {
                return (c) c(cVar);
            }

            public String toString() {
                return "EMPTY";
            }
        }

        private a() {
        }

        public final g a(List<? extends c> list) {
            m.f(list, "annotations");
            return list.isEmpty() ? f25180b : new h(list);
        }

        public final g b() {
            return f25180b;
        }
    }

    /* JADX INFO: compiled from: Annotations.kt */
    public static final class b {
        public static c a(g gVar, c cVar) {
            c next;
            m.f(cVar, "fqName");
            Iterator<c> it = gVar.iterator();
            while (it.hasNext()) {
                next = it.next();
                if (m.a(next.d(), cVar)) {
                    return next;
                }
            }
            next = null;
            return next;
        }

        public static boolean b(g gVar, c cVar) {
            m.f(cVar, "fqName");
            return gVar.l(cVar) != null;
        }
    }

    boolean R0(c cVar);

    boolean isEmpty();

    c l(c cVar);
}
