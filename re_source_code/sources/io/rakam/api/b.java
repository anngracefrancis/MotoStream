package io.rakam.api;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.database.room.RoomNotification;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DatabaseHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class b extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Map<String, b> f21917f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final h f21918g = h.d();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    File f21919h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f21920i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f21921j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private c f21922k;

    protected b(Context context, String str) {
        super(context, l(str), (SQLiteDatabase.CursorFactory) null, 3);
        this.f21921j = true;
        this.f21919h = context.getDatabasePath(l(str));
        this.f21920i = j.e(str);
    }

    private synchronized long H(String str, long j2) {
        long jSimpleQueryForLong;
        jSimpleQueryForLong = -1;
        SQLiteStatement sQLiteStatement = null;
        try {
            try {
                try {
                    SQLiteStatement sQLiteStatementCompileStatement = getReadableDatabase().compileStatement("SELECT id FROM " + str + " LIMIT 1 OFFSET " + (j2 - 1));
                    try {
                        jSimpleQueryForLong = sQLiteStatementCompileStatement.simpleQueryForLong();
                    } catch (SQLiteDoneException e2) {
                        f21918g.h("io.rakam.api.DatabaseHelper", e2);
                    }
                    if (sQLiteStatementCompileStatement != null) {
                        sQLiteStatementCompileStatement.close();
                    }
                } catch (StackOverflowError e3) {
                    f21918g.c("io.rakam.api.DatabaseHelper", String.format("getNthEventId from %s failed", str), e3);
                    e.e().g(String.format("DB: Failed to getNthEventId from table %s", str), e3);
                    e();
                    if (0 != 0) {
                        sQLiteStatement.close();
                    }
                }
            } catch (SQLiteException e4) {
                f21918g.c("io.rakam.api.DatabaseHelper", String.format("getNthEventId from %s failed", str), e4);
                e.e().g(String.format("DB: Failed to getNthEventId from table %s", str), e4);
                e();
                if (0 != 0) {
                    sQLiteStatement.close();
                }
            }
            close();
        } catch (Throwable th) {
            if (0 != 0) {
                sQLiteStatement.close();
            }
            close();
            throw th;
        }
        return jSimpleQueryForLong;
    }

    private synchronized long b(String str, String str2) {
        StackOverflowError e2;
        long jQ;
        SQLiteException e3;
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("event", str2);
                jQ = Q(writableDatabase, str, contentValues);
                if (jQ == -1) {
                    try {
                        f21918g.g("io.rakam.api.DatabaseHelper", String.format("Insert into %s failed", str));
                    } catch (SQLiteException e4) {
                        e3 = e4;
                        f21918g.c("io.rakam.api.DatabaseHelper", String.format("addEvent to %s failed", str), e3);
                        e.e().g(String.format("DB: Failed to addEvent: %s", str2), e3);
                        e();
                    } catch (StackOverflowError e5) {
                        e2 = e5;
                        f21918g.c("io.rakam.api.DatabaseHelper", String.format("addEvent to %s failed", str), e2);
                        e.e().g(String.format("DB: Failed to addEvent: %s", str2), e2);
                        e();
                    }
                }
            } catch (SQLiteException e6) {
                e3 = e6;
                jQ = -1;
            } catch (StackOverflowError e7) {
                e2 = e7;
                jQ = -1;
            }
            close();
        } catch (Throwable th) {
            close();
            throw th;
        }
        return jQ;
    }

    private static void d(RuntimeException runtimeException) {
        String message = runtimeException.getMessage();
        if (!j.d(message) && message.startsWith("Cursor window allocation of")) {
            throw new CursorWindowAllocationException(message);
        }
        throw runtimeException;
    }

    /* JADX WARN: Code duplicated, block: B:71:0x00eb A[DONT_GENERATE] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v3, types: [io.rakam.api.e] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void e() {
        ?? r2;
        ?? r1;
        ?? r0;
        boolean zIsOpen;
        boolean zIsOpen2;
        String strIsOpen = "DB: Failed to run databaseReset callback in delete";
        String strE = "databaseReset callback failed during delete";
        String str = "io.rakam.api.DatabaseHelper";
        SQLiteDatabase writableDatabase = null;
        try {
            try {
                close();
                this.f21919h.delete();
                if (this.f21922k != null && this.f21921j) {
                    this.f21921j = false;
                    try {
                        writableDatabase = getWritableDatabase();
                        this.f21922k.a(writableDatabase);
                    } catch (SQLiteException e2) {
                        f21918g.c("io.rakam.api.DatabaseHelper", String.format("databaseReset callback failed during delete", new Object[0]), e2);
                        e eVarE = e.e();
                        Object[] objArr = new Object[0];
                        String str2 = String.format("DB: Failed to run databaseReset callback in delete", objArr);
                        eVarE.g(str2, e2);
                        r0 = zIsOpen;
                        r1 = eVarE;
                        r2 = objArr;
                        strIsOpen = zIsOpen;
                        strE = eVarE;
                        str = objArr;
                        r0 = zIsOpen2;
                        r1 = strE;
                        r2 = str;
                        strIsOpen = zIsOpen2;
                        strE = strE;
                        str = str;
                    } finally {
                        this.f21921j = true;
                        if (writableDatabase != null && writableDatabase.isOpen()) {
                            close();
                        }
                    }
                    r0 = zIsOpen;
                    r1 = eVarE;
                    r2 = objArr;
                    strIsOpen = zIsOpen;
                    strE = eVarE;
                    str = objArr;
                    r0 = zIsOpen2;
                    r1 = strE;
                    r2 = str;
                    strIsOpen = zIsOpen2;
                    strE = strE;
                    str = str;
                }
            } catch (Throwable th) {
                if (this.f21922k != null && this.f21921j) {
                    this.f21921j = false;
                    try {
                        writableDatabase = getWritableDatabase();
                        this.f21922k.a(writableDatabase);
                    } catch (SQLiteException e3) {
                        f21918g.c(str, String.format(strE, new Object[0]), e3);
                        e.e().g(String.format(strIsOpen, new Object[0]), e3);
                    } finally {
                        this.f21921j = true;
                        if (writableDatabase != null && writableDatabase.isOpen()) {
                            close();
                        }
                    }
                }
                throw th;
            }
        } catch (SecurityException e4) {
            f21918g.c("io.rakam.api.DatabaseHelper", "delete failed", e4);
            e.e().f("DB: Failed to delete database");
            if (this.f21922k != null && this.f21921j) {
                this.f21921j = false;
                try {
                    writableDatabase = getWritableDatabase();
                    this.f21922k.a(writableDatabase);
                } catch (SQLiteException e5) {
                    f21918g.c("io.rakam.api.DatabaseHelper", String.format("databaseReset callback failed during delete", new Object[0]), e5);
                    strE = e.e();
                    str = new Object[0];
                    strIsOpen = String.format("DB: Failed to run databaseReset callback in delete", str);
                    strE.g(strIsOpen, e5);
                    r0 = strIsOpen;
                    r1 = strE;
                    r2 = str;
                    r0 = strIsOpen;
                    r1 = strE;
                    r2 = str;
                } finally {
                    this.f21921j = true;
                    if (writableDatabase != null && writableDatabase.isOpen()) {
                        close();
                    }
                }
            }
            r0 = strIsOpen;
            r1 = strE;
            r2 = str;
            r0 = strIsOpen;
            r1 = strE;
            r2 = str;
        }
        r0 = strIsOpen;
        r1 = strE;
        r2 = str;
        r0 = strIsOpen;
        r1 = strE;
        r2 = str;
    }

    private synchronized void i0(String str, long j2) {
        try {
            try {
                try {
                    getWritableDatabase().delete(str, "id = " + j2, null);
                } catch (SQLiteException e2) {
                    f21918g.c("io.rakam.api.DatabaseHelper", String.format("removeEvent from %s failed", str), e2);
                    e.e().g(String.format("DB: Failed to removeEvent from table %s", str), e2);
                    e();
                }
            } catch (StackOverflowError e3) {
                f21918g.c("io.rakam.api.DatabaseHelper", String.format("removeEvent from %s failed", str), e3);
                e.e().g(String.format("DB: Failed to removeEvent from table %s", str), e3);
                e();
            }
            close();
        } catch (Throwable th) {
            close();
            throw th;
        }
    }

    @Deprecated
    static b j(Context context) {
        return k(context, null);
    }

    static synchronized b k(Context context, String str) {
        b bVar;
        String strE = j.e(str);
        Map<String, b> map = f21917f;
        bVar = map.get(strE);
        if (bVar == null) {
            bVar = new b(context.getApplicationContext(), strE);
            map.put(strE, bVar);
        }
        return bVar;
    }

    private static String l(String str) {
        if (j.d(str) || str.equals("$default_instance")) {
            return "io.rakam.api";
        }
        return "io.rakam.api_" + str;
    }

    private synchronized void n0(String str, long j2) {
        try {
            try {
                try {
                    getWritableDatabase().delete(str, "id <= " + j2, null);
                } catch (SQLiteException e2) {
                    f21918g.c("io.rakam.api.DatabaseHelper", String.format("removeEvents from %s failed", str), e2);
                    e.e().g(String.format("DB: Failed to removeEvents from table %s", str), e2);
                    e();
                }
            } catch (StackOverflowError e3) {
                f21918g.c("io.rakam.api.DatabaseHelper", String.format("removeEvents from %s failed", str), e3);
                e.e().g(String.format("DB: Failed to removeEvents from table %s", str), e3);
                e();
            }
            close();
        } catch (Throwable th) {
            close();
            throw th;
        }
    }

    private synchronized long p(String str) {
        long jSimpleQueryForLong;
        SQLiteStatement sQLiteStatementCompileStatement = null;
        try {
            try {
                try {
                    sQLiteStatementCompileStatement = getReadableDatabase().compileStatement("SELECT COUNT(*) FROM " + str);
                    jSimpleQueryForLong = sQLiteStatementCompileStatement.simpleQueryForLong();
                    sQLiteStatementCompileStatement.close();
                    close();
                } catch (SQLiteException e2) {
                    f21918g.c("io.rakam.api.DatabaseHelper", String.format("getNumberRows for %s failed", str), e2);
                    e.e().g(String.format("DB: Failed to getNumberRows for table %s", str), e2);
                    e();
                    if (sQLiteStatementCompileStatement != null) {
                        sQLiteStatementCompileStatement.close();
                    }
                    close();
                    jSimpleQueryForLong = 0;
                }
            } catch (StackOverflowError e3) {
                f21918g.c("io.rakam.api.DatabaseHelper", String.format("getNumberRows for %s failed", str), e3);
                e.e().g(String.format("DB: Failed to getNumberRows for table %s", str), e3);
                e();
                if (sQLiteStatementCompileStatement != null) {
                    sQLiteStatementCompileStatement.close();
                }
                close();
                jSimpleQueryForLong = 0;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                sQLiteStatementCompileStatement.close();
            }
            close();
            throw th;
        }
        return jSimpleQueryForLong;
    }

    private void t0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS store");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS long_store");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS identifys");
        onCreate(sQLiteDatabase);
    }

    synchronized List<JSONObject> A(long j2, long j3) throws JSONException {
        return y("identifys", j2, j3);
    }

    synchronized Long B(String str) {
        return (Long) N("long_store", str);
    }

    synchronized long D(long j2) {
        return H("events", j2);
    }

    synchronized long I(long j2) {
        return H("identifys", j2);
    }

    synchronized long J() {
        return m() + z();
    }

    synchronized String K(String str) {
        return (String) N(AccountAnalytics.STORE, str);
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00ca: MOVE (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:44:0x00ca */
    protected synchronized Object N(String str, String str2) {
        Cursor cursor;
        Cursor cursorE0;
        Object string;
        Cursor cursor2 = null;
        string = null;
        string = null;
        string = null;
        string = null;
        string = null;
        string = null;
        string = null;
        try {
            try {
                try {
                    cursorE0 = e0(getReadableDatabase(), str, new String[]{RoomNotification.KEY, "value"}, "key = ?", new String[]{str2}, null, null, null, null);
                    try {
                        if (cursorE0.moveToFirst()) {
                            string = str.equals(AccountAnalytics.STORE) ? cursorE0.getString(1) : Long.valueOf(cursorE0.getLong(1));
                        }
                        cursorE0.close();
                    } catch (SQLiteException e2) {
                        e = e2;
                        f21918g.c("io.rakam.api.DatabaseHelper", String.format("getValue from %s failed", str), e);
                        e.e().g(String.format("DB: Failed to getValue: %s", str2), e);
                        e();
                        if (cursorE0 != null) {
                            cursorE0.close();
                        }
                    } catch (RuntimeException e3) {
                        e = e3;
                        e.e().g(String.format("DB: Failed to getValue: %s", str2), e);
                        d(e);
                        if (cursorE0 != null) {
                            cursorE0.close();
                        }
                    } catch (StackOverflowError e4) {
                        e = e4;
                        f21918g.c("io.rakam.api.DatabaseHelper", String.format("getValue from %s failed", str), e);
                        e.e().g(String.format("DB: Failed to getValue: %s", str2), e);
                        e();
                        if (cursorE0 != null) {
                            cursorE0.close();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } catch (SQLiteException e5) {
                e = e5;
                cursorE0 = null;
            } catch (RuntimeException e6) {
                e = e6;
                cursorE0 = null;
            } catch (StackOverflowError e7) {
                e = e7;
                cursorE0 = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor2 != null) {
                    cursor2.close();
                }
                close();
                throw th;
            }
            close();
        } catch (Throwable th3) {
            th = th3;
            cursor2 = cursor;
        }
        return string;
    }

    synchronized long Q(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) throws StackOverflowError, SQLiteException {
        return sQLiteDatabase.insert(str, null, contentValues);
    }

    synchronized long T(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) throws StackOverflowError, SQLiteException {
        return sQLiteDatabase.insertWithOnConflict(str, null, contentValues, 5);
    }

    synchronized long W(String str, Long l) {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return l == null ? f("long_store", str) : a0("long_store", str, l);
    }

    synchronized long Y(String str, String str2) {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return str2 == null ? f(AccountAnalytics.STORE, str) : a0(AccountAnalytics.STORE, str, str2);
    }

    synchronized long Z(SQLiteDatabase sQLiteDatabase, String str, String str2, Object obj) throws StackOverflowError, SQLiteException {
        long jT;
        ContentValues contentValues = new ContentValues();
        contentValues.put(RoomNotification.KEY, str2);
        if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            contentValues.put("value", (String) obj);
        }
        jT = T(sQLiteDatabase, str, contentValues);
        if (jT == -1) {
            f21918g.g("io.rakam.api.DatabaseHelper", "Insert failed");
        }
        return jT;
    }

    synchronized long a(String str) {
        return b("events", str);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0048 A[Catch: all -> 0x008b, TRY_LEAVE, TryCatch #1 {, blocks: (B:6:0x000e, B:8:0x0014, B:29:0x0081, B:31:0x0087, B:32:0x008a, B:15:0x0042, B:17:0x0048, B:22:0x0074, B:4:0x0004, B:13:0x001b, B:20:0x004d), top: B:39:0x0004, inners: #0 }] */
    synchronized long a0(String str, String str2, Object obj) {
        long jZ;
        SQLiteDatabase writableDatabase = null;
        try {
            try {
                try {
                    writableDatabase = getWritableDatabase();
                    jZ = Z(writableDatabase, str, str2, obj);
                    if (writableDatabase != null && writableDatabase.isOpen()) {
                        close();
                    }
                } catch (StackOverflowError e2) {
                    f21918g.c("io.rakam.api.DatabaseHelper", String.format("insertOrReplaceKeyValue in %s failed", str), e2);
                    e.e().g(String.format("DB: Failed to insertOrReplaceKeyValue %s", str2), e2);
                    e();
                    if (writableDatabase != null && writableDatabase.isOpen()) {
                        close();
                    }
                    jZ = -1;
                }
            } catch (SQLiteException e3) {
                f21918g.c("io.rakam.api.DatabaseHelper", String.format("insertOrReplaceKeyValue in %s failed", str), e3);
                e.e().g(String.format("DB: Failed to insertOrReplaceKeyValue %s", str2), e3);
                e();
                if (writableDatabase != null && writableDatabase.isOpen()) {
                    close();
                }
                jZ = -1;
            }
        } catch (Throwable th) {
            if (writableDatabase != null && writableDatabase.isOpen()) {
                close();
            }
            throw th;
        }
        return jZ;
    }

    synchronized long c(String str) {
        return b("identifys", str);
    }

    Cursor e0(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    synchronized long f(String str, String str2) {
        long jDelete;
        try {
            jDelete = getWritableDatabase().delete(str, "key=?", new String[]{str2});
        } catch (StackOverflowError e2) {
            f21918g.c("io.rakam.api.DatabaseHelper", String.format("deleteKey from %s failed", str), e2);
            e.e().g(String.format("DB: Failed to deleteKey: %s", str2), e2);
            e();
            jDelete = -1;
        } catch (SQLiteException e3) {
            f21918g.c("io.rakam.api.DatabaseHelper", String.format("deleteKey from %s failed", str), e3);
            e.e().g(String.format("DB: Failed to deleteKey: %s", str2), e3);
            e();
            jDelete = -1;
        } finally {
            close();
        }
        return jDelete;
    }

    synchronized void f0(long j2) {
        i0("events", j2);
    }

    synchronized long m() {
        return p("events");
    }

    synchronized void m0(long j2) {
        n0("events", j2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS store (key TEXT PRIMARY KEY NOT NULL, value TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS long_store (key TEXT PRIMARY KEY NOT NULL, value INTEGER);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS identifys (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);");
        c cVar = this.f21922k;
        if (cVar == null || !this.f21921j) {
            return;
        }
        try {
            try {
                this.f21921j = false;
                cVar.a(sQLiteDatabase);
            } catch (SQLiteException e2) {
                f21918g.c("io.rakam.api.DatabaseHelper", String.format("databaseReset callback failed during onCreate", new Object[0]), e2);
                e.e().g(String.format("DB: Failed to run databaseReset callback during onCreate", new Object[0]), e2);
            }
        } finally {
            this.f21921j = true;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 > i3) {
            f21918g.b("io.rakam.api.DatabaseHelper", "onUpgrade() with invalid oldVersion and newVersion");
            t0(sQLiteDatabase);
            return;
        }
        if (i3 <= 1) {
            return;
        }
        if (i2 == 1) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS store (key TEXT PRIMARY KEY NOT NULL, value TEXT);");
            if (i3 <= 2) {
                return;
            }
        } else if (i2 != 2) {
            if (i2 != 3) {
                f21918g.b("io.rakam.api.DatabaseHelper", "onUpgrade() with unknown oldVersion " + i2);
                t0(sQLiteDatabase);
                return;
            }
            return;
        }
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS identifys (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS long_store (key TEXT PRIMARY KEY NOT NULL, value INTEGER);");
    }

    synchronized void p0(long j2) {
        i0("identifys", j2);
    }

    synchronized void q0(long j2) {
        n0("identifys", j2);
    }

    synchronized List<JSONObject> x(long j2, long j3) throws JSONException {
        return y("events", j2, j3);
    }

    void x0(c cVar) {
        this.f21922k = cVar;
    }

    protected synchronized List<JSONObject> y(String str, long j2, long j3) throws JSONException {
        LinkedList linkedList;
        String str2;
        String str3;
        try {
            linkedList = new LinkedList();
            Cursor cursorE0 = null;
            try {
                try {
                    try {
                        try {
                            SQLiteDatabase readableDatabase = getReadableDatabase();
                            String[] strArr = {DeepLinkIntentReceiver.DeepLinksKeys.ID, "event"};
                            if (j2 >= 0) {
                                str2 = "id <= " + j2;
                            } else {
                                str2 = null;
                            }
                            if (j3 >= 0) {
                                str3 = HttpUrl.FRAGMENT_ENCODE_SET + j3;
                            } else {
                                str3 = null;
                            }
                            cursorE0 = e0(readableDatabase, str, strArr, str2, null, null, null, "id ASC", str3);
                            while (cursorE0.moveToNext()) {
                                long j4 = cursorE0.getLong(0);
                                String string = cursorE0.getString(1);
                                if (!j.d(string)) {
                                    JSONObject jSONObject = new JSONObject(string);
                                    jSONObject.put("event_id", j4);
                                    linkedList.add(jSONObject);
                                }
                            }
                            cursorE0.close();
                        } catch (Throwable th) {
                            if (cursorE0 != null) {
                                cursorE0.close();
                            }
                            close();
                            throw th;
                        }
                    } catch (SQLiteException e2) {
                        f21918g.c("io.rakam.api.DatabaseHelper", String.format("getEvents from %s failed", str), e2);
                        e.e().g(String.format("DB: Failed to getEventsFromTable %s", str), e2);
                        e();
                        if (cursorE0 != null) {
                            cursorE0.close();
                        }
                    }
                } catch (RuntimeException e3) {
                    e.e().g(String.format("DB: Failed to getEventsFromTable %s", str), e3);
                    d(e3);
                    if (cursorE0 != null) {
                        cursorE0.close();
                    }
                }
            } catch (StackOverflowError e4) {
                f21918g.c("io.rakam.api.DatabaseHelper", String.format("getEvents from %s failed", str), e4);
                e.e().g(String.format("DB: Failed to getEventsFromTable %s", str), e4);
                e();
                if (cursorE0 != null) {
                    cursorE0.close();
                }
            }
            close();
        } catch (Throwable th2) {
            throw th2;
        }
        return linkedList;
    }

    synchronized long z() {
        return p("identifys");
    }
}
