package io.sentry.config;

import io.sentry.s4;
import io.sentry.w1;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* JADX INFO: compiled from: FilesystemPropertiesLoader.java */
/* JADX INFO: loaded from: classes2.dex */
final class e {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w1 f22368b;

    public e(String str, w1 w1Var) {
        this.a = str;
        this.f22368b = w1Var;
    }

    public Properties a() {
        try {
            File file = new File(this.a);
            if (!file.isFile() || !file.canRead()) {
                return null;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                bufferedInputStream.close();
                return properties;
            } catch (Throwable th) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (IOException e2) {
            this.f22368b.a(s4.ERROR, e2, "Failed to load Sentry configuration from file: %s", this.a);
            return null;
        }
    }
}
