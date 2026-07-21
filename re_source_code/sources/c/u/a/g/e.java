package c.u.a.g;

import android.database.sqlite.SQLiteStatement;
import c.u.a.f;

/* JADX INFO: compiled from: FrameworkSQLiteStatement.java */
/* JADX INFO: loaded from: classes.dex */
class e extends d implements f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SQLiteStatement f3492g;

    e(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f3492g = sQLiteStatement;
    }

    @Override // c.u.a.f
    public int E() {
        return this.f3492g.executeUpdateDelete();
    }

    @Override // c.u.a.f
    public long j1() {
        return this.f3492g.executeInsert();
    }
}
