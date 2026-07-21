package cm.aptoide.pt.install;

import cm.aptoide.pt.database.room.RoomInstalled;
import java.util.List;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public interface InstalledPersistence {
    rx.e<RoomInstalled> get(String str, int i2);

    rx.e<List<RoomInstalled>> getAll();

    rx.e<List<RoomInstalled>> getAllAsList(String str);

    rx.e<List<RoomInstalled>> getAllInstalled();

    rx.e<List<RoomInstalled>> getAllInstalledSorted();

    rx.e<List<RoomInstalled>> getAllInstalling();

    rx.e<List<RoomInstalled>> getAsList(String str, int i2);

    rx.e<RoomInstalled> getInstalled(String str);

    rx.e<List<RoomInstalled>> getInstalledFilteringSystemApps();

    rx.b insert(RoomInstalled roomInstalled);

    Single<Boolean> isInstalled(String str, int i2);

    rx.e<Boolean> isInstalled(String str);

    rx.b remove(String str, int i2);

    rx.b replaceAllBy(List<RoomInstalled> list);
}
