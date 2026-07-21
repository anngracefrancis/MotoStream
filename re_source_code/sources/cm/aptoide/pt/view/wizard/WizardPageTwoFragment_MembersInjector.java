package cm.aptoide.pt.view.wizard;

import cm.aptoide.pt.util.MarketResourceFormatter;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class WizardPageTwoFragment_MembersInjector implements f.a<WizardPageTwoFragment> {
    private final Provider<MarketResourceFormatter> marketResourceFormatterProvider;

    public WizardPageTwoFragment_MembersInjector(Provider<MarketResourceFormatter> provider) {
        this.marketResourceFormatterProvider = provider;
    }

    public static f.a<WizardPageTwoFragment> create(Provider<MarketResourceFormatter> provider) {
        return new WizardPageTwoFragment_MembersInjector(provider);
    }

    public static void injectMarketResourceFormatter(WizardPageTwoFragment wizardPageTwoFragment, MarketResourceFormatter marketResourceFormatter) {
        wizardPageTwoFragment.marketResourceFormatter = marketResourceFormatter;
    }

    public void injectMembers(WizardPageTwoFragment wizardPageTwoFragment) {
        injectMarketResourceFormatter(wizardPageTwoFragment, this.marketResourceFormatterProvider.get());
    }
}
