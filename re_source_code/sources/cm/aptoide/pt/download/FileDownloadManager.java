package cm.aptoide.pt.download;

import cm.aptoide.pt.downloadmanager.Constants;
import cm.aptoide.pt.downloadmanager.FileDownloadCallback;
import cm.aptoide.pt.downloadmanager.FileDownloader;
import e.h.a.q;

/* JADX INFO: loaded from: classes.dex */
public class FileDownloadManager implements FileDownloader {
    private static final int APTOIDE_DOWNLOAD_TASK_TAG_KEY = 888;
    public static final int PROGRESS_MAX_VALUE = 100;
    public static final int RETRY_TIMES = 3;
    private int downloadId;
    private String downloadsPath;
    private FileDownloadTask fileDownloadTask;
    private q fileDownloader;
    private final String fileName;
    private final int fileType;
    private final String mainDownloadPath;
    private final String packageName;
    private final int versionCode;

    public FileDownloadManager(q qVar, FileDownloadTask fileDownloadTask, String str, String str2, int i2, String str3, int i3, String str4) {
        this.fileDownloader = qVar;
        this.fileDownloadTask = fileDownloadTask;
        this.downloadsPath = str;
        this.mainDownloadPath = str2;
        this.fileType = i2;
        this.packageName = str3;
        this.versionCode = i3;
        this.fileName = str4;
    }

    private void createBaseDownloadTask(String str, int i2, String str2, int i3, String str3) {
        e.h.a.a aVarD = this.fileDownloader.d(str);
        aVarD.O(3);
        aVarD.f(Constants.VERSION_CODE, String.valueOf(i2));
        aVarD.f(Constants.PACKAGE, str2);
        aVarD.f(Constants.FILE_TYPE, String.valueOf(i3));
        aVarD.j(APTOIDE_DOWNLOAD_TASK_TAG_KEY, this.fileDownloadTask);
        aVarD.W(this.fileDownloadTask);
        aVarD.R(100);
        aVarD.k(this.downloadsPath + str3);
        this.downloadId = aVarD.m().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$pauseDownload$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a() {
        this.fileDownloader.k(this.fileDownloadTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$removeDownloadFile$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b() {
        this.fileDownloader.c(this.downloadId, this.mainDownloadPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$startFileDownload$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c() {
        String str = this.mainDownloadPath;
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("The url for the download can not be empty");
        }
        createBaseDownloadTask(this.mainDownloadPath, this.versionCode, this.packageName, this.fileType, this.fileName);
        this.fileDownloader.m(this.fileDownloadTask, true);
    }

    @Override // cm.aptoide.pt.downloadmanager.FileDownloader
    public rx.e<FileDownloadCallback> observeFileDownloadProgress() {
        return this.fileDownloadTask.onDownloadStateChanged();
    }

    @Override // cm.aptoide.pt.downloadmanager.FileDownloader
    public rx.b pauseDownload() {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.download.g
            @Override // rx.m.a
            public final void call() {
                this.f5083f.a();
            }
        });
    }

    @Override // cm.aptoide.pt.downloadmanager.FileDownloader
    public rx.b removeDownloadFile() {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.download.f
            @Override // rx.m.a
            public final void call() {
                this.f5082f.b();
            }
        });
    }

    @Override // cm.aptoide.pt.downloadmanager.FileDownloader
    public rx.b startFileDownload() {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.download.h
            @Override // rx.m.a
            public final void call() {
                this.f5084f.c();
            }
        });
    }

    @Override // cm.aptoide.pt.downloadmanager.FileDownloader
    public void stopFailedDownload() {
        int iL = this.fileDownloader.l(this.downloadId, null);
        if (iL != 0) {
            this.fileDownloader.j(iL);
        }
    }
}
