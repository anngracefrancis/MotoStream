package okhttp3.internal.http;

import j.f;
import j.i;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.q0;
import kotlin.jvm.internal.m;
import kotlin.text.u;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

/* JADX INFO: compiled from: HttpHeaders.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\u000b\u001a\u00020\n*\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\u000e\u001a\u00020\r*\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\u0012\u001a\u00020\r*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0015\u001a!\u0010\u001b\u001a\u00020\n*\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0011\u0010\u001e\u001a\u00020\r*\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0017\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001dH\u0007¢\u0006\u0004\b!\u0010\u001f\"\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$\"\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010$¨\u0006&"}, d2 = {"Lokhttp3/Headers;", HttpUrl.FRAGMENT_ENCODE_SET, "headerName", HttpUrl.FRAGMENT_ENCODE_SET, "Lokhttp3/Challenge;", "parseChallenges", "(Lokhttp3/Headers;Ljava/lang/String;)Ljava/util/List;", "Lj/f;", HttpUrl.FRAGMENT_ENCODE_SET, "result", "Lkotlin/u;", "readChallengeHeader", "(Lj/f;Ljava/util/List;)V", HttpUrl.FRAGMENT_ENCODE_SET, "skipCommasAndWhitespace", "(Lj/f;)Z", HttpUrl.FRAGMENT_ENCODE_SET, "prefix", "startsWith", "(Lj/f;B)Z", "readQuotedString", "(Lj/f;)Ljava/lang/String;", "readToken", "Lokhttp3/CookieJar;", "Lokhttp3/HttpUrl;", "url", "headers", "receiveHeaders", "(Lokhttp3/CookieJar;Lokhttp3/HttpUrl;Lokhttp3/Headers;)V", "Lokhttp3/Response;", "promisesBody", "(Lokhttp3/Response;)Z", "response", "hasBody", "Lj/i;", "QUOTED_STRING_DELIMITERS", "Lj/i;", "TOKEN_DELIMITERS", "okhttp"}, k = 2, mv = {1, 4, 0})
public final class HttpHeaders {
    private static final i QUOTED_STRING_DELIMITERS;
    private static final i TOKEN_DELIMITERS;

    static {
        i.a aVar = i.f22842g;
        QUOTED_STRING_DELIMITERS = aVar.d("\"\\");
        TOKEN_DELIMITERS = aVar.d("\t ,=");
    }

    public static final boolean hasBody(Response response) {
        m.f(response, "response");
        return promisesBody(response);
    }

    public static final List<Challenge> parseChallenges(Headers headers, String str) {
        m.f(headers, "$this$parseChallenges");
        m.f(str, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (u.q(str, headers.name(i2), true)) {
                try {
                    readChallengeHeader(new f().r0(headers.value(i2)), arrayList);
                } catch (EOFException e2) {
                    Platform.INSTANCE.get().log("Unable to parse challenge", 5, e2);
                }
            }
        }
        return arrayList;
    }

    public static final boolean promisesBody(Response response) {
        m.f(response, "$this$promisesBody");
        if (m.a(response.request().method(), "HEAD")) {
            return false;
        }
        int iCode = response.code();
        return (((iCode >= 100 && iCode < 200) || iCode == 204 || iCode == 304) && Util.headersContentLength(response) == -1 && !u.q("chunked", Response.header$default(response, "Transfer-Encoding", null, 2, null), true)) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0090  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:59:0x0085 A[EDGE_INSN: B:59:0x0085->B:28:0x0085 BREAK  A[LOOP:2: B:22:0x0072->B:48:0x00c5], SYNTHETIC] */
    private static final void readChallengeHeader(f fVar, List<Challenge> list) throws EOFException {
        String token;
        while (true) {
            String token2 = null;
            while (true) {
                if (token2 == null) {
                    skipCommasAndWhitespace(fVar);
                    token2 = readToken(fVar);
                    if (token2 == null) {
                        return;
                    }
                }
                boolean zSkipCommasAndWhitespace = skipCommasAndWhitespace(fVar);
                String token3 = readToken(fVar);
                if (token3 == null) {
                    if (fVar.R()) {
                        list.add(new Challenge(token2, (Map<String, String>) q0.i()));
                        return;
                    }
                    return;
                }
                byte b2 = (byte) 61;
                int iSkipAll = Util.skipAll(fVar, b2);
                boolean zSkipCommasAndWhitespace2 = skipCommasAndWhitespace(fVar);
                if (zSkipCommasAndWhitespace || !(zSkipCommasAndWhitespace2 || fVar.R())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int iSkipAll2 = iSkipAll + Util.skipAll(fVar, b2);
                    while (true) {
                        if (token3 != null) {
                            if (iSkipAll2 == 0) {
                                break;
                                break;
                            }
                            if (iSkipAll2 <= 1) {
                                return;
                            }
                            if (startsWith(fVar, (byte) 34)) {
                                token = readQuotedString(fVar);
                            } else {
                                token = readToken(fVar);
                            }
                            if (token != null) {
                                return;
                            } else {
                                return;
                            }
                        }
                        token3 = readToken(fVar);
                        if (skipCommasAndWhitespace(fVar)) {
                            break;
                        }
                        iSkipAll2 = Util.skipAll(fVar, b2);
                        if (iSkipAll2 == 0) {
                            break;
                        }
                        if (iSkipAll2 <= 1 || skipCommasAndWhitespace(fVar)) {
                            return;
                        }
                        if (startsWith(fVar, (byte) 34)) {
                            token = readQuotedString(fVar);
                        } else {
                            token = readToken(fVar);
                        }
                        if (token != null || ((String) linkedHashMap.put(token3, token)) != null) {
                            return;
                        }
                        if (!skipCommasAndWhitespace(fVar) && !fVar.R()) {
                            return;
                        } else {
                            token3 = null;
                        }
                    }
                    list.add(new Challenge(token2, linkedHashMap));
                    token2 = token3;
                } else {
                    Map mapSingletonMap = Collections.singletonMap(null, token3 + u.w("=", iSkipAll));
                    m.e(mapSingletonMap, "Collections.singletonMap…ek + \"=\".repeat(eqCount))");
                    list.add(new Challenge(token2, (Map<String, String>) mapSingletonMap));
                }
            }
        }
    }

    private static final String readQuotedString(f fVar) throws EOFException {
        byte b2 = (byte) 34;
        if (!(fVar.readByte() == b2)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        f fVar2 = new f();
        while (true) {
            long jB0 = fVar.b0(QUOTED_STRING_DELIMITERS);
            if (jB0 == -1) {
                return null;
            }
            if (fVar.m(jB0) == b2) {
                fVar2.write(fVar, jB0);
                fVar.readByte();
                return fVar2.T();
            }
            if (fVar.size() == jB0 + 1) {
                return null;
            }
            fVar2.write(fVar, jB0);
            fVar.readByte();
            fVar2.write(fVar, 1L);
        }
    }

    private static final String readToken(f fVar) {
        long jB0 = fVar.b0(TOKEN_DELIMITERS);
        if (jB0 == -1) {
            jB0 = fVar.size();
        }
        if (jB0 != 0) {
            return fVar.Z(jB0);
        }
        return null;
    }

    public static final void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        m.f(cookieJar, "$this$receiveHeaders");
        m.f(httpUrl, "url");
        m.f(headers, "headers");
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> all = Cookie.INSTANCE.parseAll(httpUrl, headers);
        if (all.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, all);
    }

    private static final boolean skipCommasAndWhitespace(f fVar) throws EOFException {
        boolean z = false;
        while (!fVar.R()) {
            byte bM = fVar.m(0L);
            if (bM == 9 || bM == 32) {
                fVar.readByte();
            } else {
                if (bM != 44) {
                    break;
                }
                fVar.readByte();
                z = true;
            }
        }
        return z;
    }

    private static final boolean startsWith(f fVar, byte b2) {
        return !fVar.R() && fVar.m(0L) == b2;
    }
}
