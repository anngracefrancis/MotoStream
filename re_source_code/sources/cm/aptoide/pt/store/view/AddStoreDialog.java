package cm.aptoide.pt.store.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.dataprovider.exception.AptoideWsV7Exception;
import cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener;
import cm.aptoide.pt.dataprovider.interfaces.SuccessRequestListener;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStoreMeta;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetStoreMetaRequest;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.navigator.ActivityResultNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.orientation.ScreenOrientationManager;
import cm.aptoide.pt.search.SuggestionCursorAdapter;
import cm.aptoide.pt.search.suggestions.SearchSuggestionManager;
import cm.aptoide.pt.store.StoreAnalytics;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import cm.aptoide.pt.store.StoreError;
import cm.aptoide.pt.store.StoreUtils;
import cm.aptoide.pt.store.StoreUtilsProxy;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.utils.GenericDialogs;
import cm.aptoide.pt.utils.design.ShowMessage;
import cm.aptoide.pt.view.fragment.BaseDialogFragment;
import com.google.android.material.snackbar.Snackbar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class AddStoreDialog extends BaseDialogFragment {
    private static final int COMPLETION_THRESHOLD = 1;
    public static final int PRIVATE_STORE_ERROR_CODE = 22;
    public static final int PRIVATE_STORE_INVALID_CREDENTIALS_CODE = 21;
    private static final String TAG = AddStoreDialog.class.getName();
    private final int PRIVATE_STORE_REQUEST_CODE = 20;
    private AptoideAccountManager accountManager;
    private Button addStoreButton;
    private AnalyticsManager analyticsManager;
    private BodyInterceptor<BaseBody> baseBodyBodyInterceptor;
    private Converter.Factory converterFactory;
    private TextView errorMessage;
    private OkHttpClient httpClient;
    private Dialog loadingDialog;
    private NavigationTracker navigationTracker;
    private FragmentNavigator navigator;
    private ScreenOrientationManager orientationManager;
    private SearchSuggestionManager searchSuggestionManager;
    private SearchView searchView;
    private RelativeLayout searchViewLayout;
    private StoreAnalytics storeAnalytics;

    @Inject
    StoreCredentialsProvider storeCredentialsProvider;
    private String storeName;

    @Inject
    StoreUtilsProxy storeUtilsProxy;
    private rx.t.b subscriptions;
    private TokenInvalidator tokenInvalidator;
    private Button topStoresButton;

    /* JADX INFO: renamed from: cm.aptoide.pt.store.view.AddStoreDialog$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$store$StoreError;

        static {
            int[] iArr = new int[StoreError.values().length];
            $SwitchMap$cm$aptoide$pt$store$StoreError = iArr;
            try {
                iArr[StoreError.PRIVATE_STORE_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$store$StoreError[StoreError.STORE_DOESNT_EXIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private enum BundleArgs {
        STORE_NAME
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addStoreAction, reason: merged with bridge method [inline-methods] */
    public void h(String str) {
        this.storeName = str;
        getStore(str);
        showLoadingDialog();
    }

    private void bindViews(View view) {
        this.addStoreButton = (Button) view.findViewById(R.id.button_dialog_add_store);
        this.topStoresButton = (Button) view.findViewById(R.id.button_top_stores);
        this.searchView = (SearchView) view.findViewById(R.id.store_search_view);
        this.searchViewLayout = (RelativeLayout) view.findViewById(R.id.search_box_layout);
        this.errorMessage = (TextView) view.findViewById(R.id.error_message);
        EditText editText = (EditText) this.searchView.findViewById(R.id.search_src_text);
        editText.setTextSize(2, 12.0f);
        editText.setHintTextColor(getResources().getColor(R.color.grey));
    }

    private GetStoreMetaRequest buildRequest(String str) {
        return GetStoreMetaRequest.of(StoreUtils.getStoreCredentials(str, this.storeCredentialsProvider), this.baseBodyBodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences());
    }

    private void dismissIfFocusIsLost() {
        this.subscriptions.a(e.g.a.c.a.b(this.searchView).z0(300L, TimeUnit.MILLISECONDS).D(new rx.m.e() { // from class: cm.aptoide.pt.store.view.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(!((Boolean) obj).booleanValue());
            }
        }).G0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.b
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7592f.d((Boolean) obj);
            }
        }));
    }

    private void executeRequest(GetStoreMetaRequest getStoreMetaRequest) {
        this.storeUtilsProxy.subscribeStore(getStoreMetaRequest, new SuccessRequestListener() { // from class: cm.aptoide.pt.store.view.i
            @Override // cm.aptoide.pt.dataprovider.interfaces.SuccessRequestListener, rx.m.b
            public final void call(Object obj) {
                this.f7619f.e((GetStoreMeta) obj);
            }
        }, new ErrorRequestListener() { // from class: cm.aptoide.pt.store.view.g
            @Override // cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener
            public final void onError(Throwable th) {
                this.a.f(th);
            }
        }, this.storeName, this.accountManager);
    }

    private void getStore(String str) {
        executeRequest(buildRequest(str));
    }

    private void handleEmptyQuery(final SuggestionCursorAdapter suggestionCursorAdapter) {
        this.subscriptions.a(e.g.a.b.c.a.d.a(this.searchView).j0(rx.l.c.a.b()).D(new rx.m.e() { // from class: cm.aptoide.pt.store.view.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((e.g.a.b.c.a.g) obj).d().length() == 0);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.store.view.l
            @Override // rx.m.b
            public final void call(Object obj) {
                suggestionCursorAdapter.setData(Collections.emptyList());
            }
        }).D0());
    }

    private void handleStoreRemoteQuery(final SuggestionCursorAdapter suggestionCursorAdapter) {
        this.subscriptions.a(e.g.a.b.c.a.d.a(this.searchView).D(new rx.m.e() { // from class: cm.aptoide.pt.store.view.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(!((e.g.a.b.c.a.g) obj).c());
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.store.view.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((e.g.a.b.c.a.g) obj).d().toString();
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.store.view.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                String str = (String) obj;
                return Boolean.valueOf(str != null && str.length() >= 1);
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.store.view.o
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7677f.g(suggestionCursorAdapter, (String) obj);
            }
        }).s0().D0());
    }

    private void handleSubmittedQuery() {
        this.subscriptions.a(e.g.a.b.c.a.d.a(this.searchView).j0(rx.l.c.a.b()).D(new rx.m.e() { // from class: cm.aptoide.pt.store.view.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((e.g.a.b.c.a.g) obj).c());
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.store.view.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((e.g.a.b.c.a.g) obj).d().toString();
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.store.view.c
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7593f.h((String) obj);
            }
        }).D0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$dismissIfFocusIsLost$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(Boolean bool) {
        Dialog dialog = getDialog();
        if (dialog != null && dialog.isShowing() && isResumed()) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$executeRequest$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(GetStoreMeta getStoreMeta) {
        ShowMessage.asSnack(getView(), AptoideUtils.StringU.getFormattedString(R.string.store_followed, getContext().getResources(), this.storeName));
        dismissLoadingDialog();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$executeRequest$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(Throwable th) {
        dismissLoadingDialog();
        if (!(th instanceof AptoideWsV7Exception)) {
            this.searchViewLayout.setBackground(getResources().getDrawable(R.drawable.add_stores_dialog_seach_box_error));
            this.errorMessage.setVisibility(0);
            this.errorMessage.setText(R.string.error_occured);
            return;
        }
        BaseV7Response.Error error = ((AptoideWsV7Exception) th).getBaseResponse().getError();
        int i2 = AnonymousClass2.$SwitchMap$cm$aptoide$pt$store$StoreError[StoreUtils.getErrorType(error.getCode()).ordinal()];
        if (i2 == 1) {
            PrivateStoreDialog.newInstance(this, 20, this.storeName, false).show(getFragmentManager(), PrivateStoreDialog.class.getName());
            return;
        }
        if (i2 != 2) {
            this.searchViewLayout.setBackground(getResources().getDrawable(R.drawable.add_stores_dialog_seach_box_error));
            this.errorMessage.setVisibility(0);
            this.errorMessage.setText(error.getDescription());
        } else {
            this.searchViewLayout.setBackground(getResources().getDrawable(R.drawable.add_stores_dialog_seach_box_error));
            this.errorMessage.setVisibility(0);
            this.errorMessage.setText(error.getDescription());
        }
    }

    static /* synthetic */ Single lambda$handleStoreRemoteQuery$7(SuggestionCursorAdapter suggestionCursorAdapter, Throwable th) {
        if (th instanceof TimeoutException) {
            Logger.getInstance().i(TAG, "Timeout reached while waiting for store suggestions");
            return Single.m(suggestionCursorAdapter.getSuggestions());
        }
        Logger.getInstance().w(TAG, "handleStoreRemoteQuery: ", th);
        return Single.h(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleStoreRemoteQuery$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single g(final SuggestionCursorAdapter suggestionCursorAdapter, String str) {
        return this.searchSuggestionManager.getSuggestionsForStore(str).q(new rx.m.e() { // from class: cm.aptoide.pt.store.view.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AddStoreDialog.lambda$handleStoreRemoteQuery$7(suggestionCursorAdapter, (Throwable) obj);
            }
        }).p(rx.l.c.a.b()).g(new rx.m.b() { // from class: cm.aptoide.pt.store.view.d
            @Override // rx.m.b
            public final void call(Object obj) {
                suggestionCursorAdapter.setData((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupButtonHandlers$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(Void r3) {
        setDefaultState();
        addStoreAction();
        this.storeAnalytics.sendStoreTabInteractEvent("Add Store", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupButtonHandlers$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(Void r1) {
        topStoresAction();
    }

    private void setDefaultState() {
        this.errorMessage.setVisibility(4);
        this.searchViewLayout.setBackground(getResources().getDrawable(R.drawable.add_stores_dialog_search_box_border));
    }

    private void setupButtonHandlers() {
        this.subscriptions.a(e.g.a.c.a.a(this.addStoreButton).G0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.p
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7683f.i((Void) obj);
            }
        }));
        this.subscriptions.a(e.g.a.c.a.a(this.topStoresButton).G0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.m
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7633f.j((Void) obj);
            }
        }));
    }

    private void setupSearch() {
        final SuggestionCursorAdapter suggestionCursorAdapter = new SuggestionCursorAdapter(getContext());
        this.searchView.setOnSuggestionListener(new SearchView.m() { // from class: cm.aptoide.pt.store.view.AddStoreDialog.1
            @Override // androidx.appcompat.widget.SearchView.m
            public boolean onSuggestionClick(int i2) {
                AddStoreDialog.this.searchView.d0(suggestionCursorAdapter.getSuggestionAt(i2), false);
                return true;
            }

            @Override // androidx.appcompat.widget.SearchView.m
            public boolean onSuggestionSelect(int i2) {
                return false;
            }
        });
        this.searchView.setSuggestionsAdapter(suggestionCursorAdapter);
        ((AutoCompleteTextView) this.searchView.findViewById(R.id.search_src_text)).setThreshold(1);
        handleEmptyQuery(suggestionCursorAdapter);
        handleSubmittedQuery();
        handleStoreRemoteQuery(suggestionCursorAdapter);
    }

    private void showLoadingDialog() {
        if (this.loadingDialog == null) {
            this.loadingDialog = GenericDialogs.createGenericPleaseWaitDialog(getActivity(), this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId);
        }
        this.orientationManager.lock();
        this.loadingDialog.show();
    }

    private void topStoresAction() {
        this.navigator.navigateTo(TopStoresFragment.newInstance(), true);
        if (isAdded()) {
            dismiss();
        }
    }

    void dismissLoadingDialog() {
        this.orientationManager.unlock();
        this.loadingDialog.dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 20) {
            if (i3 == -1) {
                dismiss();
            } else if (i3 != 21) {
                Snackbar.Z(this.searchView, R.string.error_occured, -1).P();
            } else {
                Snackbar.Z(this.searchView, R.string.ws_error_invalid_grant, -1).P();
            }
        }
    }

    @Override // com.trello.rxlifecycle.h.a.c, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (ActivityResultNavigator.class.isAssignableFrom(activity.getClass())) {
            this.navigator = ((ActivityResultNavigator) activity).getFragmentNavigator();
            this.orientationManager = new ScreenOrientationManager(activity, activity.getWindowManager());
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(AddStoreDialog.class.getSimpleName() + " must extend class " + ActivityResultNavigator.class.getSimpleName());
        Logger.getInstance().e(TAG, (Throwable) illegalStateException);
        throw illegalStateException;
    }

    @Override // cm.aptoide.pt.view.fragment.BaseDialogFragment, com.trello.rxlifecycle.h.a.c, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        this.subscriptions = new rx.t.b();
        this.tokenInvalidator = ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator();
        this.converterFactory = WebService.getDefaultConverter();
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        this.httpClient = ((AptoideApplication) getContext().getApplicationContext()).getDefaultClient();
        this.baseBodyBodyInterceptor = ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
        if (bundle != null) {
            this.storeName = bundle.getString(BundleArgs.STORE_NAME.name());
        }
        AptoideApplication aptoideApplication = (AptoideApplication) getContext().getApplicationContext();
        this.analyticsManager = aptoideApplication.getAnalyticsManager();
        NavigationTracker navigationTracker = aptoideApplication.getNavigationTracker();
        this.navigationTracker = navigationTracker;
        this.storeAnalytics = new StoreAnalytics(this.analyticsManager, navigationTracker);
        this.searchSuggestionManager = aptoideApplication.getSearchSuggestionManager();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(-1, -1);
            dialog.getWindow().requestFeature(1);
            dialog.setCancelable(true);
        }
        return layoutInflater.inflate(R.layout.dialog_add_store, viewGroup, false);
    }

    @Override // com.trello.rxlifecycle.h.a.c, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        rx.t.b bVar = this.subscriptions;
        if (bVar != null && !bVar.isUnsubscribed()) {
            this.subscriptions.unsubscribe();
        }
        super.onDestroyView();
    }

    @Override // com.trello.rxlifecycle.h.a.c, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Dialog dialog = getDialog();
        Rect rect = new Rect();
        getActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        double dWidth = rect.width();
        Double.isNaN(dWidth);
        double d2 = dWidth * 0.8d;
        if (dialog != null) {
            if (getResources().getConfiguration().orientation == 2) {
                dialog.getWindow().setLayout(Math.round((float) d2), -2);
            } else {
                dialog.getWindow().setLayout(-1, -2);
            }
        }
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(BundleArgs.STORE_NAME.name(), this.storeName);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseDialogFragment, com.trello.rxlifecycle.h.a.c, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bindViews(view);
        setupSearch();
        setupButtonHandlers();
        dismissIfFocusIsLost();
    }

    @Deprecated
    private void addStoreAction() {
        String string = this.searchView.getQuery().toString();
        if (string.length() > 0) {
            this.storeName = string;
            getStore(string);
            showLoadingDialog();
        } else {
            this.searchViewLayout.setBackground(getResources().getDrawable(R.drawable.add_stores_dialog_seach_box_error));
            this.errorMessage.setVisibility(0);
            this.errorMessage.setText(R.string.add_store_dialog_no_query);
        }
    }
}
