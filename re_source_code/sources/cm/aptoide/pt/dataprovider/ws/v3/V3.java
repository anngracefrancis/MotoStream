package cm.aptoide.pt.dataprovider.ws.v3;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.BuildConfig;
import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.dataprovider.exception.AptoideWsV3Exception;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v3.BaseV3Response;
import cm.aptoide.pt.dataprovider.model.v3.ErrorResponse;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.preferences.toolbox.ToolboxManager;
import java.io.IOException;
import java.util.Iterator;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.adapter.rxjava.HttpException;
import rx.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class V3<U> extends WebService<Service, U> {
    protected static final String BASE_HOST = "https://webservices.aptoide.com/webservices/3/";
    private final String INVALID_ACCESS_TOKEN_CODE;
    private boolean accessTokenRetry;
    private final BodyInterceptor<BaseBody> bodyInterceptor;
    protected final BaseBody map;
    private final TokenInvalidator tokenInvalidator;

    protected V3(String str, BaseBody baseBody, BodyInterceptor<BaseBody> bodyInterceptor, TokenInvalidator tokenInvalidator) {
        super(Service.class, new OkHttpClient(), WebService.getDefaultConverter(), str);
        this.INVALID_ACCESS_TOKEN_CODE = "invalid_token";
        this.accessTokenRetry = false;
        this.map = baseBody;
        this.bodyInterceptor = bodyInterceptor;
        this.tokenInvalidator = tokenInvalidator;
    }

    public static String getErrorMessage(BaseV3Response baseV3Response) {
        StringBuilder sb = new StringBuilder();
        if (baseV3Response == null || baseV3Response.getErrors() == null) {
            sb.append("Server returned null response.");
        } else {
            Iterator<ErrorResponse> it = baseV3Response.getErrors().iterator();
            while (it.hasNext()) {
                sb.append(it.next().msg);
                sb.append(". ");
            }
            if (sb.length() == 0) {
                sb.append("Server failed with empty error list.");
            }
        }
        return sb.toString();
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? "http" : BuildConfig.APTOIDE_WEB_SERVICES_SCHEME);
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_HOST);
        sb.append("/webservices/3/");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$observe$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ e c(boolean z, Throwable th) {
        if (th instanceof HttpException) {
            try {
                GenericResponseV3 genericResponseV3 = (GenericResponseV3) this.converterFactory.responseBodyConverter(GenericResponseV3.class, null, null).convert(((HttpException) th).response().errorBody());
                if (!"invalid_token".equals(genericResponseV3.getError())) {
                    AptoideWsV3Exception aptoideWsV3Exception = new AptoideWsV3Exception(th);
                    aptoideWsV3Exception.setBaseResponse(genericResponseV3);
                    return e.C(aptoideWsV3Exception);
                }
                if (!this.accessTokenRetry) {
                    this.accessTokenRetry = true;
                    return this.tokenInvalidator.invalidateAccessToken().b(observe(z));
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return e.C(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$observe$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ e d(final boolean z, BaseBody baseBody) {
        return super.observe(z).o0(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v3.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4978f.c(z, (Throwable) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.dataprovider.WebService
    public e<U> observe(final boolean z) {
        return (e<U>) this.bodyInterceptor.intercept(this.map).k(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v3.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4980f.d(z, (BaseBody) obj);
            }
        });
    }

    protected V3(BaseBody baseBody, OkHttpClient okHttpClient, Converter.Factory factory, BodyInterceptor<BaseBody> bodyInterceptor, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(Service.class, okHttpClient, factory, getHost(sharedPreferences));
        this.INVALID_ACCESS_TOKEN_CODE = "invalid_token";
        this.accessTokenRetry = false;
        this.map = baseBody;
        this.bodyInterceptor = bodyInterceptor;
        this.tokenInvalidator = tokenInvalidator;
    }

    protected V3(OkHttpClient okHttpClient, Converter.Factory factory, BodyInterceptor<BaseBody> bodyInterceptor, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        this(new BaseBody(), okHttpClient, factory, bodyInterceptor, tokenInvalidator, sharedPreferences);
    }
}
