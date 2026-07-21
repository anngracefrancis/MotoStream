package cm.aptoide.pt.networking;

import android.content.SharedPreferences;
import cm.aptoide.accountmanager.AccountException;
import cm.aptoide.pt.dataprovider.exception.AptoideWsV3Exception;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v3.OAuth;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v3.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v3.OAuth2AuthenticationRequest;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class RefreshTokenInvalidator implements TokenInvalidator {
    private final int MAX_REFRESH_TOKEN_RETRIES = 3;
    private final AuthenticationPersistence authenticationPersistence;
    private final BodyInterceptor<BaseBody> bodyInterceptor;
    private final Converter.Factory converterFactory;
    private final String extraId;
    private final OkHttpClient httpClient;
    private final rx.s.b<Void> logoutSubject;
    private final SharedPreferences sharedPreferences;
    private final TokenInvalidator tokenInvalidator;

    public RefreshTokenInvalidator(BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, SharedPreferences sharedPreferences, String str, TokenInvalidator tokenInvalidator, AuthenticationPersistence authenticationPersistence, rx.s.b<Void> bVar) {
        this.bodyInterceptor = bodyInterceptor;
        this.httpClient = okHttpClient;
        this.converterFactory = factory;
        this.sharedPreferences = sharedPreferences;
        this.extraId = str;
        this.tokenInvalidator = tokenInvalidator;
        this.authenticationPersistence = authenticationPersistence;
        this.logoutSubject = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$invalidateAccessToken$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b a(OAuth oAuth) {
        return !oAuth.hasErrors() ? this.authenticationPersistence.updateAuthentication(oAuth.getAccessToken()) : rx.b.s(new AccountException(oAuth));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$invalidateAccessToken$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b b(Authentication authentication) {
        return OAuth2AuthenticationRequest.of(authentication.getRefreshToken(), this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences, this.extraId).observe().Z0().j(new rx.m.e() { // from class: cm.aptoide.pt.networking.u
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6668f.a((OAuth) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$invalidateAccessToken$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b c(Throwable th, Integer num) {
        if (num.intValue() < 3) {
            if (th instanceof AptoideWsV3Exception) {
                return null;
            }
        } else if (th instanceof AptoideWsV3Exception) {
            this.logoutSubject.onNext(null);
            return rx.b.e();
        }
        this.logoutSubject.onNext(null);
        return rx.b.s(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$invalidateAccessToken$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d(rx.e eVar) {
        return eVar.e1(rx.e.r0(1, 3), new rx.m.f() { // from class: cm.aptoide.pt.networking.r
            @Override // rx.m.f
            public final Object a(Object obj, Object obj2) {
                return this.f6665f.c((Throwable) obj, (Integer) obj2);
            }
        });
    }

    public rx.s.b<Void> getLogoutSubject() {
        return this.logoutSubject;
    }

    @Override // cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator
    public rx.b invalidateAccessToken() {
        return this.authenticationPersistence.getAuthentication().j(new rx.m.e() { // from class: cm.aptoide.pt.networking.s
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6666f.b((Authentication) obj);
            }
        }).F(new rx.m.e() { // from class: cm.aptoide.pt.networking.t
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6667f.d((rx.e) obj);
            }
        });
    }
}
