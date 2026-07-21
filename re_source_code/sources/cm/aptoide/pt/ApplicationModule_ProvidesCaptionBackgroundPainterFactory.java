package cm.aptoide.pt;

import cm.aptoide.pt.editorial.CaptionBackgroundPainter;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesCaptionBackgroundPainterFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesCaptionBackgroundPainterFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesCaptionBackgroundPainterFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesCaptionBackgroundPainterFactory(applicationModule);
    }

    public static CaptionBackgroundPainter providesCaptionBackgroundPainter(ApplicationModule applicationModule) {
        return (CaptionBackgroundPainter) f.b.b.c(applicationModule.providesCaptionBackgroundPainter());
    }

    @Override // javax.inject.Provider
    public CaptionBackgroundPainter get() {
        return providesCaptionBackgroundPainter(this.module);
    }
}
