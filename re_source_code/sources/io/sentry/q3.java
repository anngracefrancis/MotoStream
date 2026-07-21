package io.sentry;

import java.net.URI;
import java.util.HashMap;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: RequestDetailsResolver.java */
/* JADX INFO: loaded from: classes2.dex */
final class q3 {
    private final x4 a;

    public q3(x4 x4Var) {
        this.a = (x4) io.sentry.util.q.c(x4Var, "options is required");
    }

    p3 a() {
        String str;
        f1 f1Var = new f1(this.a.getDsn());
        URI uriC = f1Var.c();
        String string = uriC.resolve(uriC.getPath() + "/envelope/").toString();
        String strA = f1Var.a();
        String strB = f1Var.b();
        StringBuilder sb = new StringBuilder();
        sb.append("Sentry sentry_version=7,sentry_client=");
        sb.append(this.a.getSentryClientName());
        sb.append(",sentry_key=");
        sb.append(strA);
        if (strB == null || strB.length() <= 0) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        } else {
            str = ",sentry_secret=" + strB;
        }
        sb.append(str);
        String string2 = sb.toString();
        String sentryClientName = this.a.getSentryClientName();
        HashMap map = new HashMap();
        map.put("User-Agent", sentryClientName);
        map.put("X-Sentry-Auth", string2);
        return new p3(string, map);
    }
}
