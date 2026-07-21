package io.sentry.internal.debugmeta;

import io.sentry.s4;
import io.sentry.util.h;
import io.sentry.util.j;
import io.sentry.w1;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: ResourcesDebugMetaLoader.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class c implements a {
    private final w1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ClassLoader f22438b;

    public c(w1 w1Var) {
        this(w1Var, c.class.getClassLoader());
    }

    @Override // io.sentry.internal.debugmeta.a
    public Properties a() {
        try {
            InputStream resourceAsStream = this.f22438b.getResourceAsStream(j.a);
            try {
                if (resourceAsStream == null) {
                    this.a.c(s4.INFO, "%s file was not found.", j.a);
                } else {
                    try {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(resourceAsStream);
                        try {
                            Properties properties = new Properties();
                            properties.load(bufferedInputStream);
                            bufferedInputStream.close();
                            resourceAsStream.close();
                            return properties;
                        } catch (Throwable th) {
                            try {
                                bufferedInputStream.close();
                            } catch (Throwable unused) {
                            }
                            throw th;
                        }
                    } catch (IOException e2) {
                        this.a.a(s4.ERROR, e2, "Failed to load %s", j.a);
                    } catch (RuntimeException e3) {
                        this.a.a(s4.ERROR, e3, "%s file is malformed.", j.a);
                    }
                }
                if (resourceAsStream == null) {
                    return null;
                }
                resourceAsStream.close();
                return null;
            } catch (Throwable th2) {
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th2;
            }
        } catch (IOException e4) {
            this.a.a(s4.ERROR, e4, "Failed to load %s", j.a);
            return null;
        }
    }

    c(w1 w1Var, ClassLoader classLoader) {
        this.a = w1Var;
        this.f22438b = h.a(classLoader);
    }
}
