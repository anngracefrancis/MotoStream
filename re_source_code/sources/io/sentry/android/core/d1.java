package io.sentry.android.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import io.sentry.q4;
import io.sentry.s4;
import io.sentry.w1;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ManifestMetadataReader.java */
/* JADX INFO: loaded from: classes2.dex */
final class d1 {
    static void a(Context context, SentryAndroidOptions sentryAndroidOptions, s0 s0Var) {
        io.sentry.util.q.c(context, "The application context is required.");
        io.sentry.util.q.c(sentryAndroidOptions, "The options object is required.");
        try {
            Bundle bundleB = b(context, sentryAndroidOptions.getLogger(), s0Var);
            w1 logger = sentryAndroidOptions.getLogger();
            if (bundleB != null) {
                sentryAndroidOptions.setDebug(d(bundleB, logger, "io.sentry.debug", sentryAndroidOptions.isDebug()));
                if (sentryAndroidOptions.isDebug()) {
                    String strName = sentryAndroidOptions.getDiagnosticLevel().name();
                    Locale locale = Locale.ROOT;
                    String strI = i(bundleB, logger, "io.sentry.debug.level", strName.toLowerCase(locale));
                    if (strI != null) {
                        sentryAndroidOptions.setDiagnosticLevel(s4.valueOf(strI.toUpperCase(locale)));
                    }
                }
                sentryAndroidOptions.setAnrEnabled(d(bundleB, logger, "io.sentry.anr.enable", sentryAndroidOptions.isAnrEnabled()));
                sentryAndroidOptions.setEnableAutoSessionTracking(d(bundleB, logger, "io.sentry.auto-session-tracking.enable", d(bundleB, logger, "io.sentry.session-tracking.enable", sentryAndroidOptions.isEnableAutoSessionTracking())));
                if (sentryAndroidOptions.getSampleRate() == null) {
                    Double dF = f(bundleB, logger, "io.sentry.sample-rate");
                    if (dF.doubleValue() != -1.0d) {
                        sentryAndroidOptions.setSampleRate(dF);
                    }
                }
                sentryAndroidOptions.setAnrReportInDebug(d(bundleB, logger, "io.sentry.anr.report-debug", sentryAndroidOptions.isAnrReportInDebug()));
                sentryAndroidOptions.setAnrTimeoutIntervalMillis(h(bundleB, logger, "io.sentry.anr.timeout-interval-millis", sentryAndroidOptions.getAnrTimeoutIntervalMillis()));
                String strI2 = i(bundleB, logger, "io.sentry.dsn", sentryAndroidOptions.getDsn());
                boolean zD = d(bundleB, logger, "io.sentry.enabled", sentryAndroidOptions.isEnabled());
                if (!zD || (strI2 != null && strI2.isEmpty())) {
                    sentryAndroidOptions.getLogger().c(s4.DEBUG, "Sentry enabled flag set to false or DSN is empty: disabling sentry-android", new Object[0]);
                } else if (strI2 == null) {
                    sentryAndroidOptions.getLogger().c(s4.FATAL, "DSN is required. Use empty string to disable SDK.", new Object[0]);
                }
                sentryAndroidOptions.setEnabled(zD);
                sentryAndroidOptions.setDsn(strI2);
                sentryAndroidOptions.setEnableNdk(d(bundleB, logger, "io.sentry.ndk.enable", sentryAndroidOptions.isEnableNdk()));
                sentryAndroidOptions.setEnableScopeSync(d(bundleB, logger, "io.sentry.ndk.scope-sync.enable", sentryAndroidOptions.isEnableScopeSync()));
                sentryAndroidOptions.setRelease(i(bundleB, logger, "io.sentry.release", sentryAndroidOptions.getRelease()));
                sentryAndroidOptions.setEnvironment(i(bundleB, logger, "io.sentry.environment", sentryAndroidOptions.getEnvironment()));
                sentryAndroidOptions.setSessionTrackingIntervalMillis(h(bundleB, logger, "io.sentry.session-tracking.timeout-interval-millis", sentryAndroidOptions.getSessionTrackingIntervalMillis()));
                sentryAndroidOptions.setEnableActivityLifecycleBreadcrumbs(d(bundleB, logger, "io.sentry.breadcrumbs.activity-lifecycle", sentryAndroidOptions.isEnableActivityLifecycleBreadcrumbs()));
                sentryAndroidOptions.setEnableAppLifecycleBreadcrumbs(d(bundleB, logger, "io.sentry.breadcrumbs.app-lifecycle", sentryAndroidOptions.isEnableAppLifecycleBreadcrumbs()));
                sentryAndroidOptions.setEnableSystemEventBreadcrumbs(d(bundleB, logger, "io.sentry.breadcrumbs.system-events", sentryAndroidOptions.isEnableSystemEventBreadcrumbs()));
                sentryAndroidOptions.setEnableAppComponentBreadcrumbs(d(bundleB, logger, "io.sentry.breadcrumbs.app-components", sentryAndroidOptions.isEnableAppComponentBreadcrumbs()));
                sentryAndroidOptions.setEnableUserInteractionBreadcrumbs(d(bundleB, logger, "io.sentry.breadcrumbs.user-interaction", sentryAndroidOptions.isEnableUserInteractionBreadcrumbs()));
                sentryAndroidOptions.setEnableNetworkEventBreadcrumbs(d(bundleB, logger, "io.sentry.breadcrumbs.network-events", sentryAndroidOptions.isEnableNetworkEventBreadcrumbs()));
                sentryAndroidOptions.setEnableUncaughtExceptionHandler(d(bundleB, logger, "io.sentry.uncaught-exception-handler.enable", sentryAndroidOptions.isEnableUncaughtExceptionHandler()));
                sentryAndroidOptions.setAttachThreads(d(bundleB, logger, "io.sentry.attach-threads", sentryAndroidOptions.isAttachThreads()));
                sentryAndroidOptions.setAttachScreenshot(d(bundleB, logger, "io.sentry.attach-screenshot", sentryAndroidOptions.isAttachScreenshot()));
                sentryAndroidOptions.setAttachViewHierarchy(d(bundleB, logger, "io.sentry.attach-view-hierarchy", sentryAndroidOptions.isAttachViewHierarchy()));
                sentryAndroidOptions.setSendClientReports(d(bundleB, logger, "io.sentry.send-client-reports", sentryAndroidOptions.isSendClientReports()));
                sentryAndroidOptions.setCollectAdditionalContext(d(bundleB, logger, "io.sentry.additional-context", sentryAndroidOptions.isCollectAdditionalContext()));
                if (sentryAndroidOptions.getEnableTracing() == null) {
                    sentryAndroidOptions.setEnableTracing(e(bundleB, logger, "io.sentry.traces.enable", null));
                }
                if (sentryAndroidOptions.getTracesSampleRate() == null) {
                    Double dF2 = f(bundleB, logger, "io.sentry.traces.sample-rate");
                    if (dF2.doubleValue() != -1.0d) {
                        sentryAndroidOptions.setTracesSampleRate(dF2);
                    }
                }
                sentryAndroidOptions.setTraceSampling(d(bundleB, logger, "io.sentry.traces.trace-sampling", sentryAndroidOptions.isTraceSampling()));
                sentryAndroidOptions.setEnableAutoActivityLifecycleTracing(d(bundleB, logger, "io.sentry.traces.activity.enable", sentryAndroidOptions.isEnableAutoActivityLifecycleTracing()));
                sentryAndroidOptions.setEnableActivityLifecycleTracingAutoFinish(d(bundleB, logger, "io.sentry.traces.activity.auto-finish.enable", sentryAndroidOptions.isEnableActivityLifecycleTracingAutoFinish()));
                sentryAndroidOptions.setProfilingEnabled(d(bundleB, logger, "io.sentry.traces.profiling.enable", sentryAndroidOptions.isProfilingEnabled()));
                if (sentryAndroidOptions.getProfilesSampleRate() == null) {
                    Double dF3 = f(bundleB, logger, "io.sentry.traces.profiling.sample-rate");
                    if (dF3.doubleValue() != -1.0d) {
                        sentryAndroidOptions.setProfilesSampleRate(dF3);
                    }
                }
                sentryAndroidOptions.setEnableUserInteractionTracing(d(bundleB, logger, "io.sentry.traces.user-interaction.enable", sentryAndroidOptions.isEnableUserInteractionTracing()));
                sentryAndroidOptions.setEnableTimeToFullDisplayTracing(d(bundleB, logger, "io.sentry.traces.time-to-full-display.enable", sentryAndroidOptions.isEnableTimeToFullDisplayTracing()));
                long jH = h(bundleB, logger, "io.sentry.traces.idle-timeout", -1L);
                if (jH != -1) {
                    sentryAndroidOptions.setIdleTimeout(Long.valueOf(jH));
                }
                List<String> listG = g(bundleB, logger, "io.sentry.traces.trace-propagation-targets");
                if (!bundleB.containsKey("io.sentry.traces.trace-propagation-targets") && (listG == null || listG.isEmpty())) {
                    listG = g(bundleB, logger, "io.sentry.traces.tracing-origins");
                }
                if ((bundleB.containsKey("io.sentry.traces.trace-propagation-targets") || bundleB.containsKey("io.sentry.traces.tracing-origins")) && listG == null) {
                    sentryAndroidOptions.setTracePropagationTargets(Collections.emptyList());
                } else if (listG != null) {
                    sentryAndroidOptions.setTracePropagationTargets(listG);
                }
                sentryAndroidOptions.setEnableFramesTracking(d(bundleB, logger, "io.sentry.traces.frames-tracking", true));
                sentryAndroidOptions.setProguardUuid(i(bundleB, logger, "io.sentry.proguard-uuid", sentryAndroidOptions.getProguardUuid()));
                io.sentry.protocol.o sdkVersion = sentryAndroidOptions.getSdkVersion();
                if (sdkVersion == null) {
                    sdkVersion = new io.sentry.protocol.o(HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET);
                }
                sdkVersion.h(j(bundleB, logger, "io.sentry.sdk.name", sdkVersion.e()));
                sdkVersion.j(j(bundleB, logger, "io.sentry.sdk.version", sdkVersion.g()));
                sentryAndroidOptions.setSdkVersion(sdkVersion);
                sentryAndroidOptions.setSendDefaultPii(d(bundleB, logger, "io.sentry.send-default-pii", sentryAndroidOptions.isSendDefaultPii()));
                List<String> listG2 = g(bundleB, logger, "io.sentry.gradle-plugin-integrations");
                if (listG2 != null) {
                    Iterator<String> it = listG2.iterator();
                    while (it.hasNext()) {
                        q4.c().a(it.next());
                    }
                }
                sentryAndroidOptions.setEnableRootCheck(d(bundleB, logger, "io.sentry.enable-root-check", sentryAndroidOptions.isEnableRootCheck()));
                sentryAndroidOptions.setSendModules(d(bundleB, logger, "io.sentry.send-modules", sentryAndroidOptions.isSendModules()));
            }
            sentryAndroidOptions.getLogger().c(s4.INFO, "Retrieving configuration from AndroidManifest.xml", new Object[0]);
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().b(s4.ERROR, "Failed to read configuration from android manifest metadata.", th);
        }
    }

    private static Bundle b(Context context, w1 w1Var, s0 s0Var) throws PackageManager.NameNotFoundException {
        if (s0Var == null) {
            s0Var = new s0(w1Var);
        }
        return t0.a(context, 128L, s0Var).metaData;
    }

    static boolean c(Context context, w1 w1Var) {
        io.sentry.util.q.c(context, "The application context is required.");
        boolean zD = true;
        try {
            Bundle bundleB = b(context, w1Var, null);
            zD = bundleB != null ? d(bundleB, w1Var, "io.sentry.auto-init", true) : true;
            w1Var.c(s4.INFO, "Retrieving auto-init from AndroidManifest.xml", new Object[0]);
        } catch (Throwable th) {
            w1Var.b(s4.ERROR, "Failed to read auto-init from android manifest metadata.", th);
        }
        return zD;
    }

    private static boolean d(Bundle bundle, w1 w1Var, String str, boolean z) {
        boolean z2 = bundle.getBoolean(str, z);
        w1Var.c(s4.DEBUG, "%s read: %s", str, Boolean.valueOf(z2));
        return z2;
    }

    private static Boolean e(Bundle bundle, w1 w1Var, String str, Boolean bool) {
        if (bundle.getSerializable(str) == null) {
            w1Var.c(s4.DEBUG, "%s used default %s", str, bool);
            return bool;
        }
        boolean z = bundle.getBoolean(str, bool != null);
        w1Var.c(s4.DEBUG, "%s read: %s", str, Boolean.valueOf(z));
        return Boolean.valueOf(z);
    }

    private static Double f(Bundle bundle, w1 w1Var, String str) {
        Double dValueOf = Double.valueOf(Float.valueOf(bundle.getFloat(str, -1.0f)).doubleValue());
        w1Var.c(s4.DEBUG, "%s read: %s", str, dValueOf);
        return dValueOf;
    }

    private static List<String> g(Bundle bundle, w1 w1Var, String str) {
        String string = bundle.getString(str);
        w1Var.c(s4.DEBUG, "%s read: %s", str, string);
        if (string != null) {
            return Arrays.asList(string.split(",", -1));
        }
        return null;
    }

    private static long h(Bundle bundle, w1 w1Var, String str, long j2) {
        long j3 = bundle.getInt(str, (int) j2);
        w1Var.c(s4.DEBUG, "%s read: %s", str, Long.valueOf(j3));
        return j3;
    }

    private static String i(Bundle bundle, w1 w1Var, String str, String str2) {
        String string = bundle.getString(str, str2);
        w1Var.c(s4.DEBUG, "%s read: %s", str, string);
        return string;
    }

    private static String j(Bundle bundle, w1 w1Var, String str, String str2) {
        String string = bundle.getString(str, str2);
        w1Var.c(s4.DEBUG, "%s read: %s", str, string);
        return string;
    }
}
