package androidx.work.impl.n;

import android.database.Cursor;
import androidx.work.x;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: WorkSpecDao_Impl.java */
/* JADX INFO: loaded from: classes.dex */
public final class r implements q {
    private final androidx.room.j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.room.c<p> f2540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final androidx.room.q f2541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final androidx.room.q f2542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final androidx.room.q f2543e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final androidx.room.q f2544f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final androidx.room.q f2545g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final androidx.room.q f2546h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final androidx.room.q f2547i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final androidx.room.q f2548j;

    /* JADX INFO: compiled from: WorkSpecDao_Impl.java */
    class a extends androidx.room.c<p> {
        a(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(c.u.a.f fVar, p pVar) throws Throwable {
            String str = pVar.f2525c;
            if (str == null) {
                fVar.I0(1);
            } else {
                fVar.w(1, str);
            }
            fVar.h0(2, v.j(pVar.f2526d));
            String str2 = pVar.f2527e;
            if (str2 == null) {
                fVar.I0(3);
            } else {
                fVar.w(3, str2);
            }
            String str3 = pVar.f2528f;
            if (str3 == null) {
                fVar.I0(4);
            } else {
                fVar.w(4, str3);
            }
            byte[] bArrL = androidx.work.e.l(pVar.f2529g);
            if (bArrL == null) {
                fVar.I0(5);
            } else {
                fVar.o0(5, bArrL);
            }
            byte[] bArrL2 = androidx.work.e.l(pVar.f2530h);
            if (bArrL2 == null) {
                fVar.I0(6);
            } else {
                fVar.o0(6, bArrL2);
            }
            fVar.h0(7, pVar.f2531i);
            fVar.h0(8, pVar.f2532j);
            fVar.h0(9, pVar.f2533k);
            fVar.h0(10, pVar.m);
            fVar.h0(11, v.a(pVar.n));
            fVar.h0(12, pVar.o);
            fVar.h0(13, pVar.p);
            fVar.h0(14, pVar.q);
            fVar.h0(15, pVar.r);
            fVar.h0(16, pVar.s ? 1L : 0L);
            fVar.h0(17, v.i(pVar.t));
            androidx.work.c cVar = pVar.l;
            if (cVar == null) {
                fVar.I0(18);
                fVar.I0(19);
                fVar.I0(20);
                fVar.I0(21);
                fVar.I0(22);
                fVar.I0(23);
                fVar.I0(24);
                fVar.I0(25);
                return;
            }
            fVar.h0(18, v.h(cVar.b()));
            fVar.h0(19, cVar.g() ? 1L : 0L);
            fVar.h0(20, cVar.h() ? 1L : 0L);
            fVar.h0(21, cVar.f() ? 1L : 0L);
            fVar.h0(22, cVar.i() ? 1L : 0L);
            fVar.h0(23, cVar.c());
            fVar.h0(24, cVar.d());
            byte[] bArrC = v.c(cVar.a());
            if (bArrC == null) {
                fVar.I0(25);
            } else {
                fVar.o0(25, bArrC);
            }
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* JADX INFO: compiled from: WorkSpecDao_Impl.java */
    class b extends androidx.room.q {
        b(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    /* JADX INFO: compiled from: WorkSpecDao_Impl.java */
    class c extends androidx.room.q {
        c(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    /* JADX INFO: compiled from: WorkSpecDao_Impl.java */
    class d extends androidx.room.q {
        d(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }
    }

    /* JADX INFO: compiled from: WorkSpecDao_Impl.java */
    class e extends androidx.room.q {
        e(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    /* JADX INFO: compiled from: WorkSpecDao_Impl.java */
    class f extends androidx.room.q {
        f(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    /* JADX INFO: compiled from: WorkSpecDao_Impl.java */
    class g extends androidx.room.q {
        g(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    /* JADX INFO: compiled from: WorkSpecDao_Impl.java */
    class h extends androidx.room.q {
        h(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    /* JADX INFO: compiled from: WorkSpecDao_Impl.java */
    class i extends androidx.room.q {
        i(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    public r(androidx.room.j jVar) {
        this.a = jVar;
        this.f2540b = new a(jVar);
        this.f2541c = new b(jVar);
        this.f2542d = new c(jVar);
        this.f2543e = new d(jVar);
        this.f2544f = new e(jVar);
        this.f2545g = new f(jVar);
        this.f2546h = new g(jVar);
        this.f2547i = new h(jVar);
        this.f2548j = new i(jVar);
    }

    @Override // androidx.work.impl.n.q
    public int a(x.a aVar, String... strArr) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder sbB = androidx.room.t.f.b();
        sbB.append("UPDATE workspec SET state=");
        sbB.append("?");
        sbB.append(" WHERE id IN (");
        androidx.room.t.f.a(sbB, strArr.length);
        sbB.append(")");
        c.u.a.f fVarCompileStatement = this.a.compileStatement(sbB.toString());
        fVarCompileStatement.h0(1, v.j(aVar));
        int i2 = 2;
        for (String str : strArr) {
            if (str == null) {
                fVarCompileStatement.I0(i2);
            } else {
                fVarCompileStatement.w(i2, str);
            }
            i2++;
        }
        this.a.beginTransaction();
        try {
            int iE = fVarCompileStatement.E();
            this.a.setTransactionSuccessful();
            return iE;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // androidx.work.impl.n.q
    public int b(String str, long j2) {
        this.a.assertNotSuspendingTransaction();
        c.u.a.f fVarAcquire = this.f2546h.acquire();
        fVarAcquire.h0(1, j2);
        if (str == null) {
            fVarAcquire.I0(2);
        } else {
            fVarAcquire.w(2, str);
        }
        this.a.beginTransaction();
        try {
            int iE = fVarAcquire.E();
            this.a.setTransactionSuccessful();
            return iE;
        } finally {
            this.a.endTransaction();
            this.f2546h.release(fVarAcquire);
        }
    }

    @Override // androidx.work.impl.n.q
    public List<p.b> c(String str) {
        androidx.room.m mVarC = androidx.room.m.c("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            mVarC.I0(1);
        } else {
            mVarC.w(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = androidx.room.t.c.b(this.a, mVarC, false, null);
        try {
            int iB = androidx.room.t.b.b(cursorB, DeepLinkIntentReceiver.DeepLinksKeys.ID);
            int iB2 = androidx.room.t.b.b(cursorB, "state");
            ArrayList arrayList = new ArrayList(cursorB.getCount());
            while (cursorB.moveToNext()) {
                p.b bVar = new p.b();
                bVar.a = cursorB.getString(iB);
                bVar.f2534b = v.g(cursorB.getInt(iB2));
                arrayList.add(bVar);
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

    @Override // androidx.work.impl.n.q
    public List<p> d(long j2) throws Throwable {
        androidx.room.m mVar;
        androidx.room.m mVarC = androidx.room.m.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        mVarC.h0(1, j2);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = androidx.room.t.c.b(this.a, mVarC, false, null);
        try {
            int iB = androidx.room.t.b.b(cursorB, "required_network_type");
            int iB2 = androidx.room.t.b.b(cursorB, "requires_charging");
            int iB3 = androidx.room.t.b.b(cursorB, "requires_device_idle");
            int iB4 = androidx.room.t.b.b(cursorB, "requires_battery_not_low");
            int iB5 = androidx.room.t.b.b(cursorB, "requires_storage_not_low");
            int iB6 = androidx.room.t.b.b(cursorB, "trigger_content_update_delay");
            int iB7 = androidx.room.t.b.b(cursorB, "trigger_max_content_delay");
            int iB8 = androidx.room.t.b.b(cursorB, "content_uri_triggers");
            int iB9 = androidx.room.t.b.b(cursorB, DeepLinkIntentReceiver.DeepLinksKeys.ID);
            int iB10 = androidx.room.t.b.b(cursorB, "state");
            int iB11 = androidx.room.t.b.b(cursorB, "worker_class_name");
            int iB12 = androidx.room.t.b.b(cursorB, "input_merger_class_name");
            int iB13 = androidx.room.t.b.b(cursorB, "input");
            int iB14 = androidx.room.t.b.b(cursorB, "output");
            mVar = mVarC;
            try {
                int iB15 = androidx.room.t.b.b(cursorB, "initial_delay");
                int iB16 = androidx.room.t.b.b(cursorB, "interval_duration");
                int iB17 = androidx.room.t.b.b(cursorB, "flex_duration");
                int iB18 = androidx.room.t.b.b(cursorB, "run_attempt_count");
                int iB19 = androidx.room.t.b.b(cursorB, "backoff_policy");
                int iB20 = androidx.room.t.b.b(cursorB, "backoff_delay_duration");
                int iB21 = androidx.room.t.b.b(cursorB, "period_start_time");
                int iB22 = androidx.room.t.b.b(cursorB, "minimum_retention_duration");
                int iB23 = androidx.room.t.b.b(cursorB, "schedule_requested_at");
                int iB24 = androidx.room.t.b.b(cursorB, "run_in_foreground");
                int iB25 = androidx.room.t.b.b(cursorB, "out_of_quota_policy");
                int i2 = iB14;
                ArrayList arrayList = new ArrayList(cursorB.getCount());
                while (cursorB.moveToNext()) {
                    String string = cursorB.getString(iB9);
                    int i3 = iB9;
                    String string2 = cursorB.getString(iB11);
                    int i4 = iB11;
                    androidx.work.c cVar = new androidx.work.c();
                    int i5 = iB;
                    cVar.k(v.e(cursorB.getInt(iB)));
                    cVar.m(cursorB.getInt(iB2) != 0);
                    cVar.n(cursorB.getInt(iB3) != 0);
                    cVar.l(cursorB.getInt(iB4) != 0);
                    cVar.o(cursorB.getInt(iB5) != 0);
                    int i6 = iB2;
                    int i7 = iB3;
                    cVar.p(cursorB.getLong(iB6));
                    cVar.q(cursorB.getLong(iB7));
                    cVar.j(v.b(cursorB.getBlob(iB8)));
                    p pVar = new p(string, string2);
                    pVar.f2526d = v.g(cursorB.getInt(iB10));
                    pVar.f2528f = cursorB.getString(iB12);
                    pVar.f2529g = androidx.work.e.g(cursorB.getBlob(iB13));
                    int i8 = i2;
                    pVar.f2530h = androidx.work.e.g(cursorB.getBlob(i8));
                    int i9 = iB15;
                    i2 = i8;
                    pVar.f2531i = cursorB.getLong(i9);
                    int i10 = iB12;
                    int i11 = iB16;
                    pVar.f2532j = cursorB.getLong(i11);
                    int i12 = iB4;
                    int i13 = iB17;
                    pVar.f2533k = cursorB.getLong(i13);
                    int i14 = iB18;
                    pVar.m = cursorB.getInt(i14);
                    int i15 = iB19;
                    pVar.n = v.d(cursorB.getInt(i15));
                    iB17 = i13;
                    int i16 = iB20;
                    pVar.o = cursorB.getLong(i16);
                    int i17 = iB21;
                    pVar.p = cursorB.getLong(i17);
                    iB21 = i17;
                    int i18 = iB22;
                    pVar.q = cursorB.getLong(i18);
                    int i19 = iB23;
                    pVar.r = cursorB.getLong(i19);
                    int i20 = iB24;
                    pVar.s = cursorB.getInt(i20) != 0;
                    int i21 = iB25;
                    pVar.t = v.f(cursorB.getInt(i21));
                    pVar.l = cVar;
                    arrayList.add(pVar);
                    iB2 = i6;
                    iB25 = i21;
                    iB12 = i10;
                    iB15 = i9;
                    iB16 = i11;
                    iB18 = i14;
                    iB23 = i19;
                    iB9 = i3;
                    iB11 = i4;
                    iB = i5;
                    iB24 = i20;
                    iB22 = i18;
                    iB3 = i7;
                    iB20 = i16;
                    iB4 = i12;
                    iB19 = i15;
                }
                cursorB.close();
                mVar.f();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                mVar.f();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            mVar = mVarC;
        }
    }

    @Override // androidx.work.impl.n.q
    public void delete(String str) {
        this.a.assertNotSuspendingTransaction();
        c.u.a.f fVarAcquire = this.f2541c.acquire();
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
            this.f2541c.release(fVarAcquire);
        }
    }

    @Override // androidx.work.impl.n.q
    public List<p> e(int i2) throws Throwable {
        androidx.room.m mVar;
        androidx.room.m mVarC = androidx.room.m.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        mVarC.h0(1, i2);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = androidx.room.t.c.b(this.a, mVarC, false, null);
        try {
            int iB = androidx.room.t.b.b(cursorB, "required_network_type");
            int iB2 = androidx.room.t.b.b(cursorB, "requires_charging");
            int iB3 = androidx.room.t.b.b(cursorB, "requires_device_idle");
            int iB4 = androidx.room.t.b.b(cursorB, "requires_battery_not_low");
            int iB5 = androidx.room.t.b.b(cursorB, "requires_storage_not_low");
            int iB6 = androidx.room.t.b.b(cursorB, "trigger_content_update_delay");
            int iB7 = androidx.room.t.b.b(cursorB, "trigger_max_content_delay");
            int iB8 = androidx.room.t.b.b(cursorB, "content_uri_triggers");
            int iB9 = androidx.room.t.b.b(cursorB, DeepLinkIntentReceiver.DeepLinksKeys.ID);
            int iB10 = androidx.room.t.b.b(cursorB, "state");
            int iB11 = androidx.room.t.b.b(cursorB, "worker_class_name");
            int iB12 = androidx.room.t.b.b(cursorB, "input_merger_class_name");
            int iB13 = androidx.room.t.b.b(cursorB, "input");
            int iB14 = androidx.room.t.b.b(cursorB, "output");
            mVar = mVarC;
            try {
                int iB15 = androidx.room.t.b.b(cursorB, "initial_delay");
                int iB16 = androidx.room.t.b.b(cursorB, "interval_duration");
                int iB17 = androidx.room.t.b.b(cursorB, "flex_duration");
                int iB18 = androidx.room.t.b.b(cursorB, "run_attempt_count");
                int iB19 = androidx.room.t.b.b(cursorB, "backoff_policy");
                int iB20 = androidx.room.t.b.b(cursorB, "backoff_delay_duration");
                int iB21 = androidx.room.t.b.b(cursorB, "period_start_time");
                int iB22 = androidx.room.t.b.b(cursorB, "minimum_retention_duration");
                int iB23 = androidx.room.t.b.b(cursorB, "schedule_requested_at");
                int iB24 = androidx.room.t.b.b(cursorB, "run_in_foreground");
                int iB25 = androidx.room.t.b.b(cursorB, "out_of_quota_policy");
                int i3 = iB14;
                ArrayList arrayList = new ArrayList(cursorB.getCount());
                while (cursorB.moveToNext()) {
                    String string = cursorB.getString(iB9);
                    int i4 = iB9;
                    String string2 = cursorB.getString(iB11);
                    int i5 = iB11;
                    androidx.work.c cVar = new androidx.work.c();
                    int i6 = iB;
                    cVar.k(v.e(cursorB.getInt(iB)));
                    cVar.m(cursorB.getInt(iB2) != 0);
                    cVar.n(cursorB.getInt(iB3) != 0);
                    cVar.l(cursorB.getInt(iB4) != 0);
                    cVar.o(cursorB.getInt(iB5) != 0);
                    int i7 = iB2;
                    int i8 = iB3;
                    cVar.p(cursorB.getLong(iB6));
                    cVar.q(cursorB.getLong(iB7));
                    cVar.j(v.b(cursorB.getBlob(iB8)));
                    p pVar = new p(string, string2);
                    pVar.f2526d = v.g(cursorB.getInt(iB10));
                    pVar.f2528f = cursorB.getString(iB12);
                    pVar.f2529g = androidx.work.e.g(cursorB.getBlob(iB13));
                    int i9 = i3;
                    pVar.f2530h = androidx.work.e.g(cursorB.getBlob(i9));
                    i3 = i9;
                    int i10 = iB15;
                    pVar.f2531i = cursorB.getLong(i10);
                    int i11 = iB12;
                    int i12 = iB16;
                    pVar.f2532j = cursorB.getLong(i12);
                    int i13 = iB4;
                    int i14 = iB17;
                    pVar.f2533k = cursorB.getLong(i14);
                    int i15 = iB18;
                    pVar.m = cursorB.getInt(i15);
                    int i16 = iB19;
                    pVar.n = v.d(cursorB.getInt(i16));
                    iB17 = i14;
                    int i17 = iB20;
                    pVar.o = cursorB.getLong(i17);
                    int i18 = iB21;
                    pVar.p = cursorB.getLong(i18);
                    iB21 = i18;
                    int i19 = iB22;
                    pVar.q = cursorB.getLong(i19);
                    int i20 = iB23;
                    pVar.r = cursorB.getLong(i20);
                    int i21 = iB24;
                    pVar.s = cursorB.getInt(i21) != 0;
                    int i22 = iB25;
                    pVar.t = v.f(cursorB.getInt(i22));
                    pVar.l = cVar;
                    arrayList.add(pVar);
                    iB25 = i22;
                    iB2 = i7;
                    iB12 = i11;
                    iB15 = i10;
                    iB16 = i12;
                    iB18 = i15;
                    iB23 = i20;
                    iB9 = i4;
                    iB11 = i5;
                    iB = i6;
                    iB24 = i21;
                    iB22 = i19;
                    iB3 = i8;
                    iB20 = i17;
                    iB4 = i13;
                    iB19 = i16;
                }
                cursorB.close();
                mVar.f();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                mVar.f();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            mVar = mVarC;
        }
    }

    @Override // androidx.work.impl.n.q
    public void f(p pVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.f2540b.insert(pVar);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // androidx.work.impl.n.q
    public List<p> g() throws Throwable {
        androidx.room.m mVar;
        androidx.room.m mVarC = androidx.room.m.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = androidx.room.t.c.b(this.a, mVarC, false, null);
        try {
            int iB = androidx.room.t.b.b(cursorB, "required_network_type");
            int iB2 = androidx.room.t.b.b(cursorB, "requires_charging");
            int iB3 = androidx.room.t.b.b(cursorB, "requires_device_idle");
            int iB4 = androidx.room.t.b.b(cursorB, "requires_battery_not_low");
            int iB5 = androidx.room.t.b.b(cursorB, "requires_storage_not_low");
            int iB6 = androidx.room.t.b.b(cursorB, "trigger_content_update_delay");
            int iB7 = androidx.room.t.b.b(cursorB, "trigger_max_content_delay");
            int iB8 = androidx.room.t.b.b(cursorB, "content_uri_triggers");
            int iB9 = androidx.room.t.b.b(cursorB, DeepLinkIntentReceiver.DeepLinksKeys.ID);
            int iB10 = androidx.room.t.b.b(cursorB, "state");
            int iB11 = androidx.room.t.b.b(cursorB, "worker_class_name");
            int iB12 = androidx.room.t.b.b(cursorB, "input_merger_class_name");
            int iB13 = androidx.room.t.b.b(cursorB, "input");
            int iB14 = androidx.room.t.b.b(cursorB, "output");
            mVar = mVarC;
            try {
                int iB15 = androidx.room.t.b.b(cursorB, "initial_delay");
                int iB16 = androidx.room.t.b.b(cursorB, "interval_duration");
                int iB17 = androidx.room.t.b.b(cursorB, "flex_duration");
                int iB18 = androidx.room.t.b.b(cursorB, "run_attempt_count");
                int iB19 = androidx.room.t.b.b(cursorB, "backoff_policy");
                int iB20 = androidx.room.t.b.b(cursorB, "backoff_delay_duration");
                int iB21 = androidx.room.t.b.b(cursorB, "period_start_time");
                int iB22 = androidx.room.t.b.b(cursorB, "minimum_retention_duration");
                int iB23 = androidx.room.t.b.b(cursorB, "schedule_requested_at");
                int iB24 = androidx.room.t.b.b(cursorB, "run_in_foreground");
                int iB25 = androidx.room.t.b.b(cursorB, "out_of_quota_policy");
                int i2 = iB14;
                ArrayList arrayList = new ArrayList(cursorB.getCount());
                while (cursorB.moveToNext()) {
                    String string = cursorB.getString(iB9);
                    int i3 = iB9;
                    String string2 = cursorB.getString(iB11);
                    int i4 = iB11;
                    androidx.work.c cVar = new androidx.work.c();
                    int i5 = iB;
                    cVar.k(v.e(cursorB.getInt(iB)));
                    cVar.m(cursorB.getInt(iB2) != 0);
                    cVar.n(cursorB.getInt(iB3) != 0);
                    cVar.l(cursorB.getInt(iB4) != 0);
                    cVar.o(cursorB.getInt(iB5) != 0);
                    int i6 = iB2;
                    int i7 = iB3;
                    cVar.p(cursorB.getLong(iB6));
                    cVar.q(cursorB.getLong(iB7));
                    cVar.j(v.b(cursorB.getBlob(iB8)));
                    p pVar = new p(string, string2);
                    pVar.f2526d = v.g(cursorB.getInt(iB10));
                    pVar.f2528f = cursorB.getString(iB12);
                    pVar.f2529g = androidx.work.e.g(cursorB.getBlob(iB13));
                    int i8 = i2;
                    pVar.f2530h = androidx.work.e.g(cursorB.getBlob(i8));
                    i2 = i8;
                    int i9 = iB15;
                    pVar.f2531i = cursorB.getLong(i9);
                    int i10 = iB13;
                    int i11 = iB16;
                    pVar.f2532j = cursorB.getLong(i11);
                    int i12 = iB4;
                    int i13 = iB17;
                    pVar.f2533k = cursorB.getLong(i13);
                    int i14 = iB18;
                    pVar.m = cursorB.getInt(i14);
                    int i15 = iB19;
                    pVar.n = v.d(cursorB.getInt(i15));
                    iB17 = i13;
                    int i16 = iB20;
                    pVar.o = cursorB.getLong(i16);
                    int i17 = iB21;
                    pVar.p = cursorB.getLong(i17);
                    iB21 = i17;
                    int i18 = iB22;
                    pVar.q = cursorB.getLong(i18);
                    int i19 = iB23;
                    pVar.r = cursorB.getLong(i19);
                    int i20 = iB24;
                    pVar.s = cursorB.getInt(i20) != 0;
                    int i21 = iB25;
                    pVar.t = v.f(cursorB.getInt(i21));
                    pVar.l = cVar;
                    arrayList.add(pVar);
                    iB25 = i21;
                    iB2 = i6;
                    iB13 = i10;
                    iB15 = i9;
                    iB16 = i11;
                    iB18 = i14;
                    iB23 = i19;
                    iB9 = i3;
                    iB11 = i4;
                    iB = i5;
                    iB24 = i20;
                    iB22 = i18;
                    iB3 = i7;
                    iB20 = i16;
                    iB4 = i12;
                    iB19 = i15;
                }
                cursorB.close();
                mVar.f();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                mVar.f();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            mVar = mVarC;
        }
    }

    @Override // androidx.work.impl.n.q
    public void h(String str, androidx.work.e eVar) throws Throwable {
        this.a.assertNotSuspendingTransaction();
        c.u.a.f fVarAcquire = this.f2542d.acquire();
        byte[] bArrL = androidx.work.e.l(eVar);
        if (bArrL == null) {
            fVarAcquire.I0(1);
        } else {
            fVarAcquire.o0(1, bArrL);
        }
        if (str == null) {
            fVarAcquire.I0(2);
        } else {
            fVarAcquire.w(2, str);
        }
        this.a.beginTransaction();
        try {
            fVarAcquire.E();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f2542d.release(fVarAcquire);
        }
    }

    @Override // androidx.work.impl.n.q
    public List<p> i() throws Throwable {
        androidx.room.m mVar;
        androidx.room.m mVarC = androidx.room.m.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = androidx.room.t.c.b(this.a, mVarC, false, null);
        try {
            int iB = androidx.room.t.b.b(cursorB, "required_network_type");
            int iB2 = androidx.room.t.b.b(cursorB, "requires_charging");
            int iB3 = androidx.room.t.b.b(cursorB, "requires_device_idle");
            int iB4 = androidx.room.t.b.b(cursorB, "requires_battery_not_low");
            int iB5 = androidx.room.t.b.b(cursorB, "requires_storage_not_low");
            int iB6 = androidx.room.t.b.b(cursorB, "trigger_content_update_delay");
            int iB7 = androidx.room.t.b.b(cursorB, "trigger_max_content_delay");
            int iB8 = androidx.room.t.b.b(cursorB, "content_uri_triggers");
            int iB9 = androidx.room.t.b.b(cursorB, DeepLinkIntentReceiver.DeepLinksKeys.ID);
            int iB10 = androidx.room.t.b.b(cursorB, "state");
            int iB11 = androidx.room.t.b.b(cursorB, "worker_class_name");
            int iB12 = androidx.room.t.b.b(cursorB, "input_merger_class_name");
            int iB13 = androidx.room.t.b.b(cursorB, "input");
            int iB14 = androidx.room.t.b.b(cursorB, "output");
            mVar = mVarC;
            try {
                int iB15 = androidx.room.t.b.b(cursorB, "initial_delay");
                int iB16 = androidx.room.t.b.b(cursorB, "interval_duration");
                int iB17 = androidx.room.t.b.b(cursorB, "flex_duration");
                int iB18 = androidx.room.t.b.b(cursorB, "run_attempt_count");
                int iB19 = androidx.room.t.b.b(cursorB, "backoff_policy");
                int iB20 = androidx.room.t.b.b(cursorB, "backoff_delay_duration");
                int iB21 = androidx.room.t.b.b(cursorB, "period_start_time");
                int iB22 = androidx.room.t.b.b(cursorB, "minimum_retention_duration");
                int iB23 = androidx.room.t.b.b(cursorB, "schedule_requested_at");
                int iB24 = androidx.room.t.b.b(cursorB, "run_in_foreground");
                int iB25 = androidx.room.t.b.b(cursorB, "out_of_quota_policy");
                int i2 = iB14;
                ArrayList arrayList = new ArrayList(cursorB.getCount());
                while (cursorB.moveToNext()) {
                    String string = cursorB.getString(iB9);
                    int i3 = iB9;
                    String string2 = cursorB.getString(iB11);
                    int i4 = iB11;
                    androidx.work.c cVar = new androidx.work.c();
                    int i5 = iB;
                    cVar.k(v.e(cursorB.getInt(iB)));
                    cVar.m(cursorB.getInt(iB2) != 0);
                    cVar.n(cursorB.getInt(iB3) != 0);
                    cVar.l(cursorB.getInt(iB4) != 0);
                    cVar.o(cursorB.getInt(iB5) != 0);
                    int i6 = iB2;
                    int i7 = iB3;
                    cVar.p(cursorB.getLong(iB6));
                    cVar.q(cursorB.getLong(iB7));
                    cVar.j(v.b(cursorB.getBlob(iB8)));
                    p pVar = new p(string, string2);
                    pVar.f2526d = v.g(cursorB.getInt(iB10));
                    pVar.f2528f = cursorB.getString(iB12);
                    pVar.f2529g = androidx.work.e.g(cursorB.getBlob(iB13));
                    int i8 = i2;
                    pVar.f2530h = androidx.work.e.g(cursorB.getBlob(i8));
                    i2 = i8;
                    int i9 = iB15;
                    pVar.f2531i = cursorB.getLong(i9);
                    int i10 = iB13;
                    int i11 = iB16;
                    pVar.f2532j = cursorB.getLong(i11);
                    int i12 = iB4;
                    int i13 = iB17;
                    pVar.f2533k = cursorB.getLong(i13);
                    int i14 = iB18;
                    pVar.m = cursorB.getInt(i14);
                    int i15 = iB19;
                    pVar.n = v.d(cursorB.getInt(i15));
                    iB17 = i13;
                    int i16 = iB20;
                    pVar.o = cursorB.getLong(i16);
                    int i17 = iB21;
                    pVar.p = cursorB.getLong(i17);
                    iB21 = i17;
                    int i18 = iB22;
                    pVar.q = cursorB.getLong(i18);
                    int i19 = iB23;
                    pVar.r = cursorB.getLong(i19);
                    int i20 = iB24;
                    pVar.s = cursorB.getInt(i20) != 0;
                    int i21 = iB25;
                    pVar.t = v.f(cursorB.getInt(i21));
                    pVar.l = cVar;
                    arrayList.add(pVar);
                    iB25 = i21;
                    iB2 = i6;
                    iB13 = i10;
                    iB15 = i9;
                    iB16 = i11;
                    iB18 = i14;
                    iB23 = i19;
                    iB9 = i3;
                    iB11 = i4;
                    iB = i5;
                    iB24 = i20;
                    iB22 = i18;
                    iB3 = i7;
                    iB20 = i16;
                    iB4 = i12;
                    iB19 = i15;
                }
                cursorB.close();
                mVar.f();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                mVar.f();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            mVar = mVarC;
        }
    }

    @Override // androidx.work.impl.n.q
    public boolean j() {
        boolean z = false;
        androidx.room.m mVarC = androidx.room.m.c("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = androidx.room.t.c.b(this.a, mVarC, false, null);
        try {
            if (cursorB.moveToFirst() && cursorB.getInt(0) != 0) {
                z = true;
            }
            return z;
        } finally {
            cursorB.close();
            mVarC.f();
        }
    }

    @Override // androidx.work.impl.n.q
    public List<String> k(String str) {
        androidx.room.m mVarC = androidx.room.m.c("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
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

    @Override // androidx.work.impl.n.q
    public x.a l(String str) {
        androidx.room.m mVarC = androidx.room.m.c("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            mVarC.I0(1);
        } else {
            mVarC.w(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = androidx.room.t.c.b(this.a, mVarC, false, null);
        try {
            return cursorB.moveToFirst() ? v.g(cursorB.getInt(0)) : null;
        } finally {
            cursorB.close();
            mVarC.f();
        }
    }

    @Override // androidx.work.impl.n.q
    public p m(String str) throws Throwable {
        androidx.room.m mVar;
        p pVar;
        androidx.room.m mVarC = androidx.room.m.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?", 1);
        if (str == null) {
            mVarC.I0(1);
        } else {
            mVarC.w(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = androidx.room.t.c.b(this.a, mVarC, false, null);
        try {
            int iB = androidx.room.t.b.b(cursorB, "required_network_type");
            int iB2 = androidx.room.t.b.b(cursorB, "requires_charging");
            int iB3 = androidx.room.t.b.b(cursorB, "requires_device_idle");
            int iB4 = androidx.room.t.b.b(cursorB, "requires_battery_not_low");
            int iB5 = androidx.room.t.b.b(cursorB, "requires_storage_not_low");
            int iB6 = androidx.room.t.b.b(cursorB, "trigger_content_update_delay");
            int iB7 = androidx.room.t.b.b(cursorB, "trigger_max_content_delay");
            int iB8 = androidx.room.t.b.b(cursorB, "content_uri_triggers");
            int iB9 = androidx.room.t.b.b(cursorB, DeepLinkIntentReceiver.DeepLinksKeys.ID);
            int iB10 = androidx.room.t.b.b(cursorB, "state");
            int iB11 = androidx.room.t.b.b(cursorB, "worker_class_name");
            int iB12 = androidx.room.t.b.b(cursorB, "input_merger_class_name");
            int iB13 = androidx.room.t.b.b(cursorB, "input");
            int iB14 = androidx.room.t.b.b(cursorB, "output");
            mVar = mVarC;
            try {
                int iB15 = androidx.room.t.b.b(cursorB, "initial_delay");
                int iB16 = androidx.room.t.b.b(cursorB, "interval_duration");
                int iB17 = androidx.room.t.b.b(cursorB, "flex_duration");
                int iB18 = androidx.room.t.b.b(cursorB, "run_attempt_count");
                int iB19 = androidx.room.t.b.b(cursorB, "backoff_policy");
                int iB20 = androidx.room.t.b.b(cursorB, "backoff_delay_duration");
                int iB21 = androidx.room.t.b.b(cursorB, "period_start_time");
                int iB22 = androidx.room.t.b.b(cursorB, "minimum_retention_duration");
                int iB23 = androidx.room.t.b.b(cursorB, "schedule_requested_at");
                int iB24 = androidx.room.t.b.b(cursorB, "run_in_foreground");
                int iB25 = androidx.room.t.b.b(cursorB, "out_of_quota_policy");
                if (cursorB.moveToFirst()) {
                    String string = cursorB.getString(iB9);
                    String string2 = cursorB.getString(iB11);
                    androidx.work.c cVar = new androidx.work.c();
                    cVar.k(v.e(cursorB.getInt(iB)));
                    cVar.m(cursorB.getInt(iB2) != 0);
                    cVar.n(cursorB.getInt(iB3) != 0);
                    cVar.l(cursorB.getInt(iB4) != 0);
                    cVar.o(cursorB.getInt(iB5) != 0);
                    cVar.p(cursorB.getLong(iB6));
                    cVar.q(cursorB.getLong(iB7));
                    cVar.j(v.b(cursorB.getBlob(iB8)));
                    p pVar2 = new p(string, string2);
                    pVar2.f2526d = v.g(cursorB.getInt(iB10));
                    pVar2.f2528f = cursorB.getString(iB12);
                    pVar2.f2529g = androidx.work.e.g(cursorB.getBlob(iB13));
                    pVar2.f2530h = androidx.work.e.g(cursorB.getBlob(iB14));
                    pVar2.f2531i = cursorB.getLong(iB15);
                    pVar2.f2532j = cursorB.getLong(iB16);
                    pVar2.f2533k = cursorB.getLong(iB17);
                    pVar2.m = cursorB.getInt(iB18);
                    pVar2.n = v.d(cursorB.getInt(iB19));
                    pVar2.o = cursorB.getLong(iB20);
                    pVar2.p = cursorB.getLong(iB21);
                    pVar2.q = cursorB.getLong(iB22);
                    pVar2.r = cursorB.getLong(iB23);
                    pVar2.s = cursorB.getInt(iB24) != 0;
                    pVar2.t = v.f(cursorB.getInt(iB25));
                    pVar2.l = cVar;
                    pVar = pVar2;
                } else {
                    pVar = null;
                }
                cursorB.close();
                mVar.f();
                return pVar;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                mVar.f();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            mVar = mVarC;
        }
    }

    @Override // androidx.work.impl.n.q
    public int n(String str) {
        this.a.assertNotSuspendingTransaction();
        c.u.a.f fVarAcquire = this.f2545g.acquire();
        if (str == null) {
            fVarAcquire.I0(1);
        } else {
            fVarAcquire.w(1, str);
        }
        this.a.beginTransaction();
        try {
            int iE = fVarAcquire.E();
            this.a.setTransactionSuccessful();
            return iE;
        } finally {
            this.a.endTransaction();
            this.f2545g.release(fVarAcquire);
        }
    }

    @Override // androidx.work.impl.n.q
    public List<String> o(String str) {
        androidx.room.m mVarC = androidx.room.m.c("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
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

    @Override // androidx.work.impl.n.q
    public List<androidx.work.e> p(String str) {
        androidx.room.m mVarC = androidx.room.m.c("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
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
                arrayList.add(androidx.work.e.g(cursorB.getBlob(0)));
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

    @Override // androidx.work.impl.n.q
    public int q(String str) {
        this.a.assertNotSuspendingTransaction();
        c.u.a.f fVarAcquire = this.f2544f.acquire();
        if (str == null) {
            fVarAcquire.I0(1);
        } else {
            fVarAcquire.w(1, str);
        }
        this.a.beginTransaction();
        try {
            int iE = fVarAcquire.E();
            this.a.setTransactionSuccessful();
            return iE;
        } finally {
            this.a.endTransaction();
            this.f2544f.release(fVarAcquire);
        }
    }

    @Override // androidx.work.impl.n.q
    public void r(String str, long j2) {
        this.a.assertNotSuspendingTransaction();
        c.u.a.f fVarAcquire = this.f2543e.acquire();
        fVarAcquire.h0(1, j2);
        if (str == null) {
            fVarAcquire.I0(2);
        } else {
            fVarAcquire.w(2, str);
        }
        this.a.beginTransaction();
        try {
            fVarAcquire.E();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f2543e.release(fVarAcquire);
        }
    }

    @Override // androidx.work.impl.n.q
    public List<p> s(int i2) throws Throwable {
        androidx.room.m mVar;
        androidx.room.m mVarC = androidx.room.m.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        mVarC.h0(1, i2);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorB = androidx.room.t.c.b(this.a, mVarC, false, null);
        try {
            int iB = androidx.room.t.b.b(cursorB, "required_network_type");
            int iB2 = androidx.room.t.b.b(cursorB, "requires_charging");
            int iB3 = androidx.room.t.b.b(cursorB, "requires_device_idle");
            int iB4 = androidx.room.t.b.b(cursorB, "requires_battery_not_low");
            int iB5 = androidx.room.t.b.b(cursorB, "requires_storage_not_low");
            int iB6 = androidx.room.t.b.b(cursorB, "trigger_content_update_delay");
            int iB7 = androidx.room.t.b.b(cursorB, "trigger_max_content_delay");
            int iB8 = androidx.room.t.b.b(cursorB, "content_uri_triggers");
            int iB9 = androidx.room.t.b.b(cursorB, DeepLinkIntentReceiver.DeepLinksKeys.ID);
            int iB10 = androidx.room.t.b.b(cursorB, "state");
            int iB11 = androidx.room.t.b.b(cursorB, "worker_class_name");
            int iB12 = androidx.room.t.b.b(cursorB, "input_merger_class_name");
            int iB13 = androidx.room.t.b.b(cursorB, "input");
            int iB14 = androidx.room.t.b.b(cursorB, "output");
            mVar = mVarC;
            try {
                int iB15 = androidx.room.t.b.b(cursorB, "initial_delay");
                int iB16 = androidx.room.t.b.b(cursorB, "interval_duration");
                int iB17 = androidx.room.t.b.b(cursorB, "flex_duration");
                int iB18 = androidx.room.t.b.b(cursorB, "run_attempt_count");
                int iB19 = androidx.room.t.b.b(cursorB, "backoff_policy");
                int iB20 = androidx.room.t.b.b(cursorB, "backoff_delay_duration");
                int iB21 = androidx.room.t.b.b(cursorB, "period_start_time");
                int iB22 = androidx.room.t.b.b(cursorB, "minimum_retention_duration");
                int iB23 = androidx.room.t.b.b(cursorB, "schedule_requested_at");
                int iB24 = androidx.room.t.b.b(cursorB, "run_in_foreground");
                int iB25 = androidx.room.t.b.b(cursorB, "out_of_quota_policy");
                int i3 = iB14;
                ArrayList arrayList = new ArrayList(cursorB.getCount());
                while (cursorB.moveToNext()) {
                    String string = cursorB.getString(iB9);
                    int i4 = iB9;
                    String string2 = cursorB.getString(iB11);
                    int i5 = iB11;
                    androidx.work.c cVar = new androidx.work.c();
                    int i6 = iB;
                    cVar.k(v.e(cursorB.getInt(iB)));
                    cVar.m(cursorB.getInt(iB2) != 0);
                    cVar.n(cursorB.getInt(iB3) != 0);
                    cVar.l(cursorB.getInt(iB4) != 0);
                    cVar.o(cursorB.getInt(iB5) != 0);
                    int i7 = iB2;
                    int i8 = iB3;
                    cVar.p(cursorB.getLong(iB6));
                    cVar.q(cursorB.getLong(iB7));
                    cVar.j(v.b(cursorB.getBlob(iB8)));
                    p pVar = new p(string, string2);
                    pVar.f2526d = v.g(cursorB.getInt(iB10));
                    pVar.f2528f = cursorB.getString(iB12);
                    pVar.f2529g = androidx.work.e.g(cursorB.getBlob(iB13));
                    int i9 = i3;
                    pVar.f2530h = androidx.work.e.g(cursorB.getBlob(i9));
                    i3 = i9;
                    int i10 = iB15;
                    pVar.f2531i = cursorB.getLong(i10);
                    int i11 = iB12;
                    int i12 = iB16;
                    pVar.f2532j = cursorB.getLong(i12);
                    int i13 = iB4;
                    int i14 = iB17;
                    pVar.f2533k = cursorB.getLong(i14);
                    int i15 = iB18;
                    pVar.m = cursorB.getInt(i15);
                    int i16 = iB19;
                    pVar.n = v.d(cursorB.getInt(i16));
                    iB17 = i14;
                    int i17 = iB20;
                    pVar.o = cursorB.getLong(i17);
                    int i18 = iB21;
                    pVar.p = cursorB.getLong(i18);
                    iB21 = i18;
                    int i19 = iB22;
                    pVar.q = cursorB.getLong(i19);
                    int i20 = iB23;
                    pVar.r = cursorB.getLong(i20);
                    int i21 = iB24;
                    pVar.s = cursorB.getInt(i21) != 0;
                    int i22 = iB25;
                    pVar.t = v.f(cursorB.getInt(i22));
                    pVar.l = cVar;
                    arrayList.add(pVar);
                    iB25 = i22;
                    iB2 = i7;
                    iB12 = i11;
                    iB15 = i10;
                    iB16 = i12;
                    iB18 = i15;
                    iB23 = i20;
                    iB9 = i4;
                    iB11 = i5;
                    iB = i6;
                    iB24 = i21;
                    iB22 = i19;
                    iB3 = i8;
                    iB20 = i17;
                    iB4 = i13;
                    iB19 = i16;
                }
                cursorB.close();
                mVar.f();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                mVar.f();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            mVar = mVarC;
        }
    }

    @Override // androidx.work.impl.n.q
    public int t() {
        this.a.assertNotSuspendingTransaction();
        c.u.a.f fVarAcquire = this.f2547i.acquire();
        this.a.beginTransaction();
        try {
            int iE = fVarAcquire.E();
            this.a.setTransactionSuccessful();
            return iE;
        } finally {
            this.a.endTransaction();
            this.f2547i.release(fVarAcquire);
        }
    }
}
