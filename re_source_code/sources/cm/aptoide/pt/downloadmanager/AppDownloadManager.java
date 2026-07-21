package cm.aptoide.pt.downloadmanager;

import cm.aptoide.pt.logger.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class AppDownloadManager implements AppDownloader {
    private static final String TAG = "AppDownloadManager";
    private final DownloadApp app;
    private AppDownloadStatus appDownloadStatus;
    private DownloadAnalytics downloadAnalytics;
    private rx.s.b<FileDownloadCallback> fileDownloadSubject = rx.s.b.g1();
    private HashMap<String, RetryFileDownloader> fileDownloaderPersistence;
    private RetryFileDownloaderProvider fileDownloaderProvider;
    private rx.k subscribe;

    /* JADX INFO: renamed from: cm.aptoide.pt.downloadmanager.AppDownloadManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$downloadmanager$AppDownloadStatus$AppDownloadState;

        static {
            int[] iArr = new int[AppDownloadStatus.AppDownloadState.values().length];
            $SwitchMap$cm$aptoide$pt$downloadmanager$AppDownloadStatus$AppDownloadState = iArr;
            try {
                iArr[AppDownloadStatus.AppDownloadState.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$downloadmanager$AppDownloadStatus$AppDownloadState[AppDownloadStatus.AppDownloadState.ERROR_FILE_NOT_FOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$downloadmanager$AppDownloadStatus$AppDownloadState[AppDownloadStatus.AppDownloadState.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$downloadmanager$AppDownloadStatus$AppDownloadState[AppDownloadStatus.AppDownloadState.ERROR_NOT_ENOUGH_SPACE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public AppDownloadManager(RetryFileDownloaderProvider retryFileDownloaderProvider, DownloadApp downloadApp, HashMap<String, RetryFileDownloader> map, DownloadAnalytics downloadAnalytics) {
        this.fileDownloaderProvider = retryFileDownloaderProvider;
        this.app = downloadApp;
        this.fileDownloaderPersistence = map;
        this.downloadAnalytics = downloadAnalytics;
        this.appDownloadStatus = new AppDownloadStatus(downloadApp.getMd5(), new ArrayList(), AppDownloadStatus.AppDownloadState.PENDING, downloadApp.getSize());
    }

    private void handleCompletedFileDownload(RetryFileDownloader retryFileDownloader) {
        retryFileDownloader.stop();
    }

    private void handleErrorFileDownload() {
        Iterator<RetryFileDownloader> it = this.fileDownloaderPersistence.values().iterator();
        while (it.hasNext()) {
            it.next().stopFailedDownload();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleFileDownloadProgress, reason: merged with bridge method [inline-methods] */
    public rx.e<FileDownloadCallback> i(final RetryFileDownloader retryFileDownloader) {
        return retryFileDownloader.observeFileDownloadProgress().x(new rx.m.b() { // from class: cm.aptoide.pt.downloadmanager.p
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5233f.a((FileDownloadCallback) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.downloadmanager.j
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5213f.b(retryFileDownloader, (FileDownloadCallback) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleFileDownloadProgress$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(FileDownloadCallback fileDownloadCallback) {
        this.fileDownloadSubject.onNext(fileDownloadCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleFileDownloadProgress$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(RetryFileDownloader retryFileDownloader, FileDownloadCallback fileDownloadCallback) {
        if (fileDownloadCallback.getDownloadState() != null) {
            int i2 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$downloadmanager$AppDownloadStatus$AppDownloadState[fileDownloadCallback.getDownloadState().ordinal()];
            if (i2 == 1) {
                handleCompletedFileDownload(retryFileDownloader);
                return;
            }
            if (i2 == 2 || i2 == 3 || i2 == 4) {
                handleErrorFileDownload();
                if (fileDownloadCallback.hasError()) {
                    this.downloadAnalytics.onError(this.app.getPackageName(), this.app.getVersionCode(), this.app.getMd5(), fileDownloadCallback.getError().getErrorException(), fileDownloadCallback.getError().getUrlError(), fileDownloadCallback.getError().getHttpError(), this.appDownloadStatus.getAverageDownloadSpeed().getAverageApkSpeed(), this.appDownloadStatus.getAverageDownloadSpeed().getAverageObbSpeed(), this.appDownloadStatus.getAverageDownloadSpeed().getAverageSplitSpeed());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$observeDownloadProgress$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e c(FileDownloadCallback fileDownloadCallback) {
        setAppDownloadStatus(fileDownloadCallback);
        return rx.e.S(this.appDownloadStatus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$observeDownloadProgress$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ AppDownloadStatus d(AppDownloadStatus appDownloadStatus) {
        return this.appDownloadStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$pauseAppDownload$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e(DownloadAppFile downloadAppFile) {
        return getFileDownloader(downloadAppFile.getMainDownloadPath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$removeAppDownload$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e f(DownloadAppFile downloadAppFile) {
        return getFileDownloader(downloadAppFile.getMainDownloadPath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$startAppDownload$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e g(DownloadAppFile downloadAppFile) {
        return startFileDownload(downloadAppFile, this.app.getAttributionId());
    }

    static /* synthetic */ void lambda$startAppDownload$1(FileDownloadCallback fileDownloadCallback) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$startFileDownload$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(DownloadAppFile downloadAppFile, RetryFileDownloader retryFileDownloader) {
        this.fileDownloaderPersistence.put(downloadAppFile.getMainDownloadPath(), retryFileDownloader);
    }

    private rx.e<FileDownloadCallback> observeFileDownload() {
        return this.fileDownloadSubject;
    }

    private void setAppDownloadStatus(FileDownloadCallback fileDownloadCallback) {
        this.appDownloadStatus.setFileDownloadCallback(fileDownloadCallback);
    }

    private rx.e<FileDownloadCallback> startFileDownload(final DownloadAppFile downloadAppFile, String str) {
        return rx.e.S(this.fileDownloaderProvider.createRetryFileDownloader(downloadAppFile.getDownloadMd5(), downloadAppFile.getMainDownloadPath(), downloadAppFile.getFileType(), downloadAppFile.getPackageName(), downloadAppFile.getVersionCode(), downloadAppFile.getFileName(), rx.s.b.g1(), downloadAppFile.getAlternativeDownloadPath(), str)).x(new rx.m.b() { // from class: cm.aptoide.pt.downloadmanager.g
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5202f.h(downloadAppFile, (RetryFileDownloader) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.downloadmanager.l
            @Override // rx.m.b
            public final void call(Object obj) {
                Logger.getInstance().d(AppDownloadManager.TAG, "Starting app file download " + downloadAppFile.getFileName());
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.downloadmanager.h
            @Override // rx.m.b
            public final void call(Object obj) {
                ((RetryFileDownloader) obj).startFileDownload();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.downloadmanager.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5198f.i((RetryFileDownloader) obj);
            }
        }).w(u1.f5251f);
    }

    public rx.e<RetryFileDownloader> getFileDownloader(String str) {
        return rx.e.S(this.fileDownloaderPersistence.get(str));
    }

    @Override // cm.aptoide.pt.downloadmanager.AppDownloader
    public rx.e<AppDownloadStatus> observeDownloadProgress() {
        return observeFileDownload().G(new rx.m.e() { // from class: cm.aptoide.pt.downloadmanager.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5187f.c((FileDownloadCallback) obj);
            }
        }).w(new rx.m.b() { // from class: cm.aptoide.pt.downloadmanager.e
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.downloadmanager.s
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5241f.d((AppDownloadStatus) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.downloadmanager.AppDownloader
    public rx.b pauseAppDownload() {
        return rx.e.N(this.app.getDownloadFiles()).G(new rx.m.e() { // from class: cm.aptoide.pt.downloadmanager.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5190f.e((DownloadAppFile) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.downloadmanager.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((RetryFileDownloader) obj) != null);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.downloadmanager.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((RetryFileDownloader) obj).pauseDownload().A();
            }
        }).X0();
    }

    @Override // cm.aptoide.pt.downloadmanager.AppDownloader
    public rx.b removeAppDownload() {
        return rx.e.N(this.app.getDownloadFiles()).G(new rx.m.e() { // from class: cm.aptoide.pt.downloadmanager.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5210f.f((DownloadAppFile) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.downloadmanager.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((RetryFileDownloader) obj).removeDownloadFile().A();
            }
        }).X0();
    }

    @Override // cm.aptoide.pt.downloadmanager.AppDownloader
    public void startAppDownload() {
        this.subscribe = rx.e.N(this.app.getDownloadFiles()).G(new rx.m.e() { // from class: cm.aptoide.pt.downloadmanager.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5217f.g((DownloadAppFile) obj);
            }
        }).H0(new rx.m.b() { // from class: cm.aptoide.pt.downloadmanager.o
            @Override // rx.m.b
            public final void call(Object obj) {
                AppDownloadManager.lambda$startAppDownload$1((FileDownloadCallback) obj);
            }
        }, u1.f5251f);
    }

    @Override // cm.aptoide.pt.downloadmanager.AppDownloader
    public void stop() {
        rx.k kVar = this.subscribe;
        if (kVar == null || kVar.isUnsubscribed()) {
            return;
        }
        this.subscribe.unsubscribe();
        this.fileDownloadSubject = null;
        this.fileDownloaderPersistence.clear();
        this.fileDownloaderPersistence = null;
    }
}
