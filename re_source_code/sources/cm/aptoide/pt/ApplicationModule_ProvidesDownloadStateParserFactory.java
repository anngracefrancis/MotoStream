package cm.aptoide.pt;

import cm.aptoide.pt.app.DownloadStateParser;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesDownloadStateParserFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesDownloadStateParserFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesDownloadStateParserFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesDownloadStateParserFactory(applicationModule);
    }

    public static DownloadStateParser providesDownloadStateParser(ApplicationModule applicationModule) {
        return (DownloadStateParser) f.b.b.c(applicationModule.providesDownloadStateParser());
    }

    @Override // javax.inject.Provider
    public DownloadStateParser get() {
        return providesDownloadStateParser(this.module);
    }
}
