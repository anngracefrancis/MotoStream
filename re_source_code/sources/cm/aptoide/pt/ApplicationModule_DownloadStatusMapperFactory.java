package cm.aptoide.pt;

import cm.aptoide.pt.downloadmanager.DownloadStatusMapper;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_DownloadStatusMapperFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_DownloadStatusMapperFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_DownloadStatusMapperFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_DownloadStatusMapperFactory(applicationModule);
    }

    public static DownloadStatusMapper downloadStatusMapper(ApplicationModule applicationModule) {
        return (DownloadStatusMapper) f.b.b.c(applicationModule.downloadStatusMapper());
    }

    @Override // javax.inject.Provider
    public DownloadStatusMapper get() {
        return downloadStatusMapper(this.module);
    }
}
