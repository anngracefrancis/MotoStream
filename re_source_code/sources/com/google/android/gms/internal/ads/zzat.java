package com.google.android.gms.internal.ads;

import cm.aptoide.pt.dataprovider.BuildConfig;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class zzat extends zzaj {
    private final zzav a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SSLSocketFactory f14148b;

    public zzat() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream c(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private static List<zzl> d(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    arrayList.add(new zzl(entry.getKey(), it.next()));
                }
            }
        }
        return arrayList;
    }

    private static void e(HttpURLConnection httpURLConnection, zzr<?> zzrVar) throws zza, IOException {
        byte[] bArrO = zzrVar.O();
        if (bArrO != null) {
            httpURLConnection.setDoOutput(true);
            if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
                httpURLConnection.setRequestProperty("Content-Type", "UTF-8".length() != 0 ? "application/x-www-form-urlencoded; charset=".concat("UTF-8") : new String("application/x-www-form-urlencoded; charset="));
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(bArrO);
            dataOutputStream.close();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:31:0x00d0 A[Catch: all -> 0x0125, TryCatch #1 {all -> 0x0125, blocks: (B:14:0x0068, B:15:0x0070, B:17:0x0076, B:18:0x0086, B:19:0x008a, B:20:0x008d, B:53:0x011f, B:54:0x0124, B:21:0x0091, B:22:0x009a, B:23:0x00a0, B:24:0x00a6, B:25:0x00ac, B:26:0x00b2, B:27:0x00bb, B:28:0x00c4, B:29:0x00c9, B:31:0x00d0, B:44:0x00ec, B:51:0x0117, B:52:0x011e), top: B:63:0x0068 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ec A[Catch: all -> 0x0125, TRY_LEAVE, TryCatch #1 {all -> 0x0125, blocks: (B:14:0x0068, B:15:0x0070, B:17:0x0076, B:18:0x0086, B:19:0x008a, B:20:0x008d, B:53:0x011f, B:54:0x0124, B:21:0x0091, B:22:0x009a, B:23:0x00a0, B:24:0x00a6, B:25:0x00ac, B:26:0x00b2, B:27:0x00bb, B:28:0x00c4, B:29:0x00c9, B:31:0x00d0, B:44:0x00ec, B:51:0x0117, B:52:0x011e), top: B:63:0x0068 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0117 A[Catch: all -> 0x0125, TRY_ENTER, TryCatch #1 {all -> 0x0125, blocks: (B:14:0x0068, B:15:0x0070, B:17:0x0076, B:18:0x0086, B:19:0x008a, B:20:0x008d, B:53:0x011f, B:54:0x0124, B:21:0x0091, B:22:0x009a, B:23:0x00a0, B:24:0x00a6, B:25:0x00ac, B:26:0x00b2, B:27:0x00bb, B:28:0x00c4, B:29:0x00c9, B:31:0x00d0, B:44:0x00ec, B:51:0x0117, B:52:0x011e), top: B:63:0x0068 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzaj
    public final zzar b(zzr<?> zzrVar, Map<String, String> map) throws Throwable {
        int responseCode;
        boolean z;
        String strQ = zzrVar.q();
        HashMap map2 = new HashMap();
        map2.putAll(map);
        map2.putAll(zzrVar.g());
        zzav zzavVar = this.a;
        if (zzavVar != null) {
            String strA = zzavVar.a(strQ);
            if (strA == null) {
                String strValueOf = String.valueOf(strQ);
                throw new IOException(strValueOf.length() != 0 ? "URL blocked by rewriter: ".concat(strValueOf) : new String("URL blocked by rewriter: "));
            }
            strQ = strA;
        }
        URL url = new URL(strQ);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        int iQ = zzrVar.Q();
        httpURLConnection.setConnectTimeout(iQ);
        httpURLConnection.setReadTimeout(iQ);
        boolean z2 = false;
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        BuildConfig.APTOIDE_WEB_SERVICES_SCHEME.equals(url.getProtocol());
        try {
            for (String str : map2.keySet()) {
                httpURLConnection.setRequestProperty(str, (String) map2.get(str));
            }
            switch (zzrVar.k()) {
                case -1:
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == -1) {
                        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
                    }
                    if (zzrVar.k() != 4 || ((100 <= responseCode && responseCode < 200) || responseCode == 204 || responseCode == 304)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        zzar zzarVar = new zzar(responseCode, d(httpURLConnection.getHeaderFields()));
                        httpURLConnection.disconnect();
                        return zzarVar;
                    }
                    try {
                        return new zzar(responseCode, d(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new v3(httpURLConnection));
                    } catch (Throwable th) {
                        th = th;
                        z2 = true;
                        if (!z2) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                case 0:
                    httpURLConnection.setRequestMethod("GET");
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == -1) {
                        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
                    }
                    if (zzrVar.k() != 4) {
                        z = false;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        return new zzar(responseCode, d(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new v3(httpURLConnection));
                    }
                    zzar zzarVar2 = new zzar(responseCode, d(httpURLConnection.getHeaderFields()));
                    httpURLConnection.disconnect();
                    return zzarVar2;
                case 1:
                    httpURLConnection.setRequestMethod("POST");
                    e(httpURLConnection, zzrVar);
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == -1) {
                        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
                    }
                    if (zzrVar.k() != 4) {
                        z = false;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        return new zzar(responseCode, d(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new v3(httpURLConnection));
                    }
                    zzar zzarVar3 = new zzar(responseCode, d(httpURLConnection.getHeaderFields()));
                    httpURLConnection.disconnect();
                    return zzarVar3;
                case 2:
                    httpURLConnection.setRequestMethod("PUT");
                    e(httpURLConnection, zzrVar);
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == -1) {
                        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
                    }
                    if (zzrVar.k() != 4) {
                        z = false;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        return new zzar(responseCode, d(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new v3(httpURLConnection));
                    }
                    zzar zzarVar4 = new zzar(responseCode, d(httpURLConnection.getHeaderFields()));
                    httpURLConnection.disconnect();
                    return zzarVar4;
                case 3:
                    httpURLConnection.setRequestMethod("DELETE");
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == -1) {
                        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
                    }
                    if (zzrVar.k() != 4) {
                        z = false;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        return new zzar(responseCode, d(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new v3(httpURLConnection));
                    }
                    zzar zzarVar5 = new zzar(responseCode, d(httpURLConnection.getHeaderFields()));
                    httpURLConnection.disconnect();
                    return zzarVar5;
                case 4:
                    httpURLConnection.setRequestMethod("HEAD");
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == -1) {
                        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
                    }
                    if (zzrVar.k() != 4) {
                        z = false;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        return new zzar(responseCode, d(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new v3(httpURLConnection));
                    }
                    zzar zzarVar6 = new zzar(responseCode, d(httpURLConnection.getHeaderFields()));
                    httpURLConnection.disconnect();
                    return zzarVar6;
                case 5:
                    httpURLConnection.setRequestMethod("OPTIONS");
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == -1) {
                        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
                    }
                    if (zzrVar.k() != 4) {
                        z = false;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        return new zzar(responseCode, d(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new v3(httpURLConnection));
                    }
                    zzar zzarVar7 = new zzar(responseCode, d(httpURLConnection.getHeaderFields()));
                    httpURLConnection.disconnect();
                    return zzarVar7;
                case 6:
                    httpURLConnection.setRequestMethod("TRACE");
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == -1) {
                        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
                    }
                    if (zzrVar.k() != 4) {
                        z = false;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        return new zzar(responseCode, d(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new v3(httpURLConnection));
                    }
                    zzar zzarVar8 = new zzar(responseCode, d(httpURLConnection.getHeaderFields()));
                    httpURLConnection.disconnect();
                    return zzarVar8;
                case 7:
                    httpURLConnection.setRequestMethod("PATCH");
                    e(httpURLConnection, zzrVar);
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == -1) {
                        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
                    }
                    if (zzrVar.k() != 4) {
                        z = false;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        return new zzar(responseCode, d(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new v3(httpURLConnection));
                    }
                    zzar zzarVar9 = new zzar(responseCode, d(httpURLConnection.getHeaderFields()));
                    httpURLConnection.disconnect();
                    return zzarVar9;
                default:
                    throw new IllegalStateException("Unknown method type.");
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private zzat(zzav zzavVar) {
        this(null, null);
    }

    private zzat(zzav zzavVar, SSLSocketFactory sSLSocketFactory) {
        this.a = null;
        this.f14148b = null;
    }
}
