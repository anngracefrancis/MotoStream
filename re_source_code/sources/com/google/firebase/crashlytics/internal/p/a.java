package com.google.firebase.crashlytics.internal.p;

import cm.aptoide.pt.database.room.RoomNotification;
import java.io.IOException;

/* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements com.google.firebase.encoders.g.a {
    public static final com.google.firebase.encoders.g.a a = new a();

    /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class C0208a implements com.google.firebase.encoders.c<f0.a.AbstractC0210a> {
        static final C0208a a = new C0208a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19185b = com.google.firebase.encoders.b.d("arch");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19186c = com.google.firebase.encoders.b.d("libraryName");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19187d = com.google.firebase.encoders.b.d("buildId");

        private C0208a() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.a.AbstractC0210a abstractC0210a, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19185b, abstractC0210a.b());
            dVar.i(f19186c, abstractC0210a.d());
            dVar.i(f19187d, abstractC0210a.c());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class b implements com.google.firebase.encoders.c<f0.a> {
        static final b a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19188b = com.google.firebase.encoders.b.d("pid");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19189c = com.google.firebase.encoders.b.d("processName");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19190d = com.google.firebase.encoders.b.d("reasonCode");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19191e = com.google.firebase.encoders.b.d("importance");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19192f = com.google.firebase.encoders.b.d("pss");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19193g = com.google.firebase.encoders.b.d("rss");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19194h = com.google.firebase.encoders.b.d("timestamp");

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19195i = com.google.firebase.encoders.b.d("traceFile");

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19196j = com.google.firebase.encoders.b.d("buildIdMappingForArch");

        private b() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.a aVar, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.c(f19188b, aVar.d());
            dVar.i(f19189c, aVar.e());
            dVar.c(f19190d, aVar.g());
            dVar.c(f19191e, aVar.c());
            dVar.b(f19192f, aVar.f());
            dVar.b(f19193g, aVar.h());
            dVar.b(f19194h, aVar.i());
            dVar.i(f19195i, aVar.j());
            dVar.i(f19196j, aVar.b());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class c implements com.google.firebase.encoders.c<f0.c> {
        static final c a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19197b = com.google.firebase.encoders.b.d(RoomNotification.KEY);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19198c = com.google.firebase.encoders.b.d("value");

        private c() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.c cVar, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19197b, cVar.b());
            dVar.i(f19198c, cVar.c());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class d implements com.google.firebase.encoders.c<f0> {
        static final d a = new d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19199b = com.google.firebase.encoders.b.d("sdkVersion");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19200c = com.google.firebase.encoders.b.d("gmpAppId");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19201d = com.google.firebase.encoders.b.d("platform");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19202e = com.google.firebase.encoders.b.d("installationUuid");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19203f = com.google.firebase.encoders.b.d("firebaseInstallationId");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19204g = com.google.firebase.encoders.b.d("appQualitySessionId");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19205h = com.google.firebase.encoders.b.d("buildVersion");

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19206i = com.google.firebase.encoders.b.d("displayVersion");

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19207j = com.google.firebase.encoders.b.d("session");

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19208k = com.google.firebase.encoders.b.d("ndkPayload");
        private static final com.google.firebase.encoders.b l = com.google.firebase.encoders.b.d("appExitInfo");

        private d() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0 f0Var, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19199b, f0Var.l());
            dVar.i(f19200c, f0Var.h());
            dVar.c(f19201d, f0Var.k());
            dVar.i(f19202e, f0Var.i());
            dVar.i(f19203f, f0Var.g());
            dVar.i(f19204g, f0Var.d());
            dVar.i(f19205h, f0Var.e());
            dVar.i(f19206i, f0Var.f());
            dVar.i(f19207j, f0Var.m());
            dVar.i(f19208k, f0Var.j());
            dVar.i(l, f0Var.c());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class e implements com.google.firebase.encoders.c<f0.d> {
        static final e a = new e();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19209b = com.google.firebase.encoders.b.d("files");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19210c = com.google.firebase.encoders.b.d("orgId");

        private e() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.d dVar, com.google.firebase.encoders.d dVar2) throws IOException {
            dVar2.i(f19209b, dVar.b());
            dVar2.i(f19210c, dVar.c());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class f implements com.google.firebase.encoders.c<f0.d.b> {
        static final f a = new f();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19211b = com.google.firebase.encoders.b.d("filename");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19212c = com.google.firebase.encoders.b.d("contents");

        private f() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.d.b bVar, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19211b, bVar.c());
            dVar.i(f19212c, bVar.b());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class g implements com.google.firebase.encoders.c<f0.e.a> {
        static final g a = new g();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19213b = com.google.firebase.encoders.b.d("identifier");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19214c = com.google.firebase.encoders.b.d("version");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19215d = com.google.firebase.encoders.b.d("displayVersion");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19216e = com.google.firebase.encoders.b.d("organization");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19217f = com.google.firebase.encoders.b.d("installationUuid");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19218g = com.google.firebase.encoders.b.d("developmentPlatform");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19219h = com.google.firebase.encoders.b.d("developmentPlatformVersion");

        private g() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.e.a aVar, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19213b, aVar.e());
            dVar.i(f19214c, aVar.h());
            dVar.i(f19215d, aVar.d());
            dVar.i(f19216e, aVar.g());
            dVar.i(f19217f, aVar.f());
            dVar.i(f19218g, aVar.b());
            dVar.i(f19219h, aVar.c());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class h implements com.google.firebase.encoders.c<f0.e.a.b> {
        static final h a = new h();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19220b = com.google.firebase.encoders.b.d("clsId");

        private h() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.e.a.b bVar, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19220b, bVar.a());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class i implements com.google.firebase.encoders.c<f0.e.c> {
        static final i a = new i();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19221b = com.google.firebase.encoders.b.d("arch");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19222c = com.google.firebase.encoders.b.d("model");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19223d = com.google.firebase.encoders.b.d("cores");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19224e = com.google.firebase.encoders.b.d("ram");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19225f = com.google.firebase.encoders.b.d("diskSpace");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19226g = com.google.firebase.encoders.b.d("simulator");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19227h = com.google.firebase.encoders.b.d("state");

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19228i = com.google.firebase.encoders.b.d("manufacturer");

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19229j = com.google.firebase.encoders.b.d("modelClass");

        private i() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.e.c cVar, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.c(f19221b, cVar.b());
            dVar.i(f19222c, cVar.f());
            dVar.c(f19223d, cVar.c());
            dVar.b(f19224e, cVar.h());
            dVar.b(f19225f, cVar.d());
            dVar.a(f19226g, cVar.j());
            dVar.c(f19227h, cVar.i());
            dVar.i(f19228i, cVar.e());
            dVar.i(f19229j, cVar.g());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class j implements com.google.firebase.encoders.c<f0.e> {
        static final j a = new j();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19230b = com.google.firebase.encoders.b.d("generator");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19231c = com.google.firebase.encoders.b.d("identifier");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19232d = com.google.firebase.encoders.b.d("appQualitySessionId");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19233e = com.google.firebase.encoders.b.d("startedAt");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19234f = com.google.firebase.encoders.b.d("endedAt");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19235g = com.google.firebase.encoders.b.d("crashed");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19236h = com.google.firebase.encoders.b.d("app");

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19237i = com.google.firebase.encoders.b.d("user");

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19238j = com.google.firebase.encoders.b.d("os");

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19239k = com.google.firebase.encoders.b.d("device");
        private static final com.google.firebase.encoders.b l = com.google.firebase.encoders.b.d("events");
        private static final com.google.firebase.encoders.b m = com.google.firebase.encoders.b.d("generatorType");

        private j() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.e eVar, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19230b, eVar.g());
            dVar.i(f19231c, eVar.j());
            dVar.i(f19232d, eVar.c());
            dVar.b(f19233e, eVar.l());
            dVar.i(f19234f, eVar.e());
            dVar.a(f19235g, eVar.n());
            dVar.i(f19236h, eVar.b());
            dVar.i(f19237i, eVar.m());
            dVar.i(f19238j, eVar.k());
            dVar.i(f19239k, eVar.d());
            dVar.i(l, eVar.f());
            dVar.c(m, eVar.h());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class k implements com.google.firebase.encoders.c<f0.e.d.a> {
        static final k a = new k();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19240b = com.google.firebase.encoders.b.d("execution");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19241c = com.google.firebase.encoders.b.d("customAttributes");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19242d = com.google.firebase.encoders.b.d("internalKeys");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19243e = com.google.firebase.encoders.b.d("background");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19244f = com.google.firebase.encoders.b.d("currentProcessDetails");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19245g = com.google.firebase.encoders.b.d("appProcessDetails");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19246h = com.google.firebase.encoders.b.d("uiOrientation");

        private k() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.e.d.a aVar, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19240b, aVar.f());
            dVar.i(f19241c, aVar.e());
            dVar.i(f19242d, aVar.g());
            dVar.i(f19243e, aVar.c());
            dVar.i(f19244f, aVar.d());
            dVar.i(f19245g, aVar.b());
            dVar.c(f19246h, aVar.h());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class l implements com.google.firebase.encoders.c<f0.e.d.a.b.AbstractC0214a> {
        static final l a = new l();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19247b = com.google.firebase.encoders.b.d("baseAddress");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19248c = com.google.firebase.encoders.b.d("size");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19249d = com.google.firebase.encoders.b.d("name");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19250e = com.google.firebase.encoders.b.d("uuid");

        private l() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.e.d.a.b.AbstractC0214a abstractC0214a, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.b(f19247b, abstractC0214a.b());
            dVar.b(f19248c, abstractC0214a.d());
            dVar.i(f19249d, abstractC0214a.c());
            dVar.i(f19250e, abstractC0214a.f());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class m implements com.google.firebase.encoders.c<f0.e.d.a.b> {
        static final m a = new m();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19251b = com.google.firebase.encoders.b.d("threads");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19252c = com.google.firebase.encoders.b.d("exception");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19253d = com.google.firebase.encoders.b.d("appExitInfo");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19254e = com.google.firebase.encoders.b.d("signal");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19255f = com.google.firebase.encoders.b.d("binaries");

        private m() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.e.d.a.b bVar, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19251b, bVar.f());
            dVar.i(f19252c, bVar.d());
            dVar.i(f19253d, bVar.b());
            dVar.i(f19254e, bVar.e());
            dVar.i(f19255f, bVar.c());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class n implements com.google.firebase.encoders.c<f0.e.d.a.b.c> {
        static final n a = new n();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19256b = com.google.firebase.encoders.b.d("type");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19257c = com.google.firebase.encoders.b.d("reason");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19258d = com.google.firebase.encoders.b.d("frames");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19259e = com.google.firebase.encoders.b.d("causedBy");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19260f = com.google.firebase.encoders.b.d("overflowCount");

        private n() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.e.d.a.b.c cVar, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19256b, cVar.f());
            dVar.i(f19257c, cVar.e());
            dVar.i(f19258d, cVar.c());
            dVar.i(f19259e, cVar.b());
            dVar.c(f19260f, cVar.d());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class o implements com.google.firebase.encoders.c<f0.e.d.a.b.AbstractC0218d> {
        static final o a = new o();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19261b = com.google.firebase.encoders.b.d("name");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19262c = com.google.firebase.encoders.b.d("code");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19263d = com.google.firebase.encoders.b.d("address");

        private o() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.e.d.a.b.AbstractC0218d abstractC0218d, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19261b, abstractC0218d.d());
            dVar.i(f19262c, abstractC0218d.c());
            dVar.b(f19263d, abstractC0218d.b());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class p implements com.google.firebase.encoders.c<f0.e.d.a.b.AbstractC0220e> {
        static final p a = new p();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19264b = com.google.firebase.encoders.b.d("name");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19265c = com.google.firebase.encoders.b.d("importance");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19266d = com.google.firebase.encoders.b.d("frames");

        private p() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.e.d.a.b.AbstractC0220e abstractC0220e, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19264b, abstractC0220e.d());
            dVar.c(f19265c, abstractC0220e.c());
            dVar.i(f19266d, abstractC0220e.b());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class q implements com.google.firebase.encoders.c<f0.e.d.a.b.AbstractC0220e.AbstractC0222b> {
        static final q a = new q();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19267b = com.google.firebase.encoders.b.d("pc");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19268c = com.google.firebase.encoders.b.d("symbol");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19269d = com.google.firebase.encoders.b.d("file");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19270e = com.google.firebase.encoders.b.d("offset");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19271f = com.google.firebase.encoders.b.d("importance");

        private q() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.e.d.a.b.AbstractC0220e.AbstractC0222b abstractC0222b, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.b(f19267b, abstractC0222b.e());
            dVar.i(f19268c, abstractC0222b.f());
            dVar.i(f19269d, abstractC0222b.b());
            dVar.b(f19270e, abstractC0222b.d());
            dVar.c(f19271f, abstractC0222b.c());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class r implements com.google.firebase.encoders.c<f0.e.d.a.c> {
        static final r a = new r();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19272b = com.google.firebase.encoders.b.d("processName");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19273c = com.google.firebase.encoders.b.d("pid");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19274d = com.google.firebase.encoders.b.d("importance");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19275e = com.google.firebase.encoders.b.d("defaultProcess");

        private r() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.e.d.a.c cVar, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19272b, cVar.d());
            dVar.c(f19273c, cVar.c());
            dVar.c(f19274d, cVar.b());
            dVar.a(f19275e, cVar.e());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class s implements com.google.firebase.encoders.c<f0.e.d.c> {
        static final s a = new s();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19276b = com.google.firebase.encoders.b.d("batteryLevel");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19277c = com.google.firebase.encoders.b.d("batteryVelocity");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19278d = com.google.firebase.encoders.b.d("proximityOn");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19279e = com.google.firebase.encoders.b.d("orientation");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19280f = com.google.firebase.encoders.b.d("ramUsed");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19281g = com.google.firebase.encoders.b.d("diskUsed");

        private s() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.e.d.c cVar, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19276b, cVar.b());
            dVar.c(f19277c, cVar.c());
            dVar.a(f19278d, cVar.g());
            dVar.c(f19279e, cVar.e());
            dVar.b(f19280f, cVar.f());
            dVar.b(f19281g, cVar.d());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class t implements com.google.firebase.encoders.c<f0.e.d> {
        static final t a = new t();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19282b = com.google.firebase.encoders.b.d("timestamp");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19283c = com.google.firebase.encoders.b.d("type");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19284d = com.google.firebase.encoders.b.d("app");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19285e = com.google.firebase.encoders.b.d("device");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19286f = com.google.firebase.encoders.b.d("log");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19287g = com.google.firebase.encoders.b.d("rollouts");

        private t() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.e.d dVar, com.google.firebase.encoders.d dVar2) throws IOException {
            dVar2.b(f19282b, dVar.f());
            dVar2.i(f19283c, dVar.g());
            dVar2.i(f19284d, dVar.b());
            dVar2.i(f19285e, dVar.c());
            dVar2.i(f19286f, dVar.d());
            dVar2.i(f19287g, dVar.e());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class u implements com.google.firebase.encoders.c<f0.e.d.AbstractC0225d> {
        static final u a = new u();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19288b = com.google.firebase.encoders.b.d("content");

        private u() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.e.d.AbstractC0225d abstractC0225d, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19288b, abstractC0225d.b());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class v implements com.google.firebase.encoders.c<f0.e.d.AbstractC0226e> {
        static final v a = new v();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19289b = com.google.firebase.encoders.b.d("rolloutVariant");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19290c = com.google.firebase.encoders.b.d("parameterKey");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19291d = com.google.firebase.encoders.b.d("parameterValue");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19292e = com.google.firebase.encoders.b.d("templateVersion");

        private v() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.e.d.AbstractC0226e abstractC0226e, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19289b, abstractC0226e.d());
            dVar.i(f19290c, abstractC0226e.b());
            dVar.i(f19291d, abstractC0226e.c());
            dVar.b(f19292e, abstractC0226e.e());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class w implements com.google.firebase.encoders.c<f0.e.d.AbstractC0226e.b> {
        static final w a = new w();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19293b = com.google.firebase.encoders.b.d("rolloutId");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19294c = com.google.firebase.encoders.b.d("variantId");

        private w() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.e.d.AbstractC0226e.b bVar, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19293b, bVar.b());
            dVar.i(f19294c, bVar.c());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class x implements com.google.firebase.encoders.c<f0.e.d.f> {
        static final x a = new x();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19295b = com.google.firebase.encoders.b.d("assignments");

        private x() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.e.d.f fVar, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19295b, fVar.b());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class y implements com.google.firebase.encoders.c<f0.e.AbstractC0227e> {
        static final y a = new y();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19296b = com.google.firebase.encoders.b.d("platform");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19297c = com.google.firebase.encoders.b.d("version");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19298d = com.google.firebase.encoders.b.d("buildVersion");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19299e = com.google.firebase.encoders.b.d("jailbroken");

        private y() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.e.AbstractC0227e abstractC0227e, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.c(f19296b, abstractC0227e.c());
            dVar.i(f19297c, abstractC0227e.d());
            dVar.i(f19298d, abstractC0227e.b());
            dVar.a(f19299e, abstractC0227e.e());
        }
    }

    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    private static final class z implements com.google.firebase.encoders.c<f0.e.f> {
        static final z a = new z();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19300b = com.google.firebase.encoders.b.d("identifier");

        private z() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f0.e.f fVar, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f19300b, fVar.b());
        }
    }

    private a() {
    }

    @Override // com.google.firebase.encoders.g.a
    public void a(com.google.firebase.encoders.g.b<?> bVar) {
        d dVar = d.a;
        bVar.a(f0.class, dVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.b.class, dVar);
        j jVar = j.a;
        bVar.a(f0.e.class, jVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.h.class, jVar);
        g gVar = g.a;
        bVar.a(f0.e.a.class, gVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.i.class, gVar);
        h hVar = h.a;
        bVar.a(f0.e.a.b.class, hVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.j.class, hVar);
        z zVar = z.a;
        bVar.a(f0.e.f.class, zVar);
        bVar.a(a0.class, zVar);
        y yVar = y.a;
        bVar.a(f0.e.AbstractC0227e.class, yVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.z.class, yVar);
        i iVar = i.a;
        bVar.a(f0.e.c.class, iVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.k.class, iVar);
        t tVar = t.a;
        bVar.a(f0.e.d.class, tVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.l.class, tVar);
        k kVar = k.a;
        bVar.a(f0.e.d.a.class, kVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.m.class, kVar);
        m mVar = m.a;
        bVar.a(f0.e.d.a.b.class, mVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.n.class, mVar);
        p pVar = p.a;
        bVar.a(f0.e.d.a.b.AbstractC0220e.class, pVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.r.class, pVar);
        q qVar = q.a;
        bVar.a(f0.e.d.a.b.AbstractC0220e.AbstractC0222b.class, qVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.s.class, qVar);
        n nVar = n.a;
        bVar.a(f0.e.d.a.b.c.class, nVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.p.class, nVar);
        b bVar2 = b.a;
        bVar.a(f0.a.class, bVar2);
        bVar.a(com.google.firebase.crashlytics.internal.p.c.class, bVar2);
        C0208a c0208a = C0208a.a;
        bVar.a(f0.a.AbstractC0210a.class, c0208a);
        bVar.a(com.google.firebase.crashlytics.internal.p.d.class, c0208a);
        o oVar = o.a;
        bVar.a(f0.e.d.a.b.AbstractC0218d.class, oVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.q.class, oVar);
        l lVar = l.a;
        bVar.a(f0.e.d.a.b.AbstractC0214a.class, lVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.o.class, lVar);
        c cVar = c.a;
        bVar.a(f0.c.class, cVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.e.class, cVar);
        r rVar = r.a;
        bVar.a(f0.e.d.a.c.class, rVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.t.class, rVar);
        s sVar = s.a;
        bVar.a(f0.e.d.c.class, sVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.u.class, sVar);
        u uVar = u.a;
        bVar.a(f0.e.d.AbstractC0225d.class, uVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.v.class, uVar);
        x xVar = x.a;
        bVar.a(f0.e.d.f.class, xVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.y.class, xVar);
        v vVar = v.a;
        bVar.a(f0.e.d.AbstractC0226e.class, vVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.w.class, vVar);
        w wVar = w.a;
        bVar.a(f0.e.d.AbstractC0226e.b.class, wVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.x.class, wVar);
        e eVar = e.a;
        bVar.a(f0.d.class, eVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.f.class, eVar);
        f fVar = f.a;
        bVar.a(f0.d.b.class, fVar);
        bVar.a(com.google.firebase.crashlytics.internal.p.g.class, fVar);
    }
}
