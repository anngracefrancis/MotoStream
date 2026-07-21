package cm.aptoide.pt.download;

import cm.aptoide.pt.downloadmanager.FileDownloadCallback;
import cm.aptoide.pt.downloadmanager.FileDownloader;
import cm.aptoide.pt.downloadmanager.FileDownloaderProvider;
import e.h.a.q;

/* JADX INFO: loaded from: classes.dex */
public class FileDownloadManagerProvider implements FileDownloaderProvider {
    private final String downloadsPath;
    private final q fileDownloader;
    private final Md5Comparator md5Comparator;

    public FileDownloadManagerProvider(String str, q qVar, Md5Comparator md5Comparator) {
        this.downloadsPath = str;
        this.fileDownloader = qVar;
        this.md5Comparator = md5Comparator;
    }

    @Override // cm.aptoide.pt.downloadmanager.FileDownloaderProvider
    public FileDownloader createFileDownloader(String str, String str2, int i2, String str3, int i3, String str4, rx.s.b<FileDownloadCallback> bVar, String str5) {
        return new FileDownloadManager(this.fileDownloader, new FileDownloadTask(bVar, str, this.md5Comparator, str4, str5, !str3.equals("com.igg.android.lordsmobile"), i2), this.downloadsPath, str2, i2, str3, i3, str4);
    }
}
