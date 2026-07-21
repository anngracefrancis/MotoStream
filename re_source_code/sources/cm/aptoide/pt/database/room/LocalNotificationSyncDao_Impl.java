package cm.aptoide.pt.database.room;

import android.database.Cursor;
import androidx.room.c;
import androidx.room.j;
import androidx.room.n;
import androidx.room.q;
import androidx.room.t.b;
import c.u.a.f;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import h.a.m;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class LocalNotificationSyncDao_Impl implements LocalNotificationSyncDao {
    private final j __db;
    private final c<RoomLocalNotificationSync> __insertionAdapterOfRoomLocalNotificationSync;
    private final q __preparedStmtOfDelete;

    public LocalNotificationSyncDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfRoomLocalNotificationSync = new c<RoomLocalNotificationSync>(jVar) { // from class: cm.aptoide.pt.database.room.LocalNotificationSyncDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `localNotificationSync` (`notificationId`,`title`,`body`,`image`,`navigationUrl`,`trigger`,`id`,`actionStringRes`,`type`) VALUES (?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, RoomLocalNotificationSync roomLocalNotificationSync) {
                if (roomLocalNotificationSync.getNotificationId() == null) {
                    fVar.I0(1);
                } else {
                    fVar.w(1, roomLocalNotificationSync.getNotificationId());
                }
                if (roomLocalNotificationSync.getTitle() == null) {
                    fVar.I0(2);
                } else {
                    fVar.w(2, roomLocalNotificationSync.getTitle());
                }
                if (roomLocalNotificationSync.getBody() == null) {
                    fVar.I0(3);
                } else {
                    fVar.w(3, roomLocalNotificationSync.getBody());
                }
                if (roomLocalNotificationSync.getImage() == null) {
                    fVar.I0(4);
                } else {
                    fVar.w(4, roomLocalNotificationSync.getImage());
                }
                if (roomLocalNotificationSync.getNavigationUrl() == null) {
                    fVar.I0(5);
                } else {
                    fVar.w(5, roomLocalNotificationSync.getNavigationUrl());
                }
                fVar.h0(6, roomLocalNotificationSync.getTrigger());
                if (roomLocalNotificationSync.getId() == null) {
                    fVar.I0(7);
                } else {
                    fVar.w(7, roomLocalNotificationSync.getId());
                }
                fVar.h0(8, roomLocalNotificationSync.getActionStringRes());
                fVar.h0(9, roomLocalNotificationSync.getType());
            }
        };
        this.__preparedStmtOfDelete = new q(jVar) { // from class: cm.aptoide.pt.database.room.LocalNotificationSyncDao_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "DELETE FROM localNotificationSync WHERE notificationId = ?";
            }
        };
    }

    @Override // cm.aptoide.pt.database.room.LocalNotificationSyncDao
    public void delete(String str) {
        this.__db.assertNotSuspendingTransaction();
        f fVarAcquire = this.__preparedStmtOfDelete.acquire();
        if (str == null) {
            fVarAcquire.I0(1);
        } else {
            fVarAcquire.w(1, str);
        }
        this.__db.beginTransaction();
        try {
            fVarAcquire.E();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDelete.release(fVarAcquire);
        }
    }

    @Override // cm.aptoide.pt.database.room.LocalNotificationSyncDao
    public m<RoomLocalNotificationSync> get(String str) {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * FROM localNotificationSync WHERE notificationId = ?", 1);
        if (str == null) {
            mVarC.I0(1);
        } else {
            mVarC.w(1, str);
        }
        return n.a(this.__db, false, new String[]{"localNotificationSync"}, new Callable<RoomLocalNotificationSync>() { // from class: cm.aptoide.pt.database.room.LocalNotificationSyncDao_Impl.3
            protected void finalize() {
                mVarC.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RoomLocalNotificationSync call() throws Exception {
                RoomLocalNotificationSync roomLocalNotificationSync = null;
                Cursor cursorB = androidx.room.t.c.b(LocalNotificationSyncDao_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, "notificationId");
                    int iB2 = b.b(cursorB, "title");
                    int iB3 = b.b(cursorB, "body");
                    int iB4 = b.b(cursorB, "image");
                    int iB5 = b.b(cursorB, "navigationUrl");
                    int iB6 = b.b(cursorB, "trigger");
                    int iB7 = b.b(cursorB, DeepLinkIntentReceiver.DeepLinksKeys.ID);
                    int iB8 = b.b(cursorB, "actionStringRes");
                    int iB9 = b.b(cursorB, "type");
                    if (cursorB.moveToFirst()) {
                        roomLocalNotificationSync = new RoomLocalNotificationSync(cursorB.getString(iB), cursorB.getString(iB2), cursorB.getString(iB3), cursorB.getString(iB4), cursorB.getInt(iB8), cursorB.getString(iB5), cursorB.getLong(iB6), cursorB.getString(iB7), cursorB.getInt(iB9));
                    }
                    return roomLocalNotificationSync;
                } finally {
                    cursorB.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.LocalNotificationSyncDao
    public void save(RoomLocalNotificationSync roomLocalNotificationSync) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomLocalNotificationSync.insert(roomLocalNotificationSync);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
