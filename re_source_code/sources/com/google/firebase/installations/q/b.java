package com.google.firebase.installations.q;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.j;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: IidStore.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static final String[] a = {"*", "FCM", "GCM", HttpUrl.FRAGMENT_ENCODE_SET};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f19711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19712c;

    public b(j jVar) {
        this.f19711b = jVar.i().getSharedPreferences("com.google.android.gms.appid", 0);
        this.f19712c = b(jVar);
    }

    private String a(String str, String str2) {
        return "|T|" + str + "|" + str2;
    }

    private static String b(j jVar) {
        String strD = jVar.l().d();
        if (strD != null) {
            return strD;
        }
        String strC = jVar.l().c();
        if (!strC.startsWith("1:") && !strC.startsWith("2:")) {
            return strC;
        }
        String[] strArrSplit = strC.split(":");
        if (strArrSplit.length != 4) {
            return null;
        }
        String str = strArrSplit[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    private static String c(PublicKey publicKey) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(publicKey.getEncoded());
            bArrDigest[0] = (byte) (((bArrDigest[0] & 15) + 112) & 255);
            return Base64.encodeToString(bArrDigest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("ContentValues", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    private String d(String str) {
        try {
            return new JSONObject(str).getString("token");
        } catch (JSONException unused) {
            return null;
        }
    }

    private PublicKey e(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 8)));
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e2) {
            Log.w("ContentValues", "Invalid key stored " + e2);
            return null;
        }
    }

    private String g() {
        String string;
        synchronized (this.f19711b) {
            string = this.f19711b.getString("|S|id", null);
        }
        return string;
    }

    private String h() {
        synchronized (this.f19711b) {
            String string = this.f19711b.getString("|S||P|", null);
            if (string == null) {
                return null;
            }
            PublicKey publicKeyE = e(string);
            if (publicKeyE == null) {
                return null;
            }
            return c(publicKeyE);
        }
    }

    public String f() {
        synchronized (this.f19711b) {
            String strG = g();
            if (strG != null) {
                return strG;
            }
            return h();
        }
    }

    public String i() {
        synchronized (this.f19711b) {
            for (String str : a) {
                String string = this.f19711b.getString(a(this.f19712c, str), null);
                if (string != null && !string.isEmpty()) {
                    if (string.startsWith("{")) {
                        string = d(string);
                    }
                    return string;
                }
            }
            return null;
        }
    }
}
