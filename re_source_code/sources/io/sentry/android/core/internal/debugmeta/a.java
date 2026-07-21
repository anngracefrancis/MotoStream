package io.sentry.android.core.internal.debugmeta;

import android.content.Context;
import io.sentry.s4;
import io.sentry.util.j;
import io.sentry.w1;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: AssetsDebugMetaLoader.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class a implements io.sentry.internal.debugmeta.a {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w1 f22141b;

    public a(Context context, w1 w1Var) {
        this.a = context;
        this.f22141b = w1Var;
    }

    @Override // io.sentry.internal.debugmeta.a
    public Properties a() {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.a.getAssets().open(j.a));
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
        } catch (FileNotFoundException e2) {
            this.f22141b.a(s4.INFO, e2, "%s file was not found.", j.a);
            return null;
        } catch (IOException e3) {
            this.f22141b.b(s4.ERROR, "Error getting Proguard UUIDs.", e3);
            return null;
        } catch (RuntimeException e4) {
            this.f22141b.a(s4.ERROR, e4, "%s file is malformed.", j.a);
            return null;
        }
    }
}
