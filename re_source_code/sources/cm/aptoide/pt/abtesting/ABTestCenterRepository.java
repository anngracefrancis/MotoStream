package cm.aptoide.pt.abtesting;

import cm.aptoide.pt.database.RoomExperimentPersistence;
import java.util.HashMap;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class ABTestCenterRepository implements AbTestRepository {
    private AbTestCacheValidator cacheValidator;
    private HashMap<String, ExperimentModel> localCache;
    private RoomExperimentPersistence persistence;
    private ABTestService service;

    public ABTestCenterRepository(ABTestService aBTestService, HashMap<String, ExperimentModel> map, RoomExperimentPersistence roomExperimentPersistence, AbTestCacheValidator abTestCacheValidator) {
        this.service = aBTestService;
        this.localCache = map;
        this.persistence = roomExperimentPersistence;
        this.cacheValidator = abTestCacheValidator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$cacheExperiment$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(String str, ExperimentModel experimentModel) {
        this.localCache.put(str, experimentModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getExperiment$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e b(String str, ExperimentModel experimentModel) {
        return cacheExperiment(experimentModel, str).b(rx.e.S(experimentModel.getExperiment()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getExperiment$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e c(String str, ExperimentModel experimentModel) {
        return cacheExperiment(experimentModel, str).b(rx.e.S(experimentModel.getExperiment()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getExperiment$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d(final String str, BaseExperiment.ExperimentType experimentType, ExperimentModel experimentModel) {
        if (experimentModel.hasError() || experimentModel.getExperiment().isExpired()) {
            return this.service.getExperiment(str, experimentType).G(new rx.m.e() { // from class: cm.aptoide.pt.abtesting.e
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return this.f3750f.c(str, (ExperimentModel) obj);
                }
            });
        }
        if (!this.localCache.containsKey(str)) {
            this.localCache.put(str, experimentModel);
        }
        return rx.e.S(experimentModel.getExperiment());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$recordAction$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e(String str, BaseExperiment.ExperimentType experimentType, Experiment experiment) {
        return this.service.recordAction(str, experiment.getAssignment(), experimentType);
    }

    @Override // cm.aptoide.pt.abtesting.AbTestRepository
    public rx.b cacheExperiment(final ExperimentModel experimentModel, final String str) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.abtesting.c
            @Override // rx.m.a
            public final void call() {
                this.f3745f.a(str, experimentModel);
            }
        }).a(this.persistence.save(str, experimentModel.getExperiment()));
    }

    @Override // cm.aptoide.pt.abtesting.AbTestRepository
    public rx.e<Experiment> getExperiment(final String str, final BaseExperiment.ExperimentType experimentType) {
        if (this.localCache.containsKey(str)) {
            return this.cacheValidator.isExperimentValid(str) ? rx.e.S(this.localCache.get(str).getExperiment()) : this.service.getExperiment(str, experimentType).G(new rx.m.e() { // from class: cm.aptoide.pt.abtesting.d
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return this.f3748f.b(str, (ExperimentModel) obj);
                }
            });
        }
        return this.persistence.get(str).A().j0(Schedulers.io()).G(new rx.m.e() { // from class: cm.aptoide.pt.abtesting.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3742f.d(str, experimentType, (ExperimentModel) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.abtesting.AbTestRepository
    public rx.e<String> getExperimentId(String str) {
        return rx.e.S(str);
    }

    @Override // cm.aptoide.pt.abtesting.AbTestRepository
    public rx.e<Boolean> recordAction(final String str, final BaseExperiment.ExperimentType experimentType) {
        return this.cacheValidator.isCacheValid(str) ? getExperiment(str, null).G(new rx.m.e() { // from class: cm.aptoide.pt.abtesting.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3739f.e(str, experimentType, (Experiment) obj);
            }
        }) : rx.e.S(Boolean.FALSE);
    }

    @Override // cm.aptoide.pt.abtesting.AbTestRepository
    public rx.e<Boolean> recordImpression(String str, BaseExperiment.ExperimentType experimentType) {
        return this.cacheValidator.isCacheValid(str) ? this.service.recordImpression(str, experimentType) : rx.e.S(Boolean.FALSE);
    }

    @Override // cm.aptoide.pt.abtesting.AbTestRepository
    public rx.e<Boolean> recordAction(String str, int i2, BaseExperiment.ExperimentType experimentType) {
        return recordAction(str, experimentType);
    }
}
