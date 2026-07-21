package androidx.work.impl.n;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: WorkNameDao_Impl.java */
/* JADX INFO: loaded from: classes.dex */
public final class l implements k {
    private final androidx.room.j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.room.c<j> f2519b;

    /* JADX INFO: compiled from: WorkNameDao_Impl.java */
    class a extends androidx.room.c<j> {
        a(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(c.u.a.f fVar, j jVar) {
            String str = jVar.a;
            if (str == null) {
                fVar.I0(1);
            } else {
                fVar.w(1, str);
            }
            String str2 = jVar.f2518b;
            if (str2 == null) {
                fVar.I0(2);
            } else {
                fVar.w(2, str2);
            }
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }
    }

    public l(androidx.room.j jVar) {
        this.a = jVar;
        this.f2519b = new a(jVar);
    }

    @Override // androidx.work.impl.n.k
    public void a(j jVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.f2519b.insert(jVar);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // androidx.work.impl.n.k
    public List<String> b(String str) {
        androidx.room.m mVarC = androidx.room.m.c("SELECT name FROM workname WHERE work_spec_id=?", 1);
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
}
