package cm.aptoide.pt.logger;

import cm.aptoide.analytics.AnalyticsLogger;

/* JADX INFO: loaded from: classes.dex */
public class AnalyticsLogcatLogger implements AnalyticsLogger {
    @Override // cm.aptoide.analytics.AnalyticsLogger
    public void logDebug(String str, String str2) {
        Logger.getInstance().d(str, str2);
    }

    @Override // cm.aptoide.analytics.AnalyticsLogger
    public void logWarningDebug(String str, String str2) {
        Logger.getInstance().w(str, str2);
    }
}
