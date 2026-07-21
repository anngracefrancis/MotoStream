package okhttp3.internal.platform.android;

import android.util.Log;
import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.collections.q0;
import kotlin.jvm.internal.m;
import kotlin.text.v;
import kotlin.text.x;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: AndroidLog.kt */
/* JADX INFO: loaded from: classes3.dex */
@SuppressSignatureCheck
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u0014J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ1\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u000b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lokhttp3/internal/platform/android/AndroidLog;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "loggerName", "loggerTag", "(Ljava/lang/String;)Ljava/lang/String;", "logger", StoreTabGridRecyclerFragment.BundleCons.TAG, "Lkotlin/u;", "enableLogging", "(Ljava/lang/String;Ljava/lang/String;)V", HttpUrl.FRAGMENT_ENCODE_SET, "logLevel", "message", HttpUrl.FRAGMENT_ENCODE_SET, "t", "androidLog$okhttp", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V", "androidLog", "enable", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "knownLoggers", "Ljava/util/Map;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/logging/Logger;", "configuredLoggers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "MAX_LOG_LENGTH", "I", "<init>", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class AndroidLog {
    private static final int MAX_LOG_LENGTH = 4000;
    private static final Map<String, String> knownLoggers;
    public static final AndroidLog INSTANCE = new AndroidLog();
    private static final CopyOnWriteArraySet<Logger> configuredLoggers = new CopyOnWriteArraySet<>();

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r1 = OkHttpClient.class.getPackage();
        String name = r1 != null ? r1.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        String name2 = OkHttpClient.class.getName();
        m.e(name2, "OkHttpClient::class.java.name");
        linkedHashMap.put(name2, "okhttp.OkHttpClient");
        String name3 = Http2.class.getName();
        m.e(name3, "Http2::class.java.name");
        linkedHashMap.put(name3, "okhttp.Http2");
        String name4 = TaskRunner.class.getName();
        m.e(name4, "TaskRunner::class.java.name");
        linkedHashMap.put(name4, "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        knownLoggers = q0.s(linkedHashMap);
    }

    private AndroidLog() {
    }

    private final void enableLogging(String logger, String tag) {
        Level level;
        Logger logger2 = Logger.getLogger(logger);
        if (configuredLoggers.add(logger2)) {
            m.e(logger2, "logger");
            logger2.setUseParentHandlers(false);
            if (Log.isLoggable(tag, 3)) {
                level = Level.FINE;
            } else {
                level = Log.isLoggable(tag, 4) ? Level.INFO : Level.WARNING;
            }
            logger2.setLevel(level);
            logger2.addHandler(AndroidLogHandler.INSTANCE);
        }
    }

    private final String loggerTag(String loggerName) {
        String str = knownLoggers.get(loggerName);
        return str != null ? str : x.R0(loggerName, 23);
    }

    public final void androidLog$okhttp(String loggerName, int logLevel, String message, Throwable t) {
        int iMin;
        m.f(loggerName, "loggerName");
        m.f(message, "message");
        String strLoggerTag = loggerTag(loggerName);
        if (Log.isLoggable(strLoggerTag, logLevel)) {
            if (t != null) {
                message = message + "\n" + Log.getStackTraceString(t);
            }
            int i2 = 0;
            int length = message.length();
            while (i2 < length) {
                int iV = v.V(message, '\n', i2, false, 4, null);
                if (iV == -1) {
                    iV = length;
                }
                while (true) {
                    iMin = Math.min(iV, i2 + MAX_LOG_LENGTH);
                    String strSubstring = message.substring(i2, iMin);
                    m.e(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.println(logLevel, strLoggerTag, strSubstring);
                    if (iMin >= iV) {
                        break;
                    } else {
                        i2 = iMin;
                    }
                }
                i2 = iMin + 1;
            }
        }
    }

    public final void enable() {
        for (Map.Entry<String, String> entry : knownLoggers.entrySet()) {
            enableLogging(entry.getKey(), entry.getValue());
        }
    }
}
