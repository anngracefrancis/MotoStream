package androidx.work.impl.n;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: WorkTagDao_Impl.java */
/* JADX INFO: loaded from: classes.dex */
public final class u implements t {
    private final androidx.room.j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.room.c<s> f2550b;

    /* JADX INFO: compiled from: WorkTagDao_Impl.java */
    class a extends androidx.room.c<s> {
        a(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(c.u.a.f fVar, s sVar) {
            String str = sVar.a;
            if (str == null) {
                fVar.I0(1);
            } else {
                fVar.w(1, str);
            }
            String str2 = sVar.f2549b;
            if (str2 == null) {
                fVar.I0(2);
            } else {
                fVar.w(2, str2);
            }
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }
    }

    public u(androidx.room.j jVar) {
        this.a = jVar;
        this.f2550b = new a(jVar);
    }

    @Override // androidx.work.impl.n.t
    public void a(s sVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.f2550b.insert(sVar);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // androidx.work.impl.n.t
    public List<String> b(String str) {
        androidx.room.m mVarC = androidx.room.m.c("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
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
