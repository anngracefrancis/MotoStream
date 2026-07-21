package cm.aptoide.pt.view.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.dataprovider.interfaces.SuccessRequestListener;
import cm.aptoide.pt.dataprovider.model.v7.GetApp;
import cm.aptoide.pt.dataprovider.model.v7.GetAppMeta;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.GetAppRequest;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import cm.aptoide.pt.store.StoreUtils;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.view.NotBottomNavigationView;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class DescriptionFragment extends BaseLoaderToolbarFragment implements NotBottomNavigationView {
    private static final String APP_ID = "app_id";
    private static final String APP_NAME = "APP_NAME";
    private static final String DESCRIPTION = "description";
    private static final String HAS_APPC = "HAS_APPC";
    private static final String PACKAGE_NAME = "packageName";
    private static final String STORE_NAME = "store_name";
    private static final String TAG = DescriptionFragment.class.getSimpleName();
    private long appId;
    private String appName;
    private BodyInterceptor<BaseBody> baseBodyBodyInterceptor;
    private Converter.Factory converterFactory;
    private String description;
    private TextView descriptionContainer;
    private TextView emptyData;
    private boolean hasAppId = false;
    private boolean hasAppc;
    private OkHttpClient httpClient;
    private String packageName;
    private String partnerId;

    @Inject
    StoreCredentialsProvider storeCredentialsProvider;
    private String storeName;

    @Inject
    ThemeManager themeManager;
    private Toolbar toolbar;

    private boolean hasAppc(GetApp getApp) {
        return getApp.getNodes().getMeta().getData().hasAdvertising() || getApp.getNodes().getMeta().getData().hasBilling();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$load$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(GetApp getApp) {
        setupAppDescription(getApp);
        setupTitle(getApp);
        finishLoading();
        if (hasAppc(getApp)) {
            this.hasAppc = true;
            setupAppcAppView();
        }
    }

    public static DescriptionFragment newInstance(String str, String str2, boolean z) {
        DescriptionFragment descriptionFragment = new DescriptionFragment();
        Bundle bundle = new Bundle();
        bundle.putString(APP_NAME, str);
        bundle.putString(DESCRIPTION, str2);
        bundle.putBoolean(HAS_APPC, z);
        descriptionFragment.setArguments(bundle);
        return descriptionFragment;
    }

    private void setDataUnavailable() {
        this.emptyData.setVisibility(0);
        this.descriptionContainer.setVisibility(8);
    }

    private void setupAppDescription(GetApp getApp) {
        try {
            GetAppMeta.Media media = getApp.getNodes().getMeta().getData().getMedia();
            if (!TextUtils.isEmpty(media.getDescription())) {
                this.descriptionContainer.setText(AptoideUtils.HtmlU.parse(media.getDescription()));
                return;
            }
        } catch (NullPointerException e2) {
            CrashReport.getInstance().log(e2);
        }
        setDataUnavailable();
    }

    private void setupAppcAppView() {
        this.toolbar.setBackground(androidx.core.content.a.f(getContext(), this.themeManager.getAttributeForTheme(R.attr.appDescriptionToolbarAppc).resourceId));
    }

    private void setupTitle(GetApp getApp) {
        try {
            String name = getApp.getNodes().getMeta().getData().getName();
            if (!TextUtils.isEmpty(name) && hasToolbar()) {
                ((androidx.appcompat.app.d) getActivity()).getSupportActionBar().v(name);
                return;
            }
        } catch (NullPointerException e2) {
            CrashReport.getInstance().log(e2);
        }
        setDataUnavailable();
    }

    @Override // cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment, cm.aptoide.pt.view.fragment.BaseLoaderFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void bindViews(View view) {
        super.bindViews(view);
        this.emptyData = (TextView) view.findViewById(R.id.empty_data);
        this.descriptionContainer = (TextView) view.findViewById(R.id.data_container);
        this.toolbar = (Toolbar) view.findViewById(R.id.toolbar);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment
    protected boolean displayHomeUpAsEnabled() {
        return true;
    }

    @Override // cm.aptoide.pt.view.fragment.UiComponent
    public int getContentViewId() {
        return R.layout.fragment_app_view_description;
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(getClass().getSimpleName());
    }

    @Override // cm.aptoide.pt.view.fragment.BaseLoaderFragment
    protected int getViewToShowAfterLoadingId() {
        return R.id.data_container;
    }

    @Override // cm.aptoide.pt.view.fragment.BaseLoaderFragment
    protected int[] getViewsToShowAfterLoadingId() {
        return new int[0];
    }

    @Override // cm.aptoide.pt.view.fragment.BaseLoaderFragment, cm.aptoide.pt.view.LoadInterface
    public void load(boolean z, boolean z2, Bundle bundle) {
        if (TextUtils.isEmpty(this.description) || TextUtils.isEmpty(this.appName)) {
            if (this.hasAppId) {
                GetAppRequest.of(this.appId, this.partnerId == null ? null : this.storeName, StoreUtils.getStoreCredentials(this.storeName, this.storeCredentialsProvider), this.packageName, this.baseBodyBodyInterceptor, this.httpClient, this.converterFactory, ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator(), ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences()).execute(new SuccessRequestListener() { // from class: cm.aptoide.pt.view.fragment.c
                    @Override // cm.aptoide.pt.dataprovider.interfaces.SuccessRequestListener, rx.m.b
                    public final void call(Object obj) {
                        this.f8057f.e((GetApp) obj);
                    }
                }, false);
                return;
            } else {
                Logger.getInstance().e(TAG, "App id unavailable");
                setDataUnavailable();
                return;
            }
        }
        this.descriptionContainer.setText(AptoideUtils.HtmlU.parse(this.description));
        if (hasToolbar()) {
            androidx.appcompat.app.a supportActionBar = ((androidx.appcompat.app.d) getActivity()).getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.v(this.appName);
            }
            if (this.hasAppc) {
                setupAppcAppView();
            }
        }
        finishLoading();
    }

    @Override // cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void loadExtras(Bundle bundle) {
        super.loadExtras(bundle);
        if (bundle.containsKey("app_id")) {
            this.appId = bundle.getLong("app_id", -1L);
            this.hasAppId = true;
        }
        if (bundle.containsKey("packageName")) {
            this.packageName = bundle.getString("packageName");
        }
        if (bundle.containsKey("store_name")) {
            this.storeName = bundle.getString("store_name");
        }
        if (bundle.containsKey(DESCRIPTION)) {
            this.description = bundle.getString(DESCRIPTION);
        }
        if (bundle.containsKey(APP_NAME)) {
            this.appName = bundle.getString(APP_NAME);
        }
        if (bundle.containsKey(HAS_APPC)) {
            this.hasAppc = bundle.getBoolean(HAS_APPC);
        }
    }

    @Override // cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        AptoideApplication aptoideApplication = (AptoideApplication) getContext().getApplicationContext();
        this.baseBodyBodyInterceptor = aptoideApplication.getAccountSettingsBodyInterceptorPoolV7();
        this.httpClient = aptoideApplication.getDefaultClient();
        this.converterFactory = WebService.getDefaultConverter();
        this.partnerId = aptoideApplication.getPartnerId();
        setHasOptionsMenu(true);
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_empty, menu);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment, cm.aptoide.pt.view.fragment.BaseLoaderFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }
}
