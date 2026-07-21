package cm.aptoide.pt.database.room;

import android.database.Cursor;
import androidx.room.b;
import androidx.room.c;
import androidx.room.j;
import androidx.room.n;
import c.u.a.f;
import h.a.m;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class StoredMinimalAdDAO_Impl implements StoredMinimalAdDAO {
    private final j __db;
    private final b<RoomStoredMinimalAd> __deletionAdapterOfRoomStoredMinimalAd;
    private final c<RoomStoredMinimalAd> __insertionAdapterOfRoomStoredMinimalAd;

    public StoredMinimalAdDAO_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfRoomStoredMinimalAd = new c<RoomStoredMinimalAd>(jVar) { // from class: cm.aptoide.pt.database.room.StoredMinimalAdDAO_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `storedMinimalAd` (`packageName`,`referrer`,`cpcUrl`,`cpdUrl`,`cpiUrl`,`timestamp`,`adId`) VALUES (?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, RoomStoredMinimalAd roomStoredMinimalAd) {
                if (roomStoredMinimalAd.getPackageName() == null) {
                    fVar.I0(1);
                } else {
                    fVar.w(1, roomStoredMinimalAd.getPackageName());
                }
                if (roomStoredMinimalAd.getReferrer() == null) {
                    fVar.I0(2);
                } else {
                    fVar.w(2, roomStoredMinimalAd.getReferrer());
                }
                if (roomStoredMinimalAd.getCpcUrl() == null) {
                    fVar.I0(3);
                } else {
                    fVar.w(3, roomStoredMinimalAd.getCpcUrl());
                }
                if (roomStoredMinimalAd.getCpdUrl() == null) {
                    fVar.I0(4);
                } else {
                    fVar.w(4, roomStoredMinimalAd.getCpdUrl());
                }
                if (roomStoredMinimalAd.getCpiUrl() == null) {
                    fVar.I0(5);
                } else {
                    fVar.w(5, roomStoredMinimalAd.getCpiUrl());
                }
                if (roomStoredMinimalAd.getTimestamp() == null) {
                    fVar.I0(6);
                } else {
                    fVar.h0(6, roomStoredMinimalAd.getTimestamp().longValue());
                }
                if (roomStoredMinimalAd.getAdId() == null) {
                    fVar.I0(7);
                } else {
                    fVar.h0(7, roomStoredMinimalAd.getAdId().longValue());
                }
            }
        };
        this.__deletionAdapterOfRoomStoredMinimalAd = new b<RoomStoredMinimalAd>(jVar) { // from class: cm.aptoide.pt.database.room.StoredMinimalAdDAO_Impl.2
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `storedMinimalAd` WHERE `packageName` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, RoomStoredMinimalAd roomStoredMinimalAd) {
                if (roomStoredMinimalAd.getPackageName() == null) {
                    fVar.I0(1);
                } else {
                    fVar.w(1, roomStoredMinimalAd.getPackageName());
                }
            }
        };
    }

    @Override // cm.aptoide.pt.database.room.StoredMinimalAdDAO
    public void delete(RoomStoredMinimalAd roomStoredMinimalAd) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRoomStoredMinimalAd.handle(roomStoredMinimalAd);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // cm.aptoide.pt.database.room.StoredMinimalAdDAO
    public m<RoomStoredMinimalAd> get(String str) {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * FROM storedMinimalAd WHERE packageName = ?", 1);
        if (str == null) {
            mVarC.I0(1);
        } else {
            mVarC.w(1, str);
        }
        return n.a(this.__db, false, new String[]{"storedMinimalAd"}, new Callable<RoomStoredMinimalAd>() { // from class: cm.aptoide.pt.database.room.StoredMinimalAdDAO_Impl.3
            protected void finalize() {
                mVarC.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RoomStoredMinimalAd call() throws Exception {
                RoomStoredMinimalAd roomStoredMinimalAd = null;
                Long lValueOf = null;
                Cursor cursorB = androidx.room.t.c.b(StoredMinimalAdDAO_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = androidx.room.t.b.b(cursorB, "packageName");
                    int iB2 = androidx.room.t.b.b(cursorB, "referrer");
                    int iB3 = androidx.room.t.b.b(cursorB, "cpcUrl");
                    int iB4 = androidx.room.t.b.b(cursorB, "cpdUrl");
                    int iB5 = androidx.room.t.b.b(cursorB, "cpiUrl");
                    int iB6 = androidx.room.t.b.b(cursorB, "timestamp");
                    int iB7 = androidx.room.t.b.b(cursorB, "adId");
                    if (cursorB.moveToFirst()) {
                        RoomStoredMinimalAd roomStoredMinimalAd2 = new RoomStoredMinimalAd(cursorB.getString(iB), cursorB.getString(iB2), cursorB.getString(iB3), cursorB.getString(iB4), cursorB.getString(iB5), cursorB.isNull(iB7) ? null : Long.valueOf(cursorB.getLong(iB7)));
                        if (!cursorB.isNull(iB6)) {
                            lValueOf = Long.valueOf(cursorB.getLong(iB6));
                        }
                        roomStoredMinimalAd2.setTimestamp(lValueOf);
                        roomStoredMinimalAd = roomStoredMinimalAd2;
                    }
                    return roomStoredMinimalAd;
                } finally {
                    cursorB.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.StoredMinimalAdDAO
    public void insert(RoomStoredMinimalAd roomStoredMinimalAd) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomStoredMinimalAd.insert(roomStoredMinimalAd);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
