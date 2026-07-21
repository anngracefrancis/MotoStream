package cm.aptoide.analytics.implementation.loggers;

import cm.aptoide.analytics.AnalyticsLogger;
import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.analytics.EventLogger;
import e.f.a.a.a;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class IndicativeEventLogger implements EventLogger {
    private static final String TAG = "IndicativeEventLogger";
    private final AnalyticsLogger logger;

    public IndicativeEventLogger(AnalyticsLogger analyticsLogger) {
        this.logger = analyticsLogger;
    }

    @Override // cm.aptoide.analytics.EventLogger
    public void log(String str, Map<String, Object> map, AnalyticsManager.Action action, String str2) {
        if (map != null) {
            a.q(str, map);
        } else {
            a.n(str);
        }
        this.logger.logDebug(TAG, "log() called with: eventName = [" + str + "], data = [" + map + "], action = [" + action + "], context = [" + str2 + "]");
    }

    @Override // cm.aptoide.analytics.EventLogger
    public void setup() {
    }
}
