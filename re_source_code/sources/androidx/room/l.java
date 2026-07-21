package androidx.room;

import android.database.Cursor;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: RoomOpenHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends c.u.a.c.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private androidx.room.a f2180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f2181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f2182d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f2183e;

    /* JADX INFO: compiled from: RoomOpenHelper.java */
    public static abstract class a {
        public final int version;

        public a(int i2) {
            this.version = i2;
        }

        protected abstract void createAllTables(c.u.a.b bVar);

        protected abstract void dropAllTables(c.u.a.b bVar);

        protected abstract void onCreate(c.u.a.b bVar);

        protected abstract void onOpen(c.u.a.b bVar);

        protected abstract void onPostMigrate(c.u.a.b bVar);

        protected abstract void onPreMigrate(c.u.a.b bVar);

        protected abstract b onValidateSchema(c.u.a.b bVar);

        @Deprecated
        protected void validateMigration(c.u.a.b bVar) {
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    /* JADX INFO: compiled from: RoomOpenHelper.java */
    public static class b {
        public final boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f2184b;

        public b(boolean z, String str) {
            this.a = z;
            this.f2184b = str;
        }
    }

    public l(androidx.room.a aVar, a aVar2, String str, String str2) {
        super(aVar2.version);
        this.f2180b = aVar;
        this.f2181c = aVar2;
        this.f2182d = str;
        this.f2183e = str2;
    }

    private void h(c.u.a.b bVar) {
        if (!k(bVar)) {
            b bVarOnValidateSchema = this.f2181c.onValidateSchema(bVar);
            if (bVarOnValidateSchema.a) {
                this.f2181c.onPostMigrate(bVar);
                l(bVar);
                return;
            } else {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + bVarOnValidateSchema.f2184b);
            }
        }
        Cursor cursorH0 = bVar.H0(new c.u.a.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
        try {
            String string = cursorH0.moveToFirst() ? cursorH0.getString(0) : null;
            cursorH0.close();
            if (!this.f2182d.equals(string) && !this.f2183e.equals(string)) {
                throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
            }
        } catch (Throwable th) {
            cursorH0.close();
            throw th;
        }
    }

    private void i(c.u.a.b bVar) {
        bVar.v("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private static boolean j(c.u.a.b bVar) {
        Cursor cursorU0 = bVar.u0("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z = false;
            if (cursorU0.moveToFirst() && cursorU0.getInt(0) == 0) {
                z = true;
            }
            return z;
        } finally {
            cursorU0.close();
        }
    }

    private static boolean k(c.u.a.b bVar) {
        Cursor cursorU0 = bVar.u0("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z = false;
            if (cursorU0.moveToFirst() && cursorU0.getInt(0) != 0) {
                z = true;
            }
            return z;
        } finally {
            cursorU0.close();
        }
    }

    private void l(c.u.a.b bVar) {
        i(bVar);
        bVar.v(k.a(this.f2182d));
    }

    @Override // c.u.a.c.a
    public void b(c.u.a.b bVar) {
        super.b(bVar);
    }

    @Override // c.u.a.c.a
    public void d(c.u.a.b bVar) {
        boolean zJ = j(bVar);
        this.f2181c.createAllTables(bVar);
        if (!zJ) {
            b bVarOnValidateSchema = this.f2181c.onValidateSchema(bVar);
            if (!bVarOnValidateSchema.a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + bVarOnValidateSchema.f2184b);
            }
        }
        l(bVar);
        this.f2181c.onCreate(bVar);
    }

    @Override // c.u.a.c.a
    public void e(c.u.a.b bVar, int i2, int i3) {
        g(bVar, i2, i3);
    }

    @Override // c.u.a.c.a
    public void f(c.u.a.b bVar) {
        super.f(bVar);
        h(bVar);
        this.f2181c.onOpen(bVar);
        this.f2180b = null;
    }

    @Override // c.u.a.c.a
    public void g(c.u.a.b bVar, int i2, int i3) {
        boolean z;
        List<androidx.room.s.a> listC;
        androidx.room.a aVar = this.f2180b;
        if (aVar == null || (listC = aVar.f2119d.c(i2, i3)) == null) {
            z = false;
        } else {
            this.f2181c.onPreMigrate(bVar);
            Iterator<androidx.room.s.a> it = listC.iterator();
            while (it.hasNext()) {
                it.next().migrate(bVar);
            }
            b bVarOnValidateSchema = this.f2181c.onValidateSchema(bVar);
            if (!bVarOnValidateSchema.a) {
                throw new IllegalStateException("Migration didn't properly handle: " + bVarOnValidateSchema.f2184b);
            }
            this.f2181c.onPostMigrate(bVar);
            l(bVar);
            z = true;
        }
        if (z) {
            return;
        }
        androidx.room.a aVar2 = this.f2180b;
        if (aVar2 != null && !aVar2.a(i2, i3)) {
            this.f2181c.dropAllTables(bVar);
            this.f2181c.createAllTables(bVar);
            return;
        }
        throw new IllegalStateException("A migration from " + i2 + " to " + i3 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }
}
