package cm.aptoide.pt.app.view;

import cm.aptoide.pt.database.RoomStoredMinimalAdPersistence;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.dialog.DialogUtils;
import java.text.DecimalFormat;
import javax.inject.Named;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class AppViewFragment_MembersInjector implements f.a<AppViewFragment> {
    private final Provider<DialogUtils> dialogUtilsProvider;
    private final Provider<String> marketNameProvider;
    private final Provider<DecimalFormat> oneDecimalFormatProvider;
    private final Provider<AppViewPresenter> presenterProvider;
    private final Provider<RoomStoredMinimalAdPersistence> roomStoredMinimalAdPersistenceProvider;
    private final Provider<ThemeManager> themeManagerProvider;

    public AppViewFragment_MembersInjector(Provider<AppViewPresenter> provider, Provider<DialogUtils> provider2, Provider<String> provider3, Provider<DecimalFormat> provider4, Provider<ThemeManager> provider5, Provider<RoomStoredMinimalAdPersistence> provider6) {
        this.presenterProvider = provider;
        this.dialogUtilsProvider = provider2;
        this.marketNameProvider = provider3;
        this.oneDecimalFormatProvider = provider4;
        this.themeManagerProvider = provider5;
        this.roomStoredMinimalAdPersistenceProvider = provider6;
    }

    public static f.a<AppViewFragment> create(Provider<AppViewPresenter> provider, Provider<DialogUtils> provider2, Provider<String> provider3, Provider<DecimalFormat> provider4, Provider<ThemeManager> provider5, Provider<RoomStoredMinimalAdPersistence> provider6) {
        return new AppViewFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static void injectDialogUtils(AppViewFragment appViewFragment, DialogUtils dialogUtils) {
        appViewFragment.dialogUtils = dialogUtils;
    }

    @Named
    public static void injectMarketName(AppViewFragment appViewFragment, String str) {
        appViewFragment.marketName = str;
    }

    @Named
    public static void injectOneDecimalFormat(AppViewFragment appViewFragment, DecimalFormat decimalFormat) {
        appViewFragment.oneDecimalFormat = decimalFormat;
    }

    public static void injectPresenter(AppViewFragment appViewFragment, AppViewPresenter appViewPresenter) {
        appViewFragment.presenter = appViewPresenter;
    }

    public static void injectRoomStoredMinimalAdPersistence(AppViewFragment appViewFragment, RoomStoredMinimalAdPersistence roomStoredMinimalAdPersistence) {
        appViewFragment.roomStoredMinimalAdPersistence = roomStoredMinimalAdPersistence;
    }

    public static void injectThemeManager(AppViewFragment appViewFragment, ThemeManager themeManager) {
        appViewFragment.themeManager = themeManager;
    }

    public void injectMembers(AppViewFragment appViewFragment) {
        injectPresenter(appViewFragment, this.presenterProvider.get());
        injectDialogUtils(appViewFragment, this.dialogUtilsProvider.get());
        injectMarketName(appViewFragment, this.marketNameProvider.get());
        injectOneDecimalFormat(appViewFragment, this.oneDecimalFormatProvider.get());
        injectThemeManager(appViewFragment, this.themeManagerProvider.get());
        injectRoomStoredMinimalAdPersistence(appViewFragment, this.roomStoredMinimalAdPersistenceProvider.get());
    }
}
