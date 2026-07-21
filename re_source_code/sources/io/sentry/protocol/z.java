package io.sentry.protocol;

import java.util.Locale;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: TransactionNameSource.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public enum z {
    CUSTOM,
    URL,
    ROUTE,
    VIEW,
    COMPONENT,
    TASK;

    public String apiName() {
        return name().toLowerCase(Locale.ROOT);
    }
}
