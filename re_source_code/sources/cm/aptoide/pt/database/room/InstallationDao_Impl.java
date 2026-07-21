package cm.aptoide.pt.database.room;

import android.database.Cursor;
import androidx.room.c;
import androidx.room.j;
import androidx.room.n;
import androidx.room.t.b;
import c.u.a.f;
import h.a.m;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class InstallationDao_Impl implements InstallationDao {
    private final j __db;
    private final c<RoomInstallation> __insertionAdapterOfRoomInstallation;

    public InstallationDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfRoomInstallation = new c<RoomInstallation>(jVar) { // from class: cm.aptoide.pt.database.room.InstallationDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `installation` (`packageName`,`icon`,`name`,`versionCode`,`versionName`) VALUES (?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, RoomInstallation roomInstallation) {
                if (roomInstallation.getPackageName() == null) {
                    fVar.I0(1);
                } else {
                    fVar.w(1, roomInstallation.getPackageName());
                }
                if (roomInstallation.getIcon() == null) {
                    fVar.I0(2);
                } else {
                    fVar.w(2, roomInstallation.getIcon());
                }
                if (roomInstallation.getName() == null) {
                    fVar.I0(3);
                } else {
                    fVar.w(3, roomInstallation.getName());
                }
                fVar.h0(4, roomInstallation.getVersionCode());
                if (roomInstallation.getVersionName() == null) {
                    fVar.I0(5);
                } else {
                    fVar.w(5, roomInstallation.getVersionName());
                }
            }
        };
    }

    @Override // cm.aptoide.pt.database.room.InstallationDao
    public m<List<RoomInstallation>> getAll() {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * FROM installation", 0);
        return n.a(this.__db, false, new String[]{"installation"}, new Callable<List<RoomInstallation>>() { // from class: cm.aptoide.pt.database.room.InstallationDao_Impl.2
            protected void finalize() {
                mVarC.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomInstallation> call() throws Exception {
                Cursor cursorB = androidx.room.t.c.b(InstallationDao_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, "packageName");
                    int iB2 = b.b(cursorB, RoomInstalled.ICON);
                    int iB3 = b.b(cursorB, "name");
                    int iB4 = b.b(cursorB, RoomInstalled.VERSION_CODE);
                    int iB5 = b.b(cursorB, RoomInstalled.VERSION_NAME);
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        arrayList.add(new RoomInstallation(cursorB.getString(iB), cursorB.getString(iB3), cursorB.getString(iB2), cursorB.getInt(iB4), cursorB.getString(iB5)));
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

    @Override // cm.aptoide.pt.database.room.InstallationDao
    public void insert(RoomInstallation roomInstallation) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomInstallation.insert(roomInstallation);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // cm.aptoide.pt.database.room.InstallationDao
    public void insertAll(List<RoomInstallation> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomInstallation.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
