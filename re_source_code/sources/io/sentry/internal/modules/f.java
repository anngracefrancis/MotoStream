package io.sentry.internal.modules;

import io.sentry.s4;
import io.sentry.util.h;
import io.sentry.w1;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: ResourcesModulesLoader.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class f extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ClassLoader f22450d;

    public f(w1 w1Var) {
        this(w1Var, f.class.getClassLoader());
    }

    @Override // io.sentry.internal.modules.d
    protected Map<String, String> b() {
        TreeMap treeMap = new TreeMap();
        try {
            InputStream resourceAsStream = this.f22450d.getResourceAsStream("sentry-external-modules.txt");
            try {
                if (resourceAsStream != null) {
                    Map<String, String> mapC = c(resourceAsStream);
                    resourceAsStream.close();
                    return mapC;
                }
                this.f22448b.c(s4.INFO, "%s file was not found.", "sentry-external-modules.txt");
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
                return treeMap;
            } catch (Throwable th) {
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        } catch (IOException e2) {
            this.f22448b.b(s4.INFO, "Access to resources failed.", e2);
            return treeMap;
        } catch (SecurityException e3) {
            this.f22448b.b(s4.INFO, "Access to resources denied.", e3);
            return treeMap;
        }
    }

    f(w1 w1Var, ClassLoader classLoader) {
        super(w1Var);
        this.f22450d = h.a(classLoader);
    }
}
