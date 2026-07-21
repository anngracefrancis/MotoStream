package rx.t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import rx.k;

/* JADX INFO: compiled from: CompositeSubscription.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Set<k> f26908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f26909g;

    private static void e(Collection<k> collection) {
        if (collection == null) {
            return;
        }
        ArrayList arrayList = null;
        Iterator<k> it = collection.iterator();
        while (it.hasNext()) {
            try {
                it.next().unsubscribe();
            } catch (Throwable th) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        rx.exceptions.a.d(arrayList);
    }

    public void a(k kVar) {
        if (kVar.isUnsubscribed()) {
            return;
        }
        if (!this.f26909g) {
            synchronized (this) {
                if (!this.f26909g) {
                    if (this.f26908f == null) {
                        this.f26908f = new HashSet(4);
                    }
                    this.f26908f.add(kVar);
                    return;
                }
            }
        }
        kVar.unsubscribe();
    }

    public void b() {
        Set<k> set;
        if (this.f26909g) {
            return;
        }
        synchronized (this) {
            if (!this.f26909g && (set = this.f26908f) != null) {
                this.f26908f = null;
                e(set);
            }
        }
    }

    public boolean c() {
        Set<k> set;
        boolean z = false;
        if (this.f26909g) {
            return false;
        }
        synchronized (this) {
            if (!this.f26909g && (set = this.f26908f) != null && !set.isEmpty()) {
                z = true;
            }
        }
        return z;
    }

    public void d(k kVar) {
        Set<k> set;
        if (this.f26909g) {
            return;
        }
        synchronized (this) {
            if (!this.f26909g && (set = this.f26908f) != null) {
                boolean zRemove = set.remove(kVar);
                if (zRemove) {
                    kVar.unsubscribe();
                }
            }
        }
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.f26909g;
    }

    @Override // rx.k
    public void unsubscribe() {
        if (this.f26909g) {
            return;
        }
        synchronized (this) {
            if (this.f26909g) {
                return;
            }
            this.f26909g = true;
            Set<k> set = this.f26908f;
            this.f26908f = null;
            e(set);
        }
    }
}
