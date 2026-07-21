package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public final class zzd implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Logger f11540f = new Logger("RevokeAccessOperation", new String[0]);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f11541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final StatusPendingResult f11542h;

    private zzd(String str) {
        Preconditions.g(str);
        this.f11541g = str;
        this.f11542h = new StatusPendingResult(null);
    }

    public static PendingResult<Status> a(String str) {
        if (str == null) {
            return PendingResults.a(new Status(4), null);
        }
        zzd zzdVar = new zzd(str);
        new Thread(zzdVar).start();
        return zzdVar.f11542h;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Status status = Status.f11690i;
        try {
            String strValueOf = String.valueOf(this.f11541g);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strValueOf.length() != 0 ? "https://accounts.google.com/o/oauth2/revoke?token=".concat(strValueOf) : new String("https://accounts.google.com/o/oauth2/revoke?token=")).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.f11688g;
            } else {
                f11540f.b("Unable to revoke access!", new Object[0]);
            }
            Logger logger = f11540f;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Response Code: ");
            sb.append(responseCode);
            logger.a(sb.toString(), new Object[0]);
        } catch (IOException e2) {
            Logger logger2 = f11540f;
            String strValueOf2 = String.valueOf(e2.toString());
            logger2.b(strValueOf2.length() != 0 ? "IOException when revoking access: ".concat(strValueOf2) : new String("IOException when revoking access: "), new Object[0]);
        } catch (Exception e3) {
            Logger logger3 = f11540f;
            String strValueOf3 = String.valueOf(e3.toString());
            logger3.b(strValueOf3.length() != 0 ? "Exception when revoking access: ".concat(strValueOf3) : new String("Exception when revoking access: "), new Object[0]);
        }
        this.f11542h.k(status);
    }
}
