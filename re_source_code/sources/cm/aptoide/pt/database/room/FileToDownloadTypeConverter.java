package cm.aptoide.pt.database.room;

import com.google.gson.e;
import com.google.gson.u.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FileToDownloadTypeConverter {
    public static List<RoomFileToDownload> restoreFileToDownloadList(String str) {
        return (List) new e().i(str, new a<List<RoomFileToDownload>>() { // from class: cm.aptoide.pt.database.room.FileToDownloadTypeConverter.1
        }.getType());
    }

    public static String saveFileToDownloadList(List<RoomFileToDownload> list) {
        return new e().q(list);
    }
}
