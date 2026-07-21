package cm.aptoide.pt.account.view.store;

import android.content.SharedPreferences;
import android.text.TextUtils;
import cm.aptoide.pt.account.view.exception.InvalidImageException;
import cm.aptoide.pt.account.view.exception.StoreCreationException;
import cm.aptoide.pt.dataprovider.exception.AptoideWsV7Exception;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v3.CheckUserCredentialsJson;
import cm.aptoide.pt.dataprovider.model.v3.ErrorResponse;
import cm.aptoide.pt.dataprovider.util.HashMapNotNull;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v3.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v3.CheckUserCredentialsRequest;
import cm.aptoide.pt.dataprovider.ws.v7.SetStoreImageRequest;
import cm.aptoide.pt.dataprovider.ws.v7.SimpleSetStoreRequest;
import cm.aptoide.pt.dataprovider.ws.v7.store.RequestBodyFactory;
import cm.aptoide.pt.store.RoomStoreRepository;
import cm.aptoide.pt.themes.StoreTheme;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Converter;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class StoreManager implements cm.aptoide.accountmanager.StoreManager {
    private static final String ERROR_API_1 = "API-1";
    private static final String ERROR_CODE_2 = "WOP-2";
    private static final String ERROR_CODE_3 = "WOP-3";
    private final BodyInterceptor<BaseBody> bodyInterceptorV3;
    private final BodyInterceptor<cm.aptoide.pt.dataprovider.ws.v7.BaseBody> bodyInterceptorV7;
    private final Converter.Factory converterFactory;
    private final OkHttpClient httpClient;
    private final BodyInterceptor<HashMapNotNull<String, RequestBody>> multipartBodyInterceptor;
    private final ObjectMapper objectMapper;
    private final RequestBodyFactory requestBodyFactory;
    private final SharedPreferences sharedPreferences;
    private final RoomStoreRepository storeRepository;
    private final TokenInvalidator tokenInvalidator;

    public StoreManager(OkHttpClient okHttpClient, Converter.Factory factory, BodyInterceptor<HashMapNotNull<String, RequestBody>> bodyInterceptor, BodyInterceptor<BaseBody> bodyInterceptor2, BodyInterceptor<cm.aptoide.pt.dataprovider.ws.v7.BaseBody> bodyInterceptor3, SharedPreferences sharedPreferences, TokenInvalidator tokenInvalidator, RequestBodyFactory requestBodyFactory, ObjectMapper objectMapper, RoomStoreRepository roomStoreRepository) {
        this.httpClient = okHttpClient;
        this.converterFactory = factory;
        this.multipartBodyInterceptor = bodyInterceptor;
        this.bodyInterceptorV3 = bodyInterceptor2;
        this.bodyInterceptorV7 = bodyInterceptor3;
        this.sharedPreferences = sharedPreferences;
        this.tokenInvalidator = tokenInvalidator;
        this.requestBodyFactory = requestBodyFactory;
        this.objectMapper = objectMapper;
        this.storeRepository = roomStoreRepository;
    }

    private rx.b createStore(final String str, final String str2, final String str3, final boolean z, final String str4) {
        return TextUtils.isEmpty(str) ? rx.b.s(new StoreValidationException(0)) : CheckUserCredentialsRequest.toCreateStore(this.bodyInterceptorV3, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences, str).observe().Z0().i(new rx.m.e() { // from class: cm.aptoide.pt.account.view.store.c0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return StoreManager.lambda$createStore$2((CheckUserCredentialsJson) obj);
            }
        }).j(new rx.m.e() { // from class: cm.aptoide.pt.account.view.store.z
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3943f.c(str2, str3, z, str4, str, (CheckUserCredentialsJson) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getOnErrorCompletable, reason: merged with bridge method [inline-methods] */
    public rx.b b(Throwable th) {
        if ((th instanceof StoreCreationException) || (th instanceof InvalidImageException)) {
            return rx.b.s(th);
        }
        if (th instanceof AptoideWsV7Exception) {
            return ((AptoideWsV7Exception) th).getBaseResponse().getErrors().get(0).getCode().equals(ERROR_API_1) ? rx.b.s(new InvalidImageException(Collections.singletonList(InvalidImageException.ImageError.API_ERROR))) : rx.b.s(new InvalidImageException(Collections.singletonList(InvalidImageException.ImageError.API_ERROR), th.getMessage()));
        }
        return rx.b.s(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$createOrUpdate$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b a(boolean z, String str, String str2, String str3, boolean z2, String str4) {
        return z ? updateStore(str, str2, str3, z2, str4) : createStore(str, str2, str3, z2, str4);
    }

    static /* synthetic */ Single lambda$createStore$2(CheckUserCredentialsJson checkUserCredentialsJson) {
        List<ErrorResponse> errors = checkUserCredentialsJson.getErrors();
        if (errors == null || errors.isEmpty() || !errors.get(0).code.equals(ERROR_CODE_2)) {
            return (errors == null || errors.size() <= 0 || !errors.get(0).code.equals(ERROR_CODE_3)) ? Single.m(checkUserCredentialsJson) : Single.h(new StoreCreationException(errors.get(0).code));
        }
        return Single.h(new StoreCreationException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$createStore$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b c(String str, String str2, boolean z, String str3, String str4, CheckUserCredentialsJson checkUserCredentialsJson) {
        return needToUploadMoreStoreData(str, str2, z, str3) ? updateStore(str4, str, str2, z, str3) : rx.b.e();
    }

    private boolean needToUploadMoreStoreData(String str, String str2, boolean z, String str3) {
        return !TextUtils.isEmpty(str) || (z && !TextUtils.isEmpty(str2)) || !str3.equals(StoreTheme.DEFAULT.toString().toLowerCase());
    }

    private rx.b updateStore(String str, String str2, String str3, boolean z, String str4) {
        if (TextUtils.isEmpty(str)) {
            return rx.b.s(new StoreValidationException(0));
        }
        if (z && TextUtils.isEmpty(str3)) {
            return rx.b.s(new StoreValidationException(1));
        }
        return z ? updateStoreWithAvatar(str, str2, str4, str3) : updateStoreWithoutAvatar(str, str2, str4);
    }

    private rx.b updateStoreWithAvatar(String str, String str2, String str3, String str4) {
        return SetStoreImageRequest.of(str, str3, str2, str4, this.multipartBodyInterceptor, this.httpClient, this.converterFactory, this.requestBodyFactory, this.objectMapper, this.sharedPreferences, this.tokenInvalidator).observe().Z0().z();
    }

    private rx.b updateStoreWithoutAvatar(String str, String str2, String str3) {
        return SimpleSetStoreRequest.of(str, str3, str2, this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe().X0();
    }

    @Override // cm.aptoide.accountmanager.StoreManager
    public rx.b createOrUpdate(final String str, final String str2, final String str3, final boolean z, final String str4, final boolean z2) {
        return rx.b.i(new rx.m.d() { // from class: cm.aptoide.pt.account.view.store.b0
            @Override // rx.m.d, java.util.concurrent.Callable
            public final Object call() {
                return this.f3907f.a(z2, str, str2, str3, z, str4);
            }
        }).C(new rx.m.e() { // from class: cm.aptoide.pt.account.view.store.a0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3905f.b((Throwable) obj);
            }
        });
    }

    public rx.e<Boolean> isSubscribed(long j2) {
        return this.storeRepository.isSubscribed(j2);
    }
}
