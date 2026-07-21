package io.sentry;

import cm.aptoide.pt.dataprovider.BuildConfig;
import java.net.URI;

/* JADX INFO: compiled from: Dsn.java */
/* JADX INFO: loaded from: classes2.dex */
final class f1 {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f22406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f22407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f22408d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final URI f22409e;

    f1(String str) throws IllegalArgumentException {
        try {
            io.sentry.util.q.c(str, "The DSN is required.");
            URI uriNormalize = new URI(str).normalize();
            String scheme = uriNormalize.getScheme();
            if (!"http".equalsIgnoreCase(scheme) && !BuildConfig.APTOIDE_WEB_SERVICES_SCHEME.equalsIgnoreCase(scheme)) {
                throw new IllegalArgumentException("Invalid DSN scheme: " + scheme);
            }
            String userInfo = uriNormalize.getUserInfo();
            if (userInfo == null || userInfo.isEmpty()) {
                throw new IllegalArgumentException("Invalid DSN: No public key provided.");
            }
            String[] strArrSplit = userInfo.split(":", -1);
            String str2 = strArrSplit[0];
            this.f22408d = str2;
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("Invalid DSN: No public key provided.");
            }
            this.f22407c = strArrSplit.length > 1 ? strArrSplit[1] : null;
            String path = uriNormalize.getPath();
            path = path.endsWith("/") ? path.substring(0, path.length() - 1) : path;
            int iLastIndexOf = path.lastIndexOf("/") + 1;
            String strSubstring = path.substring(0, iLastIndexOf);
            if (!strSubstring.endsWith("/")) {
                strSubstring = strSubstring + "/";
            }
            this.f22406b = strSubstring;
            String strSubstring2 = path.substring(iLastIndexOf);
            this.a = strSubstring2;
            if (strSubstring2.isEmpty()) {
                throw new IllegalArgumentException("Invalid DSN: A Project Id is required.");
            }
            this.f22409e = new URI(scheme, null, uriNormalize.getHost(), uriNormalize.getPort(), strSubstring + "api/" + strSubstring2, null, null);
        } catch (Throwable th) {
            throw new IllegalArgumentException(th);
        }
    }

    public String a() {
        return this.f22408d;
    }

    public String b() {
        return this.f22407c;
    }

    URI c() {
        return this.f22409e;
    }
}
