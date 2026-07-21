package androidx.work.impl.n;

import android.database.Cursor;

/* JADX INFO: compiled from: PreferenceDao_Impl.java */
/* JADX INFO: loaded from: classes.dex */
public final class f implements e {
    private final androidx.room.j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.room.c<d> f2514b;

    /* JADX INFO: compiled from: PreferenceDao_Impl.java */
    class a extends androidx.room.c<d> {
        a(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(c.u.a.f fVar, d dVar) {
            String str = dVar.a;
            if (str == null) {
                fVar.I0(1);
            } else {
                fVar.w(1, str);
            }
            Long l = dVar.f2513b;
            if (l == null) {
                fVar.I0(2);
            } else {
                fVar.h0(2, l.longValue());
            }
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }
    }

    public f(androidx.room.j jVar) {
        this.a = jVar;
        this.f2514b = new a(jVar);
    }

    @Override // androidx.work.impl.n.e
    public Long a(String str) {
        androidx.room.m mVarC = androidx.room.m.c("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            mVarC.I0(1);
        } else {
            mVarC.w(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Long lValueOf = null;
        Cursor cursorB = androidx.room.t.c.b(this.a, mVarC, false, null);
        try {
            if (cursorB.moveToFirst() && !cursorB.isNull(0)) {
                lValueOf = Long.valueOf(cursorB.getLong(0));
            }
            return lValueOf;
        } finally {
            cursorB.close();
            mVarC.f();
        }
    }

    @Override // androidx.work.impl.n.e
    public void b(d dVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.f2514b.insert(dVar);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }
}
