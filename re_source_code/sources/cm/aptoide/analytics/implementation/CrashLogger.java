package cm.aptoide.analytics.implementation;

/* JADX INFO: loaded from: classes.dex */
public interface CrashLogger {
    void log(String str, String str2);

    void log(Throwable th);
}
