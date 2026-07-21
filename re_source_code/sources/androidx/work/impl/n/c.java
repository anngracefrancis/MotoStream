package androidx.work.impl.n;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: DependencyDao_Impl.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements b {
    private final androidx.room.j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.room.c<androidx.work.impl.n.a> f2512b;

    /* JADX INFO: compiled from: DependencyDao_Impl.java */
    class a extends androidx.room.c<androidx.work.impl.n.a> {
        a(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(c.u.a.f fVar, androidx.work.impl.n.a aVar) {
            String str = aVar.a;
            if (str == null) {
                fVar.I0(1);
            } else {
                fVar.w(1, str);
            }
            String str2 = aVar.f2511b;
            if (str2 == null) {
                fVar.I0(2);
            } else {
                fVar.w(2, str2);
            }
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }
    }

    public c(androidx.room.j jVar) {
        this.a = jVar;
        this.f2512b = new a(jVar);
    }

    @Override // androidx.work.impl.n.b
    public void a(androidx.work.impl.n.a aVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.f2512b.insert(aVar);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // androidx.work.impl.n.b
    public List<String> b(String str) {
        androidx.room.m mVarC = androidx.room.m.c("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            mVarC.I0(1);
        } else {
            mVarC.w(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = androidx.room.t.c.b(this.a, mVarC, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorB.getCount());
            while (cursorB.moveToNext()) {
                arrayList.add(cursorB.getString(0));
            }
            cursorB.close();
            mVarC.f();
            return arrayList;
        } catch (Throwable th) {
            cursorB.close();
            mVarC.f();
            throw th;
        }
    }

    @Override // androidx.work.impl.n.b
    public boolean c(String str) {
        androidx.room.m mVarC = androidx.room.m.c("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            mVarC.I0(1);
        } else {
            mVarC.w(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        boolean z = false;
        Cursor cursorB = androidx.room.t.c.b(this.a, mVarC, false, null);
        try {
            if (cursorB.moveToFirst()) {
                z = cursorB.getInt(0) != 0;
            }
            return z;
        } finally {
            cursorB.close();
            mVarC.f();
        }
    }

    @Override // androidx.work.impl.n.b
    public boolean d(String str) {
        androidx.room.m mVarC = androidx.room.m.c("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            mVarC.I0(1);
        } else {
            mVarC.w(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        boolean z = false;
        Cursor cursorB = androidx.room.t.c.b(this.a, mVarC, false, null);
        try {
            if (cursorB.moveToFirst()) {
                z = cursorB.getInt(0) != 0;
            }
            return z;
        } finally {
            cursorB.close();
            mVarC.f();
        }
    }
}
