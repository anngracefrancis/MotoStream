package cm.aptoide.pt.downloadmanager;

/* JADX INFO: loaded from: classes.dex */
public interface FileDownloadCallback {
    FileDownloadProgressResult getDownloadProgress();

    int getDownloadSpeed();

    AppDownloadStatus.AppDownloadState getDownloadState();

    DownloadError getError();

    int getFileType();

    String getMd5();

    boolean hasError();
}
