package androidx.work.impl.n;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SystemIdInfoDao_Impl.java */
/* JADX INFO: loaded from: classes.dex */
public final class i implements h {
    private final androidx.room.j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.room.c<g> f2516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final androidx.room.q f2517c;

    /* JADX INFO: compiled from: SystemIdInfoDao_Impl.java */
    class a extends androidx.room.c<g> {
        a(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(c.u.a.f fVar, g gVar) {
            String str = gVar.a;
            if (str == null) {
                fVar.I0(1);
            } else {
                fVar.w(1, str);
            }
            fVar.h0(2, gVar.f2515b);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
        }
    }

    /* JADX INFO: compiled from: SystemIdInfoDao_Impl.java */
    class b extends androidx.room.q {
        b(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }
    }

    public i(androidx.room.j jVar) {
        this.a = jVar;
        this.f2516b = new a(jVar);
        this.f2517c = new b(jVar);
    }

    @Override // androidx.work.impl.n.h
    public List<String> a() {
        androidx.room.m mVarC = androidx.room.m.c("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
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

    @Override // androidx.work.impl.n.h
    public void b(g gVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.f2516b.insert(gVar);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // androidx.work.impl.n.h
    public g c(String str) {
        androidx.room.m mVarC = androidx.room.m.c("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            mVarC.I0(1);
        } else {
            mVarC.w(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = androidx.room.t.c.b(this.a, mVarC, false, null);
        try {
            return cursorB.moveToFirst() ? new g(cursorB.getString(androidx.room.t.b.b(cursorB, "work_spec_id")), cursorB.getInt(androidx.room.t.b.b(cursorB, "system_id"))) : null;
        } finally {
            cursorB.close();
            mVarC.f();
        }
    }

    @Override // androidx.work.impl.n.h
    public void d(String str) {
        this.a.assertNotSuspendingTransaction();
        c.u.a.f fVarAcquire = this.f2517c.acquire();
        if (str == null) {
            fVarAcquire.I0(1);
        } else {
            fVarAcquire.w(1, str);
        }
        this.a.beginTransaction();
        try {
            fVarAcquire.E();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f2517c.release(fVarAcquire);
        }
    }
}
