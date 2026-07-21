package cm.aptoide.pt.store.view.my;

import android.os.Bundle;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.Layout;
import cm.aptoide.pt.dataprovider.model.v7.store.ListStores;
import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.Endless;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import cm.aptoide.pt.dataprovider.ws.v7.WSWidgetsUtils;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetMyStoreListRequest;
import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.store.RoomStoreRepository;
import cm.aptoide.pt.store.StoreAnalytics;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import cm.aptoide.pt.store.StoreUtilsProxy;
import cm.aptoide.pt.store.view.GetStoreEndlessFragment;
import cm.aptoide.pt.store.view.GridStoreDisplayable;
import cm.aptoide.pt.store.view.recommended.RecommendedStoreDisplayable;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import cm.aptoide.pt.view.recycler.displayable.DisplayablesFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class MyStoresSubscribedFragment extends GetStoreEndlessFragment<ListStores> {
    private static final String USER_NOT_LOGGED_ERROR = "AUTH-5";
    private AptoideAccountManager accountManager;

    @Inject
    AnalyticsManager analyticsManager;
    private BodyInterceptor<BaseBody> bodyInterceptor;
    private Converter.Factory converterFactory;
    private OkHttpClient httpClient;

    @Inject
    NavigationTracker navigationTracker;
    private StoreAnalytics storeAnalytics;

    @Inject
    StoreCredentialsProvider storeCredentialsProvider;

    @Inject
    RoomStoreRepository storeRepository;

    @Inject
    StoreUtilsProxy storeUtilsProxy;
    private TokenInvalidator tokenInvalidator;
    private WSWidgetsUtils widgetsUtils;

    private ArrayList<Displayable> getStoresDisplayable(List<Store> list) {
        ArrayList<Displayable> arrayList = new ArrayList<>(list.size());
        Collections.sort(list, new Comparator() { // from class: cm.aptoide.pt.store.view.my.b0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Store) obj).getName().compareTo(((Store) obj2).getName());
            }
        });
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (i2 == 0 || list.get(i2 - 1).getId() != list.get(i2).getId()) {
                if (this.layout == Layout.LIST) {
                    arrayList.add(new RecommendedStoreDisplayable(list.get(i2), this.storeRepository, this.accountManager, this.storeUtilsProxy, this.storeCredentialsProvider));
                } else {
                    arrayList.add(new GridStoreDisplayable(list.get(i2), "More Followed Stores", this.storeAnalytics));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$buildAction$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(ListStores listStores) {
        addDisplayables(getStoresDisplayable(listStores.getDataList().getList()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getErrorRequestListener$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(List list) {
        addDisplayables(getStoresDisplayable(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getErrorRequestListener$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(Throwable th) {
        getRecyclerView().clearOnScrollListeners();
        LinkedList linkedList = new LinkedList();
        linkedList.add(USER_NOT_LOGGED_ERROR);
        if (this.widgetsUtils.shouldAddObjectView(linkedList, th)) {
            DisplayablesFactory.loadLocalSubscribedStores(this.storeRepository).f(bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.my.y
                @Override // rx.m.b
                public final void call(Object obj) {
                    this.f7672f.i((List) obj);
                }
            }, new rx.m.b() { // from class: cm.aptoide.pt.store.view.my.a0
                @Override // rx.m.b
                public final void call(Object obj) {
                    CrashReport.getInstance().log((Throwable) obj);
                }
            });
        } else {
            finishLoading(th);
        }
    }

    public static Fragment newInstance() {
        return new MyStoresSubscribedFragment();
    }

    @Override // cm.aptoide.pt.store.view.GetStoreEndlessFragment
    protected rx.m.b<ListStores> buildAction() {
        return new rx.m.b() { // from class: cm.aptoide.pt.store.view.my.x
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7671f.h((ListStores) obj);
            }
        };
    }

    @Override // cm.aptoide.pt.store.view.GetStoreEndlessFragment
    protected V7<ListStores, ? extends Endless> buildRequest(boolean z, String str) {
        return GetMyStoreListRequest.of(str, true, this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences(), getContext().getResources(), (WindowManager) getContext().getSystemService("window"));
    }

    @Override // cm.aptoide.pt.store.view.GetStoreEndlessFragment
    protected ErrorRequestListener getErrorRequestListener() {
        return new ErrorRequestListener() { // from class: cm.aptoide.pt.store.view.my.z
            @Override // cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener
            public final void onError(Throwable th) {
                this.a.j(th);
            }
        };
    }

    @Override // cm.aptoide.pt.store.view.StoreTabWidgetsGridRecyclerFragment, cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment, cm.aptoide.pt.view.fragment.AptoideBaseFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        this.tokenInvalidator = ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator();
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        this.bodyInterceptor = ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
        this.httpClient = ((AptoideApplication) getContext().getApplicationContext()).getDefaultClient();
        this.converterFactory = WebService.getDefaultConverter();
        this.storeAnalytics = new StoreAnalytics(this.analyticsManager, this.navigationTracker);
        this.widgetsUtils = new WSWidgetsUtils();
    }
}
