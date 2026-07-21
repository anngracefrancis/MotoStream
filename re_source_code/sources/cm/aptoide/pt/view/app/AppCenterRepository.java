package cm.aptoide.pt.view.app;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class AppCenterRepository {
    private final AppService appService;
    private final Map<Long, AbstractMap.SimpleEntry<Integer, List<Application>>> cachedStoreApplications;

    public AppCenterRepository(AppService appService, Map<Long, AbstractMap.SimpleEntry<Integer, List<Application>>> map) {
        this.appService = appService;
        this.cachedStoreApplications = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: cloneList, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public AppsList d(AppsList appsList) {
        return (appsList.hasErrors() || appsList.isLoading()) ? appsList : new AppsList(new ArrayList(appsList.getList()), appsList.isLoading(), appsList.getOffset());
    }

    static /* synthetic */ AppsList lambda$getApplications$4(AbstractMap.SimpleEntry simpleEntry, AppsList appsList) {
        return new AppsList(new ArrayList((Collection) simpleEntry.getValue()), false, ((Integer) simpleEntry.getKey()).intValue());
    }

    static /* synthetic */ AppsList lambda$loadAppcRecommendedApps$9(AppsList appsList, List list) {
        return new AppsList(list, appsList.isLoading(), appsList.getOffset());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadFreshApps$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(long j2, AppsList appsList) {
        updateCache(j2, appsList, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadNextApps$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(long j2, AppsList appsList) {
        updateCache(j2, appsList, false);
    }

    static /* synthetic */ AppsList lambda$loadRecommendedApps$6(AppsList appsList, List list) {
        return new AppsList(list, appsList.isLoading(), appsList.getOffset());
    }

    private void updateCache(long j2, AppsList appsList, boolean z) {
        if (appsList.hasErrors() || appsList.isLoading()) {
            return;
        }
        AbstractMap.SimpleEntry<Integer, List<Application>> simpleEntry = this.cachedStoreApplications.get(Long.valueOf(j2));
        if (simpleEntry == null || z) {
            this.cachedStoreApplications.put(Long.valueOf(j2), new AbstractMap.SimpleEntry<>(Integer.valueOf(appsList.getOffset()), appsList.getList()));
            return;
        }
        List<Application> value = simpleEntry.getValue();
        value.addAll(appsList.getList());
        this.cachedStoreApplications.put(Long.valueOf(j2), new AbstractMap.SimpleEntry<>(Integer.valueOf(appsList.getOffset()), value));
    }

    public Single<AppsList> getApplications(long j2, int i2) {
        final AbstractMap.SimpleEntry<Integer, List<Application>> simpleEntry = this.cachedStoreApplications.get(Long.valueOf(j2));
        if (simpleEntry == null || simpleEntry.getValue().isEmpty()) {
            return loadNextApps(j2, i2);
        }
        int size = i2 - (simpleEntry.getValue().size() % i2);
        return size == 0 ? Single.m(new AppsList(new ArrayList(simpleEntry.getValue()), false, simpleEntry.getKey().intValue())) : loadNextApps(j2, size).n(new rx.m.e() { // from class: cm.aptoide.pt.view.app.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppCenterRepository.lambda$getApplications$4(simpleEntry, (AppsList) obj);
            }
        });
    }

    public Single<AppsList> loadAppcRecommendedApps(int i2, final String str) {
        return this.appService.loadAppcRecommendedApps(i2, str).k(new rx.m.e() { // from class: cm.aptoide.pt.view.app.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                AppsList appsList = (AppsList) obj;
                return rx.e.S(appsList).J(f2.f7941f).D(new rx.m.e() { // from class: cm.aptoide.pt.view.app.j
                    @Override // rx.m.e
                    public final Object call(Object obj2) {
                        return Boolean.valueOf(!((Application) obj2).getPackageName().equals(str));
                    }
                }).Y0().X(new rx.m.e() { // from class: cm.aptoide.pt.view.app.h
                    @Override // rx.m.e
                    public final Object call(Object obj2) {
                        return AppCenterRepository.lambda$loadAppcRecommendedApps$9(appsList, (List) obj2);
                    }
                });
            }
        }).Z0();
    }

    public Single<DetailedAppRequestResult> loadDetailedApp(long j2, String str, String str2) {
        return this.appService.loadDetailedApp(j2, str, str2);
    }

    public Single<DetailedAppRequestResult> loadDetailedAppFromMd5(String str) {
        return this.appService.loadDetailedAppFromMd5(str);
    }

    public Single<DetailedAppRequestResult> loadDetailedAppFromUniqueName(String str) {
        return this.appService.loadDetailedAppFromUniqueName(str);
    }

    public Single<AppsList> loadFreshApps(final long j2, int i2) {
        return this.appService.loadFreshApps(j2, i2).g(new rx.m.b() { // from class: cm.aptoide.pt.view.app.d
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7929f.a(j2, (AppsList) obj);
            }
        }).n(new rx.m.e() { // from class: cm.aptoide.pt.view.app.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7918f.b((AppsList) obj);
            }
        });
    }

    public Single<AppsList> loadNextApps(final long j2, int i2) {
        AbstractMap.SimpleEntry<Integer, List<Application>> simpleEntry = this.cachedStoreApplications.get(Long.valueOf(j2));
        return this.appService.loadApps(j2, simpleEntry != null ? simpleEntry.getKey().intValue() : 0, i2).g(new rx.m.b() { // from class: cm.aptoide.pt.view.app.i
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7948f.c(j2, (AppsList) obj);
            }
        }).n(new rx.m.e() { // from class: cm.aptoide.pt.view.app.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7938f.d((AppsList) obj);
            }
        });
    }

    public Single<AppsList> loadRecommendedApps(int i2, final String str) {
        return this.appService.loadRecommendedApps(i2, str).k(new rx.m.e() { // from class: cm.aptoide.pt.view.app.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                AppsList appsList = (AppsList) obj;
                return rx.e.S(appsList).J(f2.f7941f).D(new rx.m.e() { // from class: cm.aptoide.pt.view.app.c
                    @Override // rx.m.e
                    public final Object call(Object obj2) {
                        return Boolean.valueOf(!((Application) obj2).getPackageName().equals(str));
                    }
                }).Y0().X(new rx.m.e() { // from class: cm.aptoide.pt.view.app.g
                    @Override // rx.m.e
                    public final Object call(Object obj2) {
                        return AppCenterRepository.lambda$loadRecommendedApps$6(appsList, (List) obj2);
                    }
                });
            }
        }).Z0();
    }

    public Single<DetailedAppRequestResult> unsafeLoadDetailedApp(long j2, String str, String str2) {
        return this.appService.unsafeLoadDetailedApp(j2, str, str2);
    }

    public Single<DetailedAppRequestResult> loadDetailedApp(String str, String str2) {
        return this.appService.loadDetailedApp(str, str2);
    }
}
