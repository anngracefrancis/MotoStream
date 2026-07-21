package cm.aptoide.pt.database.room;

import android.database.Cursor;
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
public final class NotificationDao_Impl implements NotificationDao {
    private final j __db;
    private final c<RoomNotification> __insertionAdapterOfRoomNotification;
    private final q __preparedStmtOfDeleteAllByType;

    public NotificationDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfRoomNotification = new c<RoomNotification>(jVar) { // from class: cm.aptoide.pt.database.room.NotificationDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `notification` (`expire`,`abTestingGroup`,`body`,`campaignId`,`img`,`lang`,`title`,`url`,`urlTrack`,`notificationCenterUrlTrack`,`type`,`timeStamp`,`appName`,`graphic`,`ownerId`,`processed`,`actionStringRes`,`whitelistedPackages`,`key`,`dismissed`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, RoomNotification roomNotification) {
                if (roomNotification.getExpire() == null) {
                    fVar.I0(1);
                } else {
                    fVar.h0(1, roomNotification.getExpire().longValue());
                }
                if (roomNotification.getAbTestingGroup() == null) {
                    fVar.I0(2);
                } else {
                    fVar.w(2, roomNotification.getAbTestingGroup());
                }
                if (roomNotification.getBody() == null) {
                    fVar.I0(3);
                } else {
                    fVar.w(3, roomNotification.getBody());
                }
                fVar.h0(4, roomNotification.getCampaignId());
                if (roomNotification.getImg() == null) {
                    fVar.I0(5);
                } else {
                    fVar.w(5, roomNotification.getImg());
                }
                if (roomNotification.getLang() == null) {
                    fVar.I0(6);
                } else {
                    fVar.w(6, roomNotification.getLang());
                }
                if (roomNotification.getTitle() == null) {
                    fVar.I0(7);
                } else {
                    fVar.w(7, roomNotification.getTitle());
                }
                if (roomNotification.getUrl() == null) {
                    fVar.I0(8);
                } else {
                    fVar.w(8, roomNotification.getUrl());
                }
                if (roomNotification.getUrlTrack() == null) {
                    fVar.I0(9);
                } else {
                    fVar.w(9, roomNotification.getUrlTrack());
                }
                if (roomNotification.getNotificationCenterUrlTrack() == null) {
                    fVar.I0(10);
                } else {
                    fVar.w(10, roomNotification.getNotificationCenterUrlTrack());
                }
                fVar.h0(11, roomNotification.getType());
                fVar.h0(12, roomNotification.getTimeStamp());
                if (roomNotification.getAppName() == null) {
                    fVar.I0(13);
                } else {
                    fVar.w(13, roomNotification.getAppName());
                }
                if (roomNotification.getGraphic() == null) {
                    fVar.I0(14);
                } else {
                    fVar.w(14, roomNotification.getGraphic());
                }
                if (roomNotification.getOwnerId() == null) {
                    fVar.I0(15);
                } else {
                    fVar.w(15, roomNotification.getOwnerId());
                }
                fVar.h0(16, roomNotification.isProcessed() ? 1L : 0L);
                fVar.h0(17, roomNotification.getActionStringRes());
                String strSaveList = StringTypeConverter.saveList(roomNotification.getWhitelistedPackages());
                if (strSaveList == null) {
                    fVar.I0(18);
                } else {
                    fVar.w(18, strSaveList);
                }
                if (roomNotification.getKey() == null) {
                    fVar.I0(19);
                } else {
                    fVar.w(19, roomNotification.getKey());
                }
                fVar.h0(20, roomNotification.getDismissed());
            }
        };
        this.__preparedStmtOfDeleteAllByType = new q(jVar) { // from class: cm.aptoide.pt.database.room.NotificationDao_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "DELETE FROM notification where type = ?";
            }
        };
    }

    @Override // cm.aptoide.pt.database.room.NotificationDao
    public void deleteAllByType(int i2) {
        this.__db.assertNotSuspendingTransaction();
        f fVarAcquire = this.__preparedStmtOfDeleteAllByType.acquire();
        fVarAcquire.h0(1, i2);
        this.__db.beginTransaction();
        try {
            fVarAcquire.E();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllByType.release(fVarAcquire);
        }
    }

    @Override // cm.aptoide.pt.database.room.NotificationDao
    public void deleteAllExcluding(List<String> list) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbB = androidx.room.t.f.b();
        sbB.append("DELETE FROM notification where ownerId NOT IN (");
        androidx.room.t.f.a(sbB, list.size());
        sbB.append(") ");
        f fVarCompileStatement = this.__db.compileStatement(sbB.toString());
        int i2 = 1;
        for (String str : list) {
            if (str == null) {
                fVarCompileStatement.I0(i2);
            } else {
                fVarCompileStatement.w(i2, str);
            }
            i2++;
        }
        this.__db.beginTransaction();
        try {
            fVarCompileStatement.E();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // cm.aptoide.pt.database.room.NotificationDao
    public void deleteByKey(List<String> list) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbB = androidx.room.t.f.b();
        sbB.append("DELETE FROM notification where `key` IN (");
        androidx.room.t.f.a(sbB, list.size());
        sbB.append(") ");
        f fVarCompileStatement = this.__db.compileStatement(sbB.toString());
        int i2 = 1;
        for (String str : list) {
            if (str == null) {
                fVarCompileStatement.I0(i2);
            } else {
                fVarCompileStatement.w(i2, str);
            }
            i2++;
        }
        this.__db.beginTransaction();
        try {
            fVarCompileStatement.E();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // cm.aptoide.pt.database.room.NotificationDao
    public m<List<RoomNotification>> getAll() {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * FROM notification", 0);
        return n.a(this.__db, false, new String[]{"notification"}, new Callable<List<RoomNotification>>() { // from class: cm.aptoide.pt.database.room.NotificationDao_Impl.6
            protected void finalize() {
                mVarC.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomNotification> call() throws Exception {
                Cursor cursorB = androidx.room.t.c.b(NotificationDao_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, "expire");
                    int iB2 = b.b(cursorB, "abTestingGroup");
                    int iB3 = b.b(cursorB, "body");
                    int iB4 = b.b(cursorB, "campaignId");
                    int iB5 = b.b(cursorB, "img");
                    int iB6 = b.b(cursorB, "lang");
                    int iB7 = b.b(cursorB, "title");
                    int iB8 = b.b(cursorB, "url");
                    int iB9 = b.b(cursorB, "urlTrack");
                    int iB10 = b.b(cursorB, "notificationCenterUrlTrack");
                    int iB11 = b.b(cursorB, "type");
                    int iB12 = b.b(cursorB, "timeStamp");
                    int iB13 = b.b(cursorB, "appName");
                    int iB14 = b.b(cursorB, "graphic");
                    int iB15 = b.b(cursorB, "ownerId");
                    int iB16 = b.b(cursorB, "processed");
                    int iB17 = b.b(cursorB, "actionStringRes");
                    int iB18 = b.b(cursorB, "whitelistedPackages");
                    int iB19 = b.b(cursorB, RoomNotification.KEY);
                    int iB20 = b.b(cursorB, "dismissed");
                    int i2 = iB14;
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        Long lValueOf = cursorB.isNull(iB) ? null : Long.valueOf(cursorB.getLong(iB));
                        String string = cursorB.getString(iB2);
                        String string2 = cursorB.getString(iB3);
                        int i3 = cursorB.getInt(iB4);
                        String string3 = cursorB.getString(iB5);
                        String string4 = cursorB.getString(iB6);
                        String string5 = cursorB.getString(iB7);
                        String string6 = cursorB.getString(iB8);
                        String string7 = cursorB.getString(iB9);
                        String string8 = cursorB.getString(iB10);
                        int i4 = cursorB.getInt(iB11);
                        long j2 = cursorB.getLong(iB12);
                        String string9 = cursorB.getString(iB13);
                        int i5 = i2;
                        String string10 = cursorB.getString(i5);
                        int i6 = iB;
                        int i7 = iB15;
                        String string11 = cursorB.getString(i7);
                        iB15 = i7;
                        iB16 = iB16;
                        boolean z = cursorB.getInt(iB16) != 0;
                        int i8 = cursorB.getInt(iB17);
                        iB17 = iB17;
                        int i9 = iB18;
                        List<String> listRestoreList = StringTypeConverter.restoreList(cursorB.getString(i9));
                        iB18 = i9;
                        int i10 = iB20;
                        iB20 = i10;
                        RoomNotification roomNotification = new RoomNotification(lValueOf, string, string2, i3, string3, string4, string5, string6, string7, string8, j2, i4, cursorB.getLong(i10), string9, string10, string11, z, i8, listRestoreList);
                        int i11 = iB13;
                        int i12 = iB19;
                        roomNotification.setKey(cursorB.getString(i12));
                        arrayList.add(roomNotification);
                        iB = i6;
                        i2 = i5;
                        iB19 = i12;
                        iB13 = i11;
                    }
                    return arrayList;
                } finally {
                    cursorB.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.NotificationDao
    public m<List<RoomNotification>> getAllSortedDesc() {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * from notification ORDER BY timeStamp DESC", 0);
        return n.a(this.__db, false, new String[]{"notification"}, new Callable<List<RoomNotification>>() { // from class: cm.aptoide.pt.database.room.NotificationDao_Impl.5
            protected void finalize() {
                mVarC.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomNotification> call() throws Exception {
                Cursor cursorB = androidx.room.t.c.b(NotificationDao_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, "expire");
                    int iB2 = b.b(cursorB, "abTestingGroup");
                    int iB3 = b.b(cursorB, "body");
                    int iB4 = b.b(cursorB, "campaignId");
                    int iB5 = b.b(cursorB, "img");
                    int iB6 = b.b(cursorB, "lang");
                    int iB7 = b.b(cursorB, "title");
                    int iB8 = b.b(cursorB, "url");
                    int iB9 = b.b(cursorB, "urlTrack");
                    int iB10 = b.b(cursorB, "notificationCenterUrlTrack");
                    int iB11 = b.b(cursorB, "type");
                    int iB12 = b.b(cursorB, "timeStamp");
                    int iB13 = b.b(cursorB, "appName");
                    int iB14 = b.b(cursorB, "graphic");
                    int iB15 = b.b(cursorB, "ownerId");
                    int iB16 = b.b(cursorB, "processed");
                    int iB17 = b.b(cursorB, "actionStringRes");
                    int iB18 = b.b(cursorB, "whitelistedPackages");
                    int iB19 = b.b(cursorB, RoomNotification.KEY);
                    int iB20 = b.b(cursorB, "dismissed");
                    int i2 = iB14;
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        Long lValueOf = cursorB.isNull(iB) ? null : Long.valueOf(cursorB.getLong(iB));
                        String string = cursorB.getString(iB2);
                        String string2 = cursorB.getString(iB3);
                        int i3 = cursorB.getInt(iB4);
                        String string3 = cursorB.getString(iB5);
                        String string4 = cursorB.getString(iB6);
                        String string5 = cursorB.getString(iB7);
                        String string6 = cursorB.getString(iB8);
                        String string7 = cursorB.getString(iB9);
                        String string8 = cursorB.getString(iB10);
                        int i4 = cursorB.getInt(iB11);
                        long j2 = cursorB.getLong(iB12);
                        String string9 = cursorB.getString(iB13);
                        int i5 = i2;
                        String string10 = cursorB.getString(i5);
                        int i6 = iB;
                        int i7 = iB15;
                        String string11 = cursorB.getString(i7);
                        iB15 = i7;
                        iB16 = iB16;
                        boolean z = cursorB.getInt(iB16) != 0;
                        int i8 = cursorB.getInt(iB17);
                        iB17 = iB17;
                        int i9 = iB18;
                        List<String> listRestoreList = StringTypeConverter.restoreList(cursorB.getString(i9));
                        iB18 = i9;
                        int i10 = iB20;
                        iB20 = i10;
                        RoomNotification roomNotification = new RoomNotification(lValueOf, string, string2, i3, string3, string4, string5, string6, string7, string8, j2, i4, cursorB.getLong(i10), string9, string10, string11, z, i8, listRestoreList);
                        int i11 = iB13;
                        int i12 = iB19;
                        roomNotification.setKey(cursorB.getString(i12));
                        arrayList.add(roomNotification);
                        iB = i6;
                        i2 = i5;
                        iB19 = i12;
                        iB13 = i11;
                    }
                    return arrayList;
                } finally {
                    cursorB.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.NotificationDao
    public s<List<RoomNotification>> getAllSortedDescByType(Integer[] numArr) {
        StringBuilder sbB = androidx.room.t.f.b();
        sbB.append("SELECT ");
        sbB.append("*");
        sbB.append(" from notification where type IN (");
        int length = numArr.length;
        androidx.room.t.f.a(sbB, length);
        sbB.append(") ORDER BY timeStamp DESC");
        final androidx.room.m mVarC = androidx.room.m.c(sbB.toString(), length + 0);
        int i2 = 1;
        for (Integer num : numArr) {
            if (num == null) {
                mVarC.I0(i2);
            } else {
                mVarC.h0(i2, num.intValue());
            }
            i2++;
        }
        return n.c(new Callable<List<RoomNotification>>() { // from class: cm.aptoide.pt.database.room.NotificationDao_Impl.4
            protected void finalize() {
                mVarC.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomNotification> call() throws Exception {
                Cursor cursorB = androidx.room.t.c.b(NotificationDao_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, "expire");
                    int iB2 = b.b(cursorB, "abTestingGroup");
                    int iB3 = b.b(cursorB, "body");
                    int iB4 = b.b(cursorB, "campaignId");
                    int iB5 = b.b(cursorB, "img");
                    int iB6 = b.b(cursorB, "lang");
                    int iB7 = b.b(cursorB, "title");
                    int iB8 = b.b(cursorB, "url");
                    int iB9 = b.b(cursorB, "urlTrack");
                    int iB10 = b.b(cursorB, "notificationCenterUrlTrack");
                    int iB11 = b.b(cursorB, "type");
                    int iB12 = b.b(cursorB, "timeStamp");
                    int iB13 = b.b(cursorB, "appName");
                    int iB14 = b.b(cursorB, "graphic");
                    int iB15 = b.b(cursorB, "ownerId");
                    int iB16 = b.b(cursorB, "processed");
                    int iB17 = b.b(cursorB, "actionStringRes");
                    int iB18 = b.b(cursorB, "whitelistedPackages");
                    int iB19 = b.b(cursorB, RoomNotification.KEY);
                    int iB20 = b.b(cursorB, "dismissed");
                    int i3 = iB14;
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        Long lValueOf = cursorB.isNull(iB) ? null : Long.valueOf(cursorB.getLong(iB));
                        String string = cursorB.getString(iB2);
                        String string2 = cursorB.getString(iB3);
                        int i4 = cursorB.getInt(iB4);
                        String string3 = cursorB.getString(iB5);
                        String string4 = cursorB.getString(iB6);
                        String string5 = cursorB.getString(iB7);
                        String string6 = cursorB.getString(iB8);
                        String string7 = cursorB.getString(iB9);
                        String string8 = cursorB.getString(iB10);
                        int i5 = cursorB.getInt(iB11);
                        long j2 = cursorB.getLong(iB12);
                        String string9 = cursorB.getString(iB13);
                        int i6 = i3;
                        String string10 = cursorB.getString(i6);
                        int i7 = iB;
                        int i8 = iB15;
                        String string11 = cursorB.getString(i8);
                        iB15 = i8;
                        iB16 = iB16;
                        boolean z = cursorB.getInt(iB16) != 0;
                        int i9 = cursorB.getInt(iB17);
                        iB17 = iB17;
                        int i10 = iB18;
                        List<String> listRestoreList = StringTypeConverter.restoreList(cursorB.getString(i10));
                        iB18 = i10;
                        int i11 = iB20;
                        iB20 = i11;
                        RoomNotification roomNotification = new RoomNotification(lValueOf, string, string2, i4, string3, string4, string5, string6, string7, string8, j2, i5, cursorB.getLong(i11), string9, string10, string11, z, i9, listRestoreList);
                        int i12 = iB13;
                        int i13 = iB19;
                        roomNotification.setKey(cursorB.getString(i13));
                        arrayList.add(roomNotification);
                        iB = i7;
                        i3 = i6;
                        iB19 = i13;
                        iB13 = i12;
                    }
                    return arrayList;
                } finally {
                    cursorB.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.NotificationDao
    public s<List<RoomNotification>> getDismissed(Integer[] numArr, long j2, long j3) {
        StringBuilder sbB = androidx.room.t.f.b();
        sbB.append("SELECT ");
        sbB.append("*");
        sbB.append(" from notification where type IN (");
        int length = numArr.length;
        androidx.room.t.f.a(sbB, length);
        sbB.append(") AND dismissed BETWEEN ");
        sbB.append("?");
        sbB.append(" AND ");
        sbB.append("?");
        sbB.append(" ");
        int i2 = length + 2;
        final androidx.room.m mVarC = androidx.room.m.c(sbB.toString(), i2);
        int i3 = 1;
        for (Integer num : numArr) {
            if (num == null) {
                mVarC.I0(i3);
            } else {
                mVarC.h0(i3, num.intValue());
            }
            i3++;
        }
        mVarC.h0(length + 1, j2);
        mVarC.h0(i2, j3);
        return n.c(new Callable<List<RoomNotification>>() { // from class: cm.aptoide.pt.database.room.NotificationDao_Impl.3
            protected void finalize() {
                mVarC.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomNotification> call() throws Exception {
                Cursor cursorB = androidx.room.t.c.b(NotificationDao_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, "expire");
                    int iB2 = b.b(cursorB, "abTestingGroup");
                    int iB3 = b.b(cursorB, "body");
                    int iB4 = b.b(cursorB, "campaignId");
                    int iB5 = b.b(cursorB, "img");
                    int iB6 = b.b(cursorB, "lang");
                    int iB7 = b.b(cursorB, "title");
                    int iB8 = b.b(cursorB, "url");
                    int iB9 = b.b(cursorB, "urlTrack");
                    int iB10 = b.b(cursorB, "notificationCenterUrlTrack");
                    int iB11 = b.b(cursorB, "type");
                    int iB12 = b.b(cursorB, "timeStamp");
                    int iB13 = b.b(cursorB, "appName");
                    int iB14 = b.b(cursorB, "graphic");
                    int iB15 = b.b(cursorB, "ownerId");
                    int iB16 = b.b(cursorB, "processed");
                    int iB17 = b.b(cursorB, "actionStringRes");
                    int iB18 = b.b(cursorB, "whitelistedPackages");
                    int iB19 = b.b(cursorB, RoomNotification.KEY);
                    int iB20 = b.b(cursorB, "dismissed");
                    int i4 = iB14;
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        Long lValueOf = cursorB.isNull(iB) ? null : Long.valueOf(cursorB.getLong(iB));
                        String string = cursorB.getString(iB2);
                        String string2 = cursorB.getString(iB3);
                        int i5 = cursorB.getInt(iB4);
                        String string3 = cursorB.getString(iB5);
                        String string4 = cursorB.getString(iB6);
                        String string5 = cursorB.getString(iB7);
                        String string6 = cursorB.getString(iB8);
                        String string7 = cursorB.getString(iB9);
                        String string8 = cursorB.getString(iB10);
                        int i6 = cursorB.getInt(iB11);
                        long j4 = cursorB.getLong(iB12);
                        String string9 = cursorB.getString(iB13);
                        int i7 = i4;
                        String string10 = cursorB.getString(i7);
                        int i8 = iB;
                        int i9 = iB15;
                        String string11 = cursorB.getString(i9);
                        iB15 = i9;
                        iB16 = iB16;
                        boolean z = cursorB.getInt(iB16) != 0;
                        int i10 = cursorB.getInt(iB17);
                        iB17 = iB17;
                        int i11 = iB18;
                        List<String> listRestoreList = StringTypeConverter.restoreList(cursorB.getString(i11));
                        iB18 = i11;
                        int i12 = iB20;
                        iB20 = i12;
                        RoomNotification roomNotification = new RoomNotification(lValueOf, string, string2, i5, string3, string4, string5, string6, string7, string8, j4, i6, cursorB.getLong(i12), string9, string10, string11, z, i10, listRestoreList);
                        int i13 = iB13;
                        int i14 = iB19;
                        roomNotification.setKey(cursorB.getString(i14));
                        arrayList.add(roomNotification);
                        iB = i8;
                        i4 = i7;
                        iB19 = i14;
                        iB13 = i13;
                    }
                    return arrayList;
                } finally {
                    cursorB.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.NotificationDao
    public void insert(RoomNotification roomNotification) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomNotification.insert(roomNotification);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // cm.aptoide.pt.database.room.NotificationDao
    public void insertAll(List<RoomNotification> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomNotification.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
