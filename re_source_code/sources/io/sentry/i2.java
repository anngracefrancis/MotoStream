package io.sentry;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: IntegrationName.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class i2 {
    public static void a(j2 _this) {
        q4.c().a(_this.d());
    }

    public static String b(j2 _this) {
        return _this.getClass().getSimpleName().replace("Sentry", HttpUrl.FRAGMENT_ENCODE_SET).replace("Integration", HttpUrl.FRAGMENT_ENCODE_SET).replace("Interceptor", HttpUrl.FRAGMENT_ENCODE_SET).replace("EventProcessor", HttpUrl.FRAGMENT_ENCODE_SET);
    }
}
