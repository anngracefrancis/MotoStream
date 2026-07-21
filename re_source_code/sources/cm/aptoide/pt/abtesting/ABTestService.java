package cm.aptoide.pt.abtesting;

import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.networking.IdsRepository;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/* JADX INFO: loaded from: classes.dex */
public class ABTestService {
    private static final String EXPERIMENT_DRAFT = "EXPERIMENT_IN_DRAFT_STATE";
    private static final String EXPERIMENT_NOT_FOUND = "EXPERIMENT_NOT_FOUND";
    private static final String EXPERIMENT_OVER = "EXPERIMENT_EXPIRED";
    private static final String EXPERIMENT_PAUSED = "EXPERIMENT_PAUSED";
    private static final String IMPRESSION = "IMPRESSION";
    private final ABTestServiceProvider abTestServiceProvider;
    private final IdsRepository idsRepository;
    private final rx.h scheduler;

    public interface ABTestingService {
        @GET("assignments/applications/Vanilla/experiments/{experimentName}/users/{aptoideId}")
        rx.e<ABTestImpressionResponse> getExperiment(@Path("experimentName") String str, @Path("aptoideId") String str2);

        @POST("events/applications/Vanilla/experiments/{experimentName}/users/{aptoideId}")
        rx.e<Response<Void>> recordAction(@Path("experimentName") String str, @Path("aptoideId") String str2, @Body ABTestRequestBody aBTestRequestBody);

        @POST("events/applications/Vanilla/experiments/{experimentName}/users/{aptoideId}")
        rx.e<Response<Void>> recordImpression(@Path("experimentName") String str, @Path("aptoideId") String str2, @Body ABTestRequestBody aBTestRequestBody);
    }

    public ABTestService(ABTestServiceProvider aBTestServiceProvider, IdsRepository idsRepository, rx.h hVar) {
        this.abTestServiceProvider = aBTestServiceProvider;
        this.idsRepository = idsRepository;
        this.scheduler = hVar;
    }

    private rx.e<String> getAptoideId() {
        return this.idsRepository.getUniqueIdentifier().A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getExperiment$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e a(BaseExperiment.ExperimentType experimentType, String str, String str2) {
        return this.abTestServiceProvider.getService(experimentType).getExperiment(str, str2).I0(this.scheduler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getExperiment$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ ExperimentModel b(ABTestImpressionResponse aBTestImpressionResponse) {
        return mapToExperimentModel(aBTestImpressionResponse, false);
    }

    static /* synthetic */ ExperimentModel lambda$getExperiment$2(Throwable th) {
        return new ExperimentModel(new Experiment(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$recordAction$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e c(BaseExperiment.ExperimentType experimentType, String str, String str2, String str3) {
        return this.abTestServiceProvider.getService(experimentType).recordAction(str, str3, new ABTestRequestBody(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$recordAction$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(Response response) {
        Logger.getInstance().d(getClass().getName(), "response : " + response.isSuccessful());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$recordImpression$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e(BaseExperiment.ExperimentType experimentType, String str, String str2) {
        return this.abTestServiceProvider.getService(experimentType).recordImpression(str, str2, new ABTestRequestBody(IMPRESSION));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$recordImpression$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(Response response) {
        Logger.getInstance().d(getClass().getName(), "response : " + response.isSuccessful());
    }

    private boolean mapExperimentStatus(ABTestImpressionResponse aBTestImpressionResponse) {
        return aBTestImpressionResponse.getStatus().equals(EXPERIMENT_OVER) || aBTestImpressionResponse.getStatus().equals(EXPERIMENT_PAUSED) || aBTestImpressionResponse.getStatus().equals(EXPERIMENT_NOT_FOUND) || aBTestImpressionResponse.getStatus().equals(EXPERIMENT_DRAFT);
    }

    private ExperimentModel mapToExperimentModel(ABTestImpressionResponse aBTestImpressionResponse, boolean z) {
        return new ExperimentModel(new Experiment(System.currentTimeMillis(), aBTestImpressionResponse.getPayload(), aBTestImpressionResponse.getAssignment(), mapExperimentStatus(aBTestImpressionResponse)), z);
    }

    public rx.e<ExperimentModel> getExperiment(final String str, final BaseExperiment.ExperimentType experimentType) {
        return getAptoideId().G(new rx.m.e() { // from class: cm.aptoide.pt.abtesting.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3753f.a(experimentType, str, (String) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.abtesting.o
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3768f.b((ABTestImpressionResponse) obj);
            }
        }).p0(new rx.m.e() { // from class: cm.aptoide.pt.abtesting.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ABTestService.lambda$getExperiment$2((Throwable) obj);
            }
        });
    }

    public rx.e<Boolean> recordAction(final String str, final String str2, final BaseExperiment.ExperimentType experimentType) {
        return getAptoideId().G(new rx.m.e() { // from class: cm.aptoide.pt.abtesting.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3762f.c(experimentType, str, str2, (String) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.abtesting.f
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3752f.d((Response) obj);
            }
        }).w(new rx.m.b() { // from class: cm.aptoide.pt.abtesting.j
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.abtesting.p
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.TRUE;
            }
        });
    }

    public rx.e<Boolean> recordImpression(final String str, final BaseExperiment.ExperimentType experimentType) {
        return getAptoideId().G(new rx.m.e() { // from class: cm.aptoide.pt.abtesting.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3757f.e(experimentType, str, (String) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.abtesting.m
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3766f.f((Response) obj);
            }
        }).w(new rx.m.b() { // from class: cm.aptoide.pt.abtesting.n
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.abtesting.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.TRUE;
            }
        });
    }
}
