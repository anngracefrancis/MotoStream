package cm.aptoide.pt.downloadmanager;

/* JADX INFO: loaded from: classes.dex */
public interface FileDownloader {
    rx.e<FileDownloadCallback> observeFileDownloadProgress();

    rx.b pauseDownload();

    rx.b removeDownloadFile();

    rx.b startFileDownload();

    void stopFailedDownload();
}
