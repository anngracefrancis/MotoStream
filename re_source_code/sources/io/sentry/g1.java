package io.sentry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: DuplicateEventDetectionEventProcessor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g1 implements k1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<Throwable, Object> f22418f = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final x4 f22419g;

    public g1(x4 x4Var) {
        this.f22419g = (x4) io.sentry.util.q.c(x4Var, "options are required");
    }

    private static List<Throwable> a(Throwable th) {
        ArrayList arrayList = new ArrayList();
        while (th.getCause() != null) {
            arrayList.add(th.getCause());
            th = th.getCause();
        }
        return arrayList;
    }

    private static <T> boolean c(Map<T, Object> map, List<T> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (map.containsKey(it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // io.sentry.k1
    public l4 b(l4 l4Var, n1 n1Var) {
        if (this.f22419g.isEnableDeduplication()) {
            Throwable thO = l4Var.O();
            if (thO != null) {
                if (this.f22418f.containsKey(thO) || c(this.f22418f, a(thO))) {
                    this.f22419g.getLogger().c(s4.DEBUG, "Duplicate Exception detected. Event %s will be discarded.", l4Var.G());
                    return null;
                }
                this.f22418f.put(thO, null);
            }
        } else {
            this.f22419g.getLogger().c(s4.DEBUG, "Event deduplication is disabled.", new Object[0]);
        }
        return l4Var;
    }

    @Override // io.sentry.k1
    public /* synthetic */ io.sentry.protocol.x e(io.sentry.protocol.x xVar, n1 n1Var) {
        return j1.a(this, xVar, n1Var);
    }
}
