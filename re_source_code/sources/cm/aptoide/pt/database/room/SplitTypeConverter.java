package cm.aptoide.pt.database.room;

import com.google.gson.e;
import com.google.gson.u.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SplitTypeConverter {
    public static List<RoomSplit> restoreSplitList(String str) {
        return (List) new e().i(str, new a<List<RoomSplit>>() { // from class: cm.aptoide.pt.database.room.SplitTypeConverter.1
        }.getType());
    }

    public static String saveSplitList(List<RoomSplit> list) {
        return new e().q(list);
    }
}
