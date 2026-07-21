package cm.aptoide.pt.analytics;

import cm.aptoide.pt.file.CacheHelper;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AppSizeAnalyticsStringMapper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcm/aptoide/pt/analytics/AppSizeAnalyticsStringMapper;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "mapAppSizeToMBBucketValue", HttpUrl.FRAGMENT_ENCODE_SET, "appSize", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppSizeAnalyticsStringMapper {
    public final long mapAppSizeToMBBucketValue(long appSize) {
        long j2 = 100;
        return (((appSize / ((long) CacheHelper.VALUE_TO_CONVERT_MB_TO_BYTES)) / j2) * j2) + j2;
    }
}
