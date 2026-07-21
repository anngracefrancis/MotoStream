package cm.aptoide.pt.database.room;

import com.google.gson.e;
import com.google.gson.u.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StringTypeConverter {
    public static List<String> restoreList(String str) {
        return (List) new e().i(str, new a<List<String>>() { // from class: cm.aptoide.pt.database.room.StringTypeConverter.1
        }.getType());
    }

    public static String saveList(List<String> list) {
        return new e().q(list);
    }
}
