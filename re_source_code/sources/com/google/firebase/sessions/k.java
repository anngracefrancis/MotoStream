package com.google.firebase.sessions;

import cm.aptoide.pt.database.room.RoomInstalled;
import java.io.IOException;

/* JADX INFO: compiled from: AutoSessionEventEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements com.google.firebase.encoders.g.a {
    public static final com.google.firebase.encoders.g.a a = new k();

    /* JADX INFO: compiled from: AutoSessionEventEncoder.java */
    private static final class a implements com.google.firebase.encoders.c<AndroidApplicationInfo> {
        static final a a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19968b = com.google.firebase.encoders.b.d("packageName");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19969c = com.google.firebase.encoders.b.d(RoomInstalled.VERSION_NAME);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19970d = com.google.firebase.encoders.b.d("appBuildVersion");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19971e = com.google.firebase.encoders.b.d("deviceManufacturer");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19972f = com.google.firebase.encoders.b.d("currentProcessDetails");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19973g = com.google.firebase.encoders.b.d("appProcessDetails");

        private a() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AndroidApplicationInfo androidApplicationInfo, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19968b, androidApplicationInfo.getPackageName());
            dVar.i(f19969c, androidApplicationInfo.getVersionName());
            dVar.i(f19970d, androidApplicationInfo.getAppBuildVersion());
            dVar.i(f19971e, androidApplicationInfo.getDeviceManufacturer());
            dVar.i(f19972f, androidApplicationInfo.getCurrentProcessDetails());
            dVar.i(f19973g, androidApplicationInfo.b());
        }
    }

    /* JADX INFO: compiled from: AutoSessionEventEncoder.java */
    private static final class b implements com.google.firebase.encoders.c<ApplicationInfo> {
        static final b a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19974b = com.google.firebase.encoders.b.d("appId");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19975c = com.google.firebase.encoders.b.d("deviceModel");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19976d = com.google.firebase.encoders.b.d("sessionSdkVersion");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19977e = com.google.firebase.encoders.b.d("osVersion");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19978f = com.google.firebase.encoders.b.d("logEnvironment");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19979g = com.google.firebase.encoders.b.d("androidAppInfo");

        private b() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ApplicationInfo applicationInfo, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19974b, applicationInfo.getAppId());
            dVar.i(f19975c, applicationInfo.getDeviceModel());
            dVar.i(f19976d, applicationInfo.getSessionSdkVersion());
            dVar.i(f19977e, applicationInfo.getOsVersion());
            dVar.i(f19978f, applicationInfo.getLogEnvironment());
            dVar.i(f19979g, applicationInfo.getAndroidAppInfo());
        }
    }

    /* JADX INFO: compiled from: AutoSessionEventEncoder.java */
    private static final class c implements com.google.firebase.encoders.c<DataCollectionStatus> {
        static final c a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19980b = com.google.firebase.encoders.b.d("performance");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19981c = com.google.firebase.encoders.b.d("crashlytics");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19982d = com.google.firebase.encoders.b.d("sessionSamplingRate");

        private c() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(DataCollectionStatus dataCollectionStatus, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19980b, dataCollectionStatus.getPerformance());
            dVar.i(f19981c, dataCollectionStatus.getCrashlytics());
            dVar.d(f19982d, dataCollectionStatus.getSessionSamplingRate());
        }
    }

    /* JADX INFO: compiled from: AutoSessionEventEncoder.java */
    private static final class d implements com.google.firebase.encoders.c<ProcessDetails> {
        static final d a = new d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19983b = com.google.firebase.encoders.b.d("processName");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19984c = com.google.firebase.encoders.b.d("pid");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19985d = com.google.firebase.encoders.b.d("importance");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19986e = com.google.firebase.encoders.b.d("defaultProcess");

        private d() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ProcessDetails processDetails, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19983b, processDetails.getProcessName());
            dVar.c(f19984c, processDetails.getPid());
            dVar.c(f19985d, processDetails.getImportance());
            dVar.a(f19986e, processDetails.getIsDefaultProcess());
        }
    }

    /* JADX INFO: compiled from: AutoSessionEventEncoder.java */
    private static final class e implements com.google.firebase.encoders.c<SessionEvent> {
        static final e a = new e();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19987b = com.google.firebase.encoders.b.d("eventType");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19988c = com.google.firebase.encoders.b.d("sessionData");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19989d = com.google.firebase.encoders.b.d("applicationInfo");

        private e() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(SessionEvent sessionEvent, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19987b, sessionEvent.getEventType());
            dVar.i(f19988c, sessionEvent.getSessionData());
            dVar.i(f19989d, sessionEvent.getApplicationInfo());
        }
    }

    /* JADX INFO: compiled from: AutoSessionEventEncoder.java */
    private static final class f implements com.google.firebase.encoders.c<SessionInfo> {
        static final f a = new f();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19990b = com.google.firebase.encoders.b.d("sessionId");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19991c = com.google.firebase.encoders.b.d("firstSessionId");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19992d = com.google.firebase.encoders.b.d("sessionIndex");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19993e = com.google.firebase.encoders.b.d("eventTimestampUs");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19994f = com.google.firebase.encoders.b.d("dataCollectionStatus");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19995g = com.google.firebase.encoders.b.d("firebaseInstallationId");

        private f() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(SessionInfo sessionInfo, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19990b, sessionInfo.getSessionId());
            dVar.i(f19991c, sessionInfo.getFirstSessionId());
            dVar.c(f19992d, sessionInfo.getSessionIndex());
            dVar.b(f19993e, sessionInfo.getEventTimestampUs());
            dVar.i(f19994f, sessionInfo.getDataCollectionStatus());
            dVar.i(f19995g, sessionInfo.getFirebaseInstallationId());
        }
    }

    private k() {
    }

    @Override // com.google.firebase.encoders.g.a
    public void a(com.google.firebase.encoders.g.b<?> bVar) {
        bVar.a(SessionEvent.class, e.a);
        bVar.a(SessionInfo.class, f.a);
        bVar.a(DataCollectionStatus.class, c.a);
        bVar.a(ApplicationInfo.class, b.a);
        bVar.a(AndroidApplicationInfo.class, a.a);
        bVar.a(ProcessDetails.class, d.a);
    }
}
