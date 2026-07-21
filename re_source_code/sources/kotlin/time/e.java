package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DurationUnitJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0001\u001a \u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0001\u001a \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0001\u001a\f\u0010\b\u001a\u00020\u0004*\u00020\tH\u0007\u001a\f\u0010\n\u001a\u00020\t*\u00020\u0004H\u0007¨\u0006\u000b"}, d2 = {"convertDurationUnit", HttpUrl.FRAGMENT_ENCODE_SET, "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", HttpUrl.FRAGMENT_ENCODE_SET, "convertDurationUnitOverflow", "toDurationUnit", "Ljava/util/concurrent/TimeUnit;", "toTimeUnit", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/time/DurationUnitKt")
class e {
    public static final long a(long j2, DurationUnit durationUnit, DurationUnit durationUnit2) {
        m.f(durationUnit, "sourceUnit");
        m.f(durationUnit2, "targetUnit");
        return durationUnit2.getN().convert(j2, durationUnit.getN());
    }

    public static final long b(long j2, DurationUnit durationUnit, DurationUnit durationUnit2) {
        m.f(durationUnit, "sourceUnit");
        m.f(durationUnit2, "targetUnit");
        return durationUnit2.getN().convert(j2, durationUnit.getN());
    }
}
