package cm.aptoide.pt.abtesting;

/* JADX INFO: loaded from: classes.dex */
interface BaseExperiment {

    public enum ExperimentType {
        RAKAM,
        WASABI
    }

    ExperimentType getType();
}
