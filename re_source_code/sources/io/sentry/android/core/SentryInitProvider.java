package io.sentry.android.core;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import io.sentry.a4;
import io.sentry.q4;
import io.sentry.s4;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class SentryInitProvider extends x0 {
    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        if (SentryInitProvider.class.getName().equals(providerInfo.authority)) {
            throw new IllegalStateException("An applicationId is required to fulfill the manifest placeholder.");
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        i0 i0Var = new i0();
        Context context = getContext();
        if (context == null) {
            i0Var.c(s4.FATAL, "App. Context from ContentProvider is null", new Object[0]);
            return false;
        }
        if (!d1.c(context, i0Var)) {
            return true;
        }
        g1.b(context, i0Var);
        q4.c().a("AutoInit");
        return true;
    }

    @Override // android.content.ContentProvider
    public void shutdown() {
        a4.e();
    }
}
