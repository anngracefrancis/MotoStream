package c.u.a.g;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.CancellationSignal;
import android.util.Pair;
import c.u.a.f;
import java.io.IOException;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: FrameworkSQLiteDatabase.java */
/* JADX INFO: loaded from: classes.dex */
class a implements c.u.a.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f3476f = {HttpUrl.FRAGMENT_ENCODE_SET, " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f3477g = new String[0];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final SQLiteDatabase f3478h;

    /* JADX INFO: renamed from: c.u.a.g.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FrameworkSQLiteDatabase.java */
    class C0095a implements SQLiteDatabase.CursorFactory {
        final /* synthetic */ c.u.a.e a;

        C0095a(c.u.a.e eVar) {
            this.a = eVar;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.a.b(new d(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    /* JADX INFO: compiled from: FrameworkSQLiteDatabase.java */
    class b implements SQLiteDatabase.CursorFactory {
        final /* synthetic */ c.u.a.e a;

        b(c.u.a.e eVar) {
            this.a = eVar;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.a.b(new d(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    a(SQLiteDatabase sQLiteDatabase) {
        this.f3478h = sQLiteDatabase;
    }

    @Override // c.u.a.b
    public f F(String str) {
        return new e(this.f3478h.compileStatement(str));
    }

    @Override // c.u.a.b
    public Cursor H0(c.u.a.e eVar) {
        return this.f3478h.rawQueryWithFactory(new C0095a(eVar), eVar.a(), f3477g, null);
    }

    @Override // c.u.a.b
    public boolean P0() {
        return this.f3478h.inTransaction();
    }

    @Override // c.u.a.b
    public Cursor S(c.u.a.e eVar, CancellationSignal cancellationSignal) {
        return this.f3478h.rawQueryWithFactory(new b(eVar), eVar.a(), f3477g, null, cancellationSignal);
    }

    boolean a(SQLiteDatabase sQLiteDatabase) {
        return this.f3478h == sQLiteDatabase;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3478h.close();
    }

    @Override // c.u.a.b
    public String g() {
        return this.f3478h.getPath();
    }

    @Override // c.u.a.b
    public boolean isOpen() {
        return this.f3478h.isOpen();
    }

    @Override // c.u.a.b
    public void j0() {
        this.f3478h.setTransactionSuccessful();
    }

    @Override // c.u.a.b
    public void l0(String str, Object[] objArr) throws SQLException {
        this.f3478h.execSQL(str, objArr);
    }

    @Override // c.u.a.b
    public void n() {
        this.f3478h.beginTransaction();
    }

    @Override // c.u.a.b
    public List<Pair<String, String>> s() {
        return this.f3478h.getAttachedDbs();
    }

    @Override // c.u.a.b
    public Cursor u0(String str) {
        return H0(new c.u.a.a(str));
    }

    @Override // c.u.a.b
    public void v(String str) throws SQLException {
        this.f3478h.execSQL(str);
    }

    @Override // c.u.a.b
    public void z0() {
        this.f3478h.endTransaction();
    }
}
