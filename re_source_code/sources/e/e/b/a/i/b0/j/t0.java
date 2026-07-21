package e.e.b.a.i.b0.j;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/* JADX INFO: compiled from: SchemaManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class t0 extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f20798f = "INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static int f20799g = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final a f20800h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final a f20801i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final a f20802j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final a f20803k;
    private static final a l;
    private static final List<a> m;
    private final int n;
    private boolean o;

    /* JADX INFO: compiled from: SchemaManager.java */
    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        c0 c0Var = new a() { // from class: e.e.b.a.i.b0.j.c0
            @Override // e.e.b.a.i.b0.j.t0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                t0.b(sQLiteDatabase);
            }
        };
        f20800h = c0Var;
        z zVar = new a() { // from class: e.e.b.a.i.b0.j.z
            @Override // e.e.b.a.i.b0.j.t0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                t0.c(sQLiteDatabase);
            }
        };
        f20801i = zVar;
        a0 a0Var = new a() { // from class: e.e.b.a.i.b0.j.a0
            @Override // e.e.b.a.i.b0.j.t0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
            }
        };
        f20802j = a0Var;
        b0 b0Var = new a() { // from class: e.e.b.a.i.b0.j.b0
            @Override // e.e.b.a.i.b0.j.t0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                t0.e(sQLiteDatabase);
            }
        };
        f20803k = b0Var;
        d0 d0Var = new a() { // from class: e.e.b.a.i.b0.j.d0
            @Override // e.e.b.a.i.b0.j.t0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                t0.f(sQLiteDatabase);
            }
        };
        l = d0Var;
        m = Arrays.asList(c0Var, zVar, a0Var, b0Var, d0Var);
    }

    @Inject
    t0(Context context, @Named("SQLITE_DB_NAME") String str, @Named("SCHEMA_VERSION") int i2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
        this.o = false;
        this.n = i2;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        if (this.o) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }

    static /* synthetic */ void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    static /* synthetic */ void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    static /* synthetic */ void e(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    static /* synthetic */ void f(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        sQLiteDatabase.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
        sQLiteDatabase.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
        sQLiteDatabase.execSQL(f20798f);
    }

    private void j(SQLiteDatabase sQLiteDatabase, int i2) {
        a(sQLiteDatabase);
        k(sQLiteDatabase, 0, i2);
    }

    private void k(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        List<a> list = m;
        if (i3 <= list.size()) {
            while (i2 < i3) {
                m.get(i2).a(sQLiteDatabase);
                i2++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i2 + " to " + i3 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.o = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        if (Build.VERSION.SDK_INT >= 16) {
            sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        j(sQLiteDatabase, this.n);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        j(sQLiteDatabase, i3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        a(sQLiteDatabase);
        k(sQLiteDatabase, i2, i3);
    }
}
