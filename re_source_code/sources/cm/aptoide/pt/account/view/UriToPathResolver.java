package cm.aptoide.pt.account.view;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import cm.aptoide.pt.logger.Logger;

/* JADX INFO: loaded from: classes.dex */
public class UriToPathResolver {
    private static final String TAG = "cm.aptoide.pt.account.view.UriToPathResolver";
    private final ContentResolver contentResolver;

    public UriToPathResolver(ContentResolver contentResolver) {
        this.contentResolver = contentResolver;
    }

    public String getCameraStoragePath(Uri uri) {
        Cursor cursorQuery = this.contentResolver.query(uri, null, null, null, null);
        if (cursorQuery == null) {
            return uri.toString();
        }
        cursorQuery.moveToFirst();
        return cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
    }

    public String getMediaStoragePath(Uri uri) {
        if (uri == null) {
            throw new NullPointerException("content Uri is null");
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.contentResolver.query(uri, new String[]{"_data"}, null, null, null);
                if (cursorQuery == null) {
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    return uri.toString();
                }
                int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data");
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(columnIndexOrThrow);
                if (!cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
                return string;
            } catch (Exception e2) {
                Logger.getInstance().e(TAG, (Throwable) e2);
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                }
            }
        } catch (Throwable th) {
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            throw th;
        }
    }
}
