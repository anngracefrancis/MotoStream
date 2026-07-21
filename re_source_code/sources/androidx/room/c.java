package androidx.room;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: EntityInsertionAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c<T> extends q {
    public c(j jVar) {
        super(jVar);
    }

    protected abstract void bind(c.u.a.f fVar, T t);

    public final void insert(T t) {
        c.u.a.f fVarAcquire = acquire();
        try {
            bind(fVarAcquire, t);
            fVarAcquire.j1();
        } finally {
            release(fVarAcquire);
        }
    }

    public final long insertAndReturnId(T t) {
        c.u.a.f fVarAcquire = acquire();
        try {
            bind(fVarAcquire, t);
            return fVarAcquire.j1();
        } finally {
            release(fVarAcquire);
        }
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> collection) {
        c.u.a.f fVarAcquire = acquire();
        try {
            long[] jArr = new long[collection.size()];
            int i2 = 0;
            Iterator<? extends T> it = collection.iterator();
            while (it.hasNext()) {
                bind(fVarAcquire, it.next());
                jArr[i2] = fVarAcquire.j1();
                i2++;
            }
            release(fVarAcquire);
            return jArr;
        } catch (Throwable th) {
            release(fVarAcquire);
            throw th;
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> collection) {
        c.u.a.f fVarAcquire = acquire();
        try {
            Long[] lArr = new Long[collection.size()];
            int i2 = 0;
            Iterator<? extends T> it = collection.iterator();
            while (it.hasNext()) {
                bind(fVarAcquire, it.next());
                lArr[i2] = Long.valueOf(fVarAcquire.j1());
                i2++;
            }
            release(fVarAcquire);
            return lArr;
        } catch (Throwable th) {
            release(fVarAcquire);
            throw th;
        }
    }

    public final List<Long> insertAndReturnIdsList(T[] tArr) {
        c.u.a.f fVarAcquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(tArr.length);
            int i2 = 0;
            for (T t : tArr) {
                bind(fVarAcquire, t);
                arrayList.add(i2, Long.valueOf(fVarAcquire.j1()));
                i2++;
            }
            release(fVarAcquire);
            return arrayList;
        } catch (Throwable th) {
            release(fVarAcquire);
            throw th;
        }
    }

    public final void insert(T[] tArr) {
        c.u.a.f fVarAcquire = acquire();
        try {
            for (T t : tArr) {
                bind(fVarAcquire, t);
                fVarAcquire.j1();
            }
            release(fVarAcquire);
        } catch (Throwable th) {
            release(fVarAcquire);
            throw th;
        }
    }

    public final long[] insertAndReturnIdsArray(T[] tArr) {
        c.u.a.f fVarAcquire = acquire();
        try {
            long[] jArr = new long[tArr.length];
            int i2 = 0;
            for (T t : tArr) {
                bind(fVarAcquire, t);
                jArr[i2] = fVarAcquire.j1();
                i2++;
            }
            release(fVarAcquire);
            return jArr;
        } catch (Throwable th) {
            release(fVarAcquire);
            throw th;
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] tArr) {
        c.u.a.f fVarAcquire = acquire();
        try {
            Long[] lArr = new Long[tArr.length];
            int i2 = 0;
            for (T t : tArr) {
                bind(fVarAcquire, t);
                lArr[i2] = Long.valueOf(fVarAcquire.j1());
                i2++;
            }
            release(fVarAcquire);
            return lArr;
        } catch (Throwable th) {
            release(fVarAcquire);
            throw th;
        }
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> collection) {
        c.u.a.f fVarAcquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(collection.size());
            int i2 = 0;
            Iterator<? extends T> it = collection.iterator();
            while (it.hasNext()) {
                bind(fVarAcquire, it.next());
                arrayList.add(i2, Long.valueOf(fVarAcquire.j1()));
                i2++;
            }
            release(fVarAcquire);
            return arrayList;
        } catch (Throwable th) {
            release(fVarAcquire);
            throw th;
        }
    }

    public final void insert(Iterable<? extends T> iterable) {
        c.u.a.f fVarAcquire = acquire();
        try {
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                bind(fVarAcquire, it.next());
                fVarAcquire.j1();
            }
            release(fVarAcquire);
        } catch (Throwable th) {
            release(fVarAcquire);
            throw th;
        }
    }
}
