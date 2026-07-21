package io.sentry.config;

import io.sentry.util.u;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: EnvironmentVariablePropertiesProvider.java */
/* JADX INFO: loaded from: classes2.dex */
final class d implements g {
    d() {
    }

    private String h(String str) {
        return "SENTRY_" + str.replace(".", "_").replace("-", "_").toUpperCase(Locale.ROOT);
    }

    @Override // io.sentry.config.g
    public Map<String, String> a(String str) {
        String strE;
        String str2 = h(str) + "_";
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
            String key = entry.getKey();
            if (key.startsWith(str2) && (strE = u.e(entry.getValue(), "\"")) != null) {
                concurrentHashMap.put(key.substring(str2.length()).toLowerCase(Locale.ROOT), strE);
            }
        }
        return concurrentHashMap;
    }

    @Override // io.sentry.config.g
    public String b(String str) {
        return u.e(System.getenv(h(str)), "\"");
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
}
