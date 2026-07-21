package c.u.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SupportSQLiteOpenHelper.java */
/* JADX INFO: loaded from: classes.dex */
public interface c extends Closeable {

    /* JADX INFO: compiled from: SupportSQLiteOpenHelper.java */
    public static abstract class a {
        public final int a;

        public a(int i2) {
            this.a = i2;
        }

        private void a(String str) {
            if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
                return;
            }
            Log.w("SupportSQLite", "deleting the database file: " + str);
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    SQLiteDatabase.deleteDatabase(new File(str));
                } else {
                    try {
                        if (!new File(str).delete()) {
                            Log.e("SupportSQLite", "Could not delete the database file " + str);
                        }
                    } catch (Exception e2) {
                        Log.e("SupportSQLite", "error while deleting corrupted database file", e2);
                    }
                }
            } catch (Exception e3) {
                Log.w("SupportSQLite", "delete failed: ", e3);
            }
        }

        public void b(c.u.a.b bVar) {
        }

        public void c(c.u.a.b bVar) {
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + bVar.g());
            if (!bVar.isOpen()) {
                a(bVar.g());
                return;
            }
            List<Pair<String, String>> listS = null;
            try {
                try {
                    listS = bVar.s();
                } catch (SQLiteException unused) {
                }
                try {
                    bVar.close();
                } catch (IOException unused2) {
                }
            } finally {
                if (listS != null) {
                    Iterator<Pair<String, String>> it = listS.iterator();
                    while (it.hasNext()) {
                        a((String) it.next().second);
                    }
                } else {
                    a(bVar.g());
                }
            }
        }

        public abstract void d(c.u.a.b bVar);

        public abstract void e(c.u.a.b bVar, int i2, int i3);

        public void f(c.u.a.b bVar) {
        }

        public abstract void g(c.u.a.b bVar, int i2, int i3);
    }

    /* JADX INFO: compiled from: SupportSQLiteOpenHelper.java */
    public static class b {
        public final Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3470b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f3471c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f3472d;

        /* JADX INFO: compiled from: SupportSQLiteOpenHelper.java */
        public static class a {
            Context a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            String f3473b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            a f3474c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            boolean f3475d;

            a(Context context) {
                this.a = context;
            }

            public b a() {
                if (this.f3474c == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                }
                if (this.a == null) {
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                }
                if (this.f3475d && TextUtils.isEmpty(this.f3473b)) {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
                return new b(this.a, this.f3473b, this.f3474c, this.f3475d);
            }

            public a b(a aVar) {
                this.f3474c = aVar;
                return this;
            }

            public a c(String str) {
                this.f3473b = str;
                return this;
            }

            public a d(boolean z) {
                this.f3475d = z;
                return this;
            }
        }

        b(Context context, String str, a aVar, boolean z) {
            this.a = context;
            this.f3470b = str;
            this.f3471c = aVar;
            this.f3472d = z;
        }

        public static a a(Context context) {
            return new a(context);
        }
    }

    /* JADX INFO: renamed from: c.u.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SupportSQLiteOpenHelper.java */
    public interface InterfaceC0094c {
        c a(b bVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    c.u.a.b s0();

    void setWriteAheadLoggingEnabled(boolean z);
}
