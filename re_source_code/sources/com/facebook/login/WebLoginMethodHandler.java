package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import cm.aptoide.pt.account.view.LoginActivity;
import cm.aptoide.pt.reviews.RateAndReviewsFragment;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import com.facebook.internal.p0;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: WebLoginMethodHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WebLoginMethodHandler extends LoginMethodHandler {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f9987i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f9988j;

    /* JADX INFO: compiled from: WebLoginMethodHandler.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        kotlin.jvm.internal.m.f(loginClient, "loginClient");
    }

    private final String t() {
        Context contextI = d().i();
        if (contextI == null) {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            contextI = com.facebook.a0.c();
        }
        return contextI.getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", HttpUrl.FRAGMENT_ENCODE_SET);
    }

    private final void v(String str) {
        Context contextI = d().i();
        if (contextI == null) {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            contextI = com.facebook.a0.c();
        }
        contextI.getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit().putString("TOKEN", str).apply();
    }

    protected Bundle p(Bundle bundle, LoginClient.Request request) {
        kotlin.jvm.internal.m.f(bundle, "parameters");
        kotlin.jvm.internal.m.f(request, "request");
        bundle.putString("redirect_uri", g());
        if (request.r()) {
            bundle.putString(RateAndReviewsFragment.BundleCons.APP_ID, request.a());
        } else {
            bundle.putString("client_id", request.a());
        }
        bundle.putString("e2e", LoginClient.f9960f.a());
        if (request.r()) {
            bundle.putString("response_type", "token,signed_request,graph_domain,granted_scopes");
        } else {
            if (request.n().contains("openid")) {
                bundle.putString("nonce", request.m());
            }
            bundle.putString("response_type", "id_token,token,signed_request,graph_domain");
        }
        bundle.putString("code_challenge", request.d());
        p pVarE = request.e();
        bundle.putString("code_challenge_method", pVarE == null ? null : pVarE.name());
        bundle.putString("return_scopes", "true");
        bundle.putString(LoginActivity.AUTH_TYPE, request.c());
        bundle.putString("login_behavior", request.j().name());
        com.facebook.a0 a0Var = com.facebook.a0.a;
        bundle.putString("sdk", kotlin.jvm.internal.m.n("android-", com.facebook.a0.s()));
        if (r() != null) {
            bundle.putString("sso", r());
        }
        bundle.putString("cct_prefetching", com.facebook.a0.q ? "1" : "0");
        if (request.q()) {
            bundle.putString("fx_app", request.k().toString());
        }
        if (request.z()) {
            bundle.putString("skip_dedupe", "true");
        }
        if (request.l() != null) {
            bundle.putString("messenger_page_id", request.l());
            bundle.putString("reset_messenger_state", request.o() ? "1" : "0");
        }
        return bundle;
    }

    protected Bundle q(LoginClient.Request request) {
        kotlin.jvm.internal.m.f(request, "request");
        Bundle bundle = new Bundle();
        p0 p0Var = p0.a;
        if (!p0.b0(request.n())) {
            String strJoin = TextUtils.join(",", request.n());
            bundle.putString("scope", strJoin);
            a("scope", strJoin);
        }
        r rVarG = request.g();
        if (rVarG == null) {
            rVarG = r.NONE;
        }
        bundle.putString("default_audience", rVarG.k());
        bundle.putString("state", c(request.b()));
        AccessToken accessTokenE = AccessToken.f9559f.e();
        String strL = accessTokenE == null ? null : accessTokenE.l();
        if (strL == null || !kotlin.jvm.internal.m.a(strL, t())) {
            androidx.fragment.app.d dVarI = d().i();
            if (dVarI != null) {
                p0.g(dVarI);
            }
            a("access_token", "0");
        } else {
            bundle.putString("access_token", strL);
            a("access_token", "1");
        }
        bundle.putString("cbt", String.valueOf(System.currentTimeMillis()));
        com.facebook.a0 a0Var = com.facebook.a0.a;
        bundle.putString("ies", com.facebook.a0.g() ? "1" : "0");
        return bundle;
    }

    protected String r() {
        return null;
    }

    public abstract com.facebook.w s();

    public void u(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        String strValueOf;
        LoginClient.Result resultC;
        kotlin.jvm.internal.m.f(request, "request");
        LoginClient loginClientD = d();
        this.f9988j = null;
        if (bundle != null) {
            if (bundle.containsKey("e2e")) {
                this.f9988j = bundle.getString("e2e");
            }
            try {
                LoginMethodHandler.a aVar = LoginMethodHandler.f9983f;
                AccessToken accessTokenB = aVar.b(request.n(), bundle, s(), request.a());
                resultC = LoginClient.Result.f9972f.b(loginClientD.o(), accessTokenB, aVar.d(bundle, request.m()));
                if (loginClientD.i() != null) {
                    try {
                        CookieSyncManager.createInstance(loginClientD.i()).sync();
                    } catch (Exception unused) {
                    }
                    if (accessTokenB != null) {
                        v(accessTokenB.l());
                    }
                }
            } catch (FacebookException e2) {
                resultC = LoginClient.Result.c.d(LoginClient.Result.f9972f, loginClientD.o(), null, e2.getMessage(), null, 8, null);
            }
        } else if (facebookException instanceof FacebookOperationCanceledException) {
            resultC = LoginClient.Result.f9972f.a(loginClientD.o(), "User canceled log in.");
        } else {
            this.f9988j = null;
            String message = facebookException == null ? null : facebookException.getMessage();
            if (facebookException instanceof FacebookServiceException) {
                FacebookRequestError requestError = ((FacebookServiceException) facebookException).getRequestError();
                strValueOf = String.valueOf(requestError.b());
                message = requestError.toString();
            } else {
                strValueOf = null;
            }
            resultC = LoginClient.Result.f9972f.c(loginClientD.o(), null, message, strValueOf);
        }
        p0 p0Var = p0.a;
        if (!p0.a0(this.f9988j)) {
            h(this.f9988j);
        }
        loginClientD.g(resultC);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebLoginMethodHandler(Parcel parcel) {
        super(parcel);
        kotlin.jvm.internal.m.f(parcel, "source");
    }
}
