package cm.aptoide.pt.view;

import android.content.SharedPreferences;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.UserFeedbackAnalytics;
import cm.aptoide.pt.account.view.AccountNavigator;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.util.MarketResourceFormatter;
import cm.aptoide.pt.view.dialog.DialogUtils;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvidesDialogUtilsFactory implements Provider {
    private final Provider<AptoideAccountManager> accountManagerProvider;
    private final Provider<AccountNavigator> accountNavigatorProvider;
    private final Provider<AptoideInstalledAppsRepository> aptoideInstalledAppsRepositoryProvider;
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorProvider;
    private final Provider<Converter.Factory> converterFactoryProvider;
    private final Provider<OkHttpClient> httpClientProvider;
    private final Provider<MarketResourceFormatter> marketResourceFormatterProvider;
    private final ActivityModule module;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<ThemeManager> themeManagerProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;
    private final Provider<UserFeedbackAnalytics> userFeedbackAnalayticsProvider;

    public ActivityModule_ProvidesDialogUtilsFactory(ActivityModule activityModule, Provider<AptoideAccountManager> provider, Provider<AccountNavigator> provider2, Provider<BodyInterceptor<BaseBody>> provider3, Provider<OkHttpClient> provider4, Provider<Converter.Factory> provider5, Provider<AptoideInstalledAppsRepository> provider6, Provider<TokenInvalidator> provider7, Provider<SharedPreferences> provider8, Provider<MarketResourceFormatter> provider9, Provider<ThemeManager> provider10, Provider<UserFeedbackAnalytics> provider11) {
        this.module = activityModule;
        this.accountManagerProvider = provider;
        this.accountNavigatorProvider = provider2;
        this.bodyInterceptorProvider = provider3;
        this.httpClientProvider = provider4;
        this.converterFactoryProvider = provider5;
        this.aptoideInstalledAppsRepositoryProvider = provider6;
        this.tokenInvalidatorProvider = provider7;
        this.sharedPreferencesProvider = provider8;
        this.marketResourceFormatterProvider = provider9;
        this.themeManagerProvider = provider10;
        this.userFeedbackAnalayticsProvider = provider11;
    }

    public static ActivityModule_ProvidesDialogUtilsFactory create(ActivityModule activityModule, Provider<AptoideAccountManager> provider, Provider<AccountNavigator> provider2, Provider<BodyInterceptor<BaseBody>> provider3, Provider<OkHttpClient> provider4, Provider<Converter.Factory> provider5, Provider<AptoideInstalledAppsRepository> provider6, Provider<TokenInvalidator> provider7, Provider<SharedPreferences> provider8, Provider<MarketResourceFormatter> provider9, Provider<ThemeManager> provider10, Provider<UserFeedbackAnalytics> provider11) {
        return new ActivityModule_ProvidesDialogUtilsFactory(activityModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static DialogUtils providesDialogUtils(ActivityModule activityModule, AptoideAccountManager aptoideAccountManager, AccountNavigator accountNavigator, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, AptoideInstalledAppsRepository aptoideInstalledAppsRepository, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, MarketResourceFormatter marketResourceFormatter, ThemeManager themeManager, UserFeedbackAnalytics userFeedbackAnalytics) {
        return (DialogUtils) f.b.b.c(activityModule.providesDialogUtils(aptoideAccountManager, accountNavigator, bodyInterceptor, okHttpClient, factory, aptoideInstalledAppsRepository, tokenInvalidator, sharedPreferences, marketResourceFormatter, themeManager, userFeedbackAnalytics));
    }

    @Override // javax.inject.Provider
    public DialogUtils get() {
        return providesDialogUtils(this.module, this.accountManagerProvider.get(), this.accountNavigatorProvider.get(), this.bodyInterceptorProvider.get(), this.httpClientProvider.get(), this.converterFactoryProvider.get(), this.aptoideInstalledAppsRepositoryProvider.get(), this.tokenInvalidatorProvider.get(), this.sharedPreferencesProvider.get(), this.marketResourceFormatterProvider.get(), this.themeManagerProvider.get(), this.userFeedbackAnalayticsProvider.get());
    }
}
