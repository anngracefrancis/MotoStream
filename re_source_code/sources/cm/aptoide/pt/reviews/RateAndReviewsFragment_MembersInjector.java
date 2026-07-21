package cm.aptoide.pt.reviews;

import cm.aptoide.pt.UserFeedbackAnalytics;
import cm.aptoide.pt.app.AppNavigator;
import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.util.MarketResourceFormatter;
import cm.aptoide.pt.view.dialog.DialogUtils;
import javax.inject.Named;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class RateAndReviewsFragment_MembersInjector implements f.a<RateAndReviewsFragment> {
    private final Provider<AppNavigator> appNavigatorProvider;
    private final Provider<AptoideInstalledAppsRepository> aptoideInstalledAppsRepositoryProvider;
    private final Provider<DialogUtils> dialogUtilsProvider;
    private final Provider<String> marketNameProvider;
    private final Provider<MarketResourceFormatter> marketResourceFormatterProvider;
    private final Provider<StoreCredentialsProvider> storeCredentialsProvider;
    private final Provider<ThemeManager> themeManagerProvider;
    private final Provider<UserFeedbackAnalytics> userFeedbackAnalyticsProvider;

    public RateAndReviewsFragment_MembersInjector(Provider<AppNavigator> provider, Provider<String> provider2, Provider<MarketResourceFormatter> provider3, Provider<ThemeManager> provider4, Provider<DialogUtils> provider5, Provider<AptoideInstalledAppsRepository> provider6, Provider<StoreCredentialsProvider> provider7, Provider<UserFeedbackAnalytics> provider8) {
        this.appNavigatorProvider = provider;
        this.marketNameProvider = provider2;
        this.marketResourceFormatterProvider = provider3;
        this.themeManagerProvider = provider4;
        this.dialogUtilsProvider = provider5;
        this.aptoideInstalledAppsRepositoryProvider = provider6;
        this.storeCredentialsProvider = provider7;
        this.userFeedbackAnalyticsProvider = provider8;
    }

    public static f.a<RateAndReviewsFragment> create(Provider<AppNavigator> provider, Provider<String> provider2, Provider<MarketResourceFormatter> provider3, Provider<ThemeManager> provider4, Provider<DialogUtils> provider5, Provider<AptoideInstalledAppsRepository> provider6, Provider<StoreCredentialsProvider> provider7, Provider<UserFeedbackAnalytics> provider8) {
        return new RateAndReviewsFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static void injectAppNavigator(RateAndReviewsFragment rateAndReviewsFragment, AppNavigator appNavigator) {
        rateAndReviewsFragment.appNavigator = appNavigator;
    }

    public static void injectAptoideInstalledAppsRepository(RateAndReviewsFragment rateAndReviewsFragment, AptoideInstalledAppsRepository aptoideInstalledAppsRepository) {
        rateAndReviewsFragment.aptoideInstalledAppsRepository = aptoideInstalledAppsRepository;
    }

    public static void injectDialogUtils(RateAndReviewsFragment rateAndReviewsFragment, DialogUtils dialogUtils) {
        rateAndReviewsFragment.dialogUtils = dialogUtils;
    }

    @Named
    public static void injectMarketName(RateAndReviewsFragment rateAndReviewsFragment, String str) {
        rateAndReviewsFragment.marketName = str;
    }

    public static void injectMarketResourceFormatter(RateAndReviewsFragment rateAndReviewsFragment, MarketResourceFormatter marketResourceFormatter) {
        rateAndReviewsFragment.marketResourceFormatter = marketResourceFormatter;
    }

    public static void injectStoreCredentialsProvider(RateAndReviewsFragment rateAndReviewsFragment, StoreCredentialsProvider storeCredentialsProvider) {
        rateAndReviewsFragment.storeCredentialsProvider = storeCredentialsProvider;
    }

    public static void injectThemeManager(RateAndReviewsFragment rateAndReviewsFragment, ThemeManager themeManager) {
        rateAndReviewsFragment.themeManager = themeManager;
    }

    public static void injectUserFeedbackAnalytics(RateAndReviewsFragment rateAndReviewsFragment, UserFeedbackAnalytics userFeedbackAnalytics) {
        rateAndReviewsFragment.userFeedbackAnalytics = userFeedbackAnalytics;
    }

    public void injectMembers(RateAndReviewsFragment rateAndReviewsFragment) {
        injectAppNavigator(rateAndReviewsFragment, this.appNavigatorProvider.get());
        injectMarketName(rateAndReviewsFragment, this.marketNameProvider.get());
        injectMarketResourceFormatter(rateAndReviewsFragment, this.marketResourceFormatterProvider.get());
        injectThemeManager(rateAndReviewsFragment, this.themeManagerProvider.get());
        injectDialogUtils(rateAndReviewsFragment, this.dialogUtilsProvider.get());
        injectAptoideInstalledAppsRepository(rateAndReviewsFragment, this.aptoideInstalledAppsRepositoryProvider.get());
        injectStoreCredentialsProvider(rateAndReviewsFragment, this.storeCredentialsProvider.get());
        injectUserFeedbackAnalytics(rateAndReviewsFragment, this.userFeedbackAnalyticsProvider.get());
    }
}
