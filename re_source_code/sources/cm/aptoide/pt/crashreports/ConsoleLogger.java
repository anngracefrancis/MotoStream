package cm.aptoide.pt.crashreports;

import cm.aptoide.analytics.implementation.CrashLogger;
import cm.aptoide.pt.logger.Logger;

/* JADX INFO: loaded from: classes.dex */
public class ConsoleLogger implements CrashLogger {
    private static final String TAG = "cm.aptoide.pt.crashreports.ConsoleLogger";

    @Override // cm.aptoide.analytics.implementation.CrashLogger
    public void log(Throwable th) {
        Logger.getInstance().e(TAG, "Exception found", th);
    }

    @Override // cm.aptoide.analytics.implementation.CrashLogger
    public void log(String str, String str2) {
        Logger.getInstance().w(TAG, "logString : key: " + str + " , value: " + str2);
    }
}
