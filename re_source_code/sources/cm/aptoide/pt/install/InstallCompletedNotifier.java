package cm.aptoide.pt.install;

import cm.aptoide.pt.crashreports.CrashReport;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class InstallCompletedNotifier {
    private final List<App> appToCheck = new ArrayList();
    private final CrashReport crashReport;
    private final InstallManager installManager;
    private final e.g.b.c<Void> watcher;

    /* JADX INFO: Access modifiers changed from: private */
    class App {
        private String md5;
        private String packageName;
        private int versionCode;

        public App(String str, int i2, String str2) {
            this.packageName = str;
            this.versionCode = i2;
            this.md5 = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            App app = (App) obj;
            if (this.versionCode == app.versionCode && this.packageName.equals(app.packageName)) {
                return this.md5.equals(app.md5);
            }
            return false;
        }

        public int hashCode() {
            return (((this.packageName.hashCode() * 31) + this.versionCode) * 31) + this.md5.hashCode();
        }
    }

    public InstallCompletedNotifier(e.g.b.c<Void> cVar, InstallManager installManager, CrashReport crashReport) {
        this.crashReport = crashReport;
        this.watcher = cVar;
        this.installManager = installManager;
    }

    private void installFinished(App app) {
        this.appToCheck.remove(app);
        if (this.appToCheck.isEmpty()) {
            this.watcher.call(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$add$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(App app, Install install) {
        installFinished(app);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$add$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(Throwable th) {
        this.crashReport.log(th);
    }

    public void add(String str, int i2, String str2) {
        final App app = new App(str, i2, str2);
        if (this.appToCheck.contains(app)) {
            return;
        }
        this.appToCheck.add(app);
        this.installManager.getInstall(str2, str, i2).D(new rx.m.e() { // from class: cm.aptoide.pt.install.b0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((Install) obj).getState().equals(Install.InstallationStatus.INSTALLED));
            }
        }).E().H0(new rx.m.b() { // from class: cm.aptoide.pt.install.a0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6396f.a(app, (Install) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.install.z
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6610f.b((Throwable) obj);
            }
        });
    }

    public e.g.b.c<Void> getWatcher() {
        return this.watcher;
    }
}
