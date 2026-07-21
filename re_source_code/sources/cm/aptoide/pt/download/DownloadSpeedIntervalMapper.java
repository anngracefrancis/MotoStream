package cm.aptoide.pt.download;

import kotlin.Metadata;
import kotlin.Pair;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DownloadSpeedIntervalMapper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcm/aptoide/pt/download/DownloadSpeedIntervalMapper;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "getDownloadSpeedInterval", "Lkotlin/Pair;", HttpUrl.FRAGMENT_ENCODE_SET, "kilobytesPerSecond", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DownloadSpeedIntervalMapper {
    public final Pair<String, String> getDownloadSpeedInterval(long j2) {
        String str;
        String str2;
        double d2 = j2 * ((long) 1024);
        if (d2 >= 1024.0d) {
            double d3 = 1024;
            Double.isNaN(d2);
            Double.isNaN(d3);
            d2 /= d3;
            str = "KBPS";
        } else {
            str = "BPS";
        }
        if (d2 >= 1024.0d) {
            double d4 = 1024;
            Double.isNaN(d4);
            d2 /= d4;
            str = "MBPS";
        }
        if (d2 >= 1024.0d) {
            double d5 = 1024;
            Double.isNaN(d5);
            d2 /= d5;
            str = "GBPS";
        }
        if (d2 == 0.0d) {
            str2 = "0";
        } else if (d2 <= 2.0d) {
            str2 = "1-2";
        } else if (d2 <= 5.0d) {
            str2 = "3-5";
        } else if (d2 <= 10.0d) {
            str2 = "6-10";
        } else if (d2 <= 20.0d) {
            str2 = "11-20";
        } else if (d2 <= 50.0d) {
            str2 = "21-50";
        } else if (d2 <= 100.0d) {
            str2 = "51-100";
        } else if (d2 <= 200.0d) {
            str2 = "101-200";
        } else if (d2 <= 500.0d) {
            str2 = "201-500";
        } else {
            str2 = d2 <= 1000.0d ? "501-1000" : ">1000";
        }
        return new Pair<>(str2, str);
    }
}
