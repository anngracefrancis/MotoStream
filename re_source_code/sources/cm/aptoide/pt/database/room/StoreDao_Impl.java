package cm.aptoide.pt.database.room;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.c;
import androidx.room.j;
import androidx.room.n;
import androidx.room.q;
import androidx.room.t.b;
import c.u.a.f;
import cm.aptoide.pt.account.AccountAnalytics;
import h.a.m;
import h.a.s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class StoreDao_Impl implements StoreDao {
    private final j __db;
    private final c<RoomStore> __insertionAdapterOfRoomStore;
    private final q __preparedStmtOfRemoveByStoreName;

    public StoreDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfRoomStore = new c<RoomStore>(jVar) { // from class: cm.aptoide.pt.database.room.StoreDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `store` (`storeId`,`iconPath`,`theme`,`downloads`,`storeName`,`username`,`passwordSha1`) VALUES (?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, RoomStore roomStore) {
                fVar.h0(1, roomStore.getStoreId());
                if (roomStore.getIconPath() == null) {
                    fVar.I0(2);
                } else {
                    fVar.w(2, roomStore.getIconPath());
                }
                if (roomStore.getTheme() == null) {
                    fVar.I0(3);
                } else {
                    fVar.w(3, roomStore.getTheme());
                }
                fVar.h0(4, roomStore.getDownloads());
                if (roomStore.getStoreName() == null) {
                    fVar.I0(5);
                } else {
                    fVar.w(5, roomStore.getStoreName());
                }
                if (roomStore.getUsername() == null) {
                    fVar.I0(6);
                } else {
                    fVar.w(6, roomStore.getUsername());
                }
                if (roomStore.getPasswordSha1() == null) {
                    fVar.I0(7);
                } else {
                    fVar.w(7, roomStore.getPasswordSha1());
                }
            }
        };
        this.__preparedStmtOfRemoveByStoreName = new q(jVar) { // from class: cm.aptoide.pt.database.room.StoreDao_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "DELETE FROM store where storeName = ?";
            }
        };
    }

    @Override // cm.aptoide.pt.database.room.StoreDao
    public m<List<RoomStore>> getAll() {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * from store", 0);
        return n.a(this.__db, false, new String[]{AccountAnalytics.STORE}, new Callable<List<RoomStore>>() { // from class: cm.aptoide.pt.database.room.StoreDao_Impl.3
            protected void finalize() {
                mVarC.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomStore> call() throws Exception {
                Cursor cursorB = androidx.room.t.c.b(StoreDao_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, RoomStore.STORE_ID);
                    int iB2 = b.b(cursorB, RoomStore.ICON_PATH);
                    int iB3 = b.b(cursorB, RoomStore.THEME);
                    int iB4 = b.b(cursorB, RoomStore.DOWNLOADS);
                    int iB5 = b.b(cursorB, "storeName");
                    int iB6 = b.b(cursorB, "username");
                    int iB7 = b.b(cursorB, RoomStore.PASSWORD_SHA1);
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        RoomStore roomStore = new RoomStore();
                        roomStore.setStoreId(cursorB.getLong(iB));
                        roomStore.setIconPath(cursorB.getString(iB2));
                        roomStore.setTheme(cursorB.getString(iB3));
                        roomStore.setDownloads(cursorB.getLong(iB4));
                        roomStore.setStoreName(cursorB.getString(iB5));
                        roomStore.setUsername(cursorB.getString(iB6));
                        roomStore.setPasswordSha1(cursorB.getString(iB7));
                        arrayList.add(roomStore);
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

    @Override // cm.aptoide.pt.database.room.StoreDao
    public s<RoomStore> getByStoreId(long j2) {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * from store where storeId = ?", 1);
        mVarC.h0(1, j2);
        return n.c(new Callable<RoomStore>() { // from class: cm.aptoide.pt.database.room.StoreDao_Impl.5
            protected void finalize() {
                mVarC.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RoomStore call() throws Exception {
                RoomStore roomStore = null;
                Cursor cursorB = androidx.room.t.c.b(StoreDao_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, RoomStore.STORE_ID);
                    int iB2 = b.b(cursorB, RoomStore.ICON_PATH);
                    int iB3 = b.b(cursorB, RoomStore.THEME);
                    int iB4 = b.b(cursorB, RoomStore.DOWNLOADS);
                    int iB5 = b.b(cursorB, "storeName");
                    int iB6 = b.b(cursorB, "username");
                    int iB7 = b.b(cursorB, RoomStore.PASSWORD_SHA1);
                    if (cursorB.moveToFirst()) {
                        roomStore = new RoomStore();
                        roomStore.setStoreId(cursorB.getLong(iB));
                        roomStore.setIconPath(cursorB.getString(iB2));
                        roomStore.setTheme(cursorB.getString(iB3));
                        roomStore.setDownloads(cursorB.getLong(iB4));
                        roomStore.setStoreName(cursorB.getString(iB5));
                        roomStore.setUsername(cursorB.getString(iB6));
                        roomStore.setPasswordSha1(cursorB.getString(iB7));
                    }
                    if (roomStore != null) {
                        cursorB.close();
                        return roomStore;
                    }
                    throw new EmptyResultSetException("Query returned empty result set: " + mVarC.a());
                } catch (Throwable th) {
                    cursorB.close();
                    throw th;
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.StoreDao
    public s<RoomStore> getByStoreName(String str) {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * from store where storeName = ?", 1);
        if (str == null) {
            mVarC.I0(1);
        } else {
            mVarC.w(1, str);
        }
        return n.c(new Callable<RoomStore>() { // from class: cm.aptoide.pt.database.room.StoreDao_Impl.4
            protected void finalize() {
                mVarC.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RoomStore call() throws Exception {
                RoomStore roomStore = null;
                Cursor cursorB = androidx.room.t.c.b(StoreDao_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, RoomStore.STORE_ID);
                    int iB2 = b.b(cursorB, RoomStore.ICON_PATH);
                    int iB3 = b.b(cursorB, RoomStore.THEME);
                    int iB4 = b.b(cursorB, RoomStore.DOWNLOADS);
                    int iB5 = b.b(cursorB, "storeName");
                    int iB6 = b.b(cursorB, "username");
                    int iB7 = b.b(cursorB, RoomStore.PASSWORD_SHA1);
                    if (cursorB.moveToFirst()) {
                        roomStore = new RoomStore();
                        roomStore.setStoreId(cursorB.getLong(iB));
                        roomStore.setIconPath(cursorB.getString(iB2));
                        roomStore.setTheme(cursorB.getString(iB3));
                        roomStore.setDownloads(cursorB.getLong(iB4));
                        roomStore.setStoreName(cursorB.getString(iB5));
                        roomStore.setUsername(cursorB.getString(iB6));
                        roomStore.setPasswordSha1(cursorB.getString(iB7));
                    }
                    if (roomStore != null) {
                        cursorB.close();
                        return roomStore;
                    }
                    throw new EmptyResultSetException("Query returned empty result set: " + mVarC.a());
                } catch (Throwable th) {
                    cursorB.close();
                    throw th;
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.StoreDao
    public void insert(RoomStore roomStore) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomStore.insert(roomStore);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // cm.aptoide.pt.database.room.StoreDao
    public m<Integer> isSubscribed(long j2) {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT COUNT(*) from store where storeId = ?", 1);
        mVarC.h0(1, j2);
        return n.a(this.__db, false, new String[]{AccountAnalytics.STORE}, new Callable<Integer>() { // from class: cm.aptoide.pt.database.room.StoreDao_Impl.6
            protected void finalize() {
                mVarC.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                Integer numValueOf = null;
                Cursor cursorB = androidx.room.t.c.b(StoreDao_Impl.this.__db, mVarC, false, null);
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

    @Override // cm.aptoide.pt.database.room.StoreDao
    public void removeByStoreName(String str) {
        this.__db.assertNotSuspendingTransaction();
        f fVarAcquire = this.__preparedStmtOfRemoveByStoreName.acquire();
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
            this.__preparedStmtOfRemoveByStoreName.release(fVarAcquire);
        }
    }

    @Override // cm.aptoide.pt.database.room.StoreDao
    public void saveAll(List<RoomStore> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomStore.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
