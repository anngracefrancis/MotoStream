package io.sentry.config;

import io.sentry.n5;
import java.util.ArrayList;
import java.util.Properties;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: PropertiesProviderFactory.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class h {
    public static g a() {
        Properties propertiesA;
        Properties propertiesA2;
        n5 n5Var = new n5();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new j());
        arrayList.add(new d());
        String property = System.getProperty("sentry.properties.file");
        if (property != null && (propertiesA2 = new e(property, n5Var).a()) != null) {
            arrayList.add(new i(propertiesA2));
        }
        String str = System.getenv("SENTRY_PROPERTIES_FILE");
        if (str != null && (propertiesA = new e(str, n5Var).a()) != null) {
            arrayList.add(new i(propertiesA));
        }
        Properties propertiesA3 = new b(n5Var).a();
        if (propertiesA3 != null) {
            arrayList.add(new i(propertiesA3));
        }
        Properties propertiesA4 = new e("sentry.properties", n5Var).a();
        if (propertiesA4 != null) {
            arrayList.add(new i(propertiesA4));
        }
        return new c(arrayList);
    }
}
