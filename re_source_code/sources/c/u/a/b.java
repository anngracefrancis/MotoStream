package c.u.a;

import android.database.Cursor;
import android.database.SQLException;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;

/* JADX INFO: compiled from: SupportSQLiteDatabase.java */
/* JADX INFO: loaded from: classes.dex */
public interface b extends Closeable {
    f F(String str);

    Cursor H0(e eVar);

    boolean P0();

    Cursor S(e eVar, CancellationSignal cancellationSignal);

    String g();

    boolean isOpen();

    void j0();

    void l0(String str, Object[] objArr) throws SQLException;

    void n();

    List<Pair<String, String>> s();

    Cursor u0(String str);

    void v(String str) throws SQLException;

    void z0();
}
