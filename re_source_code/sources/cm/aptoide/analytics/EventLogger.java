package cm.aptoide.analytics;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface EventLogger {
    void log(String str, Map<String, Object> map, AnalyticsManager.Action action, String str2);

    void setup();
}
