package cm.aptoide.pt.database.room;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.n;
import androidx.room.t.b;
import c.u.a.f;
import h.a.s;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class AptoideInstallDao_Impl implements AptoideInstallDao {
    private final j __db;
    private final c<RoomAptoideInstallApp> __insertionAdapterOfRoomAptoideInstallApp;

    public AptoideInstallDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfRoomAptoideInstallApp = new c<RoomAptoideInstallApp>(jVar) { // from class: cm.aptoide.pt.database.room.AptoideInstallDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `aptoideinstallapp` (`packageName`) VALUES (?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, RoomAptoideInstallApp roomAptoideInstallApp) {
                if (roomAptoideInstallApp.getPackageName() == null) {
                    fVar.I0(1);
                } else {
                    fVar.w(1, roomAptoideInstallApp.getPackageName());
                }
            }
        };
    }

    @Override // cm.aptoide.pt.database.room.AptoideInstallDao
    public s<RoomAptoideInstallApp> get(String str) {
        final m mVarC = m.c("SELECT * from aptoideinstallapp where packageName = ? LIMIT 1", 1);
        if (str == null) {
            mVarC.I0(1);
        } else {
            mVarC.w(1, str);
        }
        return n.c(new Callable<RoomAptoideInstallApp>() { // from class: cm.aptoide.pt.database.room.AptoideInstallDao_Impl.2
            protected void finalize() {
                mVarC.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RoomAptoideInstallApp call() throws Exception {
                Cursor cursorB = androidx.room.t.c.b(AptoideInstallDao_Impl.this.__db, mVarC, false, null);
                try {
                    RoomAptoideInstallApp roomAptoideInstallApp = cursorB.moveToFirst() ? new RoomAptoideInstallApp(cursorB.getString(b.b(cursorB, "packageName"))) : null;
                    if (roomAptoideInstallApp != null) {
                        cursorB.close();
                        return roomAptoideInstallApp;
                    }
                    throw new EmptyResultSetException("Query returned empty result set: " + mVarC.a());
                } catch (Throwable th) {
                    cursorB.close();
                    throw th;
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.AptoideInstallDao
    public void insert(RoomAptoideInstallApp roomAptoideInstallApp) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomAptoideInstallApp.insert(roomAptoideInstallApp);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
