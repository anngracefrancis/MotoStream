package cm.aptoide.pt.install;

import cm.aptoide.pt.database.room.RoomInstallation;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface InstallationPersistence {
    rx.e<List<RoomInstallation>> getInstallationsHistory();

    rx.b insert(RoomInstallation roomInstallation);

    rx.b insertAll(List<RoomInstallation> list);
}
