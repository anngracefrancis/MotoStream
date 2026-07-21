package cm.aptoide.pt.database;

import cm.aptoide.pt.abtesting.Experiment;
import cm.aptoide.pt.database.room.RoomExperiment;

/* JADX INFO: loaded from: classes.dex */
public class RoomExperimentMapper {
    public RoomExperiment map(String str, Experiment experiment) {
        return new RoomExperiment(str, experiment.getRequestTime(), experiment.getAssignment(), experiment.getPayload(), experiment.isPartOfExperiment(), experiment.isExperimentOver());
    }

    public Experiment map(RoomExperiment roomExperiment) {
        return new Experiment(roomExperiment.getRequestTime(), roomExperiment.getAssignment(), roomExperiment.getPayload(), roomExperiment.isPartOfExperiment(), roomExperiment.isExperimentOver());
    }
}
