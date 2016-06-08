package badassapps.aaron.newshag;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by austin on 6/3/16.
 */


public class MySyncServicesBiz extends Service {

    private static final Object sSyncAdapterLock = new Object();
    private static SyncAdapterBiz sSyncAdapter3 = null;

    @Override
    public void onCreate() {
        synchronized (sSyncAdapterLock) {
            if (sSyncAdapter3 == null)
                sSyncAdapter3 = new SyncAdapterBiz(getApplicationContext(), true);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return sSyncAdapter3.getSyncAdapterBinder();
    }
}
