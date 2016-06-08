package badassapps.aaron.newshag;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by austin on 6/3/16.
 */


public class MySyncServicesTech extends Service {

    private static final Object sSyncAdapterLock = new Object();
    private static SyncAdapterTech sSyncAdapter2 = null;

    @Override
    public void onCreate() {
        synchronized (sSyncAdapterLock) {
            if (sSyncAdapter2 == null)
                sSyncAdapter2 = new SyncAdapterTech(getApplicationContext(), true);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return sSyncAdapter2.getSyncAdapterBinder();
    }
}
