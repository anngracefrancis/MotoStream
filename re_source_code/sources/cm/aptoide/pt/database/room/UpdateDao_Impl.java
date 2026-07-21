package cm.aptoide.pt.database.room;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.b;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.n;
import androidx.room.q;
import c.u.a.f;
import h.a.s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class UpdateDao_Impl implements UpdateDao {
    private final j __db;
    private final b<RoomUpdate> __deletionAdapterOfRoomUpdate;
    private final c<RoomUpdate> __insertionAdapterOfRoomUpdate;
    private final q __preparedStmtOfDeleteByPackageName;

    public UpdateDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfRoomUpdate = new c<RoomUpdate>(jVar) { // from class: cm.aptoide.pt.database.room.UpdateDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `update` (`packageName`,`appId`,`label`,`icon`,`md5`,`apkPath`,`size`,`updateVersionName`,`updateVersionCode`,`excluded`,`trustedBadge`,`alternativeApkPath`,`storeName`,`mainObbName`,`mainObbPath`,`mainObbMd5`,`patchObbName`,`patchObbPath`,`patchObbMd5`,`roomSplits`,`requiredSplits`,`hasAppc`,`downloadCampaigns`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, RoomUpdate roomUpdate) {
                if (roomUpdate.getPackageName() == null) {
                    fVar.I0(1);
                } else {
                    fVar.w(1, roomUpdate.getPackageName());
                }
                fVar.h0(2, roomUpdate.getAppId());
                if (roomUpdate.getLabel() == null) {
                    fVar.I0(3);
                } else {
                    fVar.w(3, roomUpdate.getLabel());
                }
                if (roomUpdate.getIcon() == null) {
                    fVar.I0(4);
                } else {
                    fVar.w(4, roomUpdate.getIcon());
                }
                if (roomUpdate.getMd5() == null) {
                    fVar.I0(5);
                } else {
                    fVar.w(5, roomUpdate.getMd5());
                }
                if (roomUpdate.getApkPath() == null) {
                    fVar.I0(6);
                } else {
                    fVar.w(6, roomUpdate.getApkPath());
                }
                fVar.h0(7, roomUpdate.getSize());
                if (roomUpdate.getUpdateVersionName() == null) {
                    fVar.I0(8);
                } else {
                    fVar.w(8, roomUpdate.getUpdateVersionName());
                }
                fVar.h0(9, roomUpdate.getUpdateVersionCode());
                fVar.h0(10, roomUpdate.isExcluded() ? 1L : 0L);
                if (roomUpdate.getTrustedBadge() == null) {
                    fVar.I0(11);
                } else {
                    fVar.w(11, roomUpdate.getTrustedBadge());
                }
                if (roomUpdate.getAlternativeApkPath() == null) {
                    fVar.I0(12);
                } else {
                    fVar.w(12, roomUpdate.getAlternativeApkPath());
                }
                if (roomUpdate.getStoreName() == null) {
                    fVar.I0(13);
                } else {
                    fVar.w(13, roomUpdate.getStoreName());
                }
                if (roomUpdate.getMainObbName() == null) {
                    fVar.I0(14);
                } else {
                    fVar.w(14, roomUpdate.getMainObbName());
                }
                if (roomUpdate.getMainObbPath() == null) {
                    fVar.I0(15);
                } else {
                    fVar.w(15, roomUpdate.getMainObbPath());
                }
                if (roomUpdate.getMainObbMd5() == null) {
                    fVar.I0(16);
                } else {
                    fVar.w(16, roomUpdate.getMainObbMd5());
                }
                if (roomUpdate.getPatchObbName() == null) {
                    fVar.I0(17);
                } else {
                    fVar.w(17, roomUpdate.getPatchObbName());
                }
                if (roomUpdate.getPatchObbPath() == null) {
                    fVar.I0(18);
                } else {
                    fVar.w(18, roomUpdate.getPatchObbPath());
                }
                if (roomUpdate.getPatchObbMd5() == null) {
                    fVar.I0(19);
                } else {
                    fVar.w(19, roomUpdate.getPatchObbMd5());
                }
                String strSaveSplitList = SplitTypeConverter.saveSplitList(roomUpdate.getRoomSplits());
                if (strSaveSplitList == null) {
                    fVar.I0(20);
                } else {
                    fVar.w(20, strSaveSplitList);
                }
                String strSaveList = StringTypeConverter.saveList(roomUpdate.getRequiredSplits());
                if (strSaveList == null) {
                    fVar.I0(21);
                } else {
                    fVar.w(21, strSaveList);
                }
                fVar.h0(22, roomUpdate.hasAppc() ? 1L : 0L);
                String strSaveCampaignUrlList = CampaignUrlTypeConverter.saveCampaignUrlList(roomUpdate.getDownloadCampaigns());
                if (strSaveCampaignUrlList == null) {
                    fVar.I0(23);
                } else {
                    fVar.w(23, strSaveCampaignUrlList);
                }
            }
        };
        this.__deletionAdapterOfRoomUpdate = new b<RoomUpdate>(jVar) { // from class: cm.aptoide.pt.database.room.UpdateDao_Impl.2
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `update` WHERE `packageName` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, RoomUpdate roomUpdate) {
                if (roomUpdate.getPackageName() == null) {
                    fVar.I0(1);
                } else {
                    fVar.w(1, roomUpdate.getPackageName());
                }
            }
        };
        this.__preparedStmtOfDeleteByPackageName = new q(jVar) { // from class: cm.aptoide.pt.database.room.UpdateDao_Impl.3
            @Override // androidx.room.q
            public String createQuery() {
                return "DELETE from `update` where packageName = ?";
            }
        };
    }

    @Override // cm.aptoide.pt.database.room.UpdateDao
    public void deleteAll(List<RoomUpdate> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRoomUpdate.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // cm.aptoide.pt.database.room.UpdateDao
    public void deleteByPackageName(String str) {
        this.__db.assertNotSuspendingTransaction();
        f fVarAcquire = this.__preparedStmtOfDeleteByPackageName.acquire();
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
            this.__preparedStmtOfDeleteByPackageName.release(fVarAcquire);
        }
    }

    @Override // cm.aptoide.pt.database.room.UpdateDao
    public s<RoomUpdate> get(String str) {
        final m mVarC = m.c("SELECT * from `update` where packageName = ?", 1);
        if (str == null) {
            mVarC.I0(1);
        } else {
            mVarC.w(1, str);
        }
        return n.c(new Callable<RoomUpdate>() { // from class: cm.aptoide.pt.database.room.UpdateDao_Impl.4
            protected void finalize() {
                mVarC.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RoomUpdate call() throws Exception {
                RoomUpdate roomUpdate;
                Cursor cursorB = androidx.room.t.c.b(UpdateDao_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = androidx.room.t.b.b(cursorB, "packageName");
                    int iB2 = androidx.room.t.b.b(cursorB, "appId");
                    int iB3 = androidx.room.t.b.b(cursorB, "label");
                    int iB4 = androidx.room.t.b.b(cursorB, RoomInstalled.ICON);
                    int iB5 = androidx.room.t.b.b(cursorB, "md5");
                    int iB6 = androidx.room.t.b.b(cursorB, "apkPath");
                    int iB7 = androidx.room.t.b.b(cursorB, "size");
                    int iB8 = androidx.room.t.b.b(cursorB, "updateVersionName");
                    int iB9 = androidx.room.t.b.b(cursorB, "updateVersionCode");
                    int iB10 = androidx.room.t.b.b(cursorB, "excluded");
                    int iB11 = androidx.room.t.b.b(cursorB, "trustedBadge");
                    int iB12 = androidx.room.t.b.b(cursorB, "alternativeApkPath");
                    int iB13 = androidx.room.t.b.b(cursorB, "storeName");
                    int iB14 = androidx.room.t.b.b(cursorB, "mainObbName");
                    try {
                        int iB15 = androidx.room.t.b.b(cursorB, "mainObbPath");
                        int iB16 = androidx.room.t.b.b(cursorB, "mainObbMd5");
                        int iB17 = androidx.room.t.b.b(cursorB, "patchObbName");
                        int iB18 = androidx.room.t.b.b(cursorB, "patchObbPath");
                        int iB19 = androidx.room.t.b.b(cursorB, "patchObbMd5");
                        int iB20 = androidx.room.t.b.b(cursorB, "roomSplits");
                        int iB21 = androidx.room.t.b.b(cursorB, "requiredSplits");
                        int iB22 = androidx.room.t.b.b(cursorB, "hasAppc");
                        int iB23 = androidx.room.t.b.b(cursorB, "downloadCampaigns");
                        if (cursorB.moveToFirst()) {
                            String string = cursorB.getString(iB);
                            long j2 = cursorB.getLong(iB2);
                            String string2 = cursorB.getString(iB3);
                            String string3 = cursorB.getString(iB4);
                            String string4 = cursorB.getString(iB5);
                            String string5 = cursorB.getString(iB6);
                            long j3 = cursorB.getLong(iB7);
                            String string6 = cursorB.getString(iB8);
                            int i2 = cursorB.getInt(iB9);
                            String string7 = cursorB.getString(iB11);
                            String string8 = cursorB.getString(iB12);
                            String string9 = cursorB.getString(iB13);
                            roomUpdate = new RoomUpdate(j2, string2, string3, string, string4, string5, j3, string6, string8, i2, string7, cursorB.getString(iB14), cursorB.getString(iB15), cursorB.getString(iB16), cursorB.getString(iB17), cursorB.getString(iB18), cursorB.getString(iB19), cursorB.getInt(iB22) != 0, SplitTypeConverter.restoreSplitList(cursorB.getString(iB20)), StringTypeConverter.restoreList(cursorB.getString(iB21)), string9, CampaignUrlTypeConverter.restoreCampaignUrlList(cursorB.getString(iB23)));
                            roomUpdate.setExcluded(cursorB.getInt(iB10) != 0);
                        } else {
                            roomUpdate = null;
                        }
                        if (roomUpdate != null) {
                            cursorB.close();
                            return roomUpdate;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("Query returned empty result set: ");
                        try {
                            sb.append(mVarC.a());
                            throw new EmptyResultSetException(sb.toString());
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
                cursorB.close();
                throw th;
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.UpdateDao
    public s<List<RoomUpdate>> getAllByExcluded(boolean z) {
        final m mVarC = m.c("SELECT * from `update` where excluded = ?", 1);
        mVarC.h0(1, z ? 1L : 0L);
        return n.c(new Callable<List<RoomUpdate>>() { // from class: cm.aptoide.pt.database.room.UpdateDao_Impl.5
            protected void finalize() {
                mVarC.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomUpdate> call() throws Exception {
                Cursor cursorB = androidx.room.t.c.b(UpdateDao_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = androidx.room.t.b.b(cursorB, "packageName");
                    int iB2 = androidx.room.t.b.b(cursorB, "appId");
                    int iB3 = androidx.room.t.b.b(cursorB, "label");
                    int iB4 = androidx.room.t.b.b(cursorB, RoomInstalled.ICON);
                    int iB5 = androidx.room.t.b.b(cursorB, "md5");
                    int iB6 = androidx.room.t.b.b(cursorB, "apkPath");
                    int iB7 = androidx.room.t.b.b(cursorB, "size");
                    int iB8 = androidx.room.t.b.b(cursorB, "updateVersionName");
                    int iB9 = androidx.room.t.b.b(cursorB, "updateVersionCode");
                    int iB10 = androidx.room.t.b.b(cursorB, "excluded");
                    int iB11 = androidx.room.t.b.b(cursorB, "trustedBadge");
                    int iB12 = androidx.room.t.b.b(cursorB, "alternativeApkPath");
                    int iB13 = androidx.room.t.b.b(cursorB, "storeName");
                    int iB14 = androidx.room.t.b.b(cursorB, "mainObbName");
                    int iB15 = androidx.room.t.b.b(cursorB, "mainObbPath");
                    int i2 = iB10;
                    int iB16 = androidx.room.t.b.b(cursorB, "mainObbMd5");
                    int iB17 = androidx.room.t.b.b(cursorB, "patchObbName");
                    int iB18 = androidx.room.t.b.b(cursorB, "patchObbPath");
                    int iB19 = androidx.room.t.b.b(cursorB, "patchObbMd5");
                    int iB20 = androidx.room.t.b.b(cursorB, "roomSplits");
                    int iB21 = androidx.room.t.b.b(cursorB, "requiredSplits");
                    int iB22 = androidx.room.t.b.b(cursorB, "hasAppc");
                    int iB23 = androidx.room.t.b.b(cursorB, "downloadCampaigns");
                    int i3 = iB15;
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        String string = cursorB.getString(iB);
                        long j2 = cursorB.getLong(iB2);
                        String string2 = cursorB.getString(iB3);
                        String string3 = cursorB.getString(iB4);
                        String string4 = cursorB.getString(iB5);
                        String string5 = cursorB.getString(iB6);
                        long j3 = cursorB.getLong(iB7);
                        String string6 = cursorB.getString(iB8);
                        int i4 = cursorB.getInt(iB9);
                        String string7 = cursorB.getString(iB11);
                        String string8 = cursorB.getString(iB12);
                        String string9 = cursorB.getString(iB13);
                        String string10 = cursorB.getString(iB14);
                        int i5 = i3;
                        String string11 = cursorB.getString(i5);
                        int i6 = iB;
                        int i7 = iB16;
                        String string12 = cursorB.getString(i7);
                        iB16 = i7;
                        int i8 = iB17;
                        String string13 = cursorB.getString(i8);
                        iB17 = i8;
                        int i9 = iB18;
                        String string14 = cursorB.getString(i9);
                        iB18 = i9;
                        int i10 = iB19;
                        String string15 = cursorB.getString(i10);
                        iB19 = i10;
                        int i11 = iB20;
                        List<RoomSplit> listRestoreSplitList = SplitTypeConverter.restoreSplitList(cursorB.getString(i11));
                        iB20 = i11;
                        int i12 = iB21;
                        List<String> listRestoreList = StringTypeConverter.restoreList(cursorB.getString(i12));
                        iB21 = i12;
                        iB22 = iB22;
                        boolean z2 = cursorB.getInt(iB22) != 0;
                        List<RoomCampaignUrl> listRestoreCampaignUrlList = CampaignUrlTypeConverter.restoreCampaignUrlList(cursorB.getString(iB23));
                        iB23 = iB23;
                        RoomUpdate roomUpdate = new RoomUpdate(j2, string2, string3, string, string4, string5, j3, string6, string8, i4, string7, string10, string11, string12, string13, string14, string15, z2, listRestoreSplitList, listRestoreList, string9, listRestoreCampaignUrlList);
                        i2 = i2;
                        roomUpdate.setExcluded(cursorB.getInt(i2) != 0);
                        arrayList.add(roomUpdate);
                        iB = i6;
                        i3 = i5;
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

    @Override // cm.aptoide.pt.database.room.UpdateDao
    public h.a.m<List<RoomUpdate>> getAllByExcludedSorted(boolean z) {
        final m mVarC = m.c("SELECT * from `update` where excluded = ? ORDER BY label", 1);
        mVarC.h0(1, z ? 1L : 0L);
        return n.a(this.__db, false, new String[]{"update"}, new Callable<List<RoomUpdate>>() { // from class: cm.aptoide.pt.database.room.UpdateDao_Impl.6
            protected void finalize() {
                mVarC.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomUpdate> call() throws Exception {
                Cursor cursorB = androidx.room.t.c.b(UpdateDao_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = androidx.room.t.b.b(cursorB, "packageName");
                    int iB2 = androidx.room.t.b.b(cursorB, "appId");
                    int iB3 = androidx.room.t.b.b(cursorB, "label");
                    int iB4 = androidx.room.t.b.b(cursorB, RoomInstalled.ICON);
                    int iB5 = androidx.room.t.b.b(cursorB, "md5");
                    int iB6 = androidx.room.t.b.b(cursorB, "apkPath");
                    int iB7 = androidx.room.t.b.b(cursorB, "size");
                    int iB8 = androidx.room.t.b.b(cursorB, "updateVersionName");
                    int iB9 = androidx.room.t.b.b(cursorB, "updateVersionCode");
                    int iB10 = androidx.room.t.b.b(cursorB, "excluded");
                    int iB11 = androidx.room.t.b.b(cursorB, "trustedBadge");
                    int iB12 = androidx.room.t.b.b(cursorB, "alternativeApkPath");
                    int iB13 = androidx.room.t.b.b(cursorB, "storeName");
                    int iB14 = androidx.room.t.b.b(cursorB, "mainObbName");
                    int iB15 = androidx.room.t.b.b(cursorB, "mainObbPath");
                    int i2 = iB10;
                    int iB16 = androidx.room.t.b.b(cursorB, "mainObbMd5");
                    int iB17 = androidx.room.t.b.b(cursorB, "patchObbName");
                    int iB18 = androidx.room.t.b.b(cursorB, "patchObbPath");
                    int iB19 = androidx.room.t.b.b(cursorB, "patchObbMd5");
                    int iB20 = androidx.room.t.b.b(cursorB, "roomSplits");
                    int iB21 = androidx.room.t.b.b(cursorB, "requiredSplits");
                    int iB22 = androidx.room.t.b.b(cursorB, "hasAppc");
                    int iB23 = androidx.room.t.b.b(cursorB, "downloadCampaigns");
                    int i3 = iB15;
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        String string = cursorB.getString(iB);
                        long j2 = cursorB.getLong(iB2);
                        String string2 = cursorB.getString(iB3);
                        String string3 = cursorB.getString(iB4);
                        String string4 = cursorB.getString(iB5);
                        String string5 = cursorB.getString(iB6);
                        long j3 = cursorB.getLong(iB7);
                        String string6 = cursorB.getString(iB8);
                        int i4 = cursorB.getInt(iB9);
                        String string7 = cursorB.getString(iB11);
                        String string8 = cursorB.getString(iB12);
                        String string9 = cursorB.getString(iB13);
                        String string10 = cursorB.getString(iB14);
                        int i5 = i3;
                        String string11 = cursorB.getString(i5);
                        int i6 = iB;
                        int i7 = iB16;
                        String string12 = cursorB.getString(i7);
                        iB16 = i7;
                        int i8 = iB17;
                        String string13 = cursorB.getString(i8);
                        iB17 = i8;
                        int i9 = iB18;
                        String string14 = cursorB.getString(i9);
                        iB18 = i9;
                        int i10 = iB19;
                        String string15 = cursorB.getString(i10);
                        iB19 = i10;
                        int i11 = iB20;
                        List<RoomSplit> listRestoreSplitList = SplitTypeConverter.restoreSplitList(cursorB.getString(i11));
                        iB20 = i11;
                        int i12 = iB21;
                        List<String> listRestoreList = StringTypeConverter.restoreList(cursorB.getString(i12));
                        iB21 = i12;
                        iB22 = iB22;
                        boolean z2 = cursorB.getInt(iB22) != 0;
                        List<RoomCampaignUrl> listRestoreCampaignUrlList = CampaignUrlTypeConverter.restoreCampaignUrlList(cursorB.getString(iB23));
                        iB23 = iB23;
                        RoomUpdate roomUpdate = new RoomUpdate(j2, string2, string3, string, string4, string5, j3, string6, string8, i4, string7, string10, string11, string12, string13, string14, string15, z2, listRestoreSplitList, listRestoreList, string9, listRestoreCampaignUrlList);
                        i2 = i2;
                        roomUpdate.setExcluded(cursorB.getInt(i2) != 0);
                        arrayList.add(roomUpdate);
                        iB = i6;
                        i3 = i5;
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

    @Override // cm.aptoide.pt.database.room.UpdateDao
    public s<RoomUpdate> getByPackageAndExcluded(String str, boolean z) {
        final m mVarC = m.c("SELECT * from `update` where excluded = ? and packageName = ? LIMIT 1", 2);
        mVarC.h0(1, z ? 1L : 0L);
        if (str == null) {
            mVarC.I0(2);
        } else {
            mVarC.w(2, str);
        }
        return n.c(new Callable<RoomUpdate>() { // from class: cm.aptoide.pt.database.room.UpdateDao_Impl.7
            protected void finalize() {
                mVarC.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RoomUpdate call() throws Exception {
                RoomUpdate roomUpdate;
                Cursor cursorB = androidx.room.t.c.b(UpdateDao_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = androidx.room.t.b.b(cursorB, "packageName");
                    int iB2 = androidx.room.t.b.b(cursorB, "appId");
                    int iB3 = androidx.room.t.b.b(cursorB, "label");
                    int iB4 = androidx.room.t.b.b(cursorB, RoomInstalled.ICON);
                    int iB5 = androidx.room.t.b.b(cursorB, "md5");
                    int iB6 = androidx.room.t.b.b(cursorB, "apkPath");
                    int iB7 = androidx.room.t.b.b(cursorB, "size");
                    int iB8 = androidx.room.t.b.b(cursorB, "updateVersionName");
                    int iB9 = androidx.room.t.b.b(cursorB, "updateVersionCode");
                    int iB10 = androidx.room.t.b.b(cursorB, "excluded");
                    int iB11 = androidx.room.t.b.b(cursorB, "trustedBadge");
                    int iB12 = androidx.room.t.b.b(cursorB, "alternativeApkPath");
                    int iB13 = androidx.room.t.b.b(cursorB, "storeName");
                    int iB14 = androidx.room.t.b.b(cursorB, "mainObbName");
                    try {
                        int iB15 = androidx.room.t.b.b(cursorB, "mainObbPath");
                        int iB16 = androidx.room.t.b.b(cursorB, "mainObbMd5");
                        int iB17 = androidx.room.t.b.b(cursorB, "patchObbName");
                        int iB18 = androidx.room.t.b.b(cursorB, "patchObbPath");
                        int iB19 = androidx.room.t.b.b(cursorB, "patchObbMd5");
                        int iB20 = androidx.room.t.b.b(cursorB, "roomSplits");
                        int iB21 = androidx.room.t.b.b(cursorB, "requiredSplits");
                        int iB22 = androidx.room.t.b.b(cursorB, "hasAppc");
                        int iB23 = androidx.room.t.b.b(cursorB, "downloadCampaigns");
                        if (cursorB.moveToFirst()) {
                            String string = cursorB.getString(iB);
                            long j2 = cursorB.getLong(iB2);
                            String string2 = cursorB.getString(iB3);
                            String string3 = cursorB.getString(iB4);
                            String string4 = cursorB.getString(iB5);
                            String string5 = cursorB.getString(iB6);
                            long j3 = cursorB.getLong(iB7);
                            String string6 = cursorB.getString(iB8);
                            int i2 = cursorB.getInt(iB9);
                            String string7 = cursorB.getString(iB11);
                            String string8 = cursorB.getString(iB12);
                            String string9 = cursorB.getString(iB13);
                            roomUpdate = new RoomUpdate(j2, string2, string3, string, string4, string5, j3, string6, string8, i2, string7, cursorB.getString(iB14), cursorB.getString(iB15), cursorB.getString(iB16), cursorB.getString(iB17), cursorB.getString(iB18), cursorB.getString(iB19), cursorB.getInt(iB22) != 0, SplitTypeConverter.restoreSplitList(cursorB.getString(iB20)), StringTypeConverter.restoreList(cursorB.getString(iB21)), string9, CampaignUrlTypeConverter.restoreCampaignUrlList(cursorB.getString(iB23)));
                            roomUpdate.setExcluded(cursorB.getInt(iB10) != 0);
                        } else {
                            roomUpdate = null;
                        }
                        if (roomUpdate != null) {
                            cursorB.close();
                            return roomUpdate;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("Query returned empty result set: ");
                        try {
                            sb.append(mVarC.a());
                            throw new EmptyResultSetException(sb.toString());
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
                cursorB.close();
                throw th;
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.UpdateDao
    public void insert(RoomUpdate roomUpdate) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomUpdate.insert(roomUpdate);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // cm.aptoide.pt.database.room.UpdateDao
    public void insertAll(List<RoomUpdate> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomUpdate.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
