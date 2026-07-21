package cm.aptoide.pt.abtesting;

/* JADX INFO: loaded from: classes.dex */
public interface AbTestRepository {
    rx.b cacheExperiment(ExperimentModel experimentModel, String str);

    rx.e<Experiment> getExperiment(String str, BaseExperiment.ExperimentType experimentType);

    rx.e<String> getExperimentId(String str);

    rx.e<Boolean> recordAction(String str, int i2, BaseExperiment.ExperimentType experimentType);

    rx.e<Boolean> recordAction(String str, BaseExperiment.ExperimentType experimentType);

    rx.e<Boolean> recordImpression(String str, BaseExperiment.ExperimentType experimentType);
}
