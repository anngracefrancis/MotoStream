package cm.aptoide.pt;

import cm.aptoide.pt.util.MarketResourceFormatter;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideMarketResourceFormatterFactory implements Provider {
    private final Provider<String> marketNameProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvideMarketResourceFormatterFactory(ApplicationModule applicationModule, Provider<String> provider) {
        this.module = applicationModule;
        this.marketNameProvider = provider;
    }

    public static ApplicationModule_ProvideMarketResourceFormatterFactory create(ApplicationModule applicationModule, Provider<String> provider) {
        return new ApplicationModule_ProvideMarketResourceFormatterFactory(applicationModule, provider);
    }

    public static MarketResourceFormatter provideMarketResourceFormatter(ApplicationModule applicationModule, String str) {
        return (MarketResourceFormatter) f.b.b.c(applicationModule.provideMarketResourceFormatter(str));
    }

    @Override // javax.inject.Provider
    public MarketResourceFormatter get() {
        return provideMarketResourceFormatter(this.module, this.marketNameProvider.get());
    }
}
