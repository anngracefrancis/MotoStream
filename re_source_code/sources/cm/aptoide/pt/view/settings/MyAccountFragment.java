package cm.aptoide.pt.view.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.aptoideviews.socialmedia.SocialMediaView;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.MyAccountManager;
import cm.aptoide.pt.R;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStore;
import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.BaseRequestWithStore;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetStoreRequest;
import cm.aptoide.pt.dataprovider.ws.v7.store.StoreContext;
import cm.aptoide.pt.link.CustomTabsHelper;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.socialmedia.SocialMediaAnalytics;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.BackButtonFragment;
import cm.aptoide.pt.view.NotBottomNavigationView;
import javax.inject.Inject;
import javax.inject.Named;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class MyAccountFragment extends BackButtonFragment implements SharedPreferences.OnSharedPreferenceChangeListener, MyAccountView, NotBottomNavigationView {
    private static final float STROKE_SIZE = 0.04f;

    @Inject
    AccountAnalytics accountAnalytics;
    private AptoideAccountManager accountManager;
    private View accountView;
    private CardView aptoideBackupAppsCardView;
    private CardView aptoideTvCardView;
    private CardView aptoideUploaderCardView;
    private BodyInterceptor<BaseBody> bodyInterceptor;
    private Converter.Factory converterFactory;
    private Button createStoreButton;
    private TextView createStoreMessage;
    private Button editProfileButton;
    private Button editStoreButton;
    private OkHttpClient httpClient;
    private Button loginButton;
    private View loginView;
    private Button logoutButton;

    @Inject
    @Named
    String marketName;
    private ImageView myAccountAvatar;

    @Inject
    MyAccountManager myAccountManager;
    private TextView myAccountName;

    @Inject
    MyAccountNavigator myAccountNavigator;
    private TextView myAccountProductCardTitle;
    private View myProfileView;
    private ImageView myStoreAvatar;
    private TextView myStoreName;
    private View myStoreView;
    private View settings;

    @Inject
    SocialMediaAnalytics socialMediaAnalytics;
    private SocialMediaView socialMediaView;

    @Inject
    ThemeManager themeManager;
    protected Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getStore$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e(Account account) {
        return GetStoreRequest.of(new BaseRequestWithStore.StoreCredentials(account.getStore().getName(), (String) null, (String) null), StoreContext.meta, this.bodyInterceptor, this.httpClient, this.converterFactory, ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator(), ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences(), getContext().getResources(), (WindowManager) getContext().getSystemService("window")).observe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupToolbar$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(View view) {
        getActivity().onBackPressed();
    }

    public static Fragment newInstance() {
        return new MyAccountFragment();
    }

    private void setAccountViews(View view) {
        this.myProfileView = view.findViewById(R.id.my_profile);
        this.myStoreView = view.findViewById(R.id.my_store);
        this.accountView = view.findViewById(R.id.account_displayables);
        this.loginView = view.findViewById(R.id.login_register_container);
        this.myAccountAvatar = (ImageView) this.myProfileView.findViewById(R.id.user_icon);
        this.myAccountName = (TextView) this.myProfileView.findViewById(R.id.description);
        this.myStoreAvatar = (ImageView) this.myStoreView.findViewById(R.id.user_icon);
        this.myStoreName = (TextView) this.myStoreView.findViewById(R.id.description);
        ((TextView) this.myStoreView.findViewById(R.id.name)).setText(R.string.newaccount_my_store);
        ((TextView) this.myProfileView.findViewById(R.id.name)).setText(R.string.newaccount_my_profile);
        this.loginButton = (Button) view.findViewById(R.id.login_button);
        this.logoutButton = (Button) view.findViewById(R.id.logout_button);
        this.createStoreMessage = (TextView) view.findViewById(R.id.create_store_message);
        this.createStoreButton = (Button) view.findViewById(R.id.create_store_button);
        this.editStoreButton = (Button) this.myStoreView.findViewById(R.id.edit_button);
        this.editProfileButton = (Button) this.myProfileView.findViewById(R.id.edit_button);
        this.aptoideTvCardView = (CardView) view.findViewById(R.id.product_aptoideTv_cardview);
        this.aptoideUploaderCardView = (CardView) view.findViewById(R.id.product_uploader_cardview);
        this.aptoideBackupAppsCardView = (CardView) view.findViewById(R.id.product_backup_cardview);
        this.socialMediaView = (SocialMediaView) view.findViewById(R.id.social_media_view);
    }

    private void setUserProfile(Account account) {
        if (TextUtils.isEmpty(account.getNickname())) {
            this.myAccountName.setText(account.getEmail());
        } else {
            this.myAccountName.setText(account.getNickname());
        }
        if (TextUtils.isEmpty(account.getAvatar())) {
            return;
        }
        ImageLoader.with(getContext()).loadWithShadowCircleTransformWithPlaceholder(account.getAvatar(), this.myAccountAvatar, STROKE_SIZE, R.attr.placeholder_myaccount);
    }

    private void setUserStore(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.myStoreName.setText(str);
        ImageLoader.with(getContext()).loadWithShadowCircleTransformWithPlaceholder(str2, this.myStoreAvatar, STROKE_SIZE, R.attr.placeholder_myaccount);
    }

    private void setupProductCardViews() {
        ((TextView) this.aptoideTvCardView.findViewById(R.id.product_title_textview)).setText(getString(R.string.product_card_aptoide_tv_title));
        ((TextView) this.aptoideTvCardView.findViewById(R.id.product_subtitle_textview)).setText(getString(R.string.product_card_aptoide_tv_subtitle));
        ((ImageView) this.aptoideTvCardView.findViewById(R.id.product_icon_imageview)).setImageDrawable(androidx.core.content.a.f(getContext(), R.drawable.ic_product_tv));
        ((TextView) this.aptoideUploaderCardView.findViewById(R.id.product_title_textview)).setText(getString(R.string.product_card_aptoide_uploader_title));
        ((TextView) this.aptoideUploaderCardView.findViewById(R.id.product_subtitle_textview)).setText(getString(R.string.product_card_aptoide_uploader_subtitle));
        ((ImageView) this.aptoideUploaderCardView.findViewById(R.id.product_icon_imageview)).setImageDrawable(androidx.core.content.a.f(getContext(), R.drawable.ic_product_uploader));
        ((TextView) this.aptoideBackupAppsCardView.findViewById(R.id.product_title_textview)).setText(getString(R.string.product_card_aptoide_backup_apps_title));
        ((TextView) this.aptoideBackupAppsCardView.findViewById(R.id.product_subtitle_textview)).setText(getString(R.string.product_card_aptoide_backup_apps_subtitle));
        ((ImageView) this.aptoideBackupAppsCardView.findViewById(R.id.product_icon_imageview)).setImageDrawable(androidx.core.content.a.f(getContext(), R.drawable.ic_product_backup_apps));
    }

    private void setupToolbar() {
        this.toolbar.setTitle(R.string.my_account_title_my_account);
        androidx.appcompat.app.d dVar = (androidx.appcompat.app.d) getActivity();
        dVar.setSupportActionBar(this.toolbar);
        androidx.appcompat.app.a supportActionBar = dVar.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.r(true);
            supportActionBar.v(this.toolbar.getTitle());
        }
        this.toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.view.settings.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f8145f.f(view);
            }
        });
    }

    private void showAccountAndStoreDisplayable() {
        this.loginView.setVisibility(8);
        this.accountView.setVisibility(0);
        this.myProfileView.setVisibility(0);
        this.myStoreView.setVisibility(0);
        this.createStoreButton.setVisibility(8);
        this.createStoreMessage.setVisibility(8);
    }

    private void showAccountNoStoreDisplayable() {
        this.loginView.setVisibility(8);
        this.accountView.setVisibility(0);
        this.myProfileView.setVisibility(0);
        this.myStoreView.setVisibility(8);
        if (this.myAccountManager.shouldShowCreateStore()) {
            this.createStoreButton.setVisibility(0);
            this.createStoreMessage.setVisibility(0);
        } else {
            this.createStoreButton.setVisibility(8);
            this.createStoreMessage.setVisibility(8);
        }
    }

    @Override // cm.aptoide.pt.view.settings.MyAccountView
    public rx.e<Void> aptoideBackupCardViewClick() {
        return e.g.a.c.a.a(this.aptoideBackupAppsCardView);
    }

    @Override // cm.aptoide.pt.view.settings.MyAccountView
    public rx.e<Void> aptoideTvCardViewClick() {
        return e.g.a.c.a.a(this.aptoideTvCardView);
    }

    @Override // cm.aptoide.pt.view.settings.MyAccountView
    public rx.e<Void> aptoideUploaderCardViewClick() {
        return e.g.a.c.a.a(this.aptoideUploaderCardView);
    }

    @Override // cm.aptoide.pt.view.settings.MyAccountView
    public rx.e<Void> createStoreClick() {
        return e.g.a.c.a.a(this.createStoreButton);
    }

    @Override // cm.aptoide.pt.view.settings.MyAccountView
    public rx.e<Void> editStoreClick() {
        return e.g.a.c.a.a(this.editStoreButton);
    }

    @Override // cm.aptoide.pt.view.settings.MyAccountView
    public rx.e<Void> editUserProfileClick() {
        return e.g.a.c.a.a(this.editProfileButton);
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(getClass().getSimpleName());
    }

    @Override // cm.aptoide.pt.view.settings.MyAccountView
    public rx.e<GetStore> getStore() {
        return this.accountManager.accountStatus().E().G(new rx.m.e() { // from class: cm.aptoide.pt.view.settings.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f8139f.e((Account) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.view.settings.MyAccountView
    public rx.e<Void> loginClick() {
        return e.g.a.c.a.a(this.loginButton);
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        AptoideApplication aptoideApplication = (AptoideApplication) getContext().getApplicationContext();
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        this.bodyInterceptor = aptoideApplication.getAccountSettingsBodyInterceptorPoolV7();
        this.httpClient = aptoideApplication.getDefaultClient();
        this.converterFactory = WebService.getDefaultConverter();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_my_account, viewGroup, false);
    }

    @Override // com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.myProfileView = null;
        this.myStoreView = null;
        this.loginView = null;
        this.accountView = null;
        this.createStoreMessage = null;
        this.myAccountAvatar = null;
        this.myAccountName = null;
        this.myStoreName = null;
        this.loginButton = null;
        this.logoutButton = null;
        this.createStoreButton = null;
        this.editStoreButton = null;
        this.editProfileButton = null;
        this.aptoideBackupAppsCardView = null;
        this.aptoideTvCardView = null;
        this.aptoideUploaderCardView = null;
        this.socialMediaView = null;
        super.onDestroyView();
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((TextView) view.findViewById(R.id.sign_in_message)).setText(getString(R.string.newaccount_signin_message, this.marketName));
        this.toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        this.settings = view.findViewById(R.id.settings);
        TextView textView = (TextView) view.findViewById(R.id.my_account_product_card_title);
        this.myAccountProductCardTitle = textView;
        textView.setText(getString(R.string.my_account_product_card_section_title));
        setAccountViews(view);
        setupToolbar();
        setupProductCardViews();
        attachPresenter(new MyAccountPresenter(this, this.accountManager, CrashReport.getInstance(), rx.l.c.a.b(), this.myAccountNavigator, this.accountAnalytics, this.socialMediaAnalytics));
    }

    @Override // cm.aptoide.pt.view.settings.MyAccountView
    public void refreshUI(Store store) {
        this.myStoreName.setText(store.getName());
        setUserStore(store.getName(), store.getAvatar());
    }

    @Override // cm.aptoide.pt.view.settings.MyAccountView
    public rx.e<Void> settingsClicked() {
        return e.g.a.c.a.a(this.settings);
    }

    @Override // cm.aptoide.pt.view.settings.MyAccountView
    public void showAccount(Account account) {
        if (TextUtils.isEmpty(account.getEmail())) {
            showLoginAccountDisplayable();
            return;
        }
        if (account.getStore().getName().isEmpty()) {
            showAccountNoStoreDisplayable();
            setUserProfile(account);
        } else {
            showAccountAndStoreDisplayable();
            setUserProfile(account);
            setUserStore(account.getStore().getName(), account.getStore().getAvatar());
        }
    }

    @Override // cm.aptoide.pt.view.settings.MyAccountView
    public void showLoginAccountDisplayable() {
        this.loginView.setVisibility(0);
        this.accountView.setVisibility(8);
    }

    @Override // cm.aptoide.pt.view.settings.MyAccountView
    public rx.e<Void> signOutClick() {
        return e.g.a.c.a.a(this.logoutButton);
    }

    @Override // cm.aptoide.pt.view.settings.MyAccountView
    public rx.e<SocialMediaView.SocialMediaType> socialMediaClick() {
        return this.socialMediaView.onSocialMediaClick();
    }

    @Override // cm.aptoide.pt.view.settings.MyAccountView
    public void startAptoideTvWebView() {
        CustomTabsHelper.getInstance().openInChromeCustomTab("https://blog.aptoide.com/what-is-aptoidetv/", getContext(), this.themeManager.getAttributeForTheme(R.attr.colorPrimary).resourceId);
    }

    @Override // cm.aptoide.pt.view.settings.MyAccountView
    public rx.e<Void> storeClick() {
        return e.g.a.c.a.a(this.myStoreView);
    }

    @Override // cm.aptoide.pt.view.settings.MyAccountView
    public rx.e<Void> userClick() {
        return e.g.a.c.a.a(this.myProfileView);
    }
}
