package io.sentry.android.core;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import io.sentry.android.fragment.FragmentLifecycleIntegration;
import io.sentry.android.timber.SentryTimberIntegration;
import io.sentry.compose.gestures.ComposeGestureTargetLocator;
import io.sentry.compose.viewhierarchy.ComposeViewHierarchyExporter;
import io.sentry.s4;
import io.sentry.v3;
import io.sentry.w1;
import io.sentry.y3;
import io.sentry.z3;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: compiled from: AndroidOptionsInitializer.java */
/* JADX INFO: loaded from: classes2.dex */
final class k0 {
    private static String a(PackageInfo packageInfo, String str) {
        return packageInfo.packageName + "@" + packageInfo.versionName + "+" + str;
    }

    private static void b(Context context, SentryAndroidOptions sentryAndroidOptions) {
        sentryAndroidOptions.setCacheDirPath(new File(context.getCacheDir(), "sentry").getAbsolutePath());
    }

    static void c(SentryAndroidOptions sentryAndroidOptions, Context context, s0 s0Var, b1 b1Var, f0 f0Var) {
        if (sentryAndroidOptions.getCacheDirPath() != null && (sentryAndroidOptions.getEnvelopeDiskCache() instanceof io.sentry.transport.t)) {
            sentryAndroidOptions.setEnvelopeDiskCache(new io.sentry.android.core.cache.b(sentryAndroidOptions));
        }
        sentryAndroidOptions.addEventProcessor(new io.sentry.b1(sentryAndroidOptions));
        sentryAndroidOptions.addEventProcessor(new v0(context, s0Var, sentryAndroidOptions));
        sentryAndroidOptions.addEventProcessor(new f1(sentryAndroidOptions, f0Var));
        sentryAndroidOptions.addEventProcessor(new ScreenshotEventProcessor(sentryAndroidOptions, s0Var));
        sentryAndroidOptions.addEventProcessor(new ViewHierarchyEventProcessor(sentryAndroidOptions));
        sentryAndroidOptions.addEventProcessor(new p0(context, sentryAndroidOptions, s0Var));
        sentryAndroidOptions.setTransportGate(new n0(context, sentryAndroidOptions.getLogger()));
        sentryAndroidOptions.setTransactionProfiler(new m0(context, sentryAndroidOptions, s0Var, new io.sentry.android.core.internal.util.t(context, sentryAndroidOptions, s0Var)));
        sentryAndroidOptions.setModulesLoader(new io.sentry.android.core.internal.modules.a(context, sentryAndroidOptions.getLogger()));
        sentryAndroidOptions.setDebugMetaLoader(new io.sentry.android.core.internal.debugmeta.a(context, sentryAndroidOptions.getLogger()));
        boolean zB = b1Var.b("androidx.core.view.ScrollingView", sentryAndroidOptions);
        boolean zB2 = b1Var.b("androidx.compose.ui.node.Owner", sentryAndroidOptions);
        if (sentryAndroidOptions.getGestureTargetLocators().isEmpty()) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(new io.sentry.android.core.internal.gestures.e(zB));
            if (zB2 && b1Var.b("io.sentry.compose.gestures.ComposeGestureTargetLocator", sentryAndroidOptions)) {
                arrayList.add(new ComposeGestureTargetLocator(sentryAndroidOptions.getLogger()));
            }
            sentryAndroidOptions.setGestureTargetLocators(arrayList);
        }
        if (sentryAndroidOptions.getViewHierarchyExporters().isEmpty() && zB2 && b1Var.b("io.sentry.compose.viewhierarchy.ComposeViewHierarchyExporter", sentryAndroidOptions)) {
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(new ComposeViewHierarchyExporter(sentryAndroidOptions.getLogger()));
            sentryAndroidOptions.setViewHierarchyExporters(arrayList2);
        }
        sentryAndroidOptions.setMainThreadChecker(io.sentry.android.core.internal.util.h.e());
        if (sentryAndroidOptions.getCollectors().isEmpty()) {
            sentryAndroidOptions.addCollector(new j0());
            sentryAndroidOptions.addCollector(new g0(sentryAndroidOptions.getLogger(), s0Var));
        }
        sentryAndroidOptions.setTransactionPerformanceCollector(new io.sentry.c1(sentryAndroidOptions));
        if (sentryAndroidOptions.getCacheDirPath() != null) {
            sentryAndroidOptions.addScopeObserver(new io.sentry.cache.t(sentryAndroidOptions));
            sentryAndroidOptions.addOptionsObserver(new io.sentry.cache.s(sentryAndroidOptions));
        }
    }

    static void d(Context context, final SentryAndroidOptions sentryAndroidOptions, s0 s0Var, b1 b1Var, f0 f0Var, boolean z, boolean z2) {
        io.sentry.util.o oVar = new io.sentry.util.o(new io.sentry.util.o.a() { // from class: io.sentry.android.core.s
            @Override // io.sentry.util.o.a
            public final Object a() {
                return Boolean.valueOf(io.sentry.android.core.cache.b.P(sentryAndroidOptions));
            }
        });
        sentryAndroidOptions.addIntegration(new SendCachedEnvelopeIntegration(new y3(new v3() { // from class: io.sentry.android.core.q
            @Override // io.sentry.v3
            public final String a() {
                return sentryAndroidOptions.getCacheDirPath();
            }
        }), oVar));
        sentryAndroidOptions.addIntegration(new NdkIntegration(e(s0Var) ? b1Var.c("io.sentry.android.ndk.SentryNdk", sentryAndroidOptions.getLogger()) : null));
        sentryAndroidOptions.addIntegration(EnvelopeFileObserverIntegration.b());
        sentryAndroidOptions.addIntegration(new SendCachedEnvelopeIntegration(new z3(new v3() { // from class: io.sentry.android.core.r
            @Override // io.sentry.v3
            public final String a() {
                return sentryAndroidOptions.getOutboxPath();
            }
        }), oVar));
        sentryAndroidOptions.addIntegration(new AppLifecycleIntegration());
        sentryAndroidOptions.addIntegration(o0.a(context, s0Var));
        if (context instanceof Application) {
            Application application = (Application) context;
            sentryAndroidOptions.addIntegration(new ActivityLifecycleIntegration(application, s0Var, f0Var));
            sentryAndroidOptions.addIntegration(new CurrentActivityIntegration(application));
            sentryAndroidOptions.addIntegration(new UserInteractionIntegration(application, b1Var));
            if (z) {
                sentryAndroidOptions.addIntegration(new FragmentLifecycleIntegration(application, true, true));
            }
        } else {
            sentryAndroidOptions.getLogger().c(s4.WARNING, "ActivityLifecycle, FragmentLifecycle and UserInteraction Integrations need an Application class to be installed.", new Object[0]);
        }
        if (z2) {
            sentryAndroidOptions.addIntegration(new SentryTimberIntegration());
        }
        sentryAndroidOptions.addIntegration(new AppComponentsBreadcrumbsIntegration(context));
        sentryAndroidOptions.addIntegration(new SystemEventsBreadcrumbsIntegration(context));
        sentryAndroidOptions.addIntegration(new NetworkBreadcrumbsIntegration(context, s0Var, sentryAndroidOptions.getLogger()));
        sentryAndroidOptions.addIntegration(new TempSensorBreadcrumbsIntegration(context));
        sentryAndroidOptions.addIntegration(new PhoneStateBreadcrumbsIntegration(context));
    }

    private static boolean e(s0 s0Var) {
        return s0Var.d() >= 16;
    }

    static void i(SentryAndroidOptions sentryAndroidOptions, Context context, w1 w1Var, s0 s0Var) {
        io.sentry.util.q.c(context, "The context is required.");
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        io.sentry.util.q.c(sentryAndroidOptions, "The options object is required.");
        io.sentry.util.q.c(w1Var, "The ILogger object is required.");
        sentryAndroidOptions.setLogger(w1Var);
        sentryAndroidOptions.setDateProvider(new h1());
        d1.a(context, sentryAndroidOptions, s0Var);
        b(context, sentryAndroidOptions);
        j(sentryAndroidOptions, context, s0Var);
    }

    private static void j(SentryAndroidOptions sentryAndroidOptions, Context context, s0 s0Var) {
        PackageInfo packageInfoJ = t0.j(context, sentryAndroidOptions.getLogger(), s0Var);
        if (packageInfoJ != null) {
            if (sentryAndroidOptions.getRelease() == null) {
                sentryAndroidOptions.setRelease(a(packageInfoJ, t0.k(packageInfoJ, s0Var)));
            }
            String str = packageInfoJ.packageName;
            if (str != null && !str.startsWith("android.")) {
                sentryAndroidOptions.addInAppInclude(str);
            }
        }
        if (sentryAndroidOptions.getDistinctId() == null) {
            try {
                sentryAndroidOptions.setDistinctId(a1.a(context));
            } catch (RuntimeException e2) {
                sentryAndroidOptions.getLogger().b(s4.ERROR, "Could not generate distinct Id.", e2);
            }
        }
    }
}
