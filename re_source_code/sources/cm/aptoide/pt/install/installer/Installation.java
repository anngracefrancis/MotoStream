package cm.aptoide.pt.install.installer;

import cm.aptoide.pt.database.room.RoomFileToDownload;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface Installation {
    File getFile();

    List<RoomFileToDownload> getFiles();

    String getId();

    String getPackageName();

    int getStatus();

    int getType();

    int getVersionCode();

    String getVersionName();

    rx.b save();

    rx.b saveFileChanges();

    void setStatus(int i2);

    void setType(int i2);
}
