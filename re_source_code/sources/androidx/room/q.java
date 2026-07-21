package androidx.room;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SharedSQLiteStatement.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class q {
    private final j mDatabase;
    private final AtomicBoolean mLock = new AtomicBoolean(false);
    private volatile c.u.a.f mStmt;

    public q(j jVar) {
        this.mDatabase = jVar;
    }

    private c.u.a.f createNewStatement() {
        return this.mDatabase.compileStatement(createQuery());
    }

    private c.u.a.f getStmt(boolean z) {
        if (!z) {
            return createNewStatement();
        }
        if (this.mStmt == null) {
            this.mStmt = createNewStatement();
        }
        return this.mStmt;
    }

    public c.u.a.f acquire() {
        assertNotMainThread();
        return getStmt(this.mLock.compareAndSet(false, true));
    }

    protected void assertNotMainThread() {
        this.mDatabase.assertNotMainThread();
    }

    protected abstract String createQuery();

    public void release(c.u.a.f fVar) {
        if (fVar == this.mStmt) {
            this.mLock.set(false);
        }
    }
}
