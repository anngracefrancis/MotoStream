package cm.aptoide.pt.database.room;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.c;
import androidx.room.j;
import androidx.room.n;
import androidx.room.q;
import androidx.room.t.b;
import c.u.a.f;
import cm.aptoide.pt.download.DownloadAnalytics;
import h.a.m;
import h.a.s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class DownloadDAO_Impl implements DownloadDAO {
    private final j __db;
    private final c<RoomDownload> __insertionAdapterOfRoomDownload;
    private final q __preparedStmtOfRemove;
    private final q __preparedStmtOfRemove_1;

    public DownloadDAO_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfRoomDownload = new c<RoomDownload>(jVar) { // from class: cm.aptoide.pt.database.room.DownloadDAO_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `download` (`filesToDownload`,`overallDownloadStatus`,`overallProgress`,`md5`,`appName`,`Icon`,`timeStamp`,`packageName`,`versionCode`,`action`,`versionName`,`hasAppc`,`size`,`storeName`,`trustedBadge`,`downloadError`,`attributionId`,`averageApkDownloadSpeed`,`averageObbDownloadSpeed`,`averageSplitsDownloadSpeed`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, RoomDownload roomDownload) {
                String strSaveFileToDownloadList = FileToDownloadTypeConverter.saveFileToDownloadList(roomDownload.getFilesToDownload());
                if (strSaveFileToDownloadList == null) {
                    fVar.I0(1);
                } else {
                    fVar.w(1, strSaveFileToDownloadList);
                }
                fVar.h0(2, roomDownload.getOverallDownloadStatus());
                fVar.h0(3, roomDownload.getOverallProgress());
                if (roomDownload.getMd5() == null) {
                    fVar.I0(4);
                } else {
                    fVar.w(4, roomDownload.getMd5());
                }
                if (roomDownload.getAppName() == null) {
                    fVar.I0(5);
                } else {
                    fVar.w(5, roomDownload.getAppName());
                }
                if (roomDownload.getIcon() == null) {
                    fVar.I0(6);
                } else {
                    fVar.w(6, roomDownload.getIcon());
                }
                fVar.h0(7, roomDownload.getTimeStamp());
                if (roomDownload.getPackageName() == null) {
                    fVar.I0(8);
                } else {
                    fVar.w(8, roomDownload.getPackageName());
                }
                fVar.h0(9, roomDownload.getVersionCode());
                fVar.h0(10, roomDownload.getAction());
                if (roomDownload.getVersionName() == null) {
                    fVar.I0(11);
                } else {
                    fVar.w(11, roomDownload.getVersionName());
                }
                fVar.h0(12, roomDownload.hasAppc() ? 1L : 0L);
                fVar.h0(13, roomDownload.getSize());
                if (roomDownload.getStoreName() == null) {
                    fVar.I0(14);
                } else {
                    fVar.w(14, roomDownload.getStoreName());
                }
                if (roomDownload.getTrustedBadge() == null) {
                    fVar.I0(15);
                } else {
                    fVar.w(15, roomDownload.getTrustedBadge());
                }
                fVar.h0(16, roomDownload.getDownloadError());
                if (roomDownload.getAttributionId() == null) {
                    fVar.I0(17);
                } else {
                    fVar.w(17, roomDownload.getAttributionId());
                }
                fVar.h0(18, roomDownload.getAverageApkDownloadSpeed());
                fVar.h0(19, roomDownload.getAverageObbDownloadSpeed());
                fVar.h0(20, roomDownload.getAverageSplitsDownloadSpeed());
            }
        };
        this.__preparedStmtOfRemove = new q(jVar) { // from class: cm.aptoide.pt.database.room.DownloadDAO_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "DELETE from download where md5= ?";
            }
        };
        this.__preparedStmtOfRemove_1 = new q(jVar) { // from class: cm.aptoide.pt.database.room.DownloadDAO_Impl.3
            @Override // androidx.room.q
            public String createQuery() {
                return "DELETE from download where packageName=? and versionCode=?";
            }
        };
    }

    @Override // cm.aptoide.pt.database.room.DownloadDAO
    public m<List<RoomDownload>> getAll() {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * from download", 0);
        return n.a(this.__db, false, new String[]{DownloadAnalytics.RAKAM_DOWNLOAD_EVENT}, new Callable<List<RoomDownload>>() { // from class: cm.aptoide.pt.database.room.DownloadDAO_Impl.4
            protected void finalize() {
                mVarC.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomDownload> call() throws Exception {
                Cursor cursorB = androidx.room.t.c.b(DownloadDAO_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, "filesToDownload");
                    int iB2 = b.b(cursorB, "overallDownloadStatus");
                    int iB3 = b.b(cursorB, "overallProgress");
                    int iB4 = b.b(cursorB, "md5");
                    int iB5 = b.b(cursorB, "appName");
                    int iB6 = b.b(cursorB, "Icon");
                    int iB7 = b.b(cursorB, "timeStamp");
                    int iB8 = b.b(cursorB, "packageName");
                    int iB9 = b.b(cursorB, RoomInstalled.VERSION_CODE);
                    int iB10 = b.b(cursorB, "action");
                    int iB11 = b.b(cursorB, RoomInstalled.VERSION_NAME);
                    int iB12 = b.b(cursorB, "hasAppc");
                    int iB13 = b.b(cursorB, "size");
                    int iB14 = b.b(cursorB, "storeName");
                    int iB15 = b.b(cursorB, "trustedBadge");
                    int iB16 = b.b(cursorB, "downloadError");
                    int iB17 = b.b(cursorB, "attributionId");
                    int iB18 = b.b(cursorB, "averageApkDownloadSpeed");
                    int iB19 = b.b(cursorB, "averageObbDownloadSpeed");
                    int iB20 = b.b(cursorB, "averageSplitsDownloadSpeed");
                    int i2 = iB14;
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        RoomDownload roomDownload = new RoomDownload();
                        int i3 = iB;
                        roomDownload.setFilesToDownload(FileToDownloadTypeConverter.restoreFileToDownloadList(cursorB.getString(iB)));
                        roomDownload.setOverallDownloadStatus(cursorB.getInt(iB2));
                        roomDownload.setOverallProgress(cursorB.getInt(iB3));
                        roomDownload.setMd5(cursorB.getString(iB4));
                        roomDownload.setAppName(cursorB.getString(iB5));
                        roomDownload.setIcon(cursorB.getString(iB6));
                        int i4 = iB2;
                        int i5 = iB3;
                        roomDownload.setTimeStamp(cursorB.getLong(iB7));
                        roomDownload.setPackageName(cursorB.getString(iB8));
                        roomDownload.setVersionCode(cursorB.getInt(iB9));
                        roomDownload.setAction(cursorB.getInt(iB10));
                        roomDownload.setVersionName(cursorB.getString(iB11));
                        roomDownload.setHasAppc(cursorB.getInt(iB12) != 0);
                        roomDownload.setSize(cursorB.getLong(iB13));
                        int i6 = i2;
                        roomDownload.setStoreName(cursorB.getString(i6));
                        int i7 = iB15;
                        roomDownload.setTrustedBadge(cursorB.getString(i7));
                        i2 = i6;
                        int i8 = iB16;
                        roomDownload.setDownloadError(cursorB.getInt(i8));
                        iB16 = i8;
                        int i9 = iB17;
                        roomDownload.setAttributionId(cursorB.getString(i9));
                        int i10 = iB18;
                        roomDownload.setAverageApkDownloadSpeed(cursorB.getLong(i10));
                        int i11 = iB19;
                        int i12 = iB4;
                        roomDownload.setAverageObbDownloadSpeed(cursorB.getLong(i11));
                        int i13 = iB20;
                        int i14 = iB5;
                        roomDownload.setAverageSplitsDownloadSpeed(cursorB.getLong(i13));
                        arrayList.add(roomDownload);
                        iB4 = i12;
                        iB5 = i14;
                        iB19 = i11;
                        iB20 = i13;
                        iB2 = i4;
                        iB15 = i7;
                        iB17 = i9;
                        iB3 = i5;
                        iB18 = i10;
                        iB = i3;
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

    @Override // cm.aptoide.pt.database.room.DownloadDAO
    public m<List<RoomDownload>> getAsList(String str) {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * from download where md5 = ?", 1);
        if (str == null) {
            mVarC.I0(1);
        } else {
            mVarC.w(1, str);
        }
        return n.a(this.__db, false, new String[]{DownloadAnalytics.RAKAM_DOWNLOAD_EVENT}, new Callable<List<RoomDownload>>() { // from class: cm.aptoide.pt.database.room.DownloadDAO_Impl.9
            protected void finalize() {
                mVarC.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomDownload> call() throws Exception {
                Cursor cursorB = androidx.room.t.c.b(DownloadDAO_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, "filesToDownload");
                    int iB2 = b.b(cursorB, "overallDownloadStatus");
                    int iB3 = b.b(cursorB, "overallProgress");
                    int iB4 = b.b(cursorB, "md5");
                    int iB5 = b.b(cursorB, "appName");
                    int iB6 = b.b(cursorB, "Icon");
                    int iB7 = b.b(cursorB, "timeStamp");
                    int iB8 = b.b(cursorB, "packageName");
                    int iB9 = b.b(cursorB, RoomInstalled.VERSION_CODE);
                    int iB10 = b.b(cursorB, "action");
                    int iB11 = b.b(cursorB, RoomInstalled.VERSION_NAME);
                    int iB12 = b.b(cursorB, "hasAppc");
                    int iB13 = b.b(cursorB, "size");
                    int iB14 = b.b(cursorB, "storeName");
                    int iB15 = b.b(cursorB, "trustedBadge");
                    int iB16 = b.b(cursorB, "downloadError");
                    int iB17 = b.b(cursorB, "attributionId");
                    int iB18 = b.b(cursorB, "averageApkDownloadSpeed");
                    int iB19 = b.b(cursorB, "averageObbDownloadSpeed");
                    int iB20 = b.b(cursorB, "averageSplitsDownloadSpeed");
                    int i2 = iB14;
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        RoomDownload roomDownload = new RoomDownload();
                        int i3 = iB;
                        roomDownload.setFilesToDownload(FileToDownloadTypeConverter.restoreFileToDownloadList(cursorB.getString(iB)));
                        roomDownload.setOverallDownloadStatus(cursorB.getInt(iB2));
                        roomDownload.setOverallProgress(cursorB.getInt(iB3));
                        roomDownload.setMd5(cursorB.getString(iB4));
                        roomDownload.setAppName(cursorB.getString(iB5));
                        roomDownload.setIcon(cursorB.getString(iB6));
                        int i4 = iB2;
                        int i5 = iB3;
                        roomDownload.setTimeStamp(cursorB.getLong(iB7));
                        roomDownload.setPackageName(cursorB.getString(iB8));
                        roomDownload.setVersionCode(cursorB.getInt(iB9));
                        roomDownload.setAction(cursorB.getInt(iB10));
                        roomDownload.setVersionName(cursorB.getString(iB11));
                        roomDownload.setHasAppc(cursorB.getInt(iB12) != 0);
                        roomDownload.setSize(cursorB.getLong(iB13));
                        int i6 = i2;
                        roomDownload.setStoreName(cursorB.getString(i6));
                        int i7 = iB15;
                        roomDownload.setTrustedBadge(cursorB.getString(i7));
                        i2 = i6;
                        int i8 = iB16;
                        roomDownload.setDownloadError(cursorB.getInt(i8));
                        iB16 = i8;
                        int i9 = iB17;
                        roomDownload.setAttributionId(cursorB.getString(i9));
                        int i10 = iB18;
                        roomDownload.setAverageApkDownloadSpeed(cursorB.getLong(i10));
                        int i11 = iB19;
                        int i12 = iB4;
                        roomDownload.setAverageObbDownloadSpeed(cursorB.getLong(i11));
                        int i13 = iB20;
                        int i14 = iB5;
                        roomDownload.setAverageSplitsDownloadSpeed(cursorB.getLong(i13));
                        arrayList.add(roomDownload);
                        iB4 = i12;
                        iB5 = i14;
                        iB19 = i11;
                        iB20 = i13;
                        iB2 = i4;
                        iB15 = i7;
                        iB17 = i9;
                        iB3 = i5;
                        iB18 = i10;
                        iB = i3;
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

    @Override // cm.aptoide.pt.database.room.DownloadDAO
    public m<RoomDownload> getAsObservable(String str) {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * from download where md5 = ? LIMIT 1 ", 1);
        if (str == null) {
            mVarC.I0(1);
        } else {
            mVarC.w(1, str);
        }
        return n.a(this.__db, false, new String[]{DownloadAnalytics.RAKAM_DOWNLOAD_EVENT}, new Callable<RoomDownload>() { // from class: cm.aptoide.pt.database.room.DownloadDAO_Impl.6
            protected void finalize() {
                mVarC.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RoomDownload call() throws Exception {
                RoomDownload roomDownload;
                Cursor cursorB = androidx.room.t.c.b(DownloadDAO_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, "filesToDownload");
                    int iB2 = b.b(cursorB, "overallDownloadStatus");
                    int iB3 = b.b(cursorB, "overallProgress");
                    int iB4 = b.b(cursorB, "md5");
                    int iB5 = b.b(cursorB, "appName");
                    int iB6 = b.b(cursorB, "Icon");
                    int iB7 = b.b(cursorB, "timeStamp");
                    int iB8 = b.b(cursorB, "packageName");
                    int iB9 = b.b(cursorB, RoomInstalled.VERSION_CODE);
                    int iB10 = b.b(cursorB, "action");
                    int iB11 = b.b(cursorB, RoomInstalled.VERSION_NAME);
                    int iB12 = b.b(cursorB, "hasAppc");
                    int iB13 = b.b(cursorB, "size");
                    int iB14 = b.b(cursorB, "storeName");
                    int iB15 = b.b(cursorB, "trustedBadge");
                    int iB16 = b.b(cursorB, "downloadError");
                    int iB17 = b.b(cursorB, "attributionId");
                    int iB18 = b.b(cursorB, "averageApkDownloadSpeed");
                    int iB19 = b.b(cursorB, "averageObbDownloadSpeed");
                    int iB20 = b.b(cursorB, "averageSplitsDownloadSpeed");
                    if (cursorB.moveToFirst()) {
                        RoomDownload roomDownload2 = new RoomDownload();
                        roomDownload2.setFilesToDownload(FileToDownloadTypeConverter.restoreFileToDownloadList(cursorB.getString(iB)));
                        roomDownload2.setOverallDownloadStatus(cursorB.getInt(iB2));
                        roomDownload2.setOverallProgress(cursorB.getInt(iB3));
                        roomDownload2.setMd5(cursorB.getString(iB4));
                        roomDownload2.setAppName(cursorB.getString(iB5));
                        roomDownload2.setIcon(cursorB.getString(iB6));
                        roomDownload2.setTimeStamp(cursorB.getLong(iB7));
                        roomDownload2.setPackageName(cursorB.getString(iB8));
                        roomDownload2.setVersionCode(cursorB.getInt(iB9));
                        roomDownload2.setAction(cursorB.getInt(iB10));
                        roomDownload2.setVersionName(cursorB.getString(iB11));
                        roomDownload2.setHasAppc(cursorB.getInt(iB12) != 0);
                        roomDownload2.setSize(cursorB.getLong(iB13));
                        roomDownload2.setStoreName(cursorB.getString(iB14));
                        roomDownload2.setTrustedBadge(cursorB.getString(iB15));
                        roomDownload2.setDownloadError(cursorB.getInt(iB16));
                        roomDownload2.setAttributionId(cursorB.getString(iB17));
                        roomDownload2.setAverageApkDownloadSpeed(cursorB.getLong(iB18));
                        roomDownload2.setAverageObbDownloadSpeed(cursorB.getLong(iB19));
                        roomDownload2.setAverageSplitsDownloadSpeed(cursorB.getLong(iB20));
                        roomDownload = roomDownload2;
                    } else {
                        roomDownload = null;
                    }
                    return roomDownload;
                } finally {
                    cursorB.close();
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.DownloadDAO
    public s<RoomDownload> getAsSingle(String str) {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * from download where md5 = ? LIMIT 1 ", 1);
        if (str == null) {
            mVarC.I0(1);
        } else {
            mVarC.w(1, str);
        }
        return n.c(new Callable<RoomDownload>() { // from class: cm.aptoide.pt.database.room.DownloadDAO_Impl.5
            protected void finalize() {
                mVarC.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RoomDownload call() throws Exception {
                RoomDownload roomDownload;
                Cursor cursorB = androidx.room.t.c.b(DownloadDAO_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, "filesToDownload");
                    int iB2 = b.b(cursorB, "overallDownloadStatus");
                    int iB3 = b.b(cursorB, "overallProgress");
                    int iB4 = b.b(cursorB, "md5");
                    int iB5 = b.b(cursorB, "appName");
                    int iB6 = b.b(cursorB, "Icon");
                    int iB7 = b.b(cursorB, "timeStamp");
                    int iB8 = b.b(cursorB, "packageName");
                    int iB9 = b.b(cursorB, RoomInstalled.VERSION_CODE);
                    int iB10 = b.b(cursorB, "action");
                    int iB11 = b.b(cursorB, RoomInstalled.VERSION_NAME);
                    int iB12 = b.b(cursorB, "hasAppc");
                    int iB13 = b.b(cursorB, "size");
                    int iB14 = b.b(cursorB, "storeName");
                    try {
                        int iB15 = b.b(cursorB, "trustedBadge");
                        int iB16 = b.b(cursorB, "downloadError");
                        int iB17 = b.b(cursorB, "attributionId");
                        int iB18 = b.b(cursorB, "averageApkDownloadSpeed");
                        int iB19 = b.b(cursorB, "averageObbDownloadSpeed");
                        int iB20 = b.b(cursorB, "averageSplitsDownloadSpeed");
                        if (cursorB.moveToFirst()) {
                            RoomDownload roomDownload2 = new RoomDownload();
                            roomDownload2.setFilesToDownload(FileToDownloadTypeConverter.restoreFileToDownloadList(cursorB.getString(iB)));
                            roomDownload2.setOverallDownloadStatus(cursorB.getInt(iB2));
                            roomDownload2.setOverallProgress(cursorB.getInt(iB3));
                            roomDownload2.setMd5(cursorB.getString(iB4));
                            roomDownload2.setAppName(cursorB.getString(iB5));
                            roomDownload2.setIcon(cursorB.getString(iB6));
                            roomDownload2.setTimeStamp(cursorB.getLong(iB7));
                            roomDownload2.setPackageName(cursorB.getString(iB8));
                            roomDownload2.setVersionCode(cursorB.getInt(iB9));
                            roomDownload2.setAction(cursorB.getInt(iB10));
                            roomDownload2.setVersionName(cursorB.getString(iB11));
                            roomDownload2.setHasAppc(cursorB.getInt(iB12) != 0);
                            roomDownload2.setSize(cursorB.getLong(iB13));
                            roomDownload2.setStoreName(cursorB.getString(iB14));
                            roomDownload2.setTrustedBadge(cursorB.getString(iB15));
                            roomDownload2.setDownloadError(cursorB.getInt(iB16));
                            roomDownload2.setAttributionId(cursorB.getString(iB17));
                            roomDownload2.setAverageApkDownloadSpeed(cursorB.getLong(iB18));
                            roomDownload2.setAverageObbDownloadSpeed(cursorB.getLong(iB19));
                            roomDownload2.setAverageSplitsDownloadSpeed(cursorB.getLong(iB20));
                            roomDownload = roomDownload2;
                        } else {
                            roomDownload = null;
                        }
                        if (roomDownload != null) {
                            cursorB.close();
                            return roomDownload;
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

    @Override // cm.aptoide.pt.database.room.DownloadDAO
    public m<List<RoomDownload>> getInQueueSortedDownloads() {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * from download where overallDownloadStatus=13 ORDER BY timeStamp ASC", 0);
        return n.a(this.__db, false, new String[]{DownloadAnalytics.RAKAM_DOWNLOAD_EVENT}, new Callable<List<RoomDownload>>() { // from class: cm.aptoide.pt.database.room.DownloadDAO_Impl.8
            protected void finalize() {
                mVarC.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomDownload> call() throws Exception {
                Cursor cursorB = androidx.room.t.c.b(DownloadDAO_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, "filesToDownload");
                    int iB2 = b.b(cursorB, "overallDownloadStatus");
                    int iB3 = b.b(cursorB, "overallProgress");
                    int iB4 = b.b(cursorB, "md5");
                    int iB5 = b.b(cursorB, "appName");
                    int iB6 = b.b(cursorB, "Icon");
                    int iB7 = b.b(cursorB, "timeStamp");
                    int iB8 = b.b(cursorB, "packageName");
                    int iB9 = b.b(cursorB, RoomInstalled.VERSION_CODE);
                    int iB10 = b.b(cursorB, "action");
                    int iB11 = b.b(cursorB, RoomInstalled.VERSION_NAME);
                    int iB12 = b.b(cursorB, "hasAppc");
                    int iB13 = b.b(cursorB, "size");
                    int iB14 = b.b(cursorB, "storeName");
                    int iB15 = b.b(cursorB, "trustedBadge");
                    int iB16 = b.b(cursorB, "downloadError");
                    int iB17 = b.b(cursorB, "attributionId");
                    int iB18 = b.b(cursorB, "averageApkDownloadSpeed");
                    int iB19 = b.b(cursorB, "averageObbDownloadSpeed");
                    int iB20 = b.b(cursorB, "averageSplitsDownloadSpeed");
                    int i2 = iB14;
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        RoomDownload roomDownload = new RoomDownload();
                        int i3 = iB;
                        roomDownload.setFilesToDownload(FileToDownloadTypeConverter.restoreFileToDownloadList(cursorB.getString(iB)));
                        roomDownload.setOverallDownloadStatus(cursorB.getInt(iB2));
                        roomDownload.setOverallProgress(cursorB.getInt(iB3));
                        roomDownload.setMd5(cursorB.getString(iB4));
                        roomDownload.setAppName(cursorB.getString(iB5));
                        roomDownload.setIcon(cursorB.getString(iB6));
                        int i4 = iB2;
                        int i5 = iB3;
                        roomDownload.setTimeStamp(cursorB.getLong(iB7));
                        roomDownload.setPackageName(cursorB.getString(iB8));
                        roomDownload.setVersionCode(cursorB.getInt(iB9));
                        roomDownload.setAction(cursorB.getInt(iB10));
                        roomDownload.setVersionName(cursorB.getString(iB11));
                        roomDownload.setHasAppc(cursorB.getInt(iB12) != 0);
                        roomDownload.setSize(cursorB.getLong(iB13));
                        int i6 = i2;
                        roomDownload.setStoreName(cursorB.getString(i6));
                        int i7 = iB15;
                        roomDownload.setTrustedBadge(cursorB.getString(i7));
                        i2 = i6;
                        int i8 = iB16;
                        roomDownload.setDownloadError(cursorB.getInt(i8));
                        iB16 = i8;
                        int i9 = iB17;
                        roomDownload.setAttributionId(cursorB.getString(i9));
                        int i10 = iB18;
                        roomDownload.setAverageApkDownloadSpeed(cursorB.getLong(i10));
                        int i11 = iB19;
                        int i12 = iB4;
                        roomDownload.setAverageObbDownloadSpeed(cursorB.getLong(i11));
                        int i13 = iB20;
                        int i14 = iB5;
                        roomDownload.setAverageSplitsDownloadSpeed(cursorB.getLong(i13));
                        arrayList.add(roomDownload);
                        iB4 = i12;
                        iB5 = i14;
                        iB19 = i11;
                        iB20 = i13;
                        iB2 = i4;
                        iB15 = i7;
                        iB17 = i9;
                        iB3 = i5;
                        iB18 = i10;
                        iB = i3;
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

    @Override // cm.aptoide.pt.database.room.DownloadDAO
    public m<List<RoomDownload>> getOutOfSpaceDownloads() {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * from download where overallDownloadStatus=9 and downloadError=2 ORDER BY timeStamp ASC", 0);
        return n.a(this.__db, false, new String[]{DownloadAnalytics.RAKAM_DOWNLOAD_EVENT}, new Callable<List<RoomDownload>>() { // from class: cm.aptoide.pt.database.room.DownloadDAO_Impl.10
            protected void finalize() {
                mVarC.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomDownload> call() throws Exception {
                Cursor cursorB = androidx.room.t.c.b(DownloadDAO_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, "filesToDownload");
                    int iB2 = b.b(cursorB, "overallDownloadStatus");
                    int iB3 = b.b(cursorB, "overallProgress");
                    int iB4 = b.b(cursorB, "md5");
                    int iB5 = b.b(cursorB, "appName");
                    int iB6 = b.b(cursorB, "Icon");
                    int iB7 = b.b(cursorB, "timeStamp");
                    int iB8 = b.b(cursorB, "packageName");
                    int iB9 = b.b(cursorB, RoomInstalled.VERSION_CODE);
                    int iB10 = b.b(cursorB, "action");
                    int iB11 = b.b(cursorB, RoomInstalled.VERSION_NAME);
                    int iB12 = b.b(cursorB, "hasAppc");
                    int iB13 = b.b(cursorB, "size");
                    int iB14 = b.b(cursorB, "storeName");
                    int iB15 = b.b(cursorB, "trustedBadge");
                    int iB16 = b.b(cursorB, "downloadError");
                    int iB17 = b.b(cursorB, "attributionId");
                    int iB18 = b.b(cursorB, "averageApkDownloadSpeed");
                    int iB19 = b.b(cursorB, "averageObbDownloadSpeed");
                    int iB20 = b.b(cursorB, "averageSplitsDownloadSpeed");
                    int i2 = iB14;
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        RoomDownload roomDownload = new RoomDownload();
                        int i3 = iB;
                        roomDownload.setFilesToDownload(FileToDownloadTypeConverter.restoreFileToDownloadList(cursorB.getString(iB)));
                        roomDownload.setOverallDownloadStatus(cursorB.getInt(iB2));
                        roomDownload.setOverallProgress(cursorB.getInt(iB3));
                        roomDownload.setMd5(cursorB.getString(iB4));
                        roomDownload.setAppName(cursorB.getString(iB5));
                        roomDownload.setIcon(cursorB.getString(iB6));
                        int i4 = iB2;
                        int i5 = iB3;
                        roomDownload.setTimeStamp(cursorB.getLong(iB7));
                        roomDownload.setPackageName(cursorB.getString(iB8));
                        roomDownload.setVersionCode(cursorB.getInt(iB9));
                        roomDownload.setAction(cursorB.getInt(iB10));
                        roomDownload.setVersionName(cursorB.getString(iB11));
                        roomDownload.setHasAppc(cursorB.getInt(iB12) != 0);
                        roomDownload.setSize(cursorB.getLong(iB13));
                        int i6 = i2;
                        roomDownload.setStoreName(cursorB.getString(i6));
                        int i7 = iB15;
                        roomDownload.setTrustedBadge(cursorB.getString(i7));
                        i2 = i6;
                        int i8 = iB16;
                        roomDownload.setDownloadError(cursorB.getInt(i8));
                        iB16 = i8;
                        int i9 = iB17;
                        roomDownload.setAttributionId(cursorB.getString(i9));
                        int i10 = iB18;
                        roomDownload.setAverageApkDownloadSpeed(cursorB.getLong(i10));
                        int i11 = iB19;
                        int i12 = iB4;
                        roomDownload.setAverageObbDownloadSpeed(cursorB.getLong(i11));
                        int i13 = iB20;
                        int i14 = iB5;
                        roomDownload.setAverageSplitsDownloadSpeed(cursorB.getLong(i13));
                        arrayList.add(roomDownload);
                        iB4 = i12;
                        iB5 = i14;
                        iB19 = i11;
                        iB20 = i13;
                        iB2 = i4;
                        iB15 = i7;
                        iB17 = i9;
                        iB3 = i5;
                        iB18 = i10;
                        iB = i3;
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

    @Override // cm.aptoide.pt.database.room.DownloadDAO
    public m<List<RoomDownload>> getRunningDownloads() {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * from download where overallDownloadStatus = 5 OR overallDownloadStatus = 13 OR overallDownloadStatus = 4", 0);
        return n.a(this.__db, false, new String[]{DownloadAnalytics.RAKAM_DOWNLOAD_EVENT}, new Callable<List<RoomDownload>>() { // from class: cm.aptoide.pt.database.room.DownloadDAO_Impl.7
            protected void finalize() {
                mVarC.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomDownload> call() throws Exception {
                Cursor cursorB = androidx.room.t.c.b(DownloadDAO_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, "filesToDownload");
                    int iB2 = b.b(cursorB, "overallDownloadStatus");
                    int iB3 = b.b(cursorB, "overallProgress");
                    int iB4 = b.b(cursorB, "md5");
                    int iB5 = b.b(cursorB, "appName");
                    int iB6 = b.b(cursorB, "Icon");
                    int iB7 = b.b(cursorB, "timeStamp");
                    int iB8 = b.b(cursorB, "packageName");
                    int iB9 = b.b(cursorB, RoomInstalled.VERSION_CODE);
                    int iB10 = b.b(cursorB, "action");
                    int iB11 = b.b(cursorB, RoomInstalled.VERSION_NAME);
                    int iB12 = b.b(cursorB, "hasAppc");
                    int iB13 = b.b(cursorB, "size");
                    int iB14 = b.b(cursorB, "storeName");
                    int iB15 = b.b(cursorB, "trustedBadge");
                    int iB16 = b.b(cursorB, "downloadError");
                    int iB17 = b.b(cursorB, "attributionId");
                    int iB18 = b.b(cursorB, "averageApkDownloadSpeed");
                    int iB19 = b.b(cursorB, "averageObbDownloadSpeed");
                    int iB20 = b.b(cursorB, "averageSplitsDownloadSpeed");
                    int i2 = iB14;
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        RoomDownload roomDownload = new RoomDownload();
                        int i3 = iB;
                        roomDownload.setFilesToDownload(FileToDownloadTypeConverter.restoreFileToDownloadList(cursorB.getString(iB)));
                        roomDownload.setOverallDownloadStatus(cursorB.getInt(iB2));
                        roomDownload.setOverallProgress(cursorB.getInt(iB3));
                        roomDownload.setMd5(cursorB.getString(iB4));
                        roomDownload.setAppName(cursorB.getString(iB5));
                        roomDownload.setIcon(cursorB.getString(iB6));
                        int i4 = iB2;
                        int i5 = iB3;
                        roomDownload.setTimeStamp(cursorB.getLong(iB7));
                        roomDownload.setPackageName(cursorB.getString(iB8));
                        roomDownload.setVersionCode(cursorB.getInt(iB9));
                        roomDownload.setAction(cursorB.getInt(iB10));
                        roomDownload.setVersionName(cursorB.getString(iB11));
                        roomDownload.setHasAppc(cursorB.getInt(iB12) != 0);
                        roomDownload.setSize(cursorB.getLong(iB13));
                        int i6 = i2;
                        roomDownload.setStoreName(cursorB.getString(i6));
                        int i7 = iB15;
                        roomDownload.setTrustedBadge(cursorB.getString(i7));
                        i2 = i6;
                        int i8 = iB16;
                        roomDownload.setDownloadError(cursorB.getInt(i8));
                        iB16 = i8;
                        int i9 = iB17;
                        roomDownload.setAttributionId(cursorB.getString(i9));
                        int i10 = iB18;
                        roomDownload.setAverageApkDownloadSpeed(cursorB.getLong(i10));
                        int i11 = iB19;
                        int i12 = iB4;
                        roomDownload.setAverageObbDownloadSpeed(cursorB.getLong(i11));
                        int i13 = iB20;
                        int i14 = iB5;
                        roomDownload.setAverageSplitsDownloadSpeed(cursorB.getLong(i13));
                        arrayList.add(roomDownload);
                        iB4 = i12;
                        iB5 = i14;
                        iB19 = i11;
                        iB20 = i13;
                        iB2 = i4;
                        iB15 = i7;
                        iB17 = i9;
                        iB3 = i5;
                        iB18 = i10;
                        iB = i3;
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

    @Override // cm.aptoide.pt.database.room.DownloadDAO
    public void insert(RoomDownload roomDownload) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomDownload.insert(roomDownload);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // cm.aptoide.pt.database.room.DownloadDAO
    public void insertAll(List<RoomDownload> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomDownload.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // cm.aptoide.pt.database.room.DownloadDAO
    public void remove(String str) {
        this.__db.assertNotSuspendingTransaction();
        f fVarAcquire = this.__preparedStmtOfRemove.acquire();
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
            this.__preparedStmtOfRemove.release(fVarAcquire);
        }
    }

    @Override // cm.aptoide.pt.database.room.DownloadDAO
    public void remove(String str, int i2) {
        this.__db.assertNotSuspendingTransaction();
        f fVarAcquire = this.__preparedStmtOfRemove_1.acquire();
        if (str == null) {
            fVarAcquire.I0(1);
        } else {
            fVarAcquire.w(1, str);
        }
        fVarAcquire.h0(2, i2);
        this.__db.beginTransaction();
        try {
            fVarAcquire.E();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfRemove_1.release(fVarAcquire);
        }
    }
}
