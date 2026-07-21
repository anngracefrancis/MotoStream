package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import cm.aptoide.pt.reviews.RateAndReviewsFragment;
import cm.aptoide.pt.timeline.view.follow.TimeLineFollowFragment;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequest;
import com.facebook.d0;
import com.facebook.internal.p0;
import com.facebook.o0.g0;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.q0;
import kotlin.text.Charsets;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: LoginMethodHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class LoginMethodHandler implements Parcelable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f9983f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, String> f9984g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LoginClient f9985h;

    /* JADX INFO: compiled from: LoginMethodHandler.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final AccessToken a(Bundle bundle, com.facebook.w wVar, String str) {
            String string;
            kotlin.jvm.internal.m.f(bundle, "bundle");
            kotlin.jvm.internal.m.f(str, "applicationId");
            p0 p0Var = p0.a;
            Date dateV = p0.v(bundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0L));
            ArrayList<String> stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            String string2 = bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
            Date dateV2 = p0.v(bundle, "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME", new Date(0L));
            if (string2 != null) {
                if (!(string2.length() == 0) && (string = bundle.getString("com.facebook.platform.extra.USER_ID")) != null) {
                    if (!(string.length() == 0)) {
                        return new AccessToken(string2, str, string, stringArrayList, null, null, wVar, dateV, new Date(), dateV2, bundle.getString("graph_domain"));
                    }
                }
            }
            return null;
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0074  */
        /* JADX WARN: Code duplicated, block: B:30:0x00b2  */
        /* JADX WARN: Code duplicated, block: B:43:0x00f0  */
        public final AccessToken b(Collection<String> collection, Bundle bundle, com.facebook.w wVar, String str) throws FacebookException {
            Collection<String> collectionF;
            ArrayList arrayListF;
            ArrayList arrayListF2;
            kotlin.jvm.internal.m.f(bundle, "bundle");
            kotlin.jvm.internal.m.f(str, "applicationId");
            p0 p0Var = p0.a;
            Date dateV = p0.v(bundle, "expires_in", new Date());
            String string = bundle.getString("access_token");
            if (string == null) {
                return null;
            }
            Date dateV2 = p0.v(bundle, "data_access_expiration_time", new Date(0L));
            String string2 = bundle.getString("granted_scopes");
            if (string2 == null) {
                collectionF = collection;
            } else {
                if (string2.length() > 0) {
                    Object[] array = kotlin.text.v.v0(string2, new String[]{","}, false, 0, 6, null).toArray(new String[0]);
                    if (array == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    String[] strArr = (String[]) array;
                    collectionF = kotlin.collections.u.f(Arrays.copyOf(strArr, strArr.length));
                } else {
                    collectionF = collection;
                }
            }
            String string3 = bundle.getString("denied_scopes");
            if (string3 == null) {
                arrayListF = null;
            } else {
                if (string3.length() > 0) {
                    Object[] array2 = kotlin.text.v.v0(string3, new String[]{","}, false, 0, 6, null).toArray(new String[0]);
                    if (array2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    String[] strArr2 = (String[]) array2;
                    arrayListF = kotlin.collections.u.f(Arrays.copyOf(strArr2, strArr2.length));
                } else {
                    arrayListF = null;
                }
            }
            String string4 = bundle.getString("expired_scopes");
            if (string4 == null) {
                arrayListF2 = null;
            } else {
                if (string4.length() > 0) {
                    Object[] array3 = kotlin.text.v.v0(string4, new String[]{","}, false, 0, 6, null).toArray(new String[0]);
                    if (array3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    String[] strArr3 = (String[]) array3;
                    arrayListF2 = kotlin.collections.u.f(Arrays.copyOf(strArr3, strArr3.length));
                } else {
                    arrayListF2 = null;
                }
            }
            if (p0.a0(string)) {
                return null;
            }
            return new AccessToken(string, str, e(bundle.getString("signed_request")), collectionF, arrayListF, arrayListF2, wVar, dateV, new Date(), dateV2, bundle.getString("graph_domain"));
        }

        public final AuthenticationToken c(Bundle bundle, String str) throws FacebookException {
            kotlin.jvm.internal.m.f(bundle, "bundle");
            String string = bundle.getString("com.facebook.platform.extra.ID_TOKEN");
            if (string != null) {
                if (!(string.length() == 0) && str != null) {
                    if (!(str.length() == 0)) {
                        try {
                            return new AuthenticationToken(string, str);
                        } catch (Exception e2) {
                            throw new FacebookException(e2.getMessage());
                        }
                    }
                }
            }
            return null;
        }

        public final AuthenticationToken d(Bundle bundle, String str) throws FacebookException {
            kotlin.jvm.internal.m.f(bundle, "bundle");
            String string = bundle.getString("id_token");
            if (string != null) {
                if (!(string.length() == 0) && str != null) {
                    if (!(str.length() == 0)) {
                        try {
                            return new AuthenticationToken(string, str);
                        } catch (Exception e2) {
                            throw new FacebookException(e2.getMessage(), e2);
                        }
                    }
                }
            }
            return null;
        }

        public final String e(String str) throws FacebookException {
            if (str != null) {
                if (!(str.length() == 0)) {
                    try {
                        Object[] array = kotlin.text.v.v0(str, new String[]{"."}, false, 0, 6, null).toArray(new String[0]);
                        if (array == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                        String[] strArr = (String[]) array;
                        if (strArr.length == 2) {
                            byte[] bArrDecode = Base64.decode(strArr[1], 0);
                            kotlin.jvm.internal.m.e(bArrDecode, "data");
                            String string = new JSONObject(new String(bArrDecode, Charsets.f25054b)).getString(TimeLineFollowFragment.BundleKeys.USER_ID);
                            kotlin.jvm.internal.m.e(string, "jsonObject.getString(\"user_id\")");
                            return string;
                        }
                        throw new FacebookException("Failed to retrieve user_id from signed_request");
                    } catch (UnsupportedEncodingException | JSONException unused) {
                    }
                }
            }
            throw new FacebookException("Authorization response does not contain the signed_request");
        }
    }

    public LoginMethodHandler(LoginClient loginClient) {
        kotlin.jvm.internal.m.f(loginClient, "loginClient");
        m(loginClient);
    }

    protected void a(String str, Object obj) {
        if (this.f9984g == null) {
            this.f9984g = new HashMap();
        }
        Map<String, String> map = this.f9984g;
        if (map == null) {
            return;
        }
        map.put(str, obj == null ? null : obj.toString());
    }

    public void b() {
    }

    protected String c(String str) {
        kotlin.jvm.internal.m.f(str, "authId");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0_auth_logger_id", str);
            jSONObject.put("3_method", f());
            l(jSONObject);
        } catch (JSONException e2) {
            Log.w("LoginMethodHandler", kotlin.jvm.internal.m.n("Error creating client state json: ", e2.getMessage()));
        }
        String string = jSONObject.toString();
        kotlin.jvm.internal.m.e(string, "param.toString()");
        return string;
    }

    public final LoginClient d() {
        LoginClient loginClient = this.f9985h;
        if (loginClient != null) {
            return loginClient;
        }
        kotlin.jvm.internal.m.w("loginClient");
        throw null;
    }

    public final Map<String, String> e() {
        return this.f9984g;
    }

    public abstract String f();

    protected String g() {
        StringBuilder sb = new StringBuilder();
        sb.append("fb");
        com.facebook.a0 a0Var = com.facebook.a0.a;
        sb.append(com.facebook.a0.d());
        sb.append("://authorize/");
        return sb.toString();
    }

    protected void h(String str) {
        LoginClient.Request requestO = d().o();
        String strA = requestO == null ? null : requestO.a();
        if (strA == null) {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            strA = com.facebook.a0.d();
        }
        g0 g0Var = new g0(d().i(), strA);
        Bundle bundle = new Bundle();
        bundle.putString("fb_web_login_e2e", str);
        bundle.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
        bundle.putString(RateAndReviewsFragment.BundleCons.APP_ID, strA);
        g0Var.h("fb_dialogs_web_login_dialog_complete", null, bundle);
    }

    public boolean i() {
        return false;
    }

    public boolean j(int i2, int i3, Intent intent) {
        return false;
    }

    protected Bundle k(LoginClient.Request request, Bundle bundle) throws FacebookException {
        GraphRequest graphRequestA;
        kotlin.jvm.internal.m.f(request, "request");
        kotlin.jvm.internal.m.f(bundle, "values");
        String string = bundle.getString("code");
        p0 p0Var = p0.a;
        if (p0.a0(string)) {
            throw new FacebookException("No code param found from the request");
        }
        if (string == null) {
            graphRequestA = null;
        } else {
            b0 b0Var = b0.a;
            String strG = g();
            String strF = request.f();
            if (strF == null) {
                strF = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            graphRequestA = b0.a(string, strG, strF);
        }
        if (graphRequestA == null) {
            throw new FacebookException("Failed to create code exchange request");
        }
        d0 d0VarJ = graphRequestA.j();
        FacebookRequestError facebookRequestErrorB = d0VarJ.b();
        if (facebookRequestErrorB != null) {
            throw new FacebookServiceException(facebookRequestErrorB, facebookRequestErrorB.c());
        }
        try {
            JSONObject jSONObjectC = d0VarJ.c();
            String string2 = jSONObjectC != null ? jSONObjectC.getString("access_token") : null;
            if (jSONObjectC == null || p0.a0(string2)) {
                throw new FacebookException("No access token found from result");
            }
            bundle.putString("access_token", string2);
            if (jSONObjectC.has("id_token")) {
                bundle.putString("id_token", jSONObjectC.getString("id_token"));
            }
            return bundle;
        } catch (JSONException e2) {
            throw new FacebookException(kotlin.jvm.internal.m.n("Fail to process code exchange response: ", e2.getMessage()));
        }
    }

    public void l(JSONObject jSONObject) throws JSONException {
        kotlin.jvm.internal.m.f(jSONObject, "param");
    }

    public final void m(LoginClient loginClient) {
        kotlin.jvm.internal.m.f(loginClient, "<set-?>");
        this.f9985h = loginClient;
    }

    public boolean n() {
        return false;
    }

    public abstract int o(LoginClient.Request request);

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        kotlin.jvm.internal.m.f(parcel, "dest");
        p0 p0Var = p0.a;
        p0.H0(parcel, this.f9984g);
    }

    protected LoginMethodHandler(Parcel parcel) {
        kotlin.jvm.internal.m.f(parcel, "source");
        p0 p0Var = p0.a;
        Map<String, String> mapT0 = p0.t0(parcel);
        this.f9984g = mapT0 == null ? null : q0.u(mapT0);
    }
}
