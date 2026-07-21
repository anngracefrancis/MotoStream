package cm.aptoide.pt.store;

import android.content.SharedPreferences;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.database.room.RoomStore;
import cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener;
import cm.aptoide.pt.dataprovider.interfaces.SuccessRequestListener;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStoreMeta;
import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.BaseRequestWithStore;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetHomeMetaRequest;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetStoreMetaRequest;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class StoreUtilsProxy {
    private final AptoideAccountManager accountManager;
    private final BodyInterceptor<BaseBody> bodyInterceptor;
    private final Converter.Factory converterFactory;
    private final OkHttpClient httpClient;
    private final SharedPreferences sharedPreferences;
    private final StoreCredentialsProvider storeCredentialsProvider;
    private final RoomStoreRepository storeRepository;
    private TokenInvalidator tokenInvalidator;

    public StoreUtilsProxy(AptoideAccountManager aptoideAccountManager, BodyInterceptor<BaseBody> bodyInterceptor, StoreCredentialsProvider storeCredentialsProvider, RoomStoreRepository roomStoreRepository, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        this.accountManager = aptoideAccountManager;
        this.bodyInterceptor = bodyInterceptor;
        this.storeCredentialsProvider = storeCredentialsProvider;
        this.storeRepository = roomStoreRepository;
        this.httpClient = okHttpClient;
        this.converterFactory = factory;
        this.tokenInvalidator = tokenInvalidator;
        this.sharedPreferences = sharedPreferences;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isPrivateCredentialsSet(GetStoreMetaRequest getStoreMetaRequest) {
        return (((GetHomeMetaRequest.Body) getStoreMetaRequest.getBody()).getStoreUser() == null || ((GetHomeMetaRequest.Body) getStoreMetaRequest.getBody()).getStorePassSha1() == null) ? false : true;
    }

    static /* synthetic */ rx.e lambda$addDefaultStore$0(AptoideAccountManager aptoideAccountManager, BaseRequestWithStore.StoreCredentials storeCredentials, GetStoreMeta getStoreMeta) {
        if (BaseV7Response.Info.Status.OK.equals(getStoreMeta.getInfo().getStatus())) {
            return aptoideAccountManager.isLoggedIn() ? aptoideAccountManager.subscribeStore(getStoreMeta.getData().getName(), storeCredentials.getUsername(), storeCredentials.getPasswordSha1()).b(rx.e.S(getStoreMeta)) : rx.e.S(getStoreMeta);
        }
        return rx.e.C(new Exception("Something went wrong while getting store meta"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$addDefaultStore$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b a(GetStoreMetaRequest getStoreMetaRequest, GetStoreMeta getStoreMeta) {
        return saveStore(getStoreMeta.getData(), getStoreMetaRequest);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private rx.b saveStore(Store store, GetStoreMetaRequest getStoreMetaRequest) {
        RoomStore roomStore = new RoomStore();
        roomStore.setStoreId(store.getId());
        roomStore.setStoreName(store.getName());
        roomStore.setDownloads(store.getStats().getDownloads());
        roomStore.setIconPath(store.getAvatar());
        roomStore.setTheme(store.getAppearance().getTheme());
        if (isPrivateCredentialsSet(getStoreMetaRequest)) {
            roomStore.setUsername(((GetHomeMetaRequest.Body) getStoreMetaRequest.getBody()).getStoreUser());
            roomStore.setPasswordSha1(((GetHomeMetaRequest.Body) getStoreMetaRequest.getBody()).getStorePassSha1());
        }
        return this.storeRepository.save(roomStore);
    }

    public rx.b addDefaultStore(final GetStoreMetaRequest getStoreMetaRequest, final AptoideAccountManager aptoideAccountManager, final BaseRequestWithStore.StoreCredentials storeCredentials) {
        return getStoreMetaRequest.observe().G(new rx.m.e() { // from class: cm.aptoide.pt.store.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return StoreUtilsProxy.lambda$addDefaultStore$0(aptoideAccountManager, storeCredentials, (GetStoreMeta) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.store.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7582f.a(getStoreMetaRequest, (GetStoreMeta) obj);
            }
        }).w(new rx.m.b() { // from class: cm.aptoide.pt.store.j
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        }).X0();
    }

    public void subscribeStore(String str) {
        subscribeStore(GetStoreMetaRequest.of(StoreUtils.getStoreCredentials(str, this.storeCredentialsProvider), this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences), null, null, str, this.accountManager);
    }

    public rx.e<GetStoreMeta> subscribeStoreObservable(String str) {
        return StoreUtils.subscribeStore(GetStoreMetaRequest.of(StoreUtils.getStoreCredentials(str, this.storeCredentialsProvider), this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences), this.accountManager, null, null, this.storeRepository);
    }

    public void unSubscribeStore(String str) {
        StoreUtils.unSubscribeStore(str, this.accountManager, this.storeCredentialsProvider, this.storeRepository);
    }

    public void subscribeStore(GetStoreMetaRequest getStoreMetaRequest, SuccessRequestListener<GetStoreMeta> successRequestListener, ErrorRequestListener errorRequestListener, String str, AptoideAccountManager aptoideAccountManager) {
        subscribeStore(getStoreMetaRequest, successRequestListener, errorRequestListener, str, aptoideAccountManager, null, null);
    }

    public void subscribeStore(GetStoreMetaRequest getStoreMetaRequest, SuccessRequestListener<GetStoreMeta> successRequestListener, ErrorRequestListener errorRequestListener, String str, AptoideAccountManager aptoideAccountManager, String str2, String str3) {
        StoreUtils.subscribeStore(getStoreMetaRequest, successRequestListener, errorRequestListener, aptoideAccountManager, str2, str3, this.storeRepository);
    }

    public void subscribeStore(String str, SuccessRequestListener<GetStoreMeta> successRequestListener, ErrorRequestListener errorRequestListener, AptoideAccountManager aptoideAccountManager) {
        subscribeStore(GetStoreMetaRequest.of(StoreUtils.getStoreCredentials(str, this.storeCredentialsProvider), this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences), successRequestListener, errorRequestListener, str, aptoideAccountManager);
    }
}
