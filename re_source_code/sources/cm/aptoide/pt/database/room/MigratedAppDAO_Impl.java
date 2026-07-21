package cm.aptoide.pt.database.room;

import android.database.Cursor;
import androidx.room.c;
import androidx.room.j;
import androidx.room.n;
import c.u.a.f;
import h.a.m;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class MigratedAppDAO_Impl implements MigratedAppDAO {
    private final j __db;
    private final c<RoomMigratedApp> __insertionAdapterOfRoomMigratedApp;

    public MigratedAppDAO_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfRoomMigratedApp = new c<RoomMigratedApp>(jVar) { // from class: cm.aptoide.pt.database.room.MigratedAppDAO_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `migratedapp` (`packageName`) VALUES (?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, RoomMigratedApp roomMigratedApp) {
                if (roomMigratedApp.getPackageName() == null) {
                    fVar.I0(1);
                } else {
                    fVar.w(1, roomMigratedApp.getPackageName());
                }
            }
        };
    }

    @Override // cm.aptoide.pt.database.room.MigratedAppDAO
    public m<Integer> isAppMigrated(String str) {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT COUNT(*) from migratedapp where packageName like ?", 1);
        if (str == null) {
            mVarC.I0(1);
        } else {
            mVarC.w(1, str);
        }
        return n.a(this.__db, false, new String[]{"migratedapp"}, new Callable<Integer>() { // from class: cm.aptoide.pt.database.room.MigratedAppDAO_Impl.2
            protected void finalize() {
                mVarC.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                Integer numValueOf = null;
                Cursor cursorB = androidx.room.t.c.b(MigratedAppDAO_Impl.this.__db, mVarC, false, null);
                try {
                    if (cursorB.moveToFirst() && !cursorB.isNull(0)) {
                        numValueOf = Integer.valueOf(cursorB.getInt(0));
                    }
                    return numValueOf;
                } finally {
                    cursorB.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.MigratedAppDAO
    public void save(RoomMigratedApp roomMigratedApp) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomMigratedApp.insert(roomMigratedApp);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
