package io.sentry.config;

import io.sentry.util.q;
import io.sentry.util.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AbstractPropertiesProvider.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class a implements g {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Properties f22365b;

    protected a(String str, Properties properties) {
        this.a = (String) q.c(str, "prefix is required");
        this.f22365b = (Properties) q.c(properties, "properties are required");
    }

    @Override // io.sentry.config.g
    public Map<String, String> a(String str) {
        String str2 = this.a + str + ".";
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f22365b.entrySet()) {
            if ((entry.getKey() instanceof String) && (entry.getValue() instanceof String)) {
                String str3 = (String) entry.getKey();
                if (str3.startsWith(str2)) {
                    map.put(str3.substring(str2.length()), u.e((String) entry.getValue(), "\""));
                }
            }
        }
        return map;
    }

    @Override // io.sentry.config.g
    public String b(String str) {
        return u.e(this.f22365b.getProperty(this.a + str), "\"");
    }

    @Override // io.sentry.config.g
    public /* synthetic */ Boolean c(String str) {
        return f.a(this, str);
    }

    @Override // io.sentry.config.g
    public /* synthetic */ Long d(String str) {
        return f.d(this, str);
    }

    @Override // io.sentry.config.g
    public /* synthetic */ Double e(String str) {
        return f.b(this, str);
    }

    @Override // io.sentry.config.g
    public /* synthetic */ String f(String str, String str2) {
        return f.e(this, str, str2);
    }

    @Override // io.sentry.config.g
    public /* synthetic */ List g(String str) {
        return f.c(this, str);
    }

    protected a(Properties properties) {
        this(HttpUrl.FRAGMENT_ENCODE_SET, properties);
    }
}
