package io.sentry.android.core;

import android.content.Context;
import io.sentry.Integration;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: AnrIntegrationFactory.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class o0 {
    public static Integration a(Context context, s0 s0Var) {
        return s0Var.d() >= 30 ? new AnrV2Integration(context) : new AnrIntegration(context);
    }
}
