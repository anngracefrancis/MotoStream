package cm.aptoide.pt.download;

import cm.aptoide.pt.downloadmanager.AppDownloadStatus;
import cm.aptoide.pt.downloadmanager.DownloadError;
import cm.aptoide.pt.downloadmanager.FileDownloadCallback;
import cm.aptoide.pt.downloadmanager.FileDownloadProgressResult;
import cm.aptoide.pt.logger.Logger;
import com.liulishuo.filedownloader.exception.FileDownloadHttpException;
import com.liulishuo.filedownloader.exception.FileDownloadOutOfSpaceException;

/* JADX INFO: loaded from: classes.dex */
public class FileDownloadTask extends e.h.a.g {
    private static final int FILE_NOT_FOUND_HTTP_ERROR = 404;
    private final String TAG = "FileDownloader";
    private final String attributionId;
    private final rx.s.b<FileDownloadCallback> downloadStatus;
    private final String fileName;
    private final int fileType;
    private final String md5;
    private final Md5Comparator md5Comparator;
    private final boolean shouldConfirmMd5;

    public FileDownloadTask(rx.s.b<FileDownloadCallback> bVar, String str, Md5Comparator md5Comparator, String str2, String str3, boolean z, int i2) {
        this.downloadStatus = bVar;
        this.md5 = str;
        this.md5Comparator = md5Comparator;
        this.fileName = str2;
        this.attributionId = str3;
        this.shouldConfirmMd5 = z;
        this.fileType = i2;
    }

    private boolean isMd5Approved(String str, String str2, boolean z) {
        if (z) {
            return this.md5Comparator.compareMd5(str, str2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$completed$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(e.h.a.a aVar) {
        FileDownloadTaskStatus fileDownloadTaskStatus;
        this.downloadStatus.onNext(new FileDownloadTaskStatus(AppDownloadStatus.AppDownloadState.VERIFYING_FILE_INTEGRITY, new FileDownloadProgressResult(aVar.E(), aVar.E()), this.md5, aVar.c(), this.fileType));
        if (this.attributionId != null || isMd5Approved(this.md5, this.fileName, this.shouldConfirmMd5)) {
            fileDownloadTaskStatus = new FileDownloadTaskStatus(AppDownloadStatus.AppDownloadState.COMPLETED, new FileDownloadProgressResult(aVar.E(), aVar.E()), this.md5, aVar.c(), this.fileType);
            Logger.getInstance().d("FileDownloader", " Download completed");
        } else {
            Logger.getInstance().d("FileDownloader", " Download error in md5");
            fileDownloadTaskStatus = new FileDownloadTaskStatus(AppDownloadStatus.AppDownloadState.ERROR_MD5_DOES_NOT_MATCH, this.md5, new DownloadError(new Md5DownloadComparisonException("md5 does not match"), "not_http", aVar.n()), aVar.c(), this.fileType);
        }
        this.downloadStatus.onNext(fileDownloadTaskStatus);
    }

    @Override // e.h.a.i
    protected void completed(final e.h.a.a aVar) {
        new Thread(new Runnable() { // from class: cm.aptoide.pt.download.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f5085f.a(aVar);
            }
        }).start();
    }

    @Override // e.h.a.i
    protected void error(e.h.a.a aVar, Throwable th) {
        FileDownloadTaskStatus fileDownloadTaskStatus;
        if (th != null) {
            th.printStackTrace();
            if (th instanceof FileDownloadHttpException) {
                int iB = ((FileDownloadHttpException) th).b();
                if (iB == FILE_NOT_FOUND_HTTP_ERROR) {
                    Logger.getInstance().d("FileDownloader", "File not found error on app: " + this.md5);
                    fileDownloadTaskStatus = new FileDownloadTaskStatus(AppDownloadStatus.AppDownloadState.ERROR_FILE_NOT_FOUND, this.md5, new DownloadError(th, String.valueOf(iB), aVar.n()), aVar.c(), this.fileType);
                } else {
                    Logger.getInstance().d("FileDownloader", "Http error + " + iB + " on app: " + this.md5);
                    fileDownloadTaskStatus = new FileDownloadTaskStatus(AppDownloadStatus.AppDownloadState.ERROR, this.md5, new DownloadError(th, String.valueOf(iB), aVar.n()), aVar.c(), this.fileType);
                }
            } else if (th instanceof FileDownloadOutOfSpaceException) {
                Logger.getInstance().d("FileDownloader", "Out of space error for the app: " + this.md5);
                fileDownloadTaskStatus = new FileDownloadTaskStatus(AppDownloadStatus.AppDownloadState.ERROR_NOT_ENOUGH_SPACE, this.md5, new DownloadError(th, "not_http", aVar.n()), aVar.c(), this.fileType);
            } else {
                Logger.getInstance().d("FileDownloader", "Generic error on app: " + this.md5);
                fileDownloadTaskStatus = new FileDownloadTaskStatus(AppDownloadStatus.AppDownloadState.ERROR, this.md5, new DownloadError(th, "not_http", aVar.n()), aVar.c(), this.fileType);
            }
        } else {
            Logger.getInstance().d("FileDownloader", "Unknown error on app: " + this.md5);
            fileDownloadTaskStatus = new FileDownloadTaskStatus(AppDownloadStatus.AppDownloadState.ERROR, this.md5, new DownloadError(new GeneralDownloadErrorException("Empty download error"), "not_http", aVar.n()), aVar.c(), this.fileType);
        }
        this.downloadStatus.onNext(fileDownloadTaskStatus);
    }

    public rx.e<FileDownloadCallback> onDownloadStateChanged() {
        return this.downloadStatus;
    }

    @Override // e.h.a.g
    protected void paused(e.h.a.a aVar, long j2, long j3) {
        this.downloadStatus.onNext(new FileDownloadTaskStatus(AppDownloadStatus.AppDownloadState.PAUSED, new FileDownloadProgressResult(j2, j3), this.md5, aVar.c(), this.fileType));
    }

    @Override // e.h.a.g
    protected void pending(e.h.a.a aVar, long j2, long j3) {
        this.downloadStatus.onNext(new FileDownloadTaskStatus(AppDownloadStatus.AppDownloadState.PENDING, new FileDownloadProgressResult(j2, j3), this.md5, aVar.c(), this.fileType));
    }

    @Override // e.h.a.g
    protected void progress(e.h.a.a aVar, long j2, long j3) {
        this.downloadStatus.onNext(new FileDownloadTaskStatus(AppDownloadStatus.AppDownloadState.PROGRESS, new FileDownloadProgressResult(j2, j3), this.md5, aVar.c(), this.fileType));
    }

    @Override // e.h.a.i
    protected void warn(e.h.a.a aVar) {
        this.downloadStatus.onNext(new FileDownloadTaskStatus(AppDownloadStatus.AppDownloadState.WARN, this.md5, (DownloadError) null, aVar.c(), this.fileType));
    }
}
