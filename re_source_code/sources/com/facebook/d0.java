package com.facebook;

import android.util.Log;
import com.facebook.internal.p0;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: compiled from: GraphResponse.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9691b = d0.class.getCanonicalName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final GraphRequest f9692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HttpURLConnection f9693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f9694e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final JSONObject f9695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final JSONArray f9696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final FacebookRequestError f9697h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final JSONObject f9698i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final JSONArray f9699j;

    /* JADX INFO: compiled from: GraphResponse.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final d0 b(GraphRequest graphRequest, HttpURLConnection httpURLConnection, Object obj, Object obj2) throws JSONException {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                FacebookRequestError facebookRequestErrorA = FacebookRequestError.f9605f.a(jSONObject, obj2, httpURLConnection);
                if (facebookRequestErrorA != null) {
                    Log.e(d0.f9691b, facebookRequestErrorA.toString());
                    if (facebookRequestErrorA.b() == 190) {
                        p0 p0Var = p0.a;
                        if (p0.W(graphRequest.l())) {
                            if (facebookRequestErrorA.g() != 493) {
                                AccessToken.f9559f.h(null);
                            } else {
                                AccessToken.c cVar = AccessToken.f9559f;
                                AccessToken accessTokenE = cVar.e();
                                if (kotlin.jvm.internal.m.a(accessTokenE != null ? Boolean.valueOf(accessTokenE.n()) : null, Boolean.FALSE)) {
                                    cVar.d();
                                }
                            }
                        }
                    }
                    return new d0(graphRequest, httpURLConnection, facebookRequestErrorA);
                }
                p0 p0Var2 = p0.a;
                Object objM = p0.M(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
                if (objM instanceof JSONObject) {
                    JSONObject jSONObject2 = (JSONObject) objM;
                    return new d0(graphRequest, httpURLConnection, jSONObject2.toString(), jSONObject2);
                }
                if (objM instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) objM;
                    return new d0(graphRequest, httpURLConnection, jSONArray.toString(), jSONArray);
                }
                obj = JSONObject.NULL;
                kotlin.jvm.internal.m.e(obj, "NULL");
            }
            if (obj == JSONObject.NULL) {
                return new d0(graphRequest, httpURLConnection, obj.toString(), (JSONObject) null);
            }
            throw new FacebookException(kotlin.jvm.internal.m.n("Got unexpected object type in response, class: ", obj.getClass().getSimpleName()));
        }

        private final List<d0> c(HttpURLConnection httpURLConnection, List<GraphRequest> list, Object obj) throws JSONException, FacebookException {
            Object obj2;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            int i2 = 0;
            if (size == 1) {
                GraphRequest graphRequest = list.get(0);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("body", obj);
                    jSONObject.put("code", httpURLConnection == null ? 200 : httpURLConnection.getResponseCode());
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject);
                    obj2 = jSONArray;
                } catch (IOException e2) {
                    arrayList.add(new d0(graphRequest, httpURLConnection, new FacebookRequestError(httpURLConnection, e2)));
                    obj2 = obj;
                } catch (JSONException e3) {
                    arrayList.add(new d0(graphRequest, httpURLConnection, new FacebookRequestError(httpURLConnection, e3)));
                    obj2 = obj;
                }
            } else {
                obj2 = obj;
            }
            if (obj2 instanceof JSONArray) {
                JSONArray jSONArray2 = (JSONArray) obj2;
                if (jSONArray2.length() == size) {
                    int length = jSONArray2.length();
                    if (length > 0) {
                        while (true) {
                            int i3 = i2 + 1;
                            GraphRequest graphRequest2 = list.get(i2);
                            try {
                                Object obj3 = ((JSONArray) obj2).get(i2);
                                kotlin.jvm.internal.m.e(obj3, "obj");
                                arrayList.add(b(graphRequest2, httpURLConnection, obj3, obj));
                            } catch (FacebookException e4) {
                                arrayList.add(new d0(graphRequest2, httpURLConnection, new FacebookRequestError(httpURLConnection, e4)));
                            } catch (JSONException e5) {
                                arrayList.add(new d0(graphRequest2, httpURLConnection, new FacebookRequestError(httpURLConnection, e5)));
                            }
                            if (i3 >= length) {
                                break;
                            }
                            i2 = i3;
                        }
                    }
                    return arrayList;
                }
            }
            throw new FacebookException("Unexpected number of results");
        }

        public final List<d0> a(List<GraphRequest> list, HttpURLConnection httpURLConnection, FacebookException facebookException) {
            kotlin.jvm.internal.m.f(list, "requests");
            ArrayList arrayList = new ArrayList(kotlin.collections.v.u(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new d0((GraphRequest) it.next(), httpURLConnection, new FacebookRequestError(httpURLConnection, facebookException)));
            }
            return arrayList;
        }

        public final List<d0> d(InputStream inputStream, HttpURLConnection httpURLConnection, c0 c0Var) throws Throwable {
            kotlin.jvm.internal.m.f(c0Var, "requests");
            p0 p0Var = p0.a;
            String strS0 = p0.s0(inputStream);
            com.facebook.internal.j0.a.c(g0.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(strS0.length()), strS0);
            return e(strS0, httpURLConnection, c0Var);
        }

        public final List<d0> e(String str, HttpURLConnection httpURLConnection, c0 c0Var) throws JSONException, FacebookException, IOException {
            kotlin.jvm.internal.m.f(str, "responseString");
            kotlin.jvm.internal.m.f(c0Var, "requests");
            Object objNextValue = new JSONTokener(str).nextValue();
            kotlin.jvm.internal.m.e(objNextValue, "resultObject");
            List<d0> listC = c(httpURLConnection, c0Var, objNextValue);
            com.facebook.internal.j0.a.c(g0.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", c0Var.v(), Integer.valueOf(str.length()), listC);
            return listC;
        }

        public final List<d0> f(HttpURLConnection httpURLConnection, c0 c0Var) {
            List<d0> listA;
            kotlin.jvm.internal.m.f(httpURLConnection, "connection");
            kotlin.jvm.internal.m.f(c0Var, "requests");
            InputStream errorStream = null;
            try {
                try {
                    try {
                        a0 a0Var = a0.a;
                        if (!a0.v()) {
                            Log.e(d0.f9691b, "GraphRequest can't be used when Facebook SDK isn't fully initialized");
                            throw new FacebookException("GraphRequest can't be used when Facebook SDK isn't fully initialized");
                        }
                        errorStream = httpURLConnection.getResponseCode() >= 400 ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
                        listA = d(errorStream, httpURLConnection, c0Var);
                        p0 p0Var = p0.a;
                        p0.h(errorStream);
                        return listA;
                    } catch (Exception e2) {
                        com.facebook.internal.j0.a.c(g0.REQUESTS, "Response", "Response <Error>: %s", e2);
                        listA = a(c0Var, httpURLConnection, new FacebookException(e2));
                    }
                } catch (FacebookException e3) {
                    com.facebook.internal.j0.a.c(g0.REQUESTS, "Response", "Response <Error>: %s", e3);
                    listA = a(c0Var, httpURLConnection, e3);
                }
            } catch (Throwable th) {
                p0 p0Var2 = p0.a;
                p0.h(null);
                throw th;
            }
        }
    }

    public d0(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject, JSONArray jSONArray, FacebookRequestError facebookRequestError) {
        kotlin.jvm.internal.m.f(graphRequest, "request");
        this.f9692c = graphRequest;
        this.f9693d = httpURLConnection;
        this.f9694e = str;
        this.f9695f = jSONObject;
        this.f9696g = jSONArray;
        this.f9697h = facebookRequestError;
        this.f9698i = jSONObject;
        this.f9699j = jSONArray;
    }

    public final FacebookRequestError b() {
        return this.f9697h;
    }

    public final JSONObject c() {
        return this.f9695f;
    }

    public final JSONObject d() {
        return this.f9698i;
    }

    public String toString() {
        String str;
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            Locale locale = Locale.US;
            Object[] objArr = new Object[1];
            HttpURLConnection httpURLConnection = this.f9693d;
            objArr[0] = Integer.valueOf(httpURLConnection == null ? 200 : httpURLConnection.getResponseCode());
            str = String.format(locale, "%d", Arrays.copyOf(objArr, 1));
            kotlin.jvm.internal.m.e(str, "java.lang.String.format(locale, format, *args)");
        } catch (IOException unused) {
            str = "unknown";
        }
        String str2 = "{Response:  responseCode: " + str + ", graphObject: " + this.f9695f + ", error: " + this.f9697h + "}";
        kotlin.jvm.internal.m.e(str2, "StringBuilder()\n        .append(\"{Response: \")\n        .append(\" responseCode: \")\n        .append(responseCode)\n        .append(\", graphObject: \")\n        .append(graphObject)\n        .append(\", error: \")\n        .append(error)\n        .append(\"}\")\n        .toString()");
        return str2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d0(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject) {
        this(graphRequest, httpURLConnection, str, jSONObject, null, null);
        kotlin.jvm.internal.m.f(graphRequest, "request");
        kotlin.jvm.internal.m.f(str, "rawResponse");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d0(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONArray jSONArray) {
        this(graphRequest, httpURLConnection, str, null, jSONArray, null);
        kotlin.jvm.internal.m.f(graphRequest, "request");
        kotlin.jvm.internal.m.f(str, "rawResponse");
        kotlin.jvm.internal.m.f(jSONArray, "graphObjects");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d0(GraphRequest graphRequest, HttpURLConnection httpURLConnection, FacebookRequestError facebookRequestError) {
        this(graphRequest, httpURLConnection, null, null, null, facebookRequestError);
        kotlin.jvm.internal.m.f(graphRequest, "request");
        kotlin.jvm.internal.m.f(facebookRequestError, "error");
    }
}
