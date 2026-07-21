package io.sentry.android.core;

import io.sentry.l4;
import io.sentry.n1;
import io.sentry.x4;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: classes2.dex */
public final class SentryAndroidOptions extends x4 {
    private boolean attachScreenshot;
    private boolean attachViewHierarchy;
    private a beforeScreenshotCaptureCallback;
    private a beforeViewHierarchyCaptureCallback;
    private boolean anrEnabled = true;
    private long anrTimeoutIntervalMillis = 5000;
    private boolean anrReportInDebug = false;
    private boolean enableActivityLifecycleBreadcrumbs = true;
    private boolean enableAppLifecycleBreadcrumbs = true;
    private boolean enableSystemEventBreadcrumbs = true;
    private boolean enableAppComponentBreadcrumbs = true;
    private boolean enableNetworkEventBreadcrumbs = true;
    private boolean enableAutoActivityLifecycleTracing = true;
    private boolean enableActivityLifecycleTracingAutoFinish = true;
    private int profilingTracesHz = 101;
    private z0 debugImagesLoader = e1.a();
    private boolean collectAdditionalContext = true;
    private long startupCrashFlushTimeoutMillis = 5000;
    private final long startupCrashDurationThresholdMillis = 2000;
    private boolean enableFramesTracking = true;
    private String nativeSdkName = null;
    private boolean enableRootCheck = true;
    private boolean reportHistoricalAnrs = false;
    private boolean attachAnrThreadDump = false;

    public interface a {
        boolean a(l4 l4Var, n1 n1Var, boolean z);
    }

    public SentryAndroidOptions() {
        setSentryClientName("sentry.java.android/6.34.0");
        setSdkVersion(createSdkVersion());
        setAttachServerName(false);
        setEnableScopeSync(true);
    }

    private io.sentry.protocol.o createSdkVersion() {
        io.sentry.protocol.o oVarK = io.sentry.protocol.o.k(getSdkVersion(), "sentry.java.android", "6.34.0");
        oVarK.c("maven:io.sentry:sentry-android-core", "6.34.0");
        return oVarK;
    }

    public void enableAllAutoBreadcrumbs(boolean z) {
        this.enableActivityLifecycleBreadcrumbs = z;
        this.enableAppComponentBreadcrumbs = z;
        this.enableSystemEventBreadcrumbs = z;
        this.enableAppLifecycleBreadcrumbs = z;
        this.enableNetworkEventBreadcrumbs = z;
        setEnableUserInteractionBreadcrumbs(z);
    }

    public long getAnrTimeoutIntervalMillis() {
        return this.anrTimeoutIntervalMillis;
    }

    public a getBeforeScreenshotCaptureCallback() {
        return this.beforeScreenshotCaptureCallback;
    }

    public a getBeforeViewHierarchyCaptureCallback() {
        return this.beforeViewHierarchyCaptureCallback;
    }

    public z0 getDebugImagesLoader() {
        return this.debugImagesLoader;
    }

    @ApiStatus.Internal
    public String getNativeSdkName() {
        return this.nativeSdkName;
    }

    @ApiStatus.Internal
    public int getProfilingTracesHz() {
        return this.profilingTracesHz;
    }

    @Deprecated
    public int getProfilingTracesIntervalMillis() {
        return 0;
    }

    @ApiStatus.Internal
    public long getStartupCrashDurationThresholdMillis() {
        return 2000L;
    }

    @ApiStatus.Internal
    long getStartupCrashFlushTimeoutMillis() {
        return this.startupCrashFlushTimeoutMillis;
    }

    public boolean isAnrEnabled() {
        return this.anrEnabled;
    }

    public boolean isAnrReportInDebug() {
        return this.anrReportInDebug;
    }

    public boolean isAttachAnrThreadDump() {
        return this.attachAnrThreadDump;
    }

    public boolean isAttachScreenshot() {
        return this.attachScreenshot;
    }

    public boolean isAttachViewHierarchy() {
        return this.attachViewHierarchy;
    }

    public boolean isCollectAdditionalContext() {
        return this.collectAdditionalContext;
    }

    public boolean isEnableActivityLifecycleBreadcrumbs() {
        return this.enableActivityLifecycleBreadcrumbs;
    }

    public boolean isEnableActivityLifecycleTracingAutoFinish() {
        return this.enableActivityLifecycleTracingAutoFinish;
    }

    public boolean isEnableAppComponentBreadcrumbs() {
        return this.enableAppComponentBreadcrumbs;
    }

    public boolean isEnableAppLifecycleBreadcrumbs() {
        return this.enableAppLifecycleBreadcrumbs;
    }

    public boolean isEnableAutoActivityLifecycleTracing() {
        return this.enableAutoActivityLifecycleTracing;
    }

    public boolean isEnableFramesTracking() {
        return this.enableFramesTracking;
    }

    public boolean isEnableNetworkEventBreadcrumbs() {
        return this.enableNetworkEventBreadcrumbs;
    }

    public boolean isEnableRootCheck() {
        return this.enableRootCheck;
    }

    public boolean isEnableSystemEventBreadcrumbs() {
        return this.enableSystemEventBreadcrumbs;
    }

    public boolean isReportHistoricalAnrs() {
        return this.reportHistoricalAnrs;
    }

    public void setAnrEnabled(boolean z) {
        this.anrEnabled = z;
    }

    public void setAnrReportInDebug(boolean z) {
        this.anrReportInDebug = z;
    }

    public void setAnrTimeoutIntervalMillis(long j2) {
        this.anrTimeoutIntervalMillis = j2;
    }

    public void setAttachAnrThreadDump(boolean z) {
        this.attachAnrThreadDump = z;
    }

    public void setAttachScreenshot(boolean z) {
        this.attachScreenshot = z;
    }

    public void setAttachViewHierarchy(boolean z) {
        this.attachViewHierarchy = z;
    }

    public void setBeforeScreenshotCaptureCallback(a aVar) {
        this.beforeScreenshotCaptureCallback = aVar;
    }

    public void setBeforeViewHierarchyCaptureCallback(a aVar) {
        this.beforeViewHierarchyCaptureCallback = aVar;
    }

    public void setCollectAdditionalContext(boolean z) {
        this.collectAdditionalContext = z;
    }

    public void setDebugImagesLoader(z0 z0Var) {
        if (z0Var == null) {
            z0Var = e1.a();
        }
        this.debugImagesLoader = z0Var;
    }

    public void setEnableActivityLifecycleBreadcrumbs(boolean z) {
        this.enableActivityLifecycleBreadcrumbs = z;
    }

    public void setEnableActivityLifecycleTracingAutoFinish(boolean z) {
        this.enableActivityLifecycleTracingAutoFinish = z;
    }

    public void setEnableAppComponentBreadcrumbs(boolean z) {
        this.enableAppComponentBreadcrumbs = z;
    }

    public void setEnableAppLifecycleBreadcrumbs(boolean z) {
        this.enableAppLifecycleBreadcrumbs = z;
    }

    public void setEnableAutoActivityLifecycleTracing(boolean z) {
        this.enableAutoActivityLifecycleTracing = z;
    }

    public void setEnableFramesTracking(boolean z) {
        this.enableFramesTracking = z;
    }

    public void setEnableNetworkEventBreadcrumbs(boolean z) {
        this.enableNetworkEventBreadcrumbs = z;
    }

    public void setEnableRootCheck(boolean z) {
        this.enableRootCheck = z;
    }

    public void setEnableSystemEventBreadcrumbs(boolean z) {
        this.enableSystemEventBreadcrumbs = z;
    }

    @ApiStatus.Internal
    public void setNativeSdkName(String str) {
        this.nativeSdkName = str;
    }

    @ApiStatus.Internal
    public void setProfilingTracesHz(int i2) {
        this.profilingTracesHz = i2;
    }

    @Deprecated
    public void setProfilingTracesIntervalMillis(int i2) {
    }

    public void setReportHistoricalAnrs(boolean z) {
        this.reportHistoricalAnrs = z;
    }

    void setStartupCrashFlushTimeoutMillis(long j2) {
        this.startupCrashFlushTimeoutMillis = j2;
    }
}
