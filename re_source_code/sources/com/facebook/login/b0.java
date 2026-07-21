package com.facebook.login;

import android.os.Bundle;
import android.util.Base64;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.e0;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import kotlin.random.Random;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: PKCEUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b0 {
    public static final b0 a = new b0();

    private b0() {
    }

    public static final GraphRequest a(String str, String str2, String str3) {
        kotlin.jvm.internal.m.f(str, "authorizationCode");
        kotlin.jvm.internal.m.f(str2, "redirectUri");
        kotlin.jvm.internal.m.f(str3, "codeVerifier");
        Bundle bundle = new Bundle();
        bundle.putString("code", str);
        com.facebook.a0 a0Var = com.facebook.a0.a;
        bundle.putString("client_id", com.facebook.a0.d());
        bundle.putString("redirect_uri", str2);
        bundle.putString("code_verifier", str3);
        GraphRequest graphRequestX = GraphRequest.a.x(null, "oauth/access_token", null);
        graphRequestX.G(e0.GET);
        graphRequestX.H(bundle);
        return graphRequestX;
    }

    public static final String b(String str, p pVar) throws FacebookException {
        kotlin.jvm.internal.m.f(str, "codeVerifier");
        kotlin.jvm.internal.m.f(pVar, "codeChallengeMethod");
        if (!d(str)) {
            throw new FacebookException("Invalid Code Verifier.");
        }
        if (pVar == p.PLAIN) {
            return str;
        }
        try {
            byte[] bytes = str.getBytes(Charsets.f25058f);
            kotlin.jvm.internal.m.e(bytes, "(this as java.lang.String).getBytes(charset)");
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bytes, 0, bytes.length);
            String strEncodeToString = Base64.encodeToString(messageDigest.digest(), 11);
            kotlin.jvm.internal.m.e(strEncodeToString, "{\n      // try to generate challenge with S256\n      val bytes: ByteArray = codeVerifier.toByteArray(Charsets.US_ASCII)\n      val messageDigest = MessageDigest.getInstance(\"SHA-256\")\n      messageDigest.update(bytes, 0, bytes.size)\n      val digest = messageDigest.digest()\n\n      Base64.encodeToString(digest, Base64.URL_SAFE or Base64.NO_PADDING or Base64.NO_WRAP)\n    }");
            return strEncodeToString;
        } catch (Exception e2) {
            throw new FacebookException(e2);
        }
    }

    public static final String c() {
        int i2 = kotlin.ranges.l.i(new IntRange(43, 128), Random.f22952f);
        List listP0 = kotlin.collections.c0.p0(kotlin.collections.c0.p0(kotlin.collections.c0.p0(kotlin.collections.c0.p0(kotlin.collections.c0.o0(kotlin.collections.c0.m0(new CharRange('a', 'z'), new CharRange('A', 'Z')), new CharRange('0', '9')), '-'), '.'), '_'), '~');
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(Character.valueOf(((Character) kotlin.collections.s.q0(listP0, Random.f22952f)).charValue()));
        }
        return kotlin.collections.c0.e0(arrayList, HttpUrl.FRAGMENT_ENCODE_SET, null, null, 0, null, null, 62, null);
    }

    public static final boolean d(String str) {
        if ((str == null || str.length() == 0) || str.length() < 43 || str.length() > 128) {
            return false;
        }
        return new Regex("^[-._~A-Za-z0-9]+$").b(str);
    }
}
