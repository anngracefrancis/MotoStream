package cm.aptoide.pt.wallet;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import cm.aptoide.pt.R;
import cm.aptoide.pt.app.DownloadModel;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.promotions.WalletApp;
import cm.aptoide.pt.utils.GenericDialogs;
import cm.aptoide.pt.view.ActivityView;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: WalletInstallActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u001aH\u0002J\u001a\u0010\"\u001a\u00020\u000f2\b\u0010#\u001a\u0004\u0018\u00010\u001a2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u000fH\u0016J;\u0010'\u001a\u00020\u000f*\u00020(2*\u0010)\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020,0+0*\"\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020,0+¢\u0006\u0002\u0010-R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006."}, d2 = {"Lcm/aptoide/pt/wallet/WalletInstallActivity;", "Lcm/aptoide/pt/view/ActivityView;", "Lcm/aptoide/pt/wallet/WalletInstallView;", "()V", "presenter", "Lcm/aptoide/pt/wallet/WalletInstallPresenter;", "getPresenter", "()Lcm/aptoide/pt/wallet/WalletInstallPresenter;", "setPresenter", "(Lcm/aptoide/pt/wallet/WalletInstallPresenter;)V", "cancelDownloadButtonClicked", "Lrx/Observable;", "Ljava/lang/Void;", "closeButtonClicked", "dismissDialog", HttpUrl.FRAGMENT_ENCODE_SET, "initStyling", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setDownloadProgress", "downloadModel", "Lcm/aptoide/pt/app/DownloadModel;", "showDownloadState", "showErrorMessage", "errorMessage", HttpUrl.FRAGMENT_ENCODE_SET, "showIndeterminateDownload", "showInstallationSuccessView", "showRootInstallWarningPopup", HttpUrl.FRAGMENT_ENCODE_SET, "showSdkErrorView", "showSuccessView", "title", "showWalletInstallationView", "appIcon", "walletApp", "Lcm/aptoide/pt/promotions/WalletApp;", "showWalletInstalledAlreadyView", "setSubstringTypeface", "Landroid/widget/TextView;", "textsToStyle", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/Pair;", HttpUrl.FRAGMENT_ENCODE_SET, "(Landroid/widget/TextView;[Lkotlin/Pair;)V", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletInstallActivity extends ActivityView implements WalletInstallView {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    @Inject
    public WalletInstallPresenter presenter;

    /* JADX INFO: compiled from: WalletInstallActivity.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DownloadModel.DownloadState.values().length];
            iArr[DownloadModel.DownloadState.ACTIVE.ordinal()] = 1;
            iArr[DownloadModel.DownloadState.PAUSE.ordinal()] = 2;
            iArr[DownloadModel.DownloadState.INDETERMINATE.ordinal()] = 3;
            iArr[DownloadModel.DownloadState.INSTALLING.ordinal()] = 4;
            iArr[DownloadModel.DownloadState.COMPLETE.ordinal()] = 5;
            iArr[DownloadModel.DownloadState.ERROR.ordinal()] = 6;
            iArr[DownloadModel.DownloadState.NOT_ENOUGH_STORAGE_ERROR.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void initStyling() {
        String string = getString(R.string.wallet_install_appcoins_wallet);
        kotlin.jvm.internal.m.e(string, "getString(R.string.wallet_install_appcoins_wallet)");
        String string2 = getString(R.string.wallet_install_request_message_body, new Object[]{string});
        kotlin.jvm.internal.m.e(string2, "getString(R.string.walle…sage_body, walletAppName)");
        int i2 = R.id.message_textview;
        ((TextView) _$_findCachedViewById(i2)).setText(string2);
        TextView textView = (TextView) _$_findCachedViewById(i2);
        kotlin.jvm.internal.m.e(textView, "message_textview");
        setSubstringTypeface(textView, new Pair<>(string, 1));
    }

    private final void setDownloadProgress(DownloadModel downloadModel) {
        _$_findCachedViewById(R.id.wallet_install_download_view).setVisibility(0);
        DownloadModel.DownloadState downloadState = downloadModel.getDownloadState();
        switch (downloadState == null ? -1 : WhenMappings.$EnumSwitchMapping$0[downloadState.ordinal()]) {
            case 1:
            case 2:
                ((Group) _$_findCachedViewById(R.id.wallet_install_view_group)).setVisibility(0);
                ((ImageView) _$_findCachedViewById(R.id.wallet_download_cancel_button)).setVisibility(0);
                int i2 = R.id.wallet_download_progress_bar;
                ((ProgressBar) _$_findCachedViewById(i2)).setIndeterminate(false);
                ((ProgressBar) _$_findCachedViewById(i2)).setProgress(downloadModel.getProgress());
                int i3 = R.id.wallet_download_progress_number;
                TextView textView = (TextView) _$_findCachedViewById(i3);
                StringBuilder sb = new StringBuilder();
                sb.append(downloadModel.getProgress());
                sb.append('%');
                textView.setText(sb.toString());
                ((TextView) _$_findCachedViewById(i3)).setVisibility(0);
                return;
            case 3:
                ((ProgressBar) _$_findCachedViewById(R.id.wallet_download_progress_bar)).setIndeterminate(true);
                ((Group) _$_findCachedViewById(R.id.wallet_install_view_group)).setVisibility(0);
                ((ImageView) _$_findCachedViewById(R.id.wallet_download_cancel_button)).setVisibility(0);
                return;
            case 4:
            case 5:
                ((ProgressBar) _$_findCachedViewById(R.id.wallet_download_progress_bar)).setIndeterminate(true);
                ((TextView) _$_findCachedViewById(R.id.wallet_download_progress_number)).setVisibility(8);
                ((Group) _$_findCachedViewById(R.id.wallet_install_view_group)).setVisibility(0);
                ((ImageView) _$_findCachedViewById(R.id.wallet_download_cancel_button)).setVisibility(4);
                return;
            case 6:
                String string = getString(R.string.error_occured);
                kotlin.jvm.internal.m.e(string, "getString(R.string.error_occured)");
                showErrorMessage(string);
                return;
            case 7:
                String string2 = getString(R.string.out_of_space_dialog_title);
                kotlin.jvm.internal.m.e(string2, "getString(R.string.out_of_space_dialog_title)");
                showErrorMessage(string2);
                return;
            default:
                throw new IllegalArgumentException("Invalid download state" + downloadModel.getDownloadState());
        }
    }

    private final void showErrorMessage(String errorMessage) {
        ((TextView) _$_findCachedViewById(R.id.wallet_download_download_state)).setText(errorMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showRootInstallWarningPopup$lambda-2, reason: not valid java name */
    public static final Boolean m315showRootInstallWarningPopup$lambda2(GenericDialogs.EResponse eResponse) {
        return Boolean.valueOf(eResponse.equals(GenericDialogs.EResponse.YES));
    }

    private final void showSuccessView(String title) {
        ((ImageView) _$_findCachedViewById(R.id.app_icon_imageview)).setImageDrawable(getResources().getDrawable(R.drawable.ic_check_orange_gradient_start));
        int i2 = R.id.message_textview;
        ((TextView) _$_findCachedViewById(i2)).setText(title);
        TextView textView = (TextView) _$_findCachedViewById(i2);
        kotlin.jvm.internal.m.e(textView, "message_textview");
        setSubstringTypeface(textView, new Pair<>(title, 1));
        ((ProgressBar) _$_findCachedViewById(R.id.progress_view)).setVisibility(8);
        ((Group) _$_findCachedViewById(R.id.wallet_install_success_view_group)).setVisibility(0);
        ((Button) _$_findCachedViewById(R.id.close_button)).setVisibility(0);
        ((Group) _$_findCachedViewById(R.id.wallet_install_view_group)).setVisibility(0);
        _$_findCachedViewById(R.id.wallet_install_download_view).setVisibility(8);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i2);
        if (viewFindViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), viewFindViewById);
        return viewFindViewById;
    }

    @Override // cm.aptoide.pt.wallet.WalletInstallView
    public rx.e<Void> cancelDownloadButtonClicked() {
        rx.e<Void> eVarA = e.g.a.c.a.a((ImageView) _$_findCachedViewById(R.id.wallet_download_cancel_button));
        kotlin.jvm.internal.m.e(eVarA, "clicks(wallet_download_cancel_button)");
        return eVarA;
    }

    @Override // cm.aptoide.pt.wallet.WalletInstallView
    public rx.e<Void> closeButtonClicked() {
        rx.e<Void> eVarA = e.g.a.c.a.a((Button) _$_findCachedViewById(R.id.close_button));
        kotlin.jvm.internal.m.e(eVarA, "clicks(close_button)");
        return eVarA;
    }

    @Override // cm.aptoide.pt.wallet.WalletInstallView
    public void dismissDialog() {
        finish();
    }

    public final WalletInstallPresenter getPresenter() {
        WalletInstallPresenter walletInstallPresenter = this.presenter;
        if (walletInstallPresenter != null) {
            return walletInstallPresenter;
        }
        kotlin.jvm.internal.m.w("presenter");
        return null;
    }

    @Override // cm.aptoide.pt.analytics.view.AnalyticsActivity, cm.aptoide.pt.permission.PermissionProviderActivity, cm.aptoide.pt.permission.PermissionServiceActivity, cm.aptoide.pt.navigator.ActivityResultNavigator, cm.aptoide.pt.view.BaseActivity, com.trello.rxlifecycle.h.a.a, androidx.appcompat.app.d, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.wallet_install_activity);
        initStyling();
        attachPresenter(getPresenter());
    }

    public final void setPresenter(WalletInstallPresenter walletInstallPresenter) {
        kotlin.jvm.internal.m.f(walletInstallPresenter, "<set-?>");
        this.presenter = walletInstallPresenter;
    }

    public final void setSubstringTypeface(TextView textView, Pair<String, Integer>... pairArr) {
        kotlin.jvm.internal.m.f(textView, "<this>");
        kotlin.jvm.internal.m.f(pairArr, "textsToStyle");
        SpannableString spannableString = new SpannableString(textView.getText());
        for (Pair<String, Integer> pair : pairArr) {
            int iW = kotlin.text.v.W(textView.getText().toString(), pair.c(), 0, false, 6, null);
            int length = pair.c().length() + iW;
            if (iW >= 0) {
                spannableString.setSpan(new StyleSpan(pair.d().intValue()), iW, length, 33);
            }
        }
        textView.setText(spannableString, TextView.BufferType.SPANNABLE);
    }

    @Override // cm.aptoide.pt.wallet.WalletInstallView
    public void showDownloadState(DownloadModel downloadModel) {
        kotlin.jvm.internal.m.f(downloadModel, "downloadModel");
        if (downloadModel.isDownloadingOrInstalling()) {
            _$_findCachedViewById(R.id.wallet_install_download_view).setVisibility(0);
            setDownloadProgress(downloadModel);
        } else {
            _$_findCachedViewById(R.id.wallet_install_download_view).setVisibility(8);
            ((ProgressBar) _$_findCachedViewById(R.id.progress_view)).setVisibility(8);
            ((Group) _$_findCachedViewById(R.id.wallet_install_view_group)).setVisibility(0);
        }
    }

    @Override // cm.aptoide.pt.wallet.WalletInstallView
    public void showIndeterminateDownload() {
        _$_findCachedViewById(R.id.wallet_install_download_view).setVisibility(0);
        ((ProgressBar) _$_findCachedViewById(R.id.wallet_download_progress_bar)).setIndeterminate(true);
        ((Group) _$_findCachedViewById(R.id.wallet_install_view_group)).setVisibility(0);
    }

    @Override // cm.aptoide.pt.wallet.WalletInstallView
    public void showInstallationSuccessView() {
        ((TextView) _$_findCachedViewById(R.id.install_complete_message)).setVisibility(4);
        String string = getString(R.string.wallet_install_complete_title);
        kotlin.jvm.internal.m.e(string, "getString(R.string.wallet_install_complete_title)");
        showSuccessView(string);
    }

    @Override // cm.aptoide.pt.wallet.WalletInstallView
    public rx.e<Boolean> showRootInstallWarningPopup() {
        rx.e eVarX = GenericDialogs.createGenericYesNoCancelMessage(getApplicationContext(), null, getResources().getString(R.string.root_access_dialog), this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId).X(new rx.m.e() { // from class: cm.aptoide.pt.wallet.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return WalletInstallActivity.m315showRootInstallWarningPopup$lambda2((GenericDialogs.EResponse) obj);
            }
        });
        kotlin.jvm.internal.m.e(eVarX, "createGenericYesNoCancel…cDialogs.EResponse.YES) }");
        return eVarX;
    }

    @Override // cm.aptoide.pt.wallet.WalletInstallView
    public void showSdkErrorView() {
        ((Group) _$_findCachedViewById(R.id.sdk_error_view_group)).setVisibility(0);
        ((ProgressBar) _$_findCachedViewById(R.id.progress_view)).setVisibility(8);
        ((Button) _$_findCachedViewById(R.id.close_button)).setVisibility(0);
        ((Group) _$_findCachedViewById(R.id.wallet_install_success_view_group)).setVisibility(8);
        ((Group) _$_findCachedViewById(R.id.wallet_install_view_group)).setVisibility(4);
    }

    @Override // cm.aptoide.pt.wallet.WalletInstallView
    public void showWalletInstallationView(String appIcon, WalletApp walletApp) {
        kotlin.jvm.internal.m.f(walletApp, "walletApp");
        int i2 = R.id.progress_view;
        ((ProgressBar) _$_findCachedViewById(i2)).setVisibility(8);
        ((Group) _$_findCachedViewById(R.id.wallet_install_success_view_group)).setVisibility(8);
        ((Button) _$_findCachedViewById(R.id.close_button)).setVisibility(8);
        if (appIcon != null) {
            ImageLoader.with(this).load(appIcon, (ImageView) _$_findCachedViewById(R.id.app_icon_imageview));
        }
        DownloadModel downloadModel = walletApp.getDownloadModel();
        if (downloadModel != null) {
            Logger.getInstance().d("WalletInstallActivity", "download state is " + downloadModel.getDownloadState());
            if (downloadModel.isDownloading()) {
                setDownloadProgress(downloadModel);
                return;
            }
            _$_findCachedViewById(R.id.wallet_install_download_view).setVisibility(8);
            ((ProgressBar) _$_findCachedViewById(i2)).setVisibility(8);
            ((Group) _$_findCachedViewById(R.id.wallet_install_view_group)).setVisibility(0);
        }
    }

    @Override // cm.aptoide.pt.wallet.WalletInstallView
    public void showWalletInstalledAlreadyView() {
        ((TextView) _$_findCachedViewById(R.id.install_complete_message)).setText(getString(R.string.wallet_install_request_already_installed_body));
        String string = getString(R.string.wallet_install_request_already_installed_title);
        kotlin.jvm.internal.m.e(string, "getString(R.string.walle…_already_installed_title)");
        showSuccessView(string);
    }
}
