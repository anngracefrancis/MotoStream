package cm.aptoide.pt.downloadmanager;

/* JADX INFO: loaded from: classes.dex */
public interface AppDownloader {
    rx.e<AppDownloadStatus> observeDownloadProgress();

    rx.b pauseAppDownload();

    rx.b removeAppDownload();

    void startAppDownload();

    void stop();
}
