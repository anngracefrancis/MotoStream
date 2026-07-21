package io.sentry.android.core.internal.modules;

import android.content.Context;
import io.sentry.internal.modules.d;
import io.sentry.s4;
import io.sentry.w1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: AssetsModulesLoader.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class a extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f22162d;

    public a(Context context, w1 w1Var) {
        super(w1Var);
        this.f22162d = context;
    }

    @Override // io.sentry.internal.modules.d
    protected Map<String, String> b() {
        TreeMap treeMap = new TreeMap();
        try {
            InputStream inputStreamOpen = this.f22162d.getAssets().open("sentry-external-modules.txt");
            try {
                Map<String, String> mapC = c(inputStreamOpen);
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                return mapC;
            } catch (Throwable th) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused2) {
            this.f22448b.c(s4.INFO, "%s file was not found.", "sentry-external-modules.txt");
            return treeMap;
        } catch (IOException e2) {
            this.f22448b.b(s4.ERROR, "Error extracting modules.", e2);
            return treeMap;
        }
    }
}
