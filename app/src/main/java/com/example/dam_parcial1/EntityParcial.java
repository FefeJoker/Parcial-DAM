package com.example.dam_parcial1;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.PrimaryKey;

public class EntityParcial implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String texto;
    private Boolean booleano;

    public static final Creator<EntityParcial> CREATOR = new Creator<EntityParcial>() {
        @Override
        public EntityParcial createFromParcel(Parcel in) {
            return new EntityParcial(in);
        }

        @Override
        public EntityParcial[] newArray(int size) {
            return new EntityParcial[size];
        }
    };

    public EntityParcial(String text, Boolean bool){
        texto = text;
        booleano = bool;
    }

    protected EntityParcial(Parcel in) {
        id = in.readInt();
        texto = in.readString();
        booleano = in.readBoolean();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(texto);
        dest.writeBoolean(booleano);
    }
}
