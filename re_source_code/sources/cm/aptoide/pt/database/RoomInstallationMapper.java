package cm.aptoide.pt.database;

import cm.aptoide.pt.database.room.RoomInstallation;
import cm.aptoide.pt.database.room.RoomInstalled;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: RoomInstallationMapper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0007¨\u0006\t"}, d2 = {"Lcm/aptoide/pt/database/RoomInstallationMapper;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "map", "Lcm/aptoide/pt/database/room/RoomInstallation;", "installed", "Lcm/aptoide/pt/database/room/RoomInstalled;", HttpUrl.FRAGMENT_ENCODE_SET, "installedList", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RoomInstallationMapper {
    public final List<RoomInstallation> map(List<? extends RoomInstalled> installedList) {
        kotlin.jvm.internal.m.f(installedList, "installedList");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends RoomInstalled> it = installedList.iterator();
        while (it.hasNext()) {
            arrayList.add(map(it.next()));
        }
        return arrayList;
    }

    public final RoomInstallation map(RoomInstalled installed) {
        kotlin.jvm.internal.m.f(installed, "installed");
        return new RoomInstallation(installed.getPackageName(), installed.getName(), installed.getIcon(), installed.getVersionCode(), installed.getVersionName());
    }
}
