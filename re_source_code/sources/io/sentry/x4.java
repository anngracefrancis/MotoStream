package io.sentry;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: SentryOptions.java */
/* JADX INFO: loaded from: classes.dex */
public class x4 {
    static final s4 DEFAULT_DIAGNOSTIC_LEVEL = s4.DEBUG;
    private static final String DEFAULT_ENVIRONMENT = "production";

    @ApiStatus.Internal
    public static final String DEFAULT_PROPAGATION_TARGETS = ".*";
    private boolean attachServerName;
    private boolean attachStacktrace;
    private boolean attachThreads;
    private a beforeBreadcrumb;
    private b beforeSend;
    private c beforeSendTransaction;
    private final Set<String> bundleIds;
    private String cacheDirPath;
    io.sentry.clientreport.g clientReportRecorder;
    private final List<r1> collectors;
    private int connectionTimeoutMillis;
    private final List<String> contextTags;

    @ApiStatus.Internal
    private g4 dateProvider;
    private boolean debug;
    private io.sentry.internal.debugmeta.a debugMetaLoader;
    private final List<String> defaultTracePropagationTargets;
    private s4 diagnosticLevel;
    private String dist;
    private String distinctId;
    private String dsn;
    private String dsnHash;
    private boolean enableAutoSessionTracking;
    private boolean enableDeduplication;
    private boolean enableExternalConfiguration;
    private boolean enableNdk;
    private boolean enablePrettySerializationOutput;
    private boolean enableScopeSync;
    private boolean enableShutdownHook;
    private boolean enableTimeToFullDisplayTracing;
    private Boolean enableTracing;
    private boolean enableUncaughtExceptionHandler;
    private boolean enableUserInteractionBreadcrumbs;
    private boolean enableUserInteractionTracing;
    private boolean enabled;
    private io.sentry.cache.r envelopeDiskCache;
    private s1 envelopeReader;
    private String environment;
    private final List<k1> eventProcessors;
    private b2 executorService;
    private long flushTimeoutMillis;
    private final m1 fullyDisplayedReporter;
    private final List<io.sentry.internal.gestures.a> gestureTargetLocators;
    private HostnameVerifier hostnameVerifier;
    private Long idleTimeout;

    @ApiStatus.Experimental
    private List<String> ignoredCheckIns;
    private final Set<Class<? extends Throwable>> ignoredExceptionsForType;
    private final List<String> inAppExcludes;
    private final List<String> inAppIncludes;
    private h2 instrumenter;
    private final List<Integration> integrations;
    private w1 logger;
    private io.sentry.util.thread.b mainThreadChecker;
    private long maxAttachmentSize;
    private int maxBreadcrumbs;
    private int maxCacheItems;
    private int maxDepth;
    private int maxQueueSize;
    private f maxRequestBodySize;
    private int maxSpans;
    private long maxTraceFileSize;
    private io.sentry.internal.modules.b modulesLoader;
    private final List<z1> observers;
    private final List<x1> optionsObservers;
    private boolean printUncaughtStackTrace;
    private Double profilesSampleRate;
    private d profilesSampler;
    private String proguardUuid;
    private e proxy;
    private int readTimeoutMillis;
    private String release;
    private Double sampleRate;
    private io.sentry.protocol.o sdkVersion;
    private boolean sendClientReports;
    private boolean sendDefaultPii;
    private boolean sendModules;
    private String sentryClientName;
    private c2 serializer;
    private String serverName;
    private long sessionTrackingIntervalMillis;
    private long shutdownTimeoutMillis;
    private SSLSocketFactory sslSocketFactory;
    private final Map<String, String> tags;
    private boolean traceOptionsRequests;
    private List<String> tracePropagationTargets;
    private boolean traceSampling;
    private Double tracesSampleRate;
    private g tracesSampler;
    private u5 transactionPerformanceCollector;
    private f2 transactionProfiler;
    private g2 transportFactory;
    private io.sentry.transport.s transportGate;
    private final List<io.sentry.internal.viewhierarchy.a> viewHierarchyExporters;

    /* JADX INFO: compiled from: SentryOptions.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface a {
        v0 a(v0 v0Var, n1 n1Var);
    }

    /* JADX INFO: compiled from: SentryOptions.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface b {
        l4 a(l4 l4Var, n1 n1Var);
    }

    /* JADX INFO: compiled from: SentryOptions.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface c {
        io.sentry.protocol.x a(io.sentry.protocol.x xVar, n1 n1Var);
    }

    /* JADX INFO: compiled from: SentryOptions.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface d {
        Double a(r3 r3Var);
    }

    /* JADX INFO: compiled from: SentryOptions.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class e {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f22816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f22817c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f22818d;

        public e(String str, String str2, String str3, String str4) {
            this.a = str;
            this.f22816b = str2;
            this.f22817c = str3;
            this.f22818d = str4;
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.f22818d;
        }

        public String c() {
            return this.f22816b;
        }

        public String d() {
            return this.f22817c;
        }
    }

    /* JADX INFO: compiled from: SentryOptions.java */
    /* JADX INFO: loaded from: classes2.dex */
    public enum f {
        NONE,
        SMALL,
        MEDIUM,
        ALWAYS
    }

    /* JADX INFO: compiled from: SentryOptions.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface g {
        Double a(r3 r3Var);
    }

    public x4() {
        this(false);
    }

    private void addPackageInfo() {
        q4.c().b("maven:io.sentry:sentry", "6.34.0");
    }

    private io.sentry.protocol.o createSdkVersion() {
        io.sentry.protocol.o oVar = new io.sentry.protocol.o("sentry.java", "6.34.0");
        oVar.j("6.34.0");
        return oVar;
    }

    static x4 empty() {
        return new x4(true);
    }

    public void addBundleId(String str) {
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            this.bundleIds.add(strTrim);
        }
    }

    @ApiStatus.Internal
    public void addCollector(r1 r1Var) {
        this.collectors.add(r1Var);
    }

    public void addContextTag(String str) {
        this.contextTags.add(str);
    }

    public void addEventProcessor(k1 k1Var) {
        this.eventProcessors.add(k1Var);
    }

    public void addIgnoredExceptionForType(Class<? extends Throwable> cls) {
        this.ignoredExceptionsForType.add(cls);
    }

    public void addInAppExclude(String str) {
        this.inAppExcludes.add(str);
    }

    public void addInAppInclude(String str) {
        this.inAppIncludes.add(str);
    }

    public void addIntegration(Integration integration) {
        this.integrations.add(integration);
    }

    public void addOptionsObserver(x1 x1Var) {
        this.optionsObservers.add(x1Var);
    }

    public void addScopeObserver(z1 z1Var) {
        this.observers.add(z1Var);
    }

    @Deprecated
    public void addTracingOrigin(String str) {
        if (this.tracePropagationTargets == null) {
            this.tracePropagationTargets = new CopyOnWriteArrayList();
        }
        if (str.isEmpty()) {
            return;
        }
        this.tracePropagationTargets.add(str);
    }

    boolean containsIgnoredExceptionForType(Throwable th) {
        return this.ignoredExceptionsForType.contains(th.getClass());
    }

    public a getBeforeBreadcrumb() {
        return this.beforeBreadcrumb;
    }

    public b getBeforeSend() {
        return this.beforeSend;
    }

    public c getBeforeSendTransaction() {
        return this.beforeSendTransaction;
    }

    public Set<String> getBundleIds() {
        return this.bundleIds;
    }

    public String getCacheDirPath() {
        String str = this.cacheDirPath;
        if (str == null || str.isEmpty()) {
            return null;
        }
        return this.dsnHash != null ? new File(this.cacheDirPath, this.dsnHash).getAbsolutePath() : this.cacheDirPath;
    }

    @ApiStatus.Internal
    public io.sentry.clientreport.g getClientReportRecorder() {
        return this.clientReportRecorder;
    }

    @ApiStatus.Internal
    public List<r1> getCollectors() {
        return this.collectors;
    }

    public int getConnectionTimeoutMillis() {
        return this.connectionTimeoutMillis;
    }

    public List<String> getContextTags() {
        return this.contextTags;
    }

    @ApiStatus.Internal
    public g4 getDateProvider() {
        return this.dateProvider;
    }

    @ApiStatus.Internal
    public io.sentry.internal.debugmeta.a getDebugMetaLoader() {
        return this.debugMetaLoader;
    }

    public s4 getDiagnosticLevel() {
        return this.diagnosticLevel;
    }

    public String getDist() {
        return this.dist;
    }

    @ApiStatus.Internal
    public String getDistinctId() {
        return this.distinctId;
    }

    public String getDsn() {
        return this.dsn;
    }

    public Boolean getEnableTracing() {
        return this.enableTracing;
    }

    public io.sentry.cache.r getEnvelopeDiskCache() {
        return this.envelopeDiskCache;
    }

    public s1 getEnvelopeReader() {
        return this.envelopeReader;
    }

    public String getEnvironment() {
        String str = this.environment;
        return str != null ? str : DEFAULT_ENVIRONMENT;
    }

    public List<k1> getEventProcessors() {
        return this.eventProcessors;
    }

    @ApiStatus.Internal
    public b2 getExecutorService() {
        return this.executorService;
    }

    public long getFlushTimeoutMillis() {
        return this.flushTimeoutMillis;
    }

    @ApiStatus.Internal
    public m1 getFullyDisplayedReporter() {
        return this.fullyDisplayedReporter;
    }

    public List<io.sentry.internal.gestures.a> getGestureTargetLocators() {
        return this.gestureTargetLocators;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public Long getIdleTimeout() {
        return this.idleTimeout;
    }

    @ApiStatus.Experimental
    public List<String> getIgnoredCheckIns() {
        return this.ignoredCheckIns;
    }

    public Set<Class<? extends Throwable>> getIgnoredExceptionsForType() {
        return this.ignoredExceptionsForType;
    }

    public List<String> getInAppExcludes() {
        return this.inAppExcludes;
    }

    public List<String> getInAppIncludes() {
        return this.inAppIncludes;
    }

    public h2 getInstrumenter() {
        return this.instrumenter;
    }

    public List<Integration> getIntegrations() {
        return this.integrations;
    }

    public w1 getLogger() {
        return this.logger;
    }

    public io.sentry.util.thread.b getMainThreadChecker() {
        return this.mainThreadChecker;
    }

    public long getMaxAttachmentSize() {
        return this.maxAttachmentSize;
    }

    public int getMaxBreadcrumbs() {
        return this.maxBreadcrumbs;
    }

    public int getMaxCacheItems() {
        return this.maxCacheItems;
    }

    public int getMaxDepth() {
        return this.maxDepth;
    }

    public int getMaxQueueSize() {
        return this.maxQueueSize;
    }

    public f getMaxRequestBodySize() {
        return this.maxRequestBodySize;
    }

    @ApiStatus.Experimental
    public int getMaxSpans() {
        return this.maxSpans;
    }

    public long getMaxTraceFileSize() {
        return this.maxTraceFileSize;
    }

    @ApiStatus.Internal
    public io.sentry.internal.modules.b getModulesLoader() {
        return this.modulesLoader;
    }

    public List<x1> getOptionsObservers() {
        return this.optionsObservers;
    }

    public String getOutboxPath() {
        String cacheDirPath = getCacheDirPath();
        if (cacheDirPath == null) {
            return null;
        }
        return new File(cacheDirPath, "outbox").getAbsolutePath();
    }

    public Double getProfilesSampleRate() {
        return this.profilesSampleRate;
    }

    public d getProfilesSampler() {
        return this.profilesSampler;
    }

    public String getProfilingTracesDirPath() {
        String cacheDirPath = getCacheDirPath();
        if (cacheDirPath == null) {
            return null;
        }
        return new File(cacheDirPath, "profiling_traces").getAbsolutePath();
    }

    public String getProguardUuid() {
        return this.proguardUuid;
    }

    public e getProxy() {
        return this.proxy;
    }

    public int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public String getRelease() {
        return this.release;
    }

    public Double getSampleRate() {
        return this.sampleRate;
    }

    public List<z1> getScopeObservers() {
        return this.observers;
    }

    public io.sentry.protocol.o getSdkVersion() {
        return this.sdkVersion;
    }

    public String getSentryClientName() {
        return this.sentryClientName;
    }

    public c2 getSerializer() {
        return this.serializer;
    }

    public String getServerName() {
        return this.serverName;
    }

    public long getSessionTrackingIntervalMillis() {
        return this.sessionTrackingIntervalMillis;
    }

    @ApiStatus.ScheduledForRemoval
    @Deprecated
    public long getShutdownTimeout() {
        return this.shutdownTimeoutMillis;
    }

    public long getShutdownTimeoutMillis() {
        return this.shutdownTimeoutMillis;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public List<String> getTracePropagationTargets() {
        List<String> list = this.tracePropagationTargets;
        return list == null ? this.defaultTracePropagationTargets : list;
    }

    public Double getTracesSampleRate() {
        return this.tracesSampleRate;
    }

    public g getTracesSampler() {
        return this.tracesSampler;
    }

    @Deprecated
    public List<String> getTracingOrigins() {
        return getTracePropagationTargets();
    }

    @ApiStatus.Internal
    public u5 getTransactionPerformanceCollector() {
        return this.transactionPerformanceCollector;
    }

    public f2 getTransactionProfiler() {
        return this.transactionProfiler;
    }

    public g2 getTransportFactory() {
        return this.transportFactory;
    }

    public io.sentry.transport.s getTransportGate() {
        return this.transportGate;
    }

    public final List<io.sentry.internal.viewhierarchy.a> getViewHierarchyExporters() {
        return this.viewHierarchyExporters;
    }

    public boolean isAttachServerName() {
        return this.attachServerName;
    }

    public boolean isAttachStacktrace() {
        return this.attachStacktrace;
    }

    public boolean isAttachThreads() {
        return this.attachThreads;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public boolean isEnableAutoSessionTracking() {
        return this.enableAutoSessionTracking;
    }

    public boolean isEnableDeduplication() {
        return this.enableDeduplication;
    }

    public boolean isEnableExternalConfiguration() {
        return this.enableExternalConfiguration;
    }

    public boolean isEnableNdk() {
        return this.enableNdk;
    }

    public boolean isEnablePrettySerializationOutput() {
        return this.enablePrettySerializationOutput;
    }

    public boolean isEnableScopeSync() {
        return this.enableScopeSync;
    }

    public boolean isEnableShutdownHook() {
        return this.enableShutdownHook;
    }

    public boolean isEnableTimeToFullDisplayTracing() {
        return this.enableTimeToFullDisplayTracing;
    }

    public boolean isEnableUncaughtExceptionHandler() {
        return this.enableUncaughtExceptionHandler;
    }

    public boolean isEnableUserInteractionBreadcrumbs() {
        return this.enableUserInteractionBreadcrumbs;
    }

    public boolean isEnableUserInteractionTracing() {
        return this.enableUserInteractionTracing;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isPrintUncaughtStackTrace() {
        return this.printUncaughtStackTrace;
    }

    public boolean isProfilingEnabled() {
        return (getProfilesSampleRate() != null && getProfilesSampleRate().doubleValue() > 0.0d) || getProfilesSampler() != null;
    }

    public boolean isSendClientReports() {
        return this.sendClientReports;
    }

    public boolean isSendDefaultPii() {
        return this.sendDefaultPii;
    }

    public boolean isSendModules() {
        return this.sendModules;
    }

    public boolean isTraceOptionsRequests() {
        return this.traceOptionsRequests;
    }

    @ApiStatus.Experimental
    public boolean isTraceSampling() {
        return this.traceSampling;
    }

    public boolean isTracingEnabled() {
        Boolean bool = this.enableTracing;
        if (bool != null) {
            return bool.booleanValue();
        }
        return (getTracesSampleRate() == null && getTracesSampler() == null) ? false : true;
    }

    public void merge(l1 l1Var) {
        if (l1Var.l() != null) {
            setDsn(l1Var.l());
        }
        if (l1Var.p() != null) {
            setEnvironment(l1Var.p());
        }
        if (l1Var.z() != null) {
            setRelease(l1Var.z());
        }
        if (l1Var.k() != null) {
            setDist(l1Var.k());
        }
        if (l1Var.B() != null) {
            setServerName(l1Var.B());
        }
        if (l1Var.y() != null) {
            setProxy(l1Var.y());
        }
        if (l1Var.o() != null) {
            setEnableUncaughtExceptionHandler(l1Var.o().booleanValue());
        }
        if (l1Var.v() != null) {
            setPrintUncaughtStackTrace(l1Var.v().booleanValue());
        }
        if (l1Var.n() != null) {
            setEnableTracing(l1Var.n());
        }
        if (l1Var.E() != null) {
            setTracesSampleRate(l1Var.E());
        }
        if (l1Var.w() != null) {
            setProfilesSampleRate(l1Var.w());
        }
        if (l1Var.j() != null) {
            setDebug(l1Var.j().booleanValue());
        }
        if (l1Var.m() != null) {
            setEnableDeduplication(l1Var.m().booleanValue());
        }
        if (l1Var.A() != null) {
            setSendClientReports(l1Var.A().booleanValue());
        }
        for (Map.Entry entry : new HashMap(l1Var.C()).entrySet()) {
            this.tags.put((String) entry.getKey(), (String) entry.getValue());
        }
        Iterator it = new ArrayList(l1Var.u()).iterator();
        while (it.hasNext()) {
            addInAppInclude((String) it.next());
        }
        Iterator it2 = new ArrayList(l1Var.t()).iterator();
        while (it2.hasNext()) {
            addInAppExclude((String) it2.next());
        }
        Iterator it3 = new HashSet(l1Var.s()).iterator();
        while (it3.hasNext()) {
            addIgnoredExceptionForType((Class) it3.next());
        }
        if (l1Var.D() != null) {
            setTracePropagationTargets(new ArrayList(l1Var.D()));
        }
        Iterator it4 = new ArrayList(l1Var.i()).iterator();
        while (it4.hasNext()) {
            addContextTag((String) it4.next());
        }
        if (l1Var.x() != null) {
            setProguardUuid(l1Var.x());
        }
        if (l1Var.q() != null) {
            setIdleTimeout(l1Var.q());
        }
        Iterator<String> it5 = l1Var.h().iterator();
        while (it5.hasNext()) {
            addBundleId(it5.next());
        }
        if (l1Var.G() != null) {
            setEnabled(l1Var.G().booleanValue());
        }
        if (l1Var.F() != null) {
            setEnablePrettySerializationOutput(l1Var.F().booleanValue());
        }
        if (l1Var.H() != null) {
            setSendModules(l1Var.H().booleanValue());
        }
        if (l1Var.r() != null) {
            setIgnoredCheckIns(new ArrayList(l1Var.r()));
        }
    }

    public void setAttachServerName(boolean z) {
        this.attachServerName = z;
    }

    public void setAttachStacktrace(boolean z) {
        this.attachStacktrace = z;
    }

    public void setAttachThreads(boolean z) {
        this.attachThreads = z;
    }

    public void setBeforeBreadcrumb(a aVar) {
        this.beforeBreadcrumb = aVar;
    }

    public void setBeforeSend(b bVar) {
        this.beforeSend = bVar;
    }

    public void setBeforeSendTransaction(c cVar) {
        this.beforeSendTransaction = cVar;
    }

    public void setCacheDirPath(String str) {
        this.cacheDirPath = str;
    }

    public void setConnectionTimeoutMillis(int i2) {
        this.connectionTimeoutMillis = i2;
    }

    @ApiStatus.Internal
    public void setDateProvider(g4 g4Var) {
        this.dateProvider = g4Var;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    @ApiStatus.Internal
    public void setDebugMetaLoader(io.sentry.internal.debugmeta.a aVar) {
        if (aVar == null) {
            aVar = io.sentry.internal.debugmeta.b.b();
        }
        this.debugMetaLoader = aVar;
    }

    public void setDiagnosticLevel(s4 s4Var) {
        if (s4Var == null) {
            s4Var = DEFAULT_DIAGNOSTIC_LEVEL;
        }
        this.diagnosticLevel = s4Var;
    }

    public void setDist(String str) {
        this.dist = str;
    }

    @ApiStatus.Internal
    public void setDistinctId(String str) {
        this.distinctId = str;
    }

    public void setDsn(String str) {
        this.dsn = str;
        this.dsnHash = io.sentry.util.u.a(str, this.logger);
    }

    public void setEnableAutoSessionTracking(boolean z) {
        this.enableAutoSessionTracking = z;
    }

    public void setEnableDeduplication(boolean z) {
        this.enableDeduplication = z;
    }

    public void setEnableExternalConfiguration(boolean z) {
        this.enableExternalConfiguration = z;
    }

    public void setEnableNdk(boolean z) {
        this.enableNdk = z;
    }

    public void setEnablePrettySerializationOutput(boolean z) {
        this.enablePrettySerializationOutput = z;
    }

    public void setEnableScopeSync(boolean z) {
        this.enableScopeSync = z;
    }

    public void setEnableShutdownHook(boolean z) {
        this.enableShutdownHook = z;
    }

    public void setEnableTimeToFullDisplayTracing(boolean z) {
        this.enableTimeToFullDisplayTracing = z;
    }

    public void setEnableTracing(Boolean bool) {
        this.enableTracing = bool;
    }

    public void setEnableUncaughtExceptionHandler(boolean z) {
        this.enableUncaughtExceptionHandler = z;
    }

    public void setEnableUserInteractionBreadcrumbs(boolean z) {
        this.enableUserInteractionBreadcrumbs = z;
    }

    public void setEnableUserInteractionTracing(boolean z) {
        this.enableUserInteractionTracing = z;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void setEnvelopeDiskCache(io.sentry.cache.r rVar) {
        if (rVar == null) {
            rVar = io.sentry.transport.t.c();
        }
        this.envelopeDiskCache = rVar;
    }

    public void setEnvelopeReader(s1 s1Var) {
        if (s1Var == null) {
            s1Var = x2.b();
        }
        this.envelopeReader = s1Var;
    }

    public void setEnvironment(String str) {
        this.environment = str;
    }

    @ApiStatus.Internal
    public void setExecutorService(b2 b2Var) {
        if (b2Var != null) {
            this.executorService = b2Var;
        }
    }

    public void setFlushTimeoutMillis(long j2) {
        this.flushTimeoutMillis = j2;
    }

    public void setGestureTargetLocators(List<io.sentry.internal.gestures.a> list) {
        this.gestureTargetLocators.clear();
        this.gestureTargetLocators.addAll(list);
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.hostnameVerifier = hostnameVerifier;
    }

    public void setIdleTimeout(Long l) {
        this.idleTimeout = l;
    }

    @ApiStatus.Experimental
    public void setIgnoredCheckIns(List<String> list) {
        if (list == null) {
            this.ignoredCheckIns = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!str.isEmpty()) {
                arrayList.add(str);
            }
        }
        this.ignoredCheckIns = arrayList;
    }

    public void setInstrumenter(h2 h2Var) {
        this.instrumenter = h2Var;
    }

    public void setLogger(w1 w1Var) {
        this.logger = w1Var == null ? z2.e() : new d1(this, w1Var);
    }

    public void setMainThreadChecker(io.sentry.util.thread.b bVar) {
        this.mainThreadChecker = bVar;
    }

    public void setMaxAttachmentSize(long j2) {
        this.maxAttachmentSize = j2;
    }

    public void setMaxBreadcrumbs(int i2) {
        this.maxBreadcrumbs = i2;
    }

    public void setMaxCacheItems(int i2) {
        this.maxCacheItems = i2;
    }

    public void setMaxDepth(int i2) {
        this.maxDepth = i2;
    }

    public void setMaxQueueSize(int i2) {
        if (i2 > 0) {
            this.maxQueueSize = i2;
        }
    }

    public void setMaxRequestBodySize(f fVar) {
        this.maxRequestBodySize = fVar;
    }

    @ApiStatus.Experimental
    public void setMaxSpans(int i2) {
        this.maxSpans = i2;
    }

    public void setMaxTraceFileSize(long j2) {
        this.maxTraceFileSize = j2;
    }

    @ApiStatus.Internal
    public void setModulesLoader(io.sentry.internal.modules.b bVar) {
        if (bVar == null) {
            bVar = io.sentry.internal.modules.e.b();
        }
        this.modulesLoader = bVar;
    }

    public void setPrintUncaughtStackTrace(boolean z) {
        this.printUncaughtStackTrace = z;
    }

    public void setProfilesSampleRate(Double d2) {
        if (io.sentry.util.t.a(d2)) {
            this.profilesSampleRate = d2;
            return;
        }
        throw new IllegalArgumentException("The value " + d2 + " is not valid. Use null to disable or values between 0.0 and 1.0.");
    }

    public void setProfilesSampler(d dVar) {
        this.profilesSampler = dVar;
    }

    @Deprecated
    public void setProfilingEnabled(boolean z) {
        if (getProfilesSampleRate() == null) {
            setProfilesSampleRate(z ? Double.valueOf(1.0d) : null);
        }
    }

    public void setProguardUuid(String str) {
        this.proguardUuid = str;
    }

    public void setProxy(e eVar) {
        this.proxy = eVar;
    }

    public void setReadTimeoutMillis(int i2) {
        this.readTimeoutMillis = i2;
    }

    public void setRelease(String str) {
        this.release = str;
    }

    public void setSampleRate(Double d2) {
        if (io.sentry.util.t.c(d2)) {
            this.sampleRate = d2;
            return;
        }
        throw new IllegalArgumentException("The value " + d2 + " is not valid. Use null to disable or values >= 0.0 and <= 1.0.");
    }

    @ApiStatus.Internal
    public void setSdkVersion(io.sentry.protocol.o oVar) {
        this.sdkVersion = oVar;
    }

    public void setSendClientReports(boolean z) {
        this.sendClientReports = z;
        if (z) {
            this.clientReportRecorder = new io.sentry.clientreport.d(this);
        } else {
            this.clientReportRecorder = new io.sentry.clientreport.i();
        }
    }

    public void setSendDefaultPii(boolean z) {
        this.sendDefaultPii = z;
    }

    public void setSendModules(boolean z) {
        this.sendModules = z;
    }

    public void setSentryClientName(String str) {
        this.sentryClientName = str;
    }

    public void setSerializer(c2 c2Var) {
        if (c2Var == null) {
            c2Var = b3.g();
        }
        this.serializer = c2Var;
    }

    public void setServerName(String str) {
        this.serverName = str;
    }

    public void setSessionTrackingIntervalMillis(long j2) {
        this.sessionTrackingIntervalMillis = j2;
    }

    @ApiStatus.ScheduledForRemoval
    @Deprecated
    public void setShutdownTimeout(long j2) {
        this.shutdownTimeoutMillis = j2;
    }

    public void setShutdownTimeoutMillis(long j2) {
        this.shutdownTimeoutMillis = j2;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
    }

    public void setTag(String str, String str2) {
        this.tags.put(str, str2);
    }

    public void setTraceOptionsRequests(boolean z) {
        this.traceOptionsRequests = z;
    }

    @ApiStatus.Internal
    public void setTracePropagationTargets(List<String> list) {
        if (list == null) {
            this.tracePropagationTargets = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!str.isEmpty()) {
                arrayList.add(str);
            }
        }
        this.tracePropagationTargets = arrayList;
    }

    @Deprecated
    public void setTraceSampling(boolean z) {
        this.traceSampling = z;
    }

    public void setTracesSampleRate(Double d2) {
        if (io.sentry.util.t.d(d2)) {
            this.tracesSampleRate = d2;
            return;
        }
        throw new IllegalArgumentException("The value " + d2 + " is not valid. Use null to disable or values between 0.0 and 1.0.");
    }

    public void setTracesSampler(g gVar) {
        this.tracesSampler = gVar;
    }

    @ApiStatus.Internal
    @Deprecated
    public void setTracingOrigins(List<String> list) {
        setTracePropagationTargets(list);
    }

    @ApiStatus.Internal
    public void setTransactionPerformanceCollector(u5 u5Var) {
        this.transactionPerformanceCollector = u5Var;
    }

    public void setTransactionProfiler(f2 f2Var) {
        if (f2Var == null) {
            f2Var = f3.c();
        }
        this.transactionProfiler = f2Var;
    }

    public void setTransportFactory(g2 g2Var) {
        if (g2Var == null) {
            g2Var = g3.b();
        }
        this.transportFactory = g2Var;
    }

    public void setTransportGate(io.sentry.transport.s sVar) {
        if (sVar == null) {
            sVar = io.sentry.transport.v.a();
        }
        this.transportGate = sVar;
    }

    public void setViewHierarchyExporters(List<io.sentry.internal.viewhierarchy.a> list) {
        this.viewHierarchyExporters.clear();
        this.viewHierarchyExporters.addAll(list);
    }

    private x4(boolean z) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.eventProcessors = copyOnWriteArrayList;
        this.ignoredExceptionsForType = new CopyOnWriteArraySet();
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        this.integrations = copyOnWriteArrayList2;
        this.bundleIds = new CopyOnWriteArraySet();
        this.shutdownTimeoutMillis = 2000L;
        this.flushTimeoutMillis = 15000L;
        this.enableNdk = true;
        this.logger = z2.e();
        this.diagnosticLevel = DEFAULT_DIAGNOSTIC_LEVEL;
        this.envelopeReader = new h1(new s2(this));
        this.serializer = new s2(this);
        this.maxDepth = 100;
        this.maxCacheItems = 30;
        this.maxQueueSize = 30;
        this.maxBreadcrumbs = 100;
        this.inAppExcludes = new CopyOnWriteArrayList();
        this.inAppIncludes = new CopyOnWriteArrayList();
        this.transportFactory = g3.b();
        this.transportGate = io.sentry.transport.v.a();
        this.attachStacktrace = true;
        this.enableAutoSessionTracking = true;
        this.sessionTrackingIntervalMillis = 30000L;
        this.attachServerName = true;
        this.enableUncaughtExceptionHandler = true;
        this.printUncaughtStackTrace = false;
        this.executorService = a3.c();
        this.connectionTimeoutMillis = 5000;
        this.readTimeoutMillis = 5000;
        this.envelopeDiskCache = io.sentry.transport.t.c();
        this.sendDefaultPii = false;
        this.observers = new CopyOnWriteArrayList();
        this.optionsObservers = new CopyOnWriteArrayList();
        this.tags = new ConcurrentHashMap();
        this.maxAttachmentSize = 20971520L;
        this.enableDeduplication = true;
        this.maxSpans = 1000;
        this.enableShutdownHook = true;
        this.maxRequestBodySize = f.NONE;
        this.traceSampling = true;
        this.maxTraceFileSize = 5242880L;
        this.transactionProfiler = f3.c();
        this.tracePropagationTargets = null;
        this.defaultTracePropagationTargets = Collections.singletonList(DEFAULT_PROPAGATION_TARGETS);
        this.idleTimeout = 3000L;
        this.contextTags = new CopyOnWriteArrayList();
        this.sendClientReports = true;
        this.clientReportRecorder = new io.sentry.clientreport.d(this);
        this.modulesLoader = io.sentry.internal.modules.e.b();
        this.debugMetaLoader = io.sentry.internal.debugmeta.b.b();
        this.enableUserInteractionTracing = false;
        this.enableUserInteractionBreadcrumbs = true;
        this.instrumenter = h2.SENTRY;
        this.gestureTargetLocators = new ArrayList();
        this.viewHierarchyExporters = new ArrayList();
        this.mainThreadChecker = io.sentry.util.thread.d.e();
        this.traceOptionsRequests = true;
        this.dateProvider = new b4();
        this.collectors = new ArrayList();
        this.transactionPerformanceCollector = e3.c();
        this.enableTimeToFullDisplayTracing = false;
        this.fullyDisplayedReporter = m1.a();
        this.enabled = true;
        this.enablePrettySerializationOutput = true;
        this.sendModules = true;
        this.ignoredCheckIns = null;
        if (z) {
            return;
        }
        this.executorService = new n4();
        copyOnWriteArrayList2.add(new UncaughtExceptionHandlerIntegration());
        copyOnWriteArrayList2.add(new ShutdownHookIntegration());
        copyOnWriteArrayList.add(new t2(this));
        copyOnWriteArrayList.add(new g1(this));
        if (io.sentry.util.s.b()) {
            copyOnWriteArrayList.add(new y4());
        }
        setSentryClientName("sentry.java/6.34.0");
        setSdkVersion(createSdkVersion());
        addPackageInfo();
    }
}
