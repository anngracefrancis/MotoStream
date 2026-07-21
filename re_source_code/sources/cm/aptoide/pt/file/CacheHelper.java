package cm.aptoide.pt.file;

import cm.aptoide.pt.downloadmanager.CacheManager;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.utils.FileUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class CacheHelper implements CacheManager {
    public static String TAG = "CacheHelper";
    public static final int VALUE_TO_CONVERT_MB_TO_BYTES = 1048576;
    private final FileUtils fileUtils;
    private final List<FolderToManage> foldersToCleanPath;
    private long maxCacheSize;

    public static class FolderToManage {
        final long cacheTime;
        final File folder;

        public FolderToManage(File file, long j2) {
            this.folder = file;
            this.cacheTime = j2;
        }

        protected boolean canEqual(Object obj) {
            return obj instanceof FolderToManage;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FolderToManage)) {
                return false;
            }
            FolderToManage folderToManage = (FolderToManage) obj;
            if (!folderToManage.canEqual(this)) {
                return false;
            }
            File folder = getFolder();
            File folder2 = folderToManage.getFolder();
            if (folder != null ? folder.equals(folder2) : folder2 == null) {
                return getCacheTime() == folderToManage.getCacheTime();
            }
            return false;
        }

        public long getCacheTime() {
            return this.cacheTime;
        }

        public File getFolder() {
            return this.folder;
        }

        public int hashCode() {
            File folder = getFolder();
            int iHashCode = folder == null ? 43 : folder.hashCode();
            long cacheTime = getCacheTime();
            return ((iHashCode + 59) * 59) + ((int) (cacheTime ^ (cacheTime >>> 32)));
        }

        public String toString() {
            return "CacheHelper.FolderToManage(folder=" + getFolder() + ", cacheTime=" + getCacheTime() + ")";
        }
    }

    public CacheHelper(long j2, List<FolderToManage> list, FileUtils fileUtils) {
        this.foldersToCleanPath = list;
        this.maxCacheSize = j2 * 1048576;
        this.fileUtils = fileUtils;
    }

    private boolean checkIfInFoldersToClean(List<FolderToManage> list, File file) {
        Iterator<FolderToManage> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getFolder().getAbsolutePath().equals(file.getAbsolutePath())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$cleanCache$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean a(List list) {
        return Boolean.valueOf(shouldClean(list, this.maxCacheSize));
    }

    static /* synthetic */ Iterable lambda$cleanCache$1(List list) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$cleanCache$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Long b(long j2, FolderToManage folderToManage) {
        return Long.valueOf(removeOldFiles(folderToManage.getFolder(), folderToManage.getCacheTime(), j2));
    }

    static /* synthetic */ Long lambda$cleanCache$4(List list) {
        long jLongValue = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            jLongValue += ((Long) list.get(i2)).longValue();
        }
        Logger.getInstance().d(TAG, "Cache cleaned: " + AptoideUtils.StringU.formatBytes(jLongValue, false));
        return Long.valueOf(jLongValue);
    }

    private long removeFile(long j2, long j3, File file) {
        if (j3 - file.lastModified() > j2) {
            long length = file.length();
            Logger.getInstance().d(TAG, "removeFile: " + file.getAbsolutePath());
            if (file.delete()) {
                return length;
            }
        }
        return 0L;
    }

    private long removeFilesFromDir(long j2, long j3, long j4, File file) {
        long jRemoveOldFiles = removeOldFiles(file, j2, j3);
        File[] fileArrListFiles = file.listFiles();
        return ((fileArrListFiles == null || fileArrListFiles.length <= 0) && file.delete()) ? j4 + jRemoveOldFiles : j4;
    }

    private long removeOldFiles(File file, long j2, long j3) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return 0L;
        }
        long jRemoveFilesFromDir = 0;
        for (File file2 : fileArrListFiles) {
            if (!checkIfInFoldersToClean(this.foldersToCleanPath, file2)) {
                jRemoveFilesFromDir += file2.isDirectory() ? removeFilesFromDir(j2, j3, jRemoveFilesFromDir, file2) : removeFile(j2, j3, file2);
            }
        }
        return jRemoveFilesFromDir;
    }

    private boolean shouldClean(List<FolderToManage> list, long j2) {
        long jDirSize = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            jDirSize += this.fileUtils.dirSize(this.foldersToCleanPath.get(i2).getFolder());
        }
        return jDirSize > j2;
    }

    @Override // cm.aptoide.pt.downloadmanager.CacheManager
    public rx.e<Long> cleanCache() {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        return rx.e.S(this.foldersToCleanPath).D(new rx.m.e() { // from class: cm.aptoide.pt.file.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5663f.a((List) obj);
            }
        }).J(new rx.m.e() { // from class: cm.aptoide.pt.file.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                CacheHelper.lambda$cleanCache$1(list);
                return list;
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.file.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((CacheHelper.FolderToManage) obj).getFolder().exists());
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.file.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5664f.b(jCurrentTimeMillis, (CacheHelper.FolderToManage) obj);
            }
        }).Y0().X(new rx.m.e() { // from class: cm.aptoide.pt.file.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return CacheHelper.lambda$cleanCache$4((List) obj);
            }
        }).I0(Schedulers.io());
    }
}
