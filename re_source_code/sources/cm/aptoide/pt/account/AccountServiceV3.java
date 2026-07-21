package cm.aptoide.pt.account;

import android.content.SharedPreferences;
import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AccountException;
import cm.aptoide.accountmanager.AccountFactory;
import cm.aptoide.accountmanager.AccountService;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.accountmanager.Store;
import cm.aptoide.pt.dataprovider.exception.AptoideWsV3Exception;
import cm.aptoide.pt.dataprovider.exception.AptoideWsV7Exception;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v3.BaseV3Response;
import cm.aptoide.pt.dataprovider.model.v3.OAuth;
import cm.aptoide.pt.dataprovider.model.v3.TermsAndConditionsResponse;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.model.v7.GetMySubscribedStoresResponse;
import cm.aptoide.pt.dataprovider.model.v7.GetUserInfo;
import cm.aptoide.pt.dataprovider.model.v7.GetUserMeta;
import cm.aptoide.pt.dataprovider.model.v7.GetUserSettings;
import cm.aptoide.pt.dataprovider.util.HashMapNotNull;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v3.CreateUserRequest;
import cm.aptoide.pt.dataprovider.ws.v3.GetTermsAndConditionsStatusRequest;
import cm.aptoide.pt.dataprovider.ws.v3.OAuth2AuthenticationRequest;
import cm.aptoide.pt.dataprovider.ws.v3.UpdateTermsAndConditionsRequest;
import cm.aptoide.pt.dataprovider.ws.v3.V3;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.ChangeStoreSubscriptionResponse;
import cm.aptoide.pt.dataprovider.ws.v7.GetMySubscribedStoresRequest;
import cm.aptoide.pt.dataprovider.ws.v7.GetUserInfoRequest;
import cm.aptoide.pt.dataprovider.ws.v7.SetUserMultipartRequest;
import cm.aptoide.pt.dataprovider.ws.v7.SetUserRequest;
import cm.aptoide.pt.dataprovider.ws.v7.SetUserSettings;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import cm.aptoide.pt.dataprovider.ws.v7.store.ChangeStoreSubscriptionRequest;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.networking.Authentication;
import cm.aptoide.pt.networking.AuthenticationPersistence;
import com.aptoide.authentication.model.CodeAuth;
import com.aptoide.authentication.model.OAuth2;
import com.aptoide.authenticationrx.AptoideAuthenticationRx;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Converter;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class AccountServiceV3 implements AccountService {
    private final AccountFactory accountFactory;
    private final AptoideAuthenticationRx aptoideAuthentication;
    private final AuthenticationPersistence authenticationPersistence;
    private final BodyInterceptor<BaseBody> bodyInterceptorPoolV7;
    private final BodyInterceptor<BaseBody> bodyInterceptorWebV7;
    private final Converter.Factory converterFactory;
    private final BodyInterceptor<cm.aptoide.pt.dataprovider.ws.v3.BaseBody> defaultBodyInterceptorV3;
    private final String extraId;
    private final OkHttpClient httpClient;
    private final OkHttpClient longTimeoutHttpClient;
    private final BodyInterceptor<HashMapNotNull<String, RequestBody>> multipartBodyInterceptorV7;
    private final OAuthModeProvider oAuthModeProvider;
    private final ObjectMapper serializer;
    private final SharedPreferences sharedPreferences;
    private final TokenInvalidator tokenInvalidator;
    private final BodyInterceptor<cm.aptoide.pt.dataprovider.ws.v3.BaseBody> v3NoAuthorizationBodyInterceptor;

    public AccountServiceV3(AccountFactory accountFactory, OkHttpClient okHttpClient, OkHttpClient okHttpClient2, Converter.Factory factory, ObjectMapper objectMapper, SharedPreferences sharedPreferences, String str, TokenInvalidator tokenInvalidator, AuthenticationPersistence authenticationPersistence, BodyInterceptor<cm.aptoide.pt.dataprovider.ws.v3.BaseBody> bodyInterceptor, BodyInterceptor<cm.aptoide.pt.dataprovider.ws.v3.BaseBody> bodyInterceptor2, BodyInterceptor<HashMapNotNull<String, RequestBody>> bodyInterceptor3, BodyInterceptor<BaseBody> bodyInterceptor4, BodyInterceptor<BaseBody> bodyInterceptor5, OAuthModeProvider oAuthModeProvider, AptoideAuthenticationRx aptoideAuthenticationRx) {
        this.accountFactory = accountFactory;
        this.httpClient = okHttpClient;
        this.longTimeoutHttpClient = okHttpClient2;
        this.converterFactory = factory;
        this.serializer = objectMapper;
        this.sharedPreferences = sharedPreferences;
        this.extraId = str;
        this.tokenInvalidator = tokenInvalidator;
        this.authenticationPersistence = authenticationPersistence;
        this.v3NoAuthorizationBodyInterceptor = bodyInterceptor;
        this.defaultBodyInterceptorV3 = bodyInterceptor2;
        this.multipartBodyInterceptorV7 = bodyInterceptor3;
        this.bodyInterceptorWebV7 = bodyInterceptor4;
        this.bodyInterceptorPoolV7 = bodyInterceptor5;
        this.oAuthModeProvider = oAuthModeProvider;
        this.aptoideAuthentication = aptoideAuthenticationRx;
    }

    private rx.b changeSubscription(String str, String str2, String str3, ChangeStoreSubscriptionResponse.StoreSubscriptionState storeSubscriptionState) {
        return ChangeStoreSubscriptionRequest.of(str, storeSubscriptionState, str2, str3, this.bodyInterceptorPoolV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe().Z0().z();
    }

    private String getRemoteOrLocalEmail(String str, GetUserMeta.Data data) {
        return (data.getIdentity().getEmail() == null || data.getIdentity().getEmail().isEmpty()) ? str : data.getIdentity().getEmail();
    }

    private Single<GetUserInfo> getServerAccount() {
        return GetUserInfoRequest.of(this.httpClient, this.converterFactory, this.bodyInterceptorWebV7, this.tokenInvalidator).observe(true, false).Z0().i(new rx.m.e() { // from class: cm.aptoide.pt.account.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AccountServiceV3.lambda$getServerAccount$22((GetUserInfo) obj);
            }
        }).s(new rx.m.e() { // from class: cm.aptoide.pt.account.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3793f.g((rx.e) obj);
            }
        });
    }

    private Single<List<Store>> getSubscribedStores() {
        return new GetMySubscribedStoresRequest(this.bodyInterceptorPoolV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe().X(new rx.m.e() { // from class: cm.aptoide.pt.account.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((GetMySubscribedStoresResponse) obj).getDataList().getList();
            }
        }).J(new rx.m.e() { // from class: cm.aptoide.pt.account.w
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                AccountServiceV3.lambda$getSubscribedStores$20(list);
                return list;
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.account.z
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4043f.h((cm.aptoide.pt.dataprovider.model.v7.store.Store) obj);
            }
        }).Y0().Z0();
    }

    private Single<TermsAndConditionsResponse> getTermsAndConditionsForAccount() {
        return GetTermsAndConditionsStatusRequest.of(this.defaultBodyInterceptorV3, this.converterFactory, this.httpClient, this.tokenInvalidator, this.sharedPreferences).observe(true).Z0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$createAccount$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single a(Authentication authentication) {
        return getAccount(authentication.getEmail());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$createAccount$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single b(String str, String str2, String str3, OAuth oAuth) {
        return !oAuth.hasErrors() ? this.authenticationPersistence.createAuthentication(str, str2, oAuth.getRefreshToken(), oAuth.getAccessToken(), str3).c(this.authenticationPersistence.getAuthentication().i(new rx.m.e() { // from class: cm.aptoide.pt.account.u
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3828f.a((Authentication) obj);
            }
        })) : Single.h(new AccountException(oAuth));
    }

    static /* synthetic */ Single lambda$createAccount$6(Throwable th) {
        return th instanceof AptoideWsV3Exception ? Single.h(new AccountException((AptoideWsV3Exception) th)) : Single.h(th);
    }

    static /* synthetic */ Account lambda$createAccount$7(c.i.j.e eVar) {
        return (Account) eVar.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$createAccount$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single c(String str, String str2, BaseV3Response baseV3Response) {
        return baseV3Response.hasErrors() ? Single.h(new AccountException(baseV3Response.getErrors())) : getAccount(str, str2, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET).n(new rx.m.e() { // from class: cm.aptoide.pt.account.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AccountServiceV3.lambda$createAccount$7((c.i.j.e) obj);
            }
        });
    }

    static /* synthetic */ Single lambda$createAccount$9(Throwable th) {
        return th instanceof AptoideWsV3Exception ? Single.h(new AccountException((AptoideWsV3Exception) th)) : Single.h(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAccount$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single d(final OAuth2 oAuth2, Authentication authentication) {
        return getAccount(authentication.getEmail()).n(new rx.m.e() { // from class: cm.aptoide.pt.account.r
            @Override // rx.m.e
            public final Object call(Object obj) {
                return c.i.j.e.a((Account) obj, Boolean.valueOf(oAuth2.getSignup()));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAccount$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single f(String str, String str2, final OAuth2 oAuth2) {
        return this.authenticationPersistence.createAuthentication(str, str2, oAuth2.getData().getRefreshToken(), oAuth2.getData().getAccessToken(), AptoideAccountManager.APTOIDE_SIGN_UP_TYPE).c(this.authenticationPersistence.getAuthentication().i(new rx.m.e() { // from class: cm.aptoide.pt.account.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3785f.d(oAuth2, (Authentication) obj);
            }
        }));
    }

    static /* synthetic */ Single lambda$getAccount$3(Throwable th) {
        return th instanceof AptoideWsV3Exception ? Single.h(new AccountException((AptoideWsV3Exception) th)) : Single.h(th);
    }

    static /* synthetic */ Single lambda$getServerAccount$22(GetUserInfo getUserInfo) {
        return getUserInfo.isOk() ? Single.m(getUserInfo) : Single.h(new Exception(V7.getErrorMessage(getUserInfo)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getServerAccount$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e g(rx.e eVar) {
        return retryOnTicket(eVar).x(new rx.m.b() { // from class: cm.aptoide.pt.account.j
            @Override // rx.m.b
            public final void call(Object obj) {
                Logger.getInstance().w("AccountManagerService", "retryOnTicket() doOnNext()");
            }
        });
    }

    static /* synthetic */ Iterable lambda$getSubscribedStores$20(List list) {
        return list;
    }

    static /* synthetic */ Throwable lambda$retryOnTicket$16(Long l) {
        return null;
    }

    static /* synthetic */ rx.e lambda$retryOnTicket$17(Throwable th, Integer num) {
        try {
            List<BaseV7Response.Error> errors = ((AptoideWsV7Exception) th).getBaseResponse().getErrors();
            if (errors != null && !errors.isEmpty() && errors.get(0).getCode().equalsIgnoreCase("user-1")) {
                return rx.e.U0((long) Math.pow(5.0d, num.intValue()), TimeUnit.SECONDS).X(new rx.m.e() { // from class: cm.aptoide.pt.account.v
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        AccountServiceV3.lambda$retryOnTicket$16((Long) obj);
                        return null;
                    }
                });
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return rx.e.C(th);
    }

    static /* synthetic */ rx.e lambda$retryOnTicket$18(rx.e eVar) {
        return eVar;
    }

    static /* synthetic */ rx.b lambda$updateAccount$12(BaseV7Response baseV7Response) {
        return baseV7Response.isOk() ? rx.b.e() : rx.b.s(new Exception(V7.getErrorMessage(baseV7Response)));
    }

    static /* synthetic */ rx.b lambda$updateAccount$13(BaseV7Response baseV7Response) {
        return baseV7Response.isOk() ? rx.b.e() : rx.b.s(new Exception(V7.getErrorMessage(baseV7Response)));
    }

    static /* synthetic */ rx.b lambda$updateAccount$15(BaseV7Response baseV7Response) {
        return baseV7Response.isOk() ? rx.b.e() : rx.b.s(new Exception(V7.getErrorMessage(baseV7Response)));
    }

    static /* synthetic */ rx.b lambda$updateAccountUsername$14(BaseV7Response baseV7Response) {
        return baseV7Response.isOk() ? rx.b.e() : rx.b.s(new Exception(V7.getErrorMessage(baseV7Response)));
    }

    static /* synthetic */ rx.b lambda$updateTermsAndConditions$10(BaseV3Response baseV3Response) {
        return baseV3Response.isOk() ? rx.b.e() : rx.b.s(new Exception(V3.getErrorMessage(baseV3Response)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: mapServerAccountToAccount, reason: merged with bridge method [inline-methods] */
    public Account e(GetUserInfo getUserInfo, List<Store> list, TermsAndConditionsResponse termsAndConditionsResponse, String str) {
        GetUserMeta.Data data = getUserInfo.getNodes().getMeta().getData();
        GetUserSettings.Data data2 = getUserInfo.getNodes().getSettings().getData();
        return this.accountFactory.createAccount(data.getAccess(), list, String.valueOf(data.getId()), getRemoteOrLocalEmail(str, data), data.getName(), data.getAvatar(), lambda$getSubscribedStores$21(data.getStore()), data2.isMature(), data2.getAccess().isConfirmed(), termsAndConditionsResponse.isOk() && termsAndConditionsResponse.isPrivacy(), termsAndConditionsResponse.isOk() && termsAndConditionsResponse.isTos());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: mapToStore, reason: merged with bridge method [inline-methods] */
    public Store h(cm.aptoide.pt.dataprovider.model.v7.store.Store store) {
        if (store == null) {
            return Store.emptyStore();
        }
        return new Store(store.getStats() == null ? 0L : store.getStats().getDownloads(), store.getAvatar(), store.getId(), store.getName(), store.getAppearance() == null ? "DEFAULT" : store.getAppearance().getTheme(), null, null, cm.aptoide.pt.dataprovider.model.v7.store.Store.PUBLIC_ACCESS.equalsIgnoreCase(store.getAccess()));
    }

    private rx.e<Throwable> retryOnTicket(rx.e<? extends Throwable> eVar) {
        return eVar.e1(rx.e.r0(2, 4), new rx.m.f() { // from class: cm.aptoide.pt.account.y
            @Override // rx.m.f
            public final Object a(Object obj, Object obj2) {
                return AccountServiceV3.lambda$retryOnTicket$17((Throwable) obj, (Integer) obj2);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.account.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.e eVar2 = (rx.e) obj;
                AccountServiceV3.lambda$retryOnTicket$18(eVar2);
                return eVar2;
            }
        });
    }

    @Override // cm.aptoide.accountmanager.AccountService
    public Single<Account> createAccount(final String str, final String str2, final String str3) {
        return OAuth2AuthenticationRequest.of(str, str2, str3, this.v3NoAuthorizationBodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences, this.extraId, this.oAuthModeProvider.getAuthMode(str3)).observe().Z0().i(new rx.m.e() { // from class: cm.aptoide.pt.account.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3802f.b(str, str2, str3, (OAuth) obj);
            }
        }).q(new rx.m.e() { // from class: cm.aptoide.pt.account.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AccountServiceV3.lambda$createAccount$6((Throwable) obj);
            }
        });
    }

    @Override // cm.aptoide.accountmanager.AccountService
    public Single<c.i.j.e<Account, Boolean>> getAccount(final String str, final String str2, String str3, String str4) {
        return g.a.a.a.d.d(this.aptoideAuthentication.authenticate(str2, str3, str4)).i(new rx.m.e() { // from class: cm.aptoide.pt.account.p
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3815f.f(str, str2, (OAuth2) obj);
            }
        }).q(new rx.m.e() { // from class: cm.aptoide.pt.account.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AccountServiceV3.lambda$getAccount$3((Throwable) obj);
            }
        });
    }

    @Override // cm.aptoide.accountmanager.AccountService
    public rx.b removeAccount() {
        return this.authenticationPersistence.removeAuthentication();
    }

    @Override // cm.aptoide.accountmanager.AccountService
    public Single<CodeAuth> sendMagicLink(String str) {
        return g.a.a.a.d.d(this.aptoideAuthentication.sendMagicLink(str));
    }

    @Override // cm.aptoide.accountmanager.AccountService
    public rx.b subscribeStore(String str, String str2, String str3) {
        return changeSubscription(str, str2, str3, ChangeStoreSubscriptionResponse.StoreSubscriptionState.SUBSCRIBED);
    }

    @Override // cm.aptoide.accountmanager.AccountService
    public rx.b unsubscribeStore(String str, String str2, String str3) {
        return changeSubscription(str, str2, str3, ChangeStoreSubscriptionResponse.StoreSubscriptionState.UNSUBSCRIBED);
    }

    @Override // cm.aptoide.accountmanager.AccountService
    public rx.b updateAccount(String str, String str2) {
        return SetUserMultipartRequest.of(str, str2, this.multipartBodyInterceptorV7, this.longTimeoutHttpClient, this.converterFactory, this.serializer, this.tokenInvalidator).observe(true, false).Z0().j(new rx.m.e() { // from class: cm.aptoide.pt.account.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AccountServiceV3.lambda$updateAccount$12((BaseV7Response) obj);
            }
        });
    }

    @Override // cm.aptoide.accountmanager.AccountService
    public rx.b updateAccountUsername(String str) {
        return SetUserRequest.ofWithName(str, this.bodyInterceptorPoolV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(true, false).Z0().j(new rx.m.e() { // from class: cm.aptoide.pt.account.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AccountServiceV3.lambda$updateAccountUsername$14((BaseV7Response) obj);
            }
        });
    }

    @Override // cm.aptoide.accountmanager.AccountService
    public rx.b updateTermsAndConditions() {
        return UpdateTermsAndConditionsRequest.of(this.defaultBodyInterceptorV3, this.converterFactory, this.httpClient, this.tokenInvalidator, this.sharedPreferences).observe(true).Z0().j(new rx.m.e() { // from class: cm.aptoide.pt.account.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AccountServiceV3.lambda$updateTermsAndConditions$10((BaseV3Response) obj);
            }
        });
    }

    @Override // cm.aptoide.accountmanager.AccountService
    public Single<Account> getAccount(final String str) {
        return Single.B(getServerAccount(), getSubscribedStores(), getTermsAndConditionsForAccount(), new rx.m.g() { // from class: cm.aptoide.pt.account.o
            @Override // rx.m.g
            public final Object a(Object obj, Object obj2, Object obj3) {
                return this.a.e(str, (GetUserInfo) obj, (List) obj2, (TermsAndConditionsResponse) obj3);
            }
        });
    }

    @Override // cm.aptoide.accountmanager.AccountService
    public rx.b updateAccount(String str) {
        return SetUserRequest.of(str, this.bodyInterceptorPoolV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(true, false).Z0().j(new rx.m.e() { // from class: cm.aptoide.pt.account.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AccountServiceV3.lambda$updateAccount$13((BaseV7Response) obj);
            }
        });
    }

    @Override // cm.aptoide.accountmanager.AccountService
    public Single<Account> createAccount(final String str, final String str2) {
        return CreateUserRequest.of(str.toLowerCase(), str2, this.v3NoAuthorizationBodyInterceptor, this.httpClient, this.tokenInvalidator, this.sharedPreferences, this.extraId).observe(true).Z0().i(new rx.m.e() { // from class: cm.aptoide.pt.account.x
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4039f.c(str, str2, (BaseV3Response) obj);
            }
        }).q(new rx.m.e() { // from class: cm.aptoide.pt.account.s
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AccountServiceV3.lambda$createAccount$9((Throwable) obj);
            }
        });
    }

    @Override // cm.aptoide.accountmanager.AccountService
    public rx.b updateAccount(boolean z) {
        return SetUserSettings.of(z, this.httpClient, this.converterFactory, this.bodyInterceptorPoolV7, this.tokenInvalidator).observe(true, false).Z0().j(new rx.m.e() { // from class: cm.aptoide.pt.account.t
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AccountServiceV3.lambda$updateAccount$15((BaseV7Response) obj);
            }
        });
    }
}
