package androidx.work.impl;

import android.os.Build;
import androidx.room.l;
import androidx.work.impl.n.n;
import androidx.work.impl.n.o;
import androidx.work.impl.n.q;
import androidx.work.impl.n.r;
import androidx.work.impl.n.t;
import androidx.work.impl.n.u;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.database.room.RoomNotification;
import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile q f2339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile androidx.work.impl.n.b f2340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile t f2341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile androidx.work.impl.n.h f2342e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile androidx.work.impl.n.k f2343f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile n f2344g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile androidx.work.impl.n.e f2345h;

    class a extends l.a {
        a(int i2) {
            super(i2);
        }

        @Override // androidx.room.l.a
        public void createAllTables(c.u.a.b bVar) {
            bVar.v("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.v("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
            bVar.v("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
            bVar.v("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
            bVar.v("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
            bVar.v("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
            bVar.v("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.v("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
            bVar.v("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.v("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.v("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
            bVar.v("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.v("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            bVar.v("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            bVar.v("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
        }

        @Override // androidx.room.l.a
        public void dropAllTables(c.u.a.b bVar) {
            bVar.v("DROP TABLE IF EXISTS `Dependency`");
            bVar.v("DROP TABLE IF EXISTS `WorkSpec`");
            bVar.v("DROP TABLE IF EXISTS `WorkTag`");
            bVar.v("DROP TABLE IF EXISTS `SystemIdInfo`");
            bVar.v("DROP TABLE IF EXISTS `WorkName`");
            bVar.v("DROP TABLE IF EXISTS `WorkProgress`");
            bVar.v("DROP TABLE IF EXISTS `Preference`");
            if (((androidx.room.j) WorkDatabase_Impl.this).mCallbacks != null) {
                int size = ((androidx.room.j) WorkDatabase_Impl.this).mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((androidx.room.j.b) ((androidx.room.j) WorkDatabase_Impl.this).mCallbacks.get(i2)).b(bVar);
                }
            }
        }

        @Override // androidx.room.l.a
        protected void onCreate(c.u.a.b bVar) {
            if (((androidx.room.j) WorkDatabase_Impl.this).mCallbacks != null) {
                int size = ((androidx.room.j) WorkDatabase_Impl.this).mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((androidx.room.j.b) ((androidx.room.j) WorkDatabase_Impl.this).mCallbacks.get(i2)).a(bVar);
                }
            }
        }

        @Override // androidx.room.l.a
        public void onOpen(c.u.a.b bVar) {
            ((androidx.room.j) WorkDatabase_Impl.this).mDatabase = bVar;
            bVar.v("PRAGMA foreign_keys = ON");
            WorkDatabase_Impl.this.internalInitInvalidationTracker(bVar);
            if (((androidx.room.j) WorkDatabase_Impl.this).mCallbacks != null) {
                int size = ((androidx.room.j) WorkDatabase_Impl.this).mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((androidx.room.j.b) ((androidx.room.j) WorkDatabase_Impl.this).mCallbacks.get(i2)).c(bVar);
                }
            }
        }

        @Override // androidx.room.l.a
        public void onPostMigrate(c.u.a.b bVar) {
        }

        @Override // androidx.room.l.a
        public void onPreMigrate(c.u.a.b bVar) {
            androidx.room.t.c.a(bVar);
        }

        @Override // androidx.room.l.a
        protected l.b onValidateSchema(c.u.a.b bVar) {
            HashMap map = new HashMap(2);
            map.put("work_spec_id", new androidx.room.t.g.a("work_spec_id", "TEXT", true, 1, null, 1));
            map.put("prerequisite_id", new androidx.room.t.g.a("prerequisite_id", "TEXT", true, 2, null, 1));
            HashSet hashSet = new HashSet(2);
            hashSet.add(new androidx.room.t.g.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(DeepLinkIntentReceiver.DeepLinksKeys.ID)));
            hashSet.add(new androidx.room.t.g.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList(DeepLinkIntentReceiver.DeepLinksKeys.ID)));
            HashSet hashSet2 = new HashSet(2);
            hashSet2.add(new androidx.room.t.g.d("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id")));
            hashSet2.add(new androidx.room.t.g.d("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id")));
            androidx.room.t.g gVar = new androidx.room.t.g("Dependency", map, hashSet, hashSet2);
            androidx.room.t.g gVarA = androidx.room.t.g.a(bVar, "Dependency");
            if (!gVar.equals(gVarA)) {
                return new l.b(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + gVar + "\n Found:\n" + gVarA);
            }
            HashMap map2 = new HashMap(25);
            map2.put(DeepLinkIntentReceiver.DeepLinksKeys.ID, new androidx.room.t.g.a(DeepLinkIntentReceiver.DeepLinksKeys.ID, "TEXT", true, 1, null, 1));
            map2.put("state", new androidx.room.t.g.a("state", "INTEGER", true, 0, null, 1));
            map2.put("worker_class_name", new androidx.room.t.g.a("worker_class_name", "TEXT", true, 0, null, 1));
            map2.put("input_merger_class_name", new androidx.room.t.g.a("input_merger_class_name", "TEXT", false, 0, null, 1));
            map2.put("input", new androidx.room.t.g.a("input", "BLOB", true, 0, null, 1));
            map2.put("output", new androidx.room.t.g.a("output", "BLOB", true, 0, null, 1));
            map2.put("initial_delay", new androidx.room.t.g.a("initial_delay", "INTEGER", true, 0, null, 1));
            map2.put("interval_duration", new androidx.room.t.g.a("interval_duration", "INTEGER", true, 0, null, 1));
            map2.put("flex_duration", new androidx.room.t.g.a("flex_duration", "INTEGER", true, 0, null, 1));
            map2.put("run_attempt_count", new androidx.room.t.g.a("run_attempt_count", "INTEGER", true, 0, null, 1));
            map2.put("backoff_policy", new androidx.room.t.g.a("backoff_policy", "INTEGER", true, 0, null, 1));
            map2.put("backoff_delay_duration", new androidx.room.t.g.a("backoff_delay_duration", "INTEGER", true, 0, null, 1));
            map2.put("period_start_time", new androidx.room.t.g.a("period_start_time", "INTEGER", true, 0, null, 1));
            map2.put("minimum_retention_duration", new androidx.room.t.g.a("minimum_retention_duration", "INTEGER", true, 0, null, 1));
            map2.put("schedule_requested_at", new androidx.room.t.g.a("schedule_requested_at", "INTEGER", true, 0, null, 1));
            map2.put("run_in_foreground", new androidx.room.t.g.a("run_in_foreground", "INTEGER", true, 0, null, 1));
            map2.put("out_of_quota_policy", new androidx.room.t.g.a("out_of_quota_policy", "INTEGER", true, 0, null, 1));
            map2.put("required_network_type", new androidx.room.t.g.a("required_network_type", "INTEGER", false, 0, null, 1));
            map2.put("requires_charging", new androidx.room.t.g.a("requires_charging", "INTEGER", true, 0, null, 1));
            map2.put("requires_device_idle", new androidx.room.t.g.a("requires_device_idle", "INTEGER", true, 0, null, 1));
            map2.put("requires_battery_not_low", new androidx.room.t.g.a("requires_battery_not_low", "INTEGER", true, 0, null, 1));
            map2.put("requires_storage_not_low", new androidx.room.t.g.a("requires_storage_not_low", "INTEGER", true, 0, null, 1));
            map2.put("trigger_content_update_delay", new androidx.room.t.g.a("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
            map2.put("trigger_max_content_delay", new androidx.room.t.g.a("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
            map2.put("content_uri_triggers", new androidx.room.t.g.a("content_uri_triggers", "BLOB", false, 0, null, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(2);
            hashSet4.add(new androidx.room.t.g.d("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at")));
            hashSet4.add(new androidx.room.t.g.d("index_WorkSpec_period_start_time", false, Arrays.asList("period_start_time")));
            androidx.room.t.g gVar2 = new androidx.room.t.g("WorkSpec", map2, hashSet3, hashSet4);
            androidx.room.t.g gVarA2 = androidx.room.t.g.a(bVar, "WorkSpec");
            if (!gVar2.equals(gVarA2)) {
                return new l.b(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + gVar2 + "\n Found:\n" + gVarA2);
            }
            HashMap map3 = new HashMap(2);
            map3.put(StoreTabGridRecyclerFragment.BundleCons.TAG, new androidx.room.t.g.a(StoreTabGridRecyclerFragment.BundleCons.TAG, "TEXT", true, 1, null, 1));
            map3.put("work_spec_id", new androidx.room.t.g.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet5 = new HashSet(1);
            hashSet5.add(new androidx.room.t.g.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(DeepLinkIntentReceiver.DeepLinksKeys.ID)));
            HashSet hashSet6 = new HashSet(1);
            hashSet6.add(new androidx.room.t.g.d("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id")));
            androidx.room.t.g gVar3 = new androidx.room.t.g("WorkTag", map3, hashSet5, hashSet6);
            androidx.room.t.g gVarA3 = androidx.room.t.g.a(bVar, "WorkTag");
            if (!gVar3.equals(gVarA3)) {
                return new l.b(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + gVar3 + "\n Found:\n" + gVarA3);
            }
            HashMap map4 = new HashMap(2);
            map4.put("work_spec_id", new androidx.room.t.g.a("work_spec_id", "TEXT", true, 1, null, 1));
            map4.put("system_id", new androidx.room.t.g.a("system_id", "INTEGER", true, 0, null, 1));
            HashSet hashSet7 = new HashSet(1);
            hashSet7.add(new androidx.room.t.g.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(DeepLinkIntentReceiver.DeepLinksKeys.ID)));
            androidx.room.t.g gVar4 = new androidx.room.t.g("SystemIdInfo", map4, hashSet7, new HashSet(0));
            androidx.room.t.g gVarA4 = androidx.room.t.g.a(bVar, "SystemIdInfo");
            if (!gVar4.equals(gVarA4)) {
                return new l.b(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + gVar4 + "\n Found:\n" + gVarA4);
            }
            HashMap map5 = new HashMap(2);
            map5.put("name", new androidx.room.t.g.a("name", "TEXT", true, 1, null, 1));
            map5.put("work_spec_id", new androidx.room.t.g.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet8 = new HashSet(1);
            hashSet8.add(new androidx.room.t.g.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(DeepLinkIntentReceiver.DeepLinksKeys.ID)));
            HashSet hashSet9 = new HashSet(1);
            hashSet9.add(new androidx.room.t.g.d("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id")));
            androidx.room.t.g gVar5 = new androidx.room.t.g("WorkName", map5, hashSet8, hashSet9);
            androidx.room.t.g gVarA5 = androidx.room.t.g.a(bVar, "WorkName");
            if (!gVar5.equals(gVarA5)) {
                return new l.b(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + gVar5 + "\n Found:\n" + gVarA5);
            }
            HashMap map6 = new HashMap(2);
            map6.put("work_spec_id", new androidx.room.t.g.a("work_spec_id", "TEXT", true, 1, null, 1));
            map6.put("progress", new androidx.room.t.g.a("progress", "BLOB", true, 0, null, 1));
            HashSet hashSet10 = new HashSet(1);
            hashSet10.add(new androidx.room.t.g.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(DeepLinkIntentReceiver.DeepLinksKeys.ID)));
            androidx.room.t.g gVar6 = new androidx.room.t.g("WorkProgress", map6, hashSet10, new HashSet(0));
            androidx.room.t.g gVarA6 = androidx.room.t.g.a(bVar, "WorkProgress");
            if (!gVar6.equals(gVarA6)) {
                return new l.b(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + gVar6 + "\n Found:\n" + gVarA6);
            }
            HashMap map7 = new HashMap(2);
            map7.put(RoomNotification.KEY, new androidx.room.t.g.a(RoomNotification.KEY, "TEXT", true, 1, null, 1));
            map7.put("long_value", new androidx.room.t.g.a("long_value", "INTEGER", false, 0, null, 1));
            androidx.room.t.g gVar7 = new androidx.room.t.g("Preference", map7, new HashSet(0), new HashSet(0));
            androidx.room.t.g gVarA7 = androidx.room.t.g.a(bVar, "Preference");
            if (gVar7.equals(gVarA7)) {
                return new l.b(true, null);
            }
            return new l.b(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + gVar7 + "\n Found:\n" + gVarA7);
        }
    }

    @Override // androidx.work.impl.WorkDatabase
    public androidx.work.impl.n.b b() {
        androidx.work.impl.n.b bVar;
        if (this.f2340c != null) {
            return this.f2340c;
        }
        synchronized (this) {
            if (this.f2340c == null) {
                this.f2340c = new androidx.work.impl.n.c(this);
            }
            bVar = this.f2340c;
        }
        return bVar;
    }

    @Override // androidx.room.j
    public void clearAllTables() {
        super.assertNotMainThread();
        c.u.a.b bVarS0 = super.getOpenHelper().s0();
        boolean z = Build.VERSION.SDK_INT >= 21;
        if (!z) {
            try {
                bVarS0.v("PRAGMA foreign_keys = FALSE");
            } finally {
                super.endTransaction();
                if (!z) {
                    bVarS0.v("PRAGMA foreign_keys = TRUE");
                }
                bVarS0.u0("PRAGMA wal_checkpoint(FULL)").close();
                if (!bVarS0.P0()) {
                    bVarS0.v("VACUUM");
                }
            }
        }
        super.beginTransaction();
        if (z) {
            bVarS0.v("PRAGMA defer_foreign_keys = TRUE");
        }
        bVarS0.v("DELETE FROM `Dependency`");
        bVarS0.v("DELETE FROM `WorkSpec`");
        bVarS0.v("DELETE FROM `WorkTag`");
        bVarS0.v("DELETE FROM `SystemIdInfo`");
        bVarS0.v("DELETE FROM `WorkName`");
        bVarS0.v("DELETE FROM `WorkProgress`");
        bVarS0.v("DELETE FROM `Preference`");
        super.setTransactionSuccessful();
    }

    @Override // androidx.room.j
    protected androidx.room.g createInvalidationTracker() {
        return new androidx.room.g(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // androidx.room.j
    protected c.u.a.c createOpenHelper(androidx.room.a aVar) {
        return aVar.a.a(c.u.a.c.b.a(aVar.f2117b).c(aVar.f2118c).b(new l(aVar, new a(12), "c103703e120ae8cc73c9248622f3cd1e", "49f946663a8deb7054212b8adda248c6")).a());
    }

    @Override // androidx.work.impl.WorkDatabase
    public androidx.work.impl.n.e f() {
        androidx.work.impl.n.e eVar;
        if (this.f2345h != null) {
            return this.f2345h;
        }
        synchronized (this) {
            if (this.f2345h == null) {
                this.f2345h = new androidx.work.impl.n.f(this);
            }
            eVar = this.f2345h;
        }
        return eVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public androidx.work.impl.n.h g() {
        androidx.work.impl.n.h hVar;
        if (this.f2342e != null) {
            return this.f2342e;
        }
        synchronized (this) {
            if (this.f2342e == null) {
                this.f2342e = new androidx.work.impl.n.i(this);
            }
            hVar = this.f2342e;
        }
        return hVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public androidx.work.impl.n.k h() {
        androidx.work.impl.n.k kVar;
        if (this.f2343f != null) {
            return this.f2343f;
        }
        synchronized (this) {
            if (this.f2343f == null) {
                this.f2343f = new androidx.work.impl.n.l(this);
            }
            kVar = this.f2343f;
        }
        return kVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public n i() {
        n nVar;
        if (this.f2344g != null) {
            return this.f2344g;
        }
        synchronized (this) {
            if (this.f2344g == null) {
                this.f2344g = new o(this);
            }
            nVar = this.f2344g;
        }
        return nVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public q j() {
        q qVar;
        if (this.f2339b != null) {
            return this.f2339b;
        }
        synchronized (this) {
            if (this.f2339b == null) {
                this.f2339b = new r(this);
            }
            qVar = this.f2339b;
        }
        return qVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public t k() {
        t tVar;
        if (this.f2341d != null) {
            return this.f2341d;
        }
        synchronized (this) {
            if (this.f2341d == null) {
                this.f2341d = new u(this);
            }
            tVar = this.f2341d;
        }
        return tVar;
    }
}
