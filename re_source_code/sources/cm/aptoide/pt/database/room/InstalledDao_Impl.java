package cm.aptoide.pt.database.room;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.c;
import androidx.room.j;
import androidx.room.n;
import androidx.room.q;
import androidx.room.t.b;
import c.u.a.f;
import h.a.m;
import h.a.s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class InstalledDao_Impl implements InstalledDao {
    private final j __db;
    private final c<RoomInstalled> __insertionAdapterOfRoomInstalled;
    private final q __preparedStmtOfRemove;
    private final q __preparedStmtOfRemoveAll;
    private final q __preparedStmtOfRemove_1;

    public InstalledDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfRoomInstalled = new c<RoomInstalled>(jVar) { // from class: cm.aptoide.pt.database.room.InstalledDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `installed` (`packageAndVersionCode`,`icon`,`packageName`,`name`,`versionCode`,`versionName`,`signature`,`systemApp`,`storeName`,`status`,`type`,`enabled`,`appSize`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, RoomInstalled roomInstalled) {
                if (roomInstalled.getPackageAndVersionCode() == null) {
                    fVar.I0(1);
                } else {
                    fVar.w(1, roomInstalled.getPackageAndVersionCode());
                }
                if (roomInstalled.getIcon() == null) {
                    fVar.I0(2);
                } else {
                    fVar.w(2, roomInstalled.getIcon());
                }
                if (roomInstalled.getPackageName() == null) {
                    fVar.I0(3);
                } else {
                    fVar.w(3, roomInstalled.getPackageName());
                }
                if (roomInstalled.getName() == null) {
                    fVar.I0(4);
                } else {
                    fVar.w(4, roomInstalled.getName());
                }
                fVar.h0(5, roomInstalled.getVersionCode());
                if (roomInstalled.getVersionName() == null) {
                    fVar.I0(6);
                } else {
                    fVar.w(6, roomInstalled.getVersionName());
                }
                if (roomInstalled.getSignature() == null) {
                    fVar.I0(7);
                } else {
                    fVar.w(7, roomInstalled.getSignature());
                }
                fVar.h0(8, roomInstalled.isSystemApp() ? 1L : 0L);
                if (roomInstalled.getStoreName() == null) {
                    fVar.I0(9);
                } else {
                    fVar.w(9, roomInstalled.getStoreName());
                }
                fVar.h0(10, roomInstalled.getStatus());
                fVar.h0(11, roomInstalled.getType());
                fVar.h0(12, roomInstalled.isEnabled() ? 1L : 0L);
                fVar.h0(13, roomInstalled.getAppSize().longValue());
            }
        };
        this.__preparedStmtOfRemove = new q(jVar) { // from class: cm.aptoide.pt.database.room.InstalledDao_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "DELETE FROM Installed where packageName = ? AND versionCode = ?";
            }
        };
        this.__preparedStmtOfRemove_1 = new q(jVar) { // from class: cm.aptoide.pt.database.room.InstalledDao_Impl.3
            @Override // androidx.room.q
            public String createQuery() {
                return "DELETE FROM Installed where packageName = ? ";
            }
        };
        this.__preparedStmtOfRemoveAll = new q(jVar) { // from class: cm.aptoide.pt.database.room.InstalledDao_Impl.4
            @Override // androidx.room.q
            public String createQuery() {
                return "DELETE FROM installed";
            }
        };
    }

    @Override // cm.aptoide.pt.database.room.InstalledDao
    public m<RoomInstalled> get(String str, int i2) {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * FROM Installed where packageName = ? AND versionCode = ? LIMIT 1", 2);
        if (str == null) {
            mVarC.I0(1);
        } else {
            mVarC.w(1, str);
        }
        mVarC.h0(2, i2);
        return n.a(this.__db, false, new String[]{"Installed"}, new Callable<RoomInstalled>() { // from class: cm.aptoide.pt.database.room.InstalledDao_Impl.9
            protected void finalize() {
                mVarC.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RoomInstalled call() throws Exception {
                RoomInstalled roomInstalled = null;
                Cursor cursorB = androidx.room.t.c.b(InstalledDao_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, "packageAndVersionCode");
                    int iB2 = b.b(cursorB, RoomInstalled.ICON);
                    int iB3 = b.b(cursorB, "packageName");
                    int iB4 = b.b(cursorB, "name");
                    int iB5 = b.b(cursorB, RoomInstalled.VERSION_CODE);
                    int iB6 = b.b(cursorB, RoomInstalled.VERSION_NAME);
                    int iB7 = b.b(cursorB, RoomInstalled.SIGNATURE);
                    int iB8 = b.b(cursorB, "systemApp");
                    int iB9 = b.b(cursorB, "storeName");
                    int iB10 = b.b(cursorB, "status");
                    int iB11 = b.b(cursorB, "type");
                    int iB12 = b.b(cursorB, "enabled");
                    int iB13 = b.b(cursorB, "appSize");
                    if (cursorB.moveToFirst()) {
                        roomInstalled = new RoomInstalled();
                        roomInstalled.setPackageAndVersionCode(cursorB.getString(iB));
                        roomInstalled.setIcon(cursorB.getString(iB2));
                        roomInstalled.setPackageName(cursorB.getString(iB3));
                        roomInstalled.setName(cursorB.getString(iB4));
                        roomInstalled.setVersionCode(cursorB.getInt(iB5));
                        roomInstalled.setVersionName(cursorB.getString(iB6));
                        roomInstalled.setSignature(cursorB.getString(iB7));
                        boolean z = true;
                        roomInstalled.setSystemApp(cursorB.getInt(iB8) != 0);
                        roomInstalled.setStoreName(cursorB.getString(iB9));
                        roomInstalled.setStatus(cursorB.getInt(iB10));
                        roomInstalled.setType(cursorB.getInt(iB11));
                        if (cursorB.getInt(iB12) == 0) {
                            z = false;
                        }
                        roomInstalled.setEnabled(z);
                        roomInstalled.setAppSize(Long.valueOf(cursorB.getLong(iB13)));
                    }
                    return roomInstalled;
                } finally {
                    cursorB.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.InstalledDao
    public m<List<RoomInstalled>> getAll() {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * FROM Installed", 0);
        return n.a(this.__db, false, new String[]{"Installed"}, new Callable<List<RoomInstalled>>() { // from class: cm.aptoide.pt.database.room.InstalledDao_Impl.7
            protected void finalize() {
                mVarC.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomInstalled> call() throws Exception {
                Cursor cursorB = androidx.room.t.c.b(InstalledDao_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, "packageAndVersionCode");
                    int iB2 = b.b(cursorB, RoomInstalled.ICON);
                    int iB3 = b.b(cursorB, "packageName");
                    int iB4 = b.b(cursorB, "name");
                    int iB5 = b.b(cursorB, RoomInstalled.VERSION_CODE);
                    int iB6 = b.b(cursorB, RoomInstalled.VERSION_NAME);
                    int iB7 = b.b(cursorB, RoomInstalled.SIGNATURE);
                    int iB8 = b.b(cursorB, "systemApp");
                    int iB9 = b.b(cursorB, "storeName");
                    int iB10 = b.b(cursorB, "status");
                    int iB11 = b.b(cursorB, "type");
                    int iB12 = b.b(cursorB, "enabled");
                    int iB13 = b.b(cursorB, "appSize");
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        RoomInstalled roomInstalled = new RoomInstalled();
                        ArrayList arrayList2 = arrayList;
                        roomInstalled.setPackageAndVersionCode(cursorB.getString(iB));
                        roomInstalled.setIcon(cursorB.getString(iB2));
                        roomInstalled.setPackageName(cursorB.getString(iB3));
                        roomInstalled.setName(cursorB.getString(iB4));
                        roomInstalled.setVersionCode(cursorB.getInt(iB5));
                        roomInstalled.setVersionName(cursorB.getString(iB6));
                        roomInstalled.setSignature(cursorB.getString(iB7));
                        roomInstalled.setSystemApp(cursorB.getInt(iB8) != 0);
                        roomInstalled.setStoreName(cursorB.getString(iB9));
                        roomInstalled.setStatus(cursorB.getInt(iB10));
                        roomInstalled.setType(cursorB.getInt(iB11));
                        roomInstalled.setEnabled(cursorB.getInt(iB12) != 0);
                        roomInstalled.setAppSize(Long.valueOf(cursorB.getLong(iB13)));
                        arrayList = arrayList2;
                        arrayList.add(roomInstalled);
                    }
                    cursorB.close();
                    return arrayList;
                } catch (Throwable th) {
                    cursorB.close();
                    throw th;
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.InstalledDao
    public m<List<RoomInstalled>> getAllFilteringSystemApps() {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * FROM Installed where systemApp = 0 ORDER BY name ASC", 0);
        return n.a(this.__db, false, new String[]{"Installed"}, new Callable<List<RoomInstalled>>() { // from class: cm.aptoide.pt.database.room.InstalledDao_Impl.13
            protected void finalize() {
                mVarC.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomInstalled> call() throws Exception {
                Cursor cursorB = androidx.room.t.c.b(InstalledDao_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, "packageAndVersionCode");
                    int iB2 = b.b(cursorB, RoomInstalled.ICON);
                    int iB3 = b.b(cursorB, "packageName");
                    int iB4 = b.b(cursorB, "name");
                    int iB5 = b.b(cursorB, RoomInstalled.VERSION_CODE);
                    int iB6 = b.b(cursorB, RoomInstalled.VERSION_NAME);
                    int iB7 = b.b(cursorB, RoomInstalled.SIGNATURE);
                    int iB8 = b.b(cursorB, "systemApp");
                    int iB9 = b.b(cursorB, "storeName");
                    int iB10 = b.b(cursorB, "status");
                    int iB11 = b.b(cursorB, "type");
                    int iB12 = b.b(cursorB, "enabled");
                    int iB13 = b.b(cursorB, "appSize");
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        RoomInstalled roomInstalled = new RoomInstalled();
                        ArrayList arrayList2 = arrayList;
                        roomInstalled.setPackageAndVersionCode(cursorB.getString(iB));
                        roomInstalled.setIcon(cursorB.getString(iB2));
                        roomInstalled.setPackageName(cursorB.getString(iB3));
                        roomInstalled.setName(cursorB.getString(iB4));
                        roomInstalled.setVersionCode(cursorB.getInt(iB5));
                        roomInstalled.setVersionName(cursorB.getString(iB6));
                        roomInstalled.setSignature(cursorB.getString(iB7));
                        roomInstalled.setSystemApp(cursorB.getInt(iB8) != 0);
                        roomInstalled.setStoreName(cursorB.getString(iB9));
                        roomInstalled.setStatus(cursorB.getInt(iB10));
                        roomInstalled.setType(cursorB.getInt(iB11));
                        roomInstalled.setEnabled(cursorB.getInt(iB12) != 0);
                        roomInstalled.setAppSize(Long.valueOf(cursorB.getLong(iB13)));
                        arrayList = arrayList2;
                        arrayList.add(roomInstalled);
                    }
                    cursorB.close();
                    return arrayList;
                } catch (Throwable th) {
                    cursorB.close();
                    throw th;
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.InstalledDao
    public m<List<RoomInstalled>> getAllSortedAsc() {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * FROM Installed ORDER BY name ASC", 0);
        return n.a(this.__db, false, new String[]{"Installed"}, new Callable<List<RoomInstalled>>() { // from class: cm.aptoide.pt.database.room.InstalledDao_Impl.8
            protected void finalize() {
                mVarC.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomInstalled> call() throws Exception {
                Cursor cursorB = androidx.room.t.c.b(InstalledDao_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, "packageAndVersionCode");
                    int iB2 = b.b(cursorB, RoomInstalled.ICON);
                    int iB3 = b.b(cursorB, "packageName");
                    int iB4 = b.b(cursorB, "name");
                    int iB5 = b.b(cursorB, RoomInstalled.VERSION_CODE);
                    int iB6 = b.b(cursorB, RoomInstalled.VERSION_NAME);
                    int iB7 = b.b(cursorB, RoomInstalled.SIGNATURE);
                    int iB8 = b.b(cursorB, "systemApp");
                    int iB9 = b.b(cursorB, "storeName");
                    int iB10 = b.b(cursorB, "status");
                    int iB11 = b.b(cursorB, "type");
                    int iB12 = b.b(cursorB, "enabled");
                    int iB13 = b.b(cursorB, "appSize");
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        RoomInstalled roomInstalled = new RoomInstalled();
                        ArrayList arrayList2 = arrayList;
                        roomInstalled.setPackageAndVersionCode(cursorB.getString(iB));
                        roomInstalled.setIcon(cursorB.getString(iB2));
                        roomInstalled.setPackageName(cursorB.getString(iB3));
                        roomInstalled.setName(cursorB.getString(iB4));
                        roomInstalled.setVersionCode(cursorB.getInt(iB5));
                        roomInstalled.setVersionName(cursorB.getString(iB6));
                        roomInstalled.setSignature(cursorB.getString(iB7));
                        roomInstalled.setSystemApp(cursorB.getInt(iB8) != 0);
                        roomInstalled.setStoreName(cursorB.getString(iB9));
                        roomInstalled.setStatus(cursorB.getInt(iB10));
                        roomInstalled.setType(cursorB.getInt(iB11));
                        roomInstalled.setEnabled(cursorB.getInt(iB12) != 0);
                        roomInstalled.setAppSize(Long.valueOf(cursorB.getLong(iB13)));
                        arrayList = arrayList2;
                        arrayList.add(roomInstalled);
                    }
                    cursorB.close();
                    return arrayList;
                } catch (Throwable th) {
                    cursorB.close();
                    throw th;
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.InstalledDao
    public m<List<RoomInstalled>> getAsList(String str, int i2) {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * FROM Installed where packageName = ? AND versionCode = ?", 2);
        if (str == null) {
            mVarC.I0(1);
        } else {
            mVarC.w(1, str);
        }
        mVarC.h0(2, i2);
        return n.a(this.__db, false, new String[]{"Installed"}, new Callable<List<RoomInstalled>>() { // from class: cm.aptoide.pt.database.room.InstalledDao_Impl.10
            protected void finalize() {
                mVarC.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomInstalled> call() throws Exception {
                Cursor cursorB = androidx.room.t.c.b(InstalledDao_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, "packageAndVersionCode");
                    int iB2 = b.b(cursorB, RoomInstalled.ICON);
                    int iB3 = b.b(cursorB, "packageName");
                    int iB4 = b.b(cursorB, "name");
                    int iB5 = b.b(cursorB, RoomInstalled.VERSION_CODE);
                    int iB6 = b.b(cursorB, RoomInstalled.VERSION_NAME);
                    int iB7 = b.b(cursorB, RoomInstalled.SIGNATURE);
                    int iB8 = b.b(cursorB, "systemApp");
                    int iB9 = b.b(cursorB, "storeName");
                    int iB10 = b.b(cursorB, "status");
                    int iB11 = b.b(cursorB, "type");
                    int iB12 = b.b(cursorB, "enabled");
                    int iB13 = b.b(cursorB, "appSize");
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        RoomInstalled roomInstalled = new RoomInstalled();
                        ArrayList arrayList2 = arrayList;
                        roomInstalled.setPackageAndVersionCode(cursorB.getString(iB));
                        roomInstalled.setIcon(cursorB.getString(iB2));
                        roomInstalled.setPackageName(cursorB.getString(iB3));
                        roomInstalled.setName(cursorB.getString(iB4));
                        roomInstalled.setVersionCode(cursorB.getInt(iB5));
                        roomInstalled.setVersionName(cursorB.getString(iB6));
                        roomInstalled.setSignature(cursorB.getString(iB7));
                        roomInstalled.setSystemApp(cursorB.getInt(iB8) != 0);
                        roomInstalled.setStoreName(cursorB.getString(iB9));
                        roomInstalled.setStatus(cursorB.getInt(iB10));
                        roomInstalled.setType(cursorB.getInt(iB11));
                        roomInstalled.setEnabled(cursorB.getInt(iB12) != 0);
                        roomInstalled.setAppSize(Long.valueOf(cursorB.getLong(iB13)));
                        arrayList = arrayList2;
                        arrayList.add(roomInstalled);
                    }
                    cursorB.close();
                    return arrayList;
                } catch (Throwable th) {
                    cursorB.close();
                    throw th;
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.InstalledDao
    public m<List<RoomInstalled>> getAsListByPackageName(String str) {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * FROM Installed where packageName = ?", 1);
        if (str == null) {
            mVarC.I0(1);
        } else {
            mVarC.w(1, str);
        }
        return n.a(this.__db, false, new String[]{"Installed"}, new Callable<List<RoomInstalled>>() { // from class: cm.aptoide.pt.database.room.InstalledDao_Impl.11
            protected void finalize() {
                mVarC.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomInstalled> call() throws Exception {
                Cursor cursorB = androidx.room.t.c.b(InstalledDao_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, "packageAndVersionCode");
                    int iB2 = b.b(cursorB, RoomInstalled.ICON);
                    int iB3 = b.b(cursorB, "packageName");
                    int iB4 = b.b(cursorB, "name");
                    int iB5 = b.b(cursorB, RoomInstalled.VERSION_CODE);
                    int iB6 = b.b(cursorB, RoomInstalled.VERSION_NAME);
                    int iB7 = b.b(cursorB, RoomInstalled.SIGNATURE);
                    int iB8 = b.b(cursorB, "systemApp");
                    int iB9 = b.b(cursorB, "storeName");
                    int iB10 = b.b(cursorB, "status");
                    int iB11 = b.b(cursorB, "type");
                    int iB12 = b.b(cursorB, "enabled");
                    int iB13 = b.b(cursorB, "appSize");
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        RoomInstalled roomInstalled = new RoomInstalled();
                        ArrayList arrayList2 = arrayList;
                        roomInstalled.setPackageAndVersionCode(cursorB.getString(iB));
                        roomInstalled.setIcon(cursorB.getString(iB2));
                        roomInstalled.setPackageName(cursorB.getString(iB3));
                        roomInstalled.setName(cursorB.getString(iB4));
                        roomInstalled.setVersionCode(cursorB.getInt(iB5));
                        roomInstalled.setVersionName(cursorB.getString(iB6));
                        roomInstalled.setSignature(cursorB.getString(iB7));
                        roomInstalled.setSystemApp(cursorB.getInt(iB8) != 0);
                        roomInstalled.setStoreName(cursorB.getString(iB9));
                        roomInstalled.setStatus(cursorB.getInt(iB10));
                        roomInstalled.setType(cursorB.getInt(iB11));
                        roomInstalled.setEnabled(cursorB.getInt(iB12) != 0);
                        roomInstalled.setAppSize(Long.valueOf(cursorB.getLong(iB13)));
                        arrayList = arrayList2;
                        arrayList.add(roomInstalled);
                    }
                    cursorB.close();
                    return arrayList;
                } catch (Throwable th) {
                    cursorB.close();
                    throw th;
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.InstalledDao
    public void insert(RoomInstalled roomInstalled) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomInstalled.insert(roomInstalled);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // cm.aptoide.pt.database.room.InstalledDao
    public void insertAll(List<RoomInstalled> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomInstalled.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // cm.aptoide.pt.database.room.InstalledDao
    public s<RoomInstalled> isInstalledByVersion(String str, int i2) {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * FROM installed where packageName = ? AND versionCode = ?", 2);
        if (str == null) {
            mVarC.I0(1);
        } else {
            mVarC.w(1, str);
        }
        mVarC.h0(2, i2);
        return n.c(new Callable<RoomInstalled>() { // from class: cm.aptoide.pt.database.room.InstalledDao_Impl.12
            protected void finalize() {
                mVarC.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RoomInstalled call() throws Exception {
                RoomInstalled roomInstalled = null;
                Cursor cursorB = androidx.room.t.c.b(InstalledDao_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, "packageAndVersionCode");
                    int iB2 = b.b(cursorB, RoomInstalled.ICON);
                    int iB3 = b.b(cursorB, "packageName");
                    int iB4 = b.b(cursorB, "name");
                    int iB5 = b.b(cursorB, RoomInstalled.VERSION_CODE);
                    int iB6 = b.b(cursorB, RoomInstalled.VERSION_NAME);
                    int iB7 = b.b(cursorB, RoomInstalled.SIGNATURE);
                    int iB8 = b.b(cursorB, "systemApp");
                    int iB9 = b.b(cursorB, "storeName");
                    int iB10 = b.b(cursorB, "status");
                    int iB11 = b.b(cursorB, "type");
                    int iB12 = b.b(cursorB, "enabled");
                    int iB13 = b.b(cursorB, "appSize");
                    if (cursorB.moveToFirst()) {
                        roomInstalled = new RoomInstalled();
                        roomInstalled.setPackageAndVersionCode(cursorB.getString(iB));
                        roomInstalled.setIcon(cursorB.getString(iB2));
                        roomInstalled.setPackageName(cursorB.getString(iB3));
                        roomInstalled.setName(cursorB.getString(iB4));
                        roomInstalled.setVersionCode(cursorB.getInt(iB5));
                        roomInstalled.setVersionName(cursorB.getString(iB6));
                        roomInstalled.setSignature(cursorB.getString(iB7));
                        boolean z = true;
                        roomInstalled.setSystemApp(cursorB.getInt(iB8) != 0);
                        roomInstalled.setStoreName(cursorB.getString(iB9));
                        roomInstalled.setStatus(cursorB.getInt(iB10));
                        roomInstalled.setType(cursorB.getInt(iB11));
                        if (cursorB.getInt(iB12) == 0) {
                            z = false;
                        }
                        roomInstalled.setEnabled(z);
                        roomInstalled.setAppSize(Long.valueOf(cursorB.getLong(iB13)));
                    }
                    if (roomInstalled != null) {
                        cursorB.close();
                        return roomInstalled;
                    }
                    throw new EmptyResultSetException("Query returned empty result set: " + mVarC.a());
                } catch (Throwable th) {
                    cursorB.close();
                    throw th;
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.InstalledDao
    public h.a.b remove(final String str, final int i2) {
        return h.a.b.d(new Callable<Void>() { // from class: cm.aptoide.pt.database.room.InstalledDao_Impl.5
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                f fVarAcquire = InstalledDao_Impl.this.__preparedStmtOfRemove.acquire();
                String str2 = str;
                if (str2 == null) {
                    fVarAcquire.I0(1);
                } else {
                    fVarAcquire.w(1, str2);
                }
                fVarAcquire.h0(2, i2);
                InstalledDao_Impl.this.__db.beginTransaction();
                try {
                    fVarAcquire.E();
                    InstalledDao_Impl.this.__db.setTransactionSuccessful();
                    return null;
                } finally {
                    InstalledDao_Impl.this.__db.endTransaction();
                    InstalledDao_Impl.this.__preparedStmtOfRemove.release(fVarAcquire);
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.InstalledDao
    public void removeAll() {
        this.__db.assertNotSuspendingTransaction();
        f fVarAcquire = this.__preparedStmtOfRemoveAll.acquire();
        this.__db.beginTransaction();
        try {
            fVarAcquire.E();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfRemoveAll.release(fVarAcquire);
        }
    }

    @Override // cm.aptoide.pt.database.room.InstalledDao
    public h.a.b remove(final String str) {
        return h.a.b.d(new Callable<Void>() { // from class: cm.aptoide.pt.database.room.InstalledDao_Impl.6
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                f fVarAcquire = InstalledDao_Impl.this.__preparedStmtOfRemove_1.acquire();
                String str2 = str;
                if (str2 == null) {
                    fVarAcquire.I0(1);
                } else {
                    fVarAcquire.w(1, str2);
                }
                InstalledDao_Impl.this.__db.beginTransaction();
                try {
                    fVarAcquire.E();
                    InstalledDao_Impl.this.__db.setTransactionSuccessful();
                    return null;
                } finally {
                    InstalledDao_Impl.this.__db.endTransaction();
                    InstalledDao_Impl.this.__preparedStmtOfRemove_1.release(fVarAcquire);
                }
            }
        });
    }
}
