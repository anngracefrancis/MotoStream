package i.a.g;

import androidx.recyclerview.widget.RecyclerView;
import java.util.EventListener;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: ListenerStatus.java */
/* JADX INFO: loaded from: classes2.dex */
public class m<T extends EventListener> {
    private final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f21835b;

    /* JADX INFO: compiled from: ListenerStatus.java */
    public static class a extends m<i.a.e> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static k.b.b f21836c = k.b.c.i(a.class.getName());

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ConcurrentMap<String, i.a.d> f21837d;

        public a(i.a.e eVar, boolean z) {
            super(eVar, z);
            this.f21837d = new ConcurrentHashMap(32);
        }

        private static final boolean c(i.a.d dVar, i.a.d dVar2) {
            if (dVar == null || dVar2 == null || !dVar.equals(dVar2)) {
                return false;
            }
            byte[] bArrR = dVar.r();
            byte[] bArrR2 = dVar2.r();
            if (bArrR.length != bArrR2.length) {
                return false;
            }
            for (int i2 = 0; i2 < bArrR.length; i2++) {
                if (bArrR[i2] != bArrR2[i2]) {
                    return false;
                }
            }
            return dVar.v(dVar2);
        }

        void d(i.a.c cVar) {
            if (this.f21837d.putIfAbsent(cVar.f() + "." + cVar.g(), cVar.e().clone()) != null) {
                f21836c.c("Service Added called for a service already added: " + cVar);
                return;
            }
            a().serviceAdded(cVar);
            i.a.d dVarE = cVar.e();
            if (dVarE == null || !dVarE.u()) {
                return;
            }
            a().serviceResolved(cVar);
        }

        void e(i.a.c cVar) {
            String str = cVar.f() + "." + cVar.g();
            ConcurrentMap<String, i.a.d> concurrentMap = this.f21837d;
            if (concurrentMap.remove(str, concurrentMap.get(str))) {
                a().serviceRemoved(cVar);
                return;
            }
            f21836c.c("Service Removed called for a service already removed: " + cVar);
        }

        synchronized void f(i.a.c cVar) {
            i.a.d dVarE = cVar.e();
            if (dVarE == null || !dVarE.u()) {
                f21836c.h("Service Resolved called for an unresolved event: " + cVar);
            } else {
                String str = cVar.f() + "." + cVar.g();
                i.a.d dVar = this.f21837d.get(str);
                if (c(dVarE, dVar)) {
                    f21836c.c("Service Resolved called for a service already resolved: " + cVar);
                } else if (dVar == null) {
                    if (this.f21837d.putIfAbsent(str, dVarE.clone()) == null) {
                        a().serviceResolved(cVar);
                    }
                } else if (this.f21837d.replace(str, dVar, dVarE.clone())) {
                    a().serviceResolved(cVar);
                }
            }
        }

        @Override // i.a.g.m
        public String toString() {
            StringBuilder sb = new StringBuilder(RecyclerView.l.FLAG_MOVED);
            sb.append("[Status for ");
            sb.append(a().toString());
            if (this.f21837d.isEmpty()) {
                sb.append(" no type event ");
            } else {
                sb.append(" (");
                Iterator<String> it = this.f21837d.keySet().iterator();
                while (it.hasNext()) {
                    sb.append(it.next() + ", ");
                }
                sb.append(") ");
            }
            sb.append("]");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: ListenerStatus.java */
    public static class b extends m<i.a.f> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static k.b.b f21838c = k.b.c.i(b.class.getName());

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ConcurrentMap<String, String> f21839d;

        void c(i.a.c cVar) {
            if (this.f21839d.putIfAbsent(cVar.g(), cVar.g()) == null) {
                a().b(cVar);
                return;
            }
            f21838c.i("Service Type Added called for a service type already added: " + cVar);
        }

        void d(i.a.c cVar) {
            if (this.f21839d.putIfAbsent(cVar.g(), cVar.g()) == null) {
                a().a(cVar);
                return;
            }
            f21838c.i("Service Sub Type Added called for a service sub type already added: " + cVar);
        }

        @Override // i.a.g.m
        public String toString() {
            StringBuilder sb = new StringBuilder(RecyclerView.l.FLAG_MOVED);
            sb.append("[Status for ");
            sb.append(a().toString());
            if (this.f21839d.isEmpty()) {
                sb.append(" no type event ");
            } else {
                sb.append(" (");
                Iterator<String> it = this.f21839d.keySet().iterator();
                while (it.hasNext()) {
                    sb.append(it.next() + ", ");
                }
                sb.append(") ");
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public m(T t, boolean z) {
        this.a = t;
        this.f21835b = z;
    }

    public T a() {
        return this.a;
    }

    public boolean b() {
        return this.f21835b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && a().equals(((m) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return "[Status for " + a().toString() + "]";
    }
}
