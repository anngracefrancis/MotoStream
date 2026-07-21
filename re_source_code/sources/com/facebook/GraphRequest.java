package com.facebook;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.database.room.RoomNotification;
import cm.aptoide.pt.networking.BodyInterceptorV3;
import com.facebook.internal.p0;
import com.facebook.internal.q0;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: GraphRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GraphRequest {
    public static final c a = new c(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9619b = GraphRequest.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f9620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f9621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pattern f9622e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile String f9623f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AccessToken f9624g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f9625h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private JSONObject f9626i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f9627j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f9628k;
    private boolean l;
    private Bundle m;
    private Object n;
    private String o;
    private b p;
    private e0 q;
    private boolean r;
    private String s;

    /* JADX INFO: compiled from: GraphRequest.kt */
    private static final class a {
        private final GraphRequest a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f9632b;

        public a(GraphRequest graphRequest, Object obj) {
            kotlin.jvm.internal.m.f(graphRequest, "request");
            this.a = graphRequest;
            this.f9632b = obj;
        }

        public final GraphRequest a() {
            return this.a;
        }

        public final Object b() {
            return this.f9632b;
        }
    }

    /* JADX INFO: compiled from: GraphRequest.kt */
    public interface b {
        void b(d0 d0Var);
    }

    /* JADX INFO: compiled from: GraphRequest.kt */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String C(Object obj) {
            if (obj instanceof String) {
                return (String) obj;
            }
            if ((obj instanceof Boolean) || (obj instanceof Number)) {
                return obj.toString();
            }
            if (!(obj instanceof Date)) {
                throw new IllegalArgumentException("Unsupported parameter type.");
            }
            String str = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) obj);
            kotlin.jvm.internal.m.e(str, "iso8601DateFormat.format(value)");
            return str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:10:0x0023  */
        public final void D(JSONObject jSONObject, String str, e eVar) {
            boolean z;
            if (s(str)) {
                int iW = kotlin.text.v.W(str, ":", 0, false, 6, null);
                int iW2 = kotlin.text.v.W(str, "?", 0, false, 6, null);
                if (iW <= 3 || (iW2 != -1 && iW >= iW2)) {
                    z = false;
                } else {
                    z = true;
                }
            } else {
                z = false;
            }
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object objOpt = jSONObject.opt(next);
                boolean z2 = z && kotlin.text.u.q(next, "image", true);
                kotlin.jvm.internal.m.e(next, RoomNotification.KEY);
                kotlin.jvm.internal.m.e(objOpt, "value");
                E(next, objOpt, eVar, z2);
            }
        }

        private final void E(String str, Object obj, e eVar, boolean z) {
            Class<?> cls = obj.getClass();
            if (JSONObject.class.isAssignableFrom(cls)) {
                JSONObject jSONObject = (JSONObject) obj;
                if (z) {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                        String str2 = String.format("%s[%s]", Arrays.copyOf(new Object[]{str, next}, 2));
                        kotlin.jvm.internal.m.e(str2, "java.lang.String.format(format, *args)");
                        Object objOpt = jSONObject.opt(next);
                        kotlin.jvm.internal.m.e(objOpt, "jsonObject.opt(propertyName)");
                        E(str2, objOpt, eVar, z);
                    }
                    return;
                }
                if (jSONObject.has(DeepLinkIntentReceiver.DeepLinksKeys.ID)) {
                    String strOptString = jSONObject.optString(DeepLinkIntentReceiver.DeepLinksKeys.ID);
                    kotlin.jvm.internal.m.e(strOptString, "jsonObject.optString(\"id\")");
                    E(str, strOptString, eVar, z);
                    return;
                } else if (jSONObject.has("url")) {
                    String strOptString2 = jSONObject.optString("url");
                    kotlin.jvm.internal.m.e(strOptString2, "jsonObject.optString(\"url\")");
                    E(str, strOptString2, eVar, z);
                    return;
                } else {
                    if (jSONObject.has("fbsdk:create_object")) {
                        String string = jSONObject.toString();
                        kotlin.jvm.internal.m.e(string, "jsonObject.toString()");
                        E(str, string, eVar, z);
                        return;
                    }
                    return;
                }
            }
            if (!JSONArray.class.isAssignableFrom(cls)) {
                if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
                    eVar.a(str, obj.toString());
                    return;
                }
                if (Date.class.isAssignableFrom(cls)) {
                    String str3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) obj);
                    kotlin.jvm.internal.m.e(str3, "iso8601DateFormat.format(date)");
                    eVar.a(str, str3);
                    return;
                }
                p0 p0Var = p0.a;
                p0.j0(GraphRequest.f9619b, "The type of property " + str + " in the graph object is unknown. It won't be sent in the request.");
                return;
            }
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            if (length <= 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.a;
                String str4 = String.format(Locale.ROOT, "%s[%d]", Arrays.copyOf(new Object[]{str, Integer.valueOf(i2)}, 2));
                kotlin.jvm.internal.m.e(str4, "java.lang.String.format(locale, format, *args)");
                Object objOpt2 = jSONArray.opt(i2);
                kotlin.jvm.internal.m.e(objOpt2, "jsonArray.opt(i)");
                E(str4, objOpt2, eVar, z);
                if (i3 >= length) {
                    return;
                } else {
                    i2 = i3;
                }
            }
        }

        private final void F(c0 c0Var, com.facebook.internal.j0 j0Var, int i2, URL url, OutputStream outputStream, boolean z) throws JSONException, IOException {
            g gVar = new g(outputStream, j0Var, z);
            if (i2 != 1) {
                String strN = n(c0Var);
                if (strN.length() == 0) {
                    throw new FacebookException("App ID was not specified at the request or Settings.");
                }
                gVar.a("batch_app_id", strN);
                HashMap map = new HashMap();
                K(gVar, c0Var, map);
                if (j0Var != null) {
                    j0Var.b("  Attachments:\n");
                }
                I(map, gVar);
                return;
            }
            GraphRequest graphRequestR = c0Var.get(0);
            HashMap map2 = new HashMap();
            for (String str : graphRequestR.t().keySet()) {
                Object obj = graphRequestR.t().get(str);
                if (t(obj)) {
                    kotlin.jvm.internal.m.e(str, RoomNotification.KEY);
                    map2.put(str, new a(graphRequestR, obj));
                }
            }
            if (j0Var != null) {
                j0Var.b("  Parameters:\n");
            }
            J(graphRequestR.t(), gVar, graphRequestR);
            if (j0Var != null) {
                j0Var.b("  Attachments:\n");
            }
            I(map2, gVar);
            JSONObject jSONObjectP = graphRequestR.p();
            if (jSONObjectP != null) {
                String path = url.getPath();
                kotlin.jvm.internal.m.e(path, "url.path");
                D(jSONObjectP, path, gVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void H(ArrayList arrayList, c0 c0Var) {
            kotlin.jvm.internal.m.f(arrayList, "$callbacks");
            kotlin.jvm.internal.m.f(c0Var, "$requests");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                b bVar = (b) pair.first;
                Object obj = pair.second;
                kotlin.jvm.internal.m.e(obj, "pair.second");
                bVar.b((d0) obj);
            }
            Iterator<c0.a> it2 = c0Var.u().iterator();
            while (it2.hasNext()) {
                it2.next().a(c0Var);
            }
        }

        private final void I(Map<String, a> map, g gVar) throws IOException {
            for (Map.Entry<String, a> entry : map.entrySet()) {
                if (GraphRequest.a.t(entry.getValue().b())) {
                    gVar.j(entry.getKey(), entry.getValue().b(), entry.getValue().a());
                }
            }
        }

        private final void J(Bundle bundle, g gVar, GraphRequest graphRequest) throws IOException {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (u(obj)) {
                    kotlin.jvm.internal.m.e(str, RoomNotification.KEY);
                    gVar.j(str, obj, graphRequest);
                }
            }
        }

        private final void K(g gVar, Collection<GraphRequest> collection, Map<String, a> map) throws JSONException, IOException {
            JSONArray jSONArray = new JSONArray();
            Iterator<GraphRequest> it = collection.iterator();
            while (it.hasNext()) {
                it.next().C(jSONArray, map);
            }
            gVar.l("batch", jSONArray, collection);
        }

        private final void M(HttpURLConnection httpURLConnection, boolean z) {
            if (!z) {
                httpURLConnection.setRequestProperty("Content-Type", o());
            } else {
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            }
        }

        private final HttpURLConnection e(URL url) throws IOException {
            URLConnection uRLConnectionOpenConnection = url.openConnection();
            if (uRLConnectionOpenConnection == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setRequestProperty("User-Agent", p());
            httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
            httpURLConnection.setChunkedStreamingMode(0);
            return httpURLConnection;
        }

        private final String n(c0 c0Var) {
            String strS = c0Var.s();
            if (strS != null && (!c0Var.isEmpty())) {
                return strS;
            }
            Iterator<GraphRequest> it = c0Var.iterator();
            while (it.hasNext()) {
                AccessToken accessTokenL = it.next().l();
                if (accessTokenL != null) {
                    return accessTokenL.c();
                }
            }
            String str = GraphRequest.f9621d;
            if (str != null) {
                if (str.length() > 0) {
                    return str;
                }
            }
            a0 a0Var = a0.a;
            return a0.d();
        }

        private final String o() {
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String str = String.format("multipart/form-data; boundary=%s", Arrays.copyOf(new Object[]{GraphRequest.f9620c}, 1));
            kotlin.jvm.internal.m.e(str, "java.lang.String.format(format, *args)");
            return str;
        }

        private final String p() {
            if (GraphRequest.f9623f == null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                String str = String.format("%s.%s", Arrays.copyOf(new Object[]{"FBAndroidSDK", "16.2.0"}, 2));
                kotlin.jvm.internal.m.e(str, "java.lang.String.format(format, *args)");
                GraphRequest.f9623f = str;
                com.facebook.internal.h0 h0Var = com.facebook.internal.h0.a;
                String strA = com.facebook.internal.h0.a();
                p0 p0Var = p0.a;
                if (!p0.a0(strA)) {
                    String str2 = String.format(Locale.ROOT, "%s/%s", Arrays.copyOf(new Object[]{GraphRequest.f9623f, strA}, 2));
                    kotlin.jvm.internal.m.e(str2, "java.lang.String.format(locale, format, *args)");
                    GraphRequest.f9623f = str2;
                }
            }
            return GraphRequest.f9623f;
        }

        private final boolean q(c0 c0Var) {
            Iterator<c0.a> it = c0Var.u().iterator();
            while (it.hasNext()) {
                if (it.next() instanceof c0.c) {
                    return true;
                }
            }
            Iterator<GraphRequest> it2 = c0Var.iterator();
            while (it2.hasNext()) {
                if (it2.next().n() instanceof f) {
                    return true;
                }
            }
            return false;
        }

        private final boolean r(c0 c0Var) {
            for (GraphRequest graphRequest : c0Var) {
                Iterator<String> it = graphRequest.t().keySet().iterator();
                while (it.hasNext()) {
                    if (t(graphRequest.t().get(it.next()))) {
                        return false;
                    }
                }
            }
            return true;
        }

        private final boolean s(String str) {
            Matcher matcher = GraphRequest.f9622e.matcher(str);
            if (matcher.matches()) {
                str = matcher.group(1);
                kotlin.jvm.internal.m.e(str, "matcher.group(1)");
            }
            return kotlin.text.u.E(str, "me/", false, 2, null) || kotlin.text.u.E(str, "/me/", false, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean t(Object obj) {
            return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor) || (obj instanceof ParcelableResourceWithMimeType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean u(Object obj) {
            return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(d dVar, d0 d0Var) {
            kotlin.jvm.internal.m.f(d0Var, "response");
            if (dVar == null) {
                return;
            }
            dVar.a(d0Var.c(), d0Var);
        }

        public final GraphRequest A(AccessToken accessToken, String str, JSONObject jSONObject, b bVar) {
            GraphRequest graphRequest = new GraphRequest(accessToken, str, null, e0.POST, bVar, null, 32, null);
            graphRequest.F(jSONObject);
            return graphRequest;
        }

        public final GraphRequest B(AccessToken accessToken, String str, Bundle bundle, b bVar) {
            return new GraphRequest(accessToken, str, bundle, e0.POST, bVar, null, 32, null);
        }

        public final void G(final c0 c0Var, List<d0> list) {
            kotlin.jvm.internal.m.f(c0Var, "requests");
            kotlin.jvm.internal.m.f(list, "responses");
            int size = c0Var.size();
            final ArrayList arrayList = new ArrayList();
            if (size > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    GraphRequest graphRequestR = c0Var.get(i2);
                    if (graphRequestR.n() != null) {
                        arrayList.add(new Pair(graphRequestR.n(), list.get(i2)));
                    }
                    if (i3 >= size) {
                        break;
                    } else {
                        i2 = i3;
                    }
                }
            }
            if (arrayList.size() > 0) {
                Runnable runnable = new Runnable() { // from class: com.facebook.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        GraphRequest.c.H(arrayList, c0Var);
                    }
                };
                Handler handlerT = c0Var.t();
                if ((handlerT == null ? null : Boolean.valueOf(handlerT.post(runnable))) == null) {
                    runnable.run();
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:33:0x00f2  */
        public final void L(c0 c0Var, HttpURLConnection httpURLConnection) throws Throwable {
            OutputStream gZIPOutputStream;
            kotlin.jvm.internal.m.f(c0Var, "requests");
            kotlin.jvm.internal.m.f(httpURLConnection, "connection");
            com.facebook.internal.j0 j0Var = new com.facebook.internal.j0(g0.REQUESTS, "Request");
            int size = c0Var.size();
            boolean zR = r(c0Var);
            OutputStream outputStream = null;
            e0 e0VarS = size == 1 ? c0Var.get(0).s() : null;
            if (e0VarS == null) {
                e0VarS = e0.POST;
            }
            httpURLConnection.setRequestMethod(e0VarS.name());
            M(httpURLConnection, zR);
            URL url = httpURLConnection.getURL();
            j0Var.b("Request:\n");
            j0Var.d("Id", c0Var.v());
            kotlin.jvm.internal.m.e(url, "url");
            j0Var.d("URL", url);
            Object requestMethod = httpURLConnection.getRequestMethod();
            kotlin.jvm.internal.m.e(requestMethod, "connection.requestMethod");
            j0Var.d("Method", requestMethod);
            Object requestProperty = httpURLConnection.getRequestProperty("User-Agent");
            kotlin.jvm.internal.m.e(requestProperty, "connection.getRequestProperty(\"User-Agent\")");
            j0Var.d("User-Agent", requestProperty);
            Object requestProperty2 = httpURLConnection.getRequestProperty("Content-Type");
            kotlin.jvm.internal.m.e(requestProperty2, "connection.getRequestProperty(\"Content-Type\")");
            j0Var.d("Content-Type", requestProperty2);
            httpURLConnection.setConnectTimeout(c0Var.y());
            httpURLConnection.setReadTimeout(c0Var.y());
            if (!(e0VarS == e0.POST)) {
                j0Var.e();
                return;
            }
            httpURLConnection.setDoOutput(true);
            try {
                OutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                if (zR) {
                    try {
                        gZIPOutputStream = new GZIPOutputStream(bufferedOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        outputStream = bufferedOutputStream;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        throw th;
                    }
                } else {
                    gZIPOutputStream = bufferedOutputStream;
                }
                try {
                    if (q(c0Var)) {
                        j0 j0Var2 = new j0(c0Var.t());
                        F(c0Var, null, size, url, j0Var2, zR);
                        gZIPOutputStream = new k0(gZIPOutputStream, c0Var, j0Var2.d(), j0Var2.c());
                    }
                    F(c0Var, j0Var, size, url, gZIPOutputStream, zR);
                    gZIPOutputStream.close();
                    j0Var.e();
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = gZIPOutputStream;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        public final HttpURLConnection N(c0 c0Var) throws Throwable {
            URL url;
            kotlin.jvm.internal.m.f(c0Var, "requests");
            O(c0Var);
            try {
                if (c0Var.size() == 1) {
                    url = new URL(c0Var.get(0).w());
                } else {
                    com.facebook.internal.n0 n0Var = com.facebook.internal.n0.a;
                    url = new URL(com.facebook.internal.n0.h());
                }
                HttpURLConnection httpURLConnectionE = null;
                try {
                    httpURLConnectionE = e(url);
                    L(c0Var, httpURLConnectionE);
                    return httpURLConnectionE;
                } catch (IOException e2) {
                    p0 p0Var = p0.a;
                    p0.o(httpURLConnectionE);
                    throw new FacebookException("could not construct request body", e2);
                } catch (JSONException e3) {
                    p0 p0Var2 = p0.a;
                    p0.o(httpURLConnectionE);
                    throw new FacebookException("could not construct request body", e3);
                }
            } catch (MalformedURLException e4) {
                throw new FacebookException("could not construct URL for request", e4);
            }
        }

        public final void O(c0 c0Var) {
            kotlin.jvm.internal.m.f(c0Var, "requests");
            for (GraphRequest graphRequest : c0Var) {
                if (e0.GET == graphRequest.s()) {
                    p0 p0Var = p0.a;
                    if (p0.a0(graphRequest.t().getString("fields"))) {
                        com.facebook.internal.j0.a aVar = com.facebook.internal.j0.a;
                        g0 g0Var = g0.DEVELOPER_ERRORS;
                        StringBuilder sb = new StringBuilder();
                        sb.append("GET requests for /");
                        String strQ = graphRequest.q();
                        if (strQ == null) {
                            strQ = HttpUrl.FRAGMENT_ENCODE_SET;
                        }
                        sb.append(strQ);
                        sb.append(" should contain an explicit \"fields\" parameter.");
                        aVar.a(g0Var, 5, "Request", sb.toString());
                    }
                }
            }
        }

        public final d0 f(GraphRequest graphRequest) {
            kotlin.jvm.internal.m.f(graphRequest, "request");
            List<d0> listI = i(graphRequest);
            if (listI.size() == 1) {
                return listI.get(0);
            }
            throw new FacebookException("invalid state: expected a single response");
        }

        public final List<d0> g(c0 c0Var) throws Throwable {
            Exception exc;
            HttpURLConnection httpURLConnectionN;
            List<d0> listM;
            kotlin.jvm.internal.m.f(c0Var, "requests");
            q0 q0Var = q0.a;
            q0.i(c0Var, "requests");
            HttpURLConnection httpURLConnection = null;
            try {
                httpURLConnectionN = N(c0Var);
                exc = null;
            } catch (Exception e2) {
                exc = e2;
                httpURLConnectionN = null;
            } catch (Throwable th) {
                th = th;
                p0 p0Var = p0.a;
                p0.o(httpURLConnection);
                throw th;
            }
            try {
                if (httpURLConnectionN != null) {
                    listM = m(httpURLConnectionN, c0Var);
                } else {
                    List<d0> listA = d0.a.a(c0Var.w(), null, new FacebookException(exc));
                    G(c0Var, listA);
                    listM = listA;
                }
                p0 p0Var2 = p0.a;
                p0.o(httpURLConnectionN);
                return listM;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnectionN;
                p0 p0Var3 = p0.a;
                p0.o(httpURLConnection);
                throw th;
            }
        }

        public final List<d0> h(Collection<GraphRequest> collection) {
            kotlin.jvm.internal.m.f(collection, "requests");
            return g(new c0(collection));
        }

        public final List<d0> i(GraphRequest... graphRequestArr) {
            kotlin.jvm.internal.m.f(graphRequestArr, "requests");
            return h(kotlin.collections.n.Z(graphRequestArr));
        }

        public final b0 j(c0 c0Var) {
            kotlin.jvm.internal.m.f(c0Var, "requests");
            q0 q0Var = q0.a;
            q0.i(c0Var, "requests");
            b0 b0Var = new b0(c0Var);
            a0 a0Var = a0.a;
            b0Var.executeOnExecutor(a0.k(), new Void[0]);
            return b0Var;
        }

        public final b0 k(Collection<GraphRequest> collection) {
            kotlin.jvm.internal.m.f(collection, "requests");
            return j(new c0(collection));
        }

        public final b0 l(GraphRequest... graphRequestArr) {
            kotlin.jvm.internal.m.f(graphRequestArr, "requests");
            return k(kotlin.collections.n.Z(graphRequestArr));
        }

        public final List<d0> m(HttpURLConnection httpURLConnection, c0 c0Var) {
            kotlin.jvm.internal.m.f(httpURLConnection, "connection");
            kotlin.jvm.internal.m.f(c0Var, "requests");
            List<d0> listF = d0.a.f(httpURLConnection, c0Var);
            p0 p0Var = p0.a;
            p0.o(httpURLConnection);
            int size = c0Var.size();
            if (size == listF.size()) {
                G(c0Var, listF);
                v.a.e().d();
                return listF;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String str = String.format(Locale.US, "Received %d responses while expecting %d", Arrays.copyOf(new Object[]{Integer.valueOf(listF.size()), Integer.valueOf(size)}, 2));
            kotlin.jvm.internal.m.e(str, "java.lang.String.format(locale, format, *args)");
            throw new FacebookException(str);
        }

        public final GraphRequest x(AccessToken accessToken, String str, b bVar) {
            return new GraphRequest(accessToken, str, null, null, bVar, null, 32, null);
        }

        public final GraphRequest y(AccessToken accessToken, final d dVar) {
            return new GraphRequest(accessToken, "me", null, null, new b() { // from class: com.facebook.p
                @Override // com.facebook.GraphRequest.b
                public final void b(d0 d0Var) {
                    GraphRequest.c.z(dVar, d0Var);
                }
            }, null, 32, null);
        }
    }

    /* JADX INFO: compiled from: GraphRequest.kt */
    public interface d {
        void a(JSONObject jSONObject, d0 d0Var);
    }

    /* JADX INFO: compiled from: GraphRequest.kt */
    private interface e {
        void a(String str, String str2);
    }

    /* JADX INFO: compiled from: GraphRequest.kt */
    public interface f extends b {
        void a(long j2, long j3);
    }

    /* JADX INFO: compiled from: GraphRequest.kt */
    private static final class g implements e {
        private final OutputStream a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.facebook.internal.j0 f9633b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f9634c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f9635d;

        public g(OutputStream outputStream, com.facebook.internal.j0 j0Var, boolean z) {
            kotlin.jvm.internal.m.f(outputStream, "outputStream");
            this.a = outputStream;
            this.f9633b = j0Var;
            this.f9634c = true;
            this.f9635d = z;
        }

        private final RuntimeException b() {
            return new IllegalArgumentException("value is not a supported type.");
        }

        @Override // com.facebook.GraphRequest.e
        public void a(String str, String str2) throws IOException {
            kotlin.jvm.internal.m.f(str, RoomNotification.KEY);
            kotlin.jvm.internal.m.f(str2, "value");
            f(str, null, null);
            i("%s", str2);
            k();
            com.facebook.internal.j0 j0Var = this.f9633b;
            if (j0Var == null) {
                return;
            }
            j0Var.d(kotlin.jvm.internal.m.n("    ", str), str2);
        }

        public final void c(String str, Object... objArr) throws IOException {
            kotlin.jvm.internal.m.f(str, "format");
            kotlin.jvm.internal.m.f(objArr, "args");
            if (this.f9635d) {
                OutputStream outputStream = this.a;
                StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                Locale locale = Locale.US;
                Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
                String str2 = String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
                kotlin.jvm.internal.m.e(str2, "java.lang.String.format(locale, format, *args)");
                String strEncode = URLEncoder.encode(str2, "UTF-8");
                kotlin.jvm.internal.m.e(strEncode, "encode(String.format(Locale.US, format, *args), \"UTF-8\")");
                byte[] bytes = strEncode.getBytes(Charsets.f25054b);
                kotlin.jvm.internal.m.e(bytes, "(this as java.lang.String).getBytes(charset)");
                outputStream.write(bytes);
                return;
            }
            if (this.f9634c) {
                OutputStream outputStream2 = this.a;
                Charset charset = Charsets.f25054b;
                byte[] bytes2 = "--".getBytes(charset);
                kotlin.jvm.internal.m.e(bytes2, "(this as java.lang.String).getBytes(charset)");
                outputStream2.write(bytes2);
                OutputStream outputStream3 = this.a;
                String str3 = GraphRequest.f9620c;
                if (str3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                byte[] bytes3 = str3.getBytes(charset);
                kotlin.jvm.internal.m.e(bytes3, "(this as java.lang.String).getBytes(charset)");
                outputStream3.write(bytes3);
                OutputStream outputStream4 = this.a;
                byte[] bytes4 = "\r\n".getBytes(charset);
                kotlin.jvm.internal.m.e(bytes4, "(this as java.lang.String).getBytes(charset)");
                outputStream4.write(bytes4);
                this.f9634c = false;
            }
            OutputStream outputStream5 = this.a;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.a;
            Object[] objArrCopyOf2 = Arrays.copyOf(objArr, objArr.length);
            String str4 = String.format(str, Arrays.copyOf(objArrCopyOf2, objArrCopyOf2.length));
            kotlin.jvm.internal.m.e(str4, "java.lang.String.format(format, *args)");
            Charset charset2 = Charsets.f25054b;
            if (str4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes5 = str4.getBytes(charset2);
            kotlin.jvm.internal.m.e(bytes5, "(this as java.lang.String).getBytes(charset)");
            outputStream5.write(bytes5);
        }

        public final void d(String str, Bitmap bitmap) throws IOException {
            kotlin.jvm.internal.m.f(str, RoomNotification.KEY);
            kotlin.jvm.internal.m.f(bitmap, "bitmap");
            f(str, str, "image/png");
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, this.a);
            i(HttpUrl.FRAGMENT_ENCODE_SET, new Object[0]);
            k();
            com.facebook.internal.j0 j0Var = this.f9633b;
            if (j0Var == null) {
                return;
            }
            j0Var.d(kotlin.jvm.internal.m.n("    ", str), "<Image>");
        }

        public final void e(String str, byte[] bArr) throws IOException {
            kotlin.jvm.internal.m.f(str, RoomNotification.KEY);
            kotlin.jvm.internal.m.f(bArr, "bytes");
            f(str, str, "content/unknown");
            this.a.write(bArr);
            i(HttpUrl.FRAGMENT_ENCODE_SET, new Object[0]);
            k();
            com.facebook.internal.j0 j0Var = this.f9633b;
            if (j0Var == null) {
                return;
            }
            String strN = kotlin.jvm.internal.m.n("    ", str);
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String str2 = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(bArr.length)}, 1));
            kotlin.jvm.internal.m.e(str2, "java.lang.String.format(locale, format, *args)");
            j0Var.d(strN, str2);
        }

        public final void f(String str, String str2, String str3) throws IOException {
            if (!this.f9635d) {
                c("Content-Disposition: form-data; name=\"%s\"", str);
                if (str2 != null) {
                    c("; filename=\"%s\"", str2);
                }
                i(HttpUrl.FRAGMENT_ENCODE_SET, new Object[0]);
                if (str3 != null) {
                    i("%s: %s", "Content-Type", str3);
                }
                i(HttpUrl.FRAGMENT_ENCODE_SET, new Object[0]);
                return;
            }
            OutputStream outputStream = this.a;
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String str4 = String.format("%s=", Arrays.copyOf(new Object[]{str}, 1));
            kotlin.jvm.internal.m.e(str4, "java.lang.String.format(format, *args)");
            Charset charset = Charsets.f25054b;
            if (str4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = str4.getBytes(charset);
            kotlin.jvm.internal.m.e(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream.write(bytes);
        }

        public final void g(String str, Uri uri, String str2) throws IOException {
            int iN;
            kotlin.jvm.internal.m.f(str, RoomNotification.KEY);
            kotlin.jvm.internal.m.f(uri, "contentUri");
            if (str2 == null) {
                str2 = "content/unknown";
            }
            f(str, str, str2);
            if (this.a instanceof j0) {
                p0 p0Var = p0.a;
                ((j0) this.a).b(p0.x(uri));
                iN = 0;
            } else {
                a0 a0Var = a0.a;
                InputStream inputStreamOpenInputStream = a0.c().getContentResolver().openInputStream(uri);
                p0 p0Var2 = p0.a;
                iN = p0.n(inputStreamOpenInputStream, this.a) + 0;
            }
            i(HttpUrl.FRAGMENT_ENCODE_SET, new Object[0]);
            k();
            com.facebook.internal.j0 j0Var = this.f9633b;
            if (j0Var == null) {
                return;
            }
            String strN = kotlin.jvm.internal.m.n("    ", str);
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String str3 = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(iN)}, 1));
            kotlin.jvm.internal.m.e(str3, "java.lang.String.format(locale, format, *args)");
            j0Var.d(strN, str3);
        }

        public final void h(String str, ParcelFileDescriptor parcelFileDescriptor, String str2) throws IOException {
            int iN;
            kotlin.jvm.internal.m.f(str, RoomNotification.KEY);
            kotlin.jvm.internal.m.f(parcelFileDescriptor, "descriptor");
            if (str2 == null) {
                str2 = "content/unknown";
            }
            f(str, str, str2);
            OutputStream outputStream = this.a;
            if (outputStream instanceof j0) {
                ((j0) outputStream).b(parcelFileDescriptor.getStatSize());
                iN = 0;
            } else {
                ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
                p0 p0Var = p0.a;
                iN = p0.n(autoCloseInputStream, this.a) + 0;
            }
            i(HttpUrl.FRAGMENT_ENCODE_SET, new Object[0]);
            k();
            com.facebook.internal.j0 j0Var = this.f9633b;
            if (j0Var == null) {
                return;
            }
            String strN = kotlin.jvm.internal.m.n("    ", str);
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String str3 = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(iN)}, 1));
            kotlin.jvm.internal.m.e(str3, "java.lang.String.format(locale, format, *args)");
            j0Var.d(strN, str3);
        }

        public final void i(String str, Object... objArr) throws IOException {
            kotlin.jvm.internal.m.f(str, "format");
            kotlin.jvm.internal.m.f(objArr, "args");
            c(str, Arrays.copyOf(objArr, objArr.length));
            if (this.f9635d) {
                return;
            }
            c("\r\n", new Object[0]);
        }

        public final void j(String str, Object obj, GraphRequest graphRequest) throws IOException {
            kotlin.jvm.internal.m.f(str, RoomNotification.KEY);
            Closeable closeable = this.a;
            if (closeable instanceof l0) {
                ((l0) closeable).a(graphRequest);
            }
            c cVar = GraphRequest.a;
            if (cVar.u(obj)) {
                a(str, cVar.C(obj));
                return;
            }
            if (obj instanceof Bitmap) {
                d(str, (Bitmap) obj);
                return;
            }
            if (obj instanceof byte[]) {
                e(str, (byte[]) obj);
                return;
            }
            if (obj instanceof Uri) {
                g(str, (Uri) obj, null);
                return;
            }
            if (obj instanceof ParcelFileDescriptor) {
                h(str, (ParcelFileDescriptor) obj, null);
                return;
            }
            if (!(obj instanceof ParcelableResourceWithMimeType)) {
                throw b();
            }
            ParcelableResourceWithMimeType parcelableResourceWithMimeType = (ParcelableResourceWithMimeType) obj;
            Parcelable parcelableB = parcelableResourceWithMimeType.b();
            String strA = parcelableResourceWithMimeType.a();
            if (parcelableB instanceof ParcelFileDescriptor) {
                h(str, (ParcelFileDescriptor) parcelableB, strA);
            } else {
                if (!(parcelableB instanceof Uri)) {
                    throw b();
                }
                g(str, (Uri) parcelableB, strA);
            }
        }

        public final void k() throws IOException {
            if (!this.f9635d) {
                i("--%s", GraphRequest.f9620c);
                return;
            }
            OutputStream outputStream = this.a;
            byte[] bytes = "&".getBytes(Charsets.f25054b);
            kotlin.jvm.internal.m.e(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream.write(bytes);
        }

        public final void l(String str, JSONArray jSONArray, Collection<GraphRequest> collection) throws JSONException, IOException {
            kotlin.jvm.internal.m.f(str, RoomNotification.KEY);
            kotlin.jvm.internal.m.f(jSONArray, "requestJsonArray");
            kotlin.jvm.internal.m.f(collection, "requests");
            Closeable closeable = this.a;
            if (!(closeable instanceof l0)) {
                String string = jSONArray.toString();
                kotlin.jvm.internal.m.e(string, "requestJsonArray.toString()");
                a(str, string);
                return;
            }
            l0 l0Var = (l0) closeable;
            f(str, null, null);
            c("[", new Object[0]);
            int i2 = 0;
            for (GraphRequest graphRequest : collection) {
                int i3 = i2 + 1;
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                l0Var.a(graphRequest);
                if (i2 > 0) {
                    c(",%s", jSONObject.toString());
                } else {
                    c("%s", jSONObject.toString());
                }
                i2 = i3;
            }
            c("]", new Object[0]);
            com.facebook.internal.j0 j0Var = this.f9633b;
            if (j0Var == null) {
                return;
            }
            String strN = kotlin.jvm.internal.m.n("    ", str);
            String string2 = jSONArray.toString();
            kotlin.jvm.internal.m.e(string2, "requestJsonArray.toString()");
            j0Var.d(strN, string2);
        }
    }

    /* JADX INFO: compiled from: GraphRequest.kt */
    public static final class h implements e {
        final /* synthetic */ ArrayList<String> a;

        h(ArrayList<String> arrayList) {
            this.a = arrayList;
        }

        @Override // com.facebook.GraphRequest.e
        public void a(String str, String str2) throws IOException {
            kotlin.jvm.internal.m.f(str, RoomNotification.KEY);
            kotlin.jvm.internal.m.f(str2, "value");
            ArrayList<String> arrayList = this.a;
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String str3 = String.format(Locale.US, "%s=%s", Arrays.copyOf(new Object[]{str, URLEncoder.encode(str2, "UTF-8")}, 2));
            kotlin.jvm.internal.m.e(str3, "java.lang.String.format(locale, format, *args)");
            arrayList.add(str3);
        }
    }

    static {
        char[] charArray = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        kotlin.jvm.internal.m.e(charArray, "(this as java.lang.String).toCharArray()");
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        int iNextInt = secureRandom.nextInt(11) + 30;
        if (iNextInt > 0) {
            int i2 = 0;
            do {
                i2++;
                sb.append(charArray[secureRandom.nextInt(charArray.length)]);
            } while (i2 < iNextInt);
        }
        String string = sb.toString();
        kotlin.jvm.internal.m.e(string, "buffer.toString()");
        f9620c = string;
        f9622e = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    }

    public GraphRequest() {
        this(null, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ GraphRequest(AccessToken accessToken, String str, Bundle bundle, e0 e0Var, b bVar, String str2, int i2, kotlin.jvm.internal.g gVar) {
        this((i2 & 1) != 0 ? null : accessToken, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : bundle, (i2 & 8) != 0 ? null : e0Var, (i2 & 16) != 0 ? null : bVar, (i2 & 32) != 0 ? null : str2);
    }

    public static final GraphRequest B(AccessToken accessToken, d dVar) {
        return a.y(accessToken, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(JSONArray jSONArray, Map<String, a> map) throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        String str = this.f9627j;
        if (str != null) {
            jSONObject.put("name", str);
            jSONObject.put("omit_response_on_success", this.l);
        }
        String str2 = this.f9628k;
        if (str2 != null) {
            jSONObject.put("depends_on", str2);
        }
        String strU = u();
        jSONObject.put("relative_url", strU);
        jSONObject.put("method", this.q);
        AccessToken accessToken = this.f9624g;
        if (accessToken != null) {
            com.facebook.internal.j0.a.d(accessToken.l());
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.m.keySet().iterator();
        while (it.hasNext()) {
            Object obj = this.m.get(it.next());
            if (a.t(obj)) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                String str3 = String.format(Locale.ROOT, "%s%d", Arrays.copyOf(new Object[]{"file", Integer.valueOf(map.size())}, 2));
                kotlin.jvm.internal.m.e(str3, "java.lang.String.format(locale, format, *args)");
                arrayList.add(str3);
                map.put(str3, new a(this, obj));
            }
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put("attached_files", TextUtils.join(",", arrayList));
        }
        JSONObject jSONObject2 = this.f9626i;
        if (jSONObject2 != null) {
            ArrayList arrayList2 = new ArrayList();
            a.D(jSONObject2, strU, new h(arrayList2));
            jSONObject.put("body", TextUtils.join("&", arrayList2));
        }
        jSONArray.put(jSONObject);
    }

    private final boolean J() {
        String strM = m();
        boolean zJ = strM == null ? false : kotlin.text.v.J(strM, "|", false, 2, null);
        if (((strM == null || !kotlin.text.u.E(strM, "IG", false, 2, null) || zJ) ? false : true) && y()) {
            return true;
        }
        return (z() || zJ) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(b bVar, d0 d0Var) {
        kotlin.jvm.internal.m.f(d0Var, "response");
        JSONObject jSONObjectC = d0Var.c();
        JSONObject jSONObjectOptJSONObject = jSONObjectC == null ? null : jSONObjectC.optJSONObject("__debug__");
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.optJSONArray("messages");
        if (jSONArrayOptJSONArray != null) {
            int i2 = 0;
            int length = jSONArrayOptJSONArray.length();
            if (length > 0) {
                while (true) {
                    int i3 = i2 + 1;
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
                    String strOptString = jSONObjectOptJSONObject2 == null ? null : jSONObjectOptJSONObject2.optString("message");
                    String strOptString2 = jSONObjectOptJSONObject2 == null ? null : jSONObjectOptJSONObject2.optString("type");
                    String strOptString3 = jSONObjectOptJSONObject2 == null ? null : jSONObjectOptJSONObject2.optString("link");
                    if (strOptString != null && strOptString2 != null) {
                        g0 g0Var = g0.GRAPH_API_DEBUG_INFO;
                        if (kotlin.jvm.internal.m.a(strOptString2, "warning")) {
                            g0Var = g0.GRAPH_API_DEBUG_WARNING;
                        }
                        p0 p0Var = p0.a;
                        if (!p0.a0(strOptString3)) {
                            strOptString = ((Object) strOptString) + " Link: " + ((Object) strOptString3);
                        }
                        com.facebook.internal.j0.a aVar = com.facebook.internal.j0.a;
                        String str = f9619b;
                        kotlin.jvm.internal.m.e(str, "TAG");
                        aVar.b(g0Var, str, strOptString);
                    }
                    if (i3 >= length) {
                        break;
                    } else {
                        i2 = i3;
                    }
                }
            }
        }
        if (bVar == null) {
            return;
        }
        bVar.b(d0Var);
    }

    private final void h() {
        Bundle bundle = this.m;
        if (J()) {
            bundle.putString("access_token", o());
        } else {
            String strM = m();
            if (strM != null) {
                bundle.putString("access_token", strM);
            }
        }
        if (!bundle.containsKey("access_token")) {
            p0 p0Var = p0.a;
            a0 a0Var = a0.a;
            if (p0.a0(a0.i())) {
                Log.w(f9619b, "Starting with v13 of the SDK, a client token must be embedded in your client code before making Graph API calls. Visit https://developers.facebook.com/docs/android/getting-started#client-token to learn how to implement this change.");
            }
        }
        bundle.putString("sdk", "android");
        bundle.putString("format", BodyInterceptorV3.RESPONSE_MODE_JSON);
        a0 a0Var2 = a0.a;
        if (a0.y(g0.GRAPH_API_DEBUG_INFO)) {
            bundle.putString("debug", "info");
        } else if (a0.y(g0.GRAPH_API_DEBUG_WARNING)) {
            bundle.putString("debug", "warning");
        }
    }

    private final String i(String str, boolean z) {
        if (!z && this.q == e0.POST) {
            return str;
        }
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        for (String str2 : this.m.keySet()) {
            Object obj = this.m.get(str2);
            if (obj == null) {
                obj = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            c cVar = a;
            if (cVar.u(obj)) {
                builderBuildUpon.appendQueryParameter(str2, cVar.C(obj).toString());
            } else if (this.q != e0.GET) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                String str3 = String.format(Locale.US, "Unsupported parameter type for GET request: %s", Arrays.copyOf(new Object[]{obj.getClass().getSimpleName()}, 1));
                kotlin.jvm.internal.m.e(str3, "java.lang.String.format(locale, format, *args)");
                throw new IllegalArgumentException(str3);
            }
        }
        String string = builderBuildUpon.toString();
        kotlin.jvm.internal.m.e(string, "uriBuilder.toString()");
        return string;
    }

    private final String m() {
        AccessToken accessToken = this.f9624g;
        if (accessToken != null) {
            if (!this.m.containsKey("access_token")) {
                String strL = accessToken.l();
                com.facebook.internal.j0.a.d(strL);
                return strL;
            }
        } else if (!this.m.containsKey("access_token")) {
            return o();
        }
        return this.m.getString("access_token");
    }

    private final String o() {
        a0 a0Var = a0.a;
        String strD = a0.d();
        String strI = a0.i();
        if (strD.length() > 0) {
            if (strI.length() > 0) {
                return strD + '|' + strI;
            }
        }
        p0 p0Var = p0.a;
        p0.j0(f9619b, "Warning: Request without access token missing application ID or client token.");
        return null;
    }

    private final String r() {
        if (f9622e.matcher(this.f9625h).matches()) {
            return this.f9625h;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String str = String.format("%s/%s", Arrays.copyOf(new Object[]{this.o, this.f9625h}, 2));
        kotlin.jvm.internal.m.e(str, "java.lang.String.format(format, *args)");
        return str;
    }

    private final String x(String str) {
        if (!z()) {
            com.facebook.internal.n0 n0Var = com.facebook.internal.n0.a;
            str = com.facebook.internal.n0.f();
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String str2 = String.format("%s/%s", Arrays.copyOf(new Object[]{str, r()}, 2));
        kotlin.jvm.internal.m.e(str2, "java.lang.String.format(format, *args)");
        return str2;
    }

    private final boolean y() {
        if (this.f9625h == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("^/?");
        a0 a0Var = a0.a;
        sb.append(a0.d());
        sb.append("/?.*");
        return this.r || Pattern.matches(sb.toString(), this.f9625h) || Pattern.matches("^/?app/?.*", this.f9625h);
    }

    private final boolean z() {
        a0 a0Var = a0.a;
        if (kotlin.jvm.internal.m.a(a0.o(), "instagram.com")) {
            return !y();
        }
        return true;
    }

    public final void D(final b bVar) {
        a0 a0Var = a0.a;
        if (a0.y(g0.GRAPH_API_DEBUG_INFO) || a0.y(g0.GRAPH_API_DEBUG_WARNING)) {
            this.p = new b() { // from class: com.facebook.q
                @Override // com.facebook.GraphRequest.b
                public final void b(d0 d0Var) {
                    GraphRequest.a(bVar, d0Var);
                }
            };
        } else {
            this.p = bVar;
        }
    }

    public final void E(boolean z) {
        this.r = z;
    }

    public final void F(JSONObject jSONObject) {
        this.f9626i = jSONObject;
    }

    public final void G(e0 e0Var) {
        if (this.s != null && e0Var != e0.GET) {
            throw new FacebookException("Can't change HTTP method on request with overridden URL.");
        }
        if (e0Var == null) {
            e0Var = e0.GET;
        }
        this.q = e0Var;
    }

    public final void H(Bundle bundle) {
        kotlin.jvm.internal.m.f(bundle, "<set-?>");
        this.m = bundle;
    }

    public final void I(Object obj) {
        this.n = obj;
    }

    public final d0 j() {
        return a.f(this);
    }

    public final b0 k() {
        return a.l(this);
    }

    public final AccessToken l() {
        return this.f9624g;
    }

    public final b n() {
        return this.p;
    }

    public final JSONObject p() {
        return this.f9626i;
    }

    public final String q() {
        return this.f9625h;
    }

    public final e0 s() {
        return this.q;
    }

    public final Bundle t() {
        return this.m;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{Request: ");
        sb.append(" accessToken: ");
        Object obj = this.f9624g;
        if (obj == null) {
            obj = "null";
        }
        sb.append(obj);
        sb.append(", graphPath: ");
        sb.append(this.f9625h);
        sb.append(", graphObject: ");
        sb.append(this.f9626i);
        sb.append(", httpMethod: ");
        sb.append(this.q);
        sb.append(", parameters: ");
        sb.append(this.m);
        sb.append("}");
        String string = sb.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder()\n        .append(\"{Request: \")\n        .append(\" accessToken: \")\n        .append(if (accessToken == null) \"null\" else accessToken)\n        .append(\", graphPath: \")\n        .append(graphPath)\n        .append(\", graphObject: \")\n        .append(graphObject)\n        .append(\", httpMethod: \")\n        .append(httpMethod)\n        .append(\", parameters: \")\n        .append(parameters)\n        .append(\"}\")\n        .toString()");
        return string;
    }

    public final String u() {
        if (this.s != null) {
            throw new FacebookException("Can't override URL for a batch request");
        }
        com.facebook.internal.n0 n0Var = com.facebook.internal.n0.a;
        String strX = x(com.facebook.internal.n0.h());
        h();
        Uri uri = Uri.parse(i(strX, true));
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String str = String.format("%s?%s", Arrays.copyOf(new Object[]{uri.getPath(), uri.getQuery()}, 2));
        kotlin.jvm.internal.m.e(str, "java.lang.String.format(format, *args)");
        return str;
    }

    public final Object v() {
        return this.n;
    }

    public final String w() {
        String strI;
        String str = this.s;
        if (str != null) {
            return String.valueOf(str);
        }
        String str2 = this.f9625h;
        if (this.q == e0.POST && str2 != null && kotlin.text.u.p(str2, "/videos", false, 2, null)) {
            com.facebook.internal.n0 n0Var = com.facebook.internal.n0.a;
            strI = com.facebook.internal.n0.j();
        } else {
            com.facebook.internal.n0 n0Var2 = com.facebook.internal.n0.a;
            a0 a0Var = a0.a;
            strI = com.facebook.internal.n0.i(a0.o());
        }
        String strX = x(strI);
        h();
        return i(strX, false);
    }

    public GraphRequest(AccessToken accessToken, String str, Bundle bundle, e0 e0Var, b bVar, String str2) {
        this.l = true;
        this.f9624g = accessToken;
        this.f9625h = str;
        this.o = str2;
        D(bVar);
        G(e0Var);
        if (bundle != null) {
            this.m = new Bundle(bundle);
        } else {
            this.m = new Bundle();
        }
        if (this.o == null) {
            a0 a0Var = a0.a;
            this.o = a0.n();
        }
    }

    /* JADX INFO: compiled from: GraphRequest.kt */
    public static final class ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f9630g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final RESOURCE f9631h;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f9629f = new b(null);
        public static final Parcelable.Creator<ParcelableResourceWithMimeType<?>> CREATOR = new a();

        /* JADX INFO: compiled from: GraphRequest.kt */
        public static final class a implements Parcelable.Creator<ParcelableResourceWithMimeType<?>> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ParcelableResourceWithMimeType<?> createFromParcel(Parcel parcel) {
                kotlin.jvm.internal.m.f(parcel, "source");
                return new ParcelableResourceWithMimeType<>(parcel, (kotlin.jvm.internal.g) null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ParcelableResourceWithMimeType<?>[] newArray(int i2) {
                return new ParcelableResourceWithMimeType[i2];
            }
        }

        /* JADX INFO: compiled from: GraphRequest.kt */
        public static final class b {
            private b() {
            }

            public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
                this();
            }
        }

        public /* synthetic */ ParcelableResourceWithMimeType(Parcel parcel, kotlin.jvm.internal.g gVar) {
            this(parcel);
        }

        public ParcelableResourceWithMimeType(RESOURCE resource, String str) {
            this.f9630g = str;
            this.f9631h = resource;
        }

        public final String a() {
            return this.f9630g;
        }

        public final RESOURCE b() {
            return this.f9631h;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            kotlin.jvm.internal.m.f(parcel, "out");
            parcel.writeString(this.f9630g);
            parcel.writeParcelable(this.f9631h, i2);
        }

        private ParcelableResourceWithMimeType(Parcel parcel) {
            this.f9630g = parcel.readString();
            a0 a0Var = a0.a;
            this.f9631h = (RESOURCE) parcel.readParcelable(a0.c().getClassLoader());
        }
    }
}
