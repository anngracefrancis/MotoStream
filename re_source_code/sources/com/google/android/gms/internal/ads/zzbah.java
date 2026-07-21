package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbah implements zzazw {
    private final String a;

    public zzbah() {
        this(null);
    }

    @Override // com.google.android.gms.internal.ads.zzazw
    public final void a(String str) {
        try {
            String strValueOf = String.valueOf(str);
            zzbad.e(strValueOf.length() != 0 ? "Pinging URL: ".concat(strValueOf) : new String("Pinging URL: "));
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                zzyt.a();
                zzazt.i(true, httpURLConnection, this.a);
                zzazx zzazxVar = new zzazx();
                zzazxVar.i(httpURLConnection, null);
                int responseCode = httpURLConnection.getResponseCode();
                zzazxVar.h(httpURLConnection, responseCode);
                if (responseCode < 200 || responseCode >= 300) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 65);
                    sb.append("Received non-success response code ");
                    sb.append(responseCode);
                    sb.append(" from pinging URL: ");
                    sb.append(str);
                    zzbad.i(sb.toString());
                }
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (IOException e2) {
            String message = e2.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message).length());
            sb2.append("Error while pinging URL: ");
            sb2.append(str);
            sb2.append(". ");
            sb2.append(message);
            zzbad.i(sb2.toString());
        } catch (IndexOutOfBoundsException e3) {
            String message2 = e3.getMessage();
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(message2).length());
            sb3.append("Error while parsing ping URL: ");
            sb3.append(str);
            sb3.append(". ");
            sb3.append(message2);
            zzbad.i(sb3.toString());
        } catch (RuntimeException e4) {
            String message3 = e4.getMessage();
            StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message3).length());
            sb4.append("Error while pinging URL: ");
            sb4.append(str);
            sb4.append(". ");
            sb4.append(message3);
            zzbad.i(sb4.toString());
        }
    }

    public zzbah(String str) {
        this.a = str;
    }
}
