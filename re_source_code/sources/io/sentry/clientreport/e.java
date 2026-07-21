package io.sentry.clientreport;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: DiscardReason.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public enum e {
    QUEUE_OVERFLOW("queue_overflow"),
    CACHE_OVERFLOW("cache_overflow"),
    RATELIMIT_BACKOFF("ratelimit_backoff"),
    NETWORK_ERROR("network_error"),
    SAMPLE_RATE("sample_rate"),
    BEFORE_SEND("before_send"),
    EVENT_PROCESSOR("event_processor");

    private final String reason;

    e(String str) {
        this.reason = str;
    }

    public String getReason() {
        return this.reason;
    }
}
