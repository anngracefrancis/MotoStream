package io.sentry.util;

import io.sentry.s4;
import io.sentry.x4;
import java.util.Properties;

/* JADX INFO: compiled from: DebugMetaPropertiesApplier.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j {
    public static String a = "sentry-debug-meta.properties";

    private static void a(x4 x4Var, Properties properties) {
        if (x4Var.getBundleIds().isEmpty()) {
            String property = properties.getProperty("io.sentry.bundle-ids");
            x4Var.getLogger().c(s4.DEBUG, "Bundle IDs found: %s", property);
            if (property != null) {
                for (String str : property.split(",", -1)) {
                    x4Var.addBundleId(str);
                }
            }
        }
    }

    private static void b(x4 x4Var, Properties properties) {
        if (x4Var.getProguardUuid() == null) {
            String strD = d(properties);
            x4Var.getLogger().c(s4.DEBUG, "Proguard UUID found: %s", strD);
            x4Var.setProguardUuid(strD);
        }
    }

    public static void c(x4 x4Var, Properties properties) {
        if (properties != null) {
            b(x4Var, properties);
            a(x4Var, properties);
        }
    }

    public static String d(Properties properties) {
        return properties.getProperty("io.sentry.ProguardUuids");
    }
}
