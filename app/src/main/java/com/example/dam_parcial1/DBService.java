package com.example.dam_parcial1;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBService extends IntentService {
    public DBService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        EntityParcial ep = intent.getExtras().getParcelable("entity");
        EntityParcialDatabase db = EntityParcialDatabase.getInstance(this);
        db.entityDao().insertEntityParcial(ep);
    }

    public EntityParcial[] getAllEntities(){
        EntityParcialDatabase db = EntityParcialDatabase.getInstance(this);

        return db.entityDao().getAllEntityParcial();
    }
}
