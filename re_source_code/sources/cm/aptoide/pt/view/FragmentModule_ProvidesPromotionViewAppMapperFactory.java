package cm.aptoide.pt.view;

import cm.aptoide.pt.app.DownloadStateParser;
import cm.aptoide.pt.promotions.PromotionViewAppMapper;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesPromotionViewAppMapperFactory implements Provider {
    private final Provider<DownloadStateParser> downloadStateParserProvider;
    private final FragmentModule module;

    public FragmentModule_ProvidesPromotionViewAppMapperFactory(FragmentModule fragmentModule, Provider<DownloadStateParser> provider) {
        this.module = fragmentModule;
        this.downloadStateParserProvider = provider;
    }

    public static FragmentModule_ProvidesPromotionViewAppMapperFactory create(FragmentModule fragmentModule, Provider<DownloadStateParser> provider) {
        return new FragmentModule_ProvidesPromotionViewAppMapperFactory(fragmentModule, provider);
    }

    public static PromotionViewAppMapper providesPromotionViewAppMapper(FragmentModule fragmentModule, DownloadStateParser downloadStateParser) {
        return (PromotionViewAppMapper) f.b.b.c(fragmentModule.providesPromotionViewAppMapper(downloadStateParser));
    }

    @Override // javax.inject.Provider
    public PromotionViewAppMapper get() {
        return providesPromotionViewAppMapper(this.module, this.downloadStateParserProvider.get());
    }
}
