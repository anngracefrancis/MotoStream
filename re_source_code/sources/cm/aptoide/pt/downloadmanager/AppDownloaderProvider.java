package cm.aptoide.pt.downloadmanager;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class AppDownloaderProvider {
    private final DownloadAnalytics downloadAnalytics;
    private final RetryFileDownloaderProvider fileDownloaderProvider;

    public AppDownloaderProvider(RetryFileDownloaderProvider retryFileDownloaderProvider, DownloadAnalytics downloadAnalytics) {
        this.fileDownloaderProvider = retryFileDownloaderProvider;
        this.downloadAnalytics = downloadAnalytics;
    }

    public AppDownloader getAppDownloader(DownloadApp downloadApp) {
        return new AppDownloadManager(this.fileDownloaderProvider, downloadApp, new HashMap(), this.downloadAnalytics);
    }
}
