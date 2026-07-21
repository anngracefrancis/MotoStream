package cm.aptoide.pt.database.room;

import h.a.s;

/* JADX INFO: loaded from: classes.dex */
public interface ExperimentDAO {
    s<RoomExperiment> get(String str);

    void save(RoomExperiment roomExperiment);
}
