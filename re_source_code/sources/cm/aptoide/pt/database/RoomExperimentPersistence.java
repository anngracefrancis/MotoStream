package cm.aptoide.pt.database;

import cm.aptoide.pt.abtesting.Experiment;
import cm.aptoide.pt.abtesting.ExperimentModel;
import cm.aptoide.pt.abtesting.ExperimentPersistence;
import cm.aptoide.pt.database.room.ExperimentDAO;
import cm.aptoide.pt.database.room.RoomExperiment;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class RoomExperimentPersistence implements ExperimentPersistence {
    private final ExperimentDAO experimentDAO;
    private final RoomExperimentMapper mapper;

    public RoomExperimentPersistence(ExperimentDAO experimentDAO, RoomExperimentMapper roomExperimentMapper) {
        this.experimentDAO = experimentDAO;
        this.mapper = roomExperimentMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$get$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ h.a.w a(RoomExperiment roomExperiment) throws Exception {
        return h.a.s.f(new ExperimentModel(this.mapper.map(roomExperiment), false));
    }

    static /* synthetic */ ExperimentModel lambda$get$2(Throwable th) {
        return new ExperimentModel(new Experiment(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$save$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(String str, Experiment experiment, h.a.c cVar) throws Exception {
        this.experimentDAO.save(this.mapper.map(str, experiment));
        cVar.a();
    }

    @Override // cm.aptoide.pt.abtesting.ExperimentPersistence
    public Single<ExperimentModel> get(String str) {
        return g.a.a.a.d.d(this.experimentDAO.get(str).i(h.a.b0.a.b()).d(new h.a.y.f() { // from class: cm.aptoide.pt.database.z
            @Override // h.a.y.f
            public final Object a(Object obj) {
                return this.f4967f.a((RoomExperiment) obj);
            }
        })).r(new rx.m.e() { // from class: cm.aptoide.pt.database.x
            @Override // rx.m.e
            public final Object call(Object obj) {
                return RoomExperimentPersistence.lambda$get$2((Throwable) obj);
            }
        }).e(new rx.m.b() { // from class: cm.aptoide.pt.database.o1
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
    }

    @Override // cm.aptoide.pt.abtesting.ExperimentPersistence
    public rx.b save(final String str, final Experiment experiment) {
        return g.a.a.a.d.a(h.a.b.c(new h.a.e() { // from class: cm.aptoide.pt.database.y
            @Override // h.a.e
            public final void a(h.a.c cVar) throws Exception {
                this.a.b(str, experiment, cVar);
            }
        }).f(h.a.b0.a.b()));
    }
}
