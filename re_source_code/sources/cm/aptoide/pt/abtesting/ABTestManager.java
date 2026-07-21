package cm.aptoide.pt.abtesting;

/* JADX INFO: loaded from: classes.dex */
public class ABTestManager {
    private AbTestRepository abTestRepository;

    public ABTestManager(AbTestRepository abTestRepository) {
        this.abTestRepository = abTestRepository;
    }

    public rx.e<Experiment> getExperiment(String str, BaseExperiment.ExperimentType experimentType) {
        return this.abTestRepository.getExperiment(str, experimentType).E();
    }

    public rx.e<String> getExperimentId(String str) {
        return this.abTestRepository.getExperimentId(str);
    }

    public rx.e<Boolean> recordAction(String str, BaseExperiment.ExperimentType experimentType) {
        return this.abTestRepository.recordAction(str, experimentType);
    }

    public rx.e<Boolean> recordImpression(String str, BaseExperiment.ExperimentType experimentType) {
        return this.abTestRepository.recordImpression(str, experimentType);
    }

    public rx.e<Boolean> recordAction(String str, int i2, BaseExperiment.ExperimentType experimentType) {
        return this.abTestRepository.recordAction(str, i2, experimentType);
    }
}
