package androidx.room;

import java.util.Iterator;

/* JADX INFO: compiled from: EntityDeletionOrUpdateAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b<T> extends q {
    public b(j jVar) {
        super(jVar);
    }

    protected abstract void bind(c.u.a.f fVar, T t);

    @Override // androidx.room.q
    protected abstract String createQuery();

    public final int handle(T t) {
        c.u.a.f fVarAcquire = acquire();
        try {
            bind(fVarAcquire, t);
            return fVarAcquire.E();
        } finally {
            release(fVarAcquire);
        }
    }

    public final int handleMultiple(Iterable<? extends T> iterable) {
        c.u.a.f fVarAcquire = acquire();
        int iE = 0;
        try {
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                bind(fVarAcquire, it.next());
                iE += fVarAcquire.E();
            }
            release(fVarAcquire);
            return iE;
        } catch (Throwable th) {
            release(fVarAcquire);
            throw th;
        }
    }

    public final int handleMultiple(T[] tArr) {
        c.u.a.f fVarAcquire = acquire();
        try {
            int iE = 0;
            for (T t : tArr) {
                bind(fVarAcquire, t);
                iE += fVarAcquire.E();
            }
            release(fVarAcquire);
            return iE;
        } catch (Throwable th) {
            release(fVarAcquire);
            throw th;
        }
    }
}
