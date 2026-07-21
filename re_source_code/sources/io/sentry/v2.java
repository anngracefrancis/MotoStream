package io.sentry;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: MeasurementUnit.java */
/* JADX INFO: loaded from: classes2.dex */
public interface v2 {

    /* JADX INFO: compiled from: MeasurementUnit.java */
    public enum a implements v2 {
        NANOSECOND,
        MICROSECOND,
        MILLISECOND,
        SECOND,
        MINUTE,
        HOUR,
        DAY,
        WEEK;

        @Override // io.sentry.v2
        @ApiStatus.Internal
        public /* bridge */ /* synthetic */ String apiName() {
            return u2.a(this);
        }
    }

    @ApiStatus.Internal
    String apiName();

    String name();
}
