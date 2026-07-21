package cm.aptoide.pt.install;

import cm.aptoide.pt.database.room.RoomFileToDownload;
import cm.aptoide.pt.downloadmanager.PathProvider;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: FilePathProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000e"}, d2 = {"Lcm/aptoide/pt/install/FilePathProvider;", "Lcm/aptoide/pt/downloadmanager/PathProvider;", "apkPath", HttpUrl.FRAGMENT_ENCODE_SET, "obbPath", "cachePath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApkPath", "()Ljava/lang/String;", "getCachePath", "getObbPath", "getFilePathFromFileType", "fileToDownload", "Lcm/aptoide/pt/database/room/RoomFileToDownload;", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FilePathProvider implements PathProvider {
    private final String apkPath;
    private final String cachePath;
    private final String obbPath;

    public FilePathProvider(String str, String str2, String str3) {
        kotlin.jvm.internal.m.f(str, "apkPath");
        kotlin.jvm.internal.m.f(str2, "obbPath");
        kotlin.jvm.internal.m.f(str3, "cachePath");
        this.apkPath = str;
        this.obbPath = str2;
        this.cachePath = str3;
    }

    public final String getApkPath() {
        return this.apkPath;
    }

    public final String getCachePath() {
        return this.cachePath;
    }

    @Override // cm.aptoide.pt.downloadmanager.PathProvider
    public String getFilePathFromFileType(RoomFileToDownload fileToDownload) {
        kotlin.jvm.internal.m.f(fileToDownload, "fileToDownload");
        int fileType = fileToDownload.getFileType();
        if (fileType == 0) {
            return this.apkPath;
        }
        if (fileType == 1) {
            return this.obbPath + fileToDownload.getPackageName() + '/';
        }
        if (fileType == 2) {
            return this.cachePath;
        }
        if (fileType != 3) {
            return this.cachePath;
        }
        return this.apkPath + fileToDownload.getPackageName() + "-splits/";
    }

    public final String getObbPath() {
        return this.obbPath;
    }
}
