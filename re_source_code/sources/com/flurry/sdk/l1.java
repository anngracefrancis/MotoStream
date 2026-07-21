package com.flurry.sdk;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.util.Base64;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class l1 {
    public static final Set<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static X509TrustManagerExtensions f10894b;

    static {
        HashSet hashSet = new HashSet(13);
        a = hashSet;
        hashSet.add("WoiWRyIOVNa9ihaBciRSC7XHjliYS9VwUGOIud4PB18=");
        hashSet.add("SVqWumuteCQHvVIaALrOZXuzVVVeS7f4FGxxu6V+es4=");
        hashSet.add("cAajgxHlj7GTSEIzIYIQxmEloOSoJq7VOaxWHfv72QM=");
        hashSet.add("I/Lt/z7ekCWanjD0Cvj5EqXls2lOaThEA0H2Bg4BT/o=");
        hashSet.add("Wd8xe/qfTwq3ylFNd3IpaqLHZbh2ZNCLluVzmeNkcpw=");
        hashSet.add("JbQbUG5JMJUoI6brnx0x3vZF6jilxsapbXGVfjhN8Fg=");
        hashSet.add("r/mIkG3eEpVdm+u/ko/cwxzOMo1bk4TyHIlByibiA5E=");
        hashSet.add("UZJDjsNp1+4M5x9cbbdflB779y5YRBcV6Z6rBMLIrO4=");
        hashSet.add("lnsM2T/O9/J84sJFdnrpsFp3awZJ+ZZbYpCWhGloaHI=");
        hashSet.add("i7WTqTvh0OioIruIfFR4kMPnBqrS2rdiVPl/s2uC/CY=");
        hashSet.add("uUwZgwDOxcBXrQcntwu+kYFpkiVkOaezL0WYEZ3anJc=");
        hashSet.add("dolnbtzEBnELx/9lOEQ22e6OZO/QNb6VSSX2XHA3E7A=");
        hashSet.add("2fRAUXyxl4A1/XHrKNBmc8bTkzA7y4FB/GLJuNAzCqY=");
        f10894b = null;
        if (Build.VERSION.SDK_INT >= 17) {
            f10894b = new X509TrustManagerExtensions(a());
        }
    }

    private static X509TrustManager a() {
        TrustManagerFactory trustManagerFactory;
        try {
            trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            try {
                trustManagerFactory.init((KeyStore) null);
            } catch (KeyStoreException e2) {
                e = e2;
                d1.f("SslPinningValidator", "Error in getting trust manager: ", e);
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                d1.f("SslPinningValidator", "Error in getting trust manager: ", e);
            }
        } catch (KeyStoreException e4) {
            e = e4;
            trustManagerFactory = null;
        } catch (NoSuchAlgorithmException e5) {
            e = e5;
            trustManagerFactory = null;
        }
        if (trustManagerFactory == null) {
            return null;
        }
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        for (TrustManager trustManager : trustManagers) {
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        return null;
    }

    public static void b(HttpsURLConnection httpsURLConnection) throws SSLException {
        if (Build.VERSION.SDK_INT < 17 || f10894b == null) {
            return;
        }
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        try {
            Certificate[] serverCertificates = httpsURLConnection.getServerCertificates();
            List<X509Certificate> listCheckServerTrusted = f10894b.checkServerTrusted((X509Certificate[]) Arrays.copyOf(serverCertificates, serverCertificates.length, X509Certificate[].class), "RSA", httpsURLConnection.getURL().getHost());
            if (listCheckServerTrusted == null) {
                throw new SSLPeerUnverifiedException("Empty trusted chain Certificate.");
            }
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            for (X509Certificate x509Certificate : listCheckServerTrusted) {
                byte[] encoded = x509Certificate.getPublicKey().getEncoded();
                messageDigest.update(encoded, 0, encoded.length);
                String strEncodeToString = Base64.encodeToString(messageDigest.digest(), 2);
                if (a.contains(strEncodeToString)) {
                    d1.e("SslPinningValidator", "Found matched pin: ".concat(String.valueOf(strEncodeToString)));
                    return;
                }
                str = str + "    sha256/" + strEncodeToString + ": " + x509Certificate.getSubjectDN().toString() + "\n";
            }
            throw new SSLPeerUnverifiedException("Certificate pinning failure!\n  Peer certificate chain:\n".concat(String.valueOf(str)));
        } catch (NoSuchAlgorithmException e2) {
            d1.f("SslPinningValidator", "Error in validating pinning: ", e2);
        } catch (CertificateException e3) {
            d1.f("SslPinningValidator", "Error in getting certificate: ", e3);
        }
    }
}
