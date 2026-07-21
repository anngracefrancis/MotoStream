package c.u.a.g;

import android.database.sqlite.SQLiteProgram;

/* JADX INFO: compiled from: FrameworkSQLiteProgram.java */
/* JADX INFO: loaded from: classes.dex */
class d implements c.u.a.d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SQLiteProgram f3491f;

    d(SQLiteProgram sQLiteProgram) {
        this.f3491f = sQLiteProgram;
    }

    @Override // c.u.a.d
    public void I0(int i2) {
        this.f3491f.bindNull(i2);
    }

    @Override // c.u.a.d
    public void L(int i2, double d2) {
        this.f3491f.bindDouble(i2, d2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3491f.close();
    }

    @Override // c.u.a.d
    public void h0(int i2, long j2) {
        this.f3491f.bindLong(i2, j2);
    }

    @Override // c.u.a.d
    public void o0(int i2, byte[] bArr) {
        this.f3491f.bindBlob(i2, bArr);
    }

    @Override // c.u.a.d
    public void w(int i2, String str) {
        this.f3491f.bindString(i2, str);
    }
}
