package io.sentry.vendor.gson.stream;

import java.io.IOException;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class MalformedJsonException extends IOException {
    public MalformedJsonException(String str) {
        super(str);
    }
}
