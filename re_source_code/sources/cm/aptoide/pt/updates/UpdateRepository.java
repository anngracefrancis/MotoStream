package cm.aptoide.pt.updates;

import android.content.SharedPreferences;
import android.util.Pair;
import cm.aptoide.pt.database.room.RoomInstalled;
import cm.aptoide.pt.database.room.RoomStore;
import cm.aptoide.pt.database.room.RoomUpdate;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.listapp.App;
import cm.aptoide.pt.dataprovider.model.v7.listapp.ListAppsUpdates;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.listapps.ListAppsUpdatesRequest;
import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.networking.IdsRepository;
import cm.aptoide.pt.store.RoomStoreRepository;
import java.util.Collections;
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.Single;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class UpdateRepository {
    private static final long SYNC_MIN_INTERVAL_MS = 82800000;
    private static final String TAG = "cm.aptoide.pt.updates.UpdateRepository";
    private final AptoideInstalledAppsRepository aptoideInstalledAppsRepository;
    private final BodyInterceptor<BaseBody> bodyInterceptor;
    private final Converter.Factory converterFactory;
    private final OkHttpClient httpClient;
    private final IdsRepository idsRepository;
    private long lastSyncTimestamp = 0;
    private final SharedPreferences sharedPreferences;
    private final RoomStoreRepository storeRepository;
    private final TokenInvalidator tokenInvalidator;
    private final UpdateMapper updateMapper;
    private final UpdatePersistence updatePersistence;

    public UpdateRepository(UpdatePersistence updatePersistence, RoomStoreRepository roomStoreRepository, IdsRepository idsRepository, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, UpdateMapper updateMapper, AptoideInstalledAppsRepository aptoideInstalledAppsRepository) {
        this.updatePersistence = updatePersistence;
        this.storeRepository = roomStoreRepository;
        this.idsRepository = idsRepository;
        this.bodyInterceptor = bodyInterceptor;
        this.httpClient = okHttpClient;
        this.converterFactory = factory;
        this.tokenInvalidator = tokenInvalidator;
        this.sharedPreferences = sharedPreferences;
        this.updateMapper = updateMapper;
        this.aptoideInstalledAppsRepository = aptoideInstalledAppsRepository;
    }

    private Single<List<ListAppsUpdatesRequest.ApksData>> getInstalledApks() {
        return this.aptoideInstalledAppsRepository.getAllSyncedInstalled().A().J(new rx.m.e() { // from class: cm.aptoide.pt.updates.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                UpdateRepository.lambda$getInstalledApks$7(list);
                return list;
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.updates.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return UpdateRepository.lambda$getInstalledApks$8((RoomInstalled) obj);
            }
        }).Y0().Z0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getNetworkUpdates, reason: merged with bridge method [inline-methods] */
    public rx.e<List<App>> f(final List<Long> list, final boolean z, final boolean z2) {
        Logger.getInstance().d(TAG, String.format("getNetworkUpdates() -> using %d stores", Integer.valueOf(list.size())));
        return Single.C(getInstalledApks(), this.idsRepository.getUniqueIdentifier(), new rx.m.f() { // from class: cm.aptoide.pt.updates.q
            @Override // rx.m.f
            public final Object a(Object obj, Object obj2) {
                return new Pair((List) obj, (String) obj2);
            }
        }).k(new rx.m.e() { // from class: cm.aptoide.pt.updates.p
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7820f.a(list, z, z2, (Pair) obj);
            }
        }).I0(Schedulers.io()).X(new rx.m.e() { // from class: cm.aptoide.pt.updates.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return UpdateRepository.lambda$getNetworkUpdates$6((ListAppsUpdates) obj);
            }
        });
    }

    static /* synthetic */ Iterable lambda$getInstalledApks$7(List list) {
        return list;
    }

    static /* synthetic */ ListAppsUpdatesRequest.ApksData lambda$getInstalledApks$8(RoomInstalled roomInstalled) {
        return new ListAppsUpdatesRequest.ApksData(roomInstalled.getPackageName(), roomInstalled.getVersionCode(), roomInstalled.getSignature(), roomInstalled.isEnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getNetworkUpdates$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e a(List list, boolean z, boolean z2, Pair pair) {
        return ListAppsUpdatesRequest.of((List) pair.first, list, (String) pair.second, this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(z, z2);
    }

    static /* synthetic */ List lambda$getNetworkUpdates$6(ListAppsUpdates listAppsUpdates) {
        return (listAppsUpdates == null || !listAppsUpdates.isOk()) ? Collections.emptyList() : listAppsUpdates.getList();
    }

    static /* synthetic */ RoomUpdate lambda$saveNonExcludedUpdates$11(RoomUpdate roomUpdate, Boolean bool) {
        return roomUpdate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$saveNonExcludedUpdates$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e c(final RoomUpdate roomUpdate) {
        return this.updatePersistence.isExcluded(roomUpdate.getPackageName()).A().D(new rx.m.e() { // from class: cm.aptoide.pt.updates.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(!((Boolean) obj).booleanValue());
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.updates.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                RoomUpdate roomUpdate2 = roomUpdate;
                UpdateRepository.lambda$saveNonExcludedUpdates$11(roomUpdate2, (Boolean) obj);
                return roomUpdate2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$saveNonExcludedUpdates$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b d(List list) {
        return (list == null || list.isEmpty()) ? rx.b.e() : this.updatePersistence.saveAll(list);
    }

    static /* synthetic */ Single lambda$setExcluded$14(RoomUpdate roomUpdate) {
        roomUpdate.setExcluded(true);
        return Single.m(roomUpdate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setExcluded$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b e(RoomUpdate roomUpdate) {
        return this.updatePersistence.save(roomUpdate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$sync$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b g(List list) {
        return removeAllNonExcluded().a(saveNewUpdates(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$sync$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(long j2) {
        this.lastSyncTimestamp = j2;
    }

    private rx.b saveNewUpdates(List<App> list) {
        return saveNonExcludedUpdates(this.updateMapper.mapAppUpdateList(list));
    }

    private rx.b saveNonExcludedUpdates(List<RoomUpdate> list) {
        return rx.e.N(list).G(new rx.m.e() { // from class: cm.aptoide.pt.updates.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7811f.c((RoomUpdate) obj);
            }
        }).Y0().Z0().j(new rx.m.e() { // from class: cm.aptoide.pt.updates.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7810f.d((List) obj);
            }
        });
    }

    public Single<Boolean> contains(String str, boolean z) {
        return this.updatePersistence.contains(str, z);
    }

    public Single<RoomUpdate> get(String str) {
        return this.updatePersistence.get(str);
    }

    public rx.e<List<RoomUpdate>> getAll(boolean z) {
        return this.updatePersistence.getAllSorted(z);
    }

    public rx.b remove(List<RoomUpdate> list) {
        return this.updatePersistence.removeAll(list);
    }

    /* JADX INFO: renamed from: removeAll, reason: merged with bridge method [inline-methods] */
    public rx.b b(List<RoomUpdate> list) {
        return this.updatePersistence.removeAll(list);
    }

    public rx.b removeAllNonExcluded() {
        return this.updatePersistence.getAll(false).j(new rx.m.e() { // from class: cm.aptoide.pt.updates.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7806f.b((List) obj);
            }
        });
    }

    public rx.b setExcluded(String str) {
        return this.updatePersistence.get(str).i(new rx.m.e() { // from class: cm.aptoide.pt.updates.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                return UpdateRepository.lambda$setExcluded$14((RoomUpdate) obj);
            }
        }).j(new rx.m.e() { // from class: cm.aptoide.pt.updates.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7815f.e((RoomUpdate) obj);
            }
        });
    }

    public rx.b sync(final boolean z, final boolean z2, boolean z3) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        return (z3 || jCurrentTimeMillis - this.lastSyncTimestamp >= SYNC_MIN_INTERVAL_MS) ? this.storeRepository.getAll().E().j0(Schedulers.io()).G(new rx.m.e() { // from class: cm.aptoide.pt.updates.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return rx.e.N((List) obj).X(new rx.m.e() { // from class: cm.aptoide.pt.updates.o
                    @Override // rx.m.e
                    public final Object call(Object obj2) {
                        return Long.valueOf(((RoomStore) obj2).getStoreId());
                    }
                }).Y0();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.updates.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7802f.f(z, z2, (List) obj);
            }
        }).Z0().j(new rx.m.e() { // from class: cm.aptoide.pt.updates.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7818f.g((List) obj);
            }
        }).m(new rx.m.a() { // from class: cm.aptoide.pt.updates.e
            @Override // rx.m.a
            public final void call() {
                this.f7808f.h(jCurrentTimeMillis);
            }
        }) : rx.b.e();
    }

    public rx.b remove(RoomUpdate roomUpdate) {
        return this.updatePersistence.remove(roomUpdate.getPackageName());
    }

    public rx.b remove(String str) {
        return this.updatePersistence.remove(str);
    }
}
