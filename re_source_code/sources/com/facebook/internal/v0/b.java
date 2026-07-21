package com.facebook.internal.v0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: CertificateUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    public static final String a(Context context) {
        m.f(context, "ctx");
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            StringBuilder sb = new StringBuilder();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            m.e(signatureArr, "signatures");
            int length = signatureArr.length;
            int i2 = 0;
            while (i2 < length) {
                Signature signature = signatureArr[i2];
                i2++;
                messageDigest.update(signature.toByteArray());
                sb.append(Base64.encodeToString(messageDigest.digest(), 0));
                sb.append(":");
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            String string = sb.toString();
            m.e(string, "sb.toString()");
            return string;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }
}
