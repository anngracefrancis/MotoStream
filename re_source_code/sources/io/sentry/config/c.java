package io.sentry.config;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: CompositePropertiesProvider.java */
/* JADX INFO: loaded from: classes2.dex */
final class c implements g {
    private final List<g> a;

    public c(List<g> list) {
        this.a = list;
    }

    @Override // io.sentry.config.g
    public Map<String, String> a(String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Iterator<g> it = this.a.iterator();
        while (it.hasNext()) {
            concurrentHashMap.putAll(it.next().a(str));
        }
        return concurrentHashMap;
    }

    @Override // io.sentry.config.g
    public String b(String str) {
        Iterator<g> it = this.a.iterator();
        while (it.hasNext()) {
            String strB = it.next().b(str);
            if (strB != null) {
                return strB;
            }
        }
        return null;
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
